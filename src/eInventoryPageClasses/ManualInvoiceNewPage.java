package eInventoryPageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.Base;

public class ManualInvoiceNewPage extends AbstractPage {

	public ManualInvoiceNewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[8]")
	public List<WebElement> Subtotal_Value_List;

	@FindBy(xpath = "//input[@id='input_price']")
	public List<WebElement> DollerCase_TB_List;

	@FindBy(xpath = "//div[@class='toast-message' and text()='The manual invoice number is a duplicate.  Please enter a new manual invoice number.']")
	public WebElement DuplicateInvoiceNumber_Error_MSG;

	@FindBy(xpath = "//div[@id='invoice_tbl_filter']//input[@class='form-control table-search']")
	public WebElement Search_TB_02;

	@FindBy(xpath = "//td[@class='compact sorting_1']/following-sibling::td[2]/button")
	public List<WebElement> SearchedRawItem_Add_BT;

	/***************Break Down By Cost Type Section**************/
	@FindBy(xpath = "//div[text()='Total Food:']")
	public WebElement TotalFood_Label;

	@FindBy(xpath = "//div[@id='total_food']")
	public WebElement TotalFood_Value;

	@FindBy(xpath = "//div[text()='Total Ops Supplies:']")
	public WebElement TotalOpsSupplies_Label;

	@FindBy(xpath = "//div[@id='total_ops']")
	public WebElement TotalOpsSupplies_Value;

	@FindBy(xpath = "//div[text()='Total Paper:']")
	public WebElement TotalPaper_Label;

	@FindBy(xpath = "//div[@id='total_paper']")
	public WebElement TotalPaper_Value;

	@FindBy(xpath = "//div[text()='Total Linens:']")
	public WebElement TotalLines_Label;

	@FindBy(xpath = "//div[@id='total_linens']")
	public WebElement TotalLines_Value;

	@FindBy(xpath = "//div[text()='Total Non-product (Other):']")
	public WebElement TotalNonProductOther_Label;

	@FindBy(xpath = "//div[@id='total_other']")
	public WebElement TotalNonProductOther_Value;

	@FindBy(xpath = "//div[text()='Total Non-product (Happy Meal Premiums):']")
	public WebElement TotalNonProductHappyMealPremiums_Label;

	@FindBy(xpath = "//div[@id='total_happy_meal']")
	public WebElement TotalNonProductHappyMealPremiums_Value;

	@FindBy(xpath = "//div[@id='total_val']")
	public WebElement TotalPurchases_Value;
	
	/*******************************************/

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[2]")
	public WebElement InvoiceTable_WrinId_Value;

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[3]")
	public WebElement InvoiceTable_Description_Value;

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[4]")
	public WebElement InvoiceTable_Uom_Value;

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[5]")
	public WebElement InvoiceTable_UomCase_Value;

	@FindBy(xpath = "//div[@class='toast-message' and text()='Please enter a valid value for the highlighted field(s). Fields must have a value and be greater than 0, otherwise the row should be removed from the invoice.']")
	public WebElement FieldValidation_ErrorMessage;

	/****/
	@FindBy(id = "autocomplete_add_item_btn")
	public WebElement AddWrinFromSearchBox_BT;

	@FindBy(xpath = "//button[@id='datetimepicker_purchases']")
	public WebElement ManualInvoiceDatePicker_BT;

	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[contains(.,'No search results found.')]")
	public WebElement NoSearchResultFound_MSG;

	@FindBy(xpath = "//div[@class='toast-message' and contains(.,'Item Added')]/i[@id='ebInfoIcon']")
	public WebElement CreateManualInvoice_ItemAdded_MSG;

	// BundleWise
	@FindBy(xpath = "//h2[text()='Manual Invoice']")
	public WebElement CreateManualInvoice_PopUp_Lable;

	@FindBy(xpath = "//Select[@id='vendor_list']")
	public WebElement CreateManualInvoice_Vendor_DD;

	@FindBy(xpath = "//input[@placeholder='Enter Invoice #']")
	public WebElement CreateManualInvoice_InvoiceNumber_TB;

	@FindBy(xpath = "//input[@placeholder='Enter raw item number or description']")
	public WebElement CreateManualInvoice_EnterRawItemNumberOrDescription_TB;

	@FindBy(xpath = "//button[@id='autocomplete_add_item_btn']")
	public WebElement CreateManualInvoice_Add_BT;
	
