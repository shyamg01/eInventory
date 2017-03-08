package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
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
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;

public class US179_PostAManualPurchase extends AbstractTest
{
	
	//TC452 : Verify that User is able to view the "Approve" Button on Manual Purchase Detail Screen.
	@Test()
	public void purchaseBundle_US179_TC452() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US179_TC452";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(8000);
		System.out.println(invoiceNumber);
		Thread.sleep(9000);
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		/*Thread.sleep(4000);
		purchasesPage.selectDateForApproveInvoice(date);*/
		Thread.sleep(4000);
		if(GenericMethods.isElementDisplayed(purchasesPage.ApproveManualInvoice_Approve_BT, "purchasesPage.ApproveManualInvoice_Approve_BT"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the approve button against the invoice",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the approve button against the invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		
	}			
		
//TC453 : Verify that User is able to post the pending manual invoice  with success message "Your invoice has been approved."
	
	@Test(groups="Smoke")
	public void purchaseBundle_US179_TC453() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US179_TC453";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(3000);
		if(!purchasesPage.verifyPendindInvoiceIsPresent(invoiceNumber))
		{
			Reporter.reportPassResult(
					browser,
					"Invoice should be Approved successfully",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Invoice should be Approved successfully",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		
	}			
		
//TC3531 : Verify that once a manual invoice is approved, it is locked from editing.	
	
	@Test()
	public void purchaseBundle_US179_TC3531() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US179_TC3531";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String startDate=GlobalVariable.startDate;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(5000);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(5000);
		purchasesPage.viewApprovedInvoiceOnViewHistory(invoiceNumber,startDate);
		if(Base.isElementDisplayed(purchasesPage.ViewInvoice_PopUp_Label))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Invoice on View History page",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Invoice on View History page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
			
	}		
	
//TC3533 : 	Verify that a user is able to designate a Raw Item as a "manual purchase" item.
	
	@Test()
	public void purchaseBundle_US179_TC3533() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US179_TC3533";
//		String userId = LoginTestData.supervisorUserId;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.rawItemActivityWrin;
	
			
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		RawItemActivityPage rawItemActivityPage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		//Search and select a raw item 
		rawItemActivityPage.searchAndSelectWRINID(wrin);
		Thread.sleep(3000);
		//Click on Information button
		GenericMethods.clickOnElement(rawItemActivityPage.Information_BT, "rawItemActivityPage.Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		//click on Manual Purchase check box
		Thread.sleep(2000);
		if(rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			//Do nothing
		}
		else
		{
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		Thread.sleep(2000);
		//Select the vendor from the Primary vendor drop down
		GenericMethods.clickOnElement(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD, "rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD");
		Select select = new Select(rawItemActivityPage.RawItemInformation_popUp_PrimaryVendor_DD);
		select.selectByVisibleText(vendorName);
		GenericMethods.clickOnElement(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD, "rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD");
		Select select1 = new Select(rawItemActivityPage.RawItemInformation_popUp_GLAccount_DD);
		select1.selectByIndex(2);
		Thread.sleep(5000);
		GenericMethods.clickOnElement(rawItemActivityPage.RawItemInformation_popUp_Submit_BT, "rawItemActivityPage.RawItemInformation_popUp_Submit_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		GenericMethods.clickOnElement(rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT, "rawItemActivityPage.RawItemInformation_ConfirmationPopUp_Yes_BT");
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
		Thread.sleep(5000);
		//Go to Purchase landing page
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		Thread.sleep(2000);
		/*wait.until(ExpectedConditions.visibilityOf(homePage.Menu_Back_BT));
		homePage.Menu_Back_BT.click();*/
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
		GenericMethods.clickOnElement(homePage.Purchases_BT, "homePage.Purchases_BT");
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(10000);
		GenericMethods.clickOnElement(purchasesPage.CreateManualInvoice_BT, "purchasesPage.CreateManualInvoice_BT");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);		
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		Thread.sleep(3000);
		if(Base.isElementDisplayed(By.xpath("//table[@id='invoice_tbl']/tbody/tr/td[3]")))
		{
			if(driver.findElement(By.xpath("//table[@id='invoice_tbl']/tbody/tr/td[3]")).getText().contains(wrin))
			{
			Reporter.reportPassResult(
					browser,
					"User should be able to search the Wrin on create new invoice page",
					"Pass");
			
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to search the Wrin on create new invoice page",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Wrin id should be selected successfully",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
			
	}			
	
}
