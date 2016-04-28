package transferBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
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

public class US553_InitiateAndSubmitTransfer extends AbstractTest
{
	
	
	
	//TC778 : 	Verify the user is able to submit "Transfer Out " from transfer landing page..

			@Test()
			public void transferBundle_US553_TC778() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException {
				/**Variable Section :**/
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.operator_SSO_UserId;
				String password = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = "55";
				String caseQuantity = "4";
				String innerPackQuantity ="1";
				String looseUnitQuantity ="4";
				String date = GlobalVariable.createDate;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				//Navigate to Transfer Landing page and click on create new transfer button
				TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
						.navigateToInventoryManagement().goToTransferLandingPage();
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
				//Get the time of transfer
				String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
				//Select the transfer type as "in" and select the store from drop down an add the transfer details
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
							browser,"transferBundle_US553_TC778",
							"User should be able to do transfer out type transction",
							"Pass");
				} else {
					Reporter.reportTestFailure(
							browser,"transferBundle_US553_TC778","transferBundle_US553_TC778",
							"User should be able to do transfer out type transction",
							"Fail");
					AbstractTest.takeSnapShot("transferBundle_US553_TC778");
				}
				
	
	
			}
	
	

			
			//TC794 : 	Verify the user  is able to search raw items in "Add Transfer Items" pop-up screen, able to add quantities for outer pack , inner pack and loose unit  for selected raw item and add 1 or more raw items to the Transfer and verify the transfer submission without entering quantities.

					@Test()
					public void transferBundle_US553_TC794() throws RowsExceededException,
								BiffException, WriteException, IOException, InterruptedException {
						/**Variable Section :**/
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.operator_SSO_UserId;
						String password = LoginTestData.operator_SSO_UserId;
						String storeId = LoginTestData.operatorStoreId;
						String samplewRINID = GlobalVariable.addTransferItemWrin;
						String samplewRINID1 = GlobalVariable.addTransferItemWrin1;
						String transferType2 = GlobalVariable.transferTypeOut;
						String transferStoreNumber = "55";
						String caseQuantity = "4";
						String innerPackQuantity ="1";
						String looseUnitQuantity ="4";
//						String date = GlobalVariable.createDate;
						/***********************************/
						HomePage homePage = PageFactory.initElements(driver, HomePage.class);
						//Navigate to Transfer Landing page and click on create new transfer button
						TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
								.navigateToInventoryManagement().goToTransferLandingPage();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//Get the time of transfer
//						String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
						//Select the transfer type as "in" and select the store from drop down an add the transfer details
						transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber)
								.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
						Thread.sleep(2000);
						//Enter the second WRIN
						transferLandingPage.seacrhAndSelectRawItem(samplewRINID1);
						Thread.sleep(3000);
						// Enter the outerPackQty for the food item
						Actions actions = new Actions(driver);
						actions.moveToElement(transferLandingPage.AddTransferItemsPopup_CaseCount_TB);
						// actions.click();
						actions.perform();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_CaseCount_TB));
						Thread.sleep(5000);
						/*//Get the total transfer amount
						String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];*/
						//Submit the transfer
						//Verify that transfer entries should displayed in Transfer landing page
						System.out.println("value"+transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled"));
						if (transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled").equalsIgnoreCase("true")) {
							Reporter.reportPassResult(
									browser,"transferBundle_US553_TC794",
									"User should not be allowed to submit the transfer",
									"Pass");
						} else {
							Reporter.reportTestFailure(
									browser,"transferBundle_US553_TC794","transferBundle_US553_TC794",
									"User should not be allowed to submit the transfer",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US553_TC794");
						}
						
			
			
					}
			
	
					//TC795 : 	Verify that user is taken to the transfer landing page once the "cancel" button is clicked from transfer detail screen.

					@Test()
					public void transferBundle_US553_TC795() throws RowsExceededException,
								BiffException, WriteException, IOException, InterruptedException {
						/**Variable Section :**/
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.operator_SSO_UserId;
						String password = LoginTestData.operator_SSO_UserId;
						String storeId = LoginTestData.operatorStoreId;
						
//						String date = GlobalVariable.createDate;
						/***********************************/
						HomePage homePage = PageFactory.initElements(driver, HomePage.class);
						//Navigate to Transfer Landing page and click on create new transfer button
						TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
								.navigateToInventoryManagement().goToTransferLandingPage();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//click on Cancel button 
						transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
				
						Thread.sleep(2000);
						//Verify that user should redirect to the transfer landing page
						if (Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)) {
							Reporter.reportPassResult(
									browser,"transferBundle_US553_TC795",
									"On clicking Cancel button user should redirected to transfer landing page",
									"Pass");
						} else {
							Reporter.reportTestFailure(
									browser,"transferBundle_US553_TC795_Condition1","transferBundle_US553_TC795",
									"User should not be allowed to submit the transfer",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US553_TC795_Condition1");
						}
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//click on (*) button 
						driver.findElement(By.xpath("(//div[@class='modal-close fa fa-close style-scope eb-modal'])[1]")).click();
						
						Thread.sleep(2000);
						//Verify that user should redirect to the transfer landing page
						if (Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)) {
							Reporter.reportPassResult(
									browser,"transferBundle_US553_TC795",
									"On clicking cross button user should redirected to transfer landing page",
									"Pass");
						} else {
							Reporter.reportTestFailure(
									browser,"transferBundle_US553_TC795_Condition2","transferBundle_US553_TC795",
									"On clicking cross button user should redirected to transfer landing page",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US553_TC795_Condition2");
						}
			
					}
			
	
	

					//TC3204 : 	Verify the list of raw items on transfer page.

					@Test()
					public void transferBundle_US553_TC3204() throws RowsExceededException,
								BiffException, WriteException, IOException, InterruptedException {
						/**Variable Section :**/
//						String userId = LoginTestData.level1UserId;
						String userId = LoginTestData.level1_SSO_UserId;
						String password = LoginTestData.level1_SSO_UserId;
						String transferType = GlobalVariable.transferTypeOut;
						String transferStoreNumber = "26";
						String storeId = "55";
						String wrin="00403-018";
						String caseQuantity = "4";
						String innerPackQuantity ="1";
						String looseUnitQuantity ="4";
//						String date = GlobalVariable.createDate;
						/***********************************/
						HomePage homePage = PageFactory.initElements(driver, HomePage.class);
						//Navigate to Transfer Landing page and click on create new transfer button
						TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
								.navigateToInventoryManagement().goToTransferLandingPage();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//Select the transfer type as "in" and select the store from drop down an add the transfer details
						transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
								.insertAndAddDetailsToTransfer(wrin, caseQuantity,innerPackQuantity, looseUnitQuantity);
						Thread.sleep(6000);
						//Get the total transfer amount
						String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
						//Verify that user should redirect to the transfer landing page
						if (amount1.equalsIgnoreCase("0.00")) {
							Reporter.reportPassResult(
									browser,"transferBundle_US553_TC3204",
									"User should not be able to submit the transfer",
									"Pass");
						} else {
							Reporter.reportTestFailure(
									browser,"transferBundle_US553_TC3204","transferBundle_US553_TC3204",
									"User should not be able to submit the transfer",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US553_TC3204");
						}
			
					}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
