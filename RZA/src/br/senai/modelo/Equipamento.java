package br.senai.modelo;

import br.senai.modelo.enums.Tipo;

public class Equipamento {
	private int codigo;
	private String descricao;
	private String marca;
	private Tipo tipo;

	public Equipamento(int codigo, String descricao, String marca, Tipo tipo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.marca = marca;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
