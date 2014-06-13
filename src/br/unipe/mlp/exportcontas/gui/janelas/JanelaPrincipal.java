package br.unipe.mlp.exportcontas.gui.janelas;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import br.unipe.mlp.exportcontas.gui.funcoes.G;
import br.unipe.mlp.exportcontas.gui.jtable.ModeloJTableContas;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;

public class JanelaPrincipal {

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
	JButton botaoSair = new JButton();
	private JTable table = new JTable();
	private JScrollPane scrollPane = new JScrollPane();

	public JanelaPrincipal() {
		preparaTitulo();
		preparaJtable();
		preparaBotoes();
		preparaJanela();
	}

	private void preparaBotoes() {

		botaoRelatorio.setText("Relatório");
		botaoRelatorio.setBounds(558, 305, 92, 23);
		botaoVisualizar.setText("Visualizar");
		botaoVisualizar.setBounds(558, 331, 92, 23);
		botaoSair.setText("Sair");
		botaoSair.setBounds(558, 356, 92, 23);

		janela.getContentPane().add(botaoRelatorio);
		janela.getContentPane().add(botaoVisualizar);
		janela.getContentPane().add(botaoSair);

	}

	private void preparaTitulo() {
		textoNomeSistema
				.setText("ExportContas - Extrato de Contas do Banco do Brasil");
		textoNomeSistema.setFont(new Font("Tahoma", Font.BOLD, 16));
		textoNomeSistema.setBounds(10, 11, 450, 42);
		janela.getContentPane().add(textoNomeSistema);

		Icon iconeBotaoConfig = new ImageIcon(G.diretorioApp + File.separator
				+ "bmp" + File.separator + "tools.png");

		botaoConfig.setIcon(iconeBotaoConfig);
		botaoConfig.setBounds(597, 11, 48, 48);
		janela.getContentPane().add(botaoConfig);

	}

	private void preparaJanela() {

		janela.setTitle("ExportContas - Banco do Brasil");

		janela.setBounds(100, 100, 673, 439);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);

		janela.setBackground(Color.WHITE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	private void preparaJtable() {
		scrollPane.setBounds(20, 64, 528, 315);
		janela.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new ModeloJTableContas());

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();

        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);
        esquerda.setHorizontalAlignment(SwingConstants.LEFT);

        table.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        table.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        table.getColumnModel().getColumn(2).setCellRenderer(esquerda);
        table.getColumnModel().getColumn(3).setCellRenderer(direita);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(15);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
		
		
		table.setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}
}
