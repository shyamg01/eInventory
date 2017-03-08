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

public class US1934_PhysicalInventoryBundleUserRoleAccess extends AbstractTest{
	
	//TC4075_DailyInventory : Verify the features accessible to level 1 user on physical inventory page
	@Test(groups="Smoke")
	public void physicalInventory_US1934_TC4075_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4075_DailyInventory";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4075_WeeklyInventory : Verify the features accessible to level 1 user on physical inventory page
	@Test(groups="Smoke")
	public void physicalInventory_US1934_TC4075_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4075_WeeklyInventory";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4075_MonthlyInventory : Verify the features accessible to level 1 user on physical inventory page
	@Test(groups="Smoke")
	public void physicalInventory_US1934_TC4075_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4075_MonthlyInventory";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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
	
	//TC4076_DailyInventory : Verify the features accessible to level 2 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4076_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4076_DailyInventory";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4075_WeeklyInventory : Verify the features accessible to level 1 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4076_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4076_WeeklyInventory";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(2000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4075_MonthlyInventory : Verify the features accessible to level 1 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4076_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4076_MonthlyInventory";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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
	
	//TC4077_DailyInventory : Verify the features accessible to level 3 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4077_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4077_DailyInventory";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4077_WeeklyInventory : Verify the features accessible to level 3 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4077_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4077_WeeklyInventory";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4077_MonthlyInventory : Verify the features accessible to level 3 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4077_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4077_MonthlyInventory";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4078_DailyInventory : Verify the features accessible to level 4 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4078_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4078_DailyInventory";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4078_WeeklyInventory : Verify the features accessible to level 4 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4078_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4078_WeeklyInventory";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4078_MonthlyInventory : Verify the features accessible to level 4 user on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4078_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4078_MonthlyInventory";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4079_DailyInventory : Verify the features accessible to Supervisor on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4079_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4079_DailyInventory";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4079_WeeklyInventory : Verify the features accessible to supervisor on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4079_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4079_WeeklyInventory";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4079_MonthlyInventory : Verify the features accessible to supervisor on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4079_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4079_MonthlyInventory";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4080_DailyInventory : Verify the features accessible to Supervisor with role assignment on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4080_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4080_DailyInventory";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4080_WeeklyInventory : Verify the features accessible to Supervisor with role assignment on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4080_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4080_WeeklyInventory";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4080_MonthlyInventory : Verify the features accessible to Supervisor with role assignment on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4080_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4080_MonthlyInventory";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4081_DailyInventory : Verify the features accessible to Org Admin on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4081_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4081_DailyInventory";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4081_WeeklyInventory : Verify the features accessible to org admin on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4081_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4081_WeeklyInventory";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4081_MonthlyInventory : Verify the features accessible to org admin on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4081_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4081_MonthlyInventory";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4082_DailyInventory : Verify the features accessible to Operator on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4082_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4082_DailyInventory";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4082_WeeklyInventory : Verify the features accessible to Operator on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4082_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4082_WeeklyInventory";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID1 = GlobalVariable.createWeeklyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateWeeklyInventory_BT,"CreateWeeklyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Weekly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted weekly physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4082_MonthlyInventory : Verify the features accessible to Operator on physical inventory page
	@Test()
	public void physicalInventory_US1934_TC4082_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4082_MonthlyInventory";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateMonthlyInventory_BT,"CreateMonthlyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Monthly")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
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

	//TC4082_DailyInventory : level 5 user should be able to create and view history of daily physical inventory
	@Test()
	public void physicalInventory_US1934_TC4083_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4083_DailyInventory";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4082_WeeklyInventory : level 5 user should NOT be able to create and view history of weekly physical inventory
	@Test()
	public void physicalInventory_US1934_TC4083_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4083_WeeklyInventory";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		if(physicalInventoryPage.CreateWeeklyInventory_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 5  user should not be able to create Weekly inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5  user should not be able to create Weekly inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4083_MonthlyInventory : level 5 user should NOT be able to create and view history of monthly physical inventory
	@Test()
	public void physicalInventory_US1934_TC4083_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4083_MonthlyInventory";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		if(physicalInventoryPage.CreateMonthlyInventory_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 5  user should not be able to create Monthly inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5  user should not be able to create Monthly inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC4084_DailyInventory : level 6 user should be able to create and view history of daily physical inventory
	@Test()
	public void physicalInventory_US1934_TC4084_DailyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4084_DailyInventory";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
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
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
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
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, inventoryTime, "Daily")){
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
		physicalInventoryPage.clickOnPostedInventory(createDate, inventoryTime);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(physicalInventoryPage.verifyRawItemDisplayedInPostedInventory(samplewRINID1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history of submitted daily physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4084_WeeklyInventory : level 6 user should NOT be able to create and view history of weekly physical inventory
	@Test()
	public void physicalInventory_US1934_TC4084_WeeklyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4084_WeeklyInventory";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		if(physicalInventoryPage.CreateWeeklyInventory_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 5  user should not be able to create Weekly inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5  user should not be able to create Weekly inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4084_MonthlyInventory : level 6 user should NOT be able to create and view history of monthly physical inventory
	@Test()
	public void physicalInventory_US1934_TC4084_MonthlyInventory() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1934_TC4084_MonthlyInventory";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		if(physicalInventoryPage.CreateMonthlyInventory_BT.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,
					"Level 5  user should not be able to create Monthly inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5  user should not be able to create Monthly inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
