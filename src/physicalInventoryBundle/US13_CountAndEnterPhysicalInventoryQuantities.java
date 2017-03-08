package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.AbstractTest;

public class US13_CountAndEnterPhysicalInventoryQuantities extends AbstractTest{
	
	//TC2060 : Verify that a user can enter only numeric values in outer pack, inner pack and loose units.
	@Test()
	public void physicalInventory_US13_TC2060() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US13_TC2060";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		// enter the outer pack value and verify that error message is displaying for invalid outer pack
		physicalInventoryPage.OuterPackQty_TB.clear();
		physicalInventoryPage.OuterPackQty_TB.sendKeys("1234");
		//verify that error message is displayed
		boolean errorMsgNotDisplayedForValidValue = !(Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg));
		//Enter numeric value for outer pack quantity
		Thread.sleep(1000);
		physicalInventoryPage.OuterPackQty_TB.clear();
		physicalInventoryPage.OuterPackQty_TB.sendKeys("a#$");
		boolean errorMsgDisplayed = Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg);
		System.out.println("Error "+physicalInventoryPage.InvalidValues_Msg.getText());
		Thread.sleep(1000);
		if(errorMsgDisplayed & errorMsgNotDisplayedForValidValue){
			Reporter.reportPassResult(
					browser,
					"User should not be allowed to enter special Characters in Case Quantity Box",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be allowed to enter special Characters in Case Quantity Box",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.InnerPackCountQty_TB.clear();
		physicalInventoryPage.InnerPackCountQty_TB.sendKeys("12345.99");
		//verify that error message is displayed
		errorMsgNotDisplayedForValidValue = !(Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg));
		//Enter numeric value for outer pack quantity
		Thread.sleep(1000);
		physicalInventoryPage.InnerPackCountQty_TB.clear();
		physicalInventoryPage.InnerPackCountQty_TB.sendKeys("a#$");
		errorMsgDisplayed = Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg);
		System.out.println("Error "+physicalInventoryPage.InvalidValues_Msg.getText());
		Thread.sleep(1000);
		if(errorMsgDisplayed & errorMsgNotDisplayedForValidValue){
			Reporter.reportPassResult(
					browser,
					"User should not be allowed to enter special Characters in Inner PackCount Qty Text Box",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be allowed to enter special Characters in Inner Pack Count Qty Text Box",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.LooseCountQty_TB.clear();
		physicalInventoryPage.LooseCountQty_TB.sendKeys("12345.99");
		//verify that error message is displayed
		errorMsgNotDisplayedForValidValue = !(Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg));
		//Enter numeric value for outer pack quantity
		Thread.sleep(1000);
		physicalInventoryPage.LooseCountQty_TB.clear();
		physicalInventoryPage.LooseCountQty_TB.sendKeys("a#$");
		errorMsgDisplayed = Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg);
		System.out.println("Error "+physicalInventoryPage.InvalidValues_Msg.getText());
		Thread.sleep(1000);
		if(errorMsgDisplayed & errorMsgNotDisplayedForValidValue){
			Reporter.reportPassResult(
					browser,
					"User should not be allowed to enter special Characters in Loose Units Qty Text Box",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be allowed to enter special Characters in Loose Units Qty Text Box",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2061 : Verify user is able to submit physical Inventory.
	@Test()
	public void physicalInventory_US13_TC2061() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US13_TC2061";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin2;
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
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time).searchRawItemInInventoryList(samplewRINID1);
		physicalInventoryPage.OuterPackQty_TB.clear();
		physicalInventoryPage.OuterPackQty_TB.sendKeys("10");
		physicalInventoryPage.selectADateForPhysicalInventory(GlobalVariable.createDate);
		physicalInventoryPage.CreateInventoryPopUp_Submit_BT.click();
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
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)).click();
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
		if(physicalInventoryPage.verifyInventorySaved(GlobalVariable.createDate, time, "Monthly")){
			Reporter.reportPassResult(
					browser,
					"User should be able to add physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to add physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	

}
