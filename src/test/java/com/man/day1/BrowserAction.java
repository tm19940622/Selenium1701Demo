package com.man.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/4/16.
 */
public class BrowserAction {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        //打开chrome
        driver=new ChromeDriver();
    }
    /**
     * 打开浏览器
     * 打开 百度首页
     * 等待5s
     * 关闭浏览器
     */
    @Test
    public void getTest() throws InterruptedException{
        //打开百度首页
        driver.get("http://www.baidu.com");
        //等待5S
        Thread.sleep(5000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 打开浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void backTest() throws InterruptedException{
        //打开百度首页
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 打开浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void forwardTest() throws InterruptedException{
        //打开百度首页
        driver.get("http://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().back();
        //等待3s
        Thread.sleep(3000);
        //前进
        driver.navigate().forward();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开 google首页
     * 等待3s
     * 刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void refreshTest() throws InterruptedException{
        //打开百度首页
        driver.get("https://www.google.com.hk ");
        //等待3s
        Thread.sleep(3000);
        //后退
        driver.navigate().refresh();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome浏览器
     * 设置窗口大小 500*500
     * 等待3s
     * 最大化窗口
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public void winTest() throws InterruptedException{
        //设置窗口大小
        Dimension dimension=new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        //等待3s
        Thread.sleep(3000);
        //最大化
        driver.manage().window().maximize();
        //等待3s
        Thread.sleep(3000);
        //关闭浏览器
        driver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开百度首页
     * 获取当前页面的URL
     * 等待3s
     * 校验当前页面URL是不是百度地址
     * 关闭浏览器
     */

    @Test
    public void getUrlTest(){
        //打开百度首页
        driver.get("https://www.baidu.com");
        //获取当前页面的url
        String url=driver.getCurrentUrl();
        System.out.println("获取到的URL是："+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        //关闭浏览器
        driver.quit();
    }

    @AfterTest
    public void closedBrowser(){
        driver.quit();
    }
}
