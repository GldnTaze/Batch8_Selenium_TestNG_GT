package com.eurotech.tests.day_11_listOfElements_dropDows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _1_listOfElement_FindElement {
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
    public void findElementsWithCorrectFormula() throws InterruptedException {

        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */

        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);


        List<WebElement> headers = driver.findElements(By.cssSelector(".header-text"));

        //size'ın 6 olduğunu doğrulayalım
        int size = headers.size();
        System.out.println("size = " + size);

        Assert.assertEquals(size, 6, "verify that size is 6");

        //elementlerin textini alalım

        for (WebElement header : headers) {
            System.out.println("header.getText() = " + header.getText());
        }


        //lambda ile text alalım forEach() metodu ile

        headers.forEach(header -> System.out.println(header.getText()));

        //bütün başlıklar görünüyor mu?

        for (WebElement header : headers) {
            Assert.assertTrue(header.isDisplayed());
        }

    }


    @Test
    public void findElementsWithIncorrectFormula() throws InterruptedException {
        /**
         * eğer findElements() metodu ile locate ettiğimiz WebElement listinin locator'ı hatalı olursa..
         * kod hata fırlatmaz, bunun yerine içi boş bir list elde etmiş oluruz..
         * eğer aynı işlem tek bir WebElement için yapılsaydı.. NoSuchElement hatası alacaktık...
         */


        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        List<WebElement> headers = driver.findElements(By.cssSelector(".ihsan"));
        int size = headers.size();
        System.out.println("size = " + size);


    }

    @Test
    public void findElements() throws InterruptedException {

        /**
         * navigate to https://www.saucedemo.com/
         * locate login form elements with one locator (username box, password box and login button)
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         * verify that first web element text is "Sauce Labs Backpack"
         */

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();

        List<WebElement> itemsName = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement itemName : itemsName) {
            System.out.println("itemName.getText() = " + itemName.getText());
        }

        String actualFirstItemName = itemsName.get(0).getText();
        String expectedFirstItemName = "Sauce Labs Backpack";

        Assert.assertEquals(actualFirstItemName, expectedFirstItemName);


    }

    @Test
    public void findElements_Task() throws InterruptedException {

        /**
         * navigate to http://www.eurotech.study/
         * accept cookies
         * click login
         * locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
         * verify that the size of list is 3
         * verify that the value of 3rd element is Login
         * send your credentials to related boxes and then click login button
         * verify success login with "Welcome ......." text
         * locate Experience Credentials and Education Credentials with findElements()
         * then get both element texts and print them
         */

        driver.get("http://www.eurotech.study/");
        driver.findElement(By.id("rcc-confirm-button")).click();
        driver.findElement(By.cssSelector(".btn.btn-light")).click();

        List<WebElement> inputsName = driver.findElements(By.xpath("//input"));
        int size = inputsName.size();
        int expectedSize = 3;
        Assert.assertEquals(size, expectedSize);
        // * verify that the value of 3rd element is Login
        String actualValue = inputsName.get(2).getAttribute("value");
        String expectedValue = "Login";
        Assert.assertEquals(actualValue, expectedValue, "value degerinin Login oldugunu dogrula");

        //* send your credentials to related boxes and then click login button
        inputsName.get(0).sendKeys("cumataze0627@gmail.com");
        inputsName.get(1).sendKeys("cuma.1453");
        inputsName.get(2).click();
        Thread.sleep(2000);
        //* verify success login with "Welcome ......." text
        WebElement success = driver.findElement(By.id("dashboard-p1"));

        String auctualSuccess = success.getText();
        //verify success login with "Welcome ......." text
        String expectedSuccess = "Welcome gulden";
        Assert.assertEquals(auctualSuccess, expectedSuccess);

        //* locate Experience Credentials and Education Credentials with findElements()

        List<WebElement> elements = driver.findElements(By.xpath("//h2"));
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());

        }
        elements.forEach(e -> System.out.println(e.getText()));


        elements.forEach(e -> System.out.println(e.getText()));


    }

}
/**
 * Açıklamalar....
 * findElements() --> bize WebElement'leri bir liste olarak döner.. (1 of 3 ise listede 3 element bulunur..)
 * List<WebElement> inputs = driver.findElements(By.xpath("xPathFormülü"));  // diğer yöntemler de kullanılabilir..
 * elements.get(0).click() --> listenin ilk elementine click yapar
 * elements.get(1).getText() --> listenin ikinci elementinin textini alır.
 * elements.get(2).isDisplayed() --> listenin üçüncü elementinin sayfada görünüp/görünmediğini doğrular..
 * ...
 * findElement() ve findElements() arasındaki farklar..
 * a.  findElement() --> WebElement döner, eğer elementi locate edemezse noSuchElementException fırlatır.
 * b.  findElements() --> WebElement listesi döner. eğer elementleri locate edemezse boş bir liste döner
 * bu nedenle hiçbir zaman noSuchElementException hatası fırlatmaz... bulursa dolu, bulamazsa boş liste verir.
 */




