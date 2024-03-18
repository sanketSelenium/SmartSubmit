package com.clario.ss.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PortalAndImageSearchLogPage extends BasePage {

	public PortalAndImageSearchLogPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	By pageDropdownButton = By.xpath("//button[@data-id='ddlPageType']");
	By pageDropdownOptions = By.xpath("//ul[@class='dropdown-menu inner']/li/a");
	By imageSearchNoResults = By.xpath("//div[@id='divImageSearchGrid']//table/tbody/tr/td[text()='None']");
	By portalAndImageSearchLogHeader = By.xpath("//div[@class='m-b-md']/h3[text()='Portal and Image Search Log']");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By userName = By.id("UserName");
	By protocolDropdownButton = By.xpath("//table[@class='tblImageSearch']/tbody//td//button");
	By protocolDropdownValues = By.xpath(
			"//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass']/ul/li/a/label/input[@name='multiselect_Protocol']/following-sibling::span");

	By fromDate = By.id("FromDate");
	By toDate = By.id("ToDate");
	By monthDropdown = By.xpath("//select[@class='ui-datepicker-month']");
	By yearDropdown = By.xpath("//select[@class='ui-datepicker-year']");
	By selectDay = By.xpath("//tbody/tr/td[@data-handler='selectDay']");
	By viewImagesDropdownButton = By.xpath("//span[@id='select2-ViewImagesTypeId-container']");
	By viewImagesDropdownValues = By.xpath("//ul[@id='select2-ViewImagesTypeId-results']/li");
	By searchButton = By.xpath("//button[@id='btnImageSearch']");
	By resetButton = By.xpath("//button[@id='btnImageReset']");
	By exportToExcelButton = By.xpath("//button[@id='btnExportImageSearchLog']");
	By firstNameSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[1]");
	By lastNameSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[2]");
	By usernameSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[3]");
	By protocolSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[4]");
	By dateRangeSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[10]");
	By viewImagesSearchResult = By.xpath("(//table[@class='jtable']/tbody/tr/td)[8]");
	By exportToExcelButtonPopUp = By.xpath("//div[@id='cboxLoadedContent']/div[1]");

	WebDriverWait wait = new WebDriverWait(driver, 60);
	RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();

	public void verifImageSearchlogResultsDisplay() {
		try {
			driver.findElement(pageDropdownButton).click();

			selectDropdownValueWhenSelectOptionPresent(pageDropdownOptions, "Image Search");
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Image Search page is selected");
			takeScreenShot();
			scrollPageDown();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.FAIL, "No results found");
			} else {
				test.log(LogStatus.PASS, "Image Search Log results are displayed");
				takeScreenShot();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void imageSearchResultsBasedOnFirstName(String firstname) {
		try {
			driver.findElement(firstName).sendKeys(firstname);
			test.log(LogStatus.INFO, "Entered firstname "+firstname);
			driver.findElement(searchButton).click();
			Thread.sleep(5000);
			takeScreenShot();
			scrollPageDown();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.INFO, "No results found for entered criteria " + firstname);
			} else {
				String fnsearchresult = driver.findElement(firstNameSearchResult).getText();
				if (fnsearchresult.equalsIgnoreCase(firstname)) {
					test.log(LogStatus.PASS, "Image Search results found for entered firstname " + firstname);
					takeScreenShot();
				} else {
					test.log(LogStatus.FAIL, "Results not matched with entered firstname" + firstname);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void imageSearchResultsBasedOnLastName(String lastname) {

		try {
			driver.findElement(resetButton).click();
			driver.findElement(lastName).sendKeys(lastname);
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Entered lastname "+lastname);
			driver.findElement(searchButton).click();
			Thread.sleep(5000);
			takeScreenShot();
			scrollPageDown();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.INFO, "No results found for entered criteria " + lastname);
			} else {
				String lnsearchresult = driver.findElement(lastNameSearchResult).getText();
				if (lnsearchresult.equalsIgnoreCase(lastname)) {
					test.log(LogStatus.PASS, "Image Search results found for entered lastname " + lastname);
					takeScreenShot();
				} else {
					test.log(LogStatus.FAIL, "Results not matching with entered criteria");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void imageSearchResultsBasedOnUserName(String username) {
		try {
			driver.findElement(resetButton).click();
			driver.findElement(userName).sendKeys(username);
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Entered username "+username);
			Thread.sleep(2000);
			driver.findElement(searchButton).click();

			Thread.sleep(5000);
			takeScreenShot();
			scrollPageDown();
			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.INFO, "No results found for entered criteria " + username);
			} else {
				String unsearchresult = driver.findElement(usernameSearchResult).getText();
				if (unsearchresult.equalsIgnoreCase(username)) {
					test.log(LogStatus.PASS, "Image Search results found for entered username " + username);
					takeScreenShot();
				} else {
					test.log(LogStatus.FAIL, "Results are not matching with entered criteria");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void imageSearchResultsBasedOnProtocol(String protocol) {
		try {
			driver.findElement(resetButton).click();
			Thread.sleep(3000);
			driver.findElement(protocolDropdownButton).click();
			selectDropdownValueWhenElementIsClickable(protocolDropdownValues, protocol);
			Thread.sleep(2000);
			//test.log(LogStatus.INFO, "Selected protocol "+protocol);
			driver.findElement(protocolDropdownButton).click();
			driver.findElement(searchButton).click();

			Thread.sleep(3000);
			//takeScreenShot();
			scrollPageDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isElementPresent_By(imageSearchNoResults)) {
			test.log(LogStatus.INFO, "No results found for entered criteria " + protocol);
		} else {
			String protocolsearchresult = driver.findElement(protocolSearchResult).getText();
			if (protocolsearchresult.equalsIgnoreCase(protocol)) {
				test.log(LogStatus.PASS, "Image Search results found for selected protocol " + protocol);
				takeScreenShot();
			} else {
				test.log(LogStatus.FAIL, "Results not matching with entered criteria");
			}
		}
	}

	public void selectFromDate(String actFromDate) {
		try {
			driver.findElement(fromDate).click();

			Thread.sleep(3000);
			String arr[] = actFromDate.split("-");
			String day = arr[0];
		//	System.out.println(arr[0]);
			String month = arr[1];
			String year = arr[2];
			wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
			driver.findElement(monthDropdown).click();
			Select monthdropdown = new Select(driver.findElement(monthDropdown));
			monthdropdown.selectByVisibleText(month);
			driver.findElement(yearDropdown).click();
			Select yeardropdown = new Select(driver.findElement(yearDropdown));
			yeardropdown.selectByVisibleText(year);

			List<WebElement> fromdays = driver.findElements(selectDay);
			for (int i = 0; i < fromdays.size(); i++) {
				String fday = fromdays.get(i).getText();
				//System.out.println("from date "+fday);
				if (fday.equals(day)) {
					fromdays.get(i).click();
					break;
				}

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectToDate(String actToDate) {

		try {
			driver.findElement(toDate).click();

			Thread.sleep(3000);
			String arr[] = actToDate.split("-");
			String day = arr[0];
			String month = arr[1];
			String year = arr[2];
			wait.until(ExpectedConditions.elementToBeClickable(monthDropdown));
			driver.findElement(monthDropdown).click();
			Select monthdropdown = new Select(driver.findElement(monthDropdown));
			monthdropdown.selectByVisibleText(month);
			driver.findElement(yearDropdown).click();
			Select yeardropdown = new Select(driver.findElement(yearDropdown));
			yeardropdown.selectByVisibleText(year);

			List<WebElement> fromdays = driver.findElements(selectDay);
			for (int i = 0; i < fromdays.size(); i++) {
				String fday = fromdays.get(i).getText();
				if (fday.equals(day)) {
					fromdays.get(i).click();
					break;
				}

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectDateRange() {
		try {
			Thread.sleep(8000);
			driver.findElement(resetButton).click();
			Thread.sleep(8000);
			selectFromDate(randomexceldata.readSpecificData("SS6344", 1, 4));
			selectToDate(randomexceldata.readSpecificData("SS6344", 1, 5));
			Thread.sleep(5000);
			driver.findElement(searchButton).click();
			Thread.sleep(10000);
			//takeScreenShot();
			//scrollPageDown();
			String datefrom = randomexceldata.readSpecificData("SS6344", 1, 4);
			String dateto = randomexceldata.readSpecificData("SS6344", 1, 5);

			if (isElementPresent_By(imageSearchNoResults)) {
				test.log(LogStatus.INFO, "No results found for selected dates");
			} else {
				String datesearchresult = driver.findElement(dateRangeSearchResult).getText();
				
//				int resultdate=datefrom.compareTo(datesearchresult) * datesearchresult.compareTo(dateto);
				System.out.println(" datesearchresult "+datesearchresult);
				System.out.println("datefrom  "+datefrom); 
				System.out.println("dateto  "+dateto);
				System.out.println("datefrom.compareTo(datesearchresult)  "+datefrom.compareTo(datesearchresult));
				System.out.println("datesearchresult.compareTo(dateto)  "+datesearchresult.compareTo(dateto));
				if (datefrom.compareTo(datesearchresult) * datesearchresult.compareTo(dateto) <= 0) {
					test.log(LogStatus.PASS, "Image Search results found for Selected dates ");
					takeScreenShot();
				} else {
					test.log(LogStatus.FAIL, "Results not matched with selected dates");
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void imageSearchResultsBasedOnViewImages(String viewImage) {
		driver.findElement(resetButton).click();
		try {
			Thread.sleep(3000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(viewImagesDropdownButton).click();
		selectDropdownValueWhenSelectOptionPresent(viewImagesDropdownValues, viewImage);
		driver.findElement(searchButton).click();
		try {
			Thread.sleep(3000);
		//	takeScreenShot();
			//scrollPageDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String viewimagesresult = driver.findElement(viewImagesSearchResult).getText();
		if (viewimagesresult.equalsIgnoreCase(viewImage)) {
			test.log(LogStatus.PASS, "Image Search results found for selected criteria " + viewImage);
			takeScreenShot();
		} else {
			test.log(LogStatus.FAIL, "Results are not matching with selected criteria");
		}
	}

	public void varifyExportToExcelButton() {
		try {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(resetButton));
			driver.findElement(resetButton).click();
			Thread.sleep(3000);
			driver.findElement(exportToExcelButton).click();
			waitForVisibility(exportToExcelButtonPopUp, driver);

			test.log(LogStatus.INFO,
					"Pop Up displayed: " + "Please keep this window open while we generate your report");
			takeScreenShot();
			waitForInvisibility(exportToExcelButtonPopUp, driver);
			test.log(LogStatus.PASS, "Export to Excel report generated successfully");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}