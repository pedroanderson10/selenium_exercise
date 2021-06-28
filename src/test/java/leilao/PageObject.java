package leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {

    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (browser == null){ //Caso seja o page object precise criar uma nova página no navegador
            this.browser = new ChromeDriver();
        }else { //Caso o page object esteja reaproveitando uma janela já aberta
            this.browser = browser;
        }

        this.browser.manage().timeouts()
                .implicitlyWait(1, TimeUnit.SECONDS);
                //.pageLoadTimeout(10, TimeUnit.SECONDS)

    }

    public void fecharBrowser() {
        this.browser.quit();
    }

}
