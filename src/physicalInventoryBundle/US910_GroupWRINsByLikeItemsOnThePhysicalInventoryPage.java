package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US910_GroupWRINsByLikeItemsOnThePhysicalInventoryPage extends AbstractTest{
	
	//TC1664 : Verify the grouping of like-items on physical inventory detail page.
	@Test()
	public void physicalInventory_US910_TC1664() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US910_TC1664";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID_frozen = GlobalVariable.frozenWRIN;
		String samplewRINID_refrigerated = GlobalVariable.RefrigeratedWRIN;
		String samplewRINID_dry = GlobalVariable.DryWRIN;
		String stratDate=GlobalVariable.startDate;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(5000);
		String inventoryTime = physicalInventoryPage.getTimeForNewInventory(createDate, time);
		System.out.println("inventoryTime "+inventoryTime);
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		if(physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_dry,"Dry")
				& physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_frozen,"Frozen")
				& physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_refrigerated,"Refrigerated")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view wrin Ids under their Temperature zone Container in create Inventory Model",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view wrin Ids under their Temperature zone Container in create Inventory Model",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID_frozen);
		physicalInventoryPage.addQuantityForARawItem(samplewRINID_frozen, "1", "1", "1");
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID_refrigerated);
		physicalInventoryPage.addQuantityForARawItem(samplewRINID_refrigerated, "1", "1", "1");
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID_dry);
		physicalInventoryPage.addQuantityForARawItem(samplewRINID_dry, "1", "1", "1");
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(2000); 
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_dry,"Dry")
				& physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_frozen,"Frozen")
				& physicalInventoryPage.verifyTemperatureZoneDisplayedForItem(samplewRINID_refrigerated,"Refrigerated")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view wrin Ids under their Temperature zone Container in view Inventory Model",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view wrin Ids under their Temperature zone Container in view Inventory Model",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
