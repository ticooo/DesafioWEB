package desafio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;

import desafio.setup.Hooks;
import desafio.utils.Helper;

public class HomePage {
	
	public HomePage(WebDriver driver) { 
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (xpath = "//*[text() = 'shoestock: Paixão por Sapatos | Loja de Calçados Online']")
	private WebElement home;
	
	@FindBy (xpath = "//*[@id = 'search-input']")
	private WebElement campoBusca;
	
	@FindBy (xpath = "//button[@qa-automation = \"home-search-button\"]")
	private WebElement btnBuscar;
	
	@FindBy (xpath = "//div[@class = \"img-floater\"]")
	private WebElement anuncio;
	
	@FindBy (xpath = "//span[@class = \"fechar-x\"]")
	private WebElement btnFecharAnuncio;
	
	@FindBy (xpath = "//*[@id = \"pnosp_div_close\"]")
	private WebElement btnFecharNotify;
	
	@FindBy (xpath = "//span[text() = 'Sapato Casual Couro Shoestock Neoprene Masculino']")
	private WebElement item1;
	
	@FindBy (xpath = "//span[text() = 'Sapato Casual Couro Shoestock Detalhe Metal Masculino']")
	private WebElement item2;
	
	@FindBy (xpath = "//span[text() = 'Sapato Casual Couro Shoestock Camurça Liso Masculino']")
	private WebElement item3;
	
	@FindBy (xpath = "//a[@class = \"product-item\" and @data-size = \"size-42\"]")
	private WebElement btnTamanho;
	
	@FindBy (xpath = "//button[@id = \"buy-button-now\"]")
	private WebElement btnComprar;
	
	@FindBy (xpath = "//h1[@class = \"cart__title\"]")
	private WebElement titleCarrinho;
	
	@FindBy (xpath = "//span[text() = 'SACOLA']")
	private WebElement btnAcessarCarrinho;
	

	public void fechar_anuncios() {
		Helper.element_exists(anuncio, 10);
		btnFecharAnuncio.click();
	}
	
	public void validar_pagina() {
		Helper.element_exists(home, 10);
	}
	
	public void procurar_texto(String procura) {
		campoBusca.sendKeys(procura);
	}
	
	public void clicar_buscar() {
		btnBuscar.click();
	}
	
	
	public void validar_itens_busca() {
		Assert.assertTrue(Helper.element_exists(item1, 10));
		Assert.assertTrue(Helper.element_exists(item2, 10));
		Assert.assertTrue(Helper.element_exists(item3, 10));
	}
	
	public void acessar_carrinho_compras() {
		btnAcessarCarrinho.click();
	}
	
	public void adicionar_produto_carrinho(String produto) throws InterruptedException {
		Thread.sleep(3000);
		WebElement itemMenu = Hooks.get_driver().findElement(By.xpath("//span[text() = '" + produto + "']"));
		itemMenu.click();
		WebElement itemNome = Hooks.get_driver().findElement(By.xpath("//h1[@data-productname][contains(text(), '" + produto + "')]"));
		Assert.assertTrue(Helper.element_exists(itemNome, 10));
		
		Assert.assertTrue(Helper.element_exists(btnTamanho, 10));
		btnTamanho.click();
		btnComprar.click();
		
		Assert.assertTrue(Helper.element_exists(titleCarrinho, 10));
	}
	
	public void validar_produto_carrinho(String produto) {
		WebElement item = Hooks.get_driver().findElement(By.xpath("//*[contains(text(), '" + produto + "')]"));
		
		Assert.assertTrue(Helper.element_exists(item, 10));
	}

	
		
}
