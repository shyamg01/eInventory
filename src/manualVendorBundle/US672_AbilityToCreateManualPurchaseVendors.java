package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import sprint2.AbstractTest;

import common.Base;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;

public class US672_AbilityToCreateManualPurchaseVendors extends AbstractTest {
	
	// Verify the user is able to select "Manual vendors " option from inventory
	// drop down and move to "Manual Vendors" landing page.
	@Test()
	public void manualVendor_US672_TC1212() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to purchase landing page and verify that it is redirected
		ManualVendorsPage manualVendorsPage= homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.navigateToInventoryManagement().goToManualVendorsPage();
		if (Base.isElementDisplayed(manualVendorsPage.ManualVendors_Label)) {
			Reporter.reportPassResult(browser, "manualVendor_US672_TC1212",
					"User should be redirected to Manual Vendor page", "Pass");
		} else {
			Reporter.reportTestFailure(browser, "manualVendor_US672_TC1212",
					"manualVendor_US672_TC1212",
					"User should be redirected to Manual Vendor page", "Fail");
			AbstractTest.takeSnapShot("manualVendor_US672_TC1212");
		}
	}
	
	
	// Verify the user is able to enter vendor name while creating a manual vendor from manual vendors landing page.
	@Test()
	public void manualVendor_US672_TC1213() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
		String newVendorName = "Testauto" + randomNum;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Go to Manual vendors page and click on Add vendor button
		ManualVendorsPage manualVendorPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
		/*wait.until(ExpectedConditions.visibilityOf(manualVendorPage.AddVendor_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorPage.AddvendorDetailsPopUp_VendorName_TB));*/
		// enter the vendor name in vendor name text box
		manualVendorPage.createANewVendor(newVendorName,randomNum);
		// verify the entered text
		if (Base.isElementDisplayed(manualVendorPage.VendorName_Row(newVendorName))) {
			Reporter.reportPassResult(
					browser, "manualVendor_US672_TC1213",
					"User should be able to submit manual vendor", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "manualVendor_US672_TC1213",
					"manualVendor_US672_TC1213","User should be able to submit manual vendor", "Fail");
			AbstractTest.takeSnapShot("manualVendor_US672_TC1213");
		}
	}

	// Verify the impact on manual purchase detail screens once new manual purchase vendor is created.
	@Test()
	public void manualVendor_US672_TC1220() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		String vendorName = null;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		// go to Manual Vendor page and click on Add Vendor button
		ManualVendorsPage manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToManualVendorsPage();
		vendorName = manualVendorsPage.vendorName_List.get(0).getText();
		// Go to purchase landing page and verify that vendor is present or not
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.Menu_OtherInventoryFunction_Back_BT));
		Thread.sleep(2000);
		homePage.Menu_OtherInventoryFunction_Back_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		int vendorNumber = purchasesPage.goToManualInvoiceNewPage().CreateManualInvoice_VendorName_List.size();
		for (int i = 0; i <= vendorNumber; i++) {
			if (manualInvoiceNewPage.CreateManualInvoice_VendorName_List.get(i).getText().equalsIgnoreCase(vendorName)) {
				Reporter.reportPassResult(
						browser, "manualVendor_US672_TC1220",
						"Vendor name should display in vendor name drop down",
						"Pass");
				break;
			} else if (i == vendorNumber) {
				Reporter.reportTestFailure(
						browser,"manualVendor_US672_TC1220","manualVendor_US672_TC1220",
						"Vendor name should display in vendor name drop down",
						"Fail");
				AbstractTest.takeSnapShot("manualVendor_US672_TC1220");
			} else {
				continue;
			}
		}
	}
	
}

