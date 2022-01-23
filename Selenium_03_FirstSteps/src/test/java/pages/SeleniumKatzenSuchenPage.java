package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKatzenSuchenPage {

    WebDriver driver;
    WebDriverWait wait;

    public SeleniumKatzenSuchenPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "p.lead")
    private WebElement textParagraph;

    @FindBy(id = "OL4uTQhSO")
    private WebElement imgKatze1;

    @FindBy(linkText = "Next")
    private WebElement linkNext;

    @FindBy(linkText = "Previous")
    private WebElement linkPrevious;

    @FindBy(id = "anzahlSelect")
    private WebElement selectAnzahlBilder;

    @FindBy(id = "uNLsqJwB-")
    private WebElement imgKatze2;

    @FindBy(id = "sortSelect")
    private WebElement selectSortierung;

    @FindBy(id = "icoluPWB2")
    private WebElement imgKatze3;

    @FindBy(id = "h6")
    private WebElement imgKatze4;

    public String beschreibungAuslesen() {
        return textParagraph.getText();
    }

    public String srcLinkImgKatze1Auslesen() {
        return imgKatze1.getAttribute("src");
    }

    public void nextPage() {
        linkNext.click();
    }

    public void previousPage() {
        linkPrevious.click();
    }

    public void anzahlBilderEingegen(String anzahl) {
        Select selectAnzahl = new Select(selectAnzahlBilder);
        selectAnzahl.selectByVisibleText(anzahl);
    }

    public String srcLinkImgKatze2Auslesen() {
        return imgKatze2.getAttribute("src");
    }

    public void sortierungEingeben(String sortierung) {
        Select select = new Select(selectSortierung);
        select.selectByValue(sortierung);
    }

    public String srcLinkImgKatze3Auslesen() {
        return imgKatze3.getAttribute("src");
    }

    public String srcLinkImgKatze4Auslesen() {
        wait.until(ExpectedConditions.elementToBeClickable(imgKatze4));
        return imgKatze4.getAttribute("src");
    }



}



