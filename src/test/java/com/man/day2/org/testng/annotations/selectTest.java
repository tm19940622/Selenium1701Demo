package com.man.day2.org.testng.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/5/4.
 */
public class selectTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     * 打开我们的测试界面
     * 第一次下拉框选择vivo
     * 第二次下拉框选择huawei
     * 第三次下拉框选择iPhone
     *
     */
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
    // 定位下拉框
        WebElement element=driver.findElement(By.id("moreSelect"));
    //new一个select对象
        Select select=new Select(element);
    //下拉框选择vivo
        select.selectByIndex(2);
        Thread.sleep(3000);
    //下拉框选择huawei
        select.selectByValue("huawei");
        Thread.sleep(3000);
    //下拉框选择iphone
        select.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void closed() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
