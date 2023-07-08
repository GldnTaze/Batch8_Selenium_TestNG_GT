package com.eurotech.tests.day_13_riewiev;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ {
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
    public void iframeWithIdAndElement() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by id
         * take the "iFrame" heading and print it
         * return to main html
         * switch to second frame by web element
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);
        driver.switchTo().frame("thedynamichtml");
        WebElement title1 = driver.findElement(By.tagName("h1"));
        System.out.println(title1);

        driver.switchTo().parentFrame();

        WebElement frame2 = driver.findElement(By.cssSelector("[src='frames/frames-header.html']"));
        driver.switchTo().frame(frame2);

        WebElement title2 = driver.findElement(By.tagName("h1"));
        System.out.println(title2);

         driver.switchTo().defaultContent();
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
    }

    @Test
    public void iframeWithIndex() throws InterruptedException {

        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by index
         * take the "iFrame" heading and print it
         * return to main html  (default content)
         * switch to second frame by index
         * take the "Nested Page Example" heading and print it
         */


        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        Thread.sleep(2000);
        driver.switchTo().frame(0);

        WebElement title1 = driver.findElement(By.tagName("h1"));
        System.out.println(title1);

        driver.switchTo().frame(1);

        WebElement frame2 = driver.findElement(By.cssSelector("[src=frames/frames-header.html]"));
        driver.switchTo().frame(frame2);

        WebElement title2 = driver.findElement(By.tagName("h1"));
        System.out.println(title2);

        driver.switchTo().defaultContent();
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
    }

    @Test
    public void nestedFrame_Task() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/frames/frames-test.html
         * switch to top frame by name attribute
         * take the "Nested Frames Example" heading and print it
         * return to main html
         * switch to left frame by name attribute
         * take the "Left" heading and print it
         * return to main html
         * switch to middle frame by index
         * take the "Middle" heading and print it
         * return to main html
         * switch to right frame by web element
         * take the "Right" heading and print it
         * return to main html
         * switch to footer frame by index
         * take the "EvilTester.com" link text and print it
         */
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        Thread.sleep(2000);
        WebDriver top = driver.switchTo().frame("name");

driver.switchTo().defaultContent();
        WebElement nestedText = driver.findElement(By.xpath("//h1[text()='Nested Frames Example']"));
        System.out.println(nestedText);


    }

    @Test
    public void nestedFrames() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to main frame related method
         * take the "Nested Frames" heading and print it
         */

        driver.get("https://demoqa.com/nestedframes");
        Thread.sleep(2000);
        driver.switchTo().frame("frame1");
        WebElement headingParent = driver.findElement(By.tagName("body"));
        System.out.println(headingParent);
        driver.switchTo().frame(0);
        String headingChild = driver.findElement(By.tagName("p")).getText();
        System.out.println(headingChild);

        driver.switchTo().defaultContent();
        String mainHeading = driver.findElement(By.cssSelector(".main-header")).getText();
    }
}
/**
 * No Such Element Exception aldığımızda
 * 1- Locator might be wrong or dynamic or not correct-Locator/konumlandırıcı
 yanlış veya dinamik olabilir veya doğru olmayabilir.
 * 2- Not enough wait time - Yeterli bekleme süresi yok
 * 3- There is a frame or iframe -Bir frame veya iframe var !
 - Html'de bir HTML sayfasının içinde bir diğer HTML yapısı olabilir.
 - Bu, <iframe> veya <frame> etiketi ile sağlanır.
 - Frame varsa, selenyum frame içinde ne olduğunu kontrol edemez.
 - Önce iframe'i değiştirmeliyiz. (switchTo() metodu ile)
 - iframe'e geçtiğimizde, selenium biz geri değiştirene kadar ana HTML sayfasını ve diğer frame yapılarını göremez,
 - Bir seferde sadece bir frame değiştirebiliriz ve torunlara doğrudan geçilmez.
 - kardeş/sibling arası geçiş/switch olmaz sadece ebeveynden çocuğa/parentchild.
 - child frameden bir üste yani parenta switchTo().parentFrame(); ile geçeriz.
 - en üstteki ana HTML (default) yapısına ise switchTo().defaultContent(); ile geçebiliriz.
 - bulunduğumuz frame'den bir üste ya da en üste (ana HTML) geçiş vardır. iki, üç vb. üstlere geçiş yoktur.
 */
