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

public class US603_MenuItemActivity extends AbstractTest {

	//TC1596:verify that a user should be able to search and select a menu item from the search box provided on Menu Item Activity landing page.
	@Test()
	public void menuItemActivity_US603_TC1596() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1596";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem;
		String menuItemDescription = GlobalVariable.menuItemDescription;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to menu item activity page 
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		//Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		//Verify that user is able to search the menu item using menu item number=1
		if(menuItemActivityPage.SelectItem_Value.getText().contains(menuItemNumber)
				& menuItemActivityPage.SelectItem_Value.getText().contains(menuItemDescription)){
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the menu item by typing menu item number",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the menu item by typing menu item number",
					"Fail");
			AbstractTest.takeSnapShot();
			}
		menuItemActivityPage.searchAndSelectMenuItem(menuItemDescription);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		//Verify that user is able to search the menu item using menu item Description = Hamburger
		if(menuItemActivityPage.SelectItem_Value.getText().contains(menuItemNumber)
				& menuItemActivityPage.SelectItem_Value.getText().contains(menuItemDescription)){
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the menu item by typing menu item description",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the menu item by typing menu item description",
					"Fail");
			AbstractTest.takeSnapShot();
			}
	}
	
	//TC1599:verify that a Verify that the user should be able to select the date range for the menu item selected on Menu Item Activity page.
	@Test()
	public void menuItemActivity_US603_TC1599() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1599";
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String menuItemNumber = GlobalVariable.menuItem;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to menu item activity page 
		menuItemActivityPage= homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		//Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		String todayDate = Base.returnTodayDate();
		//click on the start date button
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		//verify that by default today date is selected
		boolean defaultTodayDateSelected = menuItemActivityPage.verifyDateIsSelectedForStartDate(todayDate);
		//Verify that by default today date is selected
		defaultTodayDateSelected = defaultTodayDateSelected && menuItemActivityPage.verifyDateIsSelectedForEndDate(todayDate);
		if(defaultTodayDateSelected){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the start date and end date as default to current date",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the start date and end date as default to current date",
					"Fail");
			AbstractTest.takeSnapShot();
			}
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get start date as 5 days earlier date from today date
		cal1.add(Calendar.DATE, -3);
        String fromDate = dateFormat.format(cal1.getTime());
        //Get end date as 1 day earlier date from today date
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -1);
        String toDate = dateFormat.format(cal2.getTime());
        //enter past date in start date 
        menuItemActivityPage.selectStartDate(fromDate);
        //Verify that user is able to select past date as start date
        boolean pastDateSelected = menuItemActivityPage.verifyDateIsSelectedForStartDate(fromDate);	
        //enter past date in end date 
		menuItemActivityPage.selectEndDate(toDate);
		//Verify that user is able to select past date as end date
		pastDateSelected = pastDateSelected && menuItemActivityPage.verifyDateIsSelectedForEndDate(toDate);
		// Get start date as 1 day later date from today date
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DATE, +1);
		String tomorrowDate = dateFormat.format(cal3.getTime());
		//click on the start date button
		menuItemActivityPage.MiaStartDate_TB.click();
		//Verify that user is not able to select future date as start date ;it will be disabled
		boolean futureDatedisabled =menuItemActivityPage.verifyFutureDateIsDisabledForStartDate(tomorrowDate);
		//click on the end date button
		menuItemActivityPage.MiaEndDate_TB.click();
		//Verify that user is not able to select future date as end date ;it will be disabled
		futureDatedisabled = futureDatedisabled && menuItemActivityPage.verifyFutureDateIsDisabledForEndDate(tomorrowDate);
		if(pastDateSelected && futureDatedisabled){
			Reporter.reportPassResult(
					browser,
					"User should be able to select current or past dates only. Future date can not be selected.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to select current or past dates only. Future date can not be selected.",
					"Fail");
			AbstractTest.takeSnapShot();
			}
	}
	
	// TC1605:Verify that the user should be able to select a time period for
	// each date in the date range for the menu item selected.
	@Test()
	public void menuItemActivity_US603_TC1605() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US603_TC1605";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem;
		//String defaultStartTime = GlobalVariable.defaultStartTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		String defaultEndTime = Base.getCurrentTimeStamp();
		System.out.println("defaultEndTime "+defaultEndTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get current date and time
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DATE, 0);
		cal3.add(Calendar.HOUR, -1);
		dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String oneHourBackTime = dateFormat.format(cal3.getTime()).split(" ")[1];
		System.out.println("oneHourBackTime "+oneHourBackTime);
		//String defaultStartTime = Base.getCurrentTimeStamp();
		String defaultStartTime = Base.get15MinuteTimeStamp(Integer.parseInt(oneHourBackTime.split(":")[0]), 
				Integer.parseInt(oneHourBackTime.split(":")[1]));
		/*String defaultStartTime = Base.get15MinuteTimeSlice(Integer.parseInt(oneHourBackTime.split(":")[0]), 
				Integer.parseInt(oneHourBackTime.split(":")[1]));*/
		System.out.println("defaultStartTime "+ defaultStartTime);
		/*String currentTime = dateFormat.format(cal3.getTime()).split(" ")[1];
		String currentHour = currentTime.split(":")[0];*/
		// verify that start time is displayed as 00:00
		boolean defaultTimeDisplayed = menuItemActivityPage.StartTime_TB.getText().equals(defaultStartTime);
		// verify that end time is displayed as current hour
		defaultTimeDisplayed = defaultTimeDisplayed
				&& menuItemActivityPage.EndTime_TB.getText().equals(defaultEndTime);
		if (defaultTimeDisplayed) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Start time will default to beginning of business day. and end time will default to the current time",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Start time will default to beginning of business day. and end time will default to the current time",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	// TC1606:Verify that the Menu Item Activity will only display up to the current time if the current date is part of the date range selected.
	@Test()
	public void menuItemActivity_US603_TC1606() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1606";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		//String defaultStartTime = GlobalVariable.defaultStartTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get current date and time
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 0);
		cal1.add(Calendar.HOUR, -1);
		dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String oneHourBackTime = dateFormat.format(cal1.getTime()).split(" ")[1];
		System.out.println("oneHourBackTime " + oneHourBackTime);
		// String defaultStartTime = Base.getCurrentTimeStamp();
		String defaultStartTime = Base.get15MinuteTimeStamp(
				Integer.parseInt(oneHourBackTime.split(":")[0]),
				Integer.parseInt(oneHourBackTime.split(":")[1]));
		System.out.println("defaultStartTime " + defaultStartTime);
		// get current date and time
		String defaultEndTime = Base.getCurrentTimeStamp();
		System.out.println("defaultEndTime "+defaultEndTime);
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DATE, 0);
		dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String currentDate = dateFormat.format(cal3.getTime()).split(" ")[0];
		/*String currentTime = dateFormat.format(cal3.getTime()).split(" ")[1];
		String currentHour = currentTime.split(":")[0]+":00";*/
		// enter start date
		menuItemActivityPage.selectStartDate(currentDate);
		// enter end date
		menuItemActivityPage.selectEndDate(currentDate);
		// verify that start time is displayed as 00:00
		menuItemActivityPage.selectStartTime(defaultStartTime);
		// verify that end time is displayed as current hour
		menuItemActivityPage.selectEndTime(defaultEndTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		boolean menuItemActivityDisplayed = menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(currentDate, currentDate, defaultStartTime, defaultEndTime);
		if (menuItemActivityDisplayed) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the menu item activity up to  current time for the current date.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the menu item activity up to  current time for the current date.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.expandDateGroup();
		boolean menuItemActivityDisplayedInDetails = menuItemActivityPage.verifyMenuActivityTimeInDetailForSelectedDate(currentDate, defaultStartTime, defaultEndTime);
		if (menuItemActivityDisplayedInDetails) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the menu item activity in details up to  current time for the current date.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the menu item activity in details up to  current time for the current date.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC1607:Verify that the user should be able to view the date information in greater detail for every 15 minute time slice for each date and the time period selected.
	@Test()
	public void menuItemActivity_US603_TC1607() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1607";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String date = GlobalVariable.createDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// verify that start time is displayed as 00:00
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// verify that end time is displayed as 2 hour later from current time
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		menuItemActivityPage.expandDateGroup();
		Thread.sleep(3000);
		boolean recordsWithTimeSpanDisplayed = menuItemActivityPage.verifyMenuActivityTimeInDetailForSelectedDate(date, startTime, endTime);
		if (recordsWithTimeSpanDisplayed) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the date information in greater detail for every 15 minute time slice for each date and the time period selected.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the date information in greater detail for every 15 minute time slice for each date and the time period selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC1608:Verify the navigation path of Menu Item Activity page.*/
	@Test()
	public void menuItemActivity_US603_TC1608() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US603_TC1608";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		if (Base.isElementDisplayed(menuItemActivityPage.MenuItemActivityAndInformation_Title)){
			Reporter.reportPassResult(
					browser,
					"User should be able to get navigated to Menu Item Information & Activity page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to get navigated to Menu Item Information & Activity page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC1608:Verify the navigation path of Menu Item Activity page.*/
	@Test()
	public void menuItemActivity_US603_TC1614() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US603_TC1614";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItem = GlobalVariable.menuItem;
		String description = GlobalVariable.menuItemDescription;
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
		if(Base.isElementDisplayed(menuItemActivityPage.StartTime_TB)
				& Base.isElementDisplayed(menuItemActivityPage.EndTime_TB)
				& Base.isElementDisplayed(menuItemActivityPage.RegisterFilter_DD)
				& Base.isElementDisplayed(menuItemActivityPage.EmployeeFilter_DD)
				& Base.isElementDisplayed(menuItemActivityPage.ShowResults_BT)
				& Base.isElementDisplayed(menuItemActivityPage.Information_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Start Time End Time, Register ,Employee dropdown and Show Results Button, Information Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Start Time End Time, Register ,Employee dropdown and Show Results Button, Information Button",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	// TC1624:Verify that the user should be able to view Total Menu Items Sold rolled up for the time periods for the selected date range.
	@Test(enabled=false)
	public void menuItemActivity_US603_TC1624() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US603_TC1624";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// Enter start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Verify that sold value for menu item should be displayed for selected  date range
		if (menuItemActivityPage.verifySoldValueForMenuItemDisplayed(startDate, endDate)
				& menuItemActivityPage.verifyEmpMealValueForMenuItemDisplayed(startDate, endDate)
				& menuItemActivityPage.verifyMgrMealValueForMenuItemDisplayed(startDate, endDate)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view total Sold, Employee, Manager Meals sold (rolled up for the time periods for the selected date range) for item X.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view total Sold, Employee, Manager Meals sold (rolled up for the time periods for the selected date range) for item X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC1632:Verify that the user should be able to view Total Menu Items Wasted (rolled up for the time periods for the selected date range).
	@Test()
	public void menuItemActivity_US603_TC1632() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1632";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// enter start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Verify that Waste value for menu item should be displayed for selected date range
		if (menuItemActivityPage.verifyWasteValueForMenuItemDisplayed(startDate, endDate)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Total Menu Items Wasted (rolled up for the time periods for the selected date range)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Total Menu Items Wasted (rolled up for the time periods for the selected date range)",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC1634:Verify that the user should be able to view Total Menu Items Promo'd (rolled up for the time periods for the selected date range).
	@Test(enabled=false)
	public void menuItemActivity_US603_TC1634() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1634";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// enter start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Verify that promo value for menu item should be displayed for selected date range
		if (menuItemActivityPage.verifyPromoValueForMenuItemDisplayed(startDate, endDate)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Total Menu Items Promo'd (rolled up for the time periods for the selected date range).",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Total Menu Items Promo'd (rolled up for the time periods for the selected date range).",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	// TC1643:Verify that user should be able to view rolled up POS activity for date and time selected as a default for each date in the date range.
	@Test(enabled=false)
	public void menuItemActivity_US603_TC1643() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US603_TC1643";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// enter start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Verify that Pos Activity value for menu item should be displayed for selected date range
		if (menuItemActivityPage.verifyPOSActivityForMenuItemDisplayed(startDate, endDate)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view rolled up POS activity for date and time selected as a default for each date in the date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view rolled up POS activity for date and time selected as a default for each date in the date range",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC1645:Verify that user should be able to view the menu item activity after expanding the dates at 15 min level.
	@Test()
	public void menuItemActivity_US603_TC1645() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1645";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// Select start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		//click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		//Expand the date group
		menuItemActivityPage.expandDateGroup();
		//Verify that menu item activity is displayed in the 15 min time slice for the expanded date.
		if (menuItemActivityPage.verifyMenuActivityDisplayedFor15MinTimeSlice(date)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the menu item activity in the 15 min time slice for the expanded date.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the menu item activity in the 15 min time slice for the expanded date.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1646:Verify that the user should be able to view the total menu items sold for a date in 15 minute time slice.
	@Test(enabled=false)
	public void menuItemActivity_US603_TC1646() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1646";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// Select start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Expand the date group
		menuItemActivityPage.expandDateGroup();
		// Verify that menu item activity is displayed in the 15 min time slice  for the expanded date.
		if (menuItemActivityPage.verifySoldMenuItemDisplayedFor15MinTimeSlice(date)
				& menuItemActivityPage.verifyEmployeeMealDisplayedFor15MinTimeSlice(date)
				& menuItemActivityPage.verifyManagerMealDisplayedFor15MinTimeSlice(date)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the total menu items and total Employee/Manager Meals sold for a date in 15 minute time slice.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the total menu items and total Employee/Manager Meals sold for a date in 15 minute time slice.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC1647:Verify that the user should be able to view the Total Menu Items Wasted in the 15 minute time slice.
	@Test()
	public void menuItemActivity_US603_TC1647() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1647";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// Select start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Expand the date group
		menuItemActivityPage.expandDateGroup();
		// Verify that menu item activity is displayed in the 15 min time slice for the expanded date.
		if (menuItemActivityPage.verifyWasteItemDisplayedFor15MinTimeSlice(date)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the waste menu items sold for a date in 15 minute time slice.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the waste menu items sold for a date in 15 minute time slice.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1648:Verify that the user should be able to view the Total Menu Items Promo's in the 15 minute time slice.
	@Test(enabled=false)
	public void menuItemActivity_US603_TC1648() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="menuItemActivity_US603_TC1648";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.password;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemNumber = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to menu item activity page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToMenuItemActivityAndInformationPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_TB));
		// enter start date
		menuItemActivityPage.selectStartDate(startDate);
		// enter end date
		menuItemActivityPage.selectEndDate(endDate);
		// Select start time
		menuItemActivityPage.selectEndTime(endTime).selectStartTime(startTime);
		// click on search button
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		// Expand the date group
		menuItemActivityPage.expandDateGroup();
		// Verify that menu item activity is displayed in the 15 min time slice for the expanded date.
		if (menuItemActivityPage.verifyMenuItemPromoDisplayedFor15MinTimeSlice(date)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the total Menu Items Promo's in the 15 minute time slice",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the total Menu Items Promo's in the 15 minute time slice",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
