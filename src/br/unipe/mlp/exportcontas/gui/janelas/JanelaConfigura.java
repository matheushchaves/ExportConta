package br.unipe.mlp.exportcontas.gui.janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.unipe.mlp.exportcontas.dados.DbProperties;

public class JanelaConfigura implements ActionListener {

	private JFrame janela = new JFrame();
	private JTextField textFieldhost;
	private JTextField textFielddatabase;
	private JTextField textFieldlogin;
	private JTextField textFieldsenha;
	JButton btnConfirmar;
	JButton btnRetornar;

	private DbProperties odb = new DbProperties();

	public JanelaConfigura() {
		preparaTitulo();
		preparaHost();
		preparadatabase();
		preparalogin();
		preparasenha();
		preparaBotoes();
		preparaJanela();
	}

	private void preparaJanela() {
		janela.getContentPane().setLayout(null);
		janela.setTitle("ExportContas - Configurações");
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	private void preparaTitulo() {
		JLabel labelTitulo = new JLabel("Configurações do Banco");
		labelTitulo.setBounds(10, 11, 211, 20);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		janela.getContentPane().add(labelTitulo);

	}

	private void preparaHost() {
		JLabel labelhost = new JLabel("Host");
		labelhost.setBounds(10, 56, 46, 14);
		janela.getContentPane().add(labelhost);

		textFieldhost = new JTextField();
		textFieldhost.setBounds(88, 53, 211, 20);
		janela.getContentPane().add(textFieldhost);
		textFieldhost.setColumns(10);
		textFieldhost.setText(odb.getLocalHospedado());

	}

	private void preparadatabase() {
		JLabel lblBancoDeDados = new JLabel("Database");
		lblBancoDeDados.setBounds(10, 86, 68, 14);
		janela.getContentPane().add(lblBancoDeDados);

		textFielddatabase = new JTextField();
		textFielddatabase.setBounds(88, 84, 211, 20);
		textFielddatabase.setColumns(10);
		janela.getContentPane().add(textFielddatabase);
		textFielddatabase.setText(odb.getBancoDeDados());

	}

	private void preparalogin() {
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 118, 68, 14);
		janela.getContentPane().add(lblLogin);

		textFieldlogin = new JTextField();
		textFieldlogin.setBounds(88, 115, 211, 20);
		textFieldlogin.setColumns(10);
		janela.getContentPane().add(textFieldlogin);
		textFieldlogin.setText(odb.getUsuario());

	}

	private void preparasenha() {
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 149, 68, 14);
		janela.getContentPane().add(lblSenha);

		textFieldsenha = new JTextField();
		textFieldsenha.setBounds(88, 146, 211, 20);
		textFieldsenha.setColumns(10);
		janela.getContentPane().add(textFieldsenha);
		textFieldsenha.setText(odb.getSenha());

	}

	private void preparaBotoes() {
		btnConfirmar= new JButton("Confirmar");
		btnConfirmar.setBounds(99, 201, 93, 23);
		btnConfirmar.addActionListener(this);
		janela.getContentPane().add(btnConfirmar);
		btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(200, 201, 99, 23);
		btnRetornar.addActionListener(this);
		janela.getContentPane().add(btnRetornar);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnConfirmar)){
			odb.setLocalHospedado(textFieldhost.getText());
			odb.setBancoDeDados(textFielddatabase.getText());
			odb.setUsuario(textFieldlogin.getText());
			odb.setSenha(textFieldsenha.getText());
			if (odb.grava())
				
			janela.dispose();
		}
		if (e.getSource().equals(btnRetornar)){
			janela.dispose();
		}
			

	}
}
