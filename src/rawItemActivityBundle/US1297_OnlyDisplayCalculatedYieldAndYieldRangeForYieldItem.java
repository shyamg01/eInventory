package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.VarianceStatPage;
import eInventoryPageClasses.AbstractTest;

public class US1297_OnlyDisplayCalculatedYieldAndYieldRangeForYieldItem extends AbstractTest{
	
	//TC2043 : Verify that calculated yield range and target yield range is visible against an item in raw item information page.
	@Test()
	public void rawItemActivity_US1297_TC2043() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1297_TC2043";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItem3;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Lebel)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Value)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_YieldRange_Lebel)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_YieldRange_Value)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Target yield range and Calculated yield in raw item information related to WRIN X.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Target yield range and Calculated yield in raw item information related to WRIN X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2059 : Verify that calculated yield range and target yield range is visible against an item in raw item information page.
	@Test()
	public void rawItemActivity_US1297_TC2059() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1297_TC2059";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.nonRecipeRawItem;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		if(!Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Lebel)
				& !Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Value)
				& !Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_YieldRange_Lebel)
				& !Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_YieldRange_Value)){
			Reporter.reportPassResult(
					browser,
					"User should not be able to view the Target yield range and Calculated yield in raw item information against a specific item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view the Target yield range and Calculated yield in raw item information against a specific item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2062 : Verify that calculated yield range and target yield range is visible against an item in Daily Stat page.
	@Test(enabled =false)
	public void rawItemActivity_US1297_TC2062() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1297_TC2062";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createMonthlyInventoryWrin1;
		//String stratDate=GlobalVariable.startDate;
		//String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.verifyYieldValueDisplayedForWrin(samplewRINID)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the calculated yield value against Item X on variance stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the calculated yield value against Item X on variance stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
