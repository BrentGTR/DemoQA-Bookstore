package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Page {

    @FindBy(id = "item-3") WebElement button_ProfilePage;
    @FindBy(id = "searchBox") WebElement input_Search;
    @FindBy(xpath = "(//span[contains(@id,'see-book-')])") static List<WebElement> prd_List;
    @FindBy(id = "login") WebElement btn_Login;
    @FindBy(xpath = "//label[contains(@id,'userName-label')]") WebElement lbl_userName;
    WebDriverWait wait = new WebDriverWait(driver,10);

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public static void select_Product(int productNumber) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prd_List.get(productNumber).click();
    }

    public void navigate_ProfilePage() {
        button_ProfilePage.click();
    }

    public void perform_Search(String searchCriterion) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
        input_Search.sendKeys(searchCriterion);
    }

    public void navigate_LoginPage() {
        btn_Login.click();
    }

    public void verify_SingleSearchResultsTitle(String title) {
        Assert.assertEquals(prd_List.get(0).getText(), title);
    }

    public void verifyThatUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@id,'userName-label')]")));
    }

}
