package varianceStatBundle;

import java.io.IOException;
import java.math.BigDecimal;

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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.VarianceStatPage;

public class US916_ViewAndPrintStatVariance extends AbstractTest{
	
	//TC1706 : Verify the user has the ability to to view the daily stat.
	@Test
	public void varianceStatBundle_US916_TC1706() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1706";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		if(Base.isElementDisplayed(homePage.VarianceStat_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Variance Stat Link in main menu",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Variance Stat Link in main menu",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1707 : Verify the user has the ability to to view the daily stat.
	@Test(groups="Smoke")
	public void varianceStatBundle_US916_TC1707() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1707";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		System.out.println(varianceStatPage.VarianceStatTableHeaderDisplayed());
		System.out.println(varianceStatPage.dailyStatRecords_List.size()>0);
		if(varianceStatPage.VarianceStatTableHeaderDisplayed()
				& varianceStatPage.dailyStatRecords_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view each WRIN and Description marked as \"daily\" and marked as a recipe raw item.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view each WRIN and Description marked as \"daily\" and marked as a recipe raw item.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1708 : Verify the user has the ability to to view the daily stat.
	@Test
	public void varianceStatBundle_US916_TC1708() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1708";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		System.out.println(varianceStatPage.VarianceStatTableHeaderDisplayed());
		System.out.println(varianceStatPage.dailyStatRecords_List.size()>0);
		if(varianceStatPage.VarianceStatTableHeaderDisplayed()
				& varianceStatPage.dailyStatRecords_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view header Information in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view header Information in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1708 : Verify the user has the ability to to view the daily stat.
	@Test
	public void varianceStatBundle_US916_TC1780() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1780";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(Base.isElementDisplayed(varianceStatPage.StatGain_Label)
				& Base.isElementDisplayed(varianceStatPage.StatGain_Value)
				//& Base.isElementDisplayed(varianceStatPage.StatLoss_Label)
				& Base.isElementDisplayed(varianceStatPage.StatLoss_Value)
				& Base.isElementDisplayed(varianceStatPage.StatVariance_Value)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		System.out.println("gain "+varianceStatPage.StatGain_Value.getText());
		BigDecimal statGain = new BigDecimal(varianceStatPage.StatGain_Value.getText().replace("$", ""));
		BigDecimal statLoss = new BigDecimal(varianceStatPage.StatLoss_Value.getText().replace("$", ""));
		BigDecimal statVar = new BigDecimal(varianceStatPage.StatVariance_Value.getText().replace("$", ""));
		if(statVar.equals(statLoss.add(statGain))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Varience value as sum of Stat Loss and Stat Gain",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Varience value as sum of Stat Loss and Stat Gain",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC1782 : Verify the user has the ability to to view the daily stat.
	@Test
	public void varianceStatBundle_US916_TC1782() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//** Variable Section : **//*
		AbstractTest.tcName="varianceStatBundle_US916_TC1782";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.actualUsageItem;
		String createDate = GlobalVariable.createDate;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID1, quantity, quantity, quantity);
		VarianceStatPage varianceStatPage = homePage.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		String ActualUsageInStatPage = varianceStatPage.getActualUsageForAWrin(samplewRINID1);
		System.out.println("ActualUsageInStatPage  "+ ActualUsageInStatPage);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		String diffInStatPageActivity = varianceStatPage.calculateActualUsageForARawItem(createDate);
		System.out.println("ActualUsage Calculated  "+diffInStatPageActivity);
		if(ActualUsageInStatPage.equals(diffInStatPageActivity)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Actual usage value as per the calculation against any entry.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Actual usage value as per the calculation against any entry.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC1782 : Verify the user has the ability to to view the daily stat.
	@Test
	public void varianceStatBundle_US916_TC1786() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//** Variable Section : **//*
		AbstractTest.tcName="varianceStatBundle_US916_TC1786";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		String diffInStatPage = varianceStatPage.getDifferenceForAWrin(samplewRINID1);
		System.out.println("difffffff  "+ diffInStatPage);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		String diffInStatPageActivity = varianceStatPage.calculateDifferenceForARawItem(createDate);
		System.out.println("Difference  "+diffInStatPageActivity);
		if(diffInStatPage.equals(diffInStatPageActivity)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the $diff value same as as that of recorded $difference against any entry.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the $diff value same as as that of recorded $difference against any entry.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC1787 : Verify the $ difference on "daily stat" page
	@Test
	public void varianceStatBundle_US916_TC1787() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		//** Variable Section : **//*
		AbstractTest.tcName="varianceStatBundle_US916_TC1787";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.verifyDifferenceDisplayedForSelectedDate(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the $ diff for all displayed  details within selected date range.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the $ diff for all displayed  details within selected date range.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC1790 : Verify the stat gain,stat loss and stat variance in header section.
	@Test()
	public void varianceStatBundle_US916_TC1790() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1790";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		System.out.println("StatGain_Label "+varianceStatPage.StatGain_Label.getText());
		if(Base.isElementDisplayed(varianceStatPage.StatGain_Label)
				& Base.isElementDisplayed(varianceStatPage.StatGain_Value)
				& Base.isElementDisplayed(varianceStatPage.StatLoss_Value)
				& Base.isElementDisplayed(varianceStatPage.StatVariance_Value)
				& varianceStatPage.StatGain_Label.getText().contains("Stat Loss:")
				& varianceStatPage.StatGain_Label.getText().contains("Stat Variance:")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal calculateGain = varianceStatPage.getStatGainFromDifference();
		BigDecimal statGain = new BigDecimal(varianceStatPage.StatGain_Value.getText().replace("$", ""));
		if(calculateGain.equals(statGain)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain value as sum of all positive difference values in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain value as sum of all positive difference values in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal calculatedLoss = varianceStatPage.getStatLossFromDifference();
		BigDecimal statLoss = new BigDecimal(varianceStatPage.StatLoss_Value.getText().replace("$", ""));
		if(calculatedLoss.equals(statLoss)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Loss value as sum of all negative difference values in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Loss value as sum of all negative difference values in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal statVar = new BigDecimal(varianceStatPage.StatVariance_Value.getText().replace("$", ""));
		if(statVar.equals(statLoss.add(statGain))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain + Stat Loss as Stat Variance in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain + Stat Loss as Stat Variance in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1791 : Verify the display order on "Daily stat" page.
	@Test
	public void varianceStatBundle_US916_TC1791() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException{
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1791";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.verifyDifferenceDescendingOrder()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the biggest absolute value of the $ Difference Total first and so forth",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the biggest absolute value of the $ Difference Total first and so forth",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1792 : Verify the user has the ability to select a date to display daily stats
	@Test
	public void varianceStatBundle_US916_TC1792() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1792";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.StatDate_TB.getAttribute("value").equals(GlobalVariable.createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to select a date to display daily stats",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to select a date to display daily stats",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1793 : Verify the user has the ability to select a date to display daily stats
	@Test
	public void varianceStatBundle_US916_TC1793() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1793";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		varianceStatPage.clickOnDateGroup(createDate);
		if(varianceStatPage.VarianceStatRawItemActivity_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be directed to the raw item activity page for the applicable time period on the stat report.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be directed to the raw item activity page for the applicable time period on the stat report.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1795 : Verify the close method  on "daily stat" page.
	@Test
	public void varianceStatBundle_US916_TC1795() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US916_TC1795";
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(varianceStatPage.viewActivityButtn(samplewRINID1),"View Activity Button");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		varianceStatPage.clickOnDateGroup(createDate);
		if(varianceStatPage.VarianceStatRawItemActivity_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be directed to the raw item activity page for the applicable time period on the stat report.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be directed to the raw item activity page for the applicable time period on the stat report.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(varianceStatPage.VarianceStatOverview_BT, "VarianceStatOverview_BT");
		if(varianceStatPage.VarianceStatTableHeaderDisplayed()){
			Reporter.reportPassResult(
					browser,
					"User should be directed back to the Stat landing page on clicking variance stat overview button",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be directed back to the Stat landing page on clicking variance stat overview button",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
