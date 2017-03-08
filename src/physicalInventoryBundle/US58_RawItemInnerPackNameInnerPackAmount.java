package physicalInventoryBundle;

import java.io.IOException;
import java.math.BigDecimal;

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

public class US58_RawItemInnerPackNameInnerPackAmount extends AbstractTest{
	
	//TC2000 : Verify that the user is able to view full description UOM in the UOM column of Raw Item Information screen.
	@Test()
	public void physicalInventory_US58_TC2000() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "physicalInventory_US58_TC2000";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		BigDecimal caseQty = new BigDecimal(1);
		BigDecimal packQty = new BigDecimal(1);
		//Raw Item with INNER_PK_QTY != 0
		String samplewRINID1 = GlobalVariable.uomConversionItem2;
		String samplewRINID1_INNERPACK_QTY = GlobalVariable.uomConversionItem2_INNERPACK_QTY;
		String samplewRINID1_UOM_CONVERSION_FACTOR = GlobalVariable.uomConversionItem2_UOM_CONVERSION_FACTOR;
		//Raw Item with INNER_PK_QTY = 0
		String samplewRINID2 = GlobalVariable.uomConversionItem4;
		String samplewRINID2_UOM_CONVERSION_FACTOR = GlobalVariable.uomConversionItem4_UOM_CONVERSION_FACTOR;
		String samplewRINID2_CASE_PACK_QTY = GlobalVariable.uomConversionItem4_CASE_PACK_QTY;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage
				.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID2);
		if (!Base.isElementDisplayed(physicalInventoryPage.InnerPackCountQty_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to view  Inner Pack Quantity box for raw item with INNER_PK_QTY = 0",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view  Inner Pack Quantity box for raw item with INNER_PK_QTY = 0",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",String.valueOf(caseQty));
		BigDecimal expectedItemTotal = new BigDecimal(samplewRINID2_CASE_PACK_QTY).divide(new BigDecimal(samplewRINID2_UOM_CONVERSION_FACTOR)).multiply(caseQty);
		if (physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID2).equals(String.valueOf(expectedItemTotal))) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to view Item Total as (samplewRINID2_CASE_PACK_QTY/samplewRINID2_UOM_CONVERSION_FACTOR)*CaseQuantity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view Item Total as (samplewRINID2_CASE_PACK_QTY/samplewRINID2_UOM_CONVERSION_FACTOR)*CaseQuantity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.InnerPackCountQty_TB,"InnerPackCountQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.InnerPackCountQty_TB,"InnerPackCountQty_TB",String.valueOf(caseQty));
		expectedItemTotal = new BigDecimal(samplewRINID1_INNERPACK_QTY).divide(new BigDecimal(samplewRINID1_UOM_CONVERSION_FACTOR)).multiply(packQty);
		if (physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).equals(String.valueOf(expectedItemTotal))) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to view Item Total as (samplewRINID1_INNERPACK_QTY/samplewRINID2_UOM_CONVERSION_FACTOR)*packQty",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view Item Total as (samplewRINID1_INNERPACK_QTY/samplewRINID2_UOM_CONVERSION_FACTOR)*packQty",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2001 : Verify that the user is able to view full description UOM in the UOM column of Raw Item Information screen.
	@Test()
	public void physicalInventory_US58_TC2001() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US58_TC2001";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.uomConversionItem2;
		String samplewRINID1_ALTERNATE_INNERPACK_DESC = GlobalVariable.uomConversionItem2_ALTERNATE_INNERPACK_DESC;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if(physicalInventoryPage.InnerPackCountQty_TB.getAttribute("placeholder").equalsIgnoreCase(samplewRINID1_ALTERNATE_INNERPACK_DESC)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view  Inner Pack Description as ALTERNATE_INNERPACK_DESC.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view  Inner Pack Description as ALTERNATE_INNERPACK_DESC.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
