package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdminOptionsPage extends BasePage{
	
	//public WebDriver driver;
	public AdminOptionsPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	By userManagementMenu=By.xpath("(//button[@class='btn btn-success dropdown-toggle admButton'])[1]");
	By userManagementOptions=By.xpath("(//ul[@class='dropdown-menu ddAdmin'])[1]/li/a");
	By systemSettingsMenu=By.xpath("(//button[@class='btn btn-success dropdown-toggle admButton'])[2]");
	By systemSettingsDropdownOptions=By.xpath("(//ul[@class='dropdown-menu ddAdmin'])[2]/li/a");
	
	public String getAdminOptionsPageTitle() {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("Admin Options"));
		return driver.getTitle();
	}
	public void clickOnUserManagementMenu() {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(userManagementMenu)).click().perform();
	}

	public void clickOnInviteUserLink() {
		//Actions act=new Actions(driver);
		//act.moveToElement(driver.findElement(userManagementMenu)).click().perform();
		selectDropdownValueWithoutSearch(userManagementOptions, "Invite User");
		String expTitle="SMART Submit - Invite User";
		String actTitle=driver.getTitle();
		if(expTitle.equals(actTitle)) {
			test.log(LogStatus.PASS, "Invite User page opened properly");
		}
		else {
			test.log(LogStatus.FAIL, "Invite User page not working, please check");
		}
	}
	public void clickOnManageUserLink() {
		//Actions act=new Actions(driver);
		//act.moveToElement(driver.findElement(userManagementMenu)).click().perform();
		selectDropdownValueWhenElementIsClickable(userManagementOptions, "Manage User");
		String expTitle="SMART Submit - Manage User";
		String actTitle=driver.getTitle();
		if(expTitle.equals(actTitle)) {
			test.log(LogStatus.INFO, "Manage User page opened properly");
		}
		else {
			test.log(LogStatus.INFO, "Manage User page not working, please check");
		}
	}
	
	public void doClickOnPortalAndImageSearchLogLink() {
		try {
		doClickWithActions(systemSettingsMenu);
		selectDropdownValueWithoutSearch(systemSettingsDropdownOptions, "Portal and Image Search Log");
		Thread.sleep(5000);
		String actTitle=driver.getTitle();
		if(actTitle.equals("SMART Submit - Portal and Image Search Log")) {
			test.log(LogStatus.PASS, "Portal and Image Search log page opened properly");
			takeScreenShot();
		}
		else {
			test.log(LogStatus.FAIL, "Portal and Image Search log page not opened");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
	

