package com.ERP.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pomlogin 
{
@FindBy(xpath=".//*[@id='username']")
WebElement un;
@FindBy(xpath=".//*[@id='password']")
WebElement pwd;
@FindBy(xpath=".//*[@id='btnsubmit']")
WebElement login;
@FindBy(xpath=".//*[@id='btnreset']")
WebElement reset;
public void admlgn(String user,String pd)
{
reset.click();
un.sendKeys(user);
pwd.sendKeys(pd);
login.click();
}
}
