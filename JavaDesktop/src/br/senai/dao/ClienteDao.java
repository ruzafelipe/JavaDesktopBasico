package br.senai.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

import br.senai.modelo.Cliente;
import br.senai.programa.HelpDeskSystem;

public class ClienteDao {

	public ArrayList<Cliente> selecionarTodos() {
		BufferedReader deposito = null;
		ArrayList<Cliente> lista = new ArrayList<>();
		String linha;
		String[] registro;
		try {
			deposito = Files.newBufferedReader(PathDao.getPath(HelpDeskSystem.db.dbClientes), StandardCharsets.UTF_8);
			DateFormat df = DateFormat.getDateInstance();

			while ((linha = deposito.readLine()) != null) {
				registro = linha.split(";");
				lista.add(new Cliente(registro[0], registro[1], registro[2].toCharArray()[0], df.parse(registro[3]),
						registro[4]));
			}
			deposito.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public static void carregarDataBase(){
		
		try(BufferedReader reader = Files.newBufferedReader(PathDao.getPath(HelpDeskSystem.db.dbClientes), StandardCharsets.UTF_8)){
			String linha;
			DateFormat df = DateFormat.getDateInstance();
			while ((linha = reader.readLine()) != null) {
				HelpDeskSystem.db.dbClientes.add(new Cliente(linha.split(";")[0], linha.split(";")[1], linha.split(";")[2].charAt(0),
						df.parse(linha.split(";")[3]), linha.split(";")[4]));
			}
		}catch(IOException e){
			e.printStackTrace();
		}catch(ParseException erro){
			erro.printStackTrace();
		}
	}

	public Cliente selecionar(String chave) {
		BufferedReader deposito = null;
		Cliente cli = null;
		try {
			deposito = Files.newBufferedReader(PathDao.getPath(HelpDeskSystem.db.dbClientes), StandardCharsets.UTF_8);
			DateFormat df = DateFormat.getDateInstance();
			String linha = null;
			while ((linha = deposito.readLine()) != null) {

				if (chave.equals(linha.split(";")[1])) {
					String valores[] = linha.split(";");
					cli = new Cliente(linha.split(";")[0], linha.split(";")[1], linha.split(";")[2].charAt(0),
							df.parse(linha.split(";")[3]), linha.split(";")[4]);
				}
			}

			deposito.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cli;
	}

	public void incluir(Cliente elemento) {
		BufferedWriter deposito = null;
		try {
			deposito = Files.newBufferedWriter(PathDao.getPath(HelpDeskSystem.db.dbClientes), StandardCharsets.UTF_8,
					StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

			deposito.append(converterClienteString(elemento));

			deposito.flush();
			deposito.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Cliente elemento) {
		String linha;
		try {
			BufferedReader depositoIn = Files.newBufferedReader(PathDao.getPath(HelpDeskSystem.db.dbClientes),
					StandardCharsets.UTF_8);
			StringBuilder sb = new StringBuilder();

			while ((linha = depositoIn.readLine()) != null) {
				if (!elemento.getCpf().equals(linha.split(";")[1])) {
					sb.append(linha).append(System.getProperty("line.separator"));
				} else {
					sb.append(converterClienteString(elemento)).append(System.clearProperty("line.separator"));
				}
			}
			depositoIn.close();

			BufferedWriter depositoOut = Files.newBufferedWriter(PathDao.getPath(HelpDeskSystem.db.dbClientes),
					StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

			depositoOut.write(sb.toString());

			depositoOut.flush();
			depositoOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Cliente elemento) {

		String linha;
		try {
			BufferedReader depositoIn = Files.newBufferedReader(PathDao.getPath(HelpDeskSystem.db.dbClientes),
					StandardCharsets.UTF_8);
			StringBuilder sb = new StringBuilder();
			while ((linha = depositoIn.readLine()) != null) {
				if (!elemento.getCpf().equals(linha.split(";")[1])) {
					sb.append(linha).append(System.getProperty("line.separator"));
				}
			}
			depositoIn.close();

			BufferedWriter depositoOut = Files.newBufferedWriter(PathDao.getPath(HelpDeskSystem.db.dbClientes),
					StandardCharsets.UTF_8);
			depositoOut.write(sb.toString());
			depositoOut.flush();
			depositoOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String converterClienteString(Cliente elemento) {
		StringBuilder sb = new StringBuilder();

		sb.append(elemento.getNome()).append(";");
		sb.append(elemento.getCpf()).append(";");
		sb.append(elemento.getSexo()).append(";");
		sb.append(DateFormat.getDateInstance(DateFormat.SHORT).format(elemento.getDtNasc())).append(";");
		sb.append(elemento.getCartaoCredito()).append(";");
		sb.append(System.getProperty("line.separator"));

		return sb.toString();
	}
}
