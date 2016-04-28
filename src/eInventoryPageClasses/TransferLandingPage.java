package eInventoryPageClasses;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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


public class TransferLandingPage extends AbstractPage{

	public TransferLandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//h1[text()='Transfers']")
	public WebElement TransferLandingPage_Label;
	
	@FindBy(xpath ="//input[@id='history_start_date']")
	public WebElement TransferLandingPage_StartDate_TB;
	
	@FindBy(xpath ="//input[@id='history_end_date']")
	public WebElement TransferLandingPage_EndDate_TB;

	@FindBy(xpath ="//eb-button[@class='insertNewTransferBtn']/button")
	public WebElement CreateNewTransfers_BT;

	@FindBy(xpath ="//input[@id='autosearchInput']")
	public WebElement AddTransferItemsPopup_RawItemsSearchBox_TB;
	
	@FindBy(xpath ="(//table[@id='transfer_modal_tbl']/tbody[@id='transfer_modal_body'])[1]/tr")
	public List <WebElement> TransferDetailsPopup_Records_List;
	
	@FindBy(xpath ="//table[@id='transfercounts']/tbody/tr/td/eb-button[@value='View']/button")
	public List <WebElement> TransferLandingPage_Records_List;
	
	@FindBy(xpath ="//button[@value='Cancel']")
	public WebElement AddTransferItemsPopup_Cancel_BT;
	
	@FindBy(xpath ="//div[@id='notTitle' and text()='Warning: Transfer Incomplete']")
	public WebElement AddTransferItemsPopup_Warning_Message;
	
	@FindBy(xpath ="//button[@id='htmlButton']/span[text()='Yes']")
	public WebElement AddTransferItemsPopup_Warning_Message_Yes_BT;
	
	@FindBy(xpath ="//button[@id='htmlButton']/span[text()='No']")
	public WebElement AddTransferItemsPopup_Warning_Message_No_BT;
	
	@FindBy(xpath ="//button[@value='Submit']")
	public WebElement AddTransferItemsPopup_Submit_BT;
	
	@FindBy(xpath ="//div[@id='eb_tp_input']/span")
	public WebElement InsertNewTransfersPopup_Time_Value;
	
	@FindBy(xpath = "//input[@id='office_transfer']")
	public WebElement transferToOffice_chkBox;

	@FindBy(xpath = "//input[@id='disp_date']")
	public WebElement dateForTransfer_Label;

	@FindBy(xpath = "//input[@id='disp_time']")
	public WebElement timeForTransfer_Label;

	@FindBy(xpath = "//tbody[@id='transfer_add_body']/tr/td[6]")
	public WebElement unitCountForTransfer_Value;

	@FindBy(xpath = "//div[@id='transfer_detail_modal_count_div']//b[contains(.,'Date & Time')]/parent::span/following-sibling::span/span[1]")
	public WebElement insertNewTransfersDate_label;

	@FindBy(xpath = "//div[@id='transfer_detail_modal_count_div']//b[contains(.,'Date & Time')]/parent::span/following-sibling::span/span[2]")
	public WebElement InsertNewTransfersTime_label;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Store Number is not valid']")
	public WebElement InvalidStoreNumber_Messag;
	
	@FindBy(xpath="//tbody[@id='transfer_modal_body']/tr/td[7]/span")
	public WebElement SubTotalForTransfer_Label;

	@FindBy(xpath="//input[@value='Close']")
	public WebElement TransferDetailPopUp_Close_BTN;
	
	@FindBy(xpath="//label[text()='Select a date and time for your new transfer:']")
	public WebElement InsertNewTransfersPopup_SelectDateTime_Label;
	
	@FindBy(id = "back-to-top")
	public WebElement BackToTop_BT;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[1]/span[2]/span")
	public WebElement SubmittedTransferPopup_Type_Value;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[2]/span[2]")
	public WebElement SubmittedTransferPopup_NationalStoreNO_Value;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[3]/span[2]/span[1]")
	public WebElement SubmittedTransferPopup_Date_Value;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[3]/span[2]/span[2]")
	public WebElement SubmittedTransferPopup_Time_Value;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[5]/span[2]")
	public WebElement SubmittedTransferPopup_TotalAmount_Value;
	
	@FindBy(xpath ="//div[@id='transfer_detail_modal_count_div']/div/div[6]/span[2]")
	public WebElement SubmittedTransferPopup_CreatedBy_Value;
	
	@FindBy(xpath ="//div[@id='total_amount_div']/strong")
	public WebElement AddTransferPopup_TotalAmount_Value;
	
	@FindBy(xpath ="//input[@id='insert_new_transfer_date']")
	public WebElement AddTransferPopup_Date_TB;
	
	@FindBy(xpath ="//button[@id='insert_new_transfer_date_btn']/i[contains(@class,'calendar')]")
	public WebElement AddTransferPopup_Date_BT;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement CanceTransferPopup_Yes_BT;
	
