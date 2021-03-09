package br.senai.programa;

import javax.swing.JComboBox;

import br.senai.dao.DataBase;
import br.senai.dao.PathDao;
import br.senai.modelo.Cliente;
import br.senai.modelo.OrdemServico;
import br.senai.modelo.Peca;
import br.senai.modelo.Produto;
import br.senai.modelo.Servico;
import br.senai.modelo.enums.Classe;
import br.senai.modelo.enums.Tipo;
import br.senai.view.MasterView;

public class HelpDeskSystem {
	public static DataBase db;

	public static void main(String[] args) {
		/* "Banco de Dados" da Aplicação */
		db = new DataBase();
		db.criarPastasArquivos(PathDao.getPath(Cliente.class).getParent());
		

		/* Formulario principal da aplicação */
		new MasterView();
		
		//new OrdemServico();
		
		
	
	}

}
