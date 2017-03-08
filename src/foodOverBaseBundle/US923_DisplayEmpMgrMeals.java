package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US923_DisplayEmpMgrMeals extends AbstractTest{
	
	//TC2552: As a manager, I need to be able to view the Employee/Manager Food $ and % so that I can track progress towards meeting my target goal.
	@Test()
	public void foodOverBase_US923_TC2552() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2552";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String actualPercentage = foodOverBasePage.CurrentMonth_EmpMgrMeals_DifferencePercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = foodOverBasePage.CurrentMonth_EmpMgrMeals_DifferenceDoller_Value.getText().replace("$", "").trim();
		BigDecimal actualDoller;
		if(diff.contains("-")){
			actualDoller = new BigDecimal(diff.replace("-", "").trim()).negate();
		}else{
			actualDoller = new BigDecimal(diff);
		}
		System.out.println("doller : "+ actualDoller);
		BigDecimal netSales = new BigDecimal(foodOverBasePage.CurrentMonth_NetSales_Value.getText().replace("$", ""));
		BigDecimal calculatedPercent = actualDoller.divide(netSales,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
		System.out.println("calculatedPercent   "+calculatedPercent);
		BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
		System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
		if(calculatedPercent1.equals(actual) || calculatedPercent2.equals(actual)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2553: As a manager, I need to be able to view the Employee/Manager Food $ and % so that I can track progress towards meeting my target goal.
	@Test()
	public void foodOverBase_US923_TC2553() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2553";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		if (foodOverBasePage.CurrentMonth_EmpMgrMeals_DifferenceDoller_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost $= $x.xx in the Month to Date (Actual) $ column in the Current Month section which is in proper dollar format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2554: Verify that the user is able to view the month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column on the Food Over Base landing page in the Current Month section.
	@Test()
	public void foodOverBase_US923_TC2554() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2554";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		BigDecimal target = new BigDecimal(foodOverBasePage.CurrentMonth_EmpMgrMeals_TargetPercent_Value.getText().replace("%", "").replace("-", "").trim());
		System.out.println("target % : "+ target);
		String actualPercentage = foodOverBasePage.CurrentMonth_EmpMgrMeals_AcutalPercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = foodOverBasePage.CurrentMonth_EmpMgrMeals_DifferencePercent_Value.getText().replace("%", "").trim();
		System.out.println("diff % : "+ diff);
		BigDecimal calculatedPercent = target.subtract(actual);
		System.out.println("calculatedDiff % : "+ calculatedPercent);
		System.out.println("Result is "+calculatedPercent.toString().equals(diff));
		if (calculatedPercent.toString().equals(diff)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Current Month section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Current Month section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2555: Verify that the user is able to view the month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column on the Food Over Base landing page in the Current Month section in proper percentage format..
	@Test()
	public void foodOverBase_US923_TC2555() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2555";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String empMgrMealsPercent = foodOverBasePage.CurrentMonth_EmpMgrMeals_DifferencePercent_Value.getText().trim();
		if (empMgrMealsPercent.substring(empMgrMealsPercent.length()-1,empMgrMealsPercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the month to date Employee/Manager Food Cost %= x.xx% in the Month to Date (Actual) % column in the Current Month section which is in proper percentage format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the month to date Employee/Manager Food Cost %= x.xx% in the Month to Date (Actual) % column in the Current Month section which is in proper percentage format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2556: Verify that the user is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column on the Food Over Base landing page in the Historical Month section
	@Test()
	public void foodOverBase_US923_TC2556() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2556";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "Projections_BT");
		if (!foodOverBasePage.Historicals_EmpMgrMeals_PastMonth1_Value.getText().isEmpty()
				& !foodOverBasePage.Historicals_EmpMgrMeals_PastMonth2_Value.getText().isEmpty()
				& !foodOverBasePage.Historicals_EmpMgrMeals_PastMonth3_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Historical Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Historical Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2557: Verify that the user is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column on the Food Over Base landing page in the Historical Month section in proper dollar format.
	@Test()
	public void foodOverBase_US923_TC2557() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2557";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "Projections_BT");
		String empMgrMealsPercent1 = foodOverBasePage.Historicals_EmpMgrMeals_PastMonth1_Value.getText().trim();
		String empMgrMealsPercent2 = foodOverBasePage.Historicals_EmpMgrMeals_PastMonth2_Value.getText().trim();
		String empMgrMealsPercent3 = foodOverBasePage.Historicals_EmpMgrMeals_PastMonth3_Value.getText().trim();
		if (empMgrMealsPercent1.substring(empMgrMealsPercent1.length()-1,empMgrMealsPercent1.length()).equals("%")
				& empMgrMealsPercent2.substring(empMgrMealsPercent2.length()-1,empMgrMealsPercent2.length()).equals("%")
				& empMgrMealsPercent3.substring(empMgrMealsPercent3.length()-1,empMgrMealsPercent3.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2558: Verify that the user is able to view Employee/Manager Food Cost % and (Actual) % column on the Food Over Base landing page in  month to date,historical and month end section.
	@Test()
	public void foodOverBase_US923_TC2558() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2558";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "MonthEnd_BT");
		String empMgrMealsTargetPercent = foodOverBasePage.MonthEnd_EmpMgrMeals_TargetPercent_Value.getText().trim();
		String empMgrMealsAcutalPercent = foodOverBasePage.MonthEnd_EmpMgrMeals_AcutalPercent_Value.getText().trim();
		String empMgrMealsDifferencePercent = foodOverBasePage.MonthEnd_EmpMgrMeals_DifferencePercent_Value.getText().trim();
		if (!empMgrMealsTargetPercent.isEmpty()
				& !empMgrMealsAcutalPercent.isEmpty()
				& !empMgrMealsDifferencePercent.isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the  month end section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in the  month end section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (empMgrMealsTargetPercent.substring(empMgrMealsTargetPercent.length()-1,empMgrMealsTargetPercent.length()).equals("%")
				& empMgrMealsAcutalPercent.substring(empMgrMealsAcutalPercent.length()-1,empMgrMealsAcutalPercent.length()).equals("%")
				& empMgrMealsDifferencePercent.substring(empMgrMealsDifferencePercent.length()-1,empMgrMealsDifferencePercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2559: Verify that the user is able to view Employee/Manager Food Cost % and (Actual) % column on the Food Over Base landing page in  month to date,historical and month end section in proper dollar format.
	@Test()
	public void foodOverBase_US923_TC2559() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US923_TC2559";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "MonthEnd_BT");
		String empMgrMealsDifferencePercent = foodOverBasePage.MonthEnd_EmpMgrMeals_DifferencePercent_Value.getText().replace("%", "").trim();
		if (foodOverBasePage.MonthEnd_EmpMgrMeals_DifferenceDollar_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Employee/Manager Food Cost $= $x.xx in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal actual;
		if(empMgrMealsDifferencePercent.contains("-")){
			actual = new BigDecimal(empMgrMealsDifferencePercent.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(empMgrMealsDifferencePercent);
		}
		System.out.println("actual % : "+ actual);
		String differenceDollar = foodOverBasePage.MonthEnd_EmpMgrMeals_DifferenceDollar_Value.getText().replace("$", "").trim();
		System.out.println("doller : "+ differenceDollar);
		BigDecimal netSales = new BigDecimal(foodOverBasePage.MonthEnd_NetSales_Value.getText().replace("$", ""));
		BigDecimal calculatedDoller = actual.multiply(netSales).divide(new BigDecimal(100));
		BigDecimal calculatedDoller1 = calculatedDoller.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal calculatedDoller2 = calculatedDoller.setScale(2, BigDecimal.ROUND_UP);
		System.out.println("expected doller   "+calculatedDoller1+"2 "+calculatedDoller2);
		if(calculatedDoller1.toString().equals(differenceDollar) || calculatedDoller2.toString().equals(differenceDollar)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Month end section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Employee/Manager Food Cost $ in the Month to Date (Actual) $ column in the Month end section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
