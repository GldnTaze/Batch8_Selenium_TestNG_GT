package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _deneme {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("test");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test.!123");
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.id("login"));
        login.click();
        Thread.sleep(2000);

        String actualtUrl = driver.getCurrentUrl();
        String expectedUrl="https://demoqa.com/profile";
        driver.close();


    }
}
