package com.eurotech.tests.day_02_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        Thread.sleep(2000);
        //ikinci yontemi
        driver.navigate().to("https://testrelic.com/");
        Thread.sleep(2000);

        //navigate geri don
        driver.navigate().back();
        Thread.sleep(2000);

        //ileriye gitmek
        driver.navigate().forward();
        Thread.sleep(2000);
        //safayi yenile
        driver.navigate().refresh();


    }
}
