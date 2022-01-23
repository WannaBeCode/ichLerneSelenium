package asynchroneWebzugriffe;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import pages.SeleniumKatzenSuchenPage;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;

import java.util.concurrent.TimeUnit;

public class ImpliziertesWartenMitKatzenSuche {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://seleniumkurs.codingsolo.de");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen - räumt auf");
        //driver.close();

    }

    @Test
    public void testImplizitWait() throws InterruptedException {
        //Arange
        //Navigation
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.katzenSucheAnklicken();

        SeleniumKatzenSuchenPage katzenPage = new SeleniumKatzenSuchenPage(driver);
        String beschreibung = katzenPage.beschreibungAuslesen();
        String srcLinkKatze1 = katzenPage.srcLinkImgKatze1Auslesen();
        katzenPage.nextPage();
        katzenPage.anzahlBilderEingegen("6");
        String sourceLinkKatze2 = katzenPage.srcLinkImgKatze2Auslesen();

        //Act


        //Assert
        Assert.assertTrue(beschreibung.contains("Lieblingskatze"));
        Assert.assertTrue(srcLinkKatze1.contains("OL4uTQhSO"));
        Assert.assertTrue(sourceLinkKatze2.contains("uNLsqJwB-"));


    }

}
