package com.man.day2.org.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/4.
 */
public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
    //  通过ID或者name方式转交控制权
    //  driver.switchTo().frame("aa");
    //  通过webelement方式(有多个iframe时)
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
        Thread.sleep(3000);

    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
}
}