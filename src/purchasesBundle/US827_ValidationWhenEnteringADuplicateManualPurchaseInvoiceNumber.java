package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;

public class US827_ValidationWhenEnteringADuplicateManualPurchaseInvoiceNumber extends AbstractTest
{
	//TC1555 : Verify that system should not allow user to save duplicate Invoice Number- Vendor Name combination.
	@Test()
	public void purchaseBundle_US827_TC1555() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US827_TC1555";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId,quantity,pricePerCase);
		Thread.sleep(5000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendor);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceId);
			// Enter the quantity
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
			GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
			GenericMethods.clickOnElement(manualInvoiceNewPage.Submit_BT, "Submit_BT");
			if (Base.isElementDisplayed(manualInvoiceNewPage.DuplicateInvoiceNumber_Error_MSG)) {
				Reporter.reportPassResult(
						browser,"An error message should be displayed to user  \"The manual invoice number is already used.  Please enter a new manual invoice number.\"",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"An error message should be displayed to user  \"The manual invoice number is already used.  Please enter a new manual invoice number.\"",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		} else {
			Reporter.reportTestFailure(
					browser,
					"Created manual purchase should display on Purchase landing page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1557 : Verify that system should allow user to save duplicate Invoice Number with different Vendor Name.
	@Test()
	public void purchaseBundle_US827_TC1557() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US827_TC1557";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String vendorName1=GlobalVariable.vendorName1;
		String wrin1=GlobalVariable.createPurchaseWrinForVendor1;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
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
						browser,
						"The invoice should be created with same invoice number and different vendor name",
						"Pass");
				
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"The invoice should be created with same invoice number and different vendor name",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Invoice should be saved successfully",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
		
	//TC2842 : 	Verify duplicate Invoice Number- Vendor Name combination should not be allowed when existing Invoice Number- Vendor Name combination exists in Restore Manual Invoice 
	@Test()
	public void purchaseBundle_US827_TC2842() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US827_TC2842";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId,quantity,pricePerCase);
		Thread.sleep(3000);
		System.out.println("invoiceId"+invoiceId);
		purchasesPage.deleteAManualInvoice(invoiceId);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor).seacrhAndSelectRawItem(wrinId);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceId);
		// Enter the quantity
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
		GenericMethods.clickOnElement(manualInvoiceNewPage.Submit_BT, "Submit_BT");
		if (Base.isElementDisplayed(manualInvoiceNewPage.DuplicateInvoiceNumber_Error_MSG)) {
			Reporter.reportPassResult(
					browser,"System should not allow user to save Invoice as same Invoice Number- Vendor Name combination exists in Restore Manual Invoice Page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"System should not allow user to save Invoice as same Invoice Number- Vendor Name combination exists in Restore Manual Invoice Page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_Cross_BT));
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_Cross_BT, "CreateManualInvoice_Cross_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT));
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT, "CreateManualInvoice_ConfirmationPopUp_Yes_BT");
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Reporter.reportPassResult(
					browser,"Invoice should not be saved as same Invoice Number- Vendor Name combination exists in Restore Manual Invoice Page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should not be saved as same Invoice Number- Vendor Name combination exists in Restore Manual Invoice Page.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	// TC3512 : Verify that system should not allow user to save duplicate
	// Invoice Number- Vendor Name combination..
	@Test()
	public void purchaseBundle_US827_TC3512() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US827_TC3512";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId,wrinId, quantity,pricePerCase);
		Thread.sleep(5000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendor);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceId);
			// Enter the quantity
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
			GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
			GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
			GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
			GenericMethods.clickOnElement(manualInvoiceNewPage.Submit_BT, "Submit_BT");
			if (Base.isElementDisplayed(manualInvoiceNewPage.DuplicateInvoiceNumber_Error_MSG)) {
				Reporter.reportPassResult(
						browser,"An error message should be displayed to user  \"The manual invoice number is already used.  Please enter a new manual invoice number.\"",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"An error message should be displayed to user  \"The manual invoice number is already used.  Please enter a new manual invoice number.\"",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		} else {
			Reporter.reportTestFailure(
					browser,
					"Created manual purchase should display on Purchase landing page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
