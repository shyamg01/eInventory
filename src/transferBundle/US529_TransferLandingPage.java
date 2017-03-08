package transferBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
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

public class US529_TransferLandingPage extends AbstractTest {
	// TC798 : Verify the UI of the transfer page..
	@Test(groups="Smoke")
	public void transferBundle_US529_TC798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="transferBundle_US529_TC798";
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.selectLocation(storeId).goToTransferLandingPage();
		// Verify the UI of the screen
		if (Base.isElementDisplayed(transferLandingPage.TransferLandingPage_Label)
				&& Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)
				&& Base.isElementDisplayed(transferLandingPage.StartDate_TB)
				&& Base.isElementDisplayed(transferLandingPage.EndDate_TB)
				&& Base.isElementDisplayed(transferLandingPage.ShowResults_BT)
				&& Base.isElementDisplayed(transferLandingPage.TransferTime_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferType_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferAmount_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferLocation_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferLandingPage_CurrentDayActivity_Label)
		) {
			Reporter.reportPassResult(
					browser,
					"All the labels and the button are shwoing properly","Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser, 
					"All the labels and the button are shwoing properly",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		for (int i = 1; i <= driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr")).size(); i++) 
		{
			if(Base.isElementDisplayed(By.xpath("//table[@id='transfercounts']/tbody/tr/td/div[2]/p[2][text()='Try selecting another date range.']")))
			{
				//Do nothing
			}
			else
			{
				// Verify the date and time format for each records
				boolean result = Pattern.compile(datepattern).matcher(
						driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[1]/span")).getText()).matches();
				// verify the type of the transaction for each record
				boolean typeresult = (driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span")).getText().contains("In")
						|| driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span")).getText().contains("Out"));
				// Verify the view button for each record
				boolean viewButtonresult = driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[5]/eb-button/button")).getText().equalsIgnoreCase("View");
				if (result && typeresult && viewButtonresult) 
				{
					continue;
				} else {
					Reporter.reportTestFailure(

							browser,

							"Records are not showing in proper format", "Fail");
					AbstractTest.takeSnapShot();
					break;
				}
			}
			
		
		}
	}
	
	// TC799 : Verify the create button functionality on Transfer Page.
	@Test()
	public void transferBundle_US529_TC799() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		// ** Variable Section : **//*
		AbstractTest.tcName="transferBundle_US529_TC799";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String transferTypeOut = GlobalVariable.transferTypeOut;
		String transferTypeIn = GlobalVariable.transferTypeIn;
		String transferTypeOffice = GlobalVariable.transferTypeOffice;
		String transferInStoreNumber = GlobalVariable.nationalStore1;
		String transferOutStoreNumber = GlobalVariable.nationalStore2;
		String samplewRINID1 = GlobalVariable.addTransferItemWrin;
		String samplewRINID2 = GlobalVariable.addTransferItemWrin1;
		String samplewRINID3 = GlobalVariable.addTransferItemWrin2;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.createDate;
		/*String time=GlobalVariable.time;*/

		// ***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
//		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date);
		Thread.sleep(2000);
		transferLandingPage.selectTimeInAddNewTransferForm(time);*/
		transferLandingPage.selectTransferType(transferTypeIn).selectLocationToTransfer(transferInStoreNumber)
						.insertAndAddDetailsToTransfer(samplewRINID1, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Confirmation_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation pop up while submitting a transfer In detail",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser, 
					"User should be able to view confirmation pop up while submitting a transfer In detail",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.SubmitTransferConfirmationPopUp_No_BT.click();
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		boolean transferAddedMsgDisplayed = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		System.out.println("transferAddedMsgDisplayed"+transferAddedMsgDisplayed);
		Thread.sleep(3000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed && transferLandingPage.verifyTransferPlaced(date,transferTypeIn,transferInStoreNumber, amount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to save the transfer In details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser, 
					"User should be able to save the transfer In details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		/***********Transfer Out ********/
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
//		time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
/*		transferLandingPage.selectDateInAddNewTransferPopUp(date);
		Thread.sleep(2000);
		transferLandingPage.selectTimeInAddNewTransferForm(time);*/
		transferLandingPage.selectTransferType(transferTypeOut).selectLocationToTransfer(transferOutStoreNumber)
						.insertAndAddDetailsToTransfer(samplewRINID2, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Confirmation_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation pop up while submitting a transfer Out detail",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,

					"User should be able to view confirmation pop up while submitting a transfer Out detail",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.SubmitTransferConfirmationPopUp_No_BT.click();
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		boolean transferAddedMsgDisplayed1 = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		System.out.println("transferAddedMsgDisplayed1"+transferAddedMsgDisplayed1);
		Thread.sleep(3000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed1 && transferLandingPage.verifyTransferPlaced(date,transferTypeOut,transferOutStoreNumber, amount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to save the transfer Out details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"User should be able to save the transfer Out details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		/***********Transfer Office ********/
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		// Get the time of transfer
//		time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(date);
		Thread.sleep(2000);
		transferLandingPage.selectTimeInAddNewTransferForm(time);*/
		transferLandingPage.selectTransferType(transferTypeOffice).insertAndAddDetailsToTransfer(samplewRINID3, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		if (Base.isElementDisplayed(transferLandingPage.AddNewTransfer_Confirmation_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view confirmation pop up while submitting a transfer Office detail",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"User should be able to view confirmation pop up while submitting a transfer Office detail",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		transferLandingPage.SubmitTransferConfirmationPopUp_No_BT.click();
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		boolean transferAddedMsgDisplayed2 = Base.isElementDisplayed(transferLandingPage.TransferAdded_Messag);
		System.out.println("transferAddedMsgDisplayed2"+transferAddedMsgDisplayed2);
		Thread.sleep(3000);
		transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
		//Verify that transfer entries should displayed in Transfer landing page
		if (transferAddedMsgDisplayed2 && transferLandingPage.verifyTransferPlaced(date,transferTypeOffice,"Office",amount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to save the transfer office details with a confirmation message and popup screen should get closed.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"User should be able to save the transfer office details with a confirmation message and popup screen should get closed.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}

	}
	
	// TC876 : Verify that existing transfer should be available to user on
	// Transfer landing Page as per the date selection.
	@Test()
	public void transferBundle_US529_TC876() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		// ** Variable Section : **//*
		AbstractTest.tcName="transferBundle_US529_TC876";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		// ***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		// Fetch the today date
		String todaydate = Base.returnTodayDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//Verify user is not able to select more than current date for end date
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, -1);
		String yesterdayDate = dateFormat.format(cal1.getTime());
		System.out.println("yesterdayDate "+yesterdayDate);
		// Fetch the start date
		transferLandingPage.selectStartDate(yesterdayDate);
		transferLandingPage.selectEndDate(todaydate);
		// click on Show Result button
		transferLandingPage.ShowResults_BT.click();
		Thread.sleep(4000);
		if (transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(yesterdayDate, todaydate)
				& transferLandingPage.verifyRecordsAreDisplayedInCorrectFormat()) {
			Reporter.reportPassResult(
					browser,
					"Transfer records for date range Current Date -1 and Current Date are displayed",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"Transfer records for date range Current Date -1 and Current Date are displayed",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		//Verify user is not able to select more than current date for end date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -5);
		String dayBeforeYesterdayDate = dateFormat.format(cal2.getTime());
		System.out.println("dayBeforeYesterdayDate " + dayBeforeYesterdayDate);
		// Fetch the start date
		transferLandingPage.selectStartDate(dayBeforeYesterdayDate);
		transferLandingPage.selectEndDate(todaydate);
		// click on Show Result button
		transferLandingPage.ShowResults_BT.click();
		Thread.sleep(4000);
		if (transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(dayBeforeYesterdayDate,todaydate)
				& transferLandingPage.verifyRecordsAreDisplayedInCorrectFormat()) {
			Reporter.reportPassResult(
					browser,
					"Transfer records for date range Current Date -2 and Current Date are displayed",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"Transfer records for date range Current Date -2 and Current Date are displayed",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		// Fetch the start date
		transferLandingPage.selectStartDate(dayBeforeYesterdayDate);
		transferLandingPage.selectEndDate(yesterdayDate);
		// click on Show Result button
		transferLandingPage.ShowResults_BT.click();
		Thread.sleep(4000);
		if (transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(dayBeforeYesterdayDate, yesterdayDate)
				& transferLandingPage.verifyRecordsAreDisplayedInCorrectFormat()) {
			Reporter.reportPassResult(
					browser,
					"Transfer records for date range Current Date -2 and Current Date-1 are displayed",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(

					browser,

					"Transfer records for date range Current Date -2 and Current Date-1 are displayed",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}

	}
		
	//TC877 Verify the records displayed on Transfer Page are sort-able
		@Test()
		public void transferBundle_US529_TC877() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException, ParseException 
		{
					/** Variable Section : **/
			AbstractTest.tcName="transferBundle_US529_TC877";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Transfer Landing page and click on create new transfer button
			TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).goToTransferLandingPage();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
			transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
			Thread.sleep(5000);
			transferLandingPage.TransferAmount_Header.click();
			Thread.sleep(2000);
			boolean amountInAscendingOrder = transferLandingPage.verifyAmountIsInAscendingOrder();
			transferLandingPage.TransferAmount_Header.click();
			Thread.sleep(2000);
			boolean amountInDescendingOrder = transferLandingPage.verifyAmountIsInDescendingOrder();
			if (amountInAscendingOrder & amountInDescendingOrder ) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view TransferAmount in ascending/Descending order",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view TransferAmount in ascending/Descending order",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			transferLandingPage.TransferTime_Header.click();
			Thread.sleep(2000);
			boolean timeAscendingOrder = transferLandingPage.verifyDateIsInAscendingOrder();
			transferLandingPage.TransferTime_Header.click();
			Thread.sleep(2000);
			boolean timeInDescendingOrder = transferLandingPage.verifyDateIsInDescendingOrder();
			if (timeAscendingOrder & timeInDescendingOrder ) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view Transfer date in ascending/Descending order",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view Transfer date in ascending/Descending order",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			transferLandingPage.TransferType_Header.click();
			Thread.sleep(2000);
			boolean typeAscendingOrder = transferLandingPage.verifyTypeIsInAscendingOrder();
			transferLandingPage.TransferType_Header.click();
			Thread.sleep(2000);
			boolean typeInDescendingOrder = transferLandingPage.verifyTypeIsInDescendingOrder();
			if (typeAscendingOrder & typeInDescendingOrder ) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view Transfer type in ascending/Descending order",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view Transfer type in ascending/Descending order",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			transferLandingPage.TransferLocation_Header.click();
			Thread.sleep(2000);
			System.out.println("Class "+transferLandingPage.TransferLocation_Header.getAttribute("class"));
			boolean locationInAscendinOrder = transferLandingPage.TransferLocation_Header.getAttribute("class").contains("sorting_asc");
			transferLandingPage.TransferLocation_Header.click();
			Thread.sleep(2000);
			System.out.println("Class "+transferLandingPage.TransferLocation_Header.getAttribute("class"));
			boolean locationInDecendinOrder = transferLandingPage.TransferLocation_Header.getAttribute("class").contains("sorting_desc");
			System.out.println("descriptionInAscendinOrder  "+locationInAscendinOrder);
			System.out.println("descriptionInDecendinOrder  "+locationInDecendinOrder );
			if (locationInAscendinOrder & locationInDecendinOrder) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view Transfer location in ascending/Descending order",
						"Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view Transfer location in ascending/Descending order",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		//TC3192 Verify the View button functionality on Transfer Page.
			@Test(enabled=false)
			public void transferBundle_US529_TC3192() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException, ParseException 
			{	
				/**Variable Section :**/
				AbstractTest.tcName="transferBundle_US529_TC3192";
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.userId;
				String password = LoginTestData.password;
				String storeId = LoginTestData.StoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = GlobalVariable.nationalStore1;
				String caseQuantity = "5";
				String innerPackQuantity ="7";
				String looseUnitQuantity ="5";
				String date = GlobalVariable.createDate;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				//Navigate to Transfer Landing page and click on create new transfer button
				TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
						.goToTransferLandingPage();
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
				//Get the time of transfer
			/*	String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
				//Select the transfer type as "in" and select the store from drop down an add the transfer details
				transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber).selectDateInAddNewTransferPopUp(date)
						.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				Thread.sleep(2000);
				
				//Get the total transfer amount
				String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
				System.out.println("Amount1 is"+amount1);
				//Submit the transfer
				transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
				//click on the yes button for confirmation
				wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
				transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
				Thread.sleep(5000);
				transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
				Thread.sleep(4000);
				transferLandingPage.viewTransfer(date,amount1);
				Thread.sleep(8100);
				
				//Verify that correct deytail is shwoing on transfer detail page
				
				//Verify that transfer entries should displayed in Transfer landing page
				if (transferLandingPage.TransferDetail_NationalStoreNumber_TB.getAttribute("value").equalsIgnoreCase(transferStoreNumber) &&
				transferLandingPage.TransferDetail_TypeOfTransfer_TB.getAttribute("value").equalsIgnoreCase("Out") &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[8]/span)[1]")).getText().equalsIgnoreCase(amount1) &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[2]/span)[1]")).getText().contains(samplewRINID)) {
					Reporter.reportPassResult(
							browser,
							"All the details is shwoing on Transfer detail page",
							"Pass");
					
				} else {
					Reporter.reportTestFailure(

							browser,

							"All the details is shwoing on Transfer detail page",
							"Fail");
					AbstractTest.takeSnapShot();
					
				}
						
			}
		
			//TC3308 Verify the View button functionality on Transfer Page..
			
			@Test(enabled=false)
			public void transferBundle_US529_TC3308() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException, ParseException 
			{	/**Variable Section :**/
				AbstractTest.tcName="transferBundle_US529_TC3308";
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.userId;
				String password = LoginTestData.password;
				String storeId = LoginTestData.StoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = GlobalVariable.nationalStore1;
				String caseQuantity = "6";
				String innerPackQuantity ="3";
				String looseUnitQuantity ="5";
				String date = GlobalVariable.createDate;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				//Navigate to Transfer Landing page and click on create new transfer button
				TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
						.goToTransferLandingPage();
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
				Thread.sleep(10000);
				wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
				//Get the time of transfer
				String time1=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
				//Select the transfer type as "in" and select the store from drop down an add the transfer details
				transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber).selectDateInAddNewTransferPopUp(date)
						.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				Thread.sleep(2000);
				
				//Get the total transfer amount
				String amount1 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
				System.out.println("Amount1 is"+amount1);
				//Submit the transfer
				transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
				//click on the yes button for confirmation
				wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
				transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
				Thread.sleep(5000);
				transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
				Thread.sleep(4000);
				transferLandingPage.viewTransfer(date,amount1);
				Thread.sleep(8100);
				
				//Verify that correct detail is showing on transfer detail page
				
				//Verify that transfer entries should displayed in Transfer landing page
				if (transferLandingPage.TransferDetail_NationalStoreNumber_TB.getAttribute("value").equalsIgnoreCase(transferStoreNumber) &&
				transferLandingPage.TransferDetail_TypeOfTransfer_TB.getAttribute("value").equalsIgnoreCase("Out") &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[7]/span)[1]")).getText().equalsIgnoreCase(amount1) &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[1]/span)[1]")).getText().contains(samplewRINID))
				{
 
					Reporter.reportPassResult(
							browser,
							"All the details is shwoing on Transfer detail page",
							"Pass");
					
				} else {
					Reporter.reportTestFailure(

							browser,

							"All the details is shwoing on Transfer detail page",
							"Fail");
					AbstractTest.takeSnapShot();
					
				}
				
						
						
			}
		
	
	
	
	
}
