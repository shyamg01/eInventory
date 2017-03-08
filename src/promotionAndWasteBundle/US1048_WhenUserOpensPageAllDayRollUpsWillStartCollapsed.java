package promotionAndWasteBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;

public class US1048_WhenUserOpensPageAllDayRollUpsWillStartCollapsed extends AbstractTest
{

	@Test(groups="Smoke")
	public void pramotionWaste_US1048_TC1727() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1048_TC1727";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();

		// Verify that raw waste entry should displayed in Promotion and waste page
		if (driver.findElements(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1]/strong/i[@class='glyphicon glyphicon-chevron-down']")).size()==0) {
			Reporter.reportPassResult(
					browser,
					"Promotiona and Waste is showing in default collapse mode", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Promotiona and Waste is showing in default collapse mode", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}	

	//TC2040 : User should be able to view the submitted raw waste and promo history details.
	@Test()
	public void pramotionWaste_US1048_TC2040() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="pramotionWaste_US1048_TC2040";
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String date = GlobalVariable.createDate;
		//String eDate=GlobalVariable.eDate_7320;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
	/*	Thread.sleep(5000);
		promotionsAndWastePage.selectStartDate(stratDate);
		Thread.sleep(2000);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(10000);*/
		/*Thread.sleep(5000);
		//Expend the date icon
		
			System.out.println("Doing scroll down");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)", "");*/
		
		/*Thread.sleep(3000);
		try
		{
		driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1][contains(.,'"+eDate+"')]/span")).click();
		}catch (Exception e)
		{
			jse.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.xpath("//table[@id='waste_history_table']/tbody/tr/th[1][contains(.,'"+eDate+"')]/span")).click();

		}
		Thread.sleep(3000);*/
		promotionsAndWastePage.clickOnDateGroup(date);


		//Click on Promotion and waste page
		try
		{
			promotionsAndWastePage.viewWasteEntry(date);
		} catch (Exception e)
		{
			promotionsAndWastePage.viewPromoEntry(date);
		}
		// Verify that raw waste entry should displayed in Promotion and waste page
		if (Base.isElementDisplayed(By.xpath("//eb-modal[@id='waste_hist_detail_modal']/div[2][preceding-sibling::div[@style='visibility: visible;']]"))) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the submitted raw waste and promo history details", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the submitted raw waste and promo history details", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}		
}
