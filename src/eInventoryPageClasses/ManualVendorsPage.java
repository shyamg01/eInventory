package eInventoryPageClasses;

import java.io.IOException;
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

public class ManualVendorsPage extends AbstractPage
{

	public ManualVendorsPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[text()='Manual Vendors']")
	public WebElement ManualVendors_Label;	
	
	@FindBy(xpath="//eb-button[@id='add_vendor_button']/button")
	public WebElement AddVendor_BT;	
	
	@FindBy(xpath="//eb-validated-input[@id='add_vendor_name']/div/div/div/input")
	public WebElement AddvendorDetailsPopUp_VendorName_TB;	
	
	@FindBy(xpath="//eb-validated-input[@id='add_manual_number']/div/div/div/input")
	public WebElement AddvendorDetailsPopUp_ManualNumber_TB;	
	
	@FindBy(xpath="//eb-button[@id='save_new_vendor']/button")
	public WebElement AddvendorDetailsPopUp_SaveVendor_BT;

	@FindBy(xpath="//table[@id='vendor_info']/tbody/tr/td[1]")
	public List <WebElement> vendorName_List;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Manual Vendor Add Successful']")
	public WebElement AddVendorDetails_VendorAdded_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='The vendor name already exists']")
	public WebElement AddvendorDetailsPopUp_vendorNameAlreadyExists_Message;

	@FindBy(xpath = "//div[@class='toast-message' and text()='The vendor number already exists']")
	public WebElement AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='The vendor name and number already exists']")
	public WebElement AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Manual Vendor Add Successful']")
	public WebElement AddvendorDetailsPopUp_vendorAdd_Confirmation_MSG;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Manual Vendor Edit Successful']")
	public WebElement EditvendorDetails_ChangesSaved_Message;
	
	@FindBy(xpath = "//table[@id='vendor_info']/tbody/tr")
	public List<WebElement> VendorInfo_List;

	@FindBy(xpath = "//eb-validated-input[@id='edit_vendor_name']/div/div/div/input")
	public WebElement EditvendorDetailsPopUp_VendorName_TB;

	@FindBy(xpath = "//eb-validated-input[@id='edit_manual_number']/div/div/div/input")
	public WebElement EditvendorDetailsPopUp_VendorNumber_TB;

	@FindBy(xpath = "//eb-button[@id='save_vendor_changes']/button")
	public WebElement EditvendorDetailsPopUp_SaveVendor_BT;

	@FindBy(xpath = "//div[@class='toast-message' and contains(.,'Manual Vendor Delete Successful')]")
	public WebElement DeleteVendorPopUp_Confirmation_Message;

	@FindBy(xpath = "//div[@class='toast-message' and text()='Manual Vendor Delete Successful']")
	public WebElement DeleteVendorPopUp_VendorDeleted_Message;
	
	@FindBy(xpath="//eb-button[@id='restore_manual_vendor']/button")
	public WebElement RestoreManualVendor_BT;
	
	@FindBy(xpath = "//h2[text()='Vendor Details']")
	public WebElement EditVendorDetails_Title;
	
	@FindBy(xpath = "//h2[text()='Add Vendor Details']")
	public WebElement AddVendorDetails_Title;
	
	@FindBy(xpath = "//eb-button[@value='Delete']/button")
	public WebElement Delete_BT;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement DeleteVendorConfirmationPopUp_Yes_BT;
	
	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement DeleteVendorConfirmationPopUp_No_BT;
	
	@FindBy(xpath="//h2[text()='Restore Manual Vendor']")
	public WebElement RestoreManualVendor_Title;
	
	@FindBy(xpath = "//eb-button[@id='restore_deleted_vendors_btn']/button")
	public WebElement RestoreManualVendor_Restore_BT;
	
	@FindBy(xpath = "//eb-button/button/span[text()='Yes']")
	public WebElement RestoreManualVendor_Yes_BT;
	
	@FindBy(xpath = "//eb-button/button/span[text()='No']")
	public WebElement RestoreManualVendor_No_BT;
	
	@FindBy(xpath = "(//eb-button[@value='Cancel']/button)[1]")
	public WebElement EditVendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath="//th[text()='Vendor Name']")
	public WebElement RestoreManualVendor_VendorName_Header;
	
	@FindBy(xpath="//th[text()='Manual Number']")
	public WebElement RestoreManualVendor_ManualNumber_Header;
	
	@FindBy(xpath="//th[text()='All']")
	public WebElement RestoreManualVendor_SelectAll_Header;
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[3]")
	public WebElement AddvendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath="//eb-button[@class='cancel_add_vendor']/button[@id='htmlButton' and text()='Cancel']")
	public WebElement AddvendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement EditVendorForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='edit_vendor_modal']/div[contains(@class,'container')]")
	public WebElement EditVendorForm_Container;
	
	@FindBy(xpath = "//eb-modal[@id='add_vendor_modal']/div[contains(@class,'container')]")
	public WebElement AddVendorForm_Container;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[2]")
	public WebElement AddVendorForm_SliderToggle_BT;
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[2]")
	public WebElement EditvendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath="//eb-button[@class='cancel_add_vendor']/button[@id='htmlButton' and text()='Cancel']")
	public WebElement EditvendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='You must enter a vendor name']")
	public WebElement EditvendorDetailsPopUp_EnterVendorName_Message;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Deleting this vendor will move any Raw Items that were associated to this vendor to \"normal\" status. You must reassign these raw items to another manual vendor if they are manual purchase items.')]/following-sibling::p[contains(text(),'Are you sure you want to proceed?')]")
	public WebElement DeletevendorDetailsPopUp_Confirmation_Message;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'This vendor has pending invoices.')]/following-sibling::p[contains(text(),'Please finalize all invoices for this vendor before deleting.')]")
	public WebElement DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message;
	
	@FindBy(xpath = "//button/span[text()='OK']")
	public WebElement DeletevendorDetailsConfirmationPopUp_OK_BT;
	
	@FindBy(xpath = "//div[@class='restore-disclaimer']")
	public WebElement RestoreDeletedVendor_Disclaimer_Message;
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[4]")
	public WebElement RestoreVendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath="(//eb-button[@value='Cancel']/button)[3]")
	public WebElement RestoreVendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath="//table[@id='deleted_manual_vendors']/tbody/tr/td[2]")
	public List <WebElement> DeletedVendorName_List;
	
	@FindBy(xpath="//table[@id='deleted_manual_vendors']/tbody/tr/td[3]")
	public List <WebElement> DeletedVendorNumber_List;
	
	@FindBy(xpath="//table[@id='deleted_manual_vendors']/tbody/tr/td[1]")
	public List <WebElement> DeletedVendorSelect_ChkBox_List;
	
	@FindBy(xpath="//table[@id='deleted_manual_vendors']/tbody/tr")
	public List <WebElement> DeletedVendor_List;
	
	@FindBy(xpath = "//div[@id='dlgContent']")
	public WebElement RestoreVendorPopUp_Confirmation_Message;
	
	@FindBy(xpath = "//div[@id='back-to-top']")
	public WebElement BackToTop_BT;
	
	@FindBy(xpath="//eb-modal[@id='add_vendor_modal']")
	public List <WebElement> AddVendorModel_List;
	
	@FindBy(xpath="//eb-modal[@id='restore_manual_vendor_modal']")
	public List <WebElement> RestoreVendorModel_List;
	
	@FindBy(xpath="//div[contains(@id,'popover')]/div[@class='popover-content']")
	public WebElement InvalidVendorNameNumber_Error_Message;
		
	// This method will return vendor row object from manual vendor page
	public WebElement VendorName_Row(String vendorName) {
		return driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName + "']"));
	}
	
	// This method will return vendor row object from manual vendor page
	public WebElement VendorNumber_Row(String vendorName) {
		return driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName + "']/following-sibling::td[1]"));
	}

	// This method will verify that a vendor has been deleted from the manual vendor page
	public boolean verifyVendorDeleted(String vendorName) {
		for (int i = 1; i <= VendorInfo_List.size(); i++) {
			String vendor = driver.findElement(By.xpath("(//table[@id='vendor_info']/tbody/tr)[" + i+ "]/td[1]")).getText();
			if (vendor.equals(vendorName)) {
				return false;
			}
		}
		return true;
	}

	// This method will create a new vendor in manual vendor page
	public ManualVendorsPage createANewVendor(String vendorName,String manualNumber) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		// CLick on Add New vendor button
		GenericMethods.clickOnElement(AddVendor_BT,"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",vendorName);
		Thread.sleep(1000);
		GenericMethods.clearValueOfElement(AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",manualNumber);
		// Click on Save vendor button
		GenericMethods.clickOnElement(AddvendorDetailsPopUp_SaveVendor_BT,"AddvendorDetailsPopUp_SaveVendor_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(AddVendorDetails_VendorAdded_Message)),"AddVendorDetails_VendorAdded_Message");
		Thread.sleep(1000);
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
		
	public ManualVendorsPage restoreManualVendor(String vendorName) throws RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_Title));
		System.out.println("//table[@id='deleted_manual_vendors']/tbody/tr/td[text()='"+vendorName+"']/preceding-sibling::td[@class='select-checkbox']");
		WebElement vendorChkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='deleted_manual_vendors']/tbody/tr/td[text()='"+vendorName+"']/preceding-sibling::td[@class='select-checkbox']")));
		GenericMethods.clickOnElement(vendorChkBox,"vendorChkBox");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_Restore_BT)),"RestoreManualVendor_Restore_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(RestoreManualVendor_Yes_BT)),"RestoreManualVendor_Yes_BT");
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
	
	public boolean verifyVendorIsMovedFromRestoreVendorScreen(String vendorName) throws RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_BT)),"RestoreManualVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_Title));
		return !Base.isElementDisplayed(By.xpath("//table[@id='deleted_manual_vendors']/tbody/tr/td[text()='"+vendorName+"']"));
	}
	
	//This method will return the Edit button for any vendor in manual vendor page 
	public WebElement editVendor_BT(String vendorName)throws InterruptedException {
		Thread.sleep(1000);
		WebElement editButton = driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName+ "']/following-sibling::td/eb-button[@value='Edit']/button"));
		return editButton;
	}
	
	// This method will create a new vendor in manual vendor page
	public ManualVendorsPage editVendorDetails(String vendorName,String manualNumber) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(EditvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(EditvendorDetailsPopUp_VendorName_TB,"EditvendorDetailsPopUp_VendorName_TB",vendorName);
		GenericMethods.clearValueOfElement(EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB");
		GenericMethods.enterValueInElement(EditvendorDetailsPopUp_VendorNumber_TB,"EditvendorDetailsPopUp_VendorNumber_TB",manualNumber);
		GenericMethods.clickOnElement(EditVendorDetails_Title,"EditVendorDetails_Title");
		// Click on Save vendor button
		GenericMethods.clickOnElement(EditvendorDetailsPopUp_SaveVendor_BT,"EditvendorDetailsPopUp_SaveVendor_BT");
		wait.until(ExpectedConditions.visibilityOf(EditvendorDetails_ChangesSaved_Message));
		wait.until(ExpectedConditions.visibilityOf(VendorName_Row(vendorName)));
		Thread.sleep(3000);
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
	
	public void clickEditButtonUsingJSExecuter(int buttonRow){
		Base.executeJavaScript("document.getElementsByClassName('edit_vendor')["+buttonRow+"].click()");
	}
	
		
}
