package menuItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;

public class US1047_MenuItemActivityWhenUserEntersSearchCriteria extends AbstractTest{
	
	//TC1732: Verify that the user should be able to view the collapsed rolled up daily totals for a menu item on the Menu Item Activity page.
	@Test()
	public void menuItemActivity_US1047_TC1732() throws RowsExceededException,
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
		if (menuItemActivityPage.verifyRecordsAreCollapsed()) {
			Reporter.reportPassResult(
					browser,"menuItemActivity_US1047_TC1732",
					"System should display the collapsed rolled up daily totals for Menu Item X",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US1047_TC1732","menuItemActivity_US1047_TC1732",
					"System should display the collapsed rolled up daily totals for Menu Item X",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US898_TC1535_Condition2");
		}
	}

	//TC1733: Verify that the user should be able to expand the days to view the Menu Item activity at the 15 minute detail for the searched menu item.
	@Test()
	public void menuItemActivity_US1047_TC1733() throws RowsExceededException,
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
