package purchasesBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;

public class US178_EnterManualPurchase extends AbstractTest{
	
	//TC393 : Verify, "A method to initiate the entry of a manual purchase is available to the user from the Purchases Landing page."
	@Test()
	public void purchasesBundle_US178_TC393() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC393";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		System.out.println("Password "+password);
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if (GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable,"manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable")) {
			Reporter.reportPassResult(browser,
					"User should view a pop up screen to initiate purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should view a pop up screen to initiate purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC394 : Verify: "A method to select a vendor:1)A user is required to select a vendor for any manual purchase.2)All vendors should be store-specific."
	@Test()
	public void purchasesBundle_US178_TC394() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC394";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String userId2 = LoginTestData.level1_11089_userId;
		String storeId2 = LoginTestData.level1StoreId2;
		String vendorName = GlobalVariable.vendorName1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage =  PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		boolean vendorDisplayedInStore1 = manualInvoiceNewPage.verifyVendorDisplayed(vendorName);
		if(vendorDisplayedInStore1)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the vendor in the store that is associated with it",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the vendor in the store that is associated with it",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		System.out.println("vendorDisplayedInStore1 "+vendorDisplayedInStore1);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_Cancel_BT, "manualInvoiceNewPage.CreateManualInvoice_Cancel_BT");
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT, "manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT");
		Thread.sleep(3000);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//div[@id='signOut']")), "Sign Out");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='htmlButton']/span[text()='Yes']"))).click();
		Thread.sleep(5000);
		GenericMethods.navigateTo(GlobalVariable.testEnvironment);
		Thread.sleep(3000);
		purchasesPage.selectUserWithSSOLogin(userId2, password).selectLocation(storeId2)
		.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		boolean vendorDisplayedInStore2 = manualInvoiceNewPage.verifyVendorDisplayed(vendorName);
		System.out.println("vendorDisplayedInStore2 "+vendorDisplayedInStore2);
		if (!vendorDisplayedInStore2) {
			Reporter.reportPassResult(
					browser,
					"User should not able to view the vendor in store that is not associated",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not able to view the vendor in store that is not associated",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC396 : Verify: Verify that a user is required to select a date for any manual purchase
	@Test()
	public void purchasesBundle_US178_TC396() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC396";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 0);
		String todayDate = dateFormat.format(cal1.getTime());
		System.out.println("todayDate "+todayDate);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -1);
		String yesterdaydate = dateFormat.format(cal2.getTime());
		System.out.println("yesterdaydate "+yesterdaydate);
		boolean dateSeleted = true;
		if(Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ConnectionDown_Msg))
		{
			manualInvoiceNewPage.selectInvoiceDate(todayDate);
			System.out.println("today date"+manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText());
			boolean todayDateselected = manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText().contains(todayDate);
			manualInvoiceNewPage.selectInvoiceDate(yesterdaydate);
			System.out.println("yesterday date"+manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText());
			boolean yesterdayDateselected = manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText().contains(yesterdaydate);
			dateSeleted = dateSeleted && todayDateselected && yesterdayDateselected;
			
		} else{
			manualInvoiceNewPage.selectInvoiceDate(todayDate);
			System.out.println("today date1"+manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText());
			boolean todayDateselected = manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getText().contains(todayDate);
			dateSeleted = dateSeleted & todayDateselected;
		}
		if (dateSeleted) {
			Reporter.reportPassResult(
					browser,
					"User should view dates as: 1)Current business date if connection is ok "
					+ "2)Current business date and yesterday date if connection down", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should view dates as: 1)Current business date if connection is ok "
					+ "2)Current business date and yesterday date if connection down","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC397 : Verify, "A method to enter an invoice number (if applicable). "
	@Test()
	public void purchasesBundle_US178_TC397() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC397";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String invoiceNumber = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB", "");
		Thread.sleep(1500); 
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
		if(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.getAttribute("value").equals(invoiceNumber)){
			Reporter.reportPassResult(
					browser,
					"User should be able to enter invoice number.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter invoice number.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC398 : Verify that user should be able search and add wrins to manual purchase
	@Test()
	public void purchasesBundle_US178_TC398() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC398";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String invoiceNumber = Base.randomNumberFiveDigit();
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB", "");
		Thread.sleep(1500); 
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
		if(manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)){
			Reporter.reportPassResult(
					browser,
					"User should be able to add wrin=abc to manual purchase",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to add wrin=abc to manual purchase",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC399 : Verify that user is able to remove wrin from manual purchase
	@Test()
	public void purchasesBundle_US178_TC399() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC399";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG));
		manualInvoiceNewPage.removeWrinFromPurchaseList(wrinId);
		if(!manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)){
			Reporter.reportPassResult(
					browser,
					"User should be able to remove wrin from manual purchase",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to remove wrin from manual purchase",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC400 : Verify that the user is able to enter whole numbers into the outer pack quantities field with restriction towards entering zeros or special or alpha characters.
	@Test()
	public void purchasesBundle_US178_TC400() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC400";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String specialCharInQuantity = "@";
		String zeroQuantity = "0";
		String sixDigitInQuantity = "999291";
		String validQuantity = "12345";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)", specialCharInQuantity);
		String invalidQuantityMsg = manualInvoiceNewPage.InvalidQuantity_Error_Message.getText();
		GenericMethods.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message, "manualInvoiceNewPage.InvalidQuantity_Error_Message");
		if(invalidQuantityMsg.contains("Value must be numeric between 1 and 99999, with no decimals")){
			Reporter.reportPassResult(
					browser,
					"User should NOT be able to enter special charactrer for quantity and view error message","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should NOT be able to enter special charactrer for quantity and view error message", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)", zeroQuantity);
		invalidQuantityMsg = manualInvoiceNewPage.InvalidQuantity_Error_Message.getText();
		GenericMethods.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message, "manualInvoiceNewPage.InvalidQuantity_Error_Message");
		if(invalidQuantityMsg.contains("Value must be numeric between 1 and 99999, with no decimals")){
			Reporter.reportPassResult(
					browser,
					"User should NOT be able to enter 0 for quantity and view error message","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should NOT be able to enter 0 for quantity and view error message", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)", sixDigitInQuantity);
		invalidQuantityMsg = manualInvoiceNewPage.InvalidQuantity_Error_Message.getText();
		GenericMethods.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message, "manualInvoiceNewPage.InvalidQuantity_Error_Message");
		if(invalidQuantityMsg.contains("Value must be numeric between 1 and 99999, with no decimals")){
			Reporter.reportPassResult(
					browser,
					"User should NOT be able to enter  more than 5-digit for quantity and view error message","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should NOT be able to enter more than 5-digit for quantity and view error message", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "manualInvoiceNewPage.Quantity_TB_List.get(0)", validQuantity);
	
		if(!Base.isElementDisplayed(manualInvoiceNewPage.InvalidQuantity_Error_Message))
		{
			Reporter.reportPassResult(
					browser,
					"User should NOT be able to enter  more than 5-digit for quantity and view error message","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should NOT be able to enter more than 5-digit for quantity and view error message", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC401 : Verify that the user should be able to submit the manual purchase
	@Test()
	public void purchasesBundle_US178_TC401() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC401";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String wrinId2 = GlobalVariable.createPurchaseWrin;
		String vendor = GlobalVariable.vendorName;
		String quantity = "12345";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG)).click();
		manualInvoiceNewPage.enterQuantityForMultipleWrin(wrinId, quantity);
		
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId2);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG)).click();
		manualInvoiceNewPage.enterQuantityForMultipleWrin(wrinId2, quantity);
		GenericMethods.clickOnElement(manualInvoiceNewPage.Submit_BT, "manualInvoiceNewPage.Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)), "CreateManualInvoice_ConfirmationPopUp_Yes_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG));
		if(Base.isElementDisplayed(manualInvoiceNewPage.InvoiceSaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit invoice with success message:'Your invoice has been saved'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit invoice with success message:'Your invoice has been saved'",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC402 : Verify that user is able to approve the manual purchase from the ''Approve Pending" Purchase list
	@Test()
	public void purchasesBundle_US178_TC402() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC402";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceNumber = Base.randomNumberFiveDigit();
		//String date = GlobalVariable.createDate;
		String pricePerCase = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId, quantity,pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		//purchasesPage.selectDateForApproveInvoice(date).selectTimeForApproveInvoice(GlobalVariable.time);
		GenericMethods.clickOnElement(purchasesPage.ApproveManualInvoice_Approve_BT, "purchasesPage.ApproveManualInvoice_Approve_BT");
		if(GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message, "purchasesPage.ManualInvoiceApproveForm_ConfirmApprove_Message"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the warning message on clicking approve button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the warning message on clicking approve button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)), "purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT");
		if(GenericMethods.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG, "purchasesPage.ApproveManualInvoice_PopUp_InvoiceApprove_Confirmation_MSG"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the success message 'Purchase Posted'",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the success message 'Purchase Posted'",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC403 : Verify that user is able to close the manual purchase from the ''Approve Pending" Purchase list
	@Test()
	public void purchasesBundle_US178_TC403() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC403";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceNumber = Base.randomNumberFiveDigit();

		String pricePerCase = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		GenericMethods.clickOnElement(purchasesPage.ManualInvoiceApprove_Close_BT, "purchasesPage.ManualInvoiceApprove_Close_BT");
		if(Base.isElementDisplayed(purchasesPage.ManualInvoiceApproveForm_ConfirmCancel_Message)
				&& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)
				&& Base.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_No_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to see a warning message with Yes and No buttons on clicking close button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see a warning message with Yes and No buttons on clicking close button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT, "purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT");
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		GenericMethods.clickOnElement(purchasesPage.ManualInvoiceApprove_Close_BT, "purchasesPage.ManualInvoiceApprove_Close_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)), "purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT");
		if(!Base.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_Lable)){
			Reporter.reportPassResult(
					browser,
					"User should be landed back to purchase page on clicking Cross(X) button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be landed back to purchase page on clicking Cross(X) button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_Cancel_BT, "manualInvoiceNewPage.CreateManualInvoice_Cancel_BT");
		if(Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ConfirmCancel_Message)
				&& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_No_BT)
				&& Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to see a warning message with Yes and No buttons on clicking Cancel button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see a warning message with Yes and No buttons on clicking Cancel button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)), "manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT");
		if(!Base.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable)){
			Reporter.reportPassResult(
					browser,
					"User should be landed back to purchase page on clicking Cancel button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be landed back to purchase page on clicking Cancel button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2844 : Verify that user is able to delete the manual purchase from the ''Approve Pending" Purchase list
	@Test()
	public void purchasesBundle_US178_TC2844() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC2844";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceNumber = Base.randomNumberFiveDigit();
		String pricePerCase = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		GenericMethods.clickOnElement(purchasesPage.ApproveManualInvoice_PopUp_Delete_BT, "purchasesPage.ApproveManualInvoice_PopUp_Delete_BT");
		if(GenericMethods.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_Confirmation_MSG, "purchasesPage.ApproveManualInvoice_PopUp_Confirmation_MSG")){
			Reporter.reportPassResult(
					browser,
					"User should be able to see confirmation pop up on clicking delete button",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see confirmation pop up on clicking delete button",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)), "purchasesPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT");
		if(GenericMethods.isElementDisplayed(purchasesPage.ApproveManualInvoice_PopUp_InvoiceDelete_Confirmation_MSG, "purchasesPage.ApproveManualInvoice_PopUp_InvoiceDelete_Confirmation_MSG")){
			Reporter.reportPassResult(
					browser,
					"User should view a success message 'invoice deleted'.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should view a success message 'invoice deleted'.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3384 : Verify the header "Delivery date, status, vendor, invoice, invoice total, amount off, auto approve and type" on purchase landing page
	@Test()
	public void purchasesBundle_US178_TC3384() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC3384";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		if (GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_DeliveryDate_Header, "purchasesPage.ApprovePendingTable_DeliveryDate_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Status_Header, "purchasesPage.ApprovePendingTable_Status_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Vendor_Header, "purchasesPage.ApprovePendingTable_Vendor_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Invoice_Header, "purchasesPage.ApprovePendingTable_Invoice_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_InvoiceTotal_Header, "purchasesPage.ApprovePendingTable_InvoiceTotal_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_AmountOff_Header, "purchasesPage.ApprovePendingTable_AmountOff_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_AutoApprove_Header, "purchasesPage.ApprovePendingTable_AutoApprove_Header")
				&& GenericMethods.isElementDisplayed(purchasesPage.ApprovePendingTable_Type_Header, "purchasesPage.ApprovePendingTable_Type_Header")) {
			Reporter.reportPassResult(
					browser,
					"purchase landing page table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"purchase landing page table columns include:  Delivery Date, Status, Vendor, Invoice, Invoice Total, Amount Off, Auto Approve, Type",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3615 : Verify the header "Delivery date, status, vendor, invoice, invoice total, amount off, auto approve and type" on purchase landing page
	@Test()
	public void purchasesBundle_US178_TC3615() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC3615";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ManualSource_Label));
		// Click on create new invoice button
		if (GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_ManualSource_Label, "manualInvoiceNewPage.CreateManualInvoice_ManualSource_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_CreatedBy_Label, "manualInvoiceNewPage.CreateManualInvoice_CreatedBy_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Vendor_Label, "manualInvoiceNewPage.CreateManualInvoice_Vendor_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_Label, "manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Date_Label, "manualInvoiceNewPage.CreateManualInvoice_Date_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoice_Item_Label, "manualInvoiceNewPage.CreateManualInvoice_Item_Label")) 
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view label as source, created by, vendor, invoice number, date, item",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view label as source, created by, vendor, invoice number, date, item",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		//wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ItemAdded_MSG));
		if (GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_WRIN_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_WRIN_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_Description_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_Description_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_UOM_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_UOM_Label")
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_Case_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_Case_Label") 
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_Quantity_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_Quantity_Label") 
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_PricePerCase_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_PricePerCase_Label") 
				&& GenericMethods.isElementDisplayed(manualInvoiceNewPage.CreateManualInvoiceTable_SubTotal_Label, "manualInvoiceNewPage.CreateManualInvoiceTable_SubTotal_Label")) 
				{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the columns with text for 'wrin, description, UOM case, quantity, price per case, sub-total'.",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the columns with text for 'wrin, description, UOM case, quantity, price per case, sub-total'.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	/*TC3616 : Verify that the user is able to view label as source, created by, vendor, invoice number, date, item as 
	well as columns for wrin, description, UOM case, quantity, price per case, sub-total for submitted manual invoice 
	form which needs approval.*/
	@Test()
	public void purchasesBundle_US178_TC3616() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException,
			ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US178_TC3616";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceNumber = Base.randomNumberFiveDigit();
		String pricePerCase = "25.00";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId, quantity, pricePerCase);
		Thread.sleep(5000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveManualInvoice_PopUp_Lable));
		// Click on create new invoice button
		if (GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_ManualSource_Label, "purchasesPage.ManualInvoiceApprove_ManualSource_Label")
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_CreatedBy_Label, "purchasesPage.ManualInvoiceApprove_CreatedBy_Label")
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Vendor_Label, "purchasesPage.ManualInvoiceApprove_Vendor_Label") 
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_InvoiceNumber_Label, "purchasesPage.ManualInvoiceApprove_InvoiceNumber_Label")) 
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view label as source, created by, vendor, invoice number, date, item in Approve Invoice Form",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view label as source, created by, vendor, invoice number, date, item in Approve Invoice Form",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if (GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_WRIN_Label, "purchasesPage.ManualInvoiceApprove_WRIN_Label")
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_Description_Label, "purchasesPage.ManualInvoiceApprove_Description_Label")
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_CasePurchased_Label, "purchasesPage.ManualInvoiceApprove_CasePurchased_Label")
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_PricePerCase_Label, "purchasesPage.ManualInvoiceApprove_PricePerCase_Label") 
				&& GenericMethods.isElementDisplayed(purchasesPage.ManualInvoiceApprove_SubTotal_Label, "purchasesPage.ManualInvoiceApprove_SubTotal_Label") ) 
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the columns with text for wrin, description, cases purchased, price per case, sub-total",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the columns with text for wrin, description, cases purchased, price per case, sub-total",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	

}
