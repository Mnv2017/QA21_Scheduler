package com.telran.scheduler.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WageHelper extends HelperBase{
    public WageHelper(AppiumDriver driver) {
        super(driver);
    }

    public void chooseWage(String wage) {
        tap(By.id("wizard_settings_wage_arrow"));
        type(By.id("wage_dialog_input"),wage);
        tap(By.id("wage_dialog_ok_btn"));
        tap(By.id("wizard_settings_next"));
    }

    // wizard_settings_wage_arrow
    // wage_dialog_input
    // wage_dialog_input
    // wizard_settings_next
}
