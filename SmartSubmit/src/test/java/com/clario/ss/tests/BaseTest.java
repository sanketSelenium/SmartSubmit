package com.clario.ss.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.clario.ss.pages.AdminOptionsPage;
import com.clario.ss.pages.DashboardPage;
import com.clario.ss.pages.EmailCheckingPage;
import com.clario.ss.pages.ImageSearchPage;
import com.clario.ss.pages.InviteUserPage;
import com.clario.ss.pages.LaunchPage;
import com.clario.ss.pages.LoginPage;
import com.clario.ss.pages.ManageUserPage;
import com.clario.ss.pages.PortalAndImageSearchLogPage;
import com.clario.ss.pages.RegistrationPage;
import com.clario.ss.pages.UploaderPage;
import com.clario.ss.util.ConstantsConfig;
import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.ExcelReader;
import com.clario.ss.util.ExtentManager;
import com.clario.ss.utils.RandomDataExcelUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	ExtentManager em = new ExtentManager();
	public ExtentReports extent = em.getInstance();
	public ExtentTest test;
	public ExcelReader xls = new ExcelReader(ConstantsConfig.DATA_XLS_PATH);
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	public UploaderPage uploaderpage;
	public RandomDataExcelUtil randomexceldata;
	public AdminOptionsPage adminoptionspage;
	public InviteUserPage inviteuserpage;
	public ImageSearchPage imagesearchpage;
	public PortalAndImageSearchLogPage portalandimagesearchlogpage;
	public EmailCheckingPage emailcheckingpage;
	public RegistrationPage registrationpage;
	public ManageUserPage manageuserpage;

	

	public void init() {
//	 loginpage=new LoginPage(driver,test);
//	 imagesearchpage=new ImageSearchPage(driver,test);
//	  randomexceldata = new RandomDataExcelUtil();
	//test=extent.startTest("");
		prop=init_prop();
		
		String  browserName=prop.getProperty("browser");
		test.log(LogStatus.INFO, "Opening browser - " + browserName);

		try {
			if (browserName.equals("chrome")) {
		//System.setProperty("webdriver.chrome.driver",ConstantsOR.CHROME_DRIVER_EXE);
				WebDriverManager.chromedriver().setup();
//				ChromeOptions ops = new ChromeOptions();
//				ops.addArguments("--remote-allow-origins=*");
				 driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} 
			else if (browserName.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}else {
				test.log(LogStatus.INFO, "Please pass the right browser name");
			}
			
			// init(data.get("Browser"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			
			if(ConstantsOR.LOGIN_ERROR!=null) {
			//return ;

			}
			else {
				driver.navigate().refresh();
			}
			
		      
			test.log(LogStatus.INFO, "Browser opened successfully - " + browserName);
			//takeScreenShot();
			// return driver;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// return driver;
		
		
	}
	
	public Properties init_prop()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
		
	}

	public void clickonElement(By buttonID) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.elementToBeClickable(buttonID));
			js.executeScript("arguments[0].click();", driver.findElement(buttonID));
			Thread.sleep(4000);
		} catch (Exception ex) {
			ex.printStackTrace();
			reportFailure("Unable to click :" + buttonID);
		}
	}

	public void verifyChildWindow(String a, String expectedURL) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (isElementPresent(a)) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(a)));
				driver.findElement(By.xpath(a)).click();
				Thread.sleep(10000);
				String Parent_Window = driver.getWindowHandle();
				// Switching from parent window to child window
				for (String Child_Window : driver.getWindowHandles()) {
					driver.switchTo().window(Child_Window);
					Thread.sleep(2000);

				}
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				if (currentURL.contains(expectedURL)) {
					test.log(LogStatus.PASS, "New tab and navigate to " + currentURL);
					driver.close();
				} else {
					reportFailure("Not able to redireted to " + expectedURL + "as Actual URL is : " + currentURL);
					driver.close();
				}
				Thread.sleep(1000);
				driver.switchTo().window(Parent_Window);
				Thread.sleep(3000);
			} else {
				test.log(LogStatus.INFO, "Link may not be there");
				takeScreenShot();
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Element not found for verifyChildWindow");
		}

	}

	public boolean isElementPresent(String locator) {
		// test.log(LogStatus.INFO, "Trying to find element -> "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			// test.log(LogStatus.INFO, "Element not found");
			return false;
		} else {
			// test.log(LogStatus.INFO, "Element found");
			return true;
		}

	}

	public void reportFailure(String failureMessage) {
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		// Assert.fail(failureMessage);
	}

	public int giveRandomNo(int upTo) {
		Random rdm = new Random();
		int no = rdm.nextInt(upTo);
		return no;
	}

	public void pageObjects() {
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);

		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenShot();

	}

	/*
	 * public void takeScreenShot(){ Date d=new Date(); String
	 * screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	 * String filePath=ConstantsConfig.REPORTS_PATH+"screenshots//"+screenshotFile;
	 * // store screenshot in that file File scrFile =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * try { FileUtils.copyFile(scrFile, new File(filePath)); } catch (IOException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * test.log(LogStatus.INFO,test.addScreenCapture(filePath)); }
	 */

	public void takeScreenShot() {
		test.log(LogStatus.INFO, "Taking screenshot");
		Date d = new Date();
		String screenshotFile = "Snap_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// String filePath = Constants.REPORTS_PATH + "screenshots//" + screenshotFile;
		String filePath = ExtentManager.SnapshotFolderPath + screenshotFile;
		String snapPath = "snaps//" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(snapPath));
	}

	public boolean verifyTitle(String expTitle) {
		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(expTitle))
			return true;
		else
			return false;
	}
	// webdriver code

	public void Logout() {
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConstantsOR.SIGNOUT_BUTTON));
		driver.findElement(ConstantsOR.SIGNOUT_BUTTON).click();
//		String acttitle="Sign In";
//		if(acttitle.equals(driver.getTitle())) {
//			return true;
//		}
//		return false;
	}

	public void Selectdate(String date, String Xpath, String page) {

		try {
//			driver.findElement(By.xpath("//*[@id='T:oc_4601409352region1:id21::glyph']")).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Selecting " + page);
			driver.findElement(By.xpath(Xpath)).sendKeys(date);

		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("");
		}

	}

	public boolean verifyUserName(String expfullname) {
		try {
			String username = "";
			test.log(LogStatus.INFO, "Verifying the username after login " + expfullname);
//			Thread.sleep(50000);
			System.out.println(username + "=" + expfullname);
			 username= driver.findElement(ConstantsOR.LOGGED_IN_USERNAME).getText();
			System.out.println(username + "=" + expfullname);
			if (username.contains(expfullname)) {
				test.log(LogStatus.PASS, "Username is Correct : " + username);
				return true;
			} else {
				reportFailure(username + " Username is NOT Correct as expected is " + expfullname);
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	public void verifyLogin() 
	{
		WebDriverWait wait=new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ConstantsOR.LOADER));
		int logoutbutton=driver.findElements(ConstantsOR.SIGNOUT_BUTTON).size();
		//System.out.println(loginsuctext);
	if(logoutbutton>0)
		{
		test.log(LogStatus.PASS, "User Logged in Successfully");
			
		}
	else {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
	
			String loginErrortext=driver.findElement(ConstantsOR.LOGIN_ERROR).getText();
			System.out.println(loginErrortext);
			test.log(LogStatus.FAIL,"Login failed: "+loginErrortext);
			takeScreenShot();
			
		}

		}
			

}

