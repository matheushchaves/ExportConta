package br.unipe.mlp.exportcontas.dados.contas;


import br.unipe.mlp.exportcontas.modelo.conta.Conta;

public interface IRepositorioConta {
	boolean incluir(Conta c);
	boolean remover(int numero);
	boolean atualizar(int numero,Conta c);
	boolean existeConta(int numero);
	Conta pesquisaPorClienteCpf(String cpf);
}
