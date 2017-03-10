package rawItemActivityBundle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.TransferLandingPage;

public class US858_UIUXRetrofitRawItemActivityInfo extends AbstractTest
{
	
	//TC3729 : 	Verify Raw Item Information & Activity Page is accessible from the Main Menu.
	
	@Test(groups="Smoke")
	public void rawItemActivityBundle_US858_TC3729() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US858_TC3729";
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
	
	//TC3730 : Verify the UI of Raw Item Information & Activity page.	
	@Test()
	public void rawItemActivityBundle_US858_TC3730() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US858_TC3730";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;		
		String todayDate=Base.returnTodayDate();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		String startDate=rawitemactivitypage.StartDate_TB.getAttribute("value");
		String endDate=rawitemactivitypage.EndDate_TB.getAttribute("value");
		System.out.println("StartDate"+startDate+"EndDate"+endDate);
		String[] date=todayDate.split("/");
		String expectedStratSDate=date[0]+"/"+"01/"+date[2];
		System.out.println("Exp start date "+expectedStratSDate);
		/*Verify that following fields are displaying on Raw item Activity page
		1. Header <Raw Item Information & Activity>
		2. Label <Item> with Search text field.
		3. Start Date { field with calendar widget}- Default to Current Date
		4. End Date {field with calendar widget}- Default to Current Date
		5. Arrow sign with label <Current Day Activity> at the end of the screen.*/
		
