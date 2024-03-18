package com.clario.ss.sanitychecklist;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.PortalAndImageSearchLogPage;
import com.clario.ss.tests.BaseTest;
import com.clario.ss.utils.RandomDataExcelUtil;

public class ImageSearchLogFilterTest_SS6344 extends BaseTest {

	String testCaseName = "ImageSearchLogFilterTest";

	@Test
	public void imageSearchSearchResults() {
		test = extent.startTest(testCaseName);
		init();

		loginpage = new LoginPage(driver, test);
		imagesearchpage = new ImageSearchPage(driver, test);
		dashboardpage = new DashboardPage(driver, test);
		adminoptionspage = new AdminOptionsPage(driver, test);
		portalandimagesearchlogpage = new PortalAndImageSearchLogPage(driver, test);
		randomexceldata = new RandomDataExcelUtil();

		loginpage.doLogin(randomexceldata.readSpecificData("LoginCredentials", 1, 1),
				randomexceldata.readSpecificData("LoginCredentials", 1, 2));
		dashboardpage.validateSSUseraccess();
		dashboardpage.clickOnAdminAreaLink();
		adminoptionspage.doClickOnPortalAndImageSearchLogLink();
		portalandimagesearchlogpage.verifImageSearchlogResultsDisplay();
		portalandimagesearchlogpage
				.imageSearchResultsBasedOnFirstName(randomexceldata.readSpecificData("SS6344", 1, 0));
		portalandimagesearchlogpage
				.imageSearchResultsBasedOnLastName((randomexceldata.readSpecificData("SS6344", 1, 1)));
		portalandimagesearchlogpage
				.imageSearchResultsBasedOnUserName((randomexceldata.readSpecificData("SS6344", 1, 2)));
		portalandimagesearchlogpage
				.imageSearchResultsBasedOnProtocol((randomexceldata.readSpecificData("SS6344", 1, 3)));
		portalandimagesearchlogpage.selectDateRange();
		portalandimagesearchlogpage
				.imageSearchResultsBasedOnViewImages((randomexceldata.readSpecificData("SS6344", 1, 6)));
		portalandimagesearchlogpage.varifyExportToExcelButton();
	}

	@AfterMethod
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		if (driver != null)
			driver.quit();
	}
}