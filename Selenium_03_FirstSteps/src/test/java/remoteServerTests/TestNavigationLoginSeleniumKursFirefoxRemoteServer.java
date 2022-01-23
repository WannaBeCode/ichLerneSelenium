package remoteServerTests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;
import pages.SeleniumTestForm1Page;

import java.net.URL;

public class TestNavigationLoginSeleniumKursFirefoxRemoteServer {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        //System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        //driver = new FirefoxDriver();

        URL remoteWebDriver = new URL(("http://192.168.0.220:4444/wd/hub"));

        DesiredCapabilities desiredCapabilitiesFirefox = new DesiredCapabilities();
        desiredCapabilitiesFirefox.setBrowserName("firefox");

        driver = new RemoteWebDriver(remoteWebDriver, desiredCapabilitiesFirefox );
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

        //Arrange
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        //Act
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();

        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.testForm1Anklicken();

        //Assert
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);

        String erfolgsMeldung = testForm1Page.readHeadline();
        Assert.assertEquals(erfolgsMeldung, "Selenium Test Form1");



    }


}
