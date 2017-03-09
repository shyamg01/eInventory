package physicalInventoryBundle;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PhysicalInventoryPart2  extends AbstractTest
{
	//TC_PI_24 : Range indicator color is  getting changed when non-numeric value entered
	
	@Test()
	public void physicalInventory_24() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="physicalInventory_24";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;

		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		physicalInventoryPage.DailyInventory_BT.click();
		wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventory_PopUp_Title));
		//Enter some value in first loose Unit field
		GenericMethods.enterValueInElement(physicalInventoryPage.DailyInventory_PopUp_Loose_TB.get(0), "First Loose Unit Text Box", "te");
		if(physicalInventoryPage.DailyInventory_PopUp_RangeIndicator_RB.get(0).getAttribute("class").equalsIgnoreCase("badge invBadgeOutline"))
		{
			Reporter.reportPassResult(
					browser,
					"Color should be changed to the red of range Indicator check box",
					"Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"Color should be changed to the red of range Indicator check box",
					"Fail");
			AbstractTest.takeSnapShot();
		}

		
		
		
		
	}
	
	
	//TC_PI_25 : Verify that Calculated Usage will need to use latest month UPT
	
		@Test()
		public void physicalInventory_25() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_25";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String samplewRINID = GlobalVariable.nonRecipeRawItem;
			String looseUnit=Integer.toString(Base.generateNdigitRandomNumber(1));
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			RawItemActivityPage rawItemActivityPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToRawItemActivityPage();
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			rawItemActivityPage.Information_BT.click();
			Thread.sleep(2000);
			//Fetch the current month Usase per thousand value
			String beforeValue=driver.findElement(By.xpath("//table[@id='upt_hist_table']/tbody/tr[1]/td[3]")).getText().trim();
			System.out.println("beforeValue "+beforeValue);
			Thread.sleep(1500);
			//Click on Cancel Button on Information page
			rawItemActivityPage.RawItemInformation_popUp_Cancel_BT.click();
			Thread.sleep(1500);
			//Go to the Physical Inventory Page
			PhysicalInventoryPage physicalInventoryPage=homePage.goToPhysicalInventoryPage();
			//Create a Physical Inventory
			physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID, "", "", looseUnit);
			Thread.sleep(10000);
			//Again go to the Raw Item Information Page and check the usas per thousand value
			rawItemActivityPage=homePage.goToRawItemActivityPage();
			rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
			Thread.sleep(5000);
			rawItemActivityPage.Information_BT.click();
			Thread.sleep(2000);
			//Fetch the new current month Usase per thousand value
			String afterValue=driver.findElement(By.xpath("//table[@id='upt_hist_table']/tbody/tr[1]/td[3]")).getText().trim();
			System.out.println("afterValue "+beforeValue);
			Thread.sleep(1500);
			if(!beforeValue.equalsIgnoreCase(afterValue))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the changed UPT value against WRIN",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the changed UPT value against WRIN",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
			
		}
	
		//TC_PI_26 : Verify the expansion of row on physical inventory page.



				@Test()
				public void physicalInventory_26() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_26";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value="5";

					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					//Select All cable WRINs option
					Select select =new Select(physicalInventoryPage.Wrin_DD);
					select.selectByIndex(1);
					Thread.sleep(2000);
					//Click on the first Raw
					GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
					//Enter the case value
					GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
					GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value);
					//Verify that default Add Count radio button is checked
					if(physicalInventoryPage.Preview_Case_TB.getAttribute("value").equalsIgnoreCase(value))
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to enter case value.",
								"Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to enter case value.",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
				}
			
	
		//TC_PI_27 : Verify that after expanding any row the default selected radio button is  "Add Count"



		@Test()
		public void physicalInventory_27() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_27";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;

			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//Click on the first Raw
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Verify that default Add Count radio button is checked
			if(physicalInventoryPage.Preview_AddCount_RB.isSelected())
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to view the default selected Add count radio button.",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to view the default selected Add count radio button.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
		}
	

		//TC_PI_28 : Verify the preview section  while doing manual editing(Add or Replace case) against any raw item X which has been submitted as physical inventory.
		@Test()
		public void physicalInventory_28() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_28";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String value1="5";
			String value2="6";
			String value3="7";

			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//fetch the WRIN ID of first record
			String Wrin=driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]/span")).getText().trim();
			//click on the first record and wait for the preview page to be opened
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value1);
			//click on save button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_Save_BT, "physicalInventoryPage.Preview_Save_BT");
			Thread.sleep(3000);
			//Again click on the same raw
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+Wrin+"')]")), "Same raw which is opened in last step");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Fetch the existing value
			String previousValue=driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText();
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value2);
			System.out.println(" first "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText());
			System.out.println("Second "+Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2))));
			//Verify that value is updated in preview section
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText().equalsIgnoreCase(Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2)))))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Cash with Add count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Cash with Add count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
			//click on the Replace count radio button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_ReplaceCount_RB, "physicalInventoryPage.Preview_ReplaceCount_RB");
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value3);
			//Verify that value is updated in preview section
			System.out.println(" third "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText());
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText().equalsIgnoreCase(value3))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Cash with Replace count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Cash with Replace count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
			
		}
	

		//TC_PI_29 : Verify the preview section  while doing manual editing(Add or Replace pack) against any raw item X which has been submitted as physical inventory.
		@Test()
		public void physicalInventory_29() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_29";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String wrin =GlobalVariable.wrinWithAllTypes;
			String value1="5";
			String value2="6";
			String value3="7";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//Click on the the record with the given wrin
			driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+wrin+"')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB", value1);
			//click on save button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_Save_BT, "physicalInventoryPage.Preview_Save_BT");
			Thread.sleep(3000);
			//Again click on the same raw
			driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+wrin+"')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Fetch the existing value
			String previousValue=driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[2]/span")).getText();
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB", value2);
			System.out.println(" first "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[2]/span")).getText());
			System.out.println("Second "+Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2))));
			//Verify that value is updated in preview section
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[2]/span")).getText().equalsIgnoreCase(Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2)))))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Pack with Add count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Pack with Add count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Thread.sleep(3000);
			//click on the Replace count radio button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_ReplaceCount_RB, "physicalInventoryPage.Preview_ReplaceCount_RB");
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Pack_TB, "physicalInventoryPage.Preview_Pack_TB", value3);
			//Verify that value is updated in preview section
			System.out.println(" third "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[2]/span")).getText());
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[2]/span")).getText().equalsIgnoreCase(value3))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Pack with Replace count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Pack with Replace count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
		}



		//TC_PI_30 : Verify the preview section  while doing manual editing(Add or Replace loose) against any raw item X which has been submitted as physical inventory.
		@Test()
		public void physicalInventory_30() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_30";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String wrin =GlobalVariable.wrinWithAllTypes;
			String value1="5";
			String value2="6";
			String value3="7";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//Click on the the record with the given wrin
			driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+wrin+"')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB", value1);
			Thread.sleep(2000);
			//click on save button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_Save_BT, "physicalInventoryPage.Preview_Save_BT");
			Thread.sleep(3000);
			if(Base.isElementDisplayed(By.xpath("//strong[text()='Preview']")))
			{
				physicalInventoryPage.Preview_Cross_BT.click();
				Thread.sleep(3000);
			}
			//Again click on the same raw
			driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+wrin+"')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Fetch the existing value
			String previousValue=driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[3]/span")).getText();
			Thread.sleep(2000);
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB", value2);
			System.out.println(" first "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[3]/span")).getText());
			System.out.println("Second "+Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2))));
			//Verify that value is updated in preview section
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[3]/span")).getText().equalsIgnoreCase(Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2)))))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Loose with Add count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Loose with Add count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			Thread.sleep(3000);
			//click on the Replace count radio button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_ReplaceCount_RB, "physicalInventoryPage.Preview_ReplaceCount_RB");
			Thread.sleep(2000);
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Loose_TB, "physicalInventoryPage.Preview_Loose_TB", value3);
			//Verify that value is updated in preview section
			System.out.println(" third "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[3]/span")).getText());
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[3]/span")).getText().equalsIgnoreCase(value3))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Loose with Replace count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Loose with Replace count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
		}

		//TC_PI_31 : Verify the Cancellation of preview pop -up once cliked on "X" sign.
		@Test()
		public void physicalInventory_31() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_31";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String wrin =GlobalVariable.wrinWithAllTypes;

			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//Click on the the record with the given wrin
			driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+wrin+"')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			Thread.sleep(2000);
			physicalInventoryPage.Preview_Cross_BT.click();
			if(!Base.isElementDisplayed(By.xpath("//strong[text()='Preview']")))
			{
				Reporter.reportPassResult(
						browser,
						"User should be able to cancel the edit and return the row to its normal height unchanged.",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should be able to cancel the edit and return the row to its normal height unchanged.",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		
		}


//TC_PI_32 :Verify the  user is able to save the count  of preview pop -up once count is added or replaced

		@Test()
		public void physicalInventory_32() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
		{
			/** Variable Section : **/
			AbstractTest.tcName="physicalInventory_32";
			String password = LoginTestData.password;
			String userId = LoginTestData.userId;
			String storeId = LoginTestData.StoreId;
			String value1="5";
			String value2="6";
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
					.goToPhysicalInventoryPage();
			//Select All cable WRINs option
			Select select =new Select(physicalInventoryPage.Wrin_DD);
			select.selectByIndex(1);
			Thread.sleep(2000);
			//fetch the WRIN ID of first record
			String Wrin=driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]/span")).getText().trim();
			//click on the first record and wait for the preview page to be opened
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value1);
			//click on save button
			GenericMethods.clickOnElement(physicalInventoryPage.Preview_Save_BT, "physicalInventoryPage.Preview_Save_BT");
			Thread.sleep(3000);
			//Again click on the same raw
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+Wrin+"')]")), "Same raw which is opened in last step");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
			//Fetch the existing value
			String previousValue=driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText();
			//Enter the case value
			GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
			GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value2);
			System.out.println(" first "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText());
			System.out.println("Second "+Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2))));
			//Verify that value is updated in preview section
			if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText().equalsIgnoreCase(Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2)))))
			{
				Reporter.reportPassResult(
						browser,
						"Correct value should display for the Cash with Add count RB selected",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"Correct value should display for the Cash with Add count RB selected",
						"Fail");
				AbstractTest.takeSnapShot();
			}
			
						
		}
	

		//TC_PI_33 : Verify that the user is allowed to submit inventory even if the range indicator is red

				@Test()
				public void physicalInventory_33() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_33";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value1=Integer.toString(Base.generateNdigitRandomNumber(2));
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Click on Daily Inventory button
					physicalInventoryPage.DailyInventory_BT.click();
					//Enter case value for the first wrin ID
					physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).sendKeys(value1);
					//Verify that red button is enabled against WRIN id
					if(physicalInventoryPage.DailyInventory_PopUp_RangeIndicator_RB.get(0).getAttribute("class").equalsIgnoreCase("badge invBadgeRed"))
					{
						//click on Submitt button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ConfirmationPopUp_YES_BT));
						System.out.println(driver.findElement(By.xpath("//div[@id='dlgContent']/div/div[2]")).getText());
						if(driver.findElement(By.xpath("//div[@id='dlgContent']/div/div[2]")).getText().trim().contains("There are one or more items that are out of"))
						{
							Reporter.reportPassResult(
									browser,
									"User should be able to view the pop up message",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"User should be able to view the pop up message",
									"Fail");
							AbstractTest.takeSnapShot();
						}
					}
					else
					{
						physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).clear();
						physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).sendKeys(Integer.toString(Base.generateNdigitRandomNumber(3)));
						//click on Submit button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ConfirmationPopUp_YES_BT));
						if(driver.findElement(By.xpath("//div[@id='dlgContent']/div/div[2]")).getText().trim().contains("There are one or more items that are out of"))
						{
							Reporter.reportPassResult(
									browser,
									"User should be able to view the pop up message",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"User should be able to view the pop up message",
									"Fail");
							AbstractTest.takeSnapShot();
						}
						
					}
					
					
					
								
				}
			

	//TC_PI_34 : Verify that the updated count is visible in inventory history section after submitting physical inventory


				@Test()
				public void physicalInventory_34() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_34";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value1=Integer.toString(Base.generateNdigitRandomNumber(2));
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Create a Physical inventory
					GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
					//Get the WrinId for the first record
					String wrindID=physicalInventoryPage.DailyInventory_PopUp_WRIN_Value.get(0).getText().trim();
					//Enter the loose Unit value for the first record
					physicalInventoryPage.DailyInventoryPopUp_LooseUnitsQty_TB_List.get(0).sendKeys(value1);
					//Fetch the item total value for the first record
					Thread.sleep(1500);
					String expItemTotal=physicalInventoryPage.DailyInventory_PopUp_ItemTotal_Value.get(0).getText().trim();
					//Submit the Inventory
					GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
					if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
					}
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
					Thread.sleep(3000);
					//Now Go to the Inventory History and search the wrin
					physicalInventoryPage.InventoryHistory_BT.click();
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.InventoryHistory_Title));
					//Search the wrin ID
					Thread.sleep(2000);
					physicalInventoryPage.InventoryHistory_Search_TB.sendKeys(wrindID);
					Thread.sleep(2000);
					//Verify that added record is displaying
					if(Base.isElementDisplayed(By.xpath("//table[@id='historyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrindID+"')]/../following-sibling::td[5]/span[text()='"+value1+"']/../following-sibling::td[1]/span[text()='"+expItemTotal+"']")))
					{
						
						Reporter.reportPassResult(
								browser,
								"User should be able to find the updated entry against raw item X",
								"Pass");
					
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to find the updated entry against raw item X",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
						
					
								
				}	

	//TC_PI_37 : Verify that  user is able to save data using tab while doing manual edit on physical inventory page

				@Test()
				public void physicalInventory_37() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_37";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value1="5";
					String value2="6";
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					//Select All cable WRINs option
					Select select =new Select(physicalInventoryPage.Wrin_DD);
					select.selectByIndex(1);
					Thread.sleep(2000);
					//fetch the WRIN ID of first record
					String Wrin=driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]/span")).getText().trim();
					//click on the first record and wait for the preview page to be opened
					GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
					//Enter the case value
					GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
					GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value1);
					//click on save button
					GenericMethods.clickOnElement(physicalInventoryPage.Preview_Save_BT, "physicalInventoryPage.Preview_Save_BT");
					Thread.sleep(3000);
					//Again click on the same raw
					GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td[2]/span[contains(.,'"+Wrin+"')]")), "Same raw which is opened in last step");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
					//Fetch the existing value
					String previousValue=driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText();
					//Enter the case value
					GenericMethods.clearValueOfElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB");
					GenericMethods.enterValueInElement(physicalInventoryPage.Preview_Case_TB, "physicalInventoryPage.Preview_Case_TB", value2);
					System.out.println(" first "+driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText());
					//Click the tab button 3 times
					physicalInventoryPage.Preview_Case_TB.sendKeys(Keys.TAB);
					Thread.sleep(1500);
					physicalInventoryPage.Preview_Loose_TB.sendKeys(Keys.TAB);
					Thread.sleep(3000);
					//click on the first record and wait for the preview page to be opened
					GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr[1]/td[2]")), "First Raw of Physical Inventory Page");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='Preview']")));
					System.out.println("Second "+Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2))));
					//Verify that value is updated in preview section
					if(driver.findElement(By.xpath("//strong[text()='Preview']/../../following-sibling::div[1]/div[1]/span")).getText().equalsIgnoreCase(Integer.toString((Integer.parseInt(previousValue)+Integer.parseInt(value2)))))
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to view the updated case value against raw item X",
								"Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to view the updated case value against raw item X",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
								
				}
			



