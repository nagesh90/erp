package com.ERP.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class stockcategorie {

	public static void main(String[] args) 
	{
	
	WebDriver d=new FirefoxDriver();
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	d.get("http://webapp.qedgetech.com");
	d.manage().window().maximize();
	String Expval="Reset";
	String Actval=d.findElement(By.id("btnreset")).getText();
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
	Actions clk=new Actions(d);
	clk.moveToElement(d.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();
	d.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
	String exp="Stock Categories";
	String act=d.findElement(By.xpath(".//*[@id='ewPageCaption']")).getText();
	if (exp.equalsIgnoreCase(act))
	{
	System.out.println("Stock Categories page launched");
	}
	else
	{
		System.out.println("Stock Categories page not launched");
	}
	d.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	d.findElement(By.id("x_Category_Name")).sendKeys("swift");
	d.findElement(By.id("btnAction")).click();
	d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();	
	Actions clk1=new Actions(d);
	clk1.moveToElement(d.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();
	d.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();
	String ev="Unit of Measurement";
	String av=d.findElement(By.xpath(".//*[@id='ewPageCaption']")).getText();
	if (ev.equalsIgnoreCase(av))
	{
	System.out.println("Unit of Measurement page launched");
	}
	else
	{
		System.out.println("Unit of Measurement page not launched");
	}
	d.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	d.findElement(By.className("form-control")).sendKeys("007");
	d.findElement(By.name("x_UOM_Description")).sendKeys("diesel cars");
	d.findElement(By.id("btnAction")).click();
	d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	
	}

}
