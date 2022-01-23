package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTestAppliaktionenPage {

    WebDriver driver;

    //Menuebutton
    @FindBy(id = "portaltab-burger-menu")
    private WebElement btnMenue;

    @FindBy(linkText = "Selenium Testapplikationen")
    private WebElement zeigeBeispiele;

    //Link Testform 1
    @FindBy(linkText = "Selenium Test Form1")
    private WebElement linkTestForm1;

    //Link WebShop Testseite
    @FindBy(linkText = "Webshop Testseite")
    private WebElement linkWebshopTestseite;

    //Link Drag and Drop Beispiel
    @FindBy(linkText = "Drag and Drop Beispiel")
    private WebElement linkDragAndDrop;

    //Link IFrameTest
    @FindBy(linkText = "IFrame Beispiel")
    private WebElement linkIFrameTest;

    //Link WebElemnte
    @FindBy (linkText = "Web Elemente")
    private WebElement linkWebElemente;

    //Link Katzensuche Testseite
    @FindBy(linkText = "Katzensuche Testseite (AJAX)")
    private WebElement linkKatzenSuche;

    //Link Fluent Wait TestSeite
    @FindBy(linkText = "Fluent Wait Testseite")
    private WebElement linkFluentWaitTestSeite;

    //Link Testform3 DataDriven
    @FindBy(linkText = "Testform3 DataDriven")
    private WebElement linkTestform3DataDriven;



    public SeleniumTestAppliaktionenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void menuAusklappen() {
        btnMenue.click();
    }

    public void testForm1Anklicken() {
        linkTestForm1.click();
    }

    public void dragAndDropTestAnklicken() {
        linkDragAndDrop.click();
    }

    public void iframeTestAnklicken() {
        linkIFrameTest.click();
    }

    public void webElemtenteAnklicken() {
        linkWebElemente.click();
    }

    public void zeigeBeispieleAn() {
        zeigeBeispiele.click();
    }

    public void katzenSucheAnklicken() {
        linkKatzenSuche.click();
    }

    public void webShopTestSeiteAnklicken() {
        linkWebshopTestseite.click();
    }

    public void fluentWaitTestSeiteAnklicken() {
        linkFluentWaitTestSeite.click();
    }

    public void testform3DataDrivenAnklicken() {
        linkTestform3DataDriven.click();
    }


}