//TC PI_39 : Verify that perpetual inventory count is getting updated on RII page once user is submitting count as inventory.


				@Test()
				public void physicalInventory_39() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_39";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value1=Integer.toString(Base.generateNdigitRandomNumber(2));
					String date=Base.returnTodayDate();
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Create a Physical inventory
					GenericMethods.clickOnElement(physicalInventoryPage.DailyInventory_BT, "DailyInventory_BT");
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventoryPopUp_Title));
					//Get the WrinId for the first record
					String wrindID=physicalInventoryPage.DailyInventory_PopUp_WRIN_Value.get(0).getText().trim();
					//Enter the loose Unit value for the first record
					physicalInventoryPage.DailyInventoryPopUp_LooseUnitsQty_TB_List.get(0).sendKeys(value1);
					//Fetch the item total value for the first record
					Thread.sleep(1500);
					//Submit the Inventory
					GenericMethods.clickOnElement(physicalInventoryPage.DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
					if(Base.isElementDisplayed(physicalInventoryPage.ConfirmationPopUp_YES_BT)){
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
					}
					wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG));
					Thread.sleep(7000);
					//Now Go to the Raw Item Activity page and search the wrin
					RawItemActivityPage rawItemActivityPage=homePage.goToRawItemActivityPage();		
					rawItemActivityPage.searchAndSelectWRINID(wrindID);
					Thread.sleep(3000);
					//verify the on hand amount
					if(rawItemActivityPage.verifyInventoryOnHandCountMatchedForSelectedDate(date, value1+".00", "Each"))
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to find the updated on hand count for raw item X",
								"Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to find the updated on hand count for raw item X",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
						
					
								
				}	


