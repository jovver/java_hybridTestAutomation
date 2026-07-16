package tests.base;

import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseMobileAppTest {

    protected static AppiumDriver driver;

    // TODO: Update the setUp() method to be dynamic
    public static void Android_setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName",
                ConfigReader.getProperty("android.platformName"));
        caps.setCapability("appium:platformVersion",
                ConfigReader.getProperty("android.platformVersion"));
        caps.setCapability("appium:deviceName",
                ConfigReader.getProperty("android.deviceName"));
        caps.setCapability("appium:app",
                ConfigReader.getProperty("android.appPath"));
        caps.setCapability("appium:automationName",
                ConfigReader.getProperty("android.automationName"));

        driver = new AndroidDriver(new URL(ConfigReader.getProperty("mobile.appiumServerUrl")), caps);
    }

    public static void iOS_setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName",
                ConfigReader.getProperty("iOS.platformName"));
        caps.setCapability("appium:platformVersion",
                ConfigReader.getProperty("iOS.platformVersion"));
        caps.setCapability("appium:deviceName",
                ConfigReader.getProperty("iOS.deviceName"));
        caps.setCapability("appium:UDID",
                ConfigReader.getProperty("iOS.UDID"));
        caps.setCapability("appium:automationName",
                ConfigReader.getProperty("iOS.automationName"));
        caps.setCapability("appium:app",
                ConfigReader.getProperty("iOS.app"));

        driver = new IOSDriver(new URL(ConfigReader.getProperty("iOS.appiumServerUrl")), caps);
    }

    @AfterClass
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
