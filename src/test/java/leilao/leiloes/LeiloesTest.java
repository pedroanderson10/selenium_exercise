package leilao.leiloes;

import leilao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class LeiloesTest {

    private LeiloesPage leiloesPage;
    private CadastroLeilaoPage paginaCadastro;

    @BeforeEach
    //Realizar login e carregar formulário da página "Criar Leilão"
    public void realizarLogin(){
        // 1 step : Realizar login
        LoginPage loginPage = new LoginPage();
        loginPage.preencherFormularioLogin("fulano", "pass");
        this.leiloesPage = loginPage.realizarLogin();

        // 2 step : Entrar na página "Criar Leilão"
        this.paginaCadastro = leiloesPage.carregarFormulario();
    }

    @AfterEach
    public void fecharBrowser(){
        this.leiloesPage.fecharBrowser();
    }

    @Test
    @DisplayName("Cadastro Leilão")
    public void efetuarCadastroDeLeilao(){
        // 1 step : Realizar login
        // 2 step : Entrar na página "Criar Leilão"

        // 3 step : Preencher formulário
        String diaAtual = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + diaAtual;
        String valor = "500.00";
        this.leiloesPage = paginaCadastro.cadastrarLeilao(nome, valor, diaAtual);

        assertTrue(leiloesPage.isLeilaoCadastrado(nome, valor, diaAtual));
    }

    @Test
    @DisplayName("Validar Cadastro de Leilao")
    public void validarCadastroDeUmNovoLeilao(){
        this.leiloesPage = paginaCadastro.cadastrarLeilao("", "", "");
        assertFalse(this.paginaCadastro.isPaginaCadastroLeilao());
        assertTrue(this.paginaCadastro.isMensagensValidacao());
    }


}
