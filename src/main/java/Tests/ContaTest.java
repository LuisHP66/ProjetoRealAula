package Tests;

import Factory.BaseTest;
import Pages.ContasPage;
import Pages.MenuPage;
import org.junit.Test;

public class ContaTest extends BaseTest {

    private static MenuPage menupage;
    private static ContasPage contaspage;

    public ContaTest(){
    menupage = new MenuPage();
    contaspage = new ContasPage();
    }

    @Test
    public void inserirContaValida(){
        menupage.selectComboAdicionar();
        contaspage.setNomeConta("conta qualquer");
        contaspage.clickSalvar();
        contaspage.mdsDeRetorno("Conta adicionada com sucesso!");
    }
    @Test
    public void inserirEAlterarConta(){
        menupage.selectComboAdicionar();
        contaspage.setNomeConta("Outra Conta");
        contaspage.clickSalvar();
        contaspage.mdsDeRetorno("Conta adicionada com sucesso!");
        menupage.selectComboListar();
        contaspage.clickEditar("Outra Conta");
        contaspage.setNomeConta("Conta Teste");
        contaspage.clickSalvar();
        contaspage.mdsDeRetorno("Conta alterada com sucesso!");
    }
    @Test
    public void inserirContasMesmoNomeValidarMsg(){
        menupage.selectComboAdicionar();
        contaspage.setNomeConta("Teste mesmo nome");
        contaspage.clickSalvar();
        contaspage.mdsDeRetorno("Conta adicionada com sucesso!");
        menupage.selectComboAdicionar();
        contaspage.setNomeConta("Teste mesmo nome");
        contaspage.clickSalvar();
        contaspage.mdsDeRetorno("Já existe uma conta com esse nome!");
    }
    @Test
    public void inserirMovimentacao(){
        menupage.selectComboAdicionar();
        contaspage.setNomeConta("Teste inserirMovimentacao");
        contaspage.clickSalvar();

    }
}
