package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestForm1LoginSeleniumKursFirefox {

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

        driver.findElement(By.cssSelector("input.form-control[type=text]")).sendKeys("selenium42");
        driver.findElement(By.cssSelector("input.form-control[type=password]")).sendKeys("R5vxI0j60");
        driver.findElement(By.cssSelector("input.btn-primary")).click();
        driver.findElement(By.id("portaltab-burger-menu")).click();
        driver.findElement(By.linkText("Selenium Testapplikationen")).click();
        driver.findElement(By.linkText("Selenium Test Form1")).click();
        driver.findElement(By.id("form-widgets-betreff")).sendKeys("Automatischer Test");
        driver.findElement(By.id("form-widgets-name")).sendKeys("Tobias");

        Select selectAuswahl1 = new Select(driver.findElement(By.id("form-widgets-auswahl1")));
        selectAuswahl1.selectByVisibleText("Java Grundlagen Kurs mit Dieter");

        Select selectAuswahl2 = new Select(driver.findElement(By.id("form-widgets-auswahl2-from")));
        selectAuswahl2.selectByIndex(2);
        selectAuswahl2.selectByIndex(4);
        selectAuswahl2.selectByIndex(6);

        driver.findElement(By.name("from2toButton")).click();

        Select selectAuswahl3 = new Select(driver.findElement(By.id("form-widgets-auswahl2-to")));
        selectAuswahl3.selectByIndex(2);

        driver.findElement(By.name("upButton")).click();


        //Act

        driver.findElement(By.name("form.buttons.speichern")).click();


        //Assert

        String erfolgsMeldung = driver.findElement(By.id("message")).getText();
        Assert.assertTrue(erfolgsMeldung.contains("Hallo Tobias, Danke das du den Kurs Java Grundlagen Kurs mit Dieter besuchst!"));

        String erstesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[1]")).getText();
        String zweitesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[2]")).getText();
        String drittesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[3]")).getText();

        Assert.assertEquals(erstesElement, "Magazzini Alimentari Riuniti");
        Assert.assertEquals(zweitesElement, "Volkswagen");
        Assert.assertEquals(drittesElement, "Ernst Handel");


    }


}
