package com.eurotech.tests.day_11_listOfElements_dropDows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class odev {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void dropDownWithSelectTag_Task() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com/"
         * locate the dropdown menu nearby the search box
         * select the Baby department by using text then print the department name
         * select the Books department by using index then print the department name
         * select the Health & Household department by using value attribute then print the department name
         * get all options to a list
         * print all departments name
         * get the text of fifth element and verify that the text is Books
         */
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        WebElement dropDownElement = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDownElement);
        //select the Baby department by using text then print the department name
        select.selectByVisibleText("Baby");
        Thread.sleep(3000);
        WebElement baby = select.getFirstSelectedOption();
        System.out.println("baby.getText() = " + baby.getText());

        // select the Books department by using index then print the department name

        select.selectByIndex(5);
        Thread.sleep(2000);
        WebElement books = select.getFirstSelectedOption();
        System.out.println("books.getText() = " + books.getText());


        //select the Health & Household department by using value attribute then print the department name
        select.selectByIndex(12);
        Thread.sleep(2000);
        WebElement health = select.getFirstSelectedOption();
        System.out.println("health.getText() = " + health.getText());

        // * get all options to a list
        //-->2.yontem  allDepartments.forEach(e-> System.out.println(e.getText()));
        List<WebElement> allDepartments = select.getOptions();
        for (WebElement allDepartment : allDepartments) {
            System.out.println("allDepartment.getText() = " + allDepartment.getText());
        }
        String actualText = allDepartments.get(5).getText();
        String expectedText = "Books";
        Assert.assertEquals(actualText, expectedText);






    }

}

