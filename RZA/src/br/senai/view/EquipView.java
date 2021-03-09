package br.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.senai.modelo.Equipamento;
import br.senai.modelo.Peca;
import br.senai.modelo.enums.Classe;
import br.senai.modelo.enums.Tipo;
import br.senai.programa.HelpDeskSystem;

public class EquipView extends JFrame{
	
	
	
	private JLabel lbCodigo, lbTipo, lbDesc, lbMarca;
	private JTextField tfCodigo, tfTipo, tfDesc, tfMarca;
	private JButton btOk,btCancelar;
	private JComboBox cbTipo = new JComboBox<Tipo>();
	
	
	public EquipView(){

		
		super("Produtos");
		iniciarComponentes();
		definirEventos();
		
	}

	

	private void iniciarComponentes() {
		
		setSize(400,350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lbCodigo = new JLabel("Código:");
		lbTipo = new JLabel("Tipo:");
		lbDesc = new JLabel("Descrição:");
		lbMarca = new JLabel("Marca:");
		
		
		tfCodigo = new JTextField();
		tfTipo = new JTextField();
		tfDesc = new JTextField();
		tfMarca = new JTextField();
		
		
		btOk = new JButton("Ok");
		btCancelar = new JButton("Cancelar");
		
		
		lbCodigo.setBounds(30,45,80,25);
		tfCodigo.setBounds(90,45,80,25);
		lbTipo.setBounds(30,100,100,25);
		cbTipo.setBounds(90,100,100,25);
		lbDesc.setBounds(30,150,100,25);
		tfDesc.setBounds(100,150,160,25);
		lbMarca.setBounds(30,210,100,25);
		tfMarca.setBounds(90,210,120,25);
		btOk.setBounds(73,260,100,25);
		btCancelar.setBounds(195,260,100,25);
		
		
	    cbTipo.addItem("");		
		cbTipo.addItem(Tipo.CELULAR);
		cbTipo.addItem(Tipo.NOTEBOOK);
		cbTipo.addItem(Tipo.PC);
		cbTipo.addItem(Tipo.TABLET);
			
		
	
		add(lbCodigo);
		add(tfCodigo);
		add(lbTipo);
		add(cbTipo);
        add(lbDesc);
        add(tfDesc);
        add(lbMarca);
        add(tfMarca);
        add(btOk);
        add(btCancelar);
		
		
		
		setVisible(true);
		
		
	}
	
	
	private void definirEventos() {
		
		btOk.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
			
				try{
					
					if (tfCodigo.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite o código.");
					} else if (tfDesc.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite a descrição.");
					} else if(tfMarca.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Digite a marca.");
					} else if (cbTipo.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null,"Selecione o tipo.");
					} else{
					
					Equipamento equipamento = new Equipamento(Integer.parseInt(tfCodigo.getText()), tfDesc.getText(), tfMarca.getText(),Tipo.valueOf(cbTipo.getSelectedItem().toString()));
					HelpDeskSystem.db.dbEquipamentos.add(equipamento);
					tfDesc.setText("");
					tfCodigo.setText("");
					tfMarca.setText("");
					cbTipo.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null,"Produto cadastrado");
					
					}
				
			} catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null,"Digite apenas numeros no código.");
				tfCodigo.setText("");
			}
				
				
				
			}	
		});
		
		
	}

}
