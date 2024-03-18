package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class ImageSearchAccessControl_SS6338 extends BaseTest {
	
	String testCaseName = "ImageSearchAccessControl";
	@Test
	public void accessControl() {
		test = extent.startTest(testCaseName);
		init();
		
		loginpage=new LoginPage(driver,test);
		 imagesearchpage=new ImageSearchPage(driver,test);
		 dashboardpage=new DashboardPage(driver,test);
		 randomexceldata = new RandomDataExcelUtil();
		 
		 loginpage.doLogin(randomexceldata.readSpecificData("SS6338", 1, 1), randomexceldata.readSpecificData("SS6338", 1, 2));
		 imagesearchpage.validateNonSSUser();
		 Logout();
		 loginpage.doLogin(randomexceldata.readSpecificData("SS6338", 2, 1), randomexceldata.readSpecificData("SS6338", 2, 2));
		 dashboardpage.validateSSUseraccess();
		 Logout();
		 loginpage.doLogin(randomexceldata.readSpecificData("SS6338", 3, 1), randomexceldata.readSpecificData("SS6338", 3, 2));
		 imagesearchpage.validateSSuserWithProtocolAccess();
		 
		 
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
