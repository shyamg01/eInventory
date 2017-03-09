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
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US1380_UIUXRetrofitManualVendors extends AbstractTest{
	
	//TC2856: Verify, "Manual Vendors  Page is accessible from the Main Menu".
	@Test()
	public void manualVendor_US1380_TC2856() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2856";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.ManualVendors_Label));
		//Assert.assertEquals(GenericMethods.isElementDisplayed(manualVendorsPage.ManualVendors_Label), true,"Manual vendor Level is not displaying");
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")
				& GenericMethods.isElementDisplayed(manualVendorsPage.ManualVendors_Label,"ManualVendors_Label")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to access Manual Vendors Page from the Main Menu",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to access Manual Vendors Page from the Main Menu",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2857: Verify, "Header persists through the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2857() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2857";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (GenericMethods.isElementDisplayed(manualVendorsPage.ManualVendors_Label,"ManualVendors_Label")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Manual Vendors Page Header",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Manual Vendors Page Header",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2858: Verify "The Main Menu can be opened and closed from the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2858() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2858";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		//verify that Manual Vendors  Page is accessible from the Main Menu
		if (GenericMethods.isElementDisplayed(homePage.ManualVendors_BT,"ManualVendors_BT")){
			Reporter.reportPassResult(
					browser,
					"User should be able to open Main Menu from Manual Vendors Page","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to open Main Menu from Manual Vendors Page","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2859: Verify, "Users need to add manual vendors from the Manual Vendors Page".
	@Test()
	public void manualVendor_US1380_TC2859() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2859";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
		String alphanumericVendorName = "Testauto" + vendorNumber;
		String LeadingSpecialCharacterVendorName = "#";
		String spaceLeadingVendorName = " ";
		String specialCharacterVendorName = "a 12&%#";
		String specialCharacterVendorNumber = "#";
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)), "AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB, "AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB, "AddvendorDetailsPopUp_VendorName_TB", LeadingSpecialCharacterVendorName);
		boolean leadingSpecialCharactersVendorNameNotAllowed = manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText().equals("Value cannot have special character as a leading character");
		System.out.println(manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText());
		
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",spaceLeadingVendorName);
		boolean leadingSpaceVendorNameNotAllowed = manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText().equals("Value cannot have special character as a leading character");
		System.out.println(manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText());
		
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",specialCharacterVendorName);
		boolean specialCharactersVendorNameAllowed = !Base.isElementDisplayed(manualVendorsPage.InvalidVendorNameNumber_Error_Message);
		
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",alphanumericVendorName);
		boolean alphanumericVendorNameAllowed = !Base.isElementDisplayed(manualVendorsPage.InvalidVendorNameNumber_Error_Message);
		//verify that user is able to add new manual vendor
		if (leadingSpecialCharactersVendorNameNotAllowed & leadingSpaceVendorNameNotAllowed
				& specialCharactersVendorNameAllowed & alphanumericVendorNameAllowed) {
			Reporter.reportPassResult(
					browser,
					"User should be not able to enter special characters and space characters as leading characters for vendor name and allowed to enter alphanumeric value.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be not able to enter special characters and space characters as leading characters for vendor name and allowed to enter alphanumeric value.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",specialCharacterVendorNumber);
		boolean specialCharacterVendorNumberNotAllowed = manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText().equals("Values must be numeric with no decimals or you have entered a number larger than this field allows. (Example: 123)");
		System.out.println(manualVendorsPage.InvalidVendorNameNumber_Error_Message.getText());
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		boolean numericVendorNumberAllowed = !Base.isElementDisplayed(manualVendorsPage.InvalidVendorNameNumber_Error_Message);
		
		if (specialCharacterVendorNumberNotAllowed & numericVendorNumberAllowed) {
			Reporter.reportPassResult(
					browser,
					"User should be not able to enter special characters for vendor Number and allowed to enter numeric value.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be not able to enter special characters for vendor Number and allowed to enter numeric value.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		// Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that user is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(alphanumericVendorName),"alphanumericVendorName")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to add a manual vendor",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2860: Verify, "Manual Vendors Page provides a listing of Vendors".
	@Test()
	public void manualVendor_US1380_TC2860() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2860";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//verify that user is able to see the list of manual vendors
		if (manualVendorsPage.VendorInfo_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view list of manual vendors in Manual Vendors Page.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view list of manual vendors in Manual Vendors Page.","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2861: Verify,"Manual Vendors listings cascade down the page regardless of count".
	@Test()
	public void manualVendor_US1380_TC2861() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2861";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//verify that user is able to see the list of manual vendors
		if (manualVendorsPage.VendorInfo_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view list of manual vendors in Manual Vendors Page.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view list of manual vendors in Manual Vendors Page.","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2862: Verify,"The Form provides Cancel and Exit (X) options that a user can select to close the form".
	@Test()
	public void manualVendor_US1380_TC2862() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2862";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		// Click on cancel button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT)),"AddvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(2000);
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (!Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT)
				& GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close add manual vendor form on clicking Cancel button","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close add manual vendor form on clicking Cancel button","Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		// Click on Close(X) button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_Close_BT)),"AddvendorDetailsPopUp_Close_BT");
		Thread.sleep(2000);
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (!Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_Close_BT)
				& GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close add manual vendor form on clicking Close(X) button","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close add manual vendor form on clicking Close(X) button","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/* TC2863: Verify, "The Form can be collapsed and re-opened. When the form is collapsed and 
	 * the user scrolls the Manual Vendors Page, the form anchors to the browser and remains visible" */
	@Test()
	public void manualVendor_US1380_TC2863() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2863";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),vendor1);
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorForm_SliderToggle_BT,"EditVendorForm_SliderToggle_BT");
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView")	) {
			Reporter.reportPassResult(
					browser,
					"User should be able to collapse the details screen","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to collapse the details screen","Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorForm_SliderToggle_BT,"EditVendorForm_SliderToggle_BT");
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalExpandedView")	) {
			Reporter.reportPassResult(
					browser,
					"User should be able to expand the collapsed screen","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to expand the collapsed screen","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC2864: Verify,"A user can only have one 'Add New Vendor' form open at a time."
	@Test()
	public void manualVendor_US1380_TC2864() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2864";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		//Click on Add new Vendor button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		boolean isAddVendorButtonNotClickable;
		try {
			GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
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
					browser,
					"A user can only have one 'Add New Vendor' form open at a time.","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"A user can only have one 'Add New Vendor' form open at a time.","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	/* TC2865 : Verify, "If the form is already open and collapsed and the user attempts to create a new one,
	 *  the collapsed form will re-open. A new form will not be created." */
	@Test()
	public void manualVendor_US1380_TC2865() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2865";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		Thread.sleep(1000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorForm_SliderToggle_BT,"AddVendorForm_SliderToggle_BT");
		Thread.sleep(1000);
		//verify that user User should be able to close add manual vendor form on clicking Cancel button
		boolean addVendorFormCollapsed = manualVendorsPage.AddVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		System.out.println("addVendorFormCollapsed "+addVendorFormCollapsed);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		Thread.sleep(2000);
		boolean addVendorFormExpanded = manualVendorsPage.AddVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		System.out.println("addVendorFormExpanded "+addVendorFormExpanded);
		//manualVendorsPage.FormSliderToggle_BT
		//verify that User should be able to close add manual vendor form on clicking  Close(X) button
		if (addVendorFormCollapsed & addVendorFormExpanded) {
			Reporter.reportPassResult(
					browser,
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"If the form is already open and collapsed and the user attempts to create a new one,the collapsed form will re-open",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2866: Verify,"If the form is already open and not collapsed and the user attempts to create a new one,
	the form will remain open. A new form will not be created."*/	
	@Test()
	public void manualVendor_US1380_TC2866() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2866";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		//Click on Add new Vendor button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendorDetails_Title));
		boolean isAddVendorButtonNotClickable;
		try {
			GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
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
		if (isAddVendorButtonNotClickable & GenericMethods.isElementDisplayed(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title")) {
			Reporter.reportPassResult(
					browser,
					"If the form is already open and not collapsed and the user attempts to create a new one,the form will remain open",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"If the form is already open and not collapsed and the user attempts to create a new one,the form will remain open",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2867: Verify, "A Manual Vendor submission provides a confirmation to the user that anchors to
	the bottom of the Manual Vendors Page"*/	
	@Test()
	public void manualVendor_US1380_TC2867() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2867";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		//verify that operator is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),newVendorName)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation success message at the bottom of the Manual Vendors Page",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view confirmation success message at the bottom of the Manual Vendors Page",
					"Fail");
			AbstractTest.takeSnapShot();
			
			
		}
	}
	
	//TC2868: Verify, "The Vendor details Form provides Cancel and Exit (X) options that a user can select to close the form".
	@Test()
	public void manualVendor_US1380_TC2868() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2868";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),vendor1);
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT,"EditVendorDetailsPopUp_Cancel_BT");
		Thread.sleep(2000);
		//verify that operator is able to add new manual vendor
		if (!Base.isElementDisplayed(manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT) &
				GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close Edit Vendor details form on clicking Cancel Button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close Edit Vendor details form on clicking Cancel Button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),vendor1);
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_Close_BT,"EditvendorDetailsPopUp_Close_BT");
		//verify that operator is able to add new manual vendor
		if (!Base.isElementDisplayed(manualVendorsPage.EditvendorDetailsPopUp_Close_BT) &
				GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close Edit Vendor details form on clicking Close(X) Button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close Edit Vendor details form on clicking Close(X) Button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	/*TC2870: Verify,"The Form requires a Vendor Name and a Manual Number as input from the 
	user before a Vendor edit can be submitted".
*/	@Test()
	public void manualVendor_US1380_TC2870() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2870";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		WebElement vendor=manualVendorsPage.editVendor_BT(newVendorName);
		Thread.sleep(4000);
		GenericMethods.clickOnElement(vendor,newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		boolean errorMessageDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.EditvendorDetailsPopUp_EnterVendorName_Message,"EditvendorDetailsPopUp_EnterVendorName_Message");
		if (errorMessageDisplayed) {
			Reporter.reportPassResult(
					browser,
					"The Edit Vendor Form requires a Vendor Name before a Vendor edit can be submitted",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"The Edit Vendor Form requires a Vendor Name before a Vendor edit can be submitted",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_Close_BT,"EditvendorDetailsPopUp_Close_BT");
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		boolean editVendorChangesSaved = GenericMethods.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message,"EditvendorDetails_ChangesSaved_Message");
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetails_ChangesSaved_Message,"EditvendorDetails_ChangesSaved_Message");
		Thread.sleep(4000);
		System.out.println("Manual num "+manualVendorsPage.VendorNumber_Row(newVendorName).getText());
		if (editVendorChangesSaved & manualVendorsPage.VendorNumber_Row(newVendorName).getText().equals("")) {
			Reporter.reportPassResult(
					browser,
					"User is able to edit Vendor details with blank manual number",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to edit Vendor details with blank manual number",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		vendor=manualVendorsPage.editVendor_BT(newVendorName);
		GenericMethods.clickOnElement(vendor,newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		newVendorName = newVendorName +"Edit";
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		Thread.sleep(3000);
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",newVendorName);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetails_ChangesSaved_Message));
		//verify that user is able to add new manual vendor
		System.out.println("Manual num "+manualVendorsPage.VendorNumber_Row(newVendorName).getText());
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),newVendorName)
				& manualVendorsPage.VendorNumber_Row(newVendorName).getText().equals("")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to submit manual vendor details and navigated back to Manual vendor landing page with the updated values",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit manual vendor details and navigated back to Manual vendor landing page with the updated values",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	/*TC2871: Verify, "The Form can be collapsed and re-opened. When the form is collapsed and the user scrolls the Manual Vendors Page, 
	 the form anchors to the browser and remains visible."*/
	@Test()
	public void manualVendor_US1380_TC2871() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2871";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),"First Vendor Name");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorForm_SliderToggle_BT,"EditVendorForm_SliderToggle_BT");
		boolean editFormCollapsed = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		Actions actions = new Actions(driver);
		actions.moveToElement(manualVendorsPage.RestoreManualVendor_BT);
		// actions
		actions.perform();
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorForm_SliderToggle_BT,"EditVendorForm_SliderToggle_BT");
		boolean editFormExpanded = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalExpandedView");
		// verify that user is able to add new manual vendor
		if (editFormCollapsed & editFormExpanded) {
			Reporter.reportPassResult(
					browser,
					"User is able to scroll down to manual vendor page when Edit form is collapsed","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to scroll down to manual vendor page when Edit form is collapsed",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2872: Verify,"A user can only have one 'Vendor Detail' form open at a time".*/
	@Test()
	public void manualVendor_US1380_TC2872() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2872";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),"First Vendor Name");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		boolean isEditVendorButtonNotClickable;
		try {
			GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),"First Vendor Name");
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
					browser,
					"A user can only have one 'Vendor Detail' form open at a time","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"A user can only have one 'Vendor Detail' form open at a time",	"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2873: Verify," If the form is already open and whether it is open or collapsed, the user will not be able to edit another as the edits will not be selectable."*/
	@Test()
	public void manualVendor_US1380_TC2873() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2873";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		String vendor1 = manualVendorsPage.vendorName_List.get(0).getText();
		System.out.println("vendor1 "+vendor1);
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor1),vendor1);
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		Thread.sleep(2000);
		System.out.println("Value in Edit Form 1"+manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value"));
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorForm_SliderToggle_BT,"EditVendorForm_SliderToggle_BT");
		Thread.sleep(2000);
		boolean editFormCollapsed = manualVendorsPage.EditVendorForm_Container.getAttribute("class").contains("modalCollapsedView");
		String vendor2 = manualVendorsPage.vendorName_List.get(2).getText();
		System.out.println("vendor2 "+vendor2);
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor2),vendor2);
		System.out.println("Value in Edit Form 2 "+manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value"));
		if (editFormCollapsed & manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals(vendor1)) {
			Reporter.reportPassResult(
					browser,
					"A user can only have one 'Edit Vendor Detail' form open at a time","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"A user can only have one 'Edit Vendor Detail' form open at a time","Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_Close_BT,"EditvendorDetailsPopUp_Close_BT");
	}
	
	/*TC2874 :Verify,"The Form provides functionality to delete a vendor".*/
	@Test()
	public void manualVendor_US1380_TC2874() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2874";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		Thread.sleep(4000);
		//click on edit button for the vendor
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//click on submit button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		Thread.sleep(4000);
		//verify that operator is able to delete the manual vendor
		if (manualVendorsPage.verifyVendorDeleted(newVendorName)) {
			Reporter.reportPassResult(
					browser,
					"user is able to delete a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"user is able to delete a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC2875: Verify,"The Form prompts the user when a vendor has pending invoices and the delete option is selected.
	 The prompt instructs users to finalize all pending invoices before deleting a vendor."*/
	@Test()
	public void manualVendor_US1380_TC2875() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2875";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendor = GlobalVariable.purchaseVendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//click on edit button for the vendor
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendor),vendor);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//click on submit button
		//wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message));
		//verify that operator is able to delete the manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message,"DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message")) {
			Reporter.reportPassResult(
					browser,
					"When a vendor has pending invoices and the delete option is selected Form prompt instructs users to finalize all pending invoices before deleting a vendor",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"When a vendor has pending invoices and the delete option is selected Form prompt instructs users to finalize all pending invoices before deleting a vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(manualVendorsPage.DeletevendorDetailsConfirmationPopUp_OK_BT,"DeletevendorDetailsConfirmationPopUp_OK_BT");
	}

	/*TC2876 :Verify,"The Form prompts the user when a vendor has no pending invoices and the delete option is selected.
	 The prompt informs the user that the raw items associated with this vendor will need to be re-assigned to another 
	 manual vendor if they are manual purchase items. It prompts whether the user would like to proceed."*/
	@Test()
	public void manualVendor_US1380_TC2876() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2876";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message));
		String confirmationMsg = manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message.getText();
		System.out.println("confirmationMsg "+confirmationMsg);
		//verify that operator is able to delete the manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message,"DeletevendorDetailsPopUp_Confirmation_Message")
				& GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT,"DeleteVendorConfirmationPopUp_Yes_BT")
				& GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT,"DeleteVendorConfirmationPopUp_Yes_BT")) {
			Reporter.reportPassResult(
					browser,
					"The Form prompts the user about raw Item accociation when a vendor has no pending invoices and the delete option is selected.",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"The Form prompts the user about raw Item accociation when a vendor has no pending invoices and the delete option is selected.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2877 :Verify, "The popup of delete button provides 2 options on manual vendor details screen , Yes and No
	 * :Yes - Proceeds with Manual Vendor deletion and No - Returns the user back to the 'Vendor Detail' Form".*/
	@Test(groups="Smoke")
	public void manualVendor_US1380_TC2877() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2877";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message));
		GenericMethods.clickOnElement(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT,"DeleteVendorConfirmationPopUp_No_BT");
		boolean delectionCanceled = !Base.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT);
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.Delete_BT,"Delete_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		//verify that operator is able to delete the manual vendor
		if (delectionCanceled & GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message,"DeleteVendorPopUp_VendorDeleted_Message")) {
			Reporter.reportPassResult(
					browser,
					"While manual vendor deletion Yes Button - Proceeds with Manual Vendor deletion and No Button - Returns the user back to the 'Vendor Detail' Form",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"While manual vendor deletion Yes Button - Proceeds with Manual Vendor deletion and No Button - Returns the user back to the 'Vendor Detail' Form",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2878 : Verify,"A Manual Vendor submission provides a confirmation to the user that anchors to the bottom of 
	 the Manual Vendors Page"*/
	@Test()
	public void manualVendor_US1380_TC2878() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2878";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		// edit the vendor details with different vendor name
		newVendorName = newVendorName + "Edit";
		randomNum = randomNum +"0";
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(Keys.BACK_SPACE);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_EnterVendorName_Message)),"EditvendorDetailsPopUp_EnterVendorName_Message");
		Thread.sleep(3000);
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",newVendorName);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",randomNum);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		// Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		//verify that operator is able to delete the manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message,"EditvendorDetails_ChangesSaved_Message")) {
			Reporter.reportPassResult(
					browser,
					"User is able to see confirmation message while editing manual vendor details",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to see confirmation message while editing manual vendor details",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC2879: Verify,"The 'Restore Manual Vendor' Form adheres to the approved Interaction Framework and Visual Design".
	@Test()
	public void manualVendor_US1380_TC2879() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2879";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		// verify that operator is able to restore deleted manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_Title,"RestoreManualVendor_Title")
				& GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_VendorName_Header,"RestoreManualVendor_VendorName_Header")
				& GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_ManualNumber_Header,"RestoreManualVendor_ManualNumber_Header")
				& GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_SelectAll_Header,"RestoreManualVendor_SelectAll_Header")) {
			Reporter.reportPassResult(
					browser,
					"Verify table headings include: 'Select All', 'Vendor Name' and 'Manual Number'", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify table headings include: 'Select All', 'Vendor Name' and 'Manual Number'", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2880: Verify,"The Form provides a message informing users that deleted vendors are retained for up to 10 days".
	@Test()
	public void manualVendor_US1380_TC2880() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2880";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// verify that operator is able to restore deleted manual vendor
		if (manualVendorsPage.RestoreDeletedVendor_Disclaimer_Message.getText().contains("Deleted manual vendors are retained for up to 10 days.")) {
			Reporter.reportPassResult(
					browser,
					"Restore Manual Vendor Form provides a message informing users that deleted vendors are retained for up to 10 days", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Restore Manual Vendor Form provides a message informing users that deleted vendors are retained for up to 10 days", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2881: Verify,"The Form provides Cancel and Exit (X) options that a user can select to close the restore form".
	@Test()
	public void manualVendor_US1380_TC2881() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2881";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// Click on cancel button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT)),"RestoreVendorDetailsPopUp_Cancel_BT");
		Thread.sleep(2000);
		// verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT)
				& GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close restore manual vendor form on clicking Cancel button","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close Restore manual vendor form on clicking Cancel button","Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(2000);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		// Click on Close(X) button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreVendorDetailsPopUp_Close_BT)),"RestoreVendorDetailsPopUp_Close_BT");
		Thread.sleep(2000);
		// verify that User should be able to close Restore manual vendor form on clicking Close(X) button
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Close_BT)
				& GenericMethods.isElementDisplayed(manualVendorsPage.AddVendor_BT,"AddVendor_BT")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to close Restore manual vendor form on clicking Close(X) button","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close Restore manual vendor form on clicking Close(X) button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}


	/*TC2883: Verify,"A user can only have one 'Restore Manual Vendor' form open at a time."*/
	@Test()
	public void manualVendor_US1380_TC2883() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2883";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		boolean isRestoreVendorButtonNotClickable;
		try {
			GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_BT,"RestoreManualVendor_BT");
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
					browser,
					"A user can only have one 'Restore Manual Vendor' form open at a time.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"A user can only have one 'Restore Manual Vendor' form open at a time.",	"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	
	
	/*TC2885: Verify,"If the form is already open and not collapsed and the user attempts to create a new one,
	 *the form will remain open. A new form will not be created.*/
	@Test()
	public void manualVendor_US1380_TC2885() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2885";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		Thread.sleep(2000);
		boolean isRestoreVendorButtonNotClickable;
		try {
			GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_BT,"RestoreManualVendor_BT");
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
					browser,
					"A user can only have one 'Restore Manual Vendor' form open at a time.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"A user can only have one 'Restore Manual Vendor' form open at a time.",	"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2886: Verify," The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored"*/
	@Test()
	public void manualVendor_US1380_TC2886() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2886";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String manualNumber=Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(vendorName,manualNumber);
		Thread.sleep(4000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
		GenericMethods.clickOnElement(vendor,vendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message)),"DeleteVendorPopUp_VendorDeleted_Message");
		Thread.sleep(4000);
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		if (manualVendorsPage.DeletedVendorName_List.size()>0
				& manualVendorsPage.DeletedVendorNumber_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"The restore Form provides a list of available manual vendors (Vendor Name & Manual Number) that can be restored",	"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2887: Verify,"The restore manual vendor form allows the user to select one or more vendors from the list"*/
	@Test()
	public void manualVendor_US1380_TC2887() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2887";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First Deleted Vendor checkbox");
		System.out.println(manualVendorsPage.DeletedVendor_List.get(0).getAttribute("class"));
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(1),"second Deleted Vendor checkbox");
		System.out.println(manualVendorsPage.DeletedVendor_List.get(1).getAttribute("class"));
		if (manualVendorsPage.DeletedVendor_List.get(0).getAttribute("class").contains("selected")
				& manualVendorsPage.DeletedVendor_List.get(1).getAttribute("class").contains("selected")) {
			Reporter.reportPassResult(
					browser,
					"The restore manual vendor form allows the user to select one or more vendors from the list","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"The restore manual vendor form allows the user to select one or more vendors from the list","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2888: Verify,"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed".*/
	@Test()
	public void manualVendor_US1380_TC2888() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2888";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		if (manualVendorsPage.RestoreManualVendor_Restore_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,
					"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"The Form requires at least one Vendor Name/Manual Number selection before a restore is allowed","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2889: Verify,"The Form enables the restore button when at least one manual vendor is selected from the list".*/
	@Test()
	public void manualVendor_US1380_TC2889() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2889";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First Deleted Vendor");
		if (manualVendorsPage.RestoreManualVendor_Restore_BT.getAttribute("disabled") == null) {
			Reporter.reportPassResult(
					browser,
					"The Form enables the restore button when at least one manual vendor is selected from the list","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"The Form enables the restore button when at least one manual vendor is selected from the listt","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2891: Verify,"Selecting restore causes a popup prompting whether the user would like to proceed"*/
	@Test()
	public void manualVendor_US1380_TC2891() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2891";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First deleted vendor checkbox");
		GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_Restore_BT,"RestoreManualVendor_Restore_BT");
		if (GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_Yes_BT,"RestoreManualVendor_Yes_BT")
				& GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_No_BT,"RestoreManualVendor_No_BT")
				& manualVendorsPage.RestoreVendorPopUp_Confirmation_Message.getText().contains("Are you sure you want to restore this manual vendor?")) {
			Reporter.reportPassResult(
					browser,
					"Selecting restore causes a popup prompting whether the user would like to proceed with YES and NO buttons","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Selecting restore causes a popup prompting whether the user would like to proceed with YES and NO buttons","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2892: Verify that the deleted manual vendor should be restored once user click on "Yes"button.*/
	@Test(groups="Smoke")
	public void manualVendor_US1380_TC2892() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2892";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		String vendorName = manualVendorsPage.DeletedVendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First deleted vendor checkbox");
		GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_Restore_BT,"RestoreManualVendor_Restore_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Yes_BT)),"RestoreManualVendor_Yes_BT");
		Thread.sleep(2000);
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(vendorName),vendorName)) {
			Reporter.reportPassResult(
					browser,
					"Deleted manual vendor should be restored once user click on Yes button.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Deleted manual vendor should be restored once user click on Yes button.","Fail");
			AbstractTest.takeSnapShot();
			
		}
		if(manualVendorsPage.verifyVendorIsMovedFromRestoreVendorScreen(vendorName)){
			Reporter.reportPassResult(
					browser,
					"USer should not be able to view the restored vendor name in Restore Vendor screen",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"USer should not be able to view the restored vendor name in Restore Vendor screen",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2894: Verify that the user should return back to the 'Restore Manual Vendor' Form when clicks on "No" button.*/
	@Test()
	public void manualVendor_US1380_TC2894() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2894";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First deleted vendor checkbox");
		GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_Restore_BT,"RestoreManualVendor_Restore_BT");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_No_BT)),"RestoreManualVendor_No_BT");
		if (GenericMethods.isElementDisplayed(manualVendorsPage.RestoreVendorDetailsPopUp_Cancel_BT,"RestoreVendorDetailsPopUp_Cancel_BT")
				& manualVendorsPage.DeletedVendor_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"User should return back to the 'Restore Manual Vendor' Form when clicks on No button.","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should return back to the 'Restore Manual Vendor' Form when clicks on No button.","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC2898: Verify,"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page".*/
	@Test()
	public void manualVendor_US1380_TC2898() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC2898";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		String vendorName = manualVendorsPage.DeletedVendorName_List.get(0).getText();
		GenericMethods.clickOnElement(manualVendorsPage.DeletedVendorSelect_ChkBox_List.get(0),"First Deleted Vendor");
		GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_Restore_BT,"RestoreManualVendor_Restore_BT");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_No_BT)),"RestoreManualVendor_No_BT");
		if (!Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_No_BT)) {
			Reporter.reportPassResult(
					browser,
					"User Should not be able to restore the manual vendor on clicking No Button and should be back on Restore Manual Vendor Page","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User Should not be able to restore the manual vendor on clicking No Button and should be back on Restore Manual Vendor Page","Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.RestoreManualVendor_Restore_BT,"RestoreManualVendor_Restore_BT");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Yes_BT)),"RestoreManualVendor_Yes_BT");
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(vendorName),vendorName)) {
			Reporter.reportPassResult(
					browser,
					"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"A Manual Vendor restore provides a confirmation to the user that anchors to the bottom of the Manual Vendors Page","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3057: Verify that user should be restricted from duplicating the same vendor name*/
	@Test()
	public void manualVendor_US1380_TC3057() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1380_TC3057";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",newVendorName);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		// Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateVendorNameErrorDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateVendorNameErrorDisplayed "+duplicateVendorNameErrorDisplayed);
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_Close_BT,"AddvendorDetailsPopUp_Close_BT");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clickOnElement(manualVendorsPage.Delete_BT,"Delete_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
		Thread.sleep(5000);
		if(Base.isElementDisplayed(manualVendorsPage.BackToTop_BT))
			GenericMethods.clickOnElement(manualVendorsPage.BackToTop_BT,"BackToTop_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.AddVendor_BT)),"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",newVendorName);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		// Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateDeletedVendorNameErrorDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateDeletedVendorNameErrorDisplayed "+duplicateDeletedVendorNameErrorDisplayed);
		// Create a new vendor
		if (duplicateVendorNameErrorDisplayed & duplicateDeletedVendorNameErrorDisplayed) {
			Reporter.reportPassResult(
					browser,
					"Verify that user should be restricted from duplicating the same vendor name","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify that user should be restricted from duplicating the same vendor name","Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC4434: Verify submit feature of manual vendor screen*/
	@Test()
	public void manualVendor_US1380_TC4434() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1380_TC4434";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber1=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorNumber2=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		String vendorName1 = "TestAuto"+Base.generateNdigitRandomNumber(4);
		String vendorName2 = "TTestAuto"+Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(vendorName1, vendorNumber1);
		Thread.sleep(5000);
		// Create a new vendor
		manualVendorsPage.createANewVendor(vendorName2, vendorNumber2);
		Thread.sleep(5000);
		//Click on a vendor Name
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName1),vendorName1);
		vendorName1 = vendorName1 +"Edit";
		vendorNumber1 = vendorNumber1+"0";
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//Enter an another existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",vendorName1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//Enter an another existing vendor manual number
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",vendorNumber1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		if(Base.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message)
				& Base.isElementDisplayed(manualVendorsPage.VendorName_Row(vendorName1))){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit the details with success message",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit the details with success message",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(5000);
		//Click on a vendor Name
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName2), vendorName2);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		if(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals(vendorName2)
				& manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.getAttribute("value").equals(vendorNumber2)){
			Reporter.reportPassResult(
					browser,
					"User should view the details of manual vendor 2",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should view the details of manual vendor 2",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		vendorName2 = vendorName2 + "Edit";
		vendorNumber2 = vendorNumber2 + "0";
		Thread.sleep(1000);
		//Enter an another existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",vendorName2);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//Enter an another existing vendor manual number
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",vendorNumber2);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		if(Base.isElementDisplayed(manualVendorsPage.EditvendorDetails_ChangesSaved_Message)
						& Base.isElementDisplayed(manualVendorsPage.VendorName_Row(vendorName2))){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit the details with success message","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"User should be able to submit the details with success message",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
