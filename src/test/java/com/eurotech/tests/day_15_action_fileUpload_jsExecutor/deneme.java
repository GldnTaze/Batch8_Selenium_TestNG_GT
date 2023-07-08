package com.eurotech.tests.day_15_action_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class deneme {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testName() {
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */

        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));
        List<WebElement> users = driver.findElements(By.tagName("h5"));


        for (int i = 0; i < elements.size(); i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(elements.get(i)).perform();
            Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(users.get(i))).isDisplayed());
        }
        int i=0;
        for (WebElement element : elements) {

           actions.moveToElement(element).perform();
            Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(users.get(i))).isDisplayed());
            i++;


        }
    }
}
