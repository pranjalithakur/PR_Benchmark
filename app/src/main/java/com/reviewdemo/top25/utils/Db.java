package com.reviewdemo.top25.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
	public static Connection open() throws SQLException {
		return DriverManager.getConnection(Constants.JDBC_URL, Constants.DB_USER, Constants.DB_PASSWORD);
	}

	public static String getScalar(String sql) throws SQLException {
		try (Connection conn = open(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getString(1);
			}
			return null;
		}
	}

	public static int execute(String sql) throws SQLException {
		try (Connection conn = open(); Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(sql);
		}
	}
}
