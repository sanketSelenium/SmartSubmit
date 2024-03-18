package com.clario.ss.pages;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TapUserPortalPage extends BasePage {
	
	public TapUserPortalPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}
	
	public void tapUser(String taptrialname) {
	
		test.log(LogStatus.INFO, "Logged in with user associated with Tap trial");
		takeScreenShot();
		
//		if(taptrialname.equals(taptrial)) {
//			test.log(LogStatus.PASS, "Tapaccess user logged in successfully");
//		
		//driver.findElement(By.xpath("//a[text()='Sandbox New']")).click();
		try{
//			String taptrial=driver.findElement(By.xpath("//a[text()='"+taptrialname+"']")).getText();
//			System.out.println(taptrial);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			if(driver.findElements(By.xpath("//a[text()='"+taptrialname+"']")).size()!=0)
			{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='"+taptrialname+"']")));
			driver.findElement(By.xpath("//a[text()='"+taptrialname+"']")).click();
			test.log(LogStatus.INFO, "Clicked on "+taptrialname+" trial");
			//test.log(LogStatus.INFO, "Clicked on tap trial");
			Thread.sleep(5000);
			String Parent_Window = driver.getWindowHandle();    
		      // Switching from parent window to child window   
//		     for (String Child_Window : driver.getWindowHandles())  
//		     {  
//		    	 driver.switchTo().window(Child_Window);
//		    	 Thread.sleep(2000);
//		    			    	
//		     }
			Set<String> handles=driver.getWindowHandles();
			
			Iterator<String>it=handles.iterator();
			String parentWindow1=it.next();
			System.out.println(parentWindow1);
			String childWindow1=it.next();
			System.out.println(childWindow1);
			
			driver.switchTo().window(childWindow1);
			Thread.sleep(3000);
//		     String currentURL=driver.getCurrentUrl();
//	    	 System.out.println(currentURL);
			String title=driver.getTitle();
	    	 if(title.contains("Sign In"))
	    	 {
	    		 test.log(LogStatus.PASS, "Tap trial link is working fine");
	    		 test.log(LogStatus.INFO, driver.getCurrentUrl());
	    		 driver.close();
	    	 }	
	    	 else
	    	 {
	    		 test.log(LogStatus.FAIL, "Tap trial link is not working");
	    		 driver.close();
	    	 }	
	    	 Thread.sleep(1000);
		     driver.switchTo().window(Parent_Window);
		     Thread.sleep(3000);
			}
		else
		{
			 test.log(LogStatus.FAIL, "Please check trial type is tap and entered trial name is proper");
			 takeScreenShot();
		}
		}
				catch (Exception e)
			{
				e.printStackTrace();   
				//reportFailure("Element not found for verifyChildWindow");
				test.log(LogStatus.FAIL, "Clicking on tap trial new tab not opened");
			}
		
		
	}

}
