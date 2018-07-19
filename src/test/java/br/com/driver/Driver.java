package br.com.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável pela manipulação do driver.
 */
public class Driver {

	private static WebDriver driver;
	private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
	private static boolean rodarMaximizado = true;

	/**
	 * @Descricao Método que deve ser chamado para iniciar o webdriver e todas as
	 *            suas configurações. Sempre que quiser receber o webdriver em
	 *            algum lugar, esse é o método chamado.
	 * @return retorna o driver pronto com todas as configurações realizadas.
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		return driver;
	}

	/**
	 * @Descricao Verifica qual o browser será executa e chama o método
	 *            específico à cada navegador. Caso nenhum navegador seja
	 *            informado via "cmd"
	 */
	private static void setarConfiguracoesDoDriver() {
		if (browserSetadoViaPrompt != null) {
			switch (browserSetadoViaPrompt) {
			case "firefox":
				configsFirefox("firefox");
				break;
			case "chrome":
				configsChrome("chrome");
				break;
			}
		} else {
			configsChrome("chrome");
		}
		/**
		 * A linha abaixo define que todos os comandos do webdriver terão um timeout de
		 * X segundos (Por padrão está setado como 30). Caso o comando seja realizado
		 * antes dos X segundos, ele passa para o próximo.
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @param navegador
	 */
	private static void configsFirefox(String navegador) {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		if (rodarMaximizado == true) {
			driver.manage().window().maximize();
		}
	}

	/**
	 * @param navegador
	 */
	private static void configsChrome(String navegador) {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		if (rodarMaximizado == true) {
			driver.manage().window().maximize();
		}

	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
