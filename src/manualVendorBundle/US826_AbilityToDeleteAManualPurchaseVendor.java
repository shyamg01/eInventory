package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.ViewPurchaseHistoryPage;

public class US826_AbilityToDeleteAManualPurchaseVendor extends AbstractTest
{
	
	//TC1553: Verify warning message while deleting a manual vendor from manual purchase vendor edit page.
		@Test()
		public void manualVendor_US826_TC1553() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1553";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
			String newVendorName = "Testauto" + randomNum;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			manualVendorsPage.createANewVendor(newVendorName,randomNum);
			Thread.sleep(2000);
			//Verify that delete vendor button for a vendor should be displayed
			GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT));
			//Verify that user should be able to view the confirmation message
			if (GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message,"DeletevendorDetailsPopUp_Confirmation_Message")) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}

		//TC1552: Verify that the user has an ability to delete a manual vendor on the manual purchase vendor edit page.
		@Test()
		public void manualVendor_US826_TC1552() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1552";
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
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(vendorName,manualNumber);
			// Click on the edit vendor button
			WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
			Thread.sleep(4000);
			GenericMethods.clickOnElement(vendor,vendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			boolean deleteVendorWarningMsgDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message,"DeletevendorDetailsPopUp_Confirmation_Message");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			//Verify that user should be able to view the confirmation message
			boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message,"DeleteVendorPopUp_VendorDeleted_Message");
			Thread.sleep(4000);
			//verify that operator is able to delete the manual vendor
			if (deleteVendorWarningMsgDisplayed & deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to delete the manual purchase vendor.",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to delete the manual purchase vendor.",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		//TC2841:Verify the option to proceed with  "delete"  while deleting manual vendor on manual purchase vendor landing page.
		@Test()
		public void manualVendor_US826_TC2841() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC2841";
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
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(vendorName,manualNumber);
			// Click on the edit vendor button
			WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
			Thread.sleep(4000);
			GenericMethods.clickOnElement(vendor,vendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			//Verify that user should be able to view the confirmation message
			boolean deleteVendorWarningMsgDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message,"DeletevendorDetailsPopUp_Confirmation_Message");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message,"DeleteVendorPopUp_VendorDeleted_Message");
			Thread.sleep(4000);
			//verify that operator is able to delete the manual vendor
			if (deleteVendorWarningMsgDisplayed & deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to procees with delete button on manual purchase vendor page.",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to procees with delete button on manual purchase vendor page.",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		//TC1554: Verify the option to proceed with  cancel button while deleting manual vendor on manual purchase vendor landing page.
		@Test()
		public void manualVendor_US826_TC1554() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1554";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
			String newVendorName = "Testauto" + randomNum;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			manualVendorsPage.createANewVendor(newVendorName,randomNum);
			Thread.sleep(2000);
			//Verify that delete vendor button for a vendor should be displayed
			GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT));
			//Verify that user should be able to view the confirmation message
			if (GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_Confirmation_Message,"DeletevendorDetailsPopUp_Confirmation_Message")
					& GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT,"DeleteVendorConfirmationPopUp_Yes_BT")
					& GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT,"DeleteVendorConfirmationPopUp_No_BT")) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page along with Yes and No Buttons",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view warning message while deleting a manual vendor from manual purchase vendor edit page along with Yes and No Buttons",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			GenericMethods.clickOnElement(manualVendorsPage.DeleteVendorConfirmationPopUp_No_BT,"DeleteVendorConfirmationPopUp_No_BT");
			GenericMethods.clickOnElement(manualVendorsPage.EditVendorDetailsPopUp_Cancel_BT,"EditVendorDetailsPopUp_Cancel_BT");
			if(Base.isElementDisplayed(manualVendorsPage.ManualVendors_Label)){
				Reporter.reportPassResult(
						browser,
						"User should be navigate back to manual purchase vendor landing page on clicking Cancel button is Edit vendor details Page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be navigate back to manual purchase vendor landing page on clicking Cancel button is Edit vendor details Page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		// TC1556: Verify the purchase history with the vendor name will stay in tact, after the vendor is deleted from manual purchase vendor edit page.
		@Test()
		public void manualVendor_US826_TC1556() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1556";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
			String itemQty="1";
			String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
			String invoiceId = Base.randomNumberFiveDigit();
			String startDate = GlobalVariable.startDate;
			String endDate = GlobalVariable.endDate;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
			//Associate a raw item with the new vendor
			homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
			//Create a new manual purchase and post the purchase
			PurchasesPage purchasesPage = homePage.goToPurchaseLandingPage();
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			manualInvoiceNewPage.createAManualPurchase(newVendorName, invoiceId, wrinIDForNewVendor, itemQty, "10");
			purchasesPage.approveAManualInvoice(invoiceId);
			ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
			Thread.sleep(5000);
			GenericMethods.clickOnElement(purchasesPage.ViewHistory_BT,"ViewHistory_BT");
			GenericMethods.clickOnElement(viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD,"ViewHistory_Vendor_DD");
			GenericMethods.clickOnElement(viewPurchaseHistoryPage.ViewHistory_ShowResults_BT,"ViewHistory_ShowResults_BT");
			Thread.sleep(5000);
			System.out.println("Invoice posted "+ viewPurchaseHistoryPage.verifyManualInvoicePosted(invoiceId));
			GenericMethods.clickOnElement(homePage.goToManualVendorsPage().editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
			Thread.sleep(4000);
			//Verify vendor is deleted
			boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
			//Navigate to purchase Landing page and get purchase history
			GenericMethods.clickOnElement(homePage.goToPurchaseLandingPage().ViewHistory_BT,"ViewHistory_BT");
			//Click on the posted purchase record that was created above
			wait.until(ExpectedConditions.visibilityOf(viewPurchaseHistoryPage.ViewHistory_Vendor_DD));
			GenericMethods.clickOnElement(viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD,"ViewHistory_Vendor_DD");
			GenericMethods.clickOnElement(viewPurchaseHistoryPage.ViewHistory_ShowResults_BT,"ViewHistory_ShowResults_BT");
			Thread.sleep(5000);
			System.out.println("Invoice Id "+invoiceId);
			viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(invoiceId);
			//Verify that deleted vendor name should displayed in the posted purchase
			if ( vendorDeletedOnCLickingDeleteBtn && viewPurchaseHistoryPage.ViewInvoiceForm_Vendor_Value.getText().equals(newVendorName)) {
				Reporter.reportPassResult(
						browser,
						"Purchase history with the vendor name should stay in tact, after the vendor is deleted from manual vendor page",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"Purchase history with the vendor name should stay in tact, after the vendor is deleted from manual vendor page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		// TC1561: Verify the raw item will not be designated as "manual purchase" once the manual vendor is deleted.
		@Test()
		public void manualVendor_US826_TC1561() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1561";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
			String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
			//Associate a raw item with the new vendor
			RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
			GenericMethods.clickOnElement(homePage.goToManualVendorsPage().editVendor_BT(newVendorName),"newVendorName");
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
			Thread.sleep(4000);
			//Verify vendor is deleted
			boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
			//Click on the posted purchase record that was created above
			homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor);
			GenericMethods.clickOnElement(rawItemActivityPage.Information_BT,"Information_BT");
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
			Select vendorDD = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
			System.out.println(vendorDD.getFirstSelectedOption().getText());
			//Verify that deleted vendor name should displayed in the posted purchase
			if ( vendorDeletedOnCLickingDeleteBtn && vendorDD.getFirstSelectedOption().getText().equals("Select Vendor")) {
				Reporter.reportPassResult(
						browser,
						"Vendor should get removed from Primary Vendor field and it should be Select Vendor once deleted in Manual Vendor Page",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"Vendor should get removed from Primary Vendor field and it should be Select Vendor once deleted in Manual Vendor Page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		//TC1562: Verify once deleted, the vendor is not select-able from the Manual Purchase entry screen.
		@Test()
		public void manualVendor_US826_TC1562() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1562";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
			//Create a new manual purchase and post the purchase
			PurchasesPage purchasesPage = homePage.goToPurchaseLandingPage();
			ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
			boolean vendorDisplayedInCreatePurchasePage = manualInvoiceNewPage.verifyVendorDisplayed(newVendorName);
			GenericMethods.clickOnElement(homePage.goToManualVendorsPage().editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
			Thread.sleep(4000);
			//Verify vendor is deleted
			boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
			homePage.goToPurchaseLandingPage().goToManualInvoiceNewPage();
			boolean vendorNotDisplayedInCreatePurchasePage = !manualInvoiceNewPage.verifyVendorDisplayed(newVendorName);
			//Verify that deleted vendor name should displayed in the posted purchase
			if ( vendorDisplayedInCreatePurchasePage & vendorDeletedOnCLickingDeleteBtn & vendorNotDisplayedInCreatePurchasePage) {
				Reporter.reportPassResult(
						browser,
						"User should not be able to select vendor abc from create Manual Purchase Screen once Manual Vendor is deleted",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should not be able to select vendor abc from create Manual Purchase Screen once Manual Vendor is deleted",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		// TC1697: Verify the vendor and any associated finalized manual purchases will still be view-able on the store's ledger page once the vendor is deleted.
		@Test()
		public void manualVendor_US826_TC1697() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC1697";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
			String itemQty="1";
			String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
			String invoiceId = Base.randomNumberFiveDigit();
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			System.out.println("newVendorName"+newVendorName);
			manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
			//Associate a raw item with the new vendor
			homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
			//Create a new manual purchase and post the purchase
			PurchasesPage purchasesPage = homePage.goToPurchaseLandingPage();
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			manualInvoiceNewPage.createAManualPurchase(newVendorName, invoiceId, wrinIDForNewVendor, itemQty, "10");
			purchasesPage.approveAManualInvoice(invoiceId);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
			Thread.sleep(5000);
			GenericMethods.clickOnElement(purchasesPage.ViewLedger_BT,"ViewLedger_BT");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			System.out.println("Invoice invoice in store ledger details page "+ storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(newVendorName, GlobalVariable.createDate, invoiceId));
			GenericMethods.clickOnElement(homePage.goToManualVendorsPage().editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
			Thread.sleep(4000);
			//Verify vendor is deleted
			boolean vendorDeletedOnCLickingDeleteBtn = manualVendorsPage.verifyVendorDeleted(newVendorName);
			//Navigate to purchase Landing page and get purchase history
			GenericMethods.clickOnElement(homePage.goToPurchaseLandingPage().ViewLedger_BT,"ViewLedger_BT");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			//Verify that deleted vendor name should displayed in the posted purchase
			if ( vendorDeletedOnCLickingDeleteBtn &
					storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(newVendorName, GlobalVariable.createDate, invoiceId)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view the posted manual purchase associated to vendor 'abc', after the vendor is deleted from manual vendor page",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the posted manual purchase associated to vendor 'abc', after the vendor is deleted from manual vendor page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		
		//TC2843: Verify that user is getting warning message while deleting any vendor which is associated with any Manual invoice.
		@Test()
		public void manualVendor_US826_TC2843() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="manualVendor_US826_TC2843";
			ManualVendorsPage manualVendorsPage;
			String password = LoginTestData.operator_SSO_Password;
			String userId = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String wrinIDForNewVendor = GlobalVariable.wrinIdForNewVendor;
			String itemQty="1";
			String newVendorName = "Testauto" + Base.generateNdigitRandomNumber(4);
			String newVendorNumber = String.valueOf(Base.generateNdigitRandomNumber(4));
			String invoiceId = Base.randomNumberFiveDigit();
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToManualVendorsPage();
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
			//Create a new vendor
			manualVendorsPage.createANewVendor(newVendorName, newVendorNumber);
			//Associate a raw item with the new vendor
			homePage.goToRawItemActivityPage().searchAndSelectWRINID(wrinIDForNewVendor).associateRawItemToVendor(newVendorName);
			//Create a new manual purchase and post the purchase
			homePage.goToPurchaseLandingPage();
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			manualInvoiceNewPage.createAManualPurchase(newVendorName, invoiceId, wrinIDForNewVendor, itemQty, "10");
			GenericMethods.clickOnElement(homePage.goToManualVendorsPage().editVendor_BT(newVendorName),newVendorName);
			wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
			//click on delete button
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
			//Verify that deleted vendor name should displayed in the posted purchase
			if (GenericMethods.isElementDisplayed(manualVendorsPage.DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message,"DeletevendorDetailsPopUp_PendingInvoiceConfirmation_Message")) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view the message as \"This vendor still has pending invoices. Please finalize all invoices for this vendor before deleting?\"",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the message as \"This vendor still has pending invoices. Please finalize all invoices for this vendor before deleting?\"",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			GenericMethods.clickOnElement(manualVendorsPage.DeletevendorDetailsConfirmationPopUp_OK_BT,"DeletevendorDetailsConfirmationPopUp_OK_BT");
		}
	
	
}
