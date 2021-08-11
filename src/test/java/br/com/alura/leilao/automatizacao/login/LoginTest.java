package br.com.alura.leilao.automatizacao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    public void deveriaEfetuarLoginComDadosValidos(){
        System.setProperty("webdriver.chrome.driver", "C:/dev/java/testes-integracao/drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes/login");
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/leiloes/login"));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

        browser.quit();
    }
}
