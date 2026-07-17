package drivers.factory.manager;

import drivers.config.ConfigReader;
import drivers.factory.Factory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSDriverManager implements Factory
{
    @Override
    public AppiumDriver createDriver(){

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
                ConfigReader.getProperty("iOS.appPath"));

        AppiumDriver driver;
        try {
            return driver = new IOSDriver(new URL(ConfigReader.getProperty("mobile.appiumServerUrl")), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
