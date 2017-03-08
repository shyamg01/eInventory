package eInventoryPageClasses;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.Reporter;

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
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'cancel this purchase?')]")
	public WebElement CreateManualInvoice_ConfirmCancel_Message;
	
	@FindBy(xpath = "//eb-modal[@id='manual_purchase_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement CreateManualInvoice_Cross_BT;
	
	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement CreateManualInvoice_ConfirmationPopUp_No_BT;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement CreateManualInvoice_ConfirmationPopUp_Yes_BT;
	
	@FindBy(xpath = "//td[contains(@class,'sub_total dt-right')]")
	public WebElement CreateManualInvoice_SubTotal_Value;

	@FindBy(xpath = "//input[@placeholder='quantity']")
	public List<WebElement> Quantity_TB_List;
	
	@FindBy(xpath = "//td[@class='sub_total dt-right']")
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
	
	@FindBy(xpath="//div[contains(@id,'popover') and @role='tooltip']/div[@class='popover-content']")
	public WebElement InvalidQuantity_Error_Message;
	
	@FindBy(xpath="//div[contains(@id,'popover') and @role='tooltip']/div[@class='popover-content']")
	public WebElement InvalidPricePerCase_Error_Message;
	
	@FindBy(xpath = "//eb-datepicker[@id='disp_date_picker']/span[contains(text(),' Connection down! Ensure correct date!')]")
	public WebElement CreateManualInvoice_ConnectionDown_Msg;
	
	/**************Create new invoice Fields Labels***************/
	@FindBy(xpath="//div[text()='Source: Manual']")
	public WebElement CreateManualInvoice_ManualSource_Label;
	
	@FindBy(xpath="//div[@id='invoice_created_by']")
	public WebElement CreateManualInvoice_CreatedBy_Label;
	
	@FindBy(xpath="//label[@id='vendor_list_label']")
	public WebElement CreateManualInvoice_Vendor_Label;
	
	@FindBy(xpath = "//label[@id='vendor_list_label']/span[@class='fa fa-asterisk']")
	public WebElement CreateManualInvoice_VendorAsterisk_Label;
	
	@FindBy(xpath="//label[contains(.,'Invoice Number')]")
	public WebElement CreateManualInvoice_InvoiceNumber_Label;
	
	@FindBy(xpath="//eb-datepicker[@id='disp_date_picker']/div/label[contains(.,'Date:')]")
	public WebElement CreateManualInvoice_Date_Label;
	
	@FindBy(xpath="//label[contains(.,'Item')]")
	public WebElement CreateManualInvoice_Item_Label;
	
	@FindBy(xpath="//label[contains(.,'Item')]/span[contains(@class,'fa fa-asterisk')]")
	public WebElement CreateManualInvoice_ItemAsterisk_Label;
	
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
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement CreateManualInvoice_SliderToggle_BT;
	
	
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
	public ManualInvoiceNewPage selectInvoiceDate(String invoiceDate)throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_PopUp_Lable));
		GenericMethods.clickOnElement(CreateManualInvoice_InvoiceDate_TB, "CreateManualInvoice_InvoiceDate_TB");
		Thread.sleep(2000);
		int day = Base.getDayFromDate(invoiceDate);
		int month = Base.getMonthFromDate(invoiceDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),3);
		Reporter.reportPassResult(AbstractTest.browser, "Month "+Base.getMonthName(month+1)+" is selected From Date Picker", "Pass");
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[3]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")), "clicked on "+day+"in calender");
		GenericMethods.clickOnElement(CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}
	
	public boolean verifyDateIsDisabled(String date) throws InterruptedException{
		CreateManualInvoice_InvoiceDate_TB.click();
		Thread.sleep(2000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),3);
		return driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[3]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
	}
	

	public void selectMonthFromDropDown(String month) {
		String monthName = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[3]/div[contains(@class,'xdsoft_month')]/span")).getText();
		System.out.println(monthName);
		while (!monthName.equals(month)) {
			driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[3]/button[@class='xdsoft_prev']")).click();
			monthName = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])[3]/div[contains(@class,'xdsoft_month')]/span")).getText();
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
	public ManualInvoiceNewPage seacrhAndSelectRawItem(String samplewRINID)throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
