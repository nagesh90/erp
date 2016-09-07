package com.ERP.master;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class pomexe 
{
@Test	
public void lgexe() throws InterruptedException
{
	WebDriver d=new FirefoxDriver();
    d.get("http://webapp.qedgetech.com");
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	pomlogin lgn=PageFactory.initElements(d, pomlogin.class);
	lgn.admlgn("admin", "master");
	
	pomhpage hp=PageFactory.initElements(d, pomhpage.class);
	hp.supp();
	Thread.sleep(3000);
	pomsupp sup=PageFactory.initElements(d, pomsupp.class);
	sup.suppcr("bmw", "hamburg", "berlin", "germany", "dinesh", "0123456", "dinesh@gmail.com", "789456123", "car brand");
	hp.sc(d);
	Thread.sleep(3000);
	hp.uom(d);
	Thread.sleep(3000);
	hp.si();
}
	
}
