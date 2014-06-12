package br.unipe.mlp.exportcontas.dados;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioMysql {
	private String localHospedado;
	private String bancoDeDados;
	private String usuario;
	private String senha;
	private String conexao;
	protected java.sql.Connection connect = null;
	protected java.sql.Statement statement = null;
	protected PreparedStatement preparedStatement = null;
	protected ResultSet resultSet = null;

	public RepositorioMysql(String localHospedado, String bancoDeDados,
			String usuario, String senha) {
		super();
		this.localHospedado = localHospedado;
		this.bancoDeDados = bancoDeDados;
		this.usuario = usuario;
		this.senha = senha;
		this.conexao = "jdbc:mysql://" + this.localHospedado + "/"
				+ this.bancoDeDados + "?user=" + this.usuario + "&password="
				+ this.senha;
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

	public String getLocalHospedado() {
		return localHospedado;
	}

	public String getBancoDeDados() {
		return bancoDeDados;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getConexao() {
		return conexao;
	}


}
