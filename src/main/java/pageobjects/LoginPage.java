package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends Page {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName") WebElement input_userName;
    @FindBy(id = "password") WebElement input_password;
    @FindBy(id = "login") WebElement btn_login;
    @FindBy(id = "userForm") WebElement form_LoginUser;
    WebDriverWait wait = new WebDriverWait(driver,10);

    public void login(String userName, String password) {
        input_userName.sendKeys(userName);
        input_password.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(btn_login));
        btn_login.click();
    }

    public void verify_OnLoginPage() {
        Assert.assertTrue(form_LoginUser.isDisplayed());
    }
}
