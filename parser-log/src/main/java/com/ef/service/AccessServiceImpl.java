package com.ef.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

import com.ef.config.MySqlConnectionFactory;
import com.ef.dao.AccessDAOImpl;
import com.ef.model.AccessDTO;

public class AccessServiceImpl implements AccessService {
	public static ResourceBundle resource;

	/**
	 * Load access data from a file to database
	 */
	public void loadData(String file) {
		AccessDAOImpl accessDAO = new AccessDAOImpl();
		accessDAO.loadData(new MySqlConnectionFactory(), new File(file));
	}

	/**
	 * Find IP's based on filter sent by user
	 */
	public List<AccessDTO> find(LocalDateTime startDate, TypeDuration duration, Integer threshold) {
		return new AccessDAOImpl().find(new MySqlConnectionFactory(), duration, startDate, threshold);
	}

	/**
	 * Block IP based on its access log
	 */
	public void blockIP(List<AccessDTO> accesses, TypeDuration duration) {
		resource = ResourceBundle.getBundle("resources/messages");
		String message = resource.getString(duration.toString().toLowerCase().concat(".block"));
		new AccessDAOImpl().blockIp(new MySqlConnectionFactory(), accesses, message);
	}

}
