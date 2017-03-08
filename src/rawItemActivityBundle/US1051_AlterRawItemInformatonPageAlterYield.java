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

public class US1051_AlterRawItemInformatonPageAlterYield extends AbstractTest {
	
	//TC1736 : Verify calculation of yield for raw items.
	@Test()
	public void rawItemActivity_US1051_TC1736() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1051_TC1736";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String caseQty=	Integer.toString(Base.generateNdigitRandomNumber(1));
		String samplewRINID = GlobalVariable.rawItem3;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String date = Base.returnTodayDate();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a Physical Inventory
		physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID, caseQty, "", "");
		Thread.sleep(5000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		System.out.println("Date "+rawItemActivityPage.RawItemInformation_CalculatedYieldDate_Value.getAttribute("innerHTML"));
		if(rawItemActivityPage.RawItemInformation_CalculatedYieldDate_Value.getAttribute("innerHTML").contains(date)){
			Reporter.reportPassResult(
					browser,
					"The calculated yield should be calculated from the time of the most recent physical inventory to the previous physical inventory.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"The calculated yield should be calculated from the time of the most recent physical inventory to the previous physical inventory.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
