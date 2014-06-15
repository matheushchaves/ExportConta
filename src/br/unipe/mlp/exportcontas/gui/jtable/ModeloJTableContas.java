package br.unipe.mlp.exportcontas.gui.jtable;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import br.unipe.mlp.exportcontas.dados.RepositorioContaMysql;
import br.unipe.mlp.exportcontas.gui.funcoes.G;

@SuppressWarnings("serial")
public class ModeloJTableContas extends AbstractTableModel {
	private RepositorioContaMysql contas;
	private ResultSet resultSet;
	String[] nomeColuna = {"Nº da Conta","Cpf","Nome","Saldo"};
	public ModeloJTableContas() {
		contas = new RepositorioContaMysql();
		resultSet = contas.dadosConsulta("Select numero,cpf,nome,saldo from contas,clientes where contas.cliente=clientes.cpf");
	}
	
	@Override
	public int getColumnCount() {
		return nomeColuna.length;
	}

	@Override
	public int getRowCount() {
		int rows = 0;
		try {
			resultSet.last();
			rows = resultSet.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			G.msgErro("Informe esse erro ao desenvolvedor :"+e.getMessage(), "Erro ModeloJTableContas.getRowCount() - SQLException");
		}
		return rows;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Object retorno = null;
		try {
			resultSet.absolute(linha+1);
			
			switch (coluna) {
			case 0:
				retorno = resultSet.getInt(1);	
				break;
			case 1:
				retorno = G.mascaraCpf( resultSet.getString(2));
				break;
			case 2:
				retorno = resultSet.getString(3);
				break;
			case 3:
				retorno = G.dinheiroToString(resultSet.getDouble(4));
				break;
			}
		} catch (SQLException e) {
			G.msgErro("Informe esse erro ao desenvolvedor :"+e.getMessage(), "Erro ModeloJTableContas.getValueAt() - SQLException");
		}
		return retorno;
	}
	@Override
	public String getColumnName(int column) {
		
		return  this.nomeColuna[column];
	}
}
