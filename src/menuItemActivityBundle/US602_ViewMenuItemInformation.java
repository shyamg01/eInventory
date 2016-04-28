package menuItemActivityBundle;
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
import eInventoryPageClasses.MenuItemActivityAndInformationPage;
import sprint2.AbstractTest;

public class US602_ViewMenuItemInformation extends AbstractTest
{
	
	//TC1349 : Verify that user is able to navigate to "Menu Item Information & activity" landing page and search and select a menu item on it.
		
	@Test()
	public void menuItemActivity_US602_TC1349() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//tr[contains(@class,'tableGroupHead')])[1]/th/span[1]")).click();
		if(Base.isElementDisplayed(By.xpath("//table[@id='mia_table']/tbody/tr")))
		{
			Reporter.reportPassResult(
					browser,"menuItemActivity_US602_TC1349",
					"User should be able to view all the activity",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"menuItemActivity_US602_TC1349","menuItemActivity_US602_TC1349",
					"User should be able to view all the activity",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US602_TC1349");
		}	
		
	}
	
	
	//TC1350 : Verify that below fields for menu item are read only to user on "Menu Information" page:
	 
	 
	 
/*	1)Menu Item Number
	2)Description
	3)Currently on POS: Yes/No
	4)Day part code
	5)Family Group
	6)Current Recipe Information
	*/
	
	@Test()
	public void menuItemActivity_US602_TC1350() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		String startTime = GlobalVariable.startTime;
		String endTime = GlobalVariable.endTime;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		menuItemActivityPage.selectStartDate(startDate).selectEndDate(endDate).selectStartTime(startTime).selectEndTime(endTime);
		menuItemActivityPage.ShowResults_BT.click();
		Thread.sleep(5000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_MenuItemNumberHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DescriptionHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_OnPOSHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_DaypartCodeHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Table_FamilyGroupHeader)){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US602_TC1350",
					"User should be able to view Menu Item Information page with Information of searched Menu item",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US602_TC1350_Condition1","menuItemActivity_US602_TC1350",
					"User should be able to view Menu Item Information page with Information of searched Menu item",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US602_TC1350_Condition1");
		}
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		if(Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_Receipe_Table)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_WRINHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_DescriptionHeader)
				& Base.isElementDisplayed(menuItemActivityPage.MenuItemInformation_ReceipeTable_ServingFactorHeader)
				& menuItemActivityPage.MenuItemInformation_ReceipeTable_ItemList.size()>0){
			Reporter.reportPassResult(
					browser, "menuItemActivity_US602_TC1350",
					"User should be able to view columns with label name WRIN, Description, Serving factor with required data to each column",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US602_TC1350_Condition2","menuItemActivity_US602_TC1350",
					"User should be able to view columns with label name WRIN, Description, Serving factor with required data to each column",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US602_TC1350_Condition2");
		}
		
	}
	
	
