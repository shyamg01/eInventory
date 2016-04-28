package sprint13;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import eInventoryPageClasses.MenuItemInformationPage;

public class US1383_ViewMenuItemInformationHistoricalRecipeInfo extends AbstractTest{
	
	@Test()
	public void sprint13_US1383_TC2184() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		String menuItemId = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		MenuItemInformationPage menuInformationPage = PageFactory.initElements(driver, MenuItemInformationPage.class);
		MenuItemActivityAndInformationPage menuItemActivityPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToMenuItemActivityPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItemId);
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		// Get start date as 5 days earlier date from today date
		cal1.add(Calendar.DATE, -0);
        String fromDate = dateFormat.format(cal1.getTime());
        //Get end date as 1 day earlier date from today date
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -0);
        String toDate = dateFormat.format(cal2.getTime());
       //enter start date 
        menuItemActivityPage.enterDateInMenuItemStartDate(fromDate);
       //enter end date 
        menuItemActivityPage.enterDateInMenuItemEndDate(toDate);
        menuItemActivityPage.ShowResults_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.SelectItem_Value));
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuInformationPage.MenuItemInformation_Title));
		menuInformationPage.Recipe_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(menuInformationPage.HistoricRecipe_BT));
		Base.executeJavaScript("document.getElementById('mia-info-historic-recipe-btn').click()");
		//action.moveToElement(menuItemActivityPage.MenuItemInformationPopUp_HistoricRecipe_BT);
		//menuItemActivityPage.MenuItemInformationPopUp_HistoricRecipe_BT.click();
		if (menuItemActivityPage.verifyHistoricReciopesTableHeaderDIsplayed()) {
			Reporter.reportPassResult(
					browser,"sprint13_US1356_TC2426",
					"User should not be able to view menu item on completed waste page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint13_US1356_TC2426","sprint13_US1356_TC2426",
					"User should not be able to view menu item on completed waste page",
					"Fail");
			AbstractTest.takeSnapShot("sprint13_US1356_TC2426");
		}
	}

}
