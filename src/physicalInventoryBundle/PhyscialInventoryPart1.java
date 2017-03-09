package physicalInventoryBundle;

import java.io.IOException;
import java.util.ArrayList;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.StoreControlSettingsPage;

public class PhyscialInventoryPart1  extends AbstractTest{
	
	//Verify removal of list on physical inventory page and also verify that user is able to submit physical inventory against each available item as its own inventory.
	@Test()
	public void physicalInventory_PI01() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI01";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String caseqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPhysicalInventoryPage();
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventory_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to Daily Inventory button in Physical Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to Daily Inventory button in Physical Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Select wrinDD = new Select(physicalInventoryPage.Wrin_DD);
		wrinDD.selectByVisibleText("All countable WRINs");
		Thread.sleep(2000);
		String wrinId = physicalInventoryPage.WrinId_List.get(0).getText();
		physicalInventoryPage.selectWrinForSubmissionInPILandingPage(wrinId, caseqty, innerPackqty, looseUnitqty);
		GenericMethods.clickOnElement(physicalInventoryPage.SubmitSelectedItems_BT, "SubmitSelectedItems_BT");
		GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		Thread.sleep(5000);
		if(!physicalInventoryPage.verifyWrinIdDisplayedInPILandingPage(wrinId)){
			Reporter.reportPassResult(
					browser,
					"WRIN X should get removed from countable WRINS list after submitting.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"WRIN X should get removed from countable WRINS list after submitting.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(physicalInventoryPage.InventoryHistory_BT, "InventoryHistory_BT");
		Thread.sleep(2000);
		if (physicalInventoryPage.verifyWrinIdDisplayedInInventoryHistoryPage(wrinId)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to find the raw item X in inventory history.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to find the raw item X in inventory history.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the WRINS are getting removed from physical inventory required count section once physical inventory is submitted against the same.
	@Test()
	public void physicalInventory_PI02() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI02";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String caseqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPhysicalInventoryPage();
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventory_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to Daily Inventory button in Physical Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to Daily Inventory button in Physical Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Select wrinDD = new Select(physicalInventoryPage.Wrin_DD);
		wrinDD.selectByVisibleText("Required Counts");
		Thread.sleep(2000);
		String wrinId = physicalInventoryPage.WrinId_List.get(0).getText();
		physicalInventoryPage.selectWrinForSubmissionInPILandingPage(wrinId, caseqty, innerPackqty, looseUnitqty);
		GenericMethods.clickOnElement(physicalInventoryPage.SubmitSelectedItems_BT, "SubmitSelectedItems_BT");
		GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		Thread.sleep(5000);
		if(!physicalInventoryPage.verifyWrinIdDisplayedInPILandingPage(wrinId)){
			Reporter.reportPassResult(
					browser,
					"WRIN X should get removed from Required Counts WRINS list after submitting.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"WRIN X should get removed from Required Counts WRINS list after submitting.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(physicalInventoryPage.InventoryHistory_BT, "InventoryHistory_BT");
		Thread.sleep(2000);
		if (physicalInventoryPage.verifyWrinIdDisplayedInInventoryHistoryPage(wrinId)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to find the raw item X in inventory history.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to find the raw item X in inventory history.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI03() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI03";
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createDailyInventoryWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		GenericMethods.clickOnElement(rawItemActivityPage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_Frequency_DD)
				& Base.isElementDisplayed(rawItemActivityPage.RawItemInformation_popUp_Frequency_Lebel)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view frequency for selected wrin Item in Raw Item Information Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view frequency for selected wrin Item in Raw Item Information Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI04() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI04";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String caseqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitqty = String.valueOf(Base.generateNdigitRandomNumber(1));
		String inventoryDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.enterQuantityForAllWrin(caseqty, innerPackqty, looseUnitqty);
		ArrayList<String> wirnIdList = new ArrayList<String>();
		for(WebElement wrinId : physicalInventoryPage.DailyInventoryPopUp_WrinId_List){
			wirnIdList.add(wrinId.getText());
		}
		ArrayList<String> itemTotalList = new ArrayList<String>();
		for(String wirnId : wirnIdList){
			itemTotalList.add(physicalInventoryPage.getItemTotalForAWrin(wirnId));
		}
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(5000);
		GenericMethods.clickOnElement(physicalInventoryPage.InventoryHistory_BT, "InventoryHistory_BT");
		int count = 0;
		for (String wirnId : wirnIdList) {
			if (physicalInventoryPage.verifyInventorySubmittedForItem(wirnId,inventoryDate, itemTotalList.get(count))) {
				Reporter.reportPassResult(
						browser,
						"User should be able to submit inventory against multiple items at the same time.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to submit inventory against multiple items at the same time.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			count++;
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI05() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI05";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createDailyInventoryWrin2;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		//Click on Information button
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT,"Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		String currentFrequency = select.getFirstSelectedOption().getText();
		System.out.println("currentFrequency "+currentFrequency);
		if(currentFrequency.equals("Weekly")){
			select.selectByVisibleText("Monthly");
		}else{
			select.selectByVisibleText("Weekly");
		}
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_Submit_BT, "RawItemInformation_popUp_Submit_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT,"RawItemInformation_ConfirmationPopUp_Yes_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT,"Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		String updatedFrequency = select.getFirstSelectedOption().getText();
		if(currentFrequency.equals("Weekly")){
			if(updatedFrequency.equals("Monthly")){
				Reporter.reportPassResult(
						browser,
						"User should be able to change the frequency code on RII.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to change the frequency code on RII.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else{
			if(updatedFrequency.equals("Weekly")){
				Reporter.reportPassResult(
						browser,
						"User should be able to change the frequency code on RII.",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to change the frequency code on RII.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI06() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI06";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.newFoodItem;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		//Click on Information button
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT,"Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		String currentFrequency = select.getFirstSelectedOption().getText();
		if(currentFrequency.equals("Weekly")){
				Reporter.reportPassResult(
						browser,
						"User should be able to view the default frequency code as weekly for new food items in RII Page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the default frequency code as weekly for new food items in RII Page",
						"Fail");
				AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI07() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI07";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.newNonFoodItem;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		//Click on Information button
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT,"Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		String currentFrequency = select.getFirstSelectedOption().getText();
		if(currentFrequency.equals("Monthly")){
				Reporter.reportPassResult(
						browser,
						"User should be able to view the default frequency code as monthly for new non food items in RII Page",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the default frequency code as monthly for new non food items in RII Page",
						"Fail");
				AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI08() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI08";
		StoreControlSettingsPage storSettingsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		storSettingsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToStoreSettingsPage();
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_BT, "InventorySetting_BT");
		if (Base.isElementDisplayed(storSettingsPage.InventorySetting_Invoices_Label)
				&& Base.isElementDisplayed(storSettingsPage.InventorySetting_Invoices_Label)
				&& Base.isElementDisplayed(storSettingsPage.InventorySetting_Invoices_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the settings options: Invoices. Transfers, Physical inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the settings options: Invoices. Transfers, Physical inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI09() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI09";
		StoreControlSettingsPage storSettingsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		storSettingsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToStoreSettingsPage();
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_BT, "InventorySetting_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.InventorySetting_PhysicalInventory_Label));
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT, "InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		int existingSelectedDay = Integer.parseInt(storSettingsPage.PhysicalInventorySetting_SelectedDay_BT.getAttribute("value"));
		System.out.println("existingSelectedDay "+ existingSelectedDay);
		if(existingSelectedDay <= 4){
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",storSettingsPage.PhysicalInventorySetting_WeekDays_List.get(existingSelectedDay+1));
		}else{
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",storSettingsPage.PhysicalInventorySetting_WeekDays_List.get(existingSelectedDay-2));
		}
		int newSelectedDay = Integer.parseInt(storSettingsPage.PhysicalInventorySetting_SelectedDay_BT.getAttribute("value"));
		if(existingSelectedDay != newSelectedDay){
			Reporter.reportPassResult(
					browser,
					"User should be able to select the day for physical inventory week day in store setting page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the day for physical inventory week day in store setting page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_Save_BT, "PhysicalInventorySetting_Save_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySettingSaved_Confirmation_MSG));
		Thread.sleep(3000);
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT, "InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		int updatedDay = Integer.parseInt(storSettingsPage.PhysicalInventorySetting_SelectedDay_BT.getAttribute("value"));
		if(updatedDay == newSelectedDay){
			Reporter.reportPassResult(
					browser,
					"user is able to save the setting for weekly Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"user is able to save the setting for weekly Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_WeekDays_List.get(existingSelectedDay-1), "Weekday");
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_Save_BT, "PhysicalInventorySetting_Save_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySettingSaved_Confirmation_MSG));
		Thread.sleep(3000);
	}
	
	// Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI10() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "physicalInventory_PI10";
		StoreControlSettingsPage storSettingsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		storSettingsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToStoreSettingsPage();
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_BT,"InventorySetting_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.InventorySetting_PhysicalInventory_Label));
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT,"InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		String existingState = storSettingsPage.PhysicalInventorySetting_WeeklySetting_Toggle_BT.getAttribute("class");
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_WeeklySetting_Toggle_BT,"PhysicalInventorySetting_WeeklySetting_Toggle_BT");
		String newState = storSettingsPage.PhysicalInventorySetting_WeeklySetting_Toggle_BT.getAttribute("class");
		System.out.println("newState "+ newState);
		if(existingState.contains("switch-off")){
			if(newState.contains("switch-on")) {
				Reporter.reportPassResult(
						browser,
						"user is able to enable the the option 'Allow weekly inventory to start 1 day before end of week?'",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"user is able to enable the the option 'Allow weekly inventory to start 1 day before end of week?'",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else{
			if(newState.contains("switch-off")) {
				Reporter.reportPassResult(
						browser,
						"user is able to enable the the option 'Allow weekly inventory to start 1 day before end of week?'",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"user is able to enable the the option 'Allow weekly inventory to start 1 day before end of week?'",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_Save_BT,"PhysicalInventorySetting_Save_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySettingSaved_Confirmation_MSG));
		Thread.sleep(3000);
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT,"InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		String updatedState = storSettingsPage.PhysicalInventorySetting_WeeklySetting_Toggle_BT.getAttribute("class");
		System.out.println("updatedState "+ updatedState);
		if (newState.contains(updatedState)) {
			Reporter.reportPassResult(
					browser,
					"user is able to save the setting for weekly Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"user is able to save the setting for weekly Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_WeeklySetting_Toggle_BT,"PhysicalInventorySetting_WeeklySetting_Toggle_BT");
		GenericMethods.clickOnElement(storSettingsPage.PhysicalInventorySetting_Save_BT,"PhysicalInventorySetting_Save_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySettingSaved_Confirmation_MSG));
		Thread.sleep(3000);
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI11() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI11";
		StoreControlSettingsPage storSettingsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		storSettingsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToStoreSettingsPage();
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_BT, "InventorySetting_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.InventorySetting_PhysicalInventory_Label));
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT, "InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		if (Base.isElementDisplayed(storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to find the option Days before End of Month that Monthly Food Inventory may begin",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to find the option Days before End of Month that Monthly Food Inventory may begin",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clearValueOfElement(storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB");
		GenericMethods.enterValueInElement(storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB","1");
		if (!Base.isElementDisplayed(storSettingsPage.InvalidValue_Error_Message)
				&& storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB.getAttribute("value").equals("1")) {
			Reporter.reportPassResult(
					browser,
					"User should not get any error message when values are within 0-3.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not get any error message when values are within 0-3.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String foodItemExistingValue =  storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB.getAttribute("value");
		System.out.println("foodItemExistingValue "+ foodItemExistingValue);
		GenericMethods.clearValueOfElement(storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB");
		GenericMethods.enterValueInElement(storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB","4");
		
		System.out.println("msg "+ storSettingsPage.InvalidValue_Error_Message.getText());
		System.out.println("new value : "+ storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB.getAttribute("value"));
		if (Base.isElementDisplayed(storSettingsPage.InvalidValue_Error_Message)
				&& storSettingsPage.InvalidValue_Error_Message.getText().contains("Value must be numeric from 0 to 3 with no decimals")
				&& !storSettingsPage.PhysicalInventorySetting_FoodItem_InventoryDaysPrior_TB.getAttribute("value").equals("4")) {
			Reporter.reportPassResult(
					browser,
					"User should get error message when entered value is 4 as value must be numeric from 0-3 with no decimals",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should get error message when entered value is 4 as value must be numeric from 0-3 with no decimals",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the presence of additional Inventory settings in store settings page
	@Test()
	public void physicalInventory_PI12() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI12";
		StoreControlSettingsPage storSettingsPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Store Settings Page
		storSettingsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToStoreSettingsPage();
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_BT, "InventorySetting_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.InventorySetting_PhysicalInventory_Label));
		GenericMethods.clickOnElement(storSettingsPage.InventorySetting_PhysicalInventory_Edit_BT, "InventorySetting_PhysicalInventory_Edit_BT");
		wait.until(ExpectedConditions.visibilityOf(storSettingsPage.PhysicalInventorySetting_Popup_Title));
		if (Base.isElementDisplayed(storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_Label)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to find the option Days before End of Month that Monthly Non-Food Inventory may begin (0-3)",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to find the option Days before End of Month that Monthly Non-Food Inventory may begin (0-3)",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clearValueOfElement(storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB");
		GenericMethods.enterValueInElement(storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB","1");
		if (!Base.isElementDisplayed(storSettingsPage.InvalidValue_Error_Message)
				&& storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB.getAttribute("value").equals("1")) {
			Reporter.reportPassResult(
					browser,
					"User should not get any error message when values are within 0-3.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not get any error message when values are within 0-3.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		String foodItemExistingValue =  storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB.getAttribute("value");
		System.out.println("foodItemExistingValue "+ foodItemExistingValue);
		GenericMethods.clearValueOfElement(storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB");
		GenericMethods.enterValueInElement(storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB, "PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB","4");
		
		System.out.println("msg "+ storSettingsPage.InvalidValue_Error_Message.getText());
		System.out.println("new value : "+ storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB.getAttribute("value"));
		if (Base.isElementDisplayed(storSettingsPage.InvalidValue_Error_Message)
				&& storSettingsPage.InvalidValue_Error_Message.getText().contains("Value must be numeric from 0 to 3 with no decimals")
				&& !storSettingsPage.PhysicalInventorySetting_NonFoodItem_InventoryDaysPrior_TB.getAttribute("value").equals("4")) {
			Reporter.reportPassResult(
					browser,
					"User should get error message when entered value is 4 as value must be numeric from 0-3 with no decimals",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should get error message when entered value is 4 as value must be numeric from 0-3 with no decimals",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the color of the range indicator is changing to yellow while submitting physical inventory.
	@Test()
	public void physicalInventory_PI19() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI19";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createDailyInventoryWrin2;	
		String posDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		String perpectualCount = rawitemactivitypage.getInventoryCountForADate(posDate).split(" ")[0];
		System.out.println("perpectualCount "+ perpectualCount);
		physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		String looseUnits = physicalInventoryPage.getLooseUnitsForGreenIndicator(perpectualCount);
		System.out.println("looseUnits "+ looseUnits);
		String unitCount = physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID, "", "", looseUnits).getItemTotalForAWrin(samplewRINID);
		String calculatedRange = physicalInventoryPage.calculateRangeIndicator(perpectualCount, unitCount);
		String currentRange = physicalInventoryPage.getRangeIndicatorForAWrin(samplewRINID);
		if(calculatedRange.equals(currentRange) 
				&& currentRange.equals("Green")){
			Reporter.reportPassResult(
					browser,
					"User should be able to change the range indicator to green while submitting a physcial Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to change the range indicator to green while submitting a physcial Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the color of the range indicator is changing to yellow while submitting physical inventory.
	@Test()
	public void physicalInventory_PI20() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI20";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createDailyInventoryWrin2;	
		String posDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		String perpectualCount = rawitemactivitypage.getInventoryCountForADate(posDate).split(" ")[0];
		System.out.println("perpectualCount "+ perpectualCount);
		physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		String looseUnits = physicalInventoryPage.getLooseUnitsForYellowIndicator(perpectualCount);
		System.out.println("looseUnits "+ looseUnits);
		String unitCount = physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID, "", "", looseUnits).getItemTotalForAWrin(samplewRINID);
		String calculatedRange = physicalInventoryPage.calculateRangeIndicator(perpectualCount, unitCount);
		String currentRange = physicalInventoryPage.getRangeIndicatorForAWrin(samplewRINID);
		if(calculatedRange.equals(currentRange) 
				&& currentRange.equals("Yellow")){
			Reporter.reportPassResult(
					browser,
					"User should be able to change the range indicator to yellow while submitting a physcial Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to change the range indicator to yellow while submitting a physcial Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the color of the range indicator is changing to red while submitting physical inventory.
	@Test()
	public void physicalInventory_PI21() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI21";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.createDailyInventoryWrin2;	
		String posDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		String perpectualCount = rawitemactivitypage.getInventoryCountForADate(posDate).split(" ")[0];
		System.out.println("perpectualCount "+ perpectualCount);
		physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		String looseUnits = physicalInventoryPage.getLooseUnitsForRedIndicator(perpectualCount);
		System.out.println("looseUnits "+ looseUnits);
		String unitCount = physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID, "", "", looseUnits).getItemTotalForAWrin(samplewRINID);
		String calculatedRange = physicalInventoryPage.calculateRangeIndicator(perpectualCount, unitCount);
		String currentRange = physicalInventoryPage.getRangeIndicatorForAWrin(samplewRINID);
		if(calculatedRange.equals(currentRange)){
			Reporter.reportPassResult(
					browser,
					"User should be able to change the range indicator to red while submitting a physcial Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to change the range indicator to red while submitting a physcial Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//Verify the color of the range indicator is changing to red while submitting physical inventory.
	@Test()
	public void physicalInventory_PI23() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_PI23";
		PhysicalInventoryPage physicalInventoryPage;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.nonRecipeItemWithActualUsageZero;	
		String posDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(2000);
		String perpectualCount = rawitemactivitypage.getInventoryCountForADate(posDate).split(" ")[0];
		System.out.println("perpectualCount "+ perpectualCount);
		physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		String looseUnits = physicalInventoryPage.getLooseUnitsForYellowIndicator(perpectualCount);
		System.out.println("looseUnits "+ looseUnits);
		String unitCount = physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID, "", "", looseUnits).getItemTotalForAWrin(samplewRINID);
		String calculatedRange = physicalInventoryPage.calculateRangeIndicator(perpectualCount, unitCount);
		String currentRange = physicalInventoryPage.getRangeIndicatorForAWrin(samplewRINID);
		if(calculatedRange.equals(currentRange) 
				&& currentRange.equals("Yellow")){
			Reporter.reportPassResult(
					browser,
					"User should be able to change the range indicator to yellow while submitting a physcial Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to change the range indicator to yellow while submitting a physcial Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.enterQuantityForNewAddedWrin(samplewRINID, "", "", "");
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Title, "DailyInventoryPopUp_Title");
		currentRange = physicalInventoryPage.getRangeIndicatorForAWrin(samplewRINID);
		if(currentRange.equals("N/A")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view no color for range indicator color when unit counts will be removed ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view no color for range indicator color when unit counts will be removed",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
}
