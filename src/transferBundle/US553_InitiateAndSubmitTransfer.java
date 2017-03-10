package transferBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;

public class US553_InitiateAndSubmitTransfer extends AbstractTest
{
	//TC778 : 	Verify the user is able to submit "Transfer Out " from transfer landing page..

			@Test(groups="Smoke")
			public void transferBundle_US553_TC778() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException
			{
				
				/**Variable Section :**/
				AbstractTest.tcName="transferBundle_US553_TC778";
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.userId;
				String password = LoginTestData.password;
				String storeId = LoginTestData.StoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = GlobalVariable.nationalStore1;
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
				String date = GlobalVariable.createDate;
				/*String time=GlobalVariable.time;*/
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				//Navigate to Transfer Landing page and click on create new transfer button
				TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToTransferLandingPage();
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
				//Get the time of transfer
//				String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
				if (transferLandingPage.verifyTransferPlaced(date,transferType2,transferStoreNumber,amount1)) {
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
	
	

			
			//TC794 : 	Verify the user  is able to search raw items in "Add Transfer Items" pop-up screen, able to add quantities for outer pack , inner pack and loose unit  for selected raw item and add 1 or more raw items to the Transfer and verify the transfer submission without entering quantities.

					@Test()
					public void transferBundle_US553_TC794() throws RowsExceededException,
								BiffException, WriteException, IOException, InterruptedException {
						/**Variable Section :**/
						AbstractTest.tcName="transferBundle_US553_TC794";
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.userId;
						String password = LoginTestData.password;
						String storeId = LoginTestData.StoreId;
						String samplewRINID = GlobalVariable.addTransferItemWrin;
						String samplewRINID1 = GlobalVariable.addTransferItemWrin1;
						String transferType2 = GlobalVariable.transferTypeOut;
						String transferStoreNumber = GlobalVariable.nationalStore1;
						String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
						String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
						String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
						/*String date = GlobalVariable.createDate;*/
						/***********************************/
						HomePage homePage = PageFactory.initElements(driver, HomePage.class);
						//Navigate to Transfer Landing page and click on create new transfer button
						TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
								.goToTransferLandingPage();
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
						actions.moveToElement(transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(0));
						// actions.click();
						actions.perform();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(0)));
						Thread.sleep(3000);
						/*//Get the total transfer amount
						String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];*/
						//Submit the transfer
						//Verify that transfer entries should displayed in Transfer landing page
						System.out.println("value"+transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled"));
						if (transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled").equalsIgnoreCase("true")) {
							Reporter.reportPassResult(
									browser,
									"User should not be allowed to submit the transfer",
									"Pass");
							
						} else {
							Reporter.reportTestFailure(

									browser,

									"User should not be allowed to submit the transfer",
									"Fail");
							AbstractTest.takeSnapShot();
							
						}
						
			
			
					}
			
	
					//TC795 : 	Verify that user is taken to the transfer landing page once the "cancel" button is clicked from transfer detail screen.

					@Test()
					public void transferBundle_US553_TC795() throws RowsExceededException,
								BiffException, WriteException, IOException, InterruptedException {
						/**Variable Section :**/
						AbstractTest.tcName="transferBundle_US553_TC795";
//						String userId = LoginTestData.operatorUserId;
						String userId = LoginTestData.userId;
						String password = LoginTestData.password;
						String storeId = LoginTestData.StoreId;
						
//						String date = GlobalVariable.createDate;
						/***********************************/
						HomePage homePage = PageFactory.initElements(driver, HomePage.class);
						//Navigate to Transfer Landing page and click on create new transfer button
						TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
								.goToTransferLandingPage();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//click on Cancel button 
						transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT));
						transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT.click();
						Thread.sleep(2000);
						//Verify that user should redirect to the transfer landing page
						if (Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)) {
							Reporter.reportPassResult(
									browser,
									"On clicking Cancel button user should redirected to transfer landing page",
									"Pass");
							
						} else {
							Reporter.reportTestFailure(

									browser,

									"User should not be allowed to submit the transfer",
									"Fail");
							AbstractTest.takeSnapShot();
							
						}
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
						Thread.sleep(10000);
						wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
						//click on (*) button 
						transferLandingPage.AddTransferForm_Close_BT.click();
						
						Thread.sleep(2000);
						//Verify that user should redirect to the transfer landing page
						if (Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)) {
							Reporter.reportPassResult(
									browser,
									"On clicking cross button user should redirected to transfer landing page",
									"Pass");
							
						} else {
							Reporter.reportTestFailure(

									browser,

									"On clicking cross button user should redirected to transfer landing page",
									"Fail");
							AbstractTest.takeSnapShot();
							
						}
			
			
					}
			
	
	

					
					
	// TC971 Verify the impact on "Raw Item Activity" page and "Store Ledger"
	// page, once the transfer is submitted.
	@Test()
	public void transferBundle_US553_TC971() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		AbstractTest.tcName="transferBundle_US553_TC971";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String samplewRINID = GlobalVariable.addTransferItemWrin3;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String expCount;
		String totalAmount = null;
		RawItemActivityPage rawItemActivityPage;
		PurchasesPage purchasesPage;
		StoreLedgerDetailPage storeLedgerDetailPage;
		/* End-Variable Deceleration */
		// create instances for home page and transfer landing page
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		// Go to purchase landing page and click on view store ledger button and fetch the number of records
		purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		// click on store ledger button
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		Thread.sleep(2000);
		// Fetch the amount for the newly added record which is displaying at bottom
		int noOfTransferRecords = storeLedgerDetailPage.StoreLedgerTable_Transfers_List.size();
		System.out.println("noOfTransferRecords "+ noOfTransferRecords);
		//go to transfer landing page
		TransferLandingPage transferLandingPage = homePage.goToTransferLandingPage();
		// Create a transfer out type transaction click on insert new transfer button
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		System.out.println("Type is"+transferType);
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date);
		Thread.sleep(1500);
		transferLandingPage.selectTimeInAddNewTransferForm(time);*/
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		expCount = transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().split(" ")[0].replace(",", "");
		System.out.println("Expected Count" + "-" + expCount);
		// Fetch the sub total Value
		totalAmount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("total amunt" + totalAmount);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
		rawItemActivityPage = homePage.goToRawItemActivityPage();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		//rawItemActivityPage.clickOnDateGroup(date);
		System.out.println("No of activities2 "+rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount));
		// Verify that correct count value is showing at raw item activity page
		if (rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount)) {
			Reporter.reportPassResult(
					browser,
					"Transfer out count value should display at raw item activity page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"Transfer out count value should display at raw item activity page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		// Go to purchase landing page
		homePage.goToPurchaseLandingPage().ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		Thread.sleep(2000);
		// Fetch the amount for the newly added record which is displaying at bottom
		int updatedNoOfTransferRecords = storeLedgerDetailPage.StoreLedgerTable_Transfers_List.size();
		System.out.println("updatedNoOfTransferRecords "+updatedNoOfTransferRecords);
		// Fetch the Actual Amount
		if (storeLedgerDetailPage.verifyTransferActivitiesDisplayedInStoreLedgerDetailsPage(date, transferStoreNumber, transferType, totalAmount)
				& updatedNoOfTransferRecords == (noOfTransferRecords +1)) {
			Reporter.reportPassResult(
					browser,
					"Transfer out amount should display at store ledger detail page",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"Transfer out amount should display at store ledger detail page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

}
