package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class US952_ShowPerpetualInventoryOnHandForRecipeRawItems extends AbstractTest{
	
	//TC4045 : Verify the expected number of units for the applicable raw item at the applicable times under "On Hand" column.
	@Test()
	public void rawItemActivity_US952_TC4045() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US952_TC4045";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String value1=Integer.toString(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a Physical Inventory
		//Create a Physical inventory
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		//Get the WrinId for the first record
		String wrindID=physicalInventoryPage.DailyInventory_PopUp_WRIN_Value.get(0).getText().trim();
		//Enter the loose Unit value for the first record
		physicalInventoryPage.DailyInventoryPopUp_LooseUnitsQty_TB_List.get(0).sendKeys(value1);
		//Fetch the item total value for the first record
		Thread.sleep(1500);
		String expItemTotal=physicalInventoryPage.DailyInventory_PopUp_ItemTotal_Value.get(0).getText().trim();
		//Submit the Inventory
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(3000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(wrindID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		String uom = wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_UOM_Value)).getText();
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		if(rawItemActivityPage.verifyInventoryOnHandCountMatchedForSelectedDate(createDate,expItemTotal,uom)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the On Hand value with UOM description.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the On Hand value with UOM description.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC4048 : Verify the calculated usage calculation for any WRIN which is a part of any recipe.
	@Test()
	public void rawItemActivity_US952_TC4048() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US952_TC4048";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		String recipeItem = GlobalVariable.recipeRawItem;
		String createDate = GlobalVariable.createDate;
		String value1=Integer.toString(Base.generateNdigitRandomNumber(1));
		String inventoryCount=null;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a Physical Inventory
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		if(Base.isElementDisplayed(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+recipeItem+"')]")
				))
		{
			
			WebElement looseUnitsPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+recipeItem+"')]/../following-sibling::td/eb-validated-input[@class='loose_count_input']/div//div/input"));
			GenericMethods.clearValueOfElement(looseUnitsPack, "looseUnitsPack");
			GenericMethods.enterValueInElement(looseUnitsPack, "looseUnitsPack", value1);
			Thread.sleep(3000);
			 inventoryCount=driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+recipeItem+"')]/../following-sibling::td[5]/span")).getText().trim();

			
		}
		else
		{
			physicalInventoryPage.seacrhAndSelectRawItem(recipeItem);
			Thread.sleep(2000);
			
			WebElement looseUnitsPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+recipeItem+"')]/following-sibling::td/eb-validated-input[@class='loose_count_input']/div//div/input"));
			GenericMethods.clearValueOfElement(looseUnitsPack, "looseUnitsPack");
			GenericMethods.enterValueInElement(looseUnitsPack, "looseUnitsPack", value1);
			Thread.sleep(3000);
			System.out.println("itemm "+"//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+recipeItem+"')]/following-sibling::td[5]/span");
			 inventoryCount=driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+recipeItem+"')]/following-sibling::td[5]/span")).getText().trim();

			
		}
		
		Thread.sleep(2000);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
			
		Thread.sleep(5000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(stratDate).selectEndDate(endDate).searchAndSelectWRINID(recipeItem);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		String uom = wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_UOM_Value)).getText();
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		if(rawItemActivityPage.verifyInventoryOnHandCountMatchedForSelectedDate(createDate,inventoryCount,uom)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the On Hand value as Y  for any WRIN which is a part of any recipe.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the On Hand value as Y  for any WRIN which is a part of any recipe.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	
	//TC4053 : Verify the past date significant events on raw item activity page.
	@Test()//need to complete
	public void rawItemActivity_US952_TC4053() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US952_TC4053";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID=GlobalVariable.rawItem1;
		String stratDate=GlobalVariable.startDate;
		String endDate=GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();;
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		String uom = wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_UOM_Value)).getText();
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
	/*	if(rawItemActivityPage.verifyInventoryOnHandCountMatchedForSelectedDate(inventoryDate,inventoryCount,uom)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the On Hand number for each significant events that happened earlier than the current date",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the On Hand number for each significant events that happened earlier than the current date",
					"Fail");
			AbstractTest.takeSnapShot();
		}*/
	}

}
