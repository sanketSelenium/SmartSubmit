package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class ImageSearchSearchResults_SS6339 extends BaseTest {

	String testCaseName = "ImageSearchSearchResults";
	@Test
	public void imageSearchSearchResults() {
		test = extent.startTest(testCaseName);
		init();
		
		loginpage=new LoginPage(driver,test);
		 imagesearchpage=new ImageSearchPage(driver,test);
		 dashboardpage=new DashboardPage(driver,test);
		 randomexceldata = new RandomDataExcelUtil();
		 loginpage.doLogin(randomexceldata.readSpecificData("SS6339", 1, 0), randomexceldata.readSpecificData("SS6339", 1, 1));
		 imagesearchpage.verifyProtocolValidation();
		 imagesearchpage.verifySiteValidation(randomexceldata.readSpecificData("SS6339", 1, 2));
		 imagesearchpage.selectSiteAndSearchResults(randomexceldata.readSpecificData("SS6339", 1, 3));
		 imagesearchpage.selectSubjectAndSearchResults(randomexceldata.readSpecificData("SS6339", 1, 4));
		 imagesearchpage.selectTimepointAndSearchResults(randomexceldata.readSpecificData("SS6339", 1, 5));
		 
		 imagesearchpage.verifyResetButton();
}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
}