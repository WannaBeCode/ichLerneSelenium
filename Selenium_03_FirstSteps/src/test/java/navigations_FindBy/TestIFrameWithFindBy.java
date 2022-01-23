package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursIFramePage;
import pages.SeleniumKursLoginPage;

public class TestIFrameWithFindBy {
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
    public void testeIFrame() {
        //Arrange
       SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
       loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
       loginPage.loginButtonanklicken();

       WebElement burgerMenue = driver.findElement(By.id("portaltab-burger-menu"));
       burgerMenue.click();

       WebElement showTestapplications = driver.findElement(By.linkText("Selenium Testapplikationen"));
       showTestapplications.click();

       WebElement goToIFrame = driver.findElement(By.linkText("IFrame Beispiel"));
       goToIFrame.click();

       SeleniumKursIFramePage iframePage = new SeleniumKursIFramePage(driver);
       iframePage.wechsleZuIFrame();

       //Act
       iframePage.namenEingeben("Tobias");
       iframePage.alarmKnopfAnklicken();

       //Assert

       Assert.assertTrue(iframePage.alarmNachrichtAuslesen().contains("Tobias"));

       iframePage.alarmNachrichtSchliessen();

   }

}
