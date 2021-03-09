package br.senai.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class ExmploTableModel extends JFrame {
	private JTable tblXaxa;
	JScrollPane scrollXaxa;
	DefaultTableModel dtm;

	public ExmploTableModel() {
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		setTitle("Exemplo de Tabela Default Table Model");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 420);

		getContentPane().setLayout(null);

		String[] cabecalho = new String[] { "Código", "Nome", "Telefone" };
		String[][] conteudo = new String[][] { { "1", "Eu", "5555-5555" }, { "2", "Tu", "5656-5656" },
				{ "3", "Ele", "5757-5757" }, { "4", "Nós", "5858-5858" }, { "5", "Vós", "5959-5959" },
				{ "6", "Eles", "5050-5050" } };

		tblXaxa = new JTable();
		dtm = new DefaultTableModel(conteudo, cabecalho);
		tblXaxa.setModel(dtm);
		scrollXaxa = new JScrollPane();
		scrollXaxa.setBounds(10, 10, 390, 200);
		scrollXaxa.setViewportView(tblXaxa);
		add(scrollXaxa);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(10, 220, 120, 30);
		add(datePicker);

		setVisible(true);
	}

	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}	
	
	public void adicionaLinha() {
		DefaultTableModel modelo = (DefaultTableModel) tblXaxa.getModel();
		modelo.addRow(new String[] { "7", "Outros", "777777" });
	}

	public void removeLinhaSelecionada() {
		int linha = tblXaxa.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel) tblXaxa.getModel();
		if (linha != -1) {
			modelo.removeRow(linha);
		}
	}

	public String getValorCelula(int posLinha, int posColuna) {
		return tblXaxa.getValueAt(posLinha, posColuna).toString();
	}

	public void setValorCelula(String valor, int posLinha, int posColuna) {
		tblXaxa.setValueAt(valor, posLinha, posColuna);
	}

	public int quantLinhas() {
		return tblXaxa.getRowCount();
	}

	public int quantColunas() {
		return tblXaxa.getColumnCount();
	}

	public static void main(String[] args) {
		ExmploTableModel form = new ExmploTableModel();

		JOptionPane.showMessageDialog(null, "Colunas: " + form.quantColunas());
		JOptionPane.showMessageDialog(null, "Linhas: " + form.quantLinhas());
		form.setValorCelula("22", 1, 1);
		JOptionPane.showMessageDialog(null, "Valor: " + form.getValorCelula(1, 1));

	}

}
