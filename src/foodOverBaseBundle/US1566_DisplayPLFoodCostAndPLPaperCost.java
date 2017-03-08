package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.AbstractTest;

public class US1566_DisplayPLFoodCostAndPLPaperCost extends AbstractTest{
	
	//TC2747: Verify calculation of Total P&L Food Cost $ section.
	@Test()
	public void foodOverBase_US1566_TC2747() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1566_TC2747";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		foodOverBasePage.MonthEnd_BT.click();
		// Verify that Difference percentage column is displaying
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_TotalPLFoodCost_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_TotalPLPaperCost_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_BeginingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodPurchases_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodTransfers_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodPromotions_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_EndingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_Total_Label)) {
			Reporter.reportPassResult(browser,
					"Below components should be displayed under Total P&L Food Cost header with dollar amount: Beginning Inventory Food Purchases Food Transfers Food Promotion Ending Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Below components should be displayed under Total P&L Food Cost header with dollar amount: Beginning Inventory Food Purchases Food Transfers Food Promotion Ending Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal beginingInventoryAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_BeginingInventory_Value.getText().replace("$", ""));
		BigDecimal foodPurchasesAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_FoodPurchases_Value.getText().replace("$", ""));
		BigDecimal foodTransfersAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_FoodTransfers_Value.getText().replace("$", ""));
		String transferSign = foodOverBasePage.MonthEnd_PlFoodCost_FoodTransfers_Sign.getText();
		if(transferSign.equals("-")){
			foodTransfersAmount = foodTransfersAmount.negate();
		}
		BigDecimal foodPromotionsAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_FoodPromotions_Value.getText().replace("$", ""));
		BigDecimal endingInventoryAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_EndingInventory_Value.getText().replace("$", ""));
		BigDecimal totalAmount = new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_Total_Value.getText().replace("$", ""));
		
		BigDecimal expectedTotal = beginingInventoryAmount.add(foodPurchasesAmount).add(foodTransfersAmount).subtract(foodPromotionsAmount).subtract(endingInventoryAmount);
		System.out.println("expectedTotal "+expectedTotal);
		System.out.println("totalAmount "+totalAmount);
		if (expectedTotal.equals(totalAmount)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC2749: Verify the calculation of Total P&L Paper Cost $.
	@Test()
	public void foodOverBase_US1566_TC2749() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1566_TC2749";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		foodOverBasePage.MonthEnd_BT.click();
		// Verify that Difference percentage column is displaying
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_TotalPLFoodCost_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_TotalPLPaperCost_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_BeginingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperPurchases_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperTransfers_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperPromotions_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_EndingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_Total_Label)) {
			Reporter.reportPassResult(browser,
					"Below components should be displayed under Total P&L Paper Cost  header with dollar amount: Beginning Inventory Paper Purchases Paper Transfers Paper Promotion Ending Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"Below components should be displayed under Total P&L Paper Cost  header with dollar amount: Beginning Inventory Paper Purchases Paper Transfers Paper Promotion Ending Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal beginingInventoryAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_BeginingInventory_Value.getText().replace("$", ""));
		BigDecimal paperPurchasesAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_PaperPurchases_Value.getText().replace("$", ""));
		BigDecimal paperTransfersAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_PaperTransfers_Value.getText().replace("$", ""));
		BigDecimal paperPromotionsAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_PaperPromotions_Value.getText().replace("$", ""));
		BigDecimal endingInventoryAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_EndingInventory_Value.getText().replace("$", ""));
		BigDecimal totalAmount = new BigDecimal(foodOverBasePage.MonthEnd_PLPaperCost_Total_Value.getText().replace("$", ""));
		
		BigDecimal expectedTotal = beginingInventoryAmount.add(paperPurchasesAmount).add(paperTransfersAmount).subtract(paperPromotionsAmount).subtract(endingInventoryAmount);
		System.out.println("expectedTotal "+expectedTotal);
		System.out.println("totalAmount "+totalAmount);
		if (expectedTotal.equals(totalAmount)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Total P&L Food Cost header for each moth selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}

}
