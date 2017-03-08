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

public class US10_RuleDisplayRawItemLongDescription extends AbstractTest{
	
	// TC1971: Verify that the user is able to view long description corresponding to the WRIN number for the correct Raw Item.
	@Test()
	public void physicalInventory_US10_TC1971() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US10_TC1971";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String wrin_Description = GlobalVariable.createDailyInventoryWrin1_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if (physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(samplewRINID1, wrin_Description)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view long description=x corresponding to the WRIN number=y.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view long description=x corresponding to the WRIN number=y.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	// TC1973: Verify that the user is able to view the description with mixed case.
	@Test()
	public void physicalInventory_US10_TC1973() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US10_TC1973";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin3;
		String wrin_Description = GlobalVariable.createDailyInventoryWrin3_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if (physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(samplewRINID1, wrin_Description)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the description with mixed case",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the description with mixed case",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
