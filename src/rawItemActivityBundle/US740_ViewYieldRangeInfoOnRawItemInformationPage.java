package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;

import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;

public class US740_ViewYieldRangeInfoOnRawItemInformationPage extends AbstractTest{
	
	
	//TC1579:Verify the user is able to view Target Yield range for any Raw Item on raw item information page.
	@Test()
	public void rawItemActivity_US740_TC1579() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="rawItemActivity_US740_TC1579";
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
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		Thread.sleep(1500);
		//Verify that Target Yield Range should be displayed in raw item info page
		if(!(rawItemActivityPage.RawItemInformation_YieldRange_Value.getText().isEmpty())){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the target yield range in Raw Item Information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the target yield range in Raw Item Information Page",
					"Fail");
			AbstractTest.takeSnapShot();

		}
	}
	
	//TC1581 : Verify "Target Yield Range" for raw item whose midrange yield number is < 100
	@Test()
	public void rawItemActivity_US740_TC1581() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US740_TC1581";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItem3;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		float middleRangeYieldNumber = Float.valueOf(GlobalVariable.middleRangeYieldNumber_00055);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		Thread.sleep(1500);
		//Get the total Yield Range Value
		String yieldRange = rawItemActivityPage.RawItemInformation_YieldRange_Value.getText();
		//Get the low point
		float lowPoint = Float.parseFloat(yieldRange.split(" - ")[0]);
		//Verify that low point value should be middleRangeYieldNumber - 1
		boolean verifyYieldRange = (lowPoint == (middleRangeYieldNumber - 1));
		//Get the high point
		float highPoint = Float.parseFloat(yieldRange.split(" - ")[1]);
		//Verify that high point value should be middleRangeYieldNumber + 1
		verifyYieldRange = (highPoint == (middleRangeYieldNumber + 1));
		if (verifyYieldRange) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the lowPoint as midpointyieldnumber-1 and HighPoint as midpointyieldnumber+1",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the lowPoint as midpointyieldnumber-1 and HighPoint as midpointyieldnumber+1",
					"Fail");
			AbstractTest.takeSnapShot();

		}
	}
	
	//TC1582 : Verify "Target Yield Range" for raw item whose midrange yield number is > 100
	@Test()
	public void rawItemActivity_US740_TC1582() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US740_TC1582";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItem4;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		float middleRangeYieldNumber = Float.valueOf(GlobalVariable.middleRangeYieldNumber_00028);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		Thread.sleep(1500);
		//Get the total Yield Range Value
		String yieldRange = rawItemActivityPage.RawItemInformation_YieldRange_Value.getText();
		// Get the low point
		float lowPoint = Float.parseFloat(yieldRange.split(" - ")[0]);
		// Verify that low point value should be middleRangeYieldNumber - 10
		boolean verifyYieldRange = (lowPoint == (middleRangeYieldNumber - 10));
		// Get the high point
		float highPoint = Float.parseFloat(yieldRange.split(" - ")[1]);
		// Verify that high point value should be middleRangeYieldNumber + 10
		verifyYieldRange = (highPoint == (middleRangeYieldNumber + 10));
		if (verifyYieldRange) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the lowPoint as midpointyieldnumber-10 and HighPoint as midpointyieldnumber+10",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the lowPoint as midpointyieldnumber-10 and HighPoint as midpointyieldnumber+10",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
