package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.ApproveAdjustmentsPage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.ViewPurchaseHistoryPage;

public class US846_UIUXRetrofitPurchases extends AbstractTest{
	
	// TC3352 : UI/UX Retrofit - Purchases - Approve Pending: View
	@Test()
	public void purchasesBundle_US846_TC3352() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3352";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)) {
			Reporter.reportPassResult(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ApprovePendingTable_DeliveryDate_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Status_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Vendor_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Invoice_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_InvoiceTotal_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AmountOff_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AutoApprove_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Type_Header)) 
		{
			Reporter.reportPassResult(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int pendingPurchaseCount = purchasesPage.PendingPurchase_List.size();
		String countInTab = purchasesPage.ApprovePendingTab_Count.getText();
		purchasesPage.ApproveAdjustments_BT.click();
		Thread.sleep(2000);
		int pendingAdjustmentsCount = purchasesPage.PendingAdjustments_List.size();
		String countInApproveAdjustmentsTab = approveAdjustmentsPage.ApproveAdjustmentsTab_Count.getText();
		if (countInTab.equals(String.valueOf(pendingPurchaseCount))
				& countInApproveAdjustmentsTab.equals(String.valueOf(pendingAdjustmentsCount))) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Approve Pending' and 'Approve Adjustments' tabs include the number of pending invoices",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Approve Pending' and 'Approve Adjustments' tabs include the number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ApprovePending_BT.click();
		Thread.sleep(2000);
		System.out.println("Masg "+purchasesPage.RestorePurchases_Msg.getText());
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)
				& Base.isElementDisplayed(purchasesPage.MissingInvoice_Msg)) {
			Reporter.reportPassResult(
					browser,
					"restore message displays below table 'Oops, accidentally delete a manual invoice?' and includes a 'Restore Invoice' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"restore message displays below table 'Oops, accidentally delete a manual invoice?' and includes a 'Restore Invoice' button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (purchasesPage.verifyApproveButtonDisplayedForRecordsWithNeedsApprovalStatus()
				& purchasesPage.verifyViewButtonDisplayedForRecords()) {
			Reporter.reportPassResult(
					browser,
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button and each listing with Status != 'Needs Approval' has a 'View' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button and each listing with Status != 'Needs Approval' has a 'View' button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}
	
	// TC3353 : UI/UX Retrofit - Purchases - Approve Pending: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3353() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3353";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (purchasesPage.verifyDeliverDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	// TC3354 : UI/UX Retrofit - Purchases - Approve Pending: Sorting
	@Test()
	public void purchasesBundle_US846_TC3354() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3354";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		
		purchasesPage.ApprovePendingTable_DeliveryDate_Header.click();
		Thread.sleep(2000);
		boolean dateInAscendinOrder = purchasesPage.verifyDeliverDateInAscendingOrder();
		purchasesPage.ApprovePendingTable_DeliveryDate_Header.click();
		Thread.sleep(2000);
		boolean dateInDecendinOrder = purchasesPage.verifyDeliverDateInDescendingOrder();
		System.out.println("dateInAscendinOrder  "+dateInAscendinOrder );
		System.out.println("dateInDecendinOrder  "+dateInDecendinOrder );
		if (dateInAscendinOrder & dateInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending date",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending date",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		
		purchasesPage.ApprovePendingTable_Status_Header.click();
		Thread.sleep(2000);
		boolean statusInAscendinOrder = purchasesPage.verifyStatusInAscendingOrder();
		purchasesPage.ApprovePendingTable_Status_Header.click();
		Thread.sleep(2000);
		boolean statusInDecendinOrder = purchasesPage.verifyStatusInDescendingOrder();
		System.out.println("statusInAscendinOrder  "+statusInAscendinOrder );
		System.out.println("statusInDecendinOrder  "+statusInDecendinOrder );
		
		if (statusInAscendinOrder & statusInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Status",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Status",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_Vendor_Header.click();
		Thread.sleep(2000);
		boolean vendorInAscendinOrder = purchasesPage.verifyVendorInAscendingOrder();
		purchasesPage.ApprovePendingTable_Vendor_Header.click();
		Thread.sleep(2000);
		boolean vendorInDecendinOrder = purchasesPage.verifyVendorInDescendingOrder();
		System.out.println("vendorInAscendinOrder  "+vendorInAscendinOrder );
		System.out.println("vendorInDecendinOrder  "+vendorInDecendinOrder );
		
		if (vendorInAscendinOrder & vendorInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending vendor",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_Invoice_Header.click();
		Thread.sleep(2000);
		boolean invoiceInAscendinOrder = purchasesPage.verifyInvoiceInAscendingOrder();
		purchasesPage.ApprovePendingTable_Invoice_Header.click();
		Thread.sleep(2000);
		boolean invoiceInDecendinOrder = purchasesPage.verifyInvoiceInDescendingOrder();
		System.out.println("invoiceInAscendinOrder  "+invoiceInAscendinOrder );
		System.out.println("invoiceInDecendinOrder  "+invoiceInDecendinOrder );
		
		if (invoiceInAscendinOrder & invoiceInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Invoice",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_InvoiceTotal_Header.click();
		Thread.sleep(2000);
		boolean invoiceTotalInAscendinOrder = purchasesPage.verifyInvoiceTotalInAscendingOrder();
		purchasesPage.ApprovePendingTable_InvoiceTotal_Header.click();
		Thread.sleep(2000);
		boolean invoiceTotalInDecendinOrder = purchasesPage.verifyInvoiceTotalInDescendingOrder();
		System.out.println("invoiceTotalInAscendinOrder  "+invoiceTotalInAscendinOrder );
		System.out.println("invoiceTotalInDecendinOrder  "+invoiceTotalInDecendinOrder );
		
		if (invoiceTotalInAscendinOrder & invoiceTotalInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Invoice Total",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Invoice Total",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_AmountOff_Header.click();
		Thread.sleep(2000);
		boolean amountOffInAscendinOrder = purchasesPage.verifyAmountOffInAscendingOrder();
		purchasesPage.ApprovePendingTable_AmountOff_Header.click();
		Thread.sleep(2000);
		boolean amountOffInDecendinOrder = purchasesPage.verifyAmountOffInDescendingOrder();
		System.out.println("amountOffInAscendinOrder  "+amountOffInAscendinOrder );
		System.out.println("amountOffInDecendinOrder  "+amountOffInDecendinOrder );
		
		if (amountOffInAscendinOrder & amountOffInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending amount Off",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending amount Off",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_AutoApprove_Header.click();
		Thread.sleep(2000);
		boolean autoApproveInAscendinOrder = purchasesPage.verifyAutoApproveInAscendingOrder();
		purchasesPage.ApprovePendingTable_AutoApprove_Header.click();
		Thread.sleep(2000);
		boolean autoApproveInDecendinOrder = purchasesPage.verifyAutoApproveInDescendingOrder();
		System.out.println("autoApproveInAscendinOrder  "+autoApproveInAscendinOrder );
		System.out.println("autoApproveInDecendinOrder  "+autoApproveInDecendinOrder );
		
		if (autoApproveInAscendinOrder & autoApproveInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Auto Approve",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Auto Approve",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApprovePendingTable_Type_Header.click();
		Thread.sleep(2000);
		boolean typeInAscendinOrder = purchasesPage.verifyTypeInAscendingOrder();
		purchasesPage.ApprovePendingTable_Type_Header.click();
		Thread.sleep(2000);
		boolean typeInDecendinOrder = purchasesPage.verifyTypeInDescendingOrder();
		System.out.println("typeInAscendinOrder  "+typeInAscendinOrder );
		System.out.println("typeInDecendinOrder  "+typeInDecendinOrder );
		
		if (typeInAscendinOrder & typeInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Type",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Type",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3355 : UI/UX Retrofit - Purchases - Approve Pending: Notifications (Variance)
	@Test()
	public void purchasesBundle_US846_TC3355() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3355";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (purchasesPage.verifyNotificationDisplayedForExceedVariance()) {
			Reporter.reportPassResult(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3358 : UI/UX Retrofit - Purchases - Approve Pending: Approve Invoice (Electronic)
	@Test(enabled=false)
	public void purchasesBundle_US846_TC3358() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3358";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String productCategory = "";//GlobalVariable.pendingInvoiceId1_ProductCategory;
		String invoiceId = "";//GlobalVariable.pendingElectronicInvoiceId1;
		String date = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String backTime = "23:45";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		
		purchasesPage.clickOnApproveButtonForElectronicPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveElectronicInvoice_PopUp_Lable));
		System.out.println(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled"));
		if(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled").equals("true")
				& purchasesPage.verifyBackTimeIsSelected(backTime)){
			Reporter.reportPassResult(
					browser,
					"'Approve' is inactive until required fields are complete and time control allows user to arrow down to set the hour and minute.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Approve' is inactive until required fields are complete and time control allows user to arrow down to set the hour and minute.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.selectDateForApproveElectronicInvoice(date).selectTimeInApproveElectronicInvoiceForm(time);
		if(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled")== null){
			Reporter.reportPassResult(
					browser,
					"time control allows user to arrow down to set the hour and minute, User is able to select the date "
					+ "and 'Approve' is activates when time is selected", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"time control allows user to arrow down to set the hour and minute, User is able to select the date "
					+ "and 'Approve' is activates when time is selected", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApproveInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveInvoiceForm_Vendor_Label)
				& !purchasesPage.ApproveInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !purchasesPage.ApproveInvoiceForm_Invoice_Value.getText().isEmpty()
				& !purchasesPage.ApproveInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_WRIN_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_Description_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_CasePurchased_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_PricePerCase_Label)
				& Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_SubTotal_Label)) {
			Reporter.reportPassResult(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApproveInvoiceForm_GrandTotal_Label)
				& !purchasesPage.ApproveInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_BreakDownByCostType_Label)
				& !purchasesPage.getBreakDownCostForElectronicInvoice(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"totals by type are included below the table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify popup includes No and Yes buttons",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify popup includes No and Yes buttons",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT.click();
		if (!Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_Approve_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify user returns to modal on clicking No Button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify user returns to modal on clicking No Button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)).click();
		if (Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_PopUp_InvoiceApprove_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,
					"Verify confirmation message displays anchored to bottom of browser",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify confirmation message displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3359 : UI/UX Retrofit - Purchases - View History: View Approved Invoice (Electronic)
	@Test(enabled=false)
	public void purchasesBundle_US846_TC3359() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3359";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String productCategory = "";//GlobalVariable.approvedInvoiceId1_ProductCategory;
		String invoiceId = "";///GlobalVariable.approvedElectronicInvoiceId1;
		/*String date = GlobalVariable.createDate;*/
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ViewHistory_BT.click();
		Thread.sleep(2000);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD.click();
		viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(invoiceId);
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_ElectronicSource_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_CreatedBy_Label.getText().contains("Created By: System")) {
			Reporter.reportPassResult(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"totals by type are included below the table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3360 : UI/UX Retrofit - Purchases - Approve Pending: Approve Invoice (Manual)
	@Test()
	public void purchasesBundle_US846_TC3360() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3360";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		//String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		String userName = homePage.SelectedUserName_Label.getText();
		System.out.println("userName "+userName);
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ManualSource_Label)
				& purchasesPage.ManualInvoiceApprove_CreatedBy_Label.getText().toLowerCase().contains("created by: "+userName.toLowerCase()+" - "+userId)) {
			Reporter.reportPassResult(
					browser,
					"Verify modal title 'Purchases' Verify heading displays 'Source: Manual' Verify heading displays 'Created By: ' + UserName + '-' + UserID",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify modal title 'Purchases' Verify heading displays 'Source: Manual' Verify heading displays 'Created By: ' + UserName + '-' + UserID",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (purchasesPage.ManualInvoiceApprove_Vendor_Value.getText().equals(vendor)
				& purchasesPage.ManualInvoiceApprove_InvoiceNumber_Value.getText().equals(invoiceId)
				& purchasesPage.verifyRemoveWrinOptionIsNotPresent()) {
			Reporter.reportPassResult(
					browser,
					"Vendor, Invoice Number, Items fields are displayed and read-only and Date field is displayed and editable",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Vendor, Invoice Number, Items fields are displayed and read-only and Date field is displayed and editable",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		//purchasesPage.selectDateForApproveInvoice(date);
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Cancel_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_Approve_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_Delete_BT)) {
			Reporter.reportPassResult(
					browser,
					"Cancel, Delete and Approve buttons exist",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Cancel, Delete and Approve buttons exist",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_WRIN_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Description_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_CasePurchased_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_PricePerCase_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_SubTotal_Label)) {
			Reporter.reportPassResult(
					browser,
					"Verify columns included: WRIN, Description, UOM, Case, Quantity, Price Per Case and Sub-total",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify columns included: WRIN, Description, UOM, Case, Quantity, Price Per Case and Sub-total",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_BreakDownByCostType_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_TotalFood_Section)) {
			Reporter.reportPassResult(
					browser,
					"totals by type are included below the table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		//purchasesPage.selectTimeForApproveInvoice(GlobalVariable.time);
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		if (
				Base.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify popup includes No, Yes and X buttons",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify popup includes No, Yes and X buttons",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(purchasesPage.ApproveManualInvoice_Approve_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)).click();
		if (Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,
					"Verify confirmation message displays anchored to bottom of browser",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify confirmation message displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3361 : UI/UX Retrofit - Purchases - View History: View Approved Invoice (Manual)
	@Test()
	public void purchasesBundle_US846_TC3361() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3361";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.wrinID_Food;
		String productCategory = GlobalVariable.productCategoryFood;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String pricePerCase = "11.66";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		String userName = homePage.SelectedUserName_Label.getText();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		purchasesPage.approveAManualInvoice(invoiceId);
		purchasesPage.ViewHistory_BT.click();
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_Vendor_DD));
		viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD.click();
		viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(invoiceId);
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_ManualSource_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_CreatedBy_Label.getText().toLowerCase().contains("created by: "+userName.toLowerCase()+" - "+userId)){
			Reporter.reportPassResult(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"totals by type are included below the table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3362 : UI/UX Retrofit - Purchases - Approve Pending: View Pending Invoice w/Variance (Electronic)
	@Test(enabled=false)
	public void purchasesBundle_US846_TC3362() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3362";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String productCategory = "";//GlobalVariable.pendingInvoiceId2_ProductCategory;
		String invoiceId = "";//GlobalVariable.pendingElectronicInvoiceIdWithVarience;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = purchasesPage.clickOnViewButtonForElectronicPurchase(invoiceId);
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_ElectronicSource_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_CreatedBy_Label.getText().contains("Created By: System")) {
			Reporter.reportPassResult(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)
				& viewPurchaseHistoryPage.ViewInvoiceForm_purchaseDetail_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"totals by type are included below the table",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3363 : UI/UX Retrofit - Purchases - Approve Pending: Restore Deleted Invoices (Access): NO Deleted Invoice
	@Test()
	public void purchasesBundle_US846_TC3363_NoDeletedInvoice() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3363_NoDeletedInvoice";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.level1_11089_userId;
		String storeId2 = "11089";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		System.out.println("Msg "+purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg.getText());
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg)) {
			Reporter.reportPassResult(
					browser,
					"Verify message displays 'We don't have any invoices, deleted within the past 10 days, to show'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify message displays 'We don't have any invoices, deleted within the past 10 days, to show'",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cross_BT)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Close_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify only 'Close' and 'X' buttons exist",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify only 'Close' and 'X' buttons exist",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.RestoreManualInvoice_Cross_BT.click();
	}
	
	//TC3363 : UI/UX Retrofit - Purchases - Approve Pending: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3363() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3363";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		String pricePerCase = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		//purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		purchasesPage.deleteAManualInvoice(invoiceId);
		Thread.sleep(5000);
		Base.toReachbottomOfthePage();
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		System.out.println("Disclaimer Msg "+purchasesPage.RestoreManualInvoice_TimeDisclaimer_Msg.getText());
		System.out.println("Invoice Msg "+purchasesPage.RestoreManualInvoice_SelectInvoice_Msg.getText());
		if(Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_TimeDisclaimer_Msg)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_SelectInvoice_Msg)){
			Reporter.reportPassResult(
					browser,
					"message displays 'Deleted manual invoices are retained for up to 10 days' and "
					+ "'Select the invoices you want to restore", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"message displays 'Deleted manual invoices are retained for up to 10 days' and "
					+ "'Select the invoices you want to restore","Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_InvoiceDate_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Invoice_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Vendor_Header)
				&Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cross_BT)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cancel_BT)
				& purchasesPage.RestoreManualInvoice_Restore_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,
					"table header includes: Invoice Date, Invoice, Vendor.'Cancel' and 'X' buttons exist to exit and "
					+ "'Restore' button is inactive until at least one invoice is selected", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"table header includes: Invoice Date, Invoice, Vendor.'Cancel' and 'X' buttons exist to exit and"
					+ " 'Restore' button is inactive until at least one invoice is selected","Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if(purchasesPage.verifyDeletedInvoiceAreSelectable()){
			Reporter.reportPassResult(
					browser,
					"checkboxes for each invoice exist and allow user to select one or multiple", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"checkboxes for each invoice exist and allow user to select one or multiple","Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		purchasesPage.RestoreManualInvoice_SelectAll_CB.click();
		boolean recordsUnselected = true;
		for(WebElement invoice : purchasesPage.RestoreManualInvoice_DeletedInvoice_List){
			recordsUnselected = recordsUnselected & !invoice.getAttribute("class").contains("selected");
		}
		
		purchasesPage.RestoreManualInvoice_SelectAll_CB.click();
		boolean recordsSelected = true;
		for(WebElement invoice : purchasesPage.RestoreManualInvoice_DeletedInvoice_List){
			recordsSelected = recordsSelected & invoice.getAttribute("class").contains("selected");
		}
		if(recordsUnselected & recordsSelected 
				& purchasesPage.RestoreManualInvoice_Restore_BT.getAttribute("disabled") == null){
			Reporter.reportPassResult(
					browser,
					"Verify checkbox exists to select/de-select all invoices at once and 'Restore' button active when at least one invoice is selected", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify checkbox exists to select/de-select all invoices at once 'Restore' button active when at least one invoice is selected","Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.RestoreManualInvoice_SelectAll_CB.click();
		purchasesPage.RestoreManualInvoice_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.RestoreManualInvoice_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.RestoreManualInvoice_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.RestoreManualInvoice_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,
					"Model is collapsible and can be re-opened",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.restoreInvoice(invoiceId);
		if(Base.isElementDisplayed(purchasesPage.RestoredInvoiceAdded_Msg)){
			Reporter.reportPassResult(
					browser,
					"Restore confirmation displays anchored to bottom of browser",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Restore confirmation displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3365 : UI/UX Retrofit - Purchases - Approve Pending: No Pending Invoices
	@Test()
	public void purchasesBundle_US846_TC3365() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3365";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.level1_11078_userId;
		String storeId2 = "11078";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		String countInTab = purchasesPage.ApprovePendingTab_Count.getText();
		if (countInTab.equals("0")) {
			Reporter.reportPassResult(
					browser,
					"'Approve Pending' button displays '0' for number of pending invoices",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Approve Pending' button displays '0' for number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApprovePendingTable_NoPendingPurchases_Img)
				& purchasesPage.ApprovePendingTable_NoPendingPurchases_Msg.getText().contains("We don’t have any pending purchases to show")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)
				& Base.isElementDisplayed(purchasesPage.MissingInvoice_Msg)) {
			Reporter.reportPassResult(
					browser,
					"inventory icon displays with message 'We don't have any pending purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"inventory icon displays with message 'We don't have any pending purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3367 : UI/UX Retrofit - Purchases - Approve Adjustments: View
	@Test(enabled = false)
	public void purchasesBundle_US846_TC3367() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3367";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ApproveAdjustments_BT.click();
		int pendingAdjustmentsCount = purchasesPage.PendingAdjustments_List.size();
		String countInApproveAdjustmentsTab = approveAdjustmentsPage.ApproveAdjustmentsTab_Count.getText();
		
		if (Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)
				& countInApproveAdjustmentsTab.equals(String.valueOf(pendingAdjustmentsCount))) {
			Reporter.reportPassResult(
					browser,
					"'Create Manual Invoice' button exists on page header and 'Approve Adjustments' tabs include the number of pending invoices",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Create Manual Invoice' button exists on page header and 'Approve Adjustments' tabs include the number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_DeliveryDate_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Status_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Vendor_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Invoice_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_WRIN_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Description_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Purchased_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Adjusted_header)) {
			Reporter.reportPassResult(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, WRIN, Description, Cases Purchased, Cases Credit",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, WRIN, Description, Cases Purchased, Cases Credit",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (approveAdjustmentsPage.verifyApproveButtonDisplayedForRecordsWithNeedsApprovalStatus()) {
			Reporter.reportPassResult(
					browser,
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)
				& Base.isElementDisplayed(purchasesPage.MissingInvoice_Msg)) {
			Reporter.reportPassResult(
					browser,
					"Restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3420_Validation1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		/*ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);*/
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		boolean createInvoiceModelDisplayed = Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveAdjustments_BT)).click();
		//wait.until(ExpectedConditions.visibilityOf(approveAdjustmentsPage.ApproveAdjustmentsTable_header));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		purchasesPage.ApproveAdjustments_BT.click();
		
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_StartDate_TB));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		purchasesPage.ApproveAdjustments_BT.click();
		
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		purchasesPage.ApproveAdjustments_BT.click();
		if(createInvoiceModelDisplayed){
			Reporter.reportPassResult(
					browser,
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3420_Validation2";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String date = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+date);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if(manualInvoiceNewPage.CreateManualInvoice_VendorName_List.get(0).getText().contains("Select a vendor")
			& manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.getAttribute("placeholder").contains("Enter Invoice #")
			& manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.getAttribute("placeholder").contains("Enter raw item number or description")
			& manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getAttribute("value").equals(date)){
			Reporter.reportPassResult(
					browser,
					"Vendor displays 'Select a vendor'. Invoice Number displays 'Enter Invoice#'. Date is pre-populated with current date"
					+ " Item displays 'Enter raw item number or description to add to this invoice'","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Vendor displays 'Select a vendor'. Invoice Number displays 'Enter Invoice#'. Date is pre-populated with current date"
					+ " Item displays 'Enter raw item number or description to add to this invoice'", "Fail");
			AbstractTest.takeSnapShot();
			
			}
		if(Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Vendor_Label)
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_VendorAsterisk_Label)
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Date_Label)
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Item_Label)
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_Label)
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ItemAsterisk_Label)){
			Reporter.reportPassResult(
					browser,
					"Verify required fields display: 'Vendor', 'Date', 'Item' Verify 'Invoice Number' is optional field Verify Vendor and Item display red asterisk","Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"Verify required fields display: 'Vendor', 'Date', 'Item' Verify 'Invoice Number' is optional field Verify Vendor and Item display red asterisk", "Fail");
				AbstractTest.takeSnapShot();
				
		}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3420_Validation3";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		/*String date = GlobalVariable.createDate;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.sendKeys("test");
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		String invalidWrinMsg = manualInvoiceNewPage.CreateManualInvoice_NoSuggestionForWrinId_Msg.getText();
		System.out.println("invalidWrinMsgDisplayed "+ invalidWrinMsg);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		if(invalidWrinMsg.contains("We can't find a match. Try broadening your criteria.") 
				& manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)){
			Reporter.reportPassResult(
					browser,
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("p");
		Base.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message);
		String invalidQuantityMsg = manualInvoiceNewPage.InvalidQuantity_Error_Message.getText();
		System.out.println("invalidQuantityMsg "+invalidQuantityMsg);
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys("p");
		Base.isElementDisplayed(manualInvoiceNewPage.InvalidPricePerCase_Error_Message);
		String invalidCasePriceMsg = manualInvoiceNewPage.InvalidPricePerCase_Error_Message.getText();
		System.out.println("invalidCasePriceMsg "+invalidCasePriceMsg);
		if(invalidQuantityMsg.contains("Value must be numeric between 1 and 99999, with no decimals")
				& invalidCasePriceMsg.contains("Values must be numeric with up to 4 decimals. (Example: 12345.9999)")){
			Reporter.reportPassResult(
					browser,
					"error displays 'Just numeric character 0-9, please.' For Quantity Validation "
					+ "and Error message displayed for price per case validation","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"error displays 'Just numeric character 0-9, please.' For Quantity Validation "
					+ "and Error message displayed for price per case validation", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3420_Validation4";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String invoiceId = Base.randomNumberFiveDigit();
		String quantity = "1";
		String pricePerCase = "11.23";
		/*String date = GlobalVariable.createDate;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)){
			Reporter.reportPassResult(
					browser,
					"confirmation message displays anchored to bottom of browser and Approve Pending includes the new invoice","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"confirmation message displays anchored to bottom of browser and Approve Pending includes the new invoice", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}
	
	//TC3422 : UI/UX Retrofit - Purchases - View History: Default State
	@Test()
	public void purchasesBundle_US846_TC3422() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3422";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(2000);
		purchasesPage.ViewHistory_BT.click();
		if(!Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTab_Count)
				& viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"'View History' tab DOES NOT display a number for invoices in history and 'Show Results' button inactive by default","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'View History' tab DOES NOT display a number for invoices in history and 'Show Results' button inactive by default", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		System.out.println("startDate "+startDate);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+endDate);
		
		if (viewPurchaseHistoryPage.ViewHistory_StartDate_TB.getAttribute("value").equals(startDate)
				& viewPurchaseHistoryPage.ViewHistory_EndDate_TB.getAttribute("value").equals(endDate)
				& viewPurchaseHistoryPage.ViewHistory_Vendor_DD.getText().equals("All")) {
			Reporter.reportPassResult(
					browser,
					"filter criteria defaults:  Vendor - All, Start Date = First Date of Month, End Date = Current of Month",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"filter criteria defaults:  Vendor - All, Start Date = First Date of Month, End Date = Current of Month",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3423 : UI/UX Retrofit - Purchases - View History: View
	@Test()
	public void purchasesBundle_US846_TC3423() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3423";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId2 = LoginTestData.level1StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_Vendor_DD));
		viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD.click();
		viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		if(Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_DeliveryDate_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_Vendor_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_Invoice_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_InvoiceTotal_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_AmountOff_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_AutoApprove_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_Type_Header)){
			Reporter.reportPassResult(
					browser,
					"Verify table columns include:  Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify table columns include:  Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)
				& Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)) {
			Reporter.reportPassResult(
					browser,
					"4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger and Create Manual Invoice' button exists on page header",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger and Create Manual Invoice' button exists on page header",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if(viewPurchaseHistoryPage.verifyViewButtonDisplayedForEachPostedPurchase()){
			Reporter.reportPassResult(
					browser,
					"Verify each listing has a 'View' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify each listing has a 'View' button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)
				& Base.isElementDisplayed(purchasesPage.MissingInvoice_Msg)) {
			Reporter.reportPassResult(
					browser,
					"restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3424 : UI/UX Retrofit - Purchases - View History: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3424() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3424";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		if (viewPurchaseHistoryPage.verifyDeliveryDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					" invoice history display the most recent delivery date in descending order",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					" invoice history display the most recent delivery date in descending order",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3425 : UI/UX Retrofit - Purchases - View History: Sorting
	@Test()
	public void purchasesBundle_US846_TC3425() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3425";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		viewPurchaseHistoryPage.ViewHistoryTable_DeliveryDate_Header.click();
		Thread.sleep(2000);
		boolean dateInAscendinOrder = viewPurchaseHistoryPage.verifyDeliveryDateInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_DeliveryDate_Header.click();
		Thread.sleep(2000);
		boolean dateInDecendinOrder = viewPurchaseHistoryPage.verifyDeliveryDateInDescendingOrder();
		System.out.println("dateInAscendinOrder  "+dateInAscendinOrder );
		System.out.println("dateInDecendinOrder  "+dateInDecendinOrder );
		if (dateInAscendinOrder & dateInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending date",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending date",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		viewPurchaseHistoryPage.ViewHistoryTable_Vendor_Header.click();
		Thread.sleep(2000);
		boolean vendorInAscendinOrder = viewPurchaseHistoryPage.verifyVendorInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_Vendor_Header.click();
		Thread.sleep(2000);
		boolean vendorInDecendinOrder = viewPurchaseHistoryPage.verifyVendorInDescendingOrder();
		System.out.println("vendorInAscendinOrder  "+vendorInAscendinOrder );
		System.out.println("vendorInDecendinOrder  "+vendorInDecendinOrder );
		if (vendorInAscendinOrder & vendorInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Vendor",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		viewPurchaseHistoryPage.ViewHistoryTable_Invoice_Header.click();
		Thread.sleep(2000);
		boolean invoiceInAscendinOrder = viewPurchaseHistoryPage.verifyInvoiceInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_Invoice_Header.click();
		Thread.sleep(2000);
		boolean invoiceInDecendinOrder = viewPurchaseHistoryPage.verifyInvoiceInAscendingOrder();
		System.out.println("invoiceInAscendinOrder  "+invoiceInAscendinOrder );
		System.out.println("invoiceInDecendinOrder  "+invoiceInDecendinOrder );
		if (vendorInAscendinOrder & vendorInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Invoice",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewHistoryTable_InvoiceTotal_Header.click();
		Thread.sleep(2000);
		boolean invoiceTotalInAscendinOrder = viewPurchaseHistoryPage.verifyInvoiceTotalInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_InvoiceTotal_Header.click();
		Thread.sleep(2000);
		boolean invoiceTotalInDecendinOrder = viewPurchaseHistoryPage.verifyInvoiceTotalInDescendingOrder();
		System.out.println("invoiceTotalInAscendinOrder  "+invoiceTotalInAscendinOrder );
		System.out.println("invoiceTotalInDecendinOrder  "+invoiceTotalInDecendinOrder );
		if (invoiceTotalInAscendinOrder & invoiceTotalInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Invoice Total",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Invoice Total",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewHistoryTable_AmountOff_Header.click();
		Thread.sleep(2000);
		boolean amountOffInAscendinOrder = viewPurchaseHistoryPage.verifyAmountOffInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_AmountOff_Header.click();
		Thread.sleep(2000);
		boolean amountOffInDecendinOrder = viewPurchaseHistoryPage.verifyAmountOffInDescendingOrder();
		System.out.println("amountOffInAscendinOrder  "+amountOffInAscendinOrder );
		System.out.println("amountOffInDecendinOrder  "+amountOffInDecendinOrder );
		
		if (amountOffInAscendinOrder & amountOffInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending amount Off",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending amount Off",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewHistoryTable_AutoApprove_Header.click();
		Thread.sleep(2000);
		boolean autoApproveInAscendinOrder = viewPurchaseHistoryPage.verifyAutoApproveInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_AutoApprove_Header.click();
		Thread.sleep(2000);
		boolean autoApproveInDecendinOrder = viewPurchaseHistoryPage.verifyAutoApproveInDescendingOrder();
		System.out.println("autoApproveInAscendinOrder  "+autoApproveInAscendinOrder );
		System.out.println("autoApproveInDecendinOrder  "+autoApproveInDecendinOrder );
		
		if (autoApproveInAscendinOrder & autoApproveInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Auto Approve",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Auto Approve",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		viewPurchaseHistoryPage.ViewHistoryTable_Type_Header.click();
		Thread.sleep(2000);
		boolean typeInAscendinOrder = viewPurchaseHistoryPage.verifyTypeInAscendingOrder();
		viewPurchaseHistoryPage.ViewHistoryTable_Type_Header.click();
		Thread.sleep(2000);
		boolean typeInDecendinOrder = viewPurchaseHistoryPage.verifyTypeInDescendingOrder();
		System.out.println("typeInAscendinOrder  "+typeInAscendinOrder );
		System.out.println("typeInDecendinOrder  "+typeInDecendinOrder );
		
		if (typeInAscendinOrder & typeInDecendinOrder) {
			Reporter.reportPassResult(
					browser,
					"user should be able to toggle between ascending and descending Type",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to toggle between ascending and descending Type",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3429 : UI/UX Retrofit - Purchases - View History: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3429() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3429";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestorePurchases_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		if (purchasesPage.RestoreManualInvoice_DeletedInvoice_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"deleted invoices display in 'Restore Invoice' modal",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"deleted invoices display in 'Restore Invoice' modal",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3432 : UI/UX Retrofit - Purchases - View Ledger: Default State
	@Test()
	public void purchasesBundle_US846_TC3432() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3432";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		if(!Base.isElementDisplayed(storeLedgerDetailPage.storeledger_Count)){
			Reporter.reportPassResult(
					browser,
					"'View Ledger' tab DOES NOT display a number for invoices in history","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'View Ledger' tab DOES NOT display a number for invoices in history", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		System.out.println("month_DD_FirstElement "+storeLedgerDetailPage.month_DD_FirstElement.getAttribute("value"));
		if (Base.isElementDisplayed(storeLedgerDetailPage.month_DD)
				& storeLedgerDetailPage.month_DD_FirstElement.getAttribute("value").equals(startDate)) {
			Reporter.reportPassResult(
					browser,
					"filter criteria displays:  Month and  filter criteria defaults:  Month = Last Closed Month' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"filter criteria displays:  Month and  filter criteria defaults:  Month = Last Closed Month",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3433 : UI/UX Retrofit - Purchases - View Ledger: Default State
	@Test()
	public void purchasesBundle_US846_TC3433() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3433";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendorName = GlobalVariable.vendorName;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		// select last month from the dropdown
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get last month and year
//		Calendar cal2 = Calendar.getInstance();
//		cal2.add(Calendar.MONTH, -1);
//		cal2.set(Calendar.DATE, 1);
//		String date = dateFormat.format(cal2.getTime());
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(3000);
		if(Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_DeliveryDate_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Invoice_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Type_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_InvoiceTotal_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Food_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Paper_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProduct_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_OpsSupplies_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Linens_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProductHappyMealPremium_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProductOther_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax1_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax2_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax3_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_StateTax_Label)){
			Reporter.reportPassResult(
					browser,
					"'Create Manual Invoice' button exists on page header and table columns include:  Delivery Date, Invoice, "
					+ "Type,  Invoice Total, Food, Paper, Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, "
					+ "Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Create Manual Invoice' button exists on page header and table columns include:  Delivery Date, Invoice, "
					+ "Type,  Invoice Total, Food, Paper, Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, "
					+ "Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if(Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_GrandTotal_Label)
				& !storeLedgerDetailPage.StoreLedgerTable_InvoiceTotal_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Food_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Paper_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_NonProduct_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_OpsSupplies_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Linens_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_NonProductHappyMealPremium_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_NonProductOther_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Tax1_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Tax2_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_Tax3_Value.getText().isEmpty()
				& !storeLedgerDetailPage.StoreLedgerTable_StateTax_Value.getText().isEmpty()){
			Reporter.reportPassResult(
					browser,
					" 'Grand Total' line displays below the heading providing totals for Invoice Total, Food, Paper,"
					+ " Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, Non-Product Other, Tax 1, "
					+ "Tax 2, Tax 3, Sales Tax","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"'Grand Total' line displays below the heading providing totals for Invoice Total, Food, Paper,"
					+ " Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, Non-Product Other, Tax 1, "
					+ "Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if(storeLedgerDetailPage.verifyVendorGroupIsDisplayed(vendorName)){
			Reporter.reportPassResult(
					browser,
					"Verify activity is displayed by vendor","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify activity is displayed by vendor", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)
				& Base.isElementDisplayed(purchasesPage.MissingInvoice_Msg)) {
			Reporter.reportPassResult(
					browser,
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}

	//TC3434 : UI/UX Retrofit - Purchases - View Ledger: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3434() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3434";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendorName = GlobalVariable.vendorName;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(3000);
		if (storeLedgerDetailPage.verifyDeliveryDateInDescendingOrder(vendorName)) {
			Reporter.reportPassResult(
					browser,
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3435 : UI/UX Retrofit - Purchases - View Ledger: Sorting
	@Test()
	public void purchasesBundle_US846_TC3435() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3435";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(createDate);
		Thread.sleep(3000);
		if (storeLedgerDetailPage.StoreLedgerTable_DeliveryDate_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Invoice_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Type_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_InvoiceTotal_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Food_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Paper_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_NonProduct_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_OpsSupplies_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Linens_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_NonProductHappyMealPremium_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_NonProductOther_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Tax1_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Tax2_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_Tax3_Label.getAttribute("class").contains("sorting_disabled")
				& storeLedgerDetailPage.StoreLedgerTable_StateTax_Label.getAttribute("class").contains("sorting_disabled")) {
			Reporter.reportPassResult(
					browser,
					"Sorting functionality is not provided for Store Ledger Details Page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Sorting functionality is not provided for Store Ledger Details Page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3437 : UI/UX Retrofit - Purchases - View Ledger: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3437() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3437";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		if (purchasesPage.RestoreManualInvoice_DeletedInvoice_List.size()>0) {
			Reporter.reportPassResult(
					browser,
					"deleted invoices display in 'Restore Invoice' modal",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"deleted invoices display in 'Restore Invoice' modal",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3364 : UI/UX Retrofit - Purchases - Approve Pending: Restore Deleted Invoices (No Access)
	@Test()
	public void purchasesBundle_US846_TC3364() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3364";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& !Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of page and 'Restore Invoice' button is not displayed ",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of page and 'Restore Invoice' button is not displayed ",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3430 : UI/UX Retrofit - Purchases - View History: Restore Deleted Invoices (No Access)
	@Test()
	public void purchasesBundle_US846_TC3430() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3430";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_BT)).click();
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& !Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of view history page and 'Restore Invoice' button is not displayed",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of view history page and 'Restore Invoice' button is not displayed",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3438 : UI/UX Retrofit - Purchases - View Ledger: Restore Deleted Invoices (No Access)
	@Test()
	public void purchasesBundle_US846_TC3438() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC3438";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewLedger_BT)).click();
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_Msg)
				& !Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of View Ledger page and 'Restore Invoice' button is not displayed ",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify message DOES NOT display 'Oops, accidentally deleted a manual invoice?' at bottom of View Ledger page and 'Restore Invoice' button is not displayed ",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC4008 : UI/UX Retrofit - Purchases - Approve Pending: View
	@Test()
	public void purchasesBundle_US846_TC4008() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US846_TC4008";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId,quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		//purchasesPage.selectDateForApproveInvoice(GlobalVariable.createDate);
		//purchasesPage.selectTimeForApproveInvoice(GlobalVariable.time);
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		if (Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_No_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message)) {
			Reporter.reportPassResult(
					browser,
					"user should be able to view text in dialogue box as \"Are you sure you want to approve this manual invoice?\" with \"yes\" and \"no\" buutons",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should be able to view text in dialogue box as \"Are you sure you want to approve this manual invoice?\" with \"yes\" and \"no\" buutons",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	


}
