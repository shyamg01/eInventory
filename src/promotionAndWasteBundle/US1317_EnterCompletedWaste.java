package promotionAndWasteBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.FoodOverBasePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.RawItemPromoPage;
import eInventoryPageClasses.RawItemWastePage;

public class US1317_EnterCompletedWaste extends AbstractTest{
	
	//TC2301: Verify that the user is able to view 'Completed Waste' button on the Promotions and Waste Landing page.
	@Test()
	public void promotionWaste_US1317_TC2301() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2301";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		if(Base.isElementDisplayed(promotionsAndWastePage.CompletedWaste_BT)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view 'Enter Completed Waste' button on the Promotions and Waste Landing page.", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view 'Enter Completed Waste' button on the Promotions and Waste Landing page.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}
	
	//TC2302: Verify that the user is able to select a date and time for the completed waste entry.
	@Test(enabled = false)//Not valid for current ui
	public void promotionWaste_US1317_TC2302() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2302";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
//		completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
//		if(completedWastePage.SelectDateAndTime_TB.getAttribute("value").equals(createDate)
//				& completedWastePage.SelectTime_TB.getText().equals(time)){
//			Reporter.reportPassResult(
//					browser, 
//					"user is able to select a date and time for the completed waste entry.", "Pass");
//			
//		} else {
//			Reporter.reportTestFailure(
//					browser,
//					"user is able to select a date and time for the completed waste entry.", "Fail");
//			AbstractTest.takeSnapShot();
//			
//		}
		
	}
	
	//TC2303: Verify, "A method to search (number or description) and add one or more menu items to the Completed Waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2303() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2303";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		//String createDate = GlobalVariable.createDate;
		/**/
		String menuItemId1 = GlobalVariable.completedWasteWrin3;
		String menuItem1Description = GlobalVariable.completedWasteWrin3Description;
		String menuItemId2 = GlobalVariable.completedWasteWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		//completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItem1Description);
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId2);
		if(completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId1)
				& completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId2)){
			Reporter.reportPassResult(
					browser,
					"User should be able to search, select and add wrin=a or description=b from the search box", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to search, select and add wrin=a or description=b from the search box", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		
	}
	
	//TC2308: Verify that the user is able to enter whole number as quantities for one or more menu items on the completed waste entry screen which is greater than 0 and less than 1000 (3 digit cap).
	@Test()
	public void promotionWaste_US1317_TC2308() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2308";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String validquantity = "4";
		String inValidquantity1 = "0";
		String inValidquantity2 = "1000";
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		//completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, inValidquantity1);
		String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount "+wasteAmount);
		if(Base.isElementDisplayed(completedWastePage.CompletedWasteForm_ZeroQuantityError_Message)
				& completedWastePage.Submit_BT.getAttribute("disabled").equals("true")
				& wasteAmount.equals("0.00")){
			Reporter.reportPassResult(
					browser,
					"User should not be able to submit complated waste with 0 quantity", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to submit complated waste with 0 quantity", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.clear();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.sendKeys(inValidquantity2);
		if(Base.isElementDisplayed(completedWastePage.InvalidQuantity_Error_Message)
				& completedWastePage.InvalidQuantity_Error_Message.getText().contains("Values must be numeric with no decimals or you have entered a number larger than this field allows. (Example: 123)")
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals("100")){
			Reporter.reportPassResult(
					browser,
					"User should not be able to submit complated waste with 1000 quantity", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should not be able to submit complated waste with 1000 quantity", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.clear();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.sendKeys(validquantity);
		completedWastePage.CompletedWaste_Title.click();
		wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		if(completedWastePage.Submit_BT.getAttribute("disabled")== null &
				!wasteAmount.equals("0.00") & completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals(validquantity)){
			Reporter.reportPassResult(
					browser,
					"User should be able to enter quantities=a which is a whole number > 0 and < 1000", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter quantities=a which is a whole number > 0 and < 1000", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2313: Verify that the user is able to enter only numeric characters as quantities for one or more menu items on the entry screen of Completed Waste page
	@Test()
	public void promotionWaste_US1317_TC2313() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2313";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity1 = "$$$###";
		String quantity2 = ".";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		//completedWastePage.selectDateForRawWaste(createDate);
		//Thread.sleep(2000);
		//completedWastePage.selectTimeInCompletedWasteForm(time);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		//completedWastePage.CompletedWasteForm_ItemAdded_Message.click();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.clear();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.sendKeys(quantity1);
		if(Base.isElementDisplayed(completedWastePage.InvalidQuantity_Error_Message)
				& completedWastePage.InvalidQuantity_Error_Message.getText().contains("Values must be numeric with no decimals or you have entered a number larger than this field allows. (Example: 123)")
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals("")){
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter special character in menu Item Quantity text box in Completed Waste form", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter special character in menu Item Quantity text box in Completed Waste form", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		Thread.sleep(3000);
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.clear();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.sendKeys(quantity2);
		//completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity2);
		if(Base.isElementDisplayed(completedWastePage.InvalidQuantity_Error_Message)
				& completedWastePage.InvalidQuantity_Error_Message.getText().contains("Values must be numeric with no decimals or you have entered a number larger than this field allows. (Example: 123)")
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals("")){
			Reporter.reportPassResult(
					browser,
					"User should not be able to enter decimal number in menu Item Quantity text box in Completed Waste form", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to enter  decimal number in menu Item Quantity text box in Completed Waste form", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
	}
	
	//TC2320: Verify that user is able to view Completed Waste Food Cost $ subtotal for each menu item on the Completed Waste entry page
	@Test()
	public void promotionWaste_US1317_TC2320() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2320";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		//completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount "+wasteAmount);
		if(!wasteAmount.equals("0.00")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view Completed Waste Food Cost $ subtotal=z for item=x on the Completed Waste entry page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Completed Waste Food Cost $ subtotal=z for item=x on the Completed Waste entry page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		//completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
	}
	
	//TC2322:Verify,"a method to remove the menu item from the completed waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2322() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2322";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity);
		completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
		if(!completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId1)){
			Reporter.reportPassResult(
					browser,
					"User should be able to remove item=x on the Completed Waste entry page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to remove item=x on the Completed Waste entry page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	//TC2323: Verify,"A method to submit the completed waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2323() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2323";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(2));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		//completedWastePage.selectDateForRawWaste(createDate);
		//Thread.sleep(2000);
		//completedWastePage.selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		completedWastePage.Submit_BT.click();
		if(Base.isElementDisplayed(completedWastePage.SubmitCompletedWaste_PopUp_Warning_Message)
				& Base.isElementDisplayed(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)
				& Base.isElementDisplayed(completedWastePage.SubmitCompletedWaste_PopUp_NO_BT)){
			Reporter.reportPassResult(
					browser,
					"Warning popup message should appear: \"Are you sure you want to submit this completed waste?\" with Yes and No option.", "Pass");
			

		} else {
			Reporter.reportTestFailure(
					browser,
					"Warning popup message should appear: \"Are you sure you want to submit this completed waste?\" with Yes and No option.", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_NO_BT)).click();
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_Warning_Message));
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		if(Base.isElementDisplayed(completedWastePage.WasteEntrySaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser,
					"User should be able to submit the completed waste entry", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to submit the completed waste entry", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2324:  Verify that the user is able to directed back to the Completed Waste Landing page after clicking on cancel button
	@Test()
	public void promotionWaste_US1317_TC2324() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2324";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		completedWastePage.Cancel_BT.click();
		boolean warningMessageDisplayed = Base.isElementDisplayed(completedWastePage.CancelCompletedWastePopUp_Warning_Message);
		warningMessageDisplayed = warningMessageDisplayed 
				& completedWastePage.CancelCompletedWastePopUp_Warning_Message.getText().contains("All entered information will be lost. Are you sure you want to cancel?");
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_NO_BT)).click();
		Thread.sleep(2000);
		if (warningMessageDisplayed & !Base.isElementDisplayed(completedWastePage.CompletedWasteEntryIncomplete_PopUp_NO_BT)) {
			Reporter.reportPassResult(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		completedWastePage.Cancel_BT.click();
		warningMessageDisplayed = Base.isElementDisplayed(completedWastePage.CancelCompletedWastePopUp_Warning_Message);
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(5000);
		if (warningMessageDisplayed & !Base.isElementDisplayed(completedWastePage.CompletedWaste_Title)
				& Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and Completed Waste form should be closed on clicking Yes button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and Completed Waste form should be closed on clicking Yes button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2325: Verify that the user has an option to not continue with cancel and directed back to the entry page.
	@Test()
	public void promotionWaste_US1317_TC2325() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2325";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		completedWastePage.Cancel_BT.click();
		boolean warningMessageDisplayed = Base.isElementDisplayed(completedWastePage.CancelCompletedWastePopUp_Warning_Message);
		warningMessageDisplayed = warningMessageDisplayed 
				& completedWastePage.CancelCompletedWastePopUp_Warning_Message.getText().contains("All entered information will be lost. Are you sure you want to cancel?");
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_NO_BT)).click();
		Thread.sleep(2000);
		if (warningMessageDisplayed & !Base.isElementDisplayed(completedWastePage.CompletedWasteEntryIncomplete_PopUp_NO_BT)
				& Base.isElementDisplayed(completedWastePage.CompletedWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2326: Verify that the user is able to view Completed Waste numbers on Menu Item Activity page with the 15 minute time and date selected
	@Test()
	public void promotionWaste_US1317_TC2326() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2326";
		PromotionsAndWastePage promotionsAndWastePage;
		MenuItemActivityAndInformationPage menuItemActivityAndInformationPage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(2));
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String createDate = GlobalVariable.createDate;
		//
		/*String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		menuItemActivityAndInformationPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToMenuItemActivityAndInformationPage();
		menuItemActivityAndInformationPage.selectStartDate(startDate).selectEndDate(endDate);
		menuItemActivityAndInformationPage.searchAndSelectMenuItem(menuItemId1);
		Thread.sleep(2000);
		// Enter start time
		String time = Base.getCurrentTimeForStore(storeId);
		System.out.println("time "+ time);
		String startTime = Base.get15MinuteTimeStamp(Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
		String endTime = Base.getNext15MinuteTimeSlice(Integer.parseInt(startTime.split(":")[0]), Integer.parseInt(startTime.split(":")[1]));
		System.out.println("startTime "+ startTime);
		System.out.println("endTime "+ endTime);
		menuItemActivityAndInformationPage.selectEndTime(endTime).selectStartTime(startTime).ShowResults_BT.click();
		Thread.sleep(2000);
		menuItemActivityAndInformationPage.expandDateGroup();
		int noOfWasteActivities = menuItemActivityAndInformationPage.calculateTotalWasteForADate(createDate);
		System.out.println("noOfWasteActivities "+noOfWasteActivities);
		/*String next15MinuteTime = Base.getNext15MinuteTimeSlice(Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
		System.out.println("next15MinuteTime "+next15MinuteTime);*/
		int wasteActvitiesForTimeSpan = menuItemActivityAndInformationPage.getCompletedWasteCountForSelectedTime(createDate,startTime,endTime);
		System.out.println("wasteActvitiesForTimeSpan "+wasteActvitiesForTimeSpan);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		//completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		String expectedCount = completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value");
		System.out.println("expectedCount "+expectedCount);
		String time2 = Base.getCurrentTimeForStore(storeId);
		String startTime2 = Base.get15MinuteTimeStamp(Integer.parseInt(time2.split(":")[0]), Integer.parseInt(time2.split(":")[1]));
		String endTime2 = Base.getNext15MinuteTimeSlice(Integer.parseInt(startTime2.split(":")[0]), Integer.parseInt(startTime2.split(":")[1]));
		System.out.println("time2 "+ time2);
		System.out.println("startTime2 "+ startTime2);
		System.out.println("endTime2 "+ endTime2);
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.goToMenuItemActivityAndInformationPage();
		menuItemActivityAndInformationPage.selectStartDate(startDate).selectEndDate(endDate);
		menuItemActivityAndInformationPage.searchAndSelectMenuItem(menuItemId1);
		Thread.sleep(2000);
		// Enter start time
		menuItemActivityAndInformationPage.selectEndTime(endTime2).selectStartTime(startTime).ShowResults_BT.click();
		Thread.sleep(2000);
		menuItemActivityAndInformationPage.expandDateGroup();
		System.out.println("getCompletedWasteCountForSelectedTime "+menuItemActivityAndInformationPage.getCompletedWasteCountForSelectedTime(createDate,startTime,endTime));
		if(menuItemActivityAndInformationPage.calculateTotalWasteForADate(createDate) == noOfWasteActivities + Integer.parseInt(expectedCount)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view Completed Waste numbers should be updated on Menu Item Activity page after each waste activity for a date selected", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view Completed Waste numbers should be updated on Menu Item Activity page after each waste activity for a date selected", "Fail");
			AbstractTest.takeSnapShot();
		}
		if (startTime.equals(startTime2)) {
			if (menuItemActivityAndInformationPage.getCompletedWasteCountForSelectedTime(createDate,startTime, endTime) == wasteActvitiesForTimeSpan
					+ Integer.parseInt(expectedCount)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view Completed Waste numbers on Menu Item Activity page with the 15 minute interval for time and date selected",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view Completed Waste numbers on Menu Item Activity page with the 15 minute interval for time and date selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}else{
			if (menuItemActivityAndInformationPage.getCompletedWasteCountForSelectedTime(createDate,startTime2, endTime2) == Integer.parseInt(expectedCount)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view Completed Waste numbers on Menu Item Activity page with the 15 minute interval for time and date selected",
						"Pass");
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view Completed Waste numbers on Menu Item Activity page with the 15 minute interval for time and date selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}
	}
		
	
	//TC2327: Verify that the user is able to view the event named as "Completed Waste" on raw item activity page for the completed waste entry
	@Test()
	public void promotionWaste_US1317_TC2327() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2327";
		PromotionsAndWastePage promotionsAndWastePage;
		RawItemActivityPage rawItemActivityPage;
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String receipeWrinItemId= GlobalVariable.receipeWrinForCompletedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(2));
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String createDate = GlobalVariable.createDate;
		//
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		int noOfWasteActivities = rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate);
		System.out.println("noOfWasteActivities "+noOfWasteActivities);
		//Get Middle Range Yield from Raw item activity page
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String yieldRange = rawItemActivityPage.RawItemInformation_YieldRange_Value.getText();
		// Get the low point
		BigDecimal lowPoint = new BigDecimal(yieldRange.split(" - ")[0]);
		BigDecimal middleRangeYield;
		System.out.println("compare "+lowPoint.compareTo(new BigDecimal(110)));
		if(lowPoint.compareTo(new BigDecimal(110))>0){
			middleRangeYield = lowPoint.add(new BigDecimal(10));
		}else{
			middleRangeYield = lowPoint.add(new BigDecimal(1));
		}
		System.out.println("middleRangeYield "+middleRangeYield);
		rawItemActivityPage.RawItemInformation_popUp_Cancel_BT.click();
		//Get Serving Factor of raw item from menu item activity page
		menuItemActivityPage = homePage.goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItemId1);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(2000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		BigDecimal recipeItemServingFactor = new BigDecimal(menuItemActivityPage.getServingFactorForRecipeItem(receipeWrinItemId));
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		/*completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
		Thread.sleep(2000);*/
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		Thread.sleep(2000);
		BigDecimal completedWasteCount = new BigDecimal(completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value"));
		BigDecimal temp = new BigDecimal(1).divide(middleRangeYield,5,RoundingMode.HALF_UP);
		BigDecimal expectedCompletedWasteCount = temp.multiply(recipeItemServingFactor).multiply(completedWasteCount);
		BigDecimal expectedCompletedWasteCount1 = expectedCompletedWasteCount.setScale(4, RoundingMode.FLOOR);
		BigDecimal expectedCompletedWasteCount2 = expectedCompletedWasteCount.setScale(4, RoundingMode.HALF_UP);
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		/*homePage.Menu_DD_BT.click();
		Thread.sleep(2000);*/
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		System.out.println(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate));
		if(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate) == noOfWasteActivities +1
				& (rawItemActivityPage.verifyCompletedWasteEventCountMatchedForSelectedDate(createDate, String.valueOf(expectedCompletedWasteCount1)) || rawItemActivityPage.verifyCompletedWasteEventCountMatchedForSelectedDate(createDate, String.valueOf(expectedCompletedWasteCount2)))){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
			
		}
	}
	
	//TC2565: Verify that, user is unable to submit  "completed waste" for value meals.
	@Test()
	public void promotionWaste_US1317_TC2565() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2565";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String valueMeal = GlobalVariable.valueMealDescription;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a raw waste entry
		completedWastePage.CompletedWastePopUp_SearchBox_TB.sendKeys(valueMeal);
		action.sendKeys(Keys.SPACE).build().perform();
		Thread.sleep(1500);
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size = driver.findElements(By.xpath("//strong[text()='" + valueMeal + "']")).size();
		if(size==0){
			Reporter.reportPassResult(
					browser,
					"User should be able to Completed waste for Value meal Item", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to Completed waste for Value meal Item", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3229: Verify Current Cost per Unit for each wrin added for completed waste entry = ('Case Price')/('UOM/Case') 
	@Test()
	public void promotionWaste_US1317_TC3229() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC3229";
		PromotionsAndWastePage promotionsAndWastePage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId =GlobalVariable.completedWasteWrin1;
		/*String receipeWrinItemId= GlobalVariable.receipeWrinForCompletedWasteWrin1;
		String receipeItemUomPerCase = GlobalVariable.receipeWrinForCompletedWasteWrin1_UOMPerCase;
		String receipeItemCasePrice = GlobalVariable.receipeWrinForCompletedWasteWrin1_CasePrice;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;*/
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		// Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId, "10");
		String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount "+wasteAmount);
		if(!wasteAmount.equals("0.00")){
			Reporter.reportPassResult(
					browser,
					"User should be able to view sub total= x on the Completed Waste entry page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view sub total= x on the Completed Waste entry page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		/*BigDecimal uomPerCase = new BigDecimal(receipeItemUomPerCase);
		BigDecimal casePrice = new BigDecimal(receipeItemCasePrice);
		BigDecimal costPerUnit = casePrice.divide(uomPerCase, 4, RoundingMode.HALF_UP);
		System.out.println("Case price "+costPerUnit);
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		Thread.sleep(2000);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String avgCostPerUnit = rawItemActivityPage.AveratCostPerUnit_Value.getText();
		System.out.println(avgCostPerUnit);
		if(avgCostPerUnit.equals(costPerUnit)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC3229",
					"Current Cost per Unit should be = ('Case Price')/('UOM/Case')", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC3229","promotionWaste_US1317_TC3229",
					"Current Cost per Unit should be = ('Case Price')/('UOM/Case')", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC3229");
		}*/
	}
	
	//TC2328: Verify that the user is able to view the event named as "Raw Waste" on raw item activity page for the raw waste entry
	@Test()
	public void promotionWaste_US1317_TC2328() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2328";
		RawItemActivityPage rawItemActivityPage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId1 = GlobalVariable.rawItemWastewrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		int noOfWasteActivities = rawItemActivityPage.getNumberOfWasteActivities(createDate);
		//homePage.Menu_DD_BT.click();
		//wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(2000);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		//Create a raw waste entry
		rawItemWastePage.searchAndSelectRawItemWasted(wrinId1);
		//rawItemWastePage.RawWasteForm_ItemAdded_Message.click();
		rawItemWastePage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedCount = rawItemWastePage.RawWasteForm_TotalUnitsValue.getText().replace(",", "");
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		if(rawItemActivityPage.getNumberOfWasteActivities(createDate) == noOfWasteActivities +1
				& rawItemActivityPage.verifyRawWasteEventCountMatchedForSelectedDate(createDate, expectedCount)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the event= Waste for raw-item=x on date D and time=T", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the event= Waste for raw-item=x on date D and time=T", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2329: Verify that the user is able to view the event named as "Raw Promo" on raw item activity page for the raw promo entry
	@Test()
	public void promotionWaste_US1317_TC2329() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2329";
		RawItemActivityPage rawItemActivityPage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String wrinId1 = GlobalVariable.rawItemPromowrin2;
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		//
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		// Navigate to Promotion and Waste page
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		int noOfPromoActivities = rawItemActivityPage.getNoumberOfPromoActivities(createDate);
		/*homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();*/
		PromotionsAndWastePage promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		//Create a raw waste entry
		rawItemPromoPage.searchAndSelectRawPromoItem(wrinId1);
		//rawItemPromoPage.RawPromoForm_ItemAdded_Message.click();
		rawItemPromoPage.addQuantitiesForMultipleWrin(wrinId1, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedCount = rawItemPromoPage.RawPromoForm_TotalUnitsValue.getText().replace(",", "");
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		/*homePage.Menu_DD_BT.click();
		Thread.sleep(2000);*/
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(wrinId1);
		Thread.sleep(5000);
		if(rawItemActivityPage.getNoumberOfPromoActivities(createDate) == noOfPromoActivities +1
				& rawItemActivityPage.verifyRawPromoEventCountMatchedForSelectedDate(createDate, expectedCount)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the event= Promo for raw-item=x on date D and time=T", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC2330: Verify throughout the day,the entries of raw waste, raw promo and completed waste will feed to the raw item activity pages.
	@Test()
	public void promotionWaste_US1317_TC2330() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="promotionWaste_US1317_TC2330";
		PromotionsAndWastePage promotionsAndWastePage;
		RawItemActivityPage rawItemActivityPage;
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId =  LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String receipeWrinItemId= GlobalVariable.receipeWrinForCompletedWasteWrin1;
		String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String caseQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity = String.valueOf(Base.generateNdigitRandomNumber(1));
		String createDate = GlobalVariable.createDate;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		RawItemWastePage rawItemWastePage = PageFactory.initElements(driver,RawItemWastePage.class);
		RawItemPromoPage rawItemPromoPage = PageFactory.initElements(driver,RawItemPromoPage.class);
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		int noOfCompletedWasteActivities = rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate);
		int noOfPromoActivities = rawItemActivityPage.getNoumberOfPromoActivities(createDate);
		int noOfWasteActivities = rawItemActivityPage.getNumberOfWasteActivities(createDate);
		System.out.println("noOfWasteActivities "+noOfCompletedWasteActivities);
		rawItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemActivityPage.RawItemInformation_Title));
		String yieldRange = rawItemActivityPage.RawItemInformation_YieldRange_Value.getText();
		// Get the low point
		BigDecimal lowPoint = new BigDecimal(yieldRange.split(" - ")[0]);
		BigDecimal middleRangeYield;
		System.out.println("compare "+lowPoint.compareTo(new BigDecimal(110)));
		if(lowPoint.compareTo(new BigDecimal(110))>0){
			middleRangeYield = lowPoint.add(new BigDecimal(10));
		}else{
			middleRangeYield = lowPoint.add(new BigDecimal(1));
		}
		System.out.println("middleRangeYield "+middleRangeYield);
		rawItemActivityPage.RawItemInformation_popUp_Cancel_BT.click();
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItemId1);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(2000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		BigDecimal recipeItemServingFactor = new BigDecimal(menuItemActivityPage.getServingFactorForRecipeItem(receipeWrinItemId));
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		//completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		BigDecimal completedWasteCount = new BigDecimal(completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value"));
		BigDecimal temp = new BigDecimal(1).divide(middleRangeYield,5,RoundingMode.HALF_UP);
		BigDecimal expectedCompletedWasteCount = temp.multiply(recipeItemServingFactor).multiply(completedWasteCount);
		expectedCompletedWasteCount = expectedCompletedWasteCount.setScale(4, RoundingMode.FLOOR);
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		//Enter Raw Waste
		promotionsAndWastePage.RawWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
		rawItemWastePage.removeAllWrinIdFromRawWastePage();
		/*rawItemWastePage.selectDateForRawWaste(createDate);
		Thread.sleep(2000);
		rawItemWastePage.selectTimeInRawWasteForm(time);
		Thread.sleep(2000);*/
		rawItemWastePage.searchAndSelectRawItemWasted(receipeWrinItemId);
		rawItemWastePage.addQuantitiesForMultipleWrin(receipeWrinItemId, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedRawWasteCount = rawItemWastePage.RawWasteForm_TotalUnitsValue.getText().replace(",", "");;
		rawItemWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.SubmitRawWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		//Enter Raw Promo
		promotionsAndWastePage.RawPromo_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.RawPromo_Title));
		rawItemPromoPage.removeAllWrinIdFromRawPromoPage();
		//rawItemPromoPage.selectDateForRawPromo(createDate).selectTimeInRawPromoForm(time);
		rawItemPromoPage.searchAndSelectRawPromoItem(receipeWrinItemId);
		rawItemPromoPage.addQuantitiesForMultipleWrin(receipeWrinItemId, innerPackQuantity, caseQuantity, looseUnitQuantity);
		String expectedRawPromoCount = rawItemPromoPage.RawPromoForm_TotalUnitsValue.getText().replace(",", "");;
		rawItemPromoPage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.SubmitRawPromo_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(rawItemPromoPage.PromoEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		System.out.println(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate));
		if(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate) == noOfCompletedWasteActivities +1
				& rawItemActivityPage.verifyCompletedWasteEventCountMatchedForSelectedDate(createDate, String.valueOf(expectedCompletedWasteCount))){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		System.out.println(rawItemActivityPage.getNumberOfWasteActivities(createDate));
		if(rawItemActivityPage.getNumberOfWasteActivities(createDate) == noOfWasteActivities +1
				& rawItemActivityPage.verifyRawWasteEventCountMatchedForSelectedDate(createDate, expectedRawWasteCount)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the Raw waste activity for the  wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Raw waste activity for the  wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
		System.out.println(rawItemActivityPage.getNoumberOfPromoActivities(createDate));
		if(rawItemActivityPage.getNoumberOfPromoActivities(createDate) == noOfPromoActivities +1
				& rawItemActivityPage.verifyRawPromoEventCountMatchedForSelectedDate(createDate, expectedRawPromoCount)){
			Reporter.reportPassResult(
					browser, 
					"User should be able to view the Raw promo activity for the  wrin Item In Raw Item Activity Page", "Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Raw promo activity for the  wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3228: Verify,"Completed Waste Usage will be calculated using raw items in the recipe that have the WASTE_INDICATOR = 'Y' in BOM_COMPONENTS".
		@Test()
		public void promotionWaste_US1317_TC3228() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="promotionWaste_US1317_TC3228";
			PromotionsAndWastePage promotionsAndWastePage;
			FoodOverBasePage foodOverBasePage;
			String userId =  LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String menuItemId1 = GlobalVariable.completedWasteWrin_YWasteIndicator;
			String quantity = String.valueOf(Base.generateNdigitRandomNumber(2));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
			// Navigate to Food over base page
			foodOverBasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToFoodOverBasePage();
			String currentCompletedWasteDollerValue = foodOverBasePage.CurrentMonth_DifferenceDoller_List.get(0).getText().replace("$", "").replace("-", "").trim();
			String currentCompletedWastePercentValue = foodOverBasePage.CurrentMonth_DifferencePercent_List.get(0).getText().replace("%", "").replace("-", "").trim();
			/*BigDecimal wasteValue1 = new BigDecimal(currentCompletedWasteDollerValue);*/
			System.out.println("currentCompletedWasteDollerValue "+currentCompletedWasteDollerValue);
			BigDecimal wastePercent1 = new BigDecimal(currentCompletedWastePercentValue);
			System.out.println("currentCompletedWastePercentValue "+currentCompletedWastePercentValue);
			// Navigate to Promotion and Waste page
			promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
			//CLick on Raw Waste Button
			promotionsAndWastePage.CompletedWaste_BT.click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
			completedWastePage.removeAllWrinIdFromCompletedWastePage();
			//Create a raw waste entry
			//completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
			//Create a raw waste entry
			completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
			String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
			/*BigDecimal subtotal = new BigDecimal(wasteAmount);*/
			System.out.println("wasteAmount "+wasteAmount);
			completedWastePage.Submit_BT.click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
			Thread.sleep(5000);
			homePage.goToFoodOverBasePage();
			String newCompletedWasteDollerValue = foodOverBasePage.CurrentMonth_DifferenceDoller_List.get(0).getText().replace("$", "").replace("-", "").trim();
			System.out.println("newCompletedWasteDollerValue "+newCompletedWasteDollerValue);
			BigDecimal wasteValue2 = new BigDecimal(newCompletedWasteDollerValue);
			String newCompletedWastePercentValue = foodOverBasePage.CurrentMonth_DifferencePercent_List.get(0).getText().replace("%", "").replace("-", "").trim();
			System.out.println("newCompletedWastePercentValue "+newCompletedWastePercentValue);
			BigDecimal wastePercent2 = new BigDecimal(newCompletedWastePercentValue);
			BigDecimal netSales = new BigDecimal(foodOverBasePage.CurrentMonth_NetSales_Value.getText().replace("$", ""));
			System.out.println("netSales "+netSales);
			BigDecimal calculatedDiff = wastePercent2.multiply(netSales).divide(new BigDecimal(100));
			BigDecimal calculatedDiff1 = calculatedDiff.setScale(2, BigDecimal.ROUND_UP);
			BigDecimal calculatedDiff2 = calculatedDiff.setScale(2, BigDecimal.ROUND_DOWN);
			System.out.println("diffffffffffffffffffff1   "+calculatedDiff1);
			System.out.println("diffffffffffffffffffff2   "+calculatedDiff2);
			if(!wastePercent1.equals(wastePercent2) & (wasteValue2.equals(calculatedDiff1) || wasteValue2.equals(calculatedDiff2))){
				Reporter.reportPassResult(
						browser, 
						"User should be able to view the Completed Waste Food Cost =y$ subtotal for wrin=x on the Completed Waste entry", "Pass");
				
			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the Completed Waste Food Cost =y$ subtotal for wrin=x on the Completed Waste entry", "Fail");
				AbstractTest.takeSnapShot();
				
			}
		}

		//TC4426: Verify,"A method to submit the completed waste entry is available to the user".
		@Test()
		public void promotionWaste_US1317_TC4426() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="promotionWaste_US1317_TC4426";
			PromotionsAndWastePage promotionsAndWastePage;
			String userId =  LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			String createDate = GlobalVariable.createDate;
			String menuItemId1 = GlobalVariable.completedWasteWrin1;
			String quantity = String.valueOf(Base.generateNdigitRandomNumber(1));
			String startDate = GlobalVariable.startDate;
			String endDate = GlobalVariable.endDate;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
			// Navigate to Promotion and Waste page
			promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPromotionsAndWastePage();
			String userName = homePage.SelectedUserName_Label.getText();
			userName =  Base.toCamelCase(userName).trim();
			//CLick on Raw Waste Button
			promotionsAndWastePage.CompletedWaste_BT.click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
			completedWastePage.removeAllWrinIdFromCompletedWastePage();
			//String time = completedWastePage.getTimeToSet();
			//completedWastePage.selectDateForRawWaste(createDate).selectTimeInCompletedWasteForm(time);
			//Thread.sleep(2000);
			//Create a raw waste entry
			completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
			String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
			String time = Base.getCurrentTimeForStore(storeId);
			completedWastePage.Submit_BT.click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
			wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
			Thread.sleep(3000);
			promotionsAndWastePage.selectStartDate(startDate);
			promotionsAndWastePage.selectEndDate(endDate);
			promotionsAndWastePage.ShowResults_BT.click();
			Thread.sleep(8000);
			promotionsAndWastePage.clickOnDateGroup(createDate);
			if (promotionsAndWastePage.verifyCompletedWasteEntry(createDate, wasteAmount,userName, userId, time)) {
				Reporter.reportPassResult(
						browser,
						"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered for completed waste in the promo waste page.",
						"Pass");

			} else {
				Reporter.reportTestFailure(
						browser,
						"User should be able to view first Name, Last Name Initial of the user, date and time stamp of creation, time entered for completed waste in the promo waste page.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}	

}
