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

public class US1170_DisplayDiscountCoupon extends AbstractTest{

	//TC2560: Verify that in the $ column, the month to date aggregated Discount Coupon $ is displayed
	@Test()
	public void foodOverBase_US1170_TC2560() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName = "foodOverBase_US1170_TC2560";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToFoodOverBasePage();
		if (foodOverBasePage.CurrentMonth_DiscountCoupons_DifferenceDoller_Value.getText().trim().substring(0, 1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the proper dollar format value of discount coupon in Month to Date (Actual)$ section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the proper dollar format value of discount coupon in Month to Date (Actual)$ section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String actualPercentage = foodOverBasePage.CurrentMonth_DiscountCoupons_DifferencePercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if (actualPercentage.contains("-")) {
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		} else {
			actual = new BigDecimal(actualPercentage);
		}
		System.out.println("actual % : " + actual);
		String diff = foodOverBasePage.CurrentMonth_DiscountCoupons_DifferenceDoller_Value.getText().replace("$", "").trim();
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
					"User should be able to view Discount Coupon $ value. in the Current Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Discount Coupon $ value. in the Current Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2561: Verify that in the % column, the month to date aggregated Discount Coupon % is displayed
	@Test()
	public void foodOverBase_US1170_TC2561() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName = "foodOverBase_US1170_TC2561";
		FoodOverBasePage foodOverBasePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		String discountPercent = foodOverBasePage.CurrentMonth_DiscountCoupons_DifferencePercent_Value.getText().trim();
		if (discountPercent.substring(discountPercent.length()-1,discountPercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the month to date  discount coupon value in the Month to Date (Actual) % column in the Current Month section which is in proper percentage format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the month to date  discount coupon value in the Month to Date (Actual) % column in the Current Month section which is in proper percentage format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal target = new BigDecimal(foodOverBasePage.CurrentMonth_DiscountCoupons_TargetPercent_Value.getText().replace("%", "").replace("-", "").trim());
		String actualPercentage = foodOverBasePage.CurrentMonth_DiscountCoupons_AcutalPercent_Value.getText().replace("%", "").trim();
		BigDecimal actual;
		if(actualPercentage.contains("-")){
			actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
		}else{
			actual = new BigDecimal(actualPercentage);
		}
		boolean negate = false;
		if(discountPercent.contains("-")){
			negate = true;
		}
		discountPercent = discountPercent.replace("%", "").replace("-", "").trim();
		BigDecimal diff = new BigDecimal(discountPercent);
		if (negate){
			diff = diff.negate();
		}
		System.out.println("diff % : "+ diff);
		BigDecimal calculatedPercent = target.subtract(actual);
		System.out.println("calculatedDiff % : "+ calculatedPercent);
		if (calculatedPercent.equals(diff)) {
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
	
	//TC2562: Verify that in the $ column, the month to date aggregated Discount Coupon $ is displayed for historical months.
	@Test()
	public void foodOverBase_US1170_TC2562() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName = "foodOverBase_US1170_TC2562";
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
		String discountCouponTargetPercent = foodOverBasePage.MonthEnd_DiscountCoupon_TargetPercent_Value.getText().trim();
		String discountCouponAcutalPercent = foodOverBasePage.MonthEnd_DiscountCoupon_AcutalPercent_Value.getText().trim();
		String discountCouponDifferencePercent = foodOverBasePage.MonthEnd_DiscountCoupon_DifferencePercent_Value.getText().trim();
		if (!discountCouponTargetPercent.isEmpty()
				& !discountCouponAcutalPercent.isEmpty()
				& !discountCouponDifferencePercent.isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date discount coupon % in the Month to Date (Actual) % column in the  month end section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date discount coupon % in the Month to Date (Actual) % column in the  month end section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (discountCouponTargetPercent.substring(discountCouponTargetPercent.length()-1,discountCouponTargetPercent.length()).equals("%")
				& discountCouponAcutalPercent.substring(discountCouponAcutalPercent.length()-1,discountCouponAcutalPercent.length()).equals("%")
				& discountCouponDifferencePercent.substring(discountCouponDifferencePercent.length()-1,discountCouponDifferencePercent.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date discount coupon % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date discount coupon  % in the Month to Date (Actual) % column in month end section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (foodOverBasePage.MonthEnd_DiscountCoupon_DifferenceDollar_Value.getText().trim().substring(0,1).equals("$")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date discount coupon $= $x.xx in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date discount coupon $ in the Month to Date (Actual) $ column in the Month end section which is in proper dollar format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal actual;
		if(discountCouponDifferencePercent.contains("-")){
			actual = new BigDecimal(discountCouponDifferencePercent.replace("-", "").replace("%", "").trim()).negate();
		}else{
			System.out.println("discountCouponDifferencePercent "+ discountCouponDifferencePercent.replace("%", "").trim());
			actual = new BigDecimal(discountCouponDifferencePercent.replace("%", "").trim());
		}
		System.out.println("actual % : "+ actual);
		String differenceDollar = foodOverBasePage.MonthEnd_DiscountCoupon_DifferenceDollar_Value.getText().replace("$", "").trim();
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
					"User should be able to view the aggregated month to date discount coupon $ in the Month to Date (Actual) $ column in the Month end section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date discount coupon $ in the Month to Date (Actual) $ column in the Month end section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2563: Verify that in the % column, the month to date aggregated Discount Coupon % is displayed for all historical months.
	@Test()
	public void foodOverBase_US1170_TC2563() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName = "foodOverBase_US1170_TC2563";
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
		String discountCouponPercent1 = foodOverBasePage.Historicals_DiscountCoupon_PastMonth1_Value.getText().trim();
		String discountCouponPercent2 = foodOverBasePage.Historicals_DiscountCoupon_PastMonth1_Value.getText().trim();
		String discountCouponPercent3 = foodOverBasePage.Historicals_DiscountCoupon_PastMonth1_Value.getText().trim();
		if (!discountCouponPercent1.isEmpty()
				& !discountCouponPercent2.isEmpty()
				& !discountCouponPercent3.isEmpty()) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Discount Coupon Cost % in the Month to Date (Actual) % column in the Historical Month section",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Discount Coupon Cost % in the Month to Date (Actual) % column in the Historical Month section",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if (discountCouponPercent1.substring(discountCouponPercent1.length()-1,discountCouponPercent1.length()).equals("%")
				& discountCouponPercent2.substring(discountCouponPercent2.length()-1,discountCouponPercent2.length()).equals("%")
				& discountCouponPercent3.substring(discountCouponPercent3.length()-1,discountCouponPercent3.length()).equals("%")) {
			Reporter.reportPassResult(
					browser,
					"User is able to view the aggregated month to date Discount Coupon Cost % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view the aggregated month to date Discount Coupon Cost % in the Month to Date (Actual) % column in the Historical Month section which is in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
}
