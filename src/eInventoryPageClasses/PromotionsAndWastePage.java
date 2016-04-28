package eInventoryPageClasses;

import java.math.BigDecimal;
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
	
	@FindBy(id ="begin_date")
	public WebElement BeginDate_TB;
	
	@FindBy(xpath ="//button[@id='one_month_cal_btn']")
	public WebElement MonthToDate_BT;
	
	@FindBy(xpath ="//button[@id='two_month_cal_btn']")
	public WebElement TwoMonthToDate_BT;
	
	@FindBy(xpath ="//label[@id='daily_label']")
	public WebElement DailyRollup_label;
	
	@FindBy(xpath ="//th[contains(text(),'Date')]")
	public WebElement Date_Coloumn;
	
	@FindBy(xpath ="//th[contains(text(),'Cost')]")
	public WebElement Cost_Coloumn ;

	@FindBy(xpath ="//h5[@id='raw_waste_table_cap']/b[1]")
	public WebElement fromDateHeader_Label ;
	
	@FindBy(xpath ="//h5[@id='raw_waste_table_cap']/b[2]")
	public WebElement toDateHeader_Label ;
	
	@FindBy(xpath ="//button[@id='raw_waste_start_btn']")
	public WebElement wasteHistoryStartDate_BT ;
	
	@FindBy(xpath ="//button[@id='raw_waste_end_btn']")
	public WebElement wasteHistoryEndDate_BT ;
	
	@FindBy(xpath ="//input[@value='Update Table']")
	public WebElement updateTable_BT ;
	
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
	
	@FindBy(xpath ="//h2[text()='Completed Waste']")
	public WebElement CompletedWastePopUp_Title ;
	
	@FindBy(xpath ="//eb-button[@value='Show Results']/button")
	public WebElement ShowResults_BT;

	@FindBy(xpath ="//th[text()='Time of Waste']")
	public WebElement PromotionAndWasteTable_TimeofWaste_Header;
	
	@FindBy(xpath ="//th[text()='Date Entered']")
	public WebElement PromotionAndWasteTable_DateEntered_Header;
	
	@FindBy(xpath ="//th[text()='Time Entered']")
	public WebElement PromotionAndWasteTable_TimeEntered_Header;
	
	@FindBy(xpath ="//th[text()='Entered By']")
	public WebElement PromotionAndWasteTable_EnteredBy_Header;
	
	@FindBy(xpath ="//th[text()='Type']")
	public WebElement PromotionAndWasteTable_Type_Header;
	
	@FindBy(xpath ="//th[text()='Amount']")
	public WebElement PromotionAndWasteTable_Amount_Header;
	
	@FindBy(xpath ="//div[@id='kpi-container']/div[1]")
	public WebElement AtAGlance_Expand_Icon;
	
	@FindBy(xpath ="//div[@id='kpi-header']/h2[text()='Current Day Activity']")
	public WebElement AtAGlance_Header;
	
	@FindBy(xpath ="//h5[text()='Raw Item Activity']")
	public WebElement AtAGlance_RawItemActivity_Label;
	
	@FindBy(xpath ="//h6[contains(.,'Current day as of')]")
	public WebElement AtAGlance_CurrentDayAsOf_Label;
	
	@FindBy(xpath ="//th[contains(.,'Top Raw Items Wasted')]")
	public WebElement AtAGlance_TopRawItemWasted_Column_header;
	
	@FindBy(xpath ="//th[contains(.,'Top Raw Items Promo')]")
	public WebElement AtAGlance_TopRawItemsPromo_Column_header;
	
	@FindBy(xpath ="//th[contains(.,'Top Completed Waste')]")
	public WebElement AtAGlance_TopCompletedWaste_Column_header;
	
	@FindBy(xpath ="//tr[contains(@class,'waste_date_group')]")
	public List<WebElement> WasteRecordsList;
	
	@FindBy(xpath ="//h2[text()='Waste']")
	public WebElement ViewWasteForm_Title;
	
	@FindBy(xpath ="//h2[text()='Promo']")
	public WebElement ViewPromoForm_Title;
	
	@FindBy(xpath ="//h2[text()='Completd Waste']")
	public WebElement ViewCompletedWasteForm_Title;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/tfoot//td/b[text()='Total: ']")
	public WebElement wasteDetail_Total_Label ;
	
	@FindBy(xpath ="//div[@id='waste_hist_detail_data']/table/tfoot//td/b[2]")
	public WebElement wasteDetail_Total_Value ;
	
	@FindBy(xpath ="//tbody[@id='waste_hist_detail_table_body']/tr")
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
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/tfoot//td/b[text()='Total: ']")
	public WebElement CompletedWasteDetail_Total_Label ;
	
	@FindBy(xpath ="//div[@id='comp_waste_hist_detail_data']/table/tfoot//td/b[2]")
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
	
	//double click on the First row of todays date in daily roll up table
	
	public RawItemWastePage doubleClickOnFirstTodayDateRecordInDailyRollupTable()
	{
		wait.until(ExpectedConditions.visibilityOf(PromotionAndWaste_Title));
		int size=driver.findElements(By.xpath("//table[@id='raw_history_tbl']/tbody/tr")).size();
		for(int i=1;i<=size;i++)
		{
			String todayDate=getCurrentDateinMMDDYYYY();
			if(driver.findElement(By.xpath("//table[@id='raw_history_tbl']/tbody/tr["+i+"]/td[1]")).getText().trim().equalsIgnoreCase(todayDate))
			{
				action.moveToElement(driver.findElement(By.xpath("//table[@id='raw_history_tbl']/tbody/tr["+i+"]/td[1]"))).doubleClick().build().perform();
			}
			
		}
	
		return PageFactory.initElements(driver, RawItemWastePage.class);
		
	}
	
	//Verify Raw Waste entry is Present or not
	public boolean isRawWasteEntryPresent(String date, String amount) {
		String dateformat1 = getFormattedDate(date);
		String enteredDate = Base.returnTodayDate();
		String month = enteredDate.split("/")[0];
		String day = enteredDate.split("/")[1];
		String year = enteredDate.split("/")[2];
		String dateformat2 =  month+"/" + day+"/"+year;//  12-08-2015
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Waste']/../following-sibling::td/span[text()='"+amount+"']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Waste']/../following-sibling::td/span[text()='"+amount+"']")).size();
		if (size >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	//Verify Completed Waste entry is Present or not
	public boolean isCompletedWasteEntryPresent(String date, String amount) {
		String dateformat1 = getFormattedDate(date);
		String enteredDate = Base.returnTodayDate();
		String month = enteredDate.split("/")[0];
		String day = enteredDate.split("/")[1];
		String year = enteredDate.split("/")[2];
		String dateformat2 =  month+"/" + day+"/"+year;
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Completed waste']/../following-sibling::td/span[text()='"+amount+"']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Completed waste']/../following-sibling::td/span[text()='"+amount+"']")).size();
		if (size >= 1) {
			return true;
		} else {
			return false;
		}
	}
	// Verify Raw Promo entry is Present or not
	public boolean isRawPromoEntryPresent(String date, String amount)throws InterruptedException {
		String dateformat1 = getFormattedDate(date);
		String enteredDate = Base.returnTodayDate();
		String month = enteredDate.split("/")[0];
		String day = enteredDate.split("/")[1];
		String year = enteredDate.split("/")[2];
		String dateformat2 =  month+"/" + day+"/"+year;
		System.out.println("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Promo']/../following-sibling::td/span[text()='"+amount+"']");
		int size = driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[text()='"+dateformat2+"']/../following-sibling::td/span[text()='Promo']/../following-sibling::td/span[text()='"+amount+"']")).size();
		if (size >= 1) {
			System.out.println("true");
			return true;
		} else {
			return false;
		}
	}
		
		/* @Author :Hemlata
		 * This method will take start date and end date as input in MM/DD/YYYY format and select start date and end date 
		from the calendar present in raw waste and promo landing page*/
		public void selectStartAndEndDateForWasteHistory(String startDate,String endDate) throws InterruptedException{
			int month1 = Base.getMonthFromDate(startDate);
			int date1 = Base.getDayFromDate(startDate);
			int month2 = Base.getMonthFromDate(endDate);
			int date2 = Base.getDayFromDate(endDate);
			promoWasteHistoryStartDate_TB.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month1+"']/div[text()='"+date1+"']")).click();
			promoWasteHistoryEndDate_TB.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month2+"']/div[text()='"+date2+"']")).click();
			
		}
		
		/*Author :Hemlata 
		This method will take date in yyyymmdd format and verify Expand And Collapse Functionality For that Date Group records */
		public boolean verifyExpandAndCollapseFunctionalityForDateGroup(String date) {
			//get the header element for the given date group
			WebElement dateGroup1 = driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+ date + "_group')]"));
			/*//get the raw waste amount from header
			String rawWasteAmt = driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+ date + "_group')]/td/div[@class='waste_day_totals']/b")).getText();
			//get the promo amount from header
			String promoAmt = dateGroup1.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr[contains(@class,'date"+ date + "_group')]/td/div[@class='promo_day_totals']/b")).getText();
			// if raw waste amount and promo amount will be $0.00 for passed date group than NO RAW WASTE label will be displayed in table
			if (rawWasteAmt.equals("Raw waste: $0.00") && promoAmt.equals("Raw promo: $0.00")) {
				String noRawWasteMsg = driver.findElement(By.xpath("//tr[contains(@class,'date" + date + " ')]")).getAttribute("class");
				//if 'NO RAW WASTE label' is hidden than expand the header and verify that label is displayed
				if (noRawWasteMsg.contains("hidden")) {
					dateGroup1.click();
					String noRawWaste = driver.findElement(By.xpath("//tr[contains(@class,'date" + date+ " ')]/td[3]")).getText();
					return noRawWaste.equals("NO RAW WASTE");
				} //else click on the header and verify that label is hidden now
				else {
					dateGroup1.click();
					return (!noRawWasteMsg.contains("hidden"));

				}
			} 
			// if raw waste amount or promo amount is not 0.00 for passed date group than records will be displayed in table
			else {*/
				//get the record list from the table for passed date group
				List<WebElement> historyRecordsList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
				//If the records are hidden by default view that click on the header and verify that records are displayed
				if(historyRecordsList.get(0).getAttribute("class").contains("hidden")){
					boolean toggle = true;
					dateGroup1.click();
					for (int a = 0; a < historyRecordsList.size(); a++) {
						toggle = toggle && (!historyRecordsList.get(a).getAttribute("class").contains("hidden"));
				}
					return toggle;
				} 
				//If the records are expanded by default view that click on the header and verify that records are hidden
				else {
					boolean toggle = true;
					dateGroup1.click();
					for (int a = 0; a < historyRecordsList.size(); a++) {
						toggle = toggle && (historyRecordsList.get(a).getAttribute("class").contains("hidden"));
					}
					return toggle;
					}
				}
			/*}*/
		
	/*
	 * @Author :Hemlata This method will take date in yyyymmdd format and click
	 * on the first record for that date group
	 */
	public void clickOnFirstRecordOfADateGroup(String date) {
		
		
		int size=Record_Expend_Button_List.size();
		for(int i=1;i<=size;i++)
		{
		// get the raw waste amount from header
		String rawWasteAmt = driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr["+i+"]/td/b/div[2]")).getText();
		// get the promo amount from header
		String promoAmt = driver
				.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr["+i+"]/td/b/div[3]")).getText();
		// if raw waste amount and promo amount is not $0.00 for passed date group than click on the first record
		if (!(rawWasteAmt.trim().equalsIgnoreCase("Raw waste: $0.00,") && promoAmt.trim().equalsIgnoreCase("Raw promo: $0.00,"))) 
		{
			Record_Expend_Button_List.get(i-2).click();
			driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr["+(i+1)+"]/td[1]")).click();
			break;
			/*WebElement historyRecord = driver.findElement(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
			// if record is hidden than first expand the date group header and than click on the first record
			if (historyRecord.getAttribute("class").contains("hidden")) {
				dateGroup1.click();
				historyRecord.click();
			} else {
				historyRecord.click();
			}*/
		}
		else
		{
			i=i+1;
		}
	}

}
	
	public boolean verifyRecordsAreCollapsed(){
		boolean toggle=true;
		List<WebElement>wasteHistoryList = driver.findElements(By.xpath("//tr[contains(@class,'waste_date_group')]/following-sibling::tr[@role='row']"));
		for(WebElement wasteItem : wasteHistoryList){
			toggle = toggle && wasteItem.getAttribute("class").contains("hidden");
		}
		return toggle;
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
	
	public String getPromoWasteAmountFromDateGroupHeader(String date){
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
		promoWasteHistoryStartDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),4);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[4]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	}
	
	public PromotionsAndWastePage selectEndDate(String endDate) throws InterruptedException{
		promoWasteHistoryEndDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),5);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[5]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	}
	
	/*public PromotionsAndWastePage selectMonthFromDatePicker(String monthName,int calIndex){
		String selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[1]/span")).getText();
		while (!selectedMonth.equals(monthName)) {
			driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/button[@class='xdsoft_prev']")).click();
			selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[contains(@class,'xdsoft_month')]/span")).getText();
			System.out.println("monthName found "+selectedMonth);
		}
		return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	}*/
	
	public boolean verifyStartDateIsDisabled(String startDate){
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),4);
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[4]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		return dateEnabled;
	}
	
	public boolean verifyEndDateIsDisabled(String endDate){
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),5);
		boolean dateEnabled = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[5]//tbody/tr//td[@data-month='"+month+"' and @data-date='"+day+"']")).getAttribute("class").contains("xdsoft_disabled");
		return dateEnabled;
	}
	
	public String calculatePromoAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Promo");
	}

	public String calculateWasteAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Waste");
	}
	
	public String calculateCompleteWasteAmountForSelectedDate(String date) throws InterruptedException{
		return calculatePromoWasteAmount(date, "Completed waste");
	}
	
	public String calculatePromoWasteAmount(String date, String promoWasteType) throws InterruptedException{
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
	
	public String getFormattedDate(String date){
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
		viewPromoWasteEntry(date, "Promo");
	}
	
	public void viewWasteEntry(String date) throws InterruptedException {
		viewPromoWasteEntry(date, "Waste");
	}
	
	public void viewCompletedWasteEntry(String date) throws InterruptedException {
		viewPromoWasteEntry(date, "Completed waste");
	}
	
	
	// Verify Raw Waste entry is Present or not
	public void viewPromoWasteEntry(String date, String promoWasteType ) throws InterruptedException {
		String dateformat1 = getFormattedDate(date);
		WebElement promoWasteViewBtn = driver.findElement(By.xpath("//tr[contains(@class,'date"+dateformat1+" ')]/td[5]/span[text()='"+promoWasteType+"']/../following-sibling::td[contains(@class,' view-column')]/eb-button/button"));
		Base.scrollToTheElement(promoWasteViewBtn);
		Thread.sleep(3000);
		promoWasteViewBtn.click();
	}
		
		
}
