package pageobjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Page {

    @FindBy(xpath = "(//button[contains(@id,'submit')][contains(text(),'Delete All Books')])[1]")
    WebElement btn_deleteAllBooksInCollection;
    @FindBy(id = "closeSmallModal-ok")
    WebElement btn_modalOk;
    @FindBy(xpath = "//button[contains(@id,'submit')][contains(text(),'Log out')]")
    WebElement btn_logOut;
    WebDriverWait wait = new WebDriverWait(driver,10);

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void delete_AllBooksInCollection() {
        btn_deleteAllBooksInCollection.click();
        btn_modalOk.click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_logOut));
        btn_logOut.click();
    }
}
