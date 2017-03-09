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
import common.GenericMethods;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemPromoPage;

public class US1438_AutoSaveImplementResurrectionBehavior extends AbstractTest{
	
	//TC3227 : Verify auto save behavior  when user is logged in through cloud.
	@Test()
	public void UserStoriesWithoutBundle_US1438_TC3232() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1438_TC3232";
		PromotionsAndWastePage promotionsAndWastePage;
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String caseQuantity = "4";
		String innerPackQuantity = "2";
		String looseUnitQuantity = "3";
		String wrinId1 = GlobalVariable.rawItemWatsewrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		GenericMethods.clickOnElement(rawItemPromoPage.RawPromoForm_SliderToggle_BT, "RawPromoForm_SliderToggle_BT");
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//div[@id='signOut']")), "Sign Out");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='htmlButton']/span[text()='Yes']"))).click();
		Thread.sleep(5000);
		driver.get(GlobalVariable.testEnvironment);
		 homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
			.goToPromotionsAndWastePage().RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		if (!rawItemPromoPage.verifyWasteItemIsAdded(wrinId1)) {
			Reporter.reportPassResult(
					browser,
					" User should be able to view the previously entered data for raw promo in promotion and waste landing page.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the previously entered data raw promo in promotion and waste landing page.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void UserStoriesWithoutBundle_US1438_TC4393()
			throws RowsExceededException, BiffException, WriteException,
			IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName = "UserStoriesWithoutBundle_US1438_TC4393";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID1, quantity,  quantity,  quantity);
		String itemTotal = physicalInventoryPage.getItemTotalForAWrin(samplewRINID1);
		System.out.println("itemTotal "+ itemTotal);
		physicalInventoryPage.goToPromotionsAndWastePage();
    	physicalInventoryPage.goToPhysicalInventoryPage();
    	Thread.sleep(6000);
    	GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		String savedItemTotal = physicalInventoryPage.getItemTotalForAWrin(samplewRINID1);
		if(itemTotal.equals(savedItemTotal)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the previously entered data for daily inventory in Physical Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					" User should be able to view the previously entered data  for daily inventory in Physical Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

}
