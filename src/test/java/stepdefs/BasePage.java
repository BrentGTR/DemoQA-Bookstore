package stepdefs;

import io.cucumber.java.Before;
import testbase.TestBase;
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

}