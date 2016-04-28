package sprint11;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemInformationPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.VarianceStatPage;

public class US1204_Level6Access extends AbstractTest {

	//TC2046:Verify that the level 6 user should be able to enter a daily Physical Inventory.
	@Test()
	public void sprint11_US1204_TC2046() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.level6_SSO_UserId;
		String password = LoginTestData.level6_SSO_Password;
		//HSSFSheet physicalInventoryPageSheet = ReadTestData.getTestDataSheet("sprint11_US1204_TC2046", "Object1");
		String caseValue="2";
		String looseUnit="4";
		/***********************************/
		//Go to Physical Inventory page
		String date=Base.returnTodayDate();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage =homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		//Fetch the record count
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		// Verify that create Weekly/Monthly inventory button should be disabled for level 5 user
		if (Boolean.valueOf(physicalInventoryPage.CreateWeeklyInventory_BT.getAttribute("disabled"))
				& Boolean.valueOf(physicalInventoryPage.CreateMonthlyInventory_BT.getAttribute("disabled"))) {
			Reporter.reportPassResult(
					browser,"sprint12_US1203_TC2113",
					"level 5 user should not be able to enter a monthly, weekly Physical Inventory","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1203_TC2112_Condition1","sprint12_US1203_TC2113",
					"level 5 user should not be able to enter a monthly, weekly Physical Inventory","Fail");
			AbstractTest.takeSnapShot("sprint12_US1203_TC2112_Condition1");
		}
		int numberofRecordsBeforeCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		//Create a Physical inventory
		//wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateDailyInventory_BT));
		//click on Daily Inventory button
		physicalInventoryPage.CreateDailyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		//Click on Time Edit button
		physicalInventoryPage.CreateInventory_Time_Edit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Hour_Up_Link));
		//Change the hour time
		physicalInventoryPage.CreateInventory_Hour_Up_Link.click();
		//Change the Minute Time
		physicalInventoryPage.CreateInventory_Minute_Up_Link.click();
		//Fetch the date and time 
		int hour=Integer.parseInt(driver.findElement(By.xpath("//span[@id='eb_tp_hr_span']")).getText());
		System.out.println("hour is"+hour);
		String hourString=null;
		if (hour <= 9) {
			hourString = "0" + Integer.toString(hour);
			System.out.println("Hour string is " + hourString);
		} else {
			hourString = Integer.toString(hour);
			System.out.println("Hour string is " + hourString);
		}
		String min=driver.findElement(By.xpath("//span[@id='eb_tp_min_span']")).getText();
		String time=hourString+":"+min;
		System.out.println("Time is"+time);
		//click on Arrow Button
		physicalInventoryPage.CreateInventory_RawItremList_Arrow_Link.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.CreateInventory_Case_TB_List.get(0)));
		//Enter the case Value 
		physicalInventoryPage.CreateInventory_Case_TB_List.get(0).sendKeys(caseValue);
		//Enter the loose value
		physicalInventoryPage.CreateInventory_Loose_TB_List.get(0).sendKeys(looseUnit);
		physicalInventoryPage.CreateInventory_Submit_BT.click();
		Thread.sleep(4000);
		int numberofRecordsAfterCreate=driver.findElements(By.xpath("//table[@id='inventory_selection_table']/tbody/tr")).size();
		if (numberofRecordsAfterCreate == numberofRecordsBeforeCreate + 1) {

			Reporter.reportPassResult(
					browser, "sprint12_US1203_TC2112",
					"Physical Inventory should be created successfully", "Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"sprint12_US1203_TC2112_Condition2","sprint12_US1203_TC2112",
					"Physical Inventory should be created successfully", "Fail");
			AbstractTest.takeSnapShot("sprint12_US1203_TC2112_Condition2");
		}
		//Click on View button for the newly created inventory
		driver.findElement(By.xpath("//table[@id='inventory_selection_table']/tbody/tr/td[6][preceding-sibling::td[contains(.,'"+date+"')]/span[text()='"+time+"']]//button")).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if (Base.isElementDisplayed(physicalInventoryPage.DailyInventoryList_Title)) {
			Reporter.reportPassResult(
					browser,"sprint12_US1203_TC2112",
					"User should be able to view the created Physical Inventory","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint12_US1203_TC2112_Condition3","sprint12_US1203_TC2112",
					"User should be able to view the created Physical Inventory","Fail");
			AbstractTest.takeSnapShot("sprint12_US1203_TC2112_Condition3");
		}
		
	}
	
	//TC2050 Verify that the level 6 user should be able to view the Stat Variance page..
	@Test()
	public void sprint11_US1204_TC2050() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		VarianceStatPage varianceStatPage;
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to variance stat page
		varianceStatPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToVarianceStatPage();
		//select daily stat from drop down
		varianceStatPage.selectVarianceStatType("Daily");
		//click on start date button
		wait.until(ExpectedConditions.elementToBeClickable(varianceStatPage.StartDate_BT)).click();
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get yesterday date as start date
		cal1.add(Calendar.DATE, -1);
		String startDate = dateFormat.format(cal1.getTime());
		//Select yesterday date from calender
		varianceStatPage.selectDateFromCalender(startDate);
		//Verify that daily stat should displayed for the selected date 
		if (varianceStatPage.verifyVarianceStatLoaded()) {
			Reporter.reportPassResult(
					browser, "sprint11_US1204_TC2050",
					"level 6 user is able to view daily variance stat", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint11_US1204_TC2050","sprint11_US1204_TC2050",
					"level 6 user is able to view daily variance stat", "Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2050_Condition1");
		}
		// click on done with this item button
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.DoneWithThisItem_BT)).click();
		//Select monthly from the drop down
		varianceStatPage.selectVarianceStatType("Monthly");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		//get last month and year
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONTH, -1);
		cal2.set(Calendar.DATE, 1);
        String date = dateFormat2.format(cal2.getTime());
        //select last month from the drop down
        varianceStatPage.selectMonth(date);
        //verify that variance stat should displayed for the selected month
        boolean monthlyVarianceDisplayed = varianceStatPage.verifyVarianceStatLoaded();
        //click on done with this item button
        wait.until(ExpectedConditions.visibilityOf(varianceStatPage.DoneWithThisItem_BT)).click();
        //verify that user should be on variance stat page
		if (monthlyVarianceDisplayed & Base.isElementDisplayed(varianceStatPage.VarianceStatType_DD)) {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2050",
					"level 6 user is able to view Monthly variance stat",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2050","sprint11_US1204_TC2050",
					"level 6 user is able to view Monthly variance stat",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2050_Condition2");
		}
	}
	
	//TC2051:Verify that the level 6 user should be able to enter Raw Waste.
	@Test()
	public void sprint11_US1204_TC2051() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String wrinId01=GlobalVariable.rawItemWatsewrin1;
		String outerPack="3";
		String innerPack="4";
		String looseUnits="5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Create a raw waste entry
		rawItemWastePage.addARawItem(wrinId01, outerPack, innerPack, looseUnits);
		//Get the total waste amount
		String wasteAmount = rawItemWastePage.getTotalWasteAmunt();
		System.out.println("wasteAmount "+wasteAmount);
		//Submit the raw waste entry
		rawItemWastePage.Submit_BT.click();
		Thread.sleep(5000);
		//Verify that raw waste entry should displayed in Promotion and waste page
		if (promotionAndWastePage.isRawWasteEntryPresent(Base.returnTodayDate(), wasteAmount)) {
			Reporter.reportPassResult(
					browser, "sprint11_US1204_TC2051",
					"Level 6 user should be able to enter Raw Waste.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "sprint11_US1204_TC2051","sprint11_US1204_TC2051",
					"Level 6 user should be able to enter Raw Waste.",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2051_Condition1");
		}
		if(Base.isElementDisplayed(promotionAndWastePage.RawPromo_BT) & Base.isElementDisplayed(promotionAndWastePage.CompletedWaste_BT)){
			Reporter.reportTestFailure(
					browser, "sprint11_US1204_TC2051","sprint11_US1204_TC2051",
					"Level 6 user should be restricted to enter Raw Promo and Completed Waste",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2051_Condition2");
		} else {
			Reporter.reportPassResult(browser, "sprint11_US1204_TC2051",
					"Level 6 user should be restricted to enter Raw Promo and Completed Waste.", "Pass");
		}
	}
	
	//TC2052:Verify that the level 6 user can VIEW-ONLY the Raw Item Information page.
	@Test()
	public void sprint11_US1204_TC2052() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		RawItemInformationPage rawItemInformationPage; 
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String wrinId01=GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to raw item info page
		rawItemInformationPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemInformationPage();
		//Search for the WRIN ID
		rawItemInformationPage.searchAndSelectWRINID(wrinId01);
		wait.until(ExpectedConditions.visibilityOf(rawItemInformationPage.RawItemInfo_Title_Label));
		//Verify that Manual Purchase check box and ListType drop down is disabled for Level 6 user
		if(rawItemInformationPage.ManualPurchase_CB.getAttribute("disabled").equals("true")
				& rawItemInformationPage.ListType_DD.getAttribute("disabled").equals("true")){
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2052",
					"Level 6 user can VIEW-ONLY the Raw Item Information page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2052","sprint11_US1204_TC2052",
					"Level 6 user can VIEW-ONLY the Raw Item Information page.",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2052");

		}
	}
	
	/*
	 * TC2053" Verify that the user is restricted from all other views and
	 * functionality in the Inventory system except physical inventory, custom
	 * list, state variance page, raw waste and raw item information page..
	 */	
	@Test()
	public void sprint11_US1204_TC2053() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// go to Inventory Management
		homePage.selectUserWithSSOLogin(userId, password).navigateToInventoryManagement();
		Thread.sleep(4000);
		// Verify that purchage page and custom raw item list page should not display
		if (Base.isElementDisplayed(homePage.Purchases_BT)&& Base.isElementDisplayed(homePage.CustomRawItemLists_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2053_Condition1","sprint11_US1204_TC2053",
					"Purchage Page and Custome Raw Item list page should not display",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2052_Condition1");
		} else {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2053",
					"Purchage Page and Custome Raw Item list page should not display",
					"Pass");
		}
		// Verify that Physical Inventory and Promotion and waste link should display
		if (Base.isElementDisplayed(homePage.PhysicalInventory_BT)&& Base.isElementDisplayed(homePage.PromotionAndWaste_BT)) {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2053",
					"Physical Inventory Page and Promotion and waste page should  display",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2053_Condition2","sprint11_US1204_TC2053",
					"Physical Inventory Page and Promotion and waste page should  display",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2052_Condition2");
		}
		// Navigate to other Inventory function page
		homePage.navigateToOtherInventoryFunctions();
		/*Verify that Transfer,Manual Vendors ,Menu Item Activity ,Menu Item
		Information ,Food over base pages should not display*/
		if (Base.isElementDisplayed(homePage.Transfers_BT) && Base.isElementDisplayed(homePage.ManualVendors_BT)
				&& Base.isElementDisplayed(homePage.MenuItemActivity_BT) && Base.isElementDisplayed(homePage.MenuItemInformation_BT)
				&& Base.isElementDisplayed(homePage.FoodOverBase_BT)) {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2053_Condition3","sprint11_US1204_TC2053",
					"Verify that Transfer,Manual Vendors ,Menu Item Activity ,Menu Item Information ,Food over base pages should not display",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2052_Condition3");
		} else {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2053",
					"Verify that Transfer,Manual Vendors ,Menu Item Activity ,Menu Item Information ,Food over base pages should not display",
					"Pass");
		}
		// Verify that Raw Item Activity,Raw Item Information and Daily stat page should display
		if (Base.isElementDisplayed(homePage.RawItemActivity_BT) && Base.isElementDisplayed(homePage.RawItemInformation_BT)
				&& Base.isElementDisplayed(homePage.VarianceStat_BT)) {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2053",
					"Verify that Raw Item Activity,Raw Item Information and Daily stat page should display",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2053_Condition4","sprint11_US1204_TC2053",
					"Verify that Raw Item Activity,Raw Item Information and Daily stat page should display",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2052_Condition4");
		}
	}
	
	//TC2054 Verify that the level 6 user can VIEW-ONLY the Raw Item Activity page.
	@Test()
	public void sprint11_US1204_TC2119() throws InterruptedException,
			RowsExceededException, BiffException, WriteException, IOException {
		/** Variable Section : **/
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String wrin = GlobalVariable.rawItemActivityWrin;
		RawItemActivityPage rawItemActivityPage;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to raw item info page
		rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToRawItemActivityPage();
		// Search and select a wrin ID
		rawItemActivityPage.searchAndSelectWRINID(wrin);
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.getItemDetails_Button));
		rawItemActivityPage.getItemDetails_Button.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.DoneWithThisItem_BT));
		if (Base.isElementDisplayed(rawItemActivityPage.DoneWithThisItem_BT)) {
			Reporter.reportPassResult(
					browser,"sprint11_US1204_TC2119",
					"Raw Item activity page should display in non editable mode",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint11_US1204_TC2119","sprint11_US1204_TC2119",
					"Raw Item activity page should display in non editable mode",
					"Fail");
			AbstractTest.takeSnapShot("sprint11_US1204_TC2119");
		}
	}
}
