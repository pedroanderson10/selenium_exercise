package leilao.login;

import leilao.PageObject;
import leilao.leiloes.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends PageObject {

    private static final String URL_LOGIN = "http://localhost:8080/login";

    public LoginPage() {
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void preencherFormularioLogin(String username, String password) {
        //Buscar elemento a na página html
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage realizarLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser); //Retornar o browser que está sendo utilizado no momento
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
