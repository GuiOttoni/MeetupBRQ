package br.com.basepages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter os métodos que executam ações na
 *            página utilizando o JavaScript
 */
public class BasePageJavascript {

	private WebDriver driver;

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param driver
	 */
	public BasePageJavascript(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @Descricao Clicar no elemento
	 * @param elemento
	 */
	public void clicar(By elemento) {
		try {
			WebElement element = driver.findElement(elemento);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Rolar para baixo. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	public void rolarParaBaixo(int quantidade) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + quantidade + ")");
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Rolar para cima. O parâmetro "quantidade" define a quantidade de
	 *            rolagens
	 * @param quantidade
	 */
	public void rolarParaCima(int quantidade) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, " + quantidade + ")");
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Pegar valor do CSS. O parâmetro esperar receber o ID do elemento.
	 *            VocÊ DEVE passa o parâmetro como um tipo String
	 * @param idDoElemento
	 * @return String: valor do css
	 */
	public String pegarValorCss(String idDoElemento) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			String value = (String) jse.executeScript(
					"" + "if (document.getElementById('" + idDoElemento + "').style.display == 'none'){   }");
			return value;
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Mover para o elemento
	 * @param elemento
	 */
	public void moverParaOelemento(By elemento) {
		WebElement element = driver.findElement(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * @Descricao Escrever
	 * @param elemento
	 * @param texto
	 */
	public void escrever(By elemento, String texto) {
		WebElement element = driver.findElement(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value=" + texto + ";", element);
	}

}