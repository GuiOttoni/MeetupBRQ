package br.com.basepages;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
public class BasePageJava {

	WebDriver driver;

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param WebDriver
	 */
	public BasePageJava(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @Descricao Mudar de aba do navegador
	 * @param numero
	 *            da aba. Ex.: 0, 1, 2 ...
	 */
	public void mudarAba(int numero) {
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[numero]);
	}

	/**
	 * @Descricao Procurar um elemento específico na página. Para utiliza-lo é
	 *            necessário informar um localizador (id, className, cssSelector,
	 *            Xpath, etc) afim de identificá-lo na página
	 * @param elemento
	 */
	public void procurarElemento(By elemento) {
		try {
			driver.findElement(elemento);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	public void elementoExiste(By elemento) {
		assertEquals(true, driver.findElement(elemento).isDisplayed());
	}

	public void elementoEstaHabilitado(By elemento) {
		assertEquals(true, driver.findElement(elemento).isEnabled());
	}

	/**
	 * @param elemento
	 * @param tempo
	 *            limite de espera
	 */
	public void esperarElemento(By elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(elemento)));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	public void escrever(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {

		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Limpar campo
	 * @param elemento
	 * @param texto
	 */
	public void limpar(By elemento, String texto) {
		try {
			driver.findElement(elemento).clear();
		} catch (NoSuchElementException e) {

		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Clicar em um elemento
	 * @param elemento
	 */
	public void clicar(By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Clicar em um ou mais elementos
	 * @param elementos
	 */
	public void clicarElementos(List<By> elementos) {
		for (By elemento : elementos) {
			try {
				driver.findElement(elemento).click();
			} catch (NoSuchElementException e) {
			} catch (TimeoutException e) {
			} catch (ElementNotVisibleException e) {
			}
		}
	}

	/**
	 * @Descricao Verificar se o Radio Button está selecionado
	 * @param elemento
	 * @return boolean
	 */
	public boolean verificarSeRadioEstaMarcado(By elemento) {
		boolean retorno = false;
		try {
			retorno = driver.findElement(elemento).isSelected();
			return retorno;
		} catch (NoSuchElementException e) {
			return retorno;
		} catch (TimeoutException e) {
			return retorno;
		} catch (ElementNotVisibleException e) {
			return retorno;
		}
	}

	/**
	 * @Descricao Obter texto do elemento. O texto é retornado como uma String
	 * @param elemento
	 * @return String
	 */
	public String obterTexto(By elemento) {
		try {
			return driver.findElement(elemento).getText();
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao limpar valor com backspace
	 * @param elemento
	 */
	public void limparValorComBackspace(WebElement elemento) {
		while (elemento.getAttribute("value").length() > 0) {
			elemento.sendKeys(Keys.BACK_SPACE);
		}
	}

	/**
	 * @Descricao Limpar Campo
	 * @param elemento
	 */
	public void limparCampo(By elemento) {
		try {
			driver.findElement(elemento).clear();
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Pegar Valor do CSS. elementoCss: nome do elemento CSS a ser obtido
	 *            o valor. Ex. Display
	 * @param elemento
	 * @param elementoCss
	 * @return String
	 */
	public String pegarValorCss(By elemento, String elementoCss) {
		try {
			return driver.findElement(elemento).getCssValue(elementoCss);
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Obter valor do "Attribute"
	 * @param elemento
	 * @return String
	 */
	public String obterValorDoElementoAttribute(By elemento) {
		try {
			return driver.findElement(elemento).getAttribute("value");
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Verificar se o check box está marcado
	 * @param elemento
	 * @return boolean
	 */
	public boolean verificarSeOcheckBoxEstaMarcado(By elemento) {
		try {
			return driver.findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		} catch (ElementNotVisibleException e) {
			return false;
		}
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Urls ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Abrir uma nova URL em um novo browser.
	 * @param URL
	 * 
	 */
	public void abrirUrl(String url) {
		driver.get(url);
	}

	/**
	 * @Descricao Nvaegar para outra URL, permanecendo na mesma aba do browser
	 * @param URL
	 */
	public void navegarUrl(String url) {
		driver.navigate().to(url);
	}

	/**
	 * @Descricao Valida título da aba do browser
	 * @param tituloDaAba
	 */
	public void validarTituloDoBrowser(String tituloDaAba) {
		assertEquals(tituloDaAba, driver.getTitle());
	}

	/**
	 * @Descricao Valida a URL atual
	 * @param URL
	 * 
	 */
	public void validarUrlAtual(String url) {
		assertEquals(url, driver.getCurrentUrl());
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Combos ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Selecionar combo por texto visível
	 * @param elemento
	 * @param valor
	 */
	public void selecionarComboPorTextoVisivel(By elemento, String valor) {
		try {
			WebElement webElement = driver.findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByVisibleText(valor);
		} catch (NoSuchElementException e) {

		} catch (TimeoutException e) {

		} catch (ElementNotVisibleException e) {

		}
	}

	/**
	 * @Descricao Clicar no combo pela posição (index)
	 * @param elemento
	 * @param posicao
	 */
	public void clicarComboIndex(By elemento, int posicao) {
		try {
			WebElement webElement = driver.findElement(elemento);
			Select combo = new Select(webElement);
			combo.selectByIndex(posicao);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Obter texto da primeira posição do combo
	 * @param elemento
	 * @return String
	 */
	public String obterTextoDaPrimeiraPosicaoDoCombo(By elemento) {
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			return combo.getFirstSelectedOption().getText();
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Obter a quantidade de opções do combo
	 * @param elemento
	 * @return Integer
	 */
	public Integer obterQuantidadeOpcoesCombo(By elemento) {
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			return options.size();
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Passar um texto e verificar se existe a opção no combo. Ex.: Se
	 *            quiser verificar num combo de cidade a opção "São Paulo", deverá
	 *            ser passado "São Paulo" como parâmetro
	 * @param elemento
	 * @param texto
	 * @return boolean
	 */
	public boolean passarTextoEverificarSeExisteOpcaoDeAcordoComOtextoNoCombo(By elemento, String texto) {
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			for (WebElement option : options) {
				if (option.getText().equals(texto)) {
					return true;
				}
			}
			return false;
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		} catch (ElementNotVisibleException e) {
			return false;
		}
	}

	/**
	 * @Descricao Desmarcar combo de acordo com o texto
	 * @param elemento
	 * @param valor
	 */
	public void desmarcarComboPorTextoVisivel(By elemento, String valor) {
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			combo.deselectByVisibleText(valor);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Obter todos os textos do combo
	 * @param elemento
	 * @return List
	 */
	public List<String> obterTextosCombo(By elemento) {
		List<String> listaDeTexto = new ArrayList<String>();
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			int quantidade = obterQuantidadeOpcoesCombo(elemento);
			for (int i = 0; i <= quantidade; i++) {
				listaDeTexto.add(combo.getOptions().get(i).getText());
			}
			return listaDeTexto;
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/**
	 * @Descricao Obter uma lista das opções que estão selecionadas no combo
	 * @param elemento
	 * @return lista de String
	 */
	public List<String> obterTodasAsOpcoesSelecionadasQueEstaoSelecionadasNoCombo(By elemento) {
		try {
			WebElement element = driver.findElement(elemento);
			Select combo = new Select(element);
			List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
			List<String> valores = new ArrayList<String>();
			for (WebElement opcao : allSelectedOptions) {
				valores.add(opcao.getText());
			}
			return valores;
		} catch (NoSuchElementException e) {
			return null;
		} catch (TimeoutException e) {
			return null;
		} catch (ElementNotVisibleException e) {
			return null;
		}
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Frames ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Entrar no frame
	 * @param elemento
	 */
	public void entrarFrame(String elemento) {
		try {
			driver.switchTo().frame(elemento);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Sair do frame atual e voltar pra estrutura HTML padrão
	 */
	public void sairFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * @Descricao Trocar de Janela
	 * @param elemento
	 */
	public void trocarJanela(String elemento) {
		try {
			driver.switchTo().window(elemento);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Alerts ***********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @Descricao Aceitar o alerta
	 */
	public void aceitarAlerta() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	/**
	 * @Descricao Obter texto do alerta
	 * @return String
	 */
	public String obterTextoDoAlerta() {
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		return texto;
	}

	/**
	 * @Descricao Negar Alerta
	 */
	public void negarAlerta() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	/**
	 * @Descricao Escrever no Alerta
	 * @param elemento
	 */
	public void escreverNoAlerta(String elemento) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(elemento);
	}

	/*
	 * ***********************************
	 * 
	 * 
	 * 
	 * **************** Esperas **********
	 * 
	 * 
	 * 
	 ***********************************/

	/**
	 * @param elemento.
	 * @param tempo
	 *            limite de espera
	 */
	public void esperarSerClicavel(By elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(elemento));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarSerSelecionavel(By elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeSelected(elemento));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Esperar a página estar na URL passada via parâmetro
	 * @param URL
	 * @param tempoLimiteDeEspera
	 */
	public void esperarUrlSerCarregada(String url, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
			wait.until(ExpectedConditions.urlToBe(url));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Esperar elemento ser clicável, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	public void esperarSerClicavelClicarEscrever(By elemento, String valor, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
			wait.until(ExpectedConditions.elementToBeClickable(elemento)).clear();
			wait.until(ExpectedConditions.elementToBeClickable(elemento)).click();
			wait.until(ExpectedConditions.elementToBeClickable(elemento)).sendKeys(valor);
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarVisibilidadeDoElemento(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(elemento)));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Esperar elemento ser visível
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarElementoSerVisivel(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(elemento)));
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}

	/**
	 * @Descricao Esperar elemento ser clicável, após, limpar o campo
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	public void esperarElementoSerClicavelLimparCampo(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, tempoLimiteDeEspera);
			WebElement input = wait.until(ExpectedConditions.elementToBeClickable(elemento));
			while (input.getAttribute("value").length() > 0) {
				input.sendKeys(Keys.BACK_SPACE);
			}
		} catch (NoSuchElementException e) {
		} catch (TimeoutException e) {
		} catch (ElementNotVisibleException e) {
		}
	}
}