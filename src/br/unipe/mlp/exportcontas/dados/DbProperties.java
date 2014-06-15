package br.unipe.mlp.exportcontas.dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import br.unipe.mlp.exportcontas.gui.funcoes.G;

public class DbProperties {
	private String localHospedado;
	private String bancoDeDados;
	private String usuario;
	private String senha;

	public DbProperties() {
		this.localHospedado = G.getdbProp().getProperty("localHospedado");
		this.bancoDeDados = G.getdbProp().getProperty("bancoDeDados");
		this.usuario = G.getdbProp().getProperty("usuario");
		this.senha = G.getdbProp().getProperty("senha");

	}

	public String getLocalHospedado() {
		return localHospedado;
	}

	public void setLocalHospedado(String localHospedado) {
		this.localHospedado = localHospedado;
	}

	public String getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(String bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean grava(){
		Properties p = G.getdbProp();
		p.setProperty("localHospedado", this.localHospedado);
		p.setProperty("bancoDeDados", this.bancoDeDados);
		p.setProperty("usuario", this.usuario);
		p.setProperty("senha", this.senha);
		try {
			p.store(new FileOutputStream(G.diretorioApp+File.separator+"db.properties"), "");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.localHospedado+","+this.bancoDeDados+","+this.usuario+","+this.senha;
	}

}
