package rawItemActivityBundle;

import java.io.IOException;
import java.util.List;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.RawItemActivityPage;
import sprint2.AbstractTest;

public class US290_RawItemActivity extends AbstractTest
{	
	//TC859 : Verify user is able to navigate to "Raw Item Activity" page.
	@Test()
	public void rawItemActivityBundle_US290_TC859() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.supervisor_SSO_UserId;
		String password = LoginTestData.supervisor_SSO_Password;
		String storeId = LoginTestData.supervisorStoreId;			
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();		
		Thread.sleep(5000);
		if(rawitemactivitypage.RawItemActivity_Title.isDisplayed())
		{
			Reporter.reportPassResult(
					browser,"rawItemActivityBundle_US290_TC859",
					"User is navigated to raw item Activity page",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"rawItemActivityBundle_US290_TC859","rawItemActivityBundle_US290_TC859",
					"User is navigated to raw item Activity page",
					"Fail");
			AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC859");
		}

	}	
	//TC861 : Verify that user is able to search and select one raw item.
	@Test()
	public void rawItemActivityBundle_US290_TC861() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		String userId = LoginTestData.operator_SSO_UserId;
		String password = LoginTestData.operator_SSO_Password;
		String storeId = LoginTestData.operatorStoreId;
		String samplewRINID = GlobalVariable.rawItemActivityWrin;	
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
		rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText());
		if(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText().contains(samplewRINID))
		{
			Reporter.reportPassResult(
					browser,"rawItemActivityBundle_US290_TC861",
					"User should be able to search and select a raw item",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,"rawItemActivityBundle_US290_TC861","rawItemActivityBundle_US290_TC861",
					"User should be able to search and select a raw item",
					"Fail");
			AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC861");
		}

	}
	
	//TC862 : Verify user is able to  select a date range after selecting a WRIN ID on "Raw Item Activity" page.
		@Test()
		public void rawItemActivityBundle_US290_TC862() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String todayDate=Base.returnTodayDate();
			/*******************************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
			//Fetch the start date
			Thread.sleep(4000);
			String startDate=rawitemactivitypage.StartDate_TB.getAttribute("value");
			String endDate=rawitemactivitypage.EndDate_TB.getAttribute("value");
			System.out.println("StartDate"+startDate+"EndDate"+endDate);
			String[] date=todayDate.split("/");
			String expectedStratSDate=date[0]+"/"+"01/"+date[2];
	
			if(startDate.equalsIgnoreCase(expectedStratSDate) && endDate.equalsIgnoreCase(todayDate))
			{
				Reporter.reportPassResult(
						browser,"rawItemActivityBundle_US290_TC862",
						"Correct Start and date should display",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"rawItemActivityBundle_US290_TC862","rawItemActivityBundle_US290_TC862",
						"Correct Start and date should display",
						"Fail");
				AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC862");
			}

		}
		
	//TC2235 : Verify the presence of  event POS open on raw item activity page.
		
		@Test()
		public void rawItemActivityBundle_US290_TC2235() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			String eventCountValue;
			/*******************************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[2]/span/strong[text()='POS OPEN']")).size()<=0)
			{
				Reporter.reportTestFailure(
						browser,"rawItemActivityBundle_US290_TC2235","rawItemActivityBundle_US290_TC2235",
						"No entry of POS open is present",
						"Fail");
				AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC2235");
			}
			else
			{
				List <WebElement> element=driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td[3][preceding-sibling::td/span/strong[text()='POS OPEN']]/span/strong"));
				for(int i=0;i<element.size();i++)
				{
					 eventCountValue=element.get(i).getAttribute("innerHTML");
					 Thread.sleep(2000);
					 System.out.println("eventCountValue for"+i+"th is"+eventCountValue);
					 if(eventCountValue.equalsIgnoreCase("") && i==element.size()-1)
					 {
						 Reporter.reportPassResult(
									browser,"rawItemActivityBundle_US290_TC2235",
									"No value should present for this field",
									"Pass");
					 }
					 else if(eventCountValue.equalsIgnoreCase(""))
					 {
						 continue;
					 }
					 else
					 {
						 Reporter.reportTestFailure(
									browser,"rawItemActivityBundle_US290_TC2235","rawItemActivityBundle_US290_TC2235",
									"No value should present for this field",
									"Fail");
							AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC2235");
					 }
					
				}
				
			}
		
		}	
		
		
	//TC4041 : Verify a method to access raw item information page.
		
		@Test()
		public void rawItemActivityBundle_US290_TC4041() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String userId = LoginTestData.operator_SSO_UserId;
			String password = LoginTestData.operator_SSO_Password;
			String storeId = LoginTestData.operatorStoreId;
			String samplewRINID = GlobalVariable.rawItemActivityWrin;	
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawitemactivitypage = PageFactory.initElements(driver, RawItemActivityPage.class);
			homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).navigateToInventoryManagement().goToRawItemActivityPage();
			rawitemactivitypage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			System.out.println(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText());
			/*if(driver.findElement(By.xpath("//span[@class='raw-item-description']")).getText().contains(samplewRINID))
			{
				Reporter.reportPassResult(
						browser,"rawItemActivityBundle_US290_TC861",
						"User should be able to search and select a raw item",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,"rawItemActivityBundle_US290_TC861","rawItemActivityBundle_US290_TC861",
						"User should be able to search and select a raw item",
						"Fail");
				AbstractTest.takeSnapShot("rawItemActivityBundle_US290_TC861");
			}*/

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
}
