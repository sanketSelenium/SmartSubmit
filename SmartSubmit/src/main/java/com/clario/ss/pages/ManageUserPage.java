package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ManageUserPage extends BasePage{
	
	public ManageUserPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}

	By userNameTextbox=By.id("txtSearchEmail");
	By manageUserSearchButton=By.id("btnSearchUser");
	By noResultsFound=By.xpath("//*[@id='UserInfoGridContainer']/div/table/tbody/tr/td[text()='None']");
	By userNameStatusActiveLink=By.xpath("(//tbody/tr/td/a)[5]");
	By yesButton=By.xpath("//div/input[@id='btnYes']");
	By submitButton=By.id("ConfirmSubmit");
	//By userNameStatusInactiveLink=By.xpath("//tbody/tr/td/a[text()=\"Inactive\"]");
	By backLink=By.xpath("//div/a[text()='BACK']");
	By userManagementMenu=By.xpath("(//button[@class='btn btn-success dropdown-toggle admButton'])[1]");
	By userManagementOptions=By.xpath("(//ul[@class='dropdown-menu ddAdmin'])[1]/li/a");
	By searchUserTextbox=By.id("Email");
	By deleteUserSearchButton=By.xpath("//button[@id='btnSearch']");
	By userInactivatedMessage=By.xpath("//div/label[@id=\"Deletemessage\"]");
	By closeButton=By.xpath("//button[@id=\"cboxClose\"]");
	By comments=By.xpath("//*[@id=\"UserComment\"]");
	By exportToExcelButton=By.xpath("//div/button[@id='btnExportResults']");
	By deleteUserButton=By.xpath("//div/button[@id='btnDeleteUser']");
	By deleteUserYesButton=By.xpath("//div/input[@id='ConfirmSubmit']");
	By esignUsername=By.id("txtusername");
	By esignPassword=By.id("txtpassword");
	By esignSubmitButton=By.xpath("//div/button[@id='btnsubmit']");
	By loadingSpinner=By.xpath("//div[@id='spinner']");
	By deleteUserSuccessMesg=By.xpath("//div/label[@id='Successmessage']");
	
	
	WebDriverWait wait=new WebDriverWait(driver,90);
	public void SearchUserByUsernameOnly(String username) 
	{
		try
		{
		driver.findElement(userNameTextbox).sendKeys(username);
		driver.findElement(manageUserSearchButton).click();
		//WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SEARCH_RESULTS_COUNT));
	    Thread.sleep(5000);
		
		if(isElementPresent_By(noResultsFound))
		{
			String userscount=driver.findElement(noResultsFound).getText();
			System.out.println(userscount);
		
			test.log(LogStatus.INFO, "User is not present in SMART Submit");
			
		}
		else {
			test.log(LogStatus.INFO, "User is present in SMART Submit");
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void clickOnRemoveUserLink() {
		selectDropdownValueWhenElementIsClickable(userManagementOptions, "Remove User");
		String expTitle="SMART Submit - Manage User Role Activation";
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		if(expTitle.equals(actTitle)) {
			test.log(LogStatus.INFO, "Manage User Role Activation page opened properly");
		}
		else {
			test.log(LogStatus.INFO, "Manage User Role Activation page not working, please check");
		}
	}
	
	public void RemoveUser(String username,String esignun,String esignpwd) {
		try
		{
		driver.findElement(userNameTextbox).sendKeys(username);
		driver.findElement(manageUserSearchButton).click();
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		if(isElementPresent_By(noResultsFound))
		{
			scrollPageDown();
			Thread.sleep(2000);
			takeScreenShot();
			String userscount=driver.findElement(noResultsFound).getText();
			System.out.println(userscount);
		
			test.log(LogStatus.INFO, "User is not present in SMART Submit");
			//Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(backLink)).click().build().perform();
	
			Thread.sleep(2000);
		
		}
		else {
			scrollPageDown();
			Thread.sleep(2000);
			takeScreenShot();
			test.log(LogStatus.INFO, "User is present in SMART Submit");
		
			String userStatus=driver.findElement(userNameStatusActiveLink).getText();
			System.out.println(userStatus);
			if(userStatus.equals("Active")) {
				driver.findElement(userNameStatusActiveLink).click();
				Thread.sleep(8000);
				driver.switchTo().frame(1);
				String text=driver.findElement(exportToExcelButton).getText();
				System.out.println(text);
				
				scrollPageDown();
				driver.findElement(yesButton).click();
				driver.findElement(submitButton).click();
				String inactiveMessage=driver.findElement(userInactivatedMessage).getText();
				if(inactiveMessage.contains("inactivated")) {
					test.log(LogStatus.PASS, "User has been inactivated");
					Thread.sleep(8000);
					
				//	Actions act=new Actions(driver);
					act.moveToElement(driver.findElement(backLink)).click().build().perform();
			
					Thread.sleep(2000);
					driver.findElement(userManagementMenu).click();
					clickOnRemoveUserLink();
					driver.findElement(searchUserTextbox).sendKeys(username);
					driver.findElement(deleteUserSearchButton).click();
					Thread.sleep(8000);
					takeScreenShot();
					driver.findElement(deleteUserButton).click();
					driver.findElement(deleteUserYesButton).click();
					Thread.sleep(3000);
					driver.switchTo().frame(1);
					Thread.sleep(3000);
					driver.findElement(esignUsername).sendKeys(esignun);
					driver.findElement(esignPassword).sendKeys(esignpwd);
					driver.findElement(esignSubmitButton).click();
					//wait.until(ExpectedConditions.visibilityOfElementLocated(loadingSpinner));
					wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinner));
					String deleteMsg=driver.findElement(deleteUserSuccessMesg).getText();
					System.out.println(deleteMsg);
					if(deleteMsg.contains("deleted")) {
						
						
						test.log(LogStatus.PASS, "User deleted successfully");
						
					
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", driver.findElement(backLink));
					}
					else {
						test.log(LogStatus.FAIL, "User not deleted "+deleteMsg);
					}
					
				}
			}
				else {
					test.log(LogStatus.INFO, "User is inactive");
					
					//Actions act=new Actions(driver);
					act.moveToElement(driver.findElement(backLink)).click().build().perform();
			
					Thread.sleep(2000);
					driver.findElement(userManagementMenu).click();
					clickOnRemoveUserLink();
					driver.findElement(searchUserTextbox).sendKeys(username);
					driver.findElement(deleteUserSearchButton).click();
					Thread.sleep(8000);
					driver.findElement(deleteUserButton).click();
					driver.findElement(deleteUserYesButton).click();
					Thread.sleep(3000);
					driver.switchTo().frame(1);
					Thread.sleep(3000);
					driver.findElement(esignUsername).sendKeys(esignun);
					driver.findElement(esignPassword).sendKeys(esignpwd);
					driver.findElement(esignSubmitButton).click();
					//Thread.sleep(10000);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinner));
					String deleteMsg=driver.findElement(deleteUserSuccessMesg).getText();
					if(deleteMsg.contains("deleted")) {
						
						//act.moveToElement(driver.findElement(backLink)).click().build().perform();
						test.log(LogStatus.PASS, "User deleted successfully");
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("arguments[0].click();", driver.findElement(backLink));
					}
					else {
						test.log(LogStatus.FAIL, "User not deleted "+deleteMsg);
					}
				}
			
			}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		
		
}
	public void updateUserSmartPortalAccessSet(String setValue) 
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@class='jtable']/tbody/tr[1]/td[3]/a"))));
		driver.findElement(By.xpath("//table[@class='jtable']/tbody/tr[1]/td[3]/a")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		Thread.sleep(5000);
		//driver.findElement(By.id("City")).sendKeys("City");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(ConstantsOR.EDIT_USER_SAVE_BUTTON));
//		String setting=driver.findElement(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_DROPDOWN).getText();
//		System.out.println(setting);
		//wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_DROPDOWN));
	driver.findElement(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_BUTTON).click();
	Thread.sleep(5000);
		//new Select(driver.findElement(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_DROPDOWN)).selectByVisibleText(setValue);
	selectDropdownValueWithoutSearch(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_DROPDOWN, setValue);

//		if(setting.equalsIgnoreCase("Off")) {
//			driver.findElement(By.xpath("//input[@id=\"reset\"]")).click();
//			driver.findElement(ConstantsOR.SIGNOUT_BUTTON).click();
//		}
//		else {
//			driver.findElement(ConstantsOR.SMART_PORTAL_ACCESS_SETTING_DROPDOWN).click();
//			
//		;
//		driver.findElement(ConstantsOR.SAVE_BUTTON).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();",driver.findElement(ConstantsOR.EDIT_USER_SAVE_BUTTON));
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}catch(Exception e) {
		e.printStackTrace();
		
		}
}
}