package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.BPuserPortalPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.DataUtil;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class BPuserPortalTest extends BaseTest {
	
	String testCaseName = "BPuserPortalTest";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws Exception {
		test = extent.startTest(testCaseName);
		/* Validating the test Runmode */
		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get(ConstantsConfig.RUNMODE_COL).equals("No")) {
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
			// throw new SkipException("Skipping the test as Runmode is N");
		} else {
			test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
				init("Chrome");
		RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();
		LoginPage loginpage = new LoginPage(driver, test);
		BPuserPortalPage bpuserPortalPage=new BPuserPortalPage(driver,test);
//		loginpage.doLoginWithPortalUser(randomexceldata.readSpecificData("PortalUsers", 3, 2),randomexceldata.readSpecificData("PortalUsers",3,3));
//		test.log(LogStatus.INFO, "Logged in with BP user having SMART Portal access");
//		bpuserPortalPage.BPuserwithSmartPortalAccess(randomexceldata.readSpecificData("PortalUsers", 3, 4));	
		loginpage.doLoginWithPortalUser(randomexceldata.readSpecificData("PortalUsers", 4, 2),randomexceldata.readSpecificData("PortalUsers",4,3));
		//test.log(LogStatus.INFO, "Logged in with BP user having No SMART Portal access");
		//takeScreenShot();
		bpuserPortalPage.BpUserwithoutSmartPortalAccess(randomexceldata.readSpecificData("PortalUsers", 4, 4));
}
}
	@AfterTest
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		if (driver != null)
			driver.quit();
	}
	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testCaseName);
	}
}