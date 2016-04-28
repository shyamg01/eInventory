package eInventoryPageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;

public class MenuItemActivityAndInformationPage extends AbstractPage
{

	public MenuItemActivityAndInformationPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath ="//h1[text()='Menu Item Information & Activity']")
	public WebElement MenuItemActivityAndInformation_Title;
	
	@FindBy(xpath = "//label[contains(@class,'autosearch')]")
	public WebElement MenuItemSearchBox_Label;
	
	@FindBy(xpath = "//input[contains(@id,'autosearchInput')]")
	public WebElement MenuItemSearchBox_TB;
	
	@FindBy(xpath = "//span[@id='mia-selected-item']")
	public WebElement SelectItem_Value;
	
	@FindBy(xpath = "//label[contains(text(),'Start Date:')]")
	public WebElement MiaStartDate_Label;
	
	@FindBy(xpath = "//input[@id='menu_item_history_start_date']")
	public WebElement MiaStartDate_TB;
	
	@FindBy(xpath = "//label[contains(text(),'End Date: ')]")
	public WebElement MiaEndDate_Label;
	
	@FindBy(xpath = "//input[@id='menu_item_history_end_date']")
	public WebElement MiaEndDate_TB;
	
	@FindBy(xpath = "(//div[@id='eb_tp_input'])[1]/span[@id='eb_tp_span']")
	public WebElement StartTime_TB;
	
	@FindBy(xpath = "(//div[@id='eb_tp_input'])[2]/span[@id='eb_tp_span']")
	public WebElement EndTime_TB;
	
	@FindBy(xpath = "(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span'])[1]")
	public WebElement StartTime_hourSpan_Value;
	
	@FindBy(xpath = "(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span'])[1]")
	public WebElement StartTime_MinSpan_Value;
	
	@FindBy(xpath = "(//div[@id='eb_tp_hr_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_hr_span'])[2]")
	public WebElement EndTime_hourSpan_Value;
	
	@FindBy(xpath = "(//div[@id='eb_tp_min_control']/div[contains(@class,'eb_tp_hr_min')]/span[@id='eb_tp_min_span'])[2]")
	public WebElement EndTime_MinSpan_Value;
	
	@FindBy(xpath = "//eb-multiselect-dropdown[@id='register_list_select']")
	public WebElement RegisterFilter_DD;
	
	@FindBy(xpath = "//eb-multiselect-dropdown[@id='employee_list_select']")
	public WebElement EmployeeFilter_DD;
	
	@FindBy(xpath = "//button[@value='Show Results']")
	public WebElement ShowResults_BT;
	
	@FindBy(xpath = "//table[@id='mia_table']")
	public WebElement MenuItemActivity_Table;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Date & Time']")
	public WebElement MenuItemActivityTable_DateTime_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Activity']")
	public WebElement MenuItemActivityTable_Activity_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Sold']")
	public WebElement MenuItemActivityTable_Sold_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Employee Meal']")
	public WebElement MenuItemActivityTable_EmpMeal_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Manager Meal']")
	public WebElement MenuItemActivityTable_MgrMeal_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Waste']")
	public WebElement MenuItemActivityTable_Waste_Header;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table/thead/tr/th[text()='Promo']")
	public WebElement MenuItemActivityTable_Promo_Header;
	
	/***********************Menu Item Information*********************/
	@FindBy(xpath = "//button[@value='Information']")
	public WebElement Information_BT;
	
	@FindBy(xpath = "//h2[text()='Menu Item Information']")
	public WebElement MenuItemInformation_PopUp_Title;
	
	@FindBy(xpath = "//thead[@id='mia-info-top-table-thead']/tr/th[text()='Menu Item No.']")
	public WebElement MenuItemInformation_Table_MenuItemNumberHeader;
	
	@FindBy(xpath = "//thead[@id='mia-info-top-table-thead']/tr/th[text()='Description']")
	public WebElement MenuItemInformation_Table_DescriptionHeader;
	
	@FindBy(xpath = "//thead[@id='mia-info-top-table-thead']/tr/th[text()='On POS']")
	public WebElement MenuItemInformation_Table_OnPOSHeader;
	
	@FindBy(xpath = "//thead[@id='mia-info-top-table-thead']/tr/th[text()='Daypart Code']")
	public WebElement MenuItemInformation_Table_DaypartCodeHeader;
	
	@FindBy(xpath = "//thead[@id='mia-info-top-table-thead']/tr/th[text()='Family Group']")
	public WebElement MenuItemInformation_Table_FamilyGroupHeader;
	
	@FindBy(xpath = "//button[contains(@id,'mia-info-recipe-btn')]/i[1]")
	public WebElement MenuItemInformation_Receipe_Expand_BT;
	
	@FindBy(xpath = "//button[contains(@id,'mia-info-recipe-btn')]/i[2]")
	public WebElement MenuItemInformation_Receipe_Collapse_BT;
	
	@FindBy(xpath = "//button[contains(@id,'mia-info-historic-recipe-btn')]/i[1]")
	public WebElement MenuItemInformation_HistoricReceipe_Expand_BT;
	
	@FindBy(xpath = "//button[contains(@id,'mia-info-historic-recipe-btn')]/i[2]")
	public WebElement MenuItemInformation_HistoricReceipe_Collpse_BT;
	
	@FindBy(xpath = "//span[contains(@class,'recipe_effective_date')]")
	public WebElement MenuItemInformation_ReceipeEffectiveDate_Value;
	
	@FindBy(xpath = "//table[contains(@class,'mia-recipe-table')]")
	public WebElement MenuItemInformation_Receipe_Table;
	
	@FindBy(xpath = "//table[contains(@class,'mia-recipe-table')]/thead/tr/th[text()='WRIN']")
	public WebElement MenuItemInformation_ReceipeTable_WRINHeader;
	
	@FindBy(xpath = "//table[contains(@class,'mia-recipe-table')]/thead/tr/th[text()='Description']")
	public WebElement MenuItemInformation_ReceipeTable_DescriptionHeader;
	
	@FindBy(xpath = "//table[contains(@class,'mia-recipe-table')]/thead/tr/th[text()='Serving Factor']")
	public WebElement MenuItemInformation_ReceipeTable_ServingFactorHeader;
	
	@FindBy(xpath = "//table[contains(@class,'mia-recipe-table')]/tbody/tr")
	public List<WebElement> MenuItemInformation_ReceipeTable_ItemList;
	
	@FindBy(xpath = "//div[contains(@id,'mia-info-historic-recipe-table')]")
	public WebElement MenuItemInformation_HistoricReceipe_Table;
	
	@FindBy(xpath = "(//div[contains(@class,'slider-close')]/i[@id='modalToggle'])[1]")
	public WebElement MenuItemInformation_SliderToggle_BT;
	
	@FindBy(xpath = "//eb-modal[@id='mia-info-modal']/div[contains(@class,'container')]")
	public WebElement MenuItemInformation_Container;
	
	@FindBy(xpath = "//eb-modal[@id='mia-info-modal']/div[contains(@class,'container')]/div[@id='header-row']/div[contains(@class,'modal-close')]")
	public WebElement MenuItemInformation_Close_BT;
	
	/*********************KPI Screen**************************/
	@FindBy(xpath = "//div[contains(@class,'kpi-toggle-btn')]")
	public WebElement Kpi_Toggle_BT;
	
	@FindBy(xpath = "//div[@id='kpi-body-header']/h5[text()='Menu Item Activity']")
	public WebElement Kpi_Model_Header;
	
	@FindBy(xpath = "//div[@id='kpi-body-header']/h6[contains(text(),'Current day as of')]")
	public WebElement Kpi_Model_SubHeader;
	
	@FindBy(xpath = "//div[@id='kpi-container']")
	public WebElement Kpi_Model_Container;
	
	@FindBy(xpath = "//table[@id='top_menu_items_employee_meals']")
	public WebElement KpiModel_TopMenuItemsEmployeeMeals_Table;
	
	@FindBy(xpath = "//table[@id='top_menu_items_wasted']")
	public WebElement KpiModel_TopMenuItemsWasted_Table;
	
	@FindBy(xpath = "(//table[@id='top_promo_items_wasted'])[1]")
	public WebElement KpiModel_TopMenuItemsPromo_Table;
	
	@FindBy(xpath = "(//table[@id='top_promo_items_wasted'])[2]")
	public WebElement KpiModel_TopMenuItemsManagerMeals_Table;
	
	/*
	 * This method will take WRIN Id as argument and search the the WRIN Id in Menu Item Activity Page
	 */

	public MenuItemActivityAndInformationPage searchAndSelectMenuItem(String menuItem)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(MenuItemSearchBox_TB));
		MenuItemSearchBox_TB.clear();
		MenuItemSearchBox_TB.sendKeys(menuItem);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		driver.findElement(By.xpath("(//strong[text()='" + menuItem + "'])[1]")).click();
		return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);

	}
	
	public MenuItemActivityAndInformationPage selectStartDate(String startDate) throws InterruptedException{
		MiaStartDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(startDate);
		int month = Base.getMonthFromDate(startDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);
	}
	
	public MenuItemActivityAndInformationPage selectEndDate(String endDate) throws InterruptedException{
		MiaEndDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(endDate);
		int month = Base.getMonthFromDate(endDate);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);
	}
	
	//This method will verify that a date is selected for Start Date field
	public boolean verifyDateIsSelectedForStartDate(String date) {
		System.out.println("Start Date "+MiaStartDate_TB.getAttribute("value"));
		if (MiaStartDate_TB.getAttribute("value").equals(date))
			return true;
		else
			return false;

	}
	//This method will verify that a date is selected for End Date field
	public boolean verifyDateIsSelectedForEndDate(String date) {
		System.out.println("end Date "+MiaEndDate_TB.getAttribute("value"));
		if (MiaEndDate_TB.getAttribute("value").equals(date))
			return true;
		else
			return false;

	}
	
	//This method will verify that future date is disabled for Start Date field
	public boolean verifyFutureDateIsDisabledForStartDate(String date) {
		int month = Base.getMonthFromDate(date);
		int day = Base.getDayFromDate(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='xdsoft_calendar'])[1]")));
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		String dateClass = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+ month + "' and @data-date='" + day + "']")).getAttribute("class");
		if (dateClass.contains("xdsoft_disabled"))
			return true;
		else
			return false;

	}
	
	//This method will verify that future date is disabled for End Date field	
	public boolean verifyFutureDateIsDisabledForEndDate(String date) {
		int month = Base.getMonthFromDate(date);
		int day = Base.getDayFromDate(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='xdsoft_calendar'])[2]")));
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		String dateClass = driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]//tbody/tr//td[@data-month='"+ month + "' and @data-date='" + day + "']")).getAttribute("class");
		if (dateClass.contains("xdsoft_disabled"))
			return true;
		else
			return false;

	}
	
	// This method will click on the Start time button and enter the time for Start Time
	public MenuItemActivityAndInformationPage selectStartTime(String startTime)throws InterruptedException {
		StartTime_TB.click();
		Thread.sleep(1000);
		String hourValue = startTime.split(":")[0];
		while(!StartTime_hourSpan_Value.getText().equals(hourValue)){
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[0].click();");
		}
		//StartTime_hourSpan_Value.click();
		String minuteValue = startTime.split(":")[1];
		while(!StartTime_MinSpan_Value.getText().equals(minuteValue)){
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[1].click();");
		}
		StartTime_TB.click();
		return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);
	}
	
	// This method will click on the end time button and enter the time for End Time
	public MenuItemActivityAndInformationPage selectEndTime(String time) throws InterruptedException {
		EndTime_TB.click();
		Thread.sleep(1000);
		String hourValue = time.split(":")[0];
		while (!EndTime_hourSpan_Value.getText().equals(hourValue)) {
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[2].click();");
		}
		//EndTime_hourSpan_Value.click();
		String minuteValue = time.split(":")[1];
		while (!EndTime_MinSpan_Value.getText().equals(minuteValue)) {
			Base.executeJavaScript("document.getElementsByClassName('eb_tp_time_up style-scope eb-timepicker')[3].click();");
		}
		EndTime_TB.click();
		return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);
	}
	
	
	//This method will verify that menu item activity search results will be displayed for the selected date and time range
	public boolean verifyMenuActivityTimeForSelectedDateRange(String startdate,String endDate, String startTime,String endTime) throws InterruptedException{
		Thread.sleep(5000);
		int startDay =  Base.getDayFromDate(startdate);
		int endDay =  Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean timeRangeMatched = true;
		for(int i = startDay; i <= endDay; i++){
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day+ year ;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'date"+date+"_group')]")));
			String timeDuration = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[1]/span[@class='mia-long-date-time']")).getText();
			String selectedTime = timeDuration.split("\\|")[1];
			String startTimeInRecord = selectedTime.split(" to ")[0].trim();
			String EndTimeInRecord = selectedTime.split(" to ")[1].trim();
			timeRangeMatched = startTime.equals(startTimeInRecord);
			timeRangeMatched = timeRangeMatched && endTime.equals(EndTimeInRecord);
		}
		return timeRangeMatched;
	}
	
	//This method will verify that Sold value for a menu item will be displayed in menu Item Activity Search Results for selected date and Time Range 
	public boolean verifySoldValueForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException{
		Thread.sleep(5000);
		int startDay =  Base.getDayFromDate(startdate);
		int endDay =  Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean soldValueFound = true;
		for(int i = startDay; i <= endDay; i++){
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			String soldValue = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[3]/div")).getText();
			soldValueFound = soldValueFound && (! soldValue.isEmpty());
		}
		return soldValueFound;
	}
	
	//This method will verify that Waste value for a menu item will be displayed in menu Item Activity Search Results for selected date and Time Range
	public boolean verifyWasteValueForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException{
		Thread.sleep(5000);
		int startDay =  Base.getDayFromDate(startdate);
		int endDay =  Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean wasteValueFound = true;
		for(int i = startDay; i <= endDay; i++){
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			String wasteValue = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[6]/div")).getText();
			wasteValueFound = wasteValueFound && (! wasteValue.isEmpty());
			
		}
		return wasteValueFound;		
	}
	//This method will verify that Promo value for a menu item will be displayed in menu Item Activity Search Results for selected date and Time Range
	public boolean verifyPromoValueForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException{
		Thread.sleep(5000);
		int startDay =  Base.getDayFromDate(startdate);
		int endDay =  Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean promoValueFound = true;
		for(int i = startDay; i <= endDay; i++){
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			String promoValue = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[7]/div")).getText();
			promoValueFound = promoValueFound && (! promoValue.isEmpty());
		}
		return promoValueFound;
		
	}
	
	// This method will verify that EmpMeal value for a menu item will be displayed in menu Item Activity Search Results for selected date and Time Range
	public boolean verifyEmpMealValueForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException {
		Thread.sleep(5000);
		int startDay = Base.getDayFromDate(startdate);
		int endDay = Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean empMealValueFound = true;
		for (int i = startDay; i <= endDay; i++) {
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			String empMealValue = driver.findElement(By.xpath("//tr[contains(@class,'date" + date+ "_group')]/th[4]/div")).getText();
			empMealValueFound = empMealValueFound && (!empMealValue.isEmpty());
		}
		return empMealValueFound;

	}

	// This method will verify that Mgr Meal value for a menu item will be displayed in menu Item Activity Search Results for selected date and Time Range
	public boolean verifyMgrMealValueForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException {
		Thread.sleep(5000);
		int startDay = Base.getDayFromDate(startdate);
		int endDay = Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean mgrMealValueFound = true;
		for (int i = startDay; i <= endDay; i++) {
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			String mgrMealValue = driver.findElement(By.xpath("//tr[contains(@class,'date" + date+ "_group')]/th[5]/div")).getText();
			mgrMealValueFound = mgrMealValueFound && (!mgrMealValue.isEmpty());
		}
		return mgrMealValueFound;

	}
	
	/*This method will verify that Activity value for a menu item will be displayed in menu Item Activity Search Results 
	for selected date and Time Range and verify that Activity=Sold+Emp meal+Mgr meal+Waste+Promo*/
	public boolean verifyPOSActivityForMenuItemDisplayed(String startdate,String endDate) throws InterruptedException{
		Thread.sleep(5000);
		int startDay =  Base.getDayFromDate(startdate);
		int endDay =  Base.getDayFromDate(endDate);
		String month = startdate.split("/")[0];
		String year = startdate.split("/")[2];
		boolean activityValueFound = true;
		for(int i = startDay; i <= endDay; i++){
			String day;
			if (i > 0 && i < 10) {
				day = "0" + i;
			} else {
				day = String.valueOf(i);
			}
			String date = month + day + year;
			int POSActivityValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[2]/div")).getText());
			int soldValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[3]/div")).getText());
			int empMealValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[4]/div")).getText());
			int mgrMealValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[5]/div")).getText());
			int wasteValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[6]/div")).getText());
			int promoValue = Integer.parseInt(driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[7]/div")).getText());			
			boolean activityCalculationResult = (POSActivityValue == soldValue + empMealValue + mgrMealValue + wasteValue + promoValue);
			activityValueFound = activityValueFound && activityCalculationResult;
		}
		return activityValueFound;
		
	}
	
	//Expand the menu item activity for a date group
	public void expandDateGroup() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordGroupList = driver.findElements(By.xpath("//tr[contains(@class,'tableGroupHead')]"));
		for (int i = 1; i <= miaRecordGroupList.size(); i++) {
			try {
				driver.findElement(By.xpath("(//tr[contains(@class,'tableGroupHead')])["+ i + "]/th/span[1]")).click();
				Base.toReachbottomOfthePage();
			} catch (Exception e) {
				Base.toReachbottomOfthePage();
			}
			Thread.sleep(4000);
		}
	}
		
	//Expand the menu item activity for a date group
	/*public void expandDateGroup() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordGroupList = driver.findElements(By.xpath("//tr[contains(@class,'tableGroupHead')]"));
		for (int i = 1; i <= miaRecordGroupList.size(); i++) {
			Base.toReachbottomOfthePage();
			driver.findElement(By.xpath("(//tr[contains(@class,'tableGroupHead')])[" + i+ "]/td/img[@class='mia-chevron-down']")).click();
			;
			Thread.sleep(1000);
		}
	}*/
	
	// Expand the menu item activity for a date group
	public void collapseDateGroup() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordGroupList = driver.findElements(By.xpath("//tr[contains(@class,'tableGroupHead')]"));
		for (int i = 1; i <= miaRecordGroupList.size(); i++) {
			driver.findElement(By.xpath("(//tr[contains(@class,'tableGroupHead')])["+ i + "]/th/span[2]")).click();
			Thread.sleep(1000);
		}
	}
	
	//This method will verify that menu activity should be displayed in detail with 15 minutes time span for a selected date and selected time range
	//It will take date argument as MM/DD/YYYY format or YYYYMMDD format
	public boolean verifyMenuActivityTimeInDetailForSelectedDate(String date, String startTime,String endTime){
		if (date.contains("/")) {
			date = getDateInMMDDYYYYFormat(date);
		}
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int j;
		boolean result = true;
		for(int i=1;i<=miaRecordList.size();i++){
			String timeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[1]")).getText();
			String startTimeInRecord = timeSpan.split(" to ")[0].trim();
			String EndTimeInRecord = timeSpan.split(" to ")[1].trim();
			int hour = Base.getHourFromTime(EndTimeInRecord);
			int minute = Base.getMinuteFromTime(EndTimeInRecord);
			String timeSlice = Base.get15MinuteTimeSlice(hour, minute);
			result = result && timeSlice.equals(startTimeInRecord);
			if (i < miaRecordList.size()) {
				j = i + 1;
				timeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date+ " ')])[" + j + "]/td[1]")).getText();
				String EndTimeInNextRecord = timeSpan.split(" to ")[1].trim();
				System.out.println("startTimeInRecord "+ startTimeInRecord);
				System.out.println("EndTimeInNextRecord "+ EndTimeInNextRecord);
				result = result && startTimeInRecord.equals(EndTimeInNextRecord);
			}
		}
		System.out.println("Result "+result);
		return result;
		
	}
	
	// This method will verify that menu activity should be displayed in detail with 15 minutes time span for each date and selected time range
	public boolean verifyMenuActivityTimeInDetailForEachDate(String startTime, String endTime) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordGroupList = driver.findElements(By.xpath("//tr[contains(@class,'tableGroupHead')]"));
		boolean result = true;
		for(WebElement miaRecordGroup : miaRecordGroupList){
			String date =  miaRecordGroup.getAttribute("class").split(" date")[1].split("_")[0];
			result = result && verifyMenuActivityTimeInDetailForSelectedDate(date, startTime, endTime);
		}
		return result;
	}
	
	// This method will verify that menu activity should be displayed in detail with 15 minutes time span for a selected date and selected time range
	public boolean verifyMenuActivityDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String miaForTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[2]")).getText();
			result = result	&& (!miaForTimeSpan.isEmpty());
			}
		return result;
		}
	
	// This method will verify that total menu items sold for a date in 15 min time slice should be displayed
	public boolean verifySoldMenuItemDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String menuItemSoldInTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[3]")).getText();
			result = result && (!menuItemSoldInTimeSpan.isEmpty());
		}
		return result;
	}
	
	// This method will verify that total menu items sold for a date in 15 min time slice should be displayed
	public boolean verifyEmployeeMealDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String menuItemSoldInTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[4]")).getText();
			result = result && (!menuItemSoldInTimeSpan.isEmpty());
		}
		return result;
	}
	
	// This method will verify that total menu items sold for a date in 15 min time slice should be displayed
	public boolean verifyManagerMealDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String menuItemSoldInTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[5]")).getText();
			result = result && (!menuItemSoldInTimeSpan.isEmpty());
		}
		return result;
	}
	
	// This method will verify that waste menu items sold for a date in 15 min time slice should be displayed
	public boolean verifyWasteItemDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String wasteItemInTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[6]")).getText();
			result = result && (!wasteItemInTimeSpan.isEmpty());
		}
		return result;
	}
	
	// This method will verify that menu item Promo should be displayed for a date in 15 min time slice 
	public boolean verifyMenuItemPromoDisplayedFor15MinTimeSlice(String date) {
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date" + date + " ')]"));
		boolean result = true;
		for (int i = 1; i <= miaRecordList.size(); i++) {
			String menuItemPromoInTimeSpan = driver.findElement(By.xpath("(//tr[contains(@class,'date" + date + " ')])["+ i + "]/td[7]")).getText();
			result = result && (!menuItemPromoInTimeSpan.isEmpty());
		}
		return result;
	}
	
	public String getDateInMMDDYYYYFormat(String date){
		String month = date.split("/")[0];
		String day = date.split("/")[1];
		String year = date.split("/")[2];
		String formattedDate = month + day +year;
		return formattedDate;
		
	}
	
	public boolean verifyHistoricReciopesTableHeaderDIsplayed(){
		boolean result = driver.findElement(By.xpath(".//div[@id='mia-info-historic-recipe-table']/table/thead/tr/th[@class='mia-info-table-header-title']")).isDisplayed();
		System.out.println("Header title displayed "+ result);
		result = result & driver.findElement(By.xpath(".//div[@id='mia-info-historic-recipe-table']/table/thead/tr/th[@class='mia-wrin-column']")).isDisplayed();
		System.out.println("Wrin column displayed "+ result);
		result = result & driver.findElement(By.xpath(".//div[@id='mia-info-historic-recipe-table']/table/thead/tr/th[@class='mia-desc-column']")).isDisplayed();
		System.out.println("Description column displayed "+ result);
		return result;
	}
	
	public boolean verifyRecordsAreCollapsed(){
		List<WebElement> activityList = driver.findElements(By.xpath("//table[@id='mia_table']/tbody/tr[contains(@class,'odd') or contains(@class,'even')]"));
		boolean result = true;
		for(WebElement activity : activityList){
			result = result & activity.getAttribute("class").contains("hidden");
		}
		return result;
	}
	
	public boolean verifyRecordsAreExpanded(){
		List<WebElement> activityList = driver.findElements(By.xpath("//table[@id='mia_table']/tbody/tr[contains(@class,'odd') or contains(@class,'even')]"));
		boolean result = true;
		for(WebElement activity : activityList){
			result = result & !activity.getAttribute("class").contains("hidden");
		}
		return result;
	}
	
	public int calculateTotalActivityForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'tableGroupHead')]")));
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int  activityCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String activity = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[2]")).getText();
			activityCount = activityCount + Integer.parseInt(activity);
		}
		System.out.println("Result "+activityCount);
		return activityCount;
	}
	
	public int getActivityTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String activityTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[2]/div")).getText();
		return Integer.parseInt(activityTotal);
	}
	
	public int calculateTotalSoldForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int  soldCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String sold = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[3]")).getText();
			soldCount = soldCount + Integer.parseInt(sold);
		}
		System.out.println("Result "+soldCount);
		return soldCount;
	}
	
	public int getSoldTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String soldTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]//th[3]/div")).getText();
		return Integer.parseInt(soldTotal);
	}
	
	public int calculateTotalEmpMealForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int empMealCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String empMeal = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[4]")).getText();
			empMealCount = empMealCount + Integer.parseInt(empMeal);
		}
		System.out.println("Result "+empMealCount);
		return empMealCount;
	}
	
	public int getEmpMealTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String empMealTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]//th[4]/div")).getText();
		return Integer.parseInt(empMealTotal);
	}
	
	public int calculateTotalMgrMealForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int mgrMealCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String mgrMeal = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[5]")).getText();
			mgrMealCount = mgrMealCount + Integer.parseInt(mgrMeal);
		}
		System.out.println("Result "+mgrMealCount);
		return mgrMealCount;
	}
	
	public int getMgrMealTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String mgrMealTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[5]/div")).getText();
		return Integer.parseInt(mgrMealTotal);
	}
	
	public int calculateTotalWasteForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int wasteCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String waste = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[6]")).getText();
			wasteCount = wasteCount + Integer.parseInt(waste);
		}
		System.out.println("Result "+wasteCount);
		return wasteCount;
	}
	
	public int getWasteTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String wasteTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[6]/div")).getText();
		return Integer.parseInt(wasteTotal);
	}
	
	public int calculateTotalPromoForADate(String date){
		date = getDateInMMDDYYYYFormat(date);
		List<WebElement> miaRecordList = driver.findElements(By.xpath("//tr[contains(@class,'date"+date+" ')]"));
		int promoCount = 0;
		for(int i=1;i<=miaRecordList.size();i++){
			String promo = driver.findElement(By.xpath("(//tr[contains(@class,'date"+date+" ')])["+i+"]/td[7]")).getText();
			promoCount = promoCount + Integer.parseInt(promo);
		}
		System.out.println("Result "+promoCount);
		return promoCount;
	}

	public int getPromoTotalFromDateHeader(String date){
		date = getDateInMMDDYYYYFormat(date);
		String promoTotal = driver.findElement(By.xpath("//tr[contains(@class,'date"+date+"_group')]/th[7]/div")).getText();
		return Integer.parseInt(promoTotal);
	}
	/**************KPI Screen *************************/
	public boolean verifyDataDisplayedInTopEmployeeMealTable(){
		List<WebElement> itemList = driver.findElements(By.xpath("//table[@id='top_menu_items_employee_meals']/tbody/tr"));
		boolean result = true;
		if(driver.findElement(By.xpath("//table[@id='top_menu_items_employee_meals']/tbody/tr[1]/td")).getText().contains("No Activity")){
			return result;
		}else{
			for(int i=1;i<=itemList.size();i++){
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_employee_meals']/tbody/tr["+i+"]/td[@class='menu_item_number']"));
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_employee_meals']/tbody/tr["+i+"]/td[@class='menu_item_desc']"));
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_employee_meals']/tbody/tr["+i+"]/td[@class='amt']"));
			}
			return result;
		}
	}
	
	public boolean verifyHeaderDisplayedInTopEmployeeMealTable(){
		WebElement topEmployeeHeader = driver.findElement(By.xpath("//table[@id='top_menu_items_employee_meals']/thead/tr/th[1]"));
		WebElement quantityHeader = driver.findElement(By.xpath("//table[@id='top_menu_items_employee_meals']/thead/tr/th[2]"));
		return topEmployeeHeader.getText().contains("Top Employee Meals") & quantityHeader.getText().contains("Quantity");
	}
	
	public boolean verifyDataDisplayedInTopMenuItemWastedTable(){
		List<WebElement> itemList = driver.findElements(By.xpath("//table[@id='top_menu_items_wasted']/tbody/tr"));
		boolean result = true;
		if(driver.findElement(By.xpath("//table[@id='top_menu_items_wasted']/tbody/tr[1]/td")).getText().contains("No Activity")){
			return result;
		}else{
			for(int i=1;i<=itemList.size();i++){
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_wasted']/tbody/tr["+i+"]/td[@class='wrin']"));
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_wasted']/tbody/tr["+i+"]/td[@class='wrinDesc']"));
				result = result & Base.isElementDisplayed(By.xpath("//table[@id='top_menu_items_wasted']/tbody/tr["+i+"]/td[@class='amt']"));
			}
			return result;
		}
	}
	
	public boolean verifyHeaderDisplayedInTopMenuItemWastedTable(){
		WebElement topMenuItemHeader = driver.findElement(By.xpath("//table[@id='top_menu_items_wasted']/thead/tr/th[1]"));
		WebElement quantityHeader = driver.findElement(By.xpath("//table[@id='top_menu_items_wasted']/thead/tr/th[2]"));
		return topMenuItemHeader.getText().contains("Top Menu Items Wasted") & quantityHeader.getText().contains("Quantity");
	}
	
	public boolean verifyDataDisplayedInTopMenuItemPromoTable(){
		List<WebElement> itemList = driver.findElements(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/tbody/tr"));
		boolean result = true;
		if(driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/tbody/tr[1]/td")).getText().contains("No Activity")){
			return result;
		}else{
			for(int i=1;i<=itemList.size();i++){
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/tbody/tr["+i+"]/td[@class='menu_item_number']"));
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/tbody/tr["+i+"]/td[@class='menu_item_desc']"));
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/tbody/tr["+i+"]/td[@class='amt']"));
			}
			return result;
		}
	}
	
	public boolean verifyHeaderDisplayedInTopMenuItemPromoTable(){
		WebElement topMenuItemHeader = driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/thead/tr/th[1]"));
		WebElement quantityHeader = driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[1]/thead/tr/th[2]"));
		return topMenuItemHeader.getText().contains("Top Menu Item Promo'd") & quantityHeader.getText().contains("Quantity");
	}
	
	public boolean verifyDataDisplayedInTopManagerMealTable(){
		List<WebElement> itemList = driver.findElements(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/tbody/tr"));
		boolean result = true;
		if(driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/tbody/tr[1]/td")).getText().contains("No Activity")){
			return result;
		}else{
			for(int i=1;i<=itemList.size();i++){
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/tbody/tr["+i+"]/td[@class='menu_item_number']"));
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/tbody/tr["+i+"]/td[@class='menu_item_desc']"));
				result = result & Base.isElementDisplayed(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/tbody/tr["+i+"]/td[@class='amt']"));
			}
			return result;
		}
	}
	
	public boolean verifyHeaderDisplayedInTopManagerMealTable(){
		WebElement topManagerMealHeader = driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/thead/tr/th[1]"));
		WebElement quantityHeader = driver.findElement(By.xpath("(//table[@id='top_promo_items_wasted'])[2]/thead/tr/th[2]"));
		return topManagerMealHeader.getText().contains("Top Manager Meals") & quantityHeader.getText().contains("Quantity");
	}

}
