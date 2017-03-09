package foodOverBaseBundle;

import java.io.IOException;
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

public class US924_DisplayCondimentsPercentageAndDoller extends AbstractTest
{
	
	//TC2334 : Verify that the user is able to view the aggregated month to date Condiment Cost $ in the Month to Date (Actual) $ column
	
	
	@Test()
	public void foodOverBase_US924_TC2334() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2334";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String pattern=("(\\$)(.*)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Current Month button
		GenericMethods.clickOnElement(foodOverBasePage.CurrentMonth_BT, "foodOverBasePage.CurrentMonth_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.CurrentMonth_BaseFood_Label));
		String expeCondignment=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_contributors']/tbody/tr/td[text()='Condiments']/following-sibling::td[5]")), "Condignment $ Value").trim();
		System.out.println("expeCondignment"+expeCondignment);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(expeCondignment).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Condiment Cost $= $x in the Month to Date (Actual) $ column for Condiments",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Condiment Cost $= $x in the Month to Date (Actual) $ column for Condiments",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	
	}
	
	
	
	//TC2336 : Verify that the user is able to view the aggregated month to date Condiment Cost $ in the Month to Date (Actual) $ column in proper $ format
	
	@Test()
	public void foodOverBase_US924_TC2336() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2336";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String pattern=("(\\$)(.*)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Month End button
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "foodOverBasePage.MonthEnd_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.MonthEnd_Actual_Column_Label));
		String expeCondignment=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Condiments']/following-sibling::td[5]")), "Condignment $ Value").trim();
		System.out.println("expeCondignment"+expeCondignment);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(expeCondignment).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Condiment Cost $= $x.xx in the Month End (Actual) $ column for Condiments which is in proper dollar format",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Condiment Cost $= $x.xx in the Month End (Actual) $ column for Condiments which is in proper dollar format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	
	}
	
	
	//TC2338 : Verify that the user is able to view the aggregated month to date Condiment % in the Month to Date (actual) % column
	
	@Test()
	public void foodOverBase_US924_TC2338() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2338";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String pattern=("(.*)(%)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Current Month button
		GenericMethods.clickOnElement(foodOverBasePage.CurrentMonth_BT, "foodOverBasePage.CurrentMonth_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.CurrentMonth_BaseFood_Label));
		String expeCondignment=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='current_month_contributors']/tbody/tr/td[text()='Condiments']/following-sibling::td[3]")), "Condignment % Value").trim();
		System.out.println("expeCondignment"+expeCondignment);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(expeCondignment).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Condiment %=x% in the Month to Date (actual) % column",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Condiment %=x% in the Month to Date (actual) % column",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	
	}
	
	
	//TC3439 : Verify that the user is able to view the aggregated month to date Condiment % in the Month to Date (actual) % column in proper % format
	
	@Test()
	public void foodOverBase_US924_TC2339() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2339";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String pattern=("(.*)(%)");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FoodOverBasePage foodOverBasePage = PageFactory.initElements(driver,FoodOverBasePage.class);
		// Navigate to Food Over Base page
		foodOverBasePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToFoodOverBasePage();
		//click on Month End button
		GenericMethods.clickOnElement(foodOverBasePage.MonthEnd_BT, "foodOverBasePage.MonthEnd_BT");
		wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.MonthEnd_Actual_Column_Label));
		String expeCondignment=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='month_end_contributors']/tbody/tr/td[text()='Condiments']/following-sibling::td[3]")), "Condignment % Value").trim();
		System.out.println("expeCondignment"+expeCondignment);
		System.out.println("Pattern.compile(pattern)"+Pattern.compile(pattern));
		if(Pattern.compile(pattern).matcher(expeCondignment).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month to date Condiment %=x.xx% in the Month End (actual) % column in proper % format",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month to date Condiment %=x.xx% in the Month End (actual) % column in proper % format",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	
	}

	
	//TC2340 : Verify that the user is able to view the aggregated month Condiment  in the Actual  column for each historical month 
	
	
	@Test()
	public void foodOverBase_US924_TC2340() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2340";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
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
		String first=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[1]")), "First Ho=istorical month Condiments %");
		//Fetch the text of Second historical month
		String second=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[2]")), "Second Ho=istorical month Condiments %");
		//Fetch the text of Third historical month
		String third=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[3]")), "Third Ho=istorical month Condiments %");
		System.out.println("first"+first);
		System.out.println("second"+second);
		System.out.println("third"+third);
		if(Pattern.compile(pattern).matcher(first).matches() &&
				Pattern.compile(pattern).matcher(second).matches() &&
				Pattern.compile(pattern).matcher(third).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month Condiment= x.xx% in the Actual % column for each historical month ",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month Condiment= x.xx% in the Actual % column for each historical month ",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
	
	//TC2341 : Verify that the user is able to view the aggregated month Condiment % in the Actual % column for each historical month in proper % format
	
	@Test()
	public void foodOverBase_US924_TC2341() throws RowsExceededException,
	BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="foodOverBase_US924_TC2341";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
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
		String first=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[1]")), "First Ho=istorical month Condiments %");
		//Fetch the text of Second historical month
		String second=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[2]")), "Second Ho=istorical month Condiments %");
		//Fetch the text of Third historical month
		String third=GenericMethods.getText(driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Condiments']/following-sibling::td[3]")), "Third Ho=istorical month Condiments %");
		System.out.println("first"+first);
		System.out.println("second"+second);
		System.out.println("third"+third);
		if(Pattern.compile(pattern).matcher(first).matches() &&
				Pattern.compile(pattern).matcher(second).matches() &&
				Pattern.compile(pattern).matcher(third).matches())
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the aggregated month Condiment= x.xx% in the Actual % column for each historical month ",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the aggregated month Condiment= x.xx% in the Actual % column for each historical month ",
					"Fail");
			AbstractTest.takeSnapShot();
		}

	}
}
