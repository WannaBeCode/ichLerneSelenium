package webShopTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebShopAGBPage {
    WebDriver driver;
    WebDriverWait wait;

    public SeleniumWebShopAGBPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div > select")
    private WebElement selectLand;

    @FindBy(className = "chkAgree")
    private WebElement checkAGBAkzeptieren;

    @FindBy(css = "div > button")
    private WebElement btnWeiter;

    public void landAuswaehlen(String land) {
        Select landAuswahl = new Select(selectLand);
        landAuswahl.selectByValue(land);
    }

    public void akzeptierenAGB() {
        checkAGBAkzeptieren.click();
    }

    public void clickWeiter() {
        btnWeiter.click();
    }


    }

