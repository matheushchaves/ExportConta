package br.unipe.mlp.exportcontas.gui.janelas;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import br.unipe.mlp.exportcontas.gui.funcoes.G;
import br.unipe.mlp.exportcontas.gui.jtable.ModeloJTableContas;
import br.unipe.mlp.exportcontas.gui.relatorios.RelatorioContas;

public class JanelaPrincipal implements ActionListener {
	private Timer timer= new Timer();

	private JFrame janela = new JFrame();

	private JLabel textoNomeSistema = new JLabel();
	private JButton botaoConfig = new JButton();

	private JButton botaoVisualizar = new JButton();
	private JButton botaoRelatorio = new JButton();
	private JButton botaoSair = new JButton();
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
		botaoRelatorio.addActionListener(this);
		janela.getContentPane().add(botaoRelatorio);

		botaoVisualizar.setText("Visualizar");
		botaoVisualizar.setBounds(558, 331, 92, 23);
		botaoVisualizar.addActionListener(this);
		janela.getContentPane().add(botaoVisualizar);

		botaoSair.setText("Sair");
		botaoSair.setBounds(558, 356, 92, 23);
		botaoSair.addActionListener(this);
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
		botaoConfig.addActionListener(this);
		janela.getContentPane().add(botaoConfig);

	}

	private void preparaJtable() {
		scrollPane.setBounds(20, 64, 528, 300);
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
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.setVisible(true);
	}

	private TimerTask atualizaJtable() {
		TimerTask tarefa = new TimerTask() {
			@Override
			public void run() {
					preparaJtable();
			}
		};
		return tarefa;

	}

	private void preparaJanela() {
		janela.setTitle("ExportContas - Banco do Brasil");
		janela.setBounds(100, 100, 673, 439);
		janela.getContentPane().setLayout(null);
		janela.setBackground(Color.WHITE);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		timer.schedule(atualizaJtable(),0, 10 * 1000);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(botaoConfig)) {
			new JanelaConfigura();
		}

		if (e.getSource().equals(botaoRelatorio)) {
			if (table.getSelectedRow() > -1)
				new RelatorioContas((int) table.getValueAt(
						table.getSelectedRow(), 0));
			else
				G.msgAlert("Selecione uma conta na lista para Gerar Txt",
						"Alerta");

		}

		if (e.getSource().equals(botaoVisualizar)) {
			if (table.getSelectedRow() > -1)
				new JanelaVisualizar((int) table.getValueAt(
						table.getSelectedRow(), 0));
			else
				G.msgAlert("Selecione uma conta na lista para visualização",
						"Alerta");
		}

		if (e.getSource().equals(botaoSair)) {
			janela.dispose();
			System.exit(0);

		}
	}

}