		if(rawitemactivitypage.RawItemActivity_Title.isDisplayed() &&
				rawitemactivitypage.Item_Label.isDisplayed() &&
				rawitemactivitypage.Search_TB.isDisplayed() &&
				rawitemactivitypage.StartDate_TB.isDisplayed() &&
				rawitemactivitypage.EndDate_TB.isDisplayed() &&
				startDate.equalsIgnoreCase(expectedStratSDate) && 
				endDate.equalsIgnoreCase(todayDate) &&
				Base.isElementDisplayed(By.xpath("//h2[text()='Current Day Activity']"))
				)
		{
			Reporter.reportPassResult(
					browser,
					"All the required fields should display properly",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the required fields should display properly",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}	
	
	
	//TC3731 : Verify,"The Main Menu can be opened and closed from the Raw Item Activity/Info Page".
	@Test()
	public void rawItemActivityBundle_US858_TC3731() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US858_TC3731";
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
		GenericMethods.clickOnElement(homePage.Menu_DD_BT,"Menu_DD_BT");
		wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT));
		Thread.sleep(1000);
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemActivityTable_CreatedByHeader,"RawItemActivityTable_CreatedByHeader");
		Thread.sleep(2000);
		if (!Base.isElementDisplayed(homePage.RawItemActivity_BT)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to close the menu", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to close the menu", "Fail");
			AbstractTest.takeSnapShot();
		}
	}	
		
	//TC3732 : Verify search text field on Raw Item Information & Activity page.	
	@Test()
	public void rawItemActivityBundle_US858_TC3732() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US858_TC3732";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		try
		{
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the WRIN",
					"Pass");
		} catch (Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the WRIN",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}	
	
	//TC3733 : Verify Start and End Date calendar widget.
		@Test()
		public void rawItemActivityBundle_US858_TC3733() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3733";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			//String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String todayDate=Base.returnTodayDate();
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			//Verify user is not able to select more than current date for end date
			Calendar cal1 = Calendar.getInstance();
			cal1.add(Calendar.DATE, 1);
			String tomorrowDate = dateFormat.format(cal1.getTime());
			System.out.println("tomorrowDate "+tomorrowDate);
			GenericMethods.clickOnElement(rawitemactivitypage.StartDate_TB,"StartDate_TB");
			Thread.sleep(1000);
			if (rawitemactivitypage.verifyStartDateIsDisabled(tomorrowDate) 
					&& !rawitemactivitypage.verifyStartDateIsDisabled(Base.returnTodayDate())) {
				Reporter.reportPassResult(
						browser,
						"System should not allow user to select date more than the current date.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should not allow user to select date more than the current date.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			GenericMethods.clickOnElement(rawitemactivitypage.StartDate_TB,"StartDate_TB");
			Thread.sleep(1000);
			rawitemactivitypage.selectStartDate(todayDate);
			if (rawitemactivitypage.StartDate_TB.getAttribute("value").equals(todayDate)) {
				Reporter.reportPassResult(
						browser,
						"System should  allow user to select current date as start date",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should  allow user to select current date as start date",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Calendar cal2 = Calendar.getInstance();
			cal2.add(Calendar.DATE, -1);
			String yesterdayDate = dateFormat.format(cal2.getTime());
			System.out.println("yesterdayDate "+yesterdayDate);
			GenericMethods.clickOnElement(rawitemactivitypage.EndDate_TB,"EndDate_TB");
			Thread.sleep(1000);
			System.out.println("First "+rawitemactivitypage.verifyEndDateIsDisabled(tomorrowDate));
			System.out.println("Second "+rawitemactivitypage.verifyEndDateIsDisabled(yesterdayDate));
			System.out.println("third "+rawitemactivitypage.verifyEndDateIsDisabled(Base.returnTodayDate()));
			if (rawitemactivitypage.verifyEndDateIsDisabled(tomorrowDate)
					&& rawitemactivitypage.verifyEndDateIsDisabled(yesterdayDate)
					&& !rawitemactivitypage.verifyEndDateIsDisabled(Base.returnTodayDate())) {
				Reporter.reportPassResult(
						browser,
						"Only current date should be allowed for selection for end date. Past and future date should be disabled.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Only current date should be allowed for selection for end date. Past and future date should be disabled.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
//			GenericMethods.clickOnElement(rawitemactivitypage.EndDate_TB,"EndDate_TB");
//			Thread.sleep(1000);
			rawitemactivitypage.selectEndDate(todayDate);
			if (rawitemactivitypage.EndDate_TB.getAttribute("value").equals(todayDate)) {
				Reporter.reportPassResult(
						browser,
						"System should  allow user to select current date as end date",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should  allow user to select current date as end date",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Calendar cal3 = Calendar.getInstance();
			cal3.add(Calendar.DATE, -5);
			String fiveDaysPastDate = dateFormat.format(cal3.getTime());
			System.out.println("fiveDaysPastDate "+fiveDaysPastDate);
			rawitemactivitypage.selectStartDate(fiveDaysPastDate);
			if (rawitemactivitypage.StartDate_TB.getAttribute("value").equals(fiveDaysPastDate)) {
				Reporter.reportPassResult(
						browser,
						"System should allow user to select past date as start date",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should allow user to select past date as start date",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Calendar cal4 = Calendar.getInstance();
			cal4.add(Calendar.DATE, -6);
			String sixDaysPastDate = dateFormat.format(cal4.getTime());
			System.out.println("sixDaysPastDate "+sixDaysPastDate);
			GenericMethods.clickOnElement(rawitemactivitypage.EndDate_TB,"EndDate_TB");
			Thread.sleep(1000);
			if (rawitemactivitypage.verifyEndDateIsDisabled(sixDaysPastDate)) {
				Reporter.reportPassResult(
						browser,
						"System should not allow user to select less than selected in Start Date field.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should not allow user to select less than selected in Start Date field.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Calendar cal5 = Calendar.getInstance();
			cal5.add(Calendar.DATE, -3);
			String threeDaysPastDate = dateFormat.format(cal5.getTime());
			System.out.println("threeDaysPastDate "+threeDaysPastDate);
			GenericMethods.clickOnElement(rawitemactivitypage.EndDate_TB,"EndDate_TB");
			Thread.sleep(1000);
			rawitemactivitypage.selectEndDate(threeDaysPastDate);
			if (rawitemactivitypage.EndDate_TB.getAttribute("value").equals(threeDaysPastDate)) {
				Reporter.reportPassResult(
						browser,
						"System should allow user to select end date as more than selected in Start Date field",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should allow user to select end date as more than selected in Start Date field",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			System.out.println("End date"+rawitemactivitypage.EndDate_TB.getAttribute("value"));
			GenericMethods.clickOnElement(rawitemactivitypage.StartDate_TB,"StartDate_TB");
			Thread.sleep(1500);
			if (rawitemactivitypage.verifyStartDateIsDisabled(Base.returnTodayDate())) {
				Reporter.reportPassResult(
						browser,
						"System should not allow user to select date more than selected in End Date.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"System should not allow user to select date more than selected in End Date.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}	
		
		
		//TC3826 : Verify UI when Search functionality is performed on Raw Item Information & Activity page.
		
		@Test()
		public void rawItemActivityBundle_US858_TC3826() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3826";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			/*String todayDate=Base.returnTodayDate();*/
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			/*verify that following fields are displaying
			1. <Label> Item : <Raw Item Number> - <Raw Item Number>
			2 Information {button}- on right side
			3. Table containing following columns:
			Event Created
			Event Type
			Event Count 
			On Hand
			Variance
			$ Difference
			Created by
			f no data exists for selected date:
			"We don't have any raw item activity to show" should be displayed under the table.

			If data exists for selected date:
			Different container should be displayed on the basis of date (in which data exists). It should be collapsed.
			*/
//			rawitemactivitypage.selectStartDate("04/02/2016");
			Thread.sleep(5000);
			System.out.println(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText().contains("Item: "+samplewRINID));
			System.out.println(Base.isElementDisplayed(rawitemactivitypage.Information_BT));
			System.out.println(Base.isElementDisplayed(By.xpath("//p[text()='We don’t have any raw item activity to show.']")));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[1]")).getText().equalsIgnoreCase("Event Created"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[2]")).getText().equalsIgnoreCase("Event Type"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[2]")).getText().equalsIgnoreCase("Event Type"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[4]")).getText().equalsIgnoreCase("On Hand"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[5]")).getText().equalsIgnoreCase("Variance"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[6]")).getText().equalsIgnoreCase("$ Difference"));
			System.out.println(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[7]")).getText().equalsIgnoreCase("Created By"));
			if(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText().contains("Item: "+samplewRINID) &&
					Base.isElementDisplayed(rawitemactivitypage.Information_BT) &&
					(Base.isElementDisplayed(By.xpath("//p[text()='We don’t have any raw item activity to show.']")) ||
							(driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[1]")).getText().equalsIgnoreCase("Event Created") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[2]")).getText().equalsIgnoreCase("Event Type") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[3]")).getText().equalsIgnoreCase("Event Count") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[4]")).getText().equalsIgnoreCase("On Hand") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[5]")).getText().equalsIgnoreCase("Variance") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[6]")).getText().equalsIgnoreCase("$ Difference") &&
									driver.findElement(By.xpath("//table[@class='ridt display nowrap table accordion dataTable no-footer']/thead/tr/th[7]")).getText().equalsIgnoreCase("Created By")
									)))
			{
				Reporter.reportPassResult(
						browser,
						"All the fields are displaying as expetced",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"All the fields are displaying as expetced",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			

		}	
		
		
	//TC3828 :  Verify UI of the Raw Item Information screen.
	@Test()
	public void rawItemActivityBundle_US858_TC3827()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "rawItemActivityBundle_US858_TC3827";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createPurchaseWrin;
		String createDate = GlobalVariable.createDate;
		String value1=Integer.toString(Base.generateNdigitRandomNumber(1));
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String pricePerCase = "25.00";
		String invoiceId = Base.randomNumberFiveDigit();
		String transferType = GlobalVariable.transferTypeOffice;
		String stratDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Create and approve a manual purchase
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceId,samplewRINID, quantity, pricePerCase);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		String expectedPurchaseCount = purchasesPage.getCasesPurchasedForAWrin(samplewRINID).split(" ")[2];
/*		purchasesPage.selectDateForApproveInvoice(GlobalVariable.approveDate).selectTimeForApproveInvoice(GlobalVariable.time);
*/		purchasesPage.ApproveManualInvoice_Approve_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_ConfirmationMessage_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG));
		Thread.sleep(5000);
		// Create a Raw Promo
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		/*rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);*/
		// Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(samplewRINID);
		// rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemPromoPage.addQuantitiesForMultipleWrin(samplewRINID, "2", "2","3");
		String expectedRawPromoCount = rawItemPromoPage.RawPromoForm_TotalUnitsValue.getText().replace(",", "");
		Thread.sleep(1500);
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		// Create a Raw Waste
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(2000);
		rawItemWastePage.selectTimeInRawWasteForm(time);*/
		Thread.sleep(2000);
		// Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		// rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(samplewRINID, "2", "2","3");
		String expectedRawWasteCount = rawItemWastePage.RawWasteForm_TotalUnitsValue.getText().replace(",", "");
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		// Create a Transfer
		TransferLandingPage transferLandingPage = homePage.goToTransferLandingPage();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferLandingPage_Label));
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.removeAllWrinIdFromTransferPage();
		// Select the transfer type as "Office" and add the transfer details
		/*transferLandingPage.selectDateInAddNewTransferPopUp(createDate).selectTimeInAddNewTransferForm(GlobalVariable.time);*/
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID, "1", "2", "3");
		Thread.sleep(2000);
		// Submit the transfer
		String expTransferCount = transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().split(" ")[0];
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
		Thread.sleep(5000);
		PhysicalInventoryPage physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		
		//Create a Physical Inventory
		physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID, "", "", value1);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		String uom = wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_UOM_Value)).getText();
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
//		rawItemActivityPage.clickOnDateGroup(createDate);
		if (rawItemActivityPage.verifyInventoryOnHandCountMatchedForSelectedDate(createDate, value1+".00", uom) ) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the quantities counted=q for applicable raw items=X of the submitted physical inventory on the Raw Item Activity page for the date D selected in On Hand column",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the quantities counted=q for applicable raw items=X of the submitted physical inventory on the Raw Item Activity page for the date D selected in On Hand column",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(rawItemActivityPage.verifyTransferOutEventCountMatchedForSelectedDate(createDate,expTransferCount)){
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
		if(rawItemActivityPage.verifyRawWasteEventCountMatchedForSelectedDate(createDate, expectedRawWasteCount)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the Raw waste activity for the  wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Raw waste activity for the  wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		if(rawItemActivityPage.verifyRawPromoEventCountMatchedForSelectedDate(createDate, expectedRawPromoCount)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the Raw promo activity for the  wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Raw promo activity for the  wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		if(rawItemActivityPage.verifyPurchaseEventDisplayed(createDate, expectedPurchaseCount, invoiceId)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the Purchase activity for the  wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Purchase activity for the  wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
		
	//TC3828 : Verify UI of the Raw Item Information screen.	
		@Test()
		public void rawItemActivityBundle_US858_TC3828() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3828";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.recepieItemWithYieldValue;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			//Click on Information button
			rawitemactivitypage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			/*System should display following information on Raw Item Information screen:

				1. Table containing following column and selected Raw item Information:
				WRIN 
				Description
				Category 
				Zone
				UOM
				Inner Pack
				Case
				2. <Label> Manual Purchase along with check box and Yes <Label>
				3. List Type <DDL>
				4. McDonald GL Account <DDL>
				5. Primary Vendor <DDL>
				6. Case Price <Text Field>
				7. Current Usage/$ 1,000 <Label>--No Need to Verify
				8. Historic Usage/$ 1,000 <Label>--No Need to Verify
				9. Average Cost Per Unit <Label>
				10. Yield Range<Label>
				11. Calculated Yield <Label>
				12. Cancel and Submit button*/
			if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
			{
				rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

			}
			;
			if(GenericMethods.textCompare("WRIN", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[1]")), "First Column")) &&
					GenericMethods.textCompare("Description", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[2]")), "Second Column")) &&
					GenericMethods.textCompare("Category", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[3]")), "Third Column")) &&
					GenericMethods.textCompare("Zone", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[4]")), "Forth Column")) &&
					GenericMethods.textCompare("UOM", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[5]")), "Fifth Column")) &&
					GenericMethods.textCompare("Inner Pack", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[6]")), "Sixth Column")) &&
					GenericMethods.textCompare("Case", GenericMethods.getText(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/thead/tr/th[7]")), "Seventh Column")) &&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB, "rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Manual Purchase']"), "Manual Purchase Label") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Yes']"), "Yes Label") &&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD, "rawitemactivitypage.RawItemInformation_popUp_ListType_DD") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Frequency']"), "List Type Label")&&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD, "rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='McDonalds GL Account']"), "Mcdonalds GL Account Label")&&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD, "rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Primary Vendor']"), "Primary Vendor Label") &&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB, "rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Case Price:']"), "Cash price Label") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Average Cost per Unit']"), "Average Cost Per unil Label") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Yield Range']"), "Yield range Label") &&
					GenericMethods.isElementDisplayed(By.xpath("//span[text()='Calculated Yield']"), "Calculated Yield Label") &&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_Submit_BT, "rawitemactivitypage.RawItemInformation_popUp_Submit_BT") &&
					GenericMethods.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_Cancel_BT, "rawitemactivitypage.RawItemInformation_popUp_Cancel_BT"))
			{
				Reporter.reportPassResult(
						browser,
						"All the fields are displaying as expetced on Raw Item Information Page",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"All the fields are displaying as expetced on Raw Item Information Page",
						"Fail");
				AbstractTest.takeSnapShot();
			}

	
	
		}	
		
	//TC3829 : Verify Cancel or Cross (X) button functionality on Raw Item Information page.
		@Test()
		public void rawItemActivityBundle_US858_TC3829() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3829";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			/*String todayDate=Base.returnTodayDate();*/
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			//Click on Information button
			rawitemactivitypage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			//Click on Cancel button or cross button
			rawitemactivitypage.RawItemInformation_popUp_Cancel_BT.click();
			Thread.sleep(3000);
			if(!Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_Title))
			{
				rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
				Reporter.reportPassResult(
						browser,
						"Raw Item information page is getting closed",
						"Pass");

			} else
			{
				Reporter.reportTestFailure(
						browser,
						"Raw Item information page is getting closed",
						"Fail");
				AbstractTest.takeSnapShot();
			}
	
		}	
		
		
		//TC3830 : Verify Submit button functionality on Raw Item Information page.
		
		
		@Test()
		public void rawItemActivityBundle_US858_TC3830() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3830";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String casePrice="5";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			//Click on Information button
			rawitemactivitypage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
			{
				rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

			}
			//Click on Cancel button or cross button
			rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
			rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
			Thread.sleep(3000);
			rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
			Thread.sleep(2000);
			rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
			Thread.sleep(2000);
			//Click on Submit button
			rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
			rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
			Thread.sleep(2000);
			rawitemactivitypage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
			{
				rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

			}
			if(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").equalsIgnoreCase(casePrice+".0000"))
			{
				Reporter.reportPassResult(
						browser,
						"Information page should open with the updated value",
						"Pass");

			} else
			{
				Reporter.reportTestFailure(
						browser,
						"Information page should open with the updated value",
						"Fail");
				AbstractTest.takeSnapShot();
			}
	
		}		
		
		
	//TC3831 : Verify KPI screen on Raw Item Information & Activity page.
		
		@Test()
		public void rawItemActivityBundle_US858_TC3831() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="rawItemActivityBundle_US858_TC3831";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
			Thread.sleep(5000);
			rawitemactivitypage.RawItemInformation_Arrow_Sign.click();
			Thread.sleep(3000);
			rawitemactivitypage.RawItemInformation_CurrentDayActivity_Label.isDisplayed();
			/*System should display different tables with the following column:
			Table 1 should contain column with label name Top Raw Items Wasted, quantity and total.
			Table 2 should contain column with label name Top Raw Items Promo'd, quantity and total
			4.View table in each table.
			User should be able to view data for each table (if available) in the format: menu item number, menu item description, quantity and total.
			5.Click on arrow icon again on KPI screen
			User should be able to collapse the KPI screen*/
			System.out.println(driver.findElement(By.xpath("//table[@id='kpiRIA_waste']/thead/tr/th[1]")).getText());
			if(driver.findElement(By.xpath("//table[@id='kpiRIA_waste']/thead/tr/th[1]")).getText().equalsIgnoreCase("Top Raw Items Wasted") &&
					driver.findElement(By.xpath("//table[@id='kpiRIA_waste']/thead/tr/th[2]")).getText().equalsIgnoreCase("quantity") &&
					driver.findElement(By.xpath("//table[@id='kpiRIA_waste']/thead/tr/th[3]")).getText().equalsIgnoreCase("total") &&
					driver.findElement(By.xpath("//table[@id='kpiRIA_promo']/thead/tr/th[1]")).getText().equalsIgnoreCase("Top Raw Items Promo'd") &&
					driver.findElement(By.xpath("//table[@id='kpiRIA_promo']/thead/tr/th[2]")).getText().equalsIgnoreCase("quantity") &&
					driver.findElement(By.xpath("//table[@id='kpiRIA_promo']/thead/tr/th[3]")).getText().equalsIgnoreCase("total"))
			{
				Reporter.reportPassResult(
						browser,
						"All the fields should display properly on KPI screen",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"All the fields should display properly on KPI screen",
						"Fail");
					AbstractTest.takeSnapShot();
			}
	}		
		
		
		

		
		

}
