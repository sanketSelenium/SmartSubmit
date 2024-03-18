package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.ManageUserPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.DataUtil;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class PortalPageAccessRestriction_SS5986 extends BaseTest {
	
	String testCaseName = "PortalPageAccessRestriction_SS5986";
@Test
//	@Test(dataProvider = "getData")
//	public void doLogin(Hashtable<String, String> data) throws Exception {
	public void portalaccess() {
		test = extent.startTest(testCaseName);
		/* Validating the test Runmode */
//		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get(ConstantsConfig.RUNMODE_COL).equals("No")) {
//			test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
//			// throw new SkipException("Skipping the test as Runmode is N");
//		} else {
			test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
				init();
		RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();
		LoginPage loginpage = new LoginPage(driver, test);
		DashboardPage dashboardpage=new DashboardPage(driver,test);
		AdminOptionsPage adminoptionspage=new AdminOptionsPage(driver,test);
		ManageUserPage manageuserpage=new ManageUserPage(driver,test);
		loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		verifyLogin();
		dashboardpage.clickOnAdminAreaLink();
		
		adminoptionspage.clickOnManageUserLink();
		manageuserpage.SearchUserByUsernameOnly(randomexceldata.readSpecificData("SS5986",1,0));
		manageuserpage.updateUserSmartPortalAccessSet(randomexceldata.readSpecificData("SS5986",1,2));
		

		Logout();
		loginpage.doLogin(randomexceldata.readSpecificData("SS5986",1,0), randomexceldata.readSpecificData("SS5986",1,1));
		verifyLogin();
		dashboardpage.clickOnSettingIcon();
		dashboardpage.verifyCogwheelOptionsAsPerSmartPortalAccSet(randomexceldata.readSpecificData("SS5986",1,2));
		
}
//}

	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
//	@DataProvider
//	public Object[][] getData(){
//		return DataUtil.getData(xls, testCaseName);
//	}
	
}