package br.unipe.mlp.exportcontas.gui.janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.unipe.mlp.exportcontas.dados.IRepositorioConta;
import br.unipe.mlp.exportcontas.dados.RepositorioContaMysql;
import br.unipe.mlp.exportcontas.gui.funcoes.G;
import br.unipe.mlp.exportcontas.modelo.conta.Conta;

public class JanelaVisualizar implements ActionListener {

	JDialog janela = new JDialog();
	JButton btnRetornar = new JButton();
	IRepositorioConta contas = new RepositorioContaMysql();

	public JanelaVisualizar(int numeroDaConta) {

		Conta conta = contas.pega(numeroDaConta);

		/*
		 * Nr Conta
		 */
		JLabel lblConta = new JLabel("Conta");
		lblConta.setHorizontalAlignment(SwingConstants.LEFT);
		lblConta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConta.setBounds(10, 14, 46, 17);
		janela.getContentPane().add(lblConta);

		JLabel lblVlconta = new JLabel(String.format("%d", conta.getNumero()));
		lblVlconta.setForeground(new Color(0, 0, 128));
		lblVlconta.setHorizontalAlignment(SwingConstants.LEFT);
		lblVlconta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVlconta.setBounds(61, 14, 74, 17);
		janela.getContentPane().add(lblVlconta);

		/*
		 * Nome
		 */
		JLabel label = new JLabel("Nome");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 64, 38, 17);
		janela.getContentPane().add(label);

		JLabel lblVlnome = new JLabel(conta.getResponsavel().getNome());
		lblVlnome.setForeground(new Color(0, 0, 128));
		lblVlnome.setHorizontalAlignment(SwingConstants.LEFT);
		lblVlnome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVlnome.setBounds(58, 62, 281, 17);
		janela.getContentPane().add(lblVlnome);

		/*
		 * Data Abertura
		 */
		JLabel lblDataAbertura = new JLabel("Data Abertura");
		lblDataAbertura.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataAbertura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataAbertura.setBounds(142, 14, 99, 17);
		janela.getContentPane().add(lblDataAbertura);

		JLabel lblVldataabertura = new JLabel(G.dateToString(conta
				.getDataAbertura()));
		lblVldataabertura.setForeground(new Color(0, 0, 128));
		lblVldataabertura.setHorizontalAlignment(SwingConstants.LEFT);
		lblVldataabertura.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVldataabertura.setBounds(250, 14, 99, 17);
		janela.getContentPane().add(lblVldataabertura);

		/*
		 * Saldo
		 */
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSaldo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSaldo.setBounds(10, 149, 53, 21);
		janela.getContentPane().add(lblSaldo);

		JLabel label_1 = new JLabel(G.dinheiroToString(conta.getSaldo()));
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_1.setBounds(69, 125, 185, 45);
		janela.getContentPane().add(label_1);
		/*
		 * Cpf
		 */
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(10, 42, 29, 17);
		janela.getContentPane().add(lblCpf);

		JLabel lblVlcpf = new JLabel(G.mascaraCpf(conta.getResponsavel()
				.getCpf()));
		lblVlcpf.setForeground(new Color(0, 0, 128));
		lblVlcpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblVlcpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVlcpf.setBounds(45, 42, 121, 17);
		janela.getContentPane().add(lblVlcpf);

		/*
		 * Data Nascimento
		 */
		JLabel lblNome = new JLabel("Data de Nascimento");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(10, 84, 132, 17);
		janela.getContentPane().add(lblNome);

		JLabel lblVldatanascimento = new JLabel(G.dateToString(conta
				.getResponsavel().getDataNascimento()));
		lblVldatanascimento.setForeground(new Color(0, 0, 128));
		lblVldatanascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblVldatanascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVldatanascimento.setBounds(142, 84, 132, 17);
		janela.getContentPane().add(lblVldatanascimento);

		/*
		 * Sexo
		 */

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSexo.setBounds(10, 104, 46, 17);
		janela.getContentPane().add(lblSexo);

		JLabel lblVlsexo = new JLabel(
				(String.format("%s", conta.getResponsavel().getSexo())
						.compareTo("M") == 0 ? "Masculino" : "Feminino"));
		lblVlsexo.setForeground(new Color(0, 0, 128));
		lblVlsexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblVlsexo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVlsexo.setBounds(61, 104, 142, 17);
		janela.getContentPane().add(lblVlsexo);

		/*
		 * Botao Retornar
		 */

		btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(293, 151, 99, 23);
		btnRetornar.addActionListener(this);
		janela.getContentPane().add(btnRetornar);

		/*
		 * Propriedades da Janela
		 */

		janela.getContentPane().setLayout(null);
		janela.setBounds(100, 100, 450, 220);
		janela.setTitle("ExportContas - Detalhes da Conta");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setModal(true);

		janela.setResizable(false);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnRetornar)) {
			janela.dispose();
		}

	}
}
