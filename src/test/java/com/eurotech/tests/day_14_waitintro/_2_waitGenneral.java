package com.eurotech.tests.day_14_waitintro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class _2_waitGenneral {
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
    public void testwait() {
        //wait bir senkronizasyon olarak ifade edilir
        //DOM-->HTML kodlarini dokumant object model olarak ifade edilir
        WebElement checkBox=driver.findElement(By.id("checkbox"));
        Assert.assertTrue(checkBox.isEnabled());


    }
}
