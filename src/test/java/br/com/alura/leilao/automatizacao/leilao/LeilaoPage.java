package br.com.alura.leilao.automatizacao.leilao;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeilaoPage {

    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
    private WebDriver browser;

    public LeilaoPage(WebDriver browser){
        this.browser = browser;
    }

    public void fechar(){
        this.browser.quit();
    }


    public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
    }
}
