package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage extends Page {

    @FindBy(id = "addNewRecordButton") WebElement button_addNewRecord;
    @FindBy(id = "gotoStore") WebElement button_goToStore;

    public ProductListingPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOn_AddToCollection() {
        button_addNewRecord.click();
    }
    public void clickOn_GoToBookStore() {
        button_goToStore.click();
    }
}
