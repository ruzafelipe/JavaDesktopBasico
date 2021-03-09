package br.senai.modelo.enums;

public enum Tipo {
	TABLET("Tablet"), PC("Pc"), NOTEBOOK("Notebook"), CELULAR("Celular");
	
	public String nome;
	Tipo(String nome){
		this.nome = nome;
		
	}

}
