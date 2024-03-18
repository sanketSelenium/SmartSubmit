package com.clario.ss.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ImageSearchPage extends BasePage {

	public ImageSearchPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

//	public ImageSearchPage(WebDriver driver) {
//		super(driver);
//	}
	By imageSearchHeader = By.xpath("//h3[text()='Image Search']");
	By protocolDropdownButton = By.xpath("//span[@id='select2-ddlProtocol-container']");
	By protocolDropdown = By.xpath("//span[@class='select2-results']/ul/li");
	By siteDropdownButton = By.xpath("//span[@id='select2-ddlSiteId-container']");
	By siteDropdown = By.xpath("//span[@class='select2-results']/ul/li");
	By subjectDropdownButton = By.xpath("//table/tbody/tr[3]/td[2]/button");
	By subjectDropdown = By.xpath(
			"//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass']/ul/li/a/label/input[@name='multiselect_SubjectID']/following-sibling::span");
	By timepointDropdownButton = By.xpath("//table/tbody/tr[4]/td[2]/button");
	By timepointDropdown = By.xpath(
			"//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass']/ul/li/a/label/input[@name='multiselect_TimepointID']/following-sibling::span");
	By searchButton = By.xpath("//button[@id='btnSearchCIP']");
	By resetButton = By.xpath("//button[@id='btnSearchReset']");
	By protocolErrormsg = By.xpath("//span[@id='ErrProtocol']");
	By siteErrormsg = By.xpath("//span[@id='ErrSiteId']");
	By imageSearchNoResults = By.xpath("//*[@id='CIPInfoGridContainer']/div/table/tbody/tr/td[text()='None']");
	By iAgreeButton = By.xpath("//input[@id='confirmation-popup-confirm']");
	By stopButton = By.xpath("//input[@id='confirmation-popup-cancel']");
	By downloadTimepointLink = By.xpath("(//div/a[text()='Timepoint'])[2]");
	By downnloadImagesColumn = By.xpath("//div/span[text()='Download Images']");
	By warningMessagePopup = By.xpath("//div[@id='divSuccessMessage']");
	By okWarningMessage = By.xpath("(//div[@class='form-body']//p)[3]");
	By downloadOkButton = By.xpath("(//div/button[text()='OK'])[3]");
	By subjectDropdownText = By.xpath("//table/tbody/tr[3]/td[2]/button/span");
	By timepointDropdownText = By.xpath("//table/tbody/tr[4]/td[2]/button/span");
	RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();

	public void verifyImageSearchforBPtrial(String protocol, String site, String subject) {
		try {
			test.log(LogStatus.INFO, "Checking ImageSearch for BP trial type");
			driver.findElement(ConstantsOR.IMAGE_SEARCH_PROTOCOL_DROPDOWN_BUTTON).click();
			Thread.sleep(3000);
			// driver.findElement(By.xpath("//span/ul//li[text()='US-DEM-999 ']")).click();
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.IMAGE_SEARCH_PROTOCOL_DROPDOWN, protocol);
			Thread.sleep(3000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SITE_DROPDOWN_BUTTON).click();
			// driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='000']")).click();
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.IMAGE_SEARCH_SITE_DROPDOWN, site);

			Thread.sleep(5000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN_BUTTON).click();
			Thread.sleep(8000);
			selectDropdownValueWhenElementIsClickable(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN, subject);

			Thread.sleep(5000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN_BUTTON).click();
			// driver.findElement(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN_BUTTON).click();
			// Thread.sleep(5000);
			// selectDropdownValueWithoutSearch(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN,
			// timepoint);
			// driver.findElement(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN_BUTTON).click();
			driver.findElement(ConstantsOR.IMAGE_SEARCH_BUTTON).click();
			Thread.sleep(8000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(5000);
			takeScreenShot();
			// String
			// text=driver.findElement(ConstantsOR.IMAGE_SEARCH_NO_RESULTS).getText();
			if (isElementPresent_By(ConstantsOR.IMAGE_SEARCH_NO_RESULTS)) {
				test.log(LogStatus.INFO, "No results found for selected criteria");
			} else {
				verifyImageSearchTimepointLink("//div/a[text()='Timepoint']", "Timepoint", "tp");
				verifyImageSearchSubjectLink("//div/a[text()='Subject']", "Subject", "-pa-");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyImageSearchforSDtrial(String protocol, String site, String subject) {
		try {
			test.log(LogStatus.INFO, "Checking ImageSearch for SD trial type");
			driver.findElement(ConstantsOR.IMAGE_SEARCH_PROTOCOL_DROPDOWN_BUTTON).click();
			Thread.sleep(3000);
			// driver.findElement(By.xpath("//span/ul//li[text()='US-DEM-999 ']")).click();
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.IMAGE_SEARCH_PROTOCOL_DROPDOWN, protocol);
			Thread.sleep(3000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SITE_DROPDOWN_BUTTON).click();
			// driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='000']")).click();
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.IMAGE_SEARCH_SITE_DROPDOWN, site);

			Thread.sleep(5000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN_BUTTON).click();
			Thread.sleep(8000);
			selectDropdownValueWhenElementIsClickable(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN, subject);
			// driver.findElement(ConstantsOR.IMAGE_SEARCH_SUBJECT_SEARCH).sendKeys(subject);
			// driver.findElement(null)

			Thread.sleep(5000);
			driver.findElement(ConstantsOR.IMAGE_SEARCH_SUBJECT_DROPDOWN_BUTTON).click();
			// driver.findElement(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN_BUTTON).click();
			// Thread.sleep(5000);
			// selectDropdownValueWithoutSearch(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN,
			// timepoint);
			// driver.findElement(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_DROPDOWN_BUTTON).click();
			driver.findElement(ConstantsOR.IMAGE_SEARCH_BUTTON).click();
			Thread.sleep(8000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(5000);
			takeScreenShot();
			// String
			// text=driver.findElement(ConstantsOR.IMAGE_SEARCH_NO_RESULTS).getText();
			if (isElementPresent_By(ConstantsOR.IMAGE_SEARCH_NO_RESULTS)) {
				test.log(LogStatus.INFO, "No results found for selected criteria");
			} else {

				WebDriverWait wait = new WebDriverWait(driver, 30);
				if (driver.findElements(By.xpath("//div/a[text()='Timepoint']")).size() != 0) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Timepoint']")));
					driver.findElement(By.xpath("//div/a[text()='Timepoint']")).click();
					test.log(LogStatus.INFO, "Clicked on Timepoint link");
					Thread.sleep(10000);
					String Parent_Window = driver.getWindowHandle();
					System.out.println(Parent_Window);

					Set<String> handles = driver.getWindowHandles();

					Iterator<String> it = handles.iterator();
					String parentWindow1 = it.next();
					System.out.println(parentWindow1);
					String childWindow1 = it.next();
					System.out.println(childWindow1);

					driver.switchTo().window(childWindow1);
					Thread.sleep(5000);
					String currentURL = driver.getCurrentUrl();
					System.out.println(currentURL);
					List<WebElement> tpwindowcount = driver
							.findElements(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_NEW_WINDOW_RESULTS_COUNT);
					// int tpwindowcountsize=tpwindowcount.size();
					System.out.println("window tp count " + tpwindowcount.size());
//				for (int i = 0; i < tpwindowcount.size(); i++) {
//
//					String value1 = tpwindowcount.get(i).getText();
//					// System.out.println(value1);
//				}
					if (currentURL.contains("sd-vi")) {
						// System.out.println("test inside");
						// if (tpwindowcount.size() == 1) {
						// System.out.println("test second");
						test.log(LogStatus.PASS, "Timepoint link is working fine");
						test.log(LogStatus.INFO, currentURL);
						// takeScreenShot();

						driver.close();

						// }
					} else {
						test.log(LogStatus.FAIL, "Timepoint link is not working");

						driver.close();

					}

					Thread.sleep(1000);
					driver.switchTo().window(Parent_Window);
					Thread.sleep(3000);

				} else {
					test.log(LogStatus.INFO, "Link may not be there");
					takeScreenShot();
				}
//		} catch (Exception e) {
//			e.printStackTrace();
//			reportFailure("Element not found for verifyChildWindow");
//		}

			}
			verifyImageSearchSubjectLink("//div/a[text()='Subject']", "Subject", "sd-pa");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateSSuserWithProtocolAccess() {
		// try {
		String protocolmesg = driver.findElement(By.xpath("(//div[@class='row'])[4]/div/p")).getText();
		String errormsg = driver.findElement(By.xpath("(//div[@class='row'])[4]/div/p")).getText();
		boolean popup = driver.findElement(By.xpath("//div[@id='divCheckCIPWarning']/header")).isDisplayed();
		if (popup) {
			if (protocolmesg.contains("Your account is not associated with any Protocols")) {
				// System.out.println(protocolmesg);
				test.log(LogStatus.FAIL, protocolmesg);
				takeScreenShot();
			} else if (errormsg.contains("something went wrong")) {

//				// System.out.println(errormsg);
				test.log(LogStatus.FAIL, errormsg);
				takeScreenShot();
			}
		} else {
//			WebDriverWait wait = new WebDriverWait(driver, 60);
//			wait.until(ExpectedConditions.presenceOfElementLocated(imageSearchHeader));
//			takeScreenShot();
//			
//		 int imagesearchheader=driver.findElements(imageSearchHeader).size();
//		if (imagesearchheader > 0) {

			test.log(LogStatus.PASS,
					"Logged in user is added in ADFS and in SMART Submit and has access to SD/BP protocols");
			takeScreenShot();
			//takeScreenShot_Fullsystem();
		}
//			else {
//				test.log(LogStatus.FAIL, "fail");
//			}
	}
	// }

	public void validateNonSSUser() {

		int imagesearchheader = driver.findElements(imageSearchHeader).size();
		if (imagesearchheader > 0) {

			test.log(LogStatus.PASS, "Logged in user is added in ADFS but not in SMART Submit");
			takeScreenShot();
			//takeScreenShot_Fullsystem();
		} else {
			test.log(LogStatus.FAIL, "Logged in user is not routed to Image Search page");
		}
	}

	public void verifyProtocolValidation() {
		// driver.findElement(resetButton).click();
		verifyValidation(searchButton, "//span[@id='ErrProtocol']", "Please select protocol");
		String actsiteerrormsg = driver.findElement(siteErrormsg).getText();
		String expsiteerrormsg = "Please select site";
		if (actsiteerrormsg.equalsIgnoreCase(expsiteerrormsg)) {
			test.log(LogStatus.PASS, "validation message is correct " + actsiteerrormsg);
			takeScreenShot();
		} else {
			test.log(LogStatus.FAIL, "site validation message is not correct");
		}
	}

	public void verifySiteValidation(String protocol) {
		try {
			driver.findElement(protocolDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenSelectOptionPresent(protocolDropdown, protocol);
			test.log(LogStatus.INFO, "protocol " + protocol + " is selected");
			Thread.sleep(3000);
			verifyValidation(searchButton, "//span[@id='ErrSiteId']", "Please select site");
			takeScreenShot();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectSiteAndSearchResults(String site) {
		try {
//		driver.findElement(protocolDropdownButton).click();
//		Thread.sleep(3000);
//		selectDropdownValueWhenSelectOptionPresent(protocolDropdown, protocol);
//		Thread.sleep(3000);

			driver.findElement(siteDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenSelectOptionPresent(siteDropdown, site);
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "site " + site + " is selected");
			takeScreenShot();
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
			 scrollPageDown();

			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.FAIL, "No results found for selected criteria");
			} else {
				test.log(LogStatus.PASS, "Image Search results found for selected protocol and site");
				takeScreenShot();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectSubjectAndSearchResults(String subject) {
		try {

			driver.findElement(subjectDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenElementIsClickable(subjectDropdown, subject);
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "subject " + subject + " is selected");
			 takeScreenShot();
			driver.findElement(subjectDropdownButton).click();
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
			scrollPageDown();
			// takeScreenShot();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.FAIL, "No results found for selected criteria");
			} else {
				test.log(LogStatus.PASS, "Image Search results found for selected protocol, site and subject");
				takeScreenShot();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectTimepointAndSearchResults(String timepoint) {
		try {
			driver.findElement(timepointDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenElementIsClickable(timepointDropdown, timepoint);
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "timepoint " + timepoint + " is selected");
			takeScreenShot();
			driver.findElement(timepointDropdownButton).click();
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
			 scrollPageDown();
			// takeScreenShot();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.FAIL, "No results found for selected criteria");
			} else {
				test.log(LogStatus.PASS,
						"Image Search results found for selected protocol, site, subject and timepoint");
				takeScreenShot();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyImageSearchSearchResults(String protocol, String site, String subject, String timepoint) {
		try {
			driver.findElement(protocolDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenSelectOptionPresent(protocolDropdown, protocol);
			Thread.sleep(3000);
			driver.findElement(siteDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenSelectOptionPresent(siteDropdown, site);
			Thread.sleep(3000);
			driver.findElement(subjectDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenElementIsClickable(subjectDropdown, subject);
			// Thread.sleep(3000);
			driver.findElement(subjectDropdownButton).click();
			driver.findElement(timepointDropdownButton).click();
			Thread.sleep(3000);
			selectDropdownValueWhenElementIsClickable(timepointDropdown, timepoint);
			// Thread.sleep(3000);
			driver.findElement(timepointDropdownButton).click();
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
			scrollPageDown();
			// takeScreenShot();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.FAIL, "No results found for selected criteria");
			} else {
				test.log(LogStatus.PASS,
						"Image Search results found for selected protocol, site, subject and timepoint");
				takeScreenShot();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyResetButton() {

		try {
//		String protocolDefaultValue=driver.findElement(protocolDropdownButton).getAttribute("title");
//		System.out.println(protocolDefaultValue);
//		String sitDefaultValuet=driver.findElement(siteDropdownButton).getAttribute("title");
//		System.out.println(sitDefaultValuet);
//		String subjectDefaultValue=driver.findElement(By.xpath("subjectDropdownText")).getText();
//		System.out.println(subjectDefaultValue);
//		String timepointDefaultValue=driver.findElement(By.xpath("timepointDropdownText")).getText();
//		System.out.println(timepointDefaultValue);
			driver.findElement(resetButton).click();
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Verifying Image Search reset functionality");
			verifyResetValueByUsingAttribute("Protocol", protocolDropdownButton, "title", "Select");
			verifyResetValueByUsingAttribute("Site", siteDropdownButton, "title", "Select");
			verifyResetValueByUsingGetText("Subject", subjectDropdownText, "Select");
			verifyResetValueByUsingGetText("Timepoint", timepointDropdownText, "Select");
			takeScreenShot();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyViewImagesforTimepointlink(String protocoltype) {

		if (protocoltype.equalsIgnoreCase("BP")) {
			try {
				verifyImageSearchTimepointLink("(//div/a[text()='Timepoint'])[1]", "Timepoint", "tp");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (protocoltype.equalsIgnoreCase("SD")) {

			try {
				verifyImageSearchTimepointLink("(//div/a[text()='Timepoint'])[1]", "Timepoint", "sd-vi");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void verifyViewImagesforSubjectlink(String protocoltype) {

		if (protocoltype.equalsIgnoreCase("BP")) {
			try {
				verifyImageSearchSubjectLink("//div/a[text()='Subject']", "Subject", "-pa-");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (protocoltype.equalsIgnoreCase("SD")) {

			try {
				verifyImageSearchSubjectLink("//div/a[text()='Subject']", "Subject", "sd-pa");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void verifyDownloadImagesTimepointlink() {
		try {
			driver.findElement(downloadTimepointLink).click();
			test.log(LogStatus.INFO, "Clicked on Timepoint link");
			Thread.sleep(3000);
			boolean confirmationPopup = driver.findElement(iAgreeButton).isDisplayed();
			if (confirmationPopup) {
				test.log(LogStatus.PASS, "Confirmation pop up is displayed");
				takeScreenShot();
			} else {
				test.log(LogStatus.FAIL, "Confirmation pop up is not displayed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyStopDownloadButton() {
		try {
			driver.findElement(stopButton).click();
			test.log(LogStatus.INFO, "Clicked on Stop, do not proceed button");
			Thread.sleep(2000);
			boolean timepointlinkactive = driver.findElement(downloadTimepointLink).isEnabled();
			if (timepointlinkactive) {
				test.log(LogStatus.PASS,
						"Confirmation pop up is closed and user redirected to Image Search results page");
				takeScreenShot();
			} else {
				test.log(LogStatus.FAIL, "Confirmation pop up is not closed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyIagreeDownloadButton() {
		try {
			driver.findElement(iAgreeButton).click();
			test.log(LogStatus.INFO, "Clicked on I Agree button");
			Thread.sleep(5000);
			String okwarningmessage = driver.findElement(okWarningMessage).getText();
			if (okwarningmessage.contains(
					"Your images are being retrieved and will be emailed to you shortly with the download link")) {
				test.log(LogStatus.INFO, okwarningmessage);
				test.log(LogStatus.PASS, "Download process started and warning message also dislayed");
				takeScreenShot();
			} else {
				test.log(LogStatus.FAIL, "Download process not started");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyConfirmDownloadOkButton() {
		try {
			driver.findElement(downloadOkButton).click();
			test.log(LogStatus.INFO, "clicked on OK button");
			Thread.sleep(2000);
			boolean timepointlinkactive = driver.findElement(downloadTimepointLink).isEnabled();
			if (timepointlinkactive) {
				test.log(LogStatus.PASS, "User redirected to Image Search results page");
				takeScreenShot();
			} else {
				test.log(LogStatus.FAIL, "Download Confirmation pop up is not closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}