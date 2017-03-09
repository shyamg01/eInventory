package foodOverBaseBundle;

import java.io.IOException;

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

public class US1152_DisplayProductNetSales extends AbstractTest{
	
	//TC2168: Verify that the user is able to view the label "Product Net Sales $" in the Current Month section on the Food Over Base page.
	@Test()
	public void foodOverBase_US1152_TC2168() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1152_TC2168";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		if (Base.isElementDisplayed(foodOverBasePage.MonthToDateProductNetSales_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_NetSales_Value)) {
			Reporter.reportPassResult(browser,
					"User should be able to view the label Month to Date Product Net Sales in the Current Month section with dollar amount.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the label Month to Date Product Net Sales in the Current Month section with dollar amount.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2169: Verify that the user is able to view the label  "Product Net Sales $" in Projection Section on Food Over Base page.
	@Test()
	public void foodOverBase_US1152_TC2169() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1152_TC2169";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.Projections_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.Projections_NetSales_Label)
				& Base.isElementDisplayed(foodOverBasePage.Historicals_NetSales_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Product Net Sales $  label with dollar amount in Historical and Projection Section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Product Net Sales $  label with dollar amount in Historical and Projection Section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2170: Verify that the user is able to view label "Product Net Sales $" in Month - End section on Food Over Base page.
	@Test()
	public void foodOverBase_US1152_TC2170() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1152_TC2170";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.MonthEnd_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_ProductNetSales_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_NetSales_Value)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Product Net Sales label in Month End section with dollar amount for the month selected.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Product Net Sales label in Month End section with dollar amount for the month selected.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
