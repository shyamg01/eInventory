package eInventoryPageClasses;

import java.math.BigDecimal;
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
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

public class PromotionsAndWastePage extends AbstractPage
{

	public PromotionsAndWastePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath ="//h1[contains(.,'Promotions & Waste')]")
	public WebElement PromotionAndWaste_Title;
	
	@FindBy(xpath ="//a[@href='#completed']")
	public WebElement Completed_TAB;
	
	@FindBy(xpath ="//button[@id='htmlButton' and @value='Enter Raw Promo']")
	public WebElement RawPromo_BT;
	
	@FindBy(xpath ="//button[@id='htmlButton' and text()='Enter Raw Waste']")
	public WebElement RawWaste_BT;
	
	@FindBy(xpath ="//label[contains(text(),'Begin Date:')]")
	public WebElement BeginDate_Label;
	
	@FindBy(xpath ="//button[@id='one_month_cal_btn']")
	public WebElement MonthToDate_BT;
	
	@FindBy(xpath ="//label[@id='daily_label']")
	public WebElement DailyRollup_label;
	
	@FindBy(xpath ="//th[contains(text(),'Date')]")
	public WebElement Date_Coloumn;
	
	@FindBy(xpath ="//th[contains(text(),'Cost')]")
	public WebElement Cost_Coloumn ;

	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='WRIN']")
	public WebElement wasteDetail_WRINColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Description']")
	public WebElement wasteDetail_DescriptionColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Outer Pack']")
	public WebElement wasteDetail_OutePackColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Inner Pack']")
	public WebElement wasteDetail_InnerPackColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Loose Unit']")
	public WebElement wasteDetail_LooseUnitColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Total Units']")
	public WebElement wasteDetail_TotalUnitsColumn_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/thead//th[text()='Sub-total']")
	public WebElement wasteDetail_SubtotalColumn_Label ;
	
	@FindBy(xpath ="//i[@class='glyphicon glyphicon-chevron-right']")
	public List <WebElement> Record_Expend_Button_List ;
	
	@FindBy(xpath ="//input[@id='promo_waste_start_date']")
	public WebElement promoWasteHistoryStartDate_TB ;
	
	@FindBy(xpath ="//input[@id='promo_waste_end_date']")
	public WebElement promoWasteHistoryEndDate_TB ;
	
	@FindBy(xpath ="//button[@value='Enter Completed Waste']")
	public WebElement CompletedWaste_BT ;
	
	@FindBy(xpath ="//eb-button[@value='Show Results']/button")
	public WebElement ShowResults_BT;

	@FindBy(xpath ="//th[text()='Time Occurred']")
	public WebElement PromotionAndWasteTable_TimeofWaste_Header;
	
	@FindBy(xpath ="//th[text()='Date Submitted']")
	public WebElement PromotionAndWasteTable_DateEntered_Header;
	
	@FindBy(xpath ="//th[text()='Time Submitted']")
	public WebElement PromotionAndWasteTable_TimeEntered_Header;
	
	@FindBy(xpath ="//th[text()='Submitted By']")
	public WebElement PromotionAndWasteTable_EnteredBy_Header;
	
	@FindBy(xpath ="//th[text()='Type']")
	public WebElement PromotionAndWasteTable_Type_Header;
	
	@FindBy(xpath ="//th[text()='Amount']")
	public WebElement PromotionAndWasteTable_Amount_Header;
	
	@FindBy(xpath ="//div[@id='kpi-container']/div[1]")
	public WebElement AtAGlance_Expand_Icon;
	
	@FindBy(xpath ="//div[@id='kpi-header']/h2[text()='Current Day Activity']")
	public WebElement AtAGlance_Header;
	
	@FindBy(xpath ="//tr[contains(@class,'waste_date_group')]")
	public List<WebElement> WasteRecordsList;
	
	@FindBy(xpath ="(//h2[text()='Completed Waste'])[1]")
	public WebElement ViewCompletedWasteForm_Title;
	
	@FindBy(xpath ="//div[@id='raw_waste_total_amount']/span[1]/strong[contains(text(),'Total Amount:')]")
	public WebElement wasteDetail_Total_Label ;
	
	@FindBy(xpath ="//div[@id='raw_waste_total_amount']/span[2]/strong")
	public WebElement wasteDetail_Total_Value ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/tbody/tr")
	public List<WebElement> WasteDetailsEntries_List;
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/thead//th[text()='Menu Item #']")
	public WebElement ConpletedWasteDetail_MenuItem_Label ;
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/thead//th[text()='Description']")
	public WebElement ConpletedWasteDetail_Description_Label ;
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/thead//th[text()='Quantity wasted']")
	public WebElement ConpletedWasteDetail_QuantityWasted_Label ;
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/thead//th[text()='Sub-total']")
	public WebElement ConpletedWasteDetail_SubTotal_Label ;
	
	@FindBy(xpath ="//tbody[@id='comp_waste_entry_table_body']/tr")
	public List<WebElement> CompletedWasteDetailsEntries_List;
	
	@FindBy(xpath ="//div[@id='total_completed_waste_amount']/span[1]/strong[contains(text(),'Total Amount:')]")
	public WebElement CompletedWasteDetail_Total_Label ;
	
	@FindBy(xpath ="//div[@id='total_completed_waste_amount']/span[2]")
	public WebElement CompletedWasteDetail_Total_Value ;
	
	
	/*@FindBy(xpath ="//input[@id='comp_waste_autocomplete']")
	public WebElement CompletedWastePopUp_SearchBox_TB ;
	
	@FindBy(xpath ="//input[@id='validatedInput' and @label='Quantity wasted']")
	public WebElement CompletedWastePopUp_QuantityWasted_TB ;*/
		
	public boolean IspromotionsAndWaste_WastePageLoaded() throws Exception 
	{
		 /* Verify Promotions and Waste title
		 *  Verify Raw tab
		 *  Verify Complete tab
		 *  Verify Promotion tab
		 *  Verify Waste tab is displaying
		 *  Verify Begin date label is displaying
		 *  Verify Month_to_Date_button.
		 *  Verify Daily roll up label
		 *  Verify Date_Coloum.
		 *  Verify the text which display under DailyRollUp label
		 *  Verify Cost Column
		 */
		wait.until(ExpectedConditions.visibilityOf(PromotionAndWaste_Title));
		
		return   
				 Completed_TAB.isDisplayed()
				& RawPromo_BT.isDisplayed()
				& RawWaste_BT.isDisplayed()
				& BeginDate_Label.isDisplayed()
	            & MonthToDate_BT.isDisplayed()
	            & DailyRollup_label.isDisplayed()
	            & driver.findElement(By.xpath("//p[@id='p_table_expl']")).isDisplayed()
	            & Date_Coloumn.isDisplayed()
	            & Cost_Coloumn.isDisplayed();
	}
	
	/* Function to get current date in MM/dd/yyyy format */
	public String getCurrentDateinMMDDYYYY()
	{
		
		SimpleDateFormat DtFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String current_date=DtFormat.format(date).toString();
		return current_date;
	}
	
	public boolean verifyRawPromoEntry(String date, String amount, String userName, String eId, String enteredTime){
		return verifyWasteEntry(date, amount, userName, eId, enteredTime, "Raw Promo");
		
	}
	
	public boolean verifyRawWasteEntry(String date, String amount, String userName, String eId, String enteredTime){
		return verifyWasteEntry(date, amount, userName, eId, enteredTime, "Raw Waste");
		
	}
	
	public boolean verifyCompletedWasteEntry(String date, String amount, String userName, String eId, String enteredTime){
		return verifyWasteEntry(date, amount, userName, eId, enteredTime, "Completed waste");
		
	}
	
	//Verify Raw Waste entry is Present or not
	public boolean verifyWasteEntry(String date, String amount, String userName, String eId, String enteredTime, String wasteType) {
			String dateformat1 = getFormattedDate(date);
			System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'"+dateformat1+"')]/td[contains(text(),'"+enteredTime+"')]/following-sibling::td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+userName+" - "+eId+"']/../following-sibling::td/span[text()='"+wasteType+"']/../following-sibling::td/span[text()='"+amount+"']");
			return Base.isElementDisplayed(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'"+dateformat1+"')]/td[contains(text(),'"+enteredTime+"')]/following-sibling::td/span[text()='"+date+"']/../following-sibling::td/span[text()='"+userName+" - "+eId+"']/../following-sibling::td/span[text()='"+wasteType+"']/../following-sibling::td/span[text()='"+amount+"']"));
	}
	
	
	
	//Verify Raw Waste entry is Present or not
	public boolean isRawWasteEntryPresent(String date, String amount) {
		String dateformat1 = getFormattedDate(date);
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Waste']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Waste']")).size();
		if (size >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify Completed Waste entry is Present or not
	public boolean isCompletedWasteEntryPresent(String date, String amount) {
		String dateformat1 = getFormattedDate(date);
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Completed waste']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Completed waste']")).size();
		if (size >= 1) {
			return true;
		} else {
			return false;
		}
	}
	// Verify Raw Promo entry is Present or not
	public boolean isRawPromoEntryPresent(String date, String amount)throws InterruptedException {
		String dateformat1 = getFormattedDate(date);
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Promo']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td[5][following-sibling::td/span[text()='"+amount+"']]/span[text()='Promo']")).size();
		if (size >= 1) {
			System.out.println("true");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean verifyWasteHistoryDisplayedForSelectedDateRange(String startDate, String endDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date stDate = df.parse(startDate);
		Date eDate = df.parse(endDate);
		System.out.println(stDate);
		System.out.println(eDate);
		List<WebElement> recordDateList = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'waste_date_group')]"));
		boolean result = true;
		for(WebElement record : recordDateList ){
			String dategroup = record.getAttribute("class").split(" ")[2].split("_")[0];
			System.out.println("dategroup "+dategroup);
			String year = dategroup.substring(4,8);
			String month = dategroup.substring(8,10);
			String day = dategroup.substring(10,12);
			String date = month+"/"+day+"/"+year;
			System.out.println("date "+date);
			Date recordDate = df.parse(date);
			if((recordDate.compareTo(stDate)>0 ||recordDate.compareTo(stDate) ==0) & (recordDate.compareTo(eDate)<0||recordDate.compareTo(eDate)==0)){
			System.out.println("RecordDate"+recordDate);
				result = result & true;
			}else{result = result & false;}
		}
		return result;
		
	}
	
	public boolean verifyWasteDateGroupDisplayedForSelectedDateRange(String startDate, String endDate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'waste_date_group')]")));
		int startDay = Base.getDayFromDate(startDate);
		int endDay = Base.getDayFromDate(endDate);
		String month = startDate.split("/")[0];
		String year = startDate.split("/")[2];
		boolean result = true;
		for (int i = startDay; i <= endDay; i++) {
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date =  year+month + day;
			boolean dateGroupHeaderDisplayed = driver.findElement(By.xpath("//tr[contains(@class,'date" + date+ "_group')]")).isDisplayed();
			String promoWasteCalculationHeader = driver.findElement(By.xpath("//tr[contains(@class,'date" + date+ "_group')]/th[2]/span")).getText();
			boolean dateGroupFooterDisplayed = promoWasteCalculationHeader.contains("Raw Waste:") & promoWasteCalculationHeader.contains("Raw Promo:")
					& promoWasteCalculationHeader.contains("Completed Waste:");
			result =  result &  dateGroupHeaderDisplayed & dateGroupFooterDisplayed;
		}
		return result;
	}
	
	public String getPromoAmountFromDateGroupHeader(String date){
		String completeHeader = getPromoWasteAmountFromDateGroupHeader(date);
		String promoAmountHeader = completeHeader.split("\\|")[1];
		String promoAmount = promoAmountHeader.trim().split("\\$")[1];
		System.out.println("promoAmount "+promoAmount);
		return promoAmount;		
		
	}
	
	public String getWasteAmountFromDateGroupHeader(String date){
		String completeHeader = getPromoWasteAmountFromDateGroupHeader(date);
		String wasteAmountHeader = completeHeader.split("\\|")[0];
		String wasteAmount = wasteAmountHeader.trim().split("\\$")[1];
		System.out.println("wasteAmount "+wasteAmount);
		return wasteAmount;		
	}
	
	public String getCompleteWasteAmountFromDateGroupHeader(String date){
		String completeHeader = getPromoWasteAmountFromDateGroupHeader(date);
		String completeWasteAmountHeader = completeHeader.split("\\|")[2];
		String completWasteAmount = completeWasteAmountHeader.trim().split("\\$")[1];
		System.out.println("wasteAmount "+completWasteAmount);
		return completWasteAmount;		
	}
	
	private String getPromoWasteAmountFromDateGroupHeader(String date){
		String formattedDate =  getFormattedDate(date);
		String promoWasteCalculationHeader = driver.findElement(By.xpath("//tr[contains(@class,'date" + formattedDate+ "_group')]/th[2]/span")).getText();
		return promoWasteCalculationHeader;
	}
	
	public boolean verifyByDefaultDateGroupIsCollapsed(String startDate, String endDate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'waste_date_group')]")));
		int startDay = Base.getDayFromDate(startDate);
		int endDay = Base.getDayFromDate(endDate);
		String month = startDate.split("/")[0];
		String year = startDate.split("/")[2];
		boolean result = true;
		for (int i = startDay; i <= endDay; i++) {
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date =  year+month + day;
			boolean recordIsCollapsed =  driver.findElement(By.xpath("//tr[contains(@class,'date"+date+" ')]")).getAttribute("class").contains("hidden");
			result = result & recordIsCollapsed;
		}
		return result;
	}
	
	public void clickAtAGlanceToggleButton(){
		Base.executeJavaScript("document.getElementById('kpi-container').getElementsByTagName('div')[0].getElementsByTagName('h3')[0].click();");
	}
	
	public PromotionsAndWastePage selectStartDate(String startDate) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(promoWasteHistoryStartDate_TB)).click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	}
	
	public PromotionsAndWastePage selectEndDate(String endDate) throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(promoWasteHistoryEndDate_TB)).click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	}
	
	public boolean verifyStartDateIsDisabled(String startDate) throws InterruptedException{
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		return dateEnabled;
	}
	
	public boolean verifyEndDateIsDisabled(String endDate) throws InterruptedException{
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		return dateEnabled;
	}
	
	public String calculatePromoAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Raw Promo");
	}

	public String calculateWasteAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Raw Waste");
	}
	
	public String calculateCompleteWasteAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Completed waste");
	}
	
	private String calculatePromoWasteAmount(String date, String promoWasteType) throws InterruptedException{
		int day = Base.getDayFromDate(date);
		String month = date.split("/")[0];
		String year = date.split("/")[2];
		String newdate;
		if (day > 0 && day < 10) {
			newdate = "0" + day;
		} else {
			newdate = String.valueOf(day);
		}
		String formattedDate =  year+month + newdate;
		BigDecimal totalPromoWaste = new BigDecimal("0.00");
		List<WebElement> dateList = driver.findElements(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]/td[5]/span[text()='"+promoWasteType+"']"));
		System.out.println("size "+dateList.size());
		for(int i=1;i<= dateList.size();i++){
			String promoWasteAmount = driver.findElement(By.xpath("(//tr[contains(@class,'date"+formattedDate+" ')]/td[5]/span[text()='"+promoWasteType+"']/../following-sibling::td/span[@class='waste_amount'])["+i+"]")).getText();
			BigDecimal promoWasteAmt = new BigDecimal(promoWasteAmount);
			totalPromoWaste = totalPromoWaste.add(promoWasteAmt);
		}
		System.out.println("Total waste "+totalPromoWaste);
		return String.valueOf(totalPromoWaste);
	}
	
	public void clickOnDateGroup(String date) throws InterruptedException{
		String formattedDate =  getFormattedDate(date);
		WebElement dateGroup = driver.findElement(By.xpath("//tr[contains(@class,'date" + formattedDate + "_group')]"));
		Base.scrollToTheElement(dateGroup);
		Thread.sleep(1000);
		dateGroup.click();
		Thread.sleep(1000);
	}
	
	public boolean verifySelectedDateIsExpanded(String date){
		String formattedDate =  getFormattedDate(date);
		boolean recordIsExpanded =  !driver.findElement(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]")).getAttribute("class").contains("hidden");
		return recordIsExpanded;
	}
	
	public boolean verifySelectedDateIsCollapsed(String date){
		String formattedDate =  getFormattedDate(date);
		boolean recordIsCollapsed =  driver.findElement(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]")).getAttribute("class").contains("hidden");
		return recordIsCollapsed;
	}
	
	private String getFormattedDate(String date){
		int day = Base.getDayFromDate(date);
		String month = date.split("/")[0];
		String year = date.split("/")[2];
		String newdate;
		if (day > 0 && day < 10) {
			newdate = "0" + day;
		} else {
			newdate = String.valueOf(day);
		}
		String formattedDate =  year+month + newdate;
		return formattedDate;
		
	}
	
	public void viewPromoEntry(String date) throws InterruptedException {
		viewPromoWasteEntry(date, "Raw Promo");
	}
	
	public void viewWasteEntry(String date) throws InterruptedException {
		viewPromoWasteEntry(date, "Raw Waste");
	}
	
	public void viewCompletedWasteEntry(String date) throws InterruptedException {
		viewPromoWasteEntry(date, "Completed waste");
	}
	
	
	// Verify Raw Waste entry is Present or not
	private void viewPromoWasteEntry(String date, String promoWasteType ) throws InterruptedException {
		String dateformat1 = getFormattedDate(date);
		WebElement promoWasteViewBtn = driver.findElement(By.xpath("//tr[contains(@class,'date"+dateformat1+" ')]/td[5]/span[text()='"+promoWasteType+"']/../following-sibling::td[contains(@class,'view-column')]/eb-button/button"));
		Base.scrollToTheElement(promoWasteViewBtn);
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", promoWasteViewBtn);
		//promoWasteViewBtn.click();
	}
	
	public void viewWasteEntry(String date,String amount) throws InterruptedException {
		viewPromoWasteEntry(date, "Raw Waste",amount);
	}
	
	public void viewPromoEntry(String date,String amount) throws InterruptedException {
		viewPromoWasteEntry(date, "Raw Promo",amount);
	}
	
	// Verify Raw Waste entry is Present or not
	private void viewPromoWasteEntry(String date, String promoWasteType,String amount) throws InterruptedException {
		String dateformat1 = getFormattedDate(date);
		WebElement promoWasteViewBtn = driver.findElement(By.xpath("//tr[contains(@class,'date"+ dateformat1
								+ " ')]/td[5]/span[text()='"+ promoWasteType+ "']/../following-sibling::td[1]/span[text()='"+amount+"']/../following-sibling::td[contains(@class,'view-column')]/eb-button/button"));
		Base.scrollToTheElement(promoWasteViewBtn);
		Thread.sleep(3000);
		executor.executeScript("arguments[0].click();", promoWasteViewBtn);
	}
		
		
}
