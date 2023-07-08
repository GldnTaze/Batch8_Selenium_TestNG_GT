package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class _02_MultipleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void testMultipeWindws() throws InterruptedException {
        String mainHandle=driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        WebElement newTabButton=driver.findElement(By.id("tabButton"));
        newTabButton.click();

        Set<String> allWindowsHandle=driver.getWindowHandles();//tum sayfalarin Hash kodlarini burda topla

        //yeni bir linke tiklanmasi durumunda
        //bir Hash kod kummesine
        for (String handle:allWindowsHandle){
           if(! handle.equals(mainHandle)){
                driver.switchTo().window(handle);
               Thread.sleep(2000);
               driver.close();
            }
        }
        Thread.sleep(2000);
        driver.switchTo().window(mainHandle);


    }
}