	@FindBy(xpath ="//button[@id='htmlButton']/span[text()='No']")
	public WebElement CanceTransferPopup_No_BT;
	
	@FindBy(xpath ="//input[@id='transfer_input_total_pack']")
	public WebElement AddTransferItemsPopup_TotalUnits_TB;
	
	@FindBy(id="transfer_type_menu")
	public WebElement TransferType_DD;
	
	@FindBy(id="location_menu")
	public WebElement Location_DD;
	
	@FindBy(id="add-transfers-clear-input-btn")
	public WebElement AddTransferItemsPopup_AddRawItem_BT;;
	
	@FindBy(xpath="//input[@colname='inner_pack_count']")
	public WebElement AddTransferItemsPopup_InnerPackCount_TB;
	
	@FindBy(xpath="//input[@colname='case_count']")
	public WebElement AddTransferItemsPopup_CaseCount_TB;
	
	@FindBy(xpath="//input[@colname='loose_count']")
	public WebElement AddTransferItemsPopup_LooseCount_TB;	
	
	@FindBy(xpath="//button/span[text()='Yes']")
	public WebElement SubmitTransferConfirmationPopUp_Yes_BT;
	
	@FindBy(xpath="//button/span[text()='No']")
	public WebElement SubmitTransferConfirmationPopUp_No_BT;
	
	@FindBy(xpath ="//div[@id='eb-modal-print']")
	public WebElement AddTransferItemsPopup_Print_BT;
	
	@FindBy(xpath ="//div[@id='grand_amount']/span[2]/span")
	public WebElement ViewTransferItemsPopup_GrandTotal_Value;
	
	@FindBy(xpath ="//div[@id='modal-header-bottom-right']/div/div/div/a[contains(@class,'icon-print')]")
	public WebElement ViewTransferItemsPopup_Print_BT;
	
	@FindBy(xpath ="//h2[text()='Transfer']")
	public WebElement Transfer_Title;

	@FindBy(xpath ="//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span']")
	public WebElement AddNewTransferForm_hourSpan_Value;
	
	@FindBy(xpath ="//div[@id='eb_tp_hr_control']/div[@id='eb_tp_hour_up']")
	public WebElement AddNewTransferItemsPopup_HourUp_BT;
	
	@FindBy(xpath ="//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span']")
	public WebElement AddNewTransferForm_MinSpan_Value;
	
	@FindBy(xpath ="//div[@id='eb_tp_min_up']")
	public WebElement AddNewTransferItemsPopup_MinUp_BT;
	
	@FindBy(xpath ="//input[@id='history_start_date']")
	public WebElement StartDate_TB;
	
	@FindBy(xpath ="//input[@id='history_end_date']")
	public WebElement EndDate_TB;
	
	@FindBy(xpath ="//eb-button[@value='Show Results']/button")
	public WebElement ShowResults_BT;
	
	@FindBy(xpath = "//div[contains(@id,'dlgContent')]")
	public WebElement AddNewTransfer_Confirmation_Message;
	
