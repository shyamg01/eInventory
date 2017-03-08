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
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;

public class US1270_EnterDecimalLooseUnitQuantitiesOnRawWasteAndPromo  extends AbstractTest {
	
	//TC2044: Verify that the user should be able to enter 2 digits past the decimal in  loose unit fields on the raw waste entry page.
	@Test()
	public void promotionWaste_US1270_TC2044() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1270_TC2044";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		String wrinId = GlobalVariable.rawItemWatsewrin1;
		String looseUnitQuantity1 = "10.25";
		String looseUnitQuantity2 = "10.125";
//		String createDate = GlobalVariable.createDate;
		String createDate = Base.returnTodayDate();
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//String time = rawItemWastePage.getTimeToSet();
		//rawItemWastePage.selectDateForRawWaste(createDate);
		// Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		Thread.sleep(5000);
		rawItemWastePage.LooseUnits_TB.sendKeys(looseUnitQuantity1);
		boolean validValuesSaved = rawItemWastePage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity1);
		if(validValuesSaved)
		{
			Reporter.reportPassResult(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Pass");
			

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemWastePage.LooseUnits_TB.clear();
		rawItemWastePage.LooseUnits_TB.sendKeys(looseUnitQuantity2);
		boolean inValidValuesNotSaved = !rawItemWastePage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity2);
		System.out.println("msg "+rawItemWastePage.LooseUnitsInvalidValue_Error_Message.getText());
		//Values must be numeric with up to 2 decimals. (Example: 12345.99)
		if(inValidValuesNotSaved && Base.isElementDisplayed(rawItemWastePage.LooseUnitsInvalidValue_Error_Message)
				&& rawItemWastePage.LooseUnitsInvalidValue_Error_Message.getText().equals("Values must be numeric with up to 2 decimals. (Example: 12345.99)")){
			Reporter.reportPassResult(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemWastePage.Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
	}
	
	//TC2045: Verify that the user should be able to enter 2 digits past the decimal in  loose unit fields on the raw promo entry page.
	@Test()
	public void promotionWaste_US1270_TC2045() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1270_TC2045";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.rawItemPromowrin1;
		String looseUnitQuantity1 = "10.25";
		String looseUnitQuantity2 = "10.125";
//		String createDate = GlobalVariable.createDate;
		String createDate = Base.returnTodayDate();
		//String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		//rawItemPromoPage.selectDateForRawPromo(createDate);
		// Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		Thread.sleep(5000);
		rawItemPromoPage.LooseUnits_TB.sendKeys(looseUnitQuantity1);
		boolean validValuesSaved = rawItemPromoPage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity1);
		if(validValuesSaved)
		{
			Reporter.reportPassResult(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Pass");
			

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemPromoPage.LooseUnits_TB.clear();
		rawItemPromoPage.LooseUnits_TB.sendKeys(looseUnitQuantity2);
		boolean inValidValuesNotSaved = !rawItemPromoPage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity2);
		System.out.println("msg "+rawItemPromoPage.LooseUnitsInvalidValue_Error_Message.getText());
		//Values must be numeric with up to 2 decimals. (Example: 12345.99)
		if(inValidValuesNotSaved && Base.isElementDisplayed(rawItemPromoPage.LooseUnitsInvalidValue_Error_Message)
				&& rawItemPromoPage.LooseUnitsInvalidValue_Error_Message.getText().equals("Values must be numeric with up to 2 decimals. (Example: 12345.99)")){
			Reporter.reportPassResult(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemPromoPage.Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
	}
	
	//TC3913: Verify that the user should be able to enter 2 digits past the decimal in  loose unit fields on the raw waste entry page.
	@Test()
	public void promotionWaste_US1270_TC3913() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1270_TC3913";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId = GlobalVariable.rawItemWatsewrin1;
		String looseUnitQuantity1 = "12345.67";
		String looseUnitQuantity2 = "1234567";
		String createDate = Base.returnTodayDate();
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//String time = rawItemWastePage.getTimeToSet();
		//rawItemWastePage.selectDateForRawWaste(createDate);
		// Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		Thread.sleep(5000);
		rawItemWastePage.LooseUnits_TB.sendKeys(looseUnitQuantity1);
		boolean validValuesSaved = rawItemWastePage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity1);
		if(validValuesSaved)
		{
			Reporter.reportPassResult(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Pass");
			

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"No Error shoudl display for correct Loose Unit value", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemWastePage.LooseUnits_TB.clear();
		rawItemWastePage.LooseUnits_TB.sendKeys(looseUnitQuantity2);
		boolean inValidValuesNotSaved = !rawItemWastePage.LooseUnits_TB.getAttribute("value").equals(looseUnitQuantity2);
		System.out.println("msg "+rawItemWastePage.LooseUnitsInvalidValue_Error_Message.getText());
		//Values must be numeric with up to 2 decimals. (Example: 12345.99)
		if(inValidValuesNotSaved && Base.isElementDisplayed(rawItemWastePage.LooseUnitsInvalidValue_Error_Message)
				&& rawItemWastePage.LooseUnitsInvalidValue_Error_Message.getText().equals("Values must be numeric with up to 2 decimals. (Example: 12345.99)")){
			Reporter.reportPassResult(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter enter 2 digits past the decimal in loose unit fields and should NOT be allowed to enter more than 2 digits past the decimal", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		rawItemWastePage.Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
	}

}
