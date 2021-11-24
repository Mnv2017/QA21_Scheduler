package com.telran.scheduler.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChooseCurrencyAndWageTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        app.getUser().register();
    }

    @Test
    public void chooseCurrencyAndWageTest(){
        app.getCurrency().chooseCurrency("Bahamian dollar");
        app.getWage().chooseWage("25");
    }

    // wizard_settings_currency_arrow
    // android.widget.TextView
    // wizard_settings_wage_arrow
    // wage_dialog_input
    // wage_dialog_ok_btn
    // wizard_settings_next

}
