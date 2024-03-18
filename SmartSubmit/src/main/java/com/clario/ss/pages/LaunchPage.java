package com.clario.ss.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsConfig;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{
	
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);
				
		
	}
	
		public LoginPage gotoLoginPage(){
			LoginPage loginPage = new LoginPage(driver,test);
			try{
			
				// log
				test.log(LogStatus.INFO, "Opening the url - "+ConstantsConfig.getEnvDetails().get("url"));
				System.out.println(ConstantsConfig.getEnvDetails().get("url"));
				driver.get(ConstantsConfig.getEnvDetails().get("url"));
				test.log(LogStatus.PASS, "URL Opened - "+ConstantsConfig.getEnvDetails().get("url"));
				
				PageFactory.initElements(driver, loginPage);
			}catch(Exception e){
				e.printStackTrace();	
			}
		return loginPage;
		
	}
		
		

	

}
