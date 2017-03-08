package eInventoryPageClasses;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

public class ManualInvoiceEditPage extends AbstractPage
{

	public ManualInvoiceEditPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
		
	@FindBy(xpath="//input[@id='complete_button']")
	 public WebElement Finalize_BT;
	
	@FindBy(xpath="//input[@id='continue_finalize']")
	public WebElement FinalizePopUp_Continue_BT;
	
	@FindBy(xpath="//input[@id='close_button']")
	 public WebElement Cancel_BT;
	
	@FindBy(xpath="//input[@id='save_button']")
	 public WebElement Save_BT;
	
	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Your invoice has been saved')]")
	public WebElement InvoiceSave_Confirmation_Message;
	
	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Your invoice has been posted')]")
	public WebElement InvoiceFinalize_Confirmation_Message;
	
	@FindBy(xpath="//a[contains(.,'Inventory')]//b[@class='caret']")
	public WebElement Inventory_DD_Button;
	
	@FindBy(xpath="//li[@class='dropdown open']//ul[@class='dropdown-menu']/li[contains(.,'Purchases')]")
	public WebElement Inventory_DD_Purchases;
	
	@FindBy(id="vendor_list")
	public WebElement VendorList_DD;
	
	@FindBy(xpath="//input[@id='invoice_identifier']")
	public WebElement InvoiceNumber_TB;
	
	@FindBy(xpath = "//label[contains(text(),'Invoice Number:')]")
	public WebElement InvoiceNumber_Label;
	
	@FindBy(xpath = "//label[contains(text(),'Invoice Date:')]")
	public WebElement InvoiceDate_Label;
	
	@FindBy(xpath = "//label[contains(text(),'Vendor:')]")
	public WebElement Vendor_Label;
	
	@FindBy(xpath = "//div[div[@class='col-sm-4']]/div[2]/div/div/div/label/input")
	public WebElement SubSection_Search_TB;
	
	@FindBy(xpath = "//div[@class='col-xs-10 text-right']")
	public WebElement Total_Label;
	
	@FindBy(xpath = "//input[@id='autocomplete']")
	public WebElement EnterQuickSearchWithSuggestionsForManualPurchases_TB;
	
	@FindBy(xpath = "//tbody[@id='invoice_tbl_body']/tr/td[7]/input")
	public List<WebElement> Quantity_TB;
	
	@FindBy(xpath = "//div[contains(text(),'Your invoice has been saved')]")
	public WebElement InvoiceSaved_Confirmation_MSG;
	
	@FindBy(xpath="//table[@id='wrin_list_tbl']")
	public WebElement RowItemTable;
	
	@FindBy(xpath="//div[@id='wrin_list_tbl_wrapper']//label[contains(. ,'Search')]")
	public WebElement Search_Label_01;

	@FindBy(xpath="//div[@id='invoice_tbl_filter']/label[contains(.,'Search')]")
	public WebElement Search_Label_02;
	
	@FindBy(xpath="//table[@id='wrin_list_tbl']//tr[2]/td[3]/button")
	public WebElement RowItemTable_First_Add_BT;
	
	@FindBy(id="delete_button")
	public WebElement Delete_BT;
	
	@FindBy(xpath="//button[@class='btn btn-default' and text()='Cancel']")
	public WebElement DeletePopup_Cancel_BT; 
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	public WebElement DeletePopup_OK_BT;
	
	@FindBy(xpath="//input[@class='btn btn-danger']")
	public WebElement CancelPopup_OK_BT;
	
	@FindBy(xpath="//input[@class='btn btn-default']")
	public WebElement CancelPopup_Cancel_BT; 
	
	@FindBy(xpath="//th[text()='Remove']")
	public WebElement Remove_Column_Label;
	
	@FindBy(xpath="//button[@class='btn btn-link btn-link']")
	public List <WebElement> Remove_Link_List;
	
	//@Author : Hemlata
	@FindBy(xpath="(//div[@class='xdsoft_time_variant'])[1]/div[contains(@class,'xdsoft_current')]/preceding-sibling::div[1]")
	public WebElement previousToCurrentTime_label;

