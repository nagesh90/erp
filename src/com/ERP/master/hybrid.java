package com.ERP.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class hybrid {

	
	public static void main(String[] args) throws IOException 
	{
		stocklib sl=new stocklib();

		String res = null;
//input path

		String xlpath="D:\\nagesh\\ERP\\src\\com\\ERP\\testdata\\keyword_data.xlsx";

//Results
		String xlout="D:\\nagesh\\ERP\\src\\com\\ERP\\results\\keyword_Result.xlsx";

		FileInputStream fi=new FileInputStream(xlpath);
		
		XSSFWorkbook wb=new XSSFWorkbook(fi);

		XSSFSheet ws=wb.getSheet("TestCase");
		XSSFSheet ws1=wb.getSheet("TestSteps");
		XSSFSheet ws2=wb.getSheet("Testdata");
		
		int tcRc=ws.getLastRowNum();

		int tsRc=ws1.getLastRowNum();
		//test cases


		for (int i = 1; i <= tcRc; i++)
		{
			String exe=ws.getRow(i).getCell(2).getStringCellValue();
			if (exe.equalsIgnoreCase("Y"))
			{
				String tcId=ws.getRow(i).getCell(0).getStringCellValue();
				
				//test steps
				for (int j = 1; j <= tsRc ; j++) 
				{
					String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
					
					if (tcId.equalsIgnoreCase(tsTcid))
					{
						String key=ws1.getRow(j).getCell(3).getStringCellValue();
						
						switch (key) {
						case "sLanch":
							res=sl.openapp("http://webapp.qedgetech.com");
							break;
						case "sLogin":
							res=sl.admlgn("admin", "master");
							break;
						case "sLogout": 	
							res=sl.logout();
							break;
						case "sSupplier":
							String supname=ws2.getRow(1).getCell(0).getStringCellValue();
							String add=ws2.getRow(1).getCell(1).getStringCellValue();
							String city=ws2.getRow(1).getCell(2).getStringCellValue();
							String cntry=ws2.getRow(1).getCell(3).getStringCellValue();
							String cperson=ws2.getRow(1).getCell(4).getStringCellValue();
							String pno=ws2.getRow(1).getCell(5).getStringCellValue();
							String email=ws2.getRow(1).getCell(6).getStringCellValue();
							String mno=ws2.getRow(1).getCell(7).getStringCellValue();
							String notes=ws2.getRow(1).getCell(8).getStringCellValue();
							res=sl.suppliers(supname, add, city, cntry, cperson, pno, email, mno, notes);
							break;
						case "sCat":
							String catname=ws2.getRow(1).getCell(9).getStringCellValue();
							res=sl.categorie(catname);
							break;
						case "sUom":
							String Uid=ws2.getRow(1).getCell(10).getStringCellValue();
							String Udesc=ws2.getRow(1).getCell(11).getStringCellValue();
							res=sl.uom(Uid, Udesc);
							break;
							
						case "sSItem":
							res=sl.si("c73", "s73", "SI73", "u73desc", "5000", "8000", "Snote");
							
							break;
							
						case "AppC":
							res=sl.closebrowser();
							
						default:
							System.out.println("Pass a Valid Keyword");
							break;
						}

						//result updation in test steps sheet
						ws1.getRow(j).createCell(4).setCellValue(res);
						//result updation in test case sheet
						if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
						{
							ws.getRow(i).createCell(3).setCellValue(res);
						}
						else
						{
							ws.getRow(i).createCell(3).setCellValue("Fail");
						}
						
						
					}
					
					
					
				}
				
			}
			else
			{
				ws.getRow(i).createCell(3).setCellValue("BLOCKED");
			}
		}
		FileOutputStream fo=new FileOutputStream(xlout);
		wb.write(fo);
		wb.close();
		
	}

}
