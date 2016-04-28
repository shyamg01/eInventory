package transferBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
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
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3060_Supervisor",
					"Supervisor should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3060_Supervisor_Condition1","transferBundle_US1891_TC3060_Supervisor",
					"Supervisor should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Supervisor_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3060_Supervisor",
					"Supervisor should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3060_Supervisor_Condition2","transferBundle_US1891_TC3060_Supervisor",
					"Supervisor should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Supervisor_Condition2");
		}
	}
	
	/*TC3060-Operator To Verify that user with Operator Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin2;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "3";
		String innerPackQuantity ="4";
		String looseUnitQuantity ="1";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		System.out.println("Type is"+transferType);
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3060_Operator",
					"Operator should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3060_Operator_Condition1","transferBundle_US1891_TC3060_Operator",
					"Operator should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Operator_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3060_Operator",
					"Operator should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3060_Operator_Condition2","transferBundle_US1891_TC3060_Operator",
					"Operator should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Operator_Condition2");
		}
	}
	
	/*TC3060-Level1 To Verify that user with Level1 Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin3;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "1";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3060_Level1",
					"Level1 User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3060_Level1_Condition1","transferBundle_US1891_TC3060_Level1",
					"Level1 User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Level1_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3060_Level1",
					"Level1 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3060_Level1_Condition2","transferBundle_US1891_TC3060_Level1",
					"Level1 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_Level1_Condition2");
		}
	}
	
	/*TC3060-SupervisorWithRoleAssignment To Verify that user with SupervisorWithRoleAssignment Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin4;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "1";
		String innerPackQuantity ="4";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3060_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3060_SupervisorWithRoleAssignment_Condition1","transferBundle_US1891_TC3060_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_SupervisorWithRoleAssignment_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3060_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3060_SupervisorWithRoleAssignment_Condition2","transferBundle_US1891_TC3060_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_SupervisorWithRoleAssignment_Condition2");
		}
	}
	
	/*TC3060-OrgAdmin To Verify that user with OrgAdmin Access is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3060_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin1;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "4";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3060_OrgAdmin",
					"OrgAdmin User should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3060_OrgAdmin_Condition1","transferBundle_US1891_TC3060_OrgAdmin",
					"OrgAdmin User should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_OrgAdmin_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3060_OrgAdmin",
					"OrgAdmin user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3060_OrgAdmin_Condition2","transferBundle_US1891_TC3060_OrgAdmin",
					"OrgAdmin user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3060_OrgAdmin_Condition2");
		}
	}

	//TC3061-Supervisor : To Verify if the Supervisor is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin1;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, "Office",amount)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3061_Supervisor",
					"Supervisor should be able to submit transfer to office","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3061_Supervisor","transferBundle_US1891_TC3061_Supervisor",
					"Supervisor should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3061_Supervisor");
		}
	}
	
	//TC3061-Operator : To Verify if the Operator is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="4";
		String looseUnitQuantity ="1";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, "Office",amount)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3061_Operator",
					"Operator should be able to submit transfer to office","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3061_Operator","transferBundle_US1891_TC3061_Operator",
					"Operator should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3061_Operator");
		}
	}
	
	//TC3061-Level1 : To Verify if the Level1 user is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, "Office",amount)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3061_Level1",
					"Level1 user should be able to submit transfer to office","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3061_Level1","transferBundle_US1891_TC3061_Level1",
					"Level1 user should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3061_Level1");
		}
	}
	
	//TC3061-SupervisorWithRoleAssignment : To Verify if the SupervisorWithRoleAssignment is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="4";
		String looseUnitQuantity ="2";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, "Office",amount)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3061_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user should be able to submit transfer to office","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3061_SupervisorWithRoleAssignment","transferBundle_US1891_TC3061_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3061_SupervisorWithRoleAssignment");
		}
	}
	
	//TC3061-OrgAdmin : To Verify if the OrgAdmin is able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3061_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "4";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		// Verify that cancel and print button are displayed
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, "Office",amount)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3061_OrgAdmin",
					"OrgAdmin should be able to submit transfer to office","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3061_OrgAdmin","transferBundle_US1891_TC3061_OrgAdmin",
					"OrgAdmin should be able to submit transfer to office","Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3061_OrgAdmin");
		}
	}

	//TC3062-Supervisor : To Verify if the Supervisor is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3062_Supervisor",
					"Supervisor is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3062_Supervisor","transferBundle_US1891_TC3062_Supervisor",
					"Supervisor is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3062_Supervisor");
		}
	}
	
	//TC3062-Operator : To Verify if the Operator is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3062_Operator",
					"operator is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3062_Operator","transferBundle_US1891_TC3062_Operator",
					"operator is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3062_Operator");
		}
	}
	
	//TC3062_Level1 : To Verify if the Level1 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3062_Level1",
					"Level1 user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3062_Level1","transferBundle_US1891_TC3062_Level1",
					"Level1 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3062_Level1");
		}
	}
	
	//TC3062_SupervisorWithRoleAssignment : To Verify if the SupervisorWithRoleAssignment user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3062_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3062_SupervisorWithRoleAssignment","transferBundle_US1891_TC3062_SupervisorWithRoleAssignment",
					"SupervisorWithRoleAssignment user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3062_SupervisorWithRoleAssignment");
		}
	}
	
	//TC3062_OrgAdmin : To Verify if the OrgAdmin user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3062_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="3";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectDateInAddNewTransferPopUp(date).selectTransferType(transferType)
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3062_OrgAdmin",
					"OrgAdmin user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3062_OrgAdmin","transferBundle_US1891_TC3062_OrgAdmin",
					"OrgAdmin user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3062_OrgAdmin");
		}
	}

	/*TC3063-level2 To Verify that user with level2 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = "2";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="5";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3063_level2",
					"level2 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3063_level2_Condition1","transferBundle_US1891_TC3063_level2",
					"level2 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level2_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3063_level2",
					"level2 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3063_level2_Condition2","transferBundle_US1891_TC3063_level2",
					"level2 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level2_Condition2");
		}
	}
	
	/*TC3063-level3 To Verify that user with level3 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = "1";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="5";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3063_level3",
					"level3 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3063_level3_Condition1","transferBundle_US1891_TC3063_level3",
					"level3 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level3_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3063_level3",
					"level3 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3063_level3_Condition2","transferBundle_US1891_TC3063_level3",
					"level3 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level3_Condition2");
		}
	}
	
	/*TC3063-level4 To Verify that user with level4 user is able to transfer raw items in/out to other stores.*/
	@Test()
	public void transferBundle_US1891_TC3063_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin3;
		String transferType = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore2;
		String caseQuantity = "1";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="5";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Verify that cancel and print button are displayed  
		boolean result = Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Cancel_BT)
				& Base.isElementDisplayed(transferLandingPage.AddTransferItemsPopup_Print_BT);
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
		if (result & transferLandingPage.verifyTransferPlaced(date, time, transferStoreNumber,amount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US1891_TC3063_level4",
					"level4 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3063_level4_Condition1","transferBundle_US1891_TC3063_level4",
					"level4 user should be able to transfer raw items in/out to other stores and able to view print button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level4_Condition1");
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
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
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
		if (!transferLandingPage.verifyTransferPlaced(date,time2, amount2)) {
			Reporter.reportPassResult(browser, "transferBundle_US1891_TC3063_level4",
					"level4 user should be able to cancel transfer for raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "transferBundle_US1891_TC3063_level4_Condition2","transferBundle_US1891_TC3063_level4",
					"level4 user should be able to cancel transfer for raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3063_level4_Condition2");
		}
	}

	//TC3064-Level2 : To Verify if the Level2 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "3";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3064_Level2","transferBundle_US1891_TC3064_Level2",
					"level 2 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3064_Level2");
		} else {
			Reporter.reportPassResult(browser,"transferBundle_US1891_TC3064_Level2",
					"level 2 user is restricted to office transfer", "Pass");
		}
	}
	
	//TC3064-Level3 : To Verify if the Level3 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "2";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3064_Level3","transferBundle_US1891_TC3064_Level3",
					"level 3 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3064_Level3");
		} else {
			Reporter.reportPassResult(browser,"transferBundle_US1891_TC3064_Level3",
					"level 3 user is restricted to office transfer", "Pass");
		}
	}
	
	//TC3064-Level4 : To Verify if the Level4 user should not be able to transfer raw items to office
	@Test()
	public void transferBundle_US1891_TC3064_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/*String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "1";
		String innerPackQuantity ="2";
		String looseUnitQuantity ="1";*/
		String date = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		homePage.selectUser(userId).selectLocation(storeId).navigateToInventoryManagement()
				.goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		if (transferLandingPage.verifyOfficeTransferIsPresent()) {
			Reporter.reportTestFailure(
					browser,"transferBundle_US1891_TC3064_Level4","transferBundle_US1891_TC3064_Level4",
					"level 4 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3064_Level4");
		} else {
			Reporter.reportPassResult(browser,"transferBundle_US1891_TC3064_Level4",
					"level 4 user is restricted to office transfer", "Pass");
		}
	}

	//TC3065-level2 : To Verify if the level2 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "1";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="2";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3065_level2",
					"level2 user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3065_level2","transferBundle_US1891_TC3065_level2",
					"level2 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3065_level2");
		}
	}
	
	//TC3065-level3 : To Verify if the level3 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "1";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="7";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3065_level3",
					"level3 user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3065_level3","transferBundle_US1891_TC3065_level3",
					"level3 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3065_level3");
		}
	}
	
	//TC3065-level4 : To Verify if the level4 user is able to view and print raw items transfer details
	@Test()
	public void transferBundle_US1891_TC3065_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "2";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="3";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3065_level3",
					"level3 user is able to view raw items transfer details and able to view print button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3065_level3","transferBundle_US1891_TC3065_level3",
					"level3 user is able to view raw items transfer details and able to view print button", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3065_level3");
		}
	}
	
	//TC3067-level5 : To Verify if the level5 user is not able to view Transfer option from Main Menu.
	@Test()
	public void transferBundle_US1891_TC3067_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement();
		 wait.until(ExpectedConditions.visibilityOf(homePage.OtherInventoryFunctions_BT));
		 homePage.OtherInventoryFunctions_BT.click();
		//Verify that user is able to view the transfer entry details
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3067_level5",
					"level5 user is not able to view Transfer option from Main Menu", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3067_level5","transferBundle_US1891_TC3067_level5",
					"level5 user is not able to view Transfer option from Main Menu", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3067_level5");
		}
	}
	
	//TC3067-level6 : To Verify if the level6 user is not able to view Transfer option from Main Menu.
	@Test()
	public void transferBundle_US1891_TC3067_level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement();
		 wait.until(ExpectedConditions.visibilityOf(homePage.OtherInventoryFunctions_BT));
		 homePage.OtherInventoryFunctions_BT.click();
		//Verify that user is able to view the transfer entry details
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser, "transferBundle_US1891_TC3067_level6",
					"level6 user is not able to view Transfer option from Main Menu", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US1891_TC3067_level6","transferBundle_US1891_TC3067_level6",
					"level6 user is not able to view Transfer option from Main Menu", "Fail");
			AbstractTest.takeSnapShot("transferBundle_US1891_TC3067_level6");
		}
	}
}
