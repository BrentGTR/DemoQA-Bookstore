package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testbase.TestBase;
import util.DriverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage extends TestBase {

    public BasePage() throws IOException {
        Properties prop = new Properties();
        FileInputStream configData = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(configData);
        setupTest();
    }

    @Before
    public void cleanup() throws IOException {
        loadConfig();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            File srcFile = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            String strTestName = scenario.getName()+".png";
            scenario.attach(String.valueOf(srcFile),"image/png",strTestName);
        }
        endTest();
    }
}