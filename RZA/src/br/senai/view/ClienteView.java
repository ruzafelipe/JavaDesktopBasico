package br.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.senai.modelo.Cliente;
import br.senai.programa.HelpDeskSystem;

public class ClienteView extends JFrame {

	private JLabel lbNome, lbCpf, lbSexo, lbDtNasc, lbCc;
	private JTextField tfNome, tfCpf, tfDtNasc;
	private ButtonGroup buttonGroup;
	private JRadioButton radioMasc, radioFem;

	private MaskFormatter msData;

	private JButton btOk, btCancelar;

	private JTextField tfCc;

	private JComboBox cbBandeira;

	private Date data;

	public ClienteView() {

		super("Cliente");
		iniciarComponentes();
		definirEventos();

	}

	private void iniciarComponentes() {

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		lbNome = new JLabel("Nome:");
		lbCpf = new JLabel("Cpf:");
		lbSexo = new JLabel("Sexo:");
		lbDtNasc = new JLabel("Dt Nasc:");
		lbCc = new JLabel("C.C. :");
		tfNome = new JTextField();
		tfCpf = new JTextField();
		tfDtNasc = new JTextField();
		tfCc = new JTextField();
		String[] cbBandeiraItens = { "", "Visa", "MasterCard", "Elo" };
		cbBandeira = new JComboBox(cbBandeiraItens);

		btOk = new JButton("Ok");
		btCancelar = new JButton("Cancelar");

		buttonGroup = new ButtonGroup();
		radioMasc = new JRadioButton("Masculino", true);
		radioFem = new JRadioButton("Feminino");

		lbNome.setBounds(30, 30, 80, 25);
		tfNome.setBounds(80, 30, 170, 25);

		lbCpf.setBounds(30, 90, 80, 25);
		tfCpf.setBounds(80, 90, 120, 25);

		lbSexo.setBounds(30, 140, 80, 25);
		radioMasc.setBounds(80, 140, 120, 25);
		radioFem.setBounds(200, 140, 120, 25);

		lbDtNasc.setBounds(30, 190, 80, 25);
		tfDtNasc.setBounds(90, 190, 70, 25);

		lbCc.setBounds(30, 240, 80, 25);
		tfCc.setBounds(80, 240, 100, 25);
		cbBandeira.setBounds(200, 240, 100, 25);

		btOk.setBounds(80, 300, 100, 25);
		btCancelar.setBounds(200, 300, 100, 25);

		add(lbNome);
		add(tfNome);
		add(lbCpf);
		add(tfCpf);
		add(lbSexo);
		buttonGroup.add(radioMasc);
		buttonGroup.add(radioFem);
		add(radioMasc);
		add(radioFem);
		add(lbDtNasc);
		add(tfDtNasc);
		add(lbCc);
		add(tfCc);
		add(cbBandeira);
		add(btOk);
		add(btCancelar);

		setVisible(true);

	}

	private void definirEventos() {

		btOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				char sexo = ' ';

				if (radioMasc.isSelected()) {
					sexo = 'M';
				}
				if (radioFem.isSelected()) {
					sexo = 'F';
				}

				if (tfNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo do  nome.");

				} else if (tfCpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo do cpf.");

					// } else if (!tfDtNasc.equals(msData)){
					// JOptionPane.showMessageDialog(null,"Preencha o campo de
					// data de nascimento.");

				} else if (tfCc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo do cartão de crédito.");

				} else if (cbBandeira.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Selecione a bandeira do cartão de crédito.");

				} else {

					Cliente cliente = new Cliente(tfNome.getText(), tfCpf.getText(), sexo, new Date(tfDtNasc.getText()),
							tfCc.getText());
					HelpDeskSystem.db.dbClientes.add(cliente);

					// JanelaPrincipal.bancoDadosClientes.add(cliente);

					tfNome.setText("");
					tfCpf.setText("");
					tfCc.setText("");
					tfDtNasc.setText("");
					cbBandeira.setSelectedItem("");
					// radioMasc.setSelected(false);

					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");

					BufferedWriter deposito = null;

					try {
						Path path4 = Paths.get("C:/temp/TxtCliente.txt");
						deposito = Files.newBufferedWriter(path4, StandardCharsets.UTF_8);

						for (Path path : path4) {

							deposito.write("Nome: " + cliente.getNome() + "  Cpf:" + cliente.getCpf());
							deposito.flush();
						}

					} catch (IOException e2) {
						e2.printStackTrace();
					} finally {

						if (deposito != null) {

							try {
								deposito.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}

				}

			}
		});
		btCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}

}
