package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _9_RelativPathMetodHali {
    static    WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        /**
         * open a chrome browser
         * navigate to http://opencart.abstracta.us/index.php?route=common/home
         * locate "iPhone Add to Cart Button" with the name of product iPhone
         * then click to the add to cart button
         * take the text of success message which appears after the click
         * verify that the message contains "Success"
         * close driver
         */


      driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        Thread.sleep(3000);

        String[] productName={"iPhone","Apple Cinema 30","Canon EOS 5D","MacBook"};
        for (int i = 0; i < productName.length; i++) {
            addToCart(productName[i]);
            
        }



        WebElement success = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        System.out.println("success = " + success.getText());
        Thread.sleep(2000);
        driver.close();

    }

    public static void addToCart(String productName) throws InterruptedException {
        driver.findElement(By.xpath("// a [text()='"+productName+"']/ancestor::div[@class='caption']/following-sibling::div/button[1]")).click();
        Thread.sleep(40000);

        WebElement success = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        String actualText=success.getText();
        System.out.println("actualText = " + actualText);
        if (actualText.contains("Success")){
            System.out.println("pass");
        }else {
            System.out.println("failed");
        }


    }
}
