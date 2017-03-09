package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;

public class US1046_AbilityToRestoreDeletedInvoicesManualVendorsAndCustomLists
		extends AbstractTest {
	
	// TC1798: Verify that UI of the Restore Page on Manual Vendors screen..
	@Test()
	public void manualVendor_US1046_TC1798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1046_TC1798";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToManualVendorsPage();
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)), "RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// Verify that manual vendor should be restored and displayed in manual vendor page
		if (GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_VendorName_Header , "RestoreManualVendor_VendorName_Header")
				& GenericMethods.isElementDisplayed(manualVendorsPage.RestoreManualVendor_ManualNumber_Header,"RestoreManualVendor_ManualNumber_Header")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Restore Manual Vendor table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Restore Manual Vendor table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}


// TC1797: Verify that UI of the Restore Page on Purchases screen. 
	@Test()
	public void manualVendor_US1046_TC1797() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="manualVendor_US1046_TC1797";
		PurchasesPage purchasesPage;
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Purchases page
		purchasesPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestorePurchases_BT)), "RestorePurchases_BT");
		// verify that operator is able to restore deleted manual vendor
		if (GenericMethods.isElementDisplayed(purchasesPage.RestoreManualInvoice_InvoiceDate_Header,"RestoreManualInvoice_InvoiceDate_Header")
				& GenericMethods.isElementDisplayed(purchasesPage.RestoreManualInvoice_Invoice_Header,"RestoreManualInvoice_Invoice_Header")
				& GenericMethods.isElementDisplayed(purchasesPage.RestoreManualInvoice_Vendor_Header,"RestoreManualInvoice_Vendor_Header")
				& GenericMethods.isElementDisplayed(purchasesPage.RestoreManualInvoice_All_Header,"RestoreManualInvoice_All_Header")){
			Reporter.reportPassResult(
					browser,
					"System should display Restore Manual Invoice Page with below column: All, Invoice Date, Invoice, Vendor",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"System should display Restore Manual Invoice Page with below column: All, Invoice Date, Invoice, Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	

	
}
