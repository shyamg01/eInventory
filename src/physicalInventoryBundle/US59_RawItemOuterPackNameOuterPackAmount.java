package physicalInventoryBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;

public class US59_RawItemOuterPackNameOuterPackAmount extends AbstractTest{

	//TC7 : Verify Outer Pack quantity (Case) and Outer Pack Description (UOM) should match to SMART data.
	@Test()
	public void physicalInventory_US59_TC7() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_US59_TC7";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID1 = GlobalVariable.uomConversionItem2;
		BigDecimal uomConversionFactor = new BigDecimal(GlobalVariable.uomConversionItem2_UOM_CONVERSION_FACTOR);
		BigDecimal CASE_PACK_QTY = new BigDecimal(GlobalVariable.uomConversionItem2_CASE_PACK_QTY);
		String ALTERNATE_CASE_DESC = GlobalVariable.uomConversionItem2_ALTERNATE_CASE_DESC;
		BigDecimal qty = new BigDecimal("1");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		BigDecimal expectedOuterPackQty = CASE_PACK_QTY.divide(uomConversionFactor, 0, RoundingMode.HALF_UP);
		System.out.println("expectedOuterPackQty "+expectedOuterPackQty);
		String caseValueInRawItemInfoPage = rawItemActivityPage.RawItemInformation_Case_Value.getText().split(" ")[0];
		BigDecimal outerPackQty = new BigDecimal(caseValueInRawItemInfoPage); 
		
		if(expectedOuterPackQty.equals(outerPackQty)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view case quantiy as CASE_PK_QTY/ UOM_Conversion in Raw Item Info Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view case quantiy as CASE_PK_QTY/ UOM_Conversion in Raw Item Info Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		PhysicalInventoryPage physicalInventoryPage = homePage.goToPhysicalInventoryPage();
		physicalInventoryPage.CreateMonthlyInventory_BT.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.MonthlyInventoryList_Title));
		Thread.sleep(5000);
		physicalInventoryPage.searchRawItemInInventoryList(samplewRINID1);
		if(physicalInventoryPage.OuterPackQty_TB.getAttribute("placeholder").equalsIgnoreCase(ALTERNATE_CASE_DESC)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view  Outer Pack Description (Case) as ALTERNATE_CASE_DESC.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view  Outer Pack Description (Case) as ALTERNATE_CASE_DESC.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		physicalInventoryPage.OuterPackQty_TB.sendKeys(qty.toString());
		if(physicalInventoryPage.getUnitCountForARawItem(samplewRINID1).equals(expectedOuterPackQty.toString())){
			Reporter.reportPassResult(
					browser,
					"User should be able to view case quantiy as CASE_PK_QTY/ UOM_Conversion in Physical Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view case quantiy as CASE_PK_QTY/ UOM_Conversion in Physical Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