//TC PI_41 : Verify that user is able to submit counts as physical inventory even when the range indicator color is red or yellow..



				@Test()
				public void physicalInventory_41() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_41";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String value1=Integer.toString(Base.generateNdigitRandomNumber(2));
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Click on Daily Inventory button
					physicalInventoryPage.DailyInventory_BT.click();
					//Enter case value for the first wrin ID
					physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).sendKeys(value1);
					//Verify that red button is enabled against WRIN id
					if(physicalInventoryPage.DailyInventory_PopUp_RangeIndicator_RB.get(0).getAttribute("class").equalsIgnoreCase("badge invBadgeRed"))
					{
						//click on Submit button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ConfirmationPopUp_YES_BT));
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "physicalInventoryPage.ConfirmationPopUp_YES_BT");
						if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG, "physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG"))
						{
							Reporter.reportPassResult(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Fail");
							AbstractTest.takeSnapShot();
						}
					}
					else
					{
						physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).clear();
						physicalInventoryPage.DailyInventoryPopUp_CaseQty_TB_List.get(0).sendKeys(Integer.toString(Base.generateNdigitRandomNumber(3)));
						//click on Submit button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "physicalInventoryPage.ConfirmationPopUp_YES_BT");
						if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG, "physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG"))
						{
							Reporter.reportPassResult(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Fail");
							AbstractTest.takeSnapShot();
						}
					}
					

				}



