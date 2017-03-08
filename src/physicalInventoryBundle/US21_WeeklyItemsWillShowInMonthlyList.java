package physicalInventoryBundle;

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
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US21_WeeklyItemsWillShowInMonthlyList extends AbstractTest{
	
	//TC231 : Verify that User is able to see all weekly and daily inventory items in monthly inventory list.
	@Test
	public void physicalInventory_US21_TC231() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US21_TC231";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String samplewRINID2 = GlobalVariable.createWeeklyInventoryWrin1;
		String stratDate=GlobalVariable.startDate;
		String createDate = GlobalVariable.createDate;
		String inventoryTime = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.selectStartDate(stratDate);
		String time = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time "+time);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(GlobalVariable.createDate).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","10");
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		boolean confirmationMsgDisplayed = Base.isElementDisplayed(physicalInventoryPage.CreateInventory_Confirmation_PopUp_Message);
		if(confirmationMsgDisplayed){
			Reporter.reportPassResult(
					browser,
					"System should prompt message for confirmation Are you sure you want to submit this physical Inventory? with No and Yes option",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"System should prompt message for confirmation Are you sure you want to submit this physical Inventory? with No and Yes option",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.MonthlyInventorySaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view success message on submitting the physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view success message on submitting the physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
			}
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(2000); 
		if(physicalInventoryPage.verifyInventorySaved(createDate, time, "Monthly")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Saved physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Saved physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.clickOnPostedInventory(createDate, time);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)
				& physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID2)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted monthly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted monthly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
