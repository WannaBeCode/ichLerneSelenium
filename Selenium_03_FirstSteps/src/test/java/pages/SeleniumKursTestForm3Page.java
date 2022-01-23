package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumKursTestForm3Page {

    WebDriver driver;

    @FindBy(id = "form-widgets-bezeichnung")
    private WebElement bezeichnung;

    @FindBy(id = "form-widgets-kennung")
    private WebElement kennungVersicherung;

    @FindBy(id = "form-widgets-anschrift")
    private WebElement anschriftVersicherung;

    @FindBy(id = "form-widgets-telefon")
    private WebElement telefonVersicherung;

    @FindBy(id = "form-widgets-str")
    private WebElement strasseVersicherung;

    @FindBy(id = "form-widgets-plz")
    private WebElement plzVersicherung;

    @FindBy(id = "form-widgets-ort")
    private WebElement ortVersicherung;

    @FindBy(id = "form-widgets-auswahl1")
    private WebElement selectAuswahl;

    @FindBy(id = "form-widgets-name")
    private WebElement nameKunde;

    @FindBy(id = "form-widgets-vorname" )
    private WebElement vorNameKunde;

    @FindBy(id = "form-widgets-geburt")
    private WebElement geburtsDatumKunde;

    @FindBy(id = "form-widgets-telefonv")
    private WebElement telefonKunde;

    @FindBy(id = "form-widgets-strv")
    private WebElement strasseKunde;

    @FindBy(id = "form-widgets-plzv")
    private WebElement plzKunde;

    @FindBy(id = "form-widgets-ortv")
    private WebElement ortKunde;

    @FindBy(css = "input[value='Speichern']")
    private WebElement btnSpeichern;

    @FindBy(id = "message")
    private WebElement textStatus1;

    @FindBy(xpath = "//*[@id='auswahl']//li[1]" )
    private WebElement textStatus2;

    public SeleniumKursTestForm3Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void versicherungBezeichnungEingeben(String bezeichnung) {
        this.bezeichnung.sendKeys(bezeichnung);
    }

    public void versicherungKennungEingeben(String kennung) {
        this.kennungVersicherung.sendKeys(kennung);
    }

    public void anschriftVersicherungEingeben(String anschrift) {
        this.anschriftVersicherung.sendKeys(anschrift);
    }

    public void versicherungTelefonEingeben(String telefon) {
        this.telefonVersicherung.sendKeys(telefon);
    }

    public void versicherungStrasseEingeben(String strasse) {
        this.strasseVersicherung.sendKeys(strasse);
    }

    public void versicherungPlzEingeben(String plz) {
        this.plzVersicherung.sendKeys(plz);
    }

    public void versicherungOrtEingeben(String ort) {
        this.ortVersicherung.sendKeys(ort);
    }

    public void versicherungAuswahlEingeben(String auswahl) {
        Select auswahl1 = new Select(selectAuswahl);
        auswahl1.selectByValue(auswahl);
    }

    public void kundenNamenEingeben(String name) {
        this.nameKunde.sendKeys(name);
    }

    public void kundenVorNamenEingeben(String vorName) {
        this.vorNameKunde.sendKeys(vorName);
    }

    public void kundenGeburtsDatumEingeben(String geburtsDatum) {
        this.geburtsDatumKunde.sendKeys(geburtsDatum);
    }

    public void kundenTelefonEingeben(String telefon) {
        this.telefonKunde.sendKeys(telefon);
    }

    public void kundenStrasseEingeben(String strasse) {
        this.strasseKunde.sendKeys(strasse);
    }

    public void kundenPlzEingeben(String plz) {
        this.plzKunde.sendKeys(plz);
    }

    public void kundenOrtEingeben(String ort) {
        this.ortKunde.sendKeys(ort);
    }

    public void btnSpeichernAnklicken() {
        btnSpeichern.click();
    }

    public String textStatus1Auslesen() {
        return textStatus1.getText();
    }

    public String textStatus2Auslesen() {
        return textStatus2.getText();
    }



}
