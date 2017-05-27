package com.man.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by ManTu on 2017/5/14.
 */
public class ActionsTest2 {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }

    /**
     * 打开百度页面
     * 在百度一下按钮上右键
     */
    @Test
    public void rightClickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ButtonBaidu =driver.findElement(By.id("su"));
        Thread.sleep(3000);
        //实例化Actions类
        Actions builder=new Actions(driver);
        //在百度页面右键点击百度一下按钮
        builder.contextClick(ButtonBaidu).perform();
        Thread.sleep(3000);
    }

    /**
     * 打开百度页面
     * 双击百度一下按钮
     */
    @Test
    public void doubleClickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement ButtonBaidu=driver.findElement(By.id("su"));
        Thread.sleep(3000);
        //实例化Actions类
        Actions builder=new Actions(driver);
        //双击百度一下按钮
        builder.doubleClick(ButtonBaidu).perform();
        Thread.sleep(3000);
    }

    /**
     * 打开测试页面
     * 鼠标移动到action按钮
     * 那么显示hello world
     */

    @Test
    public void move(){
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element =driver.findElement(By.xpath(".//*[@id='action']/input"));
        //实例化Actions类
        Actions Builder=new Actions(driver);
        //鼠标移动到action按钮
        Builder.moveToElement(element).perform();

        String hello=driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();

        Assert.assertEquals(hello,"Hello World!");
    }

    /**
     * 打开测试页面
     * 把元素拖动到（x,y）
     */
    @Test
    public void DragAndDropTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        WebElement element=driver.findElement(By.id("drag"));
        //实例化Actions
        Actions Builder=new Actions(driver);
        //把元素拖动到（X,Y）
        Builder.dragAndDropBy(element,500,500).perform();
        Thread.sleep(3000);
    }

    /**
     * 打开测试页面
     * 把元素拖动到另一个元素上
     */
    @Test
    public void testClickAndHold() throws InterruptedException {
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        WebElement element1=driver.findElement(By.id("drag"));
        WebElement element2=driver.findElement(By.xpath("/html/body/h1"));
        Thread.sleep(3000);
        //实例化Actions
        Actions Builder=new Actions(driver);
        Builder.clickAndHold(element1)
                .moveToElement(element2)
                .release(element1)
                .perform();
    }

    @Test
    public void moreSelectAlert() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        WebElement element=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));

        List<WebElement> list=driver.findElements(By.xpath(".//*[@id='selectWithMultipleEqualsMultiple']/option"));

        Thread.sleep(5000);
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(1))
                .click(list.get(2))
                .keyUp(Keys.CONTROL)
                .perform();

        Thread.sleep(5000);

    }


    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        driver.get("http://www.baidu.com");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        int keys=(int) new Character('S');
        System.out.println(keys);
        robot.keyPress(keys);
        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.id("load"))
                .sendKeys("C:\\Users\\ManTu\\Desktop\\a.png");
        Thread.sleep(5000);

    }

}
