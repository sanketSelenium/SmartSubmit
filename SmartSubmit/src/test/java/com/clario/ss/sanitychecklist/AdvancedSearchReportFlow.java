package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdvancedSearchPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.LaunchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.UserManagement;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.DataUtil;
import com.relevantcodes.extentreports.LogStatus;

public class AdvancedSearchReportFlow extends BaseTest{
	
		String testCaseName="AdvancedSearchReportFlow";
		@Test(dataProvider="getData")
		public void doLogin(Hashtable<String,String> data) throws Exception{
			test = extent.startTest(testCaseName); 
			/*Validating the test Runmode*/
			if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(ConstantsConfig.RUNMODE_COL).equals("No"))
			{
				test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
				//throw new SkipException("Skipping the test as Runmode is N");
			}
			else
			{
				test.log(LogStatus.INFO, "Execution Start for "+testCaseName);
				init(data.get("Browser"));			
		/*Creating the object of pages*/
				LaunchPage launchPage =new LaunchPage(driver,test);
				//PageFactory.initElements(driver, launchPage);
		    	DashboardPage dashboardPage =new DashboardPage(driver,test);
				PageFactory.initElements(driver, dashboardPage);
				AdvancedSearchPage advSearchPage=new AdvancedSearchPage(driver,test);
				PageFactory.initElements(driver, advSearchPage);
				LoginPage loginPage = launchPage.gotoLoginPage();
				loginPage.takeScreenShot_Fullsystem();
				loginPage.doLogin(data.get("Admin_User"), data.get("Admin_Password"));
				verifyUserName(data.get("Admin_Fullname"));
				dashboardPage.isAdvSearchLinkWorking();
				advSearchPage.clickOnTrialNameDropDown();
				advSearchPage.selectTrialNameFromTrialNameDropDown(data.get("Trial_Name"));
				advSearchPage.advSearchButtonClick();
				advSearchPage.generateReport();
				
	}}
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
