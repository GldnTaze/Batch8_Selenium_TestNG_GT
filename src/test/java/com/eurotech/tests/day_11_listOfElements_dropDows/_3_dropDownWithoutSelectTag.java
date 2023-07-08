package com.eurotech.tests.day_11_listOfElements_dropDows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_dropDownWithoutSelectTag {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void dropDownWithoutSelectTag() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * locate and click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */
       driver.get("https://demoqa.com/select-menu");
        WebElement dropDwomnMenu = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropDwomnMenu.click();
        Thread.sleep(2000);
        WebElement group1Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        group1Option2.click();
        Thread.sleep(2000);

        WebElement group1Option2_1 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));

        String actualText=group1Option2_1.getText();
        String expectedText="Group 1, option 2";
        Assert.assertEquals(actualText,expectedText);

    }


    @Test
    public void dropDownWithoutSelectTag_Task() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * locate new 'Mrs.' webElement
         * get the selected option text verify that the text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
         */


        driver.get("https://demoqa.com/select-menu");
        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();
        Thread.sleep(2000);

        WebElement mrsWebElelement = driver.findElement(By.xpath("(//div[text()='Mrs.'])[1]"));
        mrsWebElelement.click();
        Thread.sleep(2000);

        WebElement mrsWebElelement_1 = driver.findElement(By.xpath("(//div[text()='Mrs.'])[1]"));
        String actualText = mrsWebElelement_1.getText();
        String expectedText="Mrs.";
        Assert.assertEquals(actualText,expectedText);
    }




    }





