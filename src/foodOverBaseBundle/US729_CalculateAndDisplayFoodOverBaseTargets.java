package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US729_CalculateAndDisplayFoodOverBaseTargets extends AbstractTest{
	
	//TC4161: Verify that the user should utilize last 3 month actual % and average to come up with projections for the new month 
	@Test()
	public void foodOverBase_US729_TC4161() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US729_TC4161";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT,"Projections_BT");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int year = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+year;
		Date twentythDate = dateFormat.parse(date2);
		boolean completedWasteCalculationDisplayed = true;
		boolean rawWasteCalculationDisplayed = true;
		boolean condimentsCalculationDisplayed = true;
		boolean empMgrMealsCalculationDisplayed = true;
		boolean discountCouponCalculationDisplayed = true;
		if(date.after(twentythDate) ||date.equals(twentythDate)){
			/*String valueInProjections = foodOverBasePage.Projections_RawWaste_Value.getText();
			String targetWasteValue = foodOverBasePage.Projections_RawWasteTarget_TB.getText();
			rawWasteCalculationDisplayed = rawWasteCalculationDisplayed & valueInProjections.equals(targetWasteValue);*/
		}else{
			String completedWasteValueInProjections = foodOverBasePage.Projections_CompletedWasteProjected_Value.getText().replace("%", "");
			System.out.println("completedWasteValueInProjections "+ completedWasteValueInProjections);
			String[] completedWasteData = foodOverBasePage.getDataForLastThreeMonths("Completed Waste");
			String month1CompletedWasteData = completedWasteData[0].replace("%", "");
			String month2CompletedWasteData = completedWasteData[1].replace("%", "");
			String month3CompletedWasteData = completedWasteData[2].replace("%", "");
			BigDecimal avgCompletedWasteData = new BigDecimal(month1CompletedWasteData).add(new BigDecimal(month2CompletedWasteData)).add(new BigDecimal(month3CompletedWasteData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgCompletedWasteData "+ avgCompletedWasteData);
			completedWasteCalculationDisplayed = completedWasteCalculationDisplayed & completedWasteValueInProjections.equals(avgCompletedWasteData.toString());
			
			String rawWasteInProjections = foodOverBasePage.Projections_RawWasteProjected_Value.getText().replace("%", "");
			System.out.println("rawWasteInProjections "+ rawWasteInProjections);
			String[] rawWasteData = foodOverBasePage.getDataForLastThreeMonths("Raw Waste");
			String month1RawWasteData = rawWasteData[0].replace("%", "");
			String month2RawWasteData = rawWasteData[1].replace("%", "");
			String month3RawWasteData = rawWasteData[2].replace("%", "");
			BigDecimal avgRawWasteData = new BigDecimal(month1RawWasteData).add(new BigDecimal(month2RawWasteData)).add(new BigDecimal(month3RawWasteData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgRawWasteData "+ avgRawWasteData);
			rawWasteCalculationDisplayed = rawWasteCalculationDisplayed & rawWasteInProjections.equals(avgRawWasteData.toString());
			
			String condimentsInProjections = foodOverBasePage.Projections_CondimentsProjected_Value.getText().replace("%", "");
			System.out.println("condimentsInProjections "+ condimentsInProjections);
			String[] condimentsData = foodOverBasePage.getDataForLastThreeMonths("Condiments");
			String month1CondimentsData = condimentsData[0].replace("%", "");
			String month2CondimentsData = condimentsData[1].replace("%", "");
			String month3CondimentsData = condimentsData[2].replace("%", "");
			BigDecimal avgCondimentsData = new BigDecimal(month1CondimentsData).add(new BigDecimal(month2CondimentsData)).add(new BigDecimal(month3CondimentsData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgCondimentsData "+ avgCondimentsData);
			condimentsCalculationDisplayed = condimentsCalculationDisplayed & condimentsInProjections.equals(avgCondimentsData.toString());
			
			String empMgrMealsInProjections = foodOverBasePage.Projections_EmpMgrMealsProjected_Value.getText().replace("%", "");
			System.out.println("empMgrMealsInProjections "+ empMgrMealsInProjections);
			String[] empMgrMealsData = foodOverBasePage.getDataForLastThreeMonths("Emp/Mgr Meals");
			String month1EmpMgrMealsData = empMgrMealsData[0].replace("%", "");
			String month2EmpMgrMealsData = empMgrMealsData[1].replace("%", "");
			String month3EmpMgrMealsData = empMgrMealsData[2].replace("%", "");
			BigDecimal avgEmpMgrMealsData = new BigDecimal(month1EmpMgrMealsData).add(new BigDecimal(month2EmpMgrMealsData)).add(new BigDecimal(month3EmpMgrMealsData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgEmpMgrMealsData "+ avgEmpMgrMealsData);
			empMgrMealsCalculationDisplayed = empMgrMealsCalculationDisplayed & empMgrMealsInProjections.equals(avgEmpMgrMealsData.toString());
			
			String discountCouponInProjections = foodOverBasePage.Projections_DiscountCouponsProjected_Value.getText().replace("%", "");
			System.out.println("discountCouponInProjections "+ discountCouponInProjections);
			String[] discountCouponData = foodOverBasePage.getDataForLastThreeMonths("Discount/Coupons");
			String month1DiscountCouponData = discountCouponData[0].replace("%", "");
			String month2DiscountCouponData = discountCouponData[1].replace("%", "");
			String month3DiscountCouponData = discountCouponData[2].replace("%", "");
			BigDecimal avgDiscountCouponData = new BigDecimal(month1DiscountCouponData).add(new BigDecimal(month2DiscountCouponData)).add(new BigDecimal(month3DiscountCouponData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgDiscountCouponData "+ avgDiscountCouponData);
			discountCouponCalculationDisplayed = discountCouponCalculationDisplayed & discountCouponInProjections.equals(avgDiscountCouponData.toString());
		}
		if (completedWasteCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Completed Waste Value displayed under Projected column should be average of preceding three months",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Completed Waste Value displayed under Projected column should be average of preceding three months",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (rawWasteCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Raw Waste Value displayed under Projected column should be average of preceding three months",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Raw Waste Value displayed under Projected column should be average of preceding three months",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (condimentsCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Condiments Value displayed under Projected column should be average of preceding three months",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Condiments Waste Value displayed under Projected column should be average of preceding three months",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (empMgrMealsCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Emp/Mgr Meals Value displayed under Projected column should be average of preceding three months",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Emp/Mgr Meals Value displayed under Projected column should be average of preceding three months",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if (discountCouponCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Discount/Coupon Value displayed under Projected column should be average of preceding three months",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Discount/Coupon Value displayed under Projected column should be average of preceding three months",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}


}
