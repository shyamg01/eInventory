package sprint10;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.CustomRawItemListsPage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;

public class US1046_AbilityToRestoreDeletedInvoicesManualVendorsAndCustomLists
		extends AbstractTest {

	//TC1797: Verify the UI of the Restore Page on Purchases screen.
	@Test()
	public void sprint10_US1046_TC1797() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PurchasesPage purchasesPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Purchases Page
		purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// Click on Restore Purchase button
		wait.until(ExpectedConditions.elementToBeClickable(purchasesPage.RestorePurchases_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		// Verify that User should be able to view the restore purchase table header
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_InvoiceDate_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Invoice_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Vendor_Header)) {
			Reporter.reportPassResult(
					browser, "sprint10_US1046_TC1797",
					"User should be able to view the restore purchase table header","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint10_US1046_TC1797","sprint10_US1046_TC1797",
					"User should be able to view the restore purchase table header","Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1797");
		}
	}
	
	// TC1798: Verify that the user should be able to restore a deleted manual vendors from "manual vendors" page.
	@Test()
	public void sprint10_US1046_TC1798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// Verify that manual vendor should be restored and displayed in manual vendor page
		if (Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_VendorName_Header) 
				& Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_ManualNumber_Header)){
			Reporter.reportPassResult(
					browser,"sprint10_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint10_US1046_TC1798","sprint10_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1798");
		}
	}
	
	//TC1800:Verify that UI of the Restore Page on Custom Raw Item List screen.
	@Test()
	public void sprint10_US1046_TC1800() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String storeId = LoginTestData.StoreId;
		String userId = LoginTestData.userId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		wait.until(ExpectedConditions.elementToBeClickable(customRawItemListsPage.RestoreLists_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(customRawItemListsPage.DeletedCustomLists_Title));
		// Verify that manual vendor should be restored and displayed in manual vendor page
		if (Base.isElementDisplayed(customRawItemListsPage.RestoreCustomList_Name_Header) 
				& Base.isElementDisplayed(customRawItemListsPage.RestoreCustomList_Restore_Header)){
			Reporter.reportPassResult(
					browser,"sprint10_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint10_US1046_TC1798","sprint10_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1798");
		}
	}
	
	//TC1803 : Verify the visibility and restore functionality on Restore Manual Invoice Page.
	@Test()
	public void sprint10_US1046_TC1803() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "4";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//Click on create new invoice button 
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		//Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		//Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		//Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		//click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		boolean manualInvoiceDeleted = !(manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId));
		//click on restore purchases button
		purchasesPage.RestorePurchases_BT.click();
		//restore the manual invoice with the same invoice id
		purchasesPage.restoreDeletedPurchases(invoiceId);
		// Verify that manual invoice should be restored 
		if (manualInvoiceDeleted & manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint10_US1046_TC1803",
					"User should be able to restore purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint10_US1046_TC1803","sprint10_US1046_TC1803",
					"User should be able to restore purchase", "Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1803");
		}
	}	
	
	// TC1804: Verify the visibility and restore functionality on Restore Manual Vendor Page. 
	@Test()
	public void sprint10_US1046_TC1804() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		//click on edit button for the vendor
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT)).click();
		Thread.sleep(4000);
		manualVendorsPage.restoreManualVendor(newVendorName);
		// verify that operator is able to restore deleted manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName))) {
			Reporter.reportPassResult(
					browser,"sprint10_US1046_TC1804",
					"User should be able to view the manual vendor=x restored.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint10_US1046_TC1804","sprint10_US1046_TC1804",
					"User should be able to view the manual vendor=x restored.",
					"Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1804");
		}
	}
	
	//TC1806: Verify the visibility and restore functionality on Deleted Custom Item List Page. 
	@Test()
	public void sprint10_US1046_TC1806() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String rawItemListName = "Test" + Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		//Create a new list
		customRawItemListsPage.createACustomRawList(rawItemListName);
		//Delete the newly created list
		customRawItemListsPage.deleteCustomRawList(rawItemListName);
		Thread.sleep(4000);
		//restore the deleted list
		customRawItemListsPage.restoreCustomList(rawItemListName);
		Thread.sleep(2000);
		// Verify that custom list is restored and displayed in  "Custom Raw Item List " page.
		boolean customListRestored = customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName);
		if (customListRestored) {
			Reporter.reportPassResult(browser, "sprint10_US1046_TC1806",
					"User should be able to restore a deleted custom list  from 'Custom Raw Item List' page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint10_US1046_TC1806","sprint10_US1046_TC1806",
					"User should be able to restore a deleted custom list  from 'Custom Raw Item List' page",
					"Fail");
			AbstractTest.takeSnapShot("sprint10_US1046_TC1806");
		}
	}
	
	
}
