package com.telran.scheduler.tests;

import com.telran.scheduler.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
/*
        "platformName": "Android",
  "platformVersion": "8.0.0",
  "deviceName": "qa21_mob",
  "appPackage": "com.example.svetlana.scheduler",
  "appActivity": ".presentation.splashScreen.SplashScreenActivity"
         */
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}