//TC PI_42 : Verify the presence of filter WRIN,Temperature zone and range indicator.



				@Test()
				public void physicalInventory_42() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_42";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Verify the presence of filter WRIN,Temperature zone and range indicator
					if(GenericMethods.isElementDisplayed(physicalInventoryPage.Wrin_DD, "Wrin_DD")
					&& GenericMethods.isElementDisplayed(physicalInventoryPage.TemperatureZone_DD, "TemperatureZone_DD")
					&& GenericMethods.isElementDisplayed(physicalInventoryPage.RangeIndicator_DD, "RangeIndicator_DD"))
					{
						Reporter.reportPassResult(
								browser,
								"User should be able to view the expected filter options",
								"Pass");
					}
					else
					{
						Reporter.reportTestFailure(
								browser,
								"User should be able to view the expected filter options",
								"Fail");
						AbstractTest.takeSnapShot();
					}
					
					

				}



//TC PI_45 : Verify that the user is able to submit daily inventory


				@Test()
				public void physicalInventory_45() throws RowsExceededException,
						BiffException, WriteException, IOException, InterruptedException 
				{
					/** Variable Section : **/
					AbstractTest.tcName="physicalInventory_45";
					String password = LoginTestData.password;
					String userId = LoginTestData.userId;
					String storeId = LoginTestData.StoreId;
					String wrin =GlobalVariable.wrinWithAllTypes;
					String value1=Integer.toString(Base.generateNdigitRandomNumber(2));
					String value2=Integer.toString(Base.generateNdigitRandomNumber(2));
					/***********************************/
					HomePage homePage = PageFactory.initElements(driver, HomePage.class);
					PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
							.goToPhysicalInventoryPage();
					Thread.sleep(2000);
					//Click on Daily Inventory button
					physicalInventoryPage.DailyInventory_BT.click();
					Thread.sleep(3000);
					//Enter case value for the first wrin ID
					GenericMethods.enterValueInElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[2]//input[@colname='case_count_input']")), "Case Price text box", value1);
					Thread.sleep(2000);
					GenericMethods.enterValueInElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[3]//input[@colname='pack_count_input']")), "Pack text box", value2);
					//Verify that red button is enabled against WRIN id
					if(physicalInventoryPage.DailyInventory_PopUp_RangeIndicator_RB.get(0).getAttribute("class").equalsIgnoreCase("badge invBadgeRed"))
					{
						//click on Submit button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ConfirmationPopUp_YES_BT));
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "physicalInventoryPage.ConfirmationPopUp_YES_BT");
						if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG, "physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG"))
						{
							Reporter.reportPassResult(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Fail");
							AbstractTest.takeSnapShot();
						}
					}
					else
					{
						GenericMethods.clearValueOfElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[2]//input[@colname='case_count_input']")), "Case Price text box");
						GenericMethods.enterValueInElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[2]//input[@colname='case_count_input']")), "Case Price text box", value1);
						Thread.sleep(2000);
						GenericMethods.clearValueOfElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[3]//input[@colname='pack_count_input']")), "Pack text box");
						GenericMethods.enterValueInElement(driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span[contains(.,'"+wrin+"')]/../following-sibling::td[3]//input[@colname='pack_count_input']")), "Pack text box", value2);
						
						//click on Submit button 
						physicalInventoryPage.DailyInventoryPopUp_Submit_BT.click();
						wait.until(ExpectedConditions.visibilityOf(physicalInventoryPage.ConfirmationPopUp_YES_BT));
						GenericMethods.clickOnElement(physicalInventoryPage.ConfirmationPopUp_YES_BT, "physicalInventoryPage.ConfirmationPopUp_YES_BT");
						if(GenericMethods.isElementDisplayed(physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG, "physicalInventoryPage.DailyInventorySubmitted_Confirmation_MSG"))
						{
							Reporter.reportPassResult(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Pass");
						}
						else
						{
							Reporter.reportTestFailure(
									browser,
									"Physical Inventory Submit confirmation message should display",
									"Fail");
							AbstractTest.takeSnapShot();
						}
						
					}
					

				}












}
