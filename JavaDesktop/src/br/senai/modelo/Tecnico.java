package br.senai.modelo;

import java.util.Date;

public class Tecnico extends Pessoa {
	private double salario;

	public Tecnico(String nome, String cpf, char sexo, Date dtNasc, double salario) {
		super(nome, cpf, sexo, dtNasc);
		setSalario(salario);
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		if (salario > 0) {
			this.salario = salario;
		}
	}

}
