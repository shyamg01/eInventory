package eInventoryPageClasses;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.Base;
import common.GenericMethods;


public class TransferLandingPage extends AbstractPage{

	public TransferLandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//h1[text()='Transfers']")
	public WebElement TransferLandingPage_Label;

	@FindBy(xpath ="//eb-button[@class='insertNewTransferBtn']/button")
	public WebElement CreateNewTransfers_BT;

	@FindBy(xpath ="//input[@id='autosearchInput']")
	public WebElement AddTransferItemsPopup_RawItemsSearchBox_TB;
	
	@FindBy(xpath ="//table[@id='transfercounts']/tbody/tr/td/eb-button[@value='View']/button")
	public List <WebElement> TransferLandingPage_Records_List;
	
	@FindBy(xpath ="//button[@value='Cancel']")
	public WebElement AddTransferItemsPopup_Cancel_BT;
	
	@FindBy(xpath ="//button[@id='htmlButton']/span[text()='Yes']")
	public WebElement AddTransferItemsPopup_Warning_Message_Yes_BT;
	
	@FindBy(xpath ="//button[@value='Submit']")
	public WebElement AddTransferItemsPopup_Submit_BT;
	
	@FindBy(xpath ="//div[@id='eb_tp_input']")
	public WebElement InsertNewTransfersPopup_Time_Value;
	
	@FindBy(xpath ="//div[@id='total_amount_div']/strong")
	public WebElement AddTransferPopup_TotalAmount_Value;
	
	@FindBy(xpath ="//input[@id='insert_new_transfer_date']")
	public WebElement AddTransferPopup_Date_TB;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement CanceTransferPopup_Yes_BT;
	
	@FindBy(xpath ="//button[@id='htmlButton']/span[text()='No']")
	public WebElement CanceTransferPopup_No_BT;
	
	@FindBy(xpath ="//tbody[@id='transfer_add_body']/tr/td[7]")
	public WebElement AddTransferItemsPopup_TotalUnits_Value;
	
	@FindBy(id="transfer_type_menu")
	public WebElement TransferType_DD;
	
	@FindBy(id="location_menu")
	public WebElement Location_DD;
	
	@FindBy(xpath="//input[@colname='inner_pack_count']")
	public List <WebElement> AddTransferItemsPopup_InnerPackCount_TB;
	
	@FindBy(xpath="//input[@colname='case_count']")
	public List <WebElement> AddTransferItemsPopup_CaseCount_TB;
	
	@FindBy(xpath="//input[@colname='loose_count']")
	public List <WebElement> AddTransferItemsPopup_LooseCount_TB;	
	
	@FindBy(xpath="//button/span[text()='Yes']")
	public WebElement SubmitTransferConfirmationPopUp_Yes_BT;
	
	@FindBy(xpath="//button/span[text()='No']")
	public WebElement SubmitTransferConfirmationPopUp_No_BT;
	
	@FindBy(xpath ="//div[@id='eb-modal-print']")
	public WebElement AddTransferItemsPopup_Print_BT;
	
	@FindBy(xpath ="//div[@id='grand_amount']/span[2]/span")
	public WebElement ViewTransferItemsPopup_GrandTotal_Value;
	
	@FindBy(xpath ="//div[@id='transfer_time']/div[2]/a[contains(@class,'icon-print')]")
	public WebElement ViewTransferItemsPopup_Print_BT;
	
	@FindBy(xpath ="//h2[text()='Transfer']")
	public WebElement Transfer_Title;

	@FindBy(xpath ="//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span']")
	public WebElement AddNewTransferForm_hourSpan_Value;
	
	@FindBy(xpath ="//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span']")
	public WebElement AddNewTransferForm_MinSpan_Value;
	
	@FindBy(xpath ="//input[@id='history_start_date']")
	public WebElement StartDate_TB;
	
	@FindBy(xpath ="//input[@id='history_end_date']")
	public WebElement EndDate_TB;
	
	@FindBy(xpath ="//eb-button[@value='Show Results']/button")
	public WebElement ShowResults_BT;
	
	@FindBy(xpath = "//div[@id='dlgContent']/p[contains(text(),'Are you sure you want to')]/following-sibling::p[contains(text(),'	submit this transfer?')]")
	public WebElement AddNewTransfer_Confirmation_Message;
	
	@FindBy(xpath="//div[@class='toast-message' and contains(text(),'Transfer entry saved')]")
	public WebElement TransferAdded_Messag;
	
	@FindBy(xpath ="(//div[contains(@class,'datepickerWrapper')])[1]")
	public WebElement StartDatePicker_Cal_Icon;
	
