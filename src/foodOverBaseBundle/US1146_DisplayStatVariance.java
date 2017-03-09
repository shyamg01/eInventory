package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US1146_DisplayStatVariance extends AbstractTest {
	
	//TC2484: Verify stat variance $ value on "Month to Date (Actual) $" on food over base page.
	@Test()
	public void foodOverBase_US1146_TC2484() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1146_TC2484";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		if (foodOverBasePage.CurrentMonth_StatVariance_DifferenceDoller_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view aggregated month to date stat variance $=$x.xx in the Month to Date (Actual) $ column which is in proper dollar format in current month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date stat variance $=$x.xx in the Month to Date (Actual) $ column which is in proper dollar format in current month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String actualPercentage = foodOverBasePage.CurrentMonth_StatVariance_DifferencePercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = foodOverBasePage.CurrentMonth_StatVariance_DifferenceDoller_Value.getText().replace("$", "").trim();
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
					"User should be able to view aggregated month to date stat variance $ in the Month to Date (Actual) $ column in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date stat variance $ in the Month to Date (Actual) $ column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2487: Verify stat variance % value on "Month to Date (Actual) %" on food over base page.
	@Test()
	public void foodOverBase_US1146_TC2487() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1146_TC2487";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String statVariencePercent = foodOverBasePage.CurrentMonth_StatVariance_DifferencePercent_Value.getText().trim();
		if (statVariencePercent.substring(statVariencePercent.length()-1,statVariencePercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date stat variance %=x.xx% in the Month to Date (actual) % column in the Current Month section which is in proper percentage format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date stat variance %=x.xx% in the Month to Date (actual) % column in the Current Month section which is in proper percentage format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal target = new BigDecimal(foodOverBasePage.CurrentMonth_StatVariance_TargetPercent_Value.getText().replace("%", "").replace("-", "").trim());
		System.out.println("target % : "+ target);
		String actualPercentage = foodOverBasePage.CurrentMonth_StatVariance_AcutalPercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : "+ actual);
		String diff = statVariencePercent.replace("%", "").trim();
		System.out.println("diff % : "+ diff);
		BigDecimal calculatedPercent = target.subtract(actual);
		System.out.println("calculatedDiff % : "+ calculatedPercent);
		System.out.println("Result is "+calculatedPercent.toString().equals(diff));
		if (calculatedPercent.toString().equals(diff)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date stat variance % in the Month to Date (actual) % column in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date stat variance % in the Month to Date (actual) % column in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2530: Verify stat variance $ value of " (Actual) $" of historical months on food over base page.
	@Test()
	public void foodOverBase_US1146_TC2530() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1146_TC2530";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "MonthEnd_BT");
		String statVarianceDifferencePercent = foodOverBasePage.MonthEnd_StatVariance_DifferencePercent_Value.getText().replace("%", "").trim();
		if (foodOverBasePage.MonthEnd_StatVariance_DifferenceDollar_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date stat variance $= $x.xx in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date stat variance $ in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal actual;
		if(statVarianceDifferencePercent.contains("-")){
			actual = new BigDecimal(statVarianceDifferencePercent.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(statVarianceDifferencePercent);
		}
		System.out.println("actual % : "+ actual);
		String differenceDollar = foodOverBasePage.MonthEnd_StatVariance_DifferenceDollar_Value.getText().replace("$", "").trim();
		BigDecimal actualDoller;
		if(differenceDollar.contains("-")){
			actualDoller = new BigDecimal(differenceDollar.replace("-", "").trim()).negate();
		}else{
			actualDoller = new BigDecimal(differenceDollar);
		}
		System.out.println("doller : "+ actualDoller);
		BigDecimal netSales = new BigDecimal(foodOverBasePage.MonthEnd_NetSales_Value.getText().replace("$", ""));
		BigDecimal calculatedPercent = actualDoller.divide(netSales,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
		System.out.println("calculatedPercent   "+calculatedPercent);
		BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
		System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
		if(calculatedPercent1.equals(actual) || calculatedPercent2.equals(actual)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view aggregated month to date stat variance $ in the Month to Date (Actual) $ column in the Historical Month section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view aggregated month to date stat variance $ in the Month to Date (Actual) $ column in the Historical Month section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2532: Verify stat variance % value of " (Actual) %" of historical months on food over base page.
	@Test()
	public void foodOverBase_US1146_TC2532() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1146_TC2532";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "Projections_BT");
		String statVariencePercent1 = foodOverBasePage.Historicals_StatVariance_PastMonth1_Value.getText().trim();
		String statVariencePercent2 = foodOverBasePage.Historicals_StatVariance_PastMonth2_Value.getText().trim();
		String statVariencePercent3 = foodOverBasePage.Historicals_StatVariance_PastMonth3_Value.getText().trim();
		if (statVariencePercent1.substring(statVariencePercent1.length()-1,statVariencePercent1.length()).equals("%")
				& statVariencePercent2.substring(statVariencePercent2.length()-1,statVariencePercent2.length()).equals("%")
				& statVariencePercent3.substring(statVariencePercent3.length()-1,statVariencePercent3.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date stat variance % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date stat variance % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2490: Verify, that stat variance information recalculated and displayed each time a physical inventory is submitted.
	/*@Test()
	public void foodOverBase_US1146_TC2490() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		*//** Variable Section : **//*
		AbstractTest.tcName="foodOverBase_US1146_TC2490";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String stratDate=GlobalVariable.startDate;
		String createDate = GlobalVariable.createDate;
		String inventoryTime = GlobalVariable.time;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String outerPackQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		*//***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String statVarDoller = foodOverBasePage.CurrentMonth_StatVariance_DifferenceDoller_Value.getText().trim();
		String statVarPercent = foodOverBasePage.CurrentMonth_StatVariance_DifferencePercent_Value.getText().trim();
		PhysicalInventoryPage physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		physicalInventoryPage.selectStartDate(stratDate);
		String time = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time "+time);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(GlobalVariable.createDate).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",outerPackQty);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		Thread.sleep(5000); 
		homePage.goToFoodOverBasePage();
		String statVarDoller2 = foodOverBasePage.CurrentMonth_StatVariance_DifferenceDoller_Value.getText().trim();
		String statVarPercent2 = foodOverBasePage.CurrentMonth_StatVariance_DifferencePercent_Value.getText().trim();
		if (!statVarDoller.equals(statVarDoller2)
				& !statVarPercent.equals(statVarPercent2)) {
			Reporter.reportPassResult(
					browser,
					"stat variance information recalculated and displayed each time a physical inventory is submitted.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"stat variance information recalculated and displayed each time a physical inventory is submitted.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}*/
}
