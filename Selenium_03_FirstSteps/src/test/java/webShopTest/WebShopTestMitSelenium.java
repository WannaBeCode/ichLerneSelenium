package webShopTest;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.SeleniumKursHomePage;
import pages.SeleniumKursLoginPage;
import pages.SeleniumTestAppliaktionenPage;

import java.util.concurrent.TimeUnit;

public class WebShopTestMitSelenium {

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
    public void testWebshop() {
        System.out.println("Starte Test für den WebShop");

        //Arrange
        SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
        loginPage.zugangsDatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonanklicken();

        SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumTestAppliaktionenPage testAppPage = new SeleniumTestAppliaktionenPage(driver);
        testAppPage.webShopTestSeiteAnklicken();

        SeleniumTestWebShopPage webShopPage = new SeleniumTestWebShopPage(driver);
        SeleniumWebShopKassePage webShopKassaPage = new SeleniumWebShopKassePage(driver);
        SeleniumWebShopAGBPage agbPage = new SeleniumWebShopAGBPage(driver);

        //Act

        webShopPage.triggerSearch("Brems");

        webShopPage.incrementProduct("Bremssattel Hinten Audi", 4);
        webShopPage.addProductToShoppingCart("Bremssattel Hinten Audi");

        webShopPage.incrementProduct("Bremsscheiben Set Vorne Audi", 2);
        webShopPage.addProductToShoppingCart("Bremsscheiben Set Vorne Audi");

        String price1 = webShopPage.readPrice();

        webShopPage.clickShoppingCart();

        webShopPage.clickCheckOutBtn();

        webShopKassaPage.promoCodeEingeben("codingsolo");
        webShopKassaPage.btnPromoCodeAktivierenAnklicken();

        String promoInfo = webShopKassaPage.promoInfoAuslesen();

        String price2 = webShopKassaPage.preisAuslesen();

        webShopKassaPage.bestellungAnklicken();

        agbPage.landAuswaehlen("Germany");

        agbPage.akzeptierenAGB();

        agbPage.clickWeiter();

        String danke = driver.findElement(By.className("wrapperTwo")).getText();

        //Assert

        Assert.assertEquals(price1, "760.58");

        Assert.assertTrue(promoInfo.contains("aktiviert"));

        Assert.assertEquals(price2, "684");

        Assert.assertTrue(danke.contains("Vielen Dank"));


      //  preis1 == 760.58
      //  preis2 ==  684





    }
}
