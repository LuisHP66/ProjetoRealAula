package Pages;

import Factory.BasePage;
import org.openqa.selenium.By;

public class ContasPage {

    private static BasePage page;

    public ContasPage(){
        page = new BasePage();
    }

    public void setNomeConta(String nomeConta){
        page.escreve(By.id("nome"), nomeConta);
    }
    public void clickSalvar(){
        page.clicaBotao(By.xpath("//button[contains(text(), 'Salvar')]"));
    }
    public void mdsDeRetorno(String msg){
        page.validaTexto(By.xpath("//div[@role='alert']"), msg);
    }
    public void clickEditar(String nomeConta){
        page.clicaBotao(By.xpath("//td[.='"+nomeConta+"']/../..//span"));
    }
}
