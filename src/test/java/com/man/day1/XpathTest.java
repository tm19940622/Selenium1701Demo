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
 * Created by ManTu on 2017/4/24.
 */
public class XpathTest {
    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
    }

    /**
     * 打开百度页面
     * 通过Xpath 测试/用在中间表示绝对路径
     */
    @Test
    public void byXpath01(){
        WebElement e1=driver.findElement(By.xpath("/html/body"));
    }

    /**
     * 打开百度页面
     * 通过Xpath 测试用//表示相对路径
     * 表示选择根目下的所有的子孙后代节点中的div节点
     */
    @Test
    public void byXpath02(){
        WebElement e2=driver.findElement(By.xpath("/html//div"));
    }
    /**
     * 打开百度页面
     * 通过Xpath 测试用//表示相对路径
     * /html//div表示根节点html下的所有子孙后代阶段中的div节点
     * //div表示选择所有的div节点，由于所有的div节点均在根节点html下
     * 因此/html//div与//div是表示的相同的节点
     */
    @Test
    public void byXpath03(){
        WebElement e3=driver.findElement(By.xpath("//div"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  //div/div
     * 表示所有div节点的子节点中含div的节点
     */
    @Test
    public void byXpath04(){
        WebElement e4=driver.findElement(By.xpath("//div/div"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  //div/div/.
     * 表示//div/div节点的当前层的节点 同//div/div
     */
    @Test
    public void byXpath05(){
        WebElement e5=driver.findElement(By.xpath("//div/div/."));
    }

    /**
     * 打开百度页面
     * 通过Xpath  //div/div/..
     * 表示选取某div节点，其子节点中含div节点
     */
    @Test
    public void byXpath06(){
        WebElement e6=driver.findElement(By.xpath("//div/div/.."));
    }

    /**
     * 打开百度页面
     * 通过Xpath  //div/div/*
     * 表示//div/div节点的所有子节点
     */
    @Test
    public void byXpath07(){
        WebElement e7=driver.findElement(By.xpath("//div/div/*"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  //div/div/*
     * 表示//div/div节点的所有子节点
     */
    @Test
    public void byXpath08(){
        WebElement e8=driver.findElement(By.xpath("//div/div/*"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  获取百度页面logo
     */
    @Test
    public void byXpath09(){
        WebElement e9=driver.findElement(By.xpath("//*[@id='lg']"));
    }

    /**
     * 打开百度页面
     * 通过Xpath //div[@id='input']/input
     */
    @Test
    public void byXpath10(){
        WebElement e10=driver.findElement(By.xpath("//*[@id='form']/input"));
    }

    /**
     * 打开百度页面
     * 通过Xpath //table//input[@id='user']
     */
    @Test
    public void byXpath11(){
        List<WebElement> e11=driver.findElements(By.xpath("//form//input[@type='hidden']"));
        System.out.println(e11.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath 用多个属性定位出唯一的节点--and
     */
    @Test
    public void byXpath12(){
        List<WebElement> e12=driver.findElements(By.xpath("//form//input[@type='hidden' and @value='1']"));
        System.out.println(e12.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath 用多个属性定位出唯一的节点--or
     */
    @Test
    public void byXpath13(){
        List<WebElement> e13=driver.findElements(By.xpath("//form//input[@value='1' or @name='f']"));
              System.out.println(e13.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath 用多个属性定位出唯一的节点,但只定位其中的一个
     */
    @Test
    public void byXpath14(){
        WebElement e14=driver.findElement(By.xpath("//form//input[@value='1' or @name='f'][2]"));
    }

    /**
     * 打开百度页面
     * 通过Xpath 使用last()函数 用多个属性定位出唯一的节点,但只定位最后一个
     */
    @Test
    public void byXpath15(){
        WebElement e15=driver.findElement(By.xpath("//form//input[@value='1' or @name='f'][last()]"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  对父节点和子节点均使用index以定位到唯一的节点
     */
    @Test
    public void byXpath16(){
        WebElement e16=driver.findElement(By.xpath("//div//form[1]//input[@type='hidden'][1]"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  使用contains()函数来定位节点
     */
    @Test
    public void byXpath17(){
        List<WebElement> e17=driver.findElements(By.xpath("//div//form//input[contains(@type,'hidden')]"));
        System.out.println(e17.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  使用text()函数来定位节点
     */
    @Test
    public void byXpath18(){
        WebElement e18=driver.findElement(By.xpath("//a[text()='拼音']"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  使用starts-with()函数来定位节点
     */
    @Test
    public void byXpath19(){
        WebElement e19=driver.findElement(By.xpath("//div[starts-with(@id,'head')]"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  使用not()函数+contains()函数来定位节点
     */
    @Test
    public void byXpath20(){
        WebElement e20=driver.findElement(By.xpath("//form//input[@type='hidden' and not(contains(@value,'1'))]"));
    }

    /**
     * 打开百度页面
     * 通过Xpath  只使用not()函数来定位节点
     */
    @Test
    public void byXpath21(){
       List<WebElement>  e21=driver.findElements(By.xpath("//form//input[not(@class)]"));
        System.out.println(e21.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴ancestor 选取当前节点的所有先辈
     */
    @Test
    public void byXpath22(){
        List<WebElement>  e22=driver.findElements(By.xpath("//form/ancestor::*"));
        System.out.println(e22.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴ancestor-or-self 选取当前节点的所有先辈以及节点本身
     */
    @Test
    public void byXpath23(){
        List<WebElement>  e23=driver.findElements(By.xpath("//form/ancestor-or-self::*"));
        System.out.println(e23.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴attribute 选取某节点的所有属性
     */
    @Test
    public void byXpath24(){
        List<WebElement>  e24=driver.findElements(By.xpath("//form//input[attribute::*]"));
        System.out.println(e24.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴child 选取当前节点的所有子元素
     */
    @Test
    public void byXpath25(){
        List<WebElement>  e25=driver.findElements(By.xpath("//span/child::*"));
        System.out.println(e25.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴descendant 选取当前节点的所有后代元素中为input节点的第一个
     */
    @Test
    public void byXpath26(){
        List<WebElement>  e26=driver.findElements(By.xpath("//form/descendant::input[1]"));
        System.out.println(e26.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴descendant-or-self 选取当前节点的所有后代元素以及当前节点本身
     */
    @Test
    public void byXpath27(){
        List<WebElement>  e27=driver.findElements(By.xpath("//form/descendant-or-self::*"));
        System.out.println(e27.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴following 选取文档中当前节点的结束标签之后的第一个div节点
     */
    @Test
    public void byXpath28(){
        List<WebElement>  e28=driver.findElements(By.xpath("//form/following::div[1]"));
        System.out.println(e28.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴following-sibling 选取文档中当前节点的结束标签之后的所有同级节点
     */
    @Test
    public void byXpath29(){
        List<WebElement>  e29=driver.findElements(By.xpath("//form/following-sibling::*"));
        System.out.println(e29.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴parent 选取当前节点的父节点
     */
    @Test
    public void byXpath30(){
        List<WebElement>  e30=driver.findElements(By.xpath("//form//input/parent::*"));
        System.out.println(e30.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴preceding 选取当前节点的开始标签之前的所有节点
     */
    @Test
    public void byXpath31(){
        List<WebElement>  e31=driver.findElements(By.xpath("//form//input[2]/preceding::*"));
        System.out.println(e31.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴preceding-sibling 选取当前节点之前的所有同级节点
     */
    @Test
    public void byXpath32(){
        List<WebElement>  e32=driver.findElements(By.xpath("//form//input[6]/preceding-sibling::*"));
        System.out.println(e32.size());
    }

    /**
     * 打开百度页面
     * 通过Xpath  轴self 选取当前节点
     */
    @Test
    public void byXpath33(){
        List<WebElement>  e33=driver.findElements(By.xpath("//form//input[6]/self::*"));
        System.out.println(e33.size());
    }



    @AfterMethod
    public void closeChrome(){
        driver.quit();
    }
}