	@FindBy(xpath ="(//div[contains(@class,'datepickerWrapper')])[2]")
	public WebElement EndDatePicker_Cal_Icon;
	
	@FindBy(xpath="//th[text()='Transfer Time']")
	public WebElement TransferTime_Header;
	
	@FindBy(xpath="//th[text()='Type']")
	public WebElement TransferType_Header;
	
	@FindBy(xpath="//th[text()='Location']")
	public WebElement TransferLocation_Header;
	
	@FindBy(xpath="//th[text()='Amount']")
	public WebElement TransferAmount_Header;
	
	@FindBy(xpath ="//table[@id='transfer_modal_tbl']/tbody/tr")
	public List <WebElement> ViewTransferForm_Records_List;
	
	@FindBy(xpath="(//th[text()='WRIN'])[2]")
	public WebElement ViewTransferForm_Wrin_Header;
	
	@FindBy(xpath="(//th[text()='Description'])[2]")
	public WebElement ViewTransferForm_Description_Header;
	
	@FindBy(xpath="(//table[@id='transfer_modal_tbl']/thead/tr/th[contains(.,'Case') and contains(.,'Count')])[1]")
	public WebElement ViewTransferForm_CaseCount_Header;;
	
	@FindBy(xpath="(//table[@id='transfer_modal_tbl']/thead/tr/th[contains(.,'Inner') and contains(.,'Pack Count')])[1]")
	public WebElement ViewTransferForm_InnerPackCount_Header;;
	
	@FindBy(xpath="(//table[@id='transfer_modal_tbl']/thead/tr/th[contains(.,'Loose') and contains(.,'Count')])[1]")
	public WebElement ViewTransferForm_LooseCount_Header;;
	
	@FindBy(xpath="(//table[@id='transfer_modal_tbl']/thead/tr/th[contains(.,'Item') and contains(.,'Total')])[1]")
	public WebElement ViewTransferForm_UnitsCount_Header;;
	
	@FindBy(xpath="(//th[contains(text(),'Sub-total')])[2]")
	public WebElement ViewTransferForm_SubTotal_Header;
	
	@FindBy(xpath="//input[@id='transfer_date']")
	public WebElement ViewTransferForm_Date_TB;
	
	@FindBy(xpath="//input[@id='transfer_time']")
	public WebElement ViewTransferForm_Time_TB;
	
	@FindBy(xpath="//input[@id='transfer_type']")
	public WebElement ViewTransferForm_TransferType_TB;
	
	@FindBy(xpath="//input[@id='transfer_store']")
	public WebElement ViewTransferForm_StoreBumber_TB;
	
	@FindBy(xpath="//div[@id='transfer_time']/div/span[@id='header_name']")
	public WebElement ViewTransferForm_PreparerName_Value;
	
	@FindBy(xpath = "//h2[text()='Transfer']")
	public WebElement AddNewTransfer_Header;
	
	@FindBy(xpath = "//div[@id='eb_tp_input']/span[@id='eb_tp_span']")
	public WebElement AddTransferPopup_Time_TB;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Transfer entry saved']")
	public WebElement Submit_Transfer_Confirmation_MSG;
	
	@FindBy(xpath="//input[@id='transfer_store']")
	public WebElement TransferDetail_NationalStoreNumber_TB;
	
	@FindBy(xpath="//input[@id='transfer_type']")
	public WebElement TransferDetail_TypeOfTransfer_TB;
	
	@FindBy(xpath="//ul[@id='utility-toolbar']/li[@id='deleteId']")
	public WebElement AddTransferPopup_DeleteItem_BT;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement AddTransferForm_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='insert_transfer_details_modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement AddTransferForm_Close_BT;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement CancelTransfer_PopUp_YES_BT;
	
	@FindBy(xpath = "//div[@id='dlgContent' and contains(text(),'All entered information will be lost. Are you sure you want to cancel?')]")
	public WebElement CancelTransfer_Warning_Message;
	
	@FindBy(xpath = "//tbody[@id='transfer_add_body']/tr")
	public List<WebElement> AddTransferForm_TransferItemEntry_List;
	
	@FindBy(xpath = "//eb-modal[@id='insert_transfer_details_modal']/div[contains(@class,'container')]")
	public WebElement AddTransferForm_Container;
	
