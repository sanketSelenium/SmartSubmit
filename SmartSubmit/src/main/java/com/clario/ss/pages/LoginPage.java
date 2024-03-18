package com.clario.ss.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);

	}
//	public LoginPage(WebDriver driver) {
//		super(driver);
//	}
	
	By userName = By.id("userNameInput");
	By password = By.id("passwordInput");
	By signInButton = By.xpath("//span[@id=\"submitButton\"]");
	By signInError = By.xpath("//div[@id='error']/label");
	
		public void doLogin(String usName,String pWord){
		//	try{	
				
			//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				//waitForVisibility(email, driver);
			driver.findElement(userName).clear();
				driver.findElement(userName).sendKeys(usName);
				//Thread.sleep(1000);
				driver.findElement(password).clear();
					driver.findElement(password).sendKeys(pWord);
				//	test.log(LogStatus.INFO, "Logging in -"+usName+"/"+"********");
					
					driver.findElement(signInButton).click();
				
				
//				catch (Exception e)
//				{
//					e.printStackTrace();
//					reportFailure("Not able to Login");
//				}
//					
//				}
		
		WebDriverWait wait=new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ConstantsOR.LOADER));
		int logoutbutton=driver.findElements(ConstantsOR.SIGNOUT_BUTTON).size();
		//System.out.println(loginsuctext);
	if(logoutbutton>0)
		{
		test.log(LogStatus.PASS, "User Logged in Successfully");
//			//return true;
		}
	else {
		Actions act=new Actions(driver);
	
		act.sendKeys(Keys.PAGE_DOWN).perform();
	
			String loginErrortext=driver.findElement(signInError).getText();
			System.out.println(loginErrortext);
			test.log(LogStatus.FAIL,"Login failed: "+loginErrortext);
		takeScreenShot();
//			//return false;
//			
//		}
		

}
			
		
}	
		
		public void verifyLoginPageTitle() {
			
			String actTitle=driver.getTitle();
			System.out.println(actTitle);
			String expTitle="Sign In";
			
			if(actTitle.equals(expTitle)) {
				test.log(LogStatus.PASS, "Login page opened properly");
			}
			else {
				test.log(LogStatus.FAIL, "Login page not opened, please check");
			}
		}
	
}	
