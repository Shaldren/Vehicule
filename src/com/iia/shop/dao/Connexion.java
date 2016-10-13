package com.iia.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static final String URL = "jdbc:sqlserver://Dorian;databaseName=ManageVehicule;";
	private static final String PASSWORD = "sql2014";
	private static final String LOGIN = "sa";
	private static Connection connection;
	

	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connexion.connection = DriverManager.getConnection(Connexion.URL, Connexion.LOGIN, Connexion.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de charger le driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de lors de la connexion");
		}
		return Connexion.connection;
	}
	
	public static void close(){
		try {
			Connexion.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
