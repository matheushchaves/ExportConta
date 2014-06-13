package br.unipe.mlp.exportcontas.dados;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unipe.mlp.exportcontas.modelo.conta.Conta;

public class RepositorioContaMysql extends RepositorioMysql implements
		IRepositorioConta {
	
	@Override
	public boolean incluir(Conta c) {
		String consulta = "insert into contas values (default, ?, ?, ?, ? , ?)";
		int nrolinhas = 0;
		try {
			preparedStatement = connect.prepareStatement(consulta);
			preparedStatement.setInt(1, c.getNumero());
			preparedStatement.setDouble(2, c.getSaldo());
			preparedStatement.setDate(3, (Date) c.getDataAbertura());
			preparedStatement.setString(4, c.getOperacao());
			preparedStatement.setString(5, c.getResponsavel().getCpf());
			nrolinhas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return (nrolinhas > 0);
	}

	@Override
	public boolean remover(int numero) {
		String consulta = "delete from contas where numero = " + numero;
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
	public boolean atualizar(int numero, Conta c) {
		String consulta = "update contas set saldo = ?, operacao = ?, cliente = ? where numero = ?";
		int nrolinhas = 0;
		try {
			preparedStatement = connect.prepareStatement(consulta);
			preparedStatement.setDouble(1, c.getSaldo());
			preparedStatement.setString(2, c.getOperacao());
			preparedStatement.setString(3, c.getResponsavel().getCpf());
			preparedStatement.setInt(4, c.getNumero());
			nrolinhas = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return (nrolinhas > 0);
	}

	@Override
	public Conta pega(int numero) {
		String consulta = "select numero,saldo,dataAbertura,operacao,cliente from contas where numero = "+ numero;
		Conta conta = new Conta();
		try {
			preparedStatement = connect.prepareStatement(consulta);
			resultSet = preparedStatement.executeQuery();
			conta = resultSetToConta(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return (conta);
	}

	@Override
	public Conta pegaporcpf(String cpf) {
		String consulta = "select numero,saldo,dataAbertura,operacao,cliente from contas where cpf = "
				+ cpf;
		Conta conta = new Conta();
		try {
			preparedStatement = connect.prepareStatement(consulta);
			resultSet = preparedStatement.executeQuery();
			conta = resultSetToConta(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return (conta);

	}

	private Conta resultSetToConta(ResultSet resultSet) {
		Conta conta = new Conta();
		IRepositorioCliente tbcliente = new RepositorioClienteMysql();
		try {
			conta.setNumero(resultSet.getInt("numero"));
			conta.setDataAbertura(resultSet.getDate("dataAbertura"));
			conta.setOperacao(resultSet.getString("operacao"));
			conta.setSaldo(resultSet.getDouble("saldo"));
			conta.setResponsavel(tbcliente.pega(resultSet.getString("cpf")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta;
	}
	
	public ResultSet dadosConsulta(String consulta){
		try {
			preparedStatement = connect.prepareStatement(consulta);
			resultSet = preparedStatement.executeQuery();
			resultSet.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	

}
