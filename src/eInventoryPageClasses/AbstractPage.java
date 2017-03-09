package eInventoryPageClasses;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.GenericMethods;
import common.GlobalVariable;

public class AbstractPage 

{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions action;
	public static JavascriptExecutor executor;
	
	
	 AbstractPage (WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,15);
		action = new Actions(driver);
		executor = (JavascriptExecutor)driver;
	}
	//Method Reporter
		//This method will select a user from user dropdown	 
		public HomePage selectUser(String userId) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
			HomePage homePage = new HomePage(driver);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(homePage.User_DD_BT));
			GenericMethods.clickOnElement(homePage.User_DD_BT,"homePage.User_DD_BT");

			wait.until(ExpectedConditions.visibilityOf(homePage.User_DD));
			GenericMethods.clickOnElement(driver.findElement(By.xpath("//div[@id='user-settings-dropdown']/div/a[text()='"+userId+"']")),"UserID");
//			driver.findElement(By.xpath("//div[@id='user-settings-dropdown']/div/a[text()='"+userId+"']")).click();
			wait.until(ExpectedConditions.visibilityOf(homePage.SelectedUserName_Label));
			return PageFactory.initElements(driver, HomePage.class);
		}
	
	/*//This method will select a user from user dropdown	 
	public HomePage selectUser(String userId) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(homePage.User_DD_BT));
		homePage.User_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.User_DD));
		driver.findElement(By.xpath("//div[@id='user-settings-dropdown']/div/a[text()='"+userId+"']")).click();
		wait.until(ExpectedConditions.visibilityOf(homePage.SelectedUserName_Label));
		return PageFactory.initElements(driver, HomePage.class);
	}*/
	
	// This method will use SSO login to select user for a specific store 
	public HomePage selectUserWithSSOLogin(String userId, String password)
			throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		HomePage homePage = new HomePage(driver);
		/*wait.until(ExpectedConditions.visibilityOf(homePage.User_DD_BT));
		homePage.User_DD_BT.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.User_DD));
		driver.findElement(By.xpath("//ul[@id='user-settings-dropdown']/li/a[text()='SSO Login']")).click();*/
		if(GlobalVariable.loginMode.equals("SSO")){
			homePage.ssoLogin(userId, password);
		}else{
			selectUser(userId);
		}
		return PageFactory.initElements(driver, HomePage.class);
	}
	//Method Reporter
	//This method will select a store from locations dropdown	 
    public HomePage selectLocation(String storeId) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.Locations_DD_BT));
        GenericMethods.clickOnElement(homePage.Locations_DD_BT,"homePage.Locations_DD_BT");
        wait.until(ExpectedConditions.visibilityOf(homePage.Locations_DD));
        GenericMethods.clickOnElement(driver.findElement(By.xpath("//div[@id='store-locations-dropdown']/li/a[contains(text(),'"+storeId+"')]")), "Store ID");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(homePage.HomePage_MonthToDatePerformance_Label));
        Thread.sleep(2000);
        return PageFactory.initElements(driver, HomePage.class);
    }
	
