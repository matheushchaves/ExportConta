package br.unipe.mlp.exportcontas.dados;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unipe.mlp.exportcontas.modelo.cliente.Cliente;

public class RepositorioClienteMysql extends RepositorioContaMysql implements
		IRepositorioCliente {


	@Override
	public boolean incluir(Cliente cliente) {
		String consulta = "insert into clientes values (?, ?, ?, ?)";
		int nrolinhas = 0;
		try {
			preparedStatement = connect.prepareStatement(consulta);
			preparedStatement.setString(1, cliente.getCpf());
			preparedStatement.setString(2, cliente.getNome());
			preparedStatement.setDate(3, (Date) cliente.getDataNascimento());
			preparedStatement.setString(4,
					String.format("%s", cliente.getSexo()));
			nrolinhas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return (nrolinhas > 0);

	}

	@Override
	public boolean remover(String cpf) {
		String consulta = "delete from clientes where numero = " + cpf;
		int nrolinhas = 0;
		try {
			preparedStatement = connect.prepareStatement(consulta);
			nrolinhas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return (nrolinhas > 0);
	}

	@Override
	public boolean atualizar(String cpf, Cliente c) {
		String consulta = "update clientes set nome=?,dataNascimento=?,sexo=? where cpf=? ";
		int nrolinhas = 0;
		try {
			preparedStatement = connect.prepareStatement(consulta);
			preparedStatement.setString(1, c.getNome());
			preparedStatement.setDate(2, (Date) c.getDataNascimento());
			preparedStatement.setString(3, String.format("%s", c.getSexo()));
			preparedStatement.setString(4, c.getCpf());
			nrolinhas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return (nrolinhas > 0);
	}

	@Override
	public Cliente pega(String cpf) {
		String consulta = "select cpf,nome,dataNascimento,sexo from clientes where cpf = "
				+ cpf;
		Cliente cliente = new Cliente();
		try {
			preparedStatement = connect.prepareStatement(consulta);
			resultSet = preparedStatement.getResultSet();
			cliente = resultSetToCliente(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	private Cliente resultSetToCliente(ResultSet resultSet) {

		Cliente cliente = new Cliente();

		try {
			cliente.setCpf(resultSet.getString("cpf"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setDataNascimento(resultSet.getDate("dataNascimento"));
			cliente.setSexo(resultSet.getString("sexo").charAt(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cliente;

	}
}
