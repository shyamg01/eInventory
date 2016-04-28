package transferBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.TransferLandingPage;
import sprint2.AbstractTest;

public class US857_UIUXRetrofitTransfers extends AbstractTest{
	
	//TC3095 : Verify,"Transfer Page is accessible from the Main Menu".
	@Test()
	public void transferBundle_US857_TC3095() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		if (Base.isElementDisplayed(transferLandingPage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3095",
					"Transfer Page is accessible from the Main Menu",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3095","transferBundle_US857_TC3095",
					"Transfer Page is accessible from the Main Menu",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3095");
		}
	}
	
	//TC3100 :Verify,"Header persists through the Transfer Page".
	@Test()
	public void transferBundle_US857_TC3100() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		if (Base.isElementDisplayed(transferLandingPage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3100",
					"User should be able to view the header as Transfers.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3100","transferBundle_US857_TC3100",
					"User should be able to view the header as Transfers.",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3100");
		}
	}
	
	//TC3101 : Verify,"The Main Menu can be opened and closed from the Transfer Page".".
	@Test()
	public void transferBundle_US857_TC3101() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		homePage.Menu_DD_BT.click();
		if (Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3101",
					"User should be able to open the main menu from TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3101","transferBundle_US857_TC3101",
					"User should be able to open the main menu from TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3101");
		}
	}
	
	//TC3109 : Verify,"Users need to search for transfers within a date range from the Transfer Page"..
	@Test()
	public void transferBundle_US857_TC3109() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		if (transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(GlobalVariable.startDate, GlobalVariable.endDate)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3109",
					"User should be able to view transfer History for selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3109","transferBundle_US857_TC3109",
					"User should be able to view transfer History for selected date range",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3109");
		}
	}
	
	//TC3110 Verify,"Transfer Page filter criteria defaults to the current month for both Start and End Date".
	@Test()
	public void transferBundle_US857_TC3110() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		if (transferLandingPage.StartDate_TB.getAttribute("value").equals(startDate)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3110",
					"User should able to view the start date as 1st date of current month",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3110_Condition1","transferBundle_US857_TC3110",
					"User should able to view the start date as 1st date of current month",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3110_Condition1");
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+endDate);
		if (transferLandingPage.EndDate_TB.getAttribute("value").equals(endDate)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3110",
					"User should able to view the end date as current date of current month",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3110_Condition2","transferBundle_US857_TC3110",
					"User should able to view the end date as current date of current month",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3110_Condition2");
		}
		
	}
	
	//TC3111 : Verify,"Transfer Page includes a calendar function to facilitate Start and End Date entry".
	@Test()
	public void transferBundle_US857_TC3111() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		if (Base.isElementDisplayed(transferLandingPage.StartDatePicker_Cal_Icon)
				& Base.isElementDisplayed(transferLandingPage.EndDatePicker_Cal_Icon)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3111",
					"User should be able to view  start date calendar icon and end date calendar icon",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3111","transferBundle_US857_TC3111",
					"User should be able to view  start date calendar icon and end date calendar icon",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3111");
		}
	}
	
	//TC3112 : Verify,"Transfer Page provides a listing of transfers (In, Out and Office Transfer) for the date range specified".
	@Test()
	public void transferBundle_US857_TC3112() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		
		if (Base.isElementDisplayed(transferLandingPage.StartDatePicker_Cal_Icon)
				& Base.isElementDisplayed(transferLandingPage.EndDatePicker_Cal_Icon)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3112",
					"User should be able to view  start date calendar icon and end date calendar icon",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3112","transferBundle_US857_TC3112",
					"User should be able to view  start date calendar icon and end date calendar icon",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3112");
		}
	}
	
	//TC3113 : Verify,"Transfer listings cascade down the page regardless of count for the criteria selected".
	@Test()
	public void transferBundle_US857_TC3113() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		if (transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(GlobalVariable.startDate, GlobalVariable.endDate)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3113",
					"User should be able to view the transfer listings cascade down the page regardless of count for the date range selected",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3113","transferBundle_US857_TC3113",
					"User should be able to view the transfer listings cascade down the page regardless of count for the date range selected",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3113");
		}
	}
	
	//TC3115 : Verify,"Each listing provides the user with a transfer’s summary including:  Transfer Date/Time, Transfer Type, Store, and Amount along with a View into additional transfer details for that particular listing".
	@Test()
	public void transferBundle_US857_TC3115() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException 
	{
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		if (Base.isElementDisplayed(transferLandingPage.TransferTime_Header)
				& Base.isElementDisplayed(transferLandingPage.TransferType_Header)
				& Base.isElementDisplayed(transferLandingPage.TransferLocation_Header)
				& Base.isElementDisplayed(transferLandingPage.TransferAmount_Header)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3115",
					"User should be able to view the transfer’s summary including:  Transfer Date/Time, Transfer Type, Store, and Amount Headers",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3115","transferBundle_US857_TC3115",
					"User should be able to view the transfer’s summary including:  Transfer Date/Time, Transfer Type, Store, and Amount Headers",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3115");
		}
	}
	
	//TC3117 : Verify,"Transfer Page includes toggles for Transfer Date/Time, Transfer Type, Store, and Amount giving users the ability to sort the fields in ascending or descending order".
	@Test()
	public void transferBundle_US857_TC3117() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		transferLandingPage.TransferAmount_Header.click();
		boolean amountInAscendingOrder = transferLandingPage.verifyAmountIsInAscendingOrder();
		transferLandingPage.TransferAmount_Header.click();
		boolean amountInDescendingOrder = transferLandingPage.verifyAmountIsInDescendingOrder();
		if (amountInAscendingOrder & amountInDescendingOrder ) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3117",
					"User should be able to view TransferAmount in ascending/Descending order",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3117","transferBundle_US857_TC3117",
					"User should be able to view TransferAmount in ascending/Descending order",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3117");
		}
	}
	
	//TC3127 : Verify,"Transfer Page provides functionality for users to create new transfers".
	@Test()
	public void transferBundle_US857_TC3127() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		if (Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3127",
					"User should be able to view Create New Transfers button on transfer landing page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3127","transferBundle_US857_TC3127",
					"User should be able to view Create New Transfers button on transfer landing page",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3127");
		}
	}
	
	//TC3128 : Verify,"Transfer Page provides access to a Detail Form for each transfer listing that provides the user with additional information".
	@Test()
	public void transferBundle_US857_TC3128() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		transferLandingPage.TransferLandingPage_Records_List.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferForm_Date_TB));
		if (transferLandingPage.ViewTransferForm_Records_List.size()>0) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3128",
					"User should be able to view additional information related to a transfer on clicking view details",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3128","transferBundle_US857_TC3128",
					"User should be able to view additional information related to a transfer on clicking view details",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3128");
		}
	}
	
	//TC3129 : Verify,"The Transfer Detail Form is read-only"..
	@Test()
	public void transferBundle_US857_TC3129() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		transferLandingPage.TransferLandingPage_Records_List.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferForm_Date_TB));
		if (transferLandingPage.ViewTransferForm_Date_TB.getAttribute("disabled").equals("true")
				& transferLandingPage.ViewTransferForm_Time_TB.getAttribute("disabled").equals("true")
				& transferLandingPage.ViewTransferForm_TransferType_TB.getAttribute("disabled").equals("true")
				& transferLandingPage.ViewTransferForm_StoreBumber_TB.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3129",
					"User should be able to view transfer detail form as read-only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3129","transferBundle_US857_TC3129",
					"User should be able to view transfer detail form as read-only",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3129");
		}
	}
	
	//TC3132 : Verify,"The Transfer Detail Form information includes the Transfer Date/Time, Preparer, Transfer Type, Transfer Store".
	@Test()
	public void transferBundle_US857_TC3132() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String nationalStoreNumber = GlobalVariable.nationalStore1;
		String date = GlobalVariable.createDate;
		String caseQuantity = "5";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="8";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.Transfer_Title));
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText();
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(nationalStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		// click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		transferLandingPage.viewTransfer(date, time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferForm_Date_TB));
		if (transferLandingPage.ViewTransferForm_Date_TB.getAttribute("value").equals(date)
				& transferLandingPage.ViewTransferForm_Time_TB.getAttribute("value").equals(time)
				& transferLandingPage.ViewTransferForm_TransferType_TB.getAttribute("value").equalsIgnoreCase(transferType)
				& transferLandingPage.ViewTransferForm_StoreBumber_TB.getAttribute("value").equals(nationalStoreNumber)
				& transferLandingPage.ViewTransferForm_PreparerName_Value.getText().contains(userId)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3132",
					"User should be able to view the Transfer Detail Form information which includes the Transfer Date/Time, Preparer, Transfer Type, Transfer Store.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3132","transferBundle_US857_TC3132",
					"User should be able to view the Transfer Detail Form information which includes the Transfer Date/Time, Preparer, Transfer Type, Transfer Store.",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3132");
		}
	}
	
	//TC3133 : Verify,"The Transfer Detail Form provides the user with information for each raw item in the transfer including:  WRIN, Description, Case, Pack, Loose, Item Total and Subtotal".
	@Test()
	public void transferBundle_US857_TC3133() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		transferLandingPage.TransferLandingPage_Records_List.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferForm_Date_TB));
		if (Base.isElementDisplayed(transferLandingPage.ViewTransferForm_Wrin_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_Description_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_CaseCount_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_InnerPackCount_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_LooseCount_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_UnitsCount_Header)
				& Base.isElementDisplayed(transferLandingPage.ViewTransferForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3133",
					"User should be able to view the Transfer Detail Form which provides the user with information for each raw item in the transfer including: WRIN, Description, Case, Pack, Loose, Item Total and Subtotal",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3133","transferBundle_US857_TC3133",
					"User should be able to view the Transfer Detail Form which provides the user with information for each raw item in the transfer including: WRIN, Description, Case, Pack, Loose, Item Total and Subtotal",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3133");
		}
	}
	
	//TC3134 : Verify,"The Transfer Detail Form provides the user with a Grand Total for the raw items in the transfer".
	@Test()
	public void transferBundle_US857_TC3134() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		transferLandingPage.TransferLandingPage_Records_List.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferForm_Date_TB));
		if (!transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3134",
					"The Transfer Detail Form provides the user with a Grand Total for the raw items in the transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3134","transferBundle_US857_TC3134",
					"The Transfer Detail Form provides the user with a Grand Total for the raw items in the transfer",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3134");
		}
	}
	
	//TC3136 : Verify,"The ‘Create New Transfer’ Form adheres to the approved Interaction Framework and Visual Design".
	@Test()
	public void transferBundle_US857_TC3136() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Header)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3136",
					"User should be able to view a pop-up screen on Clicking the Create New Transfer Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3136","transferBundle_US857_TC3136",
					"User should be able to view a pop-up screen on Clicking the Create New Transfer Button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3136");
		}
	}
	
	//TC3137 : Verify,"The Form requires Date, Time, Transfer Type, Store Number and at least one Raw Item as input from the user before a transfer can be submitted".
	@Test()
	public void transferBundle_US857_TC3137() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Header)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3137",
					"User should be able to view a pop-up screen on Clicking the Create New Transfer Button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3137","transferBundle_US857_TC3137",
					"User should be able to view a pop-up screen on Clicking the Create New Transfer Button",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3137");
		}
	}
	
	//TC3140 : Verify,"The Form provides a calendar control to facilitate Date entry".
	@Test()
	public void transferBundle_US857_TC3140() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.selectDateInAddNewTransferPopUp(GlobalVariable.createDate);
		System.out.println(transferLandingPage.AddTransferPopup_Date_TB.getAttribute("value"));
		if (transferLandingPage.AddTransferPopup_Date_TB.getAttribute("value").equals(GlobalVariable.createDate)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3140",
					"User should be able to click and select date to create transfer from calendar icon",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3140","transferBundle_US857_TC3140",
					"User should be able to click and select date to create transfer from calendar icon",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3140");
		}
	}
	
	//TC3141 : Verify,"The Form provides a calendar control to facilitate Date entry".
	@Test()
	public void transferBundle_US857_TC3141() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.selectTimeInAddNewTransferForm(GlobalVariable.transferTime);
		System.out.println(transferLandingPage.AddTransferPopup_Time_TB.getText());
		if (transferLandingPage.AddTransferPopup_Time_TB.getText().equals(GlobalVariable.transferTime)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3141",
					"User should be able to click and select time to create transfer from calendar icon",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3141","transferBundle_US857_TC3141",
					"User should be able to click and select time to create transfer from calendar icon",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3141");
		}
	}
	
	//TC3145 : Verify,"The Form provides a control for users to select between Transfer Types:  Transfer In, Transfer Out, Office Transfer.  Only one selection is allowed".
	@Test()
	public void transferBundle_US857_TC3145() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		Select selectTransferType = new Select(transferLandingPage.TransferType_DD);
		List<WebElement>transferType = selectTransferType.getOptions();
		System.out.println(transferType.get(1).getAttribute("value"));
		if (transferType.get(1).getAttribute("value").equalsIgnoreCase(GlobalVariable.transferTypeOffice)
				& transferType.get(2).getAttribute("value").equalsIgnoreCase(GlobalVariable.transferTypeIn)
				& transferType.get(3).getAttribute("value").equalsIgnoreCase(GlobalVariable.transferTypeOut)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3145",
					"User should be able to view the transfer type as: Transfer In, Transfer Out, Office Transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3145","transferBundle_US857_TC3145",
					"User should be able to view the transfer type as: Transfer In, Transfer Out, Office Transfer",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3145");
		}
	}
	
	//TC3146 : Verify,"The Form provides functionality to assign raw items to the transfer by raw item number or description. At least one raw item added is required per transfer".
	@Test()
	public void transferBundle_US857_TC3146() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType);
		Thread.sleep(2000);
		if (transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3146",
					"User should not be able to complete any transfer without at least one wrin",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3146_Condition1","transferBundle_US857_TC3146",
					"User should not be able to complete any transfer without at least one wrin",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3146_Condition1");
		}
		transferLandingPage.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		if (Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3146",
					"User should be able to Submit transfer with Wrin Item added",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3146_Condition2","transferBundle_US857_TC3146",
					"User should be able to Submit transfer with Wrin Item added",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3146_Condition2");
		}
	}
	
	//TC3147 : Verify,"For each raw item added:A confirmation message will appear anchored to the bottom of the form".
	@Test()
	public void transferBundle_US857_TC3147() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		Thread.sleep(2000);
		if (Base.isElementDisplayed(transferLandingPage.AddTransferPopup_ItemAdded_Msg)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3147",
					"User should be able to view the confirmation message for the wrin added at the bottom of form",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3147","transferBundle_US857_TC3147",
					"User should be able to view the confirmation message for the wrin added at the bottom of form",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3147");
		}
	}
	
	//TC3148 : Verify,"Once a raw item has been added it will display in a list view with the following details:  WRIN, Description, Case, Pack, Loose, Item Total and Sub Total".
	@Test()
	public void transferBundle_US857_TC3148() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		Thread.sleep(2000);
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_Wrin_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_Description_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_CaseCount_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_InnerPackCount_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_LooseCount_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_UnitsCount_Header)
				& Base.isElementDisplayed(transferLandingPage.AddNewTransferForm_SubTotal_Header)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3148",
					"ser should be able to view the following list for the wrin added: WRIN, Description, Case, Pack, Loose, Item Total and Sub Total",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3148","transferBundle_US857_TC3148",
					"ser should be able to view the following list for the wrin added: WRIN, Description, Case, Pack, Loose, Item Total and Sub Total",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3148");
		}
	}
	
	/* TC3149 : Verify, The Form requires, for each raw item added, the user to enter a quantity for at least 
	 * one of the item quantity fields (Case, Pack, or Loose) before a transfer can be submitted"*/
	@Test()
	public void transferBundle_US857_TC3149() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		if (transferLandingPage.AddTransferItemsPopup_Submit_BT.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3149",
					"User should NOT be able to submit without entering the quantities",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3149_Condition1","transferBundle_US857_TC3149",
					"User should NOT be able to submit without entering the quantities",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3149_Condition1");
		}
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		if (Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3149",
					"User should be able to submit the transfer details with Case, Pack, or Loose quantities",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3149_Condition2","transferBundle_US857_TC3149",
					"User should be able to submit the transfer details with Case, Pack, or Loose quantities",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3149_Condition2");
		}
	}
	
	/* TC3151 : Verify,"The Form calculates Item Total and Sub Total once the item’s quantity fields have been entered".*/
	@Test()
	public void transferBundle_US857_TC3151() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		String subTotal = transferLandingPage.getTotalTransferAmunt();
		String total = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText();
		// Submit the transfer
		if (total.contains(subTotal)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3151",
					"User should be able to view calculates Item Total and Sub Total once the item’s quantity fields have been entered",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3151","transferBundle_US857_TC3151",
					"User should be able to view calculates Item Total and Sub Total once the item’s quantity fields have been entered",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3151");
		}
	}
	
	/* TC3152 : Verify,"The Form provides functionality to delete raw items from the transfer before submission".*/
	@Test()
	public void transferBundle_US857_TC3152() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		transferLandingPage.removeWrinIdFromTransferPage(samplewRINID);
		// Submit the transfer
		if (!transferLandingPage.verifyItemIsAdded(samplewRINID)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3152",
					"The Form provides functionality to delete raw items from the transfer before submission",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3152","transferBundle_US857_TC3152",
					"The Form provides functionality to delete raw items from the transfer before submission",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3152");
		}
	}

	
	/* TC3154 : User should be able to cancel the form and view the corresponding confirmation message for the entries in the form*/
	@Test()
	public void transferBundle_US857_TC3154() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		transferLandingPage.AddTransferForm_Close_BT.click();
		System.out.println(transferLandingPage.CancelTransfer_Warning_Message.getText());
		// Submit the transfer
		if (Base.isElementDisplayed(transferLandingPage.CancelTransfer_Warning_Message)
				& transferLandingPage.CancelTransfer_Warning_Message.getText().contains("Are you sure you want to cancel")
				& Base.isElementDisplayed(transferLandingPage.CanceTransferPopup_Yes_BT)
				& Base.isElementDisplayed(transferLandingPage.CanceTransferPopup_No_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3154",
					"User should be able to cancel the form on clicking Close(X) button and view the corresponding confirmation message for the entries in the form",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3154","transferBundle_US857_TC3154",
					"User should be able to cancel the form on clicking Close(X) button and view the corresponding confirmation message for the entries in the form",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3154");
		}
	}
	
	/* TC3155 : Verify,"Click/touch on ‘Cancel’ clears and closes the form. If the form contains entries then display the corresponding confirmation message".*/
	@Test()
	public void transferBundle_US857_TC3155() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		System.out.println(transferLandingPage.CancelTransfer_Warning_Message.getText());
		// Submit the transfer
		if (Base.isElementDisplayed(transferLandingPage.CancelTransfer_Warning_Message)
				& transferLandingPage.CancelTransfer_Warning_Message.getText().contains("Are you sure you want to cancel")
				& Base.isElementDisplayed(transferLandingPage.CanceTransferPopup_Yes_BT)
				& Base.isElementDisplayed(transferLandingPage.CanceTransferPopup_No_BT)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3155",
					"User should be able to cancel the form on clicking Cancel Button and view the corresponding confirmation message for the entries in the form",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3155","transferBundle_US857_TC3155",
					"User should be able to cancel the form on clicking Cancel Button and view the corresponding confirmation message for the entries in the form",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3155");
		}
	}
	
	/* TC3156 : Verify,"Click/touch on ‘Submit’ updates the Transfer status list view to reflect the newly completed Transfer and displays the submit confirmation message".*/
	@Test()
	public void transferBundle_US857_TC3156() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String time = GlobalVariable.transferTime;
		String caseQuantity = "5";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="6";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(time);;
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		String transferAmount = transferLandingPage.getTotalTransferAmunt();
		System.out.println("transferAmount "+transferAmount);
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		// Submit the transfer
		if (Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3156",
					"User should be able to see confirmation message on submitting the transfer entries",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3156_Condition1","transferBundle_US857_TC3156",
					"User should be able to see confirmation message on submitting the transfer entries",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3156_Condition1");
		}
		Thread.sleep(5000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		// Submit the transfer
		if (transferLandingPage.verifyTransferPlaced(date, time, "Office",transferAmount)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3156",
					"User should be able view newly completed Transfer in the Transfer status list view on landing page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3156_Condition2","transferBundle_US857_TC3156",
					"User should be able view newly completed Transfer in the Transfer status list view on landing page",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3156_Condition2");
		}
	}
	
	/* TC3158 : Verify,"Transfer submission provides a confirmation to the user that anchors to the bottom of the browser".*/
	@Test()
	public void transferBundle_US857_TC3158() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String time = GlobalVariable.transferTime;
		String caseQuantity = "5";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="7";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(time);;
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID);
		//wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferPopup_ItemAdded_Msg)).click();
		transferLandingPage.EnterQuantitiesForWrinId(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		String transferAmount = transferLandingPage.getTotalTransferAmunt();
		System.out.println("transferAmount "+transferAmount);
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		// Submit the transfer
		if (Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag)) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3158",
					"User should be able to view the submit confirmation message at the bottom of the screen on submitting the transfer entries",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3158","transferBundle_US857_TC3158",
					"User should be able to view the submit confirmation message at the bottom of the screen on submitting the transfer entries",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3158");
		}
	}
	
	/* TC3159 : Verify,"The Form’s scroll bars display when the contents of containers exceed the fixed height (Desktop Only)".*/
	@Test()
	public void transferBundle_US857_TC3159() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID1 = GlobalVariable.addTransferItemWrin;
		String samplewRINID2= GlobalVariable.addTransferItemWrin1;
		String samplewRINID3 = GlobalVariable.addTransferItemWrin2;
		String samplewRINID4 = GlobalVariable.addTransferItemWrin3;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String time = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(time);;
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID1).seacrhAndSelectRawItem(samplewRINID2);
		transferLandingPage.seacrhAndSelectRawItem(samplewRINID3).seacrhAndSelectRawItem(samplewRINID4);
		int noOfItem = transferLandingPage.AddTransferForm_TransferItemEntry_List.size();
		Actions actions = new Actions(driver);
		actions.moveToElement(transferLandingPage.AddTransferForm_TransferItemEntry_List.get(noOfItem-1));
		actions.perform();
		//verify that Promotion and Waste page is accessible from the Main Menu
		if (transferLandingPage.AddTransferForm_TransferItemEntry_List.get(noOfItem-1).isDisplayed()) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3159",
					"The Form’s scroll bars display when the contents of containers exceed the fixed height.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3159","transferBundle_US857_TC3159",
					"The Form’s scroll bars display when the contents of containers exceed the fixed height.",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3159");
		}
	}
	
	/* TC3160 :Verify,"The Form can be collapsed and re-opened. When the user scrolls the form anchors to the browser and remains visible"..*/
	@Test()
	public void transferBundle_US857_TC3160() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID1 = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeOffice;
		String date = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer  button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		transferLandingPage.selectStartDate(startDate).selectEndDate(endDate).ShowResults_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddNewTransfer_Header));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		// Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).seacrhAndSelectRawItem(samplewRINID1);
		transferLandingPage.AddTransferForm_SliderToggle_BT.click();
		// verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (transferLandingPage.AddTransferForm_Container.getAttribute("class").contains("modalCollapsedView")) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3160",
					"User should be able to collapse the Add new transfer screen",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3160_Condition1","transferBundle_US857_TC3160",
					"User should be able to collapse the Add new transfer screen",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3160_Condition1");
		}
		transferLandingPage.AddTransferForm_SliderToggle_BT.click();
		// verify that user User should be able to close add manual vendor form on clicking Cancel button
		if (transferLandingPage.AddTransferForm_Container.getAttribute("class").contains("modalExpandedView")) {
			Reporter.reportPassResult(
					browser,"transferBundle_US857_TC3160",
					"User should be able to expand the Add new transfer screen",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"transferBundle_US857_TC3160_Condition2","transferBundle_US857_TC3160",
					"User should be able to expand the Add new transfer screen",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US857_TC3160_Condition2");
		}
		transferLandingPage.AddTransferForm_SliderToggle_BT.click();
		int noOfRecords = transferLandingPage.TransferLandingPage_Records_List.size();
		if (noOfRecords > 0) {
			action.moveToElement(transferLandingPage.TransferLandingPage_Records_List.get(noOfRecords - 1));
			action.perform();
			// verify that Promotion and Waste page is accessible from the Main Menu
			if (transferLandingPage.TransferLandingPage_Records_List.get(noOfRecords - 1).isDisplayed()) {
				Reporter.reportPassResult(
						browser,"transferBundle_US857_TC3160",
						"User should be able to scroll up/down in Transfer landing page when Add new transfer Form is collpased",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"transferBundle_US857_TC3160_Condition3",
						"transferBundle_US857_TC3160",
						"User should be able to scroll up/down in Transfer landing page when Add new transfer Form is collpased",
						"Fail");
				AbstractTest.takeSnapShot("transferBundle_US857_TC3160_Condition3");
			}
		}
	}

}
