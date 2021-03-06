package com.telran.scheduler.fw;

import com.telran.scheduler.model.User;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.Random;

public class UserHelper extends HelperBase{

    public UserHelper(AppiumDriver driver) {
        super(driver);
    }

    public void login(User user) throws InterruptedException {
        type(By.id("log_email_input"), user.getEmail());
        type(By.id("log_password_input"), user.getPassword());
        hideKeyboard();
        Thread.sleep(1000);
        tapLoginButton();
        Thread.sleep(1000);
    }

    private void tapLoginButton() {
        tap(By.id("login_btn"));
    }

    public void defaultLogin() throws InterruptedException {
        login(new User().setEmail("mnv@mail.com").setPassword("Qwerty12345$"));
    }

    public void register() throws InterruptedException {
        Random random = new Random();
        int r = random.nextInt(100);
        login(new User().setEmail("nnn" + r + "@mail.com").setPassword("Qwerty12345$"));
    }
}
