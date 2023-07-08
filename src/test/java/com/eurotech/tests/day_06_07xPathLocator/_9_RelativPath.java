package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _9_RelativPath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to http://opencart.abstracta.us/index.php?route=common/home
         * locate "iPhone Add to Cart Button" with the name of product iPhone
         * then click to the add to cart button
         * take the text of success message which appears after the click
         * verify that the message contains "Success"
         * close driver
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        Thread.sleep(3000);

        WebElement cartAdd = driver.findElement(By.xpath("// a [text()='iPhone']/ancestor::div[@class='caption']/following-sibling::div/button[1]"));
        cartAdd.click();
        Thread.sleep(2000);

        WebElement success = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        System.out.println("success = " + success.getText());
        Thread.sleep(2000);
        driver.close();

    }
}
