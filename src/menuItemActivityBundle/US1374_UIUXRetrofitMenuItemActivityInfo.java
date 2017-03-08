package menuItemActivityBundle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;

public class US1374_UIUXRetrofitMenuItemActivityInfo extends AbstractTest{
	
	/*TC3795: Verify that the user is able to view the header "Menu Item Activity & Information", search box to search and select menu
	item with name of search box as "Item", calendar icon to select start date and end date with name of calendar icon as "Start Date" and 'End Date" respectively.*/	
	@Test()
	public void menuItemActivity_US1374_TC3795() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1374_TC3795";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//Verify user is not able to select more than current date for end date
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 0);
		String today = dateFormat.format(cal1.getTime());
		System.out.println("tomorrowDate "+today);
		if (Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityAndInformation_Title)
				& menuItemActivityPage.MenuItemSearchBox_TB.getAttribute("placeholder").equals("Enter menu item number or description")
				& menuItemActivityPage.MenuItemSearchBox_Label.getText().equals("Item")
				& Base.isElementDisplayed(menuItemActivityPage.MiaStartDate_Label)
				& Base.isElementDisplayed(menuItemActivityPage.MiaEndDate_Label)
				& menuItemActivityPage.MiaStartDate_TB.getAttribute("value").equals(today)
				& menuItemActivityPage.MiaEndDate_TB.getAttribute("value").equals(today)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the header as Menu Item Information & Activity, search box  with placeHolder Enter menu item number or description"
					+ "and label as Item,  calendar icon to select start date with Start Date Label and with default value as current date, "
					+ "calendar icon to select End date with End Date Label and with default value as current date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the header as Menu Item Information & Activity, search box  with placeHolder Enter menu item number or description"
					+ "and label as Item,  calendar icon to select start date with Start Date Label and with default value as current date, "
					+ "calendar icon to select End date with End Date Label and with default value as current date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 1);
		String tomorrowDate = dateFormat.format(cal2.getTime());
		System.out.println("tomorrowDate "+tomorrowDate);
		menuItemActivityPage.MiaStartDate_TB.click();
		Thread.sleep(1000);
		boolean futureStartDateIsDisabled = menuItemActivityPage.verifyFutureDateIsDisabledForStartDate(tomorrowDate);
		menuItemActivityPage.MiaEndDate_TB.click();
		Thread.sleep(1000);
		boolean futureEndDateIsDisabled = menuItemActivityPage.verifyFutureDateIsDisabledForEndDate(tomorrowDate);
		if (futureStartDateIsDisabled & futureEndDateIsDisabled ) {
			Reporter.reportPassResult(
					browser,
					"User should not be allowed to select future date for startdate and end date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be allowed to select future date for startdate and end date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		if(menuItemActivityPage.MiaStartDate_TB.getAttribute("value").equals(startDate)
				& menuItemActivityPage.MiaEndDate_TB.getAttribute("value").equals(endDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to select start date and end date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to select start date and end date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC3796: Verify the screen user views after selecting menu item, start date and end date.*/	
	@Test()
	public void menuItemActivity_US1374_TC3796() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1374_TC3796";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		String description = GlobalVariable.menuItemDescription;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		if(menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.SelectItem_Value.getText().contains(description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view item number and description",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view item number and description",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectEndTime(endTime).selectStartTime(startTime);
		if(menuItemActivityPage.StartTime_TB.getText().equals(startTime)
				& menuItemActivityPage.EndTime_TB.getText().equals(endTime)){
			Reporter.reportPassResult(
					browser,
					"User should be able to select start time and end time",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to select start time and end time",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(Base.isElementDisplayed(menuItemActivityPage.RegisterFilter_DD)
				& Base.isElementDisplayed(menuItemActivityPage.EmployeeFilter_DD)
				& Base.isElementDisplayed(menuItemActivityPage.ShowResults_BT)
				& Base.isElementDisplayed(menuItemActivityPage.Information_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Register ,Employee dropdown and Show Results Button, Information Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Register ,Employee dropdown and Show Results Button, Information Button",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC3797: Verify the screen once user clicks on "Show results" button after filling required fields*/	
	@Test()
	public void menuItemActivity_US1374_TC3797() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1374_TC3797";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String date = GlobalVariable.createDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectEndTime(endTime).selectStartTime(startTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if(menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)
				& menuItemActivityPage.verifyRecordsAreCollapsed()){
			Reporter.reportPassResult(
					browser,
					"Different Containers should be displayed as per the time and date selected below table column. It should be collapsed.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Different Containers should be displayed as per the time and date selected below table column. It should be collapsed.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_DateTime_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_Activity_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_Sold_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_EmpMeal_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_MgrMeal_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_Waste_Header)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityTable_Promo_Header)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view column with label name as Date & Time, Activity, Sold, Employee Meal, Manager meal, Waste, Promo.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view column with label name as Date & Time, Activity, Sold, Employee Meal, Manager meal, Waste, Promo.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.expandDateGroup();
		if(menuItemActivityPage.verifyRecordsAreExpanded() 
				& menuItemActivityPage.calculateTotalActivityForADate(date)==menuItemActivityPage.getActivityTotalFromDateHeader(date)
				& menuItemActivityPage.calculateTotalSoldForADate(date)==menuItemActivityPage.getSoldTotalFromDateHeader(date)
				& menuItemActivityPage.calculateTotalEmpMealForADate(date)==menuItemActivityPage.getEmpMealTotalFromDateHeader(date)
				& menuItemActivityPage.calculateTotalMgrMealForADate(date)==menuItemActivityPage.getMgrMealTotalFromDateHeader(date)
				& menuItemActivityPage.calculateTotalWasteForADate(date)==menuItemActivityPage.getWasteTotalFromDateHeader(date)
				& menuItemActivityPage.calculateTotalPromoForADate(date)==menuItemActivityPage.getPromoTotalFromDateHeader(date)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view rolled up values of each column for selected date same as the total sum of values for all 15 min time stamp",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view rolled up values of each column for selected date same as the total sum of values for all 15 min time stamp",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Base.scrollToTheElement(menuItemActivityPage.ShowResults_BT);
		menuItemActivityPage.collapseDateGroup();
		if(menuItemActivityPage.verifyRecordsAreCollapsed()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to collapse the menu item activity details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to collapse the menu item activity details",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	/*TC3797: Verify menu item information button*/	
	@Test()
	public void menuItemActivity_US1374_TC3798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1374_TC3798";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/*String date = GlobalVariable.createDate;*/
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectEndTime(endTime).selectStartTime(startTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_MenuItemNumberHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DescriptionHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_OnPOSHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DaypartCodeHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_FamilyGroupHeader)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		Thread.sleep(1000);
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_WRINHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_DescriptionHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_ServingFactorHeader)
				& menuItemActivityPage.MenuItemInformation_ReceipeTable_ItemList.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view columns with label name WRIN, Description, Serving factor with required data to each column",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view columns with label name WRIN, Description, Serving factor with required data to each column",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		menuItemActivityPage.MenuItemInformation_Receipe_Collapse_BT.click();
		if(!Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)){
			Reporter.reportPassResult(
					browser,
					"User should be able to collapse the recipe details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to collapse the recipe details",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view historical recipe details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view historical recipe details",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(1000);
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Collpse_BT.click();
		if(!Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser,
					"User should be able to collapse historical recipe details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to collapse historical recipe details",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.MenuItemInformation_Close_BT.click();
		if(!Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_PopUp_Title)){
			Reporter.reportPassResult(
					browser,
					"User should be able to close MenuItemInformation model on clicking Cross(X) button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to close MenuItemInformation model on clicking Cross(X) button",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	/*TC3799:  	Verify KPI screen of menu item activity & information page*/	
	@Test()
	public void menuItemActivity_US1374_TC3799() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1374_TC3799";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		//menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				
				& menuItemActivityPage.Kpi_Model_Container.getAttribute("class").contains("kpiExpandedView")
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser,
					"User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(menuItemActivityPage.verifyHeaderDisplayedInTopEmployeeMealTable()
				& menuItemActivityPage.verifyHeaderDisplayedInTopMenuItemWastedTable()
				& menuItemActivityPage.verifyHeaderDisplayedInTopMenuItemPromoTable()
				& menuItemActivityPage.verifyHeaderDisplayedInTopManagerMealTable()){
			Reporter.reportPassResult(
					browser,
					"Table 1 should contain columns top menu items wasted, quantity. Table 2 should contain columns top menu items promo'd, quantity."
					+ "Table 3 should contain columns top employee meals, quantity. Table 4 should contain columns top managers meals, quantity.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Table 1 should contain columns top menu items wasted, quantity. Table 2 should contain columns top menu items promo'd, quantity."
					+ "Table 3 should contain columns top employee meals, quantity. Table 4 should contain columns top managers meals, quantity.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(menuItemActivityPage.verifyDataDisplayedInTopEmployeeMealTable()
				& menuItemActivityPage.verifyDataDisplayedInTopMenuItemWastedTable()
				& menuItemActivityPage.verifyDataDisplayedInTopMenuItemPromoTable()
				& menuItemActivityPage.verifyDataDisplayedInTopManagerMealTable()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view data for each table if available in the format: menu item number, menu item description, quantity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view data for each table if available in the format: menu item number, menu item description, quantity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(menuItemActivityPage.Kpi_Model_Container.getAttribute("class").contains("kpiCollapsedView")){
			Reporter.reportPassResult(
					browser,
					"User should be able to collapse the KPI screen",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, 
					"User should be able to collapse the KPI screen",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
