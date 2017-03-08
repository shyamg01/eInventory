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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.AbstractTest;

public class US460_SearchAndAddAnAdhocRawItemToPhysicalInventoryList extends AbstractTest{
	
	//TC1252 : Verify the search option on physical inventory detail page.
	@Test()
	public void physicalInventory_US460_TC1252() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US460_TC1252";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.dailyInventoryWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchAndAddRawItem(samplewRINID1);
		if(physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to add item D1 in existing inventory list.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to add item D1 in existing inventory list.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	/*TC1253 : Verify the user is able to search WRIN ID , enter quantities for the searched WRIN ID and validate 
	the "Add" button to include the raw items to current physical inventory on "Physical Inventory" detail page.*/
	@Test()
	public void physicalInventory_US460_TC1253() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US460_TC1253";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.dailyInventoryWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchAndAddRawItem(samplewRINID1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		physicalInventoryPage.addQuantityForARawItem(samplewRINID1, "1", "1", "1");
		if(!physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).isEmpty()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the updated field total value.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the updated field total value.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
