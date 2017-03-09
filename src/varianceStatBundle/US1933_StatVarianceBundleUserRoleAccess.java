package varianceStatBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.VarianceStatPage;

public class US1933_StatVarianceBundleUserRoleAccess extends AbstractTest
{
	
	
	//TC4136 : Verify that level 1, level 2, level 3, level 4, supervisor, supervisor with role assignment, org admin and operator can view the current business date "Daily" Stat Variance information,historical "Daily" Stat Variance information and "Monthly" Stat Variance information
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_level1";
		String userID = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	
		
		
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_level2";
		String userID = LoginTestData.level2_SSO_UserId;
		String password = LoginTestData.level2_SSO_Password;
		String storeId = LoginTestData.level2StoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_level3";
		String userID = LoginTestData.level3_SSO_UserId;
		String password = LoginTestData.level3_SSO_Password;
		String storeId = LoginTestData.level3StoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_level4";
		String userID = LoginTestData.level4_SSO_UserId;
		String password = LoginTestData.level4_SSO_Password;
		String storeId = LoginTestData.level4StoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_supervisor";
		String userID = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_supervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_supervisorWithRoleAssignment";
		String userID = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_orgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_orgAdmin";
		String userID = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String storeId = LoginTestData.orgAdminStoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4136_operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4136_operator";
		String userID = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String todaydate=Base.returnTodayDate();
		String day=Integer.toString(Base.getDayFromDate(todaydate)-1);
		String []a=todaydate.split("/");
		String pastdate=a[0]+"/"+day+"/"+a[2];
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userID, password).selectLocation(storeId)
				.goToVarianceStatPage();
		//Select Daily from the drop down
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectDateForDailyStat(pastdate);
			Reporter.reportPassResult(
					browser,
					"User should be able to select the past date ",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the past date ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}catch(Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	//TC4137 : Verify that level 5 and level 6 users have access to the current business date "Daily" Stat Variance information but are restricted from viewing historical "Daily" Stat Variance information and any "Monthly" Stat Variance information. 
	
	
	
	@Test
	public void varianceStatBundle_US1933_TC4137_level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4137_level5";
		String userId = LoginTestData.level5_SSO_UserId;
		String password = LoginTestData.level5_SSO_Password;
		String storeId = LoginTestData.level5StoreId;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.createDailyInventoryWrin1;		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = new VarianceStatPage(driver);
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a daily Inventory
		physicalInventoryPage.submitDailyInventoryForAWrin(wrin01, quantity, quantity, quantity);
		//Go to State Varient page
		Thread.sleep(2000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		GenericMethods.clickOnElement(homePage.VarianceStat_BT, "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		Thread.sleep(3000);
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}catch(Exception e)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
		}catch(Exception e)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}
		if(GenericMethods.isElementDisplayed(driver.findElement(By.xpath("//table[@id='dailyinvstattable']/tbody/tr/td[1][contains(.,'"+wrin01+"')]")), "Created Physical Inventory"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
	@Test
	public void varianceStatBundle_US1933_TC4137_level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1933_TC4137_level6";
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		String storeId = LoginTestData.level6StoreId;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.createDailyInventoryWrin1;		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = new VarianceStatPage(driver);
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a daily Inventory
		physicalInventoryPage.submitDailyInventoryForAWrin(wrin01, quantity, quantity, quantity);
		//Go to State Varient page
		Thread.sleep(2000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		GenericMethods.clickOnElement(homePage.VarianceStat_BT, "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		Thread.sleep(3000);
		try
		{
			varianceStatPage.selectVarianceStatType("Daily");
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}catch(Exception e)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Daily' from the dropdown",
					"Pass");
			
		}
		Thread.sleep(2000);
		try
		{
			varianceStatPage.selectVarianceStatType("Monthly");
			Reporter.reportTestFailure(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}catch(Exception e)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to select 'Monthly' from the dropdown",
					"Pass");
		}
		if(GenericMethods.isElementDisplayed(driver.findElement(By.xpath("//table[@id='dailyinvstattable']/tbody/tr/td[1][contains(.,'"+wrin01+"')]")), "Created Physical Inventory"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
}
