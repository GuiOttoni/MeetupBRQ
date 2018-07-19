package br.com.main;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @version = 1.0
 * @author Paulo Lobo Neto
 * @CucumberExecuteTest = Classe principal, responsável pelo gerenciamento e
 *                      execução dos testes.
 * @RunWith = Quando uma classe é anotada com RunWith, JUnit invocará a classe
 *          referenciada para executar os testes.
 * @Features = caminho dos arquivos ".features".
 * @Glue = Caminho das classes de definição dos passos(steps). Obs.: se não for
 *       especificado a pasta, ele procura em toda a estrutura.
 * @DryRun = Se "true", verifica se todos os passos definidos nas features estão
 *         implementados.
 * @Strict = Se "true", falha a execução dos testes caso tenha passos
 *         indefinidos ou pendentes.
 * @Plugin = Define os diversos relatórios que serão gerados.
 * @Tags = manipular tags dos ".features". Exemplo para rodar uma tag
 *       específica: tags = {"@tag"}. Mais de uma tag: tags = {"@tag1","@tag2"}.
 *       Não rodar uma tag específica: tags ={"~@tag"}
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"json:src/test/resources/cucumber-report/Resultado.json", "rerun:src/test/resources/falhas/rerun.txt",
		"junit:src/test/resources/junit-report/Resultado.xml",
		"html:src/test/resources/cucumber-report/" }, glue = { "" }, monochrome = true, dryRun = false, strict = false)
/**
 * @Importante Por padrão do JUnit, o nome da classe "main" DEVE ter como seu
 *             sufixo a palavra "Test".
 */
public class CucumberExecuteTest {

}