package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.*;
import util.DriverFactory;

import java.io.File;
import java.io.IOException;

public class StepDefinitions extends Page {
    WebDriver driver = DriverFactory.getInstance().getDriver();

    public StepDefinitions() throws IOException {
        super();
        new BasePage();
    }

    @Given("^I am on the Home Page$")
    public void i_am_on_Home_Page(){
        driver.get("https://demoqa.com/books");
    }

    @Given("^user is on Profile Page$")
    public void user_is_on_Profile_Page(){
        driver.get("https://demoqa.com/profile");
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String product)  {
        new HomePage().perform_Search(product);
    }

    @When("^I add the book to my collection$")
    public void i_add_the_book_to_my_collection() {
        new HomePage().select_Product(0);
        new ProductListingPage().clickOn_AddToCollection();
    }

    @When("^I delete all books in my collection$")
    public void i_delete_all_books_in_my_collection(){
        new HomePage().navigate_ProfilePage();
        new ProfilePage().delete_AllBooksInCollection();
    }

    @When("^I go to the login page$")
    public void i_go_to_the_login_page() {
        new HomePage().navigate_LoginPage();
    }

    @When("^I log into the bookstore using the username of \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_log_into_the_bookstore(String userName, String password) throws InterruptedException{
        new LoginPage().login(userName, password);
    }

    @Then("^verify that the book displayed has a title of \"([^\"]*)\"$")
    public void verifyTitleDisplayedMatchesSearchInput(String title){
        new HomePage().verify_SingleSearchResultsTitle(title);
    }

    @Then("^verify that the Profile page is displayed$")
    public void verifyThatTheProfilePageIsDisplayed() {
        new HomePage().verifyThatUserIsLoggedIn();
    }


    @When("^I log out$")
    public void iLogOut() {
        new ProfilePage().logout();
    }

    @Then("^I can see the login page$")
    public void iCanSeeTheLoginPage() {
        new LoginPage().verify_OnLoginPage();
    }

    @Then("^I can see a pop-up that says \"([^\"]*)\"$")
    public void iCanSeeAPopUpThatSays(String popUpMessage) throws Throwable {
        Assert.assertTrue(driver.switchTo().alert().getText().contains(popUpMessage));
        driver.switchTo().alert().accept();
    }


}