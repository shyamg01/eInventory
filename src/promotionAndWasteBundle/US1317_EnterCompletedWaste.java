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
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.RawItemActivityPage;
import sprint2.AbstractTest;

public class US1317_EnterCompletedWaste extends AbstractTest{
	
	//TC2301: Verify that the user is able to view 'Completed Waste' button on the Promotions and Waste Landing page.
	@Test()
	public void promotionWaste_US1317_TC2301() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToPromotionsAndWastePage();
		// CLick on Raw Waste Button
		if(Base.isElementDisplayed(promotionsAndWastePage.CompletedWaste_BT)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2301",
					"User should be able to view 'Enter Completed Waste' button on the Promotions and Waste Landing page.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2301","promotionWaste_US1317_TC2301",
					"User should be able to view 'Enter Completed Waste' button on the Promotions and Waste Landing page.", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2301");
		}
		
	}
	
	//TC2302: Verify that the user is able to select a date and time for the completed waste entry.
	@Test()
	public void promotionWaste_US1317_TC2302() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
				.goToPromotionsAndWastePage();
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		if(completedWastePage.SelectDateAndTime_TB.getAttribute("value").equals(createDate)
				& completedWastePage.SelectTime_TB.getText().equals(time)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2302",
					"user is able to select a date and time for the completed waste entry.", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2302","promotionWaste_US1317_TC2302",
					"user is able to select a date and time for the completed waste entry.", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2302");
		}
		
	}
	
	//TC2303: Verify, "A method to search (number or description) and add one or more menu items to the Completed Waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2303() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String menuItem1Description = GlobalVariable.completedWasteWrin1Description;
		String menuItemId2 = GlobalVariable.completedWasteWrin2;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItem1Description);
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId2);
		if(completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId1)
				& completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId2)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2303",
					"User should be able to search, select and add wrin=a or description=b from the search box", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2303","promotionWaste_US1317_TC2303",
					"User should be able to search, select and add wrin=a or description=b from the search box", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2303");
		}
		
	}
	
	//TC2308: Verify that the user is able to enter whole number as quantities for one or more menu items on the completed waste entry screen which is greater than 0 and less than 1000 (3 digit cap).
	@Test()
	public void promotionWaste_US1317_TC2308() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount "+wasteAmount);
		if(completedWastePage.Submit_BT.getAttribute("disabled")== null &
				!wasteAmount.equals("0.00")){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2308",
					"User should be able to enter quantities=a which is a whole number > 0 and < 1000", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2308","promotionWaste_US1317_TC2308",
					"User should be able to enter quantities=a which is a whole number > 0 and < 1000", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2308");
		}
	}
	
	//TC2313: Verify that the user is able to enter only numeric characters as quantities for one or more menu items on the entry screen of Completed Waste page
	@Test()
	public void promotionWaste_US1317_TC2313() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity1 = "$";
		String quantity2 = ".";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		//completedWastePage.CompletedWasteForm_ItemAdded_Message.click();
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity1);
		if(Base.isElementDisplayed(completedWastePage.InvalidQuantity_Error_Message)
				& completedWastePage.InvalidQuantity_Error_Message.getText().contains("Values must be numeric with no decimals. (Example: 123)")
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals("")){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2313",
					"User should be able to enter special character in menu Item Quantity text box in Completed Waste form", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2313_Condition1","promotionWaste_US1317_TC2313",
					"User should be able to enter special character in menu Item Quantity text box in Completed Waste form", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2313_Condition1");
		}
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.clear();
		completedWastePage.CompletedWastePopUp_QuantityWasted_TB.sendKeys(quantity2);
		//completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity2);
		if(Base.isElementDisplayed(completedWastePage.InvalidQuantity_Error_Message)
				& completedWastePage.InvalidQuantity_Error_Message.getText().contains("Values must be numeric with no decimals. (Example: 123)")
				& completedWastePage.CompletedWastePopUp_QuantityWasted_TB.getAttribute("value").equals("")){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2313",
					"User should be able to enter decimal number in menu Item Quantity text box in Completed Waste form", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2313_Condition2","promotionWaste_US1317_TC2313",
					"User should be able to enter  decimal number in menu Item Quantity text box in Completed Waste form", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2313_Condition2");
		}
		completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
	}
	
	//TC2320: Verify that user is able to view Completed Waste Food Cost $ subtotal for each menu item on the Completed Waste entry page
	@Test()
	public void promotionWaste_US1317_TC2320() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		String wasteAmount = completedWastePage.getTotalCompletedWasteAmount();
		System.out.println("wasteAmount "+wasteAmount);
		if(!wasteAmount.equals("0.00")){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2320",
					"User should be able to view Completed Waste Food Cost $ subtotal=z for item=x on the Completed Waste entry page", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2320","promotionWaste_US1317_TC2320",
					"User should be able to view Completed Waste Food Cost $ subtotal=z for item=x on the Completed Waste entry page", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2320");
		}
		//completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
	}
	
	//TC2322:Verify,"a method to remove the menu item from the completed waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2322() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "4";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		completedWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Create a raw waste entry
		completedWastePage.searchMenuItemForCompletedWaste(menuItemId1);
		completedWastePage.addQuantitiesForMultipleWrin(menuItemId1, quantity);
		completedWastePage.removeWrinIdFromCompletedWastePage(menuItemId1);
		if(!completedWastePage.verifyCompletedWasteItemIsAdded(menuItemId1)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2322",
					"User should be able to remove item=x on the Completed Waste entry page", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2322","promotionWaste_US1317_TC2322",
					"User should be able to remove item=x on the Completed Waste entry page", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2322");
		}
	}

	//TC2323: Verify,"A method to submit the completed waste entry is available to the user".
	@Test()
	public void promotionWaste_US1317_TC2323() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "2";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//String time = completedWastePage.getTimeToSet();
		completedWastePage.selectDateForRawWaste(createDate);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		if(Base.isElementDisplayed(completedWastePage.WasteEntrySaved_Confirmation_MSG)){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2323",
					"User should be able to submit the completed waste entry", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2323","promotionWaste_US1317_TC2323",
					"User should be able to submit the completed waste entry", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2323");
		}
	}
	
	//TC2324:  Verify that the user is able to directed back to the Completed Waste Landing page after clicking on cancel button
	@Test()
	public void promotionWaste_US1317_TC2324() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String quantity = "5";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
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
					browser, "promotionWaste_US1317_TC2324",
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2324_Condition1","promotionWaste_US1317_TC2324",
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2324_Condition1");
		}
		completedWastePage.Cancel_BT.click();
		warningMessageDisplayed = Base.isElementDisplayed(completedWastePage.CancelCompletedWastePopUp_Warning_Message);
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWasteEntryIncomplete_PopUp_YES_BT)).click();
		Thread.sleep(2000);
		if (warningMessageDisplayed & !Base.isElementDisplayed(completedWastePage.CompletedWaste_Title)
				& Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2324",
					"On clickinng cancel button System should display a Warning message with No and Yes options and Completed Waste form should be closed on clicking Yes button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2324_Condition2","promotionWaste_US1317_TC2324",
					"On clickinng cancel button System should display a Warning message with No and Yes options and Completed Waste form should be closed on clicking Yes button", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2324_Condition2");
		}
	}
	
	//TC2325: Verify that the user has an option to not continue with cancel and directed back to the entry page.
	@Test()
	public void promotionWaste_US1317_TC2325() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToPromotionsAndWastePage();
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
					browser, "promotionWaste_US1317_TC2325",
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2325","promotionWaste_US1317_TC2325",
					"On clickinng cancel button System should display a Warning message with No and Yes options and user should return to Completed Waste form on clicking No button", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2325");
		}
	}
	
	//TC2327: Verify that the user is able to view the event named as "Completed Waste" on raw item activity page for the completed waste entry
	@Test()
	public void promotionWaste_US1317_TC2327() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItemId1 = GlobalVariable.completedWasteWrin1;
		String receipeWrinItemId= GlobalVariable.receipeWrinForCompletedWasteWrin1;
		String quantity = "6";
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String createDate = GlobalVariable.createDate;
		String time = GlobalVariable.time;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver,CompletedWastePage.class);
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		int noOfWasteActivities = rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate);
		System.out.println("noOfWasteActivities "+noOfWasteActivities);
		homePage.Menu_DD_BT.click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_Back_BT)).click();
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.goToPromotionsAndWastePage();
		//CLick on Raw Waste Button
		promotionsAndWastePage.CompletedWaste_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
		completedWastePage.removeAllWrinIdFromCompletedWastePage();
		//Create a raw waste entry
		completedWastePage.selectDateForRawWaste(createDate).selectTimeInRawWasteForm(time);
		//Create a raw waste entry
		completedWastePage.addAMenuItemOnCompletedWastePage(menuItemId1, quantity);
		completedWastePage.Submit_BT.click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.SubmitCompletedWaste_PopUp_YES_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(completedWastePage.WasteEntrySaved_Confirmation_MSG));
		Thread.sleep(5000);
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		homePage.goToRawItemActivityPage();
		rawItemActivityPage.selectStartDate(startDate).selectEndDate(endDate);
		rawItemActivityPage.searchAndSelectWRINID(receipeWrinItemId);
		Thread.sleep(2000);
		rawItemActivityPage.clickOnDateGroup(createDate);
		System.out.println(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate));
		if(rawItemActivityPage.getNumberOfCompletedWasteActivities(createDate) == noOfWasteActivities +1){
			Reporter.reportPassResult(
					browser, "promotionWaste_US1317_TC2327",
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2327","promotionWaste_US1317_TC2327",
					"User should be able to view the completed waste activity for the related receipe wrin Item In Raw Item Activity Page", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2327");
			
		}
	}
	
	//TC2565: Verify that, user is unable to submit  "completed waste" for value meals.
	@Test()
	public void promotionWaste_US1317_TC2565() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String valueMeal = GlobalVariable.valueMealDescription;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		// Navigate to Promotion and Waste page
		promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement()
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
					browser, "promotionWaste_US1317_TC2565",
					"User should be able to Completed waste for Value meal Item", "Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "promotionWaste_US1317_TC2565","promotionWaste_US1317_TC2565",
					"User should be able to Completed waste for Value meal Item", "Fail");
			AbstractTest.takeSnapShot("promotionWaste_US1317_TC2565");
		}
	}
	
	//TC3229: Verify Current Cost per Unit for each wrin added for completed waste entry = ('Case Price')/('UOM/Case') 
	@Test()
	public void promotionWaste_US1317_TC3229() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		PromotionsAndWastePage promotionsAndWastePage;
		RawItemActivityPage rawItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItemId =GlobalVariable.completedWasteWrin1;
		String receipeWrinItemId= GlobalVariable.receipeWrinForCompletedWasteWrin1;
		String receipeItemUomPerCase = GlobalVariable.receipeWrinForCompletedWasteWrin1_UOMPerCase;
		String receipeItemCasePrice = GlobalVariable.receipeWrinForCompletedWasteWrin1_CasePrice;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		CompletedWastePage completedWastePage = PageFactory.initElements(driver, CompletedWastePage.class);
		BigDecimal uomPerCase = new BigDecimal(receipeItemUomPerCase);
		BigDecimal casePrice = new BigDecimal(receipeItemCasePrice);
		BigDecimal costPerUnit = casePrice.divide(uomPerCase, 4, RoundingMode.HALF_UP);
		System.out.println("Case price "+costPerUnit);
		rawItemActivityPage =  homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.navigateToInventoryManagement().goToRawItemActivityPage();
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
		}
	}
	
}
