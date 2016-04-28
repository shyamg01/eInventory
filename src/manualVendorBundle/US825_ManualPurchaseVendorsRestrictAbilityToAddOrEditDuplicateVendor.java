package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US825_ManualPurchaseVendorsRestrictAbilityToAddOrEditDuplicateVendor extends AbstractTest{
	
	/*TC1566:Verify that when a user creates a manual purchase vendor the system will not allow the user to enter and save a vendor name that is already utilized by an existing restaurant vendor (at the individual Restaurant).*/
	@Test()
	public void manualVendor_US825_TC1566() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		//CLick on Add New vendor button
		manualVendorsPage.AddVendor_BT.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Enter an existing vendor name
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.sendKeys(String.valueOf(Base.generateNdigitRandomNumber(3)));
		//Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor Name already exists error should be displayed 
		boolean duplicateVendorNotAdded =  Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		//Change the case of the vendor name
		String vendorNameInMixedCase = vendorName.substring(0,1).toUpperCase()+vendorName.substring(1,vendorName.length());
		//Enter the vendor name
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorNameInMixedCase);
		//Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor Name already exists error should be displayed 
		duplicateVendorNotAdded =  duplicateVendorNotAdded && Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		if(duplicateVendorNotAdded){
			Reporter.reportPassResult(
					browser,"manualVendor_US825_TC1566",
					"User should not be able to enter and save a vendor name that is already utilized by an existing restaurant vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US825_TC1566","manualVendor_US825_TC1566",
					"User should not be able to enter and save a vendor name that is already utilized by an existing restaurant vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US825_TC1566");

		}
	}
	
	/*TC1567: Verify that when a user creates a manual purchase vendor the system will not allow the user to enter and 
	save a vendor number that is already utilized by an existing restaurant vendor.*/
	@Test()
	public void manualVendor_US825_TC1567() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		String newVendorName = "TestAuto"+Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
		System.out.println(" vendorNumber"+vendorNumber);
		//CLick on Add New vendor button
		manualVendorsPage.AddVendor_BT.click();
		//Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(newVendorName);
		//Enter an existing manual vendor number
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.sendKeys(vendorNumber);
		//Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that error message should displayed for duplicate vendor number
		boolean duplicateVendorNumberNotAdded = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message);
		if(duplicateVendorNumberNotAdded){
			Reporter.reportPassResult(
					browser,"manualVendor_US825_TC1567",
					"User should not be able to enter and save a vendor number that is already utilized by an existing restaurant vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US825_TC1567","manualVendor_US825_TC1567",
					"User should not be able to enter and save a vendor number that is already utilized by an existing restaurant vendor.",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US825_TC1567");

		}
	}
	
	/*TC1568: Verify that when a user enters a manual purchase vendor name or number that is already being utilized by an 
	existing vendor, it should display error messages in both the cases asking to enter new vendor name  and number.*/
	@Test()
	public void manualVendor_US825_TC1568() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		Thread.sleep(5000);
		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
		System.out.println("vendorNumber"+vendorNumber);
		//CLick on Add New vendor button
		manualVendorsPage.AddVendor_BT.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Enter an existing vendor name
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
				//Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNameNotAdded = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		System.out.println("duplicateNameNotAdded "+duplicateNameNotAdded);
		Thread.sleep(4000);
		//Enter an existing vendor manual number
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.sendKeys(vendorNumber);
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		boolean duplicateNumberNotAdded = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message);
		System.out.println("duplicateNumberNotAdded "+duplicateNumberNotAdded);
		if (duplicateNameNotAdded & duplicateNumberNotAdded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US825_TC1568",
					"User should not be able to enter and save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US825_TC1568","manualVendor_US825_TC1568",
					"User should not be able to enter and save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US825_TC1568");
		}
	}
	
	/*TC1569: Verify that when an user enters a manual purchase vendor name and number that is already
	  being utilized by an existing vendor, none of the invalid data will be saved.*/
	@Test()
	public void manualVendor_US825_TC1569() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Get the number of vendors
		int vendorListSize = manualVendorsPage.VendorInfo_List.size();
		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		String vendorNumber = manualVendorsPage.vendorNumber_List.get(0).getText();
		//CLick on Add vendor button
		manualVendorsPage.AddVendor_BT.click();
		//Enter an existing vendor name
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
		//Enter an existing vendor name
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.clear();
		manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
		//Click on Save vendor button
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		boolean duplicateNameNotAdded = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		System.out.println("duplicateNameNotAdded "+duplicateNameNotAdded);
		Thread.sleep(4000);
		//Enter an existing vendor manual number
		manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.sendKeys(vendorNumber);
		manualVendorsPage.AddvendorDetailsPopUp_SaveVendor_BT.click();
		boolean duplicateNumberNotAdded = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message);
		System.out.println("duplicateNumberNotAdded "+duplicateNumberNotAdded);
		//click on Close button
		manualVendorsPage.AddvendorDetailsPopUp_Close_BT.click();
		Thread.sleep(1000);
		//Verify that duplicated vendor should not be added
		boolean duplicateVendorNotAdded = (vendorListSize == manualVendorsPage.VendorInfo_List.size());
		if (duplicateNameNotAdded && duplicateNumberNotAdded && duplicateVendorNotAdded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US825_TC1569",
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US825_TC1569","manualVendor_US825_TC1569",
					"User should not be able to save a manual purchase vendor name or number that is already being utilized by an existing vendor",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US825_TC1569");
		}
	}
	
	 /* TC1577 : Verify that when an user edits an existing vendor name/number or
	  both, it should display error message/messages and none of the invalid data will be saved.*/
	@Test()
	public void manualVendor_US825_TC1577() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/*//HSSFSheet manualVendorPageSheet = ReadTestData.getTestDataSheet("sprint8_US825_TC1577", "Object1");
		String vendor2Name= LoginTestData.vendorName1;//ReadTestData.getTestData(manualVendorPageSheet, "VendorName");
		String vendor2Number = LoginTestData.vendorNumber1;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor Page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Get number of vendors
		int vendorListSize = manualVendorsPage.VendorInfo_List.size();
		String vendorName = manualVendorsPage.vendorName_List.get(1).getText();
		String vendor2Name= manualVendorsPage.vendorName_List.get(0).getText();
		String vendor2Number = manualVendorsPage.vendorNumber_List.get(0).getText();
		//Click on a vendor Name
		manualVendorsPage.editVendor_BT(vendorName).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		//Enter an another existing vendor name
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(vendor2Name);
		//CLick on save vendor changes button
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor name already exists error should be displayed
		boolean duplicateVendorErrorDisplayed = Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		//click on cancel button
		manualVendorsPage.EditvendorDetailsPopUp_Close_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Click on a vendor Name
		manualVendorsPage.editVendor_BT(vendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		//Enter an another existing vendor manual number
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.sendKeys(vendor2Number);
		//CLick on save vendor changes button
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor manual number already exists error should be displayed
		duplicateVendorErrorDisplayed = duplicateVendorErrorDisplayed && Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message);
		//click on cancel button
		manualVendorsPage.EditvendorDetailsPopUp_Close_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Click on a vendor Name
		manualVendorsPage.editVendor_BT(vendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB));
		//Enter an another existing vendor name
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorName_TB.sendKeys(vendor2Name);
		//Enter an another existing vendor manual number
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.clear();
		manualVendorsPage.EditvendorDetailsPopUp_VendorNumber_TB.sendKeys(vendor2Number);
		//CLick on save vendor changes button
		manualVendorsPage.EditvendorDetailsPopUp_SaveVendor_BT.click();
		//verify that vendor name already exists error should be displayed and vendor manual number already exists error should be displayed
		duplicateVendorErrorDisplayed = duplicateVendorErrorDisplayed && Base.isElementDisplayed(manualVendorsPage.AddvendorDetailsPopUp_vendorAlreadyExists_Message);
		//click on cancel button
		manualVendorsPage.AddvendorDetailsPopUp_Close_BT.click();
		//Verify that duplicated vendor should not be added
		boolean duplicateVendorNotAdded = (vendorListSize == manualVendorsPage.VendorInfo_List.size());
		if (duplicateVendorErrorDisplayed && duplicateVendorNotAdded) {
			Reporter.reportPassResult(
					browser,"manualVendor_US825_TC1577",
					"when an user edits an existing vendor name/number or both, it should display error message/messages and none of the invalid data will be saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US825_TC1577","manualVendor_US825_TC1577",
					"when an user edits an existing vendor name/number or both, it should display error message/messages and none of the invalid data will be saved",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US825_TC1577");

		}
	}

}
