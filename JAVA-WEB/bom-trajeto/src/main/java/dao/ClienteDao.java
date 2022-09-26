package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Cliente;

public class ClienteDao implements CRUD {

	private static Connection connection = MySqlConnection.createConnection();
	private static String sql;

	public static void create(Cliente cliente) {
		sql = "INSERT INTO clientes VALUES (null, ?, ?, ? , ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getEmail());

			preparedStatement.executeUpdate();

			System.out.println("Inserção executada no Banco de Dados");

		} catch (SQLException e) {
			System.out.println("A inserção não foi executada no Banco de Dados. " + e.getMessage());
		}
	}

	public static void delete(int clienteId_cli) {
		sql = "DELETE FROM clientes WHERE id_cli = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, clienteId_cli);
			preparedStatement.executeUpdate();

			System.out.println("--Cliente deletado com sucesso");

		} catch (SQLException e) {
			System.out.println("--O cliente não foi deletado " + e.getMessage());
		}
	}

	public static List<Cliente> find(String pesquisa) {

		sql = String.format("SELECT * FROM clientes WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Cliente cliente = new Cliente();

				cliente.setId_cli(resultSet.getInt("id_cli"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setEmail(resultSet.getString("email"));

				clientes.add(cliente);

			}

			System.out.println("--Busca de clientes está correta");
			return clientes;

		} catch (SQLException e) {
			System.out.println("--Busca de clientes está incorreta " + e.getMessage());
			return null;
		}

	}

	public static Cliente findByPk(int clienteId_cli) {
		sql = String.format("SELECT * FROM clientes WHERE id_cli = %d ", clienteId_cli);

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			Cliente cliente = new Cliente();

			while (resultSet.next()) {
				cliente.setId_cli(resultSet.getInt("id_cli"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("cpf"));
				cliente.setNascimento(resultSet.getString("nascimento"));
				cliente.setEmail(resultSet.getString("email"));

			}

			System.out.println("--cliente localizado com sucesso");
			return cliente;

		} catch (SQLException e) {

			System.out.println("--O cliente não foi localizado " + e.getMessage());
			return null;
		}
	}

	public static void update(Cliente cliente) {
		sql = "UPDATE clientes SET nome=?, cpf=?, nascimento=?, email=? WHERE id_cli=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getNascimento());
			preparedStatement.setString(4, cliente.getEmail());
			preparedStatement.setInt(5, cliente.getId_cli());

			preparedStatement.executeUpdate();

			System.out.println("--Atualização realizada no banco de dados");

		} catch (SQLException e) {
			System.out.println("--Atualização não foi realizada no banco de dados " + e.getMessage());
		}
	}
}
