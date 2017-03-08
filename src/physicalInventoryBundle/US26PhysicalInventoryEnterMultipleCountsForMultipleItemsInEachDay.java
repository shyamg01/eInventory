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

public class US26PhysicalInventoryEnterMultipleCountsForMultipleItemsInEachDay extends AbstractTest{
	
	//TC240 : Verify that User is able to enter multiple inventory count for multiple raw items throughout the day.
	@Test
	public void physicalInventory_US26_TC240() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US26_TC240";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String outerPacks1 = "1234";
		String innerPacks1 = "11111.11";
		String looseUnits1 = "12345.12";
		String samplewRINID2 = GlobalVariable.createDailyInventoryWrin2;
		String outerPacks2 = "1028";
		String innerPacks2 = "15400.11";
		String looseUnits2 = "12084.12";
		String samplewRINID3 = GlobalVariable.createDailyInventoryWrin3;
		String outerPacks3 = "1028";
		String innerPacks3 = "15400.11";
		String looseUnits3 = "12084.12";
		String stratDate=GlobalVariable.startDate;
		String createDate = GlobalVariable.createDate;
		String inventoryTime = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(5000);
		String time1 = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time "+time1);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(GlobalVariable.createDate)
				.selectTimeForPhysicalInventory(time1);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1).addQuantityForARawItem(samplewRINID1, outerPacks1,innerPacks1, looseUnits1);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
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
		Thread.sleep(3000); 
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(5000); 
		if(physicalInventoryPage.verifyInventorySaved(createDate, time1, "Daily")){
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
		homePage.goToPhysicalInventoryPage();
		Thread.sleep(5000);
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(5000);
		String time2 = physicalInventoryPage.getTimeForNewInventory(createDate, time1);
		System.out.println("time2 "+time2);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate)
				.selectTimeForPhysicalInventory(time2);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2).addQuantityForARawItem(samplewRINID2, outerPacks2,innerPacks2, looseUnits2);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, time2, "Daily")){
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
		homePage.goToPhysicalInventoryPage();
		Thread.sleep(5000);
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(5000);
		String time3 = physicalInventoryPage.getTimeForNewInventory(createDate, time2);
		System.out.println("time2 "+time3);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.selectADateForPhysicalInventory(GlobalVariable.createDate)
				.selectTimeForPhysicalInventory(time3);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID3).addQuantityForARawItem(samplewRINID3, outerPacks3,innerPacks3, looseUnits3);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
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
		if(physicalInventoryPage.verifyInventorySaved(createDate, time3, "Daily")){
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
		
	}

}
