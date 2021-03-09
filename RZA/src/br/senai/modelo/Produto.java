package br.senai.modelo;

import br.senai.modelo.enums.Classe;

public interface Produto {
	
	
	
	Classe getClasse();

	void setClasse(Classe cl);

	int getCodigo();

	void setCodigo(int cd);

	String getDescricao();

	void setDescricao(String ds);

	double getPreco();

	void setPreco(double pr);

}
