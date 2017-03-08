package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US12_RuleRawItemsThatMayNotHaveOneOrMoreOfOuterPackInnerPackOrLooseUnit extends AbstractTest{
	
	// TC1846: Verify that the user should be able to view the inner pack field non-editable when the raw item does not have an inner pack.
	@Test()
	public void physicalInventory_US12_TC1846() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US12_TC1846";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrinWithoutInnerPack;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		wait.until(ExpectedConditions.elementToBeClickable(physicalInventoryPage.CreateDailyInventory_BT)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryList_Title));
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		//Verify that user is not able to edit inner pack quantity  for the wrin ID
		if (!Base.isElementDisplayed(physicalInventoryPage.InnerPackCountQty_TB)) {
			Reporter.reportPassResult(
					browser,
					"User should not be able to view text field under Inner Pack column, as raw item X does not have Inner pack.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to view text field under Inner Pack column, as raw item X does not have Inner pack.",
					"Fail");
			AbstractTest.takeSnapShot();

		}
	}

}
