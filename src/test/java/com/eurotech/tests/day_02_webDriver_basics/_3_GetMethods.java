package com.eurotech.tests.day_02_webDriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_GetMethods {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url get page source code
         * verify that title, url and Page source codes  contain "hepsiburada"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
       String actualTitle= driver.getTitle(); //sayfanin basligini alir ve string olarak veririr
        String actualCurrentUrl=  driver.getCurrentUrl(); //sayfani url ni alir
        String actualPageSourse=driver.getPageSource();//sayfani kaynak kodu nu alir


        if (actualTitle.toLowerCase().contains("hepsiburada")&& actualCurrentUrl.toLowerCase().contains("hepsiburada")
                && actualPageSourse.toLowerCase().contains("hepsiburada"))
            {System.out.println("pass");

        }else {
            System.out.println("failed");
        }
        System.out.println(actualTitle);
        System.out.println(actualCurrentUrl);

        driver.close();
    }
}
