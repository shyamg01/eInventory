package varianceStatBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
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
import eInventoryPageClasses.VarianceStatPage;

public class US1190_SelectAndViewStatVarianceForAMonth extends AbstractTest
{
	
	//TC2705 : Verify a method to view a Monthly Variance Stat page is available to the user.
	
	@Test
	public void varianceStatBundle_US1190_TC2705() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1190_TC2705";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Monthly");
		Thread.sleep(3000);
		if(varianceStatPage.MonthlyStatRecords_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the monthly details for selected Month",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the monthly details for selected Month",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2706 : Verify that user is able to select month on Variance stat page.
	
	
	@Test
	public void varianceStatBundle_US1190_TC2706() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1190_TC2706";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		try
		{
		varianceStatPage.selectVarianceStatType("Monthly");
		Reporter.reportPassResult(
				browser,
				"User should be able to view the monthly details for selected Month",
				"Pass");
		} catch (Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the monthly details for selected Month",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	//TC2707 : Verify that each Raw Item that was counted during the month on a submitted Physical inventory, is shown as a new line on the Monthly Stat Variance page.
	
	@Test
	public void varianceStatBundle_US1190_TC2707() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1190_TC2707";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate=GlobalVariable.createDate;
		String inventoryTime =GlobalVariable.time;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.wrinID_01_recepie;
		String wrin02=GlobalVariable.wrinID_02_recepie;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Monthly");
		Thread.sleep(3000);
		//Fetch the Actual Uses for the first recepie Item
		String wrin_01_old_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]")), "First Recepie Actual Uses");
		String wrin_02_old_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]")), "Second Recepie Actual Uses");
		System.out.println("wrin_01_old_actualValue"+wrin_01_old_actualValue);
		System.out.println("wrin_02_old_actualValue"+wrin_02_old_actualValue);
		//Go to the Physical Inventory Page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT)), "homePage.PhysicalInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.PhysicalInventoryPage_Title));
		Thread.sleep(2000);
		String time = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time"+time);
		//create a physical Inventory for WRIN_01
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(wrin01);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		Thread.sleep(4000);
		String time1 = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time"+time1);
		driver.navigate().refresh();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time1);
		physicalInventoryPage.searchRawItemInInventoryList(wrin02);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		Thread.sleep(2000);
		//Go to state variant page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT)), "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		Thread.sleep(1500);
		varianceStatPage.selectVarianceStatType("Monthly");
		Thread.sleep(3000);
		//Fetch the new Actual Uses for the first recepie Item
		String wrin_01_new_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]")), "First Recepie Actual Uses");
		String wrin_02_new_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]")), "Second Recepie Actual Uses");
		System.out.println("wrin_01_new_actualValue"+wrin_01_new_actualValue);
		System.out.println("wrin_02_new_actualValue"+wrin_02_new_actualValue);
		if((!wrin_01_old_actualValue.equalsIgnoreCase(wrin_01_new_actualValue)) && (!wrin_02_old_actualValue.equalsIgnoreCase(wrin_02_new_actualValue)))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the raw item  K and L submitted through physical inventory .",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the raw item  K and L submitted through physical inventory .",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	//TC2728 : Verify the system is  calculating  the values for the final time period,encompassing the time of the last Physical Inventory on the item and the Month End Physical Inventory on the item.
	
	
	@Test
	public void varianceStatBundle_US1190_TC2728() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1190_TC2728";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate=GlobalVariable.createDate;
		String inventoryTime =GlobalVariable.time;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.createDailyInventoryWrin1;		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = new VarianceStatPage(driver);
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a daily Inventory
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(2000);
		String time = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time"+time);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(wrin01);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		//Fetch the Item Total Value
		String amount=driver.findElement(By.xpath("//table[@id='inventory_table']/tbody/tr[2]/td[7]")).getText();
		System.out.println("amount"+amount);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		//Go to Raw Item Activity Page
		Thread.sleep(2000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		GenericMethods.clickOnElement(homePage.VarianceStat_BT, "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		
		//click on View Activity button for the WRIN ID
		varianceStatPage.clickOnViewActivityButtonForWRIN(wrin01);
		Thread.sleep(1500);
		//click on Arrow button for the create date records
		String day=Integer.toString(Base.getDayFromDate(createDate));
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[1]/th[1][contains(.,'"+day+"')]/span")), "Arrow for the current date");
		//Verify that record for the physical inventory is Present
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span/strong[contains(.,'"+createDate+"') and contains(.,'"+time+"')]/../../../td[2]/span/strong[contains(.,'INVENTORY')]/../../../td[4]/span/strong[contains(.,'"+amount+"')]");
		if(GenericMethods.isElementDisplayed(driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span/strong[contains(.,'"+createDate+"') and contains(.,'"+time+"')]/../../../td[2]/span/strong[contains(.,'INVENTORY')]/../../../td[4]/span/strong[contains(.,'"+amount+"')]")), "Created Physical Inventory"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able top view the time of last submitted physical inventory.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	
	
	//TC2731 : Verify that all the raw items that were counted on the Monthly list will display when viewing a monthly Stat Variance.
	
	@Test
	public void varianceStatBundle_US1190_TC2731() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US1190_TC2731";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String createDate=GlobalVariable.createDate;
		String inventoryTime =GlobalVariable.time;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.wrinID_01_recepie;
		String wrin02=GlobalVariable.wrinID_02_recepie;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Monthly");
		Thread.sleep(3000);
		//Fetch the Actual Uses for the first recepie Item
		String wrin_01_old_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]")), "First Recepie Actual Uses");
		String wrin_02_old_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]")), "Second Recepie Actual Uses");
		System.out.println("wrin_01_old_actualValue"+wrin_01_old_actualValue);
		System.out.println("wrin_02_old_actualValue"+wrin_02_old_actualValue);
		//Go to the Physical Inventory Page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT)), "homePage.PhysicalInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.PhysicalInventoryPage_Title));
		Thread.sleep(2000);
		String time = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time"+time);
		//create a physical Inventory for WRIN_01
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(wrin01);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		Thread.sleep(4000);
		String time1 = physicalInventoryPage.getTimeForNewInventory(createDate, inventoryTime);
		System.out.println("time"+time1);
		driver.navigate().refresh();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(3000);
		physicalInventoryPage.selectADateForPhysicalInventory(createDate).selectTimeForPhysicalInventory(time1);
		physicalInventoryPage.searchRawItemInInventoryList(wrin02);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		Thread.sleep(2000);
		//Go to state variant page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT)), "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		Thread.sleep(1500);
		varianceStatPage.selectVarianceStatType("Monthly");
		Thread.sleep(3000);
		//Fetch the new Actual Uses for the first recepie Item
		String wrin_01_new_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]")), "First Recepie Actual Uses");
		String wrin_02_new_actualValue=GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]")), "Second Recepie Actual Uses");
		System.out.println("wrin_01_new_actualValue"+wrin_01_new_actualValue);
		System.out.println("wrin_02_new_actualValue"+wrin_02_new_actualValue);
		if((!wrin_01_old_actualValue.equalsIgnoreCase(wrin_01_new_actualValue)) && (!wrin_02_old_actualValue.equalsIgnoreCase(wrin_02_new_actualValue)))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the raw items: 1.I1 and I2 entry",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the raw items: 1.I1 and I2 entry",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