	@FindBy(xpath = "//eb-button[@id='manual_purchase_modal_cancel_btn']/button")
	public WebElement CreateManualInvoice_Cancel_BT;
	
	@FindBy(xpath = "//td[@class=' sub_total text-right']")
	public WebElement CreateManualInvoice_SubTotal_Value;

	@FindBy(xpath = "//input[@placeholder='quantity']")
	public List<WebElement> Quantity_TB_List;
	
	@FindBy(xpath = "//td[@class=' sub_total text-right']")
	public List<WebElement> SubTotal_Value_List;

	@FindBy(xpath = "//input[@placeholder='$']")
	public List<WebElement> pricePerCase_TB_List;

	@FindBy(xpath = "//eb-button[@id='manual_purchase_modal_submit_btn']/button")
	public WebElement Submit_BT;

	@FindBy(xpath = "//div[@class='toast-message' and contains(.,'Your invoice has been saved')]")
	public WebElement InvoiceSaved_Confirmation_MSG;
	
	@FindBy(xpath = "//select[@id='vendor_list']/option")
	public List<WebElement> CreateManualInvoice_VendorName_List;
	
	@FindBy(xpath = "//input[@id='disp_date']")
	public WebElement CreateManualInvoice_InvoiceDate_TB;
	
	@FindBy(xpath = "//div[@class='autocomplete-no-suggestion']/div[@id='autocomplete_info_div']")
	public WebElement CreateManualInvoice_NoSuggestionForWrinId_Msg;
	
	@FindBy(xpath="(//input[@id='validatedInput' and @placeholder='quantity'])/../following-sibling::div[@id='message_popup']/span[@id='message']")
	public WebElement InvalidQuantity_Error_Message;
	
	@FindBy(xpath="(//input[@id='validatedInput' and @placeholder='$'])/../following-sibling::div[@id='message_popup']/span[@id='message']")
	public WebElement InvalidPricePerCase_Error_Message;
	
	@FindBy(xpath = "//eb-datepicker[@id='disp_date_picker']/span[contains(text(),' Connection down! Ensure correct date!')]")
	public WebElement CreateManualInvoice_ConnectionDown_Msg;
	
	/**************Create new invoice Fields Labels***************/
	@FindBy(xpath="//span[text()='Source: Manual']")
	public WebElement CreateManualInvoice_ManualSource_Label;
	
	@FindBy(xpath="//span[@id='invoice_created_by']")
	public WebElement CreateManualInvoice_CreatedBy_Label;
	
	@FindBy(xpath="//label[@id='vendor_label']")
	public WebElement CreateManualInvoice_Vendor_Label;
	
	@FindBy(xpath="//label[contains(.,'Invoice Number:')]")
	public WebElement CreateManualInvoice_InvoiceNumber_Label;
	
	@FindBy(xpath="//eb-datepicker[@id='disp_date_picker']/div/label[contains(.,'Date:')]")
	public WebElement CreateManualInvoice_Date_Label;
	
	@FindBy(xpath="//label[contains(.,'Item')]")
	public WebElement CreateManualInvoice_Item_Label;
	
	/****************Invoice Table columns Headers*****************/
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='WRIN']")
	public WebElement CreateManualInvoiceTable_WRIN_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='Description']")
	public WebElement CreateManualInvoiceTable_Description_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='UOM']")
	public WebElement CreateManualInvoiceTable_UOM_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='Case']")
	public WebElement CreateManualInvoiceTable_Case_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='Quantity']")
	public WebElement CreateManualInvoiceTable_Quantity_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='Price Per Case']")
	public WebElement CreateManualInvoiceTable_PricePerCase_Label;
	
	@FindBy(xpath="//table[@id='invoice_tbl']/thead/tr/th[text()='Sub-total']")
	public WebElement CreateManualInvoiceTable_SubTotal_Label;
	
	
	public boolean isManualInvoiceNewPageIsLoaded() {
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_PopUp_Lable));
		return CreateManualInvoice_PopUp_Lable.getText().trim().equalsIgnoreCase("Manual Invoice - New")
				& driver.getPageSource().contains("Vendor")
				& driver.getPageSource().contains("Invoice Date")
				& driver.getPageSource().contains("Invoice Number");
	}

	/*
	 * Select the Invoice date from the calendar Invoice Date should be in
	 * MM/DD/YYYY format
	 */
	public ManualInvoiceNewPage selectInvoiceDate(String invoiceDate)throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_PopUp_Lable));
		CreateManualInvoice_InvoiceDate_TB.click();
		Thread.sleep(2000);
		int mon = Base.getMonthFromDate(invoiceDate);
		int day = Base.getDayFromDate(invoiceDate);
		String monthName = Base.getMonthName(mon + 1);
		selectMonthFromDropDown(monthName);
		driver.findElement(By.xpath("//div[@class='xdsoft_calendar']/table/tbody/tr/td[@data-month="+ (mon) + "]/div[text()=" + day + "]")).click();
		CreateManualInvoice_PopUp_Lable.click();
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}

	public void selectMonthFromDropDown(String month) {
		String monthName = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[4]/div[contains(@class,'xdsoft_month')]/span")).getText();
		System.out.println(monthName);
		while (!monthName.equals(month)) {
			driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[4]/button[@class='xdsoft_prev']")).click();
			monthName = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[4]/div[contains(@class,'xdsoft_month')]/span")).getText();
			System.out.println("monthName found " + monthName);
		}
	}

	/*
	 * Search the Raw Items Return:"No Items Available"/"Items are Available"
	 * Parameter:Wrin Id of row Item
	 */
	public String searchRawItemWithWrinID(String Wrin)throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_EnterRawItemNumberOrDescription_TB));
		// enter the WRIN id in search box
		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.sendKeys(Wrin);
		Thread.sleep(2000);
		if (SearchedRawItem_Add_BT.isEmpty()) {
			return "No Items Available";
		} else {
			return "Items are Available";
		}
	}

	// This method will verify that a vendor is listed in the vendor drop down in manual invoice new page*/
	public boolean verifyVendorDisplayed(String vendorName) {
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_Vendor_DD));
		Select vendorDD = new Select(CreateManualInvoice_Vendor_DD);
		List<WebElement> vendorList = vendorDD.getOptions();
		for (WebElement vendor : vendorList) {
			if (vendor.getText().equals(vendorName))
				return true;
		}
		return false;
	}

	public void removeWrinFromPurchaseList(String wrinId)throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"
						+ wrinId+ "')]/preceding-sibling::td[contains(@class,' select-checkbox')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='utility-toolbar']/li[@id='deleteId']"))).click();
		Thread.sleep(3000);
	}

	// Bundle Wise Function
	public ManualInvoiceNewPage seacrhAndSelectRawItem(String samplewRINID)throws InterruptedException {
		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.click();
		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.clear();
		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.sendKeys(samplewRINID);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.xpath("(//strong[text()='"+samplewRINID+"'])[1]")).click();
		Thread.sleep(2000);
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}

	public ManualInvoiceNewPage selectAVendor(String vendorName)throws InterruptedException {
		//CreateManualInvoice_Vendor_DD.click();
		Select selectVendor = new Select(CreateManualInvoice_Vendor_DD);
		selectVendor.selectByVisibleText(vendorName);
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}

	// Create a Manual Purchase
	public PurchasesPage createAManualPurchase(String vendorName,String invoiceNumber, String Wrin, String quantity,
			String pricePerCase) throws InterruptedException {
		PurchasesPage purchasePage = PageFactory.initElements(driver,PurchasesPage.class);
		wait.until(ExpectedConditions.visibilityOf(purchasePage.Purchases_Label));
		purchasePage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		selectAVendor(vendorName);
		seacrhAndSelectRawItem(Wrin);
		executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(Quantity_TB_List.get(0)));
		CreateManualInvoice_InvoiceNumber_TB.clear();
		CreateManualInvoice_InvoiceNumber_TB.sendKeys("");
		Thread.sleep(1500); 
		CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
		// Enter the quantity
		Thread.sleep(2000);
		Quantity_TB_List.get(0).clear();
		Quantity_TB_List.get(0).sendKeys(quantity);
		Thread.sleep(2000);
		CreateManualInvoice_PopUp_Lable.click();
		Thread.sleep(2000);
		Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(InvoiceSaved_Confirmation_MSG));
		return PageFactory.initElements(driver, PurchasesPage.class);
	}
	
	public boolean verifyItemIsAddedForInvoice(String wrinId){
		return Base.isElementDisplayed(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public void enterQuantityForMultipleWrin(String wrinId,String quantity){
		driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"
						+ wrinId+ "')]/following-sibling::td[contains(@class,'case_count')]/eb-validated-input/div/div/div/input[@placeholder='quantity']")).sendKeys(quantity);
		CreateManualInvoice_PopUp_Lable.click();
	}
	
}
