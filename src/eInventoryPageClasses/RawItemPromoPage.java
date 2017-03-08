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

public class RawItemPromoPage extends AbstractPage
{
	public RawItemPromoPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//h2[text()='Raw Promo']")
	public WebElement RawPromo_Title;
	
	@FindBy(xpath ="//input[@id='insert_new_promo_date']")
	public WebElement SelectDateAndTime_TB;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='case_count'])[1]")
	public WebElement OuterPack_TB;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='inner_pack_count'])[1]")
	public WebElement InnerPack_TB;
	
	@FindBy(xpath ="(//input[@id='validatedInput' and @colname='loose_count'])[1]")
	public WebElement LooseUnits_TB;
	
	@FindBy(xpath ="//input[@id='raw_promo_entry_autocomplete']")
	public WebElement RawItemWasted_TB;
	
	@FindBy(xpath ="//eb-button[@id='submit_raw_promo_btn']/button")
	public WebElement Submit_BT;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement SubmitRawPromo_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement SubmitRawPromo_PopUp_NO_BT;
	
	@FindBy(xpath ="//eb-button[@id='cancel_raw_promo_btn']/button")
	public WebElement Cancel_BT;
	
	@FindBy(xpath ="//div[@id='dlgContent' and contains(.,'All entered information will be lost.  Are you sure you want to cancel?')]")
	public WebElement RawPromoEntryIncomplete_PopUp_Window;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement RawPromoEntryIncomplete_PopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement RawPromoEntryIncomplete_PopUp_NO_BT;
	
	@FindBy(xpath ="(//div[@id ='eb_tp_input'])[2]")
	public WebElement SelectTime_TB;
	
	@FindBy(xpath ="(//i[@id ='autosearchAdditionSign'])[2]")
	public WebElement AddSearchItem_Icon;
	
	@FindBy(xpath ="(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span'])[2]")
	public WebElement RawPromo_hourSpan_Value;
	
	@FindBy(xpath ="(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span'])[2]")
	public WebElement RawPromo_MinSpan_Value;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Raw Promo Entry Saved']")
	public WebElement PromoEntrySaved_Confirmation_MSG;
	
	@FindBy(xpath="//div[contains(@id,'popover')]/div[@class='popover-content']")
	public WebElement LooseUnitsInvalidValue_Error_Message;
	
	@FindBy(xpath =".//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'submit this raw promo?')]")
	public WebElement SubmitRawPromo_ConfirmationPopUp_Msg;
	
	@FindBy(xpath = "//table[@id='raw_promo_entry_table']/tbody/tr/td[7]")
	public WebElement RawPromoForm_TotalUnitsValue;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Error: Cannot submit WRIN with a 0 quantity.']")
	public WebElement RawPromoForm_ZeroQuantityError_Message;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[2]")
	public WebElement RawPromoForm_SliderToggle_BT;
	
	
	// To Search and select a raw Item Promo
	public RawItemPromoPage searchAndSelectRawPromoItem(String wrin)throws InterruptedException {
		RawItemWasted_TB.clear();
		RawItemWasted_TB.sendKeys(wrin);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size = driver.findElements(By.xpath("//strong[text()='" + wrin + "']")).size();
		driver.findElement(By.xpath("(//strong[text()='" + wrin + "'])[" + size + "]")).click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(AddWrinFromSearchBox_BT));
		//AddWrinFromSearchBox_BT.click();
		return PageFactory.initElements(driver, RawItemPromoPage.class);
	}
	
	// To Add a Raw Promo Item
	public RawItemWastePage addARawPromoItem(String wrin, String innerPack,
			String outerPack, String looseUnits) throws InterruptedException {
		searchAndSelectRawPromoItem(wrin);
		try {
			InnerPack_TB.sendKeys(innerPack);
		} catch (Exception e) {
			// Do Nothing
		}
		Thread.sleep(2000);
		OuterPack_TB.sendKeys(outerPack);
		LooseUnits_TB.sendKeys(looseUnits);
		RawPromo_Title.click();
		//AddItem_BT.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='waste_entry_table']//td[1][contains(.,'"+ wrin + "')]")));
		return PageFactory.initElements(driver, RawItemWastePage.class);
	}
	
	public String getTotalPromoAmount(){
		List<WebElement> promoItemSubtotalList = driver.findElements(By.xpath("//table[@id='raw_promo_entry_table']/tbody/tr/td[8]"));
		BigDecimal subtotal = new BigDecimal("0.00");
		for(WebElement promoItem : promoItemSubtotalList){
			String promoItemsubtotal = promoItem.getText();//.substring(1);
			BigDecimal itemSubtotal = new BigDecimal(promoItemsubtotal);
			subtotal = subtotal.add(itemSubtotal);
		}
		return String.valueOf(subtotal);
	}
	
	public boolean verifyWasteItemIsAdded(String wrinId){
		return Base.isElementDisplayed(By.xpath("//table[@id='raw_promo_entry_table']/tbody/tr/td[contains(text(),'"+wrinId+"')]"));
	}
	
	public RawItemPromoPage selectDateForRawPromo(String date) throws InterruptedException{
		SelectDateAndTime_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		System.out.println("month"+month+"day"+day);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, RawItemPromoPage.class);
	}
	
	public void selectTimeInRawPromoForm(String time) throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!RawPromo_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[2].click();");
		}
		/*Thread.sleep(1000);
		RawWaste_hourSpan_Value.click();*/
		String minuteValue = time.split(":")[1];
		while(!RawPromo_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[3].click();");
		}
		/*Thread.sleep(1000);
		RawWaste_MinSpan_Value.click();*/
		RawPromo_Title.click();
		Thread.sleep(1000);
	}
	
	public String getTimeToSet() throws InterruptedException{
		SelectTime_TB.click();
		Thread.sleep(1000);
		String hourValue;
		String minuteValue;
		int hour = Integer.parseInt(RawPromo_hourSpan_Value.getText())+1;
		if (hour > 0 && hour < 10) {
			hourValue = "0" + hour;
		} else {
			hourValue = String.valueOf(hour);
		}
		int minute = Integer.parseInt(RawPromo_MinSpan_Value.getText())+1;
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
	
	public void addQuantitiesForMultipleWrin(String wrin, String innerPack,String outerPack, String looseUnits){
		driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='case_count']")).clear();
		driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='case_count']")).sendKeys(outerPack);
		try{
			driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[3]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='inner_pack_count']")).clear();
			driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[3]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='inner_pack_count']")).sendKeys(innerPack);
		}catch(Exception e){
			//Do nothing
		}
		driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[4]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='loose_count']")).clear();
		driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrin+"')]/following-sibling::td[4]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='loose_count']")).sendKeys(looseUnits);
		RawPromo_Title.click();
	}
	
	public void removeWrinIdFromRawPromoPage(String wrinId) throws InterruptedException{
		driver.findElement(By.xpath("//tbody[@class='promo_entry_table_body']/tr/td[contains(text(),'"+wrinId+"')]/preceding-sibling::td[contains(@class,'select-checkbox')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[2]"))).click();
		Thread.sleep(3000);
	}
	
	public void removeAllWrinIdFromRawPromoPage() throws InterruptedException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='promo_entry_table_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			removeBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@id='utility-toolbar']/li[@id='deleteId'])[2]"))).click();
			Thread.sleep(3000);
		}
	}

}
