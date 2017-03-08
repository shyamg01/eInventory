package eInventoryPageClasses;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

public class ViewPurchaseHistoryPage extends AbstractPage {
	
	public ViewPurchaseHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='history_start_date']")
	public WebElement ViewHistory_StartDate_TB;
	
	@FindBy(xpath="//input[@id='history_end_date']")
	public WebElement ViewHistory_EndDate_TB;
	
	@FindBy(xpath="//div[@id='eb_dd_input']/span")
	public WebElement ViewHistory_Vendor_DD;
	
	@FindBy(xpath = "//eb-button[@id='get_purchase_history']/button")
	public WebElement ViewHistory_ShowResults_BT;
	
	@FindBy(xpath = "//a[text()='View History']/span")
	public WebElement ViewHistoryTab_Count;
	
	/************View History Table**********/
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/tbody/tr/td[@class='dataTables_empty']/div[2]")
	public WebElement ViewHistoryTable_NoPostedPurchases_Msg;
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/tbody/tr/td[@class='dataTables_empty']/div[1]/img")
	public WebElement ViewHistoryTable_NoPostedPurchases_Img;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Delivery Date']")
	public WebElement ViewHistoryTable_DeliveryDate_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Vendor']")
	public WebElement ViewHistoryTable_Vendor_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Invoice']")
	public WebElement ViewHistoryTable_Invoice_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Invoice Total']")
	public WebElement ViewHistoryTable_InvoiceTotal_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Amount Off']")
	public WebElement ViewHistoryTable_AmountOff_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Auto Approve']")
	public WebElement ViewHistoryTable_AutoApprove_Header;
	
	@FindBy(xpath = "//th[@aria-controls='eb_purchase_his_table' and text()='Type']")
	public WebElement ViewHistoryTable_Type_Header;
	
	@FindBy(xpath="//table[@id='eb_purchase_his_table']/tbody/tr[@role='row']")
	public List<WebElement> postedPurchase_List;
	
	/******************View Invoice ***************/
	@FindBy(xpath="//h2[text()='View Purchase']")
	public WebElement ViewInvoiceForm_Title;
	
	@FindBy(xpath="//div[text()='Source: Manual']")
	public WebElement ViewInvoiceForm_ManualSource_Label;
	
	@FindBy(xpath="//div[@id='subtitle_name']")
	public WebElement ViewInvoiceForm_CreatedBy_Label;
	
	@FindBy(xpath="//span[contains(text(),'Invoice Date:')]")
	public WebElement ViewInvoiceForm_InvoiceDate_Label;
	
	@FindBy(xpath="//span[contains(text(),'Invoice Date:')]/span")
	public WebElement ViewInvoiceForm_InvoiceDate_Value;
	
	@FindBy(xpath="//span[contains(text(),'Invoice:')]")
	public WebElement ViewInvoiceForm_Invoice_Label;
	
	@FindBy(xpath="//span[contains(text(),'Invoice:')]/span")
	public WebElement ViewInvoiceForm_Invoice_Value;
	
	@FindBy(xpath="//span[contains(text(),'Vendor:')]")
	public WebElement ViewInvoiceForm_Vendor_Label;
	
	@FindBy(xpath="//span[contains(text(),'Vendor:')]/span")
	public WebElement ViewInvoiceForm_Vendor_Value;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement ViewInvoiceForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='purchase_modal']/div[contains(@class,'container')]")
	public WebElement ViewInvoiceForm_Container;
	
	@FindBy(xpath = "//table[@id='purchase_detail_table']/thead/tr/th[text()='WRIN']")
	public WebElement ViewInvoiceForm_WRIN_Header;
	
	@FindBy(xpath = "//table[@id='purchase_detail_table']/thead/tr/th[text()='Description']")
	public WebElement ViewInvoiceForm_Description_Header;
	
	@FindBy(xpath = "//table[@id='purchase_detail_table']/thead/tr/th[text()='Cases Purchased']")
	public WebElement ViewInvoiceForm_CasesPurchased_Header;
	
	@FindBy(xpath = "//table[@id='purchase_detail_table']/thead/tr/th[text()='Price Per Case']")
	public WebElement ViewInvoiceForm_PricePerCase_Header;
	
	@FindBy(xpath = "//table[@id='purchase_detail_table']/thead/tr/th[text()='Sub total']")
	public WebElement ViewInvoiceForm_SubTotal_Header;
	
	@FindBy(xpath = "//span[@class='purchaseGT']")
	public WebElement ViewInvoiceForm_GrandTotal_Label;
	
	@FindBy(xpath = "//span[@id='grand_amount']/strong")
	public WebElement ViewInvoiceForm_GrandTotal_Value;
	
	@FindBy(xpath = "//eb-button[@id='purchase_modal_close_btn']/button")
	public WebElement ViewInvoiceForm_Close_BT;
	
	
	@FindBy(xpath = "//eb-modal[@id='purchase_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement ViewInvoiceForm_Cross_BT;
	
	@FindBy(xpath="//table[@id='purchase_detail_table']/tbody/tr[@role='row']")
	public List<WebElement> ViewInvoiceForm_purchaseDetail_List;
	
	@FindBy(xpath="//h3[contains(.,'Break Down By Cost Type')]")
	public WebElement ViewInvoiceForm_BreakDownByCostType_Label;
	
	/************View Electronic Invoice*************/
	@FindBy(xpath="//div[text()='Source: Electronic']")
	public WebElement ViewInvoiceForm_ElectronicSource_Label;
	
	public ViewPurchaseHistoryPage selectStartDateToViewHistory(String startDate) throws InterruptedException{
		ViewHistory_StartDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
	}
	
	public ViewPurchaseHistoryPage selectEndDateToViewHistory(String endDate) throws InterruptedException{
		ViewHistory_EndDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
	}
	
	public boolean verifyManualInvoicePosted(String invoiceId){
		return driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td/span[text()='"+invoiceId+"']")).isDisplayed();
	}
	
	/*@Author :Hemlata
	This method will take invoice id as argument and click on the related posted purchase 
	from the posted purchase list in Purchase Page*/
	public void clickOnPostedPurchaseRecord(String invoiceId){
		wait.until(ExpectedConditions.visibilityOfAllElements(postedPurchase_List));
		WebElement viewHistoryButton = driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td/span[text()='"+invoiceId+"']/../following-sibling::td/eb-button[@id='eb_view_button']/button"));
		executor.executeScript("arguments[0].click();", viewHistoryButton);
		wait.until(ExpectedConditions.visibilityOf(ViewInvoiceForm_Title));
	}
	
	public String getInvoiceTotalForPostedPurchase(String invoiceId){
		return driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td/span[text()='"+invoiceId+"']/../following-sibling::td[1]")).getText();
	}
	
	public boolean verifyViewButtonDisplayedForEachPostedPurchase(){
		boolean result= true;
		for(int i=1;i<=postedPurchase_List.size();i++){
			result = result & Base.isElementDisplayed(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr["+i+"]/td/eb-button[@id='eb_view_button']/button"));
		}
		return result;
	}
	
	//This method will verify that purchase history records will display for selected date range
		public boolean verifyPurchaseHistoryDisplayedForSelectedDateRange(String date1, String date2) throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = new Date();
			// Convert the start date into the date format
			startDate = sdf.parse(date1);
			Date endDate = new Date();
			// Convert the end date into the date format
			endDate = sdf.parse(date2);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='eb_purchase_his_table']")));
			// Verify that only the records between the start and end date is displaying
			int size = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr")).size();
			for (int i = 1; i <= size; i++) {
				String date3 = driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr["+ i + "]/td[1]")).getText();
				Date recordDate = new Date();
				recordDate = sdf.parse(date3);
				if ((recordDate.before(endDate) & recordDate.after(startDate))|| date3.equalsIgnoreCase(date1) | date3.equalsIgnoreCase(date2)) {
					if (i == size) {
						return true;
					}
				} else {
					return false;
				}
			}
			return true;
		}
		
	public boolean verifyDeliveryDateInDescendingOrder() throws ParseException{
		List<WebElement>deliveryDate_List = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[1]/span[2]"));
		List<String>dateValueList = Base.getTextListFromWebElements(deliveryDate_List);
		return Base.verifyDateInDescendingOrder(dateValueList);
	}
	
	public boolean verifyDeliveryDateInAscendingOrder() throws ParseException{
		List<WebElement>deliveryDate_List = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[1]/span[2]"));
		List<String>dateValueList = Base.getTextListFromWebElements(deliveryDate_List);
		return Base.verifyDateInAscendingOrder(dateValueList);
	}
	
	public boolean verifyVendorInDescendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[2]/span"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInDescendingOrder(vendorValueList);
	}
	
	public boolean verifyVendorInAscendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[2]/span"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInAsscendingOrder(vendorValueList);
	}
	
	public boolean verifyInvoiceInDescendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[3]/span"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyStringInDescendingOrder(invoiceValueList);
	}
	
	public boolean verifyInvoiceInAscendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[3]/span"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyStringInAsscendingOrder(invoiceValueList);
	}

	public boolean verifyInvoiceTotalInDescendingOrder() throws ParseException{
		List<WebElement>invoiceTotalList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[4]/span"));
		List<String>invoiceTotalValueList = Base.getTextListFromWebElements(invoiceTotalList);
		return Base.verifyAmountIsInDescendingOrder(invoiceTotalValueList);
	}
	
	public boolean verifyInvoiceTotalInAscendingOrder() throws ParseException{
		List<WebElement>invoiceTotalList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[4]/span"));
		List<String>invoiceTotalValueList = Base.getTextListFromWebElements(invoiceTotalList);
		return Base.verifyStringInAsscendingOrder(invoiceTotalValueList);
	}
	
	public boolean verifyAmountOffInDescendingOrder() throws ParseException{
		List<WebElement>amountOffList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[5]/span"));
		ArrayList<String>amountOffListValueList = new ArrayList<String>();
		for(WebElement amountOff : amountOffList){
			String amount = amountOff.getText();
			amount = amount.substring(1, amount.length()-3);
			amountOffListValueList.add(amount);
		}
		return Base.verifyAmountIsInDescendingOrder(amountOffListValueList);
	}
	
	public boolean verifyAmountOffInAscendingOrder() throws ParseException{
		List<WebElement>amountOffList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[5]/span"));
		ArrayList<String>amountOffListValueList = new ArrayList<String>();
		for(WebElement amountOff : amountOffList){
			String amount = amountOff.getText();
			amount = amount.substring(1, amount.length()-3);
			amountOffListValueList.add(amount);
		}
		return Base.verifyAmountIsInDescendingOrder(amountOffListValueList);
	}
	
	public boolean verifyAutoApproveInDescendingOrder() throws ParseException{
		List<WebElement>autoApproveList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[6]/span"));
		List<String>autoApproveValueList = Base.getTextListFromWebElements(autoApproveList);
		return Base.verifyStringInDescendingOrder(autoApproveValueList);
	}
	
	public boolean verifyAutoApproveInAscendingOrder() throws ParseException{
		List<WebElement>autoApproveList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[6]/span"));
		List<String>autoApproveValueList = Base.getTextListFromWebElements(autoApproveList);
		return Base.verifyStringInAsscendingOrder(autoApproveValueList);
	}
	
	public boolean verifyTypeInDescendingOrder() throws ParseException{
		List<WebElement>typeList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[7]/span"));
		List<String>typeValueList = Base.getTextListFromWebElements(typeList);
		return Base.verifyStringInDescendingOrder(typeValueList);
	}
	
	public boolean verifyTypeInAscendingOrder() throws ParseException{
		List<WebElement>typeList = driver.findElements(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[7]/span"));
		List<String>typeValueList = Base.getTextListFromWebElements(typeList);
		return Base.verifyStringInAsscendingOrder(typeValueList);
	}
	
	public String getBreakDownCostForEachCategory(String productCategory){
		String productCatergoryCost;
		switch (productCategory.toLowerCase()) {
        case "food":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Food:')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        case "oops supplies":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Ops:')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        case "paper":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Paper')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        case "linen":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Linens')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        case "others":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Other')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        case "happy meal":
        	productCatergoryCost = driver.findElement(By.xpath("//div/span[contains(text(),'Total Happy  Meal')]/../following-sibling::div[1]/span/strong")).getText();
            break;
        default: 
			productCatergoryCost = "0";
			break;
		}
		return productCatergoryCost;
	}
	
	public String getSubTotalAmountForInvoice(){
		List<WebElement>rawItemList = driver.findElements(By.xpath("//table[@id='purchase_detail_table']/tbody/tr[@role='row']"));
		BigDecimal rawItemCost = new BigDecimal(0.00);
		for(int i= 1;i<=rawItemList.size();i++){
		rawItemCost = rawItemCost.add(new BigDecimal(driver.findElement(By.xpath("(//table[@id='purchase_detail_table']/tbody/tr[@role='row'])["+i+"]/td[6]")).getText().substring(1)));
		}
		return String.valueOf(rawItemCost);
	}
	
	public String getSubTotalForWrinItemForInvoice(String wrinId){
		return driver.findElement(By.xpath("//table[@id='purchase_detail_table']/tbody/tr/td/span[contains(text(),'"+wrinId+"')]/../following-sibling::td[5]")).getText().substring(1);
	}

}
