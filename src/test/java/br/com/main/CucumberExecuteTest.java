package br.com.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @version = 1.0
 * @author Paulo Lobo Neto
 * @CucumberExecuteTest = Classe principal, respons�vel pelo gerenciamento e
 *                      execu��o dos testes.
 * @RunWith = Quando uma classe � anotada com RunWith, JUnit invocar� a classe
 *          referenciada para executar os testes.
 * @Features = caminho dos arquivos ".features".
 * @Glue = Caminho das classes de defini��o dos passos(steps). Obs.: se n�o for
 *       especificado a pasta, ele procura em toda a estrutura.
 * @DryRun = Se "true", verifica se todos os passos definidos nas features est�o
 *         implementados.
 * @Strict = Se "true", falha a execu��o dos testes caso tenha passos
 *         indefinidos ou pendentes.
 * @Plugin = Define os diversos relat�rios que ser�o gerados.
 * @Tags = manipular tags dos ".features". Exemplo para rodar uma tag
 *       espec�fica: tags = {"@tag"}. Mais de uma tag: tags = {"@tag1","@tag2"}.
 *       N�o rodar uma tag espec�fica: tags ={"~@tag"}
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"json:src/test/resources/cucumber-report/Resultado.json", "rerun:src/test/resources/falhas/rerun.txt",
		"junit:src/test/resources/junit-report/Resultado.xml",
		"html:src/test/resources/cucumber-report/" }, glue = { "" }, monochrome = true, dryRun = false, strict = false)
/**
 * @Importante Por padr�o do JUnit, o nome da classe "main" DEVE ter como seu
 *             sufixo a palavra "Test".
 */
public class CucumberExecuteTest {

}