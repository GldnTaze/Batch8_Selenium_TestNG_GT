package com.eurotech.tests.day_09_testEG_INTRO;

import org.testng.annotations.*;

public class _2_BeforAfterMetod {
    @Test(priority = 2)
    public void test1() {
        System.out.println("test 1");
    }

    @Test(priority = 1)
    // @Ignore //(enabled=false)-->ikinci yontem                  //@Ignore  -->testı kosturmaz
    public void test2() {
        System.out.println("test 2");
    }


    @Test(priority = 3)
    public void test3() {
        System.out.println("test 3");
    }

    @Test
    public void test4() {
        System.out.println("test 4");
    }

    @BeforeMethod

    public void setUP() {
        System.out.println("before metod");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeTest
    public void beforTest() {
        System.out.println("before Test");
    }


    @AfterTest
    public void afterTest(){
        System.out.println("after Test");
    }
    @BeforeSuite
    public void beforSuite(){
        System.out.println("befor Suite");
    }

@AfterSuite
    public void afterSuite(){
    System.out.println("after Suite");
}
}




