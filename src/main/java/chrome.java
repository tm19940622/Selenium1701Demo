import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ManTu on 2017/4/12.
 */

/**
 * public class chrome {
 public static void main(String[] args) {//主静态方法
 System.out.println("welcome to java");//sout
 WebDriver driver=new FirefoxDriver();
 driver.get("http://www.cloudits.info");
 }
 }
 */



 public class chrome{
  public static WebDriver driver;
 public static void main(String[] args) {
 System.out.println("welcome to java");
 chrome.newFireFox("http://www.baidu.com");
 chrome.getTitle();
 String mvs= chrome.getTitle1();
 }

 public static void newFireFox(String Url){
 driver=new FirefoxDriver();
 driver.get(Url);
// element=driver.findElement(By.xpath(".//*[@id='kw']"));
// element.sendKeys("");
 driver.findElement(By.xpath("//*[@id='su']"));
 }

 public static void getTitle(){
  System.out.println(driver.getTitle());
 }
 public static String getTitle1(){
  return (driver.getTitle());
 }
 }

