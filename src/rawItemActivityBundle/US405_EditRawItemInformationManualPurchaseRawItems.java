package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US405_EditRawItemInformationManualPurchaseRawItems extends AbstractTest
{
	
	//TC1210 : Verify the designation of raw item present in "Raw Item Information" page as a manual purchase
	@Test(groups="Smoke")
	public void rawItemActivityBundle_US405_TC1210() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC1210";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String vendor=GlobalVariable.vendorName;
		String casePrice="5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasepage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		
		if (!Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB)
				& !Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD)
				& !Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD)) {
			Reporter.reportPassResult(
					browser,
					"Below fields should be disabled before clicking on Manual Purchase check box: Case Price List Type McDonalds GL Account Primary Vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Below fields should be disabled before clicking on Manual Purchase check box: Case Price List Type McDonalds GL Account Primary Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();
		}
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD)) {
			Reporter.reportPassResult(
					browser,
					"Below fields should be enabled after clicking  on Manual Purchase check box: Case Price List Type McDonalds GL Account Primary Vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Below fields should be enabled after clicking on Manual Purchase check box: Case Price List Type McDonalds GL Account Primary Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		Thread.sleep(5000);
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		select.selectByVisibleText("Monthly");
		Thread.sleep(1000);
		//Select McDonalds GL Account from "McDonalds GL Account drop down"
		rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD.click();
		Select select1 =new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		select1.selectByIndex(1);
		Thread.sleep(1000);
		//Select "XYZ" from primary vendor drop down
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Select select2 =new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		select2.selectByVisibleText(vendor);
		Thread.sleep(1000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_SubmitChanges_ConfirmationMessage)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to View the pop-up message Are you sure you want to submit these changes? with two options yes and no",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to View the pop-up message Are you sure you want to submit these changes? with two options yes and no",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		Thread.sleep(3000);
		//Go to Purchase landing Page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(purchasepage.Purchases_Label)).click();
		purchasepage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		try
		{
			manualInvoiceNewPage.seacrhAndSelectRawItem(samplewRINID);
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the WRIN id with the specified Vendor",
					"Pass");

		} catch (Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the WRIN id with the specified Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
		
	}	
	
	
	// TC1249 : Validate the error while entering values for editable fields, once the user has designated a raw item as manual purchase on raw item information page.
	@Test()
	public void rawItemActivityBundle_US405_TC1249() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC1249";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String vendor=GlobalVariable.vendorName;
		String inValidcasePrice="144.44444";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		Thread.sleep(5000);
	
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		select.selectByVisibleText("Monthly");
		//Select McDonalds GL Account from "McDonalds GL Account drop down"
		rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD.click();
		Select select1 =new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		select1.selectByIndex(1);
		//Select "XYZ" from primary vendor drop down
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Select select2 =new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		select2.selectByVisibleText(vendor);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(inValidcasePrice);
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_CasePrice_Error_MSG))
		{
			Reporter.reportPassResult(
					browser,
					"Error message should display for invalid case price value",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Error message should display for invalid case price value",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		
	}	
	
	//TC1250 : Verify that option "UOM/Sleeve" and "Inner Pack Description" on "Raw Item Information" page is hidden for those items which does not have inner pack.
	
	
	@Test()
	public void rawItemActivityBundle_US405_TC1250() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC1250";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemInformationWrinWithoutInnerPackDescription;	
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		//Get the inner pack value
		System.out.println("text is "+driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[6]")).getText());
		if(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[6]")).getText().equalsIgnoreCase(""))
		{
			Reporter.reportPassResult(
					browser,
					"Inner pack value should not display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Inner pack value should not display",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		
	}	
	
	//TC1251 : Verify the impact on manual purchase page once the raw item is designated as a manual purchase from "Raw Item Information" page against a particular manual vendor.
	@Test()
	public void rawItemActivityBundle_US405_TC1251() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC1251";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String vendor=GlobalVariable.vendorName;
		String casePrice="7";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasepage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		Thread.sleep(5000);
		Select select =new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		select.selectByVisibleText("Monthly");
		//Select McDonalds GL Account from "McDonalds GL Account drop down"
		rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD.click();
		Select select1 =new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		select1.selectByIndex(1);
		//Select "XYZ" from primary vendor drop down
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Select select2 =new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		select2.selectByVisibleText(vendor);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		Thread.sleep(3000);
		//Go to Purchase landing Page
		homePage.goToPurchaseLandingPage();
		purchasepage.CreateManualInvoice_BT.click();
		wait.until(ExpectedConditions.visibilityOf(manualInvoiceNewPage.CreateManualInvoice_PopUp_Lable));
		// Search and Select the Vendor from the drop down
		manualInvoiceNewPage.selectAVendor(vendor);
		try
		{
			manualInvoiceNewPage.seacrhAndSelectRawItem(samplewRINID);
			Reporter.reportPassResult(
					browser,
					"User should be able to search and select the WRIN id with the specified Vendor",
					"Pass");

		} catch (Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to search and select the WRIN id with the specified Vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}	
	
	
	//TC1314 : Verify the case price of WRIN ID is changed on Raw Item Information page, once it is updated from manual purchase detail screen.
	
	@Test()
	public void rawItemActivityBundle_US405_TC1314() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC1314";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String vendorName=GlobalVariable.vendorName;
		String date=GlobalVariable.createDate;
		String casePrice="12";
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		RawItemActivityPage rawItemActivityPage = PageFactory.initElements(driver, RawItemActivityPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, samplewRINID,"2",casePrice);
		Thread.sleep(8000);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(5000);
		//Go to Raw Item Activity Page
		homePage.goToRawItemActivityPage();
		//Click on Information button
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
	
		String actualCashPrice=rawItemActivityPage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value");
		Thread.sleep(2000);
		if(actualCashPrice.equalsIgnoreCase(casePrice+".0000"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the updated case price",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the updated case price",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}	
	
	
	//TC3719 : Verify that the user is able to view read only information of wrin, description, category, zone, case,UOM/Sleeve (if applicable), Inner Pack Description (if applicable).
	
	@Test()
	public void rawItemActivityBundle_US405_TC3719() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC3719";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		//View read only information of wrin, description, category, zone, case,UOM/Sleeve (if applicable), Inner Pack Description (if applicable).
		if(driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[1]")).getText().length()>0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[2]")).getText().length()>0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[3]")).getText().length()>0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[4]")).getText().length()>0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[5]")).getText().length()>=0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[6]")).getText().length()>=0 &&
				driver.findElement(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[7]")).getText().length()>0)
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view View read only information of wrin, description, category, zone, case,UOM/Sleeve (if applicable), Inner Pack Description (if applicable).",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view View read only information of wrin, description, category, zone, case,UOM/Sleeve (if applicable), Inner Pack Description (if applicable).",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}	
	
	//TC4395 : Verify that user is able to change the manual vendor from X to Y on raw item information modal for wrin=abc
	@Test()
	public void rawItemActivityBundle_US405_TC4395() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC4395";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String casePrice=String.valueOf(Base.generateNdigitRandomNumber(2));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB, "RawItemInformation_popUp_ManualPurchase_CB");
		}
		//Click on Cancel button or cross button
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB,"RawItemInformation_popUp_ManualPurchase_CB");
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		GenericMethods.enterValueInElement(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB,"RawItemInformation_popUp_CasePrice_TB",casePrice);
		Select listDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD, "listDropDown", 2);
		String selectedList = listDropDown.getFirstSelectedOption().getText();
		//listDropDown.selectByIndex(2);
		Select glAccountDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD,"glAccountDropDown",2);
		String selectedglAccount = glAccountDropDown.getFirstSelectedOption().getText();
		//glAccountDropDown.selectByIndex(2);
		Select vendorDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD,"vendorDropDown",2);
		String selectedVendor = vendorDropDown.getFirstSelectedOption().getText();
		//vendorDropDown.selectByIndex(2);
		rawitemactivitypage.RawItemInformation_Title.click();
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_Submit_BT,"RawItemInformation_popUp_Submit_BT");
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_SubmitChanges_ConfirmationMessage)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to View the pop-up message Are you sure you want to submit these changes?\" with two options \"yes\" and \"no\"",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to View the pop-up message Are you sure you want to submit these changes?\" with two options \"yes\" and \"no\"",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT)),"RawItemInformation_ConfirmationPopUp_No_BT");
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_Submit_BT,"RawItemInformation_popUp_Submit_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT)),"RawItemInformation_ConfirmationPopUp_Yes_BT");
		//Click on Information button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.Information_BT)), "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
			if (rawitemactivitypage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
					& rawitemactivitypage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
					& rawitemactivitypage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
					& rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)) {
				Reporter.reportPassResult(browser,
						"User should be able to save raw item information on clicking submit button",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should be able to save raw item information on clicking submit button",
						"Fail");
				AbstractTest.takeSnapShot();
			}
	}

	//TC3847 : Verify the method to cancel/close the Raw Item Information available to the user.
	@Test()
	public void rawItemActivityBundle_US405_TC3847() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US405_TC3847";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String casePrice="14";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();		
		Thread.sleep(5000);
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		//Click on Information button
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		boolean flag = true;
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			flag = false;
			GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB, "RawItemInformation_popUp_ManualPurchase_CB");
		}
		//Click on Cancel button or cross button
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB,"RawItemInformation_popUp_ManualPurchase_CB");
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		GenericMethods.enterValueInElement(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB,"RawItemInformation_popUp_CasePrice_TB",casePrice);
		Select listDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		String selectedList = listDropDown.getFirstSelectedOption().getText();
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD, "listDropDown", 2);
		//listDropDown.selectByIndex(2);
		Select glAccountDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD);
		String selectedglAccount = glAccountDropDown.getFirstSelectedOption().getText();
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD,"glAccountDropDown",2);
		//glAccountDropDown.selectByIndex(2);
		Select vendorDropDown = new Select(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD);
		String selectedVendor = vendorDropDown.getFirstSelectedOption().getText();
		GenericMethods.selectIndexFormDropDownElement(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD,"vendorDropDown",2);
		//vendorDropDown.selectByIndex(2);
		rawitemactivitypage.RawItemInformation_Title.click();
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_Cancel_BT,"RawItemInformation_popUp_Cancel_BT");
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_CancelChanges_Warning_MSG)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to View the pop-up message All entered information will be lost. Are you sure you want to cancel?\" with two options \"yes\" and \"no\"",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to View the pop-up message All entered information will be lost. Are you sure you want to cancel?\" with two options \"yes\" and \"no\"",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT)),"RawItemInformation_ConfirmationPopUp_No_BT");
		GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_Cancel_BT,"RawItemInformation_popUp_Cancel_BT");
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT)),"RawItemInformation_ConfirmationPopUp_Yes_BT");
		//Click on Information button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.Information_BT)), "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if (!flag) {
			if (!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected()) {
				Reporter.reportPassResult(browser,
						"User should not be able to save raw item information on clicking cancel button",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should not be able to save raw item information on clicking cancel button",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		} else {
			if (rawitemactivitypage.getSelectedOptionFromDropDown(listDropDown).equals(selectedList)
					& rawitemactivitypage.getSelectedOptionFromDropDown(glAccountDropDown).equals(selectedglAccount)
					& rawitemactivitypage.getSelectedOptionFromDropDown(vendorDropDown).equals(selectedVendor)
					& !rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").contains(casePrice)) {
				Reporter.reportPassResult(browser,
						"User should not be able to save raw item information on clicking cancel button",
						"Pass");
			} else {
				Reporter.reportTestFailure(browser,
						"User should not be able to save raw item information on clicking cancel button",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}
}
