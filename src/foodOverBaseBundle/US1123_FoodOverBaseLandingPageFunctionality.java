package foodOverBaseBundle;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US1123_FoodOverBaseLandingPageFunctionality extends AbstractTest{

	//TC4149: Verify that the user is able to view 3 tabs on the Food Over Base Landing page.
	@Test(groups="Smoke")
	public void foodOverBase_US1123_TC4149() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1123_TC4149";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		if (Base.isElementDisplayed(foodOverBasePage.Projections_BT)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_BT)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view 3 tabs on FOB landing page: Current Month Projections Month End",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view 3 tabs on FOB landing page: Current Month Projections Month End",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4150: Verify the landing page of current month tab's default view
	@Test(groups="Smoke")
	public void foodOverBase_US1123_TC4150() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1123_TC4150";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String currentMonthcomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		Calendar c = Calendar.getInstance();
		String currentMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String monthYear = currentMonth + " " + year;
		if (foodOverBasePage.CurrentMonth_Title_Label.getText().contains("Current Month-to-Date: "+monthYear)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view name and year of the month for the current month displayed",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view name and year of the month for the current month displayed",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_CompletedWaste_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_RawWaste_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Condiments_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_EmpMgrMeals_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_DiscountCoupons_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_StatVariance_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Unexplained_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Totals_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view below mentioned info in the first column: Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained Totals",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view below mentioned info in the first column: Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained Totals",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Target_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Actual_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_DifferencePercentage_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_DifferenceDoller_Column_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view below mentioned columns for each FOB contributors: Target Actual Difference % Difference $",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view below mentioned columns for each FOB contributors: Target Actual Difference % Difference $",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_BaseFood_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_FoodOverBase_Label)
				& Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Total_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthToDateProductNetSales_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view  info for base food, food over base, total and month-to-date product net sales",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view  info for base food, food over base, total and month-to-date product net sales",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_Comments_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Current Month factors impacting food cost comments on Current Month Tab.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Current Month factors impacting food cost comments on Current Month Tab.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
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
					"User save the comments with success message, current month comments saved",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User save the comments with success message, current month comments saved",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4151: Verify the default view of projections tab on FOB page
	@Test(groups="Smoke")
	public void foodOverBase_US1123_TC4151() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1123_TC4151";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String projectionscomments = "TestAuto_"+Base.generateNdigitRandomNumber(3);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		foodOverBasePage.Projections_BT.click();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH ,1);
		String currentMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String monthYear = currentMonth + " " + year;
		if (foodOverBasePage.Projections_Title_Label.getText().contains("Projections for: "+monthYear)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view projections of next month",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view projections of next month",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.Projections_NetSales_Label)
				& Base.isElementDisplayed(foodOverBasePage.Projections_BaseFoodTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_CompletedWasteTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_RawWasteTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_CondimentsTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_EmpMgrMealsTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_DiscountCouponsTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_StatVarianceTarget_TB)
				& Base.isElementDisplayed(foodOverBasePage.Projections_UnexplainedTarget_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view below mentioned info in projections column : Product Net Sales Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view below mentioned info in projections column : Product Net Sales Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (!foodOverBasePage.Projections_NetSalesProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_BaseFoodProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_CompletedWasteProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_RawWasteProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_CondimentsProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_EmpMgrMealsProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_DiscountCouponsProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_StatVarianceProjected_Value.getText().isEmpty()
				& !foodOverBasePage.Projections_UnexplainedProjected_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view projected * and new targets for each of the projections",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view projected * and new targets for each of the projections",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.Projections_Comments_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the comments for past 3 months factors impacting food cost",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the comments for past 3 months factors impacting food cost",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH ,-1);
		String pastMonth1 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		String monthYear1 = pastMonth1 + " " + year;
		System.out.println("previousMonth "+monthYear1);
		
		c2.add(Calendar.MONTH ,-1);
		String pastMonth2 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		String monthYear2 = pastMonth2 + " " + year;
		System.out.println("previousMonth "+monthYear2);
		
		c2.add(Calendar.MONTH ,-1);
		String pastMonth3 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		String monthYear3 = pastMonth3 + " " + year;
		System.out.println("previousMonth "+monthYear3);
		if(Base.isElementDisplayed(foodOverBasePage.Historicals_Column_Label)
				& foodOverBasePage.Historicals_PastMonth1Column_Label.getText().equals(monthYear1)
				& foodOverBasePage.Historicals_PastMonth2Column_Label.getText().equals(monthYear2)
				& foodOverBasePage.Historicals_PastMonth3Column_Label.getText().equals(monthYear3)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view past 3 months' final Food Over Base component calculations ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view past 3 months' final Food Over Base component calculations",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		if(foodOverBasePage.verifyHistoricalProjectionsDataDisplayed()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view past 3 months' final Food Over Base component calculations which includes data for Product Net Sales Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view past 3 months' final Food Over Base component calculations which includes data for Product Net Sales Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(foodOverBasePage.verifyCommentsDisplayedForLastThreeMonths()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the comments for past 3 months factors impacting food cost",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the comments for past 3 months factors impacting food cost",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int currentyear = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+currentyear;
		Date twentythDate = dateFormat.parse(date2);
		if (date.after(twentythDate) || date.equals(twentythDate)) {
			wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_EditTargets_BT)).click();
			Thread.sleep(1000);
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
		}else{
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
		Thread.sleep(5000);
		foodOverBasePage.Projections_BT.click();
		Select selectProjectionDD = new Select(foodOverBasePage.Historicals_SelectProjections_DD);
		selectProjectionDD.selectByIndex(1);
		Thread.sleep(5000);
		c2.add(Calendar.MONTH ,-1);
		String pastMonth4 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		String monthYear4 = pastMonth4 + " " + year;
		System.out.println("previousMonth "+monthYear4);
		if(Base.isElementDisplayed(foodOverBasePage.Historicals_Column_Label)
				& foodOverBasePage.Historicals_PastMonth1Column_Label.getText().equals(monthYear2)
				& foodOverBasePage.Historicals_PastMonth2Column_Label.getText().equals(monthYear3)
				& foodOverBasePage.Historicals_PastMonth3Column_Label.getText().equals(monthYear4)){
			Reporter.reportPassResult(
					browser,
					"User should be able to change historical month and view information related to historical month selected ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to change historical month and view information related to historical month selected",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC4152: Verify the default view of month-end tab on FOB page
	@Test(groups="Smoke")
	public void foodOverBase_US1123_TC4152() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1123_TC4152";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		foodOverBasePage.MonthEnd_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_CompletedWaste_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_RawWaste_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Condiments_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_EmpMgrMeals_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_DiscountCoupons_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_StatVariance_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Unexplained_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Totals_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view below mentioned info in the first column: Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained Totals",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view below mentioned info in the first column: Base Food Completed Waste Raw Waste Condiments Emp/Mgr Meals Discount/Coupons Stat Variance Unexplained Totals",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_DifferencePercentage_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_DifferenceDoller_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Target_Column_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Actual_Column_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view below mentioned columns for each food cost: Target Actual Difference % Difference $",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view below mentioned columns for each food cost: Target Actual Difference % Difference $",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_BaseFood_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_FoodOverBase_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_Total_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_ProductNetSales_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_TotalPaperCost_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view total food cost info which includes data for base food, food over base, total, product net sales and total paper cost",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view total food cost info which includes data for base food, food over base, total, product net sales and total paper cost",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_BeginingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodPurchases_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodTransfers_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_FoodPromotions_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_EndingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PlFoodCost_Total_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view total P&L food cost which includes data for beginning inventory, food purchase, food transfers, food promotions, ending inventory and total for month selected",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, 
					"User should be able to view total P&L food cost which includes data for beginning inventory, food purchase, food transfers, food promotions, ending inventory and total for month selected",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_BeginingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperPurchases_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperTransfers_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_PaperPromotions_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_EndingInventory_Label)
				& Base.isElementDisplayed(foodOverBasePage.MonthEnd_PLPaperCost_Total_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view total total P&L paper cost which includes data for beginning inventory, food purchase, food transfers, food promotions, ending inventory and total for month selected",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view total P&L paper cost which includes data for beginning inventory, food purchase, food transfers, food promotions, ending inventory and total for month selected",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_Comments_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view last month's factors impacting food cost comments on this tab",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view last month's factors impacting food cost comments on this tab",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Select selectMonthDD = new Select(foodOverBasePage.MonthEnd_SelectMonth_DD);
		selectMonthDD.selectByIndex(1);
		Thread.sleep(5000);
		String selectedMonth = selectMonthDD.getFirstSelectedOption().getText().trim();
		System.out.println("selectedMonth"+selectedMonth);
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.MONTH ,-2);
		String pastMonth1 = c2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String monthYear1 = pastMonth1 + " " + year;
		System.out.println("previousMonth "+monthYear1);
		if (selectedMonth.contains(monthYear1)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the method to change the month from drop down",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the method to change the month from drop down",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}

}
