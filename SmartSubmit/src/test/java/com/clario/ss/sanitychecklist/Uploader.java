package com.clario.ss.sanitychecklist;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.UploaderPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.DataUtil;
import com.clario.ss.util.ExcelReader;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class Uploader extends BaseTest {
	
	String testCaseName = "Uploader Case";
	
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
		RandomDataExcelUtil randomutil = new RandomDataExcelUtil();
		ExcelReader ex=new ExcelReader();
		LoginPage loginpage = new LoginPage(driver, test);
		DashboardPage dashboardpage = new DashboardPage(driver, test);
		UploaderPage uploaderpage = new UploaderPage(driver, test);
		loginpage.doLogintest(randomutil.readSpecificData("LoginCredentials", 2, 1),
				randomutil.readSpecificData("LoginCredentials", 2, 2));
		String actTitle = dashboardpage.getDashboardPageTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, ConstantsOR.DASHBOARD_PAGE_TITLE);

		// Assert.assertTrue(dashboardpage.verifyDashboardPage());

		System.out.println("Logged in successfully");
	 test.log(LogStatus.INFO, "Logged in successfully");
		Thread.sleep(9000);

		dashboardpage.clickOnSettingIcon();
		dashboardpage.clickOnUploaderType();
		Thread.sleep(3000);

		uploaderpage.selectFile();
		Thread.sleep(3000);
		}} // uploaderpage.selectUploadCaseData("Testlax3428","India site 06 -
		// 123","Cath","23658","New Case","1 day");
//	@AfterMethod
//	public void quitExt(){
//		if(extent!=null){
//			extent.endTest(test);
//			extent.flush();
//		}
//	}
//	@Test(dataProvider = "getUploadData")
//	public void uploadFile(String tn, String sn, String imaget, String sid, String reasonfu, String tp)
//			throws InterruptedException, IOException {
//		UploaderPage uploaderpage = new UploaderPage(driver, test);
//		try {
//
//
//			test.log(LogStatus.INFO, "Selecting uploader data");
//			uploaderpage.selectUploadCaseData(tn, sn, imaget, sid, reasonfu, tp);
//			// uploaderpage.selectUploadCaseData();
//
//		} catch (InterruptedException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@DataProvider
//	public Object[][] getUploadData() {
//		return ExcelReader.getTestData("UploadCaseData");
//	}
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
