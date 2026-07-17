package drivers.factory;

import drivers.factory.manager.AndroidDriverManager;
import drivers.factory.manager.IOSDriverManager;
import io.appium.java_client.AppiumDriver;

public class AppiumDriverFactory {

    protected AppiumDriver driver;

    public AppiumDriver createInstance(String platform){
        PlatformList platformType = PlatformList.valueOf(platform.toUpperCase());

        driver = switch (platformType) {
            case ANDROID -> new AndroidDriverManager().createDriver();
            case IOS -> new IOSDriverManager().createDriver();
        };

        return driver;
    }
}
