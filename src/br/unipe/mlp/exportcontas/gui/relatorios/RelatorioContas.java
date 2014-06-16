package br.unipe.mlp.exportcontas.gui.relatorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import br.unipe.mlp.exportcontas.dados.IRepositorioConta;
import br.unipe.mlp.exportcontas.dados.RepositorioContaMysql;
import br.unipe.mlp.exportcontas.gui.funcoes.G;
import br.unipe.mlp.exportcontas.modelo.conta.Conta;

public class RelatorioContas {

	public RelatorioContas(int numeroDaConta) {
		IRepositorioConta contas = new RepositorioContaMysql();
		Conta conta = contas.pega(numeroDaConta);

		String arquivo = G.diretorioApp + File.separator + "REL"
				+ conta.getNumero() + ".txt";
		FileWriter arq;
		File arquivoPgravar = new File(arquivo);
		try {
			arq = new FileWriter(arquivo);
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq
					.printf("+-----------------------------------------------------------------------------------------------+%n");
			gravarArq
					.printf("EXPORT CONTAS - EXTRATO DE CONTA DO BANCO DO BRASIL - %s%n",
							G.dateToString(new Date()));
			gravarArq.printf("CPF:%s NOME: %s",
					conta.getResponsavel().getCpf(), conta.getResponsavel()
							.getNome());
			gravarArq.printf(" DATA NASCIMENTO:%s",
					G.dateToString(conta.getResponsavel().getDataNascimento()));
			String sexo = String.format("%s", conta.getResponsavel().getSexo());
			if (sexo.compareTo("M") == 0)
				sexo = "Masculino";
			else
				sexo = "Feminino";
			gravarArq.printf(" SEXO: %s%n", sexo);
			gravarArq.printf("NUMERO:%d ", conta.getNumero());
			gravarArq.printf("DATA ABERTURA:%s ",
					G.dateToString(conta.getDataAbertura()));
			gravarArq
					.printf("TIPO:%s ",
							conta.getOperacao().compareTo("001") == 0 ? "Conta Corrente"
									: "Conta Poupança");
			gravarArq.printf(" SALDO:%s%n", G.dinheiroToString(conta.getSaldo()));
			gravarArq
					.printf("+-----------------------------------------------------------------------------------------------+%n");

			arq.close();
			if (arquivoPgravar.exists())
			    if (G.msgPergunta("Deseja abrir o arquivo "+arquivo+" ?"))
			    	G.abrirNoNotepad(arquivo);
		} catch (IOException e) {
			G.msgErro("Informe esse erro ao desenvolvedor :" + e.getMessage(),
					"Erro RelatorioContas() - IOException");
		}

	}

}
