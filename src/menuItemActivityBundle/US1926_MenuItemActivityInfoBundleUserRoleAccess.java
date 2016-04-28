package menuItemActivityBundle;

import java.io.IOException;

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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import sprint2.AbstractTest;

public class US1926_MenuItemActivityInfoBundleUserRoleAccess extends AbstractTest{
	
	//TC3626_Level1 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level1",
					"Level1 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level1","menuItemActivity_US1926_TC3626_Level1",
					"Level1 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level1");
		}
	}
	
	//TC3626_Level2 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level2",
					"Level2 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level2","menuItemActivity_US1926_TC3626_Level2",
					"Level2 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level2");
		}
	}
	
	//TC3626_Level3 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level3_SSO_UserId;
		String password = LoginTestData.level3_SSO_Password;
		String storeId = LoginTestData.level3StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level3",
					"Level3 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level3","menuItemActivity_US1926_TC3626_Level3",
					"Level3 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level3");
		}
	}
	
	//TC3626_Level4 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level4",
					"Level4 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level4","menuItemActivity_US1926_TC3626_Level4",
					"Level4 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level4");
		}
	}
	
	//TC3626_Level5 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level5",
					"Level5 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level5","menuItemActivity_US1926_TC3626_Level5",
					"Level5 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level5");
		}
	}
	
	//TC3626_Level6 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		String storeId = LoginTestData.level6StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Level6",
					"Level6 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Level6","menuItemActivity_US1926_TC3626_Level6",
					"Level6 User should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Level6");
		}
	}
	
	//TC3626_Operator : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Operator",
					"operator should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Operator","menuItemActivity_US1926_TC3626_Operator",
					"operator should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Operator");
		}
	}
	
	//TC3626_Supervisor : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_Supervisor",
					"supervisor should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_Supervisor","menuItemActivity_US1926_TC3626_Supervisor",
					"supervisor should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_Supervisor");
		}
	}
	
	//TC3626_SupervisorWithRoleAssignment : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_SupervisorWithRoleAssignment","menuItemActivity_US1926_TC3626_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_SupervisorWithRoleAssignment");
		}
	}
	
	//TC3626_OrgAdmin : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3626_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)
				& menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1926_TC3626_OrgAdmin",
					"OrgAdmin should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1926_TC3626_OrgAdmin","menuItemActivity_US1926_TC3626_OrgAdmin",
					"OrgAdmin should be able to view the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3626_OrgAdmin");
		}
	}

	//TC3629_Level1 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level1",
					"Level 1 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level1_Condition1","menuItemActivity_US1926_TC3629_Level1",
					"Level 1 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level1_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level1",
					"Level 1 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level1_Condition2","menuItemActivity_US1926_TC3629_Level1",
					"Level 1 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level1_Condition2");
		}
	}
	
	//TC3629_Level2 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level2",
					"Level 2 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level2_Condition1","menuItemActivity_US1926_TC3629_Level2",
					"Level 2 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level2_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level2",
					"Level 2 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level2_Condition2","menuItemActivity_US1926_TC3629_Level2",
					"Level 2 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level2_Condition2");
		}
	}
	
	//TC3629_Level3 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level3_SSO_UserId;
		String password = LoginTestData.level3_SSO_Password;
		String storeId = LoginTestData.level3StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level3",
					"Level 3 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level3_Condition1","menuItemActivity_US1926_TC3629_Level3",
					"Level 3 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level3_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level3",
					"Level 3 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level3_Condition2","menuItemActivity_US1926_TC3629_Level3",
					"Level 3 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level3_Condition2");
		}
	}
	
	//TC3629_Level4 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level4",
					"Level 4 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level4_Condition1","menuItemActivity_US1926_TC3629_Level4",
					"Level 4 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level4_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level4",
					"Level4 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level4_Condition2","menuItemActivity_US1926_TC3629_Level4",
					"Level 4 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level4_Condition2");
		}
	}
	
	//TC3629_Level5 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level5",
					"Level 5 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level5_Condition1","menuItemActivity_US1926_TC3629_Level5",
					"Level 5 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level5_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level5",
					"Level 5 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level5_Condition2","menuItemActivity_US1926_TC3629_Level5",
					"Level 5 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level5_Condition2");
		}
	}
	
	//TC3629_Level6 : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		String storeId = LoginTestData.level6StoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"Level 6 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level6_Condition1","menuItemActivity_US1926_TC3629_Level6",
					"Level 6 user should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level6_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"Level 6 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Level6_Condition2","menuItemActivity_US1926_TC3629_Level6",
					"Level 6 User should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Level6_Condition2");
		}
	}
	
	//TC3629_Operator : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Operator",
					"Operator should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Operator_Condition1","menuItemActivity_US1926_TC3629_Operator",
					"Operator should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Operator_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"Operator should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Operator_Condition2","menuItemActivity_US1926_TC3629_Operator",
					"Operator should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Operator_Condition2");
		}
	}
	
	//TC3629_Supervisor : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_Supervisor",
					"Supervisor should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Supervisor_Condition1","menuItemActivity_US1926_TC3629_Supervisor",
					"Supervisor should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Supervisor_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"Supervisor should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_Supervisor_Condition2","menuItemActivity_US1926_TC3629_Supervisor",
					"Supervisor should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_Supervisor_Condition2");
		}
	}
	
	//TC3629_supervisorWithRoleAssignment : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment_Condition1","menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"SupervisorWithRoleAssignment should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment_Condition2","menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_SupervisorWithRoleAssignment_Condition2");
		}
	}
	
	//TC3629_OrgAdmin : User can use all of the functionality available on the Menu Item Activity  & Information page.
	@Test()
	public void menuItemActivity_US1926_TC3629_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
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
					browser, "menuItemActivity_US1926_TC3629_OrgAdmin",
					"OrgAdmin should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_OrgAdmin_Condition1","menuItemActivity_US1926_TC3629_OrgAdmin",
					"OrgAdmin should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_OrgAdmin_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3629_Level6",
					"OrgAdmin should be able to see Recipe and Historic Recipe information for the menu Item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3629_OrgAdmin_Condition2","menuItemActivity_US1926_TC3629_OrgAdmin",
					"OrgAdmin should be able to see Recipe and Historic Recipe information for the menu Item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3629_OrgAdmin_Condition2");
		}
	}

	//TC3631_Level1 : To Verify that user with Level 1 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level1",
					"Level 1 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level1","menuItemActivity_US1926_TC3631_Level1",
					"Level 1 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level1");
		}
	}
	
	//TC3631_Level2 : To Verify that user with Level 2 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level2",
					"Level 2 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level2","menuItemActivity_US1926_TC3631_Level2",
					"Level 2 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level2");
		}
	}
	
	//TC3631_Level3 : To Verify that user with Level 3 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level3_SSO_UserId;
		String password = LoginTestData.level3_SSO_Password;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level3",
					"Level 3 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level3","menuItemActivity_US1926_TC3631_Level3",
					"Level 3 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level3");
		}
	}
	
	//TC3631_Level4 : To Verify that user with Level 4 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level4",
					"Level 4 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level4","menuItemActivity_US1926_TC3631_Level4",
					"Level 4 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level4");
		}
	}
	
	//TC3631_Level5 : To Verify that user with Level 5 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level5",
					"Level 5 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level5","menuItemActivity_US1926_TC3631_Level5",
					"Level 5 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level5");
		}
	}
	
	//TC3631_Level6 : To Verify that user with Level 6 Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Level6",
					"Level 6 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Level6","menuItemActivity_US1926_TC3631_Level6",
					"Level 6 User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Level6");
		}
	}
	
	//TC3631_Operator : To Verify that user with Operator Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Operator",
					"Operator User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Operator","menuItemActivity_US1926_TC3631_Operator",
					"Operator User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Operator");
		}
	}
	
	//TC3631_Supervisor : To Verify that user with Supervisor Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_Supervisor",
					"Supervisor User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_Supervisor","menuItemActivity_US1926_TC3631_Supervisor",
					"Supervisor User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_Supervisor");
		}
	}
	
	//TC3631_SupervisorWithRoleAssignment : To Verify that user with Supervisor Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_SupervisorWithRoleAssignment","menuItemActivity_US1926_TC3631_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_SupervisorWithRoleAssignment");
		}
	}
	
	//TC3631_OrgAdmin : To Verify that user with OrgAdmin Access is able to access Menu Item Activity KPI screen.
	@Test()
	public void menuItemActivity_US1926_TC3631_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.Kpi_Toggle_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(menuItemActivityPage.Kpi_Model_Header)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsEmployeeMeals_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsWasted_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsPromo_Table)
				& Base.isElementDisplayed(menuItemActivityPage.KpiModel_TopMenuItemsManagerMeals_Table)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US1926_TC3631_OrgAdmin",
					"OrgAdmin User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US1926_TC3631_OrgAdmin","menuItemActivity_US1926_TC3631_OrgAdmin",
					"OrgAdmin User should be able to see expanded KPi Model and it should display KPIs of the day",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US1926_TC3631_OrgAdmin");
		}
	}
}
