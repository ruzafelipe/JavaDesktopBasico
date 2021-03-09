package br.senai.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.senai.modelo.Tecnico;
import br.senai.programa.HelpDeskSystem;

public class TecnicoView extends JFrame {

	private JLabel lbNome, lbCpf, lbSexo, lbDtNasc, lbSalario;
	private JTextField tfNome, tfCpf, tfDtNasc, tfSalario;
	private ButtonGroup buttonGroup;
	private JRadioButton radioMasc, radioFem;

	private MaskFormatter msData;

	private JButton btOk, btCancelar;

	public TecnicoView() {

		super("Técnico");
		iniciarComponentes();
		definirEventos();

	}

	private void iniciarComponentes() {

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		try {
			msData = new MaskFormatter("##/##/####");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		JFormattedTextField data = new JFormattedTextField(msData);
		lbNome = new JLabel("Nome:");
		lbCpf = new JLabel("Cpf:");
		lbSexo = new JLabel("Sexo:");
		lbDtNasc = new JLabel("Dt Nasc:");
		lbSalario = new JLabel("Salário:");
		tfNome = new JTextField();
		tfCpf = new JTextField();
		tfDtNasc = new JTextField();
		tfSalario = new JTextField();
		String[] cbBandeiraItens = { "", "Visa", "MasterCard", "Elo" };

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
		data.setBounds(90, 190, 70, 25);

		lbSalario.setBounds(30, 240, 80, 25);
		tfSalario.setBounds(80, 240, 100, 25);

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
		add(data);
		add(lbSalario);
		add(tfSalario);
		add(btOk);
		add(btCancelar);

		setVisible(true);

	}

	private void definirEventos() {

		btOk.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

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
						// JOptionPane.showMessageDialog(null,"Preencha o campo
						// de data de nascimento.");

					} else if (tfSalario.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha o campo de salário.");

					} else {

						Tecnico tecnico = new Tecnico(tfNome.getText(), tfCpf.getText(), sexo,
								new Date(tfDtNasc.getText()), Double.parseDouble(tfSalario.getText()));
						HelpDeskSystem.db.dbTecnicos.add(tecnico);

						// JanelaPrincipal.bancoDadosClientes.add(cliente);

						tfNome.setText("");
						tfCpf.setText("");
						tfSalario.setText("");
						tfDtNasc.setText("");

						// radioMasc.setSelected(false);

						JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso.");

					}

				} catch (NumberFormatException erro) {

					JOptionPane.showMessageDialog(null, "Digite apenas números no salário.");
					tfSalario.setText("");

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
