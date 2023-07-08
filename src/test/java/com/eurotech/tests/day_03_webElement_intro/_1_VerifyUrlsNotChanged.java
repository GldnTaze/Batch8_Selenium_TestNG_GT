package com.eurotech.tests.day_03_webElement_intro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_VerifyUrlsNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //navigate to wep site
        driver.get("https://demoqa.com/login");
        Thread.sleep(3000);

       String expecteUrl=driver.getCurrentUrl();
        //logın button koyduk
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        Thread.sleep(3000);

        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.equals(expecteUrl)){
            System.out.println("pass");
        }else {
            System.out.println("failed");
        }
        driver.close();

    }
}
