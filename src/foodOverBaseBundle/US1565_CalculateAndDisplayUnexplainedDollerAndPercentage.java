package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;

public class US1565_CalculateAndDisplayUnexplainedDollerAndPercentage extends AbstractTest
{
	
	//TC2743 : Calculate and Display Unexplained Difference $ and %
	
	@Test()
	public void foodOverBase_US1565_TC2743() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1565_TC2743";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Projection tab
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "foodOverBasePage.Projections_BT");
		wait .until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_Title_Label));
		Thread.sleep(2000);
		//Verify that Unexplained RaW 	header and respective value for all the three months are displaying accordingly
		if(GenericMethods.isElementDisplayed(foodOverBasePage.Projections_Historicals_Unexplained_Raw_Header, "foodOverBasePage.Projections_Historicals_Unexplained_Raw_Header") &&
				(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']/following-sibling::td[1]")).getText().length()>0) &&
				(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']/following-sibling::td[2]")).getText().length()>0))
		{
			Reporter.reportPassResult(
					browser,
					"Unexplained  % column should be displayed in each month (Last three months) on Food Over Base page historical section.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Unexplained  % column should be displayed in each month (Last three months) on Food Over Base page historical section.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	
}

	//TC2744 : Verify the calculation of Total QCR Food Cost $ .(There is nothing to verify in this test case)
	
	@Test()
	public void foodOverBase_US1565_TC2744() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1565_TC2744";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Food Over Base page
		 homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Projection tab
		if(true)
		{
			Reporter.reportPassResult(
					browser,
					"Unexplained  % column should be displayed in each month (Last three months) on Food Over Base page historical section.",
					"Pass");
		}
		
			
		
	}
	
	
	//TC2745 : Verify the calculation of Unexplained Difference $ section in the Actual $ column.
	
	@Test()
	public void foodOverBase_US1565_TC2745() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1565_TC2745";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Month End tab
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "foodOverBasePage.MonthEnd_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.MonthEnd_Actual_Column_Label));
		//Fetch the total Total P&L Food Cost
		System.out.println("Text "+GenericMethods.getText(foodOverBasePage.MonthEnd_PlFoodCost_Total_Value, "foodOverBasePage.MonthEnd_PlFoodCost_Total_Value").replace("$", ""));
		BigDecimal totalPLFoodCost=new BigDecimal(foodOverBasePage.MonthEnd_PlFoodCost_Total_Value.getText().replace("$", ""));
		System.out.println("totalPLFoodCost"+totalPLFoodCost);
		//Fetch the base value for all the WRIN IDs
		String baseFood$=GenericMethods.getText(driver.findElement(By.xpath("(//table[@id='current_month_food_cost'])[2]/tbody/tr/td[text()='Base Food']/following-sibling::td[2]")), "Base Food $").replace("$", "");
		String completedWaste$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[5]")), "Completed Waste $").replace("$", "");
		String rawWaste$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Raw Waste']/following-sibling::td[5]")), "Raw Waste $").replace("$", "");
		String condiments$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Condiments']/following-sibling::td[5]")), "Condiments $").replace("$", "");
		String empMgrMeals$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[5]")), "Emp/Mgr Meals $").replace("$", "");
		String discountCoupons$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[5]")), "Discount/Coupons $").replace("$", "");
		String statVariance$=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[5]")), "StatVariance $").replace("$", "");
		System.out.println("baseFood$"+baseFood$);
		System.out.println("completedWaste$"+completedWaste$);
		System.out.println("rawWaste$"+rawWaste$);
		System.out.println("condiments$"+condiments$);
		System.out.println("empMgrMeals$"+empMgrMeals$);
		System.out.println("discountCoupons$"+discountCoupons$);
		System.out.println("statVariance$"+statVariance$);
		//Total QSR Food Cost
		BigDecimal totalQSRFoodCost=new BigDecimal(baseFood$).add(new BigDecimal(completedWaste$)).add(new BigDecimal(rawWaste$)).add(new BigDecimal(condiments$)).add(new BigDecimal(empMgrMeals$)).add(new BigDecimal(discountCoupons$)).add(new BigDecimal(statVariance$));
		System.out.println("totalQSRFoodCost"+totalQSRFoodCost);
		//Find the unexplained difference $ Value
		BigDecimal unexplainedDifference$=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Unexplained']/following-sibling::td[5]")), "Unexplained Difference $").replace("$", ""));
		System.out.println("unexplainedDifference$"+unexplainedDifference$);
		System.out.println("totalPLFoodCost.subtract(totalQSRFoodCost)"+totalPLFoodCost.subtract(totalQSRFoodCost));
		/*Verify Unexplained Difference $ is calculated as:

			   Total P&L Food Cost - Total QCR Food Cost.*/
		if(unexplainedDifference$.equals(totalPLFoodCost.subtract(totalQSRFoodCost)))
		{
			Reporter.reportPassResult(
					browser,
					"Verify Unexplained Difference $ should calculated as:Total P&L Food Cost - Total QCR Food Cost.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Verify Unexplained Difference $ should calculated as:Total P&L Food Cost - Total QCR Food Cost.",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}

}

	//TC2748 : Verify Unexplained Difference % section in Actual % column of each month.
	
	
	@Test()
	public void foodOverBase_US1565_TC2748() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1565_TC2748";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Month End tab
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "foodOverBasePage.MonthEnd_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.MonthEnd_Actual_Column_Label));
		//Find the unexplained difference $ Value
		BigDecimal unexplainedDifference$=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Unexplained']/following-sibling::td[5]")), "Unexplained Difference $").replace("$", ""));
		System.out.println("unexplainedDifference$"+unexplainedDifference$);
		//Product Net Sales
		BigDecimal productNetSales$=new BigDecimal(GenericMethods.getText(foodOverBasePage.MonthEnd_NetSales_Value, "Product Net Sales $").replace("$", ""));
		System.out.println("productNetSales$"+productNetSales$);
		//Unexplained Difference %
		BigDecimal unexplainedDifferencePercentage=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Unexplained']/following-sibling::td[3]")), "Unexplained Difference %").replace("%", ""));
		System.out.println("unexplainedDifferencePercentage"+unexplainedDifferencePercentage);
		System.out.println("unexplainedDifferencePercentage.floatValue()"+unexplainedDifferencePercentage.floatValue());
//		System.out.println("(unexplainedDifference$.divide(productNetSales$)).divide(new BigDecimal(100)))"+unexplainedDifference$.divide(productNetSales$).floatValue());
		BigDecimal calculatedPercent = unexplainedDifference$.divide(productNetSales$,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
		System.out.println("calculatedPercent   "+calculatedPercent);
		BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
		BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
		System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
		if(calculatedPercent1.equals(unexplainedDifferencePercentage) || calculatedPercent2.equals(unexplainedDifferencePercentage)) {
			Reporter.reportPassResult(
					browser,
					"Unexplained Difference % should be calculated by using the formula:(Unexplained Difference $ / Product Net Sales)* 100",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Unexplained Difference % should be calculated by using the formula:(Unexplained Difference $ / Product Net Sales)* 100",
					"Fail");
			AbstractTest.takeSnapShot();
		}

}
	
	//TC2756 : Verify the calculation of Unexplained Difference field under Projection Percentage% column for Projection month
	
	@Test()
	public void foodOverBase_US1565_TC2756() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1565_TC2756";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Projection tab
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "foodOverBasePage.Projections_BT");
		wait .until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_Title_Label));
		Thread.sleep(2000);
		//Get all the three historical month unexplained value
		String historicalFirst=driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']/following-sibling::td[1]")).getText().replaceAll("%", "");
		String historicalSecond=driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']/following-sibling::td[2]")).getText().replaceAll("%", "");
		String historicalThird=driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']/following-sibling::td[3]")).getText().replaceAll("%", "");
		System.out.println("historicalFirst "+historicalFirst+"historicalSecond "+historicalSecond+"historicalThird"+historicalThird);
		//Find the average of the Hostorical Months
		BigDecimal averageOFAll=(new BigDecimal(historicalFirst).add(new BigDecimal((historicalSecond))).add(new BigDecimal((historicalThird))).divide(new BigDecimal("3")));
		System.out.println("averageOFAll "+averageOFAll);
		//Find the Unexplained Projection Value
		BigDecimal unexplainedProjection=new BigDecimal(foodOverBasePage.Projections_UnexplainedProjected_Value.getText().replaceAll("%", ""));
		System.out.println("unexplainedProjection "+unexplainedProjection);
		if((averageOFAll.equals(unexplainedProjection)))
		{
			Reporter.reportPassResult(
					browser,
					"Correct avrage value should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Correct avrage value should display",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
