package com.eurotech.tests.day_15_action_fileUpload_jsExecutor;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_action {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       actions=new Actions(driver);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void hoverHover() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverPara = driver.findElement(By.id("hoverpara"));
       // Actions actions=new Actions(driver);
        actions.moveToElement(hoverPara).perform();

        WebElement hovereffect = driver.findElement(By.id("hoverparaeffect"));
        String actualText=hovereffect.getText();
        String expectedTest="You can see this paragraph now that you hovered on the above 'button'.";
        Assert.assertEquals(actualText,expectedTest);
        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(hovereffect)).isDisplayed());

        WebElement hoverdiv = driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverdiv).perform();
        Assert.assertTrue(new  WebDriverWait(driver,12).until(ExpectedConditions.invisibilityOf(hovereffect)));


    }

    @Test
    public void hoverOver_Task() {
        /**
         * go to https://the-internet.herokuapp.com/hovers
         * locate all users (image on the page) with findElements()
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */
        driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));

            actions.moveToElement(elements.get(0)).build().perform();
        WebElement user1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(user1)).isDisplayed());
        actions.moveToElement(elements.get(1)).perform();
        WebElement user2 = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(user2)).isDisplayed());
        actions.moveToElement(elements.get(2)).perform();
        WebElement user3 = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(user3)).isDisplayed());
    }
  //  -->2.YOL
//    driver.get("https://the-internet.herokuapp.com/hovers");
//    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='figure']"));
//
//        for (int i = 0; i < elements.size(); i++) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(elements.get(i)).perform();
//        Assert.assertTrue(new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(elements.get(i))).isDisplayed());





    // -->3.YOL
    /*
     driver.get("https://the-internet.herokuapp.com/hovers");
        List<WebElement> userElements = driver.findElements(By.className("figure"));
        for (WebElement userElement : userElements) {
            actions.moveToElement(userElement).perform();
            //Thread.sleep(3000);
            Assert.assertTrue(userElement.isDisplayed());
            Assert.assertTrue(new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(userElement)).isDisplayed());
        }
     */


    /*--->dıger yol

     driver.get("https://the-internet.herokuapp.com/hovers");
     //(//img)[2]
     //(//img)[3]
     //(//img)[4]

     //alttaki isimler
     //h5[text()='name:user1']
     //h5[text()='name:user2']
     //h5[text()='name:user3']

        Actions actions = new Actions(driver);
        for (int i = 2; i <=4 ; i++) {

            String imgXpath="(//img)["+i+"]";
            //üzerinde hover yapılan elementlere img dersek
            WebElement img=driver.findElement(By.xpath(imgXpath));

            actions.moveToElement(img).perform();

            String textXpath="//h5[text()='name: user"+(i-1)+"']";
           //üzerinde hover yapılınca altta çıkan yazılara text dersek
            WebElement text=driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(new WevDriverWait,10).until(ExpectedConditions.visibilityOf(user)).isDisplayed());
     */




    @Test
    public void test() {
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */

        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
       // Actions actions=new Actions(driver);
        //1.yol
       actions.dragAndDrop(draggable,droppable).perform();
       //2.yol
        //actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).pause(2000).release().build().perform();
       WebElement dropText = driver.findElement(By.cssSelector("#droppable>p>b"));
       Assert.assertEquals(dropText.getText(),"Dropped!");
       Assert.assertTrue(dropText.isDisplayed());


    }

    @Test
    public void dragAndDrop() {

        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */
        
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHere = driver.findElement(By.cssSelector("#simpleDropContainer p"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        WebElement droppet = driver.findElement(By.cssSelector("#simpleDropContainer p"));
        Assert.assertEquals(droppet.getText(),"Dropped!");
        Assert.assertTrue(droppet.isDisplayed());
    }

    @Test
    public void clickWithAction() throws InterruptedException {
        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         * click on Right Click Test link from left menu (use actions)
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */

        driver.get("https://skill-test.net/mouse-double-click");
        WebElement clicker = driver.findElement(By.id("clicker"));
        actions.doubleClick(clicker).perform();
        //2.yol
        actions.moveToElement(clicker).doubleClick().perform();
        //normal click
        actions.click(clicker).perform();
        //normal click tiklama yeri tarif ederek
        //actions.moveToElement(clicker,5,6).click().perform();
        WebElement rightClickLink = driver.findElement(By.xpath("//span[text()='Right Click Test']"));
        actions.click(rightClickLink).perform();
        WebElement startBtn = driver.findElement(By.id("clicker"));
        actions.contextClick(startBtn).perform();
        Thread.sleep(2000);
        WebElement resetBtn=driver.findElement(By.id("reset"));
        actions.click(resetBtn).perform();


    }

    @Test
    public void rigtClickOpenNewTab() throws InterruptedException {

        //tikladigin yeri yeni sayfada acma

        /**
         * go to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * make right click and open in new tab  (sağ ctrl+click)
         * switch to new opened tab
         * verify that the page title is "EvilTester.com"
         */
      //ctrl+sag click yeni pencerede acar
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.linkText("EvilTester.com"));

        actions.keyDown(Keys.LEFT_CONTROL)//keyDown basili tut demek
                .click(link)
                .keyUp(Keys.LEFT_CONTROL)//elimizi ctrl tusundan kaldir
                .build()
                .perform();
        ArrayList<String>tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actualTitle= driver.getTitle();
        String expectedTitle="EvilTester.com";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
