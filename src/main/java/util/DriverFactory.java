package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory
{

    private DriverFactory(){}

    private static final DriverFactory instance = new DriverFactory();
    public static DriverFactory getInstance()
    {
        return instance;
    }

    // thread local driver object for webdriver
    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() ->
        new ChromeDriver(OptionsManager.getChromeOptions())); // can be replaced with other browser drivers


    public WebDriver getDriver() // call this method to get the driver object and launch the browser
    {
        return driver.get();
    }

    public void removeDriver()
    {
            driver.get().quit();
            driver.remove();
    }
}