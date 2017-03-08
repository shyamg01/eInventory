package physicalInventoryBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;

import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;

public class US63_RawItemUOMLookupTable extends AbstractTest{
	
	//TC1975 : Verify that the user is able to view full description UOM in the UOM column of Raw Item Information screen.
	@Test()
	public void physicalInventory_US63_TC1975() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US63_TC1975";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.uomConversionItem2;
		String samplewRINID1_BASE_UOM_CODE = GlobalVariable.uomConversionItem2_BASE_UOM_CODE;
		String samplewRINID2 = GlobalVariable.uomConversionItem1;
		String samplewRINID2_BASE_UOM_CODE = GlobalVariable.uomConversionItem1_BASE_UOM_CODE;
		String samplewRINID3 = GlobalVariable.uomConversionItem3;
		String samplewRINID3_BASE_UOM_CODE = GlobalVariable.uomConversionItem3_BASE_UOM_CODE;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String uomValue1InRawItemInfoPage = rawItemActivityPage.RawItemInformation_UOM_Value.getText();
		if(uomValue1InRawItemInfoPage.equals(rawItemActivityPage.getUOMValueFromBaseUonCode(samplewRINID1_BASE_UOM_CODE))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view UOM code for raw item 1 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view UOM code for raw item 1 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		Thread.sleep(2000);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID2);
		Thread.sleep(3000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String uomValue2InRawItemInfoPage = rawItemActivityPage.RawItemInformation_UOM_Value.getText();
		if(uomValue2InRawItemInfoPage.equals(rawItemActivityPage.getUOMValueFromBaseUonCode(samplewRINID2_BASE_UOM_CODE))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view UOM code for raw item 2 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view UOM code for raw item 2 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		Thread.sleep(2000);
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID3);
		Thread.sleep(3000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String uomValue3InRawItemInfoPage = rawItemActivityPage.RawItemInformation_UOM_Value.getText();
		if(uomValue3InRawItemInfoPage.equals(rawItemActivityPage.getUOMValueFromBaseUonCode(samplewRINID3_BASE_UOM_CODE))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view UOM code for raw item 2 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view UOM code for raw item 2 as its BASE_UOM_CODE  in Raw Item Info Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}

}