	//@Author : Hemlata
	@FindBy(xpath="(//div[@class='xdsoft_time_variant'])[1]/div[contains(@class,'xdsoft_current')]")
	public WebElement finalizeWindowSelectdTime_label;

	//@Author : Hemlata
	@FindBy(xpath=".//*[@id='start_inv_div']/div/div[1]/div/div/div[contains(@class,'xdsoft_timepicker')]/button[@class='xdsoft_prev']")
	public WebElement datePickerPrevious_Button;
	
	@FindBy(xpath="//input[@id='disp_date']")
	public WebElement invoiceDate_TB;
	
	@FindBy(xpath="//tbody[@id='invoice_tbl_body']/tr[contains(.,'No search results found')]")
	public WebElement NoSearchResultsFound_Message_Label;
	
	
    /****** Approve Purchase Locaters */
	
	@FindBy(xpath="//h2[text()='Approve Manual Invoice']")
	public WebElement ApproveManualInvoice_Label;
	
	@FindBy(xpath="//input[@id='selected_vendor']")
	public WebElement ApproveManualInvoice_Vendor_TB;
	
	@FindBy(xpath="//input[@id='invoice_identifier']")
	public WebElement ApproveManualInvoice_InvoiceNumber_TB;
	
	@FindBy(xpath="//input[@id='disp_date']")
	public WebElement ApproveManualInvoice_Date_TB;
	
	@FindBy(xpath = "//eb-button[@id='purchase_modal_approve_btn']/button")
	public WebElement ApproveManualInvoice_Approve_BT;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement ManualInvoiceApprove_ConfirmationPopUp_Yes_BT;

	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement ManualInvoiceApprove_ConfirmationPopUp_No_BT;
	
	@FindBy(xpath = "//div[@id='close']/a")
	public WebElement ManualInvoiceApprove_ConfirmationPopUp_Close_BT;

	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Manual Purchase Posted')]")
	public WebElement ManualPurchasePosted_MSG;
	
	@FindBy(xpath = "//eb-button[@id='purchase_modal_delete_btn']/button")
	public WebElement ManualInvoiceApprove_Delete_BT;

	@FindBy(xpath = "//eb-button[@id='purchase_modal_cancel_btn']/button")
	public WebElement ManualInvoiceApprove_Cancel_BT;

	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement ManualInvoiceApprove_DeleteConfirmationPopUp_Yes_BT;

	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement ManualInvoiceApprove_DeleteConfirmationPopUp_No_BT;

	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Invoice deleted.')]")
	public WebElement InvoiceDeleted_Confirmation_MSG;
	
	@FindBy(xpath="(//th[text()='WRIN'])[2]")
	public WebElement ManualInvoiceApprove_WRIN_Label;
	
	@FindBy(xpath="(//th[text()='Description'])[2]")
	public WebElement ManualInvoiceApprove_Description_Label;
	
	@FindBy(xpath="(//th[text()='UOM'])[1]")
	public WebElement ManualInvoiceApprove_UOM_Label;
	
	@FindBy(xpath="(//th[text()='Case'])[1]")
	public WebElement ManualInvoiceApprove_Case_Label;
	
	@FindBy(xpath="(//th[text()='Quantity'])[1]")
	public WebElement ManualInvoiceApprove_Quantity_Label;
	
	@FindBy(xpath="(//th[text()='Price Per Case'])[1]")
	public WebElement ManualInvoiceApprove_PricePerCase_Label;
	
	@FindBy(xpath="(//th[text()='Sub-total'])[1]")
	public WebElement ManualInvoiceApprove_SubTotal_Label;
	
	@FindBy(xpath="//span[contains(.,'Break Down By Cost Type')]")
	public WebElement ManualInvoiceApprove_BreakDownByCostType_Label;
	
	@FindBy(xpath="//div[@id='total_food_div']")
	public WebElement ManualInvoiceApprove_TotalFood_Section;
	
	@FindBy(xpath="//div[@id='total_ops_div']")
	public WebElement ManualInvoiceApprove_TotalOps_Section;
	
