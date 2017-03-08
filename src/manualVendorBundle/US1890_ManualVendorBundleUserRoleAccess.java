package manualVendorBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GenericMethods;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.AbstractPage;
import eInventoryPageClasses.AbstractTest;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualVendorsPage;

public class US1890_ManualVendorBundleUserRoleAccess extends AbstractTest {
	
	/*TC3055 To verify that the user with Supervisor/ Supervisor with Role
	 Assignment/Level 1/ Operator/Org Admin Access is able to add a manual vendor.*/
	@Test(enabled=false)
	public void manualVendor_US1890_TC3055_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3055_Supervisor";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String supervisorVendorName = "supervisor" + Base.generateNdigitRandomNumber(4);
		String supervisorManualNumber="supervisor"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page(Supervisor Access)
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(Supervisor Access)
		manualVendorsPage.createANewVendor(supervisorVendorName,supervisorManualNumber);
		//verify that Supervisor is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(supervisorVendorName),supervisorVendorName)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void manualVendor_US1890_TC3055_SupervisorWithRoleAssignment()
			throws InterruptedException, RowsExceededException, BiffException,WriteException, IOException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3055_SupervisorWithRoleAssignment";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String supervisorWithRoleAssignmentVendorName = "supervisorWithRoleAssignment" + Base.generateNdigitRandomNumber(4);
		String supervisorWithRoleAssignmentManualNumber="supervisorWithRoleAssignment"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		// Navigate to Manual Vendor page(supervisorWithRoleAssignmentStoreId Access)
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId).goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(supervisorWithRoleAssignmentStoreId Access)
		manualVendorsPage.createANewVendor(supervisorWithRoleAssignmentVendorName,supervisorWithRoleAssignmentManualNumber);
		//verify that Supervisor is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(supervisorWithRoleAssignmentVendorName),supervisorWithRoleAssignmentVendorName))  {
			Reporter.reportPassResult(
					browser,
					"supervisorWithRoleAssignmentStoreId User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisorWithRoleAssignmentStoreId User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void manualVendor_US1890_TC3055_Level1()
			throws InterruptedException, RowsExceededException, BiffException,
			WriteException, IOException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3055_Level1";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String level1rVendorName = "level1" + Base.generateNdigitRandomNumber(4);
		String level1ManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		// Navigate to Manual Vendor page(level1 Access)
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(level1 Access)
		manualVendorsPage.createANewVendor(level1rVendorName,level1ManualNumber);
		//verify that level1 is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(level1rVendorName),level1rVendorName))  {
			Reporter.reportPassResult(
					browser,
					"level1 User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"level1 User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

	@Test()
	public void manualVendor_US1890_TC3055_Operator()
			throws InterruptedException, RowsExceededException, BiffException,WriteException, IOException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3055_Operator";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String operatorVendorName = "operator" + Base.generateNdigitRandomNumber(4);
		String operatorManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		// Navigate to Manual Vendor page(operator Access)
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(operator Access)
		manualVendorsPage.createANewVendor(operatorVendorName,operatorManualNumber);
		//verify that operator is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(operatorVendorName),operatorVendorName))  {
			Reporter.reportPassResult(
					browser,
					"operator User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"operator User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

	@Test()
	public void manualVendor_US1890_TC3055_OrgAdmin()
			throws InterruptedException, RowsExceededException, BiffException,WriteException, IOException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3055_OrgAdmin";
		ManualVendorsPage manualVendorsPage;
		String orgAdminStoreId = LoginTestData.orgAdminStoreId;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String orgAdminVendorName = "orgAdmin" + Base.generateNdigitRandomNumber(4);
		String orgAdminManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		// Navigate to Manual Vendor page(orgAdmin Access)
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(orgAdminStoreId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor(orgAdmin Access)
		manualVendorsPage.createANewVendor(orgAdminVendorName,orgAdminManualNumber);
		//verify that orgAdmin is able to add new manual vendor
		if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(orgAdminVendorName),orgAdminVendorName))  {
			Reporter.reportPassResult(
					browser,
					"orgAdmin User should be able to add a manual vendor",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin User should be able to add a manual vendor",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3056 To verify that the user with Supervisor/ Supervisor with Role Assignment/Level 1/ Operator/Org Admin Access  is able to edit and delete a manual vendor.
	@Test(enabled=false)
	public void manualVendor_US1890_TC3056_Supervisor() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3056_Supervisor";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.supervisor_SSO_Password;
		String userId = LoginTestData.supervisor_SSO_UserId;
		String storeId = LoginTestData.supervisorStoreId;
		String supervisorVendorName = "supervisor" + Base.generateNdigitRandomNumber(4);
		String supervisorManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(supervisorVendorName,supervisorManualNumber);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(supervisorVendorName)));
		Thread.sleep(5000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(supervisorVendorName);
		GenericMethods.clickOnElement(vendor,supervisorVendorName);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title)),"EditVendorDetails_Title");
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//Verify that user should be able to view the confirmation message
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message,"DeleteVendorPopUp_Confirmation_Message");
		System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
		Thread.sleep(4000);
		//verify that Supervisor is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(supervisorVendorName)) {
			Reporter.reportPassResult(
					browser,
					"Supervisor should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Supervisor should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void manualVendor_US1890_TC3056_SupervisorWithRoleAssignment() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3056_SupervisorWithRoleAssignment";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String supervisorWithRoleAssignmentVendorName = "supervisorWithRoleAssignment" + Base.generateNdigitRandomNumber(4);
		String supervisorWithRoleAssignmentManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(supervisorWithRoleAssignmentVendorName,supervisorWithRoleAssignmentManualNumber);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(supervisorWithRoleAssignmentVendorName)));
		Thread.sleep(5000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(supervisorWithRoleAssignmentVendorName);
		GenericMethods.clickOnElement(vendor,supervisorWithRoleAssignmentVendorName);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title)),"EditVendorDetails_Title");
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//Verify that user should be able to view the confirmation message
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message,"DeleteVendorPopUp_Confirmation_Message");
		System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
		Thread.sleep(4000);
		//verify that supervisorWithRoleAssignment is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(supervisorWithRoleAssignmentVendorName)) {
			Reporter.reportPassResult(
					browser,
					"supervisorWithRoleAssignment should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"supervisorWithRoleAssignment should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	@Test()
	public void manualVendor_US1890_TC3056_Level1() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3056_Level1";
		ManualVendorsPage manualVendorsPage;
		String userId = LoginTestData.level1_SSO_UserId;
		String password = LoginTestData.level1_SSO_Password;
		String storeId = LoginTestData.level1StoreId;
		String level1rVendorName = "level1" + Base.generateNdigitRandomNumber(4);
		String level1ManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(level1rVendorName,level1ManualNumber);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(level1rVendorName)));
		Thread.sleep(5000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(level1rVendorName);
		AbstractPage.executor.executeScript("arguments[0].scrollIntoView(true);", vendor);
		/*action.moveToElement(vendor).perform();*/
		Thread.sleep(500); 
		GenericMethods.clickOnElement(vendor,level1rVendorName);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title)),"EditVendorDetails_Title");
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//Verify that user should be able to view the confirmation message
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message,"DeleteVendorPopUp_Confirmation_Message");
		System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
		Thread.sleep(4000);
		//verify that level1 is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(level1rVendorName)) {
			Reporter.reportPassResult(
					browser,
					"level1 should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"level1 should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void manualVendor_US1890_TC3056_Operator() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3056_Operator";
		ManualVendorsPage manualVendorsPage;
		String password = LoginTestData.operator_SSO_Password;
		String userId = LoginTestData.operator_SSO_UserId;
		String storeId = LoginTestData.operatorStoreId;
		String operatorVendorName = "operator" + Base.generateNdigitRandomNumber(4);
		String operatorManualNumber= Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(operatorVendorName,operatorManualNumber);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(operatorVendorName)));
		Thread.sleep(5000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(operatorVendorName);
		GenericMethods.clickOnElement(vendor,operatorVendorName);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title)),"EditVendorDetails_Title");
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//Verify that user should be able to view the confirmation message
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message,"DeleteVendorPopUp_Confirmation_Message");
		System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
		Thread.sleep(4000);
		//verify that operator is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(operatorVendorName)) {
			Reporter.reportPassResult(
					browser,
					"operator should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"operator should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	@Test()
	public void manualVendor_US1890_TC3056_OrgAdmin() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="manualVendor_US1890_TC3056_OrgAdmin";
		ManualVendorsPage manualVendorsPage;
		String orgAdminStoreId = LoginTestData.orgAdminStoreId;
		String userId = LoginTestData.orgAdmin_SSO_UserId;
		String password = LoginTestData.orgAdmin_SSO_Password;
		String orgAdminVendorName = "orgAdmin" + Base.generateNdigitRandomNumber(4);
		String orgAdminManualNumber="orgAdmin"+Integer.toString(Base.generateNdigitRandomNumber(3));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		// Navigate to Manual Vendor page
		manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(orgAdminStoreId)
				.goToManualVendorsPage();
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
		//Create a new vendor
		manualVendorsPage.createANewVendor(orgAdminVendorName,orgAdminManualNumber);
		wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(orgAdminVendorName)));
		Thread.sleep(5000);
		// Click on the edit vendor button
		WebElement vendor=manualVendorsPage.editVendor_BT(orgAdminVendorName);
		GenericMethods.clickOnElement(vendor,orgAdminVendorName);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title)),"EditVendorDetails_Title");
		//click on delete button
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
		//Verify that user should be able to view the confirmation message
	    GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
		boolean deleteVendorConfirmationDisplayed = GenericMethods.isElementDisplayed(manualVendorsPage.DeleteVendorPopUp_Confirmation_Message,"DeleteVendorPopUp_Confirmation_Message");
		System.out.println("deleteVendorConfirmationDisplayed"+deleteVendorConfirmationDisplayed);
		Thread.sleep(4000);
		//verify that orgAdmin is able to delete the manual vendor
		if (deleteVendorConfirmationDisplayed & manualVendorsPage.verifyVendorDeleted(orgAdminVendorName)) {
			Reporter.reportPassResult(
					browser,
					"orgAdmin should be able to delete the manual purchase vendor.",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"orgAdmin should be able to delete the manual purchase vendor.",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}
	
	//TC3058: 	To verify that the user with Supervisor/ Supervisor with Role Assignment/Level 1/ Operator/Org Admin Access is able to restore a deleted manual vendor.
			@Test(enabled=false)
			public void manualVendor_US1890_TC3058_Supervisor() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3058_Supervisor";
				ManualVendorsPage manualVendorsPage;
				String password = LoginTestData.supervisor_SSO_Password;
				String userId = LoginTestData.supervisor_SSO_UserId;
				String storeId = LoginTestData.supervisorStoreId;
				String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
				String newVendorName = "Testauto" + randomNum;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Manual Vendor page
				manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Create a new vendor
				manualVendorsPage.createANewVendor(newVendorName, randomNum);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
				Thread.sleep(5000);
				//click on edit button for the vendor
				GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
				//click on submit button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message)),"DeleteVendorPopUp_VendorDeleted_Message");
				Thread.sleep(7000);
				manualVendorsPage.restoreManualVendor(newVendorName);
				// verify that Supervisor is able to restore deleted manual vendor
				if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),newVendorName)) {
					Reporter.reportPassResult(
							browser,
							"Supervisor is able to restore deleted manual vendor", "Pass");
				} else {
					Reporter.reportTestFailure(
							browser,
							"Supervisor is able to restore deleted manual vendor", "Fail");
					AbstractTest.takeSnapShot();
				}
			}
			
			@Test()
			public void manualVendor_US1890_TC3058_SupervisorWithRoleAssignment() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3058_SupervisorWithRoleAssignment";
				ManualVendorsPage manualVendorsPage;
				String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
				String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
				String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
				String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
				String newVendorName = "Testauto" + randomNum;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Manual Vendor page
				manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Create a new vendor
				manualVendorsPage.createANewVendor(newVendorName, randomNum);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
				Thread.sleep(5000);
				//click on edit button for the vendor
				GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
				//click on submit button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
				//GenericMethods.clickOnElement(wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message)),"DeleteVendorPopUp_VendorDeleted_Message");
				Thread.sleep(7000);
				manualVendorsPage.restoreManualVendor(newVendorName);
				// verify that SupervisorWithRoleAssignment is able to restore deleted manual vendor
				if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),newVendorName)) {
					Reporter.reportPassResult(
							browser,
							"SupervisorWithRoleAssignment is able to restore deleted manual vendor", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"SupervisorWithRoleAssignment is able to restore deleted manual vendor", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
			
			@Test()
			public void manualVendor_US1890_TC3058_Level1() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3058_Level1";
				ManualVendorsPage manualVendorsPage;
				String userId = LoginTestData.level1_SSO_UserId;
				String password = LoginTestData.level1_SSO_Password;
				String storeId = LoginTestData.level1StoreId;
				String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
				String newVendorName = "Testauto" + randomNum;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Manual Vendor page
				manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId).goToManualVendorsPage();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Create a new vendor
				manualVendorsPage.createANewVendor(newVendorName, randomNum);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
				Thread.sleep(5000);
				//click on edit button for the vendor
				GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
				//click on submit button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
				Thread.sleep(7000);
				manualVendorsPage.restoreManualVendor(newVendorName);
				// verify that level1 is able to restore deleted manual vendor
				if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),"newVendorName")) {
					Reporter.reportPassResult(
							browser,
							"level1 is able to restore deleted manual vendor", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"level1 is able to restore deleted manual vendor", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
			
			@Test()
			public void manualVendor_US1890_TC3058_Operator() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3058_Operator";
				ManualVendorsPage manualVendorsPage;
				String password = LoginTestData.operator_SSO_Password;
				String userId = LoginTestData.operator_SSO_UserId;
				String storeId = LoginTestData.operatorStoreId;
				String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
				String newVendorName = "Testauto" + randomNum;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Manual Vendor page
				manualVendorsPage =  homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(storeId)
						.goToManualVendorsPage();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Create a new vendor
				manualVendorsPage.createANewVendor(newVendorName, randomNum);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
				Thread.sleep(5000);
				//click on edit button for the vendor
				GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
				//click on submit button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
				Thread.sleep(7000);
				manualVendorsPage.restoreManualVendor(newVendorName);
				// verify that Operator is able to restore deleted manual vendor
				if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),"newVendorName")) {
					Reporter.reportPassResult(
							browser,
							"Operator is able to restore deleted manual vendor", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"Operator is able to restore deleted manual vendor", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	
			
			
			@Test()
			public void manualVendor_US1890_TC3058_OrgAdmin() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3058_OrgAdmin";
				ManualVendorsPage manualVendorsPage;
				String orgAdminStoreId = LoginTestData.orgAdminStoreId;
				String userId = LoginTestData.orgAdmin_SSO_UserId;
				String password = LoginTestData.orgAdmin_SSO_Password;
				String randomNum = String.valueOf(Base.generateNdigitRandomNumber(4));
				String newVendorName = "Testauto" + randomNum;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to Manual Vendor page
				manualVendorsPage = homePage.selectUserWithSSOLogin(userId, password)
						.selectLocation(orgAdminStoreId)
						.goToManualVendorsPage();
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.AddVendor_BT));
				// Create a new vendor
				manualVendorsPage.createANewVendor(newVendorName, randomNum);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.VendorName_Row(newVendorName)));
				Thread.sleep(5000);
				//click on edit button for the vendor
				GenericMethods.clickOnElement(manualVendorsPage.editVendor_BT(newVendorName),newVendorName);
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.EditVendorDetails_Title));
				//click on delete button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.Delete_BT)),"Delete_BT");
				//click on submit button
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(manualVendorsPage.DeleteVendorConfirmationPopUp_Yes_BT)),"DeleteVendorConfirmationPopUp_Yes_BT");
				wait.until(ExpectedConditions.visibilityOf(manualVendorsPage.DeleteVendorPopUp_VendorDeleted_Message));
				Thread.sleep(7000);
				manualVendorsPage.restoreManualVendor(newVendorName);
				// verify that OrgAdmin is able to restore deleted manual vendor
				if (GenericMethods.isElementDisplayed(manualVendorsPage.VendorName_Row(newVendorName),"newVendorName")) {
					Reporter.reportPassResult(
							browser,
							"OrgAdmin is able to restore deleted manual vendor", "Pass");
					

				} else {
					Reporter.reportTestFailure(
							browser,
							"OrgAdmin is able to restore deleted manual vendor", "Fail");
					AbstractTest.takeSnapShot();
					
				}
			}	

			//TC3059: Level 2, Level 3, Level 4, Level 5, Level 6  users will not have access to the manual vendors page.
			@Test()
			public void manualVendor_US1890_TC3059_Level2() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3059_Level2";
				String password = LoginTestData.level2_SSO_Password;
				String userId = LoginTestData.level2_SSO_UserId;
				String storeId = LoginTestData.level2StoreId;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to inventory management
				homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId);
				//click on other inventory functions link
				Thread.sleep(3000);
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)),"Menu_DD_BT");
				//verify that user should not be able to access manual vendor page
				if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
					Reporter.reportTestFailure(
							browser,
							"level 2 user should be restricted to view the manual vendor page",
							"Fail");
					AbstractTest.takeSnapShot();
					
				} else {
					Reporter.reportPassResult(
							browser,
							"level 2 user should be restricted to view the manual vendor page","Pass");
				}
			}	
			
			@Test()
			public void manualVendor_US1890_TC3059_Level3() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3059_Level3";
				String password = LoginTestData.level3_SSO_Password;
				String userId = LoginTestData.level3_SSO_UserId;
				String storeId = LoginTestData.level3StoreId;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to inventory management
				homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId);
				/*homePage.Menu_DD_BT*/
				Thread.sleep(3000);
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)),"Menu_DD_BT");
				//verify that user should not be able to access manual vendor page
				if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
					Reporter.reportTestFailure(
							browser,
							"level 3 user should be restricted to view the manual vendor page",
							"Fail");
					AbstractTest.takeSnapShot();
				} else {
					Reporter.reportPassResult(
							browser,
							"level 3 user should be restricted to view the manual vendor page","Pass");
				}
			}	
			
			@Test(enabled=false)
			public void manualVendor_US1890_TC3059_Level4() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3059_Level4";
				String password = LoginTestData.level4_SSO_Password;
				String userId = LoginTestData.level4_SSO_UserId;
				String storeId = LoginTestData.level4StoreId;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to inventory management
				homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId);
				Thread.sleep(3000);
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)),"Menu_DD_BT");
				//verify that user should not be able to access manual vendor page
				if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
					Reporter.reportTestFailure(
							browser,
							"level 4 user should be restricted to view the manual vendor page",
							"Fail");
					AbstractTest.takeSnapShot();
				} else {
					Reporter.reportPassResult(
							browser,
							"level 4 user should be restricted to view the manual vendor page","Pass");
				}
			}	
			
			
			@Test()
			public void manualVendor_US1890_TC3059_Level5() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3059_Level5";
				String password = LoginTestData.level5_SSO_Password;
				String userId = LoginTestData.level5_SSO_UserId;
				String storeId = LoginTestData.level5StoreId;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to inventory management
				homePage.selectUserWithSSOLogin(userId, password)
				.selectLocation(storeId);
				Thread.sleep(3000);
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)),"Menu_DD_BT");
				//verify that user should not be able to access manual vendor page
				if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
					Reporter.reportTestFailure(
							browser,
							"level 5 user should be restricted to view the manual vendor page",
							"Fail");
					AbstractTest.takeSnapShot();
				} else {
					Reporter.reportPassResult(
							browser,
							"level 5 user should be restricted to view the manual vendor page","Pass");
				}
			}	
			
			
			@Test()
			public void manualVendor_US1890_TC3059_Level6() throws RowsExceededException,
					BiffException, WriteException, IOException, InterruptedException {
				/** Variable Section : **/
				AbstractTest.tcName="manualVendor_US1890_TC3059_Level6";
				String password = LoginTestData.level6_SSO_Password;
				String userId = LoginTestData.level6_SSO_UserId;
				String storeId = LoginTestData.level6StoreId;
				/***********************************/
				HomePage homePage = PageFactory.initElements(driver, HomePage.class);
				// Navigate to inventory management
				homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId);
				Thread.sleep(3000);
				GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)),"Menu_DD_BT");
				//verify that user should not be able to access manual vendor page
				if (Base.isElementDisplayed(homePage.ManualVendors_BT)) {
					Reporter.reportTestFailure(
							browser,
							"level 6 user should be restricted to view the manual vendor page",
							"Fail");
					AbstractTest.takeSnapShot();
					
				} else {
					Reporter.reportPassResult(
							browser,
							"level 6 user should be restricted to view the manual vendor page","Pass");
				}
			}	
			
			
}
