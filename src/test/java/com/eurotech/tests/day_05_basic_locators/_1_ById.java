package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_ById {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate DevEx web element by using id locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);
        //accept cookies

        driver.findElement(By.id("rcc-confirm-button")).click();

        //id ile loket etme

        WebElement devElement=driver.findElement(By.id("landingpage-innercontainer-h1"));

        //webelementin text alalim yazdirelim
        String devElementText = devElement.getText();
        System.out.println("devElementText = " + devElementText);
        Thread.sleep(2000);
        driver.close();


    }
}
