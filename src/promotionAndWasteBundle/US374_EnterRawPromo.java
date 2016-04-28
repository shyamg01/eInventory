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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;
import sprint2.AbstractTest;

public class US374_EnterRawPromo extends AbstractTest{
	
	//TC1751: Verify that the user should be able to initiate a Raw Promo entry.
	@Test()
	public void promotionWaste_US374_TC1751() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String wrinId2 = GlobalVariable.rawItemPromowrin2;
		String caseQuantity = "3";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//String time = rawItemPromoPage.getTimeToSet();
		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId2);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId2, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String wasteAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("wasteAmount " + wasteAmount);
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		if (Base.isElementDisplayed(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG)) {
			Reporter.reportPassResult(
					browser, "promotionWaste_US374_TC1751",
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US374_TC1751_Condition1","promotionWaste_US374_TC1751",
					"User should be able to view success message on adding a wrin in Raw Waste Form", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US374_TC1751_Condition1");
		}
		Thread.sleep(3000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(8000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (!wasteAmount.equals("0.00") & promotionsAndWastePage.isRawPromoEntryPresent(createDate, wasteAmount)) {
			Reporter.reportPassResult(
					browser, "promotionWaste_US374_TC1751",
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US374_TC1751_Condition4","promotionWaste_US374_TC1751",
					"User should be able to enter raw Promo and promo entry should display in Promotion and Waste history Table", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US374_TC1751_Condition4");
		}
	}
	
	//TC1752: Verify that the user should be able to cancel a Raw Promo entry.
	@Test()
	public void promotionWaste_US374_TC1752() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin1;
		String caseQuantity = "3";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		rawItemPromoPage.selectDateForRawPromo(createDate);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.Cancel_BT.click();
		boolean warningMsgDisplayed = Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_Window);
		rawItemPromoPage.RawPromoEntryIncomplete_PopUp_NO_BT.click();
		if(warningMsgDisplayed & !Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_NO_BT)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US374_TC1752",
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "user should be landed back to Raw Promo Scree on clicking No button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US374_TC1752_Condition1","promotionWaste_US374_TC1752",
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "user should be landed back to Raw Promo Scree on clicking No button", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US374_TC1752_Condition1");
		}
		rawItemPromoPage.Cancel_BT.click();
		warningMsgDisplayed = Base.isElementDisplayed(rawItemPromoPage.RawPromoEntryIncomplete_PopUp_Window);
		rawItemPromoPage.RawPromoEntryIncomplete_PopUp_YES_BT.click();
		Thread.sleep(3000);
		if (warningMsgDisplayed & !Base.isElementDisplayed(rawItemPromoPage.RawPromo_Title)
				& Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser, "promotionWaste_US374_TC1752",
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "Raw Promo Screen should be closed on clicking Yes button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US374_TC1752_Condition1","promotionWaste_US374_TC1752",
					"User should be able to view warning message on Canceling a Raw promo entry and"
					+ "Raw Promo Screen should be closed on clicking Yes button", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US374_TC1752_Condition1");
		}
	}
	
	//TC1754: Verify that the user should be able to view the raw promo entry on the raw item activity page.
	@Test()
	public void promotionWaste_US374_TC1754() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		int noOfPromoActivities = rawItemActivityPage.getNoumberOfPromoActivities(createDate);
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if(rawItemActivityPage.getNoumberOfPromoActivities(createDate) == noOfPromoActivities +1){
			Reporter.reportPassResult(
					browser, "promotionWaste_US374_TC1754",
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US374_TC1754","promotionWaste_US374_TC1754",
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US374_TC1754");
			
		}
	}
	
}
