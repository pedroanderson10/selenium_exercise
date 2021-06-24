package leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    @BeforeEach
    public void InicializarBrowser(){
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        this.browser = new ChromeDriver();
        browser.navigate().to(URL_LOGIN);
    }

    @Test
    @DisplayName("Realizar Login")
    public void efetuarLoginComSucesso(){
        //Buscar elemento a na página html
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals(URL_LOGIN));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText() );
    }

    @Test
    @DisplayName("Tentativa de Login Inválido")
    public void tentativaDeLoginComDadosIncorretos(){
        //Buscar elemento a na página html
        browser.findElement(By.id("username")).sendKeys("usuarioX");
        browser.findElement(By.id("password")).sendKeys("passwordX");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login?error"));
        //O método getPageSource devolve uma string com todo o código fonte da página
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos.") );
        Assert.assertThrows(NoSuchElementException.class, ()-> browser.findElement(By.id("usuario-logado")) );
    }

}