	@FindBy(xpath="//th[text()='WRIN']")
	public WebElement AddNewTransferForm_Wrin_Header;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[text()='Description']")
	public WebElement AddNewTransferForm_Description_Header;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[contains(.,'Case') and contains(.,'Count')]")
	public WebElement AddNewTransferForm_CaseCount_Header;;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[contains(.,'Inner') and contains(.,'Pack Count')]")
	public WebElement AddNewTransferForm_InnerPackCount_Header;;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[contains(.,'Loose') and contains(.,'Count')]")
	public WebElement AddNewTransferForm_LooseCount_Header;;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[contains(.,'Item') and contains(.,'Total')]")
	public WebElement AddNewTransferForm_ItemTotal_Header;;
	
	@FindBy(xpath="//table[@id='transfer_add']/thead/tr/th[text()='Sub-total']")
	public WebElement AddNewTransferForm_SubTotal_Header;
	
	@FindBy(xpath ="//div[@id='kpi-header']/h2[text()='Current Day Activity']")
	public WebElement TransferLandingPage_CurrentDayActivity_Label;
	
	@FindBy(xpath ="//table[@id='transfercounts']/tbody/tr/td[2]/span")
	public List <WebElement> TransferLandingPage_TransferType_List;
	
	
	public TransferLandingPage insertAndAddDetailsToTransfer(String samplewRINID, 
			String outerPackQty, String innerPackQty,String looseUnitsQty) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException 
	{
		seacrhAndSelectRawItem(samplewRINID);
		Thread.sleep(3000);
		// Enter the outerPackQty for the food item
		Actions actions = new Actions(driver);
		actions.moveToElement(AddTransferItemsPopup_CaseCount_TB.get(0));
		actions.perform();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_CaseCount_TB.get(0)));
		GenericMethods.enterValueInElement(AddTransferItemsPopup_CaseCount_TB.get(0),"AddTransferItemsPopup_CaseCount_TB",outerPackQty);
		try {
			// Enter the innerPackQty for the food item
			GenericMethods.enterValueInElement(AddTransferItemsPopup_InnerPackCount_TB.get(0),"AddTransferItemsPopup_InnerPackCount_TB",innerPackQty);
		} catch (Exception e) {
			// innerPackQty is not applicable for the food item
		}
		// Enter the looseUnitsQty for the food item
		GenericMethods.enterValueInElement(AddTransferItemsPopup_LooseCount_TB.get(0),"AddTransferItemsPopup_LooseCount_TB",looseUnitsQty);
		AddNewTransfer_Header.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Submit_BT));
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage EnterQuantitiesForWrinId(String samplewRINID, String outerPackQty, String innerPackQty,
			String looseUnitsQty) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.enterValueInElement(driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='case_count']")),"case_count",outerPackQty);
		try{
			GenericMethods.enterValueInElement(driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[3]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='inner_pack_count']")),"inner_pack_count",innerPackQty);
		}catch(Exception e){
			//Do nothing
		}
		GenericMethods.enterValueInElement(driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[4]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='loose_count']")),"loose_count",looseUnitsQty);
		AddNewTransfer_Header.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Submit_BT));
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public boolean verifyTransferPlaced(String date,String amount) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		Thread.sleep(3000);
		System.out.println("//table[@id='transfercounts']//tr/td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+amount+"']");
		return Base.isElementDisplayed(By.xpath("//table[@id='transfercounts']//tr/td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+amount+"']"));
	}
	
	public boolean verifyTransferPlaced(String date,String transferType,String storID,String amount) throws InterruptedException{
		if(transferType.equalsIgnoreCase("Office"))
		{
			transferType="Out";
			storID="Office";
		}
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		Thread.sleep(3000);
		System.out.println("//table[@id='transfercounts']/tbody/tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[contains(.,'"+transferType+"')]/../following-sibling::td/span[contains(.,'"+storID+"')]/../following-sibling::td/span[text()='"+amount+"']");
		return Base.isElementDisplayed(By.xpath("//table[@id='transfercounts']/tbody/tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[contains(.,'"+transferType+"')]/../following-sibling::td/span[contains(.,'"+storID+"')]/../following-sibling::td/span[text()='"+amount+"']"));
	}
	
	public TransferLandingPage selectDateInAddNewTransferPopUp(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(AddTransferPopup_Date_TB,"AddTransferPopup_Date_TB");
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")),date);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	
	}
	
	public boolean verifyDateIsDisabled(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(AddTransferPopup_Date_TB,"AddTransferPopup_Date_TB");
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		return driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
	}
	
	public TransferLandingPage selectTimeInAddNewTransferForm(String time) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(InsertNewTransfersPopup_Time_Value,"InsertNewTransfersPopup_Time");
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while(!AddNewTransferForm_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_hour_up').click();");
		}
		//AddNewTransferForm_hourSpan_Value.click();
		String minuteValue = time.split(":")[1];
		while(!AddNewTransferForm_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementById('eb_tp_min_up').click();");
		}
		//AddNewTransferForm_MinSpan_Value.click();
		AddNewTransfer_Header.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, TransferLandingPage.class); 
	}
	
	public String getTimeToSet() throws InterruptedException{
		InsertNewTransfersPopup_Time_Value.click();
		Thread.sleep(1000);
		String hourValue;
		String minuteValue;
		int hour = Integer.parseInt(AddNewTransferForm_hourSpan_Value.getText())+1;
		if (hour > 0 && hour < 10) {
			hourValue = "0" + hour;
		} else {
			hourValue = String.valueOf(hour);
		}
		int minute = Integer.parseInt(AddNewTransferForm_MinSpan_Value.getText())+1;
		if (minute > 0 && minute < 10) {
			minuteValue = "0" + minute;
		} else {
			minuteValue = String.valueOf(minute);
		}
		String timeToSet = hourValue+":"+minuteValue;
		System.out.println(timeToSet);
		InsertNewTransfersPopup_Time_Value.click();
		Thread.sleep(1000);
		return timeToSet;
	}
	
	public TransferLandingPage selectTransferType(String transferTypeValue) throws RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.selectTextFormDropDownElement(TransferType_DD, "TransferType_DD", transferTypeValue);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage selectLocationToTransfer(String storeId) throws RowsExceededException, BiffException, WriteException, IOException{
		//Select selectLocation = new Select(Location_DD);
		GenericMethods.selectValueFormDropDownElement(Location_DD, "Location_DD", storeId);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage seacrhAndSelectRawItem(String samplewRINID) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clearValueOfElement(AddTransferItemsPopup_RawItemsSearchBox_TB, "AddTransferItemsPopup_RawItemsSearchBox_TB");
		GenericMethods.enterValueInElement(AddTransferItemsPopup_RawItemsSearchBox_TB, "AddTransferItemsPopup_RawItemsSearchBox_TB", samplewRINID);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//strong[text()='" + samplewRINID + "']")),samplewRINID);
		Thread.sleep(2000);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public void viewTransfer(String date, String amount) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		WebElement viewTransfer_BT = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//table[@id='transfercounts']/tbody/tr/td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+amount+"']/../following-sibling::td//button[@value='View']")));
		try {
			executor.executeScript("arguments[0].click();", viewTransfer_BT);
		} catch (Exception e) {
			// Do Page scroll
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			viewTransfer_BT.click();
		}
	}
	
	public TransferLandingPage selectStartDate(String startDate) throws InterruptedException{
		StartDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	
	public boolean verifyOfficeTransferIsPresent() {
		Select selectTransferType = new Select(TransferType_DD);
		List<WebElement>transferType = selectTransferType.getOptions();
		for (int i = 0; i < transferType.size(); i++) {
			String text = transferType.get(i).getText();
			System.out.println("text "+text);
			if (text.equalsIgnoreCase("Office")) {
				return true;
			}
		}
		return false;
	}
	
	
	public TransferLandingPage selectEndDate(String endDate) throws InterruptedException{
		EndDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	

	public boolean verifyTransferHistoryDisplayedForSelectedDateRange(String startDate, String endDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date stDate = df.parse(startDate);
		Date eDate = df.parse(endDate);
		System.out.println(stDate);
		System.out.println(eDate);
		List<WebElement> recordDateList = driver.findElements(By.xpath("//table[@id='transfercounts']//tr/td[1]/span"));
		boolean result = true;
		for(WebElement record : recordDateList ){
			String date = record.getText();
			System.out.println("date "+date);
			Date recordDate = df.parse(date);
			if((recordDate.compareTo(stDate)>0 ||recordDate.compareTo(stDate) ==0) & (recordDate.compareTo(eDate)<0||recordDate.compareTo(eDate)==0)){
			System.out.println("RecordDate"+recordDate);
				result = result & true;
			}else{result = result & false;}
		}
		return result;
		
	}
	
	/*This method will return total waste amount added*/
	public String getTotalTransferAmunt(){
		List<WebElement> transferItemSubtotalList = driver.findElements(By.xpath("//table[@id='transfer_add']/tbody/tr/td[8]"));
		BigDecimal subtotal = new BigDecimal("0.00");
		for(WebElement transferItem : transferItemSubtotalList){
			String transferSubtotal = transferItem.getText().replace("$", "").trim();
			BigDecimal itemSubtotal = new BigDecimal(transferSubtotal);
			subtotal = subtotal.add(itemSubtotal);
		}
		return String.valueOf(subtotal);
	}
	
	public void removeWrinIdFromTransferPage(String wrinId){
		WebElement checkBox = driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+wrinId+"')]/../preceding-sibling::td"));
		checkBox.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferPopup_DeleteItem_BT)).click();
	}
	
	public void removeAllWrinIdFromTransferPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='transfer_add_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			GenericMethods.clickOnElement(removeBtn,"checkBox");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='utility-toolbar']/li[@id='deleteId']"))),"Delete Button");
			Thread.sleep(1000);
		}
	}
	
	public boolean verifyItemIsAdded(String wrinId){
		return Base.isElementDisplayed(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+wrinId+"')]"));
	}
	
	public boolean verifyAmountIsInAscendingOrder(){
		List<WebElement> amountList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[4]/span"));
		boolean result = true;
		for(int i = 0;i<amountList.size();i++){
			if(i<amountList.size()-1){
				String amountValue1 = amountList.get(i).getText();
				System.out.println("amountValue1 "+amountValue1);
				BigDecimal value1 = new BigDecimal(amountValue1);
				String amountValue2 = amountList.get(i + 1).getText();
				System.out.println("amountValue2 "+amountValue2);
				BigDecimal value2 = new BigDecimal(amountValue2);
				System.out.println("Comp "+ ((value1.compareTo(value2) < 0) ||(value1.compareTo(value2) == 0)));
				result = result & ((value1.compareTo(value2) < 0) ||(value1.compareTo(value2) == 0)) ;
			}
		}
		return result;
	}
	
	public boolean verifyAmountIsInDescendingOrder(){
		List<WebElement> amountList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[4]/span"));
		boolean result = true;
		for(int i = 0;i<amountList.size();i++){
			if(i<amountList.size()-1){
				String amountValue1 = amountList.get(i).getText();
				System.out.println("amountValue1 "+amountValue1);
				BigDecimal value1 = new BigDecimal(amountValue1);
				String amountValue2 = amountList.get(i + 1).getText();
				System.out.println("amountValue2 "+amountValue2);
				BigDecimal value2 = new BigDecimal(amountValue2);
				System.out.println("Comp "+ ((value1.compareTo(value2) > 0) ||(value1.compareTo(value2) == 0)));
				result = result & ((value1.compareTo(value2) > 0) ||(value1.compareTo(value2) == 0)) ;
			}
		}
		return result;
	}
	
	public boolean verifyDateIsInAscendingOrder() throws ParseException{
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[1]/span"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyDateInAscendingOrder(dateValueList);
	}
	
	public boolean verifyDateIsInDescendingOrder() throws ParseException{
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[1]/span"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyDateInDescendingOrder(dateValueList);
	}
	
	public boolean verifyTypeIsInAscendingOrder() throws ParseException{
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyStringInAsscendingOrder(dateValueList);
	}
	
	public boolean verifyTypeIsInDescendingOrder() throws ParseException{
		List<WebElement> dateList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span"));
		List<String>dateValueList = Base.getTextListFromWebElements(dateList);
		return Base.verifyStringInDescendingOrder(dateValueList);
	}
	
	public boolean verifyRecordsAreDisplayedInCorrectFormat(){
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		List<WebElement> transferRecordsList = driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr[@role='row']"));
		boolean result = true;
		for (int i = 1; i <= transferRecordsList.size(); i++) {
			// Verify the date and time format for each records
			boolean dateTimePatternMatched = Pattern.compile(datepattern).matcher(
							driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[1]/span")).getText()).matches();
			// verify the type of the transaction for each record
			boolean storeTypeValueDisplayed = (driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[2]/span")).getText().contains("In")
					|| driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[2]/span")).getText().contains("Out"));
			boolean locationDisplayed = !driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[3]")).getText().isEmpty();
			boolean amountDisplayed = !driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[contains(@class,'money-format')]/span")).getText().isEmpty();
			// Verify the view button for each record
			boolean viewButtonresult = driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[5]/eb-button/button")).getText().equalsIgnoreCase("View");
			result = result & dateTimePatternMatched & storeTypeValueDisplayed & locationDisplayed
					& amountDisplayed & viewButtonresult;
			System.out.println("Entry format matched "+ result);
		}
		return result;
	}
	
	public String getSubTotalForAWrin(String wrinId){
		return driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+wrinId+"')]/../following-sibling::td[6]")).getText();
	}
	
}
