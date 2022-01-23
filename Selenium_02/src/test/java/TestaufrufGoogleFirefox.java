import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestaufrufGoogleFirefox {

    WebDriver driver;

    @Before
    public void initTests() {
        System.out.println("starte Webdriver");
        System.setProperty("webdriver.gecko.driver",
                "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
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
        String expect = "Google";
        Assert.assertEquals(expect, driver.getTitle());
    }

}
