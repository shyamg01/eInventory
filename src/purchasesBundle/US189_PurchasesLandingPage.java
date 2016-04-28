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
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import sprint2.AbstractTest;

public class US189_PurchasesLandingPage extends AbstractTest
{	
	
	//TC469 :  Verify that the User is able to view all  the pending purchase  on the Purchases Landing page
	
	@Test()
	public void purchasesBundle_US189_TC3352() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
	/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
	/***********************************/
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	ManualInvoiceNewPage manualInvoiceNewPage= PageFactory.initElements(driver, ManualInvoiceNewPage.class);
	PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
			.navigateToInventoryManagement().goToPurchaseLandingPage();
	wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));	
	
	if (Base.isElementDisplayed(purchasesPage.ApprovePendingTable_DeliveryDate_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Status_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Vendor_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Invoice_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_InvoiceTotal_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AmountOff_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AutoApprove_Header)
			& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Type_Header)) 
	{
		Reporter.reportPassResult(
				browser,"purchasesBundle_US189_TC3352",
				"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
				"Pass");
	} else {
		Reporter.reportTestFailure(
				browser,"purchasesBundle_US189_TC3352_Condition1","purchasesBundle_US189_TC3352",
				"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
				"Fail");
		AbstractTest.takeSnapShot("purchasesBundle_US189_TC3352_Condition1");
	}
	
	//Click on Approve button for the manual Invoice
	Thread.sleep(3000);
	manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
	Thread.sleep(6000);
	purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
	wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
	if(Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_Lable))
	{
		Reporter.reportPassResult(
				browser,"purchasesBundle_US189_TC3352",
				"User should be able to click on Approve button for the invoice",
				"Pass");
	}
	else
	{
		Reporter.reportTestFailure(
				browser,"purchasesBundle_US189_TC3352_Condition2","purchasesBundle_US189_TC3352",
				"User should be able to click on Approve button for the invoice",
				"Fail");
		AbstractTest.takeSnapShot("purchasesBundle_US189_TC3352_Condition2");
	}
	
}	
	//TC471 : Verify that user is able to enter a new Manual Purchase from Purchase landing page.
	
	@Test()
	public void purchaseBundle_US189_TC471() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if(purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC471",
					"User shoudl be able to create the manual purchase",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC471","purchaseBundle_US189_TC471",
					"User shoudl be able to create the manual purchase",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC471");
		}

	}
		
	//TC472 : Verify that user is able to view the Pending Purchases list on Purchases landing page.
	@Test()
	public void purchaseBundle_US189_TC472() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String todayDate=Base.returnTodayDate();
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		if(Base.isElementDisplayed(purchasesPage.ApprovePendingTable_DeliveryDate_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Status_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Vendor_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Invoice_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_InvoiceTotal_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AmountOff_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_AutoApprove_Header)
				& Base.isElementDisplayed(purchasesPage.ApprovePendingTable_Type_Header)) 
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC472",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC472_Condition1","purchaseBundle_US189_TC472",
					"table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC472_Condition1");
		}		
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		if(Base.isElementDisplayed(By.xpath("//table[@id='eb_purchase_table']/tbody/tr[td[1]/span[text()='"+todayDate+"'] and td[3]/span[text()='"+vendorName+"']]")))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC472",
					"User should be able to view the invoice with correct vendor and delivery date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC472_Condition2","purchaseBundle_US189_TC472",
					"User should be able to view the invoice with correct vendor and delivery date",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC472_Condition2");
		}
		Thread.sleep(7000);
		//Verify ascending order of records with dates
		List<WebElement> we= driver.findElements(By.xpath("//table[@id='eb_purchase_table']/tbody/tr/td[1]/span[2]"));
		LinkedList<Date> recordDate=new LinkedList<Date>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Size is"+we.size());
		for(int i=0;i<=we.size()-1;i++)
		{
			System.out.println(we.get(i).getText());
			String date=we.get(i).getText();
			recordDate.add(df.parse(date));
			System.out.println("After parse"+df.parse(date));
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
				 if(!(result.get(i-1)==0 || result.get(i-1)<1))
				 {
					 if(i==we.size()-1)
					 {
							Reporter.reportPassResult(
									browser,"purchaseBundle_US189_TC472",
									"Record should display in ascending order",
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
								browser,"purchaseBundle_US189_TC472_Condition3","purchaseBundle_US189_TC472",
								"Record should display as sorted",
								"Fail");
						AbstractTest.takeSnapShot("purchaseBundle_US189_TC472_Condition3");
				 }
			}
		}

	}
	
	
	
	//TC473 : Verify that Purchase History List is available on the Purchases Landing Page .
	
	
	@Test()
	public void purchaseBundle_US189_TC473() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String date=GlobalVariable.approveDate;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		driver.navigate().refresh();
		Thread.sleep(3000);
		purchasesPage.approveAManualInvoice(invoiceNumber,date);
		Thread.sleep(5000);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC473",
					"User should be able to view the Invoice on View History page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC473","purchaseBundle_US189_TC473",
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC473");
		}
		
		
	}			
	
	
	//TC474 : Verify that User is able to view the Posted  Purchases list .
		
	@Test()
	public void purchaseBundle_US189_TC474() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String date=GlobalVariable.approveDate;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		driver.navigate().refresh();
		Thread.sleep(7000);
		purchasesPage.approveAManualInvoice(invoiceNumber,date);
		Thread.sleep(5000);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC474",
					"User should be able to view the Invoice on View History page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC474_Condition1","purchaseBundle_US189_TC474",
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC474_Condition1");
		}
		//Verify that columns "Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type" are displaying.
		if(purchasesPage.ViewHistory_DeliveryDate_Column_Header.getText().equalsIgnoreCase("Delivery Date") &&
				purchasesPage.ViewHistory_Vendor_Column_Header.getText().equalsIgnoreCase("Vendor") &&
				purchasesPage.ViewHistory_Invoice_Column_Header.getText().equalsIgnoreCase("Invoice") &&
				purchasesPage.ViewHistory_InvoiceTotal_Column_Header.getText().equalsIgnoreCase("Invoice Total") &&
				purchasesPage.ViewHistory_AmountOff_Column_Header.getText().equalsIgnoreCase("Amount Off") &&
				purchasesPage.ViewHistory_AutoApprove_Column_Header.getText().equalsIgnoreCase("Auto Approve") &&
				purchasesPage.ViewHistory_Type_Column_Header.getText().equalsIgnoreCase("Type"))
		{	
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC474",
					"All the column headers should display on View History Page",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC474_Condition2","purchaseBundle_US189_TC474",
					"All the column headers should display on View History Page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC474_Condition2");
		}
		
		
	}			
	
	//TC475 :  	Verify that User is able to view the Posted  Purchases Details .
	
	@Test()
	public void purchaseBundle_US189_TC475() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String date=GlobalVariable.approveDate;
		String startDate=GlobalVariable.startDate;
