package transferBundle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class US529_TransferLandingPage extends AbstractTest {
	// TC798 : Verify the UI of the transfer page..
	@Test()
	public void transferBundle_US529_TC798() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String datepattern = ("(\\d{1,2})(/)(\\d{1,2})(/)(\\d{1,4})");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
		// Verify the UI of the screen
		if (Base.isElementDisplayed(transferLandingPage.TransferLandingPage_Label)
				&& Base.isElementDisplayed(transferLandingPage.CreateNewTransfers_BT)
				&& Base.isElementDisplayed(transferLandingPage.StartDate_TB)
				&& Base.isElementDisplayed(transferLandingPage.EndDate_TB)
				&& Base.isElementDisplayed(transferLandingPage.TransferTime_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferType_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferAmount_Header)
				&& Base.isElementDisplayed(transferLandingPage.TransferLocation_Header)
		) {
			Reporter.reportPassResult(
					browser, "transferBundle_US529_TC798",
					"All the labels and the button are shwoing properly","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "transferBundle_US529_TC798","transferBundle_US529_TC798",
					"All the labels and the button are shwoing properly",
					"Fail");
			AbstractTest.takeSnapShot("transferBundle_US529_TC798");
		}
		for (int i = 1; i <= driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr")).size(); i++) {
			// Verify the date and time format for each records
			boolean result = Pattern.compile(datepattern).matcher(
							driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr["+ i + "]/td[1]/span")).getText()).matches();
			// verify the type of the transaction for each record
			boolean typeresult = (driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span")).getText().contains("In")
					|| driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[2]/span")).getText().contains("Out"));
			// Verify the view button for each record
			boolean viewButtonresult = driver.findElement(By.xpath("//table[@id='transfercounts']/tbody/tr/td[5]/eb-button/button")).getText().equalsIgnoreCase("View");
			if (result && typeresult && viewButtonresult) {
				continue;
			} else {
				Reporter.reportTestFailure(
						browser,"transferBundle_US529_TC798","transferBundle_US529_TC798",
						"Records are not showing in proper format", "Fail");
				AbstractTest.takeSnapShot("transferBundle_US529_TC798");
				break;
			}
		}
	}
	
	/*	//TC799 : Verify the create button functionality on Transfer Page.(Not completed)
				@Test()
				public void transferBundle_US529_TC799() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					*//** Variable Section : **//*
					String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
					String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
					String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			
					*//***********************************//*
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					//Navigate to Transfer Landing page and click on create new transfer button
					TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
							.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
					
				}*/
			
	
/*	//TC876 : Verify that existing transfer should be available to user on Transfer landing Page as per the date selection.
		@Test()
		public void transferBundle_US529_TC876() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException, ParseException 
		{
					*//** Variable Section : **//*
					String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
					String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
					String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
					String userId = LoginTestData.operatorUserId;
					String storeId = LoginTestData.operatorStoreId;
					*//***********************************//*
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					//Navigate to Transfer Landing page and click on create new transfer button
					TransferLandingPage transferLandingPage = homePage.selectUser(userId).selectLocation(storeId)
							.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
					//Fetch the today date 
					String tdate=Base.returnTodayDate();
					String date=Base.returnTodayDate();
					date=date.replace(((date.split("/"))[0]), ("0"+Integer.toString((Integer.parseInt((Integer.toString(Base.getMonthFromDate(date))))))));
					//Fetch the start date
					transferLandingPage.selectStartDate(date);
					//click on Show Result button
					transferLandingPage.ShowResults_BT.click();
					Thread.sleep(4000);
					System.out.println("d is"+date);
					System.out.println("td"+tdate);
					if(transferLandingPage.verifyTransferHistoryDisplayedForSelectedDateRange(date, tdate))
						{
							Reporter.reportPassResult(
									browser,"transferBundle_US529_TC876",
									"Only the records of specified date range is showing",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,"transferBundle_US529_TC876","transferBundle_US529_TC876",
									"Only the records of specified date range is showing",
									"Fail");
							AbstractTest.takeSnapShot("transferBundle_US529_TC876");
						}
					
		}*/
		
	//TC877 Verify the records displayed on Transfer Page are sort-able.(Not completed)
	
		@Test()
		public void transferBundle_US529_TC877() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException, ParseException 
		{
					/** Variable Section : **/
				/*	String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
					String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
					String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;*/
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.operator_SSO_UserId;
					String password = LoginTestData.operator_SSO_UserId;
					String storeId = LoginTestData.operatorStoreId;
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					//Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.selectLocation(storeId).navigateToInventoryManagement().goToTransferLandingPage();
					Thread.sleep(8000);				
					List<WebElement> we= driver.findElements(By.xpath("//table[@id='transfercounts']/tbody/tr/td[1]/span"));
					LinkedList<Date> recordDate=new LinkedList<Date>();
					ArrayList<Integer> result = new ArrayList<Integer>();
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					for(int i=0;i<=we.size()-1;i++)
					{
						System.out.println(we.get(i).getText());
						String date=we.get(i).getText();
						recordDate.add(df.parse(date));
						if(i==0)
						{
							//Do Nothing
						}
						else
						{
							 result.add(recordDate.get(i).compareTo(recordDate.get(i-1)));
							 System.out.println("Result is"+result.get(i-1));
							 if(result.get(i-1)==0 || result.get(i-1)==1)
							 {
								 if(i==we.size()-1)
								 {
										Reporter.reportPassResult(
												browser,"transferBundle_US529_TC877",
												"Record should display as sorted",
												"Pass");
								 }
								 else
								 {
								 continue;
								 }
							 }
							 else
							 {
									Reporter.reportTestFailure(
											browser,"transferBundle_US529_TC877","transferBundle_US529_TC877",
											"Record should display as sorted",
											"Fail");
									AbstractTest.takeSnapShot("transferBundle_US529_TC877");
							 }
						}
					}
					
		}
	
	
		//TC3192 Verify the View button functionality on Transfer Page.
		
			@Test()
			public void transferBundle_US529_TC3192() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException, ParseException 
			{	
				/**Variable Section :**/
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.operator_SSO_UserId;
				String password = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = "55";
				String caseQuantity = "3";
				String innerPackQuantity ="2";
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
				System.out.println("Amount1 is"+amount1);
				//Submit the transfer
				transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
				//click on the yes button for confirmation
				wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
				transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
				Thread.sleep(5000);
				transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
				Thread.sleep(4000);
				transferLandingPage.viewTransfer(date, time1, amount1);
				Thread.sleep(8100);
				
				//Verify that correct deytail is shwoing on transfer detail page
				
				//Verify that transfer entries should displayed in Transfer landing page
				if (transferLandingPage.TransferDetail_NationalStoreNumber_TB.getAttribute("value").equalsIgnoreCase(transferStoreNumber) &&
				transferLandingPage.TransferDetail_TypeOfTransfer_TB.getAttribute("value").equalsIgnoreCase("Out") &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[7]/span)[1]")).getText().equalsIgnoreCase(amount1) &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[1]/span)[1]")).getText().contains(samplewRINID)) {
					Reporter.reportPassResult(
							browser,"transferBundle_US529_TC3192",
							"All the details is shwoing on Transfer detail page",
							"Pass");
				} else {
					Reporter.reportTestFailure(
							browser,"transferBundle_US529_TC3192","transferBundle_US529_TC3192",
							"All the details is shwoing on Transfer detail page",
							"Fail");
					AbstractTest.takeSnapShot("transferBundle_US529_TC3192");
				}
				
						
						
			}
		
			//TC3308 Verify the View button functionality on Transfer Page..
			
			@Test()
			public void transferBundle_US529_TC3308() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException, ParseException 
			{	/**Variable Section :**/
//				String userId = LoginTestData.operatorUserId;
				String userId = LoginTestData.operator_SSO_UserId;
				String password = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String samplewRINID = GlobalVariable.addTransferItemWrin;
				String transferType2 = GlobalVariable.transferTypeOut;
				String transferStoreNumber = "55";
				String caseQuantity = "3";
				String innerPackQuantity ="2";
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
				System.out.println("Amount1 is"+amount1);
				//Submit the transfer
				transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
				//click on the yes button for confirmation
				wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
				transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
				Thread.sleep(5000);
				transferLandingPage.selectStartDate(GlobalVariable.startDate).selectEndDate(GlobalVariable.endDate).ShowResults_BT.click();
				Thread.sleep(4000);
				transferLandingPage.viewTransfer(date, time1, amount1);
				Thread.sleep(8100);
				
				//Verify that correct detail is showing on transfer detail page
				
				//Verify that transfer entries should displayed in Transfer landing page
				if (transferLandingPage.TransferDetail_NationalStoreNumber_TB.getAttribute("value").equalsIgnoreCase(transferStoreNumber) &&
				transferLandingPage.TransferDetail_TypeOfTransfer_TB.getAttribute("value").equalsIgnoreCase("Out") &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[7]/span)[1]")).getText().equalsIgnoreCase(amount1) &&
				driver.findElement(By.xpath("(//table[@id='transfer_modal_tbl']/tbody/tr[1]/td[1]/span)[1]")).getText().contains(samplewRINID))
				{
 
					Reporter.reportPassResult(
							browser,"transferBundle_US529_TC3308",
							"All the details is shwoing on Transfer detail page",
							"Pass");
				} else {
					Reporter.reportTestFailure(
							browser,"transferBundle_US529_TC3308","transferBundle_US529_TC3308",
							"All the details is shwoing on Transfer detail page",
							"Fail");
					AbstractTest.takeSnapShot("transferBundle_US529_TC3308");
				}
				
						
						
			}
		
	
	
	
	
}
