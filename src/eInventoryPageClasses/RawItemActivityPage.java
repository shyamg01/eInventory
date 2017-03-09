package eInventoryPageClasses;

import java.io.IOException;
import java.util.Calendar;
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

public class RawItemActivityPage extends AbstractPage 
{

	public RawItemActivityPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//h1[contains(.,'Raw Item Information & Activity')]")
	public WebElement RawItemActivity_Title;
	
	@FindBy(xpath ="//label[contains(.,'Item')]")
	public WebElement Item_Label;

	@FindBy(xpath = "//input[@id='autosearchInput']")
	public WebElement Search_TB;

	@FindBy(xpath = ".//*[@id='get_item_details_btn']")
	public WebElement getItemDetails_Button;
	
	@FindBy(xpath="//input[@id='raw_activity_history_start_date']")
	public WebElement StartDate_TB;
	
	@FindBy(xpath="//input[@id='raw_activity_history_end_date']")
	public WebElement EndDate_TB;
	
	@FindBy(xpath="//eb-button[@id='raw_item_information_btn']/button")
	public WebElement Information_BT;
	
	@FindBy(xpath = "//h2[text()='Current Day Activity']")
	public WebElement RawItemInformation_CurrentDayActivity_Label;

	@FindBy(xpath = "//div[@id='kpi-header']/div")
	public WebElement RawItemInformation_Arrow_Sign;
	
	@FindBy(xpath = "//th[text()='Created By']")
	public WebElement RawItemActivityTable_CreatedByHeader;
	
	@FindBy(xpath = "//div/span[contains(.,'Average Cost per Unit')]/../following-sibling::div[1]/span")
	public WebElement AveratCostPerUnit_Value;
	
	@FindBy(xpath = "//h2[text()='Raw Item Information']")
	public WebElement RawItemInformation_Title;
	
	@FindBy(xpath = "//div[@id='raw_item_info_list']//input[@type='checkbox']")
	public WebElement RawItemInformation_popUp_ManualPurchase_CB;
	
	@FindBy(xpath = "//select[@id='select_list_type']")
	public WebElement RawItemInformation_popUp_Frequency_DD;
	
	@FindBy(xpath = "//select[@id='gl_account']")
	public WebElement RawItemInformation_popUp_GLAccount_DD;
	
	@FindBy(xpath = "//span[@id='mcd_gl_acct_num']")
	public WebElement RawItemInformation_popUp_GLAccount_Value;
	
	@FindBy(xpath = "//select[@ddm-data='raw_item.primary_vdr']")
	public WebElement RawItemInformation_popUp_PrimaryVendor_DD;
	
	@FindBy(xpath = "//input[@id='latest_case_price_editable']")
	public WebElement RawItemInformation_popUp_CasePrice_TB;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Values must be numeric with up to 4 decimals. (Example: 12345.9999)']")
	public WebElement RawItemInformation_popUp_CasePrice_Error_MSG;
	
	@FindBy(xpath = "//eb-button[@id='raw_item_info_modal_submit_btn']/button")
	public WebElement RawItemInformation_popUp_Submit_BT;
	
	@FindBy(xpath = "//button[@value='Cancel']")
	public WebElement RawItemInformation_popUp_Cancel_BT;
	
	@FindBy(xpath = "//div[@class='toast-message' and text()='Raw Item Information Changes Saved']")
	public WebElement RawItemInformation_popUp_ChangesSaved_Confirmation_MSG;
	
	@FindBy(xpath = "//button/span[text()='No']")
	public WebElement RawItemInformation_ConfirmationPopUp_No_BT;
	
	@FindBy(xpath = "//button/span[text()='Yes']")
	public WebElement RawItemInformation_ConfirmationPopUp_Yes_BT;
	
	@FindBy(xpath = "//div/span[text()='Yield Range']")
	public WebElement RawItemInformation_YieldRange_Lebel;
	
