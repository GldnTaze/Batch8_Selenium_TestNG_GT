package com.eurotech.tests.day_11_listOfElements_dropDows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _2_DropDownWithSelectTag {
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
    public void dropDownWitSelectTag() throws InterruptedException {
        /**
         * Select Menu
         * go to https://demoqa.com/select-menu
         * locate Old Style Select Menu (dropdown menu)
         * get all colorsOptions(web elements) as a list
         * verify that the number of webElement is 11
         * click (select) green
         * verify that the selected option's text is 'Green'
         */


        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);

        WebElement dropDownElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropDownElement);

        //bütün opsiyonları bir liste alalım
        List<WebElement> colorsOptions = select.getOptions();

        int expectedSize = 11;
        int actualSize = colorsOptions.size();

        Assert.assertEquals(actualSize, expectedSize);

        for (WebElement colorsOption : colorsOptions) {
            System.out.println("colorsOption.getText() = " + colorsOption.getText());
        }

        colorsOptions.get(2).click();
        Thread.sleep(2000);

        WebElement green = select.getFirstSelectedOption();

        String actualText = green.getText();
        String expectedText = "Green";

        Assert.assertEquals(actualText, expectedText);

        /**  ikinci yontem   gorunebilir metodu
         * select the blue option by visible text method
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Blue'
         */
        select.selectByVisibleText("Blue");
        Thread.sleep(2000);

        WebElement blue = select.getFirstSelectedOption();

        String actualText_1 = blue.getText();
        String expectedText_1 = "Blue";

        Assert.assertEquals(actualText_1, expectedText_1);


        /** 3. yöntem index se gore
         * select the black option by index method
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Black'
         */
        select.selectByIndex(5);
        WebElement black = select.getFirstSelectedOption();

        String actualText_2 = black.getText();
        String expectedText_2 = "Black";
        Assert.assertEquals(actualText_2, expectedText_2);

        /**
         * select the voilet option by value attribute methote
         * get the selected webElement and put into a webElement bucket by getFirstSelectedOption() (assigning)
         * verify that the selected option's text is 'Voilet'
         */
        select.selectByValue("7");//sitring olarak sectik
        Thread.sleep(2000);
        WebElement voilet = select.getFirstSelectedOption();
        String actualText_3 = voilet.getText();
        String expectedText_3 = "Voilet";
        Assert.assertEquals(actualText_3, expectedText_3);

    }

    @Test
    public void dropDownWithSelectTag_Task() throws InterruptedException {
        /**
         * navigate to https://www.amazon.com/"
         * locate the dropdown menu nearby the search box
         * select the Baby department by using text then print the department name
         * select the Books department by using index then print the department name
         * select the Health & Household department by using value attribute then print the department name
         * get all options to a list
         * print all departments name
         * get the text of fifth element and verify that the text is Books
         */
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);

        WebElement dropDownElement = driver.findElement(By.xpath("//select"));
        Select select = new Select(dropDownElement);
        //select the Baby department by using text then print the department name
        select.selectByVisibleText("Baby");
        Thread.sleep(3000);
        WebElement baby = select.getFirstSelectedOption();
        System.out.println("baby.getText() = " + baby.getText());

        // select the Books department by using index then print the department name

        select.selectByIndex(5);
        Thread.sleep(2000);
        WebElement books = select.getFirstSelectedOption();
        System.out.println("books.getText() = " + books.getText());


        //select the Health & Household department by using value attribute then print the department name
        select.selectByIndex(12);
        Thread.sleep(2000);
        WebElement health = select.getFirstSelectedOption();
        System.out.println("health.getText() = " + health.getText());

        // * get all options to a list
        //-->2.yontem  allDepartments.forEach(e-> System.out.println(e.getText()));
        List<WebElement> allDepartments = select.getOptions();
        for (WebElement allDepartment : allDepartments) {
            System.out.println("allDepartment.getText() = " + allDepartment.getText());
        }
        String actualText = allDepartments.get(5).getText();
        String expectedText = "Books";
        Assert.assertEquals(actualText, expectedText);


    }

}

/**
 * AÇIKLAMALAR:
 * Özel bir web element yapısına sahiptir.
 * İki yolla locate edilirler.
 * <p>
 * 1. Normal yol --> Web element bilinen yollar ile locate edilir ve manual olarak yapılan işlemler koda aktarılır.
 * Note: Eğer menüdeki elementleri inspect yapamıyorsanız
 * --> right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
 * <p>
 * 2.Select class --> Eğer dropdown elementi select tagı ile yapılmışsa seleniumdan gelen
 * 'Select' class bu menudeki opsiyonlarla iletişime geçmek için kullanılır.
 * 2.1. Dropdown web elementi locate edilir (select tagıyla olan yer) -->
 * WebElement dropDown = driver.findElement(By.xpath("formula"));
 * <p>
 * 2.2. Select classından bir select nesnesi oluşturulur. --> Select select = new Select(dropDown);
 * 2.2.1 select.getOptions() --> menudeki bütün seçenekleri bir WebElement liste alır.
 * 2.2.2 select.selectByVisibleText("...") --> görünen texte göre elementi seçtirir.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 * 2.2.3 select.selectByIndex("...") --> index (sıra no) ile elementi seçtirir.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 * 2.2.4 select.selectByValue("...") value attribute değeri ile elementi seçtiri.
 * select.getFirstSelectedOption() --> seçilen element ilk sıraya geçer. Bu elementi bir variable assign ederiz.
 */


