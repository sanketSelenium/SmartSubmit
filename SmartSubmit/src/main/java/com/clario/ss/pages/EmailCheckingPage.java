package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmailCheckingPage extends BasePage 
{

	public EmailCheckingPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	
	By enterEmailTextbox=By.xpath("//div/input[@id='mat-input-0']");
	By checkInboxButton=By.xpath("(//div/button/span[@class=\"mat-button-wrapper\"])[1]");
	By invitationEmailInInbox=By.xpath("(//div/ul/li)[2]/a/label[text()=\"Invitation for SMART Submit\"]");
	By invitationEmailBody=By.xpath("(//section[@class=\"container-fluid\"])[2]//div//div[@class=\"mail-font\"]");
	By registrationLink=By.partialLinkText("https://t.mddximage.com/Register");
	
	WebDriverWait wait = new WebDriverWait(driver, 90);
	public void emailVerification(String username) {
		try {
		
		driver.navigate().to("https://3dimail.3didemo.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmailTextbox));
		driver.findElement(enterEmailTextbox).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(checkInboxButton).click();
		Thread.sleep(8000);
		driver.findElement(invitationEmailInInbox).click();
		Thread.sleep(8000);
		//scrollPageDown();
		//Thread.sleep(8000);
		driver.findElement(invitationEmailBody).click();
		scrollPageDown();
		takeScreenShot();
		String regLink=driver.findElement(registrationLink).getText();
		System.out.println(regLink);
		driver.findElement(registrationLink).click();
		Thread.sleep(8000);
		
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals("Sign In")) {
			test.log(LogStatus.PASS, "Registartion link is working");
		}
		else {
			test.log(LogStatus.FAIL, "Registration link is not working");
		}
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}