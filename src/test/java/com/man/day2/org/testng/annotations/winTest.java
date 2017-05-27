package com.man.day2.org.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/4.
 */
public class winTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     * 打开测试界面
     * 点击 “Open new window”
     * 点击 baidu
     */
    @Test
    public void WindowSelectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
//      获取当前driver所在的页面的 句柄值
        String handle1=driver.getWindowHandle();
//        For 循环判断 获取到的handles是否等于handle1
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handle1))
                continue;
             driver.switchTo().window(handles);
        }
        driver.findElement(By.linkText("baidu")).click();
    }

    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}
