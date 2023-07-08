package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_RekatucXPart {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath)
         * locate login button (use xPath)
         * click login button
         * locate email address input box (use xPath)
         * send "abc" into email address input box
         * locate second login button (use xPath)
         * click Login button
         * get the message which appears on the email input box and print the message
         * close browser.
         */


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement cookies= driver.findElement(By.xpath("//button[contains(text(),'understand')]"));
        cookies.click();
        Thread.sleep(2000);

        //click login
        WebElement lioginBtn =driver.findElement(By.xpath("//a[[@class='btn btn/Ligt'"));
        lioginBtn.click();



        //send keys to email --- xpath attribute starts-with metodu ile
        WebElement emailInputBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        emailInputBox.sendKeys("abc@abc.com");

        //click second login button--- xpath * kullanılarak..
        WebElement secondLoginBtn = driver.findElement(By.xpath("//*[@id='loginpage-form-btn']"));
        secondLoginBtn.click();
        Thread.sleep(2000);

        driver.close();







    }
}
