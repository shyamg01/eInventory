package sprint8;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.ReadTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemInformationPage;
import eInventoryPageClasses.StoreLedgerDetailPage;

public class US826_ManualPurchaseVendorsAbilityToDeleteManualPurchaseVendor  extends AbstractTest {
	
	//TC1552: Verify that the user has an ability to delete a manual vendor on the manual purchase vendor edit page.
	@Test()
	public void sprint8_US826_TC1552() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String vendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(vendorName, "");
		// Click on the edit vendor button
		manualVendorsPage.editVendor_BT(vendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//Verify that user should be able to view the confirmation message
		boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(4000);
		//verify that operator is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1552",
					"User should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1552","sprint8_US826_TC1552",
					"User should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1552");
		}
	}
	
	//TC1553: Verify warning message while deleting a manual vendor from manual purchase vendor edit page.
	@Test()
	public void sprint8_US826_TC1553() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String vendorName = GlobalVariable.vendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Verify that delete vendor button for a vendor should be displayed
		manualVendorsPage.editVendor_BT(vendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//Verify that user should be able to view the confirmation message
		boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
		if (deleteVendorConfirmationDisplayed 
				& manualVendorsPage.DeleteVendorPopUp_Confirmation_Message.getText().contains("Are you sure you want to proceed?")) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1553",
					"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1553","sprint8_US826_TC1553",
					"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1553");
		}
	}
	
	// TC1554: Verify the option to proceed with cancel button while deleting manual vendor on manual purchase vendor landing page.
	@Test()
	public void sprint8_US826_TC1554() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		/***********************************/
		String newVendorName = "Testauto"+Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, "");
		// Click on the edit vendor button
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT)).click();
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName)) 
				& !Base.isElementDisplayed(manualVendorsPage.Delete_BT)) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1554",
					"User should be navigated back to manual purchase vendor landing page on clicking the cancel button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1554","sprint8_US826_TC1554",
					"User should be navigated back to manual purchase vendor landing page on clicking the cancel button",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1554");

		}
	}
	
	// TC1556: Verify the purchase history with the vendor name will stay in tact, after the vendor is deleted from manual purchase vendor edit page.
	@Test()
	public void sprint8_US826_TC1556() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		HSSFSheet rawItemInformationPageSheet = ReadTestData.getTestDataSheet("sprint8_US826_TC1556", "Object1");
		String wrinIDForNewVendor = ReadTestData.getTestData(rawItemInformationPageSheet, "WRINId");
		String itemQty="1";
		/***********************************/
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String invoiceId = Base.randomNumberFiveDigit();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, "");
		//Click on Menu Btn
		homePage.goBackToInventoryManagementMenu();
		//Associate a raw item with the new vendor
		//homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(wrinIDForNewVendor, newVendorName);
		//Click on Menu Btn
		homePage.goBackToInventoryManagementMenu();
		//Create a new manual purchase and post the purchase
		homePage.goToPurchaseLandingPage().goToManualInvoiceNewPage()
				.createAManualPurchaseForWrinID(wrinIDForNewVendor, newVendorName, itemQty,invoiceId).clickOnFinalizeButton().postTheManualPurchage();
		//Navigate to manual vendor page and delete the vendor
		Thread.sleep(2000); 
		//Click on Menu Btn
		homePage.Menu_DD_BT.click();
		homePage.goToManualVendorsPage().deleteVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_Close_BT));
		manualVendorsPage.DeleteVendorPopUp_Confirmation_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
		Thread.sleep(4000);
		//Verify vendor is deleted
		boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
		//Click on Menu Btn
		homePage.goBackToInventoryManagementMenu();
		//Navigate to purchase Landing page and get purchase history
		PurchasesPage purchasesPage = homePage.goToPurchaseLandingPage();
		purchasesPage.ViewHistory_BT.click();
		//Click on the posted purchase record that was created above
		purchasesPage.clickOnPostedPurchaseRecord(Base.returnTodayDate(), invoiceId);
		//Verify that deleted vendor name should displayed in the posted purchase
		boolean manualVendorDisplayed = Base.isElementDisplayed(purchasesPage.PostedPurchaseDetailPopUp_VendorName_Value);
		if ( vendorDeletedOnCLickingDeleteBtn && manualVendorDisplayed) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1556",
					"Purchase history with the vendor name should stay in tact, after the vendor is deleted from manual vendor page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1556","sprint8_US826_TC1556",
					"Purchase history with the vendor name should stay in tact, after the vendor is deleted from manual vendor page",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1556");
		}
	}
	
	// TC1561: Verify the raw item will not be designated as "manual purchase" once the manual vendor is deleted.
	@Test()
	public void sprint8_US826_TC1561() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		HSSFSheet rawItemInformationPageSheet = ReadTestData.getTestDataSheet("sprint8_US826_TC1561", "Object1");
		String wrinIDForNewVendor = ReadTestData.getTestData(rawItemInformationPageSheet, "WRINId");
		/***********************************/
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, "");
		// Associate a raw item with the new vendor
		homePage.goBackToInventoryManagementMenu();
		homePage.goToRawItemInformationPage().associateRawItemToVendor(wrinIDForNewVendor, newVendorName);
		// navigate to manual vendor page and delete the vendor
		homePage.goBackToInventoryManagementMenu();
		homePage.goToManualVendorsPage().deleteVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_Close_BT));
		manualVendorsPage.DeleteVendorPopUp_Confirmation_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
		Thread.sleep(4000);
		// Verify vendor is deleted
		boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
		// Navigate to Raw Item Info Page and search for the WRIN Id
		homePage.goBackToInventoryManagementMenu();
		RawItemInformationPage rawItemInformationPage = homePage.goToRawItemInformationPage().searchAndSelectWRINID(wrinIDForNewVendor);
		//Verify that manual purchase check box for the WRIN Id should be in selected state.
		boolean manualPurchaseChkBoxChecked = rawItemInformationPage.ManualPurchase_CB.getAttribute("checked").equals("true");
		if (vendorDeletedOnCLickingDeleteBtn && manualPurchaseChkBoxChecked) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1561",
					"User should be able to find the manual purchase check box in selected state.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1561","sprint8_US826_TC1561",
					"User should be able to find the manual purchase check box in selected state.",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1561");

		}
	}
	
	// TC1562: Verify once deleted, the vendor is not select-able from the Manual Purchase entry screen.
	@Test()
	public void sprint8_US826_TC1562() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		/***********************************/
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, "");
		//Navigate to Manual Invoice New page and verify that vendor name should be displayed in Manual Purchase entry Vendor Dropdown
		homePage.goBackToInventoryManagementMenu();
		boolean vendorDisplayed = homePage.goToPurchaseLandingPage()
				.goToManualInvoiceNewPage().verifyVendorDisplayed(newVendorName);
		//Navigate to manual vendor page and delete the vendor
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		homePage.goToManualVendorsPage().editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(4000);
		//Navigate to Manual Invoice New page and verify that vendor name should not be displayed in Manual Purchase entry Vendor Dropdown
		homePage.goBackToInventoryManagementMenu();
		boolean vendorDeletedFromManualPurchaseDD = homePage.goToPurchaseLandingPage()
				.goToManualInvoiceNewPage().verifyVendorDisplayed(newVendorName);
		if (vendorDisplayed && (!vendorDeletedFromManualPurchaseDD)) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1562",
					"Once vendor deleted user should not be able to select that vendor from the Manual Purchase entry screen",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1562","sprint8_US826_TC1562",
					"Once vendor deleted user should not be able to select that vendor from the Manual Purchase entry screen",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1562");
		}
	}
	
	// TC1697:Verify the vendor and any associated finalized manual purchases will still be view-able on the store's ledger page once the vendor is deleted.
	@Test()
	public void sprint8_US826_TC1697() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		String itemQty="1";
		HSSFSheet rawItemInformationPageSheet = ReadTestData.getTestDataSheet("sprint8_US826_TC1697", "Object1");
		String wrinIDForNewVendor = ReadTestData.getTestData(rawItemInformationPageSheet, "WRINId");
		/***********************************/
		String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		String invoiceId = Base.randomNumberFiveDigit();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, "");
		//Associate a raw item with the new vendor
		homePage.goBackToInventoryManagementMenu();
		homePage.goToRawItemInformationPage().associateRawItemToVendor(wrinIDForNewVendor, newVendorName);
		//Create a new manual purchase and post the purchase
		homePage.goBackToInventoryManagementMenu();
		homePage.goToPurchaseLandingPage().goToManualInvoiceNewPage()
						.createAManualPurchaseForWrinID(wrinIDForNewVendor, newVendorName, itemQty,invoiceId).clickOnFinalizeButton().postTheManualPurchage();
		//Navigate to manual vendor page and delete the vendor
		Thread.sleep(3000); 
		homePage.Menu_DD_BT.click();
		homePage.goToManualVendorsPage().deleteVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_Close_BT));
		manualVendorsPage.DeleteVendorPopUp_Confirmation_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
		Thread.sleep(3000);
		//Navigate to purchase Landing page and click on View Store Ledger Button
		homePage.goBackToInventoryManagementMenu();
		StoreLedgerDetailPage storeLedgerDetailPage = homePage.goToPurchaseLandingPage().clickOnViewStoreLedgerButton();
		// Verify that finalized manual purchases will still be view-able on the store's ledger page
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(newVendorName, Base.returnTodayDate(), invoiceId)) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC1697",
					"User should be able to view finalized manual purchases on the store's ledger page after deleting the vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC1697","sprint8_US826_TC1697",
					"User should be able to view finalized manual purchases on the store's ledger page after deleting the vendor",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC1697");

		}
	}

	//TC2841: Verify the option to proceed with  "delete"  while deleting manual vendor on manual purchase vendor landing page.
	@Test()
	public void sprint8_US826_TC2841() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String vendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(vendorName, "");
		// Click on the edit vendor button
		manualVendorsPage.editVendor_BT(vendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//Verify that user should be able to view the confirmation message
		boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(4000);
		//verify that operator is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
			Reporter.reportPassResult(
					browser,"sprint8_US826_TC2841",
					"User should be able to procees with delete button on manual purchase vendor page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint8_US826_TC2841","sprint8_US826_TC2841",
					"User should be able to procees with delete button on manual purchase vendor page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint8_US826_TC2841");
		}
	}
}
