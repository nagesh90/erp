package com.ERP.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exeng extends baseng 
{
  @Test(dataProvider="uomdata")
  public void uom(String id,String des)
  {
	sl.uom(id,des);
  }
  
  @DataProvider
  
  public Object[][] uomdata()
  {
	  Object[][] obj=new Object[2][2];
	  obj[0][0]="ret";
		obj[0][1]="pqr";
	 
		obj[1][0]="uyi";
		obj[1][1]="mno";
		return obj;
	  
  }
  
}

