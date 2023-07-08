package com.eurotech.tests.day_10_TupeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_DisableElement {
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
    public void dısableElements() throws InterruptedException {

        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");

        WebElement texBar = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(texBar.isEnabled());

        WebElement enableabatn = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableabatn.click();
        Thread.sleep(5000);
        String s= "the element is now enabled";
        texBar .sendKeys(s);


        Assert.assertTrue((texBar.isEnabled()));
        Thread.sleep(4000);

    }

    @Test
    public void disableElements() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */

        driver.get(" http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement pumpkin = driver.findElement(By.xpath("//form[@id='radio-buttons-selected-disabled']/input[3]"));
        Thread.sleep(2000);
        Assert.assertTrue(pumpkin.isEnabled());
        Assert.assertTrue(pumpkin.isSelected());
        Assert.assertTrue(pumpkin.isDisplayed());

        // * locate cabbage element
        WebElement cabbage = driver.findElement(By.xpath("//form[@id='radio-buttons-selected-disabled']/input[2]"));
        Assert.assertFalse(cabbage.isEnabled());
        Assert.assertFalse(cabbage.isSelected());
        Assert.assertTrue(cabbage.isDisplayed());
        Thread.sleep(2000);
    }
}
