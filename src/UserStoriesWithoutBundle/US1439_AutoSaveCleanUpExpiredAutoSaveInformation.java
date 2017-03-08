package UserStoriesWithoutBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
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
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.TransferLandingPage;

public class US1439_AutoSaveCleanUpExpiredAutoSaveInformation extends AbstractTest{
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3235_RawPromo() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3235_RawPromo";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(3000);
		homePage.goToPurchaseLandingPage().goToPromotionsAndWastePage().RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		if (!rawItemPromoPage.verifyWasteItemIsAdded(wrinId1)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for raw promo in promotion and waste landing page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data raw promo in promotion and waste landing page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3235_ManualVendor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3235_ManualVendor";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String supervisorVendorName = "supervisor" + Base.generateNdigitRandomNumber(4);
		String supervisorManualNumber="supervisor"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page(Supervisor Access)
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(Supervisor Access)
		manualVendorsPage.createANewVendor(supervisorVendorName,supervisorManualNumber);
		Thread.sleep(3000);
		homePage.goToPurchaseLandingPage().goToManualVendorsPage().AddVendor_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		if (manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals("")
				& manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.getAttribute("value").equals("")) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3235_Transfer() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3235_Transfer";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		homePage.goToPurchaseLandingPage().goToTransferLandingPage().CreateNewTransfers_BT.click();
		if (!transferLandingPage.verifyItemIsAdded(samplewRINID)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Transfer",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3235_Purchases() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3235_Purchases";
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
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId, quantity,pricePerCase);
		Thread.sleep(5000);
		homePage.goToTransferLandingPage().goToPurchaseLandingPage().CreateManualInvoice_BT.click();
		if (!manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3236_RawPromo() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3236_RawPromo";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(3000);
		homePage.goToPurchaseLandingPage().goToPromotionsAndWastePage().RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		if (!rawItemPromoPage.verifyWasteItemIsAdded(wrinId1)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for raw promo in promotion and waste landing page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data raw promo in promotion and waste landing page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3236_ManualVendor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3236_ManualVendor";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String supervisorVendorName = "Test Auto" + Base.generateNdigitRandomNumber(4);
		String supervisorManualNumber="Test Auto"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page(Supervisor Access)
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",supervisorVendorName);
		Thread.sleep(1000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",supervisorManualNumber);
		Thread.sleep(1000);
		// Click on Cancel vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddvendorDetailsPopUp_Cancel_BT,"AddvendorDetailsPopUp_Cancel_BT");
		Thread.sleep(3000);
		homePage.goToPurchaseLandingPage().goToManualVendorsPage().AddVendor_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		if (manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals("")
				& manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.getAttribute("value").equals("")) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3236_Transfer() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3236_Transfer";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Cancel_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.CancelTransfer_PopUp_YES_BT));
		transferLandingPage.CancelTransfer_PopUp_YES_BT.click();
		Thread.sleep(5000);
		homePage.goToPurchaseLandingPage().goToTransferLandingPage().CreateNewTransfers_BT.click();
		if (!transferLandingPage.verifyItemIsAdded(samplewRINID)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Transfer",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	@Test()
	public void UserStoriesWithoutBundle_US1439_TC3236_Purchases() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC3236_Purchases";
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
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		GenericMethods.clickOnElement(purchasePage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.selectInvoiceDate(GlobalVariable.createDate);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
		// Enter the quantity
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_Cancel_BT, "Cancel_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_ConfirmationPopUp_Yes_BT)).click();
		Thread.sleep(3000);
		homePage.goToTransferLandingPage().goToPurchaseLandingPage().CreateManualInvoice_BT.click();
		if (!manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4403 : Verify the removal of auto saved information when user logout of the application
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC4403_RawPromo() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC4403";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		GenericMethods.clickOnElement(rawItemPromoPage.RawPromoForm_SliderToggle_BT, "RawPromoForm_SliderToggle_BT");
		GenericMethods.clickOnElement(homePage.SignOut_BT, "Sign Out");
		wait.until(ExpectedConditions.visibilityOf(homePage.SignOutConfirmationPopUp_YES_BT)).click();
		Thread.sleep(5000);
		driver.get(GlobalVariable.testEnvironment);
		 homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
			.goToPromotionsAndWastePage().RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		if (!rawItemPromoPage.verifyWasteItemIsAdded(wrinId1)) {
			Reporter.reportPassResult(
					browser,
					" User should be able to view the previously entered data for raw promo in promotion and waste landing page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the previously entered data raw promo in promotion and waste landing page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC4403_Purchases() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC4403_Purchases";
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
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		// Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		GenericMethods.clickOnElement(purchasePage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		manualInvoiceNewPage.selectInvoiceDate(GlobalVariable.createDate);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
		// Enter the quantity
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_SliderToggle_BT,"CreateManualInvoice_SliderToggle_BT");
		GenericMethods.clickOnElement(homePage.SignOut_BT, "Sign Out");
		wait.until(ExpectedConditions.visibilityOf(homePage.SignOutConfirmationPopUp_YES_BT)).click();
		Thread.sleep(5000);
		driver.get(GlobalVariable.testEnvironment);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		GenericMethods.clickOnElement(purchasePage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if (!manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrinId)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC4403_Transfer() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC4403_Transfer";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = GlobalVariable.transferTypeIn;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = "3";
		String innerPackQuantity ="1";
		String looseUnitQuantity ="4";
		String date = GlobalVariable.createDate;
		String transferTime = GlobalVariable.transferTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		//Select date and time
		transferLandingPage.selectDateInAddNewTransferPopUp(date).selectTimeInAddNewTransferForm(transferTime);
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		transferLandingPage.selectTransferType(transferType).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		Thread.sleep(2000);
		GenericMethods.clickOnElement(transferLandingPage.AddTransferForm_SliderToggle_BT,"AddTransferForm_SliderToggle_BT");
		GenericMethods.clickOnElement(homePage.SignOut_BT, "Sign Out");
		wait.until(ExpectedConditions.visibilityOf(homePage.SignOutConfirmationPopUp_YES_BT)).click();
		Thread.sleep(5000);
		driver.get(GlobalVariable.testEnvironment);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage().CreateNewTransfers_BT.click();
		if (!transferLandingPage.verifyItemIsAdded(samplewRINID)) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Transfer",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1439_TC4403_ManualVendor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1439_TC4403_ManualVendor";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String supervisorVendorName = "supervisor" + Base.generateNdigitRandomNumber(4);
		String supervisorManualNumber="supervisor"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page(Supervisor Access)
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		// CLick on Add New vendor button
		GenericMethods.clickOnElement(manualVendorsPage.AddVendor_BT,"AddVendor_BT");
		// Enter a new vendor name
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB,"AddvendorDetailsPopUp_VendorName_TB",supervisorVendorName);
		Thread.sleep(1000);
		GenericMethods.clearValueOfElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB");
		GenericMethods.enterValueInElement(manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB,"AddvendorDetailsPopUp_ManualNumber_TB",supervisorManualNumber);
		Thread.sleep(1000);
		GenericMethods.clickOnElement(manualVendorsPage.AddVendorForm_SliderToggle_BT,"AddVendorForm_SliderToggle_BT");
		GenericMethods.clickOnElement(homePage.SignOut_BT, "Sign Out");
		wait.until(ExpectedConditions.visibilityOf(homePage.SignOutConfirmationPopUp_YES_BT)).click();
		Thread.sleep(5000);
		driver.get(GlobalVariable.testEnvironment);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToManualVendorsPage().AddVendor_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB));
		Thread.sleep(2000);
		if (manualVendorsPage.AddvendorDetailsPopUp_VendorName_TB.getAttribute("value").equals("")
				& manualVendorsPage.AddvendorDetailsPopUp_ManualNumber_TB.getAttribute("value").equals("")) {
			Reporter.reportPassResult(
					browser,
					" User should not be able to view the previously entered data for Manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should not be able to view the previously entered data  for Manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}


}
