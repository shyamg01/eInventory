package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;

public class US345_GenerateMonthlyBillLedgerSpreadsheet  extends AbstractTest{
	
	//TC532 : Verify that "View Store Ledger" button  is available on the Physical Inventory page to export the Manual Purchase and Electronic Invoice
	@Test()
	public void purchasesBundle_US345_TC532() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US345_TC532";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (Base.isElementDisplayed(purchasesPage.ViewLedger_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view 'View Ledger' button on landing page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view 'View Ledger' button on landing page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC533 :  Verify that user can navigate to Store  Ledger page by clicking on "View Store Ledger" button
	@Test()
	public void purchasesBundle_US345_TC533() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US345_TC533";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		if (Base.isElementDisplayed(storeLedgerDetailPage.month_DD)) {
			Reporter.reportPassResult(
					browser,
					"User should be navigated to Store Ledger detail Page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be navigated to Store Ledger detail Page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC534 :  Verify that user can navigate to Store  Ledger page by clicking on "View Store Ledger" button
	@Test()
	public void purchasesBundle_US345_TC534() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US345_TC534";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		String date = dateFormat.format(c.getTime());
		System.out.println("date"+date);
		System.out.println("Date 2"+ storeLedgerDetailPage.getDateOptionsFromSelectStoreLedgerDropDown().get(0));
		if (storeLedgerDetailPage.getDateOptionsFromSelectStoreLedgerDropDown().get(0).equals(date)) {
			Reporter.reportPassResult(
					browser,
					"The default view on Store Ledger Detail page should correspond to current month.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"The default view on Store Ledger Detail page should correspond to current month.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC535 : US345:Generate Monthly Bill Ledger Spreadsheet
	@Test()
	public void purchasesBundle_US345_TC535() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US345_TC535";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(3000);
		if(Base.isElementDisplayed(purchasesPage.CreateManualInvoice_BT)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_DeliveryDate_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Invoice_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Type_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_InvoiceTotal_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Food_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Paper_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProduct_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_OpsSupplies_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Linens_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProductHappyMealPremium_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_NonProductOther_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax1_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax2_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_Tax3_Label)
				& Base.isElementDisplayed(storeLedgerDetailPage.StoreLedgerTable_StateTax_Label)){
			Reporter.reportPassResult(
					browser,
					"Store Ledger table columns include:  Delivery Date, Invoice, Type,  Invoice Total, Food, Paper, Non-Product,"
					+ " Ops Supplies, Linens, Non-Product Happy Meal Premiums,Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Store Ledger table columns include:  Delivery Date, Invoice, Type,  Invoice Total, Food, Paper, Non-Product,"
					+ " Ops Supplies, Linens, Non-Product Happy Meal Premiums,Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC536 : Verify that user can select current and previous  month  from dropdown list on Store  Ledger detail page
	@Test()
	public void purchasesBundle_US345_TC536() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US345_TC536";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar instance = Calendar.getInstance();
	    instance.add(Calendar.MONTH, -1);
	    instance.set(Calendar.DAY_OF_MONTH, 1);
	    String startDate = dateFormat.format(instance.getTime());
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(startDate);
		Thread.sleep(3000);
		if(storeLedgerDetailPage.verifyDataForSelectedMonth(startDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to select the month selected from List in 'Month' dropdown list on Store Ledger detail "
					+ "Page. Data(if available) should be displayed for the selected month=x.","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Store Ledger table columns include:  Delivery Date, Invoice, Type,  Invoice Total, Food, Paper, Non-Product,"
					+ " Ops Supplies, Linens, Non-Product Happy Meal Premiums,Non-Product Other, Tax 1, Tax 2, Tax 3, Sales Tax", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3511 : Verify that "View Store Ledger" button  is available on the Physical Inventory page to export the Manual Purchase
	and Electronic Invoice*/
	/*@Test(enabled = false)
	public void purchasesBundle_US345_TC3511() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		*//** Variable Section : **//*
		AbstractTest.tcName="purchasesBundle_US345_TC3511";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		*//***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if(Base.isElementDisplayed(purchasesPage.ViewLedger_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view 'View Ledger' button on landing page","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view 'View Ledger' button on landing page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}*/

}
