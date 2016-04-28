package UserStoriesWithoutBundle;

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

import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemWastePage;
import sprint2.AbstractTest;

public class US1438_AutoSaveImplementResurrectionBehavior extends AbstractTest
{
	//TC3232 : 	Verify the behavior for resurrecting the data from auto-save when user does manual log out.
	
		@Test()
		public void pramotionWaste_US1438_TC3232() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.AutoSave_SSO_Password;
			String userId = LoginTestData.AutoSave_SSO_UserId;
			String samplewRINID = GlobalVariable.rawItemWatsewrin1;

			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
			PageFactory.initElements(driver, PhysicalInventoryPage.class);
			// Navigate to Promotion and waste page
			PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToPromotionsAndWastePage();
			//Click on Enter Raw Waste button
			promotionsAndWastePage.RawWaste_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
			//Search and select a WRIN ID
			rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
			Thread.sleep(4000);
			//Do sign out from the application
			homePage.SignOut_BT.click();
			Thread.sleep(5000);
			//Again Login into the application
			homePage.selectUserWithSSOLogin(userId, password)
					.navigateToInventoryManagement().goToPromotionsAndWastePage();
			//Click on Enter Raw Waste button
			promotionsAndWastePage.RawWaste_BT.click();
			wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
			
	
			// Verify that User should be able to view the previously entered data in promotion and waste landing page.
			if (!Base.isElementDisplayed(By.xpath("//table[@id='raw_waste_entry_table']/tbody/tr"))) 
			{
				Reporter.reportPassResult(
						browser, "pramotionWaste_US1438_TC3232",
						"User should be able to view the previously entered data in promotion and waste landing page.", "Pass");
			} else {
				Reporter.reportTestFailure(
						browser, "pramotionWaste_US1438_TC3232","pramotionWaste_US1438_TC3232",
						"User should be able to view the previously entered data in promotion and waste landing page.", "Fail");
				AbstractTest.takeSnapShot("pramotionWaste_US1438_TC3232");
			}
		}	
		
}
