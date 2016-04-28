package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US1046_AbilityToRestoreDeletedInvoicesManualVendorsAndCustomLists
		extends AbstractTest {
	
	// TC1798: Verify that UI of the Restore Page on Manual Vendors screen..
	@Test()
	public void manualVendor_US1046_TC1798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.RestoreManualVendor_Title));
		// Verify that manual vendor should be restored and displayed in manual vendor page
		if (Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_VendorName_Header) 
				& Base.isElementDisplayed(manualVendorsPage.RestoreManualVendor_ManualNumber_Header)){
			Reporter.reportPassResult(
					browser,"manualVendor_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1046_TC1798","manualVendor_US1046_TC1798",
					"User should be able to view Restore Manual Vendor table",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1046_TC1798");
		}
	}
	
	// TC1804: Verify the visibility and restore functionality on Restore Manual Vendor Page. 
	@Test()
	public void manualVendor_US1046_TC1804() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// Create a new vendor
		manualVendorsPage.createANewVendor(newVendorName, randomNum);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
		Thread.sleep(5000);
		//click on edit button for the vendor
		Base.scrollToTheElement(manualVendorsPage.editVendor_BT(newVendorName));
		manualVendorsPage.editVendor_BT(newVendorName).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		//click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
		//click on submit button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message)).click();
		Thread.sleep(4000);
		manualVendorsPage.restoreManualVendor(newVendorName);
		// verify that operator is able to restore deleted manual vendor
		if (Base.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName))) {
			Reporter.reportPassResult(
					browser,"manualVendor_US1046_TC1804",
					"User should be able to view the manual vendor=x restored.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"manualVendor_US1046_TC1804","manualVendor_US1046_TC1804",
					"User should be able to view the manual vendor=x restored.",
					"Fail");
			AbstractTest.takeSnapShot("manualVendor_US1046_TC1804");
		}
	}
	

	
}
