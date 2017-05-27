package com.man.day3;

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
 * Created by ManTu on 2017/5/22.
 */
public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://mail.163.com/");
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }

    /**
    * 注册失败
    * */
    @Test
    public void register(){
        //控制权转交个iframe
        driver.switchTo().frame("x-URS-iframe");
        //点击去注册按钮
        driver.findElement(By.id("changepage")).click();
        //获取当前driver所在的handle值
        String handle1=driver.getWindowHandle();
        //driver切换到新的页面
        for(String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles);
        }

        String time=String.valueOf(System.currentTimeMillis()/100);
        //输入邮箱地址
        driver.findElement(By.id("nameIpt")).sendKeys("tm"+time);
        //输入密码
        driver.findElement(By.id("mainPwdIpt")).sendKeys("tm123456");
        //确认密码
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("tm123456");
        //输入手机号
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time);
        //输入验证码
        driver.findElement(By.id("vcodeIpt")).sendKeys("abcdef");
        //输入短信验证码
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("123456");
        //点击立即注册按钮
        driver.findElement(By.id("mainRegA")).click();
        //显示等待
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));
        //校验报错信息
        String error=driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(error,"  手机验证码不正确，请重新填写");

    }
}
