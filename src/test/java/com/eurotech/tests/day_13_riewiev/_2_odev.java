package com.eurotech.tests.day_13_riewiev;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_odev {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test_1() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde id veya name kullanalım.
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);

        WebElement ifaremeText = driver.findElement(By.tagName("h3"));
        System.out.println(ifaremeText.getText());
        Thread.sleep(2000);
       driver.switchTo().frame("mce_0_ifr");
       Thread.sleep(2000);
        WebElement body = driver.findElement(By.cssSelector("#tinymce"));
        body.clear();
        body.sendKeys("Hello World!");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        WebElement ifaremeText1 = driver.findElement(By.tagName("h3"));
        System.out.println(ifaremeText1.getText());








    }

    @Test
    public void test_2() {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde index kullanalım. index 0'dan başlar..
         */
    }

    @Test
    public void test_3() {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde web element kullanalım.
         */
    }

    @Test
    public void test_4() {
        /**
         * go to https://the-internet.herokuapp.com/nested_frames
         * verify that the MIDDLE text is seen  -- by name
         * verify that the RIGHT text is seen   -- by index
         * verify that the BOTTOM text is seen  --by index
         * NOT: belirtilmeyen geçişlerde istediğiniz yöntemi kullanabilirsiniz..
         */
    }
}
