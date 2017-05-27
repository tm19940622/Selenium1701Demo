package com.man.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by ManTu on 2017/4/17.
 */
public class FindElementsTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    /**
     * 打开百度页面
     * 定位搜索文本框
     */

    @Test
    public void byIDTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.id("kw"));
    }


    /**
     * 打开百度页面
     * 通过NAME定位搜索文本框
     */

    @Test
    public void byNameTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.name("wd"));
    }

    /**
     * 打开百度页面
     * 通过Class定位搜索文本框
     */

    @Test
    public void byClassTest() {
        driver.get("http://www.baidu.com");
        WebElement keyField = driver.findElement(By.className("quickdelete"));
    }

    /**
     * 打开百度页面
     * 通过linkText定位link文本
     */

    @Test
    public void bylinkTextTest() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.linkText("新闻"));
    }

    /**
     * 打开百度页面
     * 通过partialLinkText定位link文本
     */

    @Test
    public void bypartialLinkTextTest() {
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.partialLinkText("123"));
    }

    /**
     * 打开百度页面
     * 通过tagName定位搜索文本框
     */
    @Test
    public void byTagName() {
        driver.get("http://www.baidu.com");
        WebElement list = driver.findElement(By.tagName("input"));

    }

    /**
     * 打开百度页面
     * 通过tagName定位搜索文本框们
     */
    @Test

    public void byTagsName() {
        driver.get("http://www.baidu.com");
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());

    }

    /**
     * 打开百度页面
     * 通过Xpath 百度一下按钮
     */
    @Test
    public void byXpath() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"su\"]"));

    }

    /**
     * 打开百度页面
     * 通过Xpath 百度一下按钮
     */
    @Test
    public void byXpath02() {
        driver.get("http://www.baidu.com");
//        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u_sp']/a"));//火狐
        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='u1']/a"));//chrome
 //       System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String text=list.get(i).getText();
            System.out.println(text);

        }
    }

    /**
     * 打开百度页面
     * 通过css 百度图片
     */
    @Test
    public void byCSS() {
        driver.get("http://www.baidu.com");
        WebElement e1 = driver.findElement(By.cssSelector("#s_lg_img"));

    }

    @AfterMethod
    public void closedBrowser() {
        driver.quit();
    }


}
