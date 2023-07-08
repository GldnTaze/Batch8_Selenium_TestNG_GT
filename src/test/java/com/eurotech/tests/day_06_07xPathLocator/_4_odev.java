package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_odev {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Developers link (use xPath with text feature)
         * click the Developers link
         * locate Filter By element (use xPath with text feature)
         * get the text of element and print it
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        WebElement cookies = driver.findElement(By.xpath("//button[@id='rcc-confirm-button']"));
        cookies.click();
        Thread.sleep(3000);

        WebElement devolopersText = driver.findElement(By.xpath("//a[text()='Developers']"));
        devolopersText.click();
        Thread.sleep(3000);

        WebElement filterByElement = driver.findElement(By.xpath("//h2[.='Filter By']"));
        String byElementText = filterByElement.getText();
        System.out.println("byElementText = " + byElementText);
        Thread.sleep(2000);
        driver.close();


    }
}
