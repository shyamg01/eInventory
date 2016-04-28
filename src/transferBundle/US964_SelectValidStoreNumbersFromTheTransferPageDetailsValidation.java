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

public class US964_SelectValidStoreNumbersFromTheTransferPageDetailsValidation extends AbstractTest
{
	
	//TC3189 : Verify that user is able to select store number for the type of transfer as transfer in..
	@Test()
	public void transferBundle_US964_TC3189() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
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
					browser,"transferBundle_US964_TC3189",
					"User should be able to select Store number for transfer type in", "Pass");

		}
		catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,"transferBundle_US964_TC3189","transferBundle_US964_TC3189",
					"User should be able to select Store number for transfer type in",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US964_TC3189");
		}
		
	}




	//TC3190 : Verify that user is able to select store number for the type of transfer as transfer out.

			@Test()
			public void transferBundle_US964_TC3190() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
//				String userId = LoginTestData.operatorUserId;
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
							browser,"transferBundle_US964_TC3190",
							"User should be able to select Store number for transfer type out", "Pass");

				}
				catch(Exception e)
				{
					Reporter.reportTestFailure(
							browser,"transferBundle_US964_TC3190","transferBundle_US964_TC3190",
							"User should be able to select Store number for transfer type out",
							"Fail");
					AbstractTest.takeSnapShot("transferBundle_US964_TC3190");
				}
				
			}
		


			//TC3191 : Verify that the user cannot select store number in case of transfer type as "Office".

					@Test()
					public void transferBundle_US964_TC3191() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
						/** Variable Section : **/
//						String userId = LoginTestData.operatorUserId;
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
									browser,"transferBundle_US964_TC3191",
									"User should be able to select Store number for transfer type office", "Pass");
						} 
						else
						{
							Reporter.reportTestFailure(
									browser,"transferBundle_US964_TC3191","transferBundle_US964_TC3191",
									"User should be able to select Store number for transfer type office",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US964_TC3191");
						}
					}
				
	
					//TC3196 : 	Verify that user is able to select  under construction or opened store number while initiating transfer.
					@Test()
					public void transferBundle_US964_TC3196() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
						/** Variable Section : **/
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.operator_SSO_UserId;
						String password = LoginTestData.operator_SSO_UserId;
						String storeId = LoginTestData.closeOpenStoreId;

						String transferType="in";
						String storeID=GlobalVariable.openStore;
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
									browser,"transferBundle_US964_TC3196",
									"User should be able to select Store number for transfer type in", "Pass");

						}
						catch(Exception e)
						{
							Reporter.reportTestFailure(
									browser,"transferBundle_US964_TC3196","transferBundle_US964_TC3196",
									"User should be able to select Store number for transfer type in",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US964_TC3196");
						}
						
					}
	
					//TC3197 : 	Verify that user is unable to select  store number with invalid status while initiating transfer.
					@Test()
					public void transferBundle_US964_TC3197() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
						/** Variable Section : **/
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.operator_SSO_UserId;
						String password = LoginTestData.operator_SSO_UserId;
						String storeId = LoginTestData.closeOpenStoreId;
						String transferType="in";
						String storeID=GlobalVariable.closeStore;
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
							Reporter.reportTestFailure(
									browser,"transferBundle_US964_TC3197","transferBundle_US964_TC3197",
									"User should not be able to select Store number for transfer type in",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US964_TC3197");

						}
						catch(Exception e)
						
						{
							Reporter.reportPassResult(
									browser,"transferBundle_US964_TC3197",
									"User should not be able to select Store number for transfer type in", "Pass");
							
						}
						
					}
	
	
}
