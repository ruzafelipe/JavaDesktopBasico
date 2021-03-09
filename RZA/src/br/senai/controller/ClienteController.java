package br.senai.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;

import br.senai.dao.ClienteDao;
import br.senai.dao.PathDao;
import br.senai.modelo.Cliente;
import br.senai.programa.HelpDeskSystem;

public class ClienteController {
	public void incluir(String nome, String cpf, String sexo, String dtNasc, String cartao) throws ParseException {
		ClienteDao cliDao = new ClienteDao();
		DateFormat df = DateFormat.getDateInstance();
		cliDao.incluir(new Cliente(nome, cpf, sexo.charAt(0), df.parse(dtNasc), cartao));
	}
	

}
