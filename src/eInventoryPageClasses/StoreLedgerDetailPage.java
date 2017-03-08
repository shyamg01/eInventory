package eInventoryPageClasses;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.Base;

import common.Reporter;

public class StoreLedgerDetailPage extends AbstractPage {
	public StoreLedgerDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='form-control ebos-input']/option[1]")
	public WebElement month_DD_FirstElement;

	@FindBy(xpath = "//select[@class='form-control ebos-input']")
	public WebElement month_DD;

	@FindBy(xpath = "//label[contains(.,'Search')]")
	private WebElement Search_Lable;

	@FindBy(xpath = "//label[contains(.,'Search')]/input")
	private WebElement Search_TB;

	@FindBy(xpath = "//a[text()='View Ledger']/span")
	public WebElement storeledger_Count;

	/***store Ledger Table ******/
	@FindBy(xpath = "//table[@id='ledger_table']/tbody/tr[@class='even' or @class='odd']")
	public List<WebElement> storeledger_List;
	
	@FindBy(xpath="//table[@id='ledger_table']/tbody/tr/td[@class='dataTables_empty']/div[2]")
	public WebElement StoreLedgerTable_NoLedgerInfo_Msg;
	
	@FindBy(xpath="//table[@id='ledger_table']/tbody/tr/td[@class='dataTables_empty']/div[1]/img")
	public WebElement StoreLedgerTable_NoLedgerInfo_Img;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Delivery Date']")
	public WebElement StoreLedgerTable_DeliveryDate_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[2]")
	public WebElement StoreLedgerTable_Invoice_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Type']")
	public WebElement StoreLedgerTable_Type_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[4]")
	public WebElement StoreLedgerTable_InvoiceTotal_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Food']")
	public WebElement StoreLedgerTable_Food_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Paper']")
	public WebElement StoreLedgerTable_Paper_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Non']")
	public WebElement StoreLedgerTable_NonProduct_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Ops Supplies']")
	public WebElement StoreLedgerTable_OpsSupplies_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Linens']")
	public WebElement StoreLedgerTable_Linens_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Non-Product']")
	public WebElement StoreLedgerTable_NonProductHappyMealPremium_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[contains(text(),'Non Product')]")
	public WebElement StoreLedgerTable_NonProductOther_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Tax 1']")
	public WebElement StoreLedgerTable_Tax1_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Tax 2']")
	public WebElement StoreLedgerTable_Tax2_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='Tax 3']")
	public WebElement StoreLedgerTable_Tax3_Label;
	
	@FindBy(xpath = "//div[@id='ledger_table_wrapper']/div[2]/div[1]//table/thead//th[text()='State Tax']")
	public WebElement StoreLedgerTable_StateTax_Label;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[text()='Grand Total:']")
	public WebElement StoreLedgerTable_GrandTotal_Label;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[4]")
	public WebElement StoreLedgerTable_InvoiceTotal_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[5]")
	public WebElement StoreLedgerTable_Food_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[6]")
	public WebElement StoreLedgerTable_Paper_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[7]")
	public WebElement StoreLedgerTable_NonProduct_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[8]")
	public WebElement StoreLedgerTable_OpsSupplies_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[9]")
	public WebElement StoreLedgerTable_Linens_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[10]")
	public WebElement StoreLedgerTable_NonProductHappyMealPremium_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[11]")
	public WebElement StoreLedgerTable_NonProductOther_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[12]")
	public WebElement StoreLedgerTable_Tax1_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[13]")
	public WebElement StoreLedgerTable_Tax2_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[14]")
	public WebElement StoreLedgerTable_Tax3_Value;
	
	@FindBy(xpath = "//tr[@id='grand_total_row_id']/td[15]")
	public WebElement StoreLedgerTable_StateTax_Value;
	
	@FindBy(xpath = "//table[@id='ledger_table']/tbody/tr[contains(@class,'TRANSFERS ')]")
	public List<WebElement> StoreLedgerTable_Transfers_List;
	


	//@Author :Hemlata
	// This method will return one year mm/yyyy based on current month and year
	public ArrayList<String> getDateSequence() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String Year = Integer.toString(year);
		int Month = (now.get(Calendar.MONTH) + 1);
		ArrayList<String> dateSequenceUpToOneYear = new ArrayList<>();
		dateSequenceUpToOneYear.add(Base.getMonthName(Month) + " " + Year);
		int monthCount = 12;
		for (int i = 0; i < 11; i++) {
			int lastMonth = now.get(Calendar.MONTH) - i;
			int lastYear;
			int getMonth;
			if (lastMonth <= 0) {
				getMonth = monthCount + lastMonth;
				lastYear = now.get(Calendar.YEAR) - 1;
				dateSequenceUpToOneYear.add(Base.getMonthName(getMonth) + " "+ lastYear);

			} else {
				getMonth = lastMonth;
				lastYear = now.get(Calendar.YEAR);
				dateSequenceUpToOneYear.add(Base.getMonthName(getMonth) + " "+ lastYear);
			}
		}
		return dateSequenceUpToOneYear;

	}


	/*@Author :Hemlata
	This method will return the Select Store Ledger BY Month option list*/
	public ArrayList<String> getDateOptionsFromSelectStoreLedgerDropDown() {
		ArrayList<String> dateValues = new ArrayList<String>();
		Select DateDropDown = new Select(month_DD);
		for (WebElement month : DateDropDown.getOptions()) {
			dateValues.add(month.getAttribute("value"));
		}
		return dateValues;
	}

	public void selectMonthFromStoreLedgerDrpDwn(String date) throws InterruptedException {
		int month = Base.getMonthFromDate(date);
		String monthName = Base.getMonthName(month+1);
		int year = Base.getYearFromDate(date);
		String option = monthName +" "+year;
		System.out.println("option "+option);
		wait.until(ExpectedConditions.visibilityOf(month_DD));
		Select DateDropDown = new Select(month_DD);
		DateDropDown.selectByVisibleText(option);
	}

	/*@Author :Hemlata
	This method will verify that the data in store ledger table should be for selected mm/yyyy*/
	public boolean verifyDataForSelectedMonth(String date) {
		int month = Base.getMonthFromDate(date)+1;
		int year = Base.getYearFromDate(date);
		boolean result = true;
		for (int i = 1; i < storeledger_List.size(); i++) {
			String recordDate = driver
					.findElement(By.xpath("(//table[@id='ledger_table']/tbody/tr[@class='even' or @class='odd'])["+ i + "]/td[1]/span")).getText();
			System.out.println("date "+recordDate);
			result = result && (Integer.parseInt(recordDate.split("/")[0]) == month);
			result = result && (Integer.parseInt(recordDate.split("/")[2]) == year);
		}
		return result;

	}
	
	//@Author :Hemlata
	
		public boolean verifyPosetedPurchaseDisplayedForNewVendor(String vendorName,String date,String invoiceID){
			//clickOnVendorGroup(vendorName);
			vendorName = vendorName.toUpperCase().replaceAll(" ", "_");
			System.out.println("//table[@id='ledger_table']/tbody/tr[contains(@class,'"+vendorName+" ')]/td/span[text()='"+date+"']/../following-sibling::td[1]/span[text()='"+invoiceID+"']");
			return Base.isElementDisplayed(driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr[contains(@class,'"+vendorName+" ')]/td/span[text()='"+date+"']/../following-sibling::td[1]/span[text()='"+invoiceID+"']")));
		}
	
	//verify that transfer details are displayed in Store Ledger Page
	public boolean verifyTransferIsDisplayedInStoreLedgerPage(String nationalStoreNumber, String Date,String amount,String type){
		System.out.println("//table[@id='ledger_table']//tr/td/span[text()='"+Date+"']/../following-sibling::td/span[text()='"+nationalStoreNumber+"']/../following-sibling::td[contains(text(),'$"+amount+"')]/preceding-sibling::td/span[text()='"+type+"']");
		if (type.equalsIgnoreCase("In"))
		{
			return driver.findElement(By.xpath("//table[@id='ledger_table']//tr/td/span[text()='"+Date+"']/../following-sibling::td/span[text()='"+nationalStoreNumber+"']/../following-sibling::td[contains(text(),'$"+amount+"')]/preceding-sibling::td/span[text()='"+type+"']")).isDisplayed();

		}
		else
		{
			return driver.findElement(By.xpath("//table[@id='ledger_table']//tr/td/span[text()='"+Date+"']/../following-sibling::td/span[text()='"+nationalStoreNumber+"']/../following-sibling::td[contains(text(),'$-"+amount+"')]/preceding-sibling::td/span[text()='"+type+"']")).isDisplayed();

		}
	}
	
	public boolean verifyVendorGroupIsDisplayed(String vendorName){
		vendorName = vendorName.toUpperCase().replaceAll(" ", "_");
		System.out.println("//tr[contains(@class,'"+vendorName+"_group')]");
		return Base.isElementDisplayed(By.xpath("//tr[contains(@class,'"+vendorName+"_group')]"));
	}
	
	public boolean verifyDeliveryDateInDescendingOrder(String vendorName) throws ParseException{
		vendorName = vendorName.toUpperCase().replaceAll(" ", "_");
		List<WebElement>deliveryDate_List = driver.findElements(By.xpath("//tr[contains(@class,'"+vendorName+" ')]/td[1]/span"));
		List<String>dateValueList = Base.getTextListFromWebElements(deliveryDate_List);
		return Base.verifyDateInDescendingOrder(dateValueList);
	}
	
	public boolean verifyTransferActivitiesDisplayedInStoreLedgerDetailsPage(String createDate, String storeNumber, String transferType, String transferAmount){
		System.out.println("(//tr[contains(@class,'TRANSFERS ')]/td[1]/span[contains(text(),'"+createDate+"')]/../following-sibling::td/span[text()='"+storeNumber+"']/../following-sibling::td[1]/span[text()='"+transferType+"']/../following-sibling::td[contains(text(),'"+transferAmount+"')])[1]");
		return Base.isElementDisplayed(By.xpath("(//tr[contains(@class,'TRANSFERS ')]/td[1]/span[contains(text(),'"+createDate+"')]/../following-sibling::td/span[text()='"+storeNumber+"']/../following-sibling::td[1]/span[text()='"+transferType+"']/../following-sibling::td[contains(text(),'"+transferAmount+"')])[1]"));
	}
	

}
