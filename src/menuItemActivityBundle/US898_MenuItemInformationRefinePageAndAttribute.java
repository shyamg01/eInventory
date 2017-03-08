package menuItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;



import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;

public class US898_MenuItemInformationRefinePageAndAttribute extends AbstractTest{
	
	//TC1535: Verify that user is not able to view "Yield Item" field on the Menu Item Information page.
	@Test()
	public void menuItemActivity_US898_TC1535() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="menuItemActivity_US898_TC1535";
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String menuItem = GlobalVariable.menuItem;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		if(menuItemActivityPage.SelectItem_Value.getText().contains(menuItem)){
			Reporter.reportPassResult(
					browser,
					"Verify that user is able to select Raw Item Activity from Inventory drop-down list.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify that user is able to select Raw Item Activity from Inventory drop-down list.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_MenuItemNumberHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DescriptionHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_OnPOSHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DaypartCodeHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_FamilyGroupHeader)){
			Reporter.reportPassResult(
					browser,
					"User should be able to see  1.) Menu Item Number 2.) Description 3.) On POS 4.)Day Part Code 5.)Family Group fields in menu item information pop up",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see  1.) Menu Item Number 2.) Description 3.) On POS 4.)Day Part Code 5.)Family Group fields in menu item information pop up",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeEffectiveDate_Value)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_HistoricReceipe_Expand_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to see collapsed Section containing down arrow sign with: Title Recipe with effective date and Historic Recipe ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to see collapsed Section containing down arrow sign with: Title Recipe with effective date and Historic Recipe ",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
