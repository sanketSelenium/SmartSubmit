package com.clario.ss.sanitychecklist;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SS6338 extends BaseTest {
	

	@BeforeTest
	public void setUp() {
		
		init();
		
		loginpage=new LoginPage(driver);
		 imagesearchpage=new ImageSearchPage(driver);
		 dashboardpage=new DashboardPage(driver);
		 randomexceldata = new RandomDataExcelUtil();
		
	}
	
	@Test(priority=1)
	public void verifynonssuserlogin() {
		String testCaseName="nonssuserlogin";
		test = extent.startTest(testCaseName);
		
		//LoginPage loginpage=new LoginPage(driver,test);
		
		test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
		
		loginpage.doLogin(randomexceldata.readSpecificData("SS5985", 1, 0), randomexceldata.readSpecificData("SS5985", 1, 1));
		if(dashboardpage.isSignoutButtonExist()) {
			test.log(LogStatus.PASS, "User logged in successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Login failed, please check credentials");
		}
//		boolean signoutButtonexist=dashboardpage.isSignoutButtonExist();
//		Assert.assertTrue(signoutButtonexist);
//		test.log(LogStatus.PASS, "User logged in successfully");
		int imagesearch=imagesearchpage.validateNonSSuser();
		if(imagesearch>=1) {
			test.log(LogStatus.PASS, "Logged in user is added in ADFS but not in SMART submit");
			takeScreenShot();
		}
		else {
			test.log(LogStatus.FAIL, "please check creadentials");
		}
		Logout();
		
	}
	@Test(priority=2)
	public void verifySSuser() {
		
		String testCaseName="ssuserlogin";
		test = extent.startTest(testCaseName);
		
		test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
		
		loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
//		boolean signoutButtonexist=dashboardpage.isSignoutButtonExist();
//		Assert.assertTrue(signoutButtonexist);
//		test.log(LogStatus.PASS, "User logged in successfully");
		if(dashboardpage.isSignoutButtonExist()) {
			test.log(LogStatus.PASS, "User logged in successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Login failed, please check credentials");
		}
		String actTitle=dashboardpage.validateSSuser();
		if(actTitle.contains("Dashboard")) {
			test.log(LogStatus.PASS, "Logged in user is added in ADFS and SMART submit");
			takeScreenShot();
		}
		else {
			test.log(LogStatus.FAIL, "Please check credentials for valid ss user");
		}
		
		Logout();
		
	}
@Test(priority=3)
public void verifySSuserWithProtocolAccess() {
	String testCaseName="ssuserwithprotocolaccess";
	test = extent.startTest(testCaseName);
	
	test.log(LogStatus.INFO, "Execution Start for " + testCaseName);
	
	loginpage.doLogin(randomexceldata.readSpecificData("SS5985", 1, 0), randomexceldata.readSpecificData("SS5985", 1, 1));
	if(dashboardpage.isSignoutButtonExist()) {
		test.log(LogStatus.PASS, "User logged in successfully");
	}
	else {
		test.log(LogStatus.FAIL, "Login failed, please check credentials");
	}
	boolean protocolacess=imagesearchpage.validateSSuserWithProtocolAccess();
	if(protocolacess) {
		test.log(LogStatus.PASS, "Logged in user have protocol access");
	}
	else {
		test.log(LogStatus.FAIL, "Logged in user don't have any protocl access");
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
}