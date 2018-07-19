package br.com.test;

import br.com.basepages.BasePageJava;
import br.com.basepages.BasePageKeyAndMouseEvents;
import br.com.driver.Driver;
import br.com.modelPage.Pagina1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Test {

	BasePageJava bpj = new BasePageJava(Driver.getDriver());
	Pagina1 page = new Pagina1();
	BasePageKeyAndMouseEvents bpjKeyEvents = new BasePageKeyAndMouseEvents(Driver.getDriver());

	@Given("^Passo 1$")
	public void passo1() {
		bpj.abrirUrl("https://www.google.com/");
	}

	@When("^Passo 2$")
	public void passo2() {
		bpj.clicar(page.caixaDeTexto);
		bpj.escrever(page.caixaDeTexto, "BRQ");
		bpjKeyEvents.pressionarEnter();
	}
}