/*	//This method will select a store from locations dropdown	 
	public HomePage selectLocation(String storeId) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(homePage.Locations_DD_BT)).click();
		Reporter.log("Successfully clicked on location dropdown button");
		wait.until(ExpectedConditions.visibilityOf(homePage.Locations_DD));
		driver.findElement(By.xpath("//div[@id='store-locations-dropdown']/li/a[contains(text(),'"+storeId+"')]")).click();
		Reporter.log("clicked on the storeID in the location drop down");
		//wait.until(ExpectedConditions.visibilityOf(homePage.SelectedLocation_Label));
		Thread.sleep(3000);
		return PageFactory.initElements(driver, HomePage.class);
	}*/
	

	// To go to Purchase Landing Page
		public PurchasesPage goToPurchaseLandingPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
		{
			HomePage homePage = new HomePage(driver);
			GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
			GenericMethods.clickOnElement(homePage.Purchases_BT, "homePage.Purchases_BT");
			PurchasesPage purchasePage = new PurchasesPage(driver);
			wait.until(ExpectedConditions.visibilityOf(purchasePage.Purchases_Label));
			return PageFactory.initElements(driver, PurchasesPage.class);
		}
	
		// To go to Menu Item Activity Page
	 public MenuItemActivityAndInformationPage goToMenuItemActivityAndInformationPage() throws InterruptedException
	 {
		 HomePage homePage = new HomePage(driver);
		 wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)).click();
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(homePage.MenuItemActivity_BT));
		 homePage.MenuItemActivity_BT.click();
		 MenuItemActivityAndInformationPage menuItemActivityPage=new MenuItemActivityAndInformationPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(menuItemActivityPage.MenuItemActivityAndInformation_Title));
		 return PageFactory.initElements(driver, MenuItemActivityAndInformationPage.class);
	 }
	 

	// To go to Manual Vendors landing Page
	 public ManualVendorsPage goToManualVendorsPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	 {
		 HomePage homePage = new HomePage(driver);
		 GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(homePage.ManualVendors_BT));
		 GenericMethods.clickOnElement(homePage.ManualVendors_BT, "homePage.ManualVendors_BT");
		 ManualVendorsPage manualVendor=new ManualVendorsPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(manualVendor.ManualVendors_Label));
		 return PageFactory.initElements(driver, ManualVendorsPage.class);
	 }

	 // go to Physical Inventory Page
	public PhysicalInventoryPage goToPhysicalInventoryPage() throws InterruptedException 
	{
		HomePage homePage = new HomePage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homePage.PhysicalInventory_BT));
		homePage.PhysicalInventory_BT.click();
		PhysicalInventoryPage physicalinventorypage = new PhysicalInventoryPage(driver);
		wait.until(ExpectedConditions.visibilityOf(physicalinventorypage.PhysicalInventoryPage_Title));
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}

	 // To go to Promotion and Waste page
	 public PromotionsAndWastePage goToPromotionsAndWastePage() throws InterruptedException
	 {
		 HomePage homePage=new HomePage(driver);
		 wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)).click();
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(homePage.PromotionAndWaste_BT));
		 homePage.PromotionAndWaste_BT.click();
		 PromotionsAndWastePage promotionsAndWastePage=new PromotionsAndWastePage(driver);
		 wait.until(ExpectedConditions.visibilityOf(promotionsAndWastePage.PromotionAndWaste_Title));
		 Thread.sleep(1500);
		 return PageFactory.initElements(driver, PromotionsAndWastePage.class);
	 }

	 // go to Raw Item Activity Page(Created by Akash)
	 public RawItemActivityPage goToRawItemActivityPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	 {
		 HomePage homePage = new HomePage(driver);
		 GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(homePage.RawItemActivity_BT));
		 GenericMethods.clickOnElement(homePage.RawItemActivity_BT, "homePage.RawItemActivity_BT");
		 RawItemActivityPage rawitemactivitypage=new RawItemActivityPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(rawitemactivitypage.RawItemActivity_Title));
		 return  PageFactory.initElements(driver, RawItemActivityPage.class);
	 }

	 // goto Transfer Landing Page(Created by Akash)
	 public TransferLandingPage goToTransferLandingPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	 {
		 HomePage homePage = new HomePage(driver);
		 GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		 Thread.sleep(3000);
		 wait.until(ExpectedConditions.visibilityOf(homePage.Transfers_BT));
		 GenericMethods.clickOnElement(homePage.Transfers_BT,"Transfers_BT");
		 TransferLandingPage transferlandingpage=new TransferLandingPage(driver);
		 wait.until(ExpectedConditions.visibilityOf(transferlandingpage.TransferLandingPage_Label));
		 return  PageFactory.initElements(driver, TransferLandingPage.class);
	 }

	// go to Store Control Settings Page
     public StoreControlSettingsPage goToStoreSettingsPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
     {
         HomePage homePage=new HomePage(driver);
         GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
         Thread.sleep(3000);
         GenericMethods.clickOnElement(homePage.StoreSetting_BT,"StoreSetting_BT");
         StoreControlSettingsPage storeControlSettingsPage=new StoreControlSettingsPage(driver);
         wait.until(ExpectedConditions.visibilityOf(storeControlSettingsPage.InventorySetting_BT));
         return PageFactory.initElements(driver, StoreControlSettingsPage.class);
     }
	 
	// go to Raw Item Information Page(Created by Akash)
	public VarianceStatPage goToVarianceStatPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		HomePage homePage = new HomePage(driver);
		GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homePage.VarianceStat_BT));
		GenericMethods.clickOnElement(homePage.VarianceStat_BT,"VarianceStat_BT");
		VarianceStatPage varianceStatPage = new VarianceStatPage(driver);
		wait.until(ExpectedConditions.visibilityOf(varianceStatPage.StateVariance_Label));
		return PageFactory.initElements(driver, VarianceStatPage.class);
	}
		
		
		// go to Raw Item Information Page
		 public FoodOverBasePage goToFoodOverBasePage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
		 {
			 HomePage homePage = new HomePage(driver);
			 GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
			 Thread.sleep(1500);
			 wait.until(ExpectedConditions.visibilityOf(homePage.FoodOverBase_BT));
			 GenericMethods.clickOnElement(homePage.FoodOverBase_BT, "homePage.FoodOverBase_BT");
			 FoodOverBasePage foodOverBasePage=new FoodOverBasePage(driver);
			 wait.until(ExpectedConditions.visibilityOf(foodOverBasePage.FoodOverBase_Label));
			 return  PageFactory.initElements(driver, FoodOverBasePage.class);
		 }
		 
			// go to Raw Item Information Page
		 public AuditPage goToAuditPage() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
		 {
			 HomePage homePage = new HomePage(driver);
			 GenericMethods.clickOnElement(wait.until(ExpectedConditions.elementToBeClickable(homePage.Menu_DD_BT)), "homePage.Menu_DD_BT");
			 Thread.sleep(1500);
			 wait.until(ExpectedConditions.visibilityOf(homePage.Audit_BT));
			 GenericMethods.clickOnElement(homePage.Audit_BT, "homePage.Audit_BT");
			 AuditPage auditPage=new AuditPage(driver);
			 wait.until(ExpectedConditions.visibilityOf(auditPage.Audit_Label));
			 return  PageFactory.initElements(driver, AuditPage.class);
		 }
		
		public void selectMonthFromDatePicker(String monthName,int calIndex) throws InterruptedException
		{
			Thread.sleep(3000);
			String selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[1]/span")).getText();
			while (!selectedMonth.equals(monthName))
			{
					driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/button[@class='xdsoft_prev']")).click();
					selectedMonth = driver.findElement(By.xpath("(//div[@class='xdsoft_mounthpicker'])["+calIndex+"]/div[contains(@class,'xdsoft_month')]/span")).getText();
					System.out.println("monthName found "+selectedMonth);
			}
		}
		
		public HomePage signOut() throws InterruptedException {
			try {
				GenericMethods.clickOnElement(driver.findElement(By.xpath("//div[@id='signOut']")), "Sign Out");
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='htmlButton']/span[text()='Yes']"))).click();
				AbstractTest.stepValue=AbstractTest.stepValue+1;
				Thread.sleep(5000);
			} catch (Exception e) {}
			return PageFactory.initElements(driver, HomePage.class);
		}
	 
		
}
