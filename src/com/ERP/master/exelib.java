package com.ERP.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exelib {

	
	
	public static void main(String[] args) throws IOException 
	{
	stocklib sl=new stocklib();
	FileInputStream fis= new FileInputStream("D:\\nagesh\\ERP\\src\\com\\ERP\\testdata\\uom.xlsx");
    XSSFWorkbook wb=new XSSFWorkbook(fis);
    
    String res=sl.openapp("http://webapp.qedgetech.com/login.php");
	System.out.println(res);
	
	res=sl.admlgn("admin", "master");
	System.out.println(res);
	
	XSSFSheet ws2=wb.getSheet("supp");
	int surc=ws2.getLastRowNum();
	for (int k = 1; k <=surc; k++) 
	{
		XSSFRow wr=ws2.getRow(k);
		XSSFCell wc0=wr.getCell(0);
		XSSFCell wc1=wr.getCell(1);
		XSSFCell wc2=wr.getCell(2);
		XSSFCell wc3=wr.getCell(3);
		XSSFCell wc4=wr.getCell(4);
		XSSFCell wc5=wr.getCell(5);
		XSSFCell wc6=wr.getCell(6);
		XSSFCell wc7=wr.getCell(7);
		XSSFCell wc8=wr.getCell(8);
		XSSFCell wc9=wr.createCell(9);
		String sn=wc0.getStringCellValue();
		String add=wc1.getStringCellValue();
		String cty=wc2.getStringCellValue();
		String ctry=wc3.getStringCellValue();
		String cp=wc4.getStringCellValue();
		String pn=wc5.getStringCellValue();
		String em=wc6.getStringCellValue();
		String mn=wc7.getStringCellValue();
		String n=wc8.getStringCellValue();
		res=sl.suppliers(sn, add, cty, ctry, cp, pn, em, mn, n);
		System.out.println(res);
		wc9.setCellValue(res);	
	}
	
	
	XSSFSheet ws1=wb.getSheet("cat");
	int rc1=ws1.getLastRowNum();
    for (int j = 1; j <= rc1; j++) 
    {
	XSSFRow wr=ws1.getRow(j);
	XSSFCell wc0=wr.getCell(0);
	XSSFCell wc1=wr.createCell(1);
	String catn=wc0.getStringCellValue();
	res=sl.categorie(catn);
	System.out.println(res);
	wc1.setCellValue(res);
    }
    
	
    XSSFSheet ws=wb.getSheet("data");
	int rc=ws.getLastRowNum();
    for (int i = 1; i <= rc; i++) 
    {
	XSSFRow wr=ws.getRow(i);
	XSSFCell wc0=wr.getCell(0);
	XSSFCell wc1=wr.getCell(1);
	XSSFCell wc2=wr.createCell(2);
	String id=wc0.getStringCellValue();
	String des=wc1.getStringCellValue();
	res=sl.uom(id, des);
	System.out.println(res);
	wc2.setCellValue(res);
	}
	
    FileOutputStream fos=new FileOutputStream("D:\\nagesh\\ERP\\src\\com\\ERP\\results\\uomres.xlsx");
    wb.write(fos);
    wb.close();
	
	res=sl.si("activa","Supplier-00000003371", "activa 3g","bikes369", "49000", "65000", "petrol bike");
	System.out.println(res);
	
	res=sl.logout();
	System.out.println(res);

	res=sl.closebrowser();
	System.out.println(res);
	
	}

}
