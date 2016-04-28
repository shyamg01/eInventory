package UserStoriesWithoutBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import sprint2.AbstractTest;

public class US1374_UIUXRetrofitMenuItemActivityInfo extends AbstractTest
{
	
	//TC3795 : Verify that the user is able to view the header "Menu Item Activity & Information", search box to search and select menu item with name of search box as "Item", calendar icon to select start date and end date with name of calendar icon as "Start Date" and 'End Date" respectively.
	
	
	@Test()
	public void menuItemActivity_US1374_TC3795() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityAndinformationPage;
		String userId = LoginTestData.operatorUserId;
		String storeId = LoginTestData.operatorStoreId;

		String todayDate=Base.returnTodayDate();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityAndinformationPage = homePage.selectUser(userId)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityPage();
		Thread.sleep(5000);
		//click on Start date text box and verify that calendar widget is displaying
		menuItemActivityAndinformationPage.MiaStartDate_TB.click();
		Thread.sleep(2000);
		//Verify start date calendar
		if(driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][1]/div/div[@class='xdsoft_calendar']")).isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3795",
					"Strat date calendar should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3795_Condition01","menuItemActivity_US1374_TC3795",
					"Strat date calendar should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3795_Condition01");
			
		}
		menuItemActivityAndinformationPage.MiaStartDate_TB.click();
		menuItemActivityAndinformationPage.MiaEndDate_TB.click();
		Thread.sleep(2000);
		//verify end date calendar
		if(driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div/div[@class='xdsoft_calendar']")).isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3795",
					"End date calendar should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3795_Condition02","menuItemActivity_US1374_TC3795",
					"End date calendar should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3795_Condition02");
		}
		
		menuItemActivityAndinformationPage.MiaEndDate_TB.click();
		if(//Verify Menu Item Activity and Information title
				menuItemActivityAndinformationPage.MenuItemActivityAndInformation_Title.isDisplayed() &&
				//Verify search box to search and select menu Item
				menuItemActivityAndinformationPage.MenuItemSearchBox_TB.isDisplayed() &&
				//View the name of search box as "Item" mentioned above the box
				menuItemActivityAndinformationPage.MenuItemSearchBox_Label.getText().equalsIgnoreCase("Item") &&
				//Start date and End date label
				menuItemActivityAndinformationPage.MiaStartDate_Label.isDisplayed() &&
				menuItemActivityAndinformationPage.MiaEndDate_Label.isDisplayed() &&
				//Verify the start date and End date text box
				menuItemActivityAndinformationPage.MiaStartDate_TB.isDisplayed() &&
				menuItemActivityAndinformationPage.MiaEndDate_TB.isDisplayed() &&
				menuItemActivityAndinformationPage.MiaStartDate_TB.getAttribute("value").equalsIgnoreCase(todayDate) &&
				menuItemActivityAndinformationPage.MiaEndDate_TB.getAttribute("value").equalsIgnoreCase(todayDate))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3795",
					"All the lables and fields should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3795_Condition03","menuItemActivity_US1374_TC3795",
					"All the lables and fields should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3795_Condition03");
		}
		//select start date as current date
		menuItemActivityAndinformationPage.selectStartDate(todayDate);
		//select start date as future date
		String futureDate="0"+Base.getCorrectMonthFromDate(todayDate)+"/"+(Base.getDayFromDate(todayDate)+1)+"/"+Base.getYearFromDate(todayDate);
		menuItemActivityAndinformationPage.selectStartDate(futureDate);
		menuItemActivityAndinformationPage.MiaStartDate_TB.click();
		//select End date as future date
		menuItemActivityAndinformationPage.selectEndDate(futureDate);
		;
		if(!(menuItemActivityAndinformationPage.MiaStartDate_TB.getAttribute("value").equalsIgnoreCase(futureDate) &&
				menuItemActivityAndinformationPage.MiaEndDate_TB.getAttribute("value").equalsIgnoreCase(futureDate)))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3795",
					"User should not be able to select the date as future date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3795_Condition03","menuItemActivity_US1374_TC3795",
					"User should not be able to select the date as future date",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3795_Condition03");
		}

	
	}

	
	
	//TC3796 : Verify the screen user views after selecting menu item, start date and end date.
	
	
	@Test()
	public void menuItemActivity_US1374_TC3796() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operatorUserId;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem;
		String menuItemDescription = GlobalVariable.menuItemDescription;
	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUser(userId)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.Information_BT));
		Thread.sleep(5000);
		//Verify Item Number and description
		String actItemNumberDesc=driver.findElement(By.xpath("//div[@id='mia-info-div']/span[1]")).getText()+driver.findElement(By.xpath("//div[@id='mia-info-div']/span[2]")).getText();
		String expItemNumberDesc="Item"+menuItem+" - "+menuItemDescription;
		
		if(actItemNumberDesc.equalsIgnoreCase(expItemNumberDesc))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Item number and  description should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition01","menuItemActivity_US1374_TC3796",
					"Item number and  description should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition01");
		}
		
		//click on start Time text box and verify select start time option is displaying
		menuItemActivityPage.StartTime_TB.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//eb-timepicker[@id='mia_start_time']/div/div[@id='eb_tp_controls']")));
		if(Base.isElementDisplayed(By.xpath("//eb-timepicker[@id='mia_start_time']/div/div[@id='eb_tp_controls']")))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Select start time option should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition02","menuItemActivity_US1374_TC3796",
					"Select start time option should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition02");
		}
		
		menuItemActivityPage.EndTime_TB.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//eb-timepicker[@id='mia_end_time']/div/div[@id='eb_tp_controls']")));
		if(Base.isElementDisplayed(By.xpath("//eb-timepicker[@id='mia_end_time']/div/div[@id='eb_tp_controls']")))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Select End time option should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition03","menuItemActivity_US1374_TC3796",
					"Select End time option should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition03");
		}
		
		//Verify that Register drop down is displaying
		;
		if(		driver.findElement(By.xpath("//eb-multiselect-dropdown[@id='register_list_select']/div[@id='eb_dd_label']")).getText().equalsIgnoreCase("Register") &&
				menuItemActivityPage.RegisterFilter_DD.isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Register drop down should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition04","menuItemActivity_US1374_TC3796",
					"Register drop down should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition04");
		}
		
		//Verify the Employee drop down
	
		if(driver.findElement(By.xpath("//eb-multiselect-dropdown[@id='employee_list_select']/div[@id='eb_dd_label']")).getText().equalsIgnoreCase("Employee") &&
				menuItemActivityPage.EmployeeFilter_DD.isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Employee drop down should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition05","menuItemActivity_US1374_TC3796",
					"Employee drop down should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition05");
		}
		
		//Verify show result and Information button

		if(	menuItemActivityPage.Information_BT.isDisplayed() &&
				menuItemActivityPage.ShowResults_BT.isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1374_TC3796",
					"Show result and Information buttons should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1374_TC3796_Condition06","menuItemActivity_US1374_TC3796",
					"Show result and Information buttons should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1374_TC3796_Condition06");
		}
		
		
	}
	
	
	// TC3797 : Verify the screen once user clicks on "Show results" button after filling required fields.
	
	@Test()
	public void menuItemActivity_US1374_TC3797() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUser(userId)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		menuItemActivityPage.expandDateGroup();
		if (menuItemActivityPage.verifyRecordsAreExpanded() & 
				menuItemActivityPage.verifyMenuActivityTimeInDetailForSelectedDate(startDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1047_TC1733",
					"User should be able to view the expanded Activity for Menu Item X in interval of 15 min each for the selected date and time.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1047_TC1733_Condition1","menuItemActivity_US1047_TC1733",
					"User should be able to view the expanded Activity for Menu Item X in interval of 15 min each for the selected date and time.",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1047_TC1733_Condition1");
		}
		Base.toReachTopOfthePage();
		menuItemActivityPage.collapseDateGroup();
		if(menuItemActivityPage.verifyRecordsAreCollapsed()) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1047_TC1733",
					"User should be able to collapse the menu item activity details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1047_TC1733_Condition2","menuItemActivity_US1047_TC1733",
					"User should be able to collapse the menu item activity details",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1047_TC1733_Condition2");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
