package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLoginFehlgeschlagenSeleniumKursFirefox {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://seleniumkurs.codingsolo.de");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen - räumt auf");
        //driver.close();

    }

    @Test
    public void testLogin() {
        System.out.println("Starte Test Login mit Fehlschlag");

        //Arrange

        driver.findElement(By.id("__ac_name")).sendKeys("Benutzer");
        driver.findElement(By.name("__ac_password")).sendKeys("test");

        //Act

        driver.findElement(By.xpath("//input[@value='Anmelden']")).click();

        //Assert

        String fehlerMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
        Assert.assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));

    }


}
