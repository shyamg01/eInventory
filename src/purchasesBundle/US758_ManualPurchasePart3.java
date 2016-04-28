package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.ReadTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.ViewPurchaseHistoryPage;
import sprint2.AbstractTest;

public class US758_ManualPurchasePart3 extends AbstractTest{
	
	//TC1356 : Verify the subtotal $ amounts shown for pending manual purchase need to be calculated the same as the subtotals shown for electronic invoice.
	@Test()
	public void purchasesBundle_US758_TC1356() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US758_TC1356", "Object1");
		String wrinId1 = ReadTestData.getTestData(purchasesPageSheet,"WrinId1");
		String wrinId2 = ReadTestData.getTestData(purchasesPageSheet,"WrinId2");
		String vendor = ReadTestData.getTestData(purchasesPageSheet,"Vendor");
		String quantity = ReadTestData.getTestData(purchasesPageSheet,"Quantity");
		String pricePerCase = ReadTestData.getTestData(purchasesPageSheet,"Price Per Case");
		String electronicInvoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId1);
		manualInvoiceNewPage.enterQuantityForMultipleWrin(wrinId1, quantity);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId2);
		manualInvoiceNewPage.enterQuantityForMultipleWrin(wrinId2, quantity);
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys("");
		Thread.sleep(1500); 
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceId);
		// Enter the quantity
		manualInvoiceNewPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG));
		Thread.sleep(8000); 
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		String manualInvoice_subTotalWrin1 = purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId1);
		String manualInvoice_subTotalWrin2 = purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId2);
		purchasesPage.ManualInvoiceApprove_Close_BT.click();
		System.out.println("manualInvoice_subTotalWrin1 "+manualInvoice_subTotalWrin1);
		System.out.println("manualInvoice_subTotalWrin2 "+manualInvoice_subTotalWrin2);
		purchasesPage.clickOnApproveButtonForManualPurchase(electronicInvoiceId);
		String electronicInvoice_subTotalWrin1 = purchasesPage.getSubTotalForWrinItemForElectronicInvoice(wrinId1);
		String electronicInvoice_subTotalWrin2 = purchasesPage.getSubTotalForWrinItemForElectronicInvoice(wrinId2);
		purchasesPage.ManualInvoiceApprove_Close_BT.click();
		
		if (manualInvoice_subTotalWrin1.equals(electronicInvoice_subTotalWrin1)
				& manualInvoice_subTotalWrin2.equals(electronicInvoice_subTotalWrin2) ) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1356",
					"Subtotal $ amounts= abc for same wrinId should be same for pending manual purchase and pending electronic purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1356","purchasesBundle_US758_TC1356",
					"Subtotal $ amounts= abc for same wrinId should be same for pending manual purchase and pending electronic purchase",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1356");
		}
	}
	
	//TC1367 : Verify the date and time selection post clicking "Approve" button for pending manual purchase.
	@Test()
	public void purchasesBundle_US758_TC1367() throws RowsExceededException,
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
		System.out.println("Date "+purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value"));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String date = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+date);
		if (purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value").equals("")
				& Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_Approve_BT)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1367",
					"User should be able to view date as current date in calendar section in Manual Invoice Approve Form",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1367","purchasesBundle_US758_TC1367",
					"User should be able to view date as current date in calendar section in Manual Invoice Approve Form",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1367");
		}
	}
	
	//TC1369 : Verify no future dates or dates past the current date is selected on the calendar date selector, once the manual purchase is approved.
	@Test()
	public void purchasesBundle_US758_TC1369() throws RowsExceededException,
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
		String pastDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(6000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 0);
		String todayDate = dateFormat.format(cal1.getTime());
		System.out.println("today "+todayDate);
		boolean currentDateIsSelected = purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value").contains(todayDate);
		if (currentDateIsSelected) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1367",
					"User should be able to view date as current date in calendar section in Manual Invoice Approve Form ","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1367_Condition1","purchasesBundle_US758_TC1367",
					"User should be able to view date as current date in calendar section in Manual Invoice Approve Form",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1367_Condition1");
		}
		purchasesPage.selectDateForApproveInvoice(pastDate);
		purchasesPage.ApproveManualInvoice_PopUp_Lable.click();
		System.out.println("Past Date "+purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value"));
		boolean pastDateIsNotSelected = !purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value").contains(pastDate);
		if ( pastDateIsNotSelected) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1367",
					"User should not be able to select past date","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1367_Condition2","purchasesBundle_US758_TC1367",
					"User should not be able to select past date",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1367_Condition2");
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 1);
		String futureDate = dateFormat.format(cal2.getTime());
		purchasesPage.selectDateForApproveInvoice(futureDate);
		purchasesPage.ApproveManualInvoice_PopUp_Lable.click();
		System.out.println("futureDate "+purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value"));
		boolean futureDateIsNotSelected = !purchasesPage.ApproveManualInvoice_Date_TB.getAttribute("value").contains(futureDate);
		if (futureDateIsNotSelected) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1367",
					"User should not be able to select future date","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1367_Condition3","purchasesBundle_US758_TC1367",
					"User should not be able to select future date",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1367_Condition3");
		}
	}
	
	//TC1370 : Verify manual purchase details screen from purchase history.
	@Test()
	public void purchasesBundle_US758_TC1370() throws RowsExceededException,
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
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, pricePerCase);
		Thread.sleep(6000);
		purchasesPage.approveAManualInvoice(invoiceId, date);
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
					browser,"purchasesBundle_US758_TC1370",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1370_Condition1","purchasesBundle_US758_TC1370",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1370_Condition1");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1370",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1370_Condition3","purchasesBundle_US758_TC1370",
					"Verify 'Invoice Date', 'Invoice', and 'Vendor' labels w/data are included",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1370_Condition3");
		}
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_WRIN_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Description_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_CasesPurchased_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_PricePerCase_Header)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1370",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1370_Condition4","purchasesBundle_US758_TC1370",
					"Verify form includes table w/headings:  WRIN, Description, Cases Purchased, Price Per Case, Subtotal (read-only)",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1370_Condition4");
		}
		
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Label)
				& !viewPurchaseHistoryPage.ViewInvoiceForm_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1370",
					"Verify 'Grand Total' is included at end of table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1370_Condition5","purchasesBundle_US758_TC1370",
					"Verify 'Grand Total' is included at end of table",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1370_Condition5");
		}
	}
	
	//TC1483 : Verify the information contained for posted invoice  is sent to the store ledger.
	@Test()
	public void purchasesBundle_US758_TC1483() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
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
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, "");
		Thread.sleep(6000);
		purchasesPage.approveAManualInvoice(invoiceId, date);
		Thread.sleep(5000);
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		if(storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendor, date, invoiceId)){
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC1483",
					"User should be able to view the details of transition in store ledger detail page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC1483","purchasesBundle_US758_TC1483",
					"User should be able to view the details of transition in store ledger detail page",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC1483");
		}
			
	}
	
	//TC3467 : Verify that the user is able to view the user that approved the manual invoice(name last name initial, eid) and date selected when approved
	@Test()
	public void purchasesBundle_US758_TC3467() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId, quantity, "");
		Thread.sleep(6000);
		purchasesPage.approveAManualInvoice(invoiceId, date);
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
					browser,"purchasesBundle_US758_TC3467",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC3467_Condition1","purchasesBundle_US758_TC3467",
					"Verify form header includes: Title 'View Invoice', 'Source: Manual', 'Created By: Preparer Name'",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC3467_Condition1");
		}
		System.out.println("Date "+viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText());
		if (Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Label)
				& Base.isElementDisplayed(viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Label)
				& viewPurchaseHistoryPage.ViewInvoiceForm_InvoiceDate_Value.getText().equals("date")
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Invoice_Value.getText().isEmpty()
				& !viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"purchasesBundle_US758_TC3467",
					"Verify user should be able to view invoice date as the date when invoice was approved in View history page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchasesBundle_US758_TC3467_Condition2","purchasesBundle_US758_TC3467",
					"Verify user should be able to view invoice date as the date when invoice was approved in View history page",
					"Fail");
			AbstractTest.takeSnapShot("purchasesBundle_US758_TC3467_Condition2");
		}
	}
}
