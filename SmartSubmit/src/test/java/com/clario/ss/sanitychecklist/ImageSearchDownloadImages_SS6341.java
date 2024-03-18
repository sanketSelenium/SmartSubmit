package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class ImageSearchDownloadImages_SS6341 extends BaseTest{
	
	String testCaseName = "ImageSearchDownloadImages";
	@Test
	public void imageSearchSearchResults() {
		test = extent.startTest(testCaseName);
		init();
		
		 loginpage=new LoginPage(driver,test);
		 imagesearchpage=new ImageSearchPage(driver,test);
		 dashboardpage=new DashboardPage(driver,test);
		 randomexceldata = new RandomDataExcelUtil();
		 loginpage.doLogin(randomexceldata.readSpecificData("SS6341", 1, 0), randomexceldata.readSpecificData("SS6341", 1, 1));
		 imagesearchpage.verifyImageSearchSearchResults(randomexceldata.readSpecificData("SS6341", 1, 2), randomexceldata.readSpecificData("SS6341", 1, 3), randomexceldata.readSpecificData("SS6341", 1, 4), randomexceldata.readSpecificData("SS6341", 1, 5));
		 imagesearchpage.verifyDownloadImagesTimepointlink();
		 imagesearchpage.verifyStopDownloadButton();
		 imagesearchpage.verifyDownloadImagesTimepointlink();
		 imagesearchpage.verifyIagreeDownloadButton();
		 imagesearchpage.verifyConfirmDownloadOkButton();
		 
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