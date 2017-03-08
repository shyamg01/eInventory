package foodOverBaseBundle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US1111_AbilityToViewAndEditFoodOverBaseTargetsManually extends AbstractTest{
	
	//TC2029: Verify that the user is able to edit the Targets>% column for all the fields for each controllable component listed on the Food Over Base Landing page in the projections tab.
	@Test()
	public void foodOverBase_US1111_TC2029() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1111_TC2029";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String targetValue = Base.generateDecimalRandomNumber(3).toString();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.Projections_BT.click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int year = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+year;
		Date twentythDate = dateFormat.parse(date2);
		if (date.after(twentythDate) || date.equals(twentythDate)) {
			wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_EditTargets_BT)).click();
			foodOverBasePage.editTargetPercentValues(targetValue);
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to save the values with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			foodOverBasePage.Projections_BT.click();
			if (foodOverBasePage.Projections_NetSalesTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_BaseFoodTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_CompletedWasteTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_RawWasteTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_CondimentsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_EmpMgrMealsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_DiscountCouponsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_StatVarianceTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_UnexplainedTarget_TB.getAttribute("value").equals(targetValue)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		} else {
			if (foodOverBasePage.Projections_EditTargets_BT.getAttribute("disabled").equals("true")) {
				Reporter.reportPassResult(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}
	
	/*TC2030: Verify that the percentage must be positive and can be up to the hundredths decimal place for the 
	Targets>% column of all the fields for each controllable component listed on the Food Over Base Landing page 
	in the projections tab*/
	@Test()
	public void foodOverBase_US1111_TC2030() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1111_TC2030";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String targetValue = Base.generateDecimalRandomNumber(3).toString();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.Projections_BT.click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int year = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+year;
		Date twentythDate = dateFormat.parse(date2);
		if (date.after(twentythDate) || date.equals(twentythDate)) {
			wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_EditTargets_BT)).click();
			foodOverBasePage.editTargetPercentValues(targetValue);
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to save the values with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			foodOverBasePage.Projections_BT.click();
			if (foodOverBasePage.Projections_NetSalesTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_BaseFoodTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_CompletedWasteTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_RawWasteTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_CondimentsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_EmpMgrMealsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_DiscountCouponsTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_StatVarianceTarget_TB.getAttribute("value").equals(targetValue)
					& foodOverBasePage.Projections_UnexplainedTarget_TB.getAttribute("value").equals(targetValue)) {
				Reporter.reportPassResult(browser,
						"User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		} else {
			if (foodOverBasePage.Projections_EditTargets_BT.getAttribute(
					"disabled").equals("true")) {
				Reporter.reportPassResult(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}
	
	/*TC2032:Verify that the user has the ability to edit the values of New Targets column for all the fields of 
	 * each controllable component listed and the percentage must be positive and can be up to the hundredths 
	 * decimal place*/
	@Test()
	public void foodOverBase_US1111_TC2032() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1111_TC2032";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String negativeTargetValue = "-";
		String invalidTargetValue = "1.234";
		String validTargetValue = Base.generateDecimalRandomNumber(3).toString();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.Projections_BT.click();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int year = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+year;
		Date twentythDate = dateFormat.parse(date2);
		if (date.after(twentythDate) || date.equals(twentythDate)) {
			wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_EditTargets_BT)).click();
			boolean negativeValuesNotAllowed = true;
			foodOverBasePage.Projections_NetSalesTarget_TB.clear();
			foodOverBasePage.Projections_NetSalesTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed& Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_BaseFoodTarget_TB.clear();
			foodOverBasePage.Projections_BaseFoodTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed& Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_CompletedWasteTarget_TB.clear();
			foodOverBasePage.Projections_CompletedWasteTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_RawWasteTarget_TB.clear();
			foodOverBasePage.Projections_RawWasteTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_CondimentsTarget_TB.clear();
			foodOverBasePage.Projections_CondimentsTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_EmpMgrMealsTarget_TB.clear();
			foodOverBasePage.Projections_EmpMgrMealsTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_DiscountCouponsTarget_TB.clear();
			foodOverBasePage.Projections_DiscountCouponsTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_StatVarianceTarget_TB.clear();
			foodOverBasePage.Projections_StatVarianceTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_UnexplainedTarget_TB.clear();
			foodOverBasePage.Projections_UnexplainedTarget_TB.sendKeys(negativeTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			negativeValuesNotAllowed = negativeValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			if (negativeValuesNotAllowed) {
				Reporter.reportPassResult(
						browser,
						"User should be able to enter negative values in New Targets column for all the fields for each controllable component listed.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to enter negative values in New Targets column for all the fields for each controllable component listed.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			boolean invalidValuesNotAllowed = true;
			foodOverBasePage.Projections_NetSalesTarget_TB.clear();
			foodOverBasePage.Projections_NetSalesTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_BaseFoodTarget_TB.clear();
			foodOverBasePage.Projections_BaseFoodTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_CompletedWasteTarget_TB.clear();
			foodOverBasePage.Projections_CompletedWasteTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_RawWasteTarget_TB.clear();
			foodOverBasePage.Projections_RawWasteTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_CondimentsTarget_TB.clear();
			foodOverBasePage.Projections_CondimentsTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_EmpMgrMealsTarget_TB.clear();
			foodOverBasePage.Projections_EmpMgrMealsTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_DiscountCouponsTarget_TB.clear();
			foodOverBasePage.Projections_DiscountCouponsTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_StatVarianceTarget_TB.clear();
			foodOverBasePage.Projections_StatVarianceTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			foodOverBasePage.Projections_UnexplainedTarget_TB.clear();
			foodOverBasePage.Projections_UnexplainedTarget_TB.sendKeys(invalidTargetValue);
			System.out.println("Error Message "	+ foodOverBasePage.InvalidValues_Msg.getText());
			invalidValuesNotAllowed = invalidValuesNotAllowed & Base.isElementDisplayed(foodOverBasePage.InvalidValues_Msg);
			if (invalidValuesNotAllowed) {
				Reporter.reportPassResult(
						browser,
						"User should be able to enter values more than hundredths decimal place in New Targets column for all the fields for each controllable component listed.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to enter values more than hundredths decimal place in New Targets column for all the fields for each controllable component listed.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			foodOverBasePage.editTargetPercentValues(validTargetValue);
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to save the valid values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to save the valid values with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			// foodOverBasePage.Projections_BT.click();
			if (foodOverBasePage.Projections_NetSalesTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_BaseFoodTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_CompletedWasteTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_RawWasteTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_CondimentsTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_EmpMgrMealsTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_DiscountCouponsTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_StatVarianceTarget_TB.getAttribute("value").equals(validTargetValue)
					& foodOverBasePage.Projections_UnexplainedTarget_TB.getAttribute("value").equals(validTargetValue)) {
				Reporter.reportPassResult(browser,
						"User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		} else {
			if (foodOverBasePage.Projections_EditTargets_BT.getAttribute("disabled").equals("true")) {
				Reporter.reportPassResult(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should not be able to edit projections values till 19th date of the month.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}

}
