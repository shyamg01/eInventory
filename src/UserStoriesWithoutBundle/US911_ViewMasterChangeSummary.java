package UserStoriesWithoutBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.AuditPage;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.RawItemActivityPage;

public class US911_ViewMasterChangeSummary extends AbstractTest{
	
	//TC4547 : Verify that the user is able to view audit log for manual vendor
	@Test()
	public void UserStoriesWithoutBundle_US911_TC4547() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US911_TC4547";
		ManualVendorsPage manualVendorsPage;
		AuditPage auditPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		String newVendorName = "TTestAuto"+Base.generateNdigitRandomNumber(4);
		String newVendorNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a Vendor
		manualVendorsPage.createANewVendor(vendorName, vendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName),vendorName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//Enter an another existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB",newVendorName);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//Enter an another existing vendor manual number
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",newVendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetails_ChangesSaved_Message));
		Thread.sleep(5000);
		auditPage = homePage.goToAuditPage();
		String eId = userId.substring(0,1).toUpperCase() + userId.substring(1, userId.length());
		System.out.println("eId "+ eId);
		if (auditPage.verifyManualVendorNameAuditDisplayed(eId, vendorName, newVendorName, date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for manual vendor name",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for manual vendor name",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (auditPage.verifyManualVendorNumberAuditDisplayed(eId, vendorNumber, newVendorNumber, date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for manual vendor Number",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for manual vendor Number",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
	
	//TC4547 : Verify that the user is able to view audit log for manual vendor
	@Test()
	public void UserStoriesWithoutBundle_US911_TC4548() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US911_TC4548";
		AuditPage auditPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActvityAuditWrin1;
		String date = GlobalVariable.createDate;
		String casePrice = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();
		Thread.sleep(5000);
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		String defaultListType = select.getFirstSelectedOption().getText();
		if(defaultListType.equals("Weekly") || defaultListType.equals("Daily")){
			select.selectByVisibleText("Monthly");
		}else{
			select.selectByVisibleText("Weekly");
		}
		String selectedListType = select.getFirstSelectedOption().getText();
		//Select McDonalds GL Account from "McDonalds GL Account drop down"
		Select select1 =new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		String glAccountValue1 = select1.getFirstSelectedOption().getAttribute("value");//rawitemactivitypage.RawItemInformation_popUp_GLAccount_Value.getAttribute("innerHTML");
		System.out.println("glAccountValue1 "+glAccountValue1);
		rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD.click();
		if(glAccountValue1.equals("7001001")|| glAccountValue1.equals("7030001")){
			select1.selectByValue("7420001");
		}else{
			select1.selectByValue("7001001");
		}
		String selectedAccount = select1.getFirstSelectedOption().getAttribute("value");
		//Select "XYZ" from primary vendor drop down
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Select select2 =new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		select2.selectByIndex(4);
		String selectedVendor = select2.getFirstSelectedOption().getText();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		auditPage = homePage.goToAuditPage();
		String eId = userId.substring(0,1).toUpperCase() + userId.substring(1, userId.length());
		if (auditPage.verifyRawItemInvoiceTypeAuditDisplayed(eId, "E", "M", date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for Invoice type in raw item information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for Invoice type in raw item information Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (auditPage.verifyRawItemFrequencyAuditDisplayed(eId, auditPage.getListType(defaultListType),auditPage.getListType(selectedListType), date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for List type in raw item information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for List type in raw item information Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (auditPage.verifyRawItemAccountPrimaryVendorAuditDisplayed(eId, "",selectedVendor, date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for Primary vendor in raw item information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for Primary vendor in raw item information Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (auditPage.verifyRawItemAccountNumberAuditDisplayed(eId, glAccountValue1,selectedAccount, date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view audit log for McDonalds GL Account in raw item information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view audit log for McDonalds GL Account in raw item information Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
	
	//TC4549 : Verify that the user is able to view audit log for comment on FOB page
	@Test(enabled=false)
	public void UserStoriesWithoutBundle_US911_TC4549() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US911_TC4549";
		AuditPage auditPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		FoodOverBasePage foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToFoodOverBasePage();
		String beforeValue = foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value");
		System.out.println("Before Value"+beforeValue);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		Thread.sleep(2000);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		foodOverBasePage.FoodOverBase_Label.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(5000);
		String afterValue = foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value");
		auditPage = homePage.goToAuditPage();
		String eId = userId.substring(0,1).toUpperCase() + userId.substring(1, userId.length());
		if (auditPage.verifyFOBCommentsAuditDisplayed(eId, beforeValue,afterValue, Base.returnTodayDate())){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the audit info for comment section on FOB page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the audit info for comment section on FOB page",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
}
