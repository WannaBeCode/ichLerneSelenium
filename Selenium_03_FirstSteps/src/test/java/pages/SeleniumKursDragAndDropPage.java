package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursDragAndDropPage {

    WebDriver driver;

    public SeleniumKursDragAndDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "white-logo")
    WebElement drgLogoWhite;

    @FindBy(id = "green-logo")
    WebElement drgLogoGreen;

    @FindBy(id = "blue-logo")
    WebElement drgLogoBlue;

    @FindBy(id = "red-logo")
    WebElement drgLogoRed;

    @FindBy(id = "droppable")
    WebElement dropBox;

    @FindBy(id = "coding-logo")
    WebElement drgCodingLogo;

    @FindBy(css = "#droppable > p")
    WebElement textStausmeldung;

    //Standard DragAndDrop
    public void moveAllLogosToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoWhite, dropBox).build().perform();
        actions.dragAndDrop(drgLogoGreen, dropBox).build().perform();
        actions.dragAndDrop(drgLogoRed, dropBox).build().perform();
        actions.dragAndDrop(drgLogoBlue, dropBox).build().perform();
        actions.dragAndDrop(drgCodingLogo, dropBox).build().perform();
    }


    public void moveWhiteLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoWhite, dropBox).build().perform();
    }

    public void moveGreenLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoGreen, dropBox).build().perform();
    }

    public void moveBlueLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoBlue, dropBox).build().perform();
    }

    public void moveRedLogoToBox() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drgLogoRed, dropBox).build().perform();
    }

    //Offset DragAnd Drop
    public void moveWhiteLogoToBoxWithOffSet(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoWhite,x,y).build().perform();

    }

    public void moveGreenLogoToBoxWithOffSet(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoGreen,x,y).build().perform();

    }

    public void moveBlueLogoToBoxWithOffSet(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoBlue,x,y).build().perform();

    }

    public void moveRedLogoToBoxWithOffSet(int x, int y) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(drgLogoRed,x,y).build().perform();

    }

    //Drag and Drop Manuell
    public void moveWhiteLogoToBoxManual() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoWhite).build().perform();
        actions.moveByOffset(250,0);
        actions.release(drgLogoWhite).perform();
    }

    public void moveGreenLogoToBoxManual() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoGreen).build().perform();
        actions.moveByOffset(250,0);
        actions.release(drgLogoGreen).perform();
    }

    public void moveBlueLogoToBoxManual() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoBlue).build().perform();
        actions.moveByOffset(250,0);
        actions.release(drgLogoBlue).perform();
    }

    public void moveRedLogoToBoxManual() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(drgLogoRed).build().perform();
        actions.moveByOffset(250,0);
        actions.release(drgLogoRed).perform();
    }

    public String printStatusMeldung() {
        return  textStausmeldung.getText();
    }


}
