package com.eurotech.tests.day_02_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_ClosseAndQuit {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);
         //kapatmak
        //close current tab mevcut olan tabi kapatir nerenin adresi verildi ise onu kapatir
        driver.close();




        //butun tablari kapatir
        WebDriverManager.chromedriver().setup();
        WebDriver driver1=new ChromeDriver();
        driver1.navigate().to("https:www.amazon.com");
        driver1.quit();

        //kapanmis drive yi acmak icin tekrara esan etmemiz gerekiyor

      driver=new ChromeDriver();
        driver.get("https:www.facebook.com");
        Thread.sleep(2000);
        driver.close();
    }
}
