package br.senai.dao;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import br.senai.modelo.Cliente;
import br.senai.programa.HelpDeskSystem;

public class PathDao {
	public static  Path getPath(Class cliente){
		Path path = Paths.get(System.getProperty("user.dir")+"/Arquivos");
		System.out.println(cliente.equals(Cliente.class));
		
		if(cliente.equals(Cliente.class)){
			return Paths.get(path.toString()+"/Cliente.txt");
		}/*else if(arrayList == HelpDeskSystem.db.dbTecnicos){
		return Paths.get(path.toString()+"/Tecnico.txt");			
		}else if(arrayList == HelpDeskSystem.db.dbEquipamentos){
			return Paths.get(path.toString()+"/Equipamento.txt");			
		}else if(arrayList == HelpDeskSystem.db.dbProdutos){
			return Paths.get(path.toString()+"/Produtos.txt");
		}else if(arrayList == HelpDeskSystem.db.dbOrdensServico){
			return Paths.get(path.toString()+"/OrdemServico.txt");
		}*/
		
		return null;
	}
}
