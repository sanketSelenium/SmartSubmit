package com.clario.ss.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

//	public DashboardPage(WebDriver driver) {
//		super(driver);
//	}
	By signoutbutton = By.xpath("//a[@class='signOutButton']");
	By loader = By.xpath("//section[@id='content']/div[@id='spinner']");
	By settingIcon=By.xpath("//a[@class='dropdown-toggle settingHeader']");
	By adminAreaLink=By.linkText("Admin Area");
	By afterRegloginButton=By.xpath("//div/button[@id='btnYes']");
	By userNameTextbox = By.id("userNameInput");
	By passwordTextbox = By.id("passwordInput");
	By signInButton = By.xpath("//span[@id=\"submitButton\"]");
	By qualStartButton=By.id("btnStart");
	By qualVideoPlayButton=By.xpath("//div//button[@class='jp-play jp-button']");
	By qualNextButton=By.id("btnValidate");
	By pinCodeNum1=By.xpath("//div//input[@id='txtnumber1']");
	By pinCodeNum2=By.xpath("//div//input[@id='txtnumber2']");
	By pinCodeNum3=By.xpath("//div//input[@id='txtnumber3']");
	By pinCodeNum4=By.xpath("//div//input[@id='txtnumber4']");
	By pinCodeSubmitButton=By.xpath("//div//input[@id='btnValidatePincode']");
	By esignUsername=By.id("txtusername");
	By esignPassword=By.id("txtpassword");
	By esignSubmitButton=By.xpath("//div/button[@id='btnsubmit']");
	By loadingSpinner=By.xpath("//div[@id='spinner']");
	By proceedNextButton=By.id("btnStart");
	By selectFileButton=By.xpath("//div//input[@id='pickfiles']");
	By fileSubmitButton=By.id("BtnFormSubmit");
	By fileUploadProgress=By.xpath("//div/div[@id='njuUploadProgress']");
	By fileUploadCompletePopupText=By.xpath("//div/div[@id='dvUpladDicom']/header/strong");
	By okButton=By.xpath("//div/div[@id='dvUpladDicom']//button[text()=\"OK\"]");
	By qualPendingButton=By.xpath("//div//button[@id='BtnUserNotValid']");
	By loginSuccessMesg=By.xpath("//div/div[@id='LoginSuccessMessage']");

	public boolean isSignoutButtonExist() {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		int logoutbutton = driver.findElements(signoutbutton).size();
		if (logoutbutton >= 1) {
			return true;
		} else {
			return false;
		}
	}

	public void validateSSUseraccess() {

		String actTitle = driver.getTitle();
		if (actTitle.contains("Dashboard")) {
			test.log(LogStatus.PASS, "Logged in user is added in ADFS and in SMART Submit");
			takeScreenShot();
			//takeScreenShot_Fullsystem();
		} else {
			test.log(LogStatus.FAIL, "Logged in user is not redirected to dashboard");
		}
	}

	public boolean isAdvSearchLinkPresent() {

		return driver.findElement(ConstantsOR.advSearchLink).isDisplayed();
	}

	public void  getDashboardPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		if (wait.until(ExpectedConditions.titleContains("Dashboard"))) {
			
			test.log(LogStatus.INFO, "User is redirected to dashboard page");
		}
		else {
			test.log(LogStatus.FAIL, "User is not redirected to dashboard page");
		}
		
	}

	public void isAdvSearchLinkWorking() throws InterruptedException {
		test.log(LogStatus.INFO, "Clicking on advanced Search Link");
//			waitForVisibility(driver.findElement(ConstantsOR.advSearchLink), driver);
//			Thread.sleep(3000);
		waitForInvisibility(driver.findElement(ConstantsOR.LOADER), driver);
		driver.findElement(ConstantsOR.advSearchLink).click();
//			JavascriptExecutor executor=(JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", ConstantsOR.advSearchLink);
		waitForVisibility(driver.findElement(ConstantsOR.ADV_SEARCH_HEADER), driver);
		String header = driver.findElement(ConstantsOR.ADV_SEARCH_HEADER).getText();
		if (header.equals("Advanced Search")) {
			test.log(LogStatus.PASS, header + " Page opened successfully ");
		} else {
			test.log(LogStatus.FAIL, header + " Page not opened");
		}
	}

	public void clickOnSettingIcon() {
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(90));
//			//wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SETTING_ICON));
//			Actions act=new Actions(driver);
//			wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SETTING_ICON));
//			act.moveToElement(driver.findElement(ConstantsOR.SETTING_ICON)).perform();

		try {
			// WebDriverWait wait=new WebDriverWait(driver,120);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SETTING_ICON));
			driver.findElement(ConstantsOR.SETTING_ICON).click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(ConstantsOR.SETTING_ICON));
		}

	}

	public void clickOnUploaderType() {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until((ExpectedConditions.elementToBeClickable(ConstantsOR.NNJU_V2_OPTION)));
		driver.findElement(ConstantsOR.NNJU_V2_OPTION).click();
	}

	public void clickOnAdminAreaLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.SETTING_ICON));

		try {

			driver.findElement(settingIcon).click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(settingIcon));
		}

		wait.until(ExpectedConditions.elementToBeClickable(adminAreaLink));
		driver.findElement(adminAreaLink).click();
		// return new AdminOptionsPage(driver,test);
		String expTitle = "SMART Submit - Admin Options";
		String actTitle = driver.getTitle();
		if (actTitle.equals(expTitle)) {
			test.log(LogStatus.PASS, "Admin Options page opened properly");
		} else {
			test.log(LogStatus.FAIL, "Admin Options page not working, please check");
		}
	}

	public void verifyCogwheelOptionsAsPerSmartPortalAccSet(String setValue) {
		try {
			List<WebElement> cogoptions = driver
					.findElements(By.xpath("//header[@id='LayoutHeader']/div[2]/ul/li[9]/ul/li/a"));
			List<String> optionsList = new ArrayList<>();
			// System.out.println(cogoptions.size());
			{
				for (int i = 0; i < cogoptions.size(); i++) {
					String text = cogoptions.get(i).getText();
					// System.out.println(text);
					optionsList.add(text);
				}
				if (setValue.equals("On")) {
					if (optionsList.contains("SMART Portal")) {
						// System.out.println("pass");
						test.log(LogStatus.PASS,
								"SMART Portal button is present, as SMART Portal access setting is On for logged in user");
						takeScreenShot();
					} else {
						// System.out.println("Fail");
						test.log(LogStatus.FAIL,
								"User is not able to access SMART Portal button, as SMART Portal access setting is On for logged in user");
						takeScreenShot();
					}
				}

				else if (setValue.equals("Off")) {

					if (optionsList.contains("SMART Portal")) {

						test.log(LogStatus.FAIL,
								"User is able to access SMART Portal button, as SMART Portal access setting is Off for logged in user");
						takeScreenShot();
					} else {
						takeScreenShot();
						// test.log(LogStatus.PASS, "SMART Portal button is not present, as SMART Portal
						// access setting is Off for logged in user");
						driver.navigate().to("https://t.mddximage.com/Portal/PortalInfo");
						Thread.sleep(5000);
						if (driver.getTitle().contains("Dashboard")) {
							takeScreenShot();
							test.log(LogStatus.PASS,
									"SMART Portal button is not present, as SMART Portal access setting is Off for logged in user");
							// takeScreenShot();
						} else {
							test.log(LogStatus.FAIL, "User is able to access SMART Portal when setting is Off");
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySmartPortalButton() {
		verifyChildWindow("//a[@class='headerLinkSmartPortal']", "SMART Portal", "val.smart.bioclinica.com/sp/");

	}
	
	public void verifyQualificationTraining(String username,String newPwd) {
		WebDriverWait wait=new WebDriverWait(driver,120);
		
		try {
		driver.findElement(afterRegloginButton).click();
		Thread.sleep(3000);
	
//		driver.findElement(userNameTextbox).sendKeys(username);
//		driver.findElement(passwordTextbox).sendKeys(newPwd);
//		driver.findElement(signInButton).click();
//		Thread.sleep(3000);
		if(driver.findElement(qualStartButton).isEnabled()) {
			test.log(LogStatus.INFO, "User qualification training started");
			takeScreenShot();
			
			driver.findElement(qualStartButton).click();
			Thread.sleep(3000);
		//takeScreenShot();
			driver.findElement(qualVideoPlayButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(qualNextButton));
			takeScreenShot();
			driver.findElement(qualNextButton).click();
			driver.findElement(pinCodeNum1).click();
			driver.findElement(pinCodeNum1).sendKeys("0");
			driver.findElement(pinCodeNum2).sendKeys("4");
			driver.findElement(pinCodeNum3).sendKeys("2");
			driver.findElement(pinCodeNum4).sendKeys("4");
			//takeScreenShot();
			
			driver.findElement(pinCodeSubmitButton).click();
			driver.switchTo().frame(0);
			driver.findElement(esignUsername).sendKeys(username);
			driver.findElement(esignPassword).sendKeys(newPwd);
			driver.findElement(esignSubmitButton).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.elementToBeClickable(proceedNextButton)).click();
			//driver.findElement(proceedNextButton).click();
			Thread.sleep(3000);
			takeScreenShot();
			driver.findElement(selectFileButton).click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("D:\\Automation Project\\Latest Clario\\autoit\\Fileupload.exe");
			Thread.sleep(5000);
			driver.findElement(fileSubmitButton).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(fileUploadProgress));
			String uploadComplete=driver.findElement(fileUploadCompletePopupText).getText();
			System.out.println(uploadComplete);
			if(uploadComplete.contains("omplete")) {
				test.log(LogStatus.INFO, "Qualification completed");
				takeScreenShot();
				driver.findElement(okButton).click();
				Thread.sleep(5000);
				//getDashboardPageTitle();
				
				//int logoutbutton=driver.findElements(signoutbutton).size();
				
			//if(logoutbutton>0)
				wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessMesg));
				String loginmsg=driver.findElement(loginSuccessMesg).getText();
				if(loginmsg.contains("successfully "))
				{
				//wait.until(ExpectedConditions.elementToBeClickable(signoutbutton));
				test.log(LogStatus.PASS, "Clicking on Ok button user is redirected to Dashboard page");
				takeScreenShot();
			}
			else {
				test.log(LogStatus.FAIL, "User is not redirected to Dashboard page");
			}
			}
			else {
				test.log(LogStatus.FAIL, "Qualification fourth step not completed");
			}
			
		}else {
			test.log(LogStatus.FAIL, "User is not redirected to qualification page");
		}
		
		}catch(Exception e) {
		e.printStackTrace();
	}

}
}
