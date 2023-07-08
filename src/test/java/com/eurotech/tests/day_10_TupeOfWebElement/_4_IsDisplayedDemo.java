package com.eurotech.tests.day_10_TupeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _4_IsDisplayedDemo {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void displayedTest() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 1: Element on page that is hidden)
         * locate start button and "Hello World!" text element
         * verify that Hello World! is NOT displayed
         * click start button
         * wait 5 seconds
         * verify that Hello World! is now displayed
         * take the text of element and print it
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Example 1: Element on page that is hidden")).click();

        WebElement hello=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertFalse(hello.isDisplayed());
        WebElement startBtn= driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(5000);

        Assert.assertTrue(hello.isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    public void displayTest() throws InterruptedException {

        /**  Task
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 2: Element rendered after the fact)
         * click start button
         * verify that hello element is displayed (bu elementin locate işlemi starta clickten sonra yapılmalı)
         * get the element text and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']")).click();
        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(5000);
        WebElement helloWorld=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());

        System.out.println("helloWorld.getText() = " + helloWorld.getText());

    }


}

/**
 * Açıklama  :
 * Eğer bir element web sayfasında bir şarta bağlı olarak görünüyorsa bu durumda:
 *      a. element o şart gerçekleşmeden önce HTML kodunda (DOM) var ise elementi locate ederken sorun yaşamayız... (Hidden element -gizli element)
 *      b. element o şart gerçekleştikten sonra HTML koduna (DOM) yükleniyor ise elementi şart yerine gelmeden locate edemeyiz..
 * eğer locate etmeye kalkarsak "No Such Element" hatası alırız... şart gerçekleştikten sonra locate etmeliyiz..
 */
