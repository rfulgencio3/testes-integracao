package br.com.alura.leilao.automatizacao.login;

import br.com.alura.leilao.automatizacao.leilao.LeilaoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/leiloes/login";
    private static final String URL_ERROR_LOGIN = "http://localhost:8080/login?error";
    private static final String URL_PRINCIPAL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage(){
        System.setProperty("webdriver.chrome.driver", "C:/dev/java/testes-integracao/drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void fechar(){
        this.browser.quit();
    }

    public void preencheFormularioDeLogin(String usuario, String senha) {
        this.browser.findElement(By.id("username")).sendKeys(usuario);
        this.browser.findElement(By.id("password")).sendKeys(senha);
    }

    public LeilaoPage efetuaLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeilaoPage(browser);
    }

    public boolean ePaginaDeLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean ePaginaDeLoginComDadosInvalidos() {
        return browser.getCurrentUrl().equals(URL_ERROR_LOGIN);
    }

    public boolean ePaginaPrincipalDeLogin() {
        return browser.getCurrentUrl().equals(URL_PRINCIPAL_LOGIN);
    }

    public Object getNomeUsuarioLogado() {
        try
        {
            return browser.findElement(By.id("usuario-logado")).getText();
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }

    public void navegaParaPaginaDeLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}
