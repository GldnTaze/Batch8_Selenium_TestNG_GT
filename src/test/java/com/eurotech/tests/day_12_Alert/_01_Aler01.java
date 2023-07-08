package com.eurotech.tests.day_12_Alert;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_Aler01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public  void testAlert() throws InterruptedException {

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
      Thread.sleep(6000);
      driver.switchTo().alert().accept();

      Thread.sleep(2000);

    }



    @Test
    public void testTimerAlert() throws InterruptedException {
        WebElement alertTime=driver.findElement(By.id("timerAlertButton"));
        alertTime.click();
        Thread.sleep(6000);
        String actualtext = driver.switchTo().alert().getText();
        String expectedtext="Thid alert appeared after 5 seconds";
        Assert.assertEquals(actualtext,expectedtext);


   driver.switchTo().alert().accept();




    }

    @Test
    public void testAlertDismisAndAccepr() throws InterruptedException {

        WebElement alert2 = driver.findElement(By.id("confirmButton"));
        alert2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();//aletten gelen urayi yi  RED etme
        Thread.sleep(2000);

        WebElement alertResult= driver.findElement(By.id("confirmResult"));
        Assert.assertTrue(alertResult.getText().contains("Cancel"));
    }

    @Test
    public void testAlertSendKey() throws InterruptedException {
        WebElement alert3=driver.findElement(By.id("promtButton"));
        alert3.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("gulden");
        driver.switchTo().alert().accept();

        WebElement alertName=driver.findElement(By.id("promptResult"));

        Assert.assertTrue(alertName.getText().contains("gulden"));
        Assert.assertFalse(alertName.getText().contains("123"));
    }
}
