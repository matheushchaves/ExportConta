package br.unipe.mlp.exportcontas.modelo.cliente;

import java.util.Date;

public class Cliente {
    private String cpf;   
	private String nome;
	private Date dataNascimento;
	private char sexo;
	public Cliente() {

	}
	public Cliente(String cpf, String nome, Date dataNascimento, char sexo) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
}
