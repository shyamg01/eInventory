package purchasesBundle;

import java.io.IOException;
import java.util.regex.Pattern;

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
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US477_Part2ManualPurchase extends AbstractTest
{	
	//TC1214 : 	Verify each product category sub total is calculated in real-time on the Manual Purchase detail page.
	
	//Complete it once the WRIN id will be added
	@Test()
	public void purchaseBundle_US477_TC1214() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1214";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String foodWrin=GlobalVariable.wrinID_Food;
		String linensWrin=GlobalVariable.wrinID_Linens;
		String papersWrin=GlobalVariable.wrinID_Paper;
		String oppsSuppliersWrin=GlobalVariable.wrinID_opsSupplier;
		String nonProductOtherWrin=GlobalVariable.wrinID_NonProductother;
		String nonProductOtheHappyMealsrWrin=GlobalVariable.wrinID_NonProductHappyMealPremiums;

		String quantityFood="1";
		String quantityLinens="1";
		String quantitynonProductOther="1";
		String quantityPaper="1";
		String quantityoppsSuppliers="1";
		String quantitynonProductOtheHappyMeals="1";
		String pattern = "(\\$)(.*)";
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(foodWrin);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		manualInvoiceNewPage.seacrhAndSelectRawItem(linensWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(papersWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(oppsSuppliersWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(nonProductOtherWrin);
		Thread.sleep(2000);
		manualInvoiceNewPage.seacrhAndSelectRawItem(nonProductOtheHappyMealsrWrin);
		Thread.sleep(2000);
		//Enter quantity in Food item
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys(quantityFood);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(1).sendKeys(quantityLinens);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(2).sendKeys(quantityPaper);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(3).sendKeys(quantityoppsSuppliers);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(4).sendKeys(quantitynonProductOther);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(5).sendKeys(quantitynonProductOtheHappyMeals);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		Thread.sleep(5000);
		//Get the Sub total values for the WRIN ids
		//Get the Total food Sub total Value
		String foodSubotal=driver.findElement(By.xpath("//span[@id='total_food']/strong")).getText();
		//Get the Total Paper Sub total Value
		String paperSubotal=driver.findElement(By.xpath("//span[@id='total_paper']/strong")).getText();
		//Get the Total Paper Sub total Value
		String opsSupplierSubotal=driver.findElement(By.xpath("//span[@id='total_ops']/strong")).getText();
		//Get the Total Non Product Other Sub total Value
		String nonProductOtherSubotal=driver.findElement(By.xpath("//span[@id='total_other']/strong")).getText();
		//Get the Total Non Product Other Happy Meal Sub total Value
		String nonProductOtherHappyMealSubotal=driver.findElement(By.xpath("//span[@id='total_happy_meal']/strong")).getText();
		System.out.println("foodSubotal"+foodSubotal);
		System.out.println("paperSubotal"+paperSubotal);
		System.out.println("opsSupplierSubotal"+opsSupplierSubotal);
		System.out.println("nonProductOtherSubotal"+nonProductOtherSubotal);
		System.out.println("nonProductOtherHappyMealSubotal"+nonProductOtherHappyMealSubotal);
		//Get the Total Non Product Other Happy Meal Sub total Value
		String linensSubotal=driver.findElement(By.xpath("//span[@id='total_linens']/strong")).getText();
		if(Pattern.compile(pattern).matcher(foodSubotal).matches() &&
				Pattern.compile(pattern).matcher(opsSupplierSubotal).matches() &&
				Pattern.compile(pattern).matcher(paperSubotal).matches() &&
				Pattern.compile(pattern).matcher(nonProductOtherSubotal).matches() &&
				Pattern.compile(pattern).matcher(nonProductOtherHappyMealSubotal).matches() &&
				Pattern.compile(pattern).matcher(linensSubotal).matches())
		{
			Reporter.reportPassResult(
					browser,
					"Sub Total Value shoudl display for all WRIN items",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Sub Total Value shoudl display for all WRIN items",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC1262 : Verify Manual Vendors are selectable from manual purchase page.
	@Test()
	public void purchaseBundle_US477_TC1262() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1262";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		/***********************/			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
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
				browser,
				"User should be able to select the vendor from the drop down",
				"Pass");
		
		
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the vendor from the drop down",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1219 : Verify the manual purchase is getting added to Raw Item activity page, once "manual purchase" is posted from manual purchase detail page.
	@Test
	public void purchaseBundle_US477_TC1219() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1219";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		String approveDate=GlobalVariable.createDate;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		/***********************/
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId, wrinId,quantity,pricePerCase);
		purchasesPage.approveAManualInvoice(invoiceId);
		//Go To Raw Item Activity Page
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		Thread.sleep(4000);
		if(driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[1][following-sibling::td/span[text()='Purchase Inv #"+invoiceId+"']]/span[contains(.,'"+approveDate+"')]")).size()>=1)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to select the date from date picker",
					"Pass");
		}else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the date from date picker",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	
	//TC1264 : Verify the user has the ability to select invoice date and time, when creating a new manual purchase.
	
	@Test()
	public void purchaseBundle_US477_TC1264() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1264";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String invoiceDate=GlobalVariable.createDate;
		/***********************/			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);

		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if(manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText().equalsIgnoreCase(invoiceDate))
		{
			Reporter.reportPassResult(
					browser,
				"User should be able to select the date from date picker",
				"Pass");
		}else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the date from date picker",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}	
	
	//TC1266 : Verify the "Warning message" while deleting a manual purchase from manual purchase detail page.	
	@Test(groups={"Smoke"})
	public void purchaseBundle_US477_TC1266() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1266";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,
					"Invoice should be deleted successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Invoice should be deleted successfully",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}	
	
	//TC1281 : Verify new search option on manual purchase detail page
	@Test()
	public void purchaseBundle_US477_TC1281() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1281";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		/***********************/
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		//Go to Create new invoice page
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if(Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB))
		{
			Reporter.reportPassResult(
					browser,
					"Wrin ID search text box should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Wrin ID search text box should display",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
	
//TC1312 : Verify the user has the ability to select a delivery date and time when the user approve manual purchase.
	@Test(enabled=false)
	public void purchaseBundle_US477_TC1312() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1312";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String approveDate=GlobalVariable.createDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		/***********************/
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		if (purchasesPage.ApproveManualInvoice_SelectDate_TB.getText()
				.equalsIgnoreCase(approveDate)) {
			Reporter.reportPassResult(browser,
					"User should be able to select date", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to select date", "Fail");
			AbstractTest.takeSnapShot();
		}
	}				
	
	//TC1331 : Verify the delivery date and invoice date from view history, for posted manual purchase.	
	@Test()
	public void purchaseBundle_US477_TC1331() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US477_TC1331";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String approveDate=GlobalVariable.createDate;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		purchasesPage.approveAManualInvoice(invoiceNumber);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		purchasesPage.selectStartDate(startDate);
		purchasesPage.ViewHistory_Vendor_DD.click();
		purchasesPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		//click on the View button against the invoice number 
		String deliveryDate=driver.findElement(By.xpath("//table[@id='eb_purchase_his_table']/tbody/tr/td[1][following-sibling::td/span[text()='"+invoiceNumber+"']]")).getText();
		System.out.println("deliveryDate"+deliveryDate);
		Thread.sleep(10000);
		if(deliveryDate.equalsIgnoreCase(approveDate))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the correct delivery date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the correct delivery date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
	
	//TC3505 : Verify each product category sub total is calculated in real-time on the Manual Purchase detail page
}
