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
import sprint2.AbstractTest;

public class US1242_SelectValidStoreNumbersFromTheTransferPageDetailsValidation extends AbstractTest
{
	
	//TC3165 : Verify that user is able to select store number for the type of transfer as transfer in.
		@Test()
		public void transferBundle_US1242_TC3165() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;

			String transferType="in";
			String storeID="55";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
			// Navigate to Transfer Landing page and click on create new transfer button
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
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
						browser,"transferBundle_US1242_TC3165",
						"User should be able to select Store number for transfer type in", "Pass");

			}
			catch(Exception e)
			{
				Reporter.reportTestFailure(
						browser,"transferBundle_US1242_TC3165","transferBundle_US1242_TC3165",
						"User should be able to select Store number for transfer type in",
						"Fail");
				AbstractTest.takeSnapShot("transferBundle_US1242_TC3165");
			}
		
		}
	
	
	
	
		//TC3167 : Verify that user is able to select store number for the type of transfer as transfer out.

				@Test()
				public void transferBundle_US1242_TC3167() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException {
					/** Variable Section : **/
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.operator_SSO_UserId;
					String password = LoginTestData.operator_SSO_UserId;
					String storeId = LoginTestData.operatorStoreId;

					String transferType="out";
					String storeID="55";
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
					// Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
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
								browser,"transferBundle_US1242_TC3167",
								"User should be able to select Store number for transfer type out", "Pass");

					}
					catch(Exception e)
					{
						Reporter.reportTestFailure(
								browser,"transferBundle_US1242_TC3167","transferBundle_US1242_TC3167",
								"User should be able to select Store number for transfer type out",
								"Fail");
						AbstractTest.takeSnapShot("transferBundle_US1242_TC3167");
					}
					
				}
			
	

				//TC3168 : Verify that the user cannot select store number in case of transfer type as "Office" (transfer)

				@Test()
				public void transferBundle_US1242_TC3168() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
							/** Variable Section : **/
//							String userId = LoginTestData.operatorUserId;
							String userId = LoginTestData.operator_SSO_UserId;
							String password = LoginTestData.operator_SSO_UserId;
							String storeId = LoginTestData.operatorStoreId;

							String transferType="office";
							/***********************************/
							HomePage homePage = PageFactory.initElements(driver, HomePage.class);
							TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
							// Navigate to Transfer Landing page and click on create new transfer button
							homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
									.goToTransferLandingPage().CreateNewTransfers_BT.click();
							wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
							// Select the type of transfer as 'IN'
							transferLandingPage.selectTransferType(transferType);
							Thread.sleep(4000);
							
							if (!Base.isElementDisplayed(transferLandingPage.Location_DD)) {
								Reporter.reportPassResult(
										browser,"transferBundle_US1242_TC3168",
										"User should be able to select Store number for transfer type office", "Pass");
							} 
							else
							{

								Reporter.reportTestFailure(
										browser,"transferBundle_US1242_TC3168","transferBundle_US1242_TC3168",
										"User should be able to select Store number for transfer type office",
										"Fail");
								AbstractTest.takeSnapShot("transferBundle_US1242_TC3168");
							}
						}
					
		//TC3274 : Verify that user is able to select store number for the type of transfer as transfer in and transfer out.

		@Test()
		public void transferBundle_US1242_TC3274() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
//			String userId = LoginTestData.operatorUserId;
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_UserId;
			String storeId = LoginTestData.operatorStoreId;
			String samplewRINID = GlobalVariable.addTransferItemWrin;
			String transferType1 = GlobalVariable.transferTypeIn;
			String transferType2 = GlobalVariable.transferTypeOut;
			String transferStoreNumber = "55";
			String caseQuantity = "4";
			String innerPackQuantity ="1";
			String looseUnitQuantity ="4";
			String date = GlobalVariable.createDate;
//			String transferTime = GlobalVariable.transferTime;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			//Navigate to Transfer Landing page and click on create new transfer button
			TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
					.navigateToInventoryManagement().goToTransferLandingPage();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			//Get the time of transfer
			String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
			if (transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
				Reporter.reportPassResult(
						browser,"transferBundle_US1242_TC3274",
						"User should be able to do transfer in type transction",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"transferBundle_US1242_TC3274_Condition1","transferBundle_US1242_TC3274",
						"User should be able to do transfer in type transction",
						"Fail");
				AbstractTest.takeSnapShot("transferBundle_US1242_TC3274_Condition1");
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
			if (transferLandingPage.verifyTransferPlaced(date, time1, transferStoreNumber,amount1)) {
				Reporter.reportPassResult(
						browser,"transferBundle_US1242_TC3274",
						"User should be able to do transfer out type transction",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"transferBundle_US1242_TC3274_Condition2","transferBundle_US1242_TC3274",
						"User should be able to do transfer out type transction",
						"Fail");
				AbstractTest.takeSnapShot("transferBundle_US1242_TC3274_Condition2");
			}
			
	
	
	
	
}
		
		
		
		
}
