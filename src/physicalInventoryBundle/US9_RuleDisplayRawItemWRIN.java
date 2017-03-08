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

public class US9_RuleDisplayRawItemWRIN extends AbstractTest{
	
	//TC1826 : Verify that the user is able is view the 8 digit WRIN in the "WRIN" column on the Physical Inventory page.
	@Test(groups="Smoke")
	public void physicalInventory_US9_TC1826() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US9_TC1826";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		if(physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForEachRawItem()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the 8-digit WRIN=xxxxx-xxx in WRIN column.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the 8-digit WRIN=xxxxx-xxx in WRIN column.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1827 : Verify that an 8 digit WRIN with leading zeroes will be displayed with the leading zeroes.
	@Test()
	public void physicalInventory_US9_TC1827() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US9_TC1827";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String wrinIdWithLeadingZero = GlobalVariable.createDailyInventoryWrinLeadingZero;
		String description = GlobalVariable.createDailyInventoryWrinLeadingZero_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(wrinIdWithLeadingZero,description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the WRIN number with leading zeroes.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the WRIN number with leading zeroes.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1835 : Verify that the user should be able to view the 8 digit WRIN in the format as first 5 digits and then a dash ("-") followed by the remaining 3 digits.
	@Test()
	public void physicalInventory_US9_TC1835() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US9_TC1835";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForEachRawItem()){
			Reporter.reportPassResult(
					browser,
					"Verify that the user should be able to view the 8 digit WRIN in the format as first 5 digits and then a dash (-) followed by the remaining 3 digits.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify that the user should be able to view the 8 digit WRIN in the format as first 5 digits and then a dash (-) followed by the remaining 3 digits.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1836 : Verify that an 8 digit WRIN with trailing zeroes will be displayed with the trailing zeroes.
	@Test()
	public void physicalInventory_US9_TC1836() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US9_TC1836";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String wrinIdWithTrailingZero = GlobalVariable.createDailyInventoryWrinTrailingZero;
		String description = GlobalVariable.createDailyInventoryWrinTrailingZero_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(wrinIdWithTrailingZero,description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the WRIN number with trailing zeroes.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the WRIN number with trailing zeroes.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1837 : Verify that the user should be able to view the 8 digit WRIN justified on left side within the "WRIN" column.
	@Test()
	public void physicalInventory_US9_TC1837() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US9_TC1837";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(1500);
		// Verify that the user should be able to view the 8 digit WRIN justified on left side within the "WRIN" column.
		if (physicalInventoryPage.verifyWRINColumnIsOnLeft()
				&& physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForEachRawItem()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the WRIN number justified on left side within the WRIN column.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the WRIN number justified on left side within the WRIN column.",
					"Fail");
			AbstractTest.takeSnapShot();

		}
	}
}
