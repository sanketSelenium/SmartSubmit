package com.clario.ss.base;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clario.ss.util.ConstantsOR;
import com.clario.ss.util.ExtentManager;
import com.google.common.collect.Ordering;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

//	private static final String FileUtils = null;
	public WebDriver driver;
	// public TopMenu menu;
	public ExtentTest test;

	public BasePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		/*
		 * menu = new TopMenu(driver, test); PageFactory.initElements(driver, menu);
		 */
	}
//	public BasePage(WebDriver driver) {
//		this.driver=driver;
//		
//	}

	/*
	 * public String verifyTitle(String expTitle){ test.log(LogStatus.INFO,
	 * "Verifying the title " + expTitle); // webdriver code string actualtitle=
	 * return ""; }
	 */

	/*
	 * public String verifyText(String locator,String expText){ return ""; }
	 */

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void selectDropdownValueWithoutSearch(By locator, String actvalue) {
		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		List<WebElement> tidlist = driver.findElements(locator);

		// System.out.println("total number of values: "+ tidlist.size());
//				
//		for(WebElement e:tidlist) {
//			String tvalue=e.getText();
//			System.out.println(tvalue);
//			if(tvalue.equals("actvalue")) {
//				e.click();
//				break;
//				
//			}
		for (int i = 0; i < tidlist.size(); i++) {

			String value = tidlist.get(i).getText();
			// System.out.println(value);

			if (value.equals(actvalue)) {
				// wait.until(ExpectedConditions.elementToBeClickable(tidlist.get(i)));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",
						wait.until(ExpectedConditions.elementToBeClickable(tidlist.get(i))));
				// tidlist.get(i).click();
				break;
			}
		}

	}

	public void selectDropdownValueWhenSelectOptionPresent(By locator, String actvalue) {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

		List<WebElement> tidlist = driver.findElements(locator);

		// System.out.println("total number of values present: "+ tidlist.size());
//		
//		for(WebElement e:tidlist) {
//			String tvalue=e.getText();
//			System.out.println(tvalue);
//			if(tvalue.equals("actvalue")) {
//				e.click();
//				break;
//				
//			}
		for (int i = 0; i < tidlist.size(); i++) {

			String value = tidlist.get(i).getText();
			// System.out.println(value);

			if (value.equals(actvalue)) {
				tidlist.get(i).click();
				break;
			}
		}

	}

	public void selectTimepoint(By locator, String acttpvalue) {

		List<WebElement> timepointList = driver.findElements(locator);
		for (int i = 0; i < timepointList.size(); i++) {
			String tpvalue = timepointList.get(i).getText();
			System.out.println(tpvalue);

			if (tpvalue.equals(acttpvalue)) {
				Actions act = new Actions(driver);
				act.moveToElement(timepointList.get(i)).click().perform();
				// timepointList.get(i).click();
				break;
			}
		}

	}

	public void popupScroll() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[1];", driver.findElement(ConstantsOR.DUPE_CASE_POPUP),
				100);

	}

	public void selectValueWithJavascript(By locator, String actvalue) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].value='actvalue'", locator);
	}

	public void selectDropdownValueWhenElementIsClickable(By locator, String actvalue) {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		List<WebElement> tidlist = driver.findElements(locator);

		// System.out.println("total number of values present: "+ tidlist.size());
//   		
//   		for(WebElement e:tidlist) {
//   			String tvalue=e.getText();
//   			System.out.println(tvalue);
//   			if(tvalue.equals("actvalue")) {
//   				e.click();
//   				break;
//   				
//   			}
		for (int i = 0; i < tidlist.size(); i++) {

			String value = tidlist.get(i).getText();
			//System.out.println(value);

			if (value.equals(actvalue)) {
				wait.until(ExpectedConditions.elementToBeClickable(tidlist.get(i)));

				tidlist.get(i).click();
				break;
			}
		}
	}

	public static void waitForVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForVisibility(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	public static void waitForInvisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForInvisibility(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
	}
	public static void waitForVisibilityShort(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//	public static void waitForInvisibility(By element, WebDriver driver) {
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 60);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}

	public void verifyText(WebElement element, String expValue, String area) {
		try {

			test.log(LogStatus.INFO, "Verify Value: " + expValue + " from :" + area);
			waitForVisibility(element, driver);
			String actValue = element.getText();
			if (expValue.contains(actValue)) {
				test.log(LogStatus.PASS, "Expected Value avialable at :" + area);
			} else {
				test.log(LogStatus.FAIL, "Expected Value avialable at :" + area);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			reportFailure("Could not able to verify Text " + expValue + " from :" + area);
		}
	}

	public static int Verify_CurrentDateTime_Difference(String timeIS_Submit, String timeIS_Submit_SSVerified) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
		try {
			Date date1 = dateFormat.parse(timeIS_Submit);
			Date date2 = dateFormat.parse(timeIS_Submit_SSVerified);
			return (date2.getMinutes() - date1.getMinutes());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int countElementPresent(String locator, int count, String Message) {
		try {
			Thread.sleep(3000);

			int s = driver.findElements(By.xpath(locator)).size();
			if (count == s) {
				test.log(LogStatus.PASS, s + " No of " + Message + " Available using " + locator);
			} else {
				test.log(LogStatus.FAIL, s + " No of " + Message + " Available using " + locator);
			}
			return s;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public boolean isElementPresent(String locator) {
		try {
			Thread.sleep(1000);
			// test.log(LogStatus.INFO, "Trying to find element -> "+locator);
			int s = driver.findElements(By.xpath(locator)).size();
			if (s == 0) {
				// test.log(LogStatus.INFO, "Element not found");
				return false;
			} else {
				// test.log(LogStatus.INFO, "Element found");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isElementPresent_By(By locator) {
		try {
			Thread.sleep(1000);
			// test.log(LogStatus.INFO, "Trying to find element -> "+locator);
			int s = driver.findElements(locator).size();
			if (s == 0) {
				// test.log(LogStatus.INFO, "Element not found");
				return false;
			} else {
				// test.log(LogStatus.INFO, "Element found");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isElementPresentText(String locator) {
		// test.log(LogStatus.INFO, "Trying to find element -> "+locator);
		int s = driver.findElements(By.linkText(locator)).size();
		if (s == 0) {
			// test.log(LogStatus.INFO, "Element not found");
			return false;
		} else {
			// test.log(LogStatus.INFO, "Element found");
			return true;
		}

	}

	public String TakeCurrentDateTime_DD_MM_YYYY() {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public String verifyTextListOld(By Locator, String[] expList) {
		String c = "";
		try {

			List<WebElement> allLinks = driver.findElements(Locator);
//	Iterator<WebElement> itr = allLinks.iterator();
//	while(itr.hasNext()) {
//	    WebElement a=itr.next();
//	    Thread.sleep(150);
//	    String b=a.getText();
			if (allLinks.size() >= expList.length) {
				System.out.println("in if");
				for (WebElement a : allLinks) {
					for (int i = 0; i <= allLinks.size(); i++) {
						if (i < expList.length) {
							if (a.getText().equals(expList[i])) {
								c = c + a.getText() + ",";
								break;
							}

							else {
								if (!c.contains(a.getText())) {
									test.log(LogStatus.FAIL, a.getText() + " NOT Available");
								}
							}
						}
					}
				}
			} else {
				System.out.println("in else");
				for (String a : expList) {
					for (int i = 0; i < expList.length; i++) {
						if (i < allLinks.size()) {
							if (a.equals(allLinks.get(i).getText())) {
								c = c + allLinks.get(i).getText() + ",";
								break;
							}

							else {
								if (!c.contains(expList[i])) {
									test.log(LogStatus.FAIL, expList[i] + " NOT Available");
								}
							}
						}
					}
				}
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return c;
		}
	}

	public String compareExpectedDBText(String expValue, ResultSet resultSet, String column) {

		String c = "";
		try {
			List<String> list1 = new ArrayList<String>();
			while (resultSet.next()) {

				String name = resultSet.getString(column);
				list1.add(name);
				System.out.println("Getting " + name);
			}
			System.out.println("For 1");
			for (String d : list1) {

				Thread.sleep(300);
				if (d.contains(expValue)) {

					System.out.println("Pass : " + d);
					c = c + "," + d;
				} else {
					System.out.println(d + " NOT Available");
					test.log(LogStatus.FAIL, d + " NOT Available in Column :" + column);
				}
				// test.log(LogStatus.FAIL,expList[i]+" NOT Available");
			}
			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in column :" + column);
			} else {
				test.log(LogStatus.FAIL, expValue + " Options Not Available in column :" + column);
				test.log(LogStatus.INFO, list1 + " Options  Available in column :" + column);
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public List<String> getRemovedNBSPextList(By Locator) {
		List<String> list = null;
		try {
			List<WebElement> allLinks = driver.findElements(Locator);
			list = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {
				Thread.sleep(30);
				if (!allLinks.get(i).getText().equals(" ")) {
					list.add(allLinks.get(i).getText());
				}
//		System.out.println("Available : "+allLinks.get(i).getText());
			}
		} catch (Exception e) {
			reportFailure("unable to get text list  from method getTextList");
		}

		return list;
	}

	public List<String> getTextList(By Locator) {
		List<String> list = null;
		try {
			List<WebElement> allLinks = driver.findElements(Locator);
			list = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {
				Thread.sleep(30);
				list.add(allLinks.get(i).getText());
//		System.out.print("\""+allLinks.get(i).getText()+"\",");
			}
		} catch (Exception e) {
			reportFailure("unable to get text list  from method getTextList");
		}

		return list;
	}

	public String verifyExpectedDBTextList(List<String> list, java.sql.ResultSet resultSet, String column) {
		String c = "";
		try {
			Thread.sleep(5000);
//	Iterator<String> itrStr = expList.iterator();
			List<String> list1 = new ArrayList<String>();
			while (resultSet.next()) {

				String name = resultSet.getString(column);
				list1.add(name);
//		System.out.println("Getting "+name);
			}
//	System.out.println("For 1");
			test.log(LogStatus.INFO, "Comparing Drop down values are of size, " + list.size()
					+ " in dropdown and in db :" + list1.size());
			if (list.size() == list1.size()) {
				System.out.println("in if");
				for (String d : list1) {

					Thread.sleep(30);
					if (list.contains(d)) {
						System.out.println("Pass : " + d);
//				test.log(LogStatus.PASS,"Links is match");
						c = c + "," + d;
					} else {
						System.out.println(d + " NOT Available");
						test.log(LogStatus.FAIL, d + " NOT Available in Column :" + column);
					}
				}
			} else if (list.size() > list1.size()) {
				System.out.println("in else if");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list) {

					Thread.sleep(30);
					if (list1.contains(e)) {

						System.out.println("Pass : " + e);
//						test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in Column :" + column);
					}
				}
			} else {
				System.out.println("in else ");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list1) {

					Thread.sleep(300);
					if (list.contains(e)) {

						System.out.println("Pass : " + e);
//					test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in dropdown :" + column);
					}
				}
			}
			// test.log(LogStatus.FAIL,expList[i]+" NOT Available");

			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in column :" + column);
			} else if (list.size() == 0 && list1.size() == 0) {
				test.log(LogStatus.INFO, "No Options Available in expected  column and dropdown");
			} else {
				test.log(LogStatus.FAIL, "Expected Options Not Available in column :" + column);
				test.log(LogStatus.INFO, list1 + " Options  Available in column :" + column);
				test.log(LogStatus.INFO, list + " Options  Available in dropdown ");
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public String verifyExpectedDBText(By Locator, java.sql.ResultSet resultSet, String column) {
		String c = "";
		try {
			Thread.sleep(5000);
			List<WebElement> allLinks = driver.findElements(Locator);
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {
				Thread.sleep(30);
				list.add(allLinks.get(i).getText().trim());
//	System.out.print("\""+allLinks.get(i).getText()+"\",");

			}
			boolean sorted = false;
			List<String> listSort = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {

				listSort.add(allLinks.get(i).getText());

			}
			sorted = Ordering.natural().isOrdered(listSort);
			if (sorted) {
				test.log(LogStatus.PASS, "Sorting is proper");
			} else {
				test.log(LogStatus.FAIL, "Sorting is not proper");
			}
//	Iterator<String> itrStr = expList.iterator();
			List<String> list1 = new ArrayList<String>();
			while (resultSet.next()) {

				String name = resultSet.getString(column);
				list1.add(name.trim());
//		System.out.println("Getting "+name);
			}
//	System.out.println("For 1");
			test.log(LogStatus.INFO, "Comparing Drop down values are of size, " + list.size()
					+ " in dropdown and in db :" + list1.size());
			if (list.size() == list1.size()) {
				System.out.println("in if");
				for (String d : list1) {

					Thread.sleep(30);
					if (list.contains(d)) {
						System.out.println("Pass : " + d);
//				test.log(LogStatus.PASS,"Links is match");
						c = c + "," + d;
					} else {
						System.out.println(d + " NOT Available");
						test.log(LogStatus.FAIL, d + " NOT Available in Column :" + column);
					}
				}
			} else if (list.size() > list1.size()) {
				System.out.println("in else if");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list) {

					Thread.sleep(30);
					if (list1.contains(e)) {

						System.out.println("Pass : " + e);
//						test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in Column :" + column);
					}
				}
			} else {
				System.out.println("in else ");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list1) {

					Thread.sleep(300);
					if (list.contains(e)) {

						System.out.println("Pass : " + e);
//					test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in dropdown :" + column);
					}
				}
			}
			// test.log(LogStatus.FAIL,expList[i]+" NOT Available");

			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in column :" + column);
			} else if (list.size() == 0 && list1.size() == 0) {
				test.log(LogStatus.INFO, "No Options Available in expected  column and dropdown");
			} else {
				test.log(LogStatus.FAIL, "Expected Options Not Available in column :" + column);
				test.log(LogStatus.INFO, list1 + " Options  Available in column :" + column);
				test.log(LogStatus.INFO, list + " Options  Available in dropdown ");
			}
			List<String> ls2 = new ArrayList<String>();
			ls2.addAll(0, list);
			list.removeAll(list1);
			list1.removeAll(ls2);
			if (list1.equals(list)) {
				test.log(LogStatus.PASS, "Both Expected and Actual List contains same Data");
			} else {
				test.log(LogStatus.FAIL, list1
						+ " data are not available in expected  and in Actual list not available data are  " + list);
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public String verifyExpectedDBText_ExtraUser(String extraUser, By Locator, java.sql.ResultSet resultSet,
			String column) {
		String c = "";
		try {
			Thread.sleep(5000);
			List<WebElement> allLinks = driver.findElements(Locator);
			System.out.println(Locator);
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {
				Thread.sleep(30);
				list.add(allLinks.get(i).getText());
//	System.out.println("Available : "+allLinks.get(i).getText());
			}
			boolean sorted = false;
			List<String> listSort = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {

				listSort.add(allLinks.get(i).getText());

			}
			sorted = Ordering.natural().isOrdered(listSort);
			if (sorted) {
				test.log(LogStatus.PASS, "Sorting is proper");
			} else {
				test.log(LogStatus.FAIL, "Sorting is not proper");
			}
//	Iterator<String> itrStr = expList.iterator();
			List<String> list1 = new ArrayList<String>();
			while (resultSet.next()) {

				String name = resultSet.getString(column);
				list1.add(name);
//		System.out.println("Getting "+name);
			}
			System.out.println("Adding " + extraUser + " as Expected");
			if (!list1.contains(extraUser)) {
				list1.add(extraUser);
			} else {

			}
			System.out.println("For 1");
			if (list.size() == list1.size()) {
				System.out.println("in if");
				for (String d : list1) {

					Thread.sleep(30);
					if (list.contains(d)) {
						System.out.println("Pass : " + d);
//				test.log(LogStatus.PASS,"Links is match");
						c = c + "," + d;
					} else {
						System.out.println(d + " NOT Available");
						test.log(LogStatus.FAIL, d + " NOT Available in Column :" + column);
					}
				}
			} else if (list.size() > list1.size()) {
				System.out.println("in else if");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list) {

					Thread.sleep(30);
					if (list1.contains(e)) {

						System.out.println("Pass : " + e);
//						test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in Column :" + column);
					}
				}
			} else {
				System.out.println("in else ");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list1) {

					Thread.sleep(300);
					if (list.contains(e)) {

						System.out.println("Pass : " + e);
//					test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in Column :" + column);
					}
				}
			}
			// test.log(LogStatus.FAIL,expList[i]+" NOT Available");

			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in column :" + column);
			} else {
				test.log(LogStatus.FAIL, "Expected Options Not Available in column :" + column);
				test.log(LogStatus.INFO, list1 + " Options  Available in column :" + column);
			}
			List<String> ls2 = new ArrayList<String>();
			ls2.addAll(0, list);
			list.removeAll(list1);
			list1.removeAll(ls2);
			if (list1.equals(list)) {
				test.log(LogStatus.PASS, "Both Expected and Actual List contains same Data");
			} else {
				test.log(LogStatus.FAIL, list1
						+ " data are not available in expected  and in Actual list not available data are  " + list);
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public String verifyExpectedTextList(By Locator, String[] expList) {
		String c = "";
		try {
			Thread.sleep(5000);
			List<WebElement> allLinks = driver.findElements(Locator);
			List<String> list = new ArrayList<String>();
			List<String> list1 = new ArrayList<String>();
			for (int i = 0; i < allLinks.size(); i++) {
				Thread.sleep(300);
				list.add(allLinks.get(i).getText());
				System.out.print("\"" + allLinks.get(i).getText() + "\",");
//	System.out.println("Added : "+allLinks.get(i).getText());
			}
//	boolean sorted = false;
//	List<String> listSort = new ArrayList<String>();
//	for(int i=0;i<allLinks.size();i++)
//	{
//		
//		listSort.add(allLinks.get(i).getText());
//		
//	}
//	sorted = Ordering.natural().isOrdered(listSort);
//	if(sorted)
//	{
//		test.log(LogStatus.PASS,"Sorting is proper");
//	}
//	else
//	{
//		test.log(LogStatus.FAIL,"Sorting is not proper");
//	}
			for (int i = 0; i < expList.length; i++) {
				Thread.sleep(3);
				list1.add(expList[i]);
//	System.out.println("Added : "+allLinks.get(i).getText());
			}
//	Iterator<String> itrStr = expList.iterator();
			System.out.println("For 1");
			if (list.size() == list1.size()) {
				System.out.println("in if");
				for (String d : list1) {

					Thread.sleep(30);
					if (list.contains(d)) {
						System.out.println("Pass : " + d);
//				test.log(LogStatus.PASS,"Links is match");
						c = c + "," + d;
					} else {
						System.out.println(d + " NOT Available");
						test.log(LogStatus.FAIL, d + " NOT Available in list");
					}
				}
			} else if (list.size() > list1.size()) {
				System.out.println("in else if");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list) {

					Thread.sleep(30);
					if (list1.contains(e)) {

						System.out.println("Pass : " + e);
//						test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in  in list");
					}
				}
			} else {
				System.out.println("in else ");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list1) {

					Thread.sleep(300);
					if (list.contains(e)) {

						System.out.println("Pass : " + e);
//					test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + "  NOT Available in  in list");
					}
				}
			}
			// test.log(LogStatus.FAIL,expList[i]+" NOT Available");

			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in list ");
			} else {
				test.log(LogStatus.FAIL, "Expected Options Not Available");
				test.log(LogStatus.INFO, list1 + " Options  Available");
			}
			List<String> ls2 = new ArrayList<String>();
			ls2.addAll(0, list);
			list.removeAll(list1);
			list1.removeAll(ls2);
			if (list1.equals(list)) {
				test.log(LogStatus.PASS, "Both Expected and Actual List contains same Data");
			} else {
				test.log(LogStatus.FAIL, list1
						+ " data are not available in expected  and in Actual list not available data are  " + list);
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public String verifyExpectedTextList(List<String> list, String[] expList) {
		String c = "";
		try {
			Thread.sleep(5000);
			List<String> list1 = new ArrayList<String>();

			for (int i = 0; i < expList.length; i++) {
				Thread.sleep(3);
				list1.add(expList[i]);
//	System.out.println("Added : "+allLinks.get(i).getText());
			}
//	Iterator<String> itrStr = expList.iterator();
			System.out.println("For 1");
			if (list.size() == list1.size()) {
				System.out.println("in if");
				for (String d : list1) {

					Thread.sleep(30);
					if (list.contains(d)) {
						System.out.println("Pass : " + d);
//				test.log(LogStatus.PASS,"Links is match");
						c = c + "," + d;
					} else {
						System.out.println(d + " NOT Available");
						test.log(LogStatus.FAIL, d + " NOT Available in list");
					}
				}
			} else if (list.size() > list1.size()) {
				System.out.println("in else if");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list) {

					Thread.sleep(30);
					if (list1.contains(e)) {

						System.out.println("Pass : " + e);
//						test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + " NOT Available in  in list");
					}
				}
			} else {
				System.out.println("in else ");
				test.log(LogStatus.FAIL, "Drop down values are of different size, " + list.size()
						+ " in dropdown but in db :" + list1.size());
				for (String e : list1) {

					Thread.sleep(300);
					if (list.contains(e)) {

						System.out.println("Pass : " + e);
//					test.log(LogStatus.PASS,"Links is match");
						c = c + "," + e;
					} else {
						System.out.println(e + " NOT Available");
						test.log(LogStatus.FAIL, e + "  NOT Available in  in list");
					}
				}
			}
			// test.log(LogStatus.FAIL,expList[i]+" NOT Available");

			if (!c.equals("")) {
				test.log(LogStatus.PASS, c + " Options Available in list ");
			} else {
				test.log(LogStatus.FAIL, "Expected Options Not Available");
				test.log(LogStatus.INFO, list1 + " Options  Available");
			}
			List<String> ls2 = new ArrayList<String>();
			ls2.addAll(0, list);
			list.removeAll(list1);
			list1.removeAll(ls2);
			if (list1.equals(list)) {
				test.log(LogStatus.PASS, "Both Expected and Actual List contains same Data");
			} else {
				test.log(LogStatus.FAIL, list1
						+ " data are not available in expected  and in Actual list not available data are  " + list);
			}
			return c;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;

	}

	public void clearType(By Xpath, String enterData, String area) {
		try {
			test.log(LogStatus.INFO, "Clearing " + area + " Entering :" + enterData);
			driver.findElement(Xpath).clear();
			Thread.sleep(1000);
			driver.findElement(Xpath).sendKeys(enterData);
		} catch (Exception e) {

		}
	}

	public void verifyValidation(By Xpath, String Xpatherror, String errormsg) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			test.log(LogStatus.INFO, "Verifying the validation of " + errormsg);
			Thread.sleep(2000);
			driver.findElement(Xpath).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpatherror)));
			Thread.sleep(3000);
			String Actualerrormsg = driver.findElement(By.xpath(Xpatherror)).getText();
			if (errormsg.equalsIgnoreCase(Actualerrormsg)) {
				test.log(LogStatus.PASS, "validation message is correct " + Actualerrormsg);
			} else {
				reportFailure("validation message is not correct Actual Error message is " + Actualerrormsg
						+ " And Expected validation message is " + errormsg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Issue in verifyValidation Error message is not displayed");
		}
	}

	public boolean isElementPresentID(String locator) {
		// test.log(LogStatus.INFO, "Trying to find element -> "+locator);
		try {
			Thread.sleep(1000);
			int s = driver.findElements(By.id(locator)).size();
			if (s == 0) {
				// test.log(LogStatus.INFO, "Element not found");
				return false;
			} else {
				// test.log(LogStatus.INFO, "Element found");
				return true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean isPageTitleMatch(String title) {
		test.log(LogStatus.INFO, "Trying to find element -> " + title);
		String s = driver.getTitle();
		if (s.equalsIgnoreCase(title)) {
			test.log(LogStatus.INFO, "Title is matched");
			return false;
		} else {
			test.log(LogStatus.INFO, "Element found");
			return true;
		}

	}
	/*
	 * public TopMenu getMenu(){ return menu; }
	 */

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

	public void takeScreenShot_Fullsystem() {
		test.log(LogStatus.INFO, "Taking Screenshot");
		Date d = new Date();
		String screenshotFile = "Snap_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// String filePath = Constants.REPORTS_PATH + "screenshots//" + screenshotFile;
		String filePath = ExtentManager.SnapshotFolderPath + screenshotFile;
		String snapPath = "snaps//" + screenshotFile;
		// store screenshot in that file
//		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Robot r = new Robot();

			// Used to get ScreenSize and capture image
			Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle capture = new Rectangle(dimension);
//	              BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(server.getInputStream()));

			BufferedImage Image = r.createScreenCapture(capture);
			ImageIO.write(Image, "png", new File(filePath));
		} catch (IOException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(snapPath));
	}

	public void reportFailure(String failureMessage) {
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		// Assert.fail(failureMessage);
	}

	public boolean verifyTitle(String expTitle) {
		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(expTitle))
			return true;
		else
			return false;
	}

	public void verifyFieldDisabled_Aceess_Enabled(By xpath, By xpathDisabled, String Field) {
		try {
			test.log(LogStatus.INFO, "Verifying the Field " + Field);
			if (!isElementPresent_By(xpathDisabled)) {
				test.log(LogStatus.PASS, Field + " Not Disabled");
			} else {
				test.log(LogStatus.FAIL, Field + " may Not be Disabled");
			}
			if (isElementPresent_By(xpath)) {
				test.log(LogStatus.PASS, Field + " Enabled");
			} else {
				test.log(LogStatus.FAIL, Field + " may Not be Enabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Issue in verifyFieldDisabled");
		}
	}

	public void verifyFieldDisabled(By xpathDisabled, String Field) {
		try {
			test.log(LogStatus.INFO, "Verifying the Field " + Field);
			if (isElementPresent_By(xpathDisabled)) {
				test.log(LogStatus.PASS, Field + " Disabled");
			} else {
				test.log(LogStatus.FAIL, Field + " may be Enabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Issue in verifyFieldDisabled");
		}
	}

	public void SelectPerson_DeclareEffective(String persondeclareeffective, String xpath) {
		try {
			Thread.sleep(3000);
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(persondeclareeffective);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			test.log(LogStatus.INFO,
					"SelectPerson_DeclareEffective may not be available for :" + persondeclareeffective);
		}
	}

	public String TakeCurrentDateTime() {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public String TakeCurrentDate_Increase(int increaseupto) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, increaseupto); // Adding increaseupto days
		String output = dateFormat.format(c.getTime());
		return output;
	}

	public String changeDate(int increaseupto, String date) {
		// TODO Auto-generated method stub

		// String datefff="08/01/2018";
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, increaseupto);
		Date dateBefore30Days = cal.getTime();
		String output = dateFormat.format(dateBefore30Days);
		System.out.println(output);

		return output;
	}

	public String TakeCurrentDate() {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public String TakeCurrentDate_MM_DD_YY() {
		// TODO Auto-generated method stub
		DateFormat dateFormat = new SimpleDateFormat("DD-MM-YY");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public void clickonElement(By buttonID) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].click();", driver.findElement(buttonID));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * public void waitForPageToLoad() { wait(1); JavascriptExecutor
	 * js=(JavascriptExecutor)driver; String state =
	 * (String)js.executeScript("return document.readyState");
	 * 
	 * while(!state.equals("complete")){ wait(2); state =
	 * (String)js.executeScript("return document.readyState"); } }
	 * 
	 * public void wait(int timeToWaitInSec){ try { Thread.sleep(timeToWaitInSec *
	 * 1000); } catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	public void verifyTwoChildWindow(String linktext, String expectedURL) throws InterruptedException {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (driver.findElements(By.xpath("//*[@id='tblTrialsSingleRecord_wrapper']//a[text()='" + linktext + "']"))
					.size() != 0) {

				// takeScreenShot();
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='tblTrialsSingleRecord_wrapper']//a[text()='" + linktext + "']")));
				// driver.findElement(By.xpath("//a[text()='"+linktext+"']")).click();
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", driver.findElement(
						By.xpath("//*[@id='tblTrialsSingleRecord_wrapper']//a[text()='" + linktext + "']")));
				test.log(LogStatus.INFO, "Clicked on " + linktext + "link");
				Thread.sleep(9000);
				// Switching from parent window to child window
				String Parent_Window = driver.getWindowHandle();
				System.out.println("Parent window :" + Parent_Window);

				Set<String> handles = driver.getWindowHandles();
				Iterator<String> it = handles.iterator();

				String parentWindow1 = it.next();
				System.out.println(parentWindow1);

				String parentWindow2 = it.next();
				System.out.println(parentWindow2);
				String childWindow1 = it.next();
				System.out.println(childWindow1);
				driver.switchTo().window(childWindow1);
				Thread.sleep(5000);
				String currentURL = driver.getCurrentUrl();
				System.out.println("child url :" + currentURL);
				if (currentURL.contains(expectedURL)) {

					test.log(LogStatus.PASS, linktext + " link is working fine");
					test.log(LogStatus.INFO, currentURL);
					// driver.close();
				} else {
					test.log(LogStatus.FAIL, linktext + " Link is not working");
					// reportFailure("Not able to redireted to "+expectedURL+"as Actual URL is :
					// "+currentURL);
					// driver.close();
				}

				// driver.switchTo().window(parentWindow2);

			} else {

				test.log(LogStatus.FAIL, linktext + " Link may not be present");
				takeScreenShot();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyChildWindow(String locator, String linktext, String expectedURL) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (driver.findElements(By.xpath("" + locator + "")).size() != 0) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("" + locator + "")));
				driver.findElement(By.xpath("" + locator + "")).click();
				test.log(LogStatus.INFO, "Clicked on " + linktext + " link");
				Thread.sleep(10000);
				String Parent_Window = driver.getWindowHandle();

				Set<String> handles = driver.getWindowHandles();

				Iterator<String> it = handles.iterator();
				String parentWindow1 = it.next();
				System.out.println(parentWindow1);
				String childWindow1 = it.next();
				System.out.println(childWindow1);
				// driver.close();
				driver.switchTo().window(childWindow1);
				Thread.sleep(10000);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				if (currentURL.contains(expectedURL)) {
					test.log(LogStatus.PASS, linktext + " link is working fine");
					test.log(LogStatus.INFO, currentURL);
					driver.close();
				} else {
					test.log(LogStatus.FAIL, linktext + " link is not working");
					// reportFailure("Not able to redireted to "+expectedURL+"as Actual URL is :
					// "+currentURL);
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

	public void doActionInChildWindow(String locator, String linktext, String expctedURL) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (driver.findElements(By.xpath("" + locator + "")).size() != 0) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("" + locator + "")));
				driver.findElement(By.xpath("" + locator + "")).click();
				test.log(LogStatus.INFO, "Clicked on " + linktext + " link");
				Thread.sleep(10000);
				String Parent_Window = driver.getWindowHandle();

				Set<String> handles = driver.getWindowHandles();

				Iterator<String> it = handles.iterator();
				String parentWindow1 = it.next();
				System.out.println(parentWindow1);
				String childWindow1 = it.next();
				System.out.println(childWindow1);
				// driver.close();
				driver.switchTo().window(childWindow1);
				Thread.sleep(5000);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				if (currentURL.contains(expctedURL)) {
					test.log(LogStatus.PASS, linktext + " link is working fine");
					test.log(LogStatus.INFO, currentURL);

					// driver.close();
				} else {
					test.log(LogStatus.FAIL, linktext + " link is not working");
					// reportFailure("Not able to redireted to "+expectedURL+"as Actual URL is :
					// "+currentURL);
					// driver.close();
				}
//				Thread.sleep(1000);
//				driver.switchTo().window(Parent_Window);
//				Thread.sleep(3000);
			} else {
				test.log(LogStatus.INFO, "Link may not be there");
				takeScreenShot();
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Element not found for verifyChildWindow");
		}
	}

	public void doActionInPortalChildWindow(String locator, String linktext, String expctedURL) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (driver.findElements(By.xpath("" + locator + "")).size() != 0) {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("" + locator + "")));
				driver.findElement(By.xpath("" + locator + "")).click();
				test.log(LogStatus.INFO, "Clicked on " + linktext + " link");
				Thread.sleep(10000);
				String Parent_Window = driver.getWindowHandle();

				Set<String> handles = driver.getWindowHandles();

				Iterator<String> it = handles.iterator();
				String parentWindow1 = it.next();
				System.out.println(parentWindow1);
				String childWindow1 = it.next();
				System.out.println(childWindow1);
				// driver.close();
				driver.switchTo().window(childWindow1);
				Thread.sleep(5000);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				if (currentURL.contains(expctedURL)) {
					test.log(LogStatus.PASS, linktext + " link is working fine");
					test.log(LogStatus.INFO, currentURL);

					// driver.close();
				} else {
					test.log(LogStatus.FAIL, linktext + " link is not working");
					// reportFailure("Not able to redireted to "+expectedURL+"as Actual URL is :
					// "+currentURL);
					// driver.close();
				}
//				Thread.sleep(1000);
//				driver.switchTo().window(Parent_Window);
//				Thread.sleep(3000);
			} else {
				test.log(LogStatus.INFO, "Link may not be there");
				takeScreenShot();
			}
		} catch (Exception e) {
			e.printStackTrace();
			reportFailure("Element not found for verifyChildWindow");
		}
	}

	public void verifyImageSearchTimepointLink(String locator, String linktext, String expctedURL)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (driver.findElements(By.xpath("" + locator + "")).size() != 0) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("" + locator + "")));
			driver.findElement(By.xpath("" + locator + "")).click();
			test.log(LogStatus.INFO, "Clicked on " + linktext + " link");
			Thread.sleep(10000);
			String Parent_Window = driver.getWindowHandle();
			System.out.println(Parent_Window);

			Set<String> handles = driver.getWindowHandles();

			Iterator<String> it = handles.iterator();
			String parentWindow1 = it.next();
			System.out.println(parentWindow1);
			String childWindow1 = it.next();
			System.out.println(childWindow1);

			driver.switchTo().window(childWindow1);
			Thread.sleep(5000);
			/*
			 * LoginPage loginpage = new LoginPage(driver, test); RandomDataExcelUtil
			 * randomexceldata = new RandomDataExcelUtil(); try {
			 * loginpage.doLogin(randomexceldata.readSpecificData("SS6061", 1, 0),
			 * randomexceldata.readSpecificData("SS6061", 1, 1)); } catch (IOException e) {
			 * // TODO Auto-generated catch block e.printStackTrace(); }
			 * Thread.sleep(15000);
			 */
			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			/*
			 * List<WebElement> tpwindowcount = driver
			 * .findElements(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_NEW_WINDOW_RESULTS_COUNT);
			 * // int tpwindowcountsize=tpwindowcount.size();
			 * System.out.println("window tp count " + tpwindowcount.size()); for (int i =
			 * 0; i < tpwindowcount.size(); i++) {
			 * 
			 * String value1 = tpwindowcount.get(i).getText();
			 */
			// System.out.println(value1);
			// }
			if (currentURL.contains(expctedURL)) {
				// System.out.println("test inside");
				
				 // if (tpwindowcount.size() == 1) { //System.out.println("test second");
				  test.log(LogStatus.PASS, linktext + " link is working fine");
				  test.log(LogStatus.INFO, currentURL); //takeScreenShot();
				  
				  driver.close();
				  
				 // }
				 
			} else {
				test.log(LogStatus.FAIL, linktext + " link is not working");

				driver.close();

			}

			Thread.sleep(1000);
			driver.switchTo().window(Parent_Window);
			Thread.sleep(3000);

		} else {
			test.log(LogStatus.INFO, "Link may not be there");
			takeScreenShot();
		}
