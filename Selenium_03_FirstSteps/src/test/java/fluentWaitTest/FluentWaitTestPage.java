package fluentWaitTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitTestPage {

    WebDriver driver;
    WebDriverWait wait;

    public FluentWaitTestPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".btn.btn-primary")
    private WebElement btnStart;

    @FindBy(id="status")
    private WebElement stautsNachricht;

    public void btnStartAnklicken() {
        btnStart.click();
    }

    public String getStatusText() {
        return stautsNachricht.getText();

    }


}
