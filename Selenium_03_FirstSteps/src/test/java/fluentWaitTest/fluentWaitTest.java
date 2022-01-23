package fluentWaitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class fluentWaitTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Initialisiere WebDriver");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://seleniumkurs.codingsolo.de");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test abgeschlossen");
        //driver.close();
    }

    @Test
    public void testFluentWait() {
        System.out.println("Starte Test für fluent wait");

        //Arrange
        //Navigation zum Testfeld
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPAge = new SeleniumTestAppliaktionenPage(driver);
        testAppPAge.fluentWaitTestSeiteAnklicken();

        FluentWaitTestPage fluentWaitTestPage = new FluentWaitTestPage(driver);
        fluentWaitTestPage.btnStartAnklicken();

      // String status = fluentWaitTestPage.getStatusText();
      //  System.out.println(status);

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement status = driver.findElement(By.cssSelector(("#status")));
                System.out.println(status.getText());

                return null;
            }
        });

        //Assert


    }

}
