package br.unipe.mlp.exportcontas.dados.test;

import java.util.Date;

import br.unipe.mlp.exportcontas.dados.RepositorioContaMysql;
import br.unipe.mlp.exportcontas.modelo.cliente.Cliente;
import br.unipe.mlp.exportcontas.modelo.conta.Conta;
import junit.framework.TestCase;

public class TestRepositorioContaMysql extends TestCase {

	RepositorioContaMysql contas;

	protected void setUp() throws Exception {
		contas = new RepositorioContaMysql();
	}

	protected void tearDown() throws Exception {
		contas = null;
	}

	public void testAtualizar() {
		assertFalse(contas.atualizar(122100, new Conta(122030, 4.50, new Date(), new Cliente("05182367490", "Matheus", new Date(1994, 12, 01), new String("M").charAt(0)), "002")));
	}

	public void testIncluir() {
		Cliente cli = new Cliente("84212885123", "Matheus", new java.sql.Date(1994, 12, 01), new String("M").charAt(0));
		Conta c = new Conta(122030, 4.50, new java.sql.Date(2014, 06, 16), cli, "002");
		assertTrue(contas.incluir(c));

	}

	public void testPega() {
		assertNotNull( contas.pega(122112));

	}

	public void testPegaporcpf() {
		assertNotNull(contas.pegaporcpf(""));
	}

	public void testremover() {
		assertFalse(contas.remover(122112));

	}

}
