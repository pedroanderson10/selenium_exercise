package leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeEach
    public void inicializarBrowser(){
        this.loginPage = new LoginPage();
    }

    @AfterEach
    public void fecharBrowser(){
        this.loginPage.fecharBrowser();
    }

    @Test
    @DisplayName("Realizar Login")
    public void efetuarLoginComSucesso(){
        //Buscar elemento na página html
        loginPage.preencherFormularioLogin("fulano", "pass");
        loginPage.realizarLogin();

        Assert.assertFalse(loginPage.isPaginaLogin());
        Assert.assertEquals("fulano", loginPage.getNomeUsuarioLogado());
    }

    @Test
    @DisplayName("Tentativa de Login Inválido")
    public void tentativaDeLoginComDadosIncorretos(){
        //Buscar elemento na página html
        loginPage.preencherFormularioLogin("usuarioX", "passwordX");
        loginPage.realizarLogin();

        assertFalse(loginPage.isPaginaLogin());
        assertTrue(loginPage.getTextoPagina("Usuário e senha inválidos."));

        //Assert.assertThrows(NoSuchElementException.class, ()-> browser.findElement(By.id("usuario-logado")) );
        assertNull(loginPage.getNomeUsuarioLogado());
    }

    @Test
    @DisplayName("Tentativa de Acesso à páginas restritas")
    public void tentativaDeAcessoAPaginaRestritaSerRealizarLogin(){
        loginPage.navegarPaginaLances();

        assertTrue(loginPage.isPaginaLogin());
        assertFalse(loginPage.getTextoPagina("Dados do Leilão"));
    }

}