	@FindBy(xpath = "//div[contains(@class,'confirmation-title')]/div[@id='notTitle']")
	public WebElement AddNewTransfer_ConfirmationPopUp_Title;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='Transfer entry saved']")
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
	
	@FindBy(xpath="//h2[text()='Transfer Out Detail']")
	public WebElement ViewTransferForm_Title;
	
	@FindBy(xpath ="//table[@id='transfer_modal_tbl']/tbody/tr")
	public List <WebElement> ViewTransferForm_Records_List;
	
	@FindBy(xpath="(//th[text()='WRIN'])[2]")
	public WebElement ViewTransferForm_Wrin_Header;
	
	@FindBy(xpath="(//th[text()='Description'])[2]")
	public WebElement ViewTransferForm_Description_Header;
	
	@FindBy(xpath="(//th[text()='Case Count'])[2]")
	public WebElement ViewTransferForm_CaseCount_Header;;
	
	@FindBy(xpath="(//th[text()='Inner Pack Count'])[2]")
	public WebElement ViewTransferForm_InnerPackCount_Header;;
	
	@FindBy(xpath="(//th[text()='Loose Count'])[2]")
	public WebElement ViewTransferForm_LooseCount_Header;;
	
	@FindBy(xpath="(//th[text()='Units Count'])[2]")
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
	
	@FindBy(xpath="//div[@id='transfer_time']/span[@id='header_name']")
	public WebElement ViewTransferForm_PreparerName_Value;
	
	@FindBy(xpath = "//h2[text()='Transfer']")
	public WebElement AddNewTransfer_Header;
	
	@FindBy(xpath = "//div[@id='eb_tp_input']/span[@id='eb_tp_span']")
	public WebElement AddTransferPopup_Time_TB;
	
	@FindBy(xpath="//div[@class='toast-message' and text()='New Item Added']")
	public WebElement AddTransferPopup_ItemAdded_Msg;
	
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
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement CancelTransfer_PopUp_NO_BT;
	
	@FindBy(xpath = "//div[@id='dlgContent']")
	public WebElement CancelTransfer_Warning_Message;
	
	@FindBy(xpath = "//tbody[@id='transfer_add_body']/tr")
	public List<WebElement> AddTransferForm_TransferItemEntry_List;
	
	@FindBy(xpath = "//eb-modal[@id='insert_transfer_details_modal']/div[contains(@class,'container')]")
	public WebElement AddTransferForm_Container;
	
	@FindBy(xpath="//th[text()='WRIN']")
	public WebElement AddNewTransferForm_Wrin_Header;
	
	@FindBy(xpath="//th[text()='Description']")
	public WebElement AddNewTransferForm_Description_Header;
	
	@FindBy(xpath="//th[text()='Case Count']")
	public WebElement AddNewTransferForm_CaseCount_Header;;
	
	@FindBy(xpath="//th[text()='Inner Pack Count']")
	public WebElement AddNewTransferForm_InnerPackCount_Header;;
	
	@FindBy(xpath="//th[text()='Loose Count']")
	public WebElement AddNewTransferForm_LooseCount_Header;;
	
	@FindBy(xpath="//th[text()='Units Count']")
	public WebElement AddNewTransferForm_UnitsCount_Header;;
	
	@FindBy(xpath="//th[text()='Sub-total($)']")
	public WebElement AddNewTransferForm_SubTotal_Header;
	
	
	/*
	 * After selecting the store this method will click on the continue button
	 * and allow the user to search for a WRIN id. it will insert the
	 * outerPackQty, innerPackQty(if applicable) , looseUnitsQty and than add the transfer
	 */
	/*public TransferLandingPage insertAndAddDetailsToTransfer(String samplewRINID, String outerPackQty, String innerPackQty,String looseUnitsQty) throws InterruptedException {
		// Click on the continue transfer button in Insert New Transfers Popup
		//InsertNewTransfersPopup_ContinueTransfer_BT.click();
		// Enter the WRIN Id
		AddTransferItemsPopup_RawItemsSearchBox_TB.sendKeys(samplewRINID);
		driver.findElement(By.xpath("//strong[text()='" + samplewRINID + "']")).click();
		AddTransferItemsPopup_AddRawItem_BT.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_OuterPack_TB));
		// Enter the outerPackQty for the food item
		AddTransferItemsPopup_OuterPack_TB.sendKeys(outerPackQty);
		try {
			// Enter the innerPackQty for the food item
			AddTransferItemsPopup_InnerPack_TB.sendKeys(innerPackQty);
		} catch (Exception e) {
			// innerPackQty is not applicable for the food item
		}
		// Enter the looseUnitsQty for the food item
		AddTransferItemsPopup_LooseUnits_TB.sendKeys(looseUnitsQty);
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Add_BT));
		// Add the transfer
		AddTransferItemsPopup_Add_BT.click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Submit_BT));
		return PageFactory.initElements(driver, TransferLandingPage.class);

	}*/
	
	public TransferLandingPage insertAndAddDetailsToTransfer(String samplewRINID, 
			String outerPackQty, String innerPackQty,String looseUnitsQty) throws InterruptedException 
	{
		seacrhAndSelectRawItem(samplewRINID);
		Thread.sleep(3000);
		// Enter the outerPackQty for the food item
		Actions actions = new Actions(driver);
		actions.moveToElement(AddTransferItemsPopup_CaseCount_TB);
		// actions.click();
		actions.perform();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_CaseCount_TB));
		AddTransferItemsPopup_CaseCount_TB.sendKeys(outerPackQty);
		try {
			// Enter the innerPackQty for the food item
			AddTransferItemsPopup_InnerPackCount_TB.sendKeys(innerPackQty);
		} catch (Exception e) {
			// innerPackQty is not applicable for the food item
		}
		// Enter the looseUnitsQty for the food item
		AddTransferItemsPopup_LooseCount_TB.sendKeys(looseUnitsQty);
		AddNewTransfer_Header.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Submit_BT));
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage EnterQuantitiesForWrinId(String samplewRINID, String outerPackQty, String innerPackQty,
			String looseUnitsQty) throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[2]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='case_count']")).sendKeys(outerPackQty);
		try{
			driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[3]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='inner_pack_count']")).sendKeys(innerPackQty);
		}catch(Exception e){
			//Do nothing
		}
		driver.findElement(By.xpath("//tbody[@id='transfer_add_body']/tr/td/span[contains(text(),'"+samplewRINID+"')]/../following-sibling::td[4]/eb-validated-input//div/div[contains(@class,'input-group')]/input[@colname='loose_count']")).sendKeys(looseUnitsQty);
		AddNewTransfer_Header.click();
		wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_Submit_BT));
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	
/*	//Create a transfer IN or Out type of transaction
	public TransferLandingPage createATransferTransaction(String samplewRINID,String nationalStoreNumber,String type ,String outerPackQty, String innerPackQty,String looseUnitsQty) throws InterruptedException
	{
		//click on insert new transfer button
//		CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(InsertNewTransfersPopup_InputNationalStoreNo_TB));
		InsertNewTransfersPopup_InputNationalStoreNo_TB.sendKeys(nationalStoreNumber);
		//click on transfer out or in
		if(type.equalsIgnoreCase("OUT"))
		{
			InsertNewTransfersPopup_TransferOut_RB.click();
		}
		else
		{
			InsertNewTransfersPopup_TransferIn_RB.click();
		}
		insertAndAddDetailsToTransfer(samplewRINID, outerPackQty, innerPackQty, looseUnitsQty);
		Thread.sleep(3000);
		//click on submit button
		AddTransferItemsPopup_Submit_BT.click();
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(ChangesSaved_Confirmation_MSG));
		return PageFactory.initElements(driver, TransferLandingPage.class);
		
	}*/
	
	public boolean verifyTransferPlaced(String date, String time, String amount) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		Thread.sleep(3000);
		System.out.println("//table[@id='transfercounts']//tr/td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+amount+"']");
		return Base.isElementDisplayed(By.xpath("//table[@id='transfercounts']//tr/td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+amount+"']"));
	}
	
	public boolean verifyTransferPlaced(String date, String time,String store,String amount) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		Thread.sleep(3000);
		return Base.isElementDisplayed(By.xpath("//table[@id='transfercounts']/tbody/tr/td[contains(.,'"+time+"')]/span[contains(text(),'"+date+"')]/../following-sibling::td/span[contains(.,'"+store+"')]/../following-sibling::td/span[text()='"+amount+"']"));
	}
	
	public TransferLandingPage selectDateInAddNewTransferPopUp(String date) throws InterruptedException{
		AddTransferPopup_Date_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, TransferLandingPage.class);
	
	}
	
	/*public TransferLandingPage selectMonthFromDatePicker(String monthName,int calIndex){
		String selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[1]/span")).getText();
		while (!selectedMonth.equals(monthName)) {
			driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/button[@class='xdsoft_prev']")).click();
			selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[contains(@class,'xdsoft_month')]/span")).getText();
			System.out.println("monthName found "+selectedMonth);
		}
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}*/
	
	public void selectTimeInAddNewTransferForm(String time) throws InterruptedException{
		InsertNewTransfersPopup_Time_Value.click();
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
	
	public TransferLandingPage selectTransferType(String transferTypeValue){
		Select selectTransferType = new Select(TransferType_DD);
		//TransferType_DD.click();
		selectTransferType.selectByVisibleText(transferTypeValue);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage selectLocationToTransfer(String storeId){
		Select selectLocation = new Select(Location_DD);
		selectLocation.selectByVisibleText(storeId);
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public TransferLandingPage seacrhAndSelectRawItem(String samplewRINID) throws InterruptedException{
		AddTransferItemsPopup_RawItemsSearchBox_TB.clear();
		AddTransferItemsPopup_RawItemsSearchBox_TB.sendKeys(samplewRINID);
		driver.findElement(By.xpath("//strong[text()='" + samplewRINID + "']")).click();
		Thread.sleep(2000);
		/*wait.until(ExpectedConditions.visibilityOf(AddTransferItemsPopup_AddRawItem_BT));
		AddTransferItemsPopup_AddRawItem_BT.click();*/
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	
	public void viewTransfer(String date, String time, String amount) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(CreateNewTransfers_BT));
		WebElement viewTransfer_BT = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//table[@id='transfercounts']/tbody/tr/td[contains(.,'"+time+"')]/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+amount+"']/../following-sibling::td//button[@value='View']")));
		try {
			viewTransfer_BT.click();

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
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
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
		selectMonthFromDatePicker(Base.getMonthName(month+1),3);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[3]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, TransferLandingPage.class);
	}
	

	public boolean verifyTransferHistoryDisplayedForSelectedDateRange(String startDate, String endDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
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
			String transferSubtotal = transferItem.getText();
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
	
	public void removeAllWrinIdFromTransferPage() throws InterruptedException{
		List<WebElement> removeBtnList = driver.findElements(By.xpath("//tbody[@id='transfer_add_body']/tr/td[contains(@class,'select-checkbox')]"));
		for(WebElement removeBtn : removeBtnList){
			removeBtn.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='utility-toolbar']/li[@id='deleteId']"))).click();
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
	
}