//		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		String invoiceNumber="23029";
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		driver.navigate().refresh();
		Thread.sleep(7000);
		purchasesPage.approveAManualInvoice(invoiceNumber,date);
		Thread.sleep(5000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		//Verify that columns "Delivery Date, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type" are displaying.
				if(purchasesPage.ViewHistory_DeliveryDate_Column_Header.getText().equalsIgnoreCase("Delivery Date") &&
						purchasesPage.ViewHistory_Vendor_Column_Header.getText().equalsIgnoreCase("Vendor") &&
						purchasesPage.ViewHistory_Invoice_Column_Header.getText().equalsIgnoreCase("Invoice") &&
						purchasesPage.ViewHistory_InvoiceTotal_Column_Header.getText().equalsIgnoreCase("Invoice Total") &&
						purchasesPage.ViewHistory_AmountOff_Column_Header.getText().equalsIgnoreCase("Amount Off") &&
						purchasesPage.ViewHistory_AutoApprove_Column_Header.getText().equalsIgnoreCase("Auto Approve") &&
						purchasesPage.ViewHistory_Type_Column_Header.getText().equalsIgnoreCase("Type"))
				{	
					Reporter.reportPassResult(
							browser,"purchaseBundle_US189_TC475",
							"All the column headers should display on View History Page",
							"Pass");
					
				}
				else
				{
					Reporter.reportTestFailure(
							browser,"purchaseBundle_US189_TC475_Condition2","purchaseBundle_US189_TC475",
							"All the column headers should display on View History Page",
							"Fail");
					AbstractTest.takeSnapShot("purchaseBundle_US189_TC475_Condition2");
				}
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		System.out.println(driver.findElement(By.xpath("//div[@class='col-xs-8 text-left'][2]/span")).getText());
		if(driver.findElement(By.xpath("//div[@class='col-xs-8 text-left'][2]/span")).getText().equalsIgnoreCase(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC475",
					"User should be able to view the Invoice detail on View Invoice page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC475_Condition2","purchaseBundle_US189_TC475",
					"User should be able to view the Invoice detail on View Invoice page",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC475_Condition2");
		}
		
		
		
	}			
	
	//TC3570 : Verify, "The historical purchases listed will be in chronological order (most recent on top).
	
	
	@Test()
	public void purchaseBundle_US189_TC3570() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
	
		String startDate=GlobalVariable.startDate;
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(4000);
//		selectDateForApproveInvoice(date);
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
				 if((result.get(i-1)==0 || result.get(i-1)<1))
				 {
					 if(i==we.size()-1)
					 {
							Reporter.reportPassResult(
									browser,"purchaseBundle_US189_TC3570",
									"Record should display in descending  order",
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
								browser,"purchaseBundle_US189_TC3570","purchaseBundle_US189_TC3570",
								"Record should display in descending  order",
								"Fail");
						AbstractTest.takeSnapShot("purchaseBundle_US189_TC3570");
				 }
			}
		}

	}
	
	
	//TC3571 : Verify,"The default date range will have a start date of the first of the current month and the end date will be the current date at purchase history page".
	
	
	

	@Test()
	public void purchaseBundle_US189_TC3571() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String todayDate=Base.returnTodayDate();
	
	
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(4000);
		purchasesPage.ViewHistory_StartDate_TB.click();		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']")));
		String month=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_month']/span")).getText().trim();
		String year=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][2]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_year']/span")).getText().trim();
		String date=driver.findElement(By.xpath("//div[@class='xdsoft_datepicker active']/div[@class='xdsoft_calendar']/table/tbody/tr/td[@class='xdsoft_date xdsoft_day_of_week2 xdsoft_date xdsoft_current xdsoft_weekend']")).getText().trim();
		System.out.println("date"+date);
		System.out.println("Month"+month);
		System.out.println("Year"+year);
		purchasesPage.ViewHistory_StartDate_TB.click();	
		Thread.sleep(2000);
		purchasesPage.ViewHistory_EndDate_TB.click();		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][3]/div[@class='xdsoft_datepicker active']")));
		String month1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][3]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_month']/span")).getText().trim();
		String year1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][3]/div[@class='xdsoft_datepicker active']/div/div[@class='xdsoft_label xdsoft_year']/span")).getText().trim();
		String date1=driver.findElement(By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_ xdsoft_noselect '][3]/div[@class='xdsoft_datepicker active']/div[@class='xdsoft_calendar']/table/tbody/tr/td[@class='xdsoft_date xdsoft_day_of_week2 xdsoft_date xdsoft_current xdsoft_today xdsoft_weekend']")).getText().trim();
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
					browser,"purchaseBundle_US189_TC3571",
					"User should be able to view start date as first date of the current month and end date as current date",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC3571","purchaseBundle_US189_TC3571",
					"User should be able to view start date as first date of the current month and end date as current date",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC3571");
		}
	}
	
	
	
	//TC3572 : Verify, "the default selection for this filter will be "All" to select vendor name".
	
	
	@Test()
	public void purchaseBundle_US189_TC3572() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
	
	
		/*************************************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.ViewHistory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ViewHistory_ShowResults_BT));
		Thread.sleep(7000);
		String defaultValue=driver.findElement(By.xpath("//span[@id='eb_dd_display']")).getText().trim();
		System.out.println(defaultValue);
		if(defaultValue.equalsIgnoreCase("All"))
		{
			Reporter.reportPassResult(
					browser,"purchaseBundle_US189_TC3572",
					"Default view should be 'ALL' for the vendor drop down",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"purchaseBundle_US189_TC3572","purchaseBundle_US189_TC3572",
					"Default view should be 'ALL' for the vendor drop down",
					"Fail");
			AbstractTest.takeSnapShot("purchaseBundle_US189_TC3572");
		}
	}
	
		
}
