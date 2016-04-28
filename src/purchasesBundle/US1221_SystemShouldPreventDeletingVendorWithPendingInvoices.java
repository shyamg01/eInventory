package purchasesBundle;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;
import sprint2.AbstractTest;

public class US1221_SystemShouldPreventDeletingVendorWithPendingInvoices extends AbstractTest
{
	
	//TC1995 : Verify the  user is restricted from deleting manual vendors that have already been tied to an existing pending manual invoice.
			@Test()
			public void purchaseBundle_US1221_TC1995() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String vendorName=GlobalVariable.vendorName;
				String wrin=GlobalVariable.createPurchaseWrin;
				String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
					
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
				ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
				ManualVendorsPage manualVendorsPage = PageFactory.initElements(driver, ManualVendorsPage.class);			
				homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
				wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
				Thread.sleep(3000);
				manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
				Thread.sleep(5000);
				if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
				{
					Reporter.reportPassResult(
							browser,"purchaseBundle_US1221_TC1995",
							"User shoudl be able to create the manual purchase",
							"Pass");
				}
				else
				{
					Reporter.reportTestFailure(
							browser,"purchaseBundle_US1221_TC1995_Condition1","purchaseBundle_US1221_TC1995",
							"User shoudl be able to create the manual purchase",
							"Fail");
					AbstractTest.takeSnapShot("purchaseBundle_US1221_TC1995_Condition1");
				}
				//Go to Manual Vendor Page
				homePage.Menu_DD_BT.click();
				wait.until(ExpectedConditions.visibilityOf(homePage.OtherInventoryFunctions_BT));
				Thread.sleep(3000);
				//Click on other Inventory function
				homePage.OtherInventoryFunctions_BT.click();
				wait.until(ExpectedConditions.visibilityOf(homePage.ManualVendors_BT));
				homePage.ManualVendors_BT.click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.ManualVendors_Label));
				Thread.sleep(7000);
				// Click on the edit vendor button
				WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
				Thread.sleep(4000);
				vendor.click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dlgContent']/p[contains(.,'Please finalize all invoices for this vendor before deleting')]")));
				if(Base.isElementDisplayed(By.xpath("//div[@id='dlgContent']/p[contains(.,'Please finalize all invoices for this vendor before deleting')]")))
				{
					Reporter.reportPassResult(
							browser,"purchaseBundle_US1221_TC1995",
							"User should not be able to delete the manual vendor",
							"Pass");
				}
				else
				{
					Reporter.reportTestFailure(
							browser,"purchaseBundle_US1221_TC1995_Condition2","purchaseBundle_US1221_TC1995",
							"User should not be able to delete the manual vendor",
							"Fail");
					AbstractTest.takeSnapShot("purchaseBundle_US1221_TC1995_Condition2");
				}
				
		
			}
			
	
	//TC1996 : Verify the user is allowed to delete a manual vendor if it has no existing pending manual purchases tied to it
	
			@Test()
			public void purchaseBundle_US1221_TC1996() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String vendorName = "Radio" + Base.generateNdigitRandomNumber(4);
				String manualNumber=Integer.toString(Base.generateNdigitRandomNumber(3));		
		
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Transfer Landing page and click on create new transfer button
				ManualVendorsPage manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
				//Create a vendor
				manualVendorsPage.createANewVendor(vendorName, manualNumber);
				Thread.sleep(7000);
				// Click on the edit vendor button
				WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
				Thread.sleep(4000);
				vendor.click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();;
				//Verify that user should be able to view the confirmation message
				boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
				System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
				Thread.sleep(4000);
				System.out.println("verify vendor deleted"+manualVendorsPage.verifyVendorDeleted(vendorName));
				//verify that operator is able to delete the manual vendor
				if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
					Reporter.reportPassResult(
							browser,"purchaseBundle_US1221_TC1996",
							"User should be able to delete the manual purchase vendor.",
							"Pass");
				} else {
					Reporter.reportTestFailure(
							browser,"purchaseBundle_US1221_TC1996","purchaseBundle_US1221_TC1996",
							"User should be able to delete the manual purchase vendor.",
							"Fail");
					AbstractTest.takeSnapShot("purchaseBundle_US1221_TC1996");
				}
				
		
			}
	
}
