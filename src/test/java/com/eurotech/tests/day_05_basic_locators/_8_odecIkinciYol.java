package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _8_odecIkinciYol {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up%22");
                driver.manage().window().maximize();
        Thread.sleep(2000);
//
//        //accept cookies
//        driver.findElement(By.id("accept-cookie-notification")).click();
//
//        //Full name TextField
//
//        String fullName = faker.name().fullName();
//        driver.findElement(By.id("user_full_name")).sendKeys(fullName);
//
//        //E-Mail TextField
//        String emailAddress = faker.internet().emailAddress();
//        driver.findElement(By.id("user_email_login")).sendKeys(emailAddress);
//
//        //Password TextField
//        String password = faker.internet().password();
//        driver.findElement(By.id("user_password")).sendKeys(password);
//        Thread.sleep(2000);
//
//        //click Terms of services
//        driver.findElement(By.name("terms_and_conditions")).click();
//        Thread.sleep(2000);
//
//        driver.close();

    }
}
