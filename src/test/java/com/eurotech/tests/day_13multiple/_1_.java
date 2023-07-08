package com.eurotech.tests.day_13multiple;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _1_ {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }




    @Test
    public void testMultiple() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        String parentWindow = driver.getWindowHandle();

        WebElement newWindow = driver.findElement(By.id("windowButton"));
        newWindow.click();

        Set<String> windowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        for (String windowHandle : windowHandles) {
            System.out.println(windowHandle);
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);

            }


        }
        //birden fazla olasi durumu window acildiginda hangisine nasil gidecegiz

    }
    @Test
    public void multipleTab() throws InterruptedException {
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        Thread.sleep(20000);
        driver.getWindowHandle();
        driver.findElement(By.id("newTabBtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("newWindowsBtn")).click();

        Set<String> handles = driver.getWindowHandles();
        String expectedTitle="XPath Practice - H Y R Tutorials";

        for (String handle : handles) {
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }

        }
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }
}
