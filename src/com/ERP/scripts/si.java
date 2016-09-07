package com.ERP.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class si 
{

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("http://webapp.qedgetech.com");
		d.manage().window().maximize();
		d.findElement(By.id("btnreset")).click();
		d.findElement(By.id("username")).sendKeys("admin");
		d.findElement(By.id("password")).sendKeys("master");
		d.findElement(By.id("btnsubmit")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
		d.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		Select s=new Select(d.findElement(By.id("x_Category")));
		s.selectByVisibleText("activa");
		d.findElement(By.xpath(".//*[@id='x_Supplier_Number']")).sendKeys("Supplier-00000003371");
		d.findElement(By.id("x_Stock_Name")).sendKeys("activa 3g");
		d.findElement(By.id("x_Unit_Of_Measurement")).sendKeys("bikes369");
		d.findElement(By.id("x_Purchasing_Price")).sendKeys("49000");
		d.findElement(By.id("x_Selling_Price")).sendKeys("65000");
		d.findElement(By.id("x_Notes")).sendKeys("petrol bike");
		Thread.sleep(2000);
		d.findElement(By.id("btnAction")).click();
		d.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		d.findElement(By.id("logout")).click();
		d.close();
	}

}
