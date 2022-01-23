package navigations_FindBy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import pages.SeleniumKursDragAndDropPage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;

public class TestWebElementDragAndDropWithFindBy {

    WebDriver driver;

   // @BeforeEach
    //public void setUp() throws Exception {
      //  System.out.println("Initialisiere Webdriver");
        //System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        //driver.manage().window().maximize();
        //driver.get("https://seleniumkurs.codingsolo.de");
    //}

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen - räumt auf");
        //driver.close();
    }

    @Test
    public void testDragAndDrop() {

        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://seleniumkurs.codingsolo.de");

        //Arrange
        //Login and Navigation
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.menuAusklappen();
        testAppPage.zeigeBeispieleAn();
        testAppPage.dragAndDropTestAnklicken();

        //Drag And Drop
        SeleniumKursDragAndDropPage dragDropPage = new SeleniumKursDragAndDropPage(driver);

        Actions actions = new Actions(driver);

        //Act
        dragDropPage.moveWhiteLogoToBox();
        dragDropPage.moveBlueLogoToBox();

        dragDropPage.moveRedLogoToBoxWithOffSet(250,0);

        dragDropPage.moveGreenLogoToBoxManual();

        //Assert
        String erfolgsMeldung = dragDropPage.printStatusMeldung();
        Assert.assertTrue(erfolgsMeldung.contains("green-logo"));


    }
}