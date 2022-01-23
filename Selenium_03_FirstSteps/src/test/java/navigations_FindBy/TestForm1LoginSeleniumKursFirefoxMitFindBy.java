package navigations_FindBy;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;
import pages.SeleniumTestForm1Page;

public class TestForm1LoginSeleniumKursFirefoxMitFindBy {

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
        //Arrange

        //Login
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        //Navigation zum Formular
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.testForm1Anklicken();


        //Starte Formular
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);
        testForm1Page.betreffEingeben("Automatischer Test");
        testForm1Page.namenEingeben("Tobias");

        testForm1Page. kursAuswaehlen("Java Grundlagen Kurs mit Dieter");

        testForm1Page.firmaInBox1Auswaehlen(new int[] {2,4,6});
        testForm1Page.firmenUebernehmen();
        testForm1Page.firmaInBox2Auswaehlen(new int[] {2});
        testForm1Page.ausgewaehlteFrimaVerschieben();

        //Act
        testForm1Page.formularSpeichern();

        //Assert
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        Assert.assertTrue(erfolgsMeldung.contains("Java Grundlagen Kurs mit Dieter"));

        String erstesElement = testForm1Page.erstesListenElementAuslesen();
        Assert.assertEquals(erstesElement, "Magazzini Alimentari Riuniti");



    }
}