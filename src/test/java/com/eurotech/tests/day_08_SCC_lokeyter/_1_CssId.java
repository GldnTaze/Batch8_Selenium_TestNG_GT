package com.eurotech.tests.day_08_SCC_lokeyter;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_CssId {
    public static void main(String[] args) throws InterruptedException {
        /**
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         *--------------------
         * #id
         * tagName#id
         * -------------------
         * .className
         * tagName.className
         * Note: eğer class name'de boşluk varsa silinip yerine . (nokta) konulur.
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //cookies
        driver.findElement(By.cssSelector("#rcc-confirm-button")).click();

        WebElement signBtn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signBtn.click();
        Thread.sleep(2000);

        WebElement nameInput=driver.findElement(By.cssSelector("input#signuppage-form-name-input"));
        nameInput.click();
        nameInput.sendKeys("Ahmet");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(2000);
        driver.close();

    }
}
