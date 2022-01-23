package dataDrivenTests;

import configuration.Config;
import configuration.DriverHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumKursTestForm3Page;
import pages.SeleniumTestAppliaktionenPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestForm3ParameterizedFirefox {

    WebDriver driver;

    String browsername;
    String username;
    String password;
    String bezeichnungVersicherung;
    String kennungVersicherung;
    String anschriftVersicherung;
    String strasseVersicherung;
    String telefonVersicherung;
    String plzVersicherung;
    String ortVersicherung;
    String auswahl1;
    String nameKunde;
    String vorNameKunde;
    String geburtsDatumKunde;
    String telefonKunde;
    String strasseKunde;
    String plzKunde;
    String ortKunde;
    String assert1;
    String assert2;

    public TestForm3ParameterizedFirefox(String testName, String browsername, String username, String password, String bezeichnungVersicherung, String kennungVersicherung, String anschriftVersicherung, String strasseVersicherung, String telefonVersicherung, String plzVersicherung, String ortVersicherung, String auswahl1, String nameKunde, String vorNameKunde, String geburtsDatumKunde,
                                         String telefonKunde, String strasseKunde, String plzKunde, String ortKunde, String assert1, String assert2 ) {
        this.browsername = browsername;
        this.username = username;
        this.password = password;
        this.bezeichnungVersicherung = bezeichnungVersicherung;
        this.kennungVersicherung = kennungVersicherung;
        this.anschriftVersicherung = anschriftVersicherung;
        this.strasseVersicherung = strasseVersicherung;
        this.telefonVersicherung = telefonVersicherung;
        this.plzVersicherung = plzVersicherung;
        this.ortVersicherung = ortVersicherung;
        this.auswahl1 = auswahl1;
        this.nameKunde = nameKunde;
        this.vorNameKunde = vorNameKunde;
        this.geburtsDatumKunde = geburtsDatumKunde;
        this.telefonKunde = telefonKunde;
        this.strasseKunde = strasseKunde;
        this.plzKunde = plzKunde;
        this.ortKunde = ortKunde;
        this.assert1 = assert1;
        this.assert2 = assert2;
    }

    @Before
    public void setUp() {
        System.out.println("Initialisiere Webdriver");
        driver = DriverHelper.getDriver(browsername);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(Config.getBaseURL());
    }

    @After
    public void tearDown() {
        System.out.println("Test abgeschlossen");
        driver.close();
    }

    @Test
    public void testForm3() {

        //Arrange
        //Login
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben(username,password);
        loginPage.loginButtonanklicken();

        //Navigation zum Formular
        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.testform3DataDrivenAnklicken();

        SeleniumKursTestForm3Page testForm3Page = new SeleniumKursTestForm3Page(driver);

        //Starte Formular
        //Act

        testForm3Page.versicherungBezeichnungEingeben(bezeichnungVersicherung);
        testForm3Page.versicherungKennungEingeben(kennungVersicherung);
        testForm3Page.anschriftVersicherungEingeben(anschriftVersicherung);
        testForm3Page.versicherungStrasseEingeben(strasseVersicherung);
        testForm3Page.versicherungTelefonEingeben(telefonVersicherung);
        testForm3Page.versicherungPlzEingeben(plzVersicherung);
        testForm3Page.versicherungOrtEingeben(ortVersicherung);

        testForm3Page.versicherungAuswahlEingeben(auswahl1);

        testForm3Page.kundenNamenEingeben(nameKunde);
        testForm3Page.kundenVorNamenEingeben(vorNameKunde);
        testForm3Page.kundenGeburtsDatumEingeben(geburtsDatumKunde);
        testForm3Page.kundenStrasseEingeben(strasseKunde);
        testForm3Page.kundenTelefonEingeben(telefonKunde);
        testForm3Page.kundenPlzEingeben(plzKunde);
        testForm3Page.kundenOrtEingeben(ortKunde);

        testForm3Page.btnSpeichernAnklicken();

        //Assert

        Assert.assertTrue(testForm3Page.textStatus1Auslesen().contains(assert1));
        Assert.assertEquals(testForm3Page.textStatus2Auslesen(), assert2);



    }
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> provideTestData() throws Exception {
        Collection<Object[]> collection;

        Object[][] daten = {{
                "Test TestForm3 Testfall 1 Firefox", "firefox", "selenium42", "R5vxI0j60", "Fragenbogen 42",
                "9288282", "AOK Hamburg", "2131233", "Landwehr 23", "22119", "Hamburg", "Selbststaendiger", "Blomberg", "Hans", "02.04.1967",
                "12312312", "Reeperbahn 222", "20537", "Hamburg", "Blomberg", "Fragenbogen 42"

        },
                {
                        "Test TestForm3 Testfall 2 Chrome", "chrome", "selenium42", "R5vxI0j60", "Fragenbogen 42",
                        "9288282", "AOK Hamburg", "2131233", "Landwehr 23","22119", "Hamburg", "Selbststaendiger", "Blomberg", "Hans", "02.04.1967",
                        "12312312", "Reeperbahn 222", "20537", "Hamburg", "Blomberg", "Fragenbogen 42"
                }
        };
        List<Object[]> listObjects = Arrays.asList(daten);
        collection = new ArrayList<Object[]>(listObjects);

        return collection;
    }



}
