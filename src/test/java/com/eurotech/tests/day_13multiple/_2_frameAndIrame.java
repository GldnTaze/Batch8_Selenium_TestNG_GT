package com.eurotech.tests.day_13multiple;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_frameAndIrame {
    //Frame ic ice konumlandirilmis web sayfalarinin tanimlandirilmasi icin kullanilir
    //IFrame ic ice konulmus web sayfalarinin tanimlanmasinda kullanilir
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
    public void testiframe() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        driver.switchTo().frame("frame1");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text,"This is a sample page");
    }


    @Test
    public void testiframe2() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        driver.switchTo().frame(3);
        String text = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals(text, "This is a sample page");
    }
    @Test
    public void testiframe3() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        Thread.sleep(2000);
        driver.switchTo().frame(3);
        driver.switchTo().parentFrame();//yukaruya cikar
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();//defualt sayfaya gider bas sayfaya doner

    }

}
