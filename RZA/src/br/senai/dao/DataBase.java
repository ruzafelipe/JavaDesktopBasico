package br.senai.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

import br.senai.modelo.Cliente;
import br.senai.modelo.Equipamento;
import br.senai.modelo.OrdemServico;
import br.senai.modelo.Produto;
import br.senai.modelo.Tecnico;
import br.senai.programa.HelpDeskSystem;

public class DataBase {
	public ArrayList<Cliente> dbClientes = new ArrayList<>();
	public ArrayList<Tecnico> dbTecnicos = new ArrayList<>();
	public ArrayList<Produto> dbProdutos = new ArrayList<>();
	public ArrayList<Equipamento> dbEquipamentos = new ArrayList<>();
	public ArrayList<OrdemServico> dbOrdensServico = new ArrayList<>();
	
	
	
	// Deve carregar os arrays acima (exceto dbOrdensServico) com pelo menos três objetos.
	
	
	
	
	
	public void criarPastasArquivos(Path path){
		
		try {
			Files.createDirectories(path);
			if(!Files.exists(Paths.get(path.toString()+"/Cliente.txt"))){
				Files.createFile(Paths.get(path.toString()+"/Cliente.txt"));
			}
			if(!Files.exists(Paths.get(path.toString()+"/Tecnico.txt"))){
				Files.createFile(Paths.get(path.toString()+"/Tecnico.txt"));
			}
			if(!Files.exists(Paths.get(path.toString()+"/Produtos.txt"))){
				Files.createFile(Paths.get(path.toString()+"/Produtos.txt"));
			}
			if(!Files.exists(Paths.get(path.toString()+"/Equipamento.txt"))){
				Files.createFile(Paths.get(path.toString()+"/Equipamento.txt"));
			}
			if(!Files.exists(Paths.get(path.toString()+"/OrdemServico.txt"))){
				Files.createFile(Paths.get(path.toString()+"/OrdemServico.txt"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public DataBase(){
		
		
		
		
			
		
		//Date data = new Date("21/04/1997");
		
		
		
	
	
		//dbClientes.add(new Cliente("Humberto", "123.123.123-96", 'M', new Date("04/21/1997"), "abc0215654"));
		//dbClientes.add(new Cliente("Carlos", "000.000.000-03", 'M', new Date("02/21/1994"), "ngo098989"));
		//dbClientes.add(new Cliente("Adolfo", "562.236.789-20", 'M', new Date("08/21/1984"), "jtq988998"));
		
		//dbTecnicos.add(new Tecnico("José", "123.123.123-96", 'M', new Date("08/09/1990"), 3000));
		//dbTecnicos.add(new Tecnico("Astolfo", "123.735.298-96", 'M', new Date("08/09/1985"), 3000));
		//dbTecnicos.add(new Tecnico("Laura","897.659.459-30", 'F', new Date("11/09/1997"), 3000));
		
		//dbEquipamentos.add(new Equipamento(2365,"z9002","Asus",Tipo.NOTEBOOK));
		//dbEquipamentos.add(new Equipamento(1369,"Super X","Intel",Tipo.PC));
		//dbEquipamentos.add(new Equipamento(3987,"Iphone 6s","Apple",Tipo.CELULAR));
		
		//Peca peca = new Peca();
		
		//peca.setCodigo(0250);
		//peca.setClasse(Classe.PRODUTO);
		//peca.setDescricao("Processador");
		//peca.setPreco(450);
		
		
       // Peca peca2 = new Peca();
		
		//peca2.setCodigo(0130);
		//peca2.setClasse(Classe.PRODUTO);
		//peca2.setDescricao("Hard Disk");
		//peca2.setPreco(200);
		
		//dbProdutos.add(peca);
		//dbProdutos.add(peca2);
		
		
		
	}
	
}
