package com.eurotech.tests.day_11_listOfElements_dropDows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class odev2 {
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
    public void dropdownLıst() throws InterruptedException {
        /**
         * navigate to https://demo.aspnetawesome.com/
         * locate and click DropdownList (Mango ile başlayan liste)
         * get all option names and print them
         * click potato by index (6)
         * relocate dropdown menu (çünkü listenin yapısı değişti)
         * click banana with its own locator (banana'yı locate edip tıklayalım.)
         */
        driver.get("https://demo.aspnetawesome.com/");

        WebElement dropdownList = driver.findElement(By.xpath("(//div[@class='o-dd'])[5]"));
        dropdownList.click();
        Thread.sleep(2000);
        List<WebElement>options=driver.findElements(By.xpath("(//div[@class='o-itsc'])[5]//li"));
       for(WebElement option:options){
           System.out.println("option.getText() = " + option.getText());
       }
       Thread.sleep(2000);
        WebElement potatoIndex = options.get(6);
        potatoIndex.click();
        Thread.sleep(2000);

       driver.findElement(By.xpath("(//div[@class='o-dd'])[5]")).click();
       Thread.sleep(2000);

        driver.findElement(By.xpath("//li[@data-val='169']")).click();
        Thread.sleep(2000);




    }

}