//	} catch (Exception e) {
//		e.printStackTrace();
//		reportFailure("Element not found for verifyChildWindow");
//	}

	}

	public void verifyImageSearchSubjectLink(String locator, String linktext, String expctedURL)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		List<WebElement> tpcount = driver.findElements(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_RESULTS_COUNT);
//		System.out.println("image search tp count " + tpcount.size());
//		for (int i = 0; i < tpcount.size(); i++) {
//
//			String value = tpcount.get(i).getText();
//			// System.out.println(value);
//		}
		if (driver.findElements(By.xpath("" + locator + "")).size() != 0) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("" + locator + "")));
			driver.findElement(By.xpath("" + locator + "")).click();
			test.log(LogStatus.INFO, "Clicked on " + linktext + " link");
			Thread.sleep(10000);
			String Parent_Window = driver.getWindowHandle();

			Set<String> handles = driver.getWindowHandles();

			Iterator<String> it = handles.iterator();
			String parentWindow1 = it.next();
			System.out.println(parentWindow1);
			String childWindow1 = it.next();
			System.out.println(childWindow1);

			driver.switchTo().window(childWindow1);
			Thread.sleep(5000);

			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			List<WebElement> tpwindowcount = driver
					.findElements(ConstantsOR.IMAGE_SEARCH_TIMEPOINT_NEW_WINDOW_RESULTS_COUNT);
			System.out.println("subject tp count size " + tpwindowcount.size());
