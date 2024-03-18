package com.clario.ss.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserManagement extends BasePage{

	public UserManagement(WebDriver driver, ExtentTest test) {
		super(driver, test);
		// TODO Auto-generated constructor stub
	}
public void admin_icon() {
	test.log(LogStatus.INFO,"Click on Admin panel");
	
}

}








