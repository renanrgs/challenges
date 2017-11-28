package com.ef.config;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface ConnectionFactory {
	String USER = "root";
	String PASSWORD = "noprincipio";
	Connection getConnection() throws SQLException;
}
