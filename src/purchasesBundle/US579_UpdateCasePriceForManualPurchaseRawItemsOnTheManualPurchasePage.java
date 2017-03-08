package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractPage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US579_UpdateCasePriceForManualPurchaseRawItemsOnTheManualPurchasePage extends AbstractTest
{
		
	//TC1243 : Verify the user is able to edit case price value for added item in manual purchase screen.
	
	
	@Test(groups={"Smoke"})
	public void purchaseBundle_US579_TC1243() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		AbstractTest.tcName="purchaseBundle_US579_TC1243";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;	
		String pricePerUnit="10";
	/****************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys(pricePerUnit);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		if(manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value").equalsIgnoreCase(pricePerUnit+".0000"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to Price per case value",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to Price per case value",
					"Fail");
			AbstractTest.takeSnapShot();
		}	
	}			
	
	
	//TC1244 : Verify the default case price when a particular WRIN ID is added to manual purchase and also validate the errors while updating case price.
	//Error message can not be automated because not able to track it only validate that wrong value should not be allowed
	@Test()
	public void purchaseBundle_US579_TC1244() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US579_TC1244";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;	
		String wrongPricePerUnit="10.12345";
	/****************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		Thread.sleep(3000);
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys(wrongPricePerUnit);
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		if(manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value").equalsIgnoreCase("10.1234"))
		{
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter Wrong Price per case value",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should not be able to enter Wrong Price per case value",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}	

	}			
	
	@Test()
	public void purchaseBundle_US579_TC1277() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
//		String userId = LoginTestData.supervisorUserId;
		AbstractTest.tcName="purchaseBundle_US579_TC1277";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin1;	
	/****************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(wrin);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		if(!rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		Thread.sleep(3000);
		String expCasePrice=rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value");
		System.out.println("expCasePrice"+expCasePrice);
		//Now go to Purchase landing page
		homePage.Menu_DD_BT.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendorName);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
		AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
		Thread.sleep(3000);
		String actualCasePrice=manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value");
		System.out.println("actualCasePrice"+actualCasePrice);
		if(actualCasePrice.equalsIgnoreCase(expCasePrice))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the defaule value of Case price",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the defaule value of Case price",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys("2");
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		Thread.sleep(2000);
		System.out.println("manualInvoiceNewPage.pricePerCase_TB_List.get(0).getText()"+manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value"));
		if(manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value").equalsIgnoreCase("2.0000"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the case price with correct decimal value",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the case price with correct decimal value",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
		manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys("40.00");
		Thread.sleep(2000);
		manualInvoiceNewPage.Quantity_TB_List.get(0).click();
		manualInvoiceNewPage.Quantity_TB_List.get(0).sendKeys("5");
		Thread.sleep(4000);
		System.out.println("manualInvoiceNewPage.Submit_BT.getAttribute"+manualInvoiceNewPage.Submit_BT.getAttribute("disabled"));
		if(manualInvoiceNewPage.Submit_BT.isEnabled())
		{
			Reporter.reportPassResult(
					browser,
					"User should be allowed to enter valid case price value and submit button should display as enabled",
					"Pass");
		}
		else
		{
			
			Reporter.reportTestFailure(
					browser,
					"User should be allowed to enter valid case price value and submit button should display as enabled",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}			
	
	
	
	//TC1279 : Verify all other manual purchase functionality for the raw item is available to the user.
	
	@Test()
	public void purchaseBundle_US579_TC1279() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="purchaseBundle_US579_TC1279";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;

	/****************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		purchasesPage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		/*// User should be able to view the following button
		1)Cancel
		2)submit
		3)Invoice number edit box
		4)Date selection method.
		5)Vendor selection method.
		6)Item selection method*/
		if(manualInvoiceNewPage.CreateManualInvoice_Vendor_DD.isDisplayed() &&
		manualInvoiceNewPage.CreateManualInvoice_InvoiceNumber_TB.isDisplayed() &&
		manualInvoiceNewPage.CreateManualInvoice_Cancel_BT.isDisplayed() &&
		manualInvoiceNewPage.Submit_BT.isDisplayed() &&
		manualInvoiceNewPage.CreateManualInvoice_EnterRawItemNumberOrDescription_TB.isDisplayed() &&
		Base.isElementDisplayed(By.xpath("//input[@id='disp_date']")))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to View all the options",
					"Pass");
			
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to View all the options",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}	

		
	}			
	
	
	
	//TC3506 : Verify the user is able to edit case price value for added item in manual purchase screen..
	
	
		@Test()
		public void purchaseBundle_US579_TC3506() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US579_TC3506";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;	
			String pricePerUnit="10";
		   /****************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			purchasesPage.CreateManualInvoice_BT.click();
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendorName);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
			AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			Thread.sleep(3000);
			manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
			manualInvoiceNewPage.pricePerCase_TB_List.get(0).sendKeys(pricePerUnit);
			Thread.sleep(2000);
			manualInvoiceNewPage.Quantity_TB_List.get(0).click();
			if(manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value").equalsIgnoreCase(pricePerUnit+".0000"))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to Price per case value",
						"Pass");
				
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to Price per case value",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}	

			
		}			
			
	//TC3588 : Verify the updated case price value while initiating new manual purchase.
		
		@Test()
		public void purchaseBundle_US579_TC3588() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
//			String userId = LoginTestData.supervisorUserId;
			AbstractTest.tcName="purchaseBundle_US579_TC3588";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin;
		
				
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			RawItemActivityPage rawItemActivityPage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
			//Search and select a raw item 
			rawItemActivityPage.searchAndSelectWRINID(wrin);
			Thread.sleep(3000);
			//Click on Information button
			rawItemActivityPage.Information_BT.click();
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
			//fetch the case price Value
			String expectedCasePrice=rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value");
			System.out.println("expectedCasePrice"+expectedCasePrice);
			Thread.sleep(5000);
			//Go to Purchase landing page
			homePage.Menu_DD_BT.click();
			Thread.sleep(3000);
			/*wait.until(ExpectedConditions.visibilityOf(homePage.Menu_Back_BT));
			homePage.Menu_Back_BT.click();*/
			wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
			homePage.Purchases_BT.click();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(10000);
			purchasesPage.CreateManualInvoice_BT.click();
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendorName);		
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
			Thread.sleep(3000);
			String actualCasePrice=manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value");
			System.out.println("actualCasePrice"+actualCasePrice);
			if(expectedCasePrice.equalsIgnoreCase(actualCasePrice))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the same Price per case value",
						"Pass");
				
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the same Price per case value",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}			
		
		
		
		//TC1309 : 	Verify submit button disabled while submitting an added WRIN from manual purchase detail screen without entering any value for $/case.
		@Test()
		public void purchaseBundle_US579_TC1309() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="purchaseBundle_US579_TC1309";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String vendorName=GlobalVariable.vendorName;
			String wrin=GlobalVariable.createPurchaseWrin1;	
		/****************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
			ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
			rawItemActivityPage.searchAndSelectWRINID(wrin);
			Thread.sleep(5000);
			rawItemActivityPage.Information_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
			if(!rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
			{
				rawItemActivityPage.RawItemInformation_popUp_ManualPurchase_CB.click();

			}
			Thread.sleep(3000);
			String expCasePrice=rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value");
			System.out.println("expCasePrice"+expCasePrice);
			//Now go to Purchase landing page
			homePage.Menu_DD_BT.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			Thread.sleep(3000);
			purchasesPage.CreateManualInvoice_BT.click();
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
			// Search and Select the Vendor from the drop down
			manualInvoiceNewPage.selectAVendor(vendorName);
			manualInvoiceNewPage.seacrhAndSelectRawItem(wrin);
			AbstractPage.executor.executeScript("document.getElementById('autocomplete_add_item_btn').click()");
			wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.Quantity_TB_List.get(0)));
			Thread.sleep(3000);
			String actualCasePrice=manualInvoiceNewPage.pricePerCase_TB_List.get(0).getAttribute("value");
			System.out.println("actualCasePrice"+actualCasePrice);
			if(actualCasePrice.equalsIgnoreCase(expCasePrice))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the defaule value of Case price",
						"Pass");
				
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the defaule value of Case price",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			manualInvoiceNewPage.pricePerCase_TB_List.get(0).clear();
			Thread.sleep(2000);
			manualInvoiceNewPage.Quantity_TB_List.get(0).click();
			Thread.sleep(3000);
			if(!manualInvoiceNewPage.Submit_BT.isEnabled())
			{
				Reporter.reportPassResult(
						browser,
						"Submit button Should display as disabled",
						"Pass");
				
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Submit button Should display as disabled",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			
			
		}			
			
	
}