//		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.click();
		GenericMethods.clickOnElement(CreateManualInvoice_EnterRawItemNumberOrDescription_TB, "CreateManualInvoice_EnterRawItemNumberOrDescription_TB");
		GenericMethods.clearValueOfElement(CreateManualInvoice_EnterRawItemNumberOrDescription_TB, "CreateManualInvoice_EnterRawItemNumberOrDescription_TB");
//		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.clear();
		GenericMethods.enterValueInElement(CreateManualInvoice_EnterRawItemNumberOrDescription_TB, "CreateManualInvoice_EnterRawItemNumberOrDescription_TB", samplewRINID);
//		CreateManualInvoice_EnterRawItemNumberOrDescription_TB.sendKeys(samplewRINID);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//strong[text()='"+samplewRINID+"'])[1]")), "WRIN ID");
//		driver.findElement(By.xpath("(//strong[text()='"+samplewRINID+"'])[1]")).click();
		Thread.sleep(2000);
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}

	//Method Reporter
	public ManualInvoiceNewPage selectAVendor(String vendorName)throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.selectTextFormDropDownElement(CreateManualInvoice_Vendor_DD, "CreateManualInvoice_Vendor_DD", vendorName);
		return PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	}
	
	// Create a Manual Purchase
			public PurchasesPage createAManualPurchase(String vendorName,String invoiceNumber, String Wrin, String quantity,
					String pricePerCase) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
				PurchasesPage purchasePage = PageFactory.initElements(driver,PurchasesPage.class);
				wait.until(ExpectedConditions.visibilityOf(purchasePage.Purchases_Label));
				GenericMethods.clickOnElement(purchasePage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
				wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_PopUp_Lable));
				// Search and Select the Vendor from the drop down
				selectAVendor(vendorName);
				selectInvoiceDate(GlobalVariable.createDate);
				seacrhAndSelectRawItem(Wrin);
				wait.until(ExpectedConditions.visibilityOf(Quantity_TB_List.get(0)));
				GenericMethods.clearValueOfElement(CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
				GenericMethods.enterValueInElement(CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
				// Enter the quantity
				Thread.sleep(2000);
				GenericMethods.clearValueOfElement(Quantity_TB_List.get(0), "First Quntity text box");
				GenericMethods.enterValueInElement(Quantity_TB_List.get(0), "First Quntity text box", quantity);
				Thread.sleep(2000);
				GenericMethods.clearValueOfElement(pricePerCase_TB_List.get(0), "First PricePerCase text box");
				GenericMethods.enterValueInElement(pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
				GenericMethods.clickOnElement(CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
				Thread.sleep(2000);
				GenericMethods.clickOnElement(Submit_BT, "Submit_BT");
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(CreateManualInvoice_ConfirmationPopUp_Yes_BT)), "CreateManualInvoice_ConfirmationPopUp_Yes_BT");
				wait.until(ExpectedConditions.visibilityOf(InvoiceSaved_Confirmation_MSG));
				Thread.sleep(5000);
				return PageFactory.initElements(driver, PurchasesPage.class);
			}
	
	public boolean verifyItemIsAddedForInvoice(String wrinId){
		return Base.isElementDisplayed(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public void enterQuantityForMultipleWrin(String wrinId,String quantity) throws RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.enterValueInElement(driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"
				+ wrinId+ "')]/following-sibling::td[contains(@class,'case_count')]/eb-validated-input/div/div/div/input[@placeholder='quantity']")), "wrinId", quantity);
		GenericMethods.clickOnElement(CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
	}
	
	public void enterCasePriceForMultipleWrin(String wrinId,String casePrice) throws RowsExceededException, BiffException, WriteException, IOException{
		WebElement casePriceTextBox = driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"
				+ wrinId+ "')]/following-sibling::td[contains(@class,'case_price')]/eb-validated-input/div/div/div/input[@placeholder='$']"));
		GenericMethods.enterValueInElement(casePriceTextBox, "wrinId", casePrice);
		GenericMethods.clickOnElement(CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
	}
	
	public void removeWrinIdFromManualInvoiceNewPage(String wrinId) throws InterruptedException{
		driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(text(),'"
						+ wrinId+ "')]/preceding-sibling::td[contains(@class,'select-checkbox')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])"))).click();
		Thread.sleep(3000);
	}
	
	public void removeAllWrinIdFromManualInvoiceNewPage() throws InterruptedException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			removeBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])"))).click();
			Thread.sleep(3000);
		}
	}
	
}
