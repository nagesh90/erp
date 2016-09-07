package com.ERP.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basic_script {

	
	public static void main(String[] args) 
	{

	WebDriver d=new FirefoxDriver();
	d.navigate().to("http://webapp.qedgetech.com");
	d.manage().window().maximize();
	String Expval="Login";
	String Actval=d.findElement(By.id("btnsubmit")).getText();
	if (Expval.equalsIgnoreCase(Actval))
	{
	System.out.println("app passed");	
	}
	else
	{
		System.out.println("app failed");
	}
	d.findElement(By.id("btnreset")).click();
	d.findElement(By.id("username")).sendKeys("admin");
	d.findElement(By.id("password")).sendKeys("master");
	d.findElement(By.id("btnsubmit")).click();
	String Exptitle="Dashboard";
	String Acttitle=d.findElement(By.xpath(".//*[@id='mi_dashboard_php']/a")).getText();
	if (Exptitle.equalsIgnoreCase(Acttitle))
	{
	System.out.println("home page passed");	
	}
	else
	{
		System.out.println("home page failed");
	}
	}

}
