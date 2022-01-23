package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestIFrameSeleniumKursFirefox {

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
        WebElement inputUsername =  driver.findElement(By.cssSelector("input.form-control[type=text]"));
        inputUsername.sendKeys("selenium42");
        WebElement inputPassword =  driver.findElement(By.cssSelector("input.form-control[type=password]"));
        inputPassword.sendKeys("R5vxI0j60");
        WebElement loginButton = driver.findElement(By.cssSelector("input.btn-primary[type=submit]"));
        loginButton.click();

        //Navigation
        WebElement burgerMenue = driver.findElement(By.id("portaltab-burger-menu"));
        burgerMenue.click();

        WebElement showTestapplications = driver.findElement(By.linkText("Selenium Testapplikationen"));
        showTestapplications.click();

        WebElement linkWebElement = driver.findElement(By.linkText("IFrame Beispiel"));
        linkWebElement.click();

        driver.switchTo().frame("iframe");

        WebElement inputName = driver.findElement(By.id("name"));
        WebElement btnAlert = driver.findElement(By.id("alertbtn"));

        //Act

        inputName.sendKeys("Tobias");
        btnAlert.click();

        //Assert

        Assert.assertTrue(driver.switchTo().alert().getText().contains("42"));

        driver.switchTo().alert().accept();


    }


}
