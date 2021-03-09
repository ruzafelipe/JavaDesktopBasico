package br.senai.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.senai.modelo.Cliente;
import br.senai.programa.HelpDeskSystem;

public class MasterView extends JFrame {
	// Criar Formulario principal da aplicação.
	// Deve Conter:
	// - Menu com Arquivo/Sair; Cadastro/ Operação/Ordem de Serviço;
	// Relatorio/Ordem de Serviço; Ajuda/Sobre;
	// - Sair deve fechar aplicação
	// - Ordem de Serviço deve chamar a tela OrdemDetView;
	// - Sobre deve chamar a tela SobreView;
	// - Imagem Central para LogoMarca do sistema;
	// -

	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnCadastro, mnOperacao, mnRelatorio, mnAjuda;
	private JMenuItem miSair, miOrdemServico1, miOrdemServico2, miSobre, miCliente, miTecnico, miProduto,miEquipamentos;
	private JLabel lbImagem;

	public MasterView() {
		super("HelpDeskSystem");
		inicializarComponentes();
		definirEventos();

	}

	private void inicializarComponentes() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color (0,0,0));
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('C');
		mnOperacao = new JMenu("Operação");
		mnOperacao.setMnemonic('O');
		mnRelatorio = new JMenu("Relatório");
		mnRelatorio.setMnemonic('R');
		mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('j');
		miSair = new JMenuItem("Sair");
		miSair.setMnemonic('S');
		miOrdemServico1 = new JMenuItem("Ordem Serviço");
		miOrdemServico1.setMnemonic('O');
		miOrdemServico2 = new JMenuItem("Ordem Serviço");
		miOrdemServico2.setMnemonic('O');
		miSobre = new JMenuItem("Sobre");
		miSobre.setMnemonic('S');
		miCliente = new JMenuItem("Cliente");
		miCliente.setMnemonic('C');
		miTecnico = new JMenuItem("Tecnico");
		miTecnico.setMnemonic('T');
		miProduto = new JMenuItem("Produtos");
		miProduto.setMnemonic('P');
		miEquipamentos = new JMenuItem("Equipamentos");
		miEquipamentos.setMnemonic('E');

		ImageIcon imagem1 = new ImageIcon("dgk.png");
		JLabel lbImagem = new JLabel(imagem1);


		
		add(lbImagem);
		lbImagem.setBounds(225,150, 300, 251);
		mnArquivo.add(miSair);
		mnCadastro.add(miCliente);
		mnCadastro.add(miTecnico);
		mnCadastro.add(miProduto);
		mnCadastro.add(miEquipamentos);
		mnOperacao.add(miOrdemServico1);
		mnRelatorio.add(miOrdemServico2);
		mnAjuda.add(miSobre);

		mnBarra.add(mnArquivo);
		mnBarra.add(mnCadastro);
		mnBarra.add(mnOperacao);
		mnBarra.add(mnRelatorio);
		mnBarra.add(mnAjuda);
		setJMenuBar(mnBarra);

		setVisible(true);

	}

	private void definirEventos() {

		miSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
                
				int resposta = JOptionPane.showConfirmDialog(null,"Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
				
				if (resposta == JOptionPane.YES_OPTION){
					System.exit(0);
				};

			}
		});

		miOrdemServico1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				new OrdemDetView();

			}
		});

		miSobre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				new SobreView();

			}
		});
		
		
		miCliente.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent arg0) {
				
				
					new ClienteView();
				
				
			}
		});
		
		
		
		miTecnico.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
					new TecnicoView();
				
				
			}
		});
		
		
	miProduto.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				
					new ProdutosView();
				
				
			}
		});
	
	
	miEquipamentos.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
			
			
				new EquipView();
			
			
		}
	});
		
		

	}

	
}
