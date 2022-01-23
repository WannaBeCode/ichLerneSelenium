package asynchroneWebzugriffe;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SeleniumKatzenSuchenPage;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;

import java.util.concurrent.TimeUnit;

public class ExplizietesWartenMitKatzenSuche {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
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

        //ACT
        String srcLinkKatzenImg1 = katzenPage.srcLinkImgKatze1Auslesen();

        katzenPage.nextPage();
        String srcLinkKatzenImg3 = katzenPage.srcLinkImgKatze3Auslesen();

        katzenPage.sortierungEingeben("Asc");

        String srcKatzenImg4 = katzenPage.srcLinkImgKatze4Auslesen();


        //Assert
        Assert.assertTrue(srcLinkKatzenImg1.contains("OL4uTQhSO"));
        Assert.assertTrue(srcLinkKatzenImg3.contains("icoluPWB2"));
        Assert.assertTrue(srcKatzenImg4.contains("h6"));



    }
}