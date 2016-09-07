package com.ERP.master;




import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class pomsupp 
{
@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")
WebElement suppc;
@FindBy(xpath=".//*[@id='x_Supplier_Name']")
WebElement suna;
@FindBy(xpath=".//*[@id='x_Address']")
WebElement suadd;
@FindBy(id="x_City")
WebElement sucty;
@FindBy(id="x_Country")
WebElement suctry;
@FindBy(id="x_Contact_Person")
WebElement sucp;
@FindBy(id="x_Phone_Number")
WebElement supn;
@FindBy(id="x__Email")
WebElement suem;
@FindBy(id="x_Mobile_Number")
WebElement sumn;
@FindBy(id="x_Notes")
WebElement sun;
@FindBy(xpath=".//*[@id='btnAction']")
WebElement suppadd;
@FindBy(xpath="html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")
List<WebElement> suanr;
@FindBy(xpath="html/body/div[.]/div[2]/div/div[4]/div[2]/button")
WebElement suads;
public void suppcr(String sn,String add,String cty,String ctry,String cp,String pn,String em,String mn,String n)
{
	suppc.click();
	suna.sendKeys(sn);
	suadd.sendKeys(add);
	sucty.sendKeys(cty);
	suctry.sendKeys(ctry);
	sucp.sendKeys(cp);
	supn.sendKeys(pn);
	suem.sendKeys(em);
	sumn.sendKeys(mn);
	sun.sendKeys(n);
	suppadd.click();
	//suanr.click();
	
	List<WebElement> ele=suanr;
	System.out.println(ele.size());
	for (int i = 0; i <ele.size(); i++)
	{
		System.out.println(ele.get(i).getText());
		if (ele.get(i).getText().equalsIgnoreCase("OK!"))
		{
			ele.get(i).click();
			break;
		}
	suads.click();
}
}
}