package physicalInventoryBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.AbstractTest;

public class US15_CalculateAndDisplayTotalUnitsForRawItemsOnPhysicalInventoryPage extends AbstractTest{
	
	//TC2054 : Verify Item Total column displayed on physical Inventory modal.
	@Test()
	public void physicalInventory_US15_TC2054() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US15_TC2054";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createMonthlyInventoryWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if(!physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).isEmpty()){
			Reporter.reportPassResult(
					browser,
					"Item Total column should be displayed in Inventory List screen.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total column should be displayed in Inventory List screen.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2055 : Verify calculation of Item Total column for each WRIN.
	@Test()
	public void physicalInventory_US15_TC2055() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US15_TC2055";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.uomConversionItem2;
		BigDecimal uomConversionFactor = new BigDecimal(GlobalVariable.uomConversionItem2_UOM_CONVERSION_FACTOR);
		BigDecimal CASE_PACK_QTY = new BigDecimal(GlobalVariable.uomConversionItem2_CASE_PACK_QTY);
		BigDecimal INNERPACK_QTY = new BigDecimal(GlobalVariable.uomConversionItem2_INNERPACK_QTY);
		BigDecimal qty = new BigDecimal("10");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		physicalInventoryPage.OuterPackQty_TB.sendKeys(qty.toString());
		BigDecimal outerPackQty = CASE_PACK_QTY.divide(uomConversionFactor, 0, RoundingMode.HALF_UP);
		BigDecimal innerPackQty = INNERPACK_QTY.divide(uomConversionFactor, 0, RoundingMode.HALF_UP);
		BigDecimal ItemTotal = outerPackQty.multiply(qty).add(new BigDecimal(0).multiply(innerPackQty)).add(new BigDecimal(0));
		System.out.println("item total "+physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1));
		if(physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).replace(",", "").equals(ItemTotal.toString())){
			Reporter.reportPassResult(
					browser,
					"Item Total field should get updated from 0 to "+ItemTotal,
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total field should get updated from 0 to "+ItemTotal,
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.InnerPackCountQty_TB.sendKeys(qty.toString());
		ItemTotal = outerPackQty.multiply(qty).add(qty.multiply(innerPackQty)).add(new BigDecimal(0));
		System.out.println("item total "+physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1));
		if(physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).replace(",", "").equals(ItemTotal.toString())){
			Reporter.reportPassResult(
					browser,
					"Item Total field should get updated to "+ItemTotal,
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total field should get updated to "+ItemTotal,
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.LooseCountQty_TB.sendKeys(qty.toString());
		ItemTotal = outerPackQty.multiply(qty).add(qty.multiply(innerPackQty)).add(qty);
		System.out.println("item total "+physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1));
		if(physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1).replace(",", "").equals(ItemTotal.toString())){
			Reporter.reportPassResult(
					browser,
					"Item Total field should get updated to "+ItemTotal,
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total field should get updated to "+ItemTotal,
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2056 : Verify that the Item Total field get updated as User type value in text field (Case, Pack or Loose).
	@Test()
	public void physicalInventory_US15_TC2056() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US15_TC2056";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.dailyInventoryWrin1;
		String qty ="10";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		physicalInventoryPage.OuterPackQty_TB.sendKeys(qty);
		String itemTotal = physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1);
		System.out.println("item total "+itemTotal);
		if(!itemTotal.equals("0")){
			Reporter.reportPassResult(
					browser,
					"Item Total should get updated on entering the outer pack",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total should get updated on entering the outer pack",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.InnerPackCountQty_TB.sendKeys(qty);
		String itemTotal1 = physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1);
		System.out.println("item total "+itemTotal1);
		if(!itemTotal1.equals(itemTotal)){
			Reporter.reportPassResult(
					browser,
					"Item Total field should get updated on entering inner pack",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total field should get updated from 1200 to 1320.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.LooseCountQty_TB.sendKeys(qty);
		String itemTotal2 = physicalInventoryPage.getItemTotalCountForWrinIdInCreateInventoryTable(samplewRINID1);
		System.out.println("item total "+itemTotal2);
		if(!itemTotal2.equals(itemTotal1)){
			Reporter.reportPassResult(
					browser,
					"Item Total field should get updated on entering loose units",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Item Total field should get updated on entering loose units",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
