package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursHomePage {

    WebDriver driver;

    //Statusmeldung
    @FindBy(css = "div.portalMessage:nth-child(1)")
    private WebElement statusMeldung;

    //Menuebutton
    @FindBy(id = "portaltab-burger-menu")
    private WebElement btnMenue;

    //Links aus dem Seitenmenu
    @FindBy(linkText = "Selenium Testapplikationen")
    private WebElement linksSideMenuSeleniumTestApp;

    public SeleniumKursHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String statusMeldungAuslesen() {
        return statusMeldung.getText();
    }

    public void menuAusklappen() {
        btnMenue.click();
    }

    public void seleniumTestAppLinkAnklicken() {
        linksSideMenuSeleniumTestApp.click();
    }
}
