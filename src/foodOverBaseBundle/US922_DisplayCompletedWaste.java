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

public class US922_DisplayCompletedWaste extends AbstractTest{

	//TC2544: Verify that the user is able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column on the Food Over Base landing page in the Current Month section.
	@Test()
	public void foodOverBase_US922_TC2544() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2544";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String actualPercentage = foodOverBasePage.CurrentMonth_CompletedWaste_DifferencePercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = foodOverBasePage.CurrentMonth_CompletedWaste_DifferenceDoller_Value.getText().replace("$", "").trim();
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
					"User should be able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2545: Verify that the user is able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column on the Food Over Base landing page in the Current Month section in proper dollar format.
	@Test()
	public void foodOverBase_US922_TC2545() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2545";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		if (foodOverBasePage.CurrentMonth_CompletedWaste_DifferenceDoller_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view aggregated month to date Completed Waste Food Cost $=$x.xx in the Month to Date (Actual) $ column which is in proper dollar format in current month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date Completed Waste Food Cost $=$x.xx in the Month to Date (Actual) $ column which is in proper dollar format in current month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2546: Verify that the user is able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column on the Food Over Base landing page in the Current Month section.
	@Test()
	public void foodOverBase_US922_TC2546() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2546";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		BigDecimal target = new BigDecimal(foodOverBasePage.CurrentMonth_CompletedWaste_TargetPercent_Value.getText().replace("%", "").replace("-", "").trim());
		System.out.println("target % : "+ target);
		String actualPercentage = foodOverBasePage.CurrentMonth_CompletedWaste_AcutalPercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = foodOverBasePage.CurrentMonth_CompletedWaste_DifferencePercent_Value.getText().replace("%", "").trim();
		System.out.println("diff % : "+ diff);
		BigDecimal calculatedPercent = target.subtract(actual);
		System.out.println("calculatedDiff % : "+ calculatedPercent);
		System.out.println("Result is "+calculatedPercent.toString().equals(diff));
		if (calculatedPercent.toString().equals(diff)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2547: Verify that the user is able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column on the Food Over Base landing page in the Current Month section in proper percentage format.
	@Test()
	public void foodOverBase_US922_TC2547() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2547";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String completedWastePercent = foodOverBasePage.CurrentMonth_CompletedWaste_DifferencePercent_Value.getText().trim();
		if (completedWastePercent.substring(completedWastePercent.length()-1,completedWastePercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Completed Waste %=x.xx% in the Month to Date (actual) % column in the Current Month section which is in proper percentage format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Completed Waste %=x.xx% in the Month to Date (actual) % column in the Current Month section which is in proper percentage format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2548: Verify that the user is able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column on the Food Over Base landing page in the Historical Month section.
	@Test()
	public void foodOverBase_US922_TC2548() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2548";
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
		String completedWasteDifferencePercent = foodOverBasePage.MonthEnd_CompletedWaste_DifferencePercent_Value.getText().replace("%", "").trim();
		if (foodOverBasePage.MonthEnd_CompletedWaste_DifferenceDollar_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Completed Waste Food Cost $= $x.xx in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal actual;
		if(completedWasteDifferencePercent.contains("-")){
			actual = new BigDecimal(completedWasteDifferencePercent.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(completedWasteDifferencePercent);
		}
		System.out.println("actual % : "+ actual);
		String differenceDollar = foodOverBasePage.MonthEnd_CompletedWaste_DifferenceDollar_Value.getText().replace("$", "").trim();
		BigDecimal actualDoller;
		if(differenceDollar.contains("-")){
			actualDoller = new BigDecimal(differenceDollar.replace("-", "").trim()).negate();
		}else{
			actualDoller = new BigDecimal(differenceDollar);
		}
		System.out.println("doller : "+ differenceDollar);
		BigDecimal netSales = new BigDecimal(foodOverBasePage.MonthEnd_NetSales_Value.getText().replace("$", ""));
		BigDecimal calculatedPercent = actualDoller.divide(netSales,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
		System.out.println("calculatedPercent   "+calculatedPercent);
		BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
		System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
		if(calculatedPercent1.equals(actual) || calculatedPercent2.equals(actual)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column in the Historical Month section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column in the Historical Month section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2549: Verify that the user is able to view aggregated month to date Completed Waste Food Cost $ in the Month to Date (Actual) $ column on the Food Over Base landing page in the Historical Month section in proper dollar format.
	@Test()
	public void foodOverBase_US922_TC2549() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2549";
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
		String completedWasteTargetPercent = foodOverBasePage.MonthEnd_CompletedWaste_TargetPercent_Value.getText().trim();
		String completedWasteAcutalPercent = foodOverBasePage.MonthEnd_CompletedWaste_AcutalPercent_Value.getText().trim();
		String completedWasteDifferencePercent = foodOverBasePage.MonthEnd_CompletedWaste_DifferencePercent_Value.getText().trim();
		if (!completedWasteTargetPercent.isEmpty()
				& !completedWasteAcutalPercent.isEmpty()
				& !completedWasteDifferencePercent.isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the  month end section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the  month end section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (completedWasteTargetPercent.substring(completedWasteTargetPercent.length()-1,completedWasteTargetPercent.length()).equals("%")
				& completedWasteAcutalPercent.substring(completedWasteAcutalPercent.length()-1,completedWasteAcutalPercent.length()).equals("%")
				& completedWasteDifferencePercent.substring(completedWasteDifferencePercent.length()-1,completedWasteDifferencePercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2550: Verify that the user is able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column on the Food Over Base landing page in the Historic Month section.
	@Test()
	public void foodOverBase_US922_TC2550() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2550";
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
		if (!foodOverBasePage.Historicals_CompletedWaste_PastMonth1_Value.getText().isEmpty()
				& !foodOverBasePage.Historicals_CompletedWaste_PastMonth2_Value.getText().isEmpty()
				& !foodOverBasePage.Historicals_CompletedWaste_PastMonth3_Value.getText().isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the Historical Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the Historical Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2551: Verify that the user is able to view the aggregated month to date Completed Waste % in the Month to Date (actual) % column on the Food Over Base landing page in the Historical Month section in proper percentage format.
	@Test()
	public void foodOverBase_US922_TC2551() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US922_TC2551";
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
		String completedWastePercent1 = foodOverBasePage.Historicals_CompletedWaste_PastMonth1_Value.getText().trim();
		String completedWastePercent2 = foodOverBasePage.Historicals_CompletedWaste_PastMonth2_Value.getText().trim();
		String completedWastePercent3 = foodOverBasePage.Historicals_CompletedWaste_PastMonth3_Value.getText().trim();
		if (completedWastePercent1.substring(completedWastePercent1.length()-1,completedWastePercent1.length()).equals("%")
				& completedWastePercent2.substring(completedWastePercent2.length()-1,completedWastePercent2.length()).equals("%")
				& completedWastePercent3.substring(completedWastePercent3.length()-1,completedWastePercent3.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Completed Waste % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
}
