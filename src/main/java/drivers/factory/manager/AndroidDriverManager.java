package drivers.factory.manager;

import drivers.config.ConfigReader;
import drivers.factory.Factory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager implements Factory
{
    @Override
    public AppiumDriver createDriver(){

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

        AppiumDriver driver;
        try {
            return driver = new AndroidDriver(new URL(ConfigReader.getProperty("mobile.appiumServerUrl")), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
