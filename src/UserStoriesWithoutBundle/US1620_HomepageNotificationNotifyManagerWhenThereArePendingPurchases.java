package UserStoriesWithoutBundle;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.By;
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
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;

public class US1620_HomepageNotificationNotifyManagerWhenThereArePendingPurchases extends AbstractTest
{
	
	
	
	//TC4531 : Verify the system notification for a new pending manual purchase
	@Test()
	public void UserStoriesWithoutBundle_US1620_TC4531() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
	{
		/**Variable Section :**/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1620_TC4531";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(3000);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		wait.until(ExpectedConditions.visibilityOf(homePage.HomePage_Link)).click();
		wait.until(ExpectedConditions.visibilityOf(homePage.HomePage_Title));
		Thread.sleep(3000);
		//Verify that Manual Invoice XXX message is displaying
		System.out.println("//span[text()='Manual Invoice "+invoiceNumber+" is pending']");
		if(GenericMethods.isElementDisplayed(By.xpath("//span[text()='Manual Invoice "+invoiceNumber+" is pending']"), "Manual Invoice message"))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Verbiage message Manual Invoice Invoice Number is pending.","Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Verbiage message Manual Invoice Invoice Number is pending",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
	//TC4533 : Verify that system notification is getting removed after all pending manual invoices are approved
	
	
	@Test()
	public void UserStoriesWithoutBundle_US1620_TC4533() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException 
	{
		/**Variable Section :**/
		AbstractTest.tcName="UserStoriesWithoutBundle_US1620_TC4533";
		String userId = LoginTestData.userId;
		String password = LoginTestData.password;
		String storeId = LoginTestData.StoreId;
		String vendorName=GlobalVariable.vendorName;
		String wrin=GlobalVariable.createPurchaseWrin;
		String invoiceNumber=Integer.toString(Base.generateNdigitRandomNumber(4));
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(3000);
		manualInvoiceNewPage.createAManualPurchase(vendorName, invoiceNumber, wrin,"2","3");
		Thread.sleep(1500);
		purchasesPage.approveAManualInvoice(invoiceNumber);
		Thread.sleep(1500);
		GenericMethods.clickOnElement(homePage.Menu_DD_BT, "homePage.Menu_DD_BT");
		wait.until(ExpectedConditions.visibilityOf(homePage.HomePage_Link)).click();
		wait.until(ExpectedConditions.visibilityOf(homePage.HomePage_Title));
		Thread.sleep(3000);
		//Verify that Manual Invoice XXX message is displaying
		System.out.println("//span[text()='Manual Invoice "+invoiceNumber+" is pending']");
		if(!Base.isElementDisplayed(By.xpath("//span[text()='Manual Invoice "+invoiceNumber+" is pending']")))
		{
			Reporter.reportPassResult(
					browser,
					"User should be able to view the Verbiage message Manual Invoice Invoice Number is pending.","Pass");
		}
		else
		{
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the Verbiage message Manual Invoice Invoice Number is pending",
					"Fail");
			AbstractTest.takeSnapShot();
		}
		
	}
	
	
}
