package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by ManTu on 2017/5/26.
 */
public class LoginPage {
    //定义email文本框的定位方式
    public static By emailInput=By.name("email");
    //定义密码输入框的定位方式
    public static By pwdInput=By.name("password");
    //定义登录按钮的定位方式
    public static By loginButton=By.id("dologin");
    //去注册
    public static By RegisterButton=By.id("changepage");
}
