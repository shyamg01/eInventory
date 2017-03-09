package eInventoryPageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreControlSettingsPage extends AbstractPage {

	public StoreControlSettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[@id='tabLinkInventorySettings']")
	public WebElement InventorySetting_BT;
	
	@FindBy(xpath = "//h3[text()='Invoices']")
	public WebElement InventorySetting_Invoices_Label;
	
	@FindBy(xpath = ".//h3[text()='Transfers']")
	public WebElement InventorySetting_Transfers_Label;
	
	@FindBy(xpath = "//h3[text()='Physical Inventory']")
	public WebElement InventorySetting_PhysicalInventory_Label;
	
	@FindBy(xpath = "//span[@id='physical-inventory-edit-button']")
	public WebElement InventorySetting_PhysicalInventory_Edit_BT;
	
	@FindBy(xpath = "//span[contains(text(),'Number of days before the end of month to allow inventories of Monthly Food items excluding condiments:')]")
	public WebElement PhysicalInventorySetting_FoodItem_InventoryDaysPrior_Label;
	
	@FindBy(xpath = "//span[contains(text(),'Number of days before the end of month to allow inventories of Monthly Non Food and Condiments:')]")
	public WebElement PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_Label;
	
	@FindBy(xpath = "(//input[@name='inventoryDaysPriorEOM'])[1]")
	public WebElement PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB;
	
	@FindBy(xpath = "(//input[@name='inventoryDaysPriorEOM'])[2]")
	public WebElement PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB;
	
	@FindBy(xpath = "//h2[text()='Inventory - Physical Inventory Settings']")
	public WebElement PhysicalInventorySetting_Popup_Title;
	
	@FindBy(xpath="//div[contains(@id,'popover') and @role='tooltip']/div[@class='popover-content']")
	public WebElement InvalidValue_Error_Message;
	
	@FindBy(xpath="//ul[@id='physicalInventoryWeeklyDay']/li[@class='selected']")
	public WebElement PhysicalInventorySetting_SelectedDay_BT;
	
	@FindBy(xpath="//ul[@id='physicalInventoryWeeklyDay']/li")
	public List<WebElement> PhysicalInventorySetting_WeekDays_List;
	
	@FindBy(xpath="//eb-button[@id='btnSaveInventoryPhysInvSettings']/button")
	public WebElement PhysicalInventorySetting_Save_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Your Physical Inventory settings have been saved.']")
	public WebElement PhysicalInventorySettingSaved_Confirmation_MSG;
	
	@FindBy(xpath ="//section[@id='inventoryPhysInvSettings']/div/div[2]/div[3]/div[contains(@class,'bootstrap-switch')]")
	public WebElement PhysicalInventorySetting_WeeklySetting_Toggle_BT;
	
	//
	
	/************************************************/
	
	@FindBy(xpath = "//input[@id='dollar_variance']")
	public WebElement TotalInvoiceAmountVariance_TB;
	
	@FindBy(xpath = "//input[@id='case_variance']")
	public WebElement CasesVarience_TB;
	
	@FindBy(xpath = "//input[@id='submit_variance']")
	public WebElement SaveVariance_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Your Settings have been saved.']")
	public WebElement VarianceSettingsSaved_Confirmation_MSG;
	
	@FindBy(xpath = "//h4[text()='Transfer Settings']")
	public WebElement TransferSettings_Label;
	
	@FindBy(xpath = "//b[text()='Transfer Limits']")
	public WebElement TransferLimits_Label;
	
	@FindBy(xpath = "//input[@id='transfer_limit_checkbox']")
	public WebElement TransferLimits_CB;
	
	@FindBy(xpath = "//label[@class='toggle_transfer_label']")
	public WebElement TransferAndAmountLimit_Label;
	
	@FindBy(xpath = "//input[@id='transfer_limit_textbox']")
	public WebElement TransferAndAmountLimit_TB;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Values must be numeric with up to 2 decimals. (Example: 12345.99)']")
	public WebElement InvalidTransferAmount_Error_MSG;
	
	@FindBy(xpath = "//input[@id='submit_transfer_settings']")
	public WebElement TransferSetting_Save_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Transfer Settings Posted']")
	public WebElement TransferSettingPosted_MSG;
	
	@FindBy(xpath ="//div[@id='save_modal_body']/p[text()='Changes will take affect at the next start of business day']")
	public WebElement InventorySettingPosted_Alert_MSG;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement InventorySettingPostedPopUp_Continue_BT;
	
	@FindBy(xpath = "//input[@id='transfer_type_radio_ger']")
	public WebElement TransferGroupType_GER_RB;
	
	@FindBy(xpath = "//input[@id='transfer_type_radio_coop']")
	public WebElement TransferGroupType_COOP_RB;
	
}
