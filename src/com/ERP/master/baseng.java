package com.ERP.master;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class baseng 
{
 public static stocklib sl=new stocklib();
  @BeforeTest
  public void beforeTest()
  {
	  sl.admlgn("admin", "master");
  }

  @AfterTest
  public void afterTest() 
  {
	sl.logout();
  }

  @BeforeSuite
  public void beforeSuite() throws IOException 
  {
	  sl.openapp("http://webapp.qedgetech.com/login.php");
  }

  @AfterSuite
  public void afterSuite() 
  {
	sl.closebrowser();  
  }

}
