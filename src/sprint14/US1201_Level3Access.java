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

public class US1201_Level3Access extends AbstractTest
{
	//TC2473 :  To verify if the level 3 user is able to create daily inventory
	@Test()
	public void sprint14_US1201_TC2473() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
					/** Variable Section : **/
					String userId = LoginTestData.level3_SSO_UserId;
					String password = LoginTestData.level3_SSO_Password;
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
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
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
					
						Reporter.reportPassResult(browser, "sprint14_US1201_TC2473",
								"Physical Inventory should be created successfully",
								"Pass");
					}
					else
					{
						Reporter.reportTestFailure(browser, "sprint14_US1201_TC2473_Condition1", "sprint14_US1201_TC2473", "Physical Inventory should be created successfully", "Fail");
						AbstractTest.takeSnapShot("sprint14_US1201_TC2473_Condition1");
					}
					
					//Click on View button for the newly created inventory
					driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
					if(Base.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title))
					{
						Reporter.reportPassResult(browser, "sprint14_US1201_TC2473",
								"User should be able to view the created Physical Inventory",
								"Pass");
					
					}
					else
					{
						Reporter.reportTestFailure(browser, "sprint14_US1201_TC2473_Condition2", "sprint14_US1201_TC2473", "User should be able to view the created Physical Inventory", "Fail");
						AbstractTest.takeSnapShot("sprint14_US1201_TC2473_Condition2");
					}
					
		}
	
	//TC2475 To verify if the level 3 user is able to create Weekly inventory
	@Test()
	public void sprint14_US1201_TC2475() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
			/** Variable Section : **/
			String password = LoginTestData.level3_SSO_Password;
			String userId = LoginTestData.level3_SSO_UserId;
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
			
				Reporter.reportPassResult(browser, "sprint14_US1201_TC2475",
						"Physical Inventory should be created successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1201_TC2475_Condition1", "sprint14_US1201_TC2475", "Physical Inventory should be created successfully", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1201_TC2475_Condition1");
			}
			
			//Click on View button for the newly created inventory
			driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
			if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventoryList_Title))
			{
				Reporter.reportPassResult(browser, "sprint14_US1201_TC2475",
						"User should be able to view the created Physical Inventory",
						"Pass");
			
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1201_TC2475_Condition2", "sprint14_US1201_TC2475", "User should be able to view the created Physical Inventory", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1201_TC2475_Condition2");
			}
		}
	
	//TC2476 To verify if the level 3 user is able to create monthly inventory
	@Test()
	public void sprint14_US1201_TC2476() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
			/** Variable Section : **/
			String password = LoginTestData.level3_SSO_Password;
			String userId = LoginTestData.level3_SSO_UserId;
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
			
				Reporter.reportPassResult(browser, "sprint14_US1201_TC2476",
						"Physical Inventory should be created successfully",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1201_TC2476_Condition1", "sprint14_US1201_TC2476", "Physical Inventory should be created successfully", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1201_TC2476_Condition1");
			}
			
			//Click on View button for the newly created inventory
			driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
			if(Base.isElementDisplayed(physicalInventoryPage.MonthlyInventoryList_Title))
			{
				Reporter.reportPassResult(browser, "sprint14_US1201_TC2476",
						"User should be able to view the created Physical Inventory",
						"Pass");
			
			}
			else
			{
				Reporter.reportTestFailure(browser, "sprint14_US1201_TC2476_Condition2", "sprint14_US1201_TC2476", "User should be able to view the created Physical Inventory", "Fail");
				AbstractTest.takeSnapShot("sprint14_US1201_TC2476_Condition2");
			}
		}
	
		//TC2477 : To Verify if the level 3 user is able to enter a manual purchase
	@Test()
	public void sprint14_US1201_TC2477() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceId)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2477",
					"level 3 user should be able to enter a manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2477","sprint14_US1201_TC2477",
					"level 3 user should be able to enter a manual purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2477");
		}
	}
	
	//TC2479 : To Verify if the level 3 user is able to edit and approve a pending purchase.
	@Test()
	public void sprint14_US1201_TC2479() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2479",
					"level 3 user should be able to approve a pending purchase.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2479","sprint14_US1201_TC2479",
					"level 3 user should be able to approve a pending purchase.", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2479");
		}
	}
	
	// TC2480 :To Verify if the level 3 user is able to delete a pending purchase.
	@Test()
	public void sprint14_US1201_TC2480() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor =GlobalVariable.vendorName;
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
					browser, "sprint14_US1201_TC2480",
					"level 3 user is able to delete a purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2480","sprint14_US1201_TC2480",
					"level 3 user is able to delete a purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2480");
		}
	}
	
	// TC2481 : To Verify if the level 1 user is able to view purchase history 
	@Test()
	public void sprint14_US1201_TC2481() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2481",
					"level 3 user is able to view Purchase History", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2481","sprint14_US1201_TC2481",
					"level 3 user is able to view Purchase History", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2481");
		}
	}
	
	// TC2482 : To Verify if the level 3 user is able to view store ledger
	@Test()
	public void sprint14_US1201_TC2482() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2482",
					"level 3 user is able to view store ledger", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2482","sprint14_US1201_TC2482",
					"level 3 user is able to view store ledger", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2482");
		}
	}
	
	//TC2483 :To Verify if the level 3 user is restricted to restore purchase
	@Test()
	public void sprint14_US1201_TC2483() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level1UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to purchase landing page
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2483","sprint14_US1201_TC2483",
					"level 3 user is restricted to restore purchase", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2483");
		} else {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2483",
					"level 3 user is restricted to restore purchase", "Pass");
		}
	}
	
	//TC2485 : To Verify if the level 3 user is able to enter raw waste
	@Test()
	public void sprint14_US1201_TC2485() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "1";
		String innerPackQuantity = "1";
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
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2485",
					"Level 3 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2485","sprint14_US1201_TC2485",
					"Level 3 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2485");
		}
	}
	
	// TC2486 : To Verify if the level 3 user is able to cancel raw waste entry
	@Test()
	public void sprint14_US1201_TC2486() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2486",
					"Level 3 User should be able to cancel raw waste entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2486","sprint14_US1201_TC2486",
					"Level 3 User should be able to cancel raw waste entry", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2486");
		}
	}

	//TC2488 : To Verify if the level 3 user is able to cancel completed waste entry
	@Test()
	public void sprint14_US1201_TC2488() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2488",
					"Level 3 User should be able to cancel completed waste entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2488","sprint14_US1201_TC2488",
					"Level 3 User should be able to cancel completed waste entry", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2488");
		}
	}
	
	//TC2489 : To Verify if the level 3 user is restricted to enter raw promo
	@Test()
	public void sprint14_US1201_TC2489() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// Verify that raw promo button should be displayed to level 3 user
		if (!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2489",
					"Level 1 User should be restricted to enter raw promo",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2489","sprint14_US1201_TC2489",
					"Level 1 User should be restricted to enter raw promo",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2489");
		}
	}
	
	//TC2491 : To Verify if the level 3 user is able to transfer raw items in/out to other stores.
	@Test()
	public void sprint14_US1201_TC2491() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		HSSFSheet transferLandingPageSheet = ReadTestData.getTestDataSheet("sprint14_US1201_TC2491", "Object1");
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
		System.out.println("amount "+amount);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		//Verify that transfer entries should displayed in Transfer landing page
		if (result & transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(), time, amount)) {
			Reporter.reportPassResult(
					browser,"sprint14_US1201_TC2491",
					"Level 3 User should be able to submit in/out transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2491","sprint14_US1201_TC2491",
					"Level 3 User should be able to submit in/out transfer",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2491_Condition1");
		}
		int caseQty2 = Integer.parseInt(caseQuantity) + 1;
		int innerPackQty2 = Integer.parseInt(innerPackQuantity) + 1;
		int looseUnitsQty2 = Integer.parseInt(looseUnitQuantity) + 1;
		//click on create new transfer button
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Get the time of transfer
		String time2=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID,
				String.valueOf(caseQty2), String.valueOf(innerPackQty2),String.valueOf(looseUnitsQty2));
		String amount2 = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("amount "+amount2);
		//cancel the transfer
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_Warning_Message_Yes_BT)).click();
		Thread.sleep(2000);
		// Verify that transfer entries should not displayed in Transfer landing page
		if (!transferLandingPage.verifyTransferPlaced(Base.returnTodayDate(),time2, amount2)) {
			Reporter.reportPassResult(browser, "sprint14_US1201_TC2491",
					"Level 3 User should be able to cancel in/out transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "sprint14_US1201_TC2491","sprint14_US1201_TC2491",
					"Level 3 User should be able to cancel in/out transfer",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2491_Condition2");
		}
	}
	
	//TC2493 : To Verify if the level 3 user is restricted to transfer raw items to office
	@Test()
	public void sprint14_US1201_TC2493() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = "office";
		String caseQuantity = "3";
		String innerPackQuantity ="5";
		String looseUnitQuantity ="1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		if (Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)) {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2493","sprint14_US1201_TC2493",
					"level 3 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2493");
		} else {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2493",
					"level 3 user is restricted to office transfer", "Pass");
			}
	}
	
	//TC2494 : To Verify if the level 3 user is able to view and print raw items transfer details
	@Test()
	public void sprint14_US1201_TC2494() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		HSSFSheet transferLandingPageSheet = ReadTestData.getTestDataSheet("sprint14_US1201_TC2494", "Object1");
		String transferStoreNumber = ReadTestData.getTestData(transferLandingPageSheet,"InputNationalStoreNumber");
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
		//View the transfer entry
		transferLandingPage.viewTransfer(Base.returnTodayDate(), time, amount);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value));
		//Verify that user is able to view the transfer entry details
		if (transferLandingPage.ViewTransferItemsPopup_GrandTotal_Value.getText().equals(amount)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2494",
					"level 3 user is able to view raw items transfer details", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2494","sprint14_US1201_TC2494",
					"level 3 user is able to view raw items transfer details", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2494");
		}
	}
	
	//TC2495 :To Verify if the level 3 user is able to view  variance stat
	@Test()
	public void sprint14_US1201_TC2495() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2495",
					"level 3 user is able to view daily variance stat", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2495","sprint14_US1201_TC2495",
					"level 3 user is able to view daily variance stat", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2495_Condition1");
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
					browser,"sprint14_US1201_TC2495",
					"level 3 user is able to view Monthly variance stat",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2495","sprint14_US1201_TC2495",
					"level 3 user is able to view Monthly variance stat",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2495_Condition2");
		}
	}
	
	//TC2496 : To verify that the level 3 users are able to use all of the functionality on the Food over base page.
	@Test()
	public void sprint14_US1201_TC2496() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//** Variable Section : **//*
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		int random = (int )(Math.random() * 50 + 1);
		String newtargetPercentValue = String.valueOf(random);
		//***********************************//*
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
					browser,"sprint14_US1201_TC2496",
					"Level 3 user should be able to save a comment in food over base page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2496_Condition1","sprint14_US1201_TC2496",
					"Level 3 user should be able to save a comment in food over base page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2496_Condition1");
		}
		foodOverBasePage.PostCommentPopUp_Close_BT.click();
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
					browser, "sprint14_US1201_TC2496",
					"Level 3 user should be able to edit targetPercent value for current month in FoodOverBase Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2496","sprint14_US1201_TC2496",
					"Level 3 user should be able to edit targetPercent value for current month in FoodOverBase Page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2496_Condition2");
		}
		
	}
	
	//TC2497: To verify if the level 3 user is able to view the raw item activity details
	@Test()
	public void sprint14_US1201_TC2497() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String wrinId = GlobalVariable.rawItemActivityWrin;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement()
				.goToRawItemActivityPage();
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
		//Search for the raw item
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.Information_BT));
		// Verify that user is able to view Raw item Activity details
		if (rawItemActivityPage.rawItemDetailList.size() > 0) {
			Reporter.reportPassResult(
					browser,"sprint14_US1201_TC2497",
					"Level 3 user should be able to  view the raw item activity deatails",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2497","sprint14_US1201_TC2497",
					"Level 3 user should be able to  view the raw item activity deatails",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2497");
		}
	}
	
	// TC2498: verify if the level 3 user is able to view the details of  waste/promo on the raw item activity view page
	@Test()
	public void sprint14_US1201_TC2498() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
		System.out.println("startDate "+startDate);
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
		//Search for the raw item
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.Information_BT));
		// Verify that raw item activity details are displayed for the selected raw item
		if (rawItemActivityPage.rawItemDetailList.size() > 0 & rawItemActivityPage.rawItemEventDetailList.size() > 0) {
			Reporter.reportPassResult(
					browser,"sprint14_US1201_TC2498",
					"Level 3 user should be able to view the details of waste/promo on the raw item activity view page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2498","sprint14_US1201_TC2498",
					"Level 3 user should be able to view the details of waste/promo on the raw item activity view page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2498");
		}
	}
	
	//TC2499: verify if the level 3 user is not able to modify any raw item information
	@Test()
	public void sprint14_US1201_TC2499() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemInformationPage rawItemInformationPage; 
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String wrinId01=GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		rawItemInformationPage = PageFactory.initElements(driver, RawItemInformationPage.class);
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
		//Verify that Manual Purchase check box and ListType drop down is disabled for Level 3 user
		if(rawItemInformationPage.ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemInformationPage.ListType_DD.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,"sprint14_US1201_TC2499",
					"Level 3 user can VIEW-ONLY the Raw Item Information page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2499","sprint14_US1201_TC2499",
					"Level 3 user can VIEW-ONLY the Raw Item Information page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2499");
		}
	}
	
	//TC2500: To verify if the level 3 user is able to add a custom list
	@Test()
	public void sprint14_US1201_TC2500() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2500",
					"Level 3 User should be able to add a custom list", "Pass");

		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2500","sprint14_US1201_TC2500",
					"Level 3 User should be able to add a custom list", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2500");
		}
	}
	
	//TC2501: To verify if the level 3 user is able to cancel a custom list add
	@Test()
	public void sprint14_US1201_TC2501() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser, "sprint14_US1201_TC2501",
					"Level 3 User should be  able to cancel a custom list add", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2501","sprint14_US1201_TC2501",
					"Level 3 User should be  able to cancel a custom list add", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2501");
		}
	}
	
	//TC2502: To verify if the level 3 user is able to delete a custom list
	@Test()
	public void sprint14_US1201_TC2502() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
			Reporter.reportPassResult(browser, "sprint14_US1201_TC2502",
					"level 3 user should be able to delete a custom list", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2502","sprint14_US1201_TC2502",
					"level 3 user should be able to delete a custom list", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2502");
		}
	}
	
	//TC2503 : To verify if the level 3 user is restricted to restore a custom list
	@Test()
	public void sprint14_US1201_TC2503() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
		//Verify that user is not able to see RestoreLists button in Custom raw Item list page
		if (!Base.isElementDisplayed(customRawItemListsPage.RestoreLists_BT)) {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2503",
					"level 3 user should be restricted to restore a custom list",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2503","sprint14_US1201_TC2503",
					"level 3 user should be restricted to restore a custom list",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2503");
		}
	}
	
	//TC2504: To verify that the level 3 users are restricted to the Manual Vendor page.
	@Test()
	public void sprint14_US1201_TC2504() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to inventory management
		homePage.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement();
		//click on other inventory functions link
		wait.until(ExpectedConditions.visibilityOf(homePage.OtherInventoryFunctions_BT)).click();
		//verify that user should not be able to access manual vendor page
		if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2504","sprint14_US1201_TC2504",
					"level 3 user should be restricted to view the manual vendor page",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2504");
		} else {
			Reporter.reportPassResult(
					browser,"sprint14_US1201_TC2504",
					"level 3 user should be restricted to view the manual vendor page","Pass");
		}
	}
	
	//TC2505 : To verify if the level 3 user is able to only view the menu item activity
	@Test()
	public void sprint14_US1201_TC2505() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser,"sprint14_US1201_TC2505",
					"level 3 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2505","sprint14_US1201_TC2505",
					"level 3 user should be able to view  the list of menu item activity for the selected menu item, date range and time range",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2505");
		}
	}
	
	//TC2506 : To verify if the level 3 user is able to only view the menu item information
	@Test()
	public void sprint14_US1201_TC2506() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
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
					browser,"sprint14_US1201_TC2506",
					"level 3 user should be able to only view the menu item information",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint14_US1201_TC2506","sprint14_US1201_TC2506",
					"level 3 user should be able to only view the menu item information",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2506");
		}
	}
	
	//TC2507: To verify if the level 3 users are restricted from all Inventory Restaurant setting functionality
	@Test()
	public void sprint14_US1201_TC2507() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.StoreSetting_BT)) {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2507","sprint14_US1201_TC2507",
					"Level 3 User should be restricted from all Inventory Restaurant setting functionality",
					"Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2507");
		} else {
			Reporter.reportPassResult(
					browser, "sprint14_US1201_TC2507",
					"Level 3 User should be restricted from all Inventory Restaurant setting functionality",
					"Pass");
		}
	}
	
	// TC2541 : To Verify if the level 3 user is able to enter completed waste
	@Test()
	public void sprint14_US1201_TC2541() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "7";
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
					browser, "sprint14_US1201_TC2541",
					"Level 3 User should be able to enter completed waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint14_US1201_TC2541","sprint14_US1201_TC2541",
					"Level 3 User should be able to enter completed waste", "Fail");
			AbstractTest.takeSnapShot("sprint14_US1201_TC2541");
		}
	}
	
}
