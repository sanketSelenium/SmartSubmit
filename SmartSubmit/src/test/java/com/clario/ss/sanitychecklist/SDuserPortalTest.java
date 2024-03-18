package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.SDuserPortalPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.DataUtil;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SDuserPortalTest extends BaseTest {
	
	String testCaseName = "SDuserPortalTest";

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
		SDuserPortalPage sduserPortalPage=new SDuserPortalPage(driver,test);
		loginpage.doLoginWithPortalUser(randomexceldata.readSpecificData("PortalUsers", 5, 2),randomexceldata.readSpecificData("PortalUsers",5,3));
		//takeScreenShot();
		
		sduserPortalPage.sdFormsvalidation(randomexceldata.readSpecificData("PortalUsers", 5, 6), randomexceldata.readSpecificData("PortalUsers", 5, 7));
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