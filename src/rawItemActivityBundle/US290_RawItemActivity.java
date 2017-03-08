package rawItemActivityBundle;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.TransferLandingPage;

public class US290_RawItemActivity extends AbstractTest
{	
	//TC859 : Verify user is able to navigate to "Raw Item Activity" page.
	@Test()
	public void rawItemActivityBundle_US290_TC859() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US290_TC859";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		if(rawitemactivitypage.RawItemActivity_Title.isDisplayed())
		{
			Reporter.reportPassResult(
					browser,
					"User is navigated to raw item Activity page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User is navigated to raw item Activity page",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}	
	//TC861 : Verify that user is able to search and select one raw item.
	@Test()
	public void rawItemActivityBundle_US290_TC861() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US290_TC861";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;			
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText());
		if(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText().contains(samplewRINID))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select a raw item",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select a raw item",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
	
	//TC862 : Verify user is able to  select a date range after selecting a WRIN ID on "Raw Item Activity" page.
		@Test()
		public void rawItemActivityBundle_US290_TC862() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US290_TC862";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;			
			String todayDate=Base.returnTodayDate();
			/*******************************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
			//Fetch the start date
			Thread.sleep(4000);
			String startDate=rawitemactivitypage.StartDate_TB.getAttribute("value");
			String endDate=rawitemactivitypage.EndDate_TB.getAttribute("value");
			System.out.println("StartDate"+startDate+"EndDate"+endDate);
			String[] date=todayDate.split("/");
			String expectedStratSDate=date[0]+"/"+"01/"+date[2];
	
			if(startDate.equalsIgnoreCase(expectedStratSDate) && endDate.equalsIgnoreCase(todayDate))
			{
				Reporter.reportPassResult(
						browser,
						"Correct Start and date should display",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct Start and date should display",
						"Fail");
				AbstractTest.takeSnapShot();
			}

		}
		
	//TC2235 : Verify the presence of  event POS open on raw item activity page.
		
		@Test()
		public void rawItemActivityBundle_US290_TC2235() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US290_TC2235";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;			
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String date=GlobalVariable.createDate;
			String eventCountValue;
			/*******************************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
			//select start and End Date 
			rawitemactivitypage.selectStartDate(date);
			rawitemactivitypage.selectEndDate(date);
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'POS OPEN')]")).size()==0)
			{
				Reporter.reportTestFailure(
						browser,
						"No entry of POS open is present",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			else
			{
				List <WebElement> element=driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[3][preceding-sibling::td/span[contains(.,'POS OPEN')]]/span/strong"));
				for(int i=0;i<element.size();i++)
				{
					 eventCountValue=element.get(i).getAttribute("innerHTML");
					 Thread.sleep(2000);
					 System.out.println("eventCountValue for"+i+"th is"+eventCountValue);
					 if(eventCountValue.equalsIgnoreCase("--") && i==element.size()-1)
					 {
						 Reporter.reportPassResult(
									browser,
									"No value should present for the even count field",
									"Pass");
						 break;
					 }
					 else if(eventCountValue.equalsIgnoreCase("--"))
					 {
						 continue;
					 }
					 else
					 {
						 Reporter.reportTestFailure(
									browser,
									"No value should present for the even count field",
									"Fail");
							AbstractTest.takeSnapShot();
							break;
					 }
					
				}
				
			}
		
		}	
		
		
	//TC4041 : Verify a method to access raw item information page.
		@Test()
		public void rawItemActivityBundle_US290_TC4041() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US290_TC4041";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;			
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			rawitemactivitypage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_Title))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to access Raw Item Information Page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to access Raw Item Information Page",
						"Fail");
				AbstractTest.takeSnapShot();
			}

		}
		
		//TC1142 : Validate "Transfer Out" on "Raw Item Activity" page.
		@Test()
		public void rawItemActivityBundle_US290_TC1142() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US290_TC1142";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;			
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
			String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String date = GlobalVariable.createDate;
			String expCount;
			String totalAmount = null;
			RawItemActivityPage rawItemActivityPage;
			String transferType = GlobalVariable.transferTypeOut;
			String transferStoreNumber = GlobalVariable.nationalStore1;
			/* End-Variable Deceleration */
			// create instances for home page and transfer landing page
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToRawItemActivityPage();
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
			int noOfTransferActivities = rawItemActivityPage.getNoumberOfTransferOutActivities(date);
			System.out.println("No of activities "+noOfTransferActivities);
			TransferLandingPage transferLandingPage=homePage.goToTransferLandingPage();
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)),"CreateNewTransfers_BT");
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			transferLandingPage.removeAllWrinIdFromTransferPage();
			//Select the transfer type as "in" and select the store from dropdown an add the transfer details
			System.out.println("Type is"+transferType);
			/*transferLandingPage.selectDateInAddNewTransferPopUp(date);
			Thread.sleep(1500);
			transferLandingPage.selectTimeInAddNewTransferForm(time);*/
			transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
					.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
			Thread.sleep(2000);
			//Get the total transfer amount
			expCount = transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().split(" ")[0];
			System.out.println("Expected Count" + "-" + expCount);
			// Fetch the sub total Value
			totalAmount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
			System.out.println("total amunt" + totalAmount);
			//Submit the transfer
			GenericMethods.clickOnElement(transferLandingPage.AddTransferItemsPopup_Submit_BT,"AddTransferItemsPopup_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)),"SubmitTransferConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
			rawItemActivityPage = homePage.goToRawItemActivityPage();
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
//			rawItemActivityPage.clickOnDateGroup(date);
			System.out.println("No of activities2 "+rawItemActivityPage.getNoumberOfTransferOutActivities(date));
			System.out.println("No of activities2 "+rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount));
			if(rawItemActivityPage.getNoumberOfTransferOutActivities(date) == noOfTransferActivities +1
					& rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(date,expCount)){
				Reporter.reportPassResult(
						browser,
						"User should be able to find a  transfer out event of date D and deducted count value should be visible.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to find a  transfer out event of date D and deducted count value should be visible.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
		
		//TC1154 : Validate "Transfer In" on "Raw Item Activity" page.
		@Test()
		public void rawItemActivityBundle_US290_TC1154() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US290_TC1154";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;			
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
			String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String date = GlobalVariable.createDate;
		
			String expCount;
			String totalAmount = null;
			RawItemActivityPage rawItemActivityPage;
			String transferType = GlobalVariable.transferTypeIn;
			String transferStoreNumber = GlobalVariable.nationalStore1;
			/* End-Variable Deceleration */
			// create instances for home page and transfer landing page
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToRawItemActivityPage();
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
			int noOfTransferActivities = rawItemActivityPage.getNoumberOfTransferInActivities(date);
			System.out.println("No of activities "+noOfTransferActivities);
			TransferLandingPage transferLandingPage=homePage.goToTransferLandingPage();
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)),"CreateNewTransfers_BT");
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			transferLandingPage.removeAllWrinIdFromTransferPage();
			//Select the transfer type as "in" and select the store from dropdown an add the transfer details
			System.out.println("Type is"+transferType);
		/*	transferLandingPage.selectDateInAddNewTransferPopUp(date);
			Thread.sleep(1500);
			transferLandingPage.selectTimeInAddNewTransferForm(time);*/
			transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
					.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
			Thread.sleep(2000);
			//Get the total transfer amount
			expCount = transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().split(" ")[0];
			System.out.println("Expected Count" + "-" + expCount);
			// Fetch the sub total Value
			totalAmount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
			System.out.println("total amunt" + totalAmount);
			//Submit the transfer
			GenericMethods.clickOnElement(transferLandingPage.AddTransferItemsPopup_Submit_BT,"AddTransferItemsPopup_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)),"SubmitTransferConfirmationPopUp_Yes_BT");
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
			rawItemActivityPage = homePage.goToRawItemActivityPage();
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
			System.out.println("No of activities2 "+rawItemActivityPage.getNoumberOfTransferInActivities(date));
			System.out.println("No of activities2 "+rawItemActivityPage.verifyTransferInEventCountMatchedForSelectedDate(date,expCount));
			if(rawItemActivityPage.getNoumberOfTransferInActivities(date) == noOfTransferActivities +1
					&& rawItemActivityPage.verifyTransferInEventCountMatchedForSelectedDate(date,expCount)){
				Reporter.reportPassResult(
						browser,
						"User should be able to find a  transfer In event of date D and deducted count value should be visible.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to find a  transfer In event of date D and deducted count value should be visible.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
		
}
