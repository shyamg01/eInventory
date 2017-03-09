package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
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
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.AbstractTest;

public class US189_PurchasesLandingPage extends AbstractTest {
	
	//TC471 : Verify that user is able to enter a new Manual Purchase from Purchase landing page.
	@Test()
	public void purchaseBundle_US189_TC471() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC471";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
		
	//TC472 : Verify that user is able to view the Pending Purchases list on Purchases landing page.
	@Test()
	public void purchaseBundle_US189_TC472() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC472";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String todayDate=Base.returnTodayDate();
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		if(GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_DeliveryDate_Header, "purchasesPage.ApprovePendingTable_DeliveryDate_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Status_Header, "purchasesPage.ApprovePendingTable_Status_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Vendor_Header, "purchasesPage.ApprovePendingTable_Vendor_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Invoice_Header, "purchasesPage.ApprovePendingTable_Invoice_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_InvoiceTotal_Header, "purchasesPage.ApprovePendingTable_InvoiceTotal_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_AmountOff_Header, "purchasesPage.ApprovePendingTable_AmountOff_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_AutoApprove_Header, "purchasesPage.ApprovePendingTable_AutoApprove_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Type_Header,"purchasesPage.ApprovePendingTable_Type_Header")) {
			Reporter.reportPassResult(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if(Base.isElementDisplayed(By.xpath("//table[@id='eb_purchase_table']/tbody/tr[td[1]/span[text()='"+todayDate+"'] and td[3]/span[text()='"+vendorName+"']]")))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the invoice with correct vendor and delivery date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the invoice with correct vendor and delivery date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(7000);
		//Verify descending order of records with dates
		List<WebElement> we= driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[1]/span[2]"));
		LinkedList<Date> recordDate=new LinkedList<Date>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Size is"+we.size());
		for (int i = 0; i <= we.size() - 1; i++) {
			System.out.println(we.get(i).getText());
			String date = we.get(i).getText();
			recordDate.add(df.parse(date));
			System.out.println("After parse" + df.parse(date));
			if (i == 0) {
				// Do Nothing
			} else {
				result.add(recordDate.get(i).compareTo(recordDate.get(i - 1)));
				System.out.println(i + "record date" + recordDate.get(i));
				System.out.println(i - 1 + "record date"+ recordDate.get(i - 1));
				System.out.println("Result is" + result.get(i - 1));
				if ((result.get(i - 1) == 0 || result.get(i - 1) < 1)) {
					if (i == (we.size() - 1)) {
						Reporter.reportPassResult(browser,
								"Record should display in desscending order",
								"Pass");
					} else {
						continue;
					}
				} else {
					Reporter.reportTestFailure(browser,
							"Record should display in desscending order",
							"Fail");
					AbstractTest.takeSnapShot();
					break;
				}
			}
		}
	}
	
	//TC473 : Verify that Purchase History List is available on the Purchases Landing Page .
	@Test()
	public void purchaseBundle_US189_TC473() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC473";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		Thread.sleep(3000);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(5000);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if (GenericMethods.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label,"purchasesPage.ViewInvoice_PopUp_Label")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
	
	//TC474 : Verify that User is able to view the Posted  Purchases list .
	@Test()
	public void purchaseBundle_US189_TC474() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC474";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		Thread.sleep(7000);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(5000);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber, startDate);
		if (GenericMethods.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label,"purchasesPage.ViewInvoice_PopUp_Label")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		//Verify that columns "Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type" are displaying.
		if(purchasesPage.ViewHistory_DeliveryDate_Column_Header.getText().equalsIgnoreCase("Delivery Date") &&
				purchasesPage.ViewHistory_Vendor_Column_Header.getText().equalsIgnoreCase("Vendor") &&
				purchasesPage.ViewHistory_Invoice_Column_Header.getText().equalsIgnoreCase("Invoice") &&
				purchasesPage.ViewHistory_InvoiceTotal_Column_Header.getText().equalsIgnoreCase("Invoice Total") &&
				purchasesPage.ViewHistory_AmountOff_Column_Header.getText().equalsIgnoreCase("Amount Off") &&
				purchasesPage.ViewHistory_AutoApprove_Column_Header.getText().equalsIgnoreCase("Auto Approve") && 
				purchasesPage.ViewHistory_Type_Column_Header.getText().equalsIgnoreCase("Type")) {
			Reporter.reportPassResult(
					browser,
					"All the column headers should display on View History Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"All the column headers should display on View History Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}	
	
	//TC475 :  	Verify that User is able to view the Posted  Purchases Details .
	@Test()
	public void purchaseBundle_US189_TC475() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC475";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(5000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		// Verify that columns "Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type" are displaying.
		if (purchasesPage.ViewHistory_DeliveryDate_Column_Header.getText().equalsIgnoreCase("Delivery Date")
				&& purchasesPage.ViewHistory_Vendor_Column_Header.getText().equalsIgnoreCase("Vendor")
				&& purchasesPage.ViewHistory_Invoice_Column_Header.getText().equalsIgnoreCase("Invoice")
				&& purchasesPage.ViewHistory_InvoiceTotal_Column_Header.getText().equalsIgnoreCase("Invoice Total")
				&& purchasesPage.ViewHistory_AmountOff_Column_Header.getText().equalsIgnoreCase("Amount Off")
				&& purchasesPage.ViewHistory_AutoApprove_Column_Header.getText().equalsIgnoreCase("Auto Approve")
				&& purchasesPage.ViewHistory_Type_Column_Header.getText().equalsIgnoreCase("Type")) {
			Reporter.reportPassResult(
					browser,
					"All the column headers should display on View History Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"All the column headers should display on View History Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		System.out.println(driver.findElement(By.xpath("//div[@id='outside_table']/div/div/span[contains(.,'Invoice:')]/span")).getText());
		if(driver.findElement(By.xpath("//div[@id='outside_table']/div/div/span[contains(.,'Invoice:')]/span")).getText().equalsIgnoreCase(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice detail on View Invoice page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice detail on View Invoice page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
	
	//TC3570 : Verify, "The historical purchases listed will be in chronological order (most recent on top).
	@Test()
	public void purchaseBundle_US189_TC3570() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC3570";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String startDate=GlobalVariable.startDate;
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(4000);
		purchasesPage.selectStartDate(startDate);
		Thread.sleep(2000);
		purchasesPage.ViewHistory_Vendor_DD.click();
		Thread.sleep(2000);
		purchasesPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(10000);
		List<WebElement> we= driver.findElements(By.xpath("//div[@id='posted_div']/table[@id='eb_purchase_table']/tbody/tr/td[1]/span[2]"));
		LinkedList<Date> recordDate=new LinkedList<Date>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Size is"+we.size());
		for(int i=0;i<=we.size()-1;i++)
		{
			System.out.println(we.get(i).getText());
			String date1=we.get(i).getText();
			recordDate.add(df.parse(date1));
			System.out.println("After parse"+df.parse(date1));
			if(i==0)
			{
				//Do Nothing
			}
			else
			{
				 result.add(recordDate.get(i).compareTo(recordDate.get(i-1)));
				 System.out.println(i+"record date"+recordDate.get(i));
				 System.out.println(i-1+"record date"+recordDate.get(i-1));
				 System.out.println("Result is"+result.get(i-1));
				if ((result.get(i - 1) == 0 || result.get(i - 1) < 1)) {
					if (i == we.size() - 1) {
						Reporter.reportPassResult(browser,
								"Record should display in descending  order",
								"Pass");

					} else {
						continue;
					}
				} else {
					Reporter.reportTestFailure(browser,
							"Record should display in descending  order",
							"Fail");
					AbstractTest.takeSnapShot();
				}
			}
		}

	}
	
	//TC3571 : Verify,"The default date range will have a start date of the first of the current month and the end date will be the current date at purchase history page".
	@Test()
	public void purchaseBundle_US189_TC3571() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC3571";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String todayDate=Base.returnTodayDate();
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(4000);
		purchasesPage.ViewHistory_StartDate_TB.click();		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][1]/div[@class='xdsoft_datepicker active']")));
		String month=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][1]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_month']/span")).getText().trim();
		String year=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][1]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_year']/span")).getText().trim();
		String date=driver.findElement(By.xpath("//div[@class='xdsoft_datepicker active']/div[@class='xdsoft_calendar']/table/tbody/tr/td[contains(@class,'_current xdsoft_weekend')]")).getText().trim();
		System.out.println("date"+date);
		System.out.println("Month"+month);
		System.out.println("Year"+year);
		purchasesPage.ViewHistory_StartDate_TB.click();	
		Thread.sleep(2000);
		purchasesPage.ViewHistory_EndDate_TB.click();		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']")));
		String month1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_month']/span")).getText().trim();
		String year1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_year']/span")).getText().trim();
		String date1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']/div[@class='xdsoft_calendar']/table/tbody/tr/td[contains(@class,'_current xdsoft_today xdsoft_weekend')]")).getText().trim();
		System.out.println("date"+date1);
		System.out.println("Month"+month1);
		System.out.println("Year"+year1);
		String dateExp=Integer.toString(Base.getDayFromDate(todayDate));		
		String monthExp=Base.getMonthName(Base.getCorrectMonthFromDate(todayDate));
		String yearexp=Integer.toString(Base.getYearFromDate(todayDate));
		System.out.println("dateExp"+dateExp);
		System.out.println("monthExp"+monthExp);
		System.out.println("yearexp"+yearexp);
		if(month.equalsIgnoreCase(monthExp) && date.equalsIgnoreCase("1") && year.equalsIgnoreCase(yearexp) && date1.equalsIgnoreCase(dateExp) && month1.equalsIgnoreCase(monthExp) &&  year1.equalsIgnoreCase(yearexp))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view start date as first date of the current month and end date as current date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view start date as first date of the current month and end date as current date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3572 : Verify, "the default selection for this filter will be "All" to select vendor name".
	@Test()
	public void purchaseBundle_US189_TC3572() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US189_TC3572";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(7000);
		String defaultValue=driver.findElement(By.xpath("//span[@id='eb_dd_display']")).getText().trim();
		System.out.println(defaultValue);
		if (defaultValue.equalsIgnoreCase("All")) {
			Reporter.reportPassResult(browser,
					"Default view should be 'ALL' for the vendor drop down",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Default view should be 'ALL' for the vendor drop down",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
