package br.com.alura.leilao.automatizacao.leilao;

import br.com.alura.leilao.automatizacao.login.LoginPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeilaoTest {

    private LeilaoPage paginaDeLeilao;
    
    @AfterEach
    public void afterEach(){

        this.paginaDeLeilao.fechar();
    }

    @Test
    public void deveriaCadatrarLeilao(){
        LoginPage paginaDeLogin = new LoginPage();
        paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
        this.paginaDeLeilao = paginaDeLogin.efetuaLogin();
        CadastroLeilaoPage paginaDeCadastro = paginaDeLeilao.carregarFormulario();
    }
}
