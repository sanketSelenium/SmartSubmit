package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class ImageSearchLogAccessControl_SS6342 extends BaseTest {


	String testCaseName = "ImageSearchLogAccessControl";
	@Test
	public void ImageSearchLogAccessControl() {
		test = extent.startTest(testCaseName);
		init();
		
		loginpage=new LoginPage(driver,test);
		 imagesearchpage=new ImageSearchPage(driver,test);
		 dashboardpage=new DashboardPage(driver,test);
		 adminoptionspage=new AdminOptionsPage(driver,test);
		 randomexceldata = new RandomDataExcelUtil();
		 loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		 dashboardpage.validateSSUseraccess();
		 dashboardpage.clickOnAdminAreaLink();
		 adminoptionspage.doClickOnPortalAndImageSearchLogLink();
		 
		 
		 
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