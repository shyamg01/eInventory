package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.ManualVendorsPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;

public class US1221_SystemShouldPreventDeletingVendorWithPendingInvoices extends AbstractTest {

	// TC1995 : Verify the user is restricted from deleting manual vendors that have already been tied to an existing pending manual invoice.
	@Test()
	public void purchaseBundle_US1221_TC1995() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "purchaseBundle_US1221_TC1995";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName = GlobalVariable.vendorName;
		String wrin = GlobalVariable.createPurchaseWrin;
		String invoiceNumber = Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver,PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		ManualVendorsPage manualVendorsPage = PageFactory.initElements(driver,ManualVendorsPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber,wrin, "2", "3");
		Thread.sleep(5000);
		if (purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber)) {
			Reporter.reportPassResult(
					browser,
					"User shoudl be able to create the manual purchase", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User shoudl be able to create the manual purchase", "Fail");
			AbstractTest.takeSnapShot();
		}
		// Go to Manual Vendor Page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT,"homePage.Menu_DD_BT");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.ManualVendors_BT));
		GenericMethods.clickOnElement(homePage.ManualVendors_BT,"homePage.ManualVendors_BT");
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.ManualVendors_Label));
		Thread.sleep(7000);
		// Click on the edit vendor button
		WebElement vendor = manualVendorsPage.editVendor_BT(vendorName);
		Thread.sleep(4000);
		GenericMethods.clickOnElement(vendor, "vendor");
		// vendor.click();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
		// click on delete button
		wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT));
		GenericMethods.clickOnElement(manualVendorsPage.Delete_BT,"manualVendorsPage.Delete_BT");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dlgContent']/p[contains(.,'Please finalize all invoices for this vendor before deleting')]")));
		if (GenericMethods.isElementDisplayed(By.xpath("//div[@id='dlgContent']/p[contains(.,'Please finalize all invoices for this vendor before deleting')]"),
						"Finalize Invoice For This Vendor validation message should display")) {
			Reporter.reportPassResult(browser,
					"User should not be able to delete the manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(browser,
					"User should not be able to delete the manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC1996 : Verify the user is allowed to delete a manual vendor if it has no existing pending manual purchases tied to it
	@Test()
	public void purchaseBundle_US1221_TC1996() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="purchaseBundle_US1221_TC1996";
				String userId = LoginTestData.userId;
				String password = LoginTestData.password;
				String storeId = LoginTestData.StoreId;
				String wrin=GlobalVariable.wrinIdForNewVendor;
				String vendorName = "Radio" + Base.generateNdigitRandomNumber(4);
				String manualNumber=Integer.toString(Base.generateNdigitRandomNumber(3));	
				String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
				PurchasesPage purchasePage = PageFactory.initElements(driver, PurchasesPage.class);
				ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
				// Navigate to Transfer Landing page and click on create new transfer button
				ManualVendorsPage manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToManualVendorsPage();
				//Create a vendor
				manualVendorsPage.createANewVendor(vendorName, manualNumber);
				Thread.sleep(7000);
				//Go to Raw Item Activity
				homePage.Menu_DD_BT.click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT)).click();
				wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemActivity_Title));
				rawItemActivityPage.searchAndSelectWRINID(wrin);
				rawItemActivityPage.Information_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
				if(!rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
				{
					rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();
				}
				//Click on Cancel button or cross button
				rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.click();
				rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
				rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
				Thread.sleep(3000);
				rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.sendKeys("5");
				Thread.sleep(2000);
				//Select the vendor from the Primary vendor drop down
				rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD.click();
				Select select = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
				select.selectByVisibleText(vendorName);
				rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD.click();
				Select select1 = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
				select1.selectByIndex(2);
				Thread.sleep(5000);
				rawItemActivityPage.RawItemInformation_popUp_Submit_BT.click();	
				wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT));
				rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
				wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
				Thread.sleep(5000);
				//Go to Purchase Landig Page and create a manual Purchase
				homePage.Menu_DD_BT.click();
				wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
				wait.until(ExpectedConditions.visibilityOf(purchasePage.Purchases_Label));
				Thread.sleep(3000);
				manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
				Thread.sleep(8000);
				System.out.println(invoiceNumber);
				Thread.sleep(3000);
				purchasePage.approveAManualInvoice(invoiceNumber);
				Thread.sleep(5000);
				// go to manual vendor bundle
				homePage.Menu_DD_BT.click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(homePage.ManualVendors_BT)).click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Click on the edit vendor button
				WebElement vendor=manualVendorsPage.editVendor_BT(vendorName);
				Thread.sleep(4000);
				vendor.click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)).click();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)).click();;
				//Verify that user should be able to view the confirmation message
				boolean deleteVendorConfirmationDisplayed = Base.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message);
				System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
				Thread.sleep(4000);
				System.out.println("verify vendor deleted"+manualVendorsPage.verifyVendorDeleted(vendorName));
				//verify that operator is able to delete the manual vendor
				if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(vendorName)) {
					Reporter.reportPassResult(
							browser,
							"User should be able to delete the manual purchase vendor.",
							"Pass");
				} else {
					Reporter.reportTestFailure(
							browser,
							"User should be able to delete the manual purchase vendor.",
							"Fail");
					AbstractTest.takeSnapShot();
				}
			}
}
