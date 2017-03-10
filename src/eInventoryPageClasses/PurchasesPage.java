package eInventoryPageClasses;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.Reporter;

public class PurchasesPage extends AbstractPage
{
	public PurchasesPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h1[text()='Purchases']")
	public WebElement Purchases_Label;	
	
	@FindBy(xpath="//b[text()='Audit For Manual Purchase Invoice on ']")
	public WebElement AuditPopUp_AuditForManualPurchase_Title; 
	
	@FindBy(xpath="//button[@value='Create Manual Invoice']")
	public WebElement CreateManualInvoice_BT; 
	
	@FindBy(xpath = "//table[@id='eb_purchase_table']/tbody/tr")
	public List<WebElement> PendingPurchase_List;
	
	@FindBy(xpath = "//table[@id='eb_adjustment_table']/tbody/tr[@role='row']")
	public List<WebElement> PendingAdjustments_List;
	
	/*****Purchase Page Tab and Count locater***/
	
	@FindBy(xpath="//a[text()='View Ledger']")
	public WebElement ViewLedger_BT;
	
	@FindBy(xpath="//a[text()='View History']")
	public WebElement ViewHistory_BT; 
	
	@FindBy(xpath = "//a[text()='Approve Pending']")
	public WebElement ApprovePending_BT;
	
	@FindBy(xpath = "//a[text()='Approve Pending']/span")
	public WebElement ApprovePendingTab_Count;
	
	@FindBy(xpath = "//a[text()='Approve Adjustments']")
	public WebElement ApproveAdjustments_BT;	
	/*****ViewHistory Section***/
	
	@FindBy(xpath="//input[@id='history_start_date']")
	public WebElement ViewHistory_StartDate_TB; 
	
	@FindBy(xpath="//input[@id='history_end_date']")
	public WebElement ViewHistory_EndDate_TB; 
	
	@FindBy(xpath="//div[@id='eb_dd_input']")
	public WebElement ViewHistory_Vendor_DD; 
	
	@FindBy(xpath="//button[@id='htmlButton' and @value='Show Results']")
	public WebElement ViewHistory_ShowResults_BT; 
	
	@FindBy(xpath="//h2[text()='View Purchase']")
	public WebElement ViewInvoice_PopUp_Label; 	
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[1]")
	public WebElement ViewHistory_DeliveryDate_Column_Header; 	
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[2]")
	public WebElement ViewHistory_Vendor_Column_Header; 
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[3]")
	public WebElement ViewHistory_Invoice_Column_Header; 
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[4]")
	public WebElement ViewHistory_InvoiceTotal_Column_Header; 
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[5]")
	public WebElement ViewHistory_AmountOff_Column_Header; 
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[6]")
	public WebElement ViewHistory_AutoApprove_Column_Header;
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/thead/tr/th[7]")
	public WebElement ViewHistory_Type_Column_Header; 
	
	/*****Restore Invoice Form *******/
	@FindBy(xpath="//eb-button[@id='restore_purchases']/button")
	public WebElement RestorePurchases_BT;
	
	@FindBy(xpath="//h2[text()='Restore Manual Invoice']")
	public WebElement RestoreManualInvoice_Title;
	
	@FindBy(xpath="//eb-button[@id='restore_purchase_modal_restore_btn']/button")
	public WebElement RestoreManualInvoice_Restore_BT;
	
	@FindBy(xpath="//eb-button[@id='restore_purchase_modal_restore_btn']/button")
	public WebElement RestoreManualInvoice_Cancel_BT;
	
    @FindBy(xpath="//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'restore purchase(s)?')]")
	public WebElement RestorePurchasesConfirmationPopUp_Warning_Msg;
	
	@FindBy(xpath="//th[text()='All']")
	public WebElement RestoreManualInvoice_All_Header;	
	@FindBy(xpath="//th[text()='Invoice Date']")
	public WebElement RestoreManualInvoice_InvoiceDate_Header;
	
	@FindBy(xpath="//th[text()='Invoice']")
	public WebElement RestoreManualInvoice_Invoice_Header;
	
	@FindBy(xpath="//th[text()='Vendor']")
	public WebElement RestoreManualInvoice_Vendor_Header;
	
	@FindBy(xpath="//div[@id='restore_purchase_modal_content']/div/div/div/p[contains(text(),'We don’t have any invoices,')]/following-sibling::p[contains(text(),'deleted within the past 10 days, to show.')]")
	public WebElement RestoreManualInvoice_NoDeletedInvoicePresent_Msg;
	
