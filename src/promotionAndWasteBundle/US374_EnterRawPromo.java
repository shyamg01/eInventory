package promotionAndWasteBundle;

import java.io.IOException;

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
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;

public class US374_EnterRawPromo extends AbstractTest{
	
	//TC1751: Verify that the user should be able to initiate a Raw Promo entry.
	@Test(groups="Smoke")
	public void promotionWaste_US374_TC1751() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US374_TC1751";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String wrinId2 = GlobalVariable.rawItemPromowrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//String time = rawItemPromoPage.getTimeToSet();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId2);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId2, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("wasteAmount " + wasteAmount);
		rawItemPromoPage.Submit_BT.click();
		if (Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_ConfirmationPopUp_Msg)
				& Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_PopUp_NO_BT)
				& Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw promo?\" with Yes and No option.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw promo?\" with Yes and No option.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_NO_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.Submit_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		if (Base.isElementDisplayed(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(3000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (!wasteAmount.equals("0.00") & promotionsAndWastePage.isRawPromoEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1752: Verify that the user should be able to cancel a Raw Promo entry.
	@Test()
	public void promotionWaste_US374_TC1752() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US374_TC1752";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		/*rawItemPromoPage.selectDateForRawPromo(createDate);
		Thread.sleep(2000);
		rawItemPromoPage.selectTimeInRawPromoForm(time);
		Thread.sleep(2000);*/
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.Cancel_BT.click();
		boolean warningMsgDisplayed = Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_Window);
		rawItemPromoPage.RawPromoEntryIncomplete_PopUp_NO_BT.click();
		if(warningMsgDisplayed & !Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_NO_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "user should be landed back to Raw Promo Scree on clicking No button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "user should be landed back to Raw Promo Scree on clicking No button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemPromoPage.Cancel_BT.click();
		warningMsgDisplayed = Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_Window);
		rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(3000);
		if (warningMsgDisplayed & !Base.isElementDisplayed(rawItemPromoPage.RawPromo_Title)
				& Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "Raw Promo Screen should be closed on clicking Yes button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "Raw Promo Screen should be closed on clicking Yes button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1754: Verify that the user should be able to view the raw promo entry on the raw item activity page.
	@Test()
	public void promotionWaste_US374_TC1754() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US374_TC1754";
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		int noOfPromoActivities = rawItemActivityPage.getNoumberOfPromoActivities(createDate);
		/*homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();*/
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedCount = rawItemPromoPage.RawPromoForm_TotalUnitsValue.getText().replace(",", "");
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		/*homePage.Menu_DD_BT.click();
		Thread.sleep(2000);*/
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if(rawItemActivityPage.getNoumberOfPromoActivities(createDate) == noOfPromoActivities +1
				& rawItemActivityPage.verifyRawPromoEventCountMatchedForSelectedDate(createDate, expectedCount)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3697: Verify that the user should be able to initiate a Raw Promo entry.
	@Test()
	public void promotionWaste_US374_TC3697() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US374_TC3697";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String wrinId2 = GlobalVariable.rawItemPromowrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//String time = rawItemPromoPage.getTimeToSet();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, "0", "0", "0");
		if (Base.isElementDisplayed(rawItemPromoPage.RawPromoForm_ZeroQuantityError_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view an error message If “Units Count” Units for any WRIN in a Promo and Waste = 0 ", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view an error message If “Units Count” Units for any WRIN in a Promo and Waste = 0 ", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId2);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId2, "0", "0", "0");
		if (Base.isElementDisplayed(rawItemPromoPage.RawPromoForm_ZeroQuantityError_Message)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view an error message If “Units Count” Units for any WRIN in a Promo and Waste = 0 ", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view an error message If “Units Count” Units for any WRIN in a Promo and Waste = 0 ", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId2, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("wasteAmount " + wasteAmount);
		rawItemPromoPage.Submit_BT.click();
		if (Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_ConfirmationPopUp_Msg)
				& Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_PopUp_NO_BT)
				& Base.isElementDisplayed(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw promo?\" with Yes and No option.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw promo?\" with Yes and No option.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		if (Base.isElementDisplayed(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(3000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (!wasteAmount.equals("0.00") & promotionsAndWastePage.isRawPromoEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	
	//TC4498 : Enter raw promo, raw waste, completed waste with '0' quantity
	
	
	@Test()
	public void promotionWaste_US374_TC4498() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US374_TC4498";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		String wrinId2 = GlobalVariable.rawItemWastewrin2;
		String wrinId3 = GlobalVariable.rawItemWastewrin3;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String menuItemId2 = GlobalVariable.completedWasteWrin2;
		String menuItemId3 = GlobalVariable.completedWasteWrin3;
		String looseUnitQuantityforWrin1 = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantityforWrin2 = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantityforWrin3 = "0";
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		PromotionsAndWastePage promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		GenericMethods.clickOnElement(promotionsAndWastePage.RawPromo_BT, "promotionsAndWastePage.RawPromo_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
//		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId2);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId3);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, "", "", looseUnitQuantityforWrin1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId2, "", "", looseUnitQuantityforWrin2);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId3, "", "", looseUnitQuantityforWrin3);
		if(Base.isElementDisplayed(By.xpath("//div[@class='toast-message' and text()='Error: Cannot submit WRIN with a 0 quantity.']")))
		{
			Reporter.reportPassResult(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Fail");
			AbstractTest.takeSnapShot();
		}
		
		//Click on Cancel Button
		GenericMethods.clickOnElement(rawItemPromoPage.Cancel_BT, "rawItemPromoPage.Cancel_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button/span[text()='Yes']")));
		Thread.sleep(4000);
		
		GenericMethods.clickOnElement(promotionsAndWastePage.RawWaste_BT, "promotionsAndWastePage.RawWaste_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
//		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId2);
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId3);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, "", "", looseUnitQuantityforWrin1);
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId2, "", "", looseUnitQuantityforWrin2);
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId3, "", "", looseUnitQuantityforWrin3);
		if(Base.isElementDisplayed(By.xpath("//div[@class='toast-message' and text()='Error: Cannot submit WRIN with a 0 quantity.']")))
		{
			Reporter.reportPassResult(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Fail");
			AbstractTest.takeSnapShot();
		}
		
		//Click on Cancel Button
		GenericMethods.clickOnElement(rawItemWastePage.Cancel_BT, "rawItemPromoPage.Cancel_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT)).click();
/*		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button/span[text()='Yes']")));
*/		Thread.sleep(4000);
		
		GenericMethods.clickOnElement(promotionsAndWastePage.CompletedWaste_BT, "promotionsAndWastePage.CompletedWaste_BT");
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
//		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId2);
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId3);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, looseUnitQuantityforWrin1);
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId2, looseUnitQuantityforWrin2);
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId3, looseUnitQuantityforWrin3);

	
		if(Base.isElementDisplayed(By.xpath("//div[@class='toast-message' and text()='Error: Cannot submit WRIN with a 0 quantity.']")))
		{
			Reporter.reportPassResult(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should view error message for zero quantity once clicking on submit button and should NOT be able submit", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1751: Verify that the user should be able to initiate a Raw Promo entry.
	@Test()
	public void promotionWaste_US374_TC4425() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "promotionWaste_US374_TC4425";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,
				RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		String userName = homePage.SelectedUserName_Label.getText();
		userName = Base.toCamelCase(userName).trim();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		// String time = rawItemPromoPage.getTimeToSet();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1,innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("wasteAmount " + wasteAmount);
		String time = Base.getCurrentTimeForStore(storeId);
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(3000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		promotionsAndWastePage.clickOnDateGroup(createDate);
		if (promotionsAndWastePage.verifyRawPromoEntry(createDate, wasteAmount,userName, userId, time)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered in the promo waste page.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered in the promo waste page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
