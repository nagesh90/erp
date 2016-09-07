package com.ERP.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class suppng extends baseng
{

	@Test(dataProvider="su")
	public void supp(String sn,String add,String cty,String ctry,String cp,String pn,String em,String mn,String n)
	{
		sl.suppliers(sn, add, cty, ctry, cp, pn, em, mn, n);
	}
	
	@DataProvider
	
	public Object[][] su()
	  {
		  Object[][] obj=new Object[2][9];
		  
		  obj[0][0]="toyoto";
		  obj[0][1]="hyderguda";
		  obj[0][2]="mumbai";
		  obj[0][3]="india";
		  obj[0][4]="dutt";
		  obj[0][5]="007";
		  obj[0][6]="dutt@gm.com";
		  obj[0][7]="001";
		  obj[0][8]="toyoto brand";
		  
		  obj[1][0]="toyoto";
		  obj[1][1]="swinburn";
		  obj[1][2]="queensland";
		  obj[1][3]="australia";
		  obj[1][4]="rock";
		  obj[1][5]="108";
		  obj[1][6]="rock@gm.com";
		  obj[1][7]="108";
		  obj[1][8]="toyoto brand";
			
			return obj;
	  }
}
