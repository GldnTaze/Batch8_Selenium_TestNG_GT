package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_ByPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Sign Up button web element by using partial link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        driver.findElement(By.id("accept-cookie-notification")).click();

        //partial link tekx ile loket edelim
        WebElement SignUpBtn = driver.findElement(By.partialLinkText("Up"));
        String signUpBtnText = SignUpBtn.getText();
        System.out.println(signUpBtnText);

        SignUpBtn.getAttribute("href");


        SignUpBtn.click();
        Thread.sleep(2000);
        driver.close();

    }
}