	@FindBy(xpath = "//eb-modal[@id='restore_purchase_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement RestoreManualInvoice_Cross_BT;
	
	@FindBy(xpath = "//eb-button[@id='restore_purchase_modal_close_btn']/button")
	public WebElement RestoreManualInvoice_Close_BT;
	
	@FindBy(xpath="//eb-container-messagebox/div/div/div[contains(text(),'Oops, accidentally delete')]/following-sibling::div[contains(text(),'a manual invoice?')]")
	public WebElement RestorePurchases_Msg;
	
	@FindBy(xpath="//span[contains(text(),'Deleted manual invoices are retained for up to 10 days')]")
	public WebElement RestoreManualInvoice_TimeDisclaimer_Msg;
	
	@FindBy(xpath=".//span[contains(text(),'Select the invoices you want to restore')]")
	public WebElement RestoreManualInvoice_SelectInvoice_Msg;
	
	@FindBy(xpath = "//table[@id='deleted_purchases']/tbody/tr")
	public List<WebElement> RestoreManualInvoice_DeletedInvoice_List;
	
	@FindBy(xpath = "//table[@id='deleted_purchases']/tbody/tr/td[@class='restore_purchase select-checkbox']")
	public List<WebElement> RestoreManualInvoice_SelectBox_List;
	
	@FindBy(xpath = "//table[@id='deleted_purchases']/thead/tr/th[contains(@class,'dt-select-all-checkbox')]")
	public WebElement RestoreManualInvoice_SelectAll_CB;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[2]")
	public WebElement RestoreManualInvoice_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='restore_purchase_modal']/div[contains(@class,'container')]")
	public WebElement RestoreManualInvoice_Container;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Invoice Restored']")
	public WebElement RestoredInvoiceAdded_Msg;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement RestoreManualInvoice_ConfirmationPopUp_Yes_BT;
	
	/**************Approve Pending Table Column Headers**********/
	
