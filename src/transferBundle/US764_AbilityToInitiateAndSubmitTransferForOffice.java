package transferBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.TransferLandingPage;

public class US764_AbilityToInitiateAndSubmitTransferForOffice extends AbstractTest{
	
	//TC2901 : Verify that the Store user's with Level 2-4 access are not able to submit "Office Transfer" type Transfer.
	@Test()
	public void transferBundle_US764_TC2901() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US764_TC2901";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Select the transfer type as "Office" and add the transfer details
		//transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(time);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,
					"Office Transfer option should not be available to user which has Level 2-4 access.", "Fail");
			AbstractTest.takeSnapShot();
			
		} else {
			Reporter.reportPassResult(browser,
					"Office Transfer option should not be available to user which has Level 2-4 access.", "Pass");
			
		}
	}
	
	//TC2902 : Verify that the above Store user's are able to submit "Transfer In/Out" type Transfer.
	@Test()
	public void transferBundle_US764_TC2902() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US764_TC2902";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		//String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		System.out.println("Type is"+transferType);
		transferLandingPage.removeAllWrinIdFromTransferPage();
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Confirmation_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation pop up while submitting a transfer detail",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view confirmation pop up while submitting a transfer detail",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.SubmitTransferConfirmationPopUp_No_BT.click();
		if (Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Submit_BT)
				& !(Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT))) {
			Reporter.reportPassResult(
					browser,
					"Confirmation popup screen should get closed On clickin No button and user should be on Transfer popup screen.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Confirmation popup screen should get closed On clickin No button and user should be on Transfer popup screen.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		boolean transferAddedMsgDisplayed = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		Thread.sleep(6000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed && transferLandingPage.verifyTransferPlaced(date,transferType,transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to save the transfer details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to save the transfer details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1416 : Verify that the above Store user's are able to submit "Office Transfer" type Transfer.
	@Test()
	public void transferBundle_US764_TC1416() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US764_TC1416";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		/*// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		// Get the time of transfer
		/*String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		System.out.println("message "+transferLandingPage.AddNewTransfer_Confirmation_Message.getText());
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Confirmation_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation pop up while submitting an office transfer detail",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view confirmation pop up while submitting an office transfer detail",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.SubmitTransferConfirmationPopUp_No_BT.click();
		if (Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Submit_BT)
				& !(Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT))) {
			Reporter.reportPassResult(
					browser,
					"Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		boolean transferAddedMsgDisplayed = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed & transferLandingPage.verifyTransferPlaced(date,transferType,"Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to save an office transfer details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to save an office transfer details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1417 : Verify an entry of "Office Transfer" event ,on raw item activity page.
	@Test()
	public void transferBundle_US764_TC1417() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US764_TC1417";
		RawItemActivityPage rawItemActivityPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin2;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		// Navigate to Promotion and Waste page
		rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
//		rawItemActivityPage.clickOnDateGroup(date);
		int noOfTransferActivities = rawItemActivityPage.getNoumberOfTransferOutActivities(date);
		System.out.println("No of activities "+noOfTransferActivities);
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.Transfers_BT));
		homePage.Transfers_BT.click();
		TransferLandingPage transferlandingpage=new TransferLandingPage(driver);
		wait.until(ExpectedConditions.visibilityOf(transferlandingpage.TransferLandingPage_Label));
		wait.until(ExpectedConditions.visibilityOf(transferlandingpage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select the transfer type as "Office" and add the transfer details
		// Select the transfer type as "Office" and add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Submit the transfer
		String expCount = transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().split(" ")[0];
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
		Thread.sleep(5000);
		homePage.Menu_DD_BT.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
//		rawItemActivityPage.clickOnDateGroup(date);
		System.out.println("No of activities2 "+rawItemActivityPage.getNoumberOfTransferOutActivities(date));
		System.out.println("No of activities2 "+rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount));
		if(rawItemActivityPage.getNoumberOfTransferOutActivities(date) == noOfTransferActivities +1
				& rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount)){
			Reporter.reportPassResult(
					browser,
					"User should be able to find a Office transfer event of date D and deducted count value should be visible.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to find a Office transfer event of date D and deducted count value should be visible.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3344 : Verify that the above Store user's are able to submit "Office Transfer" type Transfer.
	@Test(enabled=false)
	public void transferBundle_US764_TC3344() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US764_TC3344";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String transferTypeIn = GlobalVariable.transferTypeIn;
		String nationalStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "2";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="5";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT)).click();
		if (Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Submit_BT)
				& !(Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT))) {
			Reporter.reportPassResult(
					browser,
					"Office Transfer :Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Office Transfer :Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		boolean transferAddedMsgDisplayed = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		Thread.sleep(3000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed & transferLandingPage.verifyTransferPlaced(date,transferType,"Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"Office Transfer :User should be able to save an office transfer details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Office Transfer :User should be able to save an office transfer details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		Thread.sleep(3000);
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		// Get the time of transfer
		time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferTypeIn).selectLocationToTransfer(nationalStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Get the total transfer amount
		amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT)).click();
		if (Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Submit_BT)
				& !(Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_No_BT))) {
			Reporter.reportPassResult(
					browser,
					"InTransfer : Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"InTransfer : Confirmation popup screen should get closed On clicking No button and user should be on Transfer popup screen.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		transferAddedMsgDisplayed = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		Thread.sleep(3000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed & transferLandingPage.verifyTransferPlaced(date,transferTypeIn,nationalStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"InTransfer : User should be able to save an In transfer details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"InTransfer : User should be able to save an office transfer details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}

}
