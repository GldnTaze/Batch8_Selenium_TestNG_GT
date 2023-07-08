package com.eurotech.tests.day_08_SCC_lokeyter;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _3_Css_contains_StartssWith_EndsWith_ParenToChild {
    public static void main(String[] args) throws InterruptedException {
        /**
         * class task
         * navigate to http://www.eurotech.study/
         * click cookies button css contains (*)
         * click login button with css starts-with (^)
         * send your email to email box with css ends-with ($)
         * send your password to password box with css parent to child (>)
         * click login btn with css parent to grandson (space)
         * -----------------------------
         * [attribute*='value'] (contains)
         * tagName[attribute*='value'] (contains)
         *
         * [attribute^='firstPartOfValue'] (starts with)
         * tagName[attribute^='firstPartOfValue'] (starts with)
         *
         * [attribute$='lastPartOfValue'] (ends-with)
         * tagName[attribute$='lastPartOfValue'] (ends-with)
         *
         * xpath '/'  --> parent to child
         * css   '>'  --> parent to child
         * xpath '//' --> parent to grandson
         * css   ' '  --> parent to grandson  (space-boşluk)
         *   */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

           // * click cookies button css contains (*)
        driver.findElement(By.cssSelector("[aria-label*= cookies]")).click();
        Thread.sleep(2000);

        //    * click login button with css starts-with (^)

        driver.findElement(By.cssSelector("[class^=\"btn btn\"]")).click();
        Thread.sleep(2000);

        // * send your email to email box with css ends-with ($)

        driver.findElement(By.cssSelector("[name$=email]")).sendKeys("guldentaze2706@gmail.com");
        Thread.sleep(2000);

        // * send your password to password box with css parent to child (>)

        driver.findElement(By.cssSelector("div> input[name=\"password\"]")).sendKeys("Senih.1453");
        Thread.sleep(2000);


        //  * click login btn with css parent to grandson (space)

        driver.findElement(By.cssSelector("section [type='submit']")).click();
        Thread.sleep(2000);


    }
}
