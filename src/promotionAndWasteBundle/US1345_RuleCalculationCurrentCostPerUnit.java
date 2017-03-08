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

public class US1345_RuleCalculationCurrentCostPerUnit extends AbstractTest
{
	
	
	//TC4497 : View the cost of wrin on raw waste and raw promo page
	
	@Test()
	public void pramotionWaste_US1345_TC4497() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1345_TC4497";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		/*String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String time = GlobalVariable.time;*/
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);

		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		/*// Create a raw waste entry
		rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(1500);
		rawItemWastePage.selectTimeInRawWasteForm(time);*/
		Thread.sleep(1500);
		rawItemWastePage.addARawItem(samplewRINID, "","", looseUnitQuantity);
		// Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount " + wasteAmount);
		//Click on cancel button
		rawItemWastePage.Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.CancelRawWastePopUp_Confirmation_Message));
		rawItemWastePage.RawWasteEntryConfirmation_PopUp_YES_BT.click();
		Thread.sleep(3000);
		
		promotionAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		/*// Create a raw waste entry
		rawItemPromoPage.selectDateForRawPromo(createDate);
		Thread.sleep(1500);
		rawItemPromoPage.selectTimeInRawPromoForm(time);*/
		Thread.sleep(1500);
		rawItemPromoPage.addARawPromoItem(samplewRINID, "","", looseUnitQuantity);
		// Get the total waste amount
		String promoAmount = rawItemPromoPage.getTotalPromoAmount();
		System.out.println("wasteAmount " + promoAmount);
		if(wasteAmount.equalsIgnoreCase(promoAmount))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view same sub-total for wrin=a on both raw waste and raw promo for quantity=x", "Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view same sub-total for wrin=a on both raw waste and raw promo for quantity=x", "Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
