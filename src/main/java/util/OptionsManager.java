package util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import testbase.TestBase;
import java.util.HashMap;
import java.util.logging.Level;

public class OptionsManager extends TestBase{

    public static ChromeOptions getChromeOptions(){
        ChromeOptions opt = new ChromeOptions();

        if (prop.getProperty("local").equalsIgnoreCase("true")){
//            opt.addArguments("--headless");
            opt.addArguments("--ignore-certificate-errors");
            opt.addArguments("--start-maximized");
            opt.addArguments("--no-cache");
            opt.addArguments("--disable-extensions");
            opt.addArguments("--disable-notifications");
            opt.addArguments("--disable-background-networking");
            opt.addArguments("--no-default-browser-check");
            opt.addArguments("--no-first-run");
            opt.addArguments("--disable-component-extensions-with-background-pages");
            opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            String downloadFilepath = System.getProperty("user.dir") +"\\src\\main\\resources";
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            opt.setExperimentalOption("prefs", chromePrefs);
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
            opt.setCapability( "goog:loggingPrefs", logPrefs );
        }
        else{
            opt.addArguments("--no-sandbox");
            opt.addArguments("--disable-dev-shm-usage");
            opt.addArguments("--headless");
            opt.addArguments("--window-size=1920,1080");
            opt.addArguments("--disable-gpu");
            opt.addArguments("--no-cache");
            opt.addArguments("--ignore-certificate-errors");
            opt.addArguments("--disable-web-security");
            opt.addArguments("--disable-infobars");
            opt.addArguments("--disable-application-cache");
            opt.addArguments("--disable-extensions");
            opt.addArguments("--disable-notifications");
            opt.addArguments("--disable-background-networking");
            opt.addArguments("--no-default-browser-check");
            opt.addArguments("--no-first-run");
            opt.addArguments("--disable-component-extensions-with-background-pages");
            opt.setBinary("/usr/bin/google-chrome");
        }
        return opt;
    }

}