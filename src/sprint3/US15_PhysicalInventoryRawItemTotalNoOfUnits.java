package sprint3;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;

import common.Base;
import common.LoginTestData;
import common.ReadTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US15_PhysicalInventoryRawItemTotalNoOfUnits extends AbstractTest
{
	
	//TC2054 (Can not be automated)
	
	/*TC2055 Verify that the user cannot enter more than 2 digits after decimal places in 
	 * outer pack, inner pack and loose unit columns.*/
	@Test()
	public void Sprint3_US15_TC2055() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/* Start-Variable Deceleration */
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint3_US15_TC2055", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,	"WRINId");
		String outerPack = "12.452";
		String innerPack = "14.352";
		String looseUnits = "11.111";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		PhysicalInventoryPage physicalInventoryPage;
		/* End */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		// Click on start New Inventory button
		physicalInventoryPage.CreateWeeklyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		// enter the outer pack value and verify that error message is displaying for invalid outer pack
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(outerPack);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2055",
					"Error message should display for invalid outer pack value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2055_Condition1","Sprint3_US15_TC2055",
					"Error message should display for invalid outer pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2055_Condition1");
		}
		Thread.sleep(1000);
		// enter the inner pack value and verify that error message is displaying for invalid inner pack
		physicalInventoryPage.CreateInventory_Pack_TB_List.get(0).sendKeys(innerPack);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2055",
					"Error message should display for invalid inner pack value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2055_Condition2","Sprint3_US15_TC2055",
					"Error message should display for invalid inner pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2055_Condition2");
		}
		Thread.sleep(1000);
		// enter the loose units value and verify that error message is displaying for invalid Loose unit
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnits);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2055",
					"Error message should display for invalid loose units value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2055_Condition3","Sprint3_US15_TC2055",
					"Error message should display for invalid loose units value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2055_Condition3");
		}
	}
	
	/*TC2056 Verify that a user can enter only 4 digits before a decimal and 2
	digits after the decimal in the outer pack column.*/
	@Test()
	public void Sprint3_US15_TC2056() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint3_US15_TC2056", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,"WRINId");
		String invalidInnerPack = "123456.551";
		String validInnerPack = "12345.55";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		PhysicalInventoryPage physicalInventoryPage;
		/* End */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		// Click on start New Inventory button
		physicalInventoryPage.CreateWeeklyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		// enter the Inner pack value and verify that error message is displaying for invalid Inner pack
		physicalInventoryPage.CreateInventory_Pack_TB_List.get(0).sendKeys(invalidInnerPack);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2056",
					"Error message should display for invalid outer pack value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2056_Condition1","Sprint3_US15_TC2056",
					"Error message should display for invalid outer pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2056_Condition1");
		}
		Thread.sleep(1000);
		// enter the valid Inner pack value
		physicalInventoryPage.CreateInventory_Pack_TB_List.get(0).clear();
		physicalInventoryPage.CreateInventory_Pack_TB_List.get(0).sendKeys(validInnerPack);
		if (!Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2056",
					"Error message should not display for valid outer pack value",
					"Pass");
		}else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2056_Condition2","Sprint3_US15_TC2056",
					"Error message should not display for valid outer pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2056_Condition2");
		}
	}
	
	/*TC2057 Verify that a user can enter only 5 digits before a decimal and 2
	digits after the decimal in the inner pack column.*/
	@Test()
	public void Sprint3_US15_TC2057() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint3_US15_TC2057", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,"WRINId");
		String invalidOuterPack = "123456.551";
		String validOuterPack = "12345.55";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		PhysicalInventoryPage physicalInventoryPage;
		/* End */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		// Click on start New Inventory button
		physicalInventoryPage.CreateWeeklyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		// enter the Case pack value and verify that error message is displaying for invalid Case pack
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(invalidOuterPack);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2057",
					"Error message should display for invalid inner pack value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2057_Condition1","Sprint3_US15_TC2057",
					"Error message should display for invalid inner pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2057_Condition1");
		}
		Thread.sleep(1000);
		// enter the valid Case pack value
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).clear();
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(validOuterPack);
		if (!Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2057",
					"Error message should not display for valid inner pack value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2057_Condition2","Sprint3_US15_TC2057",
					"Error message should not display for valid inner pack value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2057_Condition2");
		}
	}

	/*TC2058 Verify that a user can enter only 5 digits before a decimal and 2
	digits after the decimal in the loose column.*/
	@Test()
	public void Sprint3_US15_TC2058() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/* Start-Variable Deceleration */
		HSSFSheet manualInvoiceNewPageSheet = ReadTestData.getTestDataSheet("Sprint3_US15_TC2058", "Object1");
		String wrinId = ReadTestData.getTestData(manualInvoiceNewPageSheet,"WRINId");
		String invalidLooseUnit = "123456.551";
		String validLooseUnit = "12345.55";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		PhysicalInventoryPage physicalInventoryPage;
		/* End */
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		// Click on start New Inventory button
		physicalInventoryPage.CreateWeeklyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		// enter the Loose Unit value and verify that error message is displaying for invalid Loose Unit
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(invalidLooseUnit);
		if (Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2058",
					"Error message should display for invalid Loose unit value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2058_Condition1","Sprint3_US15_TC2058",
					"Error message should display for invalid Loose unit value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2058_Condition1");
		}
		Thread.sleep(1000);
		// enter the valid Loose Unit value
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).clear();
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(validLooseUnit);
		if (!Base.isElementDisplayed(physicalInventoryPage.InvalidValues_Msg)) {
			Reporter.reportPassResult(
					browser,"Sprint3_US15_TC2058",
					"Error message should not display for valid loose units value",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"Sprint3_US15_TC2058_Condition2","Sprint3_US15_TC2058",
					"Error message should not display for valid loose units value",
					"Fail");
			AbstractTest.takeSnapShot("Sprint3_US15_TC2058_Condition2");
		}
	}
}
