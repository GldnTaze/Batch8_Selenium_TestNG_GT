package com.eurotech.tests.day_10_TupeOfWebElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _5_getAttributeDemo {
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
    public void getAttributeTest() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/text-box
         * locate the form web element
         * use some of GET (getAttribute, getTagName, getLocation, getCssValue) methods with the element
         */

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);

        WebElement form = driver.findElement(By.xpath("//form"));

        System.out.println("form.getAttribute(\"id\") = " + form.getAttribute("id"));
        System.out.println("------------------");
        System.out.println("form.getAttribute(\"innerHTML\") = " + form.getAttribute("innerHTML"));
        System.out.println("------------------");
        System.out.println("form.getAttribute(\"outerHTML\") = " + form.getAttribute("outerHTML"));
        System.out.println("------------------");
        System.out.println("form.getText() = " + form.getText());
        System.out.println("------------------");

        System.out.println("form.getTagName() = " + form.getTagName());
        System.out.println("form.getLocation() = " + form.getLocation());
        System.out.println("form.getCssValue(\"font\") = " + form.getCssValue("font"));



    }
    @Test
    public void getAttributeTask() throws InterruptedException {


/**
 * navigate to https://demoqa.com/text-box
 * locate Full Name input box
 * use getAttribute method with the element
 * get type attribute value and print it
 * get autocomplete attribute value and print it
 * get name attribue value and print it (name attribute olmadığı için boş dönecektir. hata vermez..)
 * get innerHTML and print it (altında child veya grandchild element olmadığından boş döner..)
 * get outerHTML (sadece kendi tag bilgilerini döner..)
 * send Ahmet to the box and take the value (eğer bir text box'ına yazı gönderirsek.. bu gönderlen yazıyı
 * getAttribute("value") metodu ile alabiliriz..)
 * NOT: getAttribute metodu ile bir web elementin texti alınamaz.. onun için getText() metodu kullanılır..

 */

        driver.get("https://demoqa.com/text-box");
        WebElement fullName= driver.findElement(By.id("userName"));
        System.out.println("fullName.getAttribute(\"id\") = " + fullName.getAttribute("id"));
        System.out.println("fullName.getAttribute(\"type\") = " + fullName.getAttribute("type"));
        System.out.println("fullName.getAttribute(\"autocomplete\") = " + fullName.getAttribute("autocomplete"));
        System.out.println("fullName.getAttribute(\"name\") = " + fullName.getAttribute("name"));
        System.out.println("fullName.getAttribute(\"outerHTML\") = " + fullName.getAttribute("outerHTML"));
        System.out.println("fullName.getAttribute(\"innerHTML\") = " + fullName.getAttribute("innerHTML"));
        System.out.println("fullName.getText() = " + fullName.getText());
        fullName.sendKeys("Ahmet");
        Thread.sleep(2000);
        System.out.println("fullName.getAttribute(\"value\") = " + fullName.getAttribute("value"));




    }

}
