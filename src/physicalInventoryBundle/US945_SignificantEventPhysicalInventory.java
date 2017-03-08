package physicalInventoryBundle;

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
import eInventoryPageClasses.RawItemActivityPage;

public class US945_SignificantEventPhysicalInventory extends AbstractTest
{

	//TC2407 : Verify On hand inventory number displayed on the Raw Item Activity page.
	
	@Test()
	public void physicalInventory_US945_TC2407() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US945_TC2407";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
		String inventoryTime=GlobalVariable.time;
		String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
		String date=GlobalVariable.createDate;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		Thread.sleep(2000);
		String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
		System.out.println("time"+time);
		physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
		GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
		//Fetch the Item Total Value
		String amount=driver.findElement(By.xpath("//table[@id='inventory_table']/tbody/tr[2]/td[7]")).getText().replaceAll(",", "");
		System.out.println("amount"+amount);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
		//Go to Raw Item Activity Page
		Thread.sleep(2000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT));
		GenericMethods.clickOnElement(homePage.RawItemActivity_BT, "homePage.RawItemActivity_BT");
//		homePage.ManualVendors_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
		Thread.sleep(1500);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
		//Fetch the onhand value
		String onHandActual=driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span/strong")).getAttribute("innerHTML");
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span");
		System.out.println("onHandActual"+onHandActual);
		int value=onHandActual.length();
		System.out.println("Value "+value);
		System.out.println("onHandActual.contains(amount) "+onHandActual.contains(amount));
		if(value>=0 && onHandActual.contains(amount))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the respective value for 'On Hand'",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the respective value for 'On Hand'",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}


	//TC2408 : Verify the perpetual inventory(On Hand) is getting calculated using the latest physical inventory count until another physical inventory is taken on that raw item..
	
		@Test()
		public void physicalInventory_US945_TC2408() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US945_TC2408";
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
			String inventoryTime=GlobalVariable.time;
			String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
			String date=GlobalVariable.createDate;
			
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
			//Fetch the Item Total Value
			String amount=driver.findElement(By.xpath("//table[@id='inventory_table']/tbody/tr[2]/td[7]")).getText().replaceAll(",", "");
			System.out.println("amount"+amount);
			Thread.sleep(5000);
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
			//Go to Raw Item Activity Page
			Thread.sleep(2000);
			GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT));
			GenericMethods.clickOnElement(homePage.RawItemActivity_BT, "homePage.RawItemActivity_BT");
//			homePage.ManualVendors_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
			Thread.sleep(1500);
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
			//Fetch the onhand value
			String onHandActual=driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span/strong")).getAttribute("innerHTML");
			System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span");
			System.out.println("onHandActual"+onHandActual);
			int value=onHandActual.length();
			if(value>=0 && onHandActual.contains(amount))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the respective value for 'On Hand'",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the respective value for 'On Hand'",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
		}
	
	//TC2410 : Verify the ability of the user to view the calculated on hand history for any of the physical inventory events that were finalized in the past.
	
		@Test()
		public void physicalInventory_US945_TC2410() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_US945_TC2410";
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID1=GlobalVariable.createDailyInventoryWrin2;
			String inventoryTime=GlobalVariable.time;
			String quantity=Integer.toString(Base.generateNdigitRandomNumber(1));
			String date=GlobalVariable.createDate;
			
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			GenericMethods.clickOnElement(physicalInventoryPage.CreateDailyInventory_BT,"CreateDailyInventory_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
			Thread.sleep(2000);
			String time = physicalInventoryPage.getTimeForNewInventory(date, inventoryTime);
			System.out.println("time"+time);
			physicalInventoryPage.selectADateForPhysicalInventory(date).selectTimeForPhysicalInventory(time);
			physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
			GenericMethods.clearValueOfElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.OuterPackQty_TB,"OuterPackQty_TB",quantity);
			//Fetch the Item Total Value
			String amount=driver.findElement(By.xpath("//table[@id='inventory_table']/tbody/tr[2]/td[7]")).getText().replaceAll(",", "");
			System.out.println("amount"+amount);
			Thread.sleep(5000);
			GenericMethods.clickOnElement(physicalInventoryPage.CreateInventoryPopUp_Submit_BT,"CreateInventoryPopUp_Submit_BT");
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.Confirmation_PopUp_YES_BT)),"Confirmation_PopUp_YES_BT");
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySaved_Confirmation_MSG));
			//Go to Raw Item Activity Page
			Thread.sleep(2000);
			GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT));
			GenericMethods.clickOnElement(homePage.RawItemActivity_BT, "homePage.RawItemActivity_BT");
//			homePage.ManualVendors_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
			Thread.sleep(1500);
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
			//Fetch the onhand value
			String onHandActual=driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span/strong")).getAttribute("innerHTML");
			System.out.println("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span[contains(.,'INVENTORY')]/../preceding-sibling::td/span[contains(.,'"+time+"') and contains(.,'"+date+"')  ]/../following-sibling::td[3]/span");
			System.out.println("onHandActual"+onHandActual);
			int value=onHandActual.length();
			if(value>=0 && onHandActual.contains(amount))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the respective value for 'On Hand'",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the respective value for 'On Hand'",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
		}
	
	
	
//TC2428 : Verify  "calculate usage per thousand" on raw item information page.	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
