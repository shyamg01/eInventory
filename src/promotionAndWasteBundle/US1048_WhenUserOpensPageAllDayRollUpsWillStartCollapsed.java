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
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemWastePage;

public class US1048_WhenUserOpensPageAllDayRollUpsWillStartCollapsed extends AbstractTest
{

	@Test(groups="Smoke")
	public void pramotionWaste_US1048_TC1727() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1048_TC1727";
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1]/strong/i[@class='glyphicon glyphicon-chevron-down']")).size()==0) {
			Reporter.reportPassResult(
					browser,
					"Promotiona and Waste is showing in default collapse mode", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Promotiona and Waste is showing in default collapse mode", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	//TC2040 : User should be able to view the submitted raw waste and promo history details.
	@Test()
	public void pramotionWaste_US1048_TC2040() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1048_TC2040";
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String date = GlobalVariable.createDate;
		String wrinId1 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		//String eDate=GlobalVariable.eDate_7320;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		//rawItemWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Thread.sleep(2000);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		promotionsAndWastePage.clickOnDateGroup(date);
		//Click on Promotion and waste page
		try
		{
			promotionsAndWastePage.viewWasteEntry(date);
		} catch (Exception e)
		{
			promotionsAndWastePage.viewPromoEntry(date);
		}
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (Base.isElementDisplayed(By.xpath("//eb-modal[@id='waste_hist_detail_modal']/div[2][preceding-sibling::div[@style='visibility: visible;']]"))) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the submitted raw waste and promo history details", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the submitted raw waste and promo history details", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}		
}
