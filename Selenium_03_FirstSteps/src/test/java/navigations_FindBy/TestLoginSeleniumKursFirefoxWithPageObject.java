package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursLoginPageMitFindBy;

public class TestLoginSeleniumKursFirefoxWithPageObject {

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
        System.out.println("Starte Test Login ");

        //Arrange

        SeleniumKursLoginPageMitFindBy loginPage = new SeleniumKursLoginPageMitFindBy(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");

        //Act

        loginPage.loginButtonanklicken();

        //Assert

        String erfolgsMeldung = loginPage.statusMeldungAuslesen();
        Assert.assertTrue(erfolgsMeldung.contains("Willkommen"));

    }


}
