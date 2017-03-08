package physicalInventoryBundle;

import java.io.IOException;
import java.util.ArrayList;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US1233_ViewMissingItemCountsOnPhysicalInventoryModal extends AbstractTest {
	
	//TC2145 : Verify the raw item on Physical Inventory page when Uncounted filter is selected in View Item DDL.
	@Test()
	public void physicalInventory_US1233_TC2145() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1233_TC2145";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		String packQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		String looseQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(5000);
		ArrayList<String>wrinIdlist = new ArrayList<String>();
		for(WebElement wrin : physicalInventoryPage.CreateInventory_WrinId_List){
			wrinIdlist.add(wrin.getText());
		}
		physicalInventoryPage.searchRawItemInInventoryList(wrinIdlist.get(0));
		physicalInventoryPage.addQuantityForARawItem(wrinIdlist.get(0), caseQty, packQty, looseQty);
		physicalInventoryPage.searchRawItemInInventoryList(wrinIdlist.get(1));
		physicalInventoryPage.addQuantityForARawItem(wrinIdlist.get(1), caseQty, packQty, looseQty);
		physicalInventoryPage.CreateInventoryPopUp_Search_BT.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		physicalInventoryPage.CreateInventoryPopUp_Search_BT.sendKeys(Keys.DELETE);
		//physicalInventoryPage.CreateInventoryPopUp_Search_BT.clear();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title)).click();
		physicalInventoryPage.selectValueFromViewItemsDropDown("uncounted");
		if(!physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(wrinIdlist.get(0))
				& !physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(wrinIdlist.get(1))){
			Reporter.reportPassResult(
					browser,
					"User should not be able to view counted wrins while applying Uncounted filter in View Items filter",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view counted wrins while applying Uncounted filter in View Items filter",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		boolean result = true;
		for(int i = 2;i<wrinIdlist.size();i++){
			System.out.println("COunt "+physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(i)));
			result = result & physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(i)).equals("0");
		}
		if(result){
			Reporter.reportPassResult(
					browser,
					"User should be able to view WRIN which contains the Item Total Value as 0 while applying Uncounted filter in View Items filter",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view WRIN which contains the Item Total Value as 0 while applying Uncounted filter in View Items filter",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2146 : Verify WRIN displayed on Physical Inventory Detail screen should get filtered when Counted Drop -down is selected.
	@Test()
	public void physicalInventory_US1233_TC2146() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US1233_TC2146";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		String packQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		String looseQty = String.valueOf(Base.generateNdigitRandomNumber(2));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		ArrayList<String>wrinIdlist = new ArrayList<String>();
		for(WebElement wrin : physicalInventoryPage.CreateInventory_WrinId_List){
			wrinIdlist.add(wrin.getText());
		}
		physicalInventoryPage.searchRawItemInInventoryList(wrinIdlist.get(0));
		physicalInventoryPage.addQuantityForARawItem(wrinIdlist.get(0), caseQty, packQty, looseQty);
		physicalInventoryPage.searchRawItemInInventoryList(wrinIdlist.get(1));
		physicalInventoryPage.addQuantityForARawItem(wrinIdlist.get(1), caseQty, packQty, looseQty);
		physicalInventoryPage.CreateInventoryPopUp_Search_BT.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		physicalInventoryPage.CreateInventoryPopUp_Search_BT.sendKeys(Keys.DELETE);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title)).click();
		physicalInventoryPage.selectValueFromViewItemsDropDown("all");
		if(physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(wrinIdlist.get(0))
				& !physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(0)).equals("0")
				& physicalInventoryPage.verifyRawItemDisplayedInCreateInventoryTable(wrinIdlist.get(1))
				& !physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(1)).equals("0")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view counted wrins while applying all filter in View Items filter",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view counted wrins while applying all filter in View Items filter",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		boolean result = true;
		for(int i = 2;i<wrinIdlist.size();i++){
			System.out.println("COunt "+physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(i)));
			result = result & physicalInventoryPage.getUnitCountForARawItem(wrinIdlist.get(i)).equals("0");
		}
		if(result){
			Reporter.reportPassResult(
					browser,
					"User should be able to view WRIN which contains the Item Total Value as 0 while applying all filter in View Items filter",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view WRIN which contains the Item Total Value as 0 while applying all filter in View Items filter",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
