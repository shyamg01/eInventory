package physicalInventoryBundle;

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
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;

public class US11_DisplayRawItemOuterPackInnerPackLooseUnitsDescriptions extends AbstractTest{
	
	//TC1883 : Verify that  pack, case and loose units descriptions should be  displayed inside the applicable editable field.
	@Test()
	public void physicalInventory_US11_TC1883() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US11_TC1883";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.dailyInventoryWrin1;
		String wrin_Description = GlobalVariable.dailyInventoryWrin1_description;
		String case_Description = GlobalVariable.dailyInventoryWrin1_case_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
		Thread.sleep(3000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String looseUnits_Description = rawItemActivityPage.RawItemInformation_UOM_Value.getText();
		System.out.println("looseUnits_Description "+looseUnits_Description);
		String innerPack_Description = rawItemActivityPage.RawItemInformation_InnerPack_Value.getText();
		System.out.println("innerPack_Description "+innerPack_Description);
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		Thread.sleep(2000);
		PhysicalInventoryPage physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchAndAddRawItem(samplewRINID1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if(physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(samplewRINID1,wrin_Description)
				& physicalInventoryPage.CreateInventory_Case_TB_List.get(0).getAttribute("placeholder").equals(case_Description)
				& physicalInventoryPage.CreateInventory_Pack_TB_List.get(0).getAttribute("placeholder").equals(innerPack_Description)
				& physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).getAttribute("placeholder").equals(looseUnits_Description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the description of editable field case, pack and loose related to D1",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the description of editable field case, pack and loose related to D1",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