	@FindBy(xpath="//th[text()='Delivery Date' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_DeliveryDate_Header;
	
	@FindBy(xpath="//th[text()='Status' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_Status_Header;
	
	@FindBy(xpath="//th[text()='Vendor' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_Vendor_Header;
	
	@FindBy(xpath="//th[text()='Invoice' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_Invoice_Header;
	
	@FindBy(xpath="//th[text()='Invoice Total' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_InvoiceTotal_Header;
	
	@FindBy(xpath="//th[text()='Amount Off' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_AmountOff_Header;
	
	@FindBy(xpath="//th[text()='Auto Approve' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_AutoApprove_Header;
	
	@FindBy(xpath="//th[text()='Type' and @aria-controls = 'eb_purchase_table']")
	public WebElement ApprovePendingTable_Type_Header;
	
	@FindBy(xpath="//td[@class='dataTables_empty']/div[2]/p")
	public WebElement ApprovePendingTable_NoPendingPurchases_Msg;
	
	@FindBy(xpath="//td[@class='dataTables_empty']/div[1]/img")
	public WebElement ApprovePendingTable_NoPendingPurchases_Img;

	@FindBy(xpath="//eb-container-messagebox/div/div/div[contains(text(),'Oops, accidentally delete')]/following-sibling::div[contains(text(),'a manual invoice?')]")
	public WebElement MissingInvoice_Msg;
	/**********Approve Pending PopUp****/

	@FindBy(xpath="//h2[text()='Purchase']")
	public WebElement ApproveManualInvoice_PopUp_Lable;
	
	@FindBy(xpath="//input[@id='purchase_modal_date_input']")
	public WebElement ApproveManualInvoice_SelectDate_TB;
	
	@FindBy(xpath ="//div[@id ='eb_tp_input']")
	public WebElement ApproveManualInvoice_SelectTime_TB;
	
	@FindBy(xpath ="//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span']")
	public WebElement ApproveManualInvoice_hourSpan_Value;
	
	@FindBy(xpath ="//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span']")
	public WebElement ApproveManualInvoice_MinSpan_Value;
	
	@FindBy(xpath="//button[@role='button' and @value='Delete']")
	public WebElement ApproveManualInvoice_PopUp_Delete_BT;
	
	@FindBy(xpath="//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'delete this manual invoice?')]")
	public WebElement ApproveManualInvoice_PopUp_Confirmation_MSG;
	
	@FindBy(xpath="//button[@id='htmlButton']/span[text()='Yes']")
	public WebElement ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT;
	
	@FindBy(xpath="//button[@id='htmlButton']/span[text()='No']")
	public WebElement ApproveManualInvoice_PopUp_ConfirmationMessage_No_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Invoice deleted.']")
	public WebElement ApproveManualInvoice_PopUp_InvoiceDelete_Confirmation_MSG;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Approved purchase saved']")
	public WebElement ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG;
	
	@FindBy(xpath="//input[@id='purchase_modal_date_input']")
	public WebElement ApproveManualInvoice_Date_TB;
	
	@FindBy(xpath = "//eb-button[@id='purchase_modal_approve_btn']/button")
	public WebElement ApproveManualInvoice_Approve_BT;
	
	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement ManualInvoiceApprove_ConfirmationPopUp_No_BT;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement ManualInvoiceApprove_ConfirmationPopUp_Yes_BT;

	@FindBy(xpath = "//eb-button[@id='purchase_modal_cancel_btn']/button")
	public WebElement ManualInvoiceApprove_Cancel_BT;
	
    @FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'cancel this manual invoice?')]")
	public WebElement ManualInvoiceApproveForm_ConfirmCancel_Message;
	
    @FindBy(xpath = "//eb-modal[@id='purchase_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement ManualInvoiceApprove_Close_BT;
	
	@FindBy(xpath="(//th[text()='WRIN'])[2]")
	public WebElement ManualInvoiceApprove_WRIN_Label;
	
	@FindBy(xpath="(//th[text()='Description'])[2]")
	public WebElement ManualInvoiceApprove_Description_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Cases Purchased']")
	public WebElement ManualInvoiceApprove_CasePurchased_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Price Per Case']")
	public WebElement ManualInvoiceApprove_PricePerCase_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Sub total']")
	public WebElement ManualInvoiceApprove_SubTotal_Label;
	
	@FindBy(xpath="//h3[text()='Break Down By Cost Type']")
	public WebElement ManualInvoiceApprove_BreakDownByCostType_Label;
	
	@FindBy(xpath="//div[@id='total_row']/div[2]/div[2]/span[contains(text(),'Total Food:')]")
	public WebElement ManualInvoiceApprove_TotalFood_Section;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement ManualInvoiceApprove_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='purchase_modal']/div[contains(@class,'container')]")
	public WebElement ManualInvoiceApproveForm_Container;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'approve this manual invoice?')]")
	public WebElement ManualInvoiceApproveForm_ConfirmApprove_Message;
	
	@FindBy(xpath="//div[text()='Source: Manual']")
	public WebElement ManualInvoiceApprove_ManualSource_Label;
	
	@FindBy(xpath="//div[@id='subtitle_name']")
	public WebElement ManualInvoiceApprove_CreatedBy_Label;
	
	@FindBy(xpath="//span[contains(text(),'Vendor:')]")
	public WebElement ManualInvoiceApprove_Vendor_Label;
	
	@FindBy(xpath="//span[contains(text(),'Vendor:')]/span")
	public WebElement ManualInvoiceApprove_Vendor_Value;
	
	@FindBy(xpath="//span[contains(.,'Invoice:')]")
	public WebElement ManualInvoiceApprove_InvoiceNumber_Label;
	
	@FindBy(xpath="//span[contains(.,'Invoice:')]/span")
	public WebElement ManualInvoiceApprove_InvoiceNumber_Value;
	
	@FindBy(xpath="//eb-datepicker[@id='purchase_modal_date_picker']/div/label[contains(.,'Date:')]")
	public WebElement ManualInvoiceApprove_Date_Label;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[2]/span[contains(text(),'Invoice Date:')]")
	public WebElement ApproveInvoiceForm_InvoiceDate_Label;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[2]/span[contains(text(),'Invoice Date:')]/span")
	public WebElement ApproveInvoiceForm_InvoiceDate_Value;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[1]/span[contains(text(),'Invoice:')]")
	public WebElement ApproveInvoiceForm_Invoice_Label;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[1]/span[contains(text(),'Invoice:')]/span")
	public WebElement ApproveInvoiceForm_Invoice_Value;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[3]/span[contains(text(),'Vendor:')]")
	public WebElement ApproveInvoiceForm_Vendor_Label;
	
	@FindBy(xpath="//div[@id='outside_table']/div/div[3]/span[contains(text(),'Vendor:')]/span")
	public WebElement ApproveInvoiceForm_Vendor_Value;
	
	@FindBy(xpath = "//div[@id='purchase_content']/div[2]/div[2]/span[contains(text(),'Grand Total:')]")
	public WebElement ApproveInvoiceForm_GrandTotal_Label;
	
	@FindBy(xpath = "//span[@id='grand_amount']/strong")
	public WebElement ApproveInvoiceForm_GrandTotal_Value;
	
	/**************Approve Electronic Invoice*************************/
	
	@FindBy(xpath="//h2[text()='Purchase']")
	public WebElement ApproveElectronicInvoice_PopUp_Lable;
	
	@FindBy(xpath="//input[@id='purchase_modal_date_input']")
	public WebElement ApproveElectronicInvoice_Date_TB;
	
	@FindBy(xpath="//div[@id ='eb_tp_input']/span")
	public WebElement ApproveElectronicInvoice_Time_TB;
	
	@FindBy(xpath ="//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span']")
	public WebElement ApproveElectronicInvoice_hourSpan_Value;
	
	@FindBy(xpath ="//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span']")
	public WebElement ApproveElectronicInvoice_MinSpan_Value;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Approved purchase saved']")
	public WebElement ApproveElectronicInvoice_PopUp_InvoiceApprove_Confirmation_MSG;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='WRIN']")
	public WebElement ApproveElectronicInvoice_WRIN_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Description']")
	public WebElement ApproveElectronicInvoice_Description_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Cases Purchased']")
	public WebElement ApproveElectronicInvoice_CasePurchased_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Price Per Case']")
	public WebElement ApproveElectronicInvoice_PricePerCase_Label;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/thead/tr/th[text()='Sub total']")
	public WebElement ApproveElectronicInvoice_SubTotal_Label;
	
	
	//To verify purchase landing page loaded successfully	
	public boolean isPurchaseLandingPageLoaded() {
		wait.until(ExpectedConditions.visibilityOf(Purchases_Label));
		 /* User should be able to view approve pending, approve adjustments,
		 create manual invoices, view history, view ledger button on purchase page  */
		return Base.isElementDisplayed(ApprovePending_BT) & Base.isElementDisplayed(ApproveAdjustments_BT)
				& Base.isElementDisplayed(CreateManualInvoice_BT) & Base.isElementDisplayed(ViewHistory_BT)
				& Base.isElementDisplayed(ViewLedger_BT);
	}
	
	// Go to Create manual invoice page
	public ManualInvoiceNewPage goToManualInvoiceNewPage() {
		wait.until(ExpectedConditions.elementToBeClickable(CreateManualInvoice_BT)).click();
		ManualInvoiceNewPage manualInvoiceNewPage=PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.elementToBeClickable(manualInvoiceNewPage.CreateManualInvoice_Vendor_DD));
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}
	
	// click on View Store Ledger Button
	public StoreLedgerDetailPage clickOnViewStoreLedgerButton() {
		ViewLedger_BT.click();
		// Wait for the Store Ledger title
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		return PageFactory.initElements(driver, StoreLedgerDetailPage.class);
	}
	
	public boolean verifyRemoveWrinOptionIsNotPresent() throws InterruptedException{
		List<WebElement> removeChkBox = driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(@class,' select-checkbox')]"));
		System.out.println("removeChkBox "+ removeChkBox.size());
		return removeChkBox.size()==0;
	}

