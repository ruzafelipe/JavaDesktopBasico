package br.senai.modelo;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrdemServico {
	private Date dtAbertura = new Date();
	private Date dtFechamento = null;
	private Cliente cliente;
	private Tecnico tecnico;
	private Equipamento equipamento;
	private ArrayList<Produto> itens = new ArrayList<>();
	private int qtd;

	public OrdemServico() {
		qtd = 0;
	}

	public OrdemServico(Date dtAbertura, Cliente cliente) {
		this();
		this.dtAbertura = dtAbertura;
		this.cliente = cliente;
	}

	public OrdemServico(Date dtAbertura, Cliente cliente, Tecnico vendedor, Equipamento equipamento) {
		this(dtAbertura, cliente);
		this.tecnico = vendedor;
		this.equipamento = equipamento;
	}
	
	
	

	public OrdemServico(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public OrdemServico(Date dtAbertura, Cliente cliente, Tecnico vendedor, Equipamento equipamento,
			ArrayList<Produto> itens) {
		this(dtAbertura, cliente, vendedor, equipamento);
		this.itens = itens;
	}

	public void adicionarProduto(Produto item) {
		itens.add(item);
	}

	public void removerProduto(Produto item) {
		itens.remove(item);
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	@Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		sb.append("-----------------------------------------------------------------\n");

		DateFormat df = DateFormat.getDateTimeInstance();
		//sb.append("Abertura: " + df.format(dtAbertura) + "\n");
		//sb.append("Fechamento: " + df.format(dtFechamento) + "\n");
		sb.append("Cliente: " + cliente.getNome() + "\n");
		sb.append("Técnico: " + tecnico.getNome() + "\n");
		sb.append("-----------------------------------------------------------------\n");
		sb.append("Equipamento: " + equipamento.getDescricao() + "\n");
		sb.append("-----------------------------------------------------------------\n");
		sb.append("Itens da Ordem de Serviço: \n");
		for (Produto item : itens) {
			sb.append(item.getCodigo() + " - " + item.getDescricao() + "\n");
		}
		sb.append("-----------------------------------------------------------------");

		return sb.toString();
	}
	
	
	
	
}
