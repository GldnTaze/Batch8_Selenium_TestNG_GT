package com.eurotech.tests.day_09_testEG_INTRO;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_TestNG_AssertionsDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("************OPEN BROWSER********");
    }

    @AfterMethod
    public void tearDown(){

        System.out.println("************CLOSE BROWSER*****");

    }

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("ayse3","ayse");

        System.out.println("second Assertion");
        Assert.assertEquals("ali","ali");
    }

    @Test
    public void test2(){
        System.out.println("Third Assertion");
        Assert.assertEquals("url","url");


    }


    @Test
    public void test3() {
        String str="eurotech";
        String str1="euro";
        String mail="aaaaa@aaaaa.com";
        Assert.assertTrue(str.startsWith(str1));

        Assert.assertTrue(mail.contains("@"),"verify thatt mail contains @");
        Assert.assertTrue(mail.contains("@")&&mail.contains("com"),"verify thatt mail contains @");
    }

    @Test
    public void test4() {
        String str="euroTech";
        Assert.assertFalse(str.contains("@"));
        Assert.assertNotEquals("ali","ayse");

    }
    @Test
    public void test5() {
        String str = "Ahmet";
        String str1 = null;
        Assert.assertNotNull(str);
        Assert.assertNull(str1);
    }

}