	@FindBy(xpath = "//div/span[text()='Yield Range']/../following-sibling::div[1]/span")
	public WebElement RawItemInformation_YieldRange_Value;
	
	@FindBy(xpath = "//div/span[text()='Calculated Yield']")
	public WebElement RawItemInformation_CalculatedYield_Lebel;
	
	@FindBy(xpath = "//div/span[text()='Calculated Yield']/../following-sibling::div[1]/span/span[1]")
	public WebElement RawItemInformation_CalculatedYield_Value;
	
	@FindBy(xpath = "//div/span[text()='Calculated Yield']/../following-sibling::div[1]/span/span[2]")
	public WebElement RawItemInformation_CalculatedYieldDate_Value;
	
	@FindBy(xpath = "//div[@id='raw_item_detail_table_wrapper']")
	public WebElement RawItemActivity_Table_Wrapper;
	
	@FindBy(xpath = "//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'POS Sales')]")
	public List<WebElement> RawItemActivity_POSSales_List;
	
	@FindBy(xpath = "//table[@id='raw_item_info_table']/tbody/tr/td[5]")
	public WebElement RawItemInformation_UOM_Value;
	
	@FindBy(xpath = "//table[@id='raw_item_info_table']/tbody/tr/td[6]")
	public WebElement RawItemInformation_InnerPack_Value;
	
	@FindBy(xpath = "//table[@id='raw_item_info_table']/tbody/tr/td[7]")
	public WebElement RawItemInformation_Case_Value;
	
	@FindBy(xpath = "//eb-button[@id='raw_item_info_modal_cancel_btn']/button")
	public WebElement RawItemInformation_Cancel_BT;
	
	@FindBy(xpath = "//span[text()='Current Usage/$1000']")
	public WebElement RawItemInformation_CurrentUsage_Lebel;
	
	@FindBy(xpath = "//div/span[text()='Current Usage/$1000']/../following-sibling::div[1]")
	public WebElement RawItemInformation_CurrentUsage_Value;
	
	@FindBy(xpath = "//span[text()='Historic Usage/$1,000']")
	public WebElement RawItemInformation_HistoricUsage_Lebel;
	
	@FindBy(xpath = "//table[@id='upt_hist_table']/tbody/tr/td[2]")
	public List<WebElement> RawItemInformation_HistoricUsageTable_Month_List;
	
