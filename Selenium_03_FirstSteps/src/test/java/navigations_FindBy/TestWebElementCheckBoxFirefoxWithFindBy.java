package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursLoginPage;
import pages.SeleniumKursWebElementPage;
import pages.SeleniumTestAppliaktionenPage;

public class TestWebElementCheckBoxFirefoxWithFindBy {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
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
        //Login
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        //Navigation
        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.menuAusklappen();
        testAppPage.zeigeBeispieleAn();
        testAppPage.webElemtenteAnklicken();

        SeleniumKursWebElementPage webElementPage = new SeleniumKursWebElementPage(driver);

        //Act
        webElementPage.checkBox1Anklicken();
        webElementPage.checkBox1Anklicken();

        webElementPage.checkBox2Anklicken();
        webElementPage.checkBox3Anklicken();

        //Assert
        Assert.assertEquals(webElementPage.checkBox1StatusAuslesen(),false);
        Assert.assertEquals(webElementPage.checkBox2StatusAuslesen(),true);
        Assert.assertEquals(webElementPage.checkBox3StatusAuslesen(),true);




    }


}
