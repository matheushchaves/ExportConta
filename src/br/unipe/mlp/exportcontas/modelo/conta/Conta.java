package br.unipe.mlp.exportcontas.modelo.conta;

import java.util.Date;

import br.unipe.mlp.exportcontas.modelo.cliente.Cliente;

public class Conta {
       private int numero;
       private double saldo;
       private Date dataAbertura;
       private Cliente responsavel;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Cliente getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Cliente responsavel) {
		this.responsavel = responsavel;
	}
       
}
