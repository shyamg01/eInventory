package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;


public class US22_RuleDailyItemsWillShowInWeeklyListAndMonthlyList extends AbstractTest{
	
	// TC232: Verify that User is able to see all  daily inventory items in weekly inventory list.
	@Test()
	public void physicalInventory_US22_TC232() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US22_TC232";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createWeeklyInventoryWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if (physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Daily Inventpry List",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Daily Inventpry List",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.CreateInventoryPopUp_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateWeeklyInventory_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if (physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Weekly Inventpry List",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Weekly Inventpry List",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		if (physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID2)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Item associated with Weekly Inventory in Weekly Inventpry List",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Raw Item associated with Weekly Inventory in Weekly Inventpry List",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC233: Verify that User is able to see all daily and weekly inventory items in monthly inventory list.
	@Test()
	public void physicalInventory_US22_TC233() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US22_TC233";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createWeeklyInventoryWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if (physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Monthly Inventory List",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Raw Item associated with Daily Inventory in Monthly Inventory List",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		if (physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID2)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Item associated with Weekly Inventory in Monthly Inventory List",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Raw Item associated with Weekly Inventory in Monthly Inventory List",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