/*	TC1351 : Verify the below Validations on the menu item information page for each menu item:
		 
		Description: Should be of max. 20 characters
		Currently on POS:  only "Yes" or "No"
		Current Recipe Information
	*/
	
	@Test()
	public void menuItemActivity_US602_TC1351() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		Thread.sleep(5000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		
		//verify "Description" field length should display characters not more than 20 max
		int descLength=driver.findElement(By.xpath("//table[@id='mia-info-top-table']/tbody/tr/td[2]/span")).getText().length();
		//Verify "Currently on POS" should have either "Yes" or "No" as its value
		String posValue=driver.findElement(By.xpath("//table[@id='mia-info-top-table']/tbody/tr/td[3]")).getText();
		//click on Recipe toggle
		driver.findElement(By.xpath("//button[contains(@id,'mia-info-recipe-btn')]/i")).click();
		Thread.sleep(4000);
		System.out.println("descLength"+descLength);
		System.out.println("posValue"+posValue);
		if(descLength<=20 && (posValue.equalsIgnoreCase("Yes") || posValue.equalsIgnoreCase("No")) && menuItemActivityPage.MenuItemInformation_Receipe_Table.isDisplayed())
		{
			Reporter.reportPassResult(
					browser, "menuItemActivity_US602_TC1351",
					"'Description' field length should display characters not more than 20 max and 'Currently on POS' should have either 'Yes' or 'No' as its value and System should display recipe against Menu Item if exists on clicking down arrow button.",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US602_TC1351","menuItemActivity_US602_TC1351",
					"'Description' field length should display characters not more than 20 max and 'Currently on POS' should have either 'Yes' or 'No' as its value and System should display recipe against Menu Item if exists on clicking down arrow button.",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US602_TC1351");
		}
			
	}
	
//TC1373 : Verify Current Recipe Information	
	@Test()
	public void menuItemActivity_US602_TC1373() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;
	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		Thread.sleep(5000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		
		//Click on Receipe toggle and Verify receipe information is displaying or 'No Receipe Information mesagge is displaying'
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		Thread.sleep(3000);
		if(Base.isElementDisplayed(By.xpath("//div[@id='mia-info-recipe-table']/div/table/tbody/tr")) ||
				Base.isElementDisplayed(By.xpath("//div[@id='mia-info-recipe-table']/span[text()='No Recipe Information Available']")))
		{
			Reporter.reportPassResult(
					browser, "menuItemActivity_US602_TC1373",
					"Correct Recepie information should display",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser, "menuItemActivity_US602_TC1373","menuItemActivity_US602_TC1373",
					"Correct Recepie information should display",
					"Fail");
			AbstractTest.takeSnapShot("menuItemActivity_US602_TC1373");
		}		
		
	}
		
	//TC1458 : Verify,"The recipe for each menu item should show the serving factors of the menu item"
		
	@Test()
	public void menuItemActivity_US602_TC1458() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		MenuItemActivityAndInformationPage menuItemActivityPage;
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String menuItem = GlobalVariable.menuItem2;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Promotion and Waste page
		menuItemActivityPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).navigateToInventoryManagement().goToMenuItemActivityAndInformationPage();
		menuItemActivityPage.searchAndSelectMenuItem(menuItem);
		Thread.sleep(5000);
		menuItemActivityPage.Information_BT.click();
		wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemInformation_PopUp_Title));
		
		//Click on Receipe toggle and Verify receipe information is displaying or 'No Receipe Information mesagge is displaying'
		menuItemActivityPage.MenuItemInformation_Receipe_Expand_BT.click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//div[@id='mia-info-recipe-table']/div/table/tbody/tr/td[3]/span")).getText());
		if(!Base.isElementDisplayed(By.xpath("//div[@id='mia-info-recipe-table']/span[text()='No Recipe Information Available']")))
		{
			int size=driver.findElements(By.xpath("//div[@id='mia-info-recipe-table']/div/table/tbody/tr/td[3]/span")).size();
			for(int i=1; i<=size;i++)
			{
				int length=driver.findElement(By.xpath("//div[@id='mia-info-recipe-table']/div/table/tbody/tr["+i+"]/td[3]/span")).getText().length();
				if(length>=1)
				{
					if( i==size)
					{
						Reporter.reportPassResult(
								browser, "menuItemActivity_US602_TC1458",
								"Correct Serving factor information should display",
								"Pass");
					}
					else
					{
						continue;
					}
				}
				else
				{
					Reporter.reportTestFailure(
							browser, "menuItemActivity_US602_TC1458","menuItemActivity_US602_TC1458",
							"Receipe Information should be displaying",
							"Fail");
					AbstractTest.takeSnapShot("menuItemActivity_US602_TC1458");
				}
			}

		}
		else
		{
			Reporter.reportPassResult(
					browser, "menuItemActivity_US602_TC1458",
					"No Receipe Information is present",
					"Pass");
		}
		
		
	}
	

}
