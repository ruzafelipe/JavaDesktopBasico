package br.senai.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SobreView extends JFrame {
	// Deve conter um JLabel com o Nome do Programa
	// Deve conter um JLabel com o Autor do Programa
	// Pode conter um JLabel com uma imagem referente ao Programa.

	private JLabel lbSistema, lbHelpDeskSystem, lbAutor, lbNome, lblImage;
	private ImageIcon image1;
	public SobreView() {
		super("Sobre...");
		inicializarComponentes();
	}

	private void inicializarComponentes() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 400);
		getContentPane().setLayout(null);
		image1 = new ImageIcon("logo.jpg");
		lbSistema = new JLabel("Sistema:");
		lbHelpDeskSystem = new JLabel("HelpDesk System");
		lbAutor = new JLabel("Autor:");
		lbNome = new JLabel("RUZA, Felipe");
		lblImage = new JLabel(image1);
		lbSistema.setBounds(30, 40, 100, 25);
		lbHelpDeskSystem.setBounds(90, 40, 130, 25);
		
		lblImage.setBounds(0, 70, 300, 300);
		lbAutor.setBounds(30, 330, 100, 25);
		lbNome.setBounds(75, 330, 230, 25);

		add(lbSistema);
		add(lbHelpDeskSystem);
		add(lbAutor);
		add(lbNome);
		add(lblImage);
		setVisible(true);

	}

}
