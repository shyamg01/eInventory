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
import sprint2.AbstractTest;

public class US1912_PurchasesStoreLedgerBundleUserRoleAccess extends AbstractTest
{
	//TC3325 : 	Verify that level 5 and level 6 user does not have access to the Purchases page..
	@Test()
	public void purchaseBundle_US1912_TC3325_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.level5UserId;
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement();
		Thread.sleep(5000);
		if(!Base.isElementDisplayed(homePage.Purchases_BT))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US1912_TC3325_level5",
					"User should not be able to access Purchase landingpage",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US1912_TC3325_level5","purchaseBundle_US1912_TC3325_level5",
					"User should not be able to access Purchase landingpage",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3325_level5");
		}		
		
	}		
		@Test()
		public void purchaseBundle_US1912_TC3325_level6() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level6UserId;
			String userId = LoginTestData.level6_SSO_UserId;
			String password = LoginTestData.level6_SSO_Password;
			String storeId = LoginTestData.level6StoreId;				
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement();
			Thread.sleep(5000);
			if(!Base.isElementDisplayed(homePage.Purchases_BT))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3325_level6",
						"User should not be able to access Purchase landingpage",
						"Pass");			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3325_level6","purchaseBundle_US1912_TC3325_level5",
						"User should not be able to access Purchase landingpage",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3325_level5");
			}			
			
		}
		
		//TC3326 : Verify that Level 2, Level 3, Level 4 users are restricted from the "Restore Purchases" functionality.
		@Test()
		public void purchaseBundle_US1912_TC3326_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
			PurchasesPage purchasesPage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();			Thread.sleep(5000);
			Thread.sleep(3000);
			if(!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3326_level2",
						"User should not be able to access Restore Purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3326_level2","purchaseBundle_US1912_TC3326_level2",
						"User should not be able to access Restore Purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3326_level2");
			}		
			
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3326_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;				
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);		
			PurchasesPage purchasesPage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();			Thread.sleep(5000);
			Thread.sleep(3000);
			if(!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3326_level3",
						"User should not be able to access Restore Purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3326_level3","purchaseBundle_US1912_TC3326_level3",
						"User should not be able to access Restore Purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3326_level3");
			}			
			
		}			

		@Test()
		public void purchaseBundle_US1912_TC3326_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;				
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
			PurchasesPage purchasesPage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();			Thread.sleep(5000);
			Thread.sleep(3000);
			if(!Base.isElementDisplayed(purchasesPage.RestorePurchases_BT))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3326_level4",
						"User should not be able to access Restore Purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3326_level4","purchaseBundle_US1912_TC3326_level4",
						"User should not be able to access Restore Purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3326_level4");
			}			
			
		}	
		
		
	//TC3334 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 users are able to restore deleted invoices		
		
		@Test()
		public void purchaseBundle_US1912_TC3334_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
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
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
			Thread.sleep(3000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3334_Supervisor",
						"Invoice should be restored successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3334_Supervisor","purchaseBundle_US1912_TC3334_Supervisor",
						"Invoice should be restored successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3334_Supervisor");
			}			
			
		}				
		
		@Test()
		public void purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
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
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
			Thread.sleep(3000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment",
						"Invoice should be restored successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment","purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment",
						"Invoice should be restored successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment");
			}			
			
		}					
		
		@Test()
		public void purchaseBundle_US1912_TC3334_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
			Thread.sleep(3000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3334_orgAdmin",
						"Invoice should be restored successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3334_orgAdmin","purchaseBundle_US1912_TC3334_orgAdmin",
						"Invoice should be restored successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3334_SupervisorWithRoleAssignment");
			}		
			
		}							
		
		@Test()
		public void purchaseBundle_US1912_TC3334_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
			Thread.sleep(3000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3334_operator",
						"Invoice should be restored successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3334_operator","purchaseBundle_US1912_TC3334_operator",
						"Invoice should be restored successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3334_operator");
			}	
			
		}						
		
		@Test()
		public void purchaseBundle_US1912_TC3334_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
			purchasesPage.restoreDeletedPurchases(invoiceNumber);
			Thread.sleep(3000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3334_level1",
						"Invoice should be restored successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3334_level1","purchaseBundle_US1912_TC3334_level1",
						"Invoice should be restored successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3334_level1");
			}			
			
		}						
		
	//TC3339 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 users are able to create manual invoice.	
		
		@Test()
		public void purchaseBundle_US1912_TC3339_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_UserId;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3339_Supervisor",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3339_Supervisor","purchaseBundle_US1912_TC3339_Supervisor",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3339_Supervisor");
			}
	
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment","purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3339_SupervisorWithRoleAssignment");
			}
	
		}		
		
		@Test()
		public void purchaseBundle_US1912_TC3339_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3339_orgAdmin",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3339_orgAdmin","purchaseBundle_US1912_TC3339_orgAdmin",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3339_orgAdmin");
			}
	
		}		
		
		@Test()
		public void purchaseBundle_US1912_TC3339_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3339_operator",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3339_operator","purchaseBundle_US1912_TC3339_operator",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3339_operator");
			}
	
		}		

		@Test()
		public void purchaseBundle_US1912_TC3339_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3339_level1",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3339_level1","purchaseBundle_US1912_TC3339_level1",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3339_level1");
			}
	
		}
		
		
	//TC3341 : Verify that Level 2, Level 3, Level 4 users are able to create manual invoice.			

		@Test()
		public void purchaseBundle_US1912_TC3341_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			Thread.sleep(5000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3341_level2",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3341_level2","purchaseBundle_US1912_TC3341_level2",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3341_level2");
			}
	
		}		
		
		@Test()
		public void purchaseBundle_US1912_TC3341_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			Thread.sleep(5000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3341_level3",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3341_level3","purchaseBundle_US1912_TC3341_level3",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3341_level3");
			}
	
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3341_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
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
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
			Thread.sleep(5000);
			if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3341_level4",
						"User shoudl be able to create the manual purchase",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3341_level4","purchaseBundle_US1912_TC3341_level4",
						"User shoudl be able to create the manual purchase",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3341_level4");
			}
	
		}			
		
	//TC3342 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to approve manual invoices.	
		
		@Test()
		public void purchaseBundle_US1912_TC3342_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_Supervisor",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_Supervisor","purchaseBundle_US1912_TC3342_Supervisor",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_Supervisor");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment","purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_supervisorWithRoleAssignment");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_orgAdmin",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_orgAdmin","purchaseBundle_US1912_TC3342_orgAdmin",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_orgAdmin");
			}
			
			
		}			
		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_operator",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_operator","purchaseBundle_US1912_TC3342_operator",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_operator");
			}
			
			
		}			
		
			
		@Test()
		public void purchaseBundle_US1912_TC3342_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_level1",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_level1","purchaseBundle_US1912_TC3342_level1",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_level1");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3342_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_level2",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_level2","purchaseBundle_US1912_TC3342_level2",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_level2");
			}
			
			
		}			
		
		
		

		@Test()
		public void purchaseBundle_US1912_TC3342_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_level3",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_level3","purchaseBundle_US1912_TC3342_level3",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_level3");
			}
			
			
		}			
		
		

		@Test()
		public void purchaseBundle_US1912_TC3342_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			String date=GlobalVariable.approveDate;
				
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(3000);
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3342_level4",
						"Invoice should be Approved successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3342_level4","purchaseBundle_US1912_TC3342_level4",
						"Invoice should be Approved successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3342_level4");
			}
			
			
		}			
		
		
	//TC3343 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to delete manual invoices	
		
		
		@Test()
		public void purchaseBundle_US1912_TC3343_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_Supervisor",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_Supervisor","purchaseBundle_US1912_TC3343_Supervisor",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_Supervisor");
			}
			
			
		}		
		

		@Test()
		public void purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment","purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_supervisorWithRoleAssignment");
			}
			
			
		}		
		
		@Test()
		public void purchaseBundle_US1912_TC3343_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_orgAdmin",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_orgAdmin","purchaseBundle_US1912_TC3343_orgAdmin",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_orgAdmin");
			}
			
			
		}		
			
		
		
		@Test()
		public void purchaseBundle_US1912_TC3343_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_operator",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_operator","purchaseBundle_US1912_TC3343_operator",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_operator");
			}
			
			
		}		
			
			
		@Test()
		public void purchaseBundle_US1912_TC3343_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_level1",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_level1","purchaseBundle_US1912_TC3343_level1",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_level1");
			}
			
			
		}		
				
		
		@Test()
		public void purchaseBundle_US1912_TC3343_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_level2",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_level2","purchaseBundle_US1912_TC3343_level2",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_level2");
			}
			
			
		}		
					
		
		@Test()
		public void purchaseBundle_US1912_TC3343_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_level3",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_level3","purchaseBundle_US1912_TC3343_level3",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_level3");
			}
			
			
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3343_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
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
		
			if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3343_level4",
						"Invoice should be deleted successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3343_level4","purchaseBundle_US1912_TC3343_level4",
						"Invoice should be deleted successfully",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3343_level4");
			}
			
			
		}			
			
	//TC3375 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to view purchase history	
		
		@Test()
		public void purchaseBundle_US1912_TC3375_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_Supervisor",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_Supervisor","purchaseBundle_US1912_TC3375_Supervisor",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_Supervisor");
			}
			
			
		}			
		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment","purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_supervisorWithRoleAssignment");
			}
			
			
		}			
		
		

		@Test()
		public void purchaseBundle_US1912_TC3375_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_orgAdmin",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_orgAdmin","purchaseBundle_US1912_TC3375_orgAdmin",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_orgAdmin");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_operator",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_operator","purchaseBundle_US1912_TC3375_operator",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_operator");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3375_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_level1",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_level1","purchaseBundle_US1912_TC3375_level1",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_level1");
			}
			
			
		}			
				
		@Test()
		public void purchaseBundle_US1912_TC3375_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_level2",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_level2","purchaseBundle_US1912_TC3375_level2",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_level2");
			}
			
			
		}			
				
		@Test()
		public void purchaseBundle_US1912_TC3375_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_level3",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_level3","purchaseBundle_US1912_TC3375_level3",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_level3");
			}
			
			
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3375_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
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
			purchasesPage.approveAManualInvoice(invoiceNumber,date);
			Thread.sleep(5000);
			purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
			if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
			{
				Reporter.reportPassResult(
						browser,"purchaseBundle_US1912_TC3375_level4",
						"User should be able to view the Invoice on View History page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3375_level4","purchaseBundle_US1912_TC3375_level4",
						"User should be able to view the Invoice on View History page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3375_level4");
			}
			
			
		}			
		
		
	//TC3415 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator, Level 1, Level 2, Level 3, Level 4 users are able to view store ledger	
		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_Supervisor() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
			String userId = LoginTestData.supervisor_SSO_UserId;
			String password = LoginTestData.supervisor_SSO_Password;
			String storeId = LoginTestData.supervisorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_Supervisor",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_Supervisor","purchaseBundle_US1912_TC3415_Supervisor",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_Supervisor");
			}
			
			
		}			
		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorWithRoleAssignmentUserId;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment","purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_supervisorWithRoleAssignment");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_orgAdmin() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.orgAdminUserId;
			String userId = LoginTestData.orgAdmin_SSO_UserId;
			String password = LoginTestData.orgAdmin_SSO_UserId;
			String storeId = LoginTestData.orgAdminStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_orgAdmin",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_orgAdmin","purchaseBundle_US1912_TC3415_orgAdmin",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_orgAdmin");
			}
			
			
		}			
		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_operator() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_operator",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_operator","purchaseBundle_US1912_TC3415_operator",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_operator");
			}
			
			
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_level1() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level1UserId;
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_UserId;
			String storeId = LoginTestData.level1StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_level1",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_level1","purchaseBundle_US1912_TC3415_level1",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_level1");
			}
						
		}			
		
		@Test()
		public void purchaseBundle_US1912_TC3415_level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level2UserId;
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			String storeId = LoginTestData.level2StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_level2",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_level2","purchaseBundle_US1912_TC3415_level2",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_level2");
			}
			
			
		}			
		
		

		@Test()
		public void purchaseBundle_US1912_TC3415_level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level3UserId;
			String userId = LoginTestData.level3_SSO_UserId;
			String password = LoginTestData.level3_SSO_Password;
			String storeId = LoginTestData.level3StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_level2",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_level2","purchaseBundle_US1912_TC3415_level2",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_level2");
			}
			
			
		}			
		
		
		
		@Test()
		public void purchaseBundle_US1912_TC3415_level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.level4UserId;
			String userId = LoginTestData.level4_SSO_UserId;
			String password = LoginTestData.level4_SSO_Password;
			String storeId = LoginTestData.level4StoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
			String date=GlobalVariable.approveDate;
			String monthYear="2016-02-01";
			String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
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
						browser,"purchaseBundle_US1912_TC3415_level4",
						"User should be able to view the Invoice on Store ledger page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"purchaseBundle_US1912_TC3415_level4","purchaseBundle_US1912_TC3415_level4",
						"User should be able to view the Invoice on Store ledger page",
						"Fail");
				AbstractTest.takeSnapShot("purchaseBundle_US1912_TC3415_level4");
			}
			
			
		}			
		

	
		
		
		

}
