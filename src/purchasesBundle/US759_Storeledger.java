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
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.AbstractTest;

public class US759_Storeledger extends AbstractTest
{
	
	//TC1549 : View posted manual purchase on store ledger page.
	@Test()
	public void purchaseBundle_US759_TC1549() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
		AbstractTest.tcName="purchaseBundle_US759_TC1549";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String date=GlobalVariable.createDate;
		/*String monthYear=GlobalVariable.viewLedger_monthDate;*/
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
		if(storeLedgerDetailPage.verifyPosetedPurchaseDisplayedForNewVendor(vendorName, date, invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on Store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
				
	}			
			
	//TC3469 : Verify submitted transfer sub total value on store ledger page.
	@Test()
	public void purchaseBundle_US759_TC3469() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
//		String userId = LoginTestData.operatorUserId;
		AbstractTest.tcName="purchaseBundle_US759_TC3469";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType1 = GlobalVariable.transferTypeIn;
		String transferType2 = GlobalVariable.transferTypeOut;
//		String monthYear=GlobalVariable.viewLedger_monthDate;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
//		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType1).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Insert the transfer out entry
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
//		String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		
		//Get the total transfer amount
		String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		//Go to Purchase landing page
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		/*Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mm-panel mm-hasnavbar mm-highest mm-current mm-opened']/div/a[@class='mm-btn mm-prev' ]")));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='mm-panel mm-hasnavbar mm-highest mm-current mm-opened']/div/a[@class='mm-btn mm-prev' ]")).click();*/
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
		Thread.sleep(2000);
		homePage.Purchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewLedger_BT));
		Thread.sleep(2000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		/*storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(monthYear);*/
		Thread.sleep(4000);
//		storeLedgerDetailPage.clickOnVendorGroup("Transfers");
		//Verify that transfer entries should displayed in Transfer landing page		
		if (storeLedgerDetailPage.verifyTransferIsDisplayedInStoreLedgerPage(transferStoreNumber, date, amount,transferType1) &&
				storeLedgerDetailPage.verifyTransferIsDisplayedInStoreLedgerPage(transferStoreNumber, date, amount1,transferType2)) {
			Reporter.reportPassResult(
					browser,
					"Transfer in and Out entries should display on store ledger page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Transfer in and Out entries should display on store ledger page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}

	}
	
	
}
