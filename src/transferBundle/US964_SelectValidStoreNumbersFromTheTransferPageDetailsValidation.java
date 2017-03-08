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

public class US964_SelectValidStoreNumbersFromTheTransferPageDetailsValidation extends AbstractTest
{
	
	//TC3189 : Verify that user is able to select store number for the type of transfer as transfer in..
	@Test()
	public void transferBundle_US964_TC3189() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US964_TC3189";
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;

		String transferType="In";
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




	//TC3190 : Verify that user is able to select store number for the type of transfer as transfer out.

			@Test()
			public void transferBundle_US964_TC3190() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="transferBundle_US964_TC3190";
//				String userId = LoginTestData.operatorUserId;
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
		


			//TC3191 : Verify that the user cannot select store number in case of transfer type as "Office".

					@Test()
					public void transferBundle_US964_TC3191() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException {
						/** Variable Section : **/
						AbstractTest.tcName="transferBundle_US964_TC3191";
//						String userId = LoginTestData.operatorUserId;
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
				
	
				
				
	
}
