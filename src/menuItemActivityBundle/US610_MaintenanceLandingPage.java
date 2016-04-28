package menuItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import sprint2.AbstractTest;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;

public class US610_MaintenanceLandingPage extends AbstractTest{
	
	// TC772: Verify that user is able to select Raw Item Activity from Inventory drop-down list.
	@Test()
	public void menuItemActivity_US610_TC772() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemActivity_Title)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US610_TC772",
					"Verify that user is able to select Raw Item Activity from Inventory drop-down list.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US610_TC772","menuItemActivity_US610_TC772",
					"Verify that user is able to select Raw Item Activity from Inventory drop-down list.",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US610_TC772");
		}
	}
	
	// TC773: Verify that user is able to select Raw Item Information modal from Raw Item Activity screen.
	@Test()
	public void menuItemActivity_US610_TC773() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String wrinId = GlobalVariable.rawItemActivityWrin;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId);
		Thread.sleep(5000);
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemActivity_Table_Wrapper)
				& rawItemActivityPage.verifyWrinItemDisplayed(wrinId)
				& Base.isElementDisplayed(rawItemActivityPage.Information_BT)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US610_TC773",
					"System should display all the activity related to selected Raw Item along with Information button.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US610_TC773_Condition1","menuItemActivity_US610_TC773",
					"System should display all the activity related to selected Raw Item along with Information button.",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US610_TC773_Condition1");
		}
		rawItemActivityPage.Information_BT.click();
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_Title)
				& rawItemActivityPage.verifyWrinItemDisplayedInRawItemInformationPopUp(wrinId)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US610_TC773",
					"A new modal screen should get opened and it should display information related to selected Raw Item.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US610_TC773_Condition2","menuItemActivity_US610_TC773",
					"A new modal screen should get opened and it should display information related to selected Raw Item.",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US610_TC773_Condition2");
		}
	}

}
