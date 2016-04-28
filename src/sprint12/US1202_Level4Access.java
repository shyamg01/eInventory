package sprint12;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemInformationPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.VarianceStatPage;

public class US1202_Level4Access extends AbstractTest {

	// TC2126: Verify that the level 4 user should be able to enter a manual purchase.
	@Test()
	public void sprint12_US1202_TC2126() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
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
					browser, "sprint12_US1202_TC2126",
					"level 4 user should be able to enter a manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2126","sprint12_US1202_TC2126",
					"level 4 user should be able to enter a manual purchase", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2126");
		}
	}
	
	// TC2127: Verify that the level 4 user is restricted from the "restore purchases" functionality on the Purchases page.
	@Test()
	public void sprint12_US1202_TC2127() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPurchaseLandingPage();
		// Go to manual invoice new page then select a vendor then add a row item
		if (Base.isElementDisplayed(purchasesPage.RestorePurchases_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2127","sprint12_US1202_TC2127",
					"Level 4 User should not be able to access restore purchases page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2127");
		} else {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2127",
					"Level 4 User should not be able to access restore purchases page.",
					"Pass");
		}
	}
	
	/*
	 * TC2128: Verify that the level 4 user is able to view the Store Ledger,
	 * purchase history and can approve and delete pending purchase on the Purchases page.
	 */
	@Test()
	public void sprint12_US1202_TC2128() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String wrinId = GlobalVariable.createPurchaseWrin1;
		String vendor =GlobalVariable.vendorName;
		String quantity = "1";
		String invoiceId1 = Base.randomNumberFiveDigit();
		String invoiceId2 = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
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
		// Verify that level 1 user should be able to view ledger details for the selected month
		if (storeLedgerDetailPage.verifyDataForSelectedMonth(month, year)) {
			Reporter.reportPassResult(browser, "sprint12_US1202_TC2128",
					"level 4 user is able to view store ledger", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2128","sprint12_US1202_TC2128",
					"level 4 user is able to view store ledger", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2128_Condition1");
		}
		purchasesPage.ViewHistory_BT.click();
		// Fetch the selected start date
		String date1 = purchasesPage.StartDate_BT.getAttribute("value");
		// Fetch the selected end date
		String date2 = purchasesPage.EndDate_BT.getAttribute("value");
		// Verify that only the records between the start and end date is displaying
		if (purchasesPage.verifyPurchaseHistoryDisplayedForSelectedDateRange(date1, date2)) {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2128",
					"level 4 user is able to view purchase history of selected date range",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2128","sprint12_US1202_TC2128",
					"level 4 user is able to view purchase history of selected date range",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2128_Condition2");
		}
		//Click on create new invoice button
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor, quantity, invoiceId1);
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId1);
		//Click on the delete button
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_BT)).click();
		//click on the Yes button on confirmation pop up
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualInvoiceDelete_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.InvoiceDeleted_Confirmation_MSG));
		Thread.sleep(5000);
		// Verify that manual purchase should be deleted from the purchase page
		if (!manualInvoiceNewPage.verifyManualInvoiceIsDisplayed(invoiceId1)) {
			Reporter.reportPassResult(
					browser, "sprint12_US1202_TC2128",
					"level 4 user is able to delete a purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2128","sprint12_US1202_TC2128",
					"level 4 user is able to delete a purchase", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2128_Condition3");
		}
		// Create a new manual purchase 
		manualInvoiceNewPage.createAManualPurchaseForWrinID(wrinId, vendor,	quantity, invoiceId2);
		// click on approve button for the created manual purchase button
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Purchases_BT)).click();
		Thread.sleep(2000);
		manualInvoiceNewPage.clickOnApproveButtonForManualPurchase(invoiceId2);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ManualInvoiceApprove_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(manualInvoiceNewPage.ManualInvoiceApprove_ConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.ManualPurchasePosted_MSG));
		Thread.sleep(2000);
		//Click on view History button
		purchasesPage.ViewHistory_BT.click();
		// Verify that manual invoice is approved
		if (purchasesPage.verifyManualInvoicePosted(invoiceId2)) {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2128",
					"level 4 user should be able to approve a pending purchase.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2128","sprint12_US1202_TC2128",
					"level 4 user should be able to approve a pending purchase.",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2128_Condition4");
		}
	}
	
	// TC2129:Verify that the level 4 user is able to enter raw waste and Completed waste
	@Test()
	public void sprint12_US1202_TC2129() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String wrinId01 = GlobalVariable.rawItemWatsewrin1;
		String outerPack = "1";
		String innerPack = "1";
		String looseUnits = "1";
		String samplewRINID = GlobalVariable.completedWasteWrin1;
		String quantity = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Create a raw waste entry
		rawItemWastePage.addARawItem(wrinId01, outerPack, innerPack, looseUnits);
		//Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount "+wasteAmount);
		//Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		Thread.sleep(3000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint12_US1202_TC2129",
					"Level 4 user should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2129","sprint12_US1202_TC2129",
					"Level 4 user should be able to enter raw waste",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2129_Condition1");
		}
		// CLick on Completed Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions
				.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a Completed waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(samplewRINID,quantity);
		// Get total waste amount
		String completedWasteAmount = completedWastePage.getTotalWasteAmunt();
		// Submit the completed waste entry
		completedWastePage.Submit_BT.click();
		Thread.sleep(3000);
		// Verify that Completed waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(Base.returnTodayDate(), completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint12_US1202_TC2129",
					"Level 4 User should be able to enter completed waste",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2129","sprint12_US1202_TC2129",
					"Level 4 User should be able to enter completed waste",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2129_Condition2");
		}
	}
	
	//TC2130:Verify that the level 4 user is not able to enter raw promo.
	@Test()
	public void sprint12_US1202_TC2130() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// Go to manual invoice new page then select a vendor then add a row item
		if (Base.isElementDisplayed(promotionsAndWastePage.RawPromo_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2130","sprint12_US1202_TC2130",
					"Level 4 user should not able to enter raw promo",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2130");
		} else {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2130",
					"Level 4 user should not able to enter raw promo",
					"Pass");
		}
	}
	
	//TC2131:Verify that the level 4 user is able transfer raw items in/out to other stores.
	@Test()
	public void sprint12_US1202_TC2131() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
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
					browser,"sprint12_US1202_TC2131",
					"Level 4 user should be able to transfer raw items in/out to other stores",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2131","sprint12_US1202_TC2131",
					"Level 4 user should be able to transfer raw items in/out to other stores",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2131_Condition1");
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
			Reporter.reportPassResult(browser, "sprint12_US1202_TC2131",
					"Level 4 User should be able to cancel in/out transfer",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, "sprint12_US1202_TC2131","sprint12_US1202_TC2131",
					"Level 4 User should be able to cancel in/out transfer",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2131_Condition2");
		}
	}
	
	//TC2133:Verify that the level 4 user is restricted from the "office" transfer.
	@Test()
	public void sprint12_US1202_TC2133() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType = "office";
		String caseQuantity = "3";
		String innerPackQuantity ="5";
		String looseUnitQuantity ="1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		TransferLandingPage transferLandingPage = PageFactory.initElements(driver, TransferLandingPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).
				navigateToInventoryManagement().goToTransferLandingPage().CreateNewTransfers_BT.click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.InsertNewTransfersPopup_InputNationalStoreNo_TB));
		//Select the transfer type as "Office" and add the transfer details
		transferLandingPage.selectTransferType(transferType)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//Verify that user should not be able to submit office transfer
		if (Base.isElementDisplayed(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)) {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2133","sprint12_US1202_TC2133",
					"level 4 user is restricted to office transfer", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2133");
		} else {
			Reporter.reportPassResult(
					browser, "sprint12_US1202_TC2133",
					"level 4 user is restricted to office transfer", "Pass");
			}
	}
	
	//TC2134:Verify that the level 4 user can use all the functionality on the Stat Variance page.
	@Test()
	public void sprint12_US1202_TC2134() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
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
					browser, "sprint12_US1202_TC2134",
					"level 4 user is able to view daily variance stat", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2134","sprint12_US1202_TC2134",
					"level 4 user is able to view daily variance stat", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2134_Condition1");
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
					browser,"sprint12_US1202_TC2134",
					"level 4 user is able to view Monthly variance stat",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2134","sprint12_US1202_TC2134",
					"level 4 user is able to view Monthly variance stat",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2134_Condition2");
		}
	}
	
	//TC2136:Verify that the level 4 user can use all the functionality on the Food over base page.
	@Test()
	public void sprint12_US1202_TC2136() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		int random = (int )(Math.random() * 50 + 1);
		String newtargetPercentValue = String.valueOf(random);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food OverBase page
		FoodOverBasePage foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).
				navigateToInventoryManagement().goToFoodOverBasePage();
		String comment = "Test Automation "+ Base.randomNumberFiveDigit();
		//Click on the post comment button for current month and save a comment
		foodOverBasePage.postCommentForCurrentMonth(comment);
		//Verify that new comment is saved 
		foodOverBasePage.PostCommentForCurrentMonth_BT.click();
		if (foodOverBasePage.CommentBox_TB.getAttribute("value").equals(comment)) {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2136",
					"Level 4 user should be able to save a comment in food over base page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2136_Condition1","sprint12_US1202_TC2136",
					"Level 4 user should be able to save a comment in food over base page",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2136_Condition1");
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
					browser, "sprint12_US1202_TC2136",
					"Level 4 user should be able to edit targetPercent value for next month in FoodOverBase Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2136","sprint12_US1202_TC2136",
					"Level 1 user should be able to edit targetPercent value for next month in FoodOverBase Page",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2136_Condition2");
		}
		
	}
	
	//TC2137:Verify that the level 4 user can use all the functionality on the Raw Item Activity page.
	@Test()
	public void sprint12_US1202_TC2137() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
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
					browser,"sprint12_US1202_TC2137",
					"Level 4 user should be able to use all the functionality on the Raw Item Activity page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2137","sprint12_US1202_TC2137",
					"Level 4 user should be able to use all the functionality on the Raw Item Activity page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2137");
		}
	}
	
	//TC2140:Verify that the level 4 user can use all the functionality on the Menu Item activity page.
	@Test()
	public void sprint12_US1202_TC2140() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		HSSFSheet menuItemActivityPageSheet = ReadTestData.getTestDataSheet("sprint15_US1208_TC2652", "Object1");
		String menuItemNumber = ReadTestData.getTestData(menuItemActivityPageSheet, "MenuItemNumber");
		String menuItemDescription = ReadTestData.getTestData(menuItemActivityPageSheet, "MenuItemDescription");
		String startTime = ReadTestData.getTestData(menuItemActivityPageSheet, "CustomStartTime");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MenuItemInformationPage menuInformationPage = PageFactory.initElements(driver, MenuItemInformationPage.class);
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
					browser,"sprint12_US1202_TC2140",
					"level 4 user should be able to view the activity details for menu item=x",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2140","sprint12_US1202_TC2140",
					"level 4 user should be able to view the activity details for menu item=x",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2140_Condition1");
		}
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuInformationPage.MenuItemInformation_Title));
		boolean manuItemIfoPageLoaded = menuInformationPage.verifyMenuItemInfoPageLoaded(menuItemNumber, menuItemDescription);
		menuInformationPage.Recipe_BT.click();
		boolean receipeTableLoaded = Base.isElementDisplayed(menuInformationPage.Recipe_Table);
		menuInformationPage.HistoricRecipe_BT.click();
		boolean historicReceipeTableLoaded = Base.isElementDisplayed(menuInformationPage.HistoricRecipe_Table);
		menuInformationPage.Close_BT.click();
		boolean menuItemInfoPageClosed = !(Base.isElementDisplayed(menuInformationPage.Close_BT));
		if (manuItemIfoPageLoaded & receipeTableLoaded & historicReceipeTableLoaded & menuItemInfoPageClosed) {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2140",
					"level 4 user should be able to use all functionality on the Menu Item Information page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2140","sprint12_US1202_TC2140",
					"level 4 user should be able to use all functionality on the Menu Item Information page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2140_Condition2");
		}
	}
	
	//TC2141:Verify that the level 4 user can READ-ONLY Raw Item Information.
	@Test()
	public void sprint12_US1202_TC2141() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemInformationPage rawItemInformationPage; 
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String wrinId01 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		rawItemInformationPage = PageFactory.initElements(driver, RawItemInformationPage.class);
		// Navigate to Raw Item Activity Page
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).
				navigateToInventoryManagement().goToRawItemActivityPage().searchAndSelectWRINID(wrinId01);
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
		// Verify that Manual Purchase check box and ListType drop down is disabled for Level 4 user
		if (rawItemInformationPage.ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemInformationPage.ListType_DD.getAttribute("disabled").equals("true")) {
			Reporter.reportPassResult(
					browser, "sprint12_US1202_TC2141",
					"Level 4 user  can READ-ONLY Raw Item Information", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint12_US1202_TC2141","sprint12_US1202_TC2141",
					"Level 4 user  can READ-ONLY Raw Item Information", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2141");
		}
	}
	
	//TC2142:Verify that the level 4 user is restricted from the Manual Vendors page.
	@Test()
	public void sprint12_US1202_TC2142() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to raw item info page
		homePage.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.OtherInventoryFunctions_BT));
		homePage.OtherInventoryFunctions_BT.click();
		if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2142","sprint12_US1202_TC2142",
					"Level 4 user should be restricted from Manual Vendors page",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2142");
		} else {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2142",
					"Level 4 user should be restricted from Manual Vendors page",
					"Pass");
		}
	}
	
	// TC2143:Verify that the level 4 user is restricted from all Inventory Restaurant setting functionality.
	@Test()
	public void sprint12_US1202_TC2143() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to raw item info page
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.StoreSetting_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2143","sprint12_US1202_TC2143",
					"Level 4 user should be restricted from store setting page",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2143");
		} else {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2143",
					"Level 4 user should be restricted from store setting page",
					"Pass");
		}
	}
	
	// TC2144:Verify that the level 4 User is restricted from restore custom list functionality on the Custom List page.
	@Test()
	public void sprint12_US1202_TC2144() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//** Variable Section : **//*
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		//***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to raw item info page
		CustomRawItemListsPage customRawItemListsPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToCustomRawItemListsPage();
		if (Base.isElementDisplayed(customRawItemListsPage.RestoreLists_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint12_US1202_TC2144","sprint12_US1202_TC2144",
					"Level 4 user should be restricted from restore custom list functionality on the Custom List page",
					"Fail");
			AbstractTest.takeSnapShot("sprint12_US1202_TC2144");
		} else {
			Reporter.reportPassResult(
					browser,"sprint12_US1202_TC2144",
					"Level 4 user should be restricted from restore custom list functionality on the Custom List page",
					"Pass");
		}
	}
}
