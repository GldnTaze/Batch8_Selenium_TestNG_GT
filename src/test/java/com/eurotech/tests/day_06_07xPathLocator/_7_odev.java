package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _7_odev {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to https://demowebshop.tricentis.com/
         * locate "Simple Computer Add to Cart Button" with the name of product
         * then click to the button
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(3000);

        WebElement webElement = driver.findElement(By.xpath("//a[text()='Simple Computer']/../following-sibling::div[3]/div[2]/input"));

        //ikinci ol//a[text()='Simple Computer']/../following-sibling::div[3]/descendant::input
        // hocanin cozumu   /ancestor::*[class0'details']//input

        webElement.click();
        Thread.sleep(4000);
        driver.close();



    }
}
