package com.eurotech.tests.day_12AlertAndMultipleReview;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_JS_Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void jsAlert_Accept() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For Js Alert button
         * create an alert object
         * take text on the alert button and print it
         * click on OK button by using alert object
         * verify that "You successfully clicked an alert" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickFor = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickFor.click();
        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();
        System.out.println( alert.getText());
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        String expectedText="You successfully clicked an alert";
        Assert.assertEquals(actualText,expectedText);


    }

    @Test
    public void jsAlert_Dismiss() {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For JS Confirm button
         * create an alert object
         * take text on the alert button and print it
         * click on CANCEL button by using alert object
         * verify that "You clicked: Cancel" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        clickForConfirm.click();

        Alert alert=driver.switchTo().alert();
        System.out.println( alert.getText());
        alert.dismiss();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText = result.getText();
        String expectedTest="You clicked: Cancel";
        Assert.assertEquals(actualText,expectedTest);


    }

    @Test
    public void jsAlert_SendKeys() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click  JS Prompt button
         * create an alert object
         * take text on the alert button and print it
         * send "Ahmet Ay" text to the bar which is on the alert
         * click on OK button by using alert object
         * verify that "You entered: Ahmet Ay" text is seen
         */


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForJSPromt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        clickForJSPromt.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        String text="Ahmet Ay";
        alert.sendKeys(text);
        Thread.sleep(2000);
        alert.accept();

        //veri
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String actualText=result.getText();
        String expectedText="You entered: "+text;
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void jsAlert_Task() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/alert-test.html
         * click alert box
         * then take message on the js popup and print it
         * accept alert
         *
         * click show confirm box
         * then take message on the js popup and print it
         * dismiss alert
         * verify that you clicked cancel button (Alınan mesajın Cancel içerdiğini doğrula)
         *
         * click show prompt box
         * then take message on the js popup and print it
         * send Ahmet to the popup box
         * accept alert
         * verify that Ahmet is sent to the box.
         *
         * NOT: tüm taskı tek test metodunda yapabilirsiniz..
         */




        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        WebElement alertBox = driver.findElement(By.xpath("//input[@class='styled-click-button'][1]"));
        alertBox.click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(5000);


        WebElement confirmBox = driver.findElement(By.cssSelector("#confirmexample"));
        confirmBox.click();
        Thread.sleep(3000);

        Alert alert1=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        WebElement cancel = driver.findElement(By.cssSelector("#confirmexplanation"));
        String actualtext = cancel.getText();

        String text="Cancel";
        Assert.assertTrue(actualtext.contains(text));

        WebElement promptBox=driver.findElement(By.cssSelector("#promptexample"));
        promptBox.click();
        System.out.println(alert.getText());
        alert.sendKeys("Ahmet");
        Thread.sleep(2000);
        alert.accept();

        WebElement  result= driver.findElement(By.cssSelector("#promptexplanation"));
        String resultText = result.getText();
        Assert.assertTrue(resultText.contains("Ahmet"));


    }
}
