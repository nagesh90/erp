package com.ERP.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class supplier {

	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		Thread.sleep(3000);
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
		d.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		String Exppage="Suppliers";
		String Actpage=d.findElement(By.xpath(".//*[@id='ewPageCaption']")).getText();
		if (Exppage.equalsIgnoreCase(Actpage))
		{
		System.out.println("suppliers page launched");	
		}
		else
		{
			System.out.println("suppliers page not launched");
		}
		d.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		d.findElement(By.xpath(".//*[@id='x_Supplier_Name']")).sendKeys("maruthi suzuki");
		d.findElement(By.id("x_Address")).sendKeys("12-11-66,sec-bad");
		d.findElement(By.id("x_City")).sendKeys("hyderabad");
		d.findElement(By.id("x_Country")).sendKeys("india");
		d.findElement(By.id("x_Contact_Person")).sendKeys("shanker");
		d.findElement(By.id("x_Phone_Number")).sendKeys("8801600321");
	    d.findElement(By.id("x__Email")).sendKeys("shanker@gmail.com");
		d.findElement(By.id("x_Mobile_Number")).sendKeys("8801600456");
		d.findElement(By.id("x_Notes")).sendKeys("cars");
		d.findElement(By.id("btnAction")).click();
		d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	}

}