	@FindBy(xpath = "//table[@id='upt_hist_table']/tbody/tr/td[3]")
	public List<WebElement> RawItemInformation_HistoricUsageTable_Usage_List;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'submit these changes?')]")
	public WebElement RawItemInformation_SubmitChanges_ConfirmationMessage;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='WRIN']")
	public WebElement RawItemInformationPopUp__WRINHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='Description']")
	public WebElement RawItemInformationPopUp_DescriptionHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='Category']")
	public WebElement RawItemInformationPopUp__CategoryHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='Zone']")
	public WebElement RawItemInformationPopUp__ZoneHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='UOM']")
	public WebElement RawItemInformationPopUp__UOMHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='Inner Pack']")
	public WebElement RawItemInformationPopUp__InnerPackHeader;
	
	@FindBy(xpath = "//table [@id='raw_item_info_table']/thead/tr/th[text()='Case']")
	public WebElement RawItemInformationPopUp__CaseHeader;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'All entered information will be lost.')]/following-sibling::p[contains(text(),'Are you sure you want to cancel?')]")
	public WebElement RawItemInformation_CancelChanges_Warning_MSG;
	
	 @FindBy(xpath = "//select[@id='select_list_type']/../../preceding-sibling::div/span[text()='Frequency']")
	 public WebElement RawItemInformation_popUp_Frequency_Lebel;
	
	// This method will take WRIN Id as argument and search the the WRIN Id in Raw Item Activity Page
	public RawItemActivityPage searchAndSelectWRINID(String samplewRINID)
			throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.enterValueInElement(Search_TB, "Search_TB", samplewRINID);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size=driver.findElements(By.xpath("//strong[text()='" + samplewRINID + "']")).size();
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//strong[text()='" + samplewRINID + "'])["+size+"]")), "WRIN ID "+samplewRINID);
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}

	// This method will select start date from calendar
	public RawItemActivityPage selectStartDate(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.clickOnElement(StartDate_TB,"StartDate_TB");
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td[@data-month='"+ month + "' and @data-date='" + day + "']/div")),month+"/"+day);
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}

	// This method will select end date from calendar
	public RawItemActivityPage selectEndDate(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.clickOnElement(EndDate_TB,"EndDate_TB");
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td[@data-month='"+ month + "' and @data-date='" + day + "']/div")),month+"/"+day);
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}
	
	public boolean verifyStartDateIsDisabled(String startDate) throws InterruptedException{
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		System.out.println("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']");
		System.out.println(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class"));
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		System.out.println("dateEnabled"+dateEnabled);
		return dateEnabled;
	}
	
	public boolean verifyEndDateIsDisabled(String endDate) throws InterruptedException{
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		return dateEnabled;
	}
	
	public void clickOnDateGroup(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		String formattedDate =  Base.getFormattedDate1(date);
		WebElement dateGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'date" + formattedDate + "_group')]")));
		GenericMethods.clickOnElement(dateGroup,date);
		Thread.sleep(1000);
	}
	
	public boolean verifySelectedDateIsExpanded(String date){
		String formattedDate =  Base.getFormattedDate1(date);
		boolean recordIsExpanded =  !driver.findElement(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]")).getAttribute("class").contains("hidden");
		return recordIsExpanded;
	}
	
	public boolean verifySelectedDateIsCollapsed(String date){
		String formattedDate =  Base.getFormattedDate1(date);
		boolean recordIsCollapsed =  driver.findElement(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]")).getAttribute("class").contains("hidden");
		return recordIsCollapsed;
	}
	
	public int getNoumberOfPromoActivities(String date){
		return getNumberOfActivities(date,"Raw Promo");
	}
	public int getNumberOfWasteActivities(String date){
		return getNumberOfActivities(date,"Raw Waste");
	}
	
	public int getNumberOfCompletedWasteActivities(String date){
		return getNumberOfActivities(date,"Completed Waste");
	}
	
	public int getNoumberOfOfficeTransferActivities(String date){
		return getNumberOfActivities(date,"Office Transfer");
	}
	
	public int getNoumberOfTransferOutActivities(String date){
		return getNumberOfActivities(date,"Transfer Out");
	}
	
	public int getNoumberOfTransferInActivities(String date){
		return getNumberOfActivities(date,"Transfer In");
	}
	
	public int getNumberOfActivities(String date, String activityType){
		String dateformat1 = Base.getFormattedDate1(date);
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[contains(text(),'"+activityType+"')]");
		return driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[contains(text(),'"+activityType+"')]")).size();
	}
	
	public boolean verifyWrinItemDisplayed(String wrinId){
		return Base.isElementDisplayed(By.xpath("//div[@id='raw_item_detail']/div/div/span[contains(.,'"+wrinId+"')]"));
	}
	
	public boolean verifyWrinItemDisplayedInRawItemInformationPopUp(String wrinId){
		return Base.isElementDisplayed(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[contains(.,'"+wrinId+"')]"));
	}
	
	public boolean verifyRawItemActivityDisplayedForADate(String date){
		String dateformat1 = Base.getFormattedDate1(date);
		return driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]")).size()>0;
	}
	
	public String getSelectedOptionFromDropDown(Select dropdown){
		List<WebElement>options = dropdown.getOptions();
		for (WebElement option : options){
			if(option.isSelected()){
				System.out.println("option is "+option.getText());
				return option.getText();
			}
		}
		return "";
	}
	
	public boolean verifyInventoryActivityDisplayed(String time,String date){
		boolean result = Base.isElementDisplayed(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span/strong[contains(text(),'INVENTORY')]/../../preceding-sibling::td/span/strong[contains(text(),'"+time+"')]"));
		result = result & driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span/strong[contains(text(),'INVENTORY')]/../../preceding-sibling::td/span/strong[contains(text(),'"+time+"')]")).getText().contains(date);
		return result;
	}
	
	public boolean verifyWasteActivityDisplayed(String amount,String date){
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td/span[contains(text(),'"+amount+"')]");
		boolean result = Base.isElementDisplayed(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td/span[contains(text(),'"+amount+"')]"));
		System.out.println("result "+result);
		System.out.println("text is "+driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td/span[contains(text(),'"+amount+"')]/../preceding-sibling::td[2]/span")).getText());
		result = result & driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td/span[contains(text(),'"+amount+"')]/../preceding-sibling::td[2]/span")).getText().contains(date);
		System.out.println("Result "+result);
		return result;
	}
	
	public boolean verifyTransferActivityDisplayed(String amount,String date){
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span[contains(.,'"+date+"')]/../following-sibling::td[1]/span[contains(text(),'Transfer Out')]/../following-sibling::td[1]/span[contains(.,'"+amount+"')]");
		boolean result = Base.isElementDisplayed(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span[contains(.,'"+date+"')]/../following-sibling::td[1]/span[contains(text(),'Transfer Out')]/../following-sibling::td[1]/span[contains(.,'"+amount+"')]"));
		return result;
	}
	
	public boolean verifyInventoryOnHandCountMatchedForSelectedDate(String date, String count, String uom){
		String formattedDate = Base.getFormattedDate1(date);
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+count+"') and contains(text(),'"+uom+"')]"));
	}
	
	public boolean verifyInventoryEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[1]/span/strong[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[1]/span/strong[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyUserNameDisplayedForSubmittedInventory(String date, String count,String user){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+count+"')]/../../following-sibling::td[3]/span/strong[contains(text(),'"+user+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+count+"')]/../../following-sibling::td[3]/span/strong[contains(text(),'"+user+"')]"));
	}
	
	public boolean verifyVarianceIsCalculatedForSelectedDateGroup(String date){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println("Var "+driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"_group')]/th[4]")).getText());
		return !(driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"_group')]/th[4]")).getText().isEmpty());
	}
	
	public boolean verifyDifferenceIsCalculatedForSelectedDate(String date){
		String formattedDate = Base.getFormattedDate1(date);
		return !driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"_group')]/th[5]")).getText().isEmpty();
	}
	
	public boolean verifyMonthYearDisplayedForHistoricalUsage(){
		Calendar cal = Calendar.getInstance();
	    int year = cal.get(cal.YEAR);
	    int month = cal.get(cal.MONTH);
	    boolean result = true;
	    for(WebElement item : RawItemInformation_HistoricUsageTable_Month_List){
	    	if(month == 0){
	    		month = 12;
	    		year--;
	    	}
	    	String monthName = Base.getMonthName(month);
	    	String temp = monthName + " "+year;
	    	System.out.println("temp "+temp);
	    	result = result & item.getText().equals(temp);
	    	System.out.println("result "+result);

	    	
	    	month--;
	    }
		return result;
	}
	
	public boolean verifyUsageDisplayedForHistoricalMonth(){
	    boolean result = true;
	    for(WebElement item : RawItemInformation_HistoricUsageTable_Usage_List){
	    	result = result & !item.getText().isEmpty();
	    }
		return result;
	}
	
	public String getWasteEventCount(String time){
		return driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(text(),'Raw Waste')]/../preceding-sibling::td/span[contains(text(),'"+time+"')]/../following-sibling::td[2]/span")).getText();
		//result = result & driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[text()='Waste']/../preceding-sibling::td/span[contains(text(),'"+time+"')]")).getText().contains(date);
	}
	
	public RawItemActivityPage associateRawItemToVendor(String vendorName) throws InterruptedException{
		Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(RawItemInformation_Title));
		if(!RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			RawItemInformation_popUp_ManualPurchase_CB.click();
			Select select =new Select(RawItemInformation_popUp_Frequency_DD);
			select.selectByVisibleText("Monthly");
			//Select McDonalds GL Account from "McDonalds GL Account drop down"
			/*RawItemInformation_popUp_GLAccount_DD.click();
			Select select1 =new Select(RawItemInformation_popUp_GLAccount_DD);
			select1.selectByIndex(1);*/
			RawItemInformation_popUp_CasePrice_TB.click();
			RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
			Thread.sleep(3000);
			RawItemInformation_popUp_CasePrice_TB.sendKeys("10");
		}
		RawItemInformation_popUp_GLAccount_DD.click();
		Select select1 =new Select(RawItemInformation_popUp_GLAccount_DD);
		select1.selectByIndex(1);
		RawItemInformation_popUp_PrimaryVendor_DD.click();
		Select vendorDD = new Select(RawItemInformation_popUp_PrimaryVendor_DD);
		vendorDD.selectByVisibleText(vendorName);
		Thread.sleep(2000);
		RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(RawItemInformation_ConfirmationPopUp_Yes_BT));
		Thread.sleep(2000);
		RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}
	
	public boolean verifyTransferOutEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(.,'Transfer Out')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Transfer Out')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyTransferInEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(.,'Transfer In')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(.,'Transfer In')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyCompletedWasteEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Completed Waste')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Completed Waste')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyRawWasteEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Raw Waste')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyRawPromoEventCountMatchedForSelectedDate(String date, String count){
		String formattedDate = Base.getFormattedDate1(date);
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Raw Promo')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span[contains(text(),'Raw Promo')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyPurchaseEventDisplayed(String date, String count, String invoiceId){
		String formattedDate = Base.getFormattedDate1(date);
		//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date09202016')]/td/span[contains(text(),'Purchase Inv #66666')]/../following-sibling::td/span[contains(text(),'15500')]
		System.out.println(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td/span[contains(text(),'Purchase Inv #"+invoiceId+"')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]");
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td/span[contains(text(),'Purchase Inv #"+invoiceId+"')]/../following-sibling::td[1]/span[contains(text(),'"+count+"')]"));
	}
	
	public boolean verifyInformationDisplayedForSelectedItem(String wrinId){
		return Base.isElementDisplayed(By.xpath("//table [@id='raw_item_info_table']/tbody/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public String getUOMValueFromBaseUonCode(String baseUomCode){
		switch (baseUomCode) {
        case "EA":
        	return "Each";
        case "TUB":
        	return "Tube";
        case "CON":
        	return "Container";
        case "PKT":
        	return "Packet";
        case "BAG":
        	return "Bag";
        default: 
        	return "";
		}
	}
	
	public String getInventoryCountForADate(String date){
		String formattedDate = Base.getFormattedDate1(date);
		String inventoryCount = "";
		if(Base.isElementDisplayed(By.xpath("(//tr[contains(@class,'"+formattedDate+"')]/td/span/strong[contains(text(),'INVENTORY')])[1]/../../following-sibling::td[2]/span/strong"))){
			inventoryCount = driver.findElement(By.xpath("(//tr[contains(@class,'"+formattedDate+"')]/td/span/strong[contains(text(),'INVENTORY')])[1]/../../following-sibling::td[2]/span/strong")).getText();
		}else{
			inventoryCount = driver.findElement(By.xpath("(//tr[contains(@class,'"+formattedDate+"')]/td/span/strong[contains(text(),'POS OPEN')])[1]/../../following-sibling::td[2]/span/strong")).getText();
		}
		return inventoryCount;
	}
	
	
	
	
}
