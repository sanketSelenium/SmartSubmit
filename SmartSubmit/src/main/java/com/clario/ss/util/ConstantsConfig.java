
//need update
package com.clario.ss.util;

import java.util.Hashtable;

import org.openqa.selenium.By;

public class ConstantsConfig {
	public static final boolean GRID_RUN=false;

	
	//Browser 
	//public static final String BROWSER="Chrome";
	//Env URL
	public static final String URL = "https://t.mddximage.com";
	
	//paths
	public static final String REPORTS_PATH = ".\\Report\\";
	//public static final String REPORTS_PATH = System.getProperty("user.dir")+"\\Report\\Reports";
	public static final String REPORTS_SEND = System.getProperty("user.dir")+"\\Report";
//3DI	
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data_SS_3DI.xlsx";
//Other	
	//public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data_SEC_Dev.xlsx";
	
	public static final String Picture = System.getProperty("user.dir")+"\\data\\Capture.PNG";
	
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	//public static final String TEST_DATA_SHEET_PATH= System.getProperty("user.dir")+"E:\\Bioclinica Smart Submit\\Bioclinica Smart Submit\\data";
	
//	Email		
		public static final String mailserver="smtp.emailsrvr.com";
		public static final String port="587";
		
		public static Hashtable<String,String> table;	
	
	public static Hashtable<String,String> getEnvDetails(){
	
		if(table==null)
		{
			table = new Hashtable<String,String>();		
			
				table.put("url", URL);				
			
				return table;
		 	
		}
			return table;
}

}
