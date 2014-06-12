package br.unipe.mlp.exportcontas.dados
;


import br.unipe.mlp.exportcontas.modelo.conta.Conta;

public interface IRepositorioConta {
	boolean incluir(Conta c);
	boolean remover(int numero);
	boolean atualizar(int numero,Conta c);
	Conta pega(int numero);
	Conta pegaporcpf(String cpf);
}
