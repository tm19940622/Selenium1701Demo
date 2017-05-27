package com.man.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/22.
 */
public class PhantomjsTest {
    @Test
    public void pjsTest() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("Phantomjs");
        Thread.sleep(3000);
        String a=driver.getTitle();
        System.out.println(a);
        driver.quit();
    }
}
