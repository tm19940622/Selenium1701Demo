package com.man.day2.org.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/10.
 */
public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    /**
    *打开测试界面
     * 点击 wait 按钮
     * 获取文本，并判断是否为“wait for display"
     */
    public void WaitTest() throws InterruptedException {
        //打开测试界面
        driver.get("file:///C:/selenium_html/index.html");
        //点击wait 按钮
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
//        Thread.sleep(5000);

        String text=driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
        Assert.assertEquals(text,"wait for display");

    }

    @Test
    /**
     *打开测试界面
     * 点击 wait 按钮
     * 获取文本，并判断是否为“wait for display"
     */
    public void WaitTest2() throws InterruptedException {
        //打开测试界面
        driver.get("file:///C:/selenium_html/index.html");
        //点击wait 按钮
        driver.findElement(By.xpath(".//*[@id='wait']/input")).click();
//        Thread.sleep(5000);
        //显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='display']/div")));

        String text=driver.findElement(By.xpath(".//*[@id='display']/div")).getText();
        Assert.assertEquals(text,"wait for display");

    }


    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
