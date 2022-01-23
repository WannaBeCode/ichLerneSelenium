package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestForm1Page {

    WebDriver driver ;

    @FindBy(tagName = "h1")
    private WebElement testFormHeadline;

    @FindBy(id = "form-widgets-betreff")
    private WebElement inputBetreff;

    @FindBy(id = "form-widgets-name")
    private WebElement inputName;

    @FindBy(id = "form-widgets-auswahl1")
    private WebElement selectKurs;

    @FindBy(id = "form-widgets-auswahl2-from")
    private WebElement selectFirmaBox1;

    @FindBy(name = "from2toButton")
    private WebElement btnAuswahlFirmaBox1;

    @FindBy(id = "form-widgets-auswahl2-to")
    private WebElement selectFirmabox2;

    @FindBy(name = "upButton")
    private WebElement btnAuswahlObenBox2;

    @FindBy(name = "form.buttons.speichern")
    private WebElement btnSpeichern;

    @FindBy(id = "message")
    private WebElement stautsMeldung;

    @FindBy(xpath = "//ul[@id='companies']/li[1]")
    private WebElement textErstesElementListeFirma;

    public SeleniumTestForm1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void betreffEingeben(String betreff) {
        inputBetreff.sendKeys(betreff);
    }

    public void namenEingeben(String name) {
        inputName.sendKeys(name);
    }

    public void kursAuswaehlen(String kursName) {
        Select selectKurs = new Select(this.selectKurs);
        selectKurs.selectByVisibleText(kursName);
    }

    public void firmaInBox1Auswaehlen(int[] auswahl) {
        Select selectFirma = new Select(this.selectFirmaBox1);
        for (int i : auswahl) {
            selectFirma.selectByIndex(i);
        }
    }

    public void firmenUebernehmen() {
        btnAuswahlFirmaBox1.click();
    }

    public void firmaInBox2Auswaehlen(int[] auswahl) {
        Select selectFirma = new Select(this.selectFirmaBox1);
        for (int i : auswahl) {
            selectFirma.selectByIndex(i);
        }
    }

    public void ausgewaehlteFrimaVerschieben() {
        btnAuswahlObenBox2.click();
    }

    public void formularSpeichern() {
        btnSpeichern.click();
    }

    public String statusMeldungAuslesen() {
        return stautsMeldung.getText();
    }

    public String erstesListenElementAuslesen() {
        return textErstesElementListeFirma.getText();
    }

    public String readHeadline() {
        return testFormHeadline.getText();
    }

}
