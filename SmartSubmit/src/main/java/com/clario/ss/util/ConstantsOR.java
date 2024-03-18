
//need update
package com.clario.ss.util;

import java.util.Hashtable;

import org.openqa.selenium.By;

public class ConstantsOR {

	// public static final String
	// CHROME_DRIVER_EXE="C:\\SWAT\\Selenium\\05102017\\05102017\\chromedriver.exe";
	public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	public static final String FIRFOX_DRIVER_EXE = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
	public static final String IE_DRIVER_EXE = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
	public static final String Phantomjs_DRIVER_EXE = System.getProperty("user.dir") + "\\Drivers\\phantomjs.exe";
	public static final String EDGE_DRIVER_EXE = System.getProperty("user.dir") + "\\Drivers\\MicrosoftWebDriver.exe";

	// Top

	public static final By globalSearch = By.xpath("//input[@id='CustomSearch']");

	// Login page

//	public static final By LOGIN_USERNAME = By.id("userNameInput");
//	public static final By LOGIN_PASSWORD = By.id("passwordInput");
//
//	public static final By LOGIN_BUTTON = By.xpath("//span[@id=\"submitButton\"]");
//	//public static final By LOGIN_SUCCESS_MESG = By.id("LoginSuccessMessage");
//	public static final By FORGOT_PASSWORD_LINK = By.linkText("Forgot Password");
//	//public static final By SPINNER = By.xpath("(//div[@class='LoadSpinner'])[2]");
	public static final By LOGIN_ERROR = By.xpath("//div[@id='error']/label");
////	public static final By SMART_PORTAL_LINK=By.xpath("//a[@class='headerLinkSmartPortal']");

	// Admin area page
	public static final String ADMIN_OPTIONS_PAGE_TITLE = "SMART Submit - Admin Options";
	public static final By USER_MANAGEMENT_MENU = By
			.xpath("(//button[@class='btn btn-success dropdown-toggle admButton'])[1]");
	public static final By USER_MANAGEMENT_OPTIONS = By.xpath("(//ul[@class='dropdown-menu ddAdmin'])[1]/li/a");

	// Dashboard Page
	public static final By LOGGED_IN_USERNAME = By.xpath("//a[@class=\" Userdropdownlink droplink\"]");
	public static final By advSearchLink = By.xpath("//a[text()=\"Advanced Search \"]");

	public static final By LOADER = By.xpath("//section[@id='content']/div[@id='spinner']");
	public static final String DASHBOARD_PAGE_TITLE = "SMART Submit - Dashboard";

	public static final By SETTING_ICON = By.xpath("//a[@class='dropdown-toggle settingHeader']");
	public static final By NNJU_V2_OPTION = By.xpath("//a[@id='divNonJavaDicomReader']");
	public static final By ADMIN_AREA_LINK = By.linkText("Admin Area");
	public static final By LOGIN_SUCCESS_MESSAGE = By.xpath("//div[@id='LoginSuccessMessage']/label[@id='lblMsg']");
	public static final By BASIC_SEARCH_TEXTBOX = By.id("txtSearch");
	public static final By SMART_PORTAL_LINK=By.xpath("//a[@class='headerLinkSmartPortal']");
	public static final By DASHBOARD_LINK=By.xpath("//a[text()='Dashboard']");
	public static final By SIGNOUT_BUTTON=By.xpath("//a[@class='signOutButton']");


	//portal page
	public static final By TRIALNAME=By.xpath("(//a[text()='DEMO-9999']/parent::td)[1]");
	public static final By SMART_PORTAL_OPTION=By.xpath("//a[@id='SMARTPortal']");
	public static final By IMAGE_SEARCH_NO_RESULTS=By.xpath("//*[@id='CIPInfoGridContainer']/div/table/tbody/tr/td[text()='None']");
	public static final By IMAGE_SEARCH_TIMEPOINT_RESULTS_COUNT=By.xpath("//table[@class='jtable']/tbody/tr/td[4]");
	public static final By IMAGE_SEARCH_TIMEPOINT_NEW_WINDOW_RESULTS_COUNT=By.xpath("//div[@class='mat-tab-link-container']//a");
 
	
	// Advanced Search Page
	public static final By ADV_SEARCH_HEADER = By.xpath("//h3[text()='Advanced Search']");
	public static final By TRIAL_NAME_DROPDOWN = By.xpath("(//span[text()=\"Select\"])[5]");
	public static final By TRIAL_NAME_SELECTED = By.xpath("(//span[text()=\"1 selected\"])[1]");
	public static final By TRIAL_NAME_SEARCH_BOX = By.xpath("(//input[@class='multifilter'])[6]");
	public static final By TRIAL_NAME_DROPDOWN_ITEMS = By.xpath(
			"(//div[@class=\"ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass\"])[6]");
	public static final String TRIAL_NAME_SELECT = "(//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass'])[6]//span[@class='clsitem']";
	public static final By ADV_SEARCH_BUTTON = By.xpath("//input[@type=\"button\" and @id=\"btnSearch\"]");
	public static final By SEARCH_RESULTS_COUNT = By
			.xpath("//label[@class=\"col-md-2\" and @id=\"lblMsgRecordCount\"]");
	public static final By SELECT_ALL_RESULTS_CHECKBOX = By.xpath("//input[@id=\"IdSelectAll\"]");
	public static final By GENERATE_REPORT_DROPDOWN = By.xpath("//button[@data-id=\"GenerateOptions\"]");
	public static final By EXPORT_REPORT_LINK = By.xpath("//span[text()=\"Export Data\"]");
	public static final By MESSAGE_POPUP = By.xpath("//*[@id=\"cboxLoadedContent\"]/div[1]");

	// Invite User page
	public static final String INVITE_USER_PAGE_TITLE = "SMART Submit Invite User";

	public static final By EMAIL_TEXTBOX = By.xpath("//input[@id='txtEmail']");
	public static final By SUBMIT_EMAIL_BUTTON = By.xpath("//button[@id='btnSubmitEmail']");
	public static final By FIRSTNAME_TEXTBOX = By.id("txtFName");
	public static final By LASTNAME_TEXTBOX = By.id("txtLName");
	public static final By SELECT_ROLE_DROPDOWN = By.xpath("//button[@data-id='ddlRole']");
	public static final By ROLE_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[2]/li/a");
	public static final By SUBMIT_INVITE_BUTTON = By.xpath("//button[@id='submit']");
	public static final By SELECT_ACCOUNT_DROPDOWN = By.xpath("//button[@data-id='ddlAccount']");
	public static final By ACCOUNT_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[3]/li/a");
	public static final By SELECT_TRIAL_DROPDOWN = By.xpath("//button[@data-id='ddlTrial']");
	public static final By TRIAL_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[4]/li/a");
	public static final By SELECT_SITE_DROPDOWN = By
			.xpath("(//td//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[2]");
	public static final By SITE_SEARCH_TEXTBOX = By.xpath("(//ul[@class='ui-helper-reset']/li/input)[2]");
	public static final By SITE_DROPDOWN_VALUES = By.xpath(
			"(//ul[@class='ui-multiselect-checkboxes ui-helper-reset'])[2]/li/a/label/input/following-sibling::span");
	public static final By SITE_SELECTED = By
			.xpath("//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all ui-state-active']/span");
	public static final By DEFAULT_UPLOAD_METHOD = By.xpath("//button[@data-id='DisplayNJUTypeID']");
	public static final By TEST_USER_DROPDOWN = By.xpath("//button[@data-id='IsTestUser']");
	public static final By TEST_USER_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[6]/li");
	public static final By QUALIFICATION_REQUIRED_CHECKBOX = By.xpath("//input[@id='IsValidatedNo']");
	public static final By ALREADY_QUALIFIED = By.xpath("//input[@id='IsValidatedYes']");
	public static final By SELECT_CORELAB_DROPDOWN = By
			.xpath("(//button[@class='ui-multiselect ui-widget ui-state-default ui-corner-all'])[1]");
	public static final By CORELAB_DROPDOWN_VALUES = By
			.xpath("(//ul[@class='ui-multiselect-checkboxes ui-helper-reset'])[1]/li/a/label/span");
	public static final By INVITE_SUCCESS_MESSAGE = By.xpath("//div[@id='divResponseMsg']");

	// Uploader page

	public static final By SELECT_FILE_BUTTON = By.id("pickfiles");
	public static final By TRIALID_DROPDOWN = By.xpath("//button[@data-id='TrialID']");
	public static final By TRIALID_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[2]/li/a");
	public static final By SITEID_DROPDOWN = By.xpath("//button[@data-id='SiteID']");
	public static final By SITEID_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[3]/li/a");
	public static final By IMAGECOUNT_WARNING_POPUP = By.id("btnSubmitReasonLowImageCount");
	public static final By IMAGING_EXAM_DROPDOWN = By.xpath("//button[@data-id='ProcedureID']");
	public static final By IMAGING_EXAM_DRPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[4]/li/a");
	public static final By SUBJECTID_FIELD = By.id("SubjectID");
	public static final By REASON_FOR_UPLOAD_DROPDOWN = By.xpath("//button[@data-id='ReasonForUploadID']");
	public static final By REASON_FOR_UPLOAD_DROPDOWN_VALUES = By.xpath("(//ul[@class='dropdown-menu inner'])[5]/li/a");
	public static final By TIMEPOINT_LIST = By.xpath("//div[@id='VisitInfo']//div[@class='VisitTitle']");
	public static final By DUPE_CASE_POPUP = By.xpath("//div[@id='StudyInstanceView']");				
	public static final By UPLOAD_AS_NEW_CASE = By.id("btnNewCase");
	public static final By REPLACE_OLD_CASE = By.id("btnSubmitReason");
	public static final By SUBMIT_BUTTON = By.id("BtnSubmit");
	public static final By ESIGN_POPUP = By.xpath("//form[@id='ajaxform']");
	public static final By ESIGN_USERNAME = By.cssSelector("input#txtusername");
	public static final By ESIGN_PASSWORD = By.cssSelector("input#txtpassword");
	public static final By ESIGN_SUBMIT_BUTTON = By.xpath("//button[@id='btnsubmit']");
	public static final By UPLOAD_PROGRESS_SPINNER = By.xpath("//div[@id='NJULoadSpinner']");
	public static final By UPLOAD_SUCCESS_POPUP = By.xpath("//div[@id='PopupContent']");
	public static final By UPLOAD_POPUP_HEADER = By.xpath("//header[@class='SuccessMSG']/strong");
	public static final By NEW_GENERATED_BIOCID = By.xpath("//div[@class='jtable-main-container']//tbody/tr/td[7]");
	
	//portal page
	//public static final By IMAGESEARCH_HEADER=By.xpath("//h3[text()='Image Search']");
	public static final By IMAGE_SEARCH_PROTOCOL_DROPDOWN_BUTTON=By.xpath("//span[@id='select2-ddlProtocol-container']");
	public static final By IMAGE_SEARCH_PROTOCOL_DROPDOWN=By.xpath("//span[@class='select2-results']/ul/li");
	public static final By IMAGE_SEARCH_SITE_DROPDOWN_BUTTON=By.xpath("//span[@id='select2-ddlSiteId-container']");
	public static final By IMAGE_SEARCH_SITE_DROPDOWN=By.xpath("//span[@class='select2-results']/ul/li");
	
	public static final By IMAGE_SEARCH_SUBJECT_DROPDOWN_BUTTON=By.xpath("//table/tbody/tr[3]/td[2]/button");
	public static final By IMAGE_SEARCH_SUBJECT_SEARCH=By.xpath("(//ul[@class='ui-helper-reset']/li/input[@class='multifilter'])[1]");
	public static final By IMAGE_SEARCH_SUBJECT_DROPDOWN=By.xpath("//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass']/ul/li/a/label/input[@name='multiselect_SubjectID']/following-sibling::span");
	public static final By IMAGE_SEARCH_TIMEPOINT_DROPDOWN_BUTTON=By.xpath("//table/tbody/tr[4]/td[2]/button");
	public static final By IMAGE_SEARCH_TIMEPOINT_DROPDOWN=By.xpath("//div[@class='ui-multiselect-menu ui-widget ui-widget-content ui-corner-all multiselectclass']/ul/li/a/label/input[@name='multiselect_TimepointID']/following-sibling::span");
	
	public static final By IMAGE_SEARCH_BUTTON=By.xpath("//button[@id='btnSearchCIP']");
	//Manage User Page
	public static final By USERNAME_TEXTBOX=By.id("txtSearchEmail");
	public static final By MANAGEUSER_SEARCH_BUTTON=By.id("btnSearchUser");
//	public static final By NO_RESULTS=By.xpath("//tbody/tr[@class='jtable-no-data-row']/td");
	public static final By NO_RESULTS=By.xpath("//*[@id='UserInfoGridContainer']/div/table/tbody/tr/td[text()='None']");
	
	public static final By SMART_PORTAL_ACCESS_SETTING_BUTTON=By.xpath("//button[@data-id='IsSMARTPortalAccessible']");
	public static final By SMART_PORTAL_ACCESS_SETTING_DROPDOWN=By.xpath("(//div[@class='dropdown-menu open'])[12]/ul/li/a");
	public static final By EDIT_USER_SAVE_BUTTON=By.xpath("//input[@id='BtnSubmit']");
}
