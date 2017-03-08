package physicalInventoryBundle;

import java.io.IOException;
import java.util.regex.Pattern;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US854_UIUXRetrofitPhysicalInventory extends AbstractTest
{
	
	
	//TC4089 : Verify the landing page of physical inventory
	
	@Test()
	public void physicalInventory_US854_TC4089() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US854_TC4089";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		// User should be able to view the header "Inventory"
		boolean condition1=GenericMethods.isElementDisplayed(physicalInventoryPage.PhysicalInventoryPage_Title, "physicalInventoryPage.PhysicalInventoryPage_Title");
		//User should be able to view the text "Take inventory" below the header
		boolean condition2=GenericMethods.isElementDisplayed(physicalInventoryPage.TakeInventory_Title, "physicalInventoryPage.TakeInventory_Title");
		//User should be able to view the label daily, weekly and monthly with "create" button next to it
		boolean condition3=GenericMethods.isElementDisplayed(physicalInventoryPage.Daily_LBL, "physicalInventoryPage.Daily_LBL");
		boolean condition4=GenericMethods.isElementDisplayed(physicalInventoryPage.Weekly_LBL, "physicalInventoryPage.Weekly_LBL");
		boolean condition5=GenericMethods.isElementDisplayed(physicalInventoryPage.Monthly_LBL, "physicalInventoryPage.Monthly_LBL");
		boolean condition6=GenericMethods.isElementDisplayed(physicalInventoryPage.CreateDailyInventory_BT, "physicalInventoryPage.CreateDailyInventory_BT");
		boolean condition7=GenericMethods.isElementDisplayed(physicalInventoryPage.CreateWeeklyInventory_BT, "physicalInventoryPage.CreateWeeklyInventory_BT");
		boolean condition8=GenericMethods.isElementDisplayed(physicalInventoryPage.CreateMonthlyInventory_BT, "physicalInventoryPage.CreateMonthlyInventory_BT");
		//User should be able to view the heading "Inventory status"
		boolean condition9=GenericMethods.isElementDisplayed(physicalInventoryPage.InventoryStatus_Title, "physicalInventoryPage.InventoryStatus_Title");
		//User should be able to view the label "start date" with calendar icon and date below it
		//User should be able to view the label "end date" with calendar icon and date below it
		boolean condition10=GenericMethods.isElementDisplayed(physicalInventoryPage.InventoryStatus_StartDate_Label, "physicalInventoryPage.InventoryStatus_StartDate_Label");
		boolean condition11=GenericMethods.isElementDisplayed(physicalInventoryPage.InventoryStatus_EndDate_Label, "physicalInventoryPage.InventoryStatus_EndDate_Label");
		boolean condition12=GenericMethods.isElementDisplayed(physicalInventoryPage.StartDate_TB, "physicalInventoryPage.StartDate_TB");
		boolean condition13=GenericMethods.isElementDisplayed(physicalInventoryPage.EndDate_TB, "physicalInventoryPage.EndDate_TB");
		//User should be able to view the label "list type" with default view for drop down as "All" below it
		boolean condition14=GenericMethods.isElementDisplayed(physicalInventoryPage.InventoryStatus_ListType_Label, "physicalInventoryPage.InventoryStatus_ListType_Label");
		boolean condition15=GenericMethods.textCompare("all", GenericMethods.getText(driver.findElement(By.xpath("//eb-multiselect-dropdown[@id='list_type_select']/div/div[@id='eb_dd_input']/span")), "List Type DD default Value"));
		//User should be able to view the label "created by" with default view for drop down as "All" below it
		boolean condition16=GenericMethods.isElementDisplayed(physicalInventoryPage.InventoryStatus_CreatedBy_Label, "physicalInventoryPage.InventoryStatus_CreatedBy_Label");
		boolean condition17=GenericMethods.textCompare("all", GenericMethods.getText(driver.findElement(By.xpath("//eb-multiselect-dropdown[@id='created_by_select']/div/div[@id='eb_dd_input']/span")), "Created By DD default Value"));
		//User should be able to view the column "created" with date and time below it
		boolean condition18=GenericMethods.isElementDisplayed(By.xpath("//th[text()='Created']"), "Created Column Header");
		//User should be able to view the column "list type" with type as daily/weekly/monthly below it
		boolean condition19=GenericMethods.isElementDisplayed(By.xpath("//th[text()='List Type']"), "List Type Column Header");
		//User should be able to view the column "created by" containing name of the user who created the inventory
		boolean condition20=GenericMethods.isElementDisplayed(By.xpath("//th[text()='Created By']"), "Created By Column Header");
		//User should be able to view the column "source" containing info related to the source of inventory creation
		boolean condition21=GenericMethods.isElementDisplayed(By.xpath("//th[text()='Source']"), "Source Column Header");
		//User should be able to view the button "view" next to the source column
		boolean condition22=true;
		if(driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size()>0)
		{
			 condition22=GenericMethods.textCompare("View", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr[1]/td[5]/a/eb-button/button")), "View Button"));
		}
		
		
		if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10 && condition11 && condition12 && condition13 && condition14 && condition15 && condition16 && condition17 && condition18 && condition19 && condition20 && condition21 && condition22)
		{
			Reporter.reportPassResult(
					browser,
					"All the fields should display as expected",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the fields should display as expected",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
	// TC4090 : Verify the create daily inventory model with all section minimize
	
	
	@Test()
	public void physicalInventory_US854_TC4090() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US854_TC4090";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		String timePattern ="(\\d{1,2})(:)(\\d{1,2})";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Go to daily Inventory page
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT, "physicalInventoryPage.CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//User should be able to view print icon on top right corner
		boolean condition1=GenericMethods.isElementDisplayed(By.xpath("//a[@class='fa fa-print icon-print pull-right']"), "Print Button");
		//User should be able to view the header "daily inventory list"
		boolean condition2=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title, "physicalInventoryPage.DailyInventoryList_Title");
		//User should be able to view the label date with calendar icon and date visible below it
		boolean condition3=GenericMethods.isElementDisplayed(By.xpath("//eb-datepicker[@id='inventory_modal_date_picker']/div/label[contains(.,'Date')]"), "Daily Invendory date label");
		boolean condition4=Pattern.compile(datepattern).matcher(GenericMethods.getText(driver.findElement(By.xpath("//input[@id='inventory_modal_date_picker_input']")), "Date Text box")).matches();
		//User should be able to view the label time with clock icon and time visible below it
		boolean condition5=GenericMethods.isElementDisplayed(By.xpath("//eb-timepicker[@id='new_phys_inv_time']/div[contains(.,'Time')]"), "Daily Invendory Time label");
		boolean condition6=Pattern.compile(timePattern).matcher(GenericMethods.getText(driver.findElement(By.xpath("//eb-timepicker[@id='new_phys_inv_time']/div[2]/div/span")), "Time Text box")).matches();
		//User should be able to view the label "add item to list" with search box to search and add wrin
		boolean condition7=GenericMethods.isElementDisplayed(By.xpath("//label[@class='style-scope eb-autosearch' and contains(.,'Add Item To List')]"), "Add Item to List label");
		boolean condition8=GenericMethods.isElementDisplayed(By.xpath("//input[@id='add_inventory_autocomplete']"), "Search box to search the WRIN");
		//User should be able to view the label "view items" with default view of dropdown as "All" below the label
		boolean condition9=GenericMethods.isElementDisplayed(By.xpath("//label[contains(.,'View Items')]"), "View Itemslabel");
		boolean condition10=GenericMethods.textCompare("All", GenericMethods.getText(driver.findElement(By.xpath("//select[@id='filter-inventory-dropdown']/option[1]")), "View Items DD default Value"));
		//User should be able to view the label "search inventory list" with search box to search the wrin already added into the inventory
		boolean condition11=GenericMethods.isElementDisplayed(By.xpath("//label[@class='style-scope eb-autosearch' and contains(.,'Search Inventory List')]"), "Search inventory List label");
		boolean condition12=GenericMethods.isElementDisplayed(By.xpath("//input[@id='search_inventory_autocomplete']"), "Search Inventory List Search box to search the WRIN");
		// User should be able to view the label "WRIN, description, case, pack, loose and item total"
		boolean condition13=GenericMethods.textCompare("WRIN", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[2]")), "WRIN cloumn header"));
		boolean condition14=GenericMethods.textCompare("Description", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[3]")), "Description cloumn header"));
		boolean condition15=GenericMethods.textCompare("Case", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[4]")), "Case cloumn header"));
		boolean condition16=GenericMethods.textCompare("Pack", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[5]")), "Pack cloumn header"));
		//User should be able to view the  label "frozen , refrigerated"
		boolean condition17=GenericMethods.isElementDisplayed(By.xpath("//span[text()='Frozen']"), "Frozen label");
		boolean condition18=GenericMethods.isElementDisplayed(By.xpath("//span[text()='Refrigerated']"), "Refrigerated label");
		//User should be able to view the button "cancel" and "submit"
		boolean condition19=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventory_popUp_Submit_BT, "physicalInventoryPage.DailyInventory_popUp_Submit_BT");
		boolean condition20=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventory_popUp_Cancel_BT, "physicalInventoryPage.DailyInventory_popUp_Cancel_BT");
		
		if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10 && condition11 && condition12 && condition13 &&
				condition14 && condition15 && condition16 && condition17 && condition18 && condition19 && condition20)
		{
			Reporter.reportPassResult(
					browser,
					"All the fields should display as expected",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the fields should display as expected",
					"Fail");
			AbstractTest.takeSnapShot();
		}


		
	}
	
	

	// TC4091 : Verify the create daily inventory model with one section maximized
	
	
	@Test()
	public void physicalInventory_US854_TC4091() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US854_TC4091";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		String timePattern ="(\\d{1,2})(:)(\\d{1,2})";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Go to daily Inventory page
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT, "physicalInventoryPage.CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//User should be able to view print icon on top right corner
		boolean condition1=GenericMethods.isElementDisplayed(By.xpath("//a[@class='fa fa-print icon-print pull-right']"), "Print Button");
		//User should be able to view the header "daily inventory list"
		boolean condition2=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title, "physicalInventoryPage.DailyInventoryList_Title");
		//User should be able to view the label date with calendar icon and date visible below it
		boolean condition3=GenericMethods.isElementDisplayed(By.xpath("//eb-datepicker[@id='inventory_modal_date_picker']/div/label[contains(.,'Date')]"), "Daily Invendory date label");
		boolean condition4=Pattern.compile(datepattern).matcher(GenericMethods.getText(driver.findElement(By.xpath("//input[@id='inventory_modal_date_picker_input']")), "Date Text box")).matches();
		//User should be able to view the label time with clock icon and time visible below it
		boolean condition5=GenericMethods.isElementDisplayed(By.xpath("//eb-timepicker[@id='new_phys_inv_time']/div[contains(.,'Time')]"), "Daily Invendory Time label");
		boolean condition6=Pattern.compile(timePattern).matcher(GenericMethods.getText(driver.findElement(By.xpath("//eb-timepicker[@id='new_phys_inv_time']/div[2]/div/span")), "Time Text box")).matches();
		//User should be able to view the label "add item to list" with search box to search and add wrin
		boolean condition7=GenericMethods.isElementDisplayed(By.xpath("//label[@class='style-scope eb-autosearch' and contains(.,'Add Item To List')]"), "Add Item to List label");
		boolean condition8=GenericMethods.isElementDisplayed(By.xpath("//input[@id='add_inventory_autocomplete']"), "Search box to search the WRIN");
		//User should be able to view the label "view items" with default view of dropdown as "All" below the label
		boolean condition9=GenericMethods.isElementDisplayed(By.xpath("//label[contains(.,'View Items')]"), "View Itemslabel");
		boolean condition10=GenericMethods.textCompare("All", GenericMethods.getText(driver.findElement(By.xpath("//select[@id='filter-inventory-dropdown']/option[1]")), "View Items DD default Value"));
		//User should be able to view the label "search inventory list" with search box to search the wrin already added into the inventory
		boolean condition11=GenericMethods.isElementDisplayed(By.xpath("//label[@class='style-scope eb-autosearch' and contains(.,'Search Inventory List')]"), "Search inventory List label");
		boolean condition12=GenericMethods.isElementDisplayed(By.xpath("//input[@id='search_inventory_autocomplete']"), "Search Inventory List Search box to search the WRIN");
		// User should be able to view the label "WRIN, description, case, pack, loose and item total"
		boolean condition13=GenericMethods.textCompare("WRIN", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[2]")), "WRIN cloumn header"));
		boolean condition14=GenericMethods.textCompare("Description", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[3]")), "Description cloumn header"));
		boolean condition15=GenericMethods.textCompare("Case", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[4]")), "Case cloumn header"));
		boolean condition16=GenericMethods.textCompare("Pack", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[5]")), "Pack cloumn header"));
		//User should be able to view the  label "frozen , refrigerated"
		boolean condition17=GenericMethods.isElementDisplayed(By.xpath("//span[text()='Frozen']"), "Frozen label");
		boolean condition18=GenericMethods.isElementDisplayed(By.xpath("//span[text()='Refrigerated']"), "Refrigerated label");
		//User should be able to view the button "cancel" and "submit"
		boolean condition19=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventory_popUp_Submit_BT, "physicalInventoryPage.DailyInventory_popUp_Submit_BT");
		boolean condition20=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventory_popUp_Cancel_BT, "physicalInventoryPage.DailyInventory_popUp_Cancel_BT");
		
		if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10 && condition11 && condition12 && condition13 &&
				condition14 && condition15 && condition16 && condition17 && condition18 && condition19 && condition20)
		{
			Reporter.reportPassResult(
					browser,
					"All the fields should display as expected",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the fields should display as expected",
					"Fail");
			AbstractTest.takeSnapShot();
		}


		
	}
	
	
	//TC4092 : Verify the smart section to add wrin on physical inventory page
	
	
	
	@Test()
	public void physicalInventory_US854_TC4092() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US854_TC4092";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String wrinId=GlobalVariable.createDailyInventoryWrin2;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Go to daily Inventory page
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT, "physicalInventoryPage.CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//Search and select a inventory
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.clear();
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.sendKeys(wrinId);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size = driver.findElements(By.xpath("//strong[text()='" + wrinId + "']")).size();
		driver.findElement(By.xpath("(//strong[text()='" + wrinId + "'])[" + size + "]")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.NewItemAdded_Confirmation_MSG));
		if(GenericMethods.isElementDisplayed(physicalInventoryPage.NewItemAdded_Confirmation_MSG, "physicalInventoryPage.NewItemAdded_Confirmation_MSG"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the WRIN ",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the WRIN ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		

		
	}
	
	
	
	//TC4093 : Verify the view inventory screen
	@Test()
	public void physicalInventory_US854_TC4093() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US854_TC4093";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String inventoryTime=GlobalVariable.time;
		String date=GlobalVariable.createDate;
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		String timePattern ="(\\d{1,2})(:)(\\d{1,2})";

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(2000);
		String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
		System.out.println("time"+time);
		physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		Thread.sleep(3000);
		physicalInventoryPage.clickOnPostedInventory(date, time);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//User should be able to view print icon on top right corner
		boolean condition1=GenericMethods.isElementDisplayed(By.xpath("//a[@class='fa fa-print icon-print']"), "Print Button");
		//User should be able to view the header "daily inventory list"
		boolean condition2=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title, "physicalInventoryPage.DailyInventoryList_Title");
		//User should be able to view the label date with calendar icon and date visible below it
		boolean condition3=GenericMethods.isElementDisplayed(By.xpath("//div[@id='readonly_inventory-info-modal-body']/div/div/label[text()='Date:']"), "Daily Invendory date label");
		boolean condition4=Pattern.compile(datepattern).matcher(driver.findElement(By.xpath("//input[@id='readonly_phys_inv_date']")).getAttribute("value")).matches();
		//User should be able to view the label time with clock icon and time visible below it
		boolean condition5=GenericMethods.isElementDisplayed(By.xpath("//div[@id='readonly_inventory-info-modal-body']/div/div/label[text()='Time:']"), "Daily Invendory Time label");
		boolean condition6=Pattern.compile(timePattern).matcher(driver.findElement(By.xpath("//input[@id='readonly_phys_inv_time']")).getAttribute("value")).matches();
		// User should be able to view the label "WRIN, description, case, pack, loose and item total"
		boolean condition7=GenericMethods.textCompare("WRIN", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[2]")), "WRIN cloumn header"));
		boolean condition8=GenericMethods.textCompare("Description", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[3]")), "Description cloumn header"));
		boolean condition9=GenericMethods.textCompare("Case", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[4]")), "Case cloumn header"));
		boolean condition10=GenericMethods.textCompare("Pack", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[5]")), "Pack cloumn header"));
		boolean condition11=GenericMethods.textCompare("Loose", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[6]")), "Loose cloumn header"));
		boolean condition12=GenericMethods.textCompare("Item Total", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[7]")), "Item total cloumn header"));
		//User should be able to view the "close" button
		boolean condition13=GenericMethods.isElementDisplayed(By.xpath("//eb-button[@id='readonly-inventory-close-btn']/button[text()='Close']"), "Close Button");
		if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10 && condition11 && condition12 && condition13 
				)
		{
			Reporter.reportPassResult(
					browser,
					"All the fields should display as expected",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the fields should display as expected",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
		
		
		//TC4094 : 	Verify the view inventory screen with all section maximized
		@Test()
		public void physicalInventory_US854_TC4094() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US854_TC4094";
			String password = LoginTestData.level1_SSO_Password;
			String userId = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
			String inventoryTime=GlobalVariable.time;
			String date=GlobalVariable.createDate;
			String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
			String timePattern ="(\\d{1,2})(:)(\\d{1,2})";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
			Thread.sleep(3000);
			physicalInventoryPage.clickOnPostedInventory(date, time);
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			//User should be able to view print icon on top right corner
			boolean condition1=GenericMethods.isElementDisplayed(By.xpath("//a[@class='fa fa-print icon-print']"), "Print Button");
			//User should be able to view the header "daily inventory list"
			boolean condition2=GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title, "physicalInventoryPage.DailyInventoryList_Title");
			//User should be able to view the label date with calendar icon and date visible below it
			boolean condition3=GenericMethods.isElementDisplayed(By.xpath("//div[@id='readonly_inventory-info-modal-body']/div/div/label[text()='Date:']"), "Daily Invendory date label");
			boolean condition4=Pattern.compile(datepattern).matcher(driver.findElement(By.xpath("//input[@id='readonly_phys_inv_date']")).getAttribute("value")).matches();
			//User should be able to view the label time with clock icon and time visible below it
			boolean condition5=GenericMethods.isElementDisplayed(By.xpath("//div[@id='readonly_inventory-info-modal-body']/div/div/label[text()='Time:']"), "Daily Invendory Time label");
			boolean condition6=Pattern.compile(timePattern).matcher(driver.findElement(By.xpath("//input[@id='readonly_phys_inv_time']")).getAttribute("value")).matches();
			// User should be able to view the label "WRIN, description, case, pack, loose and item total"
			boolean condition7=GenericMethods.textCompare("WRIN", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[2]")), "WRIN cloumn header"));
			boolean condition8=GenericMethods.textCompare("Description", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[3]")), "Description cloumn header"));
			boolean condition9=GenericMethods.textCompare("Case", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[4]")), "Case cloumn header"));
			boolean condition10=GenericMethods.textCompare("Pack", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[5]")), "Pack cloumn header"));
			boolean condition11=GenericMethods.textCompare("Loose", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[6]")), "Loose cloumn header"));
			boolean condition12=GenericMethods.textCompare("Item Total", GenericMethods.getText(driver.findElement(By.xpath("//table[@class='display table nowrap accordion dataTable no-footer']/thead/tr/th[7]")), "Item total cloumn header"));
			//User should be able to view the "close" button
			boolean condition13=GenericMethods.isElementDisplayed(By.xpath("//eb-button[@id='readonly-inventory-close-btn']/button[text()='Close']"), "Close Button");
			if(condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7 && condition8 && condition9 && condition10 && condition11 && condition12 && condition13 
					)
			{
				Reporter.reportPassResult(
						browser,
						"All the fields should display as expected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"All the fields should display as expected",
						"Fail");
				AbstractTest.takeSnapShot();
			}

		}
	
	//TC4095 : Verify the dialogue box for submit inventory
	
	
	
		@Test()
		public void physicalInventory_US854_TC4095() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US854_TC4095";
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
			String inventoryTime=GlobalVariable.time;
			String date=GlobalVariable.createDate;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			if(GenericMethods.isElementDisplayed(physicalInventoryPage.Confirmation_PopUp_YES_BT, "physicalInventoryPage.Confirmation_PopUp_YES_BT") &&
					GenericMethods.isElementDisplayed(physicalInventoryPage.Confirmation_PopUp_NO_BT, "physicalInventoryPage.Confirmation_PopUp_NO_BT")	)
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the dialogue box, 'are you sure you want to submit this daily inventory?' with 'yes' and 'no' button",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the dialogue box, 'are you sure you want to submit this daily inventory?' with 'yes' and 'no' button",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		

			
		}
		
		
	
	//TC4096 : 	Verify the physical inventory post task
	
	
	
		@Test()
		public void physicalInventory_US854_TC4096() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US854_TC4096";
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
			String inventoryTime=GlobalVariable.time;
			String date=GlobalVariable.createDate;
			
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
			Thread.sleep(3000);
			if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG, "physicalInventoryPage.DailyInventorySaved_Confirmation_MSG"))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the success message 'Daily inventory saved' at the bottom of the screen",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the success message 'Daily inventory saved' at the bottom of the screen",
						"Fail");
				AbstractTest.takeSnapShot();
			}

			
		}
		
		
	
	//TC4493 : View button fetaure of submitted PI
	
	
		@Test()
		public void physicalInventory_US854_TC4493() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US854_TC4493";
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
			String inventoryTime=GlobalVariable.time;
			String date=GlobalVariable.createDate;
			
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
			Thread.sleep(3000);
			physicalInventoryPage.clickOnPostedInventory(date, time);
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(4000);
			GenericMethods.clickOnElement(physicalInventoryPage.ViewInventoryPopUp_Close_BT, "physicalInventoryPage.ViewInventoryPopUp_Close_BT");
			Thread.sleep(1500);
			physicalInventoryPage.clickOnPostedInventory(date, time);
			if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title, "physicalInventoryPage.DailyInventoryList_Title"))
			{
				Reporter.reportPassResult(
						browser,
						"User should open the submitted PI",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should open the submitted PI",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
