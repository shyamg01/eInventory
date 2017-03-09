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
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
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
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		
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
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
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
		String wrin_01_old_actualValue;
		if(Base.isElementDisplayed(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]"))){
			wrin_01_old_actualValue = GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin01+"')]/../td[4]")), "First Recepie Actual Uses");
		}else{
			wrin_01_old_actualValue = "0.00";
		}
		String wrin_02_old_actualValue;
		if(Base.isElementDisplayed(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]"))){
			wrin_02_old_actualValue = GenericMethods.getText(driver.findElement(By.xpath("//tbody[@id='monthly_inv_table_body']/tr/td[contains(.,'"+wrin02+"')]/../td[4]")), "Second Recepie Actual Uses");
		}else{
			wrin_02_old_actualValue = "0.00";
		}
		System.out.println("wrin_01_old_actualValue"+wrin_01_old_actualValue);
		System.out.println("wrin_02_old_actualValue"+wrin_02_old_actualValue);
		//Go to the Physical Inventory Page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT)), "homePage.PhysicalInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.PhysicalInventoryPage_Title));
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(wrin01, quantity, quantity, quantity);
		physicalInventoryPage.verifyAndAddWrinInTable(wrin02, quantity, quantity, quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
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
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String createDate=GlobalVariable.createDate;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String wrin01=GlobalVariable.createDailyInventoryWrin1;		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		VarianceStatPage varianceStatPage = new VarianceStatPage(driver);
		physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(wrin01, quantity, quantity, quantity);
		String inventoryTime = Base.getCurrentTimeForStore(storeId);
		String itemTotal = physicalInventoryPage.getItemTotalForAWrin(wrin01);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(2000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		GenericMethods.clickOnElement(homePage.VarianceStat_BT, "homePage.VarianceStat_BT");
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		//click on View Activity button for the WRIN ID
		varianceStatPage.clickOnViewActivityButtonForWRIN(wrin01);
		Thread.sleep(1500);
		//Verify that record for the physical inventory is Present
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span/strong[contains(.,'"+createDate+"') and contains(.,'"+inventoryTime+"')]/../../../td[2]/span/strong[contains(.,'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+itemTotal+"')]");
		if(GenericMethods.isElementDisplayed(driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[1]/span/strong[contains(.,'"+createDate+"') and contains(.,'"+inventoryTime+"')]/../../../td[2]/span/strong[contains(.,'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+itemTotal+"')]")), "Created Physical Inventory"))
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
		String password =  LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
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
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(wrin01, quantity, quantity, quantity);
		physicalInventoryPage.verifyAndAddWrinInTable(wrin02, quantity, quantity, quantity);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(2000);
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
