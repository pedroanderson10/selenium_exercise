package leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private WebDriver browser;

    public CadastroLeilaoPage(WebDriver browser) {
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = browser;
    }

    public void fecharBrowser() {
        this.browser.quit();
    }


    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();

        return new LeiloesPage(browser);
    }
}
