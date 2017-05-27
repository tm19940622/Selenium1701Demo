package com.man.day3;

import com.po.page.LoginPage;
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
 * Created by ManTu on 2017/5/23.
 */
public class LoginTest {
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

    @Test
    public void LoginSuccess(){

        LoginTest.login(driver,"13859960491","tm520bm622115");
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String logout=driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");

    }

    @Test
    public void LoginFail(){

        LoginTest.login(driver,"13859960491","123");
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nerror']/div[2]")));

        String fail=driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        Assert.assertEquals(fail,"帐号或密码错误");

    }
    @Test
    public static void login(WebDriver driver,String email,String password){
        //将控制权转交给iframe
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.emailInput).sendKeys(email);
        driver.findElement(LoginPage.pwdInput).sendKeys(password);
        driver.findElement(LoginPage.loginButton).click();
    }
}
