package br.senai.modelo;

import java.util.Date;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	private char sexo;
	private Date dtNasc = new Date();

	public Pessoa(String nome, String cpf, char sexo, Date dtNasc) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dtNasc = dtNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

}
