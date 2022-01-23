package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPageMitFindBy {

    private WebDriver driver;

    //Eingabefeld Benutzername
    @FindBy(css = "input.form-control[type=text]")
    private WebElement inputBenutzername;

    //Eingabefeld Passwort
    @FindBy(css = "input.form-control[type=password]")
    private WebElement inputPasswort;

    //Button fuer die Anmeldung
    @FindBy(css = "input.btn-primary" )
    private WebElement loginButton;

    //Statusmeldung
    @FindBy(css = "div.portalMessage:nth-child(1)" )
    private WebElement result;

    public SeleniumKursLoginPageMitFindBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void zugangsDatenEingeben(String benutzerName, String passwort) {
        inputBenutzername.sendKeys(benutzerName);
        inputPasswort.sendKeys(passwort);
    }

    public void loginButtonanklicken() {
        loginButton.click();
    }

    public String statusMeldungAuslesen() {
        return result.getText();
    }




}





