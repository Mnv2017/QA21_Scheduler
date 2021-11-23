package com.telran.scheduler.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() throws InterruptedException {
        app.getUser().defaultLogin();
//        app.getUser().login(new User().setEmail("mnv@mail.com").setPassword("Qwerty12345$"));
        Assert.assertTrue(app.getEvent().isContainerReportPresent());
        // log_password_input
        // log_email_input
    }

    @Test
    public void registerPositiveTest(){
        
    }

}
