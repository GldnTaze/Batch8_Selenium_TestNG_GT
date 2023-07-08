package com.eurotech.tests.day_02_webDriver_basics;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class _4_callWebDriverFactory {
    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();
        driver.get("https://tr-tr.facebook.com/");
       String actualURL= driver.getCurrentUrl();
       String expecteURL="https://tr-tr.facebook.com/";

       if (actualURL.equals(expecteURL)){
           System.out.println("pass");
       }else {
           System.out.println("failed");
       }
       driver.quit();
    }
}