	public int getNumberOfRecords() {
		return driver.findElements(By.xpath("//table[@id='purchases_selection_table']/tbody/tr")).size();
	}

	//@Author : Hemlata
	public String getSubtotalValueForWrinInManualInvoice(String WRINId){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='invoice_tbl_body']")));
		return driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"+WRINId+"')]/following-sibling::td[6]")).getText();
	}
	
	public String getSubtotalValueForWrinInElectronicInvoice(String WRINId){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='purchase_detail_table']")));
		return driver.findElement(By.xpath("(//table[@id='purchase_detail_table']/tbody/tr/td/span[contains(text(),'"+WRINId+"')]/../following-sibling::td[5]")).getText();
	}
	
	public String getSubTotalAmountForElectronicInvoice(){
		List<WebElement>rawItemList = driver.findElements(By.xpath("//table[@id='purchase_detail_table']/tbody/tr[@role='row']"));
		BigDecimal rawItemCost = new BigDecimal(0.00);
		for(int i= 1;i<=rawItemList.size();i++){
		rawItemCost = rawItemCost.add(new BigDecimal(driver.findElement(By.xpath("(//table[@id='purchase_detail_table']/tbody/tr[@role='row'])["+i+"]/td[6]")).getText().substring(1)));
		}
		return String.valueOf(rawItemCost);
	}
	
	public void restoreDeletedPurchases(String invoiceId)throws InterruptedException{
		Base.toReachbottomOfthePage();
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		RestorePurchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(RestoreManualInvoice_Title));
		restoreInvoice(invoiceId);
	}
	
	public void restoreInvoice(String invoiceId)throws InterruptedException{
		driver.findElement(By.xpath("//tr[contains(@class,'deleted_purchases_history')]/td[text()='"+invoiceId+"']/preceding-sibling::td[@class='restore_purchase select-checkbox']")).click();
		wait.until(ExpectedConditions.visibilityOf(RestoreManualInvoice_Restore_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(RestoreManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(5000);
	}
	
	public boolean verifyApproveButtonDisplayedForRecordsWithNeedsApprovalStatus(){
		List<WebElement>purchaseList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[text()='Needs Approval!']"));
		boolean result = true;
		for(int i=1;i<=purchaseList.size();i++){
			result = result & Base.isElementDisplayed(By.xpath("(//table[@id='eb_purchase_table']/tbody/tr/td[text()='Needs Approval!'])["+i+"]/following-sibling::td/eb-button[@id='eb_approve_button']"));
		}
		return result;
	}

	public boolean verifyViewButtonDisplayedForRecords(){
		List<WebElement>purchaseList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[text()='Exceeds Variance!']"));
		boolean result = true;
		for(int i=1;i<=purchaseList.size();i++){
			result = result & Base.isElementDisplayed(By.xpath("(//table[@id='eb_purchase_table']/tbody/tr/td[text()='Exceeds Variance!'])["+i+"]/following-sibling::td/eb-button[@id='eb_view_button']"));
		}
		return result;
	}
	
	public boolean verifyDeliverDateInDescendingOrder() throws ParseException
	{
		List<WebElement>dateList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[1]/span[2]"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyDateInDescendingOrder(dateValueList);
	}
	
	public boolean verifyDeliverDateInAscendingOrder() throws ParseException{
		List<WebElement>dateList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[1]/span[2]"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyDateInAscendingOrder(dateValueList);
	}
	
	public boolean verifyStatusInDescendingOrder() throws ParseException{
		List<WebElement>statusList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[2]"));
		List<String>statusValueList = Base.getTextListFromWebElements(statusList);
		return Base.verifyStringInDescendingOrder(statusValueList);
	}
	
	public boolean verifyStatusInAscendingOrder() throws ParseException{
		List<WebElement>statusList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[2]"));
		List<String>statusValueList = Base.getTextListFromWebElements(statusList);
		return Base.verifyStringInAsscendingOrder(statusValueList);
	}
	
	public boolean verifyVendorInDescendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[3]/span"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInDescendingOrder(vendorValueList);
	}
	
	public boolean verifyVendorInAscendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[3]/span"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInAsscendingOrder(vendorValueList);
	}
	
	public boolean verifyInvoiceInDescendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[4]/span"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyBigIntInDescendingOrder(invoiceValueList);
	}
	
	public boolean verifyInvoiceInAscendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[4]/span"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyBigIntInAsscendingOrder(invoiceValueList);
	}
	
	public boolean verifyInvoiceTotalInDescendingOrder() throws ParseException{
		List<WebElement>invoiceTotalList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[5]"));
		List<String>invoiceTotalValueList = Base.getTextListFromWebElements(invoiceTotalList);
		return Base.verifyAmountIsInDescendingOrder(invoiceTotalValueList);
	}
	
	public boolean verifyInvoiceTotalInAscendingOrder() throws ParseException{
		List<WebElement>invoiceTotalList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[5]"));
		List<String>invoiceTotalValueList = Base.getTextListFromWebElements(invoiceTotalList);
		return Base.verifyAmountIsInAscendingOrder(invoiceTotalValueList);
	}
	
	public boolean verifyAmountOffInDescendingOrder() throws ParseException{
		List<WebElement>amountOffList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[6]/span"));
		ArrayList<String>amountOffListValueList = new ArrayList<String>();
		for(WebElement amountOff : amountOffList){
			String amount = amountOff.getText();
			amount = amount.substring(1, amount.length()-3);
			amountOffListValueList.add(amount);
		}
		return Base.verifyAmountIsInDescendingOrder(amountOffListValueList);
	}
	
	public boolean verifyAmountOffInAscendingOrder() throws ParseException{
		List<WebElement>amountOffList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[6]/span"));
		ArrayList<String>amountOffListValueList = new ArrayList<String>();
		for(WebElement amountOff : amountOffList){
			String amount = amountOff.getText();
			amount = amount.substring(1, amount.length()-3);
			amountOffListValueList.add(amount);
		}
		return Base.verifyAmountIsInAscendingOrder(amountOffListValueList);
	}
	
	public boolean verifyAutoApproveInDescendingOrder() throws ParseException{
		List<WebElement>autoApproveList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[7]/span"));
		List<String>autoApproveValueList = Base.getTextListFromWebElements(autoApproveList);
		return Base.verifyStringInDescendingOrder(autoApproveValueList);
	}
	
	public boolean verifyAutoApproveInAscendingOrder() throws ParseException{
		List<WebElement>autoApproveList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[7]/span"));
		List<String>autoApproveValueList = Base.getTextListFromWebElements(autoApproveList);
		return Base.verifyStringInAsscendingOrder(autoApproveValueList);
	}
	
	public boolean verifyTypeInDescendingOrder() throws ParseException{
		List<WebElement>typeList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[8]/span"));
		List<String>typeValueList = Base.getTextListFromWebElements(typeList);
		return Base.verifyStringInDescendingOrder(typeValueList);
	}
	
	public boolean verifyTypeInAscendingOrder() throws ParseException{
		List<WebElement>typeList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[8]/span"));
		List<String>typeValueList = Base.getTextListFromWebElements(typeList);
		return Base.verifyStringInAsscendingOrder(typeValueList);
	}
	
	public boolean verifyNotificationDisplayedForExceedVariance(){
		List<WebElement>statusList = driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[text()='Exceeds Variance!']"));
		String toolTipMsgArea;
		if(statusList.size()>0){
			WebElement tootlTip = driver.findElement(By.xpath("(//table[@id='eb_purchase_table']/tbody/tr/td[text()='Exceeds Variance!'])[1]/following-sibling::td[4]/eb-tooltip/a"));
			tootlTip.click();
//			toolTipMsgArea = tootlTip.getAttribute("aria-describedby");
			toolTipMsgArea = tootlTip.getAttribute("data-toggle");
			System.out.println("toolTipMsgArea "+toolTipMsgArea);
			return toolTipMsgArea.contains("tooltip");
		}
		return true;
	}
	//This method will verify that pending transaction is displayed in purchase page
		public boolean verifyPendindInvoiceIsPresent(String invoiceNumber) throws RowsExceededException, BiffException, WriteException, IOException {
			return Base.isElementDisplayed((By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td/span[text()='"+invoiceNumber+"']")));
		}
	
	//Delete a Manual Invoice
	public PurchasesPage deleteAManualInvoice(String invoiceNumber) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException 
	{
		//click on the Approve button against the invoice number 
		clickOnApproveButtonForManualPurchase(invoiceNumber);
		Thread.sleep(3000);
		ApproveManualInvoice_PopUp_Delete_BT.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT));
		Thread.sleep(3000);
		ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT.click();
		wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_InvoiceDelete_Confirmation_MSG));
		Thread.sleep(3000);
		return PageFactory.initElements(driver, PurchasesPage.class);
		
	}
	
	public boolean verifyDeletedInvoiceAreSelectable(){
		boolean result = true;
		int i = 0;
		for(WebElement chkBox : RestoreManualInvoice_SelectBox_List){
			chkBox.click();
			result = result & RestoreManualInvoice_DeletedInvoice_List.get(i).getAttribute("class").contains("selected");
			i++;
		}
		return true;
	}
	
    public PurchasesPage selectDateForApproveInvoice(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
    	ApproveManualInvoice_Date_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);

		System.out.println("month"+month);
		/*selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();*/

		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		Reporter.reportPassResult(AbstractTest.browser, "Month "+Base.getMonthName(month+1)+"is selected in the calender", "Pass");
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")), "Day"+day);
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
    
    public PurchasesPage selectTimeForApproveInvoice(String time) throws InterruptedException{
    	ApproveManualInvoice_SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!ApproveManualInvoice_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_hour_up').click();");
		}
		String minuteValue = time.split(":")[1];
		while(!ApproveManualInvoice_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_min_up').click();");
		}
		ApproveManualInvoice_PopUp_Lable.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	
	public PurchasesPage clickOnApproveButtonForManualPurchase(String invoiceId) throws RowsExceededException, BiffException, WriteException, IOException, InterruptedException{
		WebElement approveButton = driver.findElement(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td/span[text()='"+invoiceId+"']/../following-sibling::td/eb-button[@id='eb_approve_button']/button"));
//		executor.executeScript("arguments[0].click();", approveButton);
		action.moveToElement(approveButton).build().perform();
		Thread.sleep(1500);
		executor.executeScript("arguments[0].click();", approveButton);
//		GenericMethods.clickOnElement(approveButton, "approveButton");
//		Reporter.reportPassResult(AbstractTest.browser, "Clicked on "+approveButton, "Pass");
		wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_Lable));
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	//Method to Approve a manual Invoice
	
