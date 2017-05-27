package com.man.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 * Created by ManTu on 2017/4/16.
 */
public class OpenBrowserTest {

    @Test
    public void openFF(){
        WebDriver webDriver=new FirefoxDriver();
    }

    @Test
    public void openFf2(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webdriver=new FirefoxDriver();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\chromedriver.exe");
        WebDriver webdriver=new ChromeDriver();
    }

    @Test
    public void openIETest(){
        System.setProperty("webdriver.ie.driver","C:\\Users\\ManTu\\IdeaProjects\\bwebdriver\\drivers\\IEDriverServer.exe");
        WebDriver webdriver=new InternetExplorerDriver();
    }

}
