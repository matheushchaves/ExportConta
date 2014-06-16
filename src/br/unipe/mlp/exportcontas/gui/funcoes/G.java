package br.unipe.mlp.exportcontas.gui.funcoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class G {
	public static String diretorioApp = System.getProperty("user.dir");

	public static Properties getdbProp() {
		Properties props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(diretorioApp + File.separator
					+ "db.properties");
			props.load(file);
		} catch (FileNotFoundException e) {
			G.msgErro("Informe esse erro ao desenvolvedor :" + e.getMessage(),
					"Erro G.getdbProp() - FileNotFoundException");

		} catch (IOException e) {
			G.msgErro("Informe esse erro ao desenvolvedor :" + e.getMessage(),
					"Erro G.getdbProp() - IOException");
		}
		return props;
	}

	static void msg(String msg, String titulo, int tipo) {
		JOptionPane.showMessageDialog(null, msg, titulo, tipo);
	}

	public static void msgInfo(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void msgAlert(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.WARNING_MESSAGE);
	}

	public static void msgErro(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static boolean msgPergunta(String pergunta) {
		int retorno = JOptionPane.showConfirmDialog(null, pergunta, null,
				JOptionPane.YES_NO_OPTION);
		return (retorno == JOptionPane.YES_OPTION);
	}
public static void abrirNoNotepad(String arquivo){
	ProcessBuilder pb = new ProcessBuilder("Notepad.exe", arquivo);
	try {
		pb.start();
	} catch (IOException e) {
		G.msgErro("Informe esse erro ao desenvolvedor :"+e.getMessage(), "Erro G.abrirNoNotepad - IOException");	
	}
}
	public static String dateToString(Date data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		String retorno = df.format(data);

		return retorno;

	}

	public static String dinheiroToString(double valor) {
		return String.format("R$ %.2f", valor);
	}

	public static String mascaraCpf(String cpf) {
		return format("###.###.###-##", cpf);
	}

	private static String format(String pattern, Object value) {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (ParseException e) {
			G.msgErro("Informe esse erro ao desenvolvedor :" + e.getMessage(),
					"Erro G.format() - ParseException");
			throw new RuntimeException(e);

		}
	}

}
