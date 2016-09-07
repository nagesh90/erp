package com.ERP.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;


public class stocklib 
{
public static Properties pr;
public static FileInputStream fin;
public static WebDriver d;
public static String ev,av;

public String openapp(String url) throws IOException
{
	pr=new Properties();
	fin=new FileInputStream("D:\\nagesh\\ERP\\src\\com\\ERP\\properties\\erp.properties");
	pr.load(fin);
 ev="Register";
 d=new FirefoxDriver();
 d.manage().window().maximize();
 d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 d.get(url);
 av=d.findElement(By.xpath(pr.getProperty("reg"))).getText();
 if (ev.equalsIgnoreCase(av))
 {
	 return "app pass";
 }
 else
 {
	 return "app fail";
 }
}
 
public String admlgn(String un,String pwd)
 {
	 ev="Stock Accounting";
	 av=d.findElement(By.xpath(pr.getProperty("alrst"))).getText();
	 d.findElement(By.id(pr.getProperty("rst"))).click();
	 d.findElement(By.id(pr.getProperty("un"))).sendKeys(un);
	 d.findElement(By.id(pr.getProperty("pwd"))).sendKeys(pwd);
	 d.findElement(By.xpath(pr.getProperty("lgn"))).click();
	 if (av.contains(ev))
	 {
		 return "home page pass";
	 }
	 else
	 {
		 return "home page fail";
	 }
 
}
 
public String suppliers(String sn,String add,String cty,String ctry,String cp,String pn,String em,String mn,String n)
{
ev="Add succeeded";

d.findElement(By.xpath(pr.getProperty("sulk"))).click();
d.findElement(By.xpath(pr.getProperty("suc"))).click();
d.findElement(By.id(pr.getProperty("suna"))).sendKeys(sn);
d.findElement(By.id(pr.getProperty("suadd"))).sendKeys(add);
d.findElement(By.id(pr.getProperty("sucty"))).sendKeys(cty);
d.findElement(By.id(pr.getProperty("suctry"))).sendKeys(ctry);
d.findElement(By.id(pr.getProperty("sucp"))).sendKeys(cp);
d.findElement(By.name(pr.getProperty("supn"))).sendKeys(pn);
d.findElement(By.id(pr.getProperty("suem"))).sendKeys(em);
d.findElement(By.id(pr.getProperty("sumn"))).sendKeys(mn);
d.findElement(By.id(pr.getProperty("sun"))).sendKeys(n);
d.findElement(By.id(pr.getProperty("suctd"))).click();
d.findElement(By.xpath(pr.getProperty("surdok"))).click();
av=d.findElement(By.xpath(pr.getProperty("surst"))).getText();
d.findElement(By.xpath(pr.getProperty("surdok"))).click();
if (av.contains(ev))
{
 return"supplier created";	
}
else
{
	return "supplier not created";
}
}

public String categorie(String cn)
{
	ev="Add succeeded";
	Actions clk=new Actions(d);
	clk.moveToElement(d.findElement(By.xpath(pr.getProperty("silk")))).build().perform();
	d.findElement(By.xpath(pr.getProperty("sclk"))).click();
	d.findElement(By.xpath(pr.getProperty("scc"))).click();
	d.findElement(By.id(pr.getProperty("sccn"))).sendKeys(cn);
	d.findElement(By.id(pr.getProperty("scadd"))).click();
	d.findElement(By.xpath(pr.getProperty("scrdok"))).click();
	av=d.findElement(By.xpath(pr.getProperty("scrst"))).getText();
	d.findElement(By.xpath(pr.getProperty("scadok"))).click();
	if (ev.equalsIgnoreCase(av))
	{
		return "categorie created";
	}
	else
	{
		return "categorie not created";
	}
}

public String uom(String id,String des)
{
	ev="Add succeeded";
	Actions clk=new Actions(d);
	clk.moveToElement(d.findElement(By.xpath(pr.getProperty("silk")))).build().perform();
	d.findElement(By.xpath(pr.getProperty("uomlk"))).click();
	d.findElement(By.xpath(pr.getProperty("uomc"))).click();
	d.findElement(By.className(pr.getProperty("uomid"))).sendKeys(id);
	d.findElement(By.name(pr.getProperty("uomdes"))).sendKeys(des);
	d.findElement(By.id(pr.getProperty("uomadd"))).click();
	d.findElement(By.xpath(pr.getProperty("uomrdok"))).click();
	av=d.findElement(By.xpath(pr.getProperty("uomrst"))).getText();
	d.findElement(By.xpath(pr.getProperty("uomcok"))).click();
	if (ev.equalsIgnoreCase(av))
	{
		return "uom created";
	}
	else
	{
		return "uom not created";
	}
}

public String si(String c,String sun,String sn,String uom,String pp,String sp,String n)
{
	ev="Add succeeded";
	d.findElement(By.xpath(pr.getProperty("silk"))).click();
	d.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	Select s=new Select(d.findElement(By.id("x_Category")));
	s.selectByVisibleText(c);
	d.findElement(By.xpath(".//*[@id='x_Supplier_Number']")).sendKeys(sun);
	d.findElement(By.id("x_Stock_Name")).sendKeys(sn);
	d.findElement(By.id("x_Unit_Of_Measurement")).sendKeys(uom);
	d.findElement(By.id("x_Purchasing_Price")).sendKeys(pp);
	d.findElement(By.id("x_Selling_Price")).sendKeys(sp);
	d.findElement(By.id("x_Notes")).sendKeys(n);
	d.findElement(By.id("btnAction")).click();
	d.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	av=d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	d.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	if(ev.equalsIgnoreCase(av))
	{
		return "stock created";
	}
	else
	{
		return "stock not created";
	}
}


public String logout() 

{
	d.findElement(By.id("logout")).click();
	Sleeper.sleepTightInSeconds(3);
	//d.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	
	List<WebElement > ele=d.findElements(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]"));
	System.out.println(ele.size());
	for (int i = 0; i <ele.size(); i++)
	{
		System.out.println(ele.get(i).getText());
		if (ele.get(i).getText().equalsIgnoreCase("OK!"))
		{
			ele.get(i).click();
			break;
		}
	}
	{
	return "app closed";
	}
}
	public String closebrowser()
	{
        d.close();
        
			return "browser closed";
		
	}
}

