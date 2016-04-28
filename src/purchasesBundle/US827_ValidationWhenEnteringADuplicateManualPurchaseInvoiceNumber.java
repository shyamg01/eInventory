package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractPage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import sprint2.AbstractTest;

public class US827_ValidationWhenEnteringADuplicateManualPurchaseInvoiceNumber extends AbstractTest
{

	//TC1555 : Verify that system should not allow user to save duplicate Invoice Number- Vendor Name combination.
	
	@Test()
	public void purchaseBundle_US827_TC1555() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//Need to completed for error message
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin1;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			purchasesPage.CreateManualInvoice_BT.click();
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendorName);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
			AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
			manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
			// Enter the quantity
			manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
			manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("3");
			manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();
			manualInvoiceNewPage.Submit_BT.click();
			// Code need to upload for the duplicate invoice
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US827_TC1555","purchaseBundle_US827_TC1555",
					"Created manual purchase should display on Purchase landing page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US827_TC1555");
		}

	}

	
	//TC1557 : Verify that system should allow user to save duplicate Invoice Number with different Vendor Name.
	@Test()
	public void purchaseBundle_US827_TC1557() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String vendorName1=GlobalVariable.vendorName1;
		String wrin=GlobalVariable.createPurchaseWrin1;
		String wrin1=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Thread.sleep(3000);
			manualInvoiceNewPage.createAManualPurchase(vendorName1, invoiceNumber, wrin1,"2","3");
			if(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG.isDisplayed())
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US827_TC1557",
						"The invoice should be created with same invoice number and different vendor name",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US827_TC1557_Condition1","purchaseBundle_US827_TC1557",
						"The invoice should be created with same invoice number and different vendor name",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US827_TC1557_Condition1");
			}
		}
			
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US827_TC1557_Condition2","purchaseBundle_US827_TC1557",
					"Invoice should be saved successfully",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US827_TC1557_Condition2");
		}

	}
		
	//TC2842 : 	Verify duplicate Invoice Number- Vendor Name combination should not be allowed when existing Invoice Number- Vendor Name combination exists in Restore Manual Invoice 
	@Test()
	public void purchaseBundle_US827_TC2842() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//Need to Complete
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin1;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		driver.navigate().refresh();
		Thread.sleep(3000);
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		Thread.sleep(3000);
		boolean result=Base.isElementDisplayed(By.xpath("//tr[contains(@class,'deleted_purchases_history')]/td[text()='"+invoiceNumber+"']/preceding-sibling::td[@class='restore_purchase select-checkbox']"));
		
		if(result)
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			purchasesPage.CreateManualInvoice_BT.click();
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendorName);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
			AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
			manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
			// Enter the quantity
			manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
			manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("3");
			manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();
			manualInvoiceNewPage.Submit_BT.click();
			// Code need to upload for the duplicate invoice
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US827_TC2842","purchaseBundle_US827_TC2842",
					"Invoice should be restored successfully",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US827_TC2842");
		}
	}
	
	//TC3512 : Verify that system should not allow user to save duplicate Invoice Number- Vendor Name combination..
		@Test()
		public void purchaseBundle_US827_TC3512() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			//Need to completed for error message
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin1;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			Thread.sleep(5000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
				purchasesPage.CreateManualInvoice_BT.click();
				wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
				// Search and Select the Vendor from the drop down
				manualInvoiceNewPage.selectAVendor(vendorName);
				manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
				AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
				wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
				manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
				manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
				// Enter the quantity
				manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
				manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("3");
				manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();
				manualInvoiceNewPage.Submit_BT.click();
				// Code need to upload for the duplicate invoice
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US827_TC3512","purchaseBundle_US827_TC3512",
						"Created manual purchase should display on Purchase landing page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US827_TC3512");
			}

		}
	
	
}
