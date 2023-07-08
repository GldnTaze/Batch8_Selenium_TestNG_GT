package com.eurotech.tests.day_08_SCC_lokeyter;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Css_Attribute_multipel {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text with css multiple attribute value (and)
         * take main text with css multiple attribute value (or)
         * close driver
         * --------------------
         * [attribute='value']
         * tagName[attribute='value']
         * ----------------------
         * birden çok attribute ile css'de locate etme:
         * [attribute1='value1'][attribute2='value2'] (and)
         * tagName[attribute1='value1'][attribute2='value2'] (and)
         *
         * [attribute1='value1'],[attribute2='value2'] (or)
         * tagName[attribute1='value1'],[attribute2='value2'] (or)
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

    driver.findElement(By.cssSelector("[aria-label='Accept cookies']")).click();


        WebElement devEx = driver.findElement(By.cssSelector("[id='landingpage-innercontainer-h1'][class='x-large']"));
        System.out.println("devEx.getText() = " + devEx.getText());
        Thread.sleep(2000);

        //* take main text with css multiple attribute value (or)
        WebElement maonText = driver.findElement(By.cssSelector("[id=\"landingpage-innercontainer-p\"],[class=\"lead\"]"));
        System.out.println("maonText.getText() = " + maonText.getText());
        driver.close();


    }
}
