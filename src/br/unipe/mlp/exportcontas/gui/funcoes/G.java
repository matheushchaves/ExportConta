package br.unipe.mlp.exportcontas.gui.funcoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class G {
	public static String diretorioApp = System.getProperty("user.dir");
	public static Properties getdbProp() {
		Properties props = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream(
					diretorioApp+File.separator+"db.properties");
			props.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}

}
