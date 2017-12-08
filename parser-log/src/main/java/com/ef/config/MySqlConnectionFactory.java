package com.ef.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory implements ConnectionFactory {

	private String url;
	private static final String USER = "root";
	private static final String PASSWORD = "noprincipio";

	public MySqlConnectionFactory() {
		super();
		this.url = String.format("jdbc:mysql://localhost/test?useSSL=false&user%s%s%s%s", "=", USER, "&password=",
				PASSWORD);
	}

	/**
	 * Creates a new MySQL connection
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(this.url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getURL() {
		return this.url;
	}
}
