package br.senai.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ExmploTableSimples extends JFrame {
	private JTable tblXaxa;
	JScrollPane scrollXaxa;
	
	public ExmploTableSimples() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes(){
		setTitle("Exemplo de Tabela Simples");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 420);
		
		getContentPane().setLayout(null);
		
		String[] cabecalho = new String[]{"Código", "Nome", "Telefone"};
		String[][] conteudo = 
				new String[][]{{"1", "Eu", "5555-5555"},
									  {"2", "Tu", "5656-5656"},
									  {"3", "Ele", "5757-5757"},
									  {"4", "Nós", "5858-5858"},
									  {"2", "Vós", "5959-5959"},
									  {"3", "Eles", "5050-5050"}};
		
		tblXaxa = new JTable(conteudo, cabecalho);
		scrollXaxa =  new JScrollPane();
		scrollXaxa.setBounds(10, 10, 390, 390);
		scrollXaxa.setViewportView(tblXaxa);
		add(scrollXaxa);


		setVisible(true);
	}
	private void iniciarEventos(){
		
	}
	
	
	public static void main(String[] args) {
		new ExmploTableSimples();

	}

}
