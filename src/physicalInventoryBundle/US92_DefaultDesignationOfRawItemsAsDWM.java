package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US92_DefaultDesignationOfRawItemsAsDWM extends AbstractTest{

	//TC284 : Verify that user is able to see the  list of Raw Items designated as Daily.
	@Test()
	public void physicalInventory_US92_TC284() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US92_TC284";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createDailyInventoryWrin2;
		String samplewRINID3 = GlobalVariable.createDailyInventoryWrin3;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		boolean wrin1Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		boolean wrin2Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID2);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID3);
		boolean wrin3Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID3);
		if(wrin1Displayed & wrin2Displayed & wrin3Displayed){
			Reporter.reportPassResult(
					browser,
					"User should be able to view wrin D1,D2,D3 already added into daily inventory list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view wrin D1,D2,D3 already added into daily inventory list",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC285 : Verify that user is able to see the  list of Raw Items designated as Weekly.
	@Test()
	public void physicalInventory_US92_TC285() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US92_TC285";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createWeeklyInventoryWrin2;
		String samplewRINID3 = GlobalVariable.createWeeklyInventoryWrin3;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateWeeklyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		boolean wrin1Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		boolean wrin2Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID2);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID3);
		boolean wrin3Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID3);
		if(wrin1Displayed & wrin2Displayed & wrin3Displayed){
			Reporter.reportPassResult(
					browser,
					"User should be able to view W1,W2,W3 in weekly inventory list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view W1,W2,W3 in weekly inventory list",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC286 : Verify that user is able to see the  list of Raw Items designated as Monthly.
	@Test()
	public void physicalInventory_US92_TC286() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US92_TC286";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createMonthlyInventoryWrin2;
		String samplewRINID3 = GlobalVariable.createMonthlyInventoryWrin3;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		boolean wrin1Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		boolean wrin2Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID2);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID3);
		boolean wrin3Displayed = physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID3);
		if(wrin1Displayed & wrin2Displayed & wrin3Displayed){
			Reporter.reportPassResult(
					browser,
					"User should be able to view M1,M2,M3 in monthly inventory list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view M1,M2,M3 in monthly inventory list",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
