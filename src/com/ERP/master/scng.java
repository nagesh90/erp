package com.ERP.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class scng extends baseng
{

	@Test(dataProvider="sccn")
	public void sc(String cn)
	{
		sl.categorie(cn);
		
	}
	@DataProvider
	  
	  public Object[][] sccn()
	  {
		  Object[][] obj=new Object[2][1];
		  obj[0][0]="xyz";
		  
			obj[1][0]="pqr";
			
			return obj;
	  }
}
