package Factory;

import Pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import static Factory.DriveFactory.getDriver;
import static Factory.DriveFactory.killDriver;

public class BaseTest {
    private static LoginPage page;

    @Rule
    public TestName testName = new TestName();
    @Before
    public void inicializa() throws InterruptedException {
        getDriver().get("https://seubarriga.wcaquino.me/login");
        page = new LoginPage();
        page.setUserName("luis_hp66@hotmail.com");
        page.setPassword("apito123");
        page.clickEntrar();
        page.timeMsgRetornoLoginEncontra(10);
        page.msgRetornoLogin();
    }
    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot)getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "Screenshot" + File.separator +
                testName.getMethodName() + ".jpg"));

        if(Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
}
