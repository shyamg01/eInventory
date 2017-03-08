package UserStoriesWithoutBundle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

public class US1371_CurrentBusinessDateValidationAcrossInventory extends AbstractTest {
	
	// TC1846: Verify that the user should be able to view the inner pack field non-editable when the raw item does not have an inner pack.
	@Test()
	public void UserStoriesWithoutBundle_US1371_TC2774() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1371_TC2774";
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date businessDate = dateFormat.parse(createDate);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(businessDate); 
		cal.add(Calendar.DATE, 1);
		Date afterDate = cal.getTime();
		String afterDateValue = dateFormat.format(afterDate);
		System.out.println(afterDateValue);
		if(physicalInventoryPage.verifyDateIsDisabled(afterDateValue)){
			Reporter.reportPassResult(
					browser,
					"user should not be able to select a date after business date while submitting a physical Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should not be able to select a date after business date while submitting a physical Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Calendar cal1 = Calendar.getInstance(); 
		cal1.setTime(businessDate); 
		cal1.add(Calendar.DATE, -1);
		Date beforeDate = cal1.getTime();
		String beforeDateValue = dateFormat.format(beforeDate);
		if(physicalInventoryPage.verifyDateIsDisabled(beforeDateValue)){
			Reporter.reportPassResult(
					browser,
					"user should not be able to select a date before business date while submitting a physical Inventory",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"user should not be able to select a date before business date while submitting a physical Inventory",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.CreateInventoryPopUp_Date_TB.click();
		Thread.sleep(2000);
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

}
