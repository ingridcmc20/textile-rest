package com.textile.db.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionDB {
	// static String url = "jdbc:postgresql://adielh.com:5432/adielh_victorian";
	// static String usuario = "adielh_root"; 
	// static String password = "$4dm1nr00t$";
	static String url = "jdbc:postgresql://ec2-54-163-230-178.compute-1.amazonaws.com:5432/d52q7qdi1ne7fp?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
	static String usuario = "whhsgcvcwqgfhe";
	static String password = "d010719d6acd065bc2798bd329c5eaed97b8f83f30ccb1e30f41a9d3d8804098";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, usuario, password);
		return connection;
	}
}