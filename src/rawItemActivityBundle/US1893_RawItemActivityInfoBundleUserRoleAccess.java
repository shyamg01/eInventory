package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;

public class US1893_RawItemActivityInfoBundleUserRoleAccess extends AbstractTest{
	
	//TC3642 : Verify that Level 1 user have access to enter raw waste.
	@Test()
	public void rawItemActivity_US1893_TC3642_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3642_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if(rawItemActivityPage.verifyRawItemActivityDisplayedForADate(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the raw item activity details for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the raw item activity details for selected date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3642 : Verify that Operator have access to enter raw waste.
	@Test()
	public void rawItemActivity_US1893_TC3642_Operator()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3642_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate = GlobalVariable.createDate;
		String stratDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if (rawItemActivityPage.verifyRawItemActivityDisplayedForADate(createDate)) {
			Reporter.reportPassResult(
					browser,
					"Operator should be able to view the raw item activity details for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator should be able to view the raw item activity details for selected date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3642 : Verify that OrgAdmin have access to enter raw waste.
	@Test()
	public void rawItemActivity_US1893_TC3642_OrgAdmin()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3642_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate = GlobalVariable.createDate;
		String stratDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if (rawItemActivityPage.verifyRawItemActivityDisplayedForADate(createDate)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin should be able to view the raw item activity details for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin should be able to view the raw item activity details for selected date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3642 : Verify that Supervisor have access to enter raw waste.
	@Test()
	public void rawItemActivity_US1893_TC3642_Supervisor()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3642_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate = GlobalVariable.createDate;
		String stratDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if (rawItemActivityPage.verifyRawItemActivityDisplayedForADate(createDate)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to view the raw item activity details for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to view the raw item activity details for selected date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3642 : Verify that SupervisorWithRoleAssignment have access to enter raw waste.
	@Test()
	public void rawItemActivity_US1893_TC3642_SupervisorWithRoleAssignment()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3642_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate = GlobalVariable.createDate;
		String stratDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if (rawItemActivityPage.verifyRawItemActivityDisplayedForADate(createDate)) {
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment should be able to view the raw item activity details for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment should be able to view the raw item activity details for selected date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC3643 : Verify that Level 1 user have access to Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3643_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3643_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String casePrice = "10.0000";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("checked "+rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked"));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked") == null){
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		Select listDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getOptions().get(1).getText();
		listDropDown.selectByIndex(1);
		Select glAccountDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getOptions().get(1).getText();
		glAccountDropDown.selectByIndex(1);
		Select vendorDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getOptions().get(2).getText();
		vendorDropDown.selectByIndex(2);
		rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL, "a"),casePrice);
		rawItemActivityPage.RawItemInformation_Title.click();
		rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT)).click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view success message on submitting the raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view success message on submitting the raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
				& rawItemActivityPage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
				& rawItemActivityPage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
				& rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)){
			Reporter.reportPassResult(
					browser,
					"User should be able to save raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to save raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3643 : Verify that Operator have access to Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3643_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3643_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String casePrice = "11.0000";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("checked "+rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked"));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked") == null){
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		Select listDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getOptions().get(1).getText();
		listDropDown.selectByIndex(1);
		Select glAccountDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getOptions().get(1).getText();
		glAccountDropDown.selectByIndex(1);
		Select vendorDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getOptions().get(1).getText();
		vendorDropDown.selectByIndex(1);
		rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL, "a"),casePrice);
		rawItemActivityPage.RawItemInformation_Title.click();
		rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT)).click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"Operator should be able to view success message on submitting the raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator should be able to view success message on submitting the raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
				& rawItemActivityPage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
				& rawItemActivityPage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
				& rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)){
			Reporter.reportPassResult(
					browser,
					"Operator should be able to save raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator should be able to save raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3643 : Verify that OrgAdmin have access to Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3643_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3643_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String casePrice = "12.0000";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("checked "+rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked"));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked") == null){
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		Select listDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getOptions().get(1).getText();
		listDropDown.selectByIndex(1);
		Select glAccountDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getOptions().get(1).getText();
		glAccountDropDown.selectByIndex(1);
		Select vendorDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getOptions().get(1).getText();
		vendorDropDown.selectByIndex(1);
		rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL, "a"),casePrice);
		rawItemActivityPage.RawItemInformation_Title.click();
		rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT)).click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"OrgAdmin should be able to view success message on submitting the raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin should be able to view success message on submitting the raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
				& rawItemActivityPage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
				& rawItemActivityPage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
				& rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)){
			Reporter.reportPassResult(
					browser,
					"OrgAdmin should be able to save raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin should be able to save raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3643 : Verify that Supervisor have access to Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3643_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3643_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData. supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String casePrice = "13.0000";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("checked "+rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked"));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked") == null){
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		Select listDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getOptions().get(1).getText();
		listDropDown.selectByIndex(1);
		Select glAccountDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getOptions().get(1).getText();
		glAccountDropDown.selectByIndex(1);
		Select vendorDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getOptions().get(1).getText();
		vendorDropDown.selectByIndex(1);
		rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL, "a"),casePrice);
		rawItemActivityPage.RawItemInformation_Title.click();
		rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT)).click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to view success message on submitting the raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to view success message on submitting the raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
				& rawItemActivityPage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
				& rawItemActivityPage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
				& rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)){
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to save raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to save raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3643 : Verify that Supervisor have access to Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3643_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3643_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData. supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String casePrice = "14.0000";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("checked "+rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked"));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("checked") == null){
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		Select listDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getOptions().get(1).getText();
		listDropDown.selectByIndex(1);
		Select glAccountDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getOptions().get(1).getText();
		glAccountDropDown.selectByIndex(1);
		Select vendorDropDown = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getOptions().get(1).getText();
		vendorDropDown.selectByIndex(1);
		rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL, "a"),casePrice);
		rawItemActivityPage.RawItemInformation_Title.click();
		rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT)).click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment should be able to view success message on submitting the raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment should be able to view success message on submitting the raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
				& rawItemActivityPage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
				& rawItemActivityPage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
				& rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)){
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment should be able to save raw item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment should be able to save raw item information",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC3644 : Verify that Level2 user will have access to the Raw Item Activity page functionality
	@Test()
	public void rawItemActivity_US1893_TC3644_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3644_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String activityDate=GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		/*if(!rawItemActivityPage.verifySelectedDateIsCollapsed(activityDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view collapsed records for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view collapsed records for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
//		rawItemActivityPage.clickOnDateGroup(activityDate);
		Thread.sleep(1500);
		if(rawItemActivityPage.verifySelectedDateIsExpanded(activityDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view expanded details for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view expanded details for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3644 : Verify that Level3 user will have access to the Raw Item Activity page functionality
	@Test()
	public void rawItemActivity_US1893_TC3644_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3644_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String activityDate=GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		/*if(rawItemActivityPage.verifySelectedDateIsCollapsed(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 3 user should be able to view collapsed records for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 user should be able to view collapsed records for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
//		rawItemActivityPage.clickOnDateGroup(activityDate);
		if(rawItemActivityPage.verifySelectedDateIsExpanded(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 3 user should be able to view expanded details for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 user should be able to view expanded details for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3644 : Verify that Level4 user will have access to the Raw Item Activity page functionality
	@Test()
	public void rawItemActivity_US1893_TC3644_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3644_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String activityDate=GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		/*if(rawItemActivityPage.verifySelectedDateIsCollapsed(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 4 user should be able to view collapsed records for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 user should be able to view collapsed records for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
//		rawItemActivityPage.clickOnDateGroup(activityDate);
		if(rawItemActivityPage.verifySelectedDateIsExpanded(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 4 user should be able to view expanded details for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 user should be able to view expanded details for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3644 : Verify that Level5 user will have access to the Raw Item Activity page functionality
	@Test()
	public void rawItemActivity_US1893_TC3644_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3644_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String activityDate=GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		/*if(rawItemActivityPage.verifySelectedDateIsCollapsed(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 5 user should be able to view collapsed records for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 user should be able to view collapsed records for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
//		rawItemActivityPage.clickOnDateGroup(activityDate);
		if(rawItemActivityPage.verifySelectedDateIsExpanded(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 5 user should be able to view expanded details for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 user should be able to view expanded details for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3644 : Verify that Level6 user will have access to the Raw Item Activity page functionality
	@Test()
	public void rawItemActivity_US1893_TC3644_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3644_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String activityDate=GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
	/*	if(rawItemActivityPage.verifySelectedDateIsCollapsed(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 5 user should be able to view collapsed records for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 user should be able to view collapsed records for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
//		rawItemActivityPage.clickOnDateGroup(activityDate);
		if(rawItemActivityPage.verifySelectedDateIsExpanded(activityDate)){
			Reporter.reportPassResult(
					browser,
					"Level 5 user should be able to view expanded details for the raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 user should be able to view expanded details for the raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3646 : Verify that Level2 user will have read-only access to the Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3646_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3646_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Frequency_DD.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Submit_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 2 user should not be able to make any changes on raw item information page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 user should not be able to make any changes on raw item information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3646 : Verify that Level3 user will have read-only access to the Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3646_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3646_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Frequency_DD.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Submit_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 3 user should not be able to make any changes on raw item information page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 user should not be able to make any changes on raw item information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3646 : Verify that Level 4 user will have read-only access to the Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3646_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3646_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Frequency_DD.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Submit_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 4 user should not be able to make any changes on raw item information page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 user should not be able to make any changes on raw item information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3646 : Verify that Level 5 user will have read-only access to the Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3646_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3646_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Frequency_DD.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Submit_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 5 user should not be able to make any changes on raw item information page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 user should not be able to make any changes on raw item information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3646 : Verify that Level 6 user will have read-only access to the Raw Item Information page functionality
	@Test()
	public void rawItemActivity_US1893_TC3646_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1893_TC3646_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Frequency_DD.getAttribute("disabled").equals("true")
				& rawItemActivityPage.RawItemInformation_popUp_Submit_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 6 user should not be able to make any changes on raw item information page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 user should not be able to make any changes on raw item information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
