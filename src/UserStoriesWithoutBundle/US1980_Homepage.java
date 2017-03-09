package UserStoriesWithoutBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.CompletedWastePage;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemWastePage;

public class US1980_Homepage extends AbstractTest
{
	//TC4543 : Verify that the user is able to view 'inventory' label on home page	
	@Test()
	public void UserStoriesWithoutBundle_US1980_TC4543() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
	{
		/**Variable Section :**/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1980_TC4543";
//		String userId = LoginTestData.operatorUserId;
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		/*View the label for inventory on home page
		View 3 buttons:
		create daily inventory
		enter raw waste 
		enter completed waste*/
		if(GenericMethods.isElementDisplayed(homePage.QSRInventory_Lebel, "homePage.QSRInventory_Lebel") &&
				GenericMethods.isElementDisplayed(homePage.CreateDailyInventory_BT, "homePage.CreateDailyInventory_BT") &&
				GenericMethods.isElementDisplayed(homePage.EnterRawWaste_BT, "homePage.EnterRawWaste_BT") &&
				GenericMethods.isElementDisplayed(homePage.EnterCompletedWaste_BT, "homePage.EnterCompletedWaste_BT"))
		{
			Reporter.reportPassResult(
					browser,
					"All the labels and the button should display properly","Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"All the labels and the button should display properly",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
		
	}
	
	
	//TC4544 : Verify that the user is able to open 'create daily inventory' modal from homepage
		@Test()
		public void UserStoriesWithoutBundle_US1980_TC4544() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException 
		{
			/**Variable Section :**/
			AbstractTest.tcName="UserStoriesWithoutBundle_US1980_TC4544";
			String userId = LoginTestData.userId;
			String password = LoginTestData.password;
			String storeId = LoginTestData.StoreId;
			
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = PageFactory.initElements(driver, PhysicalInventoryPage.class);
			//Navigate to Transfer Landing page and click on create new transfer button
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
			//Click on  Create Daily inventory link
			GenericMethods.clickOnElement(homePage.CreateDailyInventory_BT, "homePage.CreateDailyInventory_BT");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
			//Verify create daily inventory page is opened
			if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventoryPopUp_Title, "DailyInventoryPopUp_Title"))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to open 'create daily inventory' modal","Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to open 'create daily inventory' modal",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
			
		}
	
	
	
	
	
		//TC4545 : Verify that the user is able to open 'enter raw waste' modal from homepage
				@Test()
				public void UserStoriesWithoutBundle_US1980_TC4545() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException 
				{
					/**Variable Section :**/
					AbstractTest.tcName="UserStoriesWithoutBundle_US1980_TC4545";
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.userId;
					String password = LoginTestData.password;
					String storeId = LoginTestData.StoreId;
					
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					RawItemWastePage rawItemWastePage=new RawItemWastePage(driver);
					//Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
					//Click on  Enter Raw Waste button
					GenericMethods.clickOnElement(homePage.EnterRawWaste_BT, "homePage.EnterRawWaste_BT");
					Thread.sleep(5000);
					wait.until(ExpectedConditions.visibilityOf(rawItemWastePage.RawWaste_Title));
					//Verify create Raw Waste page is opened
					if(GenericMethods.isElementDisplayed(rawItemWastePage.RawWaste_Title, "rawItemWastePage.RawWaste_Title")
							)
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to open 'enter raw waste' modal","Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to open 'enter raw waste' modal",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
					
				}
			
			
	
	
				//TC4546 : Verify that the user is able to open 'enter completed waste' modal from home page
				@Test()
				public void UserStoriesWithoutBundle_US1980_TC4546() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException 
				{
					/**Variable Section :**/
					AbstractTest.tcName="UserStoriesWithoutBundle_US1980_TC4546";
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.userId;
					String password = LoginTestData.password;
					String storeId = LoginTestData.StoreId;
					
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					CompletedWastePage completedWastePage=new CompletedWastePage(driver);
					//Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
					//Click on  Enter Completed Waste button
					GenericMethods.clickOnElement(homePage.EnterCompletedWaste_BT, "homePage.EnterCompletedWaste_BT");
					wait.until(ExpectedConditions.visibilityOf(completedWastePage.CompletedWaste_Title));
					//Verify create completed waste page  is opened
					if(GenericMethods.isElementDisplayed(completedWastePage.CompletedWaste_Title, "completedWastePage.CompletedWaste_Title")
							)
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to open 'enter completed waste' modal","Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to open 'enter completed waste' modal",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
					
				}
			
			
	
				//TC4551 : Verify that the user is able to view Product Net Sales on home page
				@Test()
				public void UserStoriesWithoutBundle_US1980_TC4551() throws RowsExceededException,
							BiffException, WriteException, IOException, InterruptedException 
				{
					/**Variable Section :**/
					AbstractTest.tcName="UserStoriesWithoutBundle_US1980_TC4551";
//					String userId = LoginTestData.operatorUserId;
					String userId = LoginTestData.userId;
					String password = LoginTestData.password;
					String storeId = LoginTestData.StoreId;
					
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					//Navigate to Transfer Landing page and click on create new transfer button
					homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
					//View Product Net Sales values below month-to-date restaurant performance section on homepage
					
					if(GenericMethods.getText(driver.findElement(By.xpath("//td[text()='Product Net Sales']/following-sibling::td[1]")), "Product Net Sales doller Value").length()>=0 &&
							GenericMethods.getText(driver.findElement(By.xpath("//td[text()='Product Net Sales']/following-sibling::td[2]")), "Product Net Sales percentage Value").length()>=0)
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to view Product Net Sales values below month-to-date restaurant performance section on homepage","Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to view Product Net Sales values below month-to-date restaurant performance section on homepage",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
					
				}
			
		
}
