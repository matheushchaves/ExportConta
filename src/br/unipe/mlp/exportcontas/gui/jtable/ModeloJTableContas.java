package br.unipe.mlp.exportcontas.gui.jtable;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import br.unipe.mlp.exportcontas.dados.RepositorioContaMysql;

@SuppressWarnings("serial")
public class ModeloJTableContas extends AbstractTableModel {
	private RepositorioContaMysql contas;
	private ResultSet resultSet;
	public ModeloJTableContas() {
		contas = new RepositorioContaMysql();
		resultSet = contas.dadosConsulta("Select numero,cpf,nome,saldo from contas,clientes where contas.cliente=clientes.cpf");
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		int rows = 0;
		try {
			resultSet.last();
			rows = resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Object retorno = null;
		try {
			resultSet.absolute(linha+1);
			retorno = resultSet.getObject(coluna+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	@Override
	public String getColumnName(int column) {
		String[] nomeColuna = {"Nº da Conta","Cpf","Nome","Saldo"};
		return  nomeColuna[column];
	}
}
