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
import org.openqa.selenium.support.ui.Select;
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
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import eInventoryPageClasses.MenuItemInformationPage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemInformationPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.VarianceStatPage;

public class US1200_Level2Access extends AbstractTest
{
	
	//TC2508 To verify if the level 2 user is able to create daily inventory
	@Test()
	public void sprint14_US1200_TC2508() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String caseValue = "2";
		String looseUnit = "4";
		/***********************************/
		// Go to Physical Inventory page
		String date = Base.returnTodayDate();
		System.out.println("DFate is" + date);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		// Fetch the record count
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		int numberofRecordsBeforeCreate = driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		// Create a Physical inventory
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		// click on Daily Inventory button
		physicalInventoryPage.CreateDailyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		// Click on Time Edit button
		physicalInventoryPage.CreateInventory_Time_Edit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Hour_Up_Link));
		// Change the hour time
		physicalInventoryPage.CreateInventory_Hour_Up_Link.click();
		// Change the Minute Time
		physicalInventoryPage.CreateInventory_Minute_Up_Link.click();
		// Fetch the date and time
		int hour = Integer.parseInt(driver.findElement(By.xpath("//span[@id='eb_tp_hr_span']")).getText());
		System.out.println("hour is" + hour);
		String hourString = null;
		if (hour <= 9) {
			hourString = "0" + Integer.toString(hour);
			System.out.println("Hour string is " + hourString);
		} else {
			hourString = Integer.toString(hour);
			System.out.println("Hour string is " + hourString);
		}
		String min = driver.findElement(By.xpath("//span[@id='eb_tp_min_span']")).getText();
		String time = hourString + ":" + min;
		System.out.println("Time is" + time);
		// click on Arrow Button
		physicalInventoryPage.CreateInventory_RawItremList_Arrow_Link.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Case_TB_List.get(0)));
		// Enter the case Value
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(caseValue);
		// Enter the loose value
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnit);
		physicalInventoryPage.CreateInventory_Submit_BT.click();
		Thread.sleep(4000);
		int numberofRecordsAfterCreate = driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		if (numberofRecordsAfterCreate == numberofRecordsBeforeCreate + 1) {
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2508",
					"Physical Inventory should be created successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"sprint14_US1200_TC2508_Condition1","sprint14_US1200_TC2508",
					"Physical Inventory should be created successfully", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2508_Condition1");
		}
		// Click on View button for the newly created inventory
		driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+ date + "')]/span[text()='" + time + "']]//button")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if (Base.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1200_TC2508",
					"User should be able to view the created Physical Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2508_Condition2","sprint14_US1200_TC2508",
					"User should be able to view the created Physical Inventory",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2508_Condition2");
		}
	}
	
	//TC2509 To verify if the level 2 user is able to create Weekly inventory
	@Test()
	public void sprint14_US1200_TC2509() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
		
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2509",
					"Physical Inventory should be created successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2509_Condition1", "sprint14_US1200_TC2509", "Physical Inventory should be created successfully", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2509_Condition1");
		}
		
		//Click on View button for the newly created inventory
		driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventoryList_Title))
		{
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2509",
					"User should be able to view the created Physical Inventory",
					"Pass");
		
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2509_Condition2", "sprint14_US1200_TC2509", "User should be able to view the created Physical Inventory", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2509_Condition2");
		}
	}
	
	//TC2510 To verify if the level 2 user is able to create monthly inventory
	@Test()
	public void sprint14_US1200_TC2510() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
		
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2510",
					"Physical Inventory should be created successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2510", "sprint14_US1200_TC2510", "Physical Inventory should be created successfully", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2510_Condition1");
		}
		
		//Click on View button for the newly created inventory
		driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(Base.isElementDisplayed(physicalInventoryPage.MonthlyInventoryList_Title))
		{
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2510",
					"User should be able to view the created Physical Inventory",
					"Pass");
		
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2510_Condition2", "sprint14_US1200_TC2510", "User should be able to view the created Physical Inventory", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2510_Condition2");
		}
	}
	
	//TC2511 : To Verify if the level 2 user is able to enter a manual purchase
	@Test()
	public void sprint14_US1200_TC2511() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
		Thread.sleep(5000);
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2511",
					"level 2 user should be able to enter a manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2511","sprint14_US1200_TC2511",
					"level 2 user should be able to enter a manual purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2511");
		}
	}
	
	//TC2512 : To Verify if the level 2 user is able to edit and approve a pending purchase.
	@Test()
	public void sprint14_US1200_TC2512() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		// Create a new manual purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		// click on approve button for the created manual purchase button
		homePage.Menu_DD_BT.click();
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
					browser,"sprint14_US1200_TC2512",
					"level 1 user should be able to approve a pending purchase.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"sprint14_US1200_TC2512",
					"sprint14_US1200_TC2512",
					"level 1 user should be able to approve a pending purchase.",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2512");
		}
	}
	
	// TC2514 :To Verify if the level 2 user is able to delete a pending purchase.
	@Test()
	public void sprint14_US1200_TC2514() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		// Create a new purchase
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,quantity, invoiceId);
		// Click on approve button for the same purchase
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId);
		// Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		// click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		// Verify that manual purchase should be deleted from the purchase page
		if (!manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2514",
					"level 2 user is able to delete a purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2514","sprint14_US1200_TC2514",
					"level 2 user is able to delete a purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2514");
		}
	}
	
	// TC2515 : To Verify if the level 2 user is able to view purchase history 
	@Test()
	public void sprint14_US1200_TC2515() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
		// Verify that level 2 user should be able to view Manual purchase history for the selected date range
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
	
	// TC2516 :To Verify if the level 2 user is able to view store ledger
	@Test()
	public void sprint14_US1200_TC2516() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// click on view ledger button
		StoreLedgerDetailPage storeLedgerDetailPage = purchasesPage.clickOnViewStoreLedgerButton();
		// select last month from the dropdown
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get last month and year
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
		// Verify that level 2 user should be able to view ledger details for
		// the selected month
		if (storeLedgerDetailPage.verifyDataForSelectedMonth(month, year)) {
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2516",
					"level 2 user is able to view store ledger", "Pass");
		} else {
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2516",
					"sprint14_US1200_TC2516",
					"level 2 user is able to view store ledger", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2516");
		}
	}
	
	//TC2517 :To Verify if the level 2 user is restricted to restore purchase
	@Test()
	public void sprint14_US1200_TC2517() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// Verify that restore purchase button should not display
		if (!(Base.isElementDisplayed(purchasesPage.RestorePurchases_BT))) {
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2517",
					"Restore Purchase button should not display", "Pass");
		} else {
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2517",
					"sprint14_US1200_TC2517",
					"Restore Purchase button should not display", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2517");
		}
	}

	// TC2518 : To Verify if the level 2 user is able to enter raw waste
	@Test()
	public void sprint14_US1200_TC2518() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "1";
		String innerPackQuantity = "7";
		String looseUnitQuantity = "1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2518",
					"Level 2 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2518","sprint14_US1200_TC2518",
					"Level 2 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2518");
		}
	}
		
	// TC2519 : To Verify if the level 2 user is able to enter completed waste
	@Test()
	public void sprint14_US1200_TC2519() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Completed Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a Completed waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(samplewRINID,quantity);
		// Get total waste amount
		String wasteAmount = completedWastePage.getTotalWasteAmunt();
		// Submit the completed waste entry
		completedWastePage.Submit_BT.click();
		Thread.sleep(3000);
		// Verify that Completed waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2519",
					"Level 2 User should be able to enter completed waste","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2519","sprint14_US1200_TC2519",
					"Level 2 User should be able to enter completed waste","Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2519");
		}
	}
		
	// TC2520 : To Verify if the level 2 user is able to cancel raw waste entry
	@Test()
	public void sprint14_US1200_TC2520() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "2";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		// cancel the raw waste entry
		rawItemWastePage.Cancel_BT.click();
		// Click on Yes button
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
		// Verify that raw waste entry should not displayed in Promotion and waste page
		if (!promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2520",
					"Level 2 User should be able to cancel raw waste entry","Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2520","sprint14_US1200_TC2520",
					"Level 2 User should be able to cancel raw waste entry","Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2520");
		}
	}
		
	// TC2521 : To Verify if the level 2 user is able to cancel completed waste entry
	@Test()
	public void sprint14_US1200_TC2521() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "3";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Completed waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a Completed waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(samplewRINID,quantity);
		// Get the total Completed waste amount
		String wasteAmount = completedWastePage.getTotalWasteAmunt();
		// Cancel the Completed waste entry
		completedWastePage.Cancel_BT.click();
		// click on yes button
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT)).click();
		// Verify that Completed waste entry should not displayed in Promotion and waste page
		if (!promotionAndWastePage.isCompletedWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1200_TC2521",
					"Level 2 User should be able to cancel completed waste entry","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2521","sprint14_US1200_TC2521",
					"Level 2 User should be able to cancel completed waste entry","Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2521");
		}
	}
		
	//TC2522 To Verify if the level 2 user is restricted to enter raw promo
	@Test()
	public void sprint14_US1200_TC2522() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// Verify that 'Raw Promo' button is available on the page
		if (Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2522","sprint14_US1200_TC2522",
					"Raw Promo button should display on Promotion and Waste page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2522");
		} else {
			Reporter.reportPassResult(
					browser,"sprint14_US1200_TC2522",
					"Raw Promo button should display on Promotion and Waste page","Pass");

		}
	}
	
	//TC2523 To Verify if the level 2 user is able to transfer raw items in/out to other stores.
	@Test()
	public void sprint14_US1200_TC2523() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType ="in";
		String transferStoreNumber = "716";
		String caseQuantity ="1";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		transferLandingPage.selectTransferType(transferType)
				.selectLocationToTransfer(transferStoreNumber).insertAndAddDetailsToTransfer(samplewRINID, caseQuantity, innerPackQuantity,looseUnitQuantity);
		Thread.sleep(4000);
		//Verify the 'Cancel' button functionality
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.CanceTransferPopup_Yes_BT));
		transferLandingPage.CanceTransferPopup_Yes_BT.click();
		Thread.sleep(3000);
		if(!(Base.isElementDisplayed(transferLandingPage.CanceTransferPopup_Yes_BT)))
		{
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2523",
					"Cancel button functionality should work properly",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2523", "sprint14_US1200_TC2523", "Cancel button functionality should work properly", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2523");
		}
		
		//Verify the 'Submit' button functionality
		transferLandingPage.CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		transferLandingPage.selectTransferType(transferType)
				.selectLocationToTransfer(transferStoreNumber).insertAndAddDetailsToTransfer(samplewRINID, caseQuantity, innerPackQuantity,looseUnitQuantity);
		Thread.sleep(4000);
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT));
		Thread.sleep(4000);
		if(transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(), time, amount))
		{
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2523",
					"Submitt button functionality should be working properly",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2523", "sprint14_US1200_TC2523", "Submitt button functionality should be working properly", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2523");
		}
		
		
	}
	
	//TC2524 To Verify if the level 2 user is restricted to transfer raw items to office
	@Test()
	public void sprint14_US1200_TC2524() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		Select selectTransferType = new Select(transferLandingPage.TransferType_DD);
		System.out.println("first option is"+selectTransferType.getOptions().size());
		for(int i=0;i<selectTransferType.getOptions().size();i++)
		{
			String text=selectTransferType.getOptions().get(i).getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("Office Transfer"))
			{
				Reporter.reportTestFailure(browser, "sprint14_US1200_TC2524", "sprint14_US1200_TC2524", "Office transfer option should not be present", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2524");
				break;
			}
			else if(i==(selectTransferType.getOptions().size()-1))
			{
				Reporter.reportPassResult(browser, "sprint14_US1200_TC2524",
						"Office transfer option should not be present",
						"Pass");
				break;
			}
			else
			{
				continue;
			}
		}
		
		
	}

	//TC2525 To Verify if the level 2 user is able to view and print raw items transfer details.
	@Test()
	public void sprint14_US1200_TC2525() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage();
		//Click on View transfer button for the first record
		driver.findElements(By.xpath("//button[@id='htmlButton' and @value='View']")).get(0).click();
		if(Base.isElementDisplayed(transferLandingPage.ViewTransferItemsPopup_Print_BT))
		{
			Reporter.reportPassResult(browser, "sprint14_US1200_TC2525",
					"Print button should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(browser, "sprint14_US1200_TC2525", "sprint14_US1200_TC2525", "Print button should display", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2525");
		}
		
	}
	
	//TC2526 :To Verify if the level 2 user is able to view  variance stat
	@Test()
	public void sprint14_US1200_TC2526() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
		//Select yesterday date from calendar
		varianceStatPage.selectDateFromCalender(startDate);
		//Verify that daily stat should displayed for the selected date 
		if (varianceStatPage.verifyVarianceStatLoaded()) {
			Reporter.reportPassResult(
					browser, "sprint14_US1200_TC2526",
					"level 2 user is able to view daily variance stat", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1200_TC2526","sprint14_US1200_TC2526",
					"level 2 user is able to view daily variance stat", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2526_Condition1");
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
					browser,"sprint14_US1200_TC2526",
					"level 2 user is able to view Monthly variance stat",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2526","sprint14_US1200_TC2526",
					"level 2 user is able to view Monthly variance stat",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2526_Condition2");
		}
	}

	//TC2527 : To verify that the level 2 users are able to use all of the functionality on the Food over base page.
		@Test()
		public void sprint14_US1200_TC2527() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
			int random = (int )(Math.random() * 50 + 1);
			String newtargetPercentValue = String.valueOf(random);
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Food OverBase page
			FoodOverBasePage foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToFoodOverBasePage();
			String comment = "Test Automation "+ Base.randomNumberFiveDigit();
			//Click on the post comment button for current month and save a comment
			foodOverBasePage.postCommentForCurrentMonth(comment);
			//Verify that new comment is saved 
			foodOverBasePage.PostCommentForCurrentMonth_BT.click();
			if (foodOverBasePage.CommentBox_TB.getAttribute("value").equals(comment)) {
				Reporter.reportPassResult(
						browser,"sprint14_US1200_TC2527",
						"Level 2 user should be able to save a comment in food over base page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"sprint14_US1200_TC2527_Condition2","sprint14_US1200_TC2527",
						"Level 2 user should be able to save a comment in food over base page",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2527_Condition2");
			}
			Thread.sleep(2000);
			foodOverBasePage.SaveComment_BT.click();
			Thread.sleep(2000);
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
						browser, "sprint14_US1200_TC2527",
						"Level 2 user should be able to edit targetPercent value for current month in FoodOverBase Page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2527","sprint14_US1200_TC2527",
						"Level 2 user should be able to edit targetPercent value for current month in FoodOverBase Page",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2527_Condition1");
			}
			
		}
		
	//TC2528 To verify if the level 2 user is able to view the raw item activity details.
	@Test()
	public void sprint14_US1200_TC2528() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String wrinId= GlobalVariable.rawItemActivityWrin;
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
					browser,"sprint14_US1200_TC2528",
					"User should be able to view the details of Raw Item Activity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2528","sprint14_US1200_TC2528",
					"User should be able to view the details of Raw Item Activity",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2528");
		}
	}
	
	//TC2529: To verify if the level 2 user is able to view the details of waste/promo on the raw item activity view page
	@Test()
	public void sprint14_US1200_TC2529() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
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
					browser,"sprint14_US1200_TC2529",
					"Level 2 user should be able to view the details of waste/promo on the raw item activity view page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2529","sprint14_US1200_TC2529",
					"Level 2 user should be able to view the details of waste/promo on the raw item activity view page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2529");
		}
	}
	
	// TC2531: verify if the level 2 user is not able to modify any raw item information
	@Test()
	public void sprint14_US1200_TC2531() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemInformationPage rawItemInformationPage;
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String wrinId01 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		rawItemInformationPage = PageFactory.initElements(driver,
				RawItemInformationPage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemActivityPage().searchAndSelectWRINID(wrinId01);
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
		// Verify that Manual Purchase check box and ListType drop down is disabled for Level 2 user
		if (rawItemInformationPage.ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemInformationPage.ListType_DD.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser,"sprint14_US1200_TC2531",
					"Level 2 user can VIEW-ONLY the Raw Item Information page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2531","sprint14_US1200_TC2531",
					"Level 2 user can VIEW-ONLY the Raw Item Information page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2531");
		}
	}
	
		//TC2533: To verify if the level 2 user is able to add a custom list
		@Test()
		public void sprint14_US1200_TC2533() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
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
						browser, "sprint14_US1200_TC2533",
						"User should be able to add a custom list", "Pass");

			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2533","sprint14_US1200_TC2533",
						"User should be able to add a custom list", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2533");
			}
		}
		
		//TC2534: To verify if the level 2 user is able to cancel a custom list add
		@Test()
		public void sprint14_US1200_TC2534() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
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
						browser, "sprint14_US1200_TC2534",
						"User should be  able to cancel a custom list add", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2534","sprint14_US1200_TC2534",
						"User should be  able to cancel a custom list add", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2534");
			}
		}
	
		//TC2535: To verify if the level 2 user is able to delete a custom list
		@Test()
		public void sprint14_US1200_TC2535() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
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
				Reporter.reportPassResult(browser, "sprint14_US1200_TC2535",
						"level 2 user should be able to delete a custom list", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2535","sprint14_US1200_TC2535",
						"level 2 user should be able to delete a custom list", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2535");
			}
		}
	
		//TC2536: To verify if the level 2 user is restricted to restore a custom list
		@Test()
		public void sprint14_US1200_TC2536() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Go to Custom raw Item list page
			CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToCustomRawItemListsPage();
			
			//Verify Restore list button should not  display
			
			Thread.sleep(7000);
			if (!(Base.isElementDisplayed(customRawItemListsPage.RestoreLists_BT))) {
				Reporter.reportPassResult(
						browser, "sprint14_US1200_TC2536",
						"level 2 user should be able to restore a custom list",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2536","sprint14_US1200_TC2536",
						"level 2 user should be able to restore a custom list",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2536");
			}
		}
	
		// TC2537:To verify if the level 2 user is not able to  view the manual vendor page
		@Test()
		public void sprint14_US1200_TC2537() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String userId = LoginTestData.level2_SSO_UserId;
			String password = LoginTestData.level2_SSO_Password;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Manual Vendor page
			homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement();
			 wait.until(ExpectedConditions.visibilityOf(homePage.OtherInventoryFunctions_BT));
			 homePage.OtherInventoryFunctions_BT.click();
			if (!Base.isElementDisplayed(homePage.ManualVendors_BT)) {
				Reporter.reportPassResult(
						browser, "sprint14_US1200_TC2537",
						"level 2 user should be able to only view the manual vendor page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "sprint14_US1200_TC2537","sprint14_US1200_TC2537",
						"level 2 user should be able to only view the manual vendor page",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2537");
			}
		}
	
		//TC2538 : To verify if the level 2 user is able to only view the menu item activity
		@Test()
		public void sprint14_US1200_TC2538() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
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
						browser,"sprint14_US1200_TC2538",
						"level 2 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"sprint14_US1200_TC2538","sprint14_US1200_TC2538",
						"level 2 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2538");
			}
		}
	
		//TC2539 : To verify if the level 1 user is able to only view the menu item information
		@Test()
		public void sprint14_US1200_TC2539() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
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
						browser,"sprint14_US1200_TC2539",
						"level 2 user should be able to view item page with the information of the menu item",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,"sprint14_US1200_TC2539","sprint14_US1200_TC2539",
						"level 2 user should be able to view item page with the information of the menu item",
						"Fail");
				AbstractTest.takeSnapShot("sprint14_US1200_TC2539");
			}
		}
		
	//TC2540:To verify if the level 2 users are restricted from all Inventory Restaurant setting functionality
	@Test()
	public void sprint14_US1200_TC2540() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		homePage.selectUserWithSSOLogin(userId, password);
		if (!Base.isElementDisplayed(homePage.StoreSetting_BT)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1200_TC2540",
					"Level 2 User should not be able to view Inventory Restaurant setting","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1200_TC2540","sprint14_US1200_TC2540",
					"Level 2 User should not be able to view Inventory Restaurant setting","Fail");
			AbstractTest.takeSnapShot("sprint14_US1200_TC2540");
		}
	}
	
}
