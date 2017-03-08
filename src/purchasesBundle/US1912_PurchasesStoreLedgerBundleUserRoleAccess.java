package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
import eInventoryPageClasses.AbstractTest;

public class US1912_PurchasesStoreLedgerBundleUserRoleAccess extends AbstractTest
{
	// TC3325 : Verify that level 5 and level 6 user does not have access to the Purchases page..
	@Test()
	public void purchaseBundle_US1912_TC3325_level5()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3325_level5";
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		if (!Base.isElementDisplayed(homePage.Purchases_BT)) {
			Reporter.reportPassResult(browser,
					"User should not be able to access Purchase landingpage",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to access Purchase landingpage",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		

	@Test()
	public void purchaseBundle_US1912_TC3325_level6()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3325_level6";
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		if (!Base.isElementDisplayed(homePage.Purchases_BT)) {
			Reporter.reportPassResult(browser,
					"User should not be able to access Purchase landingpage",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to access Purchase landingpage",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	// TC3326 : Verify that Level 2, Level 3, Level 4 users are restricted from the "Restore Purchases" functionality.
	@Test()
	public void purchaseBundle_US1912_TC3326_level2()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3326_level2";
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(browser,
					"User should not be able to access Restore Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to access Restore Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
	@Test()
	public void purchaseBundle_US1912_TC3326_level3()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3326_level3";
		String userId = LoginTestData.level3_SSO_UserId;
		String password = LoginTestData.level3_SSO_Password;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(browser,
					"User should not be able to access Restore Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to access Restore Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			

	@Test(enabled=false)
	public void purchaseBundle_US1912_TC3326_level4()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3326_level4";
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPurchaseLandingPage();
		if (!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportPassResult(browser,
					"User should not be able to access Restore Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to access Restore Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
		
	// TC3334 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 users are able to restore deleted invoices
	@Test(groups = { "Smoke" })
	public void purchaseBundle_US1912_TC3334_Supervisor()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3334_Supervisor";
		String userId = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;
		String vendorName = GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber,wrin, "2", "3");
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		purchasesPage.restoreDeletedPurchases(invoiceNumber);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be restored successfully", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should be restored successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
	@Test()
	public void purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName = GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber,wrin, "2", "3");
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		purchasesPage.restoreDeletedPurchases(invoiceNumber);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be restored successfully", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should be restored successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}					
		
	@Test()
	public void purchaseBundle_US1912_TC3334_orgAdmin()
			throws RowsExceededException, BiffException, WriteException,IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3334_orgAdmin";
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String vendorName = GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber,wrin, "2", "3");
		System.out.println(invoiceNumber);
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		purchasesPage.restoreDeletedPurchases(invoiceNumber);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be restored successfully", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should be restored successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}						
		
	@Test()
	public void purchaseBundle_US1912_TC3334_operator()
			throws RowsExceededException, BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1912_TC3334_operator";
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String vendorName = GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber,wrin, "2", "3");
		System.out.println(invoiceNumber);
		purchasesPage.deleteAManualInvoice(invoiceNumber);
		purchasesPage.restoreDeletedPurchases(invoiceNumber);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be restored successfully", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should be restored successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}					
		
		@Test()
		public void purchaseBundle_US1912_TC3334_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3334_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			System.out.println(invoiceNumber);
			purchasesPage.deleteAManualInvoice(invoiceNumber);
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be restored successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be restored successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}					
		
	//TC3339 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 users are able to create manual invoice.	
		@Test(groups={"Smoke"},enabled=false)
		public void purchaseBundle_US1912_TC3339_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3339_Supervisor";
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment";
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
		
		@Test()
		public void purchaseBundle_US1912_TC3339_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3339_orgAdmin";
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_Password;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3339_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3339_operator";
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	

		@Test()
		public void purchaseBundle_US1912_TC3339_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3339_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
		
		
	//TC3341 : Verify that Level 2, Level 3, Level 4 users are able to create manual invoice.			
		@Test()
		public void purchaseBundle_US1912_TC3341_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3341_level2";
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
		
		@Test()
		public void purchaseBundle_US1912_TC3341_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3341_level3";
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3341_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3341_level4";
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}

	}			
		
	//TC3342 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to approve manual invoices.	
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3342_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_Supervisor";
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment";
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_orgAdmin";
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_Password;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_operator";
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test()
		public void purchaseBundle_US1912_TC3342_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_level2";
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}

	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_level3";
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	

		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3342_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3342_level4";
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be Approved successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be Approved successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
	//TC3343 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to delete manual invoices	
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3343_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_Supervisor";
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}

	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment";
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
		
		@Test()
		public void purchaseBundle_US1912_TC3343_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_orgAdmin";
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_Password;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
		
		@Test()
		public void purchaseBundle_US1912_TC3343_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_operator";
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
			
		@Test()
		public void purchaseBundle_US1912_TC3343_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
				
		@Test()
		public void purchaseBundle_US1912_TC3343_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_level2";
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3343_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_level3";
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3343_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3343_level4";
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.deleteAManualInvoice(invoiceNumber);
		if (!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"Invoice should be deleted successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Invoice should be deleted successfully", "Fail");
			AbstractTest.takeSnapShot();
		}
	}			
			
	//TC3375 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to view purchase history	
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3375_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_Supervisor";
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			

		@Test()
		public void purchaseBundle_US1912_TC3375_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_orgAdmin";
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_Password;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_operator";
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			/**************************************************/
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			/**************************************************/
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
				
		@Test()
		public void purchaseBundle_US1912_TC3375_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_level2";
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			/**************************************************/
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
				
		@Test()
		public void purchaseBundle_US1912_TC3375_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_level3";
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			/**************************************************/
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3375_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3375_level4";
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String startDate=GlobalVariable.startDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			/**************************************************/
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
	//TC3415 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to view store ledger	
		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3415_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_Supervisor";
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
			/**************************************************/	
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
			/**************************************************/	
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_orgAdmin";
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_Password;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_operator";
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_level1";
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(
				vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_level2";
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			

		@Test()
		public void purchaseBundle_US1912_TC3415_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_level3";
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/******************************************************/	
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		

		@Test(enabled=false)
		public void purchaseBundle_US1912_TC3415_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US1912_TC3415_level4";
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.createDate;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			/***********************************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			purchasesPage.approveAManualInvoice(invoiceNumber);
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(4000);
		if (storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
}
