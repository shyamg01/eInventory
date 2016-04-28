package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US1380_UIUXRetrofitManualVendors extends AbstractTest{
	
	//TC2856: Verify, "Manual Vendors  Page is accessible from the Main Menu".
	@Test()
	public void manualVendor_US1380_TC2856() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		/*String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;*/
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.ManualVendors_Label));
		Assert.assertEquals(Base.isElementDisplayed(manualVendorsPage.ManualVendors_Label), true,"Manual vendor Level is not displaying");
		Reporter.log("User is successfully redirected to the Manual Vendor page");
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)
				& Base.isElementDisplayed(manualVendorsPage.ManualVendors_Label)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2856",
					"User should be able to access Manual Vendors Page from the Main Menu",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2856","manualVendor_US1380_TC2856",
					"User should be able to access Manual Vendors Page from the Main Menu",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2856");
		}
	}
	
	//TC2857: Verify, "Header persists through the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2857() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (Base.isElementDisplayed(manualVendorsPage.ManualVendors_Label)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2857",
					"User should be able to view Manual Vendors Page Header",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2857","manualVendor_US1380_TC2857",
					"User should be able to view Manual Vendors Page Header",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2857");
		}
	}
	
	//TC2858: Verify "The Main Menu can be opened and closed from the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2858() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		homePage.Menu_DD_BT.click();
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (Base.isElementDisplayed(homePage.ManualVendors_BT)){
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2858",
					"User should be able to open Main Menu from Manual Vendors Page","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2858","manualVendor_US1380_TC2858",
					"User should be able to open Main Menu from Manual Vendors Page","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2858");
		}
	}
	
	//TC2859: Verify, "Users need to add manual vendors from the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2859() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		//verify that user is able to add new manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName))) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2859",
					"User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2859","manualVendor_US1380_TC2859",
					"User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2859");
		}
	}
	
	//TC2860: Verify, "Manual Vendors Page provides a listing of Vendors".
	@Test()
	public void manualVendor_US1380_TC2860() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//verify that user is able to see the list of manual vendors
		if (manualVendorsPage.VendorInfo_List.size()>0) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2860",
					"User should be able to view list of manual vendors in Manual Vendors Page.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2860","manualVendor_US1380_TC2860",
					"User should be able to view list of manual vendors in Manual Vendors Page.","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2860");
		}
	}
	
	//TC2861: Verify,"Manual Vendors listings cascade down the page regardless of count".
	@Test()
	public void manualVendor_US1380_TC2861() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//verify that user is able to see the list of manual vendors
		if (manualVendorsPage.VendorInfo_List.size()>0) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2861",
					"User should be able to view list of manual vendors in Manual Vendors Page.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2861","manualVendor_US1380_TC2861",
					"User should be able to view list of manual vendors in Manual Vendors Page.","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2861");
		}
	}
	
	//TC2862: Verify,"The Form provides Cancel and Exit (X) options that a user can select to close the form".
	@Test()
	public void manualVendor_US1380_TC2862() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)).click();
		// Click on cancel button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT)).click();
		Thread.sleep(2000);
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (!Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT)
				& Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2862",
					"User should be able to close add manual vendor form on clicking Cancel button","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2862_Condition1","manualVendor_US1380_TC2862",
					"User should be able to close add manual vendor form on clicking Cancel button","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2862_Condition1");
		}
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)).click();
		// Click on Close(X) button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_Close_BT)).click();
		Thread.sleep(2000);
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (!Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_Close_BT)
				& Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2862",
					"User should be able to close add manual vendor form on clicking Close(X) button","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2862_Condition2","manualVendor_US1380_TC2862",
					"User should be able to close add manual vendor form on clicking Close(X) button","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2862_Condition2");
		}
	}
	
	/* TC2863: Verify, "The Form can be collapsed and re-opened. When the form is collapsed and 
	 * the user scrolls the Manual Vendors Page, the form anchors to the browser and remains visible" */
	@Test()
	public void manualVendor_US1380_TC2863() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		manualVendorsPage.EditVendorForm_SliderToggle_BT.click();
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView")	) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2863",
					"User should be able to collapse the details screen","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2863_Condition1","manualVendor_US1380_TC2863",
					"User should be able to collapse the details screen","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2863_Condition1");
		}
		manualVendorsPage.EditVendorForm_SliderToggle_BT.click();
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalExpandedView")	) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2863",
					"User should be able to expand the collapsed screen","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2863_Condition2","manualVendor_US1380_TC2863",
					"User should be able to expand the collapsed screen","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2863_Condition2");
		}
	}

	//TC2864: Verify,"A user can only have one 'Add New Vendor' form open at a time."
	@Test()
	public void manualVendor_US1380_TC2864() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		//Click on Add new Vendor button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		boolean isAddVendorButtonNotClickable;
		try {
			manualVendorsPage.AddVendor_BT.click();
			if (manualVendorsPage.AddVendorModel_List.size() == 1)
				isAddVendorButtonNotClickable = true;
			else {
				isAddVendorButtonNotClickable = false;
			}
		} catch (Exception elementNotClickable) {
			System.out.println("Exception");
			elementNotClickable.printStackTrace();
			isAddVendorButtonNotClickable = true;
		}
		System.out.println("isAddVendorButtonNotClickable "+isAddVendorButtonNotClickable);
		//Verify that A user can only have one 'Add New Vendor' form open at a time.
		if (isAddVendorButtonNotClickable) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2864",
					"A user can only have one 'Add New Vendor' form open at a time.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2864","manualVendor_US1380_TC2864",
					"A user can only have one 'Add New Vendor' form open at a time.","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2864");
		}
	}

	/* TC2865 : Verify, "If the form is already open and collapsed and the user attempts to create a new one,
	 *  the collapsed form will re-open. A new form will not be created." */
	@Test()
	public void manualVendor_US1380_TC2865() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		Thread.sleep(1000);
		manualVendorsPage.AddVendorForm_SliderToggle_BT.click();
		Thread.sleep(1000);
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		boolean addVendorFormCollapsed = manualVendorsPage.AddVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		System.out.println("addVendorFormCollapsed "+addVendorFormCollapsed);
		manualVendorsPage.AddVendor_BT.click();
		Thread.sleep(2000);
		boolean addVendorFormExpanded = manualVendorsPage.AddVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		System.out.println("addVendorFormExpanded "+addVendorFormExpanded);
		//manualVendorsPage.FormSliderToggle_BT.click();
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (addVendorFormCollapsed & addVendorFormExpanded) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2865",
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2865","manualVendor_US1380_TC2865",
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2865");
		}
	}
	
	/*TC2866: Verify,"If the form is already open and not collapsed and the user attempts to create a new one,
	the form will remain open. A new form will not be created."*/	
	@Test()
	public void manualVendor_US1380_TC2866() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		//Click on Add new Vendor button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		boolean isAddVendorButtonNotClickable;
		try {
			manualVendorsPage.AddVendor_BT.click();
			if (manualVendorsPage.AddVendorModel_List.size() == 1)
				isAddVendorButtonNotClickable = true;
			else {
				isAddVendorButtonNotClickable = false;
			}
		} catch (WebDriverException elementNotClickable) {
			isAddVendorButtonNotClickable = true;
		}
		/*Verify,"If the form is already open and not collapsed and the user attempts to create a new one, 
		the form will remain open. A new form will not be created."*/
		if (isAddVendorButtonNotClickable & Base.isElementDisplayed(manualVendorsPage.AddVendorDetails_Title)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2866",
					"If the form is already open and not collapsed and the user attempts to create a new one,the form will remain open",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2866","manualVendor_US1380_TC2866",
					"If the form is already open and not collapsed and the user attempts to create a new one,the form will remain open",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2866");
		}
	}
	
	/*TC2867: Verify, "A Manual Vendor submission provides a confirmation to the user that anchors to
	the bottom of the Manual Vendors Page"*/	
	@Test()
	public void manualVendor_US1380_TC2867() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		//verify that operator is able to add new manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName))) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2867",
					"User should be able to view confirmation success message at the bottom of the Manual Vendors Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2867","manualVendor_US1380_TC2867",
					"User should be able to view confirmation success message at the bottom of the Manual Vendors Page",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2867");
		}
	}
	
	//TC2868: Verify, "The Vendor details Form provides Cancel and Exit (X) options that a user can select to close the form".
	@Test()
	public void manualVendor_US1380_TC2868() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT.click();
		//verify that operator is able to add new manual vendor
		if (!Base.isElementDisplayed(manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT) &
				Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2868",
					"User should be able to close Edit Vendor details form on clicking Cancel Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2868_Condition1","manualVendor_US1380_TC2868",
					"User should be able to close Edit Vendor details form on clicking Cancel Button",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2868_Condition1");
		}
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		manualVendorsPage.EditvendorDetailsPopUp_Close_BT.click();
		//verify that operator is able to add new manual vendor
		if (!Base.isElementDisplayed(manualVendorsPage.EditvendorDetailsPopUp_Close_BT) &
				Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2868",
					"User should be able to close Edit Vendor details form on clicking Close(X) Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2868_Condition2","manualVendor_US1380_TC2868",
					"User should be able to close Edit Vendor details form on clicking Close(X) Button",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2868_Condition2");
		}
	}

	/*TC2870: Verify,"The Form requires a Vendor Name and a Manual Number as input from the 
	user before a Vendor edit can be submitted".
*/	@Test()
	public void manualVendor_US1380_TC2870() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		WebElement vendor=manualVendorsPage.editVendor_BT(newVendorName);
		Thread.sleep(4000);
		vendor.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		boolean errorMessageDisplayed = Base.isElementDisplayed(manualVendorsPage.EditvendorDetailsPopUp_EnterVendorName_Message);
		if (errorMessageDisplayed) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2870",
					"The Edit Vendor Form requires a Vendor Name before a Vendor edit can be submitted",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2870_Condition1","manualVendor_US1380_TC2870",
					"The Edit Vendor Form requires a Vendor Name before a Vendor edit can be submitted",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2870_Condition1");
		}
		manualVendorsPage.EditvendorDetailsPopUp_Close_BT.click();
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		boolean editVendorChangesSaved = Base.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message);
		manualVendorsPage.EditvendorDetails_ChangesSaved_Message.click();
		Thread.sleep(4000);
		System.out.println("Manual num "+manualVendorsPage.VendorNumber_Row(newVendorName).getText());
		if (editVendorChangesSaved & manualVendorsPage.VendorNumber_Row(newVendorName).getText().equals("")) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2870",
					"User is able to edit Vendor details with blank manual number",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2870_Condition2","manualVendor_US1380_TC2870",
					"User is able to edit Vendor details with blank manual number",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2870_Condition2");
		}
		vendor=manualVendorsPage.editVendor_BT(newVendorName);
		vendor.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		newVendorName = newVendorName +"Edit";
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.clear();
		Thread.sleep(3000);
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(newVendorName);
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetails_ChangesSaved_Message));
		//verify that user is able to add new manual vendor
		System.out.println("Manual num "+manualVendorsPage.VendorNumber_Row(newVendorName).getText());
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName))
				& manualVendorsPage.VendorNumber_Row(newVendorName).getText().equals("")) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2870",
					"User should be able to submit manual vendor details and navigated back to Manual vendor landing page with the updated values",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2870_Condition3","manualVendor_US1380_TC2870",
					"User should be able to submit manual vendor details and navigated back to Manual vendor landing page with the updated values",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2870_Condition3");
		}
	}

	/*TC2871: Verify, "The Form can be collapsed and re-opened. When the form is collapsed and the user scrolls the Manual Vendors Page, 
	 the form anchors to the browser and remains visible."*/
	@Test()
	public void manualVendor_US1380_TC2871() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		manualVendorsPage.EditVendorForm_SliderToggle_BT.click();
		boolean editFormCollapsed = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		Actions actions = new Actions(driver);
		actions.moveToElement(manualVendorsPage.RestoreManualVendor_BT);
		// actions.click();
		actions.perform();
		manualVendorsPage.EditVendorForm_SliderToggle_BT.click();
		boolean editFormExpanded = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		// verify that user is able to add new manual vendor
		if (editFormCollapsed & editFormExpanded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2871",
					"User is able to scroll down to manual vendor page when Edit form is collapsed","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2871","manualVendor_US1380_TC2871",
					"User is able to scroll down to manual vendor page when Edit form is collapsed",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2871");
		}
	}
	
	/*TC2872: Verify,"A user can only have one 'Vendor Detail' form open at a time".*/
	@Test()
	public void manualVendor_US1380_TC2872() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		boolean isEditVendorButtonNotClickable;
		try {
			manualVendorsPage.editVendor_BT(vendor1).click();
			if (manualVendorsPage.AddVendorModel_List.size() == 1)
				isEditVendorButtonNotClickable = true;
			else {
				isEditVendorButtonNotClickable = false;
			}
		} catch (WebDriverException elementNotClickable) {
			isEditVendorButtonNotClickable = true;
		}
		// verify that user is able to add new manual vendor
		if (isEditVendorButtonNotClickable) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2872",
					"A user can only have one 'Vendor Detail' form open at a time","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2872","manualVendor_US1380_TC2872",
					"A user can only have one 'Vendor Detail' form open at a time",	"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2872");
		}
	}
	
	/*TC2873: Verify," If the form is already open and whether it is open or collapsed, the user will not be able to edit another as the edits will not be selectable."*/
	@Test()
	public void manualVendor_US1380_TC2873() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		manualVendorsPage.editVendor_BT(vendor1).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		System.out.println("edit value "+manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value"));
		manualVendorsPage.EditVendorForm_SliderToggle_BT.click();
		boolean editFormCollapsed = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		manualVendorsPage.clickEditButtonUsingJSExecuter(2);
		System.out.println("edit value2 "+manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value"));
		if (editFormCollapsed & manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals(vendor1)) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2873",
					"A user can only have one 'Edit Vendor Detail' form open at a time","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2873","manualVendor_US1380_TC2873",
					"A user can only have one 'Edit Vendor Detail' form open at a time","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2873");
		}
	}
	
	/*TC2874 :Verify,"The Form provides functionality to delete a vendor".*/
	@Test()
	public void manualVendor_US1380_TC2874() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		Thread.sleep(4000);
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(4000);
		//verify that operator is able to delete the manual vendor
		if (manualVendorsPage.verifyVendorDeleted(newVendorName)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2874",
					"user is able to delete a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2874","manualVendor_US1380_TC2874",
					"user is able to delete a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2874");
		}
	}
	
	/*TC2875: Verify,"The Form prompts the user when a vendor has pending invoices and the delete option is selected.
	 The prompt instructs users to finalize all pending invoices before deleting a vendor."*/
	@Test()
	public void manualVendor_US1380_TC2875() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendor = GlobalVariable.purchaseVendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(vendor).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message));
		String pendingInvoiceMsg = manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message.getText();
		String pendingInvoiceMsg1 = manualVendorsPage.DeleteVendorPopUp_Confirmation_Message.getText();
		System.out.println(pendingInvoiceMsg);
		System.out.println(pendingInvoiceMsg1);
		manualVendorsPage.DeletevendorDetailsConfirmationPopUp_OK_BT.click();
		//verify that operator is able to delete the manual vendor
		if (pendingInvoiceMsg.contains("This vendor still has pending invoices.")
				& pendingInvoiceMsg1.contains("Please finalize all invoices for this vendor before deleting.")) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2875",
					"When a vendor has pending invoices and the delete option is selected Form prompt instructs users to finalize all pending invoices before deleting a vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2875","manualVendor_US1380_TC2875",
					"When a vendor has pending invoices and the delete option is selected Form prompt instructs users to finalize all pending invoices before deleting a vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2875");
		}
	}

	/*TC2876 :Verify,"The Form prompts the user when a vendor has no pending invoices and the delete option is selected.
	 The prompt informs the user that the raw items associated with this vendor will need to be re-assigned to another 
	 manual vendor if they are manual purchase items. It prompts whether the user would like to proceed."*/
	@Test()
	public void manualVendor_US1380_TC2876() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message));
		String confirmationMsg = manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message.getText();
		System.out.println("confirmationMsg "+confirmationMsg);
		//verify that operator is able to delete the manual vendor
		if (confirmationMsg.contains("Deleting this vendor will move any Raw Items that were associated to this vendor to \"normal\" status. You must reassign these raw items to another manual vendor if they are manual purchase items.")
				& Base.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)
				& Base.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2876",
					"The Form prompts the user about raw Item accociation when a vendor has no pending invoices and the delete option is selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2876","manualVendor_US1380_TC2876",
					"The Form prompts the user about raw Item accociation when a vendor has no pending invoices and the delete option is selected.",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2876");
		}
	}
	
	/*TC2877 :Verify, "The popup of delete button provides 2 options on manual vendor details screen , Yes and No
	 * :Yes - Proceeds with Manual Vendor deletion and No - Returns the user back to the 'Vendor Detail' Form".*/
	@Test()
	public void manualVendor_US1380_TC2877() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message));
		manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT.click();
		boolean delectionCanceled = !Base.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT);
		Thread.sleep(2000);
		manualVendorsPage.Delete_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		//verify that operator is able to delete the manual vendor
		if (delectionCanceled & Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2877",
					"While manual vendor deletion Yes Button - Proceeds with Manual Vendor deletion and No Button - Returns the user back to the 'Vendor Detail' Form",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2877","manualVendor_US1380_TC2877",
					"While manual vendor deletion Yes Button - Proceeds with Manual Vendor deletion and No Button - Returns the user back to the 'Vendor Detail' Form",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2877");
		}
	}
	
	/*TC2878 : Verify,"A Manual Vendor submission provides a confirmation to the user that anchors to the bottom of 
	 the Manual Vendors Page"*/
	@Test()
	public void manualVendor_US1380_TC2878() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		// edit the vendor details with different vendor name
		newVendorName = newVendorName + "Edit";
		randomNum = randomNum +"0";
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_EnterVendorName_Message)).click();
		Thread.sleep(3000);
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(newVendorName);
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.sendKeys(randomNum);
		// Click on Save vendor button
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that operator is able to delete the manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2878",
					"User is able to see confirmation message while editing manual vendor details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2878","manualVendor_US1380_TC2878",
					"User is able to see confirmation message while editing manual vendor details",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2878");
		}
	}

	//TC2879: Verify,"The 'Restore Manual Vendor' Form adheres to the approved Interaction Framework and Visual Design".
	@Test()
	public void manualVendor_US1380_TC2879() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		// verify that operator is able to restore deleted manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_Title)) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2879",
					"User is able to see restore manual vendor form on clicking Restore Manual Vendor Button ", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2879","manualVendor_US1380_TC2879",
					"User is able to see restore manual vendor form on clicking Restore Manual Vendor Button", "Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2879");
		}
	}
	
	//TC2880: Verify,"The Form provides a message informing users that deleted vendors are retained for up to 10 days".
	@Test()
	public void manualVendor_US1380_TC2880() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// verify that operator is able to restore deleted manual vendor
		if (manualVendorsPage.RestoreDeletedVendor_Disclaimer_Message.getText().contains("Deleted manual vendors are retained for up to 10 days.")) {
			Reporter.reportPassResult(
					browser, "manualVendor_US1380_TC2880",
					"Restore Manual Vendor Form provides a message informing users that deleted vendors are retained for up to 10 days", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US1380_TC2880","manualVendor_US1380_TC2880",
					"Restore Manual Vendor Form provides a message informing users that deleted vendors are retained for up to 10 days", "Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2880");
		}
	}
	
	//TC2881: Verify,"The Form provides Cancel and Exit (X) options that a user can select to close the restore form".
	@Test()
	public void manualVendor_US1380_TC2881() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// Click on cancel button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT)).click();
		Thread.sleep(2000);
		// verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT)
				& Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2881",
					"User should be able to close restore manual vendor form on clicking Cancel button","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2881_Condition1","manualVendor_US1380_TC2881",
					"User should be able to close Restore manual vendor form on clicking Cancel button","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2881_Condition1");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		// Click on Close(X) button
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreVendorDetailsPopUp_Close_BT)).click();
		Thread.sleep(2000);
		// verify that User should be able to close Restore manual vendor form on clicking Close(X) button
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Close_BT)
				& Base.isElementDisplayed(manualVendorsPage.AddVendor_BT)) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2881",
					"User should be able to close Restore manual vendor form on clicking Close(X) button","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2881_Condition2","manualVendor_US1380_TC2881",
					"User should be able to close Restore manual vendor form on clicking Close(X) button",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2881_Condition2");
		}
	}

	/*TC2882: Verify,"The Form can be collapsed and re-opened. When the form is collapsed and the user scrolls the
	 *Manual Vendors Page, the form anchors to the browser and remains visible."*/
	@Test()
	public void manualVendor_US1380_TC2882() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		manualVendorsPage.RestoreVendorForm_SliderToggle_BT.click();
		boolean restoreVendorFormCollapsed = manualVendorsPage.RestoreVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		Actions actions = new Actions(driver);
		actions.moveToElement(manualVendorsPage.AddVendor_BT);
		// actions.click();
		actions.perform();
		manualVendorsPage.RestoreVendorForm_SliderToggle_BT.click();
		boolean restoreVendorFormExpanded = manualVendorsPage.RestoreVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		// verify that user is able to add new manual vendor
		if (restoreVendorFormCollapsed & restoreVendorFormExpanded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2882",
					"User is able to scroll up down to manual vendor page when Restore manual Vendor form is collapsed","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2882","manualVendor_US1380_TC2882",
					"User is able to scroll up down to manual vendor page when Restore manual Vendor form is collapsed",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2882");
		}
	}
	
	/*TC2883: Verify,"A user can only have one 'Restore Manual Vendor' form open at a time."*/
	@Test()
	public void manualVendor_US1380_TC2883() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		boolean isRestoreVendorButtonNotClickable;
		try {
			manualVendorsPage.RestoreManualVendor_BT.click();
			if (manualVendorsPage.RestoreVendorModel_List.size() == 1)
				isRestoreVendorButtonNotClickable = true;
			else {
				isRestoreVendorButtonNotClickable = false;
			}
		} catch (WebDriverException elementNotClickable) {
			isRestoreVendorButtonNotClickable = true;
		}
		// verify that user is able to add new manual vendor
		if (isRestoreVendorButtonNotClickable) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2883",
					"A user can only have one 'Restore Manual Vendor' form open at a time.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2883","manualVendor_US1380_TC2883",
					"A user can only have one 'Restore Manual Vendor' form open at a time.",	"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2883");
		}
	}
	
	/*TC2884: Verify,"If the form is already open and collapsed and the user attempts to create a new one,
	  the collapsed form will re-open. A new form will not be created."*/
	@Test()
	public void manualVendor_US1380_TC2884() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		manualVendorsPage.RestoreVendorForm_SliderToggle_BT.click();
		boolean restoreVendorFormCollapsed = manualVendorsPage.RestoreVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		System.out.println("restoreVendorFormExpanded "+restoreVendorFormCollapsed);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		Thread.sleep(1000);
		boolean restoreVendorFormExpanded = manualVendorsPage.RestoreVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		System.out.println("restoreVendorFormExpanded "+restoreVendorFormExpanded);
		// verify that user is able to add new manual vendor
		if (restoreVendorFormCollapsed & restoreVendorFormExpanded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2884",
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2884","manualVendor_US1380_TC2884",
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2884");
		}
	}
	
	/*TC2885: Verify,"If the form is already open and not collapsed and the user attempts to create a new one,
	 *the form will remain open. A new form will not be created.*/
	@Test()
	public void manualVendor_US1380_TC2885() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		boolean isRestoreVendorButtonNotClickable;
		try {
			manualVendorsPage.RestoreManualVendor_BT.click();
			if (manualVendorsPage.RestoreVendorModel_List.size() == 1)
				isRestoreVendorButtonNotClickable = true;
			else {
				isRestoreVendorButtonNotClickable = false;
			}
		} catch (WebDriverException elementNotClickable) {
			isRestoreVendorButtonNotClickable = true;
		}
		// verify that user is able to add new manual vendor
		if (isRestoreVendorButtonNotClickable) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2885",
					"A user can only have one 'Restore Manual Vendor' form open at a time.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2885","manualVendor_US1380_TC2885",
					"A user can only have one 'Restore Manual Vendor' form open at a time.",	"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2885");
		}
	}
	
	/*TC2886: Verify," The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored"*/
	@Test()
	public void manualVendor_US1380_TC2886() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		if (manualVendorsPage.DeletedVendorName_List.size()>0
				& manualVendorsPage.DeletedVendorNumber_List.size()>0) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2886",
					"The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2886","manualVendor_US1380_TC2886",
					"The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored",	"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2886");
		}
	}
	
	/*TC2887: Verify,"The restore manual vendor form allows the user to select one or more vendors from the list"*/
	@Test()
	public void manualVendor_US1380_TC2887() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		System.out.println(manualVendorsPage.DeletedVendor_List.get(0).getAttribute("class"));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(1).click();
		System.out.println(manualVendorsPage.DeletedVendor_List.get(1).getAttribute("class"));
		if (manualVendorsPage.DeletedVendor_List.get(0).getAttribute("class").contains("selected")
				& manualVendorsPage.DeletedVendor_List.get(1).getAttribute("class").contains("selected")) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2887",
					"The restore manual vendor form allows the user to select one or more vendors from the list","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2887","manualVendor_US1380_TC2887",
					"The restore manual vendor form allows the user to select one or more vendors from the list","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2887");
		}
	}
	
	/*TC2888: Verify,"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed".*/
	@Test()
	public void manualVendor_US1380_TC2888() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = "5353";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		if (manualVendorsPage.RestoreManualVendor_Restore_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2888",
					"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2888","manualVendor_US1380_TC2888",
					"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2888");
		}
	}
	
	/*TC2889: Verify,"The Form enables the restore button when at least one manual vendor is selected from the list".*/
	@Test()
	public void manualVendor_US1380_TC2889() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		if (manualVendorsPage.RestoreManualVendor_Restore_BT.getAttribute("disabled") == null) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2889",
					"The Form enables the restore button when at least one manual vendor is selected from the list","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2889","manualVendor_US1380_TC2889",
					"The Form enables the restore button when at least one manual vendor is selected from the listt","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2889");
		}
	}
	
	/*TC2891: Verify,"Selecting restore causes a popup prompting whether the user would like to proceed"*/
	@Test()
	public void manualVendor_US1380_TC2891() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		manualVendorsPage.RestoreManualVendor_Restore_BT.click();
		if (Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_Yes_BT)
				& Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_No_BT)
				& manualVendorsPage.RestoreVendorPopUp_Confirmation_Message.getText().contains("Are you sure you want to restore this manual vendor?")) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2891",
					"Selecting restore causes a popup prompting whether the user would like to proceed with YES and NO buttons","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2891","manualVendor_US1380_TC2891",
					"Selecting restore causes a popup prompting whether the user would like to proceed with YES and NO buttons","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2891");
		}
	}
	
	/*TC2892: Verify that the deleted manual vendor should be restored once user click on "Yes"button.*/
	@Test()
	public void manualVendor_US1380_TC2892() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		String vendorName = manualVendorsPage.DeletedVendorName_List.get(0).getText();
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		manualVendorsPage.RestoreManualVendor_Restore_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Yes_BT)).click();
		Thread.sleep(2000);
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(vendorName))) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2892",
					"Deleted manual vendor should be restored once user click on Yes button.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2892","manualVendor_US1380_TC2892",
					"Deleted manual vendor should be restored once user click on Yes button.","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2892");
		}
	}
	
	/*TC2894: Verify that the user should return back to the 'Restore Manual Vendor' Form when clicks on "No" button.*/
	@Test()
	public void manualVendor_US1380_TC2894() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		manualVendorsPage.RestoreManualVendor_Restore_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_No_BT)).click();
		if (Base.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT)
				& manualVendorsPage.DeletedVendor_List.size()>0) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2894",
					"User should return back to the 'Restore Manual Vendor' Form when clicks on No button.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2894","manualVendor_US1380_TC2894",
					"User should return back to the 'Restore Manual Vendor' Form when clicks on No button.","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2894");
		}
	}
	
	/*TC2898: Verify,"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page".*/
	@Test()
	public void manualVendor_US1380_TC2898() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0).click();
		manualVendorsPage.RestoreManualVendor_Restore_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_No_BT)).click();
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_No_BT)) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2898",
					"User Should not be able to restore the manual vendor on clicking No Button and should be back on Restore Manual Vendor Page","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2898_Condition1","manualVendor_US1380_TC2898",
					"User Should not be able to restore the manual vendor on clicking No Button and should be back on Restore Manual Vendor Page","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2898_Condition1");
		}
		Thread.sleep(2000);
		manualVendorsPage.RestoreManualVendor_Restore_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Yes_BT)).click();
		if (Base.isElementDisplayed(manualVendorsPage.VendoreRestored_Message)) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC2898",
					"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC2898_Condition2","manualVendor_US1380_TC2898",
					"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC2898_Condition2");
		}
	}
	
	/*TC3057: Verify that user should be restricted from duplicating the same vendor name*/
	@Test()
	public void manualVendor_US1380_TC3057() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		Thread.sleep(5000);
		manualVendorsPage.AddVendor_BT.click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(newVendorName);
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.clear();
		// Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		boolean duplicateVendorNameErrorDisplayed = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		System.out.println("duplicateVendorNameErrorDisplayed "+duplicateVendorNameErrorDisplayed);
		manualVendorsPage.AddvendorDetailsPopUp_Close_BT.click();
		Thread.sleep(2000);
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		manualVendorsPage.Delete_BT.click();
		manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
		Thread.sleep(5000);
		if(Base.isElementDisplayed(manualVendorsPage.BackToTop_BT))
			manualVendorsPage.BackToTop_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.AddVendor_BT)).click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(newVendorName);
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.clear();
		// Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		boolean duplicateDeletedVendorNameErrorDisplayed = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		System.out.println("duplicateDeletedVendorNameErrorDisplayed "+duplicateDeletedVendorNameErrorDisplayed);
		// Create a new vendor
		if (duplicateVendorNameErrorDisplayed & duplicateDeletedVendorNameErrorDisplayed) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1380_TC3057",
					"Verify that user should be restricted from duplicating the same vendor name","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1380_TC3057","manualVendor_US1380_TC3057",
					"Verify that user should be restricted from duplicating the same vendor name","Fail");
			AbstractTest.takeSnapShot("manualVendor_US1380_TC3057");
		}
	}

}
