package sprint2;


import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;

public class US178_EnterAManualPurachase extends AbstractTest{
	
	// TC393 :(Verify that User is able to access the purchase Landing Page in eProfitability application)
	@Test()
	public void Sprint2_US178_TC393() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		/* End-Variable Deceleration */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page and
		boolean result = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement()
				.goToPurchaseLandingPage().isPurchaseLandingPageLoaded();
		// verify that purchase landing page is loaded successfully.
		if (result) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC393",
					"Purchase Landing Page should be Loaded with all the required fields",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC393","Sprint2_US178_TC393",
					"Purchase Landing Page should be Loaded with all the required fields",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC393");
		}
	}
	
	//TC394 :Verify that user is able to view the Approve Pending Purchases list on Purchases landing page
	@Test()
	public void Sprint2_US178_TC394() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		/* End-Variable Deceleration */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page and
		PurchasesPage purchasesPage = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement()
				.goToPurchaseLandingPage();
		purchasesPage.ApprovePending_BT.click();
		// verify that purchase landing page is loaded successfully.
		if (purchasesPage.PendingPurchase_List.size()>0) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC394",
					"User should be able to view the list of invoices that needs approval",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC394","Sprint2_US178_TC394",
					"User should be able to view the list of invoices that needs approval",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC394");
		}
	}
		
	//TC398 Verify that user is able to enter a new Manual Purchase from Purchase landing page
	@Test()
	public void Sprint2_US178_TC398() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/* Start-Variable Deceleration */
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		//HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC398", "Object1");
		String wrinId1 = GlobalVariable.createPurchaseWrin;
		String wrinId2 = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "2";
		String invoiceNumber = Base.randomNumberFiveDigit();
		/* End-Variable Deceleration */
		PurchasesPage purchasePage;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Purchase landing page
		purchasePage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//create a new manual invoice with 2 wrin Id
		purchasePage.goToManualInvoiceNewPage()
				.createAManualPurchaseForTwoWrinID(wrinId1, wrinId2, vendor,quantity, invoiceNumber);
		//Click on Menu Btn
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		//Verify that manual invoice should ne present in approve pending list
		if (purchasePage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC398",
					"Added Manual Invoice should be updated in Purchase Landing Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC398","Sprint2_US178_TC398",
					"Added Manual Invoice should be updated in Purchase Landing Page",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC398");
		}
	}
	
	//TC401 : Verify that user is able to remove  a raw item from the newly created manual Purchase 
	@Test()
	public void Sprint2_US178_TC401() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		//HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC401", "Object1");
		String wrinId = GlobalVariable.createPurchaseWrin;
		String vendor = GlobalVariable.vendorName;
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		/* End-Variable Deceleration */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage().goToManualInvoiceNewPage();
		manualInvoiceNewPage.selectAVendorFromDropdown(vendor).searchAndSelectARawItem(wrinId);
		manualInvoiceNewPage.removeWrinFromPurchaseList(wrinId);
		if (Base.isElementDisplayed(manualInvoiceNewPage.NoSearchResultFound_MSG)) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC401",
					"On clicking Remove button Item should be removed from the list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC401","Sprint2_US178_TC401",
					"On clicking Remove button Item should be removed from the list",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC401");
		}
	}
	
	//TC402 Verify that user is able to delete the manual purchase from the ''Pending Purchase: Manual Purchase detail screen'.
	@Test()
	public void Sprint2_US178_TC402() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException{
		/* Start-Variable Deceleration */
		//HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC402", "Object1");
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "3";
		String invoiceId = Base.randomNumberFiveDigit();
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		/* End-Variable Deceleration */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page and click on a CreateManualInvoice Button
		ManualInvoiceNewPage manualInvoiceNewPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage().goToManualInvoiceNewPage();
		// Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor, quantity, invoiceId);
		// Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		// Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		// click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		// Verify that manual purchase should be deleted from the purchase page
		if (!manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId)) {
			Reporter.reportPassResult(
					browser, "Sprint2_US178_TC402",
					"User is able to delete the manual purchase.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "Sprint2_US178_TC402","Sprint2_US178_TC402",
					"User is able to delete the manual purchase.", "Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC402");
		}
	}
	
	//TC403-Verify that user is able to close the manual purchase from the ''Approve Pending" Purchase list
	@Test()
	public void Sprint2_US178_TC403() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/* Start-Variable Deceleration */
		//HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC403", "Object1");
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "4";
		String invoiceId = Base.randomNumberFiveDigit();
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		/* End-Variable Deceleration */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Purchase landing page
		PurchasesPage purchasePage = homePage.selectUser(userId).selectLocation(storeId)
						.navigateToInventoryManagement().goToPurchaseLandingPage();
		// click on a CreateManualInvoice Button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasePage.goToManualInvoiceNewPage();
		// Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		// Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.elementToBeClickable(manualInvoiceNewPage.ManualInvoiceCancel_BT)).click();
		if (!Base.isElementDisplayed(manualInvoiceNewPage.Cancel_BT) & Base.isElementDisplayed(purchasePage.CreateManualInvoice_BT)) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC403",
					"After click on Cancel button page user should navigating back to the purchase landing page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC403","Sprint2_US178_TC403",
					"After click on Cancel button page user should navigating back to the purchase landing page",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC403");
		}
	}
	
