package rawItemActivityBundle;

import java.io.IOException;

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
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US811_DisplayPhysicalInventoryCountsOnRawItemActivityPage extends AbstractTest{
	
	//TC1537 : Verify that when a Physical Inventory is submitted, the quantities counted for applicable raw items will show on the Raw Item Activity page for the date="D" selected in "On Hand" column.
	@Test()
	public void rawItemActivity_US811_TC1537() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US811_TC1537";
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
	
	//TC1538 : Verify that a finalized Physical Inventory should  show as a highlighted line on the Raw Item Activity page.
	@Test()
	public void rawItemActivity_US811_TC1538() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US811_TC1538";
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
	
	//TC1539 : Verify, "The user has a method to view the physical inventory details from the Raw Item Activity page".
	@Test()
	public void rawItemActivity_US811_TC1539() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US811_TC1539";
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

}
