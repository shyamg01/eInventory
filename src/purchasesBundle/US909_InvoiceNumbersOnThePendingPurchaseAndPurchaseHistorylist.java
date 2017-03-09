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
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractPage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.AbstractTest;

public class US909_InvoiceNumbersOnThePendingPurchaseAndPurchaseHistorylist extends AbstractTest
{
	
	//TC1657 : Verify that the user should be able to view a new column "Invoice" for pending purchase list and  if a pending purchase has an invoice number then that number should be populated for the respective pending purchase.
	@Test()
	public void purchaseBundle_US909_TC1657() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US909_TC1657";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
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
			Reporter.reportPassResult(
					browser,
					"User shoudl be able to view the invoice with invoice number",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User shoudl be able to view the invoice with invoice number",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}

	}	
	
	//TC1660 : Verify that the user should be able to view a new column "Invoice" for the purchase history list and  if a posted purchase has an invoice number then that number should be populated for the respective purchase in purchase history list.
	@Test()
	public void purchaseBundle_US909_TC1660() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US909_TC1660";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/*****************************/		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		purchasesPage.approveAManualInvoice(invoiceNumber);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
		{
			Reporter.reportPassResult(
					browser,
					"Invoice is showing with invoice number on View History page",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Invoice is showing with invoice number on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}				
	
	/*//TC3498 : Verify that the user should be able to view a new column "Invoice" for the purchase history list and  if a posted purchase has invoice number as blank then that space should be blank for the respective purchase in purchase history list.
	@Test()
	public void purchaseBundle_US909_TC3498() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		*//** Variable Section : **//*
		AbstractTest.tcName="purchaseBundle_US909_TC3498";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String approveDate=GlobalVariable.approveDate;
		String createDate=GlobalVariable.createDate;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber="";
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		System.out.println("quantity"+quantity);
		*//*****************************//*		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		//Create a Mnual invoice
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.selectInvoiceDate(createDate);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys("");
		Thread.sleep(1500); 
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
		// Enter the quantity
		manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys(quantity);
		manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.click();
		Thread.sleep(3000);
		String amount=manualInvoiceNewPage.CreateManualInvoice_SubTotal_Value.getText();
		manualInvoiceNewPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG));
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
//		driver.navigate().refresh();
		Thread.sleep(3000);
		//Approve the invoice that is created
		purchasesPage.approveAManualInvoice(createDate, amount, approveDate);
		
		Thread.sleep(5000);
		//View approved invoice on View History
		purchasesPage.viewApprovedInvoiceOnViewHistory(approveDate, amount, startDate);
		Thread.sleep(2000);
		if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the invocie with blanck invoice ID",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the invocie with blanck invoice ID",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}*/			
	
	//TC3527 : Verify that the user should be able view the "Invoice Number" field as blank if pending purchase not contain an invoice number.
	@Test()
	public void purchaseBundle_US909_TC3527() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US909_TC3527";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String todayDate=Base.returnTodayDate();
		String invoiceNumber="";
		String quantity="5";
		/*****************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		//Create a Mnual invoice
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys("");
		Thread.sleep(1500); 
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
		// Enter the quantity
		manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys(quantity);
		manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();		
		Thread.sleep(3000);
		String amount=manualInvoiceNewPage.CreateManualInvoice_SubTotal_Value.getText();
		System.out.println("todayDate"+todayDate);
		System.out.println("amount"+amount);
		manualInvoiceNewPage.Submit_BT.click();
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)), "CreateManualInvoice_ConfirmationPopUp_Yes_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG));
		Thread.sleep(5000);
		System.out.println("todayDate"+todayDate);
		
		if(driver.findElement(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+todayDate+"'] and following-sibling::td[text()='$"+amount+"']]/span")).getText().equalsIgnoreCase(""))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the invoice with the blank invoice ID",
					"Pass");
			

		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the invoice with the blank invoice ID",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		
	}				

}
