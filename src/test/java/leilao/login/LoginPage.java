package leilao.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage() {
        //Informar para o Selenium, onde está o caminho do executável do driver do navegador
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }


    public void fecharBrowser() {
        this.browser.quit();
    }

    public void preencherFormularioLogin(String username, String password) {
        //Buscar elemento a na página html
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void realizarLogin() {
        browser.findElement(By.id("login-form")).submit();
    }

    public boolean isPaginaLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public String getNomeUsuarioLogado() {
        try {
            return browser.findElement(By.id("usuario-logado")).getText();
        }catch (NoSuchElementException e){
            //Retornar nulo quando não encontrar o nome do usuário logado (quando ele não tiver logado)
            return null;
        }

    }

    public boolean getTextoPagina(String texto) {
        //O método getPageSource devolve uma string com todo o código fonte da página
        return browser.getPageSource().contains(texto);
    }

    public void navegarPaginaLances() {
        this.browser.navigate().to("http://localhost:8080/leiloes/2");
    }

}
