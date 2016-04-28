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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import sprint2.AbstractTest;

public class US477_Part2ManualPurchase extends AbstractTest
{	
	//TC1214 : 	Verify each product category sub total is calculated in real-time on the Manual Purchase detail page.
	
	//Complete it once the WRIN id will be added
	@Test(enabled=false)
	public void purchaseBundle_US477_TC1214() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.level4UserId;
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		String vendorName=GlobalVariable.vendorName;
		String foodWrin=GlobalVariable.wrinID_Food;
//		String linensWrin=GlobalVariable.wrinID_Linens;
		String papersWrin=GlobalVariable.wrinID_Paper;
		String oppsSuppliersWrin=GlobalVariable.wrinID_opsSupplier;
//		String nonProductOtherWrin=GlobalVariable.wrinID_NonProductother;
		String nonProductOtheHappyMealsrWrin=GlobalVariable.wrinID_NonProductHappyMealPremiums;
		String date=GlobalVariable.approveDate;
		String monthYear="2016-02-01";
		String quantityFood="1";
		String quantityPaper="2";
		String quantityoppsSuppliers="3";
		String quantitynonProductOtheHappyMeals="4";
	
	
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(foodWrin);
//		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
//		manualInvoiceNewPage.seacrhAndSelectRawItem(linensWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(papersWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(oppsSuppliersWrin);
		Thread.sleep(2000);
//		manualInvoiceNewPage.seacrhAndSelectRawItem(nonProductOtherWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(nonProductOtheHappyMealsrWrin);
		Thread.sleep(10000);
		//Enter quantity in Food item
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys(quantityFood);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(1).sendKeys(quantityPaper);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(2).sendKeys(quantityoppsSuppliers);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(3).sendKeys(quantitynonProductOtheHappyMeals);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		Thread.sleep(5000);
		String foodSubTotal=manualInvoiceNewPage.SubTotal_Value_List.get(0).getText();
		Thread.sleep(2000);
		String paperSubTotal=manualInvoiceNewPage.SubTotal_Value_List.get(1).getText();
		Thread.sleep(2000);
		String quantityoppsSuppliersSubTotal=manualInvoiceNewPage.SubTotal_Value_List.get(2).getText();
		Thread.sleep(2000);
		String quantitynonProductOtheHappyMealsSubTotal=manualInvoiceNewPage.SubTotal_Value_List.get(3).getText();
		System.out.println("foodSubTotal"+foodSubTotal);
		System.out.println("paperSubTotal"+paperSubTotal);
		System.out.println("quantityoppsSuppliersSubTotal"+quantityoppsSuppliersSubTotal);
		System.out.println("quantitynonProductOtheHappyMealsSubTotal"+quantitynonProductOtheHappyMealsSubTotal);
		Thread.sleep(10000);
		/*manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.clear();
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys("");
		Thread.sleep(1500); 
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.sendKeys(invoiceNumber);
		// Enter the quantity
		manualInvoiceNewPage.Quantity_TB_List.get(0).clear();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys(quantity);
		manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable.click();
		manualInvoiceNewPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		driver.navigate().refresh();
		Thread.sleep(3000);
		purchasesPage.approveAManualInvoice(invoiceNumber,date);
		Thread.sleep(5000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(monthYear);
		Thread.sleep(4000);
		storeLedgerDetailPage.clickOnVendorGroup(vendorName);
		Thread.sleep(4000);
		if(storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US477_TC1214",
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1214","purchaseBundle_US477_TC1214",
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1214");
		}
		*/
		
	}
	
	//TC1262 : Verify Manual Vendors are selectable from manual purchase page.
	
	@Test()
	public void purchaseBundle_US477_TC1262() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		/***********************/			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		try{
		manualInvoiceNewPage.selectAVendor(vendorName);
		Reporter.reportPassResult(
				browser,"purchaseBundle_US477_TC1262",
				"User should be able to select the vendor from the drop down",
				"Pass");
		
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1262","purchaseBundle_US477_TC1262",
					"User should be able to select the vendor from the drop down",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1262");
		}
	}
	
	
	//TC1264 : Verify the user has the ability to select invoice date and time, when creating a new manual purchase.
	
	@Test()
	public void purchaseBundle_US477_TC1264() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String invoiceDate=GlobalVariable.createDate;
		/***********************/			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);

		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		manualInvoiceNewPage.selectInvoiceDate(invoiceDate);
		Thread.sleep(7000);
		if(manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText().equalsIgnoreCase(invoiceDate))
		{
		Reporter.reportPassResult(
				browser,"purchaseBundle_US477_TC1264",
				"User should be able to select the date from date picker",
				"Pass");
		
		}else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1264","purchaseBundle_US477_TC1264",
					"User should be able to select the date from date picker",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1264");
		}
	}	
	
//TC1266 : Verify the "Warning message" while deleting a manual purchase from manual purchase detail page.	
	
	@Test()
	public void purchaseBundle_US477_TC1266() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;

		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
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
		Thread.sleep(5000);		
		if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US477_TC1266",
					"Invoice should be deleted successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1266","purchaseBundle_US477_TC1266",
					"Invoice should be deleted successfully",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1266");
		}
		
		
	}	
	
	
	//TC1281 : Verify new search option on manual purchase detail page
		
	@Test()
	public void purchaseBundle_US477_TC1281() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);

		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		Thread.sleep(5000);
		
		if(Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US477_TC1281",
					"Wrin ID search text box should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1281","purchaseBundle_US477_TC1281",
					"Wrin ID search text box should display",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1281");
		}
		
		
	}			
	
		
//TC1312 : Verify the user has the ability to select a delivery date and time when the user approve manual purchase.
	
	@Test()
	public void purchaseBundle_US477_TC1312() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String approveDate=GlobalVariable.approveDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
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
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		purchasesPage.selectDateForApproveInvoice(approveDate);
		Thread.sleep(5000);
		
		if(purchasesPage.ApproveManualInvoice_SelectDate_TB.getText().equalsIgnoreCase(approveDate))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US477_TC1312",
					"User should be able to select date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1312","purchaseBundle_US477_TC1312",
					"User should be able to select date",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1312");
		}
		
		
	}				
	
	//TC1331 : Verify the delivery date and invoice date from view history, for posted manual purchase.	
	
	@Test()
	public void purchaseBundle_US477_TC1331() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String approveDate=GlobalVariable.approveDate;
		String startDate=GlobalVariable.startDate;

		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
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
		purchasesPage.approveAManualInvoice(invoiceNumber, approveDate);
		Thread.sleep(5000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(4000);
//		selectDateForApproveInvoice(date);
		purchasesPage.selectStartDate(startDate);
		Thread.sleep(2000);
		purchasesPage.ViewHistory_Vendor_DD.click();
		Thread.sleep(2000);
		purchasesPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(10000);
		//click on the View button against the invoice number 
		String deliveryDate=driver.findElement(By.xpath("//table[@id='posted_purchases_selection_table']/tbody/tr/td[1][following-sibling::td/span[text()='"+invoiceNumber+"']]")).getText();
		System.out.println("deliveryDate"+deliveryDate);
		Thread.sleep(10000);
		if(deliveryDate.equalsIgnoreCase(approveDate))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US477_TC1331",
					"User should be able to view the correct delivery date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US477_TC1331","purchaseBundle_US477_TC1331",
					"User should be able to view the correct delivery date",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US477_TC1331");
		}
		
		
		
	}			
	
	
	//TC3505 : Verify each product category sub total is calculated in real-time on the Manual Purchase detail page
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
