package promotionAndWasteBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import sprint2.AbstractTest;

public class US1048_WhenUserOpensPageAllDayRollUpsWillStartCollapsed extends AbstractTest
{

	@Test()
	public void pramotionWaste_US1048_TC1727() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();

		// Verify that raw waste entry should displayed in Promotion and waste page
		if (driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1]/strong/i[@class='glyphicon glyphicon-chevron-down']")).size()==0) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1048_TC1727",
					"Promotiona and Waste is showing in default collapse mode", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1048_TC1727","pramotionWaste_US1048_TC1727",
					"Promotiona and Waste is showing in default collapse mode", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1048_TC1727");
		}
	}	

	//TC2040 : User should be able to view the submitted raw waste and promo history details.
	@Test()
	public void pramotionWaste_US1048_TC2040() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String stratDate=GlobalVariable.promotionAndWastePage_StartDate;
		String date=GlobalVariable.createDate;
		String eDate=GlobalVariable.eDate_762;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		Thread.sleep(5000);
		promotionsAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);
		
		//Expend the date icon
		
			System.out.println("Doing scroll down");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");
		
		Thread.sleep(3000);
		try
		{
		driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1][contains(.,'"+eDate+"')]/span")).click();
		}catch (Exception e)
		{
			jse.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1][contains(.,'"+eDate+"')]/span")).click();

		}
		Thread.sleep(3000);


		//Click on Promotion and waste page
		promotionsAndWastePage.viewWasteEntry(date);
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (Base.isElementDisplayed(By.xpath("//eb-modal[@id='waste_hist_detail_modal']/div[2][preceding-sibling::div[@style='visibility: visible;']]"))) {
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1048_TC2040",
					"User should be able to view the submitted raw waste and promo history details", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1048_TC2040","pramotionWaste_US1048_TC2040",
					"User should be able to view the submitted raw waste and promo history details", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1048_TC1727");
		}
	}		
}
