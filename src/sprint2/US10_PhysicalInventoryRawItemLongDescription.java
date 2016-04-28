package sprint2;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import common.GlobalVariable;
import common.ReadTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;

public class US10_PhysicalInventoryRawItemLongDescription extends AbstractTest {
	
	// TC1971: Verify that the user is able to view long description corresponding to the WRIN number for the correct Raw Item.
	@Test()
	public void sprint2_US10_TC1971() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PhysicalInventoryPage physicalInventoryPage;
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		HSSFSheet physicalInventoryPageSheet = ReadTestData.getTestDataSheet("sprint2_US10_TC1971", "Object1");
		String wrinId = ReadTestData.getTestData(physicalInventoryPageSheet, "WRINId");
		String description = ReadTestData.getTestData(physicalInventoryPageSheet, "Description");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page >> Save a physical inventory
		physicalInventoryPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		wait.until(ExpectedConditions.elementToBeClickable(physicalInventoryPage.CreateWeeklyInventory_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		if (physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(wrinId, description)) {
			Reporter.reportPassResult(
					browser,"sprint2_US10_TC1971",
					"User should be able to view long description=x corresponding to the WRIN number=y for the correct Raw Item.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint2_US10_TC1971","sprint2_US10_TC1971",
					"User should be able to view long description=x corresponding to the WRIN number=y for the correct Raw Item.",
					"Fail");
			AbstractTest.takeSnapShot("sprint2_US10_TC1971");
		}
	}
	
	// TC1973: Verify that the user is able to view the description with mixed case.
	@Test()
	public void sprint2_US10_TC1973() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PhysicalInventoryPage physicalInventoryPage;
		String storeId = GlobalVariable.StoreId;
		String userId = GlobalVariable.userId;
		HSSFSheet physicalInventoryPageSheet = ReadTestData.getTestDataSheet("sprint2_US10_TC1973", "Object1");
		String wrinId = ReadTestData.getTestData(physicalInventoryPageSheet,"WRINId");
		String description = ReadTestData.getTestData(physicalInventoryPageSheet, "Description");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to physical inventory Page >> Save a physical inventory
		physicalInventoryPage = homePage.selectUser(userId).selectLocation(storeId)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		wait.until(ExpectedConditions.elementToBeClickable(physicalInventoryPage.CreateWeeklyInventory_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.WeeklyInventoryList_Title));
		physicalInventoryPage.Search_BT.click();
		physicalInventoryPage.Search_BT.sendKeys(wrinId);
		if (physicalInventoryPage.verifyWrinNumberAndDescriptionIsDisplayedForARawItem(wrinId,description)) {
			Reporter.reportPassResult(
					browser,"sprint2_US10_TC1973",
					"User should be able to view the description with mixed case",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"sprint2_US10_TC1973","sprint2_US10_TC1973",
					"User should be able to view the description with mixed case",
					"Fail");
			AbstractTest.takeSnapShot("sprint2_US10_TC1973");

		}
	}

}
