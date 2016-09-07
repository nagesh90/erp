package com.ERP.master;

import org.testng.Assert;
import org.testng.annotations.Test;

public class exng 
{
@Test(priority=3,enabled=false)
public void dn()
{
	Assert.assertEquals("gmail", "gmail");
}
@Test(priority=2)
public void dc()
{
	Assert.assertEquals("facebook", "facebook");
}
@Test(priority=1)
public void dcs()
{
Assert.assertEquals("monster", "monster");	
}
}
