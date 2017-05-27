package com.man.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ManTu on 2017/5/25.
 */
public class TestGrid {
    @Test
    public void gridTest() throws MalformedURLException, InterruptedException {
        //创建一个DesiredCapabilities类型
        DesiredCapabilities dc=DesiredCapabilities.chrome();
        //实例化一个driver
        WebDriver driver=new RemoteWebDriver(new URL("http://10.10.18.135:4446/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }

    @DataProvider(name="data1")
    public Object[][] test1(){
        return new Object[][]{
                {"firefox","http://10.10.18.135:5556"},
                {"chrome","http://10.10.18.135:6666"}
        };
    }

    @Test(dataProvider="data1")
    public void gridTest2(String browser,String URL) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc=null;
        if (browser.equals("firefox")){
            dc=DesiredCapabilities.firefox();
        }else if (browser.equals("chrome")){
            dc=DesiredCapabilities.chrome();
        }else{
            System.out.println("error");
        }

        //实例化一个driver
        WebDriver driver=new RemoteWebDriver(new URL(URL+"/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
}
