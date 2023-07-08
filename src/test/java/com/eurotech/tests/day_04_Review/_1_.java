package com.eurotech.tests.day_04_Review;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class _1_ {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.abeyis.com");

        driver.manage().window().maximize();

    }
}