	@FindBy(xpath="//div[@id='total_paper_div']")
	public WebElement ManualInvoiceApprove_Paper_Section;
	
	@FindBy(xpath="//div[@id='total_linens_div']")
	public WebElement ManualInvoiceApprove_Linens_Section;
	
	@FindBy(xpath="//div[@id='total_other_div']")
	public WebElement ManualInvoiceApprove_Others_Section;
	
	@FindBy(xpath="//div[@id='total_happy_meal_div']")
	public WebElement ManualInvoiceApprove_TotalHappyMeal_Section;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement ManualInvoiceApprove_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='purchase_modal']/div[contains(@class,'container')]")
	public WebElement ManualInvoiceApproveForm_Container;
	
	@FindBy(xpath = "//div[contains(@class,'confirmation-message')]/p[@id='notBody']")
	public WebElement ManualInvoiceApproveForm_ConfirmApprove_Message;
	
	
	public boolean verifyRemoveWrinOptionIsNotPresent() throws InterruptedException{
		List<WebElement> removeChkBox = driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[contains(@class,' select-checkbox')]"));
		return removeChkBox.size()==0;
	}
	
	public ManualInvoiceEditPage selectDateToApprove(String date) throws InterruptedException{
		ApproveManualInvoice_Date_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),4);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[4]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, ManualInvoiceEditPage.class);
	}
	
	
	public void enterQuantityAndSave(String val) 
	{
		/*entering quantity in quantity box of last record
		 * clicking save button
		 * verify the confirmation message
		 * verify the quantity has been updated
		 */
		Quantity_TB.get(Quantity_TB.size()-1).clear();
        Quantity_TB.get(Quantity_TB.size()-1).sendKeys(val);
		//enter the 
		Save_BT.click();
		wait.until(ExpectedConditions.visibilityOf(InvoiceSaved_Confirmation_MSG));
		
		
	}
	
	
	
	//click on plus sign for first row item in the list
	public ManualInvoiceEditPage clickOnPlusSignForFirstRowItem()
		{
			wait.until(ExpectedConditions.visibilityOf(RowItemTable));
			RowItemTable_First_Add_BT.click();
			return PageFactory.initElements(driver, ManualInvoiceEditPage.class);

	}
	
	
	public ManualInvoiceEditPage removeAllItemsOfSubSection() throws InterruptedException
	{
			
		int size=driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[9]/button")).size();
		System.out.println("total element"+size);
		for(int i=1;i<=size;i++)
		{
			
			driver.findElement(By.xpath("//tbody[@id='invoice_tbl_body']/tr[1]/td[9]/button")).click();
			Thread.sleep(2000);
		}
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody[@id='invoice_tbl_body']/tr/td[9]/button")));
		return PageFactory.initElements(driver, ManualInvoiceEditPage.class);

	}
	
	
	//Search and select a Raw item

	public ManualInvoiceEditPage searchAndSelectARawItem(String wrinId) throws InterruptedException
	{
		 EnterQuickSearchWithSuggestionsForManualPurchases_TB.sendKeys(wrinId);
		 action.sendKeys(Keys.SPACE).build().perform(); 
	     Thread.sleep(1500); 
	     action.sendKeys(Keys.BACK_SPACE).build().perform();
		 driver.findElement(By.xpath("//strong[text()="+wrinId+"]")).click();
		 return PageFactory.initElements(driver, ManualInvoiceEditPage.class);
	}
	
	

	//This method will take WRIN Id as argument and return subtotal value for that food item from Manual Invoice Edit Page
	public String getSubtotalValueForFoodItemPurchase(String WRINId){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='invoice_tbl_body']")));
		return driver.findElement(By.xpath(".//*[@id='invoice_tbl_body']/tr/td[contains(text(),'"+WRINId+"')]/following-sibling::td[contains(@class,'sub_total')]")).getText();
	}
	
	public int getNumberOfItemInPurchase(){
		return  driver.findElements(By.xpath("//tbody[@id='invoice_tbl_body']/tr")).size();
	}
	

}
