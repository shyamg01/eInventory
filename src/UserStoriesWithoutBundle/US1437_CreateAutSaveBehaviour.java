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

public class US1437_CreateAutSaveBehaviour extends AbstractTest
{
	
	
	//TC3227 : Verify auto save behavior  when user is logged in through cloud.
	
	@Test()
	public void pramotionWaste_US1437_TC3227() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.AutoSave_SSO_Password;
		String userId = LoginTestData.AutoSave_SSO_UserId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//Click on Enter Raw Waste button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Search and select a WRIN ID
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		//Move to the other page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT));
		Thread.sleep(1500);
		homePage.PhysicalInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.PhysicalInventoryPage_Title));
		//Again move back to the Promotion and waste page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.PromotionAndWaste_BT));
		Thread.sleep(1500);
		homePage.PromotionAndWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		//again click on Enter Raw Waste button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		
		// Verify that User should be able to view the previously entered data in promotion and waste landing page.
		if (Base.isElementDisplayed(By.xpath("//table[@id='raw_waste_entry_table']/tbody/tr"))) 
		{
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1437_TC3227",
					"User should be able to view the previously entered data in promotion and waste landing page.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1437_TC3227","pramotionWaste_US1437_TC3227",
					"User should be able to view the previously entered data in promotion and waste landing page.", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1437_TC3227");
		}
	}	
	
	
	//TC3273 : Verify auto save behavior  when user is logged in through cloud.
	
	@Test()
	public void pramotionWaste_US1437_TC3273() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String password = LoginTestData.AutoSave_SSO_Password;
		String userId = LoginTestData.AutoSave_SSO_UserId;
		String samplewRINID = GlobalVariable.rawItemWatsewrin1;

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver, RawItemWastePage.class);
		PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
		// Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage=homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//Click on Enter Raw Waste button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		//Search and select a WRIN ID
		rawItemWastePage.searchAndSelectRawItemWasted(samplewRINID);
		//Move to the other page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT));
		Thread.sleep(1500);
		homePage.PhysicalInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.PhysicalInventoryPage_Title));
		//Again move back to the Promotion and waste page
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.PromotionAndWaste_BT));
		Thread.sleep(1500);
		homePage.PromotionAndWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		//again click on Enter Raw Waste button
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		
		// Verify that User should be able to view the previously entered data in promotion and waste landing page.
		if (Base.isElementDisplayed(By.xpath("//table[@id='raw_waste_entry_table']/tbody/tr"))) 
		{
			Reporter.reportPassResult(
					browser, "pramotionWaste_US1437_TC3273",
					"User should be able to view the previously entered data in promotion and waste landing page.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "pramotionWaste_US1437_TC3273","pramotionWaste_US1437_TC3273",
					"User should be able to view the previously entered data in promotion and waste landing page.", "Fail");
			AbstractTest.takeSnapShot("pramotionWaste_US1437_TC3273");
		}
	}	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