/*	
 * Test cases not exist as per the new UI-Date(02/02/2016)
 * 
 * // TC397 Verify that user is able to view the 'UnPosted' Manual Purchase from purchase landing Page.
	@Test()
	public void Sprint2_US178_TC397() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		 Start-Variable Deceleration 
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		 End-Variable Deceleration 
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to purchase landing page then click on First available manual
		// invoice and verify that 'manual invoice edit' page is loaded
		ManualInvoiceEditPage manualInvoiceEditPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage().doubleClickOnFirstAvailableManualInvoice();
		Thread.sleep(4000);
		boolean result = manualInvoiceEditPage.isManualInvoiceEditPageIsLoaded();
		if (result) {
			Reporter.reportPassResult(
					browser,"Sprint2_US178_TC397",
					"Manual Invoice Edit Page should be Loaded with all the required fields",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint2_US178_TC397","Sprint2_US178_TC397",
					"Manual Invoice Edit Page  should be Loaded with all the required fields",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC397");
		}
	}

	 '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''' 
	// TC399 Verify that user is able to search a raw item from the list of raw
	// items on Pending Purchase: Manual Purchase detail screen
	@Test()
	public void Sprint2_US178_TC399() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		 Start-Variable Deceleration 
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC399", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,"EnterQuickSearchWithSuggestionsForManualPurchases");
		String vendor = ReadTestData.getTestData(manualInvoiceNewPageSheet,"Vendor");
		 End-Variable Deceleration 
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage()
				.goToManualInvoiceNewPage().selectAVendorFromDropdown(vendor).searchAndSelectARawItem(wrinId);
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[2]")).size() == 1) {
			Reporter.reportPassResult(browser, "Sprint2_US178_TC399",
					"User should be able to search and select a raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "Sprint2_US178_TC399",
					"Sprint2_US178_TC399",
					"User should be able to search and select a raw item",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC399");
		}
	}

	 '''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''' 
	// TC400 Verify that user is able to search a raw item from the manual
	// Purchase section on Pending Purchase: Manual Purchase detail screen
	@Test()
	public void Sprint2_US178_TC400() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		 Start-Variable Deceleration 
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint2_US178_TC400", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,"EnterQuickSearchWithSuggestionsForManualPurchases");
		String vendor = ReadTestData.getTestData(manualInvoiceNewPageSheet,"Vendor");
		HSSFSheet manualInvoiceNewPageSheet1 = ReadTestData.getTestDataSheet("Sprint2_US178_TC400", "Object2");
		String wrinId1 = ReadTestData.getTestData(manualInvoiceNewPageSheet1,"EnterQuickSearchWithSuggestionsForManualPurchases");
		 End-Variable Deceleration 
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNew = homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement()
				.goToPurchaseLandingPage().goToManualInvoiceNewPage().selectAVendorFromDropdown(vendor)
				.searchAndSelectARawItem(wrinId).searchAndSelectARawItem(wrinId1);
		manualInvoiceNew.Search_TB_02.sendKeys(wrinId);
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr")).size() == 1) {
			Reporter.reportPassResult(
					browser, "Sprint2_US178_TC400",
					"User should be able to search the selected raw item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "Sprint2_US178_TC400","Sprint2_US178_TC400",
					"User should be able to search the selected raw item",
					"Fail");
			AbstractTest.takeSnapShot("Sprint2_US178_TC400");
		}
	}*/
}
