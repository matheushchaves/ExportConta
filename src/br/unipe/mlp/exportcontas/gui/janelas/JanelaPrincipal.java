package br.unipe.mlp.exportcontas.gui.janelas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import br.unipe.mlp.exportcontas.gui.jtable.ModeloJTableContas;

public class JanelaPrincipal {

	String diretorioApp = System.getProperty("user.dir");
	JFrame janela = new JFrame();

	JPanel painelGeral = new JPanel();
	JPanel painelTitulo = new JPanel();
	JPanel painelConfig = new JPanel();
	JPanel painelOpcoes = new JPanel();
	JPanel painellista = new JPanel();

	/*
	 * este é painel para o titulo
	 */
	JLabel textoNomeSistema = new JLabel();
	JButton botaoConfig = new JButton();

	/*
	 * este é o painel para as opçoes
	 */
	JButton botaoVisualizar = new JButton();
	JButton botaoRelatorio = new JButton();

	/*
	 * este é o painel para a lista de contas
	 */

	JTable listaDeContas = new JTable();

	public JanelaPrincipal() {
		preparaConfig();
		preparaTitulo();
		preparaGeral();
		preparaJanela();
	}

	private void preparaTitulo() {
		textoNomeSistema
				.setText("ExportContas - Extrato de Contas do Banco do Brasil");
		painelTitulo.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelTitulo.add(textoNomeSistema);
	}

	private void preparaConfig() {
		
		Icon iconeBotaoConfig = new ImageIcon(diretorioApp+File.separator+"bmp"+File.separator+"database.bmp");
		botaoConfig.setIcon(iconeBotaoConfig);
		painelConfig.add(botaoConfig);
		painelConfig.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}

	private void preparaGeral() {
		painelGeral.add(painelTitulo);
		painelGeral.add(painelConfig);
		
		painelGeral.setLayout(new GridLayout(2, 2));
	}

	private void preparaJanela() {

		janela.add(painelGeral);
		janela.setSize(600, 600);
		janela.setTitle("ExportContas - Banco do Brasil");
		janela.setBackground(Color.WHITE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	private void preparaJtable() {

		listaDeContas.setModel(new ModeloJTableContas());

	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
