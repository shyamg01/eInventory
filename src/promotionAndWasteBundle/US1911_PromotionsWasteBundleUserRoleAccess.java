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
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;
import sprint2.AbstractTest;

public class US1911_PromotionsWasteBundleUserRoleAccess extends AbstractTest{
	
	//TC3206 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user have access to enter raw waste.
	@Test()
	public void pramotionWaste_US1911_TC3206_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String caseQuantity = "2";
		String innerPackQuantity = "7";
		String looseUnitQuantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(10000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3206_Level2",
					"Level 2 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3206_Level2","pramotionWaste_US1911_TC3206_Level2",
					"Level 2 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3206_Level2");
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String createDate=GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String caseQuantity = "2";
		String innerPackQuantity = "7";
		String looseUnitQuantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3206_Level3",
					"Level 3 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3206_Level3","pramotionWaste_US1911_TC3206_Level3",
					"Level 3 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3206_Level3");
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String createDate=GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String caseQuantity = "3";
		String innerPackQuantity = "5";
		String looseUnitQuantity = "1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3206_Level4",
					"Level 4 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3206_Level4","pramotionWaste_US1911_TC3206_Level4",
					"Level 4 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3206_Level4");
		}
	}
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String caseQuantity = "1";
		String innerPackQuantity = "6";
		String looseUnitQuantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3206_Level5",
					"Level 5 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3206_Level5","pramotionWaste_US1911_TC3206_Level5",
					"Level 5 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3206_Level5");
		}
	}
	
	
	@Test()
	public void pramotionWaste_US1911_TC3206_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		String createDate=GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;

		String caseQuantity = "1";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "1";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		// Create a raw waste entry
		rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		// Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3206_Level6",
					"Level 6 User should be able to enter raw waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3206_Level6","pramotionWaste_US1911_TC3206_Level6",
					"Level 6 User should be able to enter raw waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3206_Level6");
		}
	}
	
	

	//TC3207 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user have access to enter completed waste.
	@Test()
	public void pramotionWaste_US1911_TC3207_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = "8";
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(3000);
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3207_level2",
					"level2 User should be able to enter completed Waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3207_level2","pramotionWaste_US1911_TC3207_level2",
					"level2 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3207_level2");
		}
	}	


	@Test()
	public void pramotionWaste_US1911_TC3207_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = "7";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(3000);
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3207_level3",
					"level3 User should be able to enter completed Waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3207_level3","pramotionWaste_US1911_TC3207_level3",
					"level3 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3207_level3");
		}
	}	



	@Test()
	public void pramotionWaste_US1911_TC3207_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = "6";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(3000);
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3207_level4",
					"level4 User should be able to enter completed Waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3207_level4","pramotionWaste_US1911_TC3207_level4",
					"level4 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3207_level4");
		}
	}	



	@Test()
	public void pramotionWaste_US1911_TC3207_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(3000);
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3207_level5",
					"level5 User should be able to enter completed Waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3207_level5","pramotionWaste_US1911_TC3207_level5",
					"level5 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3207_level5");
		}
	}	


	@Test()
	public void pramotionWaste_US1911_TC3207_level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String menuItemId = GlobalVariable.completedWasteWrin1;
		String quantity = "4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(3000);
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
		// Get the total waste amount
		String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount " + completedWasteAmount);
		// Submit the raw waste entry
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
		completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(5000);
		promotionAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1911_TC3207_level6",
					"level6 User should be able to enter completed Waste", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1911_TC3207_level6","pramotionWaste_US1911_TC3207_level6",
					"level6 User should be able to enter completed Waste", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3207_level6");
		}
	}	
	
	//TC3208 : Verify that Level 2, Level 3, Level 4, Level 5 and Level 6 user cannot enter raw promo.
		@Test()
		public void pramotionWaste_US1911_TC3208_Level2() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level2_SSO_Password;
			String userId = LoginTestData.level2_SSO_UserId;
			String storeId = LoginTestData.level2StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.navigateToInventoryManagement().goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1911_TC3208_Level2",
						"Level 2 User should not be able to enter raw Promo", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1911_TC3208_Level2","pramotionWaste_US1911_TC3208_Level2",
						"Level 2 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3208_Level2");
			}
		}
	
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level3() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level3_SSO_Password;
			String userId = LoginTestData.level3_SSO_UserId;
			String storeId = LoginTestData.level3StoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.navigateToInventoryManagement().goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1911_TC3208_Level3",
						"Level 3 User should not be able to enter raw Promo", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1911_TC3208_Level3","pramotionWaste_US1911_TC3208_Level3",
						"Level 3 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3208_Level3");
			}
		}
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level4() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level4_SSO_Password;
			String userId = LoginTestData.level4_SSO_UserId;
			String storeId = LoginTestData.level4StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).navigateToInventoryManagement().goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1911_TC3208_Level4",
						"Level 4 User should not be able to enter raw Promo", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1911_TC3208_Level5","pramotionWaste_US1911_TC3208_Level4",
						"Level 4 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3208_Level4");
			}
		}
	
	
		@Test()
		public void pramotionWaste_US1911_TC3208_Level5() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level5_SSO_Password;
			String userId = LoginTestData.level5_SSO_UserId;
			String storeId = LoginTestData.level5StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).navigateToInventoryManagement().goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1911_TC3208_Level5",
						"Level 5 User should not be able to enter raw Promo", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1911_TC3208_Level5","pramotionWaste_US1911_TC3208_Level5",
						"Level 5 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3208_Level5");
			}
		}
	
	

		@Test()
		public void pramotionWaste_US1911_TC3208_Level6() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.level6_SSO_Password;
			String userId = LoginTestData.level6_SSO_UserId;
			String storeId = LoginTestData.level6StoreId;
		
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).navigateToInventoryManagement().goToPromotionsAndWastePage();
			
			// Verify that raw promo button is not displaying
			if(!Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT)) {
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1911_TC3208_Level6",
						"Level 6 User should not be able to enter raw Promo", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1911_TC3208_Level6","pramotionWaste_US1911_TC3208_Level6",
						"Level 6 User should not be able to enter raw Promo", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3208_Level6");
			}
		}
	
	
		
		//TC3209 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter raw waste..
		
		
			@Test()
			public void pramotionWaste_US1911_TC3209_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "1";
				String innerPackQuantity = "1";
				String looseUnitQuantity = "7";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3209_Supervisor",
							"Supervisor User should be able to enter raw waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3209_Supervisor","pramotionWaste_US1911_TC3209_Supervisor",
							"Supervisor User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3209_Supervisor");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "2";
				String innerPackQuantity = "2";
				String looseUnitQuantity = "6";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment",
							"Supervisor w/ Role Assignment User should be able to enter raw waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment","pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment",
							"Supervisor w/ Role Assignment User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3209_supervisorWithRoleAssignment");
				}
			}	
		
		
		
			@Test()
			public void pramotionWaste_US1911_TC3209_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "1";
				String innerPackQuantity = "3";
				String looseUnitQuantity = "5";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3209_orgAdmin",
							"orgAdmin User should be able to enter raw waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3209_orgAdmin","pramotionWaste_US1911_TC3209_orgAdmin",
							"orgAdmin User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3209_orgAdmin");
				}
			}	
		
		

			@Test()
			public void pramotionWaste_US1911_TC3209_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "1";
				String innerPackQuantity = "4";
				String looseUnitQuantity = "4";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT));
				rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3209_operator",
							"operatorUser should be able to enter raw waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3209_operator","pramotionWaste_US1911_TC3209_operator",
							"operator User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3209_operator");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3209_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "7";
				String innerPackQuantity = "5";
				String looseUnitQuantity = "1";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
				// Create a raw waste entry
				rawItemWastePage.addARawItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
				System.out.println("wasteAmount " + wasteAmount);
				// Submit the raw waste entry
				rawItemWastePage.Submit_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawWasteEntryPresent(createDate, wasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3209_level1",
							"level1 should be able to enter raw waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3209_level1","pramotionWaste_US1911_TC3209_level1",
							"level1 User should be able to enter raw waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3209_level1");
				}
			}	
	
			//TC3210 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter raw promo.
			@Test()
			public void pramotionWaste_US1911_TC3210_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "5";
				String innerPackQuantity = "2";
				String looseUnitQuantity = "9";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage =homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(4000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3210_Supervisor",
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3210_Supervisor","pramotionWaste_US1911_TC3210_Supervisor",
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3210_Supervisor");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "6";
				String innerPackQuantity = "7";
				String looseUnitQuantity = "8";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
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
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment",
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment","pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment",
							"supervisorWithRoleAssignment User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3210_supervisorWithRoleAssignment");
				}
			}	
		
		
		
			@Test()
			public void pramotionWaste_US1911_TC3210_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "4";
				String innerPackQuantity = "1";
				String looseUnitQuantity = "6";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3210_orgAdmin",
							"orgAdmin User should be able to enter raw promo", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3210_orgAdmin","pramotionWaste_US1911_TC3210_orgAdmin",
							"orgAdmin User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3210_orgAdmin");
				}
			}	
		
		

			@Test()
			public void pramotionWaste_US1911_TC3210_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "2";
				String innerPackQuantity = "7";
				String looseUnitQuantity = "5";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3210_operator",
							"operator User should be able to enter raw promo", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3210_operator","pramotionWaste_US1911_TC3210_operator",
							"operator User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3210_operator");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3210_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String samplewRINID = GlobalVariable.rawItemWatsewrin1;
				String caseQuantity = "1";
				String innerPackQuantity = "4";
				String looseUnitQuantity = "3";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.RawPromo_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
				rawItemPromoPage.selectDateForRawPromo(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				rawItemPromoPage.addARawPromoItem(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
				// Get the total waste amount
				String promoAmount = rawItemPromoPage.getTotalPromoAmount();
				System.out.println("promoAmount " + promoAmount);
				// Submit the raw waste entry
				rawItemPromoPage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT));
				rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isRawPromoEntryPresent(createDate, promoAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3210_level1",
							"level1 User should be able to enter raw promo", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3210_level1","pramotionWaste_US1911_TC3210_level1",
							"level1 User should be able to enter raw promo", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3210_level1");
				}
			}	
					
			
			
			
