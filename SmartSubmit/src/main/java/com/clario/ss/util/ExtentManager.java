package com.clario.ss.util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;



public class ExtentManager {
	private static ExtentReports extent;

	/*public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath =ConstantsConfig.REPORTS_PATH+fileName;
 
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "3.0.0-beta3").addSystemInfo("Environment", "QA");
			
						
		}
		
		return extent;
	}*/
	private static String fileName;
	public static String SnapshotFolderPath;
	private  static String reportFolderName;
	private static String reportPath;
	private static String reportFolderPath;
	public  ExtentReports getInstance() {
		  if (extent == null) {
		   Date d=new Date();
		   
		   //reportPath =Constants.REPORTS_PATH+fileName;
		    reportFolderName = "Report_"+d.toString().replace(":", "_").replace(" ", "_");
		    reportFolderPath =ConstantsConfig.REPORTS_PATH+reportFolderName;
		   
		    fileName="Report_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
		    reportPath =reportFolderPath+"\\"+fileName;
		   SnapshotFolderPath = reportFolderPath+"\\Snaps\\";
		   
		   extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
		   extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		   // optional
		   extent.addSystemInfo("Selenium Version", "3.0.0-beta3").addSystemInfo("Environment", "QA");
		  }
		  return extent;
		 }
}
