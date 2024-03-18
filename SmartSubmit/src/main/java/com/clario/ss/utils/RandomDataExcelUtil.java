package com.clario.ss.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RandomDataExcelUtil {
	 XSSFSheet sheet;
//	public static void main(String[] args) {
//		RandomDataExcelUtil obj=new RandomDataExcelUtil();
//		try {
//			System.out.println(obj.readSpecificData("ssuploaddata", 1, 2));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	//public static void main(String[] args) {
//	try {
//		System.out.println(readSpecificData("LoginCredentials", 0, 1));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}
//		
	public RandomDataExcelUtil() {
		
	}
		 public  String readSpecificData(String sheetName,int rowNum,int colNum)
		    {
			 try 
			 {
		        FileInputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir")+"\\data\\Data_SS_3DI.xlsx");
		        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		        sheet = wb.getSheet(sheetName);
		        
		        //rowNum=sheet.getLastRowNum();
		      //  colNum=sheet.getRow(0).getLastCellNum();
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		        String value=sheet.getRow(rowNum).getCell(colNum).toString();
//		        System.out.println(sheet.getRow(rowNum));
//		        System.out.println(sheet.getRow(rowNum).getCell(colNum));
//		        System.out.println(value);
			 
		        return value;
		        }
		        
		        
		        

}