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
import eInventoryPageClasses.TransferLandingPage;

public class US1891_TransfersBundleUserRoleAccess extends AbstractTest{
	
	/*TC3060-Supervisor To Verify that user with Supervisor Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3060_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/*String transferTime = GlobalVariable.transferTime;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 10;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 10;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 10;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID,String.valueOf(caseQty2),String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the time of transfer
		/*String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,amount2)) {
			Reporter.reportPassResult(browser,
					"Supervisor should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"Supervisor should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3060-Operator To Verify that user with Operator Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3060_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin2;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		System.out.println("Type is"+transferType);
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		//Get the time of transfer
		/*String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"Operator should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 10;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 10;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 10;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		//Get the time of transfer
		/*String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
				String.valueOf(caseQty2), String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date, amount2)) {
			Reporter.reportPassResult(browser,
					"Operator should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"Operator should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3060-Level1 To Verify that user with Level1 Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3060_Level1";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin3;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		//Get the time of transfer
//		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"Level1 User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level1 User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 10;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 10;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 10;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
				String.valueOf(caseQty2), String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the time of transfer
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,amount2)) {
			Reporter.reportPassResult(browser,
					"Level1 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"Level1 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3060-SupervisorWithRoleAssignment To Verify that user with SupervisorWithRoleAssignment Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3060_SupervisorWithRoleAssignment";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin4;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		//Get the time of transfer
//		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 10;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 10;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 10;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
				String.valueOf(caseQty2), String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,transferType,transferStoreNumber, amount2)) {
			Reporter.reportPassResult(browser,
					"SupervisorWithRoleAssignment user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {

			Reporter.reportTestFailure(browser, 
					"SupervisorWithRoleAssignment user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3060-OrgAdmin To Verify that user with OrgAdmin Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3060_OrgAdmin";
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin1;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);*/
		//Get the time of transfer
//		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"OrgAdmin User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
				String.valueOf(caseQty2), String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,transferType,transferStoreNumber, amount2)) {
			Reporter.reportPassResult(browser,
					"OrgAdmin user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"OrgAdmin user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3061-Supervisor : To Verify if the Supervisor is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3061_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin1;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, "Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to submit transfer to office","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3061-Operator : To Verify if the Operator is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3061_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, "Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"Operator should be able to submit transfer to office","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3061-Level1 : To Verify if the Level1 user is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3061_Level1";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
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
		
		// Select the transfer type as "Office" and add the transfer details
		// Select the transfer type as "Office" and add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		// Get the time of transfer
				String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, "Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"Level1 user should be able to submit transfer to office","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level1 user should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3061-SupervisorWithRoleAssignment : To Verify if the SupervisorWithRoleAssignment is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3061_SupervisorWithRoleAssignment";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
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
		// Select the transfer type as "Office" and add the transfer details
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Get the time of transfer
		/*String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, "Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment user should be able to submit transfer to office","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment user should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3061-OrgAdmin : To Verify if the OrgAdmin is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3061_OrgAdmin";
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
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
		// Select the transfer type as "Office" and add the transfer details
//		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.transferTime);
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Get the time of transfer
//		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, "Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"OrgAdmin should be able to submit transfer to office","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3062-Supervisor : To Verify if the Supervisor is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3062_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		// Select the transfer type as "Office" and add the transfer details
/*		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3062-Operator : To Verify if the Operator is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3062_Operator";
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
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "Office" and add the transfer details
		// Select the transfer type as "Office" and add the transfer details
/*		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"operator is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"operator is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3062_Level1 : To Verify if the Level1 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3062_Level1";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
	/*	// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		/*String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"Level1 user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level1 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3062_SupervisorWithRoleAssignment : To Verify if the SupervisorWithRoleAssignment user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3062_SupervisorWithRoleAssignment";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		// Select the transfer type as "Office" and add the transfer details
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3062_OrgAdmin : To Verify if the OrgAdmin user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3062_OrgAdmin";
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		// Select the transfer type as "Office" and add the transfer details
/*		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"OrgAdmin user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	/*TC3063-level2 To Verify that user with level2 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3063_level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"level2 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level2 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Select the transfer type as "Office" and add the transfer details
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		//Get the time of transfer
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID,String.valueOf(caseQty2),String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,amount2)) {
			Reporter.reportPassResult(browser,
					"level2 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {

			Reporter.reportTestFailure(browser, 
					"level2 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3063-level3 To Verify that user with level3 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3063_level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"level3 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level3 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		// Select the transfer type as "Office" and add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID,String.valueOf(caseQty2),String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,amount2)) {
			Reporter.reportPassResult(browser,
					"level3 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"level3 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3063-level4 To Verify that user with level4 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="transferBundle_US1891_TC3063_level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin3;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date,transferType, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,
					"level4 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level4 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		Thread.sleep(4000);
		//click on Create new Transfer button
//		transferLandingPage.BackToTop_BT.click();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Select the transfer type as "Office" and add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		//Get the time of transfer
//		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID,String.valueOf(caseQty2),String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		//Get the amount
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//click on cancel button
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Verify that user should be able to cancel transfer and transfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(date,amount2)) {
			Reporter.reportPassResult(browser,
					"level4 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(browser,
					"level4 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC3064-Level2 : To Verify if the Level2 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3064_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "3";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
//		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Select the transfer type as "Office" and add the transfer details
//		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,
					"level 2 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot();
			
		} else {
			Reporter.reportPassResult(browser,
					"level 2 user is restricted to office transfer", "Pass");
			
		}
	}
	
	//TC3064-Level3 : To Verify if the Level3 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3064_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
//		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
//		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,
					"level 3 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot();
			
		} else {
			Reporter.reportPassResult(browser,
					"level 3 user is restricted to office transfer", "Pass");
			
		}
	}
	
	//TC3064-Level4 : To Verify if the Level4 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3064_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
//		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
//		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,
					"level 4 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot();
			
		} else {
			Reporter.reportPassResult(browser,
					"level 4 user is restricted to office transfer", "Pass");
			
		}
	}

	//TC3065-level2 : To Verify if the level2 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3065_level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
	/*	transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"level2 user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"level2 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3065-level3 : To Verify if the level3 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3065_level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"level3 user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level3 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3065-level4 : To Verify if the level4 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3065_level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
//		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		//View the transfer entry
		transferLandingPage.viewTransfer(date,amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser,
					"level3 user is able to view raw items transfer details and able to view print button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level3 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3067-level5 : To Verify if the level5 user is not able to view Transfer option from Main Menu.
	@Test()
	public void transferBundle_US1891_TC3067_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3067_level5";

		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)).click();
		//Verify that user is able to view the transfer entry details
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser,
					"level5 user is not able to view Transfer option from Main Menu", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"level5 user is not able to view Transfer option from Main Menu", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3067-level6 : To Verify if the level6 user is not able to view Transfer option from Main Menu.
	@Test()
	public void transferBundle_US1891_TC3067_level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US1891_TC3067_level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)).click();
		//Verify that user is able to view the transfer entry details
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser,
					"level6 user is not able to view Transfer option from Main Menu", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"level6 user is not able to view Transfer option from Main Menu", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
}
