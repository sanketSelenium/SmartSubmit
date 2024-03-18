package com.clario.ss.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BPuserPortalPage extends BasePage {
	
	public BPuserPortalPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void BPuserwithSmartPortalAccess(String bptrialname) throws InterruptedException 
	{
		
		String mainWindow=driver.getWindowHandle();
		System.out.println(mainWindow);
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SETTING_ICON));
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(ConstantsOR.SETTING_ICON));
		    
				wait.until((ExpectedConditions.elementToBeClickable(ConstantsOR.SMART_PORTAL_OPTION)));
				//takeScreenShot();
				driver.findElement(ConstantsOR.SMART_PORTAL_OPTION).click();
				Thread.sleep(5000);
				
				Set<String> handles=driver.getWindowHandles();
				
				Iterator<String>it=handles.iterator();
				String mainWindow1=it.next();
				System.out.println(mainWindow1);
				String mainChildWindow1=it.next();
				System.out.println("mainChildWindow1"+mainChildWindow1);
				//driver.close();
				driver.switchTo().window(mainChildWindow1);
				System.out.println("mainChildWindow1"+mainChildWindow1);
				Thread.sleep(5000);
				if((driver.getCurrentUrl()).contains("PortalInfo")) {
					test.log(LogStatus.PASS, "SMART Portal link is working fine");
					
				}
				else {
					test.log(LogStatus.FAIL, "SMART Portal link is not working");
				}
			
			if(driver.findElement(By.xpath("(//a[text()='"+bptrialname+"']/parent::td)[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//a[text()='"+bptrialname+"']/parent::td)[1]")).click();
//			Thread.sleep(5000);
			verifyTwoChildWindow("Websend Portal", "val.mywebsend.com");
			driver.close();
			driver.switchTo().window(mainChildWindow1);
			verifyTwoChildWindow("Image Search", "protocolID=SPBP01");
			driver.findElement(By.xpath("//span[@id='select2-ddlSiteId-container']")).click();
			driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='VF101']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='btnSearchCIP']")).click();
			Thread.sleep(8000);
//			try
//			{
			
			{
				Thread.sleep(5000);
			 driver.findElement(By.xpath("(//tbody/tr/td/div/a[text()='Timepoint'])[1]")).click();
			 Thread.sleep(5000);
               Set<String> handles1=driver.getWindowHandles();
				
				Iterator<String>it1=handles1.iterator();
				String OpenWindow1=it1.next();
				System.out.println("OpenWindow1"+OpenWindow1);
				String OpenWindow2=it1.next();
				System.out.println("OpenWindow2"+OpenWindow2);
				String OpenWindow3=it1.next();
				System.out.println("OpenWindow3"+OpenWindow3);
				String OpenWindow4=it1.next();
				System.out.println("OpenWindow4"+OpenWindow3);
				//driver.close();
				driver.switchTo().window(OpenWindow4);
				Thread.sleep(5000);
				if((driver.getCurrentUrl()).contains("test.view.bioclinica.com")) 
				{
					test.log(LogStatus.PASS, "Timepoint link is working fine");
					test.log(LogStatus.INFO, driver.getCurrentUrl());
					driver.close();
					
				}
				else {
					test.log(LogStatus.FAIL, "Timepoint link is not working");
				}
				driver.switchTo().window(OpenWindow3);
				driver.findElement(By.xpath("(//tbody/tr/td/div/a[text()='Subject'])[1]")).click();
				Thread.sleep(5000);
               Set<String> handles2=driver.getWindowHandles();
				
				Iterator<String>it2=handles2.iterator();
				String OpenWindow11=it2.next();
				System.out.println("OpenWindow11"+OpenWindow11);
				String OpenWindow12=it2.next();
				System.out.println(OpenWindow12);
				//driver.close();
				String OpenWindow13=it2.next();
				System.out.println("OpenWindow13"+OpenWindow13);
				String OpenWindow14=it2.next();
				System.out.println("OpenWindow14"+OpenWindow14);
				driver.switchTo().window(OpenWindow14);
				Thread.sleep(5000);
				if((driver.getCurrentUrl()).contains("test.view.bioclinica.com"))
				{
					test.log(LogStatus.PASS, "Subject link is working fine");
					test.log(LogStatus.INFO, driver.getCurrentUrl());
					driver.close();
					driver.switchTo().window(OpenWindow13);
					driver.close();
				}
				
				else {
					test.log(LogStatus.FAIL, "Subject link is not working");
				}
			}
			else {
				test.log(LogStatus.INFO, "No records Found");
			}
