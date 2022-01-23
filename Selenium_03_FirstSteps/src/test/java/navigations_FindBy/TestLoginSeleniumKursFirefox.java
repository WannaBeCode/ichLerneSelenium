package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLoginSeleniumKursFirefox {

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

        driver.findElement(By.cssSelector("input.form-control[type=text]")).sendKeys("selenium42");
        driver.findElement(By.cssSelector("input.form-control[type=password]")).sendKeys("R5vxI0j60");

        //Act

        driver.findElement(By.cssSelector("input.btn-primary")).click();

        //Assert

        String erfolgsMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
        Assert.assertTrue(erfolgsMeldung.contains("Willkommen"));

    }


}
