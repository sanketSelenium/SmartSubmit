package com.clario.ss.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.clario.ss.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SDuserPortalPage extends BasePage {

	public SDuserPortalPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public void sdFormsvalidation(String sd9992trial, String sd1739trial) throws InterruptedException {
		//String mainWindow=driver.getWindowHandle();
		test.log(LogStatus.INFO, "Logged in with user associated with Study Direct trial");
	     takeScreenShot();
			if(sd9992trial.contains("9992")) 
		
		{
			if(driver.findElement(By.xpath("//a[text()='"+sd9992trial+"']")).isDisplayed()) 
			{
				driver.findElement(By.xpath("//a[text()='"+sd9992trial+"']")).click();
				test.log(LogStatus.INFO, "Clicked on "+sd9992trial+" trial");
				takeScreenShot();
			List<WebElement> forms9992=driver.findElements(By.xpath("//ul[@class='ulClass']/li/a"));
			if(forms9992.size()>=3) {
				
				driver.findElement(By.xpath("(//tr//td[@class=' thHeader']/ul/li/a)[1]")).click();
				test.log(LogStatus.INFO, "Clicked on Forms - DEMO-9992  (Forms) link");
				List<WebElement> demoforms992=driver.findElements(By.xpath("//tbody[@id='sdURLBody']/tr/td/a"));
				if(demoforms992.size()>=2) {
					test.log(LogStatus.PASS, "Forms - DEMO-9992  (Forms) link is working fine");
					//driver.findElement(By.xpath("//a[text()='Forms - DEMO-9992 - 101']")).click();
					verifyChildWindow("//a[text()='Forms - DEMO-9992 - 101']","Forms - DEMO-9992 - 101","site=101");
					verifyChildWindow("//a[text()='Forms - DEMO-9992 - 102']","Forms - DEMO-9992 - 102","site=102");
				}
				else {
					test.log(LogStatus.FAIL, "Forms - DEMO-9992  (Forms) link us not working");
				}
				driver.findElement(By.xpath("(//tr//td[@class=' thHeader']/ul/li/a)[2]")).click();
				test.log(LogStatus.INFO, "Clicked on Image Submission - DEMO-9992  (ImageSubmission) link");
				List<WebElement> imagesubmissionforms=driver.findElements(By.xpath("//tbody[@id='sdURLBody']//tr/td/a"));
				if(imagesubmissionforms.size()>=2) {
					test.log(LogStatus.PASS, "Image Submission - DEMO-9992  (ImageSubmission) link is working fine");
					verifyChildWindow("//a[text()='Image Submission - DEMO-9992 - 101']", "Image Submission - DEMO-9992 - 101", "site=101");
					verifyChildWindow("//a[text()='Image Submission - DEMO-9992 - 102']", "Image Submission - DEMO-9992 - 102", "site=102");
					
				}else {
					test.log(LogStatus.FAIL, "Image Submission - DEMO-9992  (ImageSubmission) link is not working");
				}
				driver.findElement(By.xpath("(//tr//td[@class=' thHeader']/ul/li/a)[3]")).click();
				test.log(LogStatus.INFO, "Clicked on Site Portal - DEMO-9992  (SitePortal) link");
				List<WebElement> siteportalforms=driver.findElements(By.xpath("//tbody[@id='sdURLBody']/tr/td/a"));
				if(siteportalforms.size()>=2) {
					test.log(LogStatus.PASS, "Site Portal - DEMO-9992  (SitePortal) link is working fine");
					verifyChildWindow("//a[text()='Site Portal - DEMO-9992 - 101']", "Site Portal - DEMO-9992 - 101", "site=101");
					verifyChildWindow("//a[text()='Site Portal - DEMO-9992 - 102']", "Site Portal - DEMO-9992 - 102", "site=102");
				}else {
					test.log(LogStatus.FAIL, "Site Portal - DEMO-9992  (SitePortal) link is not working");
				}
			}else {
				test.log(LogStatus.FAIL, "Clicking on trial "+sd9992trial+" expected page is not opened");
			}
			
			}else {
				System.out.println("user is not associated with mentioned trial");
			}
		
		}else {
			System.out.println("please check trial is of type 9992forms");
		}
		
		driver.findElement(By.xpath("//div[@id='backButton']")).click();
		Thread.sleep(3000);

		if(sd1739trial.contains("1739")) 
	
	{
		if(driver.findElement(By.xpath("//a[text()='"+sd1739trial+"']")).isDisplayed()) 
		{
			driver.findElement(By.xpath("//a[text()='"+sd1739trial+"']")).click();
			test.log(LogStatus.INFO, "Clicked on "+sd1739trial+"trial");
			takeScreenShot();
			List<WebElement> forms1739=driver.findElements(By.xpath("//ul[@class='ulClass']/li/a"));

			if(forms1739.size()>=2) {
				
				verifyChildWindow("(//tr/td/ul[@class='ulClass']/li/a)[1]", "Images - FABR-1739 (Images)", "val.smart.bioclinica.com");
				doActionInChildWindow("(//tr/td/ul[@class='ulClass']/li/a)[2]", "Image Search", "protocolID=1739");
				driver.findElement(By.xpath("//span[@id='select2-ddlSiteId-container']")).click();
				driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[text()='0102']")).click();
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
				test.log(LogStatus.FAIL, "Clicking on trial "+sd1739trial+" expected page is not opened");
			}
}else {
	System.out.println("user is not associated with mentioned trial");
}
	}		else {
		System.out.println("please check trial is of type 9992forms");
		}
}
}