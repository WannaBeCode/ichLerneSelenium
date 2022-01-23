package webShopTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestWebShopPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumTestWebShopPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@placeholder,Hier)]")
    private WebElement searchKeyWord;

    @FindBy(xpath = "//*[text() = 'Bremssattel Hinten Audi']/..//*[@class='increment']")
    private WebElement incrementProductBremssattelAudi;

    @FindBy(xpath = "//*[text() = 'Bremsscheiben Set Vorne Audi']/..//*[@class = 'increment']")
    private WebElement incrementProductBremsscheibenSetVorneAudi;

    @FindBy(xpath = "//tbody/tr[last()]//strong")
    private WebElement textPreis;

    @FindBy(css = ".cart-icon")
    private WebElement btnShoppingCart;

    @FindBy(css = "div.cart-preview > div.action-block > button")
    private WebElement btnCheckOut;

    public void triggerSearch(String productName) {
        searchKeyWord.sendKeys(productName);
    }

    public void incrementProduct(String name, int number) {
       WebElement btnPlus =  driver.findElement(By.xpath(String.format("//*[text() = '%s']/..//*[@class='increment']",name)));
       for(int i = 0; i < number - 1; i++) {
           btnPlus.click();
       }
    }

    public void addProductToShoppingCart(String name) {
        WebElement btnAddToShoppingCart = driver.findElement(By.xpath(String.format("//*[text() = '%s']/..//button",name)));
        btnAddToShoppingCart.click();
    }

    public String readPrice() {
        return textPreis.getText();
    }

    public void clickShoppingCart() {
        btnShoppingCart.click();
    }

    public void clickCheckOutBtn() {
        btnCheckOut.click();
    }










}
