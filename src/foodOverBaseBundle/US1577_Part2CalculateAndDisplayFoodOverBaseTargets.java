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
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.AbstractTest;

public class US1577_Part2CalculateAndDisplayFoodOverBaseTargets extends AbstractTest{
	
	//TC4159: Verify that the user is able to view the the Projection Month Raw Waste % value in proper percentage format in the Projected column. 
	@Test()
	public void foodOverBase_US1577_TC4159() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1577_TC4159";
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
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String todayDate = dateFormat.format(date);
		int month = Base.getCorrectMonthFromDate(todayDate);
		int year = Base.getYearFromDate(todayDate);
		String date2 = month+"/"+"20"+"/"+year;
		Date twentythDate = dateFormat.parse(date2);
		boolean baseFoodCalculationDisplayed = true;
		boolean statVarienceCalculationDisplayed = true;
		boolean unexplainedCalculationDisplayed = true;
		if(date.after(twentythDate) ||date.equals(twentythDate)){
			/*String valueInProjections = foodOverBasePage.Projections_RawWaste_Value.getText();
			String targetWasteValue = foodOverBasePage.Projections_RawWasteTarget_TB.getText();
			rawWasteCalculationDisplayed = rawWasteCalculationDisplayed & valueInProjections.equals(targetWasteValue);*/
		}else{
			String baseFoodValueInProjections = foodOverBasePage.Projections_BaseFoodProjected_Value.getText().replace("%", "");
			System.out.println("baseFoodValueInProjections "+ baseFoodValueInProjections);
			String[] baseFoodData = foodOverBasePage.getDataForLastThreeMonths("Base Food");
			String month1BaseFoodData = baseFoodData[0].replace("%", "");
			String month2BaseFoodData = baseFoodData[1].replace("%", "");
			String month3BaseFoodData = baseFoodData[2].replace("%", "");
			BigDecimal avgBaseFoodData = new BigDecimal(month1BaseFoodData).add(new BigDecimal(month2BaseFoodData)).add(new BigDecimal(month3BaseFoodData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgData "+ avgBaseFoodData);
			baseFoodCalculationDisplayed = baseFoodCalculationDisplayed & baseFoodValueInProjections.equals(avgBaseFoodData.toString());
			
			String statVarienceInProjections = foodOverBasePage.Projections_StatVarianceProjected_Value.getText().replace("%", "");
			System.out.println("statVarienceInProjections "+ statVarienceInProjections);
			String[] statVarienceData = foodOverBasePage.getDataForLastThreeMonths("Stat Variance");
			String month1StatVarienceData = statVarienceData[0].replace("%", "");
			String month2StatVarienceData = statVarienceData[1].replace("%", "");
			String month3StatVarienceData = statVarienceData[2].replace("%", "");
			BigDecimal avgStatVarienceData = new BigDecimal(month1StatVarienceData).add(new BigDecimal(month2StatVarienceData)).add(new BigDecimal(month3StatVarienceData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgData "+ avgStatVarienceData);
			statVarienceCalculationDisplayed = statVarienceCalculationDisplayed & statVarienceInProjections.equals(avgStatVarienceData.toString());
			
			String unexplainedInProjections = foodOverBasePage.Projections_UnexplainedProjected_Value.getText().replace("%", "");
			System.out.println("unexplainedInProjections "+ unexplainedInProjections);
			String[] unexplainedData = foodOverBasePage.getDataForLastThreeMonths("Unexplained");
			String month1UnexplainedData = unexplainedData[0].replace("%", "");
			String month2UnexplainedData = unexplainedData[1].replace("%", "");
			String month3UnexplainedData = unexplainedData[2].replace("%", "");
			BigDecimal avgUnexplainedData = new BigDecimal(month1UnexplainedData).add(new BigDecimal(month2UnexplainedData)).add(new BigDecimal(month3UnexplainedData)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgData "+ avgUnexplainedData);
			unexplainedCalculationDisplayed = unexplainedCalculationDisplayed & unexplainedInProjections.equals(avgUnexplainedData.toString());
		}
		if (baseFoodCalculationDisplayed & statVarienceCalculationDisplayed & unexplainedCalculationDisplayed) {
			Reporter.reportPassResult(browser,
					"If Current Date is less than 20th, then Value displayed under Projected column should be average of preceding three months else "
					+ "Value entered in New Target field should be displayed under Projected column against Raw Waste label.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"If Current Date is less than 20th, then Value displayed under Projected column should be average of preceding three months else "
					+ "Value entered in New Target field should be displayed under Projected column against Raw Waste label.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
