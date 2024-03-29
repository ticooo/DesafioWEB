package desafio.steps;


import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import desafio.pages.HomePage; 
import desafio.setup.Hooks;

public class HomeSteps {
	
	HomePage homePage = new HomePage(Hooks.get_driver());

	@Dado("que eu esteja na home")
	public void que_eu_esteja_na_home() throws InterruptedException {
		
		homePage.fechar_anuncios(); 
		homePage.validar_pagina();
	}
	
	@Quando("procuro por {string}") 
	public void procuro_por_texto(String procura) {

		homePage.procurar_texto(procura);
		homePage.clicar_buscar();
		homePage.validar_itens_busca();
	}
	
	@Entao("incluo o produto {string} no carrinho")
	public void incluo_o_produto_no_carrinho(String produto) throws InterruptedException {
		
		homePage.adicionar_produto_carrinho(produto);
	}

	@Entao("valido produto {string} no carrinho")
	public void valido_produto_no_carrinho(String produto) {
		
		homePage.validar_produto_carrinho(produto);
	}

}
