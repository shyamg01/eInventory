package varianceStatBundle;

import java.io.IOException;
import java.math.BigDecimal;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

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
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.VarianceStatPage;

public class US970_Part2StatVariance extends AbstractTest{
	
	//TC2712 : Verify that user  select a business date before the information can populate on the page.
	@Test
	public void varianceStatBundle_US970_TC2712() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2712";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.VarianceStatTableHeaderDisplayed()
				& varianceStatPage.dailyStatRecords_List.size()>0){
			Reporter.reportPassResult(
					browser,
					"User should be able to view each WRIN and Description marked as \"daily\" and marked as a recipe raw item.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view each WRIN and Description marked as \"daily\" and marked as a recipe raw item.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2713 : Verify that WRIN and Description is visible on daily stat page, for raw items which has been submitted as physical inventory.
	@Test()
	public void varianceStatBundle_US970_TC2713() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2713";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID1, quantity, quantity, quantity);
		Thread.sleep(2000);
		String itemTotal = physicalInventoryPage.getItemTotalForAWrin(samplewRINID1);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(5000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID1);
		Thread.sleep(5000);
		rawItemActivityPage.Information_BT.click();
		String uom = wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_UOM_Value)).getText();
		rawItemActivityPage.RawItemInformation_Cancel_BT.click();
		VarianceStatPage varianceStatPage = homePage.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		if(varianceStatPage.verifyInventoryOnHandCountMatchedForSelectedDate(createDate, itemTotal, uom)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the  description and physical inventory event against raw item X.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the  description and physical inventory event against raw item X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2714 : Verify the container will show "collapsed" as default on daily stat page.
	@Test()
	public void varianceStatBundle_US970_TC2714() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2714";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		if(varianceStatPage.verifySelectedDateIsExpanded(createDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the information in expanded state for current date ",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the information in expanded state for current date",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2715 : Verify the detail section of WRIN and Description container.
	@Test()
	public void varianceStatBundle_US970_TC2715() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2715";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.dailyInventoryWrin_YieldValue;
		String samplewRINID1_description = GlobalVariable.dailyInventoryWrinDescription_YieldValue;
		String createDate = GlobalVariable.createDate;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
		physicalInventoryPage.verifyAndAddWrinInTable(samplewRINID1, quantity, quantity, quantity);
		Thread.sleep(2000);
		String inventoryTime = Base.getCurrentTimeForStore(storeId);
		GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
		Thread.sleep(5000);
		VarianceStatPage varianceStatPage = homePage.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		if(varianceStatPage.verifyStatDetailsDisplayedForAnItem(samplewRINID1, samplewRINID1_description, createDate, inventoryTime)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the following details: 1. Inventory Calendar Date and Time 2. Actual Usage 3.Variance 4.$Difference 5.Yield 6. Difference",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the following details: 1. Inventory Calendar Date and Time 2. Actual Usage 3.Variance 4.$Difference 5.Yield 6. Difference",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2716 : Verify the day total for all raw items counted on the date selected will display on the TOP of the page
	@Test()
	public void varianceStatBundle_US970_TC2716() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2716";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		System.out.println("StatGain_Label "+varianceStatPage.StatGain_Label.getText());
		if(Base.isElementDisplayed(varianceStatPage.StatGain_Label)
				& Base.isElementDisplayed(varianceStatPage.StatGain_Value)
				& Base.isElementDisplayed(varianceStatPage.StatLoss_Value)
				& Base.isElementDisplayed(varianceStatPage.StatVariance_Value)
				& varianceStatPage.StatGain_Label.getText().contains("Stat Loss:")
				& varianceStatPage.StatGain_Label.getText().contains("Stat Variance:")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain , Stat Loss ans Stat Variance in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal calculateGain = varianceStatPage.getStatGainFromDifference();
		BigDecimal statGain = new BigDecimal(varianceStatPage.StatGain_Value.getText().replace("$", ""));
		if(calculateGain.equals(statGain)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain value as sum of all positive difference values in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain value as sum of all positive difference values in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal calculatedLoss = varianceStatPage.getStatLossFromDifference();
		BigDecimal statLoss = new BigDecimal(varianceStatPage.StatLoss_Value.getText().replace("$", ""));
		if(calculatedLoss.equals(statLoss)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Loss value as sum of all negative difference values in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Loss value as sum of all negative difference values in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		BigDecimal statVar = new BigDecimal(varianceStatPage.StatVariance_Value.getText().replace("$", ""));
		if(statVar.equals(statLoss.add(statGain))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Stat Gain + Stat Loss as Stat Variance in Variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Stat Gain + Stat Loss as Stat Variance in Variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2717 : Verify the rolling month net stat variance (Month to Date Used Difference Total) for each applicable raw item.
	@Test()
	public void varianceStatBundle_US970_TC2717() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2717";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin2;
		String createDate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		String diffInStatPage = varianceStatPage.getDifferenceForAWrin(samplewRINID1);
		System.out.println("difffffff  "+ diffInStatPage);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		String diffInStatPageActivity = varianceStatPage.calculateDifferenceForARawItem(createDate);
		System.out.println("Difference  "+diffInStatPageActivity);
		if(diffInStatPage.equals(diffInStatPageActivity)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the $diff as Y on stat variance landing page against Raw item X.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the $diff as Y on stat variance landing page against Raw item X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2734 : Verify the rolling month net stat variance (Month to Date Used Difference Total) for each applicable raw item.
	@Test()
	public void varianceStatBundle_US970_TC2734() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="varianceStatBundle_US970_TC2734";
		String password = LoginTestData.password;
		String userId =  LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String samplewRINID1 = GlobalVariable.createDailyInventoryWrin3;
		String createDate = GlobalVariable.createDate;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID1, quantity, quantity, quantity);
		VarianceStatPage varianceStatPage = homePage.goToVarianceStatPage();
		varianceStatPage.selectVarianceStatType("Daily").selectDateForDailyStat(GlobalVariable.createDate);
		Thread.sleep(5000);
		String diffInStatPage = varianceStatPage.getDifferenceForAWrin(samplewRINID1);
		System.out.println("difffffff  "+ diffInStatPage);
		varianceStatPage.viewActivityButtn(samplewRINID1).click();
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.VarianceStatRawItemActivity_Label));
		String diffInStatPageActivity = varianceStatPage.calculateDifferenceForARawItem(createDate);
		System.out.println("Difference  "+diffInStatPageActivity);
		if(diffInStatPage.equals(diffInStatPageActivity)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the $diff as Y on stat variance landing page against Raw item X.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the $diff as Y on stat variance landing page against Raw item X.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	
}
	