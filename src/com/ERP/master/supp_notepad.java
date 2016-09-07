package com.ERP.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class supp_notepad 
{

	public static void main(String[] args) throws IOException 
	{
	
	stocklib sl=new stocklib();
	
	String res=sl.openapp("http://webapp.qedgetech.com/login.php");
	System.out.println(res);
	
    res=sl.admlgn("admin", "master");
	System.out.println(res);
	
	String fpath="D:\\nagesh\\ERP\\src\\com\\ERP\\testdata\\supp.txt";
	String rpath="D:\\nagesh\\ERP\\src\\com\\ERP\\results\\suppres.txt";
	String sd;
	FileReader fr=new FileReader(fpath);
	BufferedReader br=new BufferedReader(fr);
	String sread=br.readLine();
	System.out.println(res);
	
	FileWriter fw=new FileWriter(rpath);
	 BufferedWriter bw=new BufferedWriter(fw);
	 bw.write(sread+"@@@"+"results");
	 bw.newLine();
	 
	 while ((sd=br.readLine())!=null) 
	 {
		System.out.println(sd);
		String sr[]=sd.split("&&&");
		String sn=sr[0];
		System.out.println(sn);
		String add=sr[1];
		System.out.println(add);
		String cty=sr[2];
		System.out.println(cty);
		String ctry=sr[3];
		System.out.println(ctry);
		String cp=sr[4];
		System.out.println(cp);
		String pn=sr[5];
		System.out.println(pn);
		String em=sr[6];
		System.out.println(em);
		String mn=sr[7];
		System.out.println(mn);
		String n=sr[8];
		System.out.println(n);
		res=sl.suppliers(sn, add, cty, ctry, cp, pn, em, mn, n);
		System.out.println(res);
		bw.write(sn+"%%%"+add+"%%%"+cty+"%%%"+ctry+"%%%"+cp+"%%%"+pn+"%%%"+em+"%%%"+mn+"%%%"+n+"%%%"+res);
		bw.newLine();	
	}
	
	 bw.close();
	br.close();			
	}

}
