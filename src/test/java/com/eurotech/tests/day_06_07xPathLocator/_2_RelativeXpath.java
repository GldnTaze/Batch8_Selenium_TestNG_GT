package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the serach bar
         * locate seacrh button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        //accept cookies

      WebElement cookies= driver.findElement(By.xpath("//input[@name='accept']"));
      cookies.click();
      Thread.sleep(2000);

      WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
     // searchBox.sendKeys("Selenium"+ Keys.ENTER);  //CLIK isi yapiyor +Keys.ENTER
        //   // alttaki kod send keys yapar ve ardından enter tuşuna basar...mutlaka manual test edilip sonra
        //        // uygulanmalıdır..
        //        // searchBox.sendKeys("Selenium"+ Keys.ENTER);


      searchBox.sendKeys("Selenium");  //CLIK isi yapiyor +Keys.ENTER
      Thread.sleep(2000);



        WebElement searchBtn = driver.findElement(By.xpath("//input[@value=\"Git\"]"));
        searchBtn.click();

        //1.yol
         WebElement resultText1=driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        System.out.println("resultText1 = " + resultText1.getText());

        //2.yol
        WebElement resultText2=driver.findElement(By.xpath("//span[.='\"Selenium\"']"));
        System.out.println("resultText2 = " + resultText2.getText());
         Thread.sleep(3000);
         driver.close();


    }
}
