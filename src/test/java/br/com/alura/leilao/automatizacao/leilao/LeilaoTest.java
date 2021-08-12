package br.com.alura.leilao.automatizacao.leilao;

import br.com.alura.leilao.automatizacao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LeilaoTest {

    private LeilaoPage paginaDeLeilao;
    private CadastroLeilaoPage paginaDeCadastro;

    @BeforeEach
    public void beforeEach(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeilao = paginaDeLogin.efetuaLogin();
        this.paginaDeCadastro = paginaDeLeilao.carregarFormulario();
    }
    
    @Test
    public void deveriaCadatrarLeilao(){
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilao do dia " + data;
        String valor = "500.00";

        this.paginaDeLeilao = paginaDeCadastro.cadastrarLeilao(nome, valor, data);
        Assert.assertTrue(paginaDeLeilao.eLeilaoCadastrado(nome, valor, data));
    }

    @Test
    public void deveriaValidarCadatroDeLeilao(){
        this.paginaDeLeilao = paginaDeCadastro.cadastrarLeilao("", "", "");

        Assert.assertFalse(this.paginaDeCadastro.ePaginaAtual());
        Assert.assertTrue(this.paginaDeLeilao.ePaginaAtual());
        Assert.assertTrue(this.paginaDeCadastro.mensagensDeValidacao());
    }
}
