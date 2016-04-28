package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;
import sprint2.AbstractTest;

public class US826_AbilityToDeleteAManualPurchaseVendor extends AbstractTest
{
	
	//TC1553: Verify warning message while deleting a manual vendor from manual purchase vendor edit page.
		@Test()
		public void manualVendor_US826_TC1553() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.navigateToInventoryManagement().goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
			//Verify that delete vendor button for a vendor should be displayed
			manualVendorsPage.editVendor_BT(vendorName).click();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
			//Verify that user should be able to view the confirmation message
			boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
			if (deleteVendorConfirmationDisplayed 
					& manualVendorsPage.DeleteVendorPopUp_Confirmation_Message.getText().contains("Are you sure you want to proceed?")) {
				Reporter.reportPassResult(
						browser,"manualVendor_US826_TC1553",
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"manualVendor_US826_TC1553","manualVendor_US826_TC1553",
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
						"Fail");
				AbstractTest.takeSnapShot("manualVendor_US826_TC1553");
			}
		}

		//TC1552: Verify that the user has an ability to delete a manual vendor on the manual purchase vendor edit page.
		@Test()
		public void manualVendor_US826_TC1552() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String manualNumber=Integer.toString(Base.generateNdigitRandomNumber(3));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.navigateToInventoryManagement().goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(vendorName,manualNumber);
			// Click on the edit vendor button
			WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
			Thread.sleep(4000);
			vendor.click();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
			//Verify that user should be able to view the confirmation message
			boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
			Thread.sleep(4000);
			//verify that operator is able to delete the manual vendor
			if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
				Reporter.reportPassResult(
						browser,"manualVendor_US826_TC1552",
						"User should be able to delete the manual purchase vendor.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"manualVendor_US826_TC1552","manualVendor_US826_TC1552",
						"User should be able to delete the manual purchase vendor.",
						"Fail");
				AbstractTest.takeSnapShot("manualVendor_US826_TC1552");
			}
		}
	
		//TC2841:Verify the option to proceed with  "delete"  while deleting manual vendor on manual purchase vendor landing page.
		@Test()
		public void manualVendor_US826_TC2841() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String manualNumber=Integer.toString(Base.generateNdigitRandomNumber(3));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.navigateToInventoryManagement().goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(vendorName,manualNumber);
			// Click on the edit vendor button
			WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
			Thread.sleep(4000);
			vendor.click();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
			//Verify that user should be able to view the confirmation message
			boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();
			Thread.sleep(4000);
			//verify that operator is able to delete the manual vendor
			if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
				Reporter.reportPassResult(
						browser,"manualVendor_US826_TC2841",
						"User should be able to procees with delete button on manual purchase vendor page.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"manualVendor_US826_TC2841","manualVendor_US826_TC2841",
						"User should be able to procees with delete button on manual purchase vendor page.",
						"Fail");
				AbstractTest.takeSnapShot("manualVendor_US826_TC2841");
			}
		}
	
	
}
