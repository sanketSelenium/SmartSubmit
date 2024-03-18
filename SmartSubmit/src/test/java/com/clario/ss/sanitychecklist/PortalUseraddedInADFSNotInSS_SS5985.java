package com.clario.ss.sanitychecklist;

import java.util.Hashtable;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.ManageUserPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.DataUtil;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class PortalUseraddedInADFSNotInSS_SS5985 extends BaseTest {
	
	String testCaseName = "PortalUseraddedInADFSNotInSS_SS5985";
	
//	
//	@BeforeTest
//	public void setup() {
//		init();
//	}
	//LoginPage loginpage = new LoginPage(driver, test);
	@Test
public void smartSubmitUserLoginTest() {
//	@Test(dataProvider = "getData")
//	public void doLogin(Hashtable<String, String> data) throws Exception {
	
		test = extent.startTest(testCaseName);
		test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
		/* Validating the test Runmode */
//		if (!DataUtil.isTestExecutable(xls, testCaseName) || data.get(ConstantsConfig.RUNMODE_COL).equals("No")) {
//			test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
//			// throw new SkipException("Skipping the test as Runmode is N");
//		} else {
			//.log(LogStatus.INFO, "Execution Start for " + testCaseName);
				
		RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();
	    loginpage = new LoginPage(driver, test);
		DashboardPage dashboardpage=new DashboardPage(driver,test);
		AdminOptionsPage adminoptionspage=new AdminOptionsPage(driver,test);
		ManageUserPage manageuserpage=new ManageUserPage(driver,test); 
		ImageSearchPage imagesearchpage=new ImageSearchPage(driver,test);
		//loginpage.doLogintest(randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		//dashboardpage.clickOnAdminAreaLink();
		//adminoptionspage.clickOnManageUserLink();
		//manageuserpage.verifyUserIsNotAddedinSS(randomexceldata.readSpecificData("PortalUsers",1,0));

		//loginpage.doLogin(randomexceldata.readSpecificData("SS5985",1,0), randomexceldata.readSpecificData("SS5985",1,1));
		loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials",1,1), randomexceldata.readSpecificData("LoginCredentials",1,2));
		//verifyLogin();
		//imagesearchpage.validateNonSSUser();
		//imagesearchpage.verifyImageSearch();
		
		WebDriverWait wait=new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ConstantsOR.LOADER));
		String actTitle=driver.getTitle();
		//if((driver.getTitle().contains("test"))) {
			Assert.assertTrue(driver.getTitle().contains("SMART Submit - Dashboard123"),"failtest");
			//Assert.assertTrue(driver.getTitle().contains("SMART Submit - Dashboard123"),test.log(LogStatus.FAIL, "failed"));
			
		//}else
//		{
//			Assert.assertTrue(false);
//			test.log(LogStatus.FAIL, "failed");
//		}
		
		
		
}
//}
	@AfterTest
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
//	

}