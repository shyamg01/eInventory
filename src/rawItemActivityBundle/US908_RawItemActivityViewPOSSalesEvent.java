package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.TransferLandingPage;

public class US908_RawItemActivityViewPOSSalesEvent extends AbstractTest{
	
	//TC2692 : Verify when any significant event (POS Open, POS Close, or Physical Inventory) is approved or submitted it will display a new event named "POS Sales".
	@Test(enabled =false)
	public void rawItemActivity_US908_TC2692() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US908_TC2692";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItem1;
		String createDate=GlobalVariable.createDate;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		if(rawItemActivityPage.RawItemActivity_POSSales_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the event named POS Sales against WRIN=X",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the event named POS Sales against WRIN=X",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	/*//TC2693 : Verify the time utilized to populate the "date and time columns" is same date and time of the new Inventory event.
	@Test()
	public void rawItemActivity_US908_TC2693() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		*//** Variable Section : **//*
		AbstractTest.tcName="rawItemActivity_US908_TC2693";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		*//***********************************//*
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.selectStartDate(stratDate);
		Thread.sleep(2000);
		physicalInventoryPage.ViewInventoryBT_List.get(0).click();
		String inventoryDate = wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ViewInventoryPopUp_Date_BT)).getAttribute("value");
		System.out.println("inventoryDate "+ inventoryDate);
		String inventoryTime = wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ViewInventoryPopUp_Time_BT)).getAttribute("value");
		System.out.println("inventoryTime "+ inventoryTime);
		String samplewRINID = physicalInventoryPage.getFirstWrinIdInCompletedInventory();
		System.out.println("samplewRINID "+ samplewRINID);
		physicalInventoryPage.ViewInventoryPopUp_Close_BT.click();
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.clickOnDateGroup(inventoryDate);
		if(rawItemActivityPage.verifyInventoryActivityDisplayed(inventoryTime,inventoryDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the date as d1 and time as T. for physical inventory activity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the date as d1 and time as T. for physical inventory activity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}*/
	
	//TC2694 : Verify the display of number in loose unit UOM for an initiated events.
	@Test()
	public void rawItemActivity_US908_TC2694() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US908_TC2694";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItem1;

		String createDate = GlobalVariable.createDate;
		String transferType = GlobalVariable.transferTypeOffice;
		String amount=Integer.toString(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		Thread.sleep(3000);
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		rawItemWastePage.addQuantitiesForMultipleWrin(samplewRINID, amount, "", "");
		Thread.sleep(2000);
		String wsteAmount=rawItemWastePage.RawWasteForm_TotalUnitsValue.getText().trim();
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(2000);
		TransferLandingPage transferLandingPage = homePage.goToTransferLandingPage();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.selectTransferType(transferType).insertAndAddDetailsToTransfer(samplewRINID, "2","", "1");
		Thread.sleep(2000);
		String itemTotal=transferLandingPage.AddTransferItemsPopup_TotalUnits_Value.getText().trim().replace("Each", "").trim();
		/*//Get the time of transfer
		String transferTime=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();*/
		//Select the transfer type as "in" and select the store from dropdown an add the transfer details
		System.out.println("Type is"+transferType);
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.TransferAdded_Messag));
		Thread.sleep(3000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		
		if(rawItemActivityPage.verifyWasteActivityDisplayed(wsteAmount,createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the date as d1 and time as T. for Waste activity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the date as d1 and time as T. for Waste activity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(rawItemActivityPage.verifyTransferActivityDisplayed(itemTotal,createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the date as d1 and time as T. for Waste activity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the date as d1 and time as T. for Waste activity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2695 : Verify the display of sum of all "Sales..." Total Calculated Servings (in Loose Unit UOMs) within the selected dates and times at the top of the Raw Item Activity page.
	@Test()
	public void rawItemActivity_US908_TC2695() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US908_TC2695";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
	
		String createDate = GlobalVariable.createDate;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;
		int amount=Base.generateNdigitRandomNumber(2);
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		/*rawItemWastePage.selectDateForRawWaste(createDate);*/
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		rawItemWastePage.addQuantitiesForMultipleWrin(samplewRINID, "", "", Integer.toString(amount));
		/*String wasteTime = rawItemWastePage.SelectTime_TB.getText();*/
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(3000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		if(rawItemActivityPage.verifyWasteActivityDisplayed("-"+Integer.toString(amount)+".0000",createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the date and amount for Waste activity",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the date and amount Waste activity",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	/*	String wasteCount = rawItemActivityPage.getWasteEventCount(wasteTime);
		System.out.println("Waste count "+ wasteCount);
		if(wasteCount.equals("-2.0000")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view waste unit count in Raw Item Activity Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view waste unit count in Raw Item Activity Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
	}

}
