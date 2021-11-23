package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() throws InterruptedException {
        app.getUser().defaultLogin();
        app.getUser().login(new User().setEmail("mnv@mail.com").setPassword("Qwerty12345$"));
        Assert.assertTrue(app.getEvent().isContainerReportPresent());
        // log_password_input
        // log_email_input
    }

    @Test
    public void loginNegativeTestWrongEmail() throws InterruptedException {
        app.getUser().login(new User().setEmail("mnvmail.com").setPassword("Qwerty12345$"));
        Assert.assertFalse(app.getEvent().isContainerReportPresent());

    }

    @Test
    public void loginNegativeTestWrongPasswort() throws InterruptedException {
        app.getUser().login(new User().setEmail("mnv@mail.com").setPassword("qwerty12345"));
        Assert.assertFalse(app.getEvent().isContainerReportPresent());
    }

    @Test
    public void registerPositiveTest() {

    }

}
