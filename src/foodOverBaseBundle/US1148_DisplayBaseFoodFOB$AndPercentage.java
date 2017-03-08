package foodOverBaseBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

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

public class US1148_DisplayBaseFoodFOB$AndPercentage extends AbstractTest
{
	
	//TC2470 : Verify the aggregated month to date Base Food % in the Month to Date (actual) % column.
	
	
	@Test()
	public void foodOverBase_US1148_TC2470() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1148_TC2470";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String pattern=("(.*)(%)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Current Month button
		GenericMethods.clickOnElement(foodOverBasePage.CurrentMonth_BT, "foodOverBasePage.CurrentMonth_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.CurrentMonth_BaseFood_Label));
		//User should be able to view the aggregated month to date Base Food % in the Month to Date (actual) % column.
		String baseFoodPercentage=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_right']/tbody/tr/td[text()='Base Food:']/following-sibling::td[1]")), "Base Foor Month To Date % Value");
		System.out.println("baseFoodPercentage"+baseFoodPercentage);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(baseFoodPercentage).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Base Food % in the Month to Date (actual) % column.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Base Food % in the Month to Date (actual) % column.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2474 : Verify the aggregated month Base Food % in the Actual % column for each historical month
	
	

	@Test()
	public void foodOverBase_US1148_TC2474() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1148_TC2474";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String pattern=("(.*)(%)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Projection tab
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "foodOverBasePage.Projections_BT");
		wait .until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_Title_Label));
		Thread.sleep(2000);
		//Fetch the text of first historical month
		String first=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[1]")), "First Ho=istorical month Base Food %");
		//Fetch the text of Second historical month
		String second=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[2]")), "Second Ho=istorical month Base Food %");
		//Fetch the text of Third historical month
		String third=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[3]")), "Third Ho=istorical month Base Food %");
		System.out.println("first"+first);
		System.out.println("second"+second);
		System.out.println("third"+third);
		if(Pattern.compile(pattern).matcher(first).matches() &&
				Pattern.compile(pattern).matcher(second).matches() &&
				Pattern.compile(pattern).matcher(third).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month Base Food % in the Actual % column for each historical month",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month Base Food % in the Actual % column for each historical month",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}

	
	//TC2732 : Verify Base Food % on food over base page.
	
	
	@Test()
	public void foodOverBase_US1148_TC2732() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1148_TC2732";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Current Month button
		GenericMethods.clickOnElement(foodOverBasePage.CurrentMonth_BT, "foodOverBasePage.CurrentMonth_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.CurrentMonth_BaseFood_Label));
		//Fetch the aggregated Base Food Cost $
		BigDecimal baseFoodCost$=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_right']/tbody/tr/td[text()='Base Food:']/following-sibling::td[2]")), "Base Food $").replace("$", ""));
		//Fetch the aggregated Product Net Sales $
		BigDecimal  netSales$=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//div[text()='Month-to-Date Product Net Sales:']/../following-sibling::div/div[1]")), "Net Sales $").replace("$", ""));
		//Fetch the Base Food %
		BigDecimal baseFoodCostPercentage=new BigDecimal(GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_right']/tbody/tr/td[text()='Base Food:']/following-sibling::td[1]")), "Base Food %").replace("%", ""));
		/*System.out.println("(baseFoodCost$.floatValue()/netSales$.floatValue())*100"+(baseFoodCost$.floatValue()/netSales$.floatValue())*100);
		System.out.println("baseFoodCostPercentage.floatValue()"+baseFoodCostPercentage);*/
		System.out.println(baseFoodCostPercentage.floatValue());
//		System.out.println((baseFoodCost$.divide(netSales$, 4, RoundingMode.CEILING)));
		System.out.println((baseFoodCost$.divide(netSales$, 4, RoundingMode.CEILING)).floatValue()*100-Float.parseFloat(".01"));
		System.out.println(baseFoodCost$.divide(netSales$, 4, RoundingMode.CEILING).multiply(new BigDecimal("100")));
		if(baseFoodCostPercentage.floatValue()==((baseFoodCost$.divide(netSales$, 4, RoundingMode.CEILING)).floatValue()*100-Float.parseFloat(".01")) ||
				baseFoodCostPercentage.floatValue()==((baseFoodCost$.divide(netSales$, 4, RoundingMode.CEILING)).floatValue()*100+Float.parseFloat(".01"))
					)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view correct base food%",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view correct base food%",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
	//TC2467 : Verify the aggregated month to date Base Food Cost $ in the Month to Date (Actual) $ column.
		
	@Test()
	public void foodOverBase_US1148_TC2467() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1148_TC2467";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String pattern=("(\\$)(.*)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Current Month button
		GenericMethods.clickOnElement(foodOverBasePage.CurrentMonth_BT, "foodOverBasePage.CurrentMonth_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.CurrentMonth_BaseFood_Label));
		//User should be able to view the aggregated month to date Base Food % in the Month to Date (actual) % column.
		String baseFooddoller=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_right']/tbody/tr/td[text()='Base Food:']/following-sibling::td[2]")), "Base Foor Month To Date $ Value");
		System.out.println("baseFooddoller"+baseFooddoller);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(baseFooddoller).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Base Food Cost $ in the 'Month to Date (Actual) $' column",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Base Food Cost $ in the 'Month to Date (Actual) $' column",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
	
	//TC2472 : Verify the aggregated month Base Food Cost % for each historical month
	
	
	@Test()
	public void foodOverBase_US1148_TC2472() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US1148_TC2472";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String pattern=("(.*)(%)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Projection tab
		GenericMethods.clickOnElement(foodOverBasePage.Projections_BT, "foodOverBasePage.Projections_BT");
		wait .until(ExpectedConditions.visibilityOf(foodOverBasePage.Projections_Title_Label));
		Thread.sleep(2000);
		//Fetch the text of first historical month
		String first=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[1]")), "First Ho=istorical month Base Food %");
		//Fetch the text of Second historical month
		String second=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[2]")), "Second Ho=istorical month Base Food %");
		//Fetch the text of Third historical month
		String third=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Base Food']/following-sibling::td[3]")), "Third Ho=istorical month Base Food %");
		System.out.println("first"+first);
		System.out.println("second"+second);
		System.out.println("third"+third);
		if(Pattern.compile(pattern).matcher(first).matches() &&
				Pattern.compile(pattern).matcher(second).matches() &&
				Pattern.compile(pattern).matcher(third).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month Base Food % in the Actual % column for each historical month",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month Base Food % in the Actual % column for each historical month",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	

}