package br.senai.view;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.senai.dao.DataBase;
import br.senai.modelo.Cliente;
import br.senai.modelo.Equipamento;
import br.senai.modelo.OrdemServico;
import br.senai.modelo.Peca;
import br.senai.modelo.Produto;
import br.senai.modelo.Servico;
import br.senai.modelo.Tecnico;
import br.senai.programa.HelpDeskSystem;

public class OrdemDetView extends JFrame {
	// Deve conter layout capaz de receber dados suficientes para carregar um
	// objeto do tipo Ordem de Servico completo e grava-lo em DB.
	// Deve utilizar os arrays de DB para carregar os combos e listas deste
	// formulário.

	private JLabel lbDtAbertura, lbDtFechamento, lbCliente, lbTecnico, lbEquipamento, lbServicosPecas;
	private JTextField tfDtAbertura, tfDtFechamento;
	private JComboBox<String> cbCliente, cbTecnico, cbEquipamentos, cbServicosPecas;
	private JButton btAdicionar, btOk, btCancelar;
	private JList<String> liItens;
	private JScrollPane spLista;
	private DefaultListModel<String> dim;
	

	public OrdemDetView() {
		super("Ordem de Serviço - Detalhes");
		inicializarComponentes();
		definirEventos();

	}

	private void inicializarComponentes() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(650,700);
		getContentPane().setLayout(null);

		lbDtAbertura = new JLabel("Dt. Abertura:");
		lbDtFechamento = new JLabel("Dt. Fechamento:");
		lbCliente = new JLabel("Cliente:");
		lbTecnico = new JLabel("Técnico:");
		lbEquipamento = new JLabel("Equipamento:");
		lbServicosPecas = new JLabel("Serviços/Peças:");

		tfDtAbertura = new JTextField();
		tfDtFechamento = new JTextField();

		cbCliente = new JComboBox<String>();
		cbTecnico = new JComboBox<String>();
		cbEquipamentos = new JComboBox<String>();
		cbServicosPecas = new JComboBox<>();

		btAdicionar = new JButton("Adicionar");
		btOk = new JButton("Ok");
		btCancelar = new JButton("Cancelar");
		
        dim = new DefaultListModel<>();
		liItens = new JList<>(dim);
		spLista = new JScrollPane(liItens);
		
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		
		
         for (Cliente cliente : HelpDeskSystem.db.dbClientes) {
			
			cbCliente.addItem("Nome: " + cliente.getNome() + "  Cpf: " + cliente.getCpf() + " "
					+ " N° Cc: " + cliente.getCartaoCredito() + "  Dt. Nasc: " + dateFormat.format(cliente.getDtNasc()));
			
			
		}
         
         
        for (Tecnico tecnico : HelpDeskSystem.db.dbTecnicos) {
 			
 			cbTecnico.addItem("Nome: " + tecnico.getNome() + "  Cpf: " + tecnico.getCpf() + "  Salário R$:" + tecnico.getSalario() +  "  Dt. Nasc: " + dateFormat.format(tecnico.getDtNasc()));
 			
 			

 		}
        
        for (Equipamento equipamento: HelpDeskSystem.db.dbEquipamentos){
        	cbEquipamentos.addItem("Cod: " + equipamento.getCodigo() + " - Desc: " + equipamento.getDescricao() + " - Marca: " +
        equipamento.getMarca() + " - Tipo: " + equipamento.getTipo());
        	
        
        
        }
         
        
        for(Produto produto : HelpDeskSystem.db.dbProdutos ){
        
        	
        	cbServicosPecas.addItem("Tipo: " + produto.getClasse() + " Desc: " + produto.getDescricao() + " R$" + produto.getPreco());
        	
        
        }
        
        

		lbDtAbertura.setBounds(30, 40, 80, 25);
		tfDtAbertura.setBounds(120, 40, 100, 25);
		lbDtFechamento.setBounds(325, 40, 100, 25);
		tfDtFechamento.setBounds(445, 40, 100, 25);

		lbCliente.setBounds(30, 100, 80, 25);
		cbCliente.setBounds(85, 100,460, 25);

		lbTecnico.setBounds(30, 160, 80, 25);
		cbTecnico.setBounds(85, 160, 460, 25);

		lbEquipamento.setBounds(30, 220, 80, 25);
		cbEquipamentos.setBounds(130, 220, 415, 25);

		lbServicosPecas.setBounds(30, 280, 130, 25);
		cbServicosPecas.setBounds(150, 280, 300, 25);
		btAdicionar.setBounds(470, 280, 100, 25);

		spLista.setBounds(30, 340, 535, 200);
		btOk.setBounds(350, 560, 100, 25);
		btCancelar.setBounds(465, 560, 100, 25);
		
		
		

		add(lbDtAbertura);
		add(tfDtAbertura);
		add(lbDtFechamento);
		add(tfDtFechamento);
		add(lbCliente);
		add(cbCliente);
		add(lbTecnico);
		add(cbTecnico);
		add(lbEquipamento);
		add(cbEquipamentos);
		add(lbServicosPecas);
		add(cbServicosPecas);
		add(btAdicionar);
		add(spLista);
		add(btOk);
		add(btCancelar);

		setVisible(true);
	}

	private void definirEventos() {
		
		
		btAdicionar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				dim.addElement(cbServicosPecas.getSelectedItem().toString());
				
			}
		});
		

		
		 btOk.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				

				
			}
		});

		
		
	}	
	
	
	
}