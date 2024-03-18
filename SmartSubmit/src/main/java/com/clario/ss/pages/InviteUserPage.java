package com.clario.ss.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InviteUserPage extends BasePage{

	//public WebDriver driver;
	

	public InviteUserPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	By userManagementOptions=By.xpath("(//ul[@class='dropdown-menu ddAdmin'])[1]/li/a");
	By emailTextbox=By.xpath("//input[@id='txtEmail']");
	By submitEmailButton=By.xpath("//button[@id='btnSubmitEmail']");
	By firstNameTextbox=By.id("txtFName");
	By lastNameTextbox=By.id("txtLName");
	By selectRoleDropdown=By.xpath("//button[@data-id='ddlRole']");
	By roleDropdownValues=By.xpath("(//ul[@class='dropdown-menu inner'])[2]/li/a");
	By inviteSubmitButton=By.xpath("//button[@id='submit']");
	By selectAccountDropdown=By.xpath("//button[@data-id='ddlAccount']");
	By accountDropdownValues=By.xpath("(//ul[@class='dropdown-menu inner'])[3]/li/a");
	By selectTrialDropdown=By.xpath("//button[@data-id='ddlTrial']");
	By trialDropdownValues=By.xpath("(//ul[@class='dropdown-menu inner'])[4]/li/a");
	By SelectSiteDropdown=By.xpath("(//td//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[2]");
	By siteSearchTextbox=By.xpath("(//ul[@class='ui-helper-reset']/li/input)[2]");
	By siteDropdownValues=By.xpath("(//ul[@class='ui-multiselect-checkboxes ui-helper-reset'])[2]/li/a/label/input/following-sibling::span");
	By siteValueSelected=By.xpath("//*[@id=\"InviteUser\"]/table/tbody/tr[11]/td[2]/button");
	By inviteUserSuccMsg=By.xpath("//div[@id='divResponseMsg']");
	
	public String getInviteUserPageTitle() {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.titleContains("Invite User"));
		return driver.getTitle();
	}
	
	public void clickOnInviteUserLink() {
		selectDropdownValueWhenElementIsClickable(userManagementOptions, "Invite User");
		String expTitle="SMART Submit - Invite User";
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		if(expTitle.equals(actTitle)) {
			test.log(LogStatus.INFO, "Invite User page opened properly");
		}
		else {
			test.log(LogStatus.INFO, "Invite User page not working, please check");
		}
	}

	public void inviteUsers(String role)  {
		WebDriverWait wait = new WebDriverWait(driver,120);
		try {
		RandomDataExcelUtil randomexceldata = new RandomDataExcelUtil();
		
		String mddxroles[] = { "MDDX Admin", "MDDX IQC", "BC IQC" };
		Set<String> allroleslist = new HashSet<>(Arrays.asList(mddxroles));

		String sponsorroles[] = { "Trial Manager", "Data Manager", "Clinical Specialist (CS)", "Auditor", "Monitor",
				"Executive Committee" };
		Set<String> sponsorrolelist = new HashSet<>(Arrays.asList(sponsorroles));

		String uploaduserroles[] = { "Clinical Research Coordinator (CRC)", "Investigator" };
		Set<String> uploadusersrolelist = new HashSet<>(Arrays.asList(uploaduserroles));

		String corelabroles[] = { "Image Admin", "Image Reviewer", "Image Tech" };
		Set<String> corelabrolelist = new HashSet<>(Arrays.asList(corelabroles));

		if (allroleslist.contains(role)) {

			//WebDriverWait wait = new WebDriverWait(driver,60);
			test.log(LogStatus.INFO, "Invite User Page opened");
		        takeScreenShot();
			test.log(LogStatus.INFO, "Inviting for role :"+role);

				driver.findElement(ConstantsOR.EMAIL_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,1));

			driver.findElement(ConstantsOR.SUBMIT_EMAIL_BUTTON).click();
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.FIRSTNAME_TEXTBOX));
			
				driver.findElement(ConstantsOR.FIRSTNAME_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,2));
			
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.LASTNAME_TEXTBOX));
			
				driver.findElement(ConstantsOR.LASTNAME_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,3));
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SELECT_ROLE_DROPDOWN));
			driver.findElement(ConstantsOR.SELECT_ROLE_DROPDOWN).click();
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.ROLE_DROPDOWN_VALUES));
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.ROLE_DROPDOWN_VALUES, role);
			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SUBMIT_INVITE_BUTTON));
			driver.findElement(ConstantsOR.SUBMIT_INVITE_BUTTON).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.INVITE_SUCCESS_MESSAGE));
			String successMessage = driver.findElement(ConstantsOR.INVITE_SUCCESS_MESSAGE).getText();
			System.out.println(successMessage);
			test.log(LogStatus.INFO, successMessage);
            takeScreenShot();

		} else if (sponsorrolelist.contains(role)) {
		//	WebDriverWait wait = new WebDriverWait(driver, 90);
			test.log(LogStatus.INFO, "Invite User Page opened");
	        takeScreenShot();
			test.log(LogStatus.INFO, "Inviting for role :"+role);
			driver.findElement(ConstantsOR.EMAIL_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,1));
			driver.findElement(ConstantsOR.SUBMIT_EMAIL_BUTTON).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.FIRSTNAME_TEXTBOX));
			driver.findElement(ConstantsOR.FIRSTNAME_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,2));
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.LASTNAME_TEXTBOX));
			driver.findElement(ConstantsOR.LASTNAME_TEXTBOX).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,3));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SELECT_ROLE_DROPDOWN));
			driver.findElement(ConstantsOR.SELECT_ROLE_DROPDOWN).click();
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.ROLE_DROPDOWN_VALUES));
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.ROLE_DROPDOWN_VALUES, role);
			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SELECT_ACCOUNT_DROPDOWN));
			doClick(ConstantsOR.SELECT_ACCOUNT_DROPDOWN);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.ACCOUNT_DROPDOWN_VALUES));
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.ACCOUNT_DROPDOWN_VALUES, randomexceldata.readSpecificData("InviteUserDataWithRole",1,4));
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SELECT_TRIAL_DROPDOWN));
			doClick(ConstantsOR.SELECT_TRIAL_DROPDOWN);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.TRIAL_DROPDOWN_VALUES));
			selectDropdownValueWithoutSearch(ConstantsOR.TRIAL_DROPDOWN_VALUES, randomexceldata.readSpecificData("InviteUserDataWithRole",1,5));
			driver.findElement(ConstantsOR.TRIAL_DROPDOWN_VALUES).sendKeys(Keys.TAB);
			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SUBMIT_INVITE_BUTTON));
			doClick(ConstantsOR.SUBMIT_INVITE_BUTTON);
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.INVITE_SUCCESS_MESSAGE));
			String successMessage = driver.findElement(ConstantsOR.INVITE_SUCCESS_MESSAGE).getText();
			System.out.println(successMessage);
			test.log(LogStatus.INFO, successMessage);
			takeScreenShot();

		} else if (uploadusersrolelist.contains(role)) {
		//	WebDriverWait wait = new WebDriverWait(driver, 60);
//			test.log(LogStatus.INFO, "Invite User Page opened");
//	        takeScreenShot();
			test.log(LogStatus.INFO, "Inviting User for role :"+role);
			driver.findElement(emailTextbox).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,1));
			driver.findElement(ConstantsOR.SUBMIT_EMAIL_BUTTON).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextbox));
			takeScreenShot();
			driver.findElement(firstNameTextbox).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,4));
			//wait.until(ExpectedConditions.presenceOfElementLocated(lastNameTextbox));
			driver.findElement(lastNameTextbox).sendKeys(randomexceldata.readSpecificData("InviteUserDataWithRole",1,5));
			//Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(selectRoleDropdown));
			driver.findElement(selectRoleDropdown).click();
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(roleDropdownValues));
			selectDropdownValueWhenSelectOptionPresent(roleDropdownValues, role);
			wait.until(ExpectedConditions.elementToBeClickable(selectAccountDropdown));
			doClick(selectAccountDropdown);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(accountDropdownValues));
			selectDropdownValueWhenSelectOptionPresent(accountDropdownValues, randomexceldata.readSpecificData("InviteUserDataWithRole",1,6));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(selectTrialDropdown));
			doClick(selectTrialDropdown);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(trialDropdownValues));
			Thread.sleep(5000);
			selectDropdownValueWithoutSearch(trialDropdownValues, randomexceldata.readSpecificData("InviteUserDataWithRole",1,7));
			Thread.sleep(3000);
		
			
			wait.until(ExpectedConditions.elementToBeClickable(SelectSiteDropdown));
			doClick(SelectSiteDropdown);
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(siteDropdownValues));
			
			
			selectDropdownValueWithoutSearch(siteDropdownValues, randomexceldata.readSpecificData("InviteUserDataWithRole",1,8));
			Thread.sleep(3000);
			doClick(siteValueSelected);
			//Thread.sleep(3000);
			//scrollPageDown();
			wait.until(ExpectedConditions.elementToBeClickable(inviteSubmitButton));
			doClick(inviteSubmitButton);
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.INVITE_SUCCESS_MESSAGE));
			String successMessage = driver.findElement(ConstantsOR.INVITE_SUCCESS_MESSAGE).getText();
			System.out.println(successMessage);
			test.log(LogStatus.INFO, successMessage);
			Thread.sleep(5000);
			takeScreenShot();
		}
		else if (corelabrolelist.contains(role)) {
		//	WebDriverWait wait = new WebDriverWait(driver, 60);

			driver.findElement(ConstantsOR.EMAIL_TEXTBOX).sendKeys("test32136@yopmail.com");
			driver.findElement(ConstantsOR.SUBMIT_EMAIL_BUTTON).click();
			// WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.FIRSTNAME_TEXTBOX));
			driver.findElement(ConstantsOR.FIRSTNAME_TEXTBOX).sendKeys("test5");
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.LASTNAME_TEXTBOX));
			driver.findElement(ConstantsOR.LASTNAME_TEXTBOX).sendKeys("user3215");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SELECT_ROLE_DROPDOWN));
			driver.findElement(ConstantsOR.SELECT_ROLE_DROPDOWN).click();
			// Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.ROLE_DROPDOWN_VALUES));
			selectDropdownValueWhenSelectOptionPresent(ConstantsOR.ROLE_DROPDOWN_VALUES, role);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.SELECT_CORELAB_DROPDOWN));
			selectDropdownValueWithoutSearch(ConstantsOR.CORELAB_DROPDOWN_VALUES, "TestlaxCL");
			driver.findElement(ConstantsOR.CORELAB_DROPDOWN_VALUES).sendKeys(Keys.TAB);
			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SUBMIT_INVITE_BUTTON));
			doClick(ConstantsOR.SUBMIT_INVITE_BUTTON);
			wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.INVITE_SUCCESS_MESSAGE));
			String successMessage = driver.findElement(ConstantsOR.INVITE_SUCCESS_MESSAGE).getText();
			System.out.println(successMessage);
			takeScreenShot();
		}
		
		else {
			System.out.println("pass the correct role");
		}


	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
