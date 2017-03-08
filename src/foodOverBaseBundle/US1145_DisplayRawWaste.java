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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemWastePage;

public class US1145_DisplayRawWaste extends AbstractTest{
	
	//TC2172: Verify that the user is able to view the the Projection month Raw Waste % in Projected column on Food Over Base page in Projection tab. 
	@Test()
	public void foodOverBase_US1145_TC2172() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1145_TC2172";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToFoodOverBasePage();
		// Verify that Difference percentage column is displaying
		foodOverBasePage.Projections_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.Projections_RawWaste_Label)
				& Base.isElementDisplayed(foodOverBasePage.Projections_RawWasteProjected_Value)) {
			Reporter.reportPassResult(browser,
					"User should be able to view Raw Waste label and Raw Waste % under Projections in projection section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste label and Raw Waste % under Projections in projection section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String rawWasteValue = foodOverBasePage.Projections_RawWasteProjected_Value.getText();
		if (rawWasteValue.substring(rawWasteValue.length()-1).equals("%")) {
			Reporter.reportPassResult(browser,
					"User should be able to view Raw Waste Projected column in proper percentage format.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste Projected column in proper percentage format.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2174: Verify that the user is able to view the the Projection Month Raw Waste % value in proper percentage format in the Projected column. 
	@Test()
	public void foodOverBase_US1145_TC2174() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException, ParseException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1145_TC2174";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
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
		boolean rawWasteCalculationDisplayed = true;
		if(date.after(twentythDate) ||date.equals(twentythDate)){
			String valueInProjections = foodOverBasePage.Projections_RawWasteProjected_Value.getText();
			String targetWasteValue = foodOverBasePage.Projections_RawWasteTarget_TB.getText();
			rawWasteCalculationDisplayed = rawWasteCalculationDisplayed & valueInProjections.equals(targetWasteValue);
		}else{
			String valueInProjections = foodOverBasePage.Projections_RawWasteProjected_Value.getText().replace("%", "");
			System.out.println("valueInProjections "+ valueInProjections);
			String[] threeMonthData = foodOverBasePage.getDataForLastThreeMonths("Raw Waste");
			String month1Data = threeMonthData[0].replace("%", "");
			String month2Data = threeMonthData[1].replace("%", "");
			String month3Data = threeMonthData[2].replace("%", "");
			BigDecimal avgData = new BigDecimal(month1Data).add(new BigDecimal(month2Data)).add(new BigDecimal(month3Data)).divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
			System.out.println("avgData "+ avgData);
			rawWasteCalculationDisplayed = rawWasteCalculationDisplayed & valueInProjections.equals(avgData.toString());
		}
		if (rawWasteCalculationDisplayed) {
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
	
	//TC2175: Verify that the user is able to view the the Current Month Raw Waste % in the Current Month-to-Date, Actual column on the Food Over Base landing page in the Current Month section 
	@Test()
	public void foodOverBase_US1145_TC2175() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1145_TC2175";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		if (Base.isElementDisplayed(foodOverBasePage.CurrentMonth_RawWaste_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Waste label and Raw Waste % for current Month.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste label and Raw Waste % for current Month.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String rawWasteValue = foodOverBasePage.CurrentMonth_ActualPercent_List.get(1).getText();
		System.out.println("rawWasteValue "+rawWasteValue);
		if (rawWasteValue.substring(rawWasteValue.length()-1).equals("%")) {
			Reporter.reportPassResult(browser,
					"User should be able to view Raw Waste Actual column in proper percentage format in the Current Month section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste Actual column in proper percentage format in the Current Month section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2180: Verify that the user is able to view the Historical Month Raw Waste % in the Actual % column for each historical month on the Food Over Base  page in Month-End section. 
	@Test()
	public void foodOverBase_US1145_TC2180() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		AbstractTest.tcName="foodOverBase_US1145_TC2180";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		foodOverBasePage.MonthEnd_BT.click();
		if (Base.isElementDisplayed(foodOverBasePage.MonthEnd_RawWaste_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view Raw Waste label under Month End in Month-End section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste label under Month End in Month-End section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String rawWasteValue = foodOverBasePage.MonthEnd_ActualPercent_List.get(1).getText();
		System.out.println("rawWasteValue "+rawWasteValue);
		if (rawWasteValue.substring(rawWasteValue.length()-1).equals("%")) {
			Reporter.reportPassResult(browser,
					"User should be able to view Raw Waste Actual column in proper percentage format in the Month-End section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste Actual column in proper percentage format in the Month-End section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2176: Verify that the user is able to view the the Current Month Raw Waste % value in proper percentage format in the Month to Date (Actual) column on the Food Over Base landing page in the Current Month section. 
	@Test()
	public void foodOverBase_US1145_TC2176() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		FoodOverBasePage foodOverBasePage;
		PromotionsAndWastePage promotionsAndWastePage;
		AbstractTest.tcName="foodOverBase_US1145_TC2176";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID = GlobalVariable.wasteItem1;
		String uomPerCase = GlobalVariable.wasteItem1_UOMPerCase;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Food over base page
		foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		String rawWastePercentValue1 = foodOverBasePage.CurrentMonth_RawWaste_AcutalPercent_Value.getText().trim().replace("%", "");
		String netSalesValue = foodOverBasePage.CurrentMonth_NetSales_Value.getText().trim().replace("$", "");
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		GenericMethods.clickOnElement(rawItemActivityPage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String casePrice = rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value");
		GenericMethods.clickOnElement(rawItemActivityPage.RawItemInformation_popUp_Cancel_BT,"RawItemInformation_popUp_Cancel_BT");
		Thread.sleep(2000);
		promotionsAndWastePage =  homePage.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		Thread.sleep(5000);
		GenericMethods.clickOnElement(promotionsAndWastePage.RawWaste_BT,"RawWaste_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		rawItemWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		//Get the total waste amount
		rawItemWastePage.addQuantitiesForMultipleWrin(samplewRINID, "", "", "100");
		Thread.sleep(2000);
		BigDecimal costPerUnit = new BigDecimal(casePrice).divide(new BigDecimal(uomPerCase));
		BigDecimal rawWasteCost = costPerUnit.multiply(new BigDecimal("100"));
		BigDecimal changeInWasteValue = (rawWasteCost.divide(new BigDecimal(netSalesValue),4,RoundingMode.HALF_UP)).multiply(new BigDecimal("100"));
		BigDecimal expectedRawWaste = new BigDecimal(rawWastePercentValue1).add(changeInWasteValue);
		expectedRawWaste = expectedRawWaste.setScale(2, RoundingMode.HALF_UP);
		System.out.println("expectedRawWaste roundingmode "+expectedRawWaste);
		GenericMethods.clickOnElement(rawItemWastePage.Submit_BT,"Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)),"SubmitRawWaste_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.goToFoodOverBasePage();
		String rawWastePercentValue2 = foodOverBasePage.CurrentMonth_RawWaste_AcutalPercent_Value.getText().trim().replace("%", "");
		System.out.println("rawWastePercentValue2 "+rawWastePercentValue2);
		System.out.println("compare "+rawWastePercentValue2.equals(String.valueOf(expectedRawWaste)));
		if (rawWastePercentValue2.equals(String.valueOf(expectedRawWaste))) {
			Reporter.reportPassResult(browser,
					"User should be able to view Raw Waste % in proper percentage format in the Current Month section.",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should be able to view Raw Waste % in proper percentage format in the Current Month section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
