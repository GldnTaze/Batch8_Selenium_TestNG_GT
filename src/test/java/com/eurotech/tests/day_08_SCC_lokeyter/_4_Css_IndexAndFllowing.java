package com.eurotech.tests.day_08_SCC_lokeyter;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_Css_IndexAndFllowing {
    public static void main(String[] args) throws InterruptedException {

        /**
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         * --------------
         * cssSyntax--->tagName :nth-of-type(indexNumber)
         * cssSyntax--->tagName :nth-child(indexNumber)
         * NOTE: sadece aynı parent altındaki web elementlerde kullanılır..
         *
         * cssSyntax:tagName[]~tagName[]
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);


        WebElement emailInput = driver.findElement(By.cssSelector("#userEmail-wrapper>div:nth-child(2)>input"));
        emailInput.sendKeys("\"hasan@hasan.com\"");
        Thread.sleep(2000);


        WebElement addressInput = driver.findElement(By.cssSelector("form div~#currentAddress-wrapper>div~div>textarea"));
        addressInput.sendKeys("Bağcılar/İstanbul");
        Thread.sleep(2000);
        driver.close();

    }
}