//			for (int i = 0; i < tpwindowcount.size(); i++) {
//
//				String value = tpwindowcount.get(i).getText();
//				// System.out.println("subject tp value: " + value);
//			}

			if (currentURL.contains(expctedURL)) {

			//	if (tpcount.size() == tpwindowcount.size()) {

					test.log(LogStatus.PASS, linktext + " link is working fine");
					test.log(LogStatus.INFO, currentURL);
					//takeScreenShot();

					driver.close();
			//	}
			} else {
				test.log(LogStatus.FAIL, linktext + " link is not working");

				driver.close();

			}

			Thread.sleep(1000);
			driver.switchTo().window(Parent_Window);
			Thread.sleep(3000);
		} else {
			test.log(LogStatus.INFO, "Link may not be there");
			takeScreenShot();
		}
//} catch (Exception e) {
//e.printStackTrace();
//reportFailure("Element not found for verifyChildWindow");
//}
	}
	
	public void scrollPageDown() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		
	}
	public void scrollPageUp() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).perform();
	}
	public void doClickWithActions(By locator) {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(locator)).click().perform();
	}
	
	public void verifyResetValueByUsingAttribute(String fieldName,By locator,String attribute,String expValue) {
	String	actValue=driver.findElement(locator).getAttribute(attribute);
		if(actValue.equals(expValue)) {
			test.log(LogStatus.PASS, fieldName+" value got cleared");
		}
		else {
			test.log(LogStatus.FAIL, fieldName+" value not got cleared");
		}
	}
	
	public void verifyResetValueByUsingGetText(String fieldName,By locator,String expValue) {
		
		String actValue=driver.findElement(locator).getText();
		if(actValue.equals(expValue)) {
			test.log(LogStatus.PASS, fieldName+" value got cleared");
		}
		else {
			test.log(LogStatus.FAIL, fieldName+" value not got cleared");
		}
		}
	
//	public void selectDate(String dayvalue,String monthValue,String yearvalue) {
		
	//	driver.findElement(fromMonthDropdown).click();
//		Select monthdropdown=new Select(driver.findElement(monthlocator));
//		monthdropdown.selectByVisibleText(monthValue);
//		driver.findElement(yearlocator).click();
//		Select yeardropdown=new Select(driver.findElement(yearlocator));
//		yeardropdown.selectByVisibleText(yearvalue);
//		
//		List<WebElement> fromdays=driver.findElements(daylocator);
//		for(int i=0;i<fromdays.size();i++) {
//			String fday=fromdays.get(i).getText();
//			if(fday.equals(dayvalue)) {
//				fromdays.get(i).click();
//				break;
//			}
//			
//	}
//	}

}