package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US825_ManualPurchaseVendorsRestrictAbilityToAddOrEditDuplicateVendor extends AbstractTest{
	
	/*TC1566:Verify that when a user creates a manual purchase vendor the system will not allow the user to enter and save a vendor name that is already utilized by an existing restaurant vendor (at the individual Restaurant).*/
	@Test()
	public void manualVendor_US825_TC1566() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC1566";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorName="abcd"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
//		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		//Enter an existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",String.valueOf(Base.generateNdigitRandomNumber(3)));
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		//Enter an existing vendor name
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",String.valueOf(Base.generateNdigitRandomNumber(3)));
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor Name already exists error should be displayed 
		boolean duplicateVendorNotAdded =  GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateVendorNotAdded"+duplicateVendorNotAdded);
		Thread.sleep(5000);
		//Change the case of the vendor name
		String vendorNameInMixedCase = vendorName.substring(0,1).toUpperCase()+vendorName.substring(1,vendorName.length());
		//Enter the vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorNameInMixedCase);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateVendorNotAdded1 =GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateVendorNotAdded1"+duplicateVendorNotAdded1);
		//verify that vendor Name already exists error should be displayed 
		boolean duplicateVendorNotAddedFinal =  duplicateVendorNotAdded && duplicateVendorNotAdded1;
		if(duplicateVendorNotAddedFinal){
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter and save a vendor name that is already utilized by an existing restaurant vendor",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to enter and save a vendor name that is already utilized by an existing restaurant vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			

		}
	}
	
	/*TC1567: Verify that when a user creates a manual purchase vendor the system will not allow the user to enter and 
	save a vendor number that is already utilized by an existing restaurant vendor.*/
	@Test()
	public void manualVendor_US825_TC1567() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC1567";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		String newVendorName = "TTestAuto"+Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
//		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",newVendorName);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that error message should displayed for duplicate vendor number
		boolean duplicateVendorNumberNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message");
		if(duplicateVendorNumberNotAdded){
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter and save a vendor number that is already utilized by an existing restaurant vendor.",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to enter and save a vendor number that is already utilized by an existing restaurant vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
			

		}
	}
	
	/*TC1568: Verify that when a user enters a manual purchase vendor name or number that is already being utilized by an 
	existing vendor, it should display error messages in both the cases asking to enter new vendor name  and number.*/
	@Test()
	public void manualVendor_US825_TC1568() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC1568";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		Thread.sleep(5000);
//		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
//		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
		System.out.println("vendorNumber"+vendorNumber);
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		//Enter an existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNameNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateNameNotAdded "+duplicateNameNotAdded);
		Thread.sleep(4000);
		//Enter an existing vendor manual number
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateNumberNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message");
		System.out.println("duplicateNumberNotAdded "+duplicateNumberNotAdded);
		if (duplicateNameNotAdded & duplicateNumberNotAdded) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter and save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to enter and save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC1569: Verify that when an user enters a manual purchase vendor name and number that is already
	  being utilized by an existing vendor, none of the invalid data will be saved.*/
	@Test()
	public void manualVendor_US825_TC1569() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC1569";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		/***********************************/

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		Thread.sleep(5000);
		int vendorListSize = manualVendorsPage.VendorInfo_List.size();
		System.out.println("vendorListSize"+vendorListSize);
//		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
//		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
//		System.out.println("vendorNumber"+vendorNumber);
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		//Enter an existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNameNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateNameNotAdded "+duplicateNameNotAdded);
		Thread.sleep(4000);
		//Enter an existing vendor manual number
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateNumberNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message");
		System.out.println("duplicateNumberNotAdded "+duplicateNumberNotAdded);
		//click on Close button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT,"AddvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(4000);
		//Verify that duplicated vendor should not be added
		boolean duplicateVendorNotAdded = (vendorListSize == manualVendorsPage.VendorInfo_List.size()-1);
		System.out.println("duplicateVendorNotAdded"+duplicateVendorNotAdded);
		if (duplicateNameNotAdded && duplicateNumberNotAdded && duplicateVendorNotAdded) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	 /* TC1577 : Verify that when an user edits an existing vendor name/number or
	  both, it should display error message/messages and none of the invalid data will be saved.*/
	@Test()
	public void manualVendor_US825_TC1577() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC1577";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		String vendorNumber_1=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName_1 = "TestAuto"+Base.generateNdigitRandomNumber(4);
		/*//HSSFSheet manualVendorPageSheet = ReadTestData.getTestDataSheet("sprint8_US825_TC1577", "Object1");
		String vendor2Name= LoginTestData.vendorName1;//ReadTestData.getTestData(manualVendorPageSheet, "VendorName");
		String vendor2Number = LoginTestData.vendorNumber1;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		/*//Get number of vendors
		int vendorListSize = manualVendorsPage.VendorInfo_List.size();*/
		//Create a Vendor
		manualVendorsPage.createANewVendor(vendorName, vendorNumber);
		//Create another Vendor
		manualVendorsPage.createANewVendor(vendorName_1, vendorNumber_1);
		System.out.println("vendorName "+vendorName+"vendorNumber "+vendorNumber);
		System.out.println("vendorName_1 "+vendorName_1+"vendorNumber_1 "+vendorNumber_1);
	/*	String vendorName = manualVendorsPage.vendorName_List.get(32).getText();
		String vendor2Name= manualVendorsPage.vendorName_List.get(33).getText();
		String vendor2Number = manualVendorsPage.vendorNumber_List.get(33).getText();
		System.out.println("vendorName "+vendorName);
		System.out.println("vendor2Name "+vendor2Name);
		System.out.println("vendor2Number "+vendor2Number);*/
		//Click on a vendor Name
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName),vendorName);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//Enter an another existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB",vendorName_1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed
		boolean duplicateVendorErrorDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		//click on cancel button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_Cancel_BT,"EditvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Click on a vendor Name
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName),vendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		//Enter an another existing vendor manual number
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",vendorNumber_1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor manual number already exists error should be displayed
		boolean duplicateVendorErrorDisplayed_1=GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message");
		//click on cancel button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_Cancel_BT,"EditvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Click on a vendor Name
		GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(vendorName),vendorName);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		//Enter an another existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",vendorName_1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//Enter an another existing vendor manual number
		GenericMethods.clearValueOfElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",vendorNumber_1);
		GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		//CLick on save vendor changes button
		GenericMethods.clickOnElement(manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateVendorErrorDisplayed_2=GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message,"manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message");
		//click on cancel button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_Close_BT,"AddvendorDetailsPopUp_Close_BT");
		//Verify that user should not be able to edit vendor name with the existing name
		if (duplicateVendorErrorDisplayed && duplicateVendorErrorDisplayed_1
				&& duplicateVendorErrorDisplayed_2) {
			Reporter.reportPassResult(
					browser,
					"when an user edits an existing vendor name/number or both, it should display error message/messages and none of the invalid data will be saved",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"when an user edits an existing vendor name/number or both, it should display error message/messages and none of the invalid data will be saved",
					"Fail");
			AbstractTest.takeSnapShot();
			

		}
	}

	/*TC2845: Verify that when an user enters a manual purchase vendor name and number that is already being
	 *  utilized by a manual invoice, none of the invalid data will be saved.*/
	@Test()
	public void manualVendor_US825_TC2845() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC2845";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		/***********************************/

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		Thread.sleep(5000);
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		int vendorListSize = manualVendorsPage.VendorInfo_List.size();
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		//Enter an existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNameNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAlreadyExists_Message,"AddvendorDetailsPopUp_vendorAlreadyExists_Message");
		System.out.println("duplicateNameNotAdded "+duplicateNameNotAdded);
		Thread.sleep(4000);
		//Enter an existing vendor manual number
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		boolean duplicateNumberNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message");
		System.out.println("duplicateNumberNotAdded "+duplicateNumberNotAdded);
		//click on Close button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT,"AddvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(4000);
		//Verify that duplicated vendor should not be added
		boolean duplicateVendorNotAdded = (vendorListSize == manualVendorsPage.VendorInfo_List.size());
		System.out.println("duplicateVendorNotAdded"+duplicateVendorNotAdded);
		if (duplicateNameNotAdded && duplicateNumberNotAdded && duplicateVendorNotAdded) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3912: Verify that user should not be able to add manual vendor with duplicate vendor number*/
	@Test()
	public void manualVendor_US825_TC3912() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US825_TC3912";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorNumber1=Integer.toString(Base.generateNdigitRandomNumber(4));
		String vendorName1 = "TestAuto"+Base.generateNdigitRandomNumber(4);
		String vendorName2 = "TestAuto"+Base.generateNdigitRandomNumber(4);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		Thread.sleep(5000);
		//CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName1);
		//Enter an existing manual vendor number
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber1);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG));
		Thread.sleep(4000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		//Enter an existing vendor name
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName2);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		vendorNumber1 = "0"+vendorNumber1;
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",vendorNumber1);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorDetails_Title,"AddVendorDetails_Title");
		//Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNumberNotAdded = GenericMethods.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message,"AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message");
		if (duplicateNumberNotAdded) {
			Reporter.reportPassResult(
					browser,
					"User should NOT be able to submit manual vendor and should be able to view the message for duplicate number",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should NOT be able to submit manual vendor and should be able to view the message for duplicate number",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
}
