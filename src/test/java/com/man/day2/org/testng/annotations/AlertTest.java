package com.man.day2.org.testng.annotations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/3.
 */
public class AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     * 1.打开"UI自动化测试"主页
     * 2.点击Alert按钮
     * 3.获取警告框的文本值
     * 4.在alert警告框点击确定按钮
     */
    @Test
    public void alertTest() throws InterruptedException {
        //打开"UI自动化测试"主页
        driver.get("file:///C:/selenium_html/index.html");
        //点击Alert按钮
        WebElement element =driver.findElement(By.className("alert"));
        element.click();
        Thread.sleep(3000);
        //在alert警告框点击确认按钮
        //把控制权转交给alert
        Alert alert=driver.switchTo().alert();
        //获取警告框的文本值
        String text=alert.getText();
        alert.accept();
        Assert.assertEquals(text,"请点击确定");
    }

    /**
     * 1.打开"UI自动化测试"主页
     * 2.点击Confirm按钮
     * 3.在Confirm警告框点击取消按钮
     * 4.再次点击确定按钮
     */
    @Test
    public void ConfirmTest() throws InterruptedException {
        //打开"UI自动化测试"主页
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        //driver 控制权转交给alert
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }

    /**
     * 1.打开"UI自动化测试"主页
     * 2.点击Prompt按钮
     * 3.在Prompt弹框中，输入“这个是Prompt”
     * 4.点击确定按钮
     * 5.再次点击确定按钮
     */
    @Test
    public void PromptTest() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        //打开"UI自动化测试"主页
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert prompt=driver.switchTo().alert();
        prompt.sendKeys("这个是prompt");
        Thread.sleep(2000);
        prompt.accept();
        Thread.sleep(3000);
        prompt.accept();
        Thread.sleep(3000);
        driver.quit();

    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
