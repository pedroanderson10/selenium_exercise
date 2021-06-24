package leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    @Test
    @DisplayName("Realizar Login")
    public void efetuarLoginComSucesso(){
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/login");

        //Buscar elemento a na página html
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText() );
    }
    

}
