
package rawItemActivityBundle;
import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;

public class US279_ViewAndEditRawItemInformation extends AbstractTest
{
	
	//TC769 : Verify that user is able to change the List Type for any searched WRIN ID on raw item information page.
	@Test()
	public void rawItemActivityBundle_US279_TC769() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US279_TC769";
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
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		rawitemactivitypage.RawItemInformation_popUp_Frequency_DD.click();
		Thread.sleep(2000);
		Select select = new Select(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD);
		try{
		select.selectByIndex(0);
		Thread.sleep(2000);
		Reporter.reportPassResult(
				browser,
				"User should be able to select the list type value",
				"Pass");
		}
		catch (Exception e)
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to select the list type value",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}	
	
	//TC3850 : Verify that user is able to save the changes on Raw Item Information page..	
	@Test()
	public void rawItemActivityBundle_US279_TC3850() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US279_TC3850";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String casePrice="8";
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
		//Click on Cancel button or cross button
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Thread.sleep(2000);
		//Click on Submit button
		rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_Title))
		{
			Reporter.reportPassResult(
					browser,
					"Popup screen should get closed and user should be in Information page",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"Popup screen should get closed and user should be in Information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}

		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Thread.sleep(2000);
		//Click on Submit button
		rawitemactivitypage.RawItemInformation_popUp_Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_popUp_ChangesSaved_Confirmation_MSG));
		Thread.sleep(2000);
		rawitemactivitypage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected())
		{
			rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.click();

		}
		if(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.getAttribute("value").equalsIgnoreCase(casePrice+".0000"))
		{
			Reporter.reportPassResult(
					browser,
					"Information page should open with the updated value",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"Information page should open with the updated value",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}	
	
	//TC3851 : Verify that user is able to cancel the changes done on Raw Item Information page.
	@Test()
	public void rawItemActivityBundle_US279_TC3851() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US279_TC3851";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		String casePrice="8";
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
		//Click on Cancel button or cross button
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Thread.sleep(2000);
		//Click on Submit button
		rawitemactivitypage.RawItemInformation_popUp_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_No_BT.click();
		Thread.sleep(2000);
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_Title))
		{
			Reporter.reportPassResult(
					browser,
					"Popup screen should get closed and user should be in Information page",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"Popup screen should get closed and user should be in Information page",
					"Fail");
			AbstractTest.takeSnapShot();
		}

		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.click();
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB.sendKeys(casePrice);
		Thread.sleep(2000);
		rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD.click();
		Thread.sleep(2000);
		//Click on Submit button
		rawitemactivitypage.RawItemInformation_popUp_Cancel_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT));
		rawitemactivitypage.RawItemInformation_ConfirmationPopUp_Yes_BT.click();
		Thread.sleep(4000);
		if(!Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_Title))
		{
			Reporter.reportPassResult(
					browser,
					"Information page should open with the updated value",
					"Pass");

		} else
		{
			Reporter.reportTestFailure(
					browser,
					"Information page should open with the updated value",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	//TC768 : Verify that user is able to search a raw item in raw item activity page.
	@Test()
	public void rawItemActivityBundle_US279_TC768() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivityBundle_US279_TC768";
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
		GenericMethods.clickOnElement(rawitemactivitypage.Information_BT, "Information_BT");
		wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemInformation_Title));
		if(Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__WRINHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp_DescriptionHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__CategoryHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__ZoneHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__UOMHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__InnerPackHeader)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformationPopUp__CaseHeader)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view List of read only information related to X a)WRIN b)Description c)category d) Zone  d)UOM e) Inner pack (if applicable)e)case f)zone g)Case price",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view List of read only information related to X a)WRIN b)Description c)category d) Zone  d)UOM e) Inner pack (if applicable)e)case f)zone g)Case price",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		if(rawitemactivitypage.verifyInformationDisplayedForSelectedItem(samplewRINID)) {
			Reporter.reportPassResult(
					browser,"User should be able to read only information related to X.","Pass");
		} else {
			Reporter.reportTestFailure(
					browser,"User should be able to read only information related to X.","Fail");
			AbstractTest.takeSnapShot();
		}
		if (!rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB.isSelected()) {
			GenericMethods.clickOnElement(rawitemactivitypage.RawItemInformation_popUp_ManualPurchase_CB,"RawItemInformation_popUp_ManualPurchase_CB");
		}
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_Frequency_DD)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_PrimaryVendor_DD)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_GLAccount_DD)
				& Base.isElementDisplayed(rawitemactivitypage.RawItemInformation_popUp_CasePrice_TB)
				& Base.isElementDisplayed(rawitemactivitypage.AveratCostPerUnit_Value)) {
			Reporter.reportPassResult(browser,
					"User should be able to view a) Manual Purchases check box b) List type c) McDonalds GL Account d) Primary Vendor e) Case Price f) Average Cost per Unit",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view a) Manual Purchases check box b) List type c) McDonalds GL Account d) Primary Vendor e) Case Price f) Average Cost per Unit",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}	
	
}
