package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.DataUtil;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class ImageSearch_SmartPortal_SS6054 extends BaseTest {


	String testCaseName = "ImageSearch_SmartPortal_SS6054";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws Exception {
		test = extent.startTest(testCaseName);
		/* Validating the test Runmode */
		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get(ConstantsConfig.RUNMODE_COL).equals("No")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
			// throw new SkipException("Skipping the test as Runmode is N");
		} else {
			test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
		init();
		RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();
		LoginPage loginpage = new LoginPage(driver, test);
		DashboardPage dashboardpage=new DashboardPage(driver,test);
		ImageSearchPage imagesearchpage=new ImageSearchPage(driver,test);
		loginpage.doLogin(randomexceldata.readSpecificData("SS6054",1,0), randomexceldata.readSpecificData("SS6054",1,1));
		verifyLogin();
		imagesearchpage.validateNonSSUser();
		imagesearchpage.verifyImageSearchforBPtrial(randomexceldata.readSpecificData("SS6054",1,3),randomexceldata.readSpecificData("SS6054",1,4),randomexceldata.readSpecificData("SS6054",1,5));
	//	imagesearchpage.verifyImageSearchforSDtrial(randomexceldata.readSpecificData("SS6054",2,3),randomexceldata.readSpecificData("SS6054",2,4),randomexceldata.readSpecificData("SS6054",2,5));

		dashboardpage.verifySmartPortalButton();
}
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
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	
	}