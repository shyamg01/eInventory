package menuItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;

public class US1047_MenuItemActivityWhenUserEntersSearchCriteria extends AbstractTest{
	
	//TC1732: Verify that the user should be able to view the collapsed rolled up daily totals for a menu item on the Menu Item Activity page.
	@Test()
	public void menuItemActivity_US1047_TC1732() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1047_TC1732";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItem = GlobalVariable.menuItem2;
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
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectEndTime(endTime).selectStartTime(startTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (menuItemActivityPage.verifyRecordsAreCollapsed()) {
			Reporter.reportPassResult(
					browser,
					"System should display the collapsed rolled up daily totals for Menu Item X",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"System should display the collapsed rolled up daily totals for Menu Item X",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC1733: Verify that the user should be able to expand the days to view the Menu Item activity at the 15 minute detail for the searched menu item.
	@Test()
	public void menuItemActivity_US1047_TC1733() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US1047_TC1733";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItem = GlobalVariable.menuItem2;
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
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectEndTime(endTime).selectStartTime(startTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		menuItemActivityPage.expandDateGroup();
		if (menuItemActivityPage.verifyRecordsAreExpanded() & 
				menuItemActivityPage.verifyMenuActivityTimeInDetailForSelectedDate(startDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the expanded Activity for Menu Item X in interval of 15 min each for the selected date and time.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the expanded Activity for Menu Item X in interval of 15 min each for the selected date and time.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Base.toReachTopOfthePage();
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

}
