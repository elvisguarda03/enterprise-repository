package br.com.guacom.enterprise.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/enterprise?useSSL=false";
		String user = "root";
		String pass = "eloah1106";
		String error;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
}
