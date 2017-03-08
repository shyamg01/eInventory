package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class US95_SearchForRawItemOnThePhysicalInventoryPage extends AbstractTest{
	
	//TC2271 : Verify user will be able to search WRIN with ID or description on Inventory List screen.
	@Test()
	public void physicalInventory_US95_TC2271() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US95_TC2271";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String refridgeratedWrin = GlobalVariable.RefrigeratedWRIN;
		String description = GlobalVariable.RefrigeratedWRIN_description;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(refridgeratedWrin);
		if(physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(refridgeratedWrin, description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to search raw item with wrin id",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to search raw item with wrin id",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(description);
		if(physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(refridgeratedWrin, description)){
			Reporter.reportPassResult(
					browser,
					"User should be able to search raw item with wrin description",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to search raw item with wrin description",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2272 : Verify user will be able to view the suggestion when it types on search text field.
	@Test()
	public void physicalInventory_US95_TC2272() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US95_TC2272";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.clear();
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.sendKeys("0000");
		action.sendKeys(Keys.SPACE).build().perform(); 
	    Thread.sleep(1500); 
	    action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size = driver.findElements(By.xpath("//strong[text()='0000']")).size();
		if(size >0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view suggestions below search text field.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view suggestions below search text field.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2273 : Verify proper message should be displayed to user when invalid or not exist in list WRIN is searched.
	@Test()
	public void physicalInventory_US95_TC2273() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US95_TC2273";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		//String weeklyWrin = GlobalVariable.createWeeklyInventoryWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateDailyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.clear();
		physicalInventoryPage.CreateInventoryPopUp_AddWrinSearch_TB.sendKeys("abcdefghi");
		action.sendKeys(Keys.SPACE).build().perform(); 
	    Thread.sleep(1500); 
	    action.sendKeys(Keys.BACK_SPACE).build().perform();
		//physicalInventoryPage.searchRawItemInInventoryList(weeklyWrin);
		if(Base.isElementDisplayed(physicalInventoryPage.NoSearchResults_Label)){
			Reporter.reportPassResult(
					browser,
					"No search results found message should appear on screen.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"No search results found message should appear on screen.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
