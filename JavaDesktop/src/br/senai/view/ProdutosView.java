package br.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.senai.modelo.Peca;
import br.senai.modelo.Servico;
import br.senai.modelo.enums.Classe;
import br.senai.modelo.enums.Tipo;
import br.senai.programa.HelpDeskSystem;

public class ProdutosView extends JFrame{
	
	private JLabel lbCodigo, lbTipo, lblServProd, lbDesc, lbPreco;
	private JTextField tfCodigo, tfTipo, tfDesc, tfPreco;
	private JButton btOk,btCancelar;
	private JComboBox cbTipo = new JComboBox<Classe>();
	
	
	public ProdutosView(){

		
		super("Produtos");
		iniciarComponentes();
		definirEventos();
		
	}

	

	private void iniciarComponentes() {
		
		setSize(400,450);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lbCodigo = new JLabel("Código:");
		lbTipo = new JLabel("Tipo:");
		lbDesc = new JLabel("Descrição:");
		lbPreco = new JLabel("Preço:");
		
		
		tfCodigo = new JTextField();
		tfTipo = new JTextField();
		tfDesc = new JTextField();
		tfPreco = new JTextField();
		
		btOk = new JButton("Ok");
		btCancelar = new JButton("Cancelar");
		
		
		lbCodigo.setBounds(30,45,80,25);
		tfCodigo.setBounds(90,45,80,25);
		lbTipo.setBounds(30,100,100,25);
		cbTipo.setBounds(90,100,100,25);
		lbDesc.setBounds(30,150,100,25);
		tfDesc.setBounds(100,150,160,25);
		lbPreco.setBounds(30,210,80,25);
		tfPreco.setBounds(80,210,80,25);
		btOk.setBounds(73,260,100,25);
		btCancelar.setBounds(195,260,100,25);
		
		cbTipo.addItem("");
		cbTipo.addItem(Classe.PRODUTO);
		cbTipo.addItem(Classe.SERVICO);
	
		add(lbCodigo);
		add(tfCodigo);
		add(lbTipo);
		add(cbTipo);
        add(lbDesc);
        add(tfDesc);
        add(lbPreco);
        add(tfPreco);
        add(btOk);
        add(btCancelar);
		
		
		
		setVisible(true);
		
		
	}
	
	
	private void definirEventos() {
		
		btOk.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					if (tfCodigo.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite o código.");
					} else if (tfDesc.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite a descrição.");
					} else if(tfPreco.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite o preço.");
					} else if (cbTipo.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null,"Selecione o tipo.");
					} else{
						
						if (cbTipo.getSelectedItem().equals(Classe.PRODUTO)){
							
							Peca peca = new Peca(Classe.valueOf(cbTipo.getSelectedItem().toString()),Double.parseDouble(tfPreco.getText()),tfDesc.getText(), Integer.parseInt(tfCodigo.getText()));
							HelpDeskSystem.db.dbProdutos.add(peca);
							tfDesc.setText("");
							tfCodigo.setText("");
							tfPreco.setText("");
							cbTipo.setSelectedIndex(0);
							JOptionPane.showMessageDialog(null,"Produto cadastrado");
							
						} else {
								Servico servico = new Servico(Classe.valueOf(cbTipo.getSelectedItem().toString()),Double.parseDouble(tfPreco.getText()),tfDesc.getText(), Integer.parseInt(tfCodigo.getText()));
						HelpDeskSystem.db.dbProdutos.add(servico);
						tfDesc.setText("");
						tfCodigo.setText("");
						tfPreco.setText("");
						cbTipo.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null,"Serviço cadastrado");
						}
						
					
					}
					
				} catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Digite apenas numeros no código e nome preço");
					tfCodigo.setText("");
					tfPreco.setText("");
				}
				
				
				
				
			}
		});
		
		
	}
	


}
