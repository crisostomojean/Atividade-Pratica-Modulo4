package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;

import model.Destino;

public class DestinoDao implements CRUDD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Destino destino) {
		sql = "INSERT INTO destinos VALUES (null,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getDestino());
			preparedStatement.setString(3, destino.getDataentrada());
			preparedStatement.setString(4, destino.getDatasaida());
			;

			preparedStatement.executeUpdate();

			System.out.println("Inserção executada no Banco de Dados");

		} catch (SQLException e) {
			System.out.println("A inserção não foi executada no Banco de Dados. " + e.getMessage());
		}
	}

	public static void delete(int destinoId) {
		sql = "DELETE FROM destinos WHERE id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, destinoId);
			preparedStatement.executeUpdate();

			System.out.println("--Destino deletado com sucesso");

		} catch (SQLException e) {
			System.out.println("--O destino não foi deletado " + e.getMessage());
		}
	}

	public static List<Destino> find(String pesquisa1) {

		sql = String.format("SELECT * FROM destinos WHERE nome like '%s%%' ", pesquisa1);
		List<Destino> destinos = new ArrayList<Destino>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Destino destino = new Destino();

				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setDestino(resultSet.getString("destino"));
				destino.setDataentrada(resultSet.getString("dataentrada"));
				destino.setDatasaida(resultSet.getString("datasaida"));

				destinos.add(destino);

			}

			System.out.println("--Busca de Destinos está correta");
			return destinos;

		} catch (SQLException e) {
			System.out.println("--Busca de Destinos está incorreta " + e.getMessage());
			return null;
		}

	}

	public static Destino findByPk(int destinoId) {
		sql = String.format("SELECT * FROM destinos WHERE id = %d ", destinoId);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Destino destino = new Destino();

			while (resultSet.next()) {
				destino.setId(resultSet.getInt("id"));
				destino.setNome(resultSet.getString("nome"));
				destino.setDestino(resultSet.getString("destino"));
				destino.setDataentrada(resultSet.getString("dataentrada"));
				destino.setDatasaida(resultSet.getString("datasaida"));

			}

			System.out.println("--Destino localizado com sucesso");
			return destino;

		} catch (SQLException e) {

			System.out.println("--O Destino não foi localizado " + e.getMessage());
			return null;
		}
	}

	public static void update(Destino destino) {
		sql = "UPDATE destinos SET nome=?, destino=?, dataentrada=?, datasaida=? WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, destino.getNome());
			preparedStatement.setString(2, destino.getDestino());
			preparedStatement.setString(3, destino.getDataentrada());
			preparedStatement.setString(4, destino.getDatasaida());
			preparedStatement.setInt(5, destino.getId());

			preparedStatement.executeUpdate();

			System.out.println("--Atualização realizada no banco de dados");

		} catch (SQLException e) {
			System.out.println("--Atualização não foi realizada no banco de dados " + e.getMessage());
		}
	}
}
