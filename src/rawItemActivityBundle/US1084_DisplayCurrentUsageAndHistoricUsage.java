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
import eInventoryPageClasses.AbstractTest;

public class US1084_DisplayCurrentUsageAndHistoricUsage extends AbstractTest {
	
	//TC2412 : Verify that current Usage/$1000 and Month End Usage/$1000  is displayed on the Raw Item Information page for non-recipe item.
	@Test()
	public void rawItemActivity_US1084_TC2412() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1084_TC2412";
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
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CurrentUsage_Lebel)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CurrentUsage_Value)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_HistoricUsage_Lebel)
				& rawItemActivityPage.verifyMonthYearDisplayedForHistoricalUsage()
				& rawItemActivityPage.RawItemInformation_HistoricUsageTable_Usage_List.size()==13){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Month and Year and Month End Usage/$1000 for each historical month for non-recipe item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Month and Year and Month End Usage/$1000 for each historical month for non-recipe item",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2413 : Verify that current Usage/$1000 and Month End Usage/$1000  is displayed on the Raw Item Information page for condiment item.
	@Test()
	public void rawItemActivity_US1084_TC2413() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1084_TC2413";
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
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CurrentUsage_Lebel)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CurrentUsage_Value)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_HistoricUsage_Lebel)
				& rawItemActivityPage.verifyMonthYearDisplayedForHistoricalUsage()
				& rawItemActivityPage.RawItemInformation_HistoricUsageTable_Usage_List.size()==13
				& rawItemActivityPage.verifyUsageDisplayedForHistoricalMonth()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Month and Year and Month End Usage/$1000 for each historical month for condiment item.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Month and Year and Month End Usage/$1000 for each historical month for condiment item.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	

}
