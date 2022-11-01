package Pages;

import Factory.BasePage;
import org.openqa.selenium.By;

public class LoginPage{

    private static BasePage page;

    public LoginPage(){
        page = new BasePage();
    }
    public void setUserName(String email){
        page.escreve(By.id("email"), email);
    }
    public void setPassword(String senha){
        page.escreve(By.id("senha"), senha);
    }
    public void clickEntrar(){
        page.clicaBotao(By.xpath("//button"));
    }
    public void msgRetornoLogin() throws InterruptedException {
        page.validaTexto(By.xpath("//div[@role= 'alert']"), "Bem vindo, Luis Henrique Petsch!");
    }
    public void timeMsgRetornoLoginEncontra(int tempo){
        page.tempoParaEncontrarElemento(tempo, By.xpath("//div[@role= 'alert']"));
    }
}
