package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.StoreLedgerDetailPage;

public class US672_AbilityToCreateManualPurchaseVendors extends AbstractTest {
	
	// Verify the user is able to select "Manual vendors " option from inventory
	// drop down and move to "Manual Vendors" landing page.
	@Test(groups="Smoke")
	public void manualVendor_US672_TC1212() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		AbstractTest.tcName="manualVendor_US672_TC1212";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to purchase landing page and verify that it is redirected
		ManualVendorsPage manualVendorsPage= homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		if (GenericMethods.isElementDisplayed(manualVendorsPage.ManualVendors_Label,"ManualVendors_Label")) {
			Reporter.reportPassResult(browser,
					"User should be redirected to Manual Vendor page", "Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"User should be redirected to Manual Vendor page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	
	// Verify the user is able to enter vendor name while creating a manual vendor from manual vendors landing page.
	@Test(groups="Smoke")
	public void manualVendor_US672_TC1213() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		AbstractTest.tcName="manualVendor_US672_TC1213";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Manual vendors page and click on Add vendor button
		ManualVendorsPage manualVendorPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		// enter the vendor name in vendor name text box
		manualVendorPage.createANewVendor(newVendorName,randomNum);
		// verify the entered text
		if (GenericMethods.isElementDisplayed(manualVendorPage.VendorName_Row(newVendorName),newVendorName)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to submit manual vendor", "Pass");
			
		} else 
		{
			Reporter.reportTestFailure(
					browser,"User should be able to submit manual vendor", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	// Verify the impact on manual purchase detail screens once new manual purchase vendor is created.
	@Test()
	public void manualVendor_US672_TC1220() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		AbstractTest.tcName="manualVendor_US672_TC1220";
		String vendorName = null;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// go to Manual Vendor page and click on Add Vendor button
		ManualVendorsPage manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		// Go to purchase landing page and verify that vendor is present or not
		GenericMethods.clickOnElement(homePage.Menu_DD_BT,"Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)),"Purchases_BT");
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		int vendorNumber = purchasesPage.goToManualInvoiceNewPage().CreateManualInvoice_VendorName_List.size();
		for (int i = 0; i <= vendorNumber; i++) {
			if (manualInvoiceNewPage.CreateManualInvoice_VendorName_List.get(i).getText().equalsIgnoreCase(vendorName)) {
				Reporter.reportPassResult(
						browser,
						"Vendor name should display in vendor name drop down",
						"Pass");
				
				break;
			} else if (i == vendorNumber) {
				Reporter.reportTestFailure(
						browser,
						"Vendor name should display in vendor name drop down",
						"Fail");
				AbstractTest.takeSnapShot();
				
			} else {
				continue;
			}
		}
	}
	
	//TC1282: Verify that user is getting warning message while deleting any vendor which is associated with any Manual invoice.
	@Test()
	public void manualVendor_US672_TC1282() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US672_TC1282";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
		//Associate a raw item with the new vendor
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
		//Verify that deleted vendor name should displayed in the posted purchase
		if (GenericMethods.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG,"RawItemInformation_popUp_ChangesSaved_Confirmation_MSG")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to associate a raw item to manual purchase Vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to associate a raw item to manual purchase Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1297: Verify the impact on raw item information page once new manual purchase vendor is created.
	@Test()
	public void manualVendor_US672_TC1297() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US672_TC1297";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
		//Associate a raw item with the new vendor
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
		//Verify that deleted vendor name should displayed in the posted purchase
		if (GenericMethods.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG,"RawItemInformation_popUp_ChangesSaved_Confirmation_MSG")){
			Reporter.reportPassResult(
					browser,
					"User should be able to associate a raw item to manual purchase Vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to associate a raw item to manual purchase Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(4000);
		GenericMethods.clickOnElement(rawItemActivityPage.Information_BT,"Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		Select vendorDD = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		System.out.println(vendorDD.getFirstSelectedOption().getText());
		//Verify that deleted vendor name should displayed in the posted purchase
		if (vendorDD.getFirstSelectedOption().getText().equals(newVendorName)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view wrin X tagged to primary vendor=XYZ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view wrin X tagged to primary vendor=XYZ",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2840: Verify user is able to view manual vendor name on purchase store lodger screen
	@Test()
	public void manualVendor_US672_TC2840() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US672_TC2840";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
		String itemQty="1";
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
		//Associate a raw item with the new vendor
		homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
		//Create a new manual purchase and post the purchase
		PurchasesPage purchasesPage = homePage.goToPurchaseLandingPage();
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(newVendorName, invoiceId, wrinIDForNewVendor, itemQty, "10");
		Thread.sleep(4000);
		purchasesPage.approveAManualInvoice(invoiceId);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(purchasesPage.ViewLedger_BT,"ViewLedger_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(newVendorName, GlobalVariable.createDate, invoiceId)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the posted manual purchase associated to vendor 'abc'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the posted manual purchase associated to vendor 'abc'",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC4058:  Verify the user is able to enter and edit vendor name with AlphaNumSpecial character and manual
	number with numerical values while creating a manual vendor from manual vendors landing page*/
	@Test(groups="Smoke")
	public void manualVendor_US672_TC4058() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		AbstractTest.tcName="manualVendor_US672_TC4058";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName1 = "x#@$%" + randomNum;
		String newVendorName2 = "a@!~ak9" + randomNum;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Manual vendors page and click on Add vendor button
		ManualVendorsPage manualVendorPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		// enter the vendor name in vendor name text box
		manualVendorPage.createANewVendor(newVendorName1,randomNum);
		// verify the entered text
		if (GenericMethods.isElementDisplayed(manualVendorPage.VendorName_Row(newVendorName1),newVendorName1)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to add manual vendor with AlphaNumSpecial character", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to add manual vendor with AlphaNumSpecial character", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(manualVendorPage.editVendor_BT(newVendorName1),newVendorName1);
		wait.until(ExpectedConditions.visibilityOf(manualVendorPage.EditVendorDetails_Title));
		GenericMethods.clearValueOfElement(manualVendorPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorPage.EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",newVendorName2);
		GenericMethods.clickOnElement(manualVendorPage.EditVendorDetails_Title,"EditVendorDetails_Title");
		// Click on Save vendor button
		GenericMethods.clickOnElement(manualVendorPage.EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorPage.EditvendorDetails_ChangesSaved_Message));
		if (GenericMethods.isElementDisplayed(manualVendorPage.VendorName_Row(newVendorName2),newVendorName2)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to edit manual vendor with AlphaNumSpecial character", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to edit manual vendor with AlphaNumSpecial character", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
}

