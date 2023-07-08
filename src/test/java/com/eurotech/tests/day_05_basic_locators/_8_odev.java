package com.eurotech.tests.day_05_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_odev {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - ""https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want

         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.navigate().to("https://www.browserstack.com/users/sign_up");
        Thread.sleep(2000);

        driver.findElement(By.id("accept-cookie-notification")).click();

        Faker faker=new Faker();

         driver.findElement(By.id("user_full_name")).sendKeys(faker.name().fullName());
         Thread.sleep(3000);


         driver.findElement(By.id("user_email_login")).sendKeys(faker.internet().emailAddress());
         Thread.sleep(3000);

         driver.findElement(By.id("user_password")).sendKeys(faker.internet().password());
         Thread.sleep(3000);


        driver.findElement(By.name("terms_and_conditions")).click();
        Thread.sleep(2000);

        driver.close();
    }
}
