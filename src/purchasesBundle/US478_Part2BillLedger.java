package purchasesBundle;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import sprint2.AbstractTest;

public class US478_Part2BillLedger extends AbstractTest
{
	
//TC1274 : Verify the change in column header on store ledger page	
	@Test()
	public void purchaseBundle_US478_TC1274() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
	
		/**Variable Section :**/
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType2 = GlobalVariable.transferTypeOut;
		String transferStoreNumber = "55";
		String caseQuantity = "2";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.approveDate;
		String monthYear="02/01/2016";

//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
//		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		
		//Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("Amount is"+amount);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		//Go to Purchase landing page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.Menu_Back_BT));
		Thread.sleep(2000);
		homePage.Menu_Back_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
		Thread.sleep(2000);
		homePage.Purchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(5000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		Thread.sleep(2000);
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(monthYear);
 		Thread.sleep(4000);
//		storeLedgerDetailPage.clickOnVendorGroup("Transfers");
		Thread.sleep(4000);
		String storeID=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[2][preceding-sibling::td/span[text()='"+date+"'] and following-sibling::td[text()='$-"+amount+"']]/span")).getText();
		if (storeID.equalsIgnoreCase(transferStoreNumber)) {
			Reporter.reportPassResult(
					browser,"purchaseBundle_US478_TC1274",
					"User should be able to view the correct National Store Number",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US478_TC1274","purchaseBundle_US478_TC1274",
					"User should be able to view the correct National Store Number",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US478_TC1274");
		
		}
		
		
	
	}		
	
}