//			}catch(Exception e) {
//				test.log(LogStatus.FAIL, "Please check Image Search link flow not working");
//			}
			
			driver.switchTo().window(mainChildWindow1);
			driver.close();
			driver.switchTo().window(mainWindow1);
			driver.findElement(By.xpath("//a[@class='signOutButton']")).click();

			
		}
		else {
			test.log(LogStatus.FAIL, "Logged in user is not associated with mentioned trial");
		}
				
	}
	
	public void BpUserwithoutSmartPortalAccess(String bptrialname) throws InterruptedException {
		test.log(LogStatus.INFO, "Logged in with user associated with Biopac trial");
		
		if(driver.findElement(By.xpath("(//a[text()='"+bptrialname+"']/parent::td)[1]")).isDisplayed()) 
		{
			takeScreenShot();
			driver.findElement(By.xpath("(//a[text()='"+bptrialname+"']/parent::td)[1]")).click();
			test.log(LogStatus.INFO, "Clicked on "+bptrialname+" trial");
			takeScreenShot();
			verifyChildWindow("//tbody/tr/td/a[text()='Websend Portal']","Websend Portal", "val.mywebsend.com");
			doActionInChildWindow("//tbody/tr/td/a[text()='Image Search']","Image Search", "protocolID=SPBP01");
			driver.findElement(By.xpath("//span[@id='select2-ddlSiteId-container']")).click();
			driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='VF101']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='btnSearchCIP']")).click();
			Thread.sleep(8000);
			if(driver.findElements(By.xpath("(//tbody/tr/td/div/a[text()='Timepoint'])[1]")).size()>0) 
			{
				//takeScreenShot();
				Thread.sleep(5000);
			 driver.findElement(By.xpath("(//tbody/tr/td/div/a[text()='Timepoint'])[1]")).click();
			 test.log(LogStatus.INFO, "Clicked on Timepoint link");
			 Thread.sleep(5000);
               Set<String> handles1=driver.getWindowHandles();
               Iterator<String>it1=handles1.iterator();
               String mailWindow=it1.next();
               System.out.println("mailWindow"+mailWindow);
               String imageserachwindow=it1.next();
               System.out.println("imageserachwindow"+imageserachwindow);
               String timepointwindow=it1.next();
               System.out.println("timepointwindow"+timepointwindow);
               driver.switchTo().window(timepointwindow);
               Thread.sleep(5000);
               if((driver.getCurrentUrl()).contains("test.view.bioclinica.com")) 
				{
					test.log(LogStatus.PASS, "Timepoint link is working fine");
					test.log(LogStatus.INFO, driver.getCurrentUrl());
					driver.close();
					
				}
				else {
					test.log(LogStatus.FAIL, "Timepoint link is not working");
				}
               driver.switchTo().window(imageserachwindow);
               driver.findElement(By.xpath("(//tbody/tr/td/div/a[text()='Subject'])[1]")).click();
               test.log(LogStatus.INFO, "Clicked on Subject link");
				Thread.sleep(5000);
				Set<String> handles2=driver.getWindowHandles();
	               Iterator<String>it2=handles2.iterator();
	               String mailWindow1=it2.next();
	               System.out.println("mailWindow1"+mailWindow1);
	               String imageserachwindow1=it2.next();
	               System.out.println("imageserachwindow1"+imageserachwindow1);
	               String subjectwindow=it2.next();
	               System.out.println("subjectwindow"+subjectwindow);
	               driver.switchTo().window(subjectwindow);
	               Thread.sleep(5000);
	               if((driver.getCurrentUrl()).contains("test.view.bioclinica.com")) 
					{
						test.log(LogStatus.PASS, "Subject link is working fine");
						test.log(LogStatus.INFO, driver.getCurrentUrl());
						driver.close();
						
					}
					else {
						test.log(LogStatus.FAIL, "Subject link is not working");
					}
	               driver.switchTo().window(imageserachwindow1);
	               
			driver.close();
			}else {
				test.log(LogStatus.INFO, "No records Found");
				takeScreenShot();
			}
	}else {
		test.log(LogStatus.FAIL, "Logged in user is not associated with mentioned trial");
	}
	}
}
