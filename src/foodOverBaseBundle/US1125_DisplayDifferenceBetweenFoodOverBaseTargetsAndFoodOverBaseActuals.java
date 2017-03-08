package foodOverBaseBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US1125_DisplayDifferenceBetweenFoodOverBaseTargetsAndFoodOverBaseActuals extends AbstractTest{
	
	//TC2149: Verify that the user is able to view a column named "Difference %" On  Current Month and Month-End tabs.
	@Test()
	public void foodOverBase_US1125_TC2149() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1125_TC2149";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_DifferencePercentage_Column_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the column named Difference % on Current Month tab",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the column named Difference % on Current Month tab",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		foodOverBasePage.MonthEnd_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_DifferencePercentage_Column_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view the column named Difference % on on Month-End tab",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the column named Difference % on on Month-End tab",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC2150: Verify that the user is able to view the difference between the Target % and Actual % for 
	each Controllable Component listed on the Current Month and Month-End tabs on Food Over Base page.*/
	@Test()
	public void foodOverBase_US1125_TC2150() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1125_TC2150";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		if (foodOverBasePage.verifyDifferencePercentageValueForCurrentMonth()) {
			Reporter.reportPassResult(browser,
					"User should be able to view the difference between the Target % and Actual % for each Controllable Component in Difference % column for Current Month",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the difference between the Target % and Actual % for each Controllable Component in Difference % column for Current Month",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT,"MonthEnd_BT");
		if (foodOverBasePage.verifyDifferencePercentageValueForMonthEnd()) {
			Reporter.reportPassResult(browser,
					"User should be able to view the difference between the Target % and Actual % for each Controllable Component in Difference % column for Month End",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the difference between the Target % and Actual % for each Controllable Component in Difference % column for Month End",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2152: Verify that the user is able to view a column named "Difference $" on Current Month and Month- End tab.
	@Test()
	public void foodOverBase_US1125_TC2152() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1125_TC2152";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_DifferenceDoller_Column_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view the column named Difference $ on Current Month tab",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the column named Difference $ on Current Month tab",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT,"MonthEnd_BT");
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_DifferenceDoller_Column_Label)) {
			Reporter.reportPassResult(browser,
					"User should be able to view the column named Difference $ on on Month-End tab",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the column named Difference $ on on Month-End tab",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*TC2153: Verify that the user is able to view the difference between the Target $ and Actual $ for each Controllable 
	 Component listed on Current and Month- End tab.*/
	@Test()
	public void foodOverBase_US1125_TC2153() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1125_TC2153";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		if (foodOverBasePage.verifyDifferenceDollerValueForCurrentMonth()) {
			Reporter.reportPassResult(browser,
					"User should be able to view the difference between the Target $ and Actual $ for each Controllable Component in \"Difference $\" column by using the below formula: Difference $ = Target $ - Actual $",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser, 
					"User should be able to view the difference between the Target $ and Actual $ for each Controllable Component in \"Difference $\" column by using the below formula: Difference $ = Target $ - Actual $",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT,"MonthEnd_BT");
		if (foodOverBasePage.verifyDifferenceDollerValueForMonthEnd()) {
			Reporter.reportPassResult(browser,
					"User should be able to view the difference between the Target $ and Actual $ for each Controllable Component in \"Difference $\" column by using the below formula: Difference $ = Target $ - Actual $",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view the difference between the Target $ and Actual $ for each Controllable Component in \"Difference $\" column by using the below formula: Difference $ = Target $ - Actual $",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
