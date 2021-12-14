package pageobjects;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Page {

    @FindBy(xpath = "(//button[contains(@id,'submit')][contains(text(),'Delete All Books')])[1]")
    WebElement btn_deleteAllBooksInCollection;
    @FindBy(id = "closeSmallModal-ok")
    WebElement btn_modalOk;
    @FindBy(xpath = "//div[contains(@Class,'main-header')]")
    WebElement header_MainProfile;
    @FindBy(xpath = "//button[contains(@id,'submit')][contains(text(),'Log out')]")
    WebElement btn_logOut;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void delete_AllBooksInCollection() {
        btn_deleteAllBooksInCollection.click();
        btn_modalOk.click();
    }

    public void verifyThatTheProfilePageIsDisplayed() {
        Assert.assertEquals(header_MainProfile.getText(),"Profile" );
    }

    public void logout() {
        btn_logOut.click();
    }
}
