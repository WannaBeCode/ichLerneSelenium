package parametrisierteTests;

import org.junit.Assert;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;
import pages.SeleniumTestForm1Page;
import configuration.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestForm1Parameterized {

    WebDriver driver;

    String browsername;
    String browserdriver;
   String username;
   String password;
   String betreff;
   String name;
   String kursTitel;
   int[] firmenBox1;
   int[] firmenBox2;
   String assert1;
   String assert2;

    public TestForm1Parameterized(String testName,String browsername, String username, String password, String betreff, String name, String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {
        this.username = username;
        this.browsername = browsername;
        this.password = password;
        this.betreff = betreff;
        this.name = name;
        this.kursTitel = kursTitel;
        this.firmenBox1 = firmenBox1;
        this.firmenBox2 = firmenBox2;
        this.assert1 = assert1;
        this.assert2 = assert2;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");
        driver = DriverHelper.getDriver(browsername);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Config.getBaseURL());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen - räumt auf");
        //driver.close();

    }

   @Test
    public void testLogin() {
        //Arrange

        //Login
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben(username, password);
        loginPage.loginButtonanklicken();

        //Navigation zum Formular
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.testForm1Anklicken();


        //Starte Formular
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);
        testForm1Page.betreffEingeben(betreff);
        testForm1Page.namenEingeben(name);

        testForm1Page. kursAuswaehlen(kursTitel);

        testForm1Page.firmaInBox1Auswaehlen(firmenBox1);
        testForm1Page.firmenUebernehmen();
        testForm1Page.firmaInBox2Auswaehlen(firmenBox2);
        testForm1Page.ausgewaehlteFrimaVerschieben();

        //Act
        testForm1Page.formularSpeichern();

        //Assert
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        Assert.assertTrue(erfolgsMeldung.contains(assert1));

        String erstesElement = testForm1Page.erstesListenElementAuslesen();
        Assert.assertEquals(erstesElement, assert2);



    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> provideTestData() throws Exception {

        Collection<Object[]> collection;

        Object[][] daten = {
                {"Test Form 1 Test 1 FireFox","firefox", "selenium42", "R5vxI0j60", "Parametrisierter Test 1", "Tobias", "Java Grundlagen Kurs mit Dieter",
                        new int[] {2,4,6}, new int[] {2}, "Java Grundlagen Kurs mit Dieter", "Magazzini Alimentari Riuniti" },
                {"Test Form 1 Test 2 chrome", "chrome",  "selenium42", "R5vxI0j60", "Parametrisierter Test 2", "Dieter", "Python Grundlagen Kurs mit Dieter",
                        new int[] {2,4,6}, new int[] {2}, "Python Grundlagen Kurs mit Dieter", "Magazzini Alimentari Riuniti" }

        };

        List<Object[]> listObjects = Arrays.asList(daten);
        collection = new ArrayList<Object[]>(listObjects);

        return collection;

    }

}