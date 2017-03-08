package promotionAndWasteBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemWastePage;

public class US367_EnterRawWaste  extends AbstractTest {

	//TC1746: Verify that the user should be able to initiate a Raw Waste entry.
	@Test()
	public void promotionWaste_US367_TC1746() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US367_TC1746";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		String wrinId2 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		//rawItemWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId2);
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId2, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		rawItemWastePage.Submit_BT.click();
		if (Base.isElementDisplayed(rawItemWastePage.SubmitRawWaste_ConfirmationPopUp_Msg)
				& Base.isElementDisplayed(rawItemWastePage.SubmitRawWaste_PopUp_NO_BT)
				& Base.isElementDisplayed(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw waste?\" with Yes and No option.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Warning popup screen will appear: \"Are you sure you want to submit this raw waste?\" with Yes and No option.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_NO_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.Submit_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		if (Base.isElementDisplayed(rawItemWastePage.WasteEntrySaved_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view success message on Submitting Raw waste entries.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view success message on Submitting Raw waste entries.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(3000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (!wasteAmount.equals("0.00") & promotionsAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to enter raw waste and waste entry should display in Promotion and Waste history Table", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter raw waste and waste entry should display in Promotion and Waste history Table", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1748: Verify that the user should be able to to close the Raw Waste entry.
	@Test(groups="Smoke")
	public void promotionWaste_US367_TC1748() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US367_TC1748";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time=GlobalVariable.time;
		//String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		Thread.sleep(3000);
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(2000);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		rawItemWastePage.Cancel_BT.click();
		boolean warningMsgDisplayed = Base.isElementDisplayed(rawItemWastePage.CancelRawWastePopUp_Confirmation_Message);
		rawItemWastePage.RawWasteEntryIncomplete_PopUp_NO_BT.click();
		if(warningMsgDisplayed & !Base.isElementDisplayed(rawItemWastePage.RawWasteEntryIncomplete_PopUp_NO_BT)){
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
		rawItemWastePage.Cancel_BT.click();
		warningMsgDisplayed = Base.isElementDisplayed(rawItemWastePage.CancelRawWastePopUp_Confirmation_Message);
		rawItemWastePage.RawWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(3000);
		if (warningMsgDisplayed & !Base.isElementDisplayed(rawItemWastePage.RawWaste_Title)
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
	
	//TC1750: Verify that the user should be able to view the raw waste entry on the raw item activity page.
	@Test()
	public void promotionWaste_US367_TC1750() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US367_TC1750";
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		int noOfWasteActivities = rawItemActivityPage.getNumberOfWasteActivities(createDate);
		//homePage.Menu_DD_BT.click();
		//wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
//		rawItemWastePage.selectDateForRawWaste(createDate);
//		Thread.sleep(2000);
//		rawItemWastePage.selectTimeInRawWasteForm(time);
//		Thread.sleep(2000);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedCount = rawItemWastePage.RawWasteForm_TotalUnitsValue.getText().replace(",", "");;
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if(rawItemActivityPage.getNumberOfWasteActivities(createDate) == noOfWasteActivities +1
				& rawItemActivityPage.verifyRawWasteEventCountMatchedForSelectedDate(createDate, expectedCount)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the event= Waste for raw-item=x on date D and time=T", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the event= Waste for raw-item=x on date D and time=T", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4424: Verify that the user is able to view the historical record of the submitted Raw Waste on the landing page
	@Test()
	public void promotionWaste_US367_TC4424() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US367_TC4424";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		PromotionsAndWastePage promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		String userName = homePage.SelectedUserName_Label.getText();
		userName = Base.toCamelCase(userName).trim();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		//rawItemWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Thread.sleep(2000);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		String time = Base.getCurrentTimeForStore(storeId);
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		promotionsAndWastePage.clickOnDateGroup(createDate);
		if (promotionsAndWastePage.verifyRawWasteEntry(createDate, wasteAmount,userName, userId, time)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered for submitted raw waste in the promo waste page.",
					"Pass");

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered for submitted raw waste  in the promo waste page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
}
