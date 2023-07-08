package com.eurotech.tests.day_01_automation_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_windowMetods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://www.eurotech.study/");
       // driver.get("www.eurotech.study/"); calismaz www olmasi lazim
       // driver.get("http://eurotech.study/"); calisir http yazilmasi lazim

        //ekrani buyutmek icin manage yonetmek demek
//        driver.manage().window().maximize();
//
//        driver.manage().window().fullscreen();

        //window pozisyonu alma sol penceresi hangi kondinatta

      Point position= driver.manage().window().getPosition(); //point konumunu gosteriri
        System.out.println(position);

       //window un sol ust kosesını ayarlar
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize();

        Point position1=driver.manage().window().getPosition();
        System.out.println("position1="+ position1);

        //window un ebatlarini verir
       Dimension size= driver.manage().window().getSize();   //ekranin eni ve boyu veriyor
        System.out.println("size:"+ size);

        Thread.sleep(2000);//javadan gelir kodu execution islemini belli bir sure durdurur
        //window un ebatalrini ayarlar
        driver.manage().window().setSize(new Dimension(880,800));


    }
}
