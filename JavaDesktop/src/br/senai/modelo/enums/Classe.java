package br.senai.modelo.enums;

public enum Classe {
	PRODUTO("Produto"), SERVICO("Serviço");
	
	
	public String nome;
	Classe(String nome){
		this.nome = nome;
		
	}
}
