package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursWebElementPage {

    WebDriver driver;

    public SeleniumKursWebElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkBoxOption1")
    WebElement checkBox1;

    @FindBy(id = "checkBoxOption2")
    WebElement checkBox2;

    @FindBy(id = "checkBoxOption3")
    WebElement checkBox3;

    @FindBy(css = "input[value='radio1']")
    private WebElement radioButton1;

    @FindBy(css = "input[value='radio2']")
    private WebElement radioButton2;

    @FindBy(css = "input[value='radio3']")
    private WebElement radioButton3;

    public void checkBox1Anklicken() {
        checkBox1.click();
    }

    public void checkBox2Anklicken() {
        checkBox2.click();
    }

    public void checkBox3Anklicken() {
        checkBox3.click();
    }

    public boolean checkBox1StatusAuslesen() {
        return checkBox1.isSelected();
    }

    public boolean checkBox2StatusAuslesen() {
        return checkBox2.isSelected();
    }

    public boolean checkBox3StatusAuslesen() {
        return checkBox3.isSelected();
    }

    public void radioButton1Anklicken() {
        radioButton1.click();
    }

    public void radioButton2Anklicken() {
        radioButton2.click();
    }

    public void radioButton3Anklicken() {
        radioButton3.click();
    }

    public String radioButton1getAttribute(String attributeName) {
        return radioButton1.getAttribute(attributeName);
    }

    public String radioButton2getAttribute(String attributeName) {
        return radioButton2.getAttribute(attributeName);
    }


    public String radioButton3getAttribute(String attributeName) {
        return radioButton3.getAttribute(attributeName);
    }


}
