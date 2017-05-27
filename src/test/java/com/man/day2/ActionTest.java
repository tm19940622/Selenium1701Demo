package com.man.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


/**
 * Created by ManTu on 2017/4/26.
 */
public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    /**
     * 我要点击报读首页的新闻链接
     **/
    @Test
    public void clickTest(){
        driver.get("http://www.baidu.com");
        //定位新闻链接
        WebElement newslink=driver.findElement(By.name("tj_trnews"));
        //点击新闻链接
        newslink.click();
        //获取当前页面的URL
        String url= driver.getCurrentUrl();
        //检验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度一下进行搜索
     * 检验title是否等于“selenium_百度搜索”
     **/
    @Test
    public void sendKeysTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //获取文本输入框
        WebElement element=driver.findElement(By.id("kw"));
        //输入关键字selenium
        element.sendKeys("selenium");
        ///获取百度一下按钮
        WebElement Button=driver.findElement(By.id("su"));
        //点击一下按钮
        Button.click();
        //等待3s
        Thread.sleep(3000);
        //获取页面的Title
        String Title=driver.getTitle();
        //检验Title是否等于"selenium_百度搜索"
        Assert.assertEquals(Title,"selenium_百度搜索");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 清空输入框
     **/
    @Test
    public void clearTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //获取文本输入框
        WebElement element=driver.findElement(By.id("kw"));
        //输入关键字selenium
        element.sendKeys("selenium");
        //等待5s
        Thread.sleep(5000);
        ///清空输入框
        element.clear();
        //等待3s
        Thread.sleep(3000);


    }

    /**
     * 打开百度首页
     * 获取新闻文本
     **/
    @Test
    public void getTextTest(){
        driver.get("http://www.baidu.com");
        String text=driver.findElement(By.name("tj_trnews")).getText();
        System.out.println(text);


    }

    /**
     * 打开百度首页
     * 获取当前页面的Title
     * 校验title值等于“百度一下，你就知道”
     **/

    @Test
    public void getTitleTest(){
        //打开百度首页
        driver.get("http://www.baidu.com");
        //获取当前页面的title
        String title=driver.getTitle();
        //校验title值等于“百度一下，你就知道”
        Assert.assertEquals(title,"百度一下，你就知道");

    }


    /**
     * 打开百度首页
     * 检验百度一下按钮已经展示
     **/

    @Test
    public void isDisplayTest(){
        //打开百度首页
        driver.get("http://www.baidu.com");
        //检验百度一下按钮已经展示
        Boolean bl=driver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(bl);
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     **/
    @Test
    public void isSelectedTest(){
        //打开测试页面
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element=driver.findElement(By.xpath(".//*[@id='radio']/input[1]"));
        element.click();
        Boolean sl=driver.findElement(By.xpath(".//*[@id='radio']/input[1]")).isSelected();
        Assert.assertTrue(sl);
    }


    /**
     * 打开百度首页
     * 获取文本框的 tagname
     * 校验是否为input
     */

    @Test
    public void getTagNameTest(){
        driver.get("http://www.baidu.com");
        String tagName=driver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度首页
     * 判断按钮显示的文本值为  百度一下
     */
    @Test
    public void getAtest(){
        driver.get("http://www.baidu.com");
        String s=driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(s,"百度一下");
    }

    /**
     * 打开测试页面
     * 判断submit按钮处于未激活状态
     */
    @Test
    public void isEnableTest(){
        driver.get("file:///C:/selenium_html/index.html");
        Boolean al=driver.findElement(By.xpath(".//*[@id='id01']/preceding-sibling::*")).isEnabled();
        Assert.assertFalse(al);
    }

    /**
     * 截图百度首页
     */

    @Test
    public void shotScreenTest(){
        driver.get("http://www.baidu.com");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\test1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }



    @AfterMethod
    public void closed(){
        driver.quit();
    }

}
