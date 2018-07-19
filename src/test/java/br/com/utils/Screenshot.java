package br.com.utils;

import static br.com.driver.Driver.getDriver;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe com método responsável por tirar screenshots
 */
public class Screenshot {

	/**
	 * @Descricao Tirar screenshot
	 * @param nomeNovoArquivo
	 */
	public void tirarScreenshot(String nomeNovoArquivo) {
		if (nomeNovoArquivo != null) {
			TakesScreenshot print = (TakesScreenshot) getDriver();
			File arquivo = print.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(arquivo, new File("src/test/resources/screenshot/" + nomeNovoArquivo + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("Parâmetro " + nomeNovoArquivo + " está nulo");
		}
	}
}