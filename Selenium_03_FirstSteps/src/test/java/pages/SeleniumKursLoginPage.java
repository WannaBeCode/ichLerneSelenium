package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {

    private WebDriver driver;



    public SeleniumKursLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void zugangsDatenEingeben(String benutzerName, String passwort) {
        this.driver.findElement(inputBenutzername).sendKeys(benutzerName);
        this.driver.findElement(inputPasswort).sendKeys(passwort);
    }

    //Eingabefeld Benutzername;
    private By inputBenutzername = By.cssSelector("input.form-control[type=text]");
    //Eingabefeld Passwort
    private By inputPasswort = By.cssSelector("input.form-control[type=password]");
    //Button fuer die Anmeldung
    private By btnAnmeldung = By.cssSelector("input.btn-primary");
    //Statusmeldung
    private By result = By.cssSelector("div.portalMessage:nth-child(1)");

    public void loginButtonanklicken() {
        this.driver.findElement(btnAnmeldung).click();
    }

    public String statusMeldungAuslesen() {
        return this.driver.findElement(result).getText();
    }




}
