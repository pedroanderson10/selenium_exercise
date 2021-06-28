package leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage {

    private static final String URL_PAGINA_CADASTRO = "http://localhost:8080/leiloes/new";
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

    public boolean isPaginaCadastroLeilao() {
        return browser.getCurrentUrl().equals(URL_PAGINA_CADASTRO);
    }

    public boolean isMensagensValidacao() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres")
                && pageSource.contains("não deve estar em branco")
                && pageSource.contains("deve ser um valor maior de 0.1")
                && pageSource.contains("deve ser uma data no formato dd/MM/yyyy");
    }
}
