package UserStoriesWithoutBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.PromotionsAndWastePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.VarianceStatPage;

public class US1587_SSOGetEIDEmployeeIDAndRoleInToken extends AbstractTest{
	
	//TC2846 : Verify that the user is able to login as Level 1 user through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2846() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2846";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 1 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 1 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2847 : Verify that the user is able to login as Level 2 user through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2847() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2847";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 2 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 2 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	//TC2848 : Verify that the user is able to login as Level 3 user through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2848() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2848";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 3 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 3 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2849 : Verify that the user is able to login as Level 4 user through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2849() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2849";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 4 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 4 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2850 : Verify that the user is able to login as Level 5 user through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2850() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2850";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 5 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 5 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2851 : Verify that the user is able to login as Level 6 user through SSO login.
	@Test(groups="Smoke")
	public void UserStoriesWithoutBundle_US1587_TC2851() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2851";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
				//.selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as level 6 user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as level 6 user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2852 : Verify,"Transfer Page is accessible from the Main Menu".
	@Test(groups="Smoke")
	public void UserStoriesWithoutBundle_US1587_TC2852() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2852";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		Thread.sleep(5000);
		if (Base.isElementDisplayed(homePage.HomePage_Title)
				& homePage.SelectedLocation_Label.getText().equals(storeId)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as operator user",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as operator user",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2853 : Verify that the user is able to login as Supervisor  through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2853() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2853";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
				//.selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as Supervisor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as Supervisor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Supervisor with role assignment  through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2854() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2854";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
				//.selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as Supervisor with role assignment",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as Supervisor with role assignment",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC2855() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC2855";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		//String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password);
				//.selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(homePage.HomePage_Title)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to login as Org Admin",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to login as Org Admin",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should not be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should not be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		if (!Base.isElementDisplayed(homePage.Transfers_BT)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should not be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should not be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4381_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4381_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferlandingpage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToTransferLandingPage();
		if (Base.isElementDisplayed(transferlandingpage.TransferLandingPage_Label)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to TransferLanding Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to TransferLanding Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4382_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4382_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Promotion and waste page
		PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPromotionsAndWastePage();
		if (Base.isElementDisplayed(promotionsAndWastePage.PromotionAndWaste_Title)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to Promotion and Waste Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to Promotion and Waste Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		if (!Base.isElementDisplayed(homePage.Purchases_BT)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should not be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should not be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		if (!Base.isElementDisplayed(homePage.Purchases_BT)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should not be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should not be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4383_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4383_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Purchases Landing Page
		PurchasesPage purchasePage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		if (Base.isElementDisplayed(purchasePage.Purchases_Label)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to Raw Item Activity Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to Raw Item Activity Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4384_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4384_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Raw Item Activity Page
		RawItemActivityPage rawitemactivitypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToRawItemActivityPage();
		if (Base.isElementDisplayed(rawitemactivitypage.RawItemActivity_Title)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to Purchases Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to Purchases Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4385_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4385_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Variance Stat Page
		VarianceStatPage varianceStatPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToVarianceStatPage();
		if (Base.isElementDisplayed(varianceStatPage.StateVariance_Label)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to variance Stat Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to variance Stat Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level1";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 1 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 1 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level2() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level2";
		String password = LoginTestData.level2_SSO_Password;
		String userId = LoginTestData.level2_SSO_UserId;
		String storeId = LoginTestData.level2StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 2 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 2 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level3() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level3";
		String password = LoginTestData.level3_SSO_Password;
		String userId = LoginTestData.level3_SSO_UserId;
		String storeId = LoginTestData.level3StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 3 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 3 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level4() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level4";
		String password = LoginTestData.level4_SSO_Password;
		String userId = LoginTestData.level4_SSO_UserId;
		String storeId = LoginTestData.level4StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 4 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 4 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level5() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level5";
		String password = LoginTestData.level5_SSO_Password;
		String userId = LoginTestData.level5_SSO_UserId;
		String storeId = LoginTestData.level5StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 5 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 5 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Level6() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Level6";
		String password = LoginTestData.level6_SSO_Password;
		String userId = LoginTestData.level6_SSO_UserId;
		String storeId = LoginTestData.level6StoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Level 6 User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Level 6 User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Operator";
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"Operator User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Operator User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_Supervisor";
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_SupervisorWithRoleAssignment";
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"supervisor with role assigment User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisor with role assigment User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC2854 : Verify that the user is able to login as Org Admin through SSO login.
	@Test()
	public void UserStoriesWithoutBundle_US1587_TC4386_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException 
	{
		/** Variable Section : **/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1587_TC4386_OrgAdmin";
		String password = LoginTestData.orgAdmin_SSO_Password;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String storeId = LoginTestData.orgAdminStoreId;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		//Navigate to Physcial Inventory Page
		PhysicalInventoryPage physicalinventorypage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPhysicalInventoryPage();
		if (Base.isElementDisplayed(physicalinventorypage.PhysicalInventoryPage_Title)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to navigate  to Physcial Inventory Page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to navigate  to Physcial Inventory Page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
