package testbase;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pageobjects.Page;
import util.DriverFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.logging.Level;

public class TestBase {

    public static Properties prop = new Properties();
    FileInputStream configData;

    {
        try {
            configData = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(configData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass(alwaysRun = true)
    public TestBase setupTest(){
        if(prop.getProperty("local").equalsIgnoreCase("true")){
            WebDriverManager.chromedriver().setup();
        }
        else{
            Page.LOGGER.log(Level.WARNING,"Config key 'local' set to "+prop.getProperty("local")+" for pipeline execution.");
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            System.setProperty("webdriver.chrome.whitelistedIps", "");
        }
        return this;
    }

    @BeforeMethod(alwaysRun = true)
    public void nameBefore(Method method) {
        Page.LOGGER.log(Level.INFO,"\nExecuting test: \n---------------------------------------------------    "+ method.getName() +"    ---------------------------------------------------");
    }

    @BeforeClass(alwaysRun = true)
    public void before() {
        try{
            FileInputStream configData = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop.load(configData);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void loadConfig() throws IOException {
        FileInputStream configData = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
        prop.load(configData);
    }

    public void endTest(){
        System.out.println("Ending test");
        DriverFactory.getInstance().removeDriver();
    }
}
