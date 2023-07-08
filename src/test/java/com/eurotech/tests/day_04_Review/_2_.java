package com.eurotech.tests.day_04_Review;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * register and login (send mail and password)
         * Verify title
         * Verify page(url)


         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");

        Thread.sleep(3000);//Thread-->Yazilimda bir Islem parcasi,
        // Pause tusuna basmak olarak algilanabilir

        driver.findElement(By.id("rcc-confirm-button")).click();

        //Bu bir webelement olarak tanimladik ve sonra click dedik
        WebElement loginButton= driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginButton.click();

//        String email="ismet.gunes47@gmail.com";
//        WebElement emailLabel=driver.findElement(By.id("loginpage-input-email"));

        Thread.sleep(3000);
        driver.findElement(By.id("loginpage-input-email")).sendKeys("ismet.gunes47@gmail.com");

        //   emailLabel.sendKeys(email);

        Thread.sleep(3000);
        String password="Basketbol103545";
        WebElement passwordLabel= driver.findElement(By.id("loginpage-form-pw-input"));
        passwordLabel.sendKeys(password);


        Thread.sleep(3000);
        driver.findElement(By.id("loginpage-form-btn")).click();


        Thread.sleep(3000);

        String actualtUrl=driver.getCurrentUrl();
        System.out.println(actualtUrl);
        String expectedUrl="http://www.eurotech.study/dashboard";

        if (actualtUrl.equals(expectedUrl)){
            System.out.println("Sayfa basarili sekilde Yuklendi");
        }else {
            System.out.println("Fail");
        }


        Thread.sleep(4000);
        driver.close();



    }
}
