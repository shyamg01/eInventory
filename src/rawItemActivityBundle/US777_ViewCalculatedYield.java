package rawItemActivityBundle;

import java.io.IOException;

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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US777_ViewCalculatedYield  extends AbstractTest{
	
	//TC1734 : Verify the calculated yield is shown on the Raw Item information screen.
	@Test()
	public void rawItemActivity_US777_TC1734() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US777_TC1734";
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
		Thread.sleep(2000);
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Lebel)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_CalculatedYield_Value)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the countable yield against X.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the countable yield against X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
}