public PurchasesPage approveAManualInvoice(String invoiceId) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{
	clickOnApproveButtonForManualPurchase(invoiceId);
	wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_Lable));
	//selectDateForApproveInvoice(approveDate);
	//selectTimeForApproveInvoice(GlobalVariable.time);
	ApproveManualInvoice_Approve_BT.click();
	wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT));
	ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT.click();
	wait.until(ExpectedConditions.visibilityOf(ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG));
	Thread.sleep(5000);
	return PageFactory.initElements(driver, PurchasesPage.class);
}

	//Method to select the start date on View History page
	public PurchasesPage selectStartDate(String startDate) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
	
		GenericMethods.clickOnElement(ViewHistory_StartDate_TB, "ViewHistory_StartDate_TB");
		Thread.sleep(3000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		Reporter.reportPassResult(AbstractTest.browser, "Month "+Base.getMonthName(month+1)+"is selected in calendar", "Pass");
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")), " Date "+day);
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	//Method to View the invoice in View History page that is already approved
	public PurchasesPage viewApprovedInvoiceOnViewHistory(String invoiceId,String startDate) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
			GenericMethods.clickOnElement(ViewHistory_BT, "ViewHistory_BT");
			wait.until(ExpectedConditions.visibilityOf(ViewHistory_ShowResults_BT));
			Thread.sleep(4000);
//			selectDateForApproveInvoice(date);
			selectStartDate(startDate);
			Thread.sleep(2000);
			GenericMethods.clickOnElement(ViewHistory_Vendor_DD, "ViewHistory_Vendor_DD");
			Thread.sleep(2000);
			GenericMethods.clickOnElement(ViewHistory_ShowResults_BT, "ViewHistory_ShowResults_BT");
			Thread.sleep(10000);
			//click on the View button against the invoice number 
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[8][preceding-sibling::td/span[text()='"+invoiceId+"']]/eb-button/button[@value='View']")), "Invoice with Invoice Id "+invoiceId);
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(ViewInvoice_PopUp_Label));
			return PageFactory.initElements(driver, PurchasesPage.class);
		}
	
			
	public PurchasesPage clickOnApproveButtonForElectronicPurchase(String invoiceId) {
		driver.findElement(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td/span[text()='"+ invoiceId+ "']/../following-sibling::td/eb-button[@id='eb_approve_button']/button")).click();
		wait.until(ExpectedConditions.visibilityOf(ApproveElectronicInvoice_PopUp_Lable));
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	//Click on view button for  electronic invoice which is labeled as Exceeds variance
	public ViewPurchaseHistoryPage clickOnViewButtonForElectronicPurchase(String invoiceId) {
		driver.findElement(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td/span[text()='"+ invoiceId+ "']/../following-sibling::td/eb-button[@id='eb_view_button']/button")).click();
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewInvoiceForm_Title));
		return viewPurchaseHistoryPage;
	}
			
	public void selectTimeInApproveElectronicInvoiceForm(String time)throws InterruptedException {
		ApproveElectronicInvoice_Time_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while (!ApproveElectronicInvoice_hourSpan_Value.getText().equals(hourValue)) {
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[0].click();");
		}
		String minuteValue = time.split(":")[1];
		while (!ApproveElectronicInvoice_MinSpan_Value.getText().equals(minuteValue)) {
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[1].click();");
		}
		ApproveManualInvoice_PopUp_Lable.click();
		Thread.sleep(1000);
	}
	
	public PurchasesPage selectDateForApproveElectronicInvoice(String date) throws InterruptedException{
		ApproveElectronicInvoice_Date_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	public boolean verifyBackTimeIsSelected(String time) throws InterruptedException{
		ApproveElectronicInvoice_Time_TB.click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]")).getAttribute("class"));
		String hourValue = time.split(":")[0];
		while (!ApproveElectronicInvoice_hourSpan_Value.getText().equals(hourValue)) {
			Base.executeJavaScript("document.getElementById('eb_tp_hour_down').click();");
		}
		String minuteValue = time.split(":")[1];
		while (!ApproveElectronicInvoice_MinSpan_Value.getText().equals(minuteValue)) {
			Base.executeJavaScript("document.getElementById('eb_tp_min_down').click();");
		}
		ApproveElectronicInvoice_PopUp_Lable.click();
		Thread.sleep(1000);
		return ApproveElectronicInvoice_Time_TB.getText().equals(time) ;
	}
	
	public String getSubTotalForWrinItemForManualInvoice(String wrinId){
		return driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"+wrinId+"')]/following-sibling::td[contains(@class,'sub_total')]")).getText();
	}
	
	public String getSubTotalForWrinItemForElectronicInvoice(String wrinId){
		return driver.findElement(By.xpath("//table[@id='purchase_detail_table']/tbody/tr/td/span[contains(text(),'"+wrinId+"')]/../following-sibling::td[5]")).getText().substring(1);
	}
	
	public String getCasesPurchasedForAWrin(String wrinId){
		return driver.findElement(By.xpath("//table[@id='purchase_detail_table']/tbody/tr/td/span[contains(text(),'"+wrinId+"')]/../following-sibling::td[2]/span")).getText();
		
	}
	
	public String getBreakDownCostForEachCategory(String productCategory){
		String productCatergoryCost;
		switch (productCategory.toLowerCase()) {
        case "food":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_food_div']/div[2]/span[contains(text(),'Total Food')]/../following-sibling::div/span[@id='total_food']")).getText();
            break;
        case "ops supplies":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_ops_div']/div[2]/span[contains(text(),'Total Ops Supplies')]/../following-sibling::div/span[@id='total_ops']")).getText();
            break;
        case "paper":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_paper_div']/div[2]/span[contains(text(),'Total Paper')]/../following-sibling::div/span[@id='total_paper']")).getText();
            break;
        case "linens":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_linens_div']/div[2]/span[contains(text(),'Total Linens')]/../following-sibling::div/span[@id='total_linens']")).getText();
            break;
        case "others":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_other_div']/div[2]/span[contains(text(),'Total Other')]/../following-sibling::div/span[@id='total_other']")).getText();
            break;
        case "happy meal":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_happy_meal_div']/div[2]/span[contains(text(),'Total Happy  Meal')]/../following-sibling::div/span[@id='total_happy_meal']")).getText();
            break;
        default: 
			productCatergoryCost = "0";
			break;
		}
		return productCatergoryCost;
	}
	
	public String getBreakDownCostForElectronicInvoice(String productCategory){
		String productCatergoryCost;
		switch (productCategory.toLowerCase()) {
        case "food":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Food')]/../following-sibling::div/span")).getText();
            break;
        case "ops supplies":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Ops Supplies')]/../following-sibling::div/span")).getText();
            break;
        case "paper":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Paper')]/../following-sibling::div/span")).getText();
            break;
        case "linens":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Linens')]/../following-sibling::div/span")).getText();
            break;
        case "others":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Other')]/../following-sibling::div/span")).getText();
            break;
        case "happy meal":
        	productCatergoryCost = driver.findElement(By.xpath("//div[@id='total_row']/div[2]/div/span[contains(text(),'Total Happy  Meal')]/../following-sibling::div/span")).getText();
            break;
        default: 
			productCatergoryCost = "0";
			break;
		}
		return productCatergoryCost;
	}
	
}
