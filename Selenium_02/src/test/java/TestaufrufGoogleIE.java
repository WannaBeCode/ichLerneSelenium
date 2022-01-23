import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestaufrufGoogleIE {

    WebDriver driver;

    @Before
    public void initTests() {
        System.out.println("starte Webdriver");
        System.setProperty("webdriver.ie.driver",
                "./drivers/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.get("https://google.com");
    }

    @After
    public void afterTest() {
        System.out.println("Test abgeschlossen - ich räume auf");
        driver.close();
    }

    @Test
    public void testTitel() {
        System.out.println("Starte Test: Vergleiche Titel");
        String expect = "Diese Website funktioniert in Microsoft Edge besser";
        Assert.assertEquals(expect, driver.getTitle());
    }

}
