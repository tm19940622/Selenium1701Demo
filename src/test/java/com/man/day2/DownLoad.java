package com.man.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * Created by ManTu on 2017/5/22.
 */
public class DownLoad {
    WebDriver driver;
    @BeforeTest
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void ClosedChrome(){
        driver.quit();
    }

    @Test
    public void download() throws AWTException, InterruptedException {
        //进入测试页面
        driver.get("https://www.baidu.com");
        //搜索框输入notepad++
        driver.findElement(By.id("kw")).sendKeys("notepad++");
        //点击搜索按钮
        driver.findElement(By.id("su")).click();
        //显示等待
/*
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("./*/
/*[text()='普通下载']")));
*/
        //点击普通下载按钮
        driver.findElement(By.xpath(".//*[text()='普通下载']")).click();
        //确认下载
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
    }
}
