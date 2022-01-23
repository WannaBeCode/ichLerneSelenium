package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumKursWebElementPage;
import pages.SeleniumTestAppliaktionenPage;

public class TestWebElementRadioButtonsFirefoxWithFindBY {

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
    public void testRadioButtonsWithFindBy() {

        //Arrange
        //Login
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        //Navigation
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.webElemtenteAnklicken();

        SeleniumKursWebElementPage webElementPage = new SeleniumKursWebElementPage(driver);

        //Act

        webElementPage.radioButton1Anklicken();
        Assert.assertEquals(webElementPage.radioButton1getAttribute("value"), "radio1");

        webElementPage.radioButton2Anklicken();
        Assert.assertEquals(webElementPage.radioButton2getAttribute("value"), "radio2");

        webElementPage.radioButton3Anklicken();
        Assert.assertEquals(webElementPage.radioButton3getAttribute("value"), "radio3");









    }


}
