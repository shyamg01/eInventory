package promotionAndWasteBundle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import bsh.ParseException;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;

public class US425_WastePromoLandingPage extends AbstractTest{
	
	// TC1739: Verify that the user should be able to select a start and end date to filter the list of raw waste/promo entries.
	@Test(groups="Smoke")
	public void promotionWaste_US425_TC1739() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException, java.text.ParseException {
		
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC1739";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		if(promotionsAndWastePage.verifyWasteHistoryDisplayedForSelectedDateRange(startDate, endDate)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view details of all raw waste, raw promo and completed waste submitted for selected date",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view details of all raw waste, raw promo and completed waste submitted for selected date",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1741: Verify that the user should be able to view raw promo and waste history for the selected date range.
	@Test()
	public void promotionWaste_US425_TC1741() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC1741";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String createdate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		if (promotionsAndWastePage.verifyByDefaultDateGroupIsCollapsed(startDate,endDate)) {
			Reporter.reportPassResult(
					browser,
					"Waste entry records should be collapsed by default","Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Waste entry records should be collapsed by default","Fail");
			AbstractTest.takeSnapShot();
			
		}
		promotionsAndWastePage.clickOnDateGroup(createdate);
		if (promotionsAndWastePage.verifySelectedDateIsExpanded(createdate)) {
			Reporter.reportPassResult(
					browser,
					"User is able to expand the records for a selecte date","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to expand the records for a selecte date","Fail");
			AbstractTest.takeSnapShot();
			
		}
		promotionsAndWastePage.clickOnDateGroup(createdate);
		if (promotionsAndWastePage.verifySelectedDateIsCollapsed(createdate)) {
			Reporter.reportPassResult(
					browser,
					"User is able to minimize the records for a selecte date","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to minimize the records for a selecte date","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3241: Verify,"The default start and end dates will be month to date on promotions and waste page".
	@Test()
	public void promotionWaste_US425_TC3241() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC3241";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		/*Verify User is able to view Start Date Field with default date as 1st date of Current Month End Date Field 
		 * with default date as Current date is selected and Show Results [button]- against Start and End Date field.*/
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		System.out.println("endDate "+endDate);
		System.out.println("Start Date "+promotionsAndWastePage.promoWasteHistoryStartDate_TB.getAttribute("value"));
		System.out.println("End Date "+promotionsAndWastePage.promoWasteHistoryEndDate_TB.getAttribute("value"));
		if (promotionsAndWastePage.promoWasteHistoryStartDate_TB.getAttribute("value").equals(startDate)
				& promotionsAndWastePage.promoWasteHistoryEndDate_TB.getAttribute("value").equals(endDate)
				& Base.isElementDisplayed(promotionsAndWastePage.ShowResults_BT)) {
			Reporter.reportPassResult(
					browser,
					"User is able to view Start Date Field with default date as 1st date of Current Month End Date Field "
					+ " with default date as Current date is selected", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to view Start Date Field with default date as 1st date of Current Month End Date Field "
					+ " with default date as Current date is selected","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3242: Verify,"The user will see the rolled up total $ amounts for raw waste, raw promo and completed waste next to the date".
	@Test()
	public void promotionWaste_US425_TC3242() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC3242";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String createdate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		promotionsAndWastePage.clickOnDateGroup(createdate);
		if(!promotionsAndWastePage.getWasteAmountFromDateGroupHeader(createdate).isEmpty() 
				& !promotionsAndWastePage.getPromoAmountFromDateGroupHeader(createdate).isEmpty()
				& !promotionsAndWastePage.getCompleteWasteAmountFromDateGroupHeader(createdate).isEmpty()){
			Reporter.reportPassResult(
					browser,
					"User should be able to view calculation for Raw Waste, Completed Waste and Raw Promo respectively in row header for selecte date.",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view calculation for Raw Waste, Completed Waste and Raw Promo respectively in row header for selecte date.",
					"Fail");
			AbstractTest.takeSnapShot();
			
			
		}
	}
	
	//TC3243: Verify,"The history section should have the current date roll up on top of the list, not the bottom of the list".
	@Test()
	public void promotionWaste_US425_TC3243() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC3243";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		String currentDateRecordClass = promotionsAndWastePage.WasteRecordsList.get(0).getAttribute("class");
		if(currentDateRecordClass.contains(Base.getFormattedDate(endDate))){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the history section with current date rolled up on top of the list",
					"Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the history section with current date rolled up on top of the list",
					"Fail");
			AbstractTest.takeSnapShot();
			
			
		}
	}
	
	//TC3244: Verify,"The current day will show all the raw waste/promo entries for the current date".
	@Test()
	public void promotionWaste_US425_TC3244() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC3244";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		promotionsAndWastePage.clickOnDateGroup(endDate);
		if (promotionsAndWastePage.verifySelectedDateIsExpanded(endDate)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the details of promotions and waste for a selecte date","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the details of promotions and waste for a selecte date","Fail");
			AbstractTest.takeSnapShot();
			
		}
		promotionsAndWastePage.clickOnDateGroup(endDate);
		if (promotionsAndWastePage.verifySelectedDateIsCollapsed(endDate)) {
			Reporter.reportPassResult(
					browser,
					"User is able to minimize the records for a selecte date","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User is able to minimize the records for a selecte date","Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC4495: View functionality promo and waste page
	@Test()
	public void promotionWaste_US425_TC4495() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US425_TC4495";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String createdate = GlobalVariable.createDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		// Select end date as today date and start date as today date
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = dateFormat.format(cal1.getTime());
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 0);
		String endDate = dateFormat.format(cal2.getTime());
		promotionsAndWastePage.selectStartDate(startDate);
		promotionsAndWastePage.selectEndDate(endDate);
		promotionsAndWastePage.ShowResults_BT.click();
		Thread.sleep(5000);
		promotionsAndWastePage.clickOnDateGroup(createdate);
		promotionsAndWastePage.viewCompletedWasteEntry(createdate);
		if(promotionsAndWastePage.CompletedWasteDetailsEntries_List.size()>0
				& Base.isElementDisplayed(promotionsAndWastePage.CompletedWasteDetail_Total_Label)
				& !promotionsAndWastePage.CompletedWasteDetail_Total_Value.getText().equals("$0.00")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view item records in waste details screen ","Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view item records in waste details screen ","Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}

}
