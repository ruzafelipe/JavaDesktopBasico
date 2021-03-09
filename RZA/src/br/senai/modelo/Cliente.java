package br.senai.modelo;

import java.util.Date;

public class Cliente extends Pessoa {
	private String cartaoCredito;

	public Cliente(String nome, String cpf, char sexo, Date dtNasc, String cartaoCredito) {
		super(nome, cpf, sexo, dtNasc);

		setCartaoCredito(cartaoCredito);
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
