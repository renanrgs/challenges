package com.ef.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ef.config.ConnectionFactory;
import com.ef.model.AccessDTO;
import com.ef.service.AccessService.TypeDuration;

public class AccessDAOImpl implements AccessDAO {

	private static final String SQL_LOAD_DATA = "LOAD DATA LOCAL INFILE ? INTO TABLE accesses FIELDS TERMINATED BY '|' ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n' (access_date, ip,  request, cod_status, user_agent )";

	private static final String SQL_SEARCH = "SELECT ip, COUNT(ip) AS quant FROM accesses WHERE access_date BETWEEN ? AND TIMESTAMP(TIMESTAMPADD(HOUR, ?, ?)) GROUP BY ip HAVING quant > ?";

	private static final String SQL_INSERT = "INSERT INTO blocked_ip (ip, message) VALUES(?, ?)";

	public void loadData(ConnectionFactory connectionFactory, File file) {
		try (Connection conn = connectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_LOAD_DATA)) {
			stmt.setString(1, file.getAbsolutePath());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<AccessDTO> find(ConnectionFactory connection, TypeDuration duration, LocalDateTime startDate,
			Integer threshold) {
		try (Connection conn = connection.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SEARCH)) {
			stmt.setTimestamp(1, Timestamp.valueOf(startDate));
			stmt.setInt(2, duration.getDuration());
			stmt.setTimestamp(3, Timestamp.valueOf(startDate));
			stmt.setInt(4, threshold);
			return buildAccessDTO(stmt.executeQuery());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void blockIp(ConnectionFactory connection, List<AccessDTO> accesses, String message) {
		try (Connection conn = connection.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
			buildBatch(accesses, message, stmt);
			stmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void buildBatch(List<AccessDTO> accesses, String message, PreparedStatement stmt) throws SQLException {
		for (AccessDTO accessDTO : accesses) {
			stmt.setString(1, accessDTO.getIp());
			stmt.setString(2, message);
			stmt.addBatch();
		}
	}

	private List<AccessDTO> buildAccessDTO(ResultSet rs) throws SQLException {
		List<AccessDTO> accesses = new ArrayList<>();
		while (rs.next()) {
			AccessDTO accessDTO = new AccessDTO();
			accessDTO.setIp(rs.getString("ip"));
			accesses.add(accessDTO);
		}
		rs.close();
		return accesses;
	}
}
