package transferBundle;

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
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.AbstractTest;

public class US1242_SelectValidStoreNumbersFromTheTransferPageDetailsValidation extends AbstractTest
{
	
	//TC3165 : Verify that user is able to select store number for the type of transfer as transfer in.
		@Test()
		public void transferBundle_US1242_TC3165() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			
			/** Variable Section : **/
			AbstractTest.tcName="transferBundle_US1242_TC3165";
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;

			String transferType=GlobalVariable.transferTypeIn;
			String storeID=GlobalVariable.nationalStore1;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
			// Navigate to Transfer Landing page and click on create new transfer button
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToTransferLandingPage().CreateNewTransfers_BT.click();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			// Select the type of transfer as 'IN'
			transferLandingPage.selectTransferType(transferType);
			Thread.sleep(4000);
			//Select the Store ID from the drop down
			try
			{
				transferLandingPage.selectLocationToTransfer(storeID);
				Reporter.reportPassResult(
						browser,
						"User should be able to select Store number for transfer type in", "Pass");
				

			}
			catch(Exception e)
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to select Store number for transfer type in",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		
		}
	
	
	
	
		//TC3167 : Verify that user is able to select store number for the type of transfer as transfer out.

				@Test()
				public void transferBundle_US1242_TC3167() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException {
					/** Variable Section : **/
					AbstractTest.tcName="transferBundle_US1242_TC3167";
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.userId;
					String password = LoginTestData.password;
					String storeId = LoginTestData.StoreId;

					String transferType="Out";
					String storeID=GlobalVariable.nationalStore1;
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
					// Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToTransferLandingPage().CreateNewTransfers_BT.click();
					wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
					// Select the type of transfer as 'IN'
					transferLandingPage.selectTransferType(transferType);
					Thread.sleep(4000);
					//Select the Store ID from the drop down
					try
					{
						transferLandingPage.selectLocationToTransfer(storeID);
						Reporter.reportPassResult(
								browser,
								"User should be able to select Store number for transfer type out", "Pass");
						

					}
					catch(Exception e)
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to select Store number for transfer type out",
								"Fail");
						AbstractTest.takeSnapShot();
						
					}
					
				}
			
	

				//TC3168 : Verify that the user cannot select store number in case of transfer type as "Office" (transfer)

				@Test()
				public void transferBundle_US1242_TC3168() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
					/** Variable Section : **/
					AbstractTest.tcName="transferBundle_US1242_TC3168";
					//							String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.userId;
					String password = LoginTestData.password;
					String storeId = LoginTestData.StoreId;

					String transferType="Office";
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
					// Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToTransferLandingPage().CreateNewTransfers_BT.click();
					wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
					// Select the type of transfer as 'IN'
					transferLandingPage.selectTransferType(transferType);
					Thread.sleep(4000);

					if (!Base.isElementDisplayed(transferLandingPage.Location_DD)) {
						Reporter.reportPassResult(
								browser,
								"User should be able to select Store number for transfer type office", "Pass");
						
					} 
					else
					{

						Reporter.reportTestFailure(
								browser,
								"User should be able to select Store number for transfer type office",
								"Fail");
						AbstractTest.takeSnapShot();
						
					}
						}
					
		//TC3274 : Verify that user is able to select store number for the type of transfer as transfer in and transfer out.

		@Test(enabled=false)
		public void transferBundle_US1242_TC3274() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="transferBundle_US1242_TC3274";
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.addTransferItemWrin;
			String transferType1 = GlobalVariable.transferTypeIn;
			String transferType2 = GlobalVariable.transferTypeOut;
			String transferStoreNumber = GlobalVariable.nationalStore1;
			String caseQuantity = "4";
			String innerPackQuantity ="1";
			String looseUnitQuantity ="4";
			String date = GlobalVariable.createDate;
//			String transferTime = GlobalVariable.transferTime;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			//Navigate to Transfer Landing page and click on create new transfer button
			TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
					.goToTransferLandingPage();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			/*//Get the time of transfer
			String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
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
			//Verify that transfer entries should displayed in Transfer landing page
			if (transferLandingPage.verifyTransferPlaced(date,transferType1, transferStoreNumber,amount)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to do transfer in type transction",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to do transfer in type transction",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			Thread.sleep(6000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			//Get the time of transfer
			String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
			//Verify that transfer entries should displayed in Transfer landing page
			if (transferLandingPage.verifyTransferPlaced(date,transferType2, transferStoreNumber,amount1)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to do transfer out type transction",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to do transfer out type transction",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		
	
}	
		
		
}
