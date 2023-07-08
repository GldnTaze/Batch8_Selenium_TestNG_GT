package com.eurotech.tests.day_02_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_odev {
    public static void main(String[] args) throws InterruptedException {
        //get hepsiburada
        //navigate trendyol
        //navigate hepsiburada
        //refresh page

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
        Thread.sleep(2000);
        driver.navigate().to("https://www.trendyol.com/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();

    }
}
