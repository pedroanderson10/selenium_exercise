package leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class TestSelenium {

    @Test
    public void helloWorld(){
        //Informar para o Selenium, onde está o caminho do executável do driver di navegador
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }

}
