package com.clario.ss.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.clario.ss.base.BasePage;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PortalPage extends BasePage {

	public PortalPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
	}

	public String getPortalPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("One Portal"));
		return driver.getTitle();
	}

	
	public void portalUserWithBothBPandSD(String bptrial, String sdtrial) throws InterruptedException {
		
		test.log(LogStatus.INFO, "Logged in with user associated with biopac and study direct trials");
		takeScreenShot();
		driver.findElement(By.xpath("(//a[text()='"+bptrial+"']/parent::td)[1]")).click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Clicked on: " +bptrial );
		
		String bptrialParentWindow=driver.getWindowHandle();
		System.out.println(bptrialParentWindow);
		
		boolean websendPortalLink=driver.findElement(By.xpath("(//a[text()='Websend Portal'])[2]")).isDisplayed();
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if(websendPortalLink) {
			test.log(LogStatus.PASS, "Clicking on biopac type trial page opened properly");
			takeScreenShot();
		}else {
			
			test.log(LogStatus.FAIL, "Clicking on biopac type trial page not opened properly");
		}
	     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[text()='Websend Portal'])[2]")));
	     Thread.sleep(3000);
		test.log(LogStatus.INFO, "Clicked on WebSend Portal link");
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String>it=handles.iterator();
		String parentWindow1=it.next();
		System.out.println(parentWindow1);
		String childWindow1=it.next();
		System.out.println(childWindow1);
		
		driver.switchTo().window(childWindow1);
		Thread.sleep(3000);
		String websendurl=driver.getCurrentUrl();
		if(driver.getCurrentUrl().equals(websendurl)) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "WebSend Portal link is working fine");
		driver.close();
		
	}else {
			System.out.println("websendPortal link is not working");
			test.log(LogStatus.FAIL, "Websend Portal link is not working");
		
		
		
	} driver.switchTo().window(bptrialParentWindow);
		
		 executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//a[text()='Image Search'])[2]")));
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Clicked on Image Search link");
         Set<String> handles1=driver.getWindowHandles();
		
		Iterator<String>it1=handles1.iterator();
		
		String parentWindow2=it1.next();
		
		System.out.println(parentWindow2);
		String childWindow2=it1.next();
		driver.switchTo().window(childWindow2);
		Thread.sleep(3000);
		String imagesearchurl=driver.getCurrentUrl();
		
		if(imagesearchurl.equals(driver.getCurrentUrl())) {
			test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "ImageSearch link is working fine");
		driver.close();
		}else {
			System.out.println("imageSearchLink is not working");
			test.log(LogStatus.FAIL, "imageSearch Link is not working");
		}
		driver.switchTo().window(bptrialParentWindow);
	   executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='BACK']")));

		driver.findElement(By.xpath("(//a[text()='" + sdtrial + "']/parent::td)[1]")).click();
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Clicked on: "+sdtrial);
		
		List<WebElement> sdlinks=driver.findElements(By.xpath("//tr/td[@class=' thHeader']/ul/li/a"));
		if(sdlinks.size()==4) {
			
		  String sdTrilMainWindow=driver.getWindowHandle();
			test.log(LogStatus.INFO, "Clicking on stdydirect trial page opened properly");
			takeScreenShot();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[1]")));
		driver.findElement(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[1]")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 (Forms) link");
		List<WebElement> formsUSDEM999Links=driver.findElements(By.xpath("//tbody[@id='sdURLBody']/tr/td/a"));
		System.out.println("formsUSDEM999Links: "+formsUSDEM999Links.size());
		if(formsUSDEM999Links.size()>=7) {
		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 001']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 001 link");
		Thread.sleep(3000);

		Set<String> handles2 = driver.getWindowHandles();

		Iterator<String> it3 = handles2.iterator();
		String parentWindow21 = it3.next();
		System.out.println(parentWindow21);
		String childWindow21 = it3.next();
		driver.switchTo().window(childWindow21);
		System.out.println(childWindow21);

		Thread.sleep(5000);
		String FormsUSDEM999001url=driver.getCurrentUrl();
		//System.out.println(driver.getCurrentUrl());
		if(FormsUSDEM999001url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Forms - US-DEM-999 - 001 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL , "Forms - US-DEM-999 - 001 link is not working");
		}
		driver.switchTo().window(parentWindow21);
		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 002']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 002 link");

		Thread.sleep(1000);

		Set<String> handles3 = driver.getWindowHandles();

		Iterator<String> it4 = handles3.iterator();
		String parentWindow3 = it4.next();
		System.out.println(parentWindow3);
		String childWindow31 = it4.next();
		driver.switchTo().window(childWindow31);
		System.out.println(childWindow31);
		
		String FormsUSDEM999002url=driver.getCurrentUrl();
		if(FormsUSDEM999002url.equals(driver.getCurrentUrl())) {
			test.log(LogStatus.INFO, driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Forms - US-DEM-999 - 002 link is working fine");
			driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 002 link is not working");
		}
		driver.switchTo().window(parentWindow21);
		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 003']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 003 link");

		Thread.sleep(1000);

		Set<String> handles4 = driver.getWindowHandles();

		Iterator<String> it5 = handles4.iterator();
		String parentWindow4 = it5.next();
		System.out.println(parentWindow4);
		String childWindow4 = it5.next();
		driver.switchTo().window(childWindow4);
		System.out.println(childWindow4);
		
		String FormsUSDEM999003url=driver.getCurrentUrl();
		if(FormsUSDEM999003url.equals(driver.getCurrentUrl())) {
			test.log(LogStatus.INFO, driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Forms - US-DEM-999 - 003 link is working fine");
			driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 003 link is not working");
		}
		driver.switchTo().window(parentWindow21);
		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 123']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 123 link");

		Thread.sleep(1000);
		Set<String> handles5 = driver.getWindowHandles();

		Iterator<String> it6 = handles5.iterator();
		String parentWindow5 = it6.next();
		System.out.println(parentWindow5);
		String childWindow51 = it6.next();
		driver.switchTo().window(childWindow51);
		System.out.println(childWindow51);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String formsUSDEM999123url=driver.getCurrentUrl();
		if(formsUSDEM999123url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Forms - US-DEM-999 - 123 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 123 link is not working");
		}
		driver.switchTo().window(parentWindow21);
      driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 124']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 124 link");

      Thread.sleep(1000);
		Set<String> handles6 = driver.getWindowHandles();

		Iterator<String> it7 = handles6.iterator();
		String parentWindow6 = it7.next();
		System.out.println(parentWindow6);
		String childWindow61 = it7.next();
		driver.switchTo().window(childWindow61);
		System.out.println(childWindow61);

		Thread.sleep(3000);
		//System.out.println(driver.getCurrentUrl());
		String formsUSDEM999124url=driver.getCurrentUrl();
		if(formsUSDEM999124url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Forms - US-DEM-999 - 124 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 124 link is not working");
		}
		driver.switchTo().window(parentWindow21);

		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 887']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 887 link");

		Thread.sleep(1000);
		Set<String> handles7 = driver.getWindowHandles();

		Iterator<String> it8 = handles7.iterator();
		String parentWindow7 = it8.next();
		System.out.println(parentWindow7);
		String childWindow71 = it8.next();
		driver.switchTo().window(childWindow71);
		System.out.println(childWindow71);

		Thread.sleep(3000);
		//System.out.println(driver.getCurrentUrl());
		String formsUSDEM999887url=driver.getCurrentUrl();
		if(formsUSDEM999887url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Forms - US-DEM-999 - 887 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 887 link is not working");
		}
		driver.switchTo().window(parentWindow21);
		
		driver.findElement(By.xpath("//a[text()='Forms - US-DEM-999 - 895']")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 895 link");

		Thread.sleep(1000);
		Set<String> handles8 = driver.getWindowHandles();

		Iterator<String> it9 = handles8.iterator();
		String parentWindow8 = it9.next();
		System.out.println(parentWindow8);
		String childWindow81 = it9.next();
		driver.switchTo().window(childWindow81);
		System.out.println(childWindow81);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String formsUSDEM999895url=driver.getCurrentUrl();
		if(formsUSDEM999895url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Forms - US-DEM-999 - 895 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Forms - US-DEM-999 - 895 link is not working");
		}
		}else {
			test.log(LogStatus.FAIL, "Forms US-DEM-999 link is not working");
		}
		
		Thread.sleep(5000);
		driver.switchTo().window(sdTrilMainWindow);
		
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[2]")));
		test.log(LogStatus.INFO, "Clicked on Image Submission-US-DEM-999 (Image Submission) link");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[2]")).click();
		test.log(LogStatus.INFO, "Clicked on Forms - US-DEM-999 - 001");

		
		Thread.sleep(1000);
		List<WebElement> imagesubmissionLinks=driver.findElements(By.xpath("//tbody[@id='sdURLBody']/tr/td/a"));
		if(imagesubmissionLinks.size()>=2) {
			test.log(LogStatus.INFO, "Image Submission - US-DEM-999  (ImageSubmission) link is working fine");
		
		driver.findElement(By.xpath("//a[text()='Image Submission - US-DEM-999 - 001']")).click();
		test.log(LogStatus.INFO, "Clicked on Image Submission - US-DEM-999 - 001 link");
		Thread.sleep(5000);
		Set<String> handles9 = driver.getWindowHandles();

		Iterator<String> it10 = handles9.iterator();
		String parentWindow9 = it10.next();
		System.out.println(parentWindow9);
		String childWindow91 = it10.next();
		driver.switchTo().window(childWindow91);
		System.out.println(childWindow91);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String imageSubmissionUSDEM999001url=driver.getCurrentUrl();
		if(imageSubmissionUSDEM999001url.equals(driver.getCurrentUrl())) {
			test.log(LogStatus.INFO, driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Image Submission - US-DEM-999 - 001 link is working fine");
			driver.close();
		}else {
			test.log(LogStatus.FAIL, "Image Submission - US-DEM-999 - 001 link is not working");
		}
		
		driver.switchTo().window(sdTrilMainWindow);
		driver.findElement(By.xpath("//a[text()='Image Submission - US-DEM-999 - 002']")).click();
		test.log(LogStatus.INFO, "Clicked on Image Submission - US-DEM-999 - 002 link");
		Thread.sleep(5000);
		Set<String> handles10 = driver.getWindowHandles();

		Iterator<String> it11 = handles10.iterator();
		String parentWindow10 = it11.next();
		System.out.println(parentWindow10);
		String childWindow10 = it11.next();
		driver.switchTo().window(childWindow10);
		System.out.println(childWindow10);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String imageSubmissionUSDEM999002url=driver.getCurrentUrl();
		if(imageSubmissionUSDEM999002url.equals(driver.getCurrentUrl())) {
			test.log(LogStatus.INFO, driver.getCurrentUrl());
			test.log(LogStatus.PASS, "Image Submission - US-DEM-999 - 002 link is working fine");
			driver.close();
		}else {
			test.log(LogStatus.FAIL, "Image Submission - US-DEM-999 - 002 link is not working");
		}
		}else {
			test.log(LogStatus.FAIL, "Image Submission - US-DEM-999  (ImageSubmission) link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[3]")));
		driver.findElement(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[3]")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999 (SitePortal) link");
		
		List<WebElement> sitePortallinks=driver.findElements(By.xpath("//tbody[@id='sdURLBody']/tr/td/a"));
		if(sitePortallinks.size()>=7) {
			test.log(LogStatus.INFO, "Site Portal -US- DEM-999 link is working fine");
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 001']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-001 link");
		Thread.sleep(1000);

		Set<String> handles11 = driver.getWindowHandles();

		Iterator<String> it12 = handles11.iterator();
		String parentWindow11 = it12.next();
		System.out.println(parentWindow11);
		String childWindow11 = it12.next();
		driver.switchTo().window(childWindow11);
		System.out.println(childWindow11);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999001url=driver.getCurrentUrl();
		if(sitePortalUSDEM999001url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 001 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 001 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 002']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-002 link");
		Thread.sleep(1000);

		Set<String> handles12 = driver.getWindowHandles();

		Iterator<String> it13 = handles12.iterator();
		String parentWindow12 = it13.next();
		System.out.println(parentWindow12);
		String childWindow12 = it13.next();
		driver.switchTo().window(childWindow12);
		System.out.println(childWindow12);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999002url=driver.getCurrentUrl();
		if(sitePortalUSDEM999002url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 002 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 002 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 003']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-003 link");
		Thread.sleep(1000);

		Set<String> handles13 = driver.getWindowHandles();

		Iterator<String> it14 = handles13.iterator();
		String parentWindow13 = it14.next();
		System.out.println(parentWindow13);
		String childWindow13 = it14.next();
		driver.switchTo().window(childWindow13);
		System.out.println(childWindow13);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999003url=driver.getCurrentUrl();
		if(sitePortalUSDEM999003url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 003 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 003 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 123']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-123 link");
		Thread.sleep(1000);
		Set<String> handles14 = driver.getWindowHandles();

		Iterator<String> it15 = handles14.iterator();
		String parentWindow14 = it15.next();
		System.out.println(parentWindow14);
		String childWindow14 = it15.next();
		driver.switchTo().window(childWindow14);
		System.out.println(childWindow14);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999123url=driver.getCurrentUrl();
		if(sitePortalUSDEM999123url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 123 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 123 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 124']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-124 link");
		Thread.sleep(1000);
		Set<String> handles15 = driver.getWindowHandles();

		Iterator<String> it16 = handles15.iterator();
		String parentWindow15 = it16.next();
		System.out.println(parentWindow15);
		String childWindow15 = it16.next();
		driver.switchTo().window(childWindow15);
		System.out.println(childWindow15);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999124url=driver.getCurrentUrl();
		if(sitePortalUSDEM999124url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 124 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 124 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 887']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-887 link");
		Thread.sleep(1000);
		Set<String> handles16 = driver.getWindowHandles();

		Iterator<String> it17 = handles16.iterator();
		String parentWindow16= it17.next();
		System.out.println(parentWindow16);
		String childWindow16 = it17.next();
		driver.switchTo().window(childWindow16);
		System.out.println(childWindow16);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String sitePortalUSDEM999887url=driver.getCurrentUrl();
		if(sitePortalUSDEM999887url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 887 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 887 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Site Portal - US-DEM-999 - 895']")));
		driver.findElement(By.xpath("//a[text()='Site Portal - US-DEM-999 - 895']")).click();
		test.log(LogStatus.INFO, "Clicked on Site Portal-US-DEM-999-895 link");
		Thread.sleep(1000);
		Set<String> handles17 = driver.getWindowHandles();

		Iterator<String> it18 = handles17.iterator();
		String parentWindow17 = it18.next();
		System.out.println(parentWindow17);
		String childWindow17 = it18.next();
		Thread.sleep(2000);
		driver.switchTo().window(childWindow17);
		System.out.println(childWindow17);

		Thread.sleep(9000);
		//System.out.println(driver.getCurrentUrl());
		
		String sitePortalUSDEM999895url=driver.getCurrentUrl();
		if(sitePortalUSDEM999895url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "Site Portal - US-DEM-999 - 895 link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "Site Portal - US-DEM-999 - 895 link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[4]")));
		driver.findElement(By.xpath("(//tr/td[@class=' thHeader']/ul/li/a)[4]")).click();
		test.log(LogStatus.INFO, "Clicked on US-DEM-999 (SponsorPortal) link");
		Thread.sleep(1000);
		Set<String> handles18 = driver.getWindowHandles();

		Iterator<String> it19 = handles18.iterator();
		String parentWindow18 = it19.next();
		System.out.println(parentWindow18);
		String childWindow18 = it19.next();
		driver.switchTo().window(childWindow18);
		System.out.println(childWindow18);

		Thread.sleep(5000);
		//System.out.println(driver.getCurrentUrl());
		String usdem999url=driver.getCurrentUrl();
		if(usdem999url.equals(driver.getCurrentUrl())) {
		test.log(LogStatus.INFO, driver.getCurrentUrl());
		test.log(LogStatus.PASS, "US DEM-999 (SponsorPortal) link is working fine");
		driver.close();
		}else {
			test.log(LogStatus.FAIL, "US DEM-999 (SponsorPortal) link is not working");
		}
		driver.switchTo().window(sdTrilMainWindow);
		
		}else {
			test.log(LogStatus.FAIL, "Clicking on study direct trial page not opened properly");
			//System.out.println("Clicking on StudyDirect trial type page not opening properly");
			//test.log(LogStatus.INFO, "Clicking on StudyDirect trial type page not opening properly");
		}
	}

}}