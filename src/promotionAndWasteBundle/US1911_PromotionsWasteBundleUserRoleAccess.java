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
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;

public class US1911_PromotionsWasteBundleUserRoleAccess extends AbstractTest{
	
	//TC3206 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user have access to enter raw waste.
	@Test()
	public void pramotionWaste_US1911_TC3206_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3206_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String createDate=GlobalVariable.createDate;
		
		
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(1500);*/
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
	/*	Thread.sleep(10000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to enter raw waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3206_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String createDate=GlobalVariable.createDate;
		
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		/*promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to enter raw waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3206_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String createDate=GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		
		
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to enter raw waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3206_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String createDate=GlobalVariable.createDate;
		
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should be able to enter raw waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3206_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		String createDate=GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		
		
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
	/*	Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should be able to enter raw waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3207 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user have access to enter completed waste.
	@Test()
	public void pramotionWaste_US1911_TC3207_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3207_level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String createDate=GlobalVariable.createDate;
		
		String menuItemId = GlobalVariable.completedWasteWrin1;
		
		String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a raw waste entry
		/*completedWastePage.selectDateForCompletedWaste(createDate);
		Thread.sleep(1500);
		completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"level2 User should be able to enter completed Waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"level2 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	@Test()
	public void pramotionWaste_US1911_TC3207_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3207_level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		
//		String createDate=GlobalVariable.createDate;
		String createDate=GlobalVariable.createDate;
		
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		/*completedWastePage.selectDateForCompletedWaste(createDate);
		Thread.sleep(1500);
		// Create a raw waste entry
		completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"level3 User should be able to enter completed Waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"level3 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	@Test()
	public void pramotionWaste_US1911_TC3207_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3207_level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		
//		String createDate=GlobalVariable.createDate;
		String createDate=GlobalVariable.createDate;
		
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		/*completedWastePage.selectDateForCompletedWaste(createDate);
		Thread.sleep(1500);
		// Create a raw waste entry
		completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"level4 User should be able to enter completed Waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"level4 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	@Test()
	public void pramotionWaste_US1911_TC3207_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3207_level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		
//		String createDate=GlobalVariable.createDate;
		String createDate=GlobalVariable.createDate;
		
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		/*completedWastePage.selectDateForCompletedWaste(createDate);
		Thread.sleep(1500);
		// Create a raw waste entry
		completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
	/*	Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"level5 User should be able to enter completed Waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"level5 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	@Test()
	public void pramotionWaste_US1911_TC3207_level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1911_TC3207_level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		
//		String createDate=GlobalVariable.createDate;
		String createDate=GlobalVariable.createDate;
		
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		/*completedWastePage.selectDateForCompletedWaste(createDate);
		Thread.sleep(1500);
		// Create a raw waste entry
		completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		/*Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser,
					"level6 User should be able to enter completed Waste", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"level6 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	
	
	//TC3208 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user cannot enter raw promo.
		@Test()
		public void pramotionWaste_US1911_TC3208_Level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="pramotionWaste_US1911_TC3208_Level2";
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
			String storeId = LoginTestData.level2StoreId;
			
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser,
						"Level 2 User should not be able to enter raw Promo", "Pass");
				

			} else {
				Reporter.reportTestFailure(
						browser,
						"Level 2 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="pramotionWaste_US1911_TC3208_Level3";
			String password = LoginTestData.level3_SSO_Password;
			String userId = LoginTestData.level3_SSO_UserId;
			String storeId = LoginTestData.level3StoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, 
						"Level 3 User should not be able to enter raw Promo", "Pass");
				

			} else {
				Reporter.reportTestFailure(
						browser,
						"Level 3 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="pramotionWaste_US1911_TC3208_Level4";
			String password = LoginTestData.level4_SSO_Password;
			String userId = LoginTestData.level4_SSO_UserId;
			String storeId = LoginTestData.level4StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser,
						"Level 4 User should not be able to enter raw Promo", "Pass");
				

			} else {
				Reporter.reportTestFailure(
						browser,
						"Level 4 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot();
				
				
			}
		}
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level5() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="pramotionWaste_US1911_TC3208_Level5";
			String password = LoginTestData.level5_SSO_Password;
			String userId = LoginTestData.level5_SSO_UserId;
			String storeId = LoginTestData.level5StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, 
						"Level 5 User should not be able to enter raw Promo", "Pass");
				

			} else {
				Reporter.reportTestFailure(
						browser,
						"Level 5 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level6() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="pramotionWaste_US1911_TC3208_Level6";
			String password = LoginTestData.level6_SSO_Password;
			String userId = LoginTestData.level6_SSO_UserId;
			String storeId = LoginTestData.level6StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser,
						"Level 6 User should not be able to enter raw Promo", "Pass");
				

			} else {
				Reporter.reportTestFailure(
						browser,
						"Level 6 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
	
		//TC3209 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter raw waste..
			@Test(enabled=false)
			public void pramotionWaste_US1911_TC3209_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3209_Supervisor";
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String createDate=GlobalVariable.createDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				/*rawItemWastePage.selectDateForRawWaste(date);
				Thread.sleep(2000);
				rawItemWastePage.selectTimeInRawWasteForm(time);
				Thread.sleep(2000);*/
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"Supervisor User should be able to enter raw waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"Supervisor User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment";
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				/*String date=GlobalVariable.createDate;*/
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				/*rawItemWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(2000);
				rawItemWastePage.selectTimeInRawWasteForm(time);
				Thread.sleep(2000);*/
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"Supervisor w/ Role Assignment User should be able to enter raw waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"Supervisor w/ Role Assignment User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3209_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3209_orgAdmin";
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				/*String date=GlobalVariable.createDate;*/

				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// CLick on Raw Waste Button
				/*rawItemWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(2000);
				rawItemWastePage.selectTimeInRawWasteForm(time);
				Thread.sleep(2000);*/
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"orgAdmin User should be able to enter raw waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"orgAdmin User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3209_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3209_operator";
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				/*String date=GlobalVariable.createDate;*/
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				/*rawItemWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(2000);
				rawItemWastePage.selectTimeInRawWasteForm(time);
				Thread.sleep(2000);*/
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, 
							"operatorUser should be able to enter raw waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"operator User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3209_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3209_level1";
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
			
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				/*rawItemWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(2000);
				rawItemWastePage.selectTimeInRawWasteForm(time);
				Thread.sleep(2000);*/
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"level1 should be able to enter raw waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"level1 User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
	
			//TC3210 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter raw promo.
			@Test(enabled=false)
			public void pramotionWaste_US1911_TC3210_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3210_Supervisor";
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				/*rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.selectTimeInRawPromoForm(time);
				Thread.sleep(2000);*/
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(4000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser,
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment";
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String createDate=GlobalVariable.createDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				/*rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				rawItemPromoPage.selectTimeInRawPromoForm(time);
				Thread.sleep(1500);*/
				// Create a raw waste entry
				rawItemPromoPage.RawItemWasted_TB.click();
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser,
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3210_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3210_orgAdmin";
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
				
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				/*rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.selectTimeInRawPromoForm(time);
				Thread.sleep(2000);*/
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser,
							"orgAdmin User should be able to enter raw promo", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"orgAdmin User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	

			@Test()
			public void pramotionWaste_US1911_TC3210_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3210_operator";
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				/*rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.selectTimeInRawPromoForm(time);
				Thread.sleep(2000);*/
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser,
							"operator User should be able to enter raw promo", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"operator User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3210_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3210_level1";
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				
				
				String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String innerPackQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				String looseUnitQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				/*rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.selectTimeInRawPromoForm(time);
				Thread.sleep(2000);*/
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser,
							"level1 User should be able to enter raw promo", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"level1 User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
					
//TC3211 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter completed waste.
			@Test(enabled=false,groups="Smoke")
			public void pramotionWaste_US1911_TC3211_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3211_Supervisor";
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String menuItemId = GlobalVariable.completedWasteWrin1;
				
				String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				/*completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.selectTimeInCompletedWasteForm(time);
				Thread.sleep(2000);*/
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				completedWastePage.CompletedWastePopUp_QuantityWasted_TB.click();
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment";
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String menuItemId = GlobalVariable.completedWasteWrin1;
				
				String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				/*completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.selectTimeInCompletedWasteForm(time);
				Thread.sleep(2000);*/
				completedWastePage.CompletedWastePopUp_SearchBox_TB.click();
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3211_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3211_orgAdmin";
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String menuItemId = GlobalVariable.completedWasteWrin1;
				
				String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				/*completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.selectTimeInCompletedWasteForm(time);
				Thread.sleep(2000);*/
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, 
							"orgAdmin User should be able to enter completed Waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"orgAdmin User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	

			@Test()
			public void pramotionWaste_US1911_TC3211_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3211_operator";
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				
//				String createDate=GlobalVariable.createDate;
				String createDate=GlobalVariable.createDate;
				
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				/*completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.selectTimeInCompletedWasteForm(time);
				Thread.sleep(2000);*/
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"operator User should be able to enter completed Waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"operator User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
		
			@Test()
			public void pramotionWaste_US1911_TC3211_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="pramotionWaste_US1911_TC3211_level1";
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
				String createDate=GlobalVariable.createDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = Integer.toString(Base.generateNdigitRandomNumber(1));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				/*completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.selectTimeInCompletedWasteForm(time);
				Thread.sleep(2000);*/
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				/*Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);*/
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(promotionAndWastePage.PromotionAndWaste_Title));
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser,
							"level1 User should be able to enter completed Waste", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"level1 User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
					
}
