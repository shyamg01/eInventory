package eInventoryPageClasses;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

public class CompletedWastePage extends AbstractPage {

	public CompletedWastePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="(//h2[text()='Completed Waste'])[2]")
	public WebElement CompletedWaste_Title;
	
	@FindBy(xpath ="//input[@id='comp_waste_autocomplete']")
	public WebElement CompletedWastePopUp_SearchBox_TB ;
	
	@FindBy(xpath ="//input[@id='validatedInput' and @colname='qty_wasted']")
	public WebElement CompletedWastePopUp_QuantityWasted_TB ;
	
	@FindBy(xpath ="//eb-button[@id='submit_comp_waste_btn']/button")
	public WebElement Submit_BT;
	
	@FindBy(xpath ="//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'submit this completed waste?')]")
	public WebElement SubmitCompletedWaste_PopUp_Warning_Message;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement SubmitCompletedWaste_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement SubmitCompletedWaste_PopUp_NO_BT;
	
	@FindBy(xpath ="//eb-button[@id='cancel_comp_waste_btn']/button")
	public WebElement Cancel_BT;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement CompletedWasteEntryIncomplete_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement CompletedWasteEntryIncomplete_PopUp_NO_BT;
	
	@FindBy(xpath ="//input[@id='insert_new_comp_date']")
	public WebElement SelectDateAndTime_TB;
	
	@FindBy(xpath ="(//div[@id ='eb_tp_input']/span)[3]")
	public WebElement SelectTime_TB;
	
	@FindBy(xpath ="(//i[@id ='autosearchAdditionSign'])[3]")
	public WebElement AddSearchItem_Icon;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span'])[3]")
	public WebElement CompletedWaste_hourSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span'])[3]")
	public WebElement CompletedWaste_MinSpan_Value;
	
	@FindBy(xpath ="//th[text()='Menu Item #']")
	public WebElement CompletedWaste_MenuItem_Header;
	
	@FindBy(xpath ="//table[@id='comp_waste_entry_table']/thead/tr/th[text()='Description']")
	public WebElement CompletedWaste_Description_Header;
	
	@FindBy(xpath ="//th[text()='Quantity wasted']")
	public WebElement CompletedWaste_QuantityWasted_Header;
	
	@FindBy(xpath ="//table[@id='comp_waste_entry_table']/thead/tr/th[text()='Sub-total']")
	public WebElement CompletedWaste_SubTotal_Header;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Error: Cannot submit WRIN with a 0 quantity.']")
	public WebElement CompletedWasteForm_ZeroQuantityError_Message;

	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='inner_pack_count'])[1]")
	public WebElement InnerPack_TB;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Completed Waste Entry Saved']")
	public WebElement WasteEntrySaved_Confirmation_MSG;

	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='case_count'])[1]")
	public WebElement OuterPack_TB;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='loose_count'])[1]")
	public WebElement LooseUnits_TB;
	
	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Duplicate Items not Allowed')]")
	public WebElement DuplicateItem_Error_Message;
	
	@FindBy(xpath = "//div[@id='dlgContent' and contains(text(),'All entered information will be lost.  Are you sure you want to cancel?')]")
	public WebElement CancelCompletedWastePopUp_Warning_Message;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[3]")
	public WebElement CompletedWasteForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='add_new_completed_waste_modal']/div[contains(@class,'container')]")
	public WebElement CompletedWasteForm_Container;
	
	@FindBy(xpath = "//tbody[@id='comp_waste_entry_table_body']/tr")
	public List<WebElement> CompletedWasteForm_WasteItemEntry_List;
	
	@FindBy(xpath = "//eb-modal[@id='add_new_completed_waste_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement CompletedWasteForm_Close_BT;
	
	@FindBy(xpath="//div[contains(@id,'popover')]/div[@class='popover-content']")
	public WebElement InvalidQuantity_Error_Message;
	
	
	public void searchMenuItemForCompletedWaste(String menuItemId) throws InterruptedException{
		CompletedWastePopUp_SearchBox_TB.clear();
		CompletedWastePopUp_SearchBox_TB.sendKeys(menuItemId);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.xpath("(//strong[text()='" + menuItemId + "'])[1]")).click();
		Thread.sleep(2000);
	}
	
	//not completed yet functionality not working
	public void addAMenuItemOnCompletedWastePage(String menuItemId,	String quantity) throws InterruptedException {
		searchMenuItemForCompletedWaste(menuItemId);
		Thread.sleep(2000);
		// Enter quantity in quantity text box
		CompletedWastePopUp_QuantityWasted_TB.clear();
		CompletedWastePopUp_QuantityWasted_TB.sendKeys(quantity);
		CompletedWaste_Title.click();
	}
	
	public String getTotalCompletedWasteAmount(){
		List<WebElement> wasteItemSubtotalList = driver.findElements(By.xpath("//table[@id='comp_waste_entry_table']/tbody/tr/td[5]"));
		BigDecimal subtotal = new BigDecimal("0.00");
		for(WebElement wasteItem : wasteItemSubtotalList){
			String wasteItemsubtotal = wasteItem.getText();
			BigDecimal itemSubtotal = new BigDecimal(wasteItemsubtotal);
			subtotal = subtotal.add(itemSubtotal);
		}
		return String.valueOf(subtotal);
	}
	
	public CompletedWastePage selectDateForCompletedWaste(String date) throws InterruptedException{
		SelectDateAndTime_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),3);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[3]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, CompletedWastePage.class);
	
	}
	
	
	public CompletedWastePage selectDateForRawWaste(String date) throws InterruptedException{
		SelectDateAndTime_TB.click();
		Thread.sleep(5000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),3);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[3]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, CompletedWastePage.class);
	
	}
	
	public String getTimeToSet() throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue;
		String minuteValue;
		int hour = Integer.parseInt(CompletedWaste_hourSpan_Value.getText())+1;
		if (hour > 0 && hour < 10) {
			hourValue = "0" + hour;
		} else {
			hourValue = String.valueOf(hour);
		}
		int minute = Integer.parseInt(CompletedWaste_MinSpan_Value.getText())+1;
		if (minute > 0 && minute < 10) {
			minuteValue = "0" + minute;
		} else {
			minuteValue = String.valueOf(minute);
		}
		String timeToSet = hourValue+":"+minuteValue;
		System.out.println(timeToSet);
		SelectTime_TB.click();
		Thread.sleep(1000);
		return timeToSet;
	}
	
	public void selectTimeInCompletedWasteForm(String time) throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!CompletedWaste_hourSpan_Value.getText().equals(hourValue)){
			System.out.println("Hour");
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[4].click();");
		}
		String minuteValue = time.split(":")[1];
		while(!CompletedWaste_MinSpan_Value.getText().equals(minuteValue)){
			System.out.println("Minute");
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[5].click();");
		}
		CompletedWaste_Title.click();
		Thread.sleep(1000);
	}
	
	public void addQuantitiesForMultipleWrin(String wrin, String quantity) throws InterruptedException{
		driver.findElement(By.xpath("//tbody[@id='comp_waste_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='qty_wasted']")).sendKeys(quantity);
		CompletedWaste_Title.click();
		Thread.sleep(2000);
	}
	
	public void removeWrinIdFromCompletedWastePage(String wrinId) throws InterruptedException{
		driver.findElement(By.xpath("//tbody[@id='comp_waste_entry_table_body']/tr/td[contains(text(),'"
				+ wrinId+ "')]/preceding-sibling::td[contains(@class,'select-checkbox')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[3]"))).click();
		Thread.sleep(3000);
	}
	
	public boolean verifyCompletedWasteItemIsAdded(String wrinId){
		return Base.isElementDisplayed(By.xpath("//tbody[@id='comp_waste_entry_table_body']/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public void removeAllWrinIdFromCompletedWastePage() throws InterruptedException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='comp_waste_entry_table_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			removeBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[3]"))).click();
			Thread.sleep(2000);
		}
	}
	

}
