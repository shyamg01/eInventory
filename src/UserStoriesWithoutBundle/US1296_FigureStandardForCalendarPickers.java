package UserStoriesWithoutBundle;

import java.io.IOException;
import java.text.ParseException;

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
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemWastePage;
import eInventoryPageClasses.TransferLandingPage;

public class US1296_FigureStandardForCalendarPickers extends AbstractTest {
	
	// TC2200: Verify that the user is able to view the Business Date whenever a calendar date and time is shown in the Inventory system.
	@Test()
	public void UserStoriesWithoutBundle_US1296_TC2200() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1296_TC2200";
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
		wait.until(ExpectedConditions.elementToBeClickable(physicalInventoryPage.CreateDailyInventory_BT)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		if(!physicalInventoryPage.verifyDateIsDisabled(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Business Date in the calendar while submitting a physical Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Business Date in the calendar while submitting a physical Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","15");
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit physical inventory for current business date only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit physical inventory for current business date only",
					"Fail");
			AbstractTest.takeSnapShot();
			}
	}
	
	// TC2200: Verify that the user is able to view the Business Date whenever a calendar date and time is shown in the Inventory system.
	@Test()
	public void UserStoriesWithoutBundle_US1296_TC2201() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1296_TC2201";
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
		if(!physicalInventoryPage.verifyDateIsDisabled(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Business Date in the calendar while submitting a physical Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Business Date in the calendar while submitting a physical Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(inventoryTime);;
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB","15");
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.WeeklyInventorySaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit physical inventory for current business date only",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit physical inventory for current business date only",
					"Fail");
			AbstractTest.takeSnapShot();
			}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1296_TC4396_PromoWaste() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1296_TC4396_PromoWaste";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		if(!rawItemWastePage.verifyDateIsDisabled(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view business date to select for entering raw waste/promo/completed waste",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view business date to select for entering raw waste/promo/completed waste",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1296_TC4396_Purchases() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1296_TC4396_Purchases";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasePage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		if(!manualInvoiceNewPage.verifyDateIsDisabled(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view business date to select for entering manual purchase",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view business date to select for entering manual purchase",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1296_TC4396_Transfers() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1296_TC4396_Transfers";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.Transfer_Title));
		if(!transferLandingPage.verifyDateIsDisabled(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view business date to select for entering transfers",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view business date to select for entering transfers",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
