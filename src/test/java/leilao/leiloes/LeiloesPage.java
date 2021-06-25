package leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

    private static final String URL_CRIAR_LEILAO = "http://localhost:8080/leiloes/new";
    private WebDriver browser;

    public LeiloesPage(WebDriver browser) {
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = browser;
    }

    public void fecharBrowser() {
        this.browser.quit();
    }


    public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to(URL_CRIAR_LEILAO);
        return new CadastroLeilaoPage(browser);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String diaAtual) {
        WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome)
                && colunaDataAbertura.getText().equals(diaAtual)
                && colunaValorInicial.getText().equals(valor);
    }
}
