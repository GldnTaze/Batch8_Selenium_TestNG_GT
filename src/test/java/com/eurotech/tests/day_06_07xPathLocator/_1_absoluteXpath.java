package com.eurotech.tests.day_06_07xPathLocator;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_absoluteXpath {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open a chrome browser and navigate to "https://demoqa.com/automation-practice-form"
         * locate current address input area with absolute xPath
         * send to the address box area
         * then take the value of address box area
         * verify that both addresses are same
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        WebElement addressInputBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[9]/div[2]/textarea"));
        addressInputBox.sendKeys("Manheim/Kolonya");
        Thread.sleep(2000);
        String actualAdress=addressInputBox.getAttribute("value");
        String expectedAdrese="Manheim/Kolonya";
        if (actualAdress.equals(expectedAdrese)){
            System.out.println("pass");
        }else {
            System.out.println("failed");
        }
        Thread.sleep(2000);
        driver.close();
    }

}
