package com.man.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ManTu on 2017/5/23.
 */
public class SendEmailTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://mail.163.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }

    @Test
    public void SendEmailTest() throws InterruptedException {
        //登录成功
        LoginTest.login(driver,"13859960491","tm520bm622115");

//        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")));
        //点击写信按钮
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("13859960491");
       //定位主题文本框 并输入文本
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("13859960491");
//        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")));

        //上传文件
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\ManTu\\Desktop\\1.txt");
        Thread.sleep(5000);
        //定位iframe
        WebElement frame=driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("html/body")).sendKeys("13859960491");

        //driver控制权转交回页面
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[text()='发送']")).click();

        String success=driver.findElement(By.xpath(".//*[text()='发送成功']")).getText();
        Assert.assertEquals(success,"发送成功可用手机接收回复");
    }
}
