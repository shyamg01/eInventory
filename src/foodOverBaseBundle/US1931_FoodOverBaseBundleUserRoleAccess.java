package foodOverBaseBundle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US1931_FoodOverBaseBundleUserRoleAccess extends AbstractTest{
	
	//TC4133: Verify that level 1 user can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Level1() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Level1";
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
						"Level1 User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level1 User should be able to save the values with success message, projected fields saved",
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
						"Level1 User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level1 User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that level 2 user can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Level2() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
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
						"Level2 User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level2 User should be able to save the values with success message, projected fields saved",
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
						"Level2 User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level2 User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that level 3 user can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Level3() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
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
						"Level3 User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level3 User should be able to save the values with success message, projected fields saved",
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
						"Level3 User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level3 User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that level 4 user can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Level4() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
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
						"Level4 User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser, 
						"Level4 User should be able to save the values with success message, projected fields saved",
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
						"Level4 User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level4 User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that Supervisor can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Supervisor() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
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
						"Supervisor User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Supervisor User should be able to save the values with success message, projected fields saved",
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
						"Supervisor User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Supervisor User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that SupervisorWithRoleAssignment can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_SupervisorWithRoleAssignment() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
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
						"SupervisorWithRoleAssignment User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"SupervisorWithRoleAssignment User should be able to save the values with success message, projected fields saved",
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
						"SupervisorWithRoleAssignment User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"SupervisorWithRoleAssignment User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that OrgAdmin can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_OrgAdmin() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
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
						"OrgAdmin User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"OrgAdmin User should be able to save the values with success message, projected fields saved",
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
						"OrgAdmin User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"OrgAdmin User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4133: Verify that Operator can enter and edit target % on FOB page 
	@Test()
	public void foodOverBase_US1931_TC4133_Operator() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4133_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
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
						"Operator User should be able to save the values with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Operator User should be able to save the values with success message, projected fields saved",
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
						"Operator User should be able to view the saved target values.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Operator User should be able to view the saved target values.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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

	//TC4134: Verify that level 1 user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Level1() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"Level1 User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level1 User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Level1 User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level1 User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that level 2 user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Level2() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"Level2 User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level2 User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Level2 User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level2 User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that level 3 user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Level3() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser, 
					"Level3 User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level3 User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Level3 User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level3 User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that Level4 user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Level4() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"Level4 User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level4 User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Level4 User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Level4 User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that Supervisor user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Supervisor() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Supervisor User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Supervisor User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that SupervisorWithRoleAssignment user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_SupervisorWithRoleAssignment() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"SupervisorWithRoleAssignment User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"SupervisorWithRoleAssignment User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"SupervisorWithRoleAssignment User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"SupervisorWithRoleAssignment User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that OrgAdmin user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_OrgAdmin() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"OrgAdmin User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"OrgAdmin User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"OrgAdmin User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"OrgAdmin User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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
	
	//TC4134: Verify that Operator user can  can enter and edit Food Over Base comments
	@Test()
	public void foodOverBase_US1931_TC4134_Operator() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1931_TC4134_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Edit_BT);
		foodOverBasePage.CurrentMonth_Comments_TB.clear();
		foodOverBasePage.CurrentMonth_Comments_TB.sendKeys(currentMonthcomments);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", foodOverBasePage.CurrentMonth_Apply_BT);
		//foodOverBasePage.CurrentMonth_Apply_BT.click();
		System.out.println(foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value"));
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CommentsSaved_Confirmation_MSG)
				& foodOverBasePage.CurrentMonth_Comments_TB.getAttribute("value").equals(currentMonthcomments)) {
			Reporter.reportPassResult(
					browser,
					"Operator User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
			foodOverBasePage.Projections_Comments_TB.clear();
			foodOverBasePage.Projections_Comments_TB.sendKeys(projectionscomments);
			foodOverBasePage.Projections_ApplyTargets_BT.click();
			System.out.println(foodOverBasePage.Projections_Comments_TB.getAttribute("value"));
			if (Base.isElementDisplayed(foodOverBasePage.Projections_ChangesSaved_Confirmation_MSG)
					& foodOverBasePage.Projections_Comments_TB.getAttribute("value").equals(projectionscomments)) {
				Reporter.reportPassResult(
						browser,
						"Operator User save the comments with success message, projected fields saved",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"Operator User save the comments with success message, projected fields saved",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else {
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

	//TC4135: Verify that the level 5 and level 6 user cannot access FOB page
	@Test()
	public void foodOverBase_US1931_TC4135_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1931_TC4135_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to inventory management
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		homePage.Menu_DD_BT.click();
		//verify that user should not be able to access manual vendor page
		if (Base.isElementDisplayed(homePage.FoodOverBase_BT)) {
			Reporter.reportTestFailure(
					browser,
					"level 5 user should be restricted to view the Food Over Base page",
					"Fail");
			AbstractTest.takeSnapShot();
		} else {
			Reporter.reportPassResult(
					browser,
					"level 5 user should be restricted to view the Food Over Base page","Pass");
		}
	}
	
	//TC4135: Verify that the level 5 and level 6 user cannot access FOB page
	@Test()
	public void foodOverBase_US1931_TC4135_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1931_TC4135_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to inventory management
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		homePage.Menu_DD_BT.click();
		//verify that user should not be able to access manual vendor page
		if (Base.isElementDisplayed(homePage.FoodOverBase_BT)) {
			Reporter.reportTestFailure(
					browser,
					"level 6 user should be restricted to view the Food Over Base page",
					"Fail");
			AbstractTest.takeSnapShot();
		} else {
			Reporter.reportPassResult(
					browser,
					"level 6 user should be restricted to view the Food Over Base page","Pass");
		}
	}


}
