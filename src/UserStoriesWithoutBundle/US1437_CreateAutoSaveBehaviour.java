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
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemPromoPage;

public class US1437_CreateAutoSaveBehaviour extends AbstractTest{
	
	//TC3227 : Verify auto save behavior  when user is logged in through cloud.
	@Test()
	public void UserStoriesWithoutBundle_US1437_TC3227_RawPromo() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1437_TC3227_RawPromo";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
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
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		GenericMethods.clickOnElement(rawItemPromoPage.RawPromoForm_SliderToggle_BT, "RawPromoForm_SliderToggle_BT");
		homePage.goToPurchaseLandingPage();
		Thread.sleep(3000);
		homePage.goToPromotionsAndWastePage().RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		System.out.println("time "+ rawItemPromoPage.OuterPack_TB.getAttribute("value").equals(caseQuantity));
		System.out.println("time "+ rawItemPromoPage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity));
		if (rawItemPromoPage.verifyWasteItemIsAdded(wrinId1)
				& rawItemPromoPage.OuterPack_TB.getAttribute("value").equals(caseQuantity)
				& rawItemPromoPage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity)
				) {
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
	
	//TC3227 : Verify auto save behavior  when user is logged in through cloud.
	@Test()
	public void UserStoriesWithoutBundle_US1437_TC3227_CompletedWaste() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1437_TC3227_CompletedWaste";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "4";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity);
		GenericMethods.clickOnElement(completedWastePage.CompletedWasteForm_SliderToggle_BT, "CompletedWasteForm_SliderToggle_BT");
		homePage.goToPurchaseLandingPage();
		Thread.sleep(3000);
		homePage.goToPromotionsAndWastePage().CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		System.out.println("time "+ completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals(quantity));
		if (completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId1)
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals(quantity)				) {
			Reporter.reportPassResult(
					browser,
					" User should be able to view the previously entered data for completed waste in promotion and waste landing page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the previously entered data  for completed waste in promotion and waste landing page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3227 : Verify auto save behavior  when user is logged in through cloud.
	@Test()
	public void UserStoriesWithoutBundle_US1437_TC4390() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1437_TC4390";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));	
		String quantity = "3";
		String pricePerCase = "25.0000";
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName).selectInvoiceDate(GlobalVariable.createDate).seacrhAndSelectRawItem(wrin);
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB, "CreateManualInvoice_InvoiceNumber_TB", invoiceNumber);
		// Enter the quantity
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.Quantity_TB_List.get(0), "First Quntity text box", quantity);
		Thread.sleep(2000);
		GenericMethods.clearValueOfElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box");
		GenericMethods.enterValueInElement(manualInvoiceNewPage.pricePerCase_TB_List.get(0), "First PricePerCase text box", pricePerCase);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable, "CreateManualInvoice_PopUp_Lable");
		Thread.sleep(2000);
		GenericMethods.clickOnElement(manualInvoiceNewPage.CreateManualInvoice_SliderToggle_BT,"CreateManualInvoice_SliderToggle_BT");
		homePage.goToPromotionsAndWastePage();
		Thread.sleep(3000);
		homePage.goToPurchaseLandingPage();
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		System.out.println("time "+ manualInvoiceNewPage.Quantity_TB_List.get(0).getAttribute("value").equals(quantity));
		System.out.println("date "+ manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getAttribute("value"));
		System.out.println("compare "+ manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getAttribute("value").equals(createDate));
		if (manualInvoiceNewPage.verifyItemIsAddedForInvoice(wrin)
				& manualInvoiceNewPage.Quantity_TB_List.get(0).getAttribute("value").equals(quantity)
				& manualInvoiceNewPage.CreateManualInvoice_InvoiceDate_TB.getAttribute("value").equals(createDate)
				& manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value").equals(pricePerCase)
				) {
			Reporter.reportPassResult(
					browser,
					" User should be able to view the previously entered data for Manual Purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the previously entered  for Manual Purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
