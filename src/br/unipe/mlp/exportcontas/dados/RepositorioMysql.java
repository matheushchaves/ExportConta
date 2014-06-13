package br.unipe.mlp.exportcontas.dados;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioMysql {
	private String conexao ;
	protected java.sql.Connection connect = null;
	protected java.sql.Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;
	DbProperties odb = new DbProperties();
	public RepositorioMysql() {
		this.conexao = "jdbc:mysql://" + odb.getLocalHospedado() + "/"
				+ odb.getBancoDeDados() + "?user=" + odb.getUsuario() + "&password="
				+ odb.getSenha();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(conexao);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			close();
		} finally {

		}
	}

	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
