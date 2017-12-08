package com.ef.dao;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import com.ef.config.ConnectionFactory;
import com.ef.model.AccessDTO;
import com.ef.service.AccessService.TypeDuration;

public interface AccessDAO {
	public void loadData(ConnectionFactory connectionFactory, File file);

	public List<AccessDTO> find(ConnectionFactory connection, TypeDuration duration, LocalDateTime startDate,
			Integer threshold);

	public void blockIp(ConnectionFactory connection, List<AccessDTO> accesses, String message);
}
