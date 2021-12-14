package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;
import util.DriverFactory;

import java.util.logging.Logger;

public class Page extends TestBase {

    public WebDriver driver = DriverFactory.getInstance().getDriver();
    public static final Logger LOGGER = Logger.getLogger( Page.class.getName() );

    public Page() {
        PageFactory.initElements(this.driver, this);
    }
}
