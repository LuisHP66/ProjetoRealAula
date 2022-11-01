package Factory;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static Factory.DriveFactory.getDriver;

public class BasePage {
    public void escreve(By by,String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }
    public String valorCampo(String id_campo){
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }
    public void clicarRadio(By by){
        getDriver().findElement(by).click();
    }
    public void clicarRadio(String id){
        getDriver().findElement(By.id(id));
    }
    public boolean radioMarcadoVerifica(String id_campo){
        return getDriver().findElement(By.id(id_campo)).isSelected();
    }
    public void selecaoCombo(String id_campo, String texto){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.selectByVisibleText(texto);
    }
    public void selecaoComboXpath(String xpath){
        getDriver().findElement(By.xpath(xpath)).click();
    }
    public String obterValorCombo(String id_campo){
        WebElement element = getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }
    public void clicaBotao(By by){
        getDriver().findElement(by).click();
    }
    public void clicaLink(String id_campo){
        getDriver().findElement(By.linkText(id_campo)).click();
    }
    public void tempoParaEncontrarElemento(int tempo, By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void validaTexto(By by, String textoEsperado){
        String texto = getDriver().findElement(by).getText();
        Assert.assertEquals(textoEsperado, texto);
    }
    public String alertaObterTextoAcept(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }
    public String alertaObterTextoDimiss(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
    }
    public String obterTextoDigitaAcept(String texto){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.sendKeys(texto);
        alert.accept();
        return valor;
    }
    public String obterTextoDigitaDimiss(String texto){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.sendKeys(texto);
        alert.dismiss();
        return valor;
    }
    public void clicarButtonTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //Procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
        int idColuna = obterIndiceColuna(colunaBusca, tabela);

        //Procurar a linha do registro
        int idLinha = obterIndiceLinha(valor, tabela, idColuna);

        //Procurar a coluna do botão
        int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);

        //Clicar no botão
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        celula.findElement(By.xpath(".//input")).click();
    }

    protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for (int i = 0; i < linhas.size(); i++) {
            if (linhas.get(i).getText().equals(valor)) {
                idLinha = i + 1;
                break;
            }
        }
        return idLinha;
    }
    protected int obterIndiceColuna(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++){
            if (colunas.get(i).getText().equals(coluna)){
                idColuna = i + 1;
                break;
            }
        }
        return idColuna;
    }
}
