package com.man.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/22.
 */
public class JStest {
    WebDriver driver;
    @BeforeTest
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @AfterTest
    public void ClosedChrome(){
        driver.quit();
    }

    @Test
    public void exJs() throws InterruptedException {
        driver.get("http://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\");");
        Thread.sleep(3000);
    }
}
