package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.ReadTestData;
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
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3352",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3352_Condition1","purchasesBundle_US846_TC3352",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3352_Condition1");
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
					browser,"purchasesBundle_US846_TC3352",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3352_Condition2","purchasesBundle_US846_TC3352",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3352_Condition2");
		}
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3352",
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3352_Condition3","purchasesBundle_US846_TC3352",
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3352_Condition3");
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
					browser,"purchasesBundle_US846_TC3352",
					"Verify 'Approve Pending' and 'Approve Adjustments' tabs include the number of pending invoices",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3352_Condition4","purchasesBundle_US846_TC3352",
					"Verify 'Approve Pending' and 'Approve Adjustments' tabs include the number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3352_Condition4");
		}
		purchasesPage.ApprovePending_BT.click();
		Thread.sleep(2000);
		System.out.println("Masg "+purchasesPage.RestorePurchases_Msg.getText());
		if (purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3352",
					"restore message displays below table 'Oops, accidentally delete a manual invoice?' and includes a 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3352_Condition5","purchasesBundle_US846_TC3352",
					"restore message displays below table 'Oops, accidentally delete a manual invoice?' and includes a 'Restore Invoice' button",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3352_Condition5");
		}
	}
	
	// TC3353 : UI/UX Retrofit - Purchases - Approve Pending: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3353() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (purchasesPage.verifyDeliverDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3353",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3353","purchasesBundle_US846_TC3353",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3353");
		}
	}
	
	// TC3354 : UI/UX Retrofit - Purchases - Approve Pending: Sorting
	@Test()
	public void purchasesBundle_US846_TC3354() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition1","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending date",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition1");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Status",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition2","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Status",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition2");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition3","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending vendor",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition3");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition4","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition4");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice Total",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition5","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice Total",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition5");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending amount Off",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition6","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending amount Off",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition6");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Auto Approve",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition7","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Auto Approve",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition7");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Type",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition8","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Type",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition8");
		}
	}

	//TC3355 : UI/UX Retrofit - Purchases - Approve Pending: Notifications (Variance)
	@Test()
	public void purchasesBundle_US846_TC3355() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (purchasesPage.verifyNotificationDisplayedForExceedVariance()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3353",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3353","purchasesBundle_US846_TC3353",
					"'Create Manual Invoice' button exists on page header (above data table)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3353");
		}
	}
	
	//TC3358 : UI/UX Retrofit - Purchases - Approve Pending: Approve Invoice (Electronic)
	@Test()
	public void purchasesBundle_US846_TC3358() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US846_TC3358", "Object1");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		String invoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String date = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String backTime = "23:45";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		
		purchasesPage.clickOnApproveButtonForElectronicPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveElectronicInvoice_PopUp_Lable));
		System.out.println(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled"));
		if(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled").equals("true")
				& purchasesPage.verifyBackTimeIsSelected(backTime)){
			Reporter.reportPassResult(
					browser, "purchasesBundle_US846_TC3358",
					"'Approve' is inactive until required fields are complete and time control allows user to arrow down to set the hour and minute.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "purchasesBundle_US846_TC3358_Condition1","purchasesBundle_US846_TC3358",
					"'Approve' is inactive until required fields are complete and time control allows user to arrow down to set the hour and minute.", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition1");
		}
		
		purchasesPage.selectDateForApproveElectronicInvoice(date).selectTimeInApproveElectronicInvoiceForm(time);
		if(purchasesPage.ApproveManualInvoice_Approve_BT.getAttribute("disabled")== null){
			Reporter.reportPassResult(
					browser, "purchasesBundle_US846_TC3358",
					"time control allows user to arrow down to set the hour and minute, User is able to select the date "
					+ "and 'Approve' is activates when time is selected", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "purchasesBundle_US846_TC3358_Condition2","purchasesBundle_US846_TC3358",
					"time control allows user to arrow down to set the hour and minute, User is able to select the date "
					+ "and 'Approve' is activates when time is selected", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition2");
		}
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3358",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3358_Condition3","purchasesBundle_US846_TC3358",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition3");
		}
		
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_BreakDownByCostType_Label)
				& !purchasesPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3358",
					"totals by type are included below the table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3358_Condition4","purchasesBundle_US846_TC3358",
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition4");
		}
		
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		System.out.println("Msg "+purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message.getText());
		
		if (Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3358",
					"Verify popup includes No, Yes and X buttons",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3358_Condition5","purchasesBundle_US846_TC3358",
					"Verify popup includes No, Yes and X buttons",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition5");
		}
		purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT.click();
		if (Base.isElementDisplayed(purchasesPage.ApproveElectronicInvoice_PopUp_InvoiceApprove_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3358",
					"Verify confirmation message displays anchored to bottom of browser",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3358_Condition6","purchasesBundle_US846_TC3358",
					"Verify confirmation message displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3358_Condition6");
		}
	}
	
	//TC3359 : UI/UX Retrofit - Purchases - View History: View Approved Invoice (Electronic)
	@Test()
	public void purchasesBundle_US846_TC3359() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US846_TC3359", "Object1");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		String invoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
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
					browser,"purchasesBundle_US846_TC3359",
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition1","purchasesBundle_US846_TC3359",
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition1");
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition2","purchasesBundle_US846_TC3359",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition2");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition3","purchasesBundle_US846_TC3359",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition3");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition4","purchasesBundle_US846_TC3359",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition4");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"Verify 'Grand Total' is included at end of table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition5","purchasesBundle_US846_TC3359",
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition5");
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"totals by type are included below the table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition6","purchasesBundle_US846_TC3359",
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition6");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3359",
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3359_Condition7","purchasesBundle_US846_TC3359",
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3359_Condition7");
		}
	}
	
	//TC3360 : UI/UX Retrofit - Purchases - Approve Pending: Approve Invoice (Manual)
	@Test()
	public void purchasesBundle_US846_TC3360() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		System.out.println(purchasesPage.ApproveManualInvoice_Vendor_TB.getAttribute("disabled"));
		if (purchasesPage.ApproveManualInvoice_Vendor_TB.getAttribute("disabled").equals("true")
				& purchasesPage.ApproveManualInvoice_InvoiceNumber_TB.getAttribute("disabled").equals("true")
				& purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("disabled")== null
				& purchasesPage.verifyRemoveWrinOptionIsNotPresent()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Vendor, Invoice Number, Items fields are displayed and read-only and Date field is displayed and editable",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition1","purchasesBundle_US846_TC3360",
					"Vendor, Invoice Number, Items fields are displayed and read-only and Date field is displayed and editable",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition1");
		}
		purchasesPage.selectDateToApprove(date);
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Cancel_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_Approve_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_Delete_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Cancel, Delete and Approve buttons exist",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition2","purchasesBundle_US846_TC3360",
					"Cancel, Delete and Approve buttons exist",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition2");
		}
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_WRIN_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Description_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_UOM_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Case_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Quantity_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_PricePerCase_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_SubTotal_Label)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Verify columns included: WRIN, Description, UOM, Case, Quantity, Price Per Case and Sub-total",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition3","purchasesBundle_US846_TC3360",
					"Verify columns included: WRIN, Description, UOM, Case, Quantity, Price Per Case and Sub-total",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition3");
		}
		if (Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_BreakDownByCostType_Label)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_TotalFood_Section)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"totals by type are included below the table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition4","purchasesBundle_US846_TC3360",
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition4");
		}
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.ManualInvoiceApprove_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.ManualInvoiceApproveForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition4","purchasesBundle_US846_TC3360",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition4");
		}
		
		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		boolean warningMsgDisplayed = Base.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message);
		System.out.println("Msg "+purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message.getText());
		if (Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT)
				& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Verify popup includes No, Yes and X buttons",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition5","purchasesBundle_US846_TC3360",
					"Verify popup includes No, Yes and X buttons",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition5");
		}
		purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT.click();
		if (Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3360",
					"Verify confirmation message displays anchored to bottom of browser",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3360_Condition6","purchasesBundle_US846_TC3360",
					"Verify confirmation message displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3360_Condition6");
		}
	}
	
	//TC3361 : UI/UX Retrofit - Purchases - View History: View Approved Invoice (Manual)
	@Test()
	public void purchasesBundle_US846_TC3361() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String wrinId = GlobalVariable.foodWrin1;
		String productCategory = GlobalVariable.productCategoryFood;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String pricePerCase = "11.66";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.approveAManualInvoice(invoiceId,date);
		Thread.sleep(5000);
		purchasesPage.ViewHistory_BT.click();
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_Vendor_DD));
		viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD.click();
		viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(invoiceId);
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_ManualSource_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_CreatedBy_Label.getText().contains(userId)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition1","purchasesBundle_US846_TC3360",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition1");
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition2","purchasesBundle_US846_TC3361",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition2");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition3","purchasesBundle_US846_TC3361",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition3");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition4","purchasesBundle_US846_TC3361",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition4");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Verify 'Grand Total' is included at end of table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition5","purchasesBundle_US846_TC3361",
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition5");
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"totals by type are included below the table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition6","purchasesBundle_US846_TC3361",
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition6");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3361",
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3361_Condition7","purchasesBundle_US846_TC3361",
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3361_Condition7");
		}
	}
	
	//TC3362 : UI/UX Retrofit - Purchases - Approve Pending: View Pending Invoice w/Variance (Electronic)
	@Test()
	public void purchasesBundle_US846_TC3362() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US846_TC3362", "Object1");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		String invoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = purchasesPage.clickOnViewButtonForElectronicPurchase(invoiceId);
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_ElectronicSource_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_CreatedBy_Label.getText().contains("Created By: System")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition1","purchasesBundle_US846_TC3362",
					"Verify form header includes: Title 'View Invoice', 'Source: Electronic', 'Created By: System",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition1");
		}
		
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalCollapsedView");
		viewPurchaseHistoryPage.ViewInvoiceForm_SliderToggle_BT.click();
		boolean formIsExpanded = viewPurchaseHistoryPage.ViewInvoiceForm_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition2","purchasesBundle_US846_TC3362",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition2");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition3","purchasesBundle_US846_TC3362",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition3");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)
				& viewPurchaseHistoryPage.ViewInvoiceForm_purchaseDetail_List.size()>0) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition4","purchasesBundle_US846_TC3362",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition4");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Verify 'Grand Total' is included at end of table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition5","purchasesBundle_US846_TC3362",
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition5");
		}
		
		//Add BreakDown Cost Type Verification
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_BreakDownByCostType_Label)
				& !viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory).isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"totals by type are included below the table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition6","purchasesBundle_US846_TC3362",
					"totals by type are included below the table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition6");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Cross_BT)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3362",
					"Verify 'X' and 'Close' buttons exist only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3362_Condition7","purchasesBundle_US846_TC3362",
					"Verify 'X' and 'Close' buttons exist only",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3362_Condition7");
		}
	}
	
	//TC3363 : UI/UX Retrofit - Purchases - Approve Pending: Restore Deleted Invoices (Access): NO Deleted Invoice
	@Test()
	public void purchasesBundle_US846_TC3363_NoDeletedInvoice() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = "4638";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		System.out.println("Msg "+purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg.getText());
		
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg)
				& purchasesPage.RestoreManualInvoice_NoDeletedInvoicePresent_Msg.getText().contains("We don’t have any invoices, deleted within the past 10 days, to show")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363_NoDeletedInvoice",
					"Verify message displays 'We don't have any invoices, deleted within the past 10 days, to show'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_NoDeletedInvoice_Condition1","purchasesBundle_US846_TC3363",
					"Verify message displays 'We don't have any invoices, deleted within the past 10 days, to show'",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_NoDeletedInvoice_Condition1");
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cross_BT)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Close_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363_NoDeletedInvoice",
					"Verify only 'Close' and 'X' buttons exist",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_NoDeletedInvoice_Condition2","purchasesBundle_US846_TC3363_NoDeletedInvoice",
					"Verify only 'Close' and 'X' buttons exist",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_NoDeletedInvoice_Condition2");
		}
		purchasesPage.RestoreManualInvoice_Cross_BT.click();
	}
	
	//TC3363 : UI/UX Retrofit - Purchases - Approve Pending: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3363() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, "");
		Thread.sleep(5000);
		//purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		purchasesPage.deleteAManualInvoice(invoiceId);
		Thread.sleep(5000);
		Base.toReachbottomOfthePage();
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		System.out.println("Disclaimer Msg "+purchasesPage.RestoreManualInvoice_TimeDisclaimer_Msg.getText());
		System.out.println("Invoice Msg "+purchasesPage.RestoreManualInvoice_SelectInvoice_Msg.getText());
		if(purchasesPage.RestoreManualInvoice_TimeDisclaimer_Msg.getText().contains("Deleted manual invoices are retained for up to 10 days")
				& purchasesPage.RestoreManualInvoice_SelectInvoice_Msg.getText().contains("Select the invoices you want to restore")){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363",
					"message displays 'Deleted manual invoices are retained for up to 10 days' and "
					+ "'Select the invoices you want to restore", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition1","purchasesBundle_US846_TC3363",
					"message displays 'Deleted manual invoices are retained for up to 10 days' and "
					+ "'Select the invoices you want to restore","Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition1");
		}
		
		if (Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_InvoiceDate_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Invoice_Header)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Vendor_Header)
				&Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cross_BT)
				& Base.isElementDisplayed(purchasesPage.RestoreManualInvoice_Cancel_BT)
				& purchasesPage.RestoreManualInvoice_Restore_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363",
					"table header includes: Invoice Date, Invoice, Vendor.'Cancel' and 'X' buttons exist to exit and "
					+ "'Restore' button is inactive until at least one invoice is selected", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition2","purchasesBundle_US846_TC3363",
					"table header includes: Invoice Date, Invoice, Vendor.'Cancel' and 'X' buttons exist to exit and"
					+ " 'Restore' button is inactive until at least one invoice is selected","Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition2");
		}
		
		if(purchasesPage.verifyDeletedInvoiceAreSelectable()){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363",
					"checkboxes for each invoice exist and allow user to select one or multiple", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition3","purchasesBundle_US846_TC3363",
					"checkboxes for each invoice exist and allow user to select one or multiple","Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition3");
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
					browser,"purchasesBundle_US846_TC3363",
					"Verify checkbox exists to select/de-select all invoices at once and 'Restore' button active when at least one invoice is selected", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition4","purchasesBundle_US846_TC3363",
					"Verify checkbox exists to select/de-select all invoices at once 'Restore' button active when at least one invoice is selected","Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition4");
		}
		purchasesPage.RestoreManualInvoice_SelectAll_CB.click();
		purchasesPage.RestoreManualInvoice_SliderToggle_BT.click();
		Thread.sleep(2000);
		boolean formIsCollapsed = purchasesPage.RestoreManualInvoice_Container.getAttribute("class").contains("modalCollapsedView");
		purchasesPage.RestoreManualInvoice_SliderToggle_BT.click();
		boolean formIsExpanded = purchasesPage.RestoreManualInvoice_Container.getAttribute("class").contains("modalExpandedView");
		if (formIsCollapsed & formIsExpanded) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363",
					"Model is collapsible and can be re-opened",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition5","purchasesBundle_US846_TC3363",
					"Model is collapsible and can be re-opened",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition5");
		}
		purchasesPage.restoreInvoice(invoiceId);
		if(Base.isElementDisplayed(purchasesPage.RestoredInvoiceAdded_Msg)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3363",
					"Restore confirmation displays anchored to bottom of browser",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3363_Condition6","purchasesBundle_US846_TC3363",
					"Restore confirmation displays anchored to bottom of browser",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3363_Condition6");
		}
	}

	//TC3365 : UI/UX Retrofit - Purchases - Approve Pending: No Pending Invoices
	@Test()
	public void purchasesBundle_US846_TC3365() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = "4638";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		String countInTab = purchasesPage.ApprovePendingTab_Count.getText();
		if (countInTab.equals("0")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3365",
					"'Approve Pending' button displays '0' for number of pending invoices",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3365_Condition1","purchasesBundle_US846_TC3365",
					"'Approve Pending' button displays '0' for number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3365_Condition1");
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApprovePendingTable_NoPendingPurchases_Img)
				& purchasesPage.ApprovePendingTable_NoPendingPurchases_Msg.getText().contains("We don’t have any pending purchases to show")
				& purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3365",
					"inventory icon displays with message 'We don't have any pending purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3365_Condition2","purchasesBundle_US846_TC3365",
					"inventory icon displays with message 'We don't have any pending purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3365_Condition2");
		}
	}
	
	//TC3366 : UI/UX Retrofit - Purchases - Approve Adjustments: No Pending Adjustments
	@Test()
	public void purchasesBundle_US846_TC3366() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = "4638";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ApproveAdjustments_BT.click();
		String countInTab = approveAdjustmentsPage.ApproveAdjustmentsTab_Count.getText();
		if (countInTab.equals("0")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3366",
					"Verify 'Approve Adjustments' tab displays '0' for number of pending adjustments listed",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3366_Condition1","purchasesBundle_US846_TC3366",
					"Verify 'Approve Adjustments' tab displays '0' for number of pending adjustments listed",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3366_Condition1");
		}
		if (approveAdjustmentsPage.ApproveAdjustmentsTable_header.getAttribute("style").contains("display: none;")) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3366",
					"Verify table headings do not display",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3366_Condition2","purchasesBundle_US846_TC3366",
					"Verify table headings do not display",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3366_Condition2");
		}
		if (Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_NoPendingPurchases_Img)
				& approveAdjustmentsPage.ApproveAdjustmentsTable_NoPendingPurchases_Msg.getText().contains("We don’t have any purchase adjustments to show"))
		{
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3366",
					"inventory icon displays with message 'We don’t have any purchase adjustments to show",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3366_Condition3","purchasesBundle_US846_TC3366",
					"inventory icon displays with message 'We don’t have any purchase adjustments to show",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3366_Condition3");
		}
	}
	
	//TC3367 : UI/UX Retrofit - Purchases - Approve Adjustments: View
	@Test()
	public void purchasesBundle_US846_TC3367() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ApproveAdjustments_BT.click();
		int pendingAdjustmentsCount = purchasesPage.PendingAdjustments_List.size();
		String countInApproveAdjustmentsTab = approveAdjustmentsPage.ApproveAdjustmentsTab_Count.getText();
		
		if (Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)
				& countInApproveAdjustmentsTab.equals(String.valueOf(pendingAdjustmentsCount))) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3367",
					"'Create Manual Invoice' button exists on page header and 'Approve Adjustments' tabs include the number of pending invoices",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3367_Condition1","purchasesBundle_US846_TC3367",
					"'Create Manual Invoice' button exists on page header and 'Approve Adjustments' tabs include the number of pending invoices",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3367_Condition1");
		}
		
		if (Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_DeliveryDate_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Status_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Vendor_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Invoice_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_WRIN_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_Description_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header)
				& Base.isElementDisplayed(approveAdjustmentsPage.ApproveAdjustmentsTable_CasesCredit_header)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3367",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, WRIN, Description, Cases Purchased, Cases Credit",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3367_Condition2","purchasesBundle_US846_TC3367",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, WRIN, Description, Cases Purchased, Cases Credit",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3367_Condition2");
		}
		
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3367",
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3367_Condition3","purchasesBundle_US846_TC3367",
					"Verify 4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3367_Condition3");
		}
		
		if (approveAdjustmentsPage.verifyApproveButtonDisplayedForRecordsWithNeedsApprovalStatus()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3367",
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3367_Condition4","purchasesBundle_US846_TC3367",
					"Verify each listing with Status = 'Needs Approval' has an 'Approve' button",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3367_Condition4");
		}
		
	}

	//TC3368 : UI/UX Retrofit - Purchases - Approve Adjustments: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3368() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ApproveAdjustments_BT.click();
		if (approveAdjustmentsPage.verifyDeliverDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3368",
					"pending adjustments display the most recent delivery date in descending order",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3368","purchasesBundle_US846_TC3368",
					"pending adjustments display the most recent delivery date in descending order",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3368");
		}
	}
	
	//TC3369 : UI/UX Retrofit - Purchases - Approve Adjustments: Sorting
	@Test()
	public void purchasesBundle_US846_TC3369() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.ApproveAdjustments_BT.click();
		wait.until(ExpectedConditions.visibilityOf(approveAdjustmentsPage.ApproveAdjustmentsTable_DeliveryDate_header));
		approveAdjustmentsPage.ApproveAdjustmentsTable_DeliveryDate_header.click();
		Thread.sleep(2000);
		boolean dateInAscendinOrder = approveAdjustmentsPage.verifyDeliverDateInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_DeliveryDate_header.click();
		Thread.sleep(2000);
		boolean dateInDecendinOrder = approveAdjustmentsPage.verifyDeliverDateInDescendingOrder();
		System.out.println("dateInAscendinOrder  "+dateInAscendinOrder );
		System.out.println("dateInDecendinOrder  "+dateInDecendinOrder );
		if (dateInAscendinOrder & dateInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending delivery date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition1","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending delivery date",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition1");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_Status_header.click();
		Thread.sleep(2000);
		boolean statusInAscendinOrder = approveAdjustmentsPage.verifyStatusInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_Status_header.click();
		Thread.sleep(2000);
		boolean statusInDecendinOrder = approveAdjustmentsPage.verifyStatusInDescendingOrder();
		System.out.println("statusInAscendinOrder  "+statusInAscendinOrder );
		System.out.println("statusInDecendinOrder  "+statusInDecendinOrder );
		
		if (statusInAscendinOrder & statusInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending Status",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition2","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending Status",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition2");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_Vendor_header.click();
		Thread.sleep(2000);
		boolean vendorInAscendinOrder = approveAdjustmentsPage.verifyVendorInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_Vendor_header.click();
		Thread.sleep(2000);
		boolean vendorInDecendinOrder = approveAdjustmentsPage.verifyVendorInDescendingOrder();
		System.out.println("vendorInAscendinOrder  "+vendorInAscendinOrder );
		System.out.println("vendorInDecendinOrder  "+vendorInDecendinOrder );
		
		if (vendorInAscendinOrder & vendorInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition3","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending vendor",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition3");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_Invoice_header.click();
		Thread.sleep(2000);
		boolean invoiceInAscendinOrder = approveAdjustmentsPage.verifyInvoiceInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_Invoice_header.click();
		Thread.sleep(2000);
		boolean invoiceInDecendinOrder = approveAdjustmentsPage.verifyInvoiceInDescendingOrder();
		System.out.println("invoiceInAscendinOrder  "+invoiceInAscendinOrder );
		System.out.println("invoiceInDecendinOrder  "+invoiceInDecendinOrder );
		
		if (invoiceInAscendinOrder & invoiceInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending Invoice",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition4","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition4");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_WRIN_header.click();
		Thread.sleep(2000);
		boolean wrinInAscendinOrder = approveAdjustmentsPage.verifyWrinInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_WRIN_header.click();
		Thread.sleep(2000);
		boolean wrinInDecendinOrder = approveAdjustmentsPage.verifyWrinInDescendingOrder();
		System.out.println("wrinInAscendinOrder  "+wrinInAscendinOrder );
		System.out.println("wrinInDecendinOrder  "+wrinInDecendinOrder );
		
		if (wrinInAscendinOrder & wrinInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending wrin Id",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition5","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending wrin Id",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition5");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_Description_header.click();
		Thread.sleep(2000);
		boolean descriptionInAscendinOrder = approveAdjustmentsPage.verifyDescriptionInAscendingOrder();
		approveAdjustmentsPage.ApproveAdjustmentsTable_Description_header.click();
		Thread.sleep(2000);
		boolean descriptionInDecendinOrder = approveAdjustmentsPage.verifyDescriptionInDescendingOrder();
		System.out.println("descriptionInAscendinOrder  "+descriptionInAscendinOrder);
		System.out.println("descriptionInDecendinOrder  "+descriptionInDecendinOrder );
		if (descriptionInAscendinOrder & descriptionInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending description",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition5","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending description",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition5");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.click();
		Thread.sleep(2000);
		System.out.println("Class "+approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.getAttribute("class"));
		boolean casesPurchasedInAscendinOrder = approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.getAttribute("class").contains("sorting_asc");
		approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.click();
		Thread.sleep(2000);
		System.out.println("Class2 "+approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.getAttribute("class"));
		boolean casesPurchasedInDecendinOrder = approveAdjustmentsPage.ApproveAdjustmentsTable_CasesPurchased_header.getAttribute("class").contains("sorting_desc");
		System.out.println("casesPurchasedInAscendinOrder  "+casesPurchasedInAscendinOrder);
		System.out.println("casesPurchasedInDecendinOrder  "+casesPurchasedInDecendinOrder );
		if (casesPurchasedInAscendinOrder & casesPurchasedInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending cases Purchased",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition5","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending cases Purchased",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition5");
		}
		
		approveAdjustmentsPage.ApproveAdjustmentsTable_CasesCredit_header.click();
		Thread.sleep(2000);
		boolean casesCreditInAscendinOrder = approveAdjustmentsPage.ApproveAdjustmentsTable_CasesCredit_header.getAttribute("class").contains("sorting_asc");
		approveAdjustmentsPage.ApproveAdjustmentsTable_CasesCredit_header.click();
		Thread.sleep(2000);
		boolean casesCreditInDecendinOrder = approveAdjustmentsPage.ApproveAdjustmentsTable_CasesCredit_header.getAttribute("class").contains("sorting_desc");
		System.out.println("casesCreditInAscendinOrder  "+casesCreditInAscendinOrder);
		System.out.println("casesCreditInDecendinOrder  "+casesCreditInDecendinOrder );
		if (casesCreditInAscendinOrder & casesCreditInDecendinOrder) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending cases Credit",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3369_Condition5","purchasesBundle_US846_TC3369",
					"user should be able to toggle between ascending and descending  cases Credit",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3369_Condition5");
		}
	}

	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ApproveAdjustmentsPage approveAdjustmentsPage = PageFactory.initElements(driver, ApproveAdjustmentsPage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		boolean createInvoiceModelDisplayed = Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		
		purchasesPage.ApproveAdjustments_BT.click();
		wait.until(ExpectedConditions.visibilityOf(approveAdjustmentsPage.ApproveAdjustmentsTable_header));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		purchasesPage.ApproveAdjustments_BT.click();
		
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_StartDate_TB));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		purchasesPage.ApproveAdjustments_BT.click();
		
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		createInvoiceModelDisplayed = createInvoiceModelDisplayed & Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable);
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.click();
		purchasesPage.ApproveAdjustments_BT.click();
		if(createInvoiceModelDisplayed){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3420_Validation1",
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3420_Validation1","purchasesBundle_US846_TC3420_Validation1",
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3420_Validation1");
		}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String date = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+date);
		if(manualInvoiceNewPage.CreateManualInvoice_VendorName_List.get(0).getText().contains("Select a vendor")
			& manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.getAttribute("placeholder").contains("Enter Invoice #")
			& manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.getAttribute("placeholder").contains("Enter raw item number or description")
			& manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getAttribute("value").equals(date)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3420_Validation2",
					"Vendor displays 'Select a vendor'. Invoice Number displays 'Enter Invoice#'. Date is pre-populated with current date"
					+ " Item displays 'Enter raw item number or description to add to this invoice'","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3420_Validation2","purchasesBundle_US846_TC3420_Validation2",
					"Vendor displays 'Select a vendor'. Invoice Number displays 'Enter Invoice#'. Date is pre-populated with current date"
					+ " Item displays 'Enter raw item number or description to add to this invoice'", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3420_Validation2");
			}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.sendKeys("test");
		String invalidWrinMsg = manualInvoiceNewPage.CreateManualInvoice_NoSuggestionForWrinId_Msg.getText();
		System.out.println("invalidWrinMsgDisplayed "+ invalidWrinMsg);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		if(invalidWrinMsg.contains("We can't find a match. Try broadening your criteria.") 
				& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG)
				& manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3420_Validation3",
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3420_Validation3_Condition1","purchasesBundle_US846_TC3420_Validation3",
					"'Manual Invoice' opens from each Page: Approve Pending, Approve Adjustments, View History, View Ledger", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3420_Validation3_Condition1");
		}
		manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("p");
		String invalidQuantityMsg = manualInvoiceNewPage.InvalidQuantity_Error_Message.getText();
		Base.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message);
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys("p");
		String invalidCasePriceMsg = manualInvoiceNewPage.InvalidPricePerCase_Error_Message.getText();
		
		if(invalidQuantityMsg.contains("Value must be numeric between 1 and 99999, with no decimals")
				& invalidCasePriceMsg.contains("Values must be numeric with up to 4 decimals. (Example: 12345.9999)")){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3420_Validation3",
					"error displays 'Just numeric character 0-9, please.' For Quantity Validation "
					+ "and Error message displayed for price per case validation","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3420_Validation3_Condition2","purchasesBundle_US846_TC3420_Validation3",
					"error displays 'Just numeric character 0-9, please.' For Quantity Validation "
					+ "and Error message displayed for price per case validation", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3420_Validation3_Condition2");
		}
	}
	
	//TC3420 : UI/UX Retrofit - Purchases - Create Manual Invoice
	@Test()
	public void purchasesBundle_US846_TC3420_Validation4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String invoiceId = Base.randomNumberFiveDigit();
		String quantity = "1";
		String pricePerCase = "11.23";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3420_Validation4",
					"confirmation message displays anchored to bottom of browser and Approve Pending includes the new invoice","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3420_Validation4","purchasesBundle_US846_TC3420_Validation4",
					"confirmation message displays anchored to bottom of browser and Approve Pending includes the new invoice", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3420_Validation4");
		}
		
	}
	
	//TC3421 : UI/UX Retrofit - Purchases - View History: No Invoice History
	@Test()
	public void purchasesBundle_US846_TC3421() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = "55";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(2000);
		purchasesPage.ViewHistory_BT.click();
		if(viewPurchaseHistoryPage.ViewHistoryTable_Header.getAttribute("style").contains("display: none;")){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3421",
					"Verify no table headings display","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3421_Condition1","purchasesBundle_US846_TC3421",
					"Verify no table headings display", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3421_Condition1");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTable_NoPostedPurchases_Img)
				& viewPurchaseHistoryPage.ViewHistoryTable_NoPostedPurchases_Msg.getText().contains("We don’t have any posted purchases to show")
				& purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3421",
					"inventory icon displays with message 'We don't have any posted purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3421_Condition2","purchasesBundle_US846_TC3421",
					"inventory icon displays with message 'We don't have any posted purchases to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3421_Condition2");
		}
		
	}
	
	//TC3422 : UI/UX Retrofit - Purchases - View History: Default State
	@Test()
	public void purchasesBundle_US846_TC3422() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(2000);
		purchasesPage.ViewHistory_BT.click();
		if(!Base.isElementDisplayed(viewPurchaseHistoryPage.ViewHistoryTab_Count)
				& viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3422",
					"'View History' tab DOES NOT display a number for invoices in history and 'Show Results' button inactive by default","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3422_Condition1","purchasesBundle_US846_TC3422",
					"'View History' tab DOES NOT display a number for invoices in history and 'Show Results' button inactive by default", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3422_Condition1");
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
					browser,"purchasesBundle_US846_TC3422",
					"filter criteria defaults:  Vendor - All, Start Date = First Date of Month, End Date = Current of Month",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3422_Condition2","purchasesBundle_US846_TC3422",
					"filter criteria defaults:  Vendor - All, Start Date = First Date of Month, End Date = Current of Month",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3422_Condition2");
		}
	}
	
	//TC3423 : UI/UX Retrofit - Purchases - View History: View
	@Test()
	public void purchasesBundle_US846_TC3423() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId2 = LoginTestData.operatorStoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId2)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
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
					browser,"purchasesBundle_US846_TC3423",
					"Verify table columns include:  Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3423_Condition1","purchasesBundle_US846_TC3423",
					"Verify table columns include:  Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3423_Condition1");
		}
		if (Base.isElementDisplayed(purchasesPage.ApprovePending_BT)
				& Base.isElementDisplayed(purchasesPage.ApproveAdjustments_BT)
				& Base.isElementDisplayed(purchasesPage.ViewHistory_BT)
				& Base.isElementDisplayed(purchasesPage.ViewLedger_BT)
				& Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3423",
					"4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger and Create Manual Invoice' button exists on page header",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3423_Condition2","purchasesBundle_US846_TC3423",
					"4 tabs exist: Approve Pending, Approve Adjustments, View History, View Ledger and Create Manual Invoice' button exists on page header",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3423_Condition2");
		}
		
		if(viewPurchaseHistoryPage.verifyViewButtonDisplayedForEachPostedPurchase()){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3423",
					"Verify each listing has a 'View' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3423_Condition3","purchasesBundle_US846_TC3423",
					"Verify each listing has a 'View' button",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3423_Condition3");
		}
		if (purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3423",
					"restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3423_Condition4","purchasesBundle_US846_TC3423",
					"restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3423_Condition4");
		}
	}
	
	//TC3424 : UI/UX Retrofit - Purchases - View History: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3424() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		if (viewPurchaseHistoryPage.verifyDeliveryDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3424",
					" invoice history display the most recent delivery date in descending order",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3424","purchasesBundle_US846_TC3424",
					" invoice history display the most recent delivery date in descending order",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3424");
		}
	}
	
	//TC3425 : UI/UX Retrofit - Purchases - View History: Sorting
	@Test()
	public void purchasesBundle_US846_TC3425() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition1","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending date",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition1");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition2","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Vendor",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition2");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition3","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition3");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice Total",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition5","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Invoice Total",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition5");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending amount Off",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition6","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending amount Off",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition6");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Auto Approve",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition7","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Auto Approve",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition7");
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
					browser,"purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Type",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3354_Condition8","purchasesBundle_US846_TC3354",
					"user should be able to toggle between ascending and descending Type",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3354_Condition8");
		}
	}

	//TC3429 : UI/UX Retrofit - Purchases - View History: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3429() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		if (purchasesPage.RestoreManualInvoice_DeletedInvoice_List.size()>0) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3429",
					"deleted invoices display in 'Restore Invoice' modal",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3429","purchasesBundle_US846_TC3429",
					"deleted invoices display in 'Restore Invoice' modal",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3429");
		}
	}
	
	//TC3431 : UI/UX Retrofit - Purchases - View Ledger: No Ledger Info
	@Test()
	public void purchasesBundle_US846_TC3431() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = "55";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		if(storeLedgerDetailPage.StoreLedgerTable_Header.getAttribute("style").contains("display: none;")){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3431",
					"Verify no table headings display","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3431_Condition1","purchasesBundle_US846_TC3431",
					"Verify no table headings display", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3431_Condition1");
		}
		if (Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NoLedgerInfo_Img)
				& storeLedgerDetailPage.StoreLedgerTable_NoLedgerInfo_Msg.getText().contains("We don’t have any ledger information to show")
				& purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3431",
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3431_Condition2","purchasesBundle_US846_TC3431",
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3431_Condition2");
		}
	}
	
	//TC3432 : UI/UX Retrofit - Purchases - View Ledger: Default State
	@Test()
	public void purchasesBundle_US846_TC3432() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		if(!Base.isElementDisplayed(storeLedgerDetailPage.storeledger_Count)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3432",
					"'View Ledger' tab DOES NOT display a number for invoices in history","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3432_Condition1","purchasesBundle_US846_TC3432",
					"'View Ledger' tab DOES NOT display a number for invoices in history", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3432_Condition1");
		}
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		System.out.println("month_DD_FirstElement "+storeLedgerDetailPage.month_DD_FirstElement.getAttribute("value"));
		if (Base.isElementDisplayed(storeLedgerDetailPage.month_DD)
				& storeLedgerDetailPage.month_DD_FirstElement.getAttribute("value").equals(startDate)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3432",
					"filter criteria displays:  Month and  filter criteria defaults:  Month = Last Closed Month' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3432_Condition2","purchasesBundle_US846_TC3432",
					"filter criteria displays:  Month and  filter criteria defaults:  Month = Last Closed Month",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3432_Condition2");
		}
	}
	
	//TC3433 : UI/UX Retrofit - Purchases - View Ledger: Default State
	@Test()
	public void purchasesBundle_US846_TC3433() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendorName = "Vendor176";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
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
					browser,"purchasesBundle_US846_TC3433",
					"'Create Manual Invoice' button exists on page header and table columns include:  Delivery Date, Invoice, "
					+ "Type,  Invoice Total, Food, Paper, Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, "
					+ "Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3433_Condition1","purchasesBundle_US846_TC3433",
					"'Create Manual Invoice' button exists on page header and table columns include:  Delivery Date, Invoice, "
					+ "Type,  Invoice Total, Food, Paper, Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, "
					+ "Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3433_Condition1");
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
					browser,"purchasesBundle_US846_TC3433",
					" 'Grand Total' line displays below the heading providing totals for Invoice Total, Food, Paper,"
					+ " Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, Non-Product Other, Tax 1, "
					+ "Tax 2, Tax 3, Sales Tax","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3433_Condition2","purchasesBundle_US846_TC3433",
					"'Grand Total' line displays below the heading providing totals for Invoice Total, Food, Paper,"
					+ " Non-Product, Ops Supplies, Linens, Non-Product Happy Meal Premiums, Non-Product Other, Tax 1, "
					+ "Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3433_Condition2");
		}
		
		if(storeLedgerDetailPage.verifyVendorGroupIsDisplayed(vendorName)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3433",
					"Verify activity is displayed by vendor","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3433_Condition3","purchasesBundle_US846_TC3433",
					"Verify activity is displayed by vendor", "Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3433_Condition3");
		}
		
		if (purchasesPage.RestorePurchases_Msg.getText().contains("Oops, accidentally delete a manual purchase?")
				& Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3433",
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice' button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3433_Condition4","purchasesBundle_US846_TC3433",
					"inventory icon displays with message 'We don’t have any ledger information to show"
					+ "and restore deleted invoice message 'Oops, accidentally deleted a manual invoice?' displays with 'Restore Invoice",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3433_Condition4");
		}
		
	}

	//TC3434 : UI/UX Retrofit - Purchases - View Ledger: Sort Defaults
	@Test()
	public void purchasesBundle_US846_TC3434() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendorName = "Vendor176";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		// select last month from the dropdown
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get last month and year
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -1);
		cal2.set(Calendar.DATE, 1);
		String date = dateFormat.format(cal2.getTime());
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(3000);
		storeLedgerDetailPage.clickOnVendorGroup(vendorName);
		if (storeLedgerDetailPage.verifyDeliveryDateInDescendingOrder(vendorName)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3434",
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3434","purchasesBundle_US846_TC3434",
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3434");
		}
	}
	
	//TC3435 : UI/UX Retrofit - Purchases - View Ledger: Sorting
	@Test()
	public void purchasesBundle_US846_TC3435() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		// select last month from the dropdown
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get last month and year
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -1);
		cal2.set(Calendar.DATE, 1);
		String date = dateFormat.format(cal2.getTime());
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
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
					browser,"purchasesBundle_US846_TC3435",
					"Sorting functionality is not provided for Store Ledger Details Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3435","purchasesBundle_US846_TC3435",
					"Sorting functionality is not provided for Store Ledger Details Page",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3435");
		}
	}
	
	//TC3437 : UI/UX Retrofit - Purchases - View Ledger: Restore Deleted Invoices (Access)
	@Test()
	public void purchasesBundle_US846_TC3437() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		purchasesPage.RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.RestoreManualInvoice_Title));
		if (purchasesPage.RestoreManualInvoice_DeletedInvoice_List.size()>0) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US846_TC3437",
					"deleted invoices display in 'Restore Invoice' modal",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US846_TC3437","purchasesBundle_US846_TC3437",
					"deleted invoices display in 'Restore Invoice' modal",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US846_TC3437");
		}
	}
	

}
