package br.unipe.mlp.exportcontas.dados.contas;

import br.unipe.mlp.exportcontas.modelo.cliente.Cliente;

public interface IRepositorioCliente {
	boolean incluir(Cliente c);
	boolean remover(String cpf);
	boolean atualizar(String cpf,Cliente c);
	Cliente pegaPorCpf(String cpf);
	boolean existeCliente(String cpf);
}
