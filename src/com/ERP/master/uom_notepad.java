package com.ERP.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class uom_notepad {

	
	public static void main(String[] args) throws IOException 
	{
		stocklib sl=new stocklib();
		
		String res=sl.openapp("http://webapp.qedgetech.com/login.php");
		System.out.println(res);
		
		res=sl.admlgn("admin", "master");
		System.out.println(res);
		
		//filepath
		 String fpath="D:\\nagesh\\ERP\\src\\com\\ERP\\testdata\\uom.txt";
		 String rpath="D:\\nagesh\\ERP\\src\\com\\ERP\\results\\uomres.txt";
		 String SD;
		 FileReader fr=new FileReader(fpath);
		 BufferedReader br=new BufferedReader(fr);
		 String srcread=br.readLine();
		 System.out.println(srcread);
		 
		 FileWriter fw=new FileWriter(rpath);
		 BufferedWriter bw=new BufferedWriter(fw);
		 bw.write(srcread+"###"+"results");
		 bw.newLine();
		 
		 while ((SD=br.readLine())!=null) 
		 {
			System.out.println(SD);
			String sr[]=SD.split("@@@");
			String id=sr[0];
			System.out.println(id);
			String des=sr[1];
			System.out.println(des);
			res=sl.uom(id, des);
			System.out.println(res);
			bw.write(id+"%%%"+des+"%%%"+res);
			bw.newLine();
		}
		bw.close();
		br.close();
	}

}
