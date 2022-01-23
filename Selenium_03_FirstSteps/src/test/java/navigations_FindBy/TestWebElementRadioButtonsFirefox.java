package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebElementRadioButtonsFirefox {

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

        WebElement showWebElements = driver.findElement(By.linkText("Web Elemente"));
        showWebElements.click();

        WebElement radioButton1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='radio3']"));

        //Act

        radioButton1.click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input:checked")).getAttribute("value"), "radio1");

        radioButton2.click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input:checked")).getAttribute("value"), "radio2");

        radioButton3.click();

        Assert.assertEquals(driver.findElement(By.cssSelector("input:checked")).getAttribute("value"), "radio3");



    }


}
