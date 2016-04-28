package sprint14;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.ReadTestData;
import common.Reporter;
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.CustomRawItemListsPage;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import eInventoryPageClasses.MenuItemInformationPage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemInformationPage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.StoreControlSettingsPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.VarianceStatPage;

public class US1199_Level1Access extends AbstractTest{
	
	//TC2435 To verify if the level 1 user is able to create daily inventory
	@Test()
	public void sprint14_US1199_TC2435() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String caseValue="2";
		String looseUnit="4";
		/***********************************/
		//Go to Physical Inventory page
		String date=Base.returnTodayDate();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage =homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		//Fetch the record count
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		int numberofRecordsBeforeCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		//Create a Physical inventory
		//wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		//click on Daily Inventory button
		physicalInventoryPage.CreateDailyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//Click on Time Edit button
		physicalInventoryPage.CreateInventory_Time_Edit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Hour_Up_Link));
		//Change the hour time
		physicalInventoryPage.CreateInventory_Hour_Up_Link.click();
		//Change the Minute Time
		physicalInventoryPage.CreateInventory_Minute_Up_Link.click();
		//Fetch the date and time 
	
		int hour=Integer.parseInt(driver.findElement(By.xpath("//span[@id='eb_tp_hr_span']")).getText());
		System.out.println("hour is"+hour);
		String hourString=null;
		if(hour<=9)
		{
			hourString="0"+Integer.toString(hour);
			System.out.println("Hour string is "+hourString);
		}
		else
		{
			hourString=Integer.toString(hour);
			System.out.println("Hour string is "+hourString);

		}
		
		String min=driver.findElement(By.xpath("//span[@id='eb_tp_min_span']")).getText();
		String time=hourString+":"+min;
		System.out.println("Time is"+time);
		//click on Arrow Button
		physicalInventoryPage.CreateInventory_RawItremList_Arrow_Link.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Case_TB_List.get(0)));
		//Enter the case Value 
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(caseValue);
		//Enter the loose value
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnit);
		physicalInventoryPage.CreateInventory_Submit_BT.click();
		Thread.sleep(4000);
		int numberofRecordsAfterCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		if(numberofRecordsAfterCreate==numberofRecordsBeforeCreate+1)
		{
		
			Reporter.reportPassResult(browser, "sprint14_US1199_TC2435",
					"Physical Inventory should be created successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1199_TC2435_Condition1", "sprint14_US1199_TC2435", "Physical Inventory should be created successfully", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2435_Condition1");
		}
		
		//Click on View button for the newly created inventory
		driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title))
		{
			Reporter.reportPassResult(browser, "sprint14_US1199_TC2435",
					"User should be able to view the created Physical Inventory",
					"Pass");
		
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1199_TC2435_Condition2", "sprint14_US1199_TC2435", "User should be able to view the created Physical Inventory", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2435_Condition2");
		}
		
	}
	
	//TC2436 To verify if the level 1 user is able to create Weekly inventory
	@Test()
	public void sprint14_US1199_TC2436() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
			/** Variable Section : **/
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String caseValue="2";
			String looseUnit="4";
			/***********************************/
			//Go to Physical Inventory page
			String date=Base.returnTodayDate();
			System.out.println("DFate is"+date);
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage =homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToPhysicalInventoryPage();
			//Fetch the record count
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
			int numberofRecordsBeforeCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
			//Create a Physical inventory
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateWeeklyInventory_BT));
			//click on Daily Inventory button
			physicalInventoryPage.CreateWeeklyInventory_BT.click();

			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
			//Click on Time Edit button
			physicalInventoryPage.CreateInventory_Time_Edit_BT.click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Hour_Up_Link));
			/*//Change the hour time
			physicalInventoryPage.CreateInventory_Hour_Up_Link.click();
			//Change the Minute Time
			physicalInventoryPage.CreateInventory_Minute_Up_Link.click();*/
			//Fetch the date and time 
			int hour=Integer.parseInt(driver.findElement(By.xpath("//span[@id='eb_tp_hr_span']")).getText());
			System.out.println("hour is"+hour);
			String hourString=null;
			if(hour<=9)
			{
				hourString="0"+Integer.toString(hour);
				System.out.println("Hour string is "+hourString);
			}
			else
			{
				hourString=Integer.toString(hour);
				System.out.println("Hour string is "+hourString);

			}
			
			String min=driver.findElement(By.xpath("//span[@id='eb_tp_min_span']")).getText();
			String time=hourString+":"+min;
			System.out.println("Time is"+time);
			//click on Arrow Button
			physicalInventoryPage.CreateInventory_RawItremList_Arrow_Link.click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Case_TB_List.get(0)));
			//Enter the case Value 
			physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(caseValue);
			//Enter the loose value
			physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnit);
			physicalInventoryPage.CreateInventory_Submit_BT.click();
			Thread.sleep(10000);
			int numberofRecordsAfterCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
			if(numberofRecordsAfterCreate==numberofRecordsBeforeCreate+1)
			{
			
				Reporter.reportPassResult(browser, "sprint14_US1199_TC2436",
						"Physical Inventory should be created successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1199_TC2436_Condition1", "sprint14_US1199_TC2436", "Physical Inventory should be created successfully", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1199_TC2436_Condition1");
			}
			
			//Click on View button for the newly created inventory
			driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
			if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventoryList_Title))
			{
				Reporter.reportPassResult(browser, "sprint14_US1199_TC2436",
						"User should be able to view the created Physical Inventory",
						"Pass");
			
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1199_TC2436_Condition2", "sprint14_US1199_TC2436", "User should be able to view the created Physical Inventory", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1199_TC2436_Condition2");
			}
		}
		
	//TC2437 To verify if the level 1 user is able to create monthly inventory
	@Test()
	public void sprint14_US1199_TC2437() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
			/** Variable Section : **/
			
			String userId = LoginTestData.level1_SSO_UserId;
			String password = LoginTestData.level1_SSO_Password;
			String caseValue="2";
			String looseUnit="4";
			/***********************************/
			//Go to Physical Inventory page
			String date=Base.returnTodayDate();
			System.out.println("DFate is"+date);
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage =homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToPhysicalInventoryPage();
			//Fetch the record count
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateMonthlyInventory_BT));
			int numberofRecordsBeforeCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
			//Create a Physical inventory
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateMonthlyInventory_BT));
			//click on Daily Inventory button
			physicalInventoryPage.CreateMonthlyInventory_BT.click();

			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
			//Click on Time Edit button
			physicalInventoryPage.CreateInventory_Time_Edit_BT.click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Hour_Up_Link));
	/*		
			//Change the hour time
			physicalInventoryPage.CreateInventory_Hour_Up_Link.click();
			//Change the Minute Time
			physicalInventoryPage.CreateInventory_Minute_Up_Link.click();
			//Fetch the date and time 
	*/	
			int hour=Integer.parseInt(driver.findElement(By.xpath("//span[@id='eb_tp_hr_span']")).getText());
			System.out.println("hour is"+hour);
			String hourString=null;
			if(hour<=9)
			{
				hourString="0"+Integer.toString(hour);
				System.out.println("Hour string is "+hourString);
			}
			else
			{
				hourString=Integer.toString(hour);
				System.out.println("Hour string is "+hourString);

			}
			
			String min=driver.findElement(By.xpath("//span[@id='eb_tp_min_span']")).getText();
			String time=hourString+":"+min;
			System.out.println("Time is"+time);
			//click on Arrow Button
			physicalInventoryPage.CreateInventory_RawItremList_Arrow_Link.click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Case_TB_List.get(0)));
			//Enter the case Value 
			physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(caseValue);
			//Enter the loose value
			physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnit);
			physicalInventoryPage.CreateInventory_Submit_BT.click();
			Thread.sleep(15000);
			int numberofRecordsAfterCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
			if(numberofRecordsAfterCreate==numberofRecordsBeforeCreate+1)
			{
			
				Reporter.reportPassResult(browser, "sprint14_US1199_TC2437",
						"Physical Inventory should be created successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1199_TC2437", "sprint14_US1199_TC2437", "Physical Inventory should be created successfully", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1199_TC2437_Condition1");
			}
			
			//Click on View button for the newly created inventory
			driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
			if(Base.isElementDisplayed(physicalInventoryPage.MonthlyInventoryList_Title))
			{
				Reporter.reportPassResult(browser, "sprint14_US1199_TC2437",
						"User should be able to view the created Physical Inventory",
						"Pass");
			
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1199_TC2437_Condition2", "sprint14_US1199_TC2437", "User should be able to view the created Physical Inventory", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1199_TC2437_Condition2");
			}
		}
		
	//TC2438 : To Verify if the level 1 user is able to enter a manual purchase
	@Test()
	public void sprint14_US1199_TC2438() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage =homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		//Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor, quantity, invoiceId);
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2438",
					"level 1 user should be able to enter a manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2438","sprint14_US1199_TC2438",
					"level 1 user should be able to enter a manual purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2438");
		}
	}
	
	//TC2439 : To Verify if the level 1 user is able to edit and approve a pending purchase.
	@Test()
	public void sprint14_US1199_TC2439() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor =GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage =homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		//Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor, quantity, invoiceId);
		Thread.sleep(2000);
		//click on approve button for the created manual purchase button
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ManualInvoiceApprove_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(manualInvoiceNewPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualPurchasePosted_MSG));
		Thread.sleep(2000);
		//Click on view History button
		purchasesPage.ViewHistory_BT.click();
		// Verify that manual invoice is approved
		if (purchasesPage.verifyManualInvoicePosted(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2439",
					"level 1 user should be able to approve a pending purchase.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2439","sprint14_US1199_TC2439",
					"level 1 user should be able to approve a pending purchase.", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2439");
		}
	}
	
	// TC2440 :To Verify if the level 1 user is able to delete a pending purchase.
	@Test()
	public void sprint14_US1199_TC2440() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//Click on create new invoice button 
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		//Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		//Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		//Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		//click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		// Verify that manual purchase should be deleted from the purchase page
		if (!manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2440",
					"level 1 user is able to delete a purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2440","sprint14_US1199_TC2440",
					"level 1 user is able to delete a purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2440");
		}
	}
	
	// TC2442 : To Verify if the level 1 user is able to view purchase history 
	@Test()
	public void sprint14_US1199_TC2442() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// click on view History button
		purchasesPage.ViewHistory_BT.click();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get Start date as current month start date
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		// Get end Date as today date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		purchasesPage.selectStartDateToViewHistory(startDate);
		purchasesPage.selectEndDateToViewHistory(endDate);
		purchasesPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(2000);
		// Verify that level 1 user should be able to view Manual purchase history for the selected date range
		if (purchasesPage.verifyPurchaseHistoryDisplayedForSelectedDateRange(startDate, endDate)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2442",
					"level 1 user is able to view Purchase History", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2442","sprint14_US1199_TC2442",
					"level 1 user is able to view Purchase History", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2442");
		}
	}
	
	// TC2443 :To Verify if the level 1 user is able to view store ledger
	@Test()
	public void sprint14_US1199_TC2443() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// click on view ledger button
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		// select last month from the dropdown
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//get last month and year
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -1);
		cal2.set(Calendar.DATE, 1);
        String date = dateFormat.format(cal2.getTime());
		storeLedgerDetailPage.selectMonthFromStoreLedgerDrpDwn(date);
		Thread.sleep(5000);
		String lastMonth = date.split("-")[1];
		if (lastMonth.startsWith("0")) {
			lastMonth = lastMonth.replace("0", "");
		}
		int month = (Integer.parseInt(lastMonth));
		int year = Integer.parseInt(date.split("-")[0]);
		// Verify that level 1 user should be able to view ledger details for the selected month
		if (storeLedgerDetailPage.verifyDataForSelectedMonth(month,year)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2443",
					"level 1 user is able to view store ledger", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2443","sprint14_US1199_TC2443",
					"level 1 user is able to view store ledger", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2443");
		}
	}
	
	//TC2444 :To Verify if the level 1 user is able to restore purchase
	@Test()
	public void sprint14_US1199_TC2444() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		//Click on create new invoice button 
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		//Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		//Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		//Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		//click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		boolean manualInvoiceDeleted = !(manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId));
		//click on restore purchases button
		purchasesPage.RestorePurchases_BT.click();
		//restore the manual invoice with the same invoice id
		purchasesPage.restoreDeletedPurchases(invoiceId);
		// Verify that manual invoice should be restored 
		if (manualInvoiceDeleted & manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2444",
					"level 1 user is able to restore purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2444","sprint14_US1199_TC2444",
					"level 1 user is able to restore purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2444");
		}
	}
	
	// TC2445 : To Verify if the level 1 user is able to enter raw waste
	@Test()
	public void sprint14_US1199_TC2445() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "1";
		String innerPackQuantity = "1";
		String looseUnitQuantity = "1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity, innerPackQuantity, looseUnitQuantity);
		//Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount "+wasteAmount);
		//Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2445",
					"Level 1 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2445","sprint14_US1199_TC2445",
					"Level 1 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2445");
		}
	}

	// TC2446 : To Verify if the level 1 user is able to enter completed waste
	@Test()
	public void sprint14_US1199_TC2446() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Completed Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a Completed waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(samplewRINID,quantity);
		//Get total waste amount
		String wasteAmount = completedWastePage.getTotalWasteAmunt();
		//Submit the completed waste entry
		completedWastePage.Submit_BT.click();
		Thread.sleep(3000);
		// Verify that Completed waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2446",
					"Level 1 User should be able to enter completed waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2446","sprint14_US1199_TC2446",
					"Level 1 User should be able to enter completed waste", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2446");
		}
	}
	
	//TC2447 : To Verify if the level 1 user is able to enter raw promo
	@Test()
	public void sprint14_US1199_TC2447() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "1";
		String innerPackQuantity = "1";
		String looseUnitQuantity = "1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver, RawItemPromoPage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Promo Button
		promotionAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		// Create a raw Promo entry
		rawItemPromoPage.addARawPromoItem(samplewRINID, innerPackQuantity, caseQuantity, looseUnitQuantity);
		//get the total promo amount
		String promoAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("promoAmount "+promoAmount);
		//submit raw promo entry
		rawItemPromoPage.Submit_BT.click();
		// Verify that raw promo entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawPromoEntryPresent(Base.returnTodayDate(), promoAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2447",
					"Level 1 User should be able to enter  raw promo",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2447","sprint14_US1199_TC2447",
					"Level 1 User should be able to enter  raw promo",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2447");
		}
	}
	
	// TC2448 : To Verify if the level 1 user is able to cancel raw waste entry
	@Test()
	public void sprint14_US1199_TC2448() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "2";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity, innerPackQuantity, looseUnitQuantity);
		//Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		//cancel the raw waste entry
		rawItemWastePage.Cancel_BT.click();
		//Click on Yes button
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
		//Verify that raw waste entry should not displayed in Promotion and waste page
		if (!promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2448",
					"Level 1 User should be able to cancel raw waste entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2448","sprint14_US1199_TC2448",
					"Level 1 User should be able to cancel raw waste entry", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2448");
		}
	}
	
	// TC2449 : To Verify if the level 1 user is able to cancel completed waste entry
	@Test()
	public void sprint14_US1199_TC2449() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "3";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Completed waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a Completed waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(samplewRINID,quantity);
		//Get the total Completed waste amount
		String wasteAmount = completedWastePage.getTotalWasteAmunt();
		//Cancel the Completed waste entry
		completedWastePage.Cancel_BT.click();
		//click on yes button
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT)).click();
		// Verify that Completed waste entry should not displayed in Promotion and waste page
		if (!promotionAndWastePage.isCompletedWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2449",
					"Level 1 User should be able to cancel completed waste entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2449","sprint14_US1199_TC2449",
					"Level 1 User should be able to cancel completed waste entry", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2449");
		}
	}
	
	//TC2450 : To Verify if the level 1 user is able to cancel raw promo entry
	@Test()
	public void sprint14_US1199_TC2450() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "3";
		String innerPackQuantity = "3";
		String looseUnitQuantity = "3";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage
				.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement().goToPromotionsAndWastePage();
		// Click on Raw promo Button
		promotionAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		// Create a raw promo entry
		rawItemPromoPage.addARawPromoItem(samplewRINID, innerPackQuantity,caseQuantity, looseUnitQuantity);
		//get the promo amount
		String promoAmount = rawItemPromoPage.getTotalPromoAmount();
		//click on cancel button
		rawItemPromoPage.Cancel_BT.click();
		//click on yes button
		wait.until(ExpectedConditions.elementToBeClickable(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT)).click();
		// Verify that raw promo entry should not displayed in Promotion and waste page
		if (!promotionAndWastePage.isRawPromoEntryPresent(Base.returnTodayDate(), promoAmount)) {
			Reporter.reportPassResult(browser, "sprint14_US1199_TC2450",
					"Level 1 User should be able to cancel raw promo entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2450","sprint14_US1199_TC2450",
					"Level 1 User should be able to cancel  raw promo entry", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2450");
		}
	}
	
	//TC2452 : To verify that the level 1 users are able to use all of the functionality on the Transfers page.
	@Test()
	public void sprint14_US1199_TC2452() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		HSSFSheet transferLandingPageSheet = ReadTestData.getTestDataSheet("sprint14_US1199_TC2452", "Object1");
		String samplewRINID = ReadTestData.getTestData(transferLandingPageSheet,"WRINId");
		String transferType = ReadTestData.getTestData(transferLandingPageSheet,"TransferType");
		String transferStoreNumber = ReadTestData.getTestData(transferLandingPageSheet,"InputNationalStoreNumber");
		String caseQuantity = ReadTestData.getTestData(transferLandingPageSheet,"OuterPackQty");
		String innerPackQuantity =ReadTestData.getTestData(transferLandingPageSheet,"InnerPackQty");
		String looseUnitQuantity =ReadTestData.getTestData(transferLandingPageSheet,"LooseUnitsQty");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Get the time of transfer
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType)
				.selectLocationToTransfer(transferStoreNumber).insertAndAddDetailsToTransfer(samplewRINID, caseQuantity, innerPackQuantity,looseUnitQuantity);
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
		//Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(), time, amount)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2452",
					"User should be able to submit in/out transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2452","sprint14_US1199_TC2452",
					"User should be able to submit in/out transfer",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2452_Condition1");
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		//click on Create new Transfer button
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Get the time of transfer
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
		// Verify that user should be able to cancel transfer and tranfer entries should not displayed in transfer page 
		if (!transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(),time2, amount2)) {
			Reporter.reportPassResult(browser, "sprint14_US1199_TC2452",
					"Level 1 User should be able to cancel in/out transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "sprint14_US1199_TC2452","sprint14_US1199_TC2452",
					"Level 1 User should be able to cancel in/out transfer",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2452_Condition2");
		}
	}
	
	//TC2456 : To Verify if the level 1 user is able to transfer raw items to office.
	@Test()
	public void sprint14_US1199_TC2456() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		HSSFSheet transferLandingPageSheet = ReadTestData.getTestDataSheet("sprint14_US1199_TC2456", "Object1");
		String samplewRINID = ReadTestData.getTestData(transferLandingPageSheet,"WRINId");
		String transferType = ReadTestData.getTestData(transferLandingPageSheet,"TransferType");
		String caseQuantity = ReadTestData.getTestData(transferLandingPageSheet,"OuterPackQty");
		String innerPackQuantity =ReadTestData.getTestData(transferLandingPageSheet,"InnerPackQty");
		String looseUnitQuantity =ReadTestData.getTestData(transferLandingPageSheet,"LooseUnitsQty");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID, caseQuantity, innerPackQuantity,looseUnitQuantity);
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
		//Verify that transfer entries should displayed in Transfer landing page
		if (result& transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(), time, amount)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2456",
					"User should be able to submit transfer to office",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2456","sprint14_US1199_TC2456",
					"User should be able to submit transfer to office",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2456");
		}
	}
	
	//TC2457 : To Verify if the level 1 user is able to view and print raw items transfer details
	@Test()
	public void sprint14_US1199_TC2457() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		HSSFSheet transferLandingPageSheet = ReadTestData.getTestDataSheet("sprint14_US1199_TC2457", "Object1");
		String samplewRINID = ReadTestData.getTestData(transferLandingPageSheet,"WRINId");
		String transferType = ReadTestData.getTestData(transferLandingPageSheet,"TransferType");
		String caseQuantity = ReadTestData.getTestData(transferLandingPageSheet,"OuterPackQty");
		String innerPackQuantity =ReadTestData.getTestData(transferLandingPageSheet,"InnerPackQty");
		String looseUnitQuantity =ReadTestData.getTestData(transferLandingPageSheet,"LooseUnitsQty");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Get the time of transfer
		String time = transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
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
		//View the transfer entry
		transferLandingPage.viewTransfer(Base.returnTodayDate(), time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2457",
					"level 1 user is able to view raw items transfer details", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2457","sprint14_US1199_TC2457",
					"level 1 user is able to view raw items transfer details", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2457");
		}
	}
	
	//TC2458 :To Verify if the level 1 user is able to view  variance state
	@Test()
	public void sprint14_US1199_TC2458() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to variance stat page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToVarianceStatPage();
		//select daily stat from drop down
		varianceStatPage.selectVarianceStatType("Daily");
		//click on start date button
		wait.until(ExpectedConditions.elementToBeClickable(varianceStatPage.StartDate_BT)).click();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get yesterday date as start date
		cal1.add(Calendar.DATE, -1);
		String startDate = dateFormat.format(cal1.getTime());
		//Select yesterday date from calender
		varianceStatPage.selectDateFromCalender(startDate);
		//Verify that daily stat should displayed for the selected date 
		if (varianceStatPage.verifyVarianceStatLoaded()) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2458",
					"level 1 user is able to view daily variance stat", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2458","sprint14_US1199_TC2458",
					"level 1 user is able to view daily variance stat", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2458_Condition1");
		}
		// click on dont with this item button
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.DoneWithThisItem_BT)).click();
		//Select monthly from the drop down
		varianceStatPage.selectVarianceStatType("Monthly");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		//get last month and year
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -1);
		cal2.set(Calendar.DATE, 1);
        String date = dateFormat2.format(cal2.getTime());
        //select last month from the drop down
        varianceStatPage.selectMonth(date);
        //verify that variance stat should displayed for the selected month
        boolean monthlyVarianceDisplayed = varianceStatPage.verifyVarianceStatLoaded();
        //click on done with this item button
        wait.until(ExpectedConditions.visibilityOf(varianceStatPage.DoneWithThisItem_BT)).click();
        //verify that user should be on variance stat page
		if (monthlyVarianceDisplayed & Base.isElementDisplayed(varianceStatPage.VarianceStatType_DD)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2458",
					"level 1 user is able to view Monthly variance stat",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2458","sprint14_US1199_TC2458",
					"level 1 user is able to view Monthly variance stat",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2458_Condition2");
		}
	}
	
	//TC2459 : To verify that the level 1 users are able to use all of the functionality on the Food over base page.
	@Test()
	public void sprint14_US1199_TC2459() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		int random = (int )(Math.random() * 50 + 1);
		String newtargetPercentValue = String.valueOf(random);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food OverBase page
		FoodOverBasePage foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToFoodOverBasePage();
		//Click on Target percentage column header link image
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.NextMonth_TargetPercent_ColumnHeader_Image_LK)).click();
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.PostTargetValuesPopUp_BaseFood_TB));
		//edit the target percentage values and save the new values
		System.out.println("newtargetPercentValue "+newtargetPercentValue);
		foodOverBasePage.editTargetPercentValues(newtargetPercentValue);
		Thread.sleep(10000);
		newtargetPercentValue = newtargetPercentValue+".00%";
		System.out.println("newtargetPercentValue "+newtargetPercentValue);
		//Verify that Values are saved
		if (foodOverBasePage.NextMonth_BaseFood_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_MenuItemWaste_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_RawWaste_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_Condiment_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_EmployeeManagerFood_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_DiscountCoupon_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_StatVariance_TargetPercent_Value.getText().equals(newtargetPercentValue)
				& foodOverBasePage.NextMonth_UnexplainedDifference_TargetPercent_Value.getText().equals(newtargetPercentValue)){
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2459",
					"Level 1 user should be able to edit targetPercent value for current month in FoodOverBase Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2459","sprint14_US1199_TC2459",
					"Level 1 user should be able to edit targetPercent value for current month in FoodOverBase Page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2459_Condition1");
		}
		String comment = "Test Automation "+ Base.randomNumberFiveDigit();
		//Click on the post comment button for current month and save a comment
		foodOverBasePage.postCommentForCurrentMonth(comment);
		//Verify that new comment is saved 
		foodOverBasePage.PostCommentForCurrentMonth_BT.click();
		if (foodOverBasePage.CommentBox_TB.getAttribute("value").equals(comment)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2459",
					"Level 1 user should be able to save a comment in food over base page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2459_Condition2","sprint14_US1199_TC2459",
					"Level 1 user should be able to save a comment in food over base page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2459_Condition2");
		}
	}
	
	//TC2460:To verify that the level 1 users are able to use all of the functionality on the Raw Item Activity page.
	@Test()
	public void sprint14_US1199_TC2460() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.rawItemActivityWrin;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemActivityPage();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get start date as 2 days earlier date from today date
		cal1.add(Calendar.DATE, -2);
		String startDate = dateFormat.format(cal1.getTime());
		// Get end date as today date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -0);
		String endDate = dateFormat.format(cal2.getTime());
		// Select start Date
		rawItemActivityPage.StartDate_BT.click();
		Thread.sleep(1000);
		rawItemActivityPage.selectStartDate(startDate);
		// Select End Date
		rawItemActivityPage.EndDate_BT.click();
		Thread.sleep(1000);
		rawItemActivityPage.selectEndDate(endDate);
		// Search for the raw item
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.Information_BT));
		// Verify that user is able to view Raw item Activity details
		if (rawItemActivityPage.rawItemDetailList.size() > 0) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2460",
					"Level 1 user should be able to  view the raw item activity deatails",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2460","sprint14_US1199_TC2460",
					"Level 1 user should be able to  view the raw item activity deatails",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2460");
		}
	}
	
	//TC2461: verify if the level 1 user is able to view the details of waste/promo on the raw item activity view page
	@Test()
	public void sprint14_US1199_TC2461() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId = GlobalVariable.rawItemActivityWrin;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemActivityPage();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get start date as current month start date
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		System.out.println("startDate " + startDate);
		// Get end date today date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -0);
		String endDate = dateFormat.format(cal2.getTime());
		// Enter start date
		rawItemActivityPage.StartDate_BT.click();
		Thread.sleep(1000);
		rawItemActivityPage.selectStartDate(startDate);
		// Select end date
		rawItemActivityPage.EndDate_BT.click();
		Thread.sleep(1000);
		rawItemActivityPage.selectEndDate(endDate);
		// Search for the raw item
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.Information_BT));
		// Verify that raw item activity details are displayed for the selected raw item
		if (rawItemActivityPage.rawItemDetailList.size() > 0
				& rawItemActivityPage.rawItemEventDetailList.size() > 0) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2460",
					"Level 1 user should be able to view the details of waste/promo on the raw item activity view page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2460","sprint14_US1199_TC2460",
					"Level 1 user should be able to view the details of waste/promo on the raw item activity view page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2460");
		}
	}
	
	//TC2462: verify if the level 1 user is not able to modify any raw item information
	@Test()
	public void sprint14_US1199_TC2462() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemInformationPage rawItemInformationPage; 
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String wrinId=GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		rawItemInformationPage = PageFactory.initElements(driver, RawItemInformationPage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemActivityPage().searchAndSelectWRINID(wrinId);
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get start date as current month start date
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		// Get end date today date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -0);
		String endDate = dateFormat.format(cal2.getTime());
		// Enter start date
		rawItemActivityPage.StartDate_BT.click();
		Thread.sleep(1000);
		rawItemActivityPage.selectStartDate(startDate);
		// Select end date
		rawItemActivityPage.EndDate_BT.click();
		Thread.sleep(2000);
		rawItemActivityPage.selectEndDate(endDate);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(rawItemActivityPage.Information_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemInformationPage.RawItemInformation_Title));
		//Verify that Manual Purchase check box and ListType drop down is disabled for Level 6 user
		if(rawItemInformationPage.ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemInformationPage.ListType_DD.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2462",
					"Level 1 user can VIEW-ONLY the Raw Item Information page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2462","sprint14_US1199_TC2462",
					"Level 1 user can VIEW-ONLY the Raw Item Information page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2462");
		}
	}
	
	//TC2463: To verify if the level 1 user is able to add a custom list
	@Test()
	public void sprint14_US1199_TC2463() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String rawItemListName = "Test" + Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		// create new Custom List
		customRawItemListsPage.createACustomRawList(rawItemListName);
		boolean result = Base.isElementDisplayed(customRawItemListsPage.ChangesSaved_Confirmation_MSG);
		// verify that custom list is created and displayed in custom Raw Item list page
		if (result && customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2463",
					"User should be able to add a custom list", "Pass");

		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2463","sprint14_US1199_TC2463",
					"User should be able to add a custom list", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2463");
		}
	}
	
	//TC2464: To verify if the level 1 user is able to cancel a custom list add
	@Test()
	public void sprint14_US1199_TC2464() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String rawItemListName = "Test" + Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		// click add list button
		customRawItemListsPage.AddList_BT.click();
		wait.until(ExpectedConditions.visibilityOf(customRawItemListsPage.CreateNewRawItemListPopup_Name_TB));
		Thread.sleep(2000);
		//enter custom list name
		customRawItemListsPage.CreateNewRawItemListPopup_Name_TB.sendKeys(rawItemListName);
		//click on cancel button
		customRawItemListsPage.CreateNewRawItemListPopup_Cancel_BT.click();
		// verify that custom list should not be added in custom Raw Item list page
		if (!customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2464",
					"User should be  able to cancel a custom list add", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2464","sprint14_US1199_TC2464",
					"User should be  able to cancel a custom list add", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2464");
		}
	}
	
	//TC2465: To verify if the level 1 user is able to delete a custom list
	@Test()
	public void sprint14_US1199_TC2465() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String rawItemListName = "Test" + Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		//create new custom list 
		customRawItemListsPage.createACustomRawList(rawItemListName);
		//verify new list is added and displayed
		boolean result = customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName);
		//Delete the added custom list
		customRawItemListsPage.deleteCustomRawList(rawItemListName);
		//Verify that custom list should be deleted and should not displayed in custom Raw Item list page
		result = result & (!customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName));
		if (result) {
			Reporter.reportPassResult(browser, "sprint14_US1199_TC2465",
					"level 1 user should be able to delete a custom list", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2465","sprint14_US1199_TC2465",
					"level 1 user should be able to delete a custom list", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2465");
		}
	}
	
	//TC2466: To verify if the level 1 user is able to restore a custom list
	@Test()
	public void sprint14_US1199_TC2466() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String rawItemListName = "Test" + Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Custom raw Item list page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		//Create a new list
		customRawItemListsPage.createACustomRawList(rawItemListName);
		//Delete the newly created list
		customRawItemListsPage.deleteCustomRawList(rawItemListName);
		//restore the deleted list
		customRawItemListsPage.restoreCustomList(rawItemListName);
		//Go to custom Raw Item list page
		homePage.Menu_DD_BT.click();
		homePage.goToCustomRawItemListsPage();
		// Verify that custom list is restored and displayed in  "Custom Raw Item List " page.
		boolean customListRestored = customRawItemListsPage.verifyCustomListIsDisplayed(rawItemListName);
		if (customListRestored) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2466",
					"level 1 user should be able to restore a custom list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2466","sprint14_US1199_TC2466",
					"level 1 user should be able to restore a custom list",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2466");
		}
	}
	
	// TC2468: To verify if the level 1 user is able to only view the manual vendor page
	@Test()
	public void sprint14_US1199_TC2468() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToManualVendorsPage();
		//Verify that level 1 user is not able to view Add Vendor Button in Manual Vendor page
		boolean result = (!Base.isElementDisplayed(manualVendorsPage.AddVendor_BT));
		//Get the name of any vendor
		String vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		//Verify that 'Edit' and 'Delete' button should not be displayed for level 1 user
		result = result & (!manualVendorsPage.verifyEditButtonDisplayed(vendorName) 
				& (!manualVendorsPage.verifyVendorDeleted(vendorName)));
		if (result) {
			Reporter.reportPassResult(
					browser, "sprint14_US1199_TC2468",
					"level 1 user should be able to only view the manual vendor page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1199_TC2468","sprint14_US1199_TC2468",
					"level 1 user should be able to only view the manual vendor page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2468");
		}
	}
	
	//TC2469 : To verify if the level 1 user is able to only view the menu item activity
	@Test()
	public void sprint14_US1199_TC2469() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		HSSFSheet menuItemActivityPageSheet = ReadTestData.getTestDataSheet("sprint15_US1208_TC2652", "Object1");
		String menuItemNumber = ReadTestData.getTestData(menuItemActivityPageSheet, "MenuItemNumber");
		String startTime = ReadTestData.getTestData(menuItemActivityPageSheet, "CustomStartTime");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Raw Item Activity Page
		MenuItemActivityAndInformationPage menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToMenuItemActivityPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MiaStartDate_BT));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get Start date as current month start date
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		// Get end Date as yesterday date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -1);
		String endDate = dateFormat.format(cal2.getTime());
		// Get current hour
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH");
		Calendar cal3 = Calendar.getInstance();
		cal3.add(Calendar.DATE, 0);
		String currentHour = dateFormat2.format(cal3.getTime());
		// Get end time as 2 hour later from current time
		String endTime = String.valueOf(Integer.parseInt(currentHour) + 2)+ ":00";
		// enter start date
		menuItemActivityPage.enterDateInMenuItemStartDate(startDate);
		// enter end date
		menuItemActivityPage.enterDateInMenuItemEndDate(endDate);
		// enter start time
		menuItemActivityPage.selectStartTime(startTime);
		// enter end time
		menuItemActivityPage.selectEndTime(endTime);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		if (menuItemActivityPage.verifyMenuActivityTimeForSelectedDateRange(startDate, endDate, startTime, endTime)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2469",
					"level 1 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2469","sprint14_US1199_TC2469",
					"level 1 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2469");
		}
	}
	
	//TC2471 : To verify if the level 1 user is able to only view the menu item information
	@Test()
	public void sprint14_US1199_TC2471() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		HSSFSheet menuItemActivityPageSheet = ReadTestData.getTestDataSheet("sprint15_US1208_TC2650", "Object1");
		String menuItemNumber = ReadTestData.getTestData(menuItemActivityPageSheet, "MenuItemNumber");
		String menuItemDescription = ReadTestData.getTestData(menuItemActivityPageSheet, "MenuItemDescription");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MenuItemInformationPage menuInformationPage = PageFactory.initElements(driver, MenuItemInformationPage.class);
		// Navigate to Raw Item Activity Page
		MenuItemActivityAndInformationPage menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToMenuItemActivityPage();
		// Search and select menu Item using menu Item Number = 1
		menuItemActivityPage.searchAndSelectMenuItem(menuItemNumber);
		wait.until(ExpectedConditions
				.visibilityOf(menuItemActivityPage.MiaStartDate_BT));
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// get Start date as current month start date
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		// Get end Date as yesterday date
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -1);
		String endDate = dateFormat.format(cal2.getTime());
		// enter start date
		menuItemActivityPage.enterDateInMenuItemStartDate(startDate);
		// enter end date
		menuItemActivityPage.enterDateInMenuItemEndDate(endDate);
		// Click on search button
		menuItemActivityPage.ShowResults_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuInformationPage.MenuItemInformation_Title));
		if (menuInformationPage.verifyMenuItemInfoPageLoaded(menuItemNumber, menuItemDescription)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2471",
					"level 1 user should be able to view item page with the information of the menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2471","sprint14_US1199_TC2471",
					"level 1 user should be able to view item page with the information of the menu item",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2471");
		}
	}
	
	//TC2543 : To verify if the level 1 users are able to view the store settings but restricted from all Inventory Restaurant setting functionality
	@Test()
	public void sprint14_US1199_TC2543() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Login with level 1 sso user id and password and go to Store setting page
		StoreControlSettingsPage storeControlSettingsPage = homePage.selectUserWithSSOLogin(userId, password).goToStoreControlSettingsPage();
		// Verify that level 1 user should have read only access to Store setting page
		if (storeControlSettingsPage.TotalInvoiceAmountVariance_TB.getAttribute("disabled").equals("true")
				& storeControlSettingsPage.CasesVarience_TB.getAttribute("disabled").equals("true")
				& storeControlSettingsPage.TransferLimits_CB.getAttribute("disabled").equals("true")
				& storeControlSettingsPage.TransferAndAmountLimit_TB.getAttribute("disabled").equals("true")
				& !Base.isElementDisplayed(storeControlSettingsPage.TransferSetting_Save_BT)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1199_TC2543",
					"level 1 user should have read only access to Store setting page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1199_TC2543","sprint14_US1199_TC2543",
					"level 1 user should have read only access to Store setting page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1199_TC2543");
		}
	}
}
