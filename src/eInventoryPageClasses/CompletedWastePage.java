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
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//input[@id='insert_new_comp_waste_date']")
	public WebElement SelectDate_TB;
	
	@FindBy(xpath ="//button[@id='insert_new_comp_waste_date_btn']")
	public WebElement SelectDate_BT;
	
	@FindBy(xpath ="//h2[text()='Completed Waste']")
	public WebElement CompletedWaste_Title;
	
	@FindBy(xpath ="//input[@id='comp_waste_autocomplete']")
	public WebElement CompletedWastePopUp_SearchBox_TB ;
	
	@FindBy(xpath ="//input[@id='validatedInput' and @colname='qty_wasted']")
	public WebElement CompletedWastePopUp_QuantityWasted_TB ;
	
	@FindBy(xpath ="(//button[@value='Add Item'])[3]")
	public WebElement AddItem_BT;
	
	@FindBy(xpath ="//eb-button[@id='submit_comp_waste_btn']/button")
	public WebElement Submit_BT;
	
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
	
	@FindBy(xpath = "(//button[@id='autosearchAddInputBtn'])[3]")
	public WebElement AddWrinFromSearchBox_BT;
	
	@FindBy(xpath ="//input[@id='insert_new_comp_date']")
	public WebElement SelectDateAndTime_TB;
	
	@FindBy(xpath ="(//div[@id ='eb_tp_input']/span)[3]")
	public WebElement SelectTime_TB;
	
	@FindBy(xpath ="(//i[@id ='autosearchAdditionSign'])[3]")
	public WebElement AddSearchItem_Icon;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/div[@id='eb_tp_hr_span'])[3]")
	public WebElement CompletedWaste_hourSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[@id='eb_tp_hour_up'])[3]")
	public WebElement CompletedWaste_HourUp_BT;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/div[@id='eb_tp_min_span'])[3]")
	public WebElement CompletedWaste_MinSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_up'])[3]")
	public WebElement CompletedWaste_MinUp_BT;
	
	@FindBy(xpath ="//th[text()='Menu Item #']")
	public WebElement CompletedWaste_MenuItem_Header;
	
	@FindBy(xpath ="//table[@id='comp_waste_entry_table']/thead/tr/th[text()='Description']")
	public WebElement CompletedWaste_Description_Header;
	
	@FindBy(xpath ="//th[text()='Quantity wasted']")
	public WebElement CompletedWaste_QuantityWasted_Header;
	
	@FindBy(xpath ="//table[@id='comp_waste_entry_table']/thead/tr/th[text()='Sub-total']")
	public WebElement CompletedWaste_SubTotal_Header;
	
	@FindBy(xpath ="//table[@id='comp_waste_entry_table']/thead/tr/th[text()='Remove']")
	public WebElement CompletedWaste_Remove_Header;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Menu Item Added']")
	public WebElement CompletedWasteForm_ItemAdded_Message;
	

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
	
	@FindBy(xpath = "//div[@id='dlgContent']")
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
	
	
	// To Add a Raw Waste Item
	public RawItemWastePage addARawItem(String wrin, String innerPack,
			String outerPack, String looseUnits) throws InterruptedException {
		// enterCurrentDateAndTimeInRawWasteOccurredAtField();
		// SelectDateAndTime_TB.click();
		searchMenuItemForCompletedWaste(wrin);
		try {
			InnerPack_TB.sendKeys(innerPack);
		} catch (Exception e) {
			// Do nothing
		}
		Thread.sleep(3000);
		OuterPack_TB.sendKeys(outerPack);
		LooseUnits_TB.sendKeys(looseUnits);
		CompletedWaste_Title.click();
		// AddItem_BT.click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='waste_entry_table'])[1]/tbody/tr/td[contains(.,'"+
		// wrin + "')]")));
		// Submit_BT.click();
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	
	public void searchMenuItemForCompletedWaste(String menuItemId) throws InterruptedException{
		CompletedWastePopUp_SearchBox_TB.clear();
		CompletedWastePopUp_SearchBox_TB.sendKeys(menuItemId);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size = driver.findElements(By.xpath("//strong[text()='" + menuItemId + "']")).size();
		driver.findElement(By.xpath("(//strong[text()='" + menuItemId + "'])[1]")).click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(AddWrinFromSearchBox_BT));
		//AddWrinFromSearchBox_BT.click();
	}
	
	//not completed yet functionality not working
	public void addAMenuItemOnCompletedWastePage(String menuItemId,	String quantity) throws InterruptedException {
		searchMenuItemForCompletedWaste(menuItemId);
		Thread.sleep(2000);
		/*wait.until(ExpectedConditions.visibilityOf(CompletedWasteForm_ItemAdded_Message));
		CompletedWasteForm_ItemAdded_Message.click();*/
		//wait.until(ExpectedConditions.visibilityOf(CompletedWasteForm_ItemAdded_Message)).click();
		// Enter quantity in quantity text box
		CompletedWastePopUp_QuantityWasted_TB.sendKeys(quantity);
		CompletedWaste_Title.click();
		//wait.until(ExpectedConditions.visibilityOf(AddItem_BT));
		//AddItem_BT.click();
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
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
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
	
	public void selectTimeInRawWasteForm(String time) throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!CompletedWaste_hourSpan_Value.getText().equals(hourValue)){
			System.out.println("Hour");
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[4].click();");
		}
		/*Thread.sleep(1000);
		RawWaste_hourSpan_Value.click();*/
		String minuteValue = time.split(":")[1];
		while(!CompletedWaste_MinSpan_Value.getText().equals(minuteValue)){
			System.out.println("Minute");
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[5].click();");
		}
		/*Thread.sleep(1000);
		RawWaste_MinSpan_Value.click();*/
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
