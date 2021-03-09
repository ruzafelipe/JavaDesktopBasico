package br.senai.modelo;

import br.senai.modelo.enums.Classe;

public class Peca implements Produto {
	
	private Classe cl;
    private double pr;
    private String ds;
    private int cd;
    
    
    
	

	public Peca(Classe cl, double pr, String ds, int cd) {
		super();
		this.cl = cl;
		this.pr = pr;
		this.ds = ds;
		this.cd = cd;
	}

	@Override
	public Classe getClasse() {
		// TODO Auto-generated method stub
		return cl;
	}

	@Override
	public int getCodigo() {
		// TODO Auto-generated method stub
		return cd;
	}

	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return ds;
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return pr;
	}

	@Override
	public void setCodigo(int cd) {
		this.cd = cd;
		

	}

	@Override
	public void setDescricao(String ds) {

		this.ds = ds;

	}

	@Override
	public void setPreco(double pr) {
		this.pr = pr;

	}

	@Override
	public void setClasse(Classe cl) {
		this.cl = cl;

	}

}
