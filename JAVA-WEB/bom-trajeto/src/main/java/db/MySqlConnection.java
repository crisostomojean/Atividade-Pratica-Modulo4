package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	private static final String url = "jdbc:mysql://localhost:3306/bom_trajeto";
	private static final String user = "root";
	private static final String password = "Jcdcdl@160907";

	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver foi encontrado");

		} catch (ClassNotFoundException e) {
			System.out.println("Driver não foi encontrado. " + e.getMessage());
		}

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado a base de dados");
			return connection;

		} catch (SQLException e) {
			System.out.println("Não conectou a base de dados." + e.getMessage());
			return null;
		}
	}
}
