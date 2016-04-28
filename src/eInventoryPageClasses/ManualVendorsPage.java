package eInventoryPageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

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
	
	@FindBy(xpath="(//eb-button[@value='Cancel']/button)[2]")
	public WebElement AddvendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath="//table[@id='vendor_info']/tbody/tr/td[1]")
	public List <WebElement> vendorName_List;
	
	@FindBy(xpath="//table[@id='vendor_info']/tbody/tr/td[2]")
	public List <WebElement> vendorNumber_List;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Manual Vendor Add Successful']")
	public WebElement AddVendorDetails_VendorAdded_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='This vendor name already exists']")
	public WebElement AddvendorDetailsPopUp_vendorAlreadyExists_Message;

	@FindBy(xpath = "//div[@class='toast-message' and text()='This vendor number already exists']")
	public WebElement AddvendorDetailsPopUp_vendorNumberAlreadyExists_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='This vendor name and number already exists']")
	public WebElement AddvendorDetailsPopUp_vendorNameAndNumberAlreadyExists_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Duplicate of deleted vendor, use 'Restore Manual Vendor' button to restore.']")
	public WebElement AddvendorDetailsPopUp_DuplicateDeletedVendor_Message;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Changes Saved']")
	public WebElement AddvendorDetailsPopUp_vendorSaved_Message;
	
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

	@FindBy(xpath = "//input[contains(@class,'delete_vendor_confirmation')]")
	public WebElement DeleteVendorPopUp_Confirmation_BT;

	@FindBy(xpath = "//div[@id='delete_manual_vendor_confirmation_modal']//div[@class='modal-content']/div[@class='modal-header']/input[@class='close']")
	public WebElement DeleteVendorPopUp_Close_BT;

	@FindBy(xpath = "//div[@class='toast-message' and text()='Manual Vendor Delete Successful']")
	public WebElement DeleteVendorPopUp_VendorDeleted_Message;
	
	@FindBy(xpath="//eb-button[@id='restore_manual_vendor']/button")
	public WebElement RestoreManualVendor_BT;
	
	@FindBy(xpath = "//input[@id='restore_manual_vendors_confirmation']")
	public WebElement RestoreVendorPopUp_Confirmation_BT;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Vendor Restored']")
	public WebElement VendoreRestored_Message;
	
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
	
	@FindBy(xpath = "//eb-button[@value='Restore']/button")
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
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[2]")
	public WebElement AddvendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement EditVendorForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='edit_vendor_modal']/div[contains(@class,'container')]")
	public WebElement EditVendorForm_Container;
	
	@FindBy(xpath = "//eb-modal[@id='add_vendor_modal']/div[contains(@class,'container')]")
	public WebElement AddVendorForm_Container;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[2]")
	public WebElement AddVendorForm_SliderToggle_BT;
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[1]")
	public WebElement EditvendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='You must enter a vendor name']")
	public WebElement EditvendorDetailsPopUp_EnterVendorName_Message;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[1]")
	public WebElement DeletevendorDetailsPopUp_Confirmation_Message;
	
	@FindBy(xpath = "//button/span[text()='OK']")
	public WebElement DeletevendorDetailsConfirmationPopUp_OK_BT;
	
	@FindBy(xpath = "//div[@class='restore-disclaimer']")
	public WebElement RestoreDeletedVendor_Disclaimer_Message;
	
	@FindBy(xpath="(//div[@id='header-row']/div[contains(@class,'modal-close')])[3]")
	public WebElement RestoreVendorDetailsPopUp_Close_BT;
	
	@FindBy(xpath="(//eb-button[@value='Cancel']/button)[3]")
	public WebElement RestoreVendorDetailsPopUp_Cancel_BT;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[3]")
	public WebElement RestoreVendorForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='restore_manual_vendor_modal']/div[contains(@class,'container')]")
	public WebElement RestoreVendorForm_Container;
	
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
	
	@FindBy(xpath="//eb-modal[@id='edit_vendor_modal']")
	public List <WebElement> EditVendorModel_List;
	
	@FindBy(xpath="//eb-modal[@id='restore_manual_vendor_modal']")
	public List <WebElement> RestoreVendorModel_List;
		
	// This method will return vendor row object from manual vendor page
	public WebElement VendorName_Row(String vendorName) {
		return driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName + "']"));
	}
	
	// This method will return vendor row object from manual vendor page
	public WebElement VendorNumber_Row(String vendorName) {
		return driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName + "']/following-sibling::td[1]"));
	}

	// This method will return the delete button for any vendor in manual vendor page
	public WebElement deleteVendor_BT(String vendorName)throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName+ "']/following-sibling::td/input[@class='delete_vendor']"));
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
	public ManualVendorsPage createANewVendor(String vendorName,String manualNumber) throws InterruptedException {
		// CLick on Add New vendor button
		AddVendor_BT.click();
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		AddvendorDetailsPopUp_VendorName_TB.clear();
		AddvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
		Thread.sleep(1000);
		AddvendorDetailsPopUp_ManualNumber_TB.clear();
		AddvendorDetailsPopUp_ManualNumber_TB.sendKeys(manualNumber);
		// Click on Save vendor button
		AddvendorDetailsPopUp_SaveVendor_BT.click();
		wait.until(ExpectedConditions.visibilityOf(AddVendorDetails_VendorAdded_Message)).click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
		
	public ManualVendorsPage restoreManualVendor(String vendorName){
		wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_Title));
		System.out.println("//table[@id='deleted_manual_vendors']/tbody/tr/td[text()='"+vendorName+"']/preceding-sibling::td[@class='select-checkbox']");
		WebElement vendorChkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='deleted_manual_vendors']/tbody/tr/td[text()='"+vendorName+"']/preceding-sibling::td[@class='select-checkbox']")));
		vendorChkBox.click();
		wait.until(ExpectedConditions.visibilityOf(RestoreManualVendor_Restore_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(RestoreManualVendor_Yes_BT)).click();
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
	
	public boolean verifyDuplicateVendorIsNotRestored(String vendorName){
		return (driver.findElements(By.xpath("//table[@id='vendor_info']//tr/td[text()='"+vendorName+"']")).size()==1);
	}
	
	public boolean verifyVendorIsRestored(String vendorName){
		return Base.isElementDisplayed(By.xpath("//table[@id='vendor_info']//tr/td[text()='"+vendorName+"']"));
	}
	
	//This method will return the Edit button for any vendor in manual vendor page 
	public WebElement editVendor_BT(String vendorName)throws InterruptedException {
		Thread.sleep(1000);
		WebElement editButton = driver.findElement(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName+ "']/following-sibling::td/eb-button[@value='Edit']/button"));
		return editButton;
	}
	
	public boolean verifyEditButtonDisplayed(String vendorName){
		return Base.isElementDisplayed(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName+ "']/following-sibling::td/eb-button[@value='Edit']/button"));
	}
	
	public boolean verifyDeleteButtonDisplayed(String vendorName){
		return Base.isElementDisplayed(By.xpath("//table[@id='vendor_info']/tbody/tr/td[text()='"+ vendorName+ "']/following-sibling::td/eb-button[@value='Delete']/button"));
	}
	
	// This method will create a new vendor in manual vendor page
	public ManualVendorsPage editVendorDetails(String vendorName,String manualNumber) throws InterruptedException {
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(EditvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		EditvendorDetailsPopUp_VendorName_TB.clear();
		EditvendorDetailsPopUp_VendorName_TB.sendKeys(vendorName);
		EditvendorDetailsPopUp_VendorNumber_TB.clear();
		EditvendorDetailsPopUp_VendorNumber_TB.sendKeys(manualNumber);
		// Click on Save vendor button
		EditvendorDetailsPopUp_SaveVendor_BT.click();
		//wait.until(ExpectedConditions.visibilityOf(Confirmation_Message));
		wait.until(ExpectedConditions.visibilityOf(VendorName_Row(vendorName)));
		Thread.sleep(3000);
		return PageFactory.initElements(driver, ManualVendorsPage.class);
	}
	
	public void clickEditButtonUsingJSExecuter(int buttonRow){
		Base.executeJavaScript("document.getElementsByClassName('edit_vendor')["+buttonRow+"].click()");
	}
	
		
}