//TC3211 : Verify that Supervisor, Supervisor w/ Role Assignment, Org Admin, Operator and Level 1 user have access to enter completed waste.
			
			
			@Test()
			public void pramotionWaste_US1911_TC3211_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = "6";
				
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				completedWastePage.CompletedWastePopUp_QuantityWasted_TB.click();
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3211_Supervisor",
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3211_Supervisor","pramotionWaste_US1911_TC3211_Supervisor",
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3211_Supervisor");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = "5";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.CompletedWastePopUp_SearchBox_TB.click();
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment",
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment","pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment",
							"supervisorWithRoleAssignment User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3211_supervisorWithRoleAssignment");
				}
			}	
		
		
		
			@Test()
			public void pramotionWaste_US1911_TC3211_orgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.orgAdmin_SSO_Password;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String storeId = LoginTestData.orgAdminStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = "2";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3211_orgAdmin",
							"orgAdmin User should be able to enter completed Waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3211_orgAdmin","pramotionWaste_US1911_TC3211_orgAdmin",
							"orgAdmin User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3211_orgAdmin");
				}
			}	
		
		

			@Test()
			public void pramotionWaste_US1911_TC3211_operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = "6";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3211_operator",
							"operator User should be able to enter completed Waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3211_operator","pramotionWaste_US1911_TC3211_operator",
							"operator User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3211_operator");
				}
			}	
		
		
			@Test()
			public void pramotionWaste_US1911_TC3211_level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				String password = LoginTestData.level1_SSO_Password;
				String userId = LoginTestData.level1_SSO_UserId;
				String storeId = LoginTestData.level1StoreId;
				String createDate=GlobalVariable.createDate;
				String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
				String menuItemId = GlobalVariable.completedWasteWrin1;
				String quantity = "5";
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
				// Navigate to Promotion and waste page
				PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
						.navigateToInventoryManagement().goToPromotionsAndWastePage();
				// CLick on Raw Waste Button
				promotionAndWastePage.CompletedWaste_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
				completedWastePage.selectDateForRawWaste(createDate);
				Thread.sleep(3000);
				// Create a raw waste entry
				completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, quantity);
				// Get the total waste amount
				String completedWasteAmount = completedWastePage.getTotalCompletedWasteAmount();
				System.out.println("wasteAmount " + completedWasteAmount);
				// Submit the raw waste entry
				completedWastePage.Submit_BT.click();
				wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT));
				completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT.click();
				Thread.sleep(5000);
				promotionAndWastePage.selectStartDate(stratDate);
				Thread.sleep(2000);
				promotionAndWastePage.ShowResults_BT.click();
				Thread.sleep(10000);
				// Verify that raw waste entry should displayed in Promotion and waste page
				if (promotionAndWastePage.isCompletedWasteEntryPresent(createDate, completedWasteAmount)) {
					Reporter.reportPassResult(
							browser, "pramotionWaste_US1911_TC3211_level1",
							"level1 User should be able to enter completed Waste", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser, "pramotionWaste_US1911_TC3211_level1","pramotionWaste_US1911_TC3210_level1",
							"level1 User should be able to enter completed Waste", "Fail");
					AbstractTest.takeSnapShot("pramotionWaste_US1911_TC3211_level1");
				}
			}	
					
}
