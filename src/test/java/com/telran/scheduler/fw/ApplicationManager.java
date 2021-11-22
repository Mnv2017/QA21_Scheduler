package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ApplicationManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities; //как в Inspector

    UserHelper user;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0.0");
        capabilities.setCapability("deviceName", "qa21_mob");
        capabilities.setCapability("automationName","Appium"); // добавили сами
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("app","/Users/nataliamorgel/Tools/v.0.0.3.apk");// путь где лежит на компе

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities); // из Inspector Remout host+ Port+Path
        user =new UserHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public void stop() {
        driver.quit();
    }
}