package Pages;

import Factory.BasePage;
import org.openqa.selenium.By;

public class MenuPage {
    private static BasePage page;

    public MenuPage(){
        page = new BasePage();
    }
    public void selectComboAdicionar(){
        page.setCombo(By.xpath("//span/.."), By.xpath("//li[@class='dropdown open']//a[@href='/addConta']"));
    }
    public void selectComboListar(){
        page.setCombo(By.xpath("//span/.."), By.xpath("//li[@class='dropdown open']//a[@href='/contas']"));
    }
    public void menuCriarMovimentacao(){

    }
}
