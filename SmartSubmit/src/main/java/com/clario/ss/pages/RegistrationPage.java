package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RegistrationPage extends BasePage {
	
	public RegistrationPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	By userNameTextbox = By.id("userNameInput");
	By passwordTextbox = By.id("passwordInput");
	By signInButton = By.xpath("//span[@id=\"submitButton\"]");
	By signInError = By.xpath("//div[@id='error']/label");
	By oldPasswordTextbox=By.id("oldPasswordInput");
	By newPasswordTextbox=By.id("newPasswordInput");
	By confirmPasswordTextbox=By.id("confirmNewPasswordInput");
	By updatePwdSubmitButton=By.id("submitButton");
	By usernameLabel=By.xpath("//div/label[text()=\"Username:\"]");
	By registraionSubmitButton=By.xpath("//div/button[@id='btnsubmit']");
	By registrationSucMsg=By.xpath("//div[@id='SuccessRegistration']/header/strong");
	
	By afterRegloginButton=By.xpath("//div/button[@id='btnYes']");

	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	
	
	public void verifyRegisterPageTitle() {
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		String expTitle="SMART Submit   - Registration";
		if(actTitle.equals(expTitle)) {
			
			test.log(LogStatus.PASS, "Registration page opened properly");
		}
		else {
			test.log(LogStatus.FAIL, "Registration page not opened properly");
		}
	}
	
	
	public void verifyUserRegistration(String username,String regPwd,String newPwd) {
		try {
		driver.findElement(userNameTextbox).sendKeys(username);
		driver.findElement(passwordTextbox).sendKeys(newPwd);
		driver.findElement(signInButton).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		if((driver.getTitle()).equals("SMART Submit - Registration"))
			
			
		{
			//System.out.println(driver.getTitle());
			wait.until(ExpectedConditions.elementToBeClickable(registraionSubmitButton));
			takeScreenShot();
			driver.findElement(registraionSubmitButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(registrationSucMsg));
			String regSuccessMessage=driver.findElement(registrationSucMsg).getText();
			 System.out.println(regSuccessMessage);
			 
			 if(regSuccessMessage.contains("Successful")) {
					test.log(LogStatus.PASS, "User registration is successful");
					takeScreenShot();
				}else {
					test.log(LogStatus.FAIL, "User registration failed");
				}
		}
		else {
		
			driver.findElement(passwordTextbox) .sendKeys(regPwd);
			driver.findElement(signInButton).click();
			Thread.sleep(3000);
			
			takeScreenShot();
			driver.findElement(oldPasswordTextbox).sendKeys(regPwd);
			driver.findElement(newPasswordTextbox).sendKeys(newPwd);
			driver.findElement(confirmPasswordTextbox).sendKeys(newPwd);
			driver.findElement(updatePwdSubmitButton).click();
			Thread.sleep(3000);
			driver.findElement(userNameTextbox).clear();
			driver.findElement(userNameTextbox).sendKeys(username);
			driver.findElement(passwordTextbox).clear();
			driver.findElement(passwordTextbox).sendKeys(newPwd);
			driver.findElement(signInButton).click();
			//Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(registraionSubmitButton));
			driver.findElement(registraionSubmitButton).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(registrationSucMsg));
			String regSuccessMessage=driver.findElement(registrationSucMsg).getText();
			 System.out.println(regSuccessMessage);
			 
			 if(regSuccessMessage.contains("Successful")) {
					test.log(LogStatus.PASS, "User registration is successful");
					takeScreenShot();
					//driver.findElement(afterRegloginButton).click();
					//Thread.sleep(3000);
				}else {
					test.log(LogStatus.FAIL, "User registration failed");
				}
			
		}
		
	}catch(Exception e) {
			e.printStackTrace();
		}
			

}
}