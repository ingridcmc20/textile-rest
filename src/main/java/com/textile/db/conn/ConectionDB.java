package com.textile.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://adielh.com:5432/adielh_victorian", "adielh_root",
				"$4dm1nr00t$");
		return connection;
	}
}
