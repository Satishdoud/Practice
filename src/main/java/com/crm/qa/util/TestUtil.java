package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 40;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\SATISH DOUD\\eclipse-workspace\\smartprogramming\\FreeCRMTestAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\Data_Fetch.xlsx";
	

   public static void getTestData(String sheetName) throws EncryptedDocumentException, IOException{
	   FileInputStream file=new FileInputStream(TESTDATA_SHEET_PATH);
	   
	   Sheet s1=WorkbookFactory.create(file).getSheet("w3");
	   
	   int lastrow=s1.getLastRowNum();
	   
	   Row r1=s1.getRow(0);
	   
	   double lastcell = r1.getLastCellNum();
	   
	   for(int i = 0; i<=lastrow; i++)
		{
			Row runningrow= s1.getRow(i); // started row loop only
						
			for(int j=0; j<lastcell;j++)// cell loop
			{
				String runningcell = runningrow.getCell(j).getStringCellValue();	
				System.out.print(runningcell+"       ");// printing purpose
			}
			System.out.println(" "); // next row print
		}
	
	
	   
   }
}