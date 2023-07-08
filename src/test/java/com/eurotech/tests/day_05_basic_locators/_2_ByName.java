package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        Faker faker=new Faker();

        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        Thread.sleep(2000);
        //locate by name
        WebElement userNameBox= driver.findElement(By.name("username"));

        userNameBox.sendKeys("Mark Ruffalo");

        //java faker dan random isim girme
        String randomFakerName = faker.name().fullName();

        userNameBox.sendKeys(randomFakerName);

        Thread.sleep(2000);

        //clear box
        userNameBox.clear();

        //send another name
        userNameBox.sendKeys("Tracy McGraddy");

        //ikinci gönderilen ismi alalım ve bir stringe atayalım ve yazdıralım
        String secondName = userNameBox.getAttribute("value");
        System.out.println("secondName = " + secondName);

        Thread.sleep(2000);

        driver.close();

    }
}
