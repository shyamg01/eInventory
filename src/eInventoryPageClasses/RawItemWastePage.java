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
import org.testng.Assert;

import common.Base;

public class RawItemWastePage extends AbstractPage
{

	public RawItemWastePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[contains(.,'Add New Entry')]")
	public WebElement AddNewEntry_BT;
	
	@FindBy(xpath ="//input[@id='insert_new_waste_date']")
	public WebElement SelectDateAndTime_TB;
	
	@FindBy(xpath ="//h2[text()='Raw Waste']")
	public WebElement RawWaste_Title;
	
	@FindBy(xpath ="//h3[contains(.,'	Enter New Raw Waste')]")
	public WebElement EnterNewRawWaste_Title;
	
	@FindBy(xpath ="//div[@id='data_entry_modal' and @aria-hidden='false']")
	public WebElement AddWasteItemPopUpWindow;
	
	@FindBy(xpath ="//input[@type='search']")
	public WebElement AddWasteItemPopUpWindow_Search_TB;
	
	@FindBy(xpath ="//label[text()='Outer Pack:']")
	public WebElement AddWasteItemPopUpWindow_OuterPack_Label;
	
	@FindBy(xpath ="//label[text()='Inner Pack:']")
	public WebElement AddWasteItemPopUpWindow_InnerPack_Label;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='case_count'])[1]")
	public WebElement OuterPack_TB;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='inner_pack_count'])[1]")
	public WebElement InnerPack_TB;
	
	@FindBy(xpath ="//label[text()='Loose Units:']")
	public WebElement AddWasteItemPopUpWindow_LooseUnits_Label;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='loose_count'])[1]")
	public WebElement LooseUnits_TB;
	
	@FindBy(xpath ="//label[text()='Total Units:']")
	public WebElement AddWasteItemPopUpWindow_TotalUnits_Label;
	
	@FindBy(xpath ="//label[text()='Cost:']")
	public WebElement AddWasteItemPopUpWindow_Cost_Label;
	
	@FindBy(xpath ="(//button[@id='htmlButton' and @value='Add Item' and text()='Add Item'])[1]")
	public WebElement AddItem_BT;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Raw Item Added']")
	public WebElement RawWasteForm_ItemAdded_Message;
	
	@FindBy(xpath ="//button[contains(.,'Cancel')]")
	public WebElement AddWasteItemPopUpWindow_Cancel_BT;
	
	@FindBy(xpath ="//input[@id='raw_waste_entry_autocomplete']")
	public WebElement RawItemWasted_TB;

	@FindBy(xpath ="//eb-button[@id='submit_raw_waste_btn']/button")
	public WebElement Submit_BT;
	

	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement RawWasteEntryConfirmation_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement RawWasteEntryConfirmation_PopUp_NO_BT;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement SubmitRawWaste_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement SubmitRawWaste_PopUp_NO_BT;
	
	@FindBy(xpath ="//input[@id='submit_raw_waste_btn']")
	public WebElement SubmitEntry_BT;
	
	@FindBy(xpath ="//eb-button[@id='cancel_raw_waste_btn']/button")
	public WebElement Cancel_BT;
	
	@FindBy(xpath ="//input[@id='cancel_raw_waste_btn']")
	public WebElement CancelEntry_BT;
	
	/*@FindBy(xpath ="//div[@class='modal-content' and contains(.,'All entered information will be lost.  Are you sure you want to cancel?')]")
	public WebElement RawWasteEntryIncomplete_PopUp_Window;*/
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement RawWasteEntryIncomplete_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement RawWasteEntryIncomplete_PopUp_NO_BT;
	
	@FindBy(xpath="//div[contains(@id,'popover')]/div[@class='popover-content']")
	public WebElement LooseUnitsInvalidValue_Error_Message;
	
	@FindBy(id = "back-to-top")
	public WebElement BackToTop_BT;
	
	@FindBy(id = "autosearchAddInputBtn")
	public WebElement AddWrinFromSearchBox_BT;
	
	@FindBy(xpath ="(//div[@id ='eb_tp_input']/span)[1]")
	public WebElement SelectTime_TB;
	
	@FindBy(xpath ="(//i[@id ='autosearchAdditionSign'])[1]")
	public WebElement AddSearchItem_Icon;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/div[@id='eb_tp_hr_span'])[1]")
	public WebElement RawWaste_hourSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[@id='eb_tp_hour_up'])[1]")
	public WebElement RawWaste_HourUp_BT;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/div[@id='eb_tp_min_span'])[1]")
	public WebElement RawWaste_MinSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_up'])[1]")
	public WebElement RawWaste_MinUp_BT;
	
	@FindBy(xpath="//div[@class='toast-message' and contains(.,'Duplicate Items not Allowed')]")
	public WebElement DuplicateItem_Error_Message;
	
	@FindBy(xpath = "//div[@id='dlgContent']")
	public WebElement CancelRawWastePopUp_Confirmation_Message;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement RawWasteForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='add_new_raw_waste_modal']/div[contains(@class,'container')]")
	public WebElement RawWasteForm_Container;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='WRIN']")
	public WebElement RawWaste_Wrin_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Description']")
	public WebElement RawWaste_Description_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Outer Pack']")
	public WebElement RawWaste_OuterPack_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Inner Pack']")
	public WebElement RawWaste_InnerPack_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Loose Unit']")
	public WebElement RawWaste_LooseUnit_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Total Units']")
	public WebElement RawWaste_TotalUnits_Header;
	
	@FindBy(xpath ="//table[@id='raw_waste_entry_table']/thead/tr/th[text()='Sub-total']")
	public WebElement RawWaste_Subtotal_Header;
	
	/*@FindBy(xpath ="//th[text()='Remove']")
	public WebElement RawWaste_Remove_Header;*/
	
	@FindBy(xpath = "//tbody[@id='waste_entry_table_body']/tr")
	public List<WebElement> RawWasteForm_WasteItemEntry_List;
	
	@FindBy(xpath = "//eb-modal[@id='add_new_raw_waste_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement RawWasteForm_Close_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Raw Waste Entry Saved']")
	public WebElement WasteEntrySaved_Confirmation_MSG;

	
	public boolean isAddWasteItemPopUpWindowLoaded()
	{
		//Verify WRIN ,Description and Add columns are displaying
		//Verify Search Text box is displaying
		return 		driver.findElement(By.xpath("//div[@class='dataTables_scrollHead']//table[@class='display compact dataTable no-footer']/thead/tr/th[1]")).getText().trim().equalsIgnoreCase("WRIN")
				&  	driver.findElement(By.xpath("//div[@class='dataTables_scrollHead']//table[@class='display compact dataTable no-footer']/thead/tr/th[2]")).getText().trim().equalsIgnoreCase("Description")
				&	driver.findElement(By.xpath("//div[@class='dataTables_scrollHead']//table[@class='display compact dataTable no-footer']/thead/tr/th[3]")).getText().trim().equalsIgnoreCase("Add")
				& 	AddWasteItemPopUpWindow_Search_TB.isDisplayed();
	}
	
	//To enter current date and time in the field
	public RawItemWastePage enterCurrentDateAndTimeInRawWasteOccurredAtField() throws InterruptedException
	{
		//Click on Select Date and Time text box
		String todayDate=Base.returnTodayDate();
		int date = Base.getDayFromDate(todayDate);
		int month = Base.getMonthFromDate(todayDate);
		SelectDateAndTime_TB.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar']/table/tbody/tr/td[@data-month='"+month+"']/div[text()='"+date+"'])[3]")).click();
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	//To Search and select a raw Item wasted
	public RawItemWastePage searchAndSelectRawItemWasted(String wrin) throws InterruptedException
	{
		RawItemWasted_TB.sendKeys(wrin);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size=driver.findElements(By.xpath("//strong[text()='"+wrin+"']")).size();
		driver.findElement(By.xpath("(//strong[text()='"+wrin+"'])[1]")).click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(AddWrinFromSearchBox_BT));
		//AddWrinFromSearchBox_BT.click();
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	
	// To Add a Raw Waste Item
	public RawItemWastePage addARawItem(String wrin, String innerPack,
			String outerPack, String looseUnits) throws InterruptedException {
		//enterCurrentDateAndTimeInRawWasteOccurredAtField();
		// SelectDateAndTime_TB.click();
		searchAndSelectRawItemWasted(wrin);
		try {
			InnerPack_TB.sendKeys(innerPack);
		} catch (Exception e) {
			// Do nothing
		}
		Thread.sleep(3000);
		OuterPack_TB.sendKeys(outerPack);
		LooseUnits_TB.sendKeys(looseUnits);
		RawWaste_Title.click();
		//AddItem_BT.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@id='waste_entry_table'])[1]/tbody/tr/td[contains(.,'"+ wrin + "')]")));
		// Submit_BT.click();
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	
	public RawItemWastePage addASecondRawItem(String wrin, String innerPack,
			String outerPack, String looseUnits) throws InterruptedException {
		searchAndSelectRawItemWasted(wrin);
		try {
			InnerPack_TB.sendKeys(innerPack);
		} catch (Exception e) {
			// Do nothing
		}
		Thread.sleep(3000);
		OuterPack_TB.sendKeys(outerPack);
		LooseUnits_TB.sendKeys(looseUnits);
		AddItem_BT.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='waste_entry_table']//td[1][contains(.,'"+ wrin + "')]")));
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	
	//Add a Waste raw item with given WRIN ID
	public RawItemWastePage addAWasteRawItem(String wrinID) {
		wait.until(ExpectedConditions.visibilityOf(AddWasteItemPopUpWindow));
		int size = driver.findElements(By.xpath("//table[@id='raw_items_tbl']/tbody/tr")).size();
		for (int i = 1; i <= size; i++) {
			if (driver.findElement(By.xpath("//table[@id='raw_items_tbl']/tbody/tr["+ i + "]/td[1]")).getText().trim().equalsIgnoreCase(wrinID)) {
				driver.findElement(By.xpath("//table[@id='raw_items_tbl']/tbody/tr[" + i+ "]/td[3]/button")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='item_wrin' and text()='" + wrinID+ "']")));
				// Verify the OuterPack label and text box
				Assert.assertTrue(AddWasteItemPopUpWindow_OuterPack_Label.isDisplayed()& OuterPack_TB.isDisplayed(),"OuterPack label and text box should display");
				// Verify the InnerPack label and text box
				Assert.assertTrue(AddWasteItemPopUpWindow_InnerPack_Label.isDisplayed() & InnerPack_TB.isDisplayed(),"InnerPack label and text box should display");
				// Verify the Loose Units label and text box
				Assert.assertTrue(AddWasteItemPopUpWindow_LooseUnits_Label.isDisplayed() & LooseUnits_TB.isDisplayed(),"Loose unit label and text box should display");
				// verify the Total Units label
				Assert.assertTrue( AddWasteItemPopUpWindow_TotalUnits_Label.isDisplayed(),"Total unit label should display successfully");
				// Verify the Cost Label
				Assert.assertTrue(AddWasteItemPopUpWindow_Cost_Label.isDisplayed(),"Cost label should display successfully");
			}
		}
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}

	// Search a Raw Item
	public boolean searchARawItem(String itemName) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(AddWasteItemPopUpWindow));
		AddWasteItemPopUpWindow_Search_TB.clear();
		AddWasteItemPopUpWindow_Search_TB.sendKeys(itemName);
		Thread.sleep(2000);
		int size = driver.findElements(By.xpath("//table[@id='raw_items_tbl']/tbody/tr")).size();
		if (size == 1) {
			if (driver.findElement(By.xpath("//table[@id='raw_items_tbl']/tbody/tr[1]/td[2]")).getText().trim().equalsIgnoreCase(itemName)) {
				return true;
			}
		}
		return false;
	}

	/*This method will return total waste amount added*/
	public String getTotalWasteAmunt(){
		List<WebElement> wasteItemSubtotalList = driver.findElements(By.xpath("//table[@id='raw_waste_entry_table']/tbody/tr/td[8]"));
		BigDecimal subtotal = new BigDecimal("0.00");
		for(WebElement wasteItem : wasteItemSubtotalList){
			String wasteItemsubtotal = wasteItem.getText();
			BigDecimal itemSubtotal = new BigDecimal(wasteItemsubtotal);
			subtotal = subtotal.add(itemSubtotal);
		}
		return String.valueOf(subtotal);
	}
	
	public boolean verifyWasteItemIsAdded(String wrinId){
		return Base.isElementDisplayed(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public RawItemWastePage selectDateForRawWaste(String date) throws InterruptedException{
		SelectDateAndTime_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, RawItemWastePage.class);
	
	}
	
	/*public RawItemWastePage selectMonthFromDatePicker(String monthName,int calIndex){
		String selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[1]/span")).getText();
		while (!selectedMonth.equals(monthName)) {
			driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/button[@class='xdsoft_prev']")).click();
			selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[contains(@class,'xdsoft_month')]/span")).getText();
			System.out.println("monthName found "+selectedMonth);
		}
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}*/
	
	public String getTimeToSet() throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue;
		String minuteValue;
		int hour = Integer.parseInt(RawWaste_hourSpan_Value.getText())+1;
		if (hour > 0 && hour < 10) {
			hourValue = "0" + hour;
		} else {
			hourValue = String.valueOf(hour);
		}
		int minute = Integer.parseInt(RawWaste_MinSpan_Value.getText())+1;
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
		while(!RawWaste_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_hour_up').click();");
		}
		/*Thread.sleep(1000);
		RawWaste_hourSpan_Value.click();*/
		String minuteValue = time.split(":")[1];
		while(!RawWaste_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_min_up').click();");
		}
		/*Thread.sleep(1000);
		RawWaste_MinSpan_Value.click();*/
		RawWaste_Title.click();
		Thread.sleep(1000);
	}
	
	public void addQuantitiesForMultipleWrin(String wrin, String innerPack,
			String outerPack, String looseUnits){
		driver.findElement(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='case_count']")).sendKeys(outerPack);
		try{
			driver.findElement(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[3]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='inner_pack_count']")).sendKeys(innerPack);
		}catch(Exception e){
			//Do nothing
		}
		driver.findElement(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[4]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='loose_count']")).sendKeys(looseUnits);
		RawWaste_Title.click();
	}
	
	public void removeWrinIdFromRawWastePage(String wrinId) throws InterruptedException{
		driver.findElement(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(text(),'"+wrinId+"')]/preceding-sibling::td[contains(@class,'select-checkbox')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[1]"))).click();
		Thread.sleep(3000);
	}
	
	public boolean verifyBackTimeIsSelected(String time) throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!RawWaste_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_hour_down').click();");
		}
		String minuteValue = time.split(":")[1];
		while(!RawWaste_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_min_down').click();");
		}
		RawWaste_Title.click();
		Thread.sleep(1000);
		System.out.println("Time "+SelectTime_TB.getText());
		return SelectTime_TB.getText().equals(time) ;
	}
	
	public void removeAllWrinIdFromRawWastePage() throws InterruptedException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='waste_entry_table_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			removeBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[1]"))).click();
			Thread.sleep(3000);
		}
	}
	
	
}
