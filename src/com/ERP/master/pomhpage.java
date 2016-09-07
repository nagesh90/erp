package com.ERP.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class pomhpage 
{
@FindBy(xpath=".//*[@id='mi_a_suppliers']/a")
WebElement supplier;
@FindBy(xpath=".//*[@id='mi_a_stock_categories']/a")
WebElement scategory;
@FindBy(xpath=".//*[@id='mi_a_unit_of_measurement']/a")
WebElement uom;
@FindBy(xpath=".//*[@id='mi_a_stock_items']/a")
WebElement sitems;

public void supp()
{
	supplier.click();
}

public void sc(WebDriver dr)
{
	Actions act=new Actions(dr);
	act.moveToElement(sitems).build().perform();
	scategory.click();
}
public void uom(WebDriver cr)
{
	Actions act=new Actions(cr);
	act.moveToElement(sitems).build().perform();
	uom.click();
}
public void si()
{
	sitems.click();
}
}
