package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.EmailCheckingPage;
import com.clario.ss.pages.InviteUserPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.ManageUserPage;
import com.clario.ss.pages.RegistrationPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class InviteUserFunctionality extends BaseTest {

	String testCaseName = "InviteUserFunctionality";

	@Test
	public void invite() {
		
		test = extent.startTest(testCaseName);
		init();
		
		loginpage=new LoginPage(driver,test);
		dashboardpage=new DashboardPage(driver,test);
	    inviteuserpage=new InviteUserPage(driver,test);
	    randomexceldata = new RandomDataExcelUtil();
	    adminoptionspage = new AdminOptionsPage(driver, test); 
	    emailcheckingpage=new EmailCheckingPage(driver,test);
	    registrationpage=new RegistrationPage(driver,test);
	    manageuserpage=new ManageUserPage(driver,test);
		loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		dashboardpage.clickOnAdminAreaLink();
		adminoptionspage.clickOnUserManagementMenu();

		adminoptionspage.clickOnManageUserLink();
	
		manageuserpage.RemoveUser(randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 1),randomexceldata.readSpecificData("LoginCredentials", 1, 1), randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		adminoptionspage.clickOnUserManagementMenu();
		inviteuserpage.clickOnInviteUserLink();
		inviteuserpage.inviteUsers(randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 0));
		Logout();
		emailcheckingpage.emailVerification(randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 1));
		registrationpage.verifyUserRegistration(randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 1), randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 2), randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 3));
	    dashboardpage.verifyQualificationTraining(randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 1), randomexceldata.readSpecificData("InviteUserDataWithRole", 1, 3));
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
