package eInventoryPageClasses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Base;

public class ApproveAdjustmentsPage extends AbstractPage{
	
	public ApproveAdjustmentsPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Approve Adjustments']/span")
	public WebElement ApproveAdjustmentsTab_Count;
	
	@FindBy(xpath="//table[@id='eb_adjustment_table']/tbody/tr/td[@class='dataTables_empty']/div[2]")
	public WebElement ApproveAdjustmentsTable_NoPendingPurchases_Msg;
	
	@FindBy(xpath="//table[@id='eb_adjustment_table']/tbody/tr/td[@class='dataTables_empty']/div[1]/img")
	public WebElement ApproveAdjustmentsTable_NoPendingPurchases_Img;
	
	@FindBy(xpath="//table[@id='eb_adjustment_table']/thead")
	public WebElement ApproveAdjustmentsTable_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Delivery Date']")
	public WebElement ApproveAdjustmentsTable_DeliveryDate_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Status']")
	public WebElement ApproveAdjustmentsTable_Status_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Vendor']")
	public WebElement ApproveAdjustmentsTable_Vendor_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Invoice']")
	public WebElement ApproveAdjustmentsTable_Invoice_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='WRIN']")
	public WebElement ApproveAdjustmentsTable_WRIN_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Description']")
	public WebElement ApproveAdjustmentsTable_Description_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Cases Purchased']")
	public WebElement ApproveAdjustmentsTable_CasesPurchased_header;
	
	@FindBy(xpath="//th[@aria-controls='eb_adjustment_table' and text()='Cases Credit']")
	public WebElement ApproveAdjustmentsTable_CasesCredit_header;
	
	@FindBy(xpath="//table[@id='eb_adjustment_table']/tbody/tr/td[1]")
	public List<WebElement> ApproveAdjustmentsTable_DeliveryDate_List;
	

	public boolean verifyApproveButtonDisplayedForRecordsWithNeedsApprovalStatus(){
		List<WebElement>adjustmentsList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[text()='Needs Approval!']"));
		boolean result = true;
		for(int i=1;i<=adjustmentsList.size();i++){
			result = result & Base.isElementDisplayed(By.xpath("(//table[@id='eb_adjustment_table']/tbody/tr/td[text()='Needs Approval!'])["+i+"]/following-sibling::td/eb-button[@id='eb_approve_button']"));
		}
		return result;
	}
	
	public boolean verifyDeliverDateInDescendingOrder() throws ParseException
	{
		List<WebElement>dateList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[1]"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		boolean result = true;
		for(int i=0;i< dateList.size();i++){
			if(i<dateList.size()-1){
				String date1 = dateValueList.get(i);
				System.out.println("date1 "+date1);
				Date recordDate1 = df.parse(date1);
				String date2 = dateValueList.get(i+1);
				System.out.println("date2 "+date2);
				Date recordDate2 = df.parse(date2);
				System.out.println("result is "+ (recordDate1.after(recordDate2) ||recordDate1.equals(recordDate2)));
				if((recordDate1.compareTo(recordDate2)>0 ||recordDate1.compareTo(recordDate2) == 0)){
					result = result & true;
				}else{
					result = result & false;
					}
			}
		}
		return result;
	}
	
	public boolean verifyDeliverDateInAscendingOrder() throws ParseException{
		List<WebElement>dateList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[1]"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		boolean result = true;
		for(int i=0;i< dateList.size();i++){
			if(i<dateList.size()-1){
				String date1 = dateValueList.get(i);
				System.out.println("date1 "+date1);
				Date recordDate1 = df.parse(date1);
				String date2 = dateValueList.get(i+1);
				System.out.println("date2 "+date2);
				Date recordDate2 = df.parse(date2);
				System.out.println("result is "+ (recordDate1.after(recordDate2) ||recordDate1.equals(recordDate2)));
				if((recordDate1.compareTo(recordDate2)>0 ||recordDate1.compareTo(recordDate2) == 0)){
					result = result & true;
				}else{
					result = result & false;
					}
			}
		}
		return result;
	}
	
	public boolean verifyStatusInDescendingOrder() throws ParseException{
		List<WebElement>statusList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[2]"));
		List<String>statusValueList = Base.getTextListFromWebElements(statusList);
		return Base.verifyStringInDescendingOrder(statusValueList);
	}
	
	public boolean verifyStatusInAscendingOrder() throws ParseException{
		List<WebElement>statusList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[2]"));
		List<String>statusValueList = Base.getTextListFromWebElements(statusList);
		return Base.verifyStringInAsscendingOrder(statusValueList);
	}
	
	public boolean verifyVendorInDescendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[3]"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInDescendingOrder(vendorValueList);
	}
	
	public boolean verifyVendorInAscendingOrder() throws ParseException{
		List<WebElement>vendorList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[3]"));
		List<String>vendorValueList = Base.getTextListFromWebElements(vendorList);
		return Base.verifyStringInAsscendingOrder(vendorValueList);
	}
	
	public boolean verifyInvoiceInDescendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[4]"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyStringInDescendingOrder(invoiceValueList);
	}
	
	public boolean verifyInvoiceInAscendingOrder() throws ParseException{
		List<WebElement>invoiceList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[4]"));
		List<String>invoiceValueList = Base.getTextListFromWebElements(invoiceList);
		return Base.verifyStringInAsscendingOrder(invoiceValueList);
	}
	
	public boolean verifyWrinInAscendingOrder() throws ParseException{
		List<WebElement>wrinList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[5]"));
		List<String>wrinValueList = Base.getTextListFromWebElements(wrinList);
		return Base.verifyStringInAsscendingOrder(wrinValueList);
	}
	
	public boolean verifyWrinInDescendingOrder() throws ParseException{
		List<WebElement>wrinList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[5]"));
		List<String>wrinValueList = Base.getTextListFromWebElements(wrinList);
		return Base.verifyStringInAsscendingOrder(wrinValueList);
	}
	
	public boolean verifyDescriptionInAscendingOrder() throws ParseException{
		List<WebElement>descriptionList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[6]"));
		List<String>descriptionValueList = Base.getTextListFromWebElements(descriptionList);
		return Base.verifyStringInAsscendingOrder(descriptionValueList);
	}
	
	public boolean verifyDescriptionInDescendingOrder() throws ParseException{
		List<WebElement>descriptionList = driver.findElements(By.xpath("//table[@id='eb_adjustment_table']/tbody/tr/td[6]"));
		List<String>descriptionValueList = Base.getTextListFromWebElements(descriptionList);
		return Base.verifyStringInAsscendingOrder(descriptionValueList);
	}
	

}
