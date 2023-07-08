package com.eurotech.tests.day_02_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_odev {
    public static void main(String[] args) {


       //go to "https://www.krafttechexlab.com/" with chrome
        //verify that the url is "https://www.krafttechexlab.com/"

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com/");
        String actualcurrentUrl = driver.getCurrentUrl();
        System.out.println(actualcurrentUrl);
        driver.quit();







    }
}
