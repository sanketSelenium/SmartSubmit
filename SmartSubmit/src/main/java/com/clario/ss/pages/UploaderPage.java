package com.clario.ss.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.clario.ss.base.BasePage;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.ExcelReader;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UploaderPage extends BasePage{
	ExcelReader ex=new ExcelReader();
//	public WebDriver driver;
	RandomDataExcelUtil randomutil=new RandomDataExcelUtil();
	
	public UploaderPage(WebDriver driver, ExtentTest test) {
		
		super(driver, test);
	 
	
	}

	public void selectFile() throws InterruptedException {

		// driver.findElement(ConstantsOR.SELECT_FILE_BUTTON).click();
		// eleutil.getElement(ConstantsOR.SELECT_FILE_BUTTON).click();
		test.log(LogStatus.INFO, "Selecting File to Upload");
		takeScreenShot();
		doClick(ConstantsOR.SELECT_FILE_BUTTON);
		Thread.sleep(2000);

		try {
			Runtime.getRuntime().exec("E:\\Bioclinica Smart Submit\\autoit\\Fileupload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectUploadCaseData(String trialName,String siteName,String imageType,String subjectId,String reasonForUpload,String timepoint) throws InterruptedException, IOException {
		 WebDriverWait wait=new WebDriverWait(driver, 60);
		// test.log(LogStatus.INFO, "Selecting  data to upload a case");
		doClick(ConstantsOR.TRIALID_DROPDOWN);

//		List<WebElement> tidlist=driver.findElements(ConstantsOR.TRIALID_DROPDOWN_VALUES);
//		System.out.println("total number of trialid's: "+ tidlist.size());
//		
//		for(WebElement e:tidlist) {
//			String tvalue=e.getText();
//			//System.out.println(tvalue);
//			if(tvalue.equals("Testlax3428")) {
//				e.click();
//				
//			}
//		}
		Thread.sleep(1000);
		selectDropdownValueWithoutSearch(ConstantsOR.TRIALID_DROPDOWN_VALUES, trialName);
		Thread.sleep(1000);
		doClick(ConstantsOR.SITEID_DROPDOWN);
		Thread.sleep(5000);
		selectDropdownValueWithoutSearch(ConstantsOR.SITEID_DROPDOWN_VALUES, siteName);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.IMAGING_EXAM_DROPDOWN));
		doClick(ConstantsOR.IMAGING_EXAM_DROPDOWN);
		Thread.sleep(1000);
		
       
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ConstantsOR.IMAGING_EXAM_DRPDOWN_VALUES));
   selectDropdownValueWithoutSearch(ConstantsOR.IMAGING_EXAM_DRPDOWN_VALUES, imageType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.IMAGECOUNT_WARNING_POPUP));
		doClick(ConstantsOR.IMAGECOUNT_WARNING_POPUP);
		Thread.sleep(3000);

		driver.findElement(ConstantsOR.SUBJECTID_FIELD).sendKeys(subjectId);
		Thread.sleep(1000);

		doClick(ConstantsOR.REASON_FOR_UPLOAD_DROPDOWN);
		Thread.sleep(1000);

		selectDropdownValueWithoutSearch(ConstantsOR.REASON_FOR_UPLOAD_DROPDOWN_VALUES, reasonForUpload);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ConstantsOR.TIMEPOINT_LIST));
	selectTimepoint(ConstantsOR.TIMEPOINT_LIST, timepoint);
		Thread.sleep(9000);

	popupScroll();
		doClick(ConstantsOR.UPLOAD_AS_NEW_CASE);
		Thread.sleep(8000);
		doClick(ConstantsOR.SUBMIT_BUTTON);
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		Thread.sleep(5000);

    	 wait=new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.ESIGN_POPUP));

		//driver.findElement(ConstantsOR.ESIGN_USERNAME).click();
		wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.ESIGN_USERNAME)).click();
//		String esignun=null;
//		try {
//			esignun=randomexceldata.readSpecificData("LoginCredentials", 2, 0);
//			System.out.println(esignun);
		driver.findElement(ConstantsOR.ESIGN_USERNAME).sendKeys(randomutil.readSpecificData("LoginCredentials",2,1));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		wait.until(ExpectedConditions.presenceOfElementLocated(ConstantsOR.ESIGN_PASSWORD));
       // driver.findElement(ConstantsOR.ESIGN_PASSWORD).click();
		wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.ESIGN_PASSWORD)).click();
//		String esignpwd=null;
//
//		try {
//			esignpwd=randomexceldata.readSpecificData("LoginCredentials", 2, 1);
//			System.out.println(esignpwd);
			driver.findElement(ConstantsOR.ESIGN_PASSWORD).sendKeys(randomutil.readSpecificData("LoginCredentials",2,2));
		//} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Thread.sleep(5000);
		driver.findElement(ConstantsOR.ESIGN_PASSWORD).sendKeys(Keys.ENTER);
//		wait.until(ExpectedConditions.elementToBeClickable(ConstantsOR.ESIGN_SUBMIT_BUTTON));
		//doClick(ConstantsOR.ESIGN_SUBMIT_BUTTON);
		String master = driver.getWindowHandle();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.UPLOAD_PROGRESS_SPINNER));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(ConstantsOR.UPLOAD_PROGRESS_SPINNER));
Thread.sleep(20000);
String var = driver.getWindowHandle();
System.out.println(var +"outside");
	
	try {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	//	System.out.println("yes");
//		String successheader=driver.findElement(ConstantsOR.UPLOAD_POPUP_HEADER).getText();
//		System.out.println(successheader);
		WebElement element = driver.switchTo().activeElement();
		 String var1 = driver.getWindowHandle();/*..contains("Success!");*/
		driver.switchTo().window(var);
System.out.println(var1 +"In side");
	} catch (AWTException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		String successheader=driver.findElement(ConstantsOR.UPLOAD_POPUP_HEADER).getText();
		System.out.println(successheader);
		test.log(LogStatus.INFO, "Please check below case upload success pop up with details: "+successheader);
		takeScreenShot();
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.NEW_GENERATED_BIOCID));
		//System.out.println(driver.findElement(ConstantsOR.NEW_GENERATED_BIOCID).getText());
	String newBIOCID=driver.findElement(ConstantsOR.NEW_GENERATED_BIOCID).getText();
	test.log(LogStatus.INFO, "BIOCID: "+newBIOCID);

	}}
