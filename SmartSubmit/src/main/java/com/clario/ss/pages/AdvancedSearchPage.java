package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvancedSearchPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public AdvancedSearchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void clickOnTrialNameDropDown() {
		driver.findElement(ConstantsOR.TRIAL_NAME_DROPDOWN).click();

	}

	public void selectTrialNameFromTrialNameDropDown(String trialName) {
//		List<WebElement> trialNameList=driver.findElements(ConstantsOR.TRIAL_NAME_SELECT);
//
//		for(WebElement e:trialNameList) {
//		String tNames=e.getText();
//
//			//System.out.println(tNames);
//			if(tNames.equals("TestlaxMDDXt")) {
//				String tNames1=e.getText();
//				System.out.println(tNames1);
//				e.click();
//				driver.findElement(ConstantsOR.TRIAL_NAME_SELECTED).click();
//				break;
		// }
		// System.out.println(tNames);
		test.log(LogStatus.INFO, "Selecting trial name :" + trialName);
		driver.findElement(ConstantsOR.TRIAL_NAME_SEARCH_BOX).sendKeys(trialName);
		driver.findElement(By.xpath(ConstantsOR.TRIAL_NAME_SELECT + "[text()='" + trialName + "']")).click();

		driver.findElement(ConstantsOR.TRIAL_NAME_SELECTED).click();
	}

	public void advSearchButtonClick() throws InterruptedException {
		driver.findElement(ConstantsOR.ADV_SEARCH_BUTTON).click();
		test.log(LogStatus.PASS, "Clicked on Advanced Search Button");
		waitForInvisibility(driver.findElement(ConstantsOR.LOADER), driver);
		Thread.sleep(5000);
		driver.findElement(ConstantsOR.ADV_SEARCH_BUTTON).sendKeys(Keys.PAGE_DOWN);
//		String resultsCount=driver.findElement(ConstantsOR.SEARCH_RESULTS_COUNT).getText();
//		System.out.println("total count "+resultsCount);
		// test.log(LogStatus.PASS, "Advanced Search results Found");
	}

	public void generateReport() throws InterruptedException {
		waitForVisibility(driver.findElement(ConstantsOR.SELECT_ALL_RESULTS_CHECKBOX), driver);
		test.log(LogStatus.INFO, "Selecting all records");
		driver.findElement(ConstantsOR.SELECT_ALL_RESULTS_CHECKBOX).click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Generating Export Report");

		driver.findElement(ConstantsOR.GENERATE_REPORT_DROPDOWN).click();
		driver.findElement(ConstantsOR.EXPORT_REPORT_LINK).click();
		waitForVisibility(driver.findElement(ConstantsOR.MESSAGE_POPUP), driver);
		test.log(LogStatus.INFO, "Pop up displayed: Please keep this window open while we generate your report.");
		//takeScreenShot_Fullsystem();
		takeScreenShot();
		waitForInvisibility(ConstantsOR.MESSAGE_POPUP, driver);
		test.log(LogStatus.PASS, "Export report generated successfully");
		test.log(LogStatus.INFO, "Report generated at path: \"C:\\Users\\IDC-99\\Downloads\" ");

	}
}
