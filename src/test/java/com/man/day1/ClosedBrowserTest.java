package com.man.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/4/16.
 */
public class ClosedBrowserTest {

    @Test
    public void closedChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        //实例化chromeDriver
        WebDriver driver=new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //关闭当前窗前窗口
        driver.close();
    }

    @Test
    public void closedChrome2() throws InterruptedException{
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        //实例化chromeDriver
        WebDriver driver=new ChromeDriver();
        //等待5s
        Thread.sleep(5000);
        //完全退出浏览器
        driver.quit();
    }
}
