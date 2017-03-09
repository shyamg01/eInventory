package UserStoriesWithoutBundle;

import java.io.IOException;
import java.text.ParseException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.ViewPurchaseHistoryPage;

public class US961_FlipListsAcrossTheInventoryApplication extends AbstractTest{
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_PhysicalInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_PhysicalInventory";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		Thread.sleep(5000);
		GenericMethods.clickOnElement(physicalInventoryPage.InventoryHistory_BT, "InventoryHistory_BT");
		if (physicalInventoryPage.verifyInventoryDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the list of most recent inventories.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the list of most recent inventories.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_Purchasse() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_Purchasse";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (purchasesPage.verifyDeliverDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the list of most recent pending purchases",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the list of most recent pending purchases",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_ViewHistory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_ViewHistory";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewHistory_BT.click();
		if (viewPurchaseHistoryPage.verifyDeliveryDateInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the list of most recent purchase history.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the list of most recent purchase history.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_StoreLedger() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_StoreLedger";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorName = GlobalVariable.vendorName;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(1000);
		purchasesPage.ViewLedger_BT.click();
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(3000);
		if (storeLedgerDetailPage.verifyDeliveryDateInDescendingOrder(vendorName)) {
			Reporter.reportPassResult(
					browser,
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" invoice history displays (within Vendor) by Delivery Date in descending order",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_PromotionWaste() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_PromotionWaste";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String vendorName = GlobalVariable.vendorName;
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_Transfer() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_Transfer";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		if (transferLandingPage.verifyDateIsInDescendingOrder()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the list of most recent transfers.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the list of most recent transfers.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US961_TC1675_RawItemActivity() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US961_TC1675_RawItemActivity";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
	}

}
