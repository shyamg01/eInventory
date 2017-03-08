package eInventoryPageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Base;

public class AuditPage extends AbstractPage {

	public AuditPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h1[text()='Audit']")
	public WebElement Audit_Label;
	
	@FindBy(xpath ="//input[@id='audit_start_date_input']")
	public WebElement AuditStartDate_TB ;
	
	@FindBy(xpath ="//input[@id='audit_end_date_input']")
	public WebElement AuditEndDate_TB ;
	
	@FindBy(xpath ="//eb-button[@value='Show Results']/button")
	public WebElement ShowResults_BT;
	
	@FindBy(xpath ="//*[@id='audit_employee_list']/div/div[@id='eb_dd_input']")
	public WebElement Employee_DD;
	
	public boolean verifyManualVendorNameAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Vendors']/../following-sibling::td/span[text()='Name']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public boolean verifyManualVendorNumberAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Vendors']/../following-sibling::td/span[text()='Manual Number']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	//Raw Item Information Audit Log
	
	public boolean verifyRawItemInvoiceTypeAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Raw Item Info']/../following-sibling::td/span[text()='Invoice Type']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public boolean verifyRawItemCasePriceAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Raw Item Info']/../following-sibling::td/span[text()='Case Price']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public boolean verifyRawItemFrequencyAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Raw Item Info']/../following-sibling::td/span[text()='Frequency']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public boolean verifyRawItemAccountNumberAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Raw Item Info']/../following-sibling::td/span[text()='McD GL Acct Number']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public boolean verifyRawItemAccountPrimaryVendorAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Raw Item Info']/../following-sibling::td/span[text()='Primary Vendor']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
	
	public String getListType(String listType){
		switch (listType) {
		case "Weekly":
			return "W";
		case "Monthly":
			return "M";
		case "Daily":
			return "D";
		default:
			return "D";
		} 
	}
	
	//Food Over BAse Page Audit
	public boolean verifyFOBCommentsAuditDisplayed(String eId, String beforeValue, String afterValue, String date){
		return Base.isElementDisplayed(By.xpath(".//*[@id='audit_landing_table']//tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+eId+"']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/span[text()='Store Food Over Base']/../following-sibling::td/span[text()='Save Comments']/../following-sibling::td/span[text()='"+beforeValue+"']/../following-sibling::td/span[text()='"+afterValue+"']"));
	}
}
