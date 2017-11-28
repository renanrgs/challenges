package com.ef.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory implements ConnectionFactory {

	private String user;
	private String password;
	private String url;

	public MySqlConnectionFactory(String user, String password) {
		super();
		this.user = user;
		this.password = password;
		this.url = String.format("jdbc:mysql://localhost/test?useSSL=false&user",
				new Object[] { "=", user, "&password=", password });
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

	public String getPassword() {
		return this.password;
	}

	public String getUser() {
		return this.user;
	}

	public String getURL() {
		return this.url;
	}
}
