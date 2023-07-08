package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_OpenBrowser {
    public static void main(String[] args) {
        //make selenium ready to talk with Chrome
        WebDriverManager.chromedriver().setup();

        //create a driver object
        //drive-->bos bir browser

        WebDriver driver=new ChromeDriver();

        //navigate to eurotechStudy web page
        driver.get("https://www.amazon.com/");

        //how to get page title
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com. Spend less. Smile more.";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("pass");
        }else System.out.println("failed");

        driver.get("https://www.hepsiburada.com/");

    }
}
