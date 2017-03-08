package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US457_GroupWRINsByTemperatureZoneOnPhysicalInventoryPage extends AbstractTest{
	
	//TC1226 : Verify all the raw items present in physical inventory should be grouped to respective temperature zone.
	@Test()
	public void physicalInventory_US457_TC1226() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US457_TC1226";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String frozenWrin = GlobalVariable.frozenWRIN;
		String dryWrin = GlobalVariable.DryWRIN;
		String refridgeratedWrin = GlobalVariable.RefrigeratedWRIN;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(frozenWrin);
		if( physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(frozenWrin,"Frozen")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view frozen wrin Ids under their Frozen Container in create Inventory Model",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view frozen wrin Ids under their Frozen Container in create Inventory Model",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(dryWrin);
		if(physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(dryWrin,"Dry")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view dry wrin Ids under Dry Container in create Inventory Model",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view dry wrin Ids under Dry Container in create Inventory Model",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(refridgeratedWrin);
		if(physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(refridgeratedWrin,"Refrigerated")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Refrigerated wrin Ids under Refrigerated Container in create Inventory Model",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Refrigerated wrin Ids under Refrigerated Container in create Inventory Model",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
