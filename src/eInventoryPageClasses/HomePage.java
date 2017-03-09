package eInventoryPageClasses;


import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import common.Base;
import common.GenericMethods;


public class HomePage extends AbstractPage

{
	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@id='user-settings']/a[@class='add_nsn dropdown-toggle']")
	public WebElement User_DD_BT;
	
	@FindBy(id="user-settings-dropdown")
	public WebElement User_DD;
	
	@FindBy(xpath="//span[@id='eid_name']")
	public WebElement SelectedUserName_Label;
	
	@FindBy(xpath="//div[@id='location-settings']/a")
	public WebElement Locations_DD_BT;
	
	@FindBy(id="store-locations-dropdown")
	public WebElement Locations_DD;
	
	@FindBy(xpath="//span[@id='nsn']")
	public WebElement SelectedLocation_Label;
	
	@FindBy(xpath="//nav[@id='topLevelNav']/div/div/a[@id='nav_menu_fa']")
	public WebElement Menu_DD_BT;
	
	@FindBy(xpath="//ul[contains(@class,'globalNavPrimaryLinks')]/li/a[text()='Physical Inventory']")  
	public WebElement PhysicalInventory_BT;
	
	@FindBy(xpath="//ul[contains(@class,'globalNavPrimaryLinks')]/li/a[text()='Transfers']")
	public WebElement Transfers_BT; 
	
	@FindBy(xpath="//ul[contains(@class,'globalNavPrimaryLinks')]/li/a[text()='Purchases']")
	public WebElement Purchases_BT;
	
	@FindBy(xpath="//ul[contains(@class,'globalNavPrimaryLinks')]/li/a[text()='Promotions & Waste']")
	public WebElement PromotionAndWaste_BT; 
	
	@FindBy(xpath="//ul[contains(@class,'globalNavSecondaryLinks')]/li/a[text()='Menu Item Information & Activity']")
	public WebElement MenuItemActivity_BT; 
	
	@FindBy(xpath="//ul[contains(@class,'globalNavSecondaryLinks')]/li/a[text()='Manual Vendors']")
	public WebElement ManualVendors_BT; 
	
	@FindBy(xpath="//ul[contains(@class,'globalNavSecondaryLinks')]/li/a[text()='Variance Stat']")
	public WebElement VarianceStat_BT; 
	
	@FindBy(xpath="//ul[contains(@class,'globalNavSecondaryLinks')]/li/a[text()='Food Over Base']")
	public WebElement FoodOverBase_BT;
	
	@FindBy(xpath="//a[text()='Raw Item Information & Activity']")
	public WebElement RawItemActivity_BT; 
	
	@FindBy(xpath="//a[text()='Audit']") 
	public WebElement Audit_BT; 
	
	@FindBy(xpath="//a[text()='Store Settings']") 
    public WebElement StoreSetting_BT;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_UsernameRegular']")
	public WebElement SSOUserName_TB;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_PasswordTextBoxRegular']")
	public WebElement SSOPassword_TB;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")
	public WebElement SSOLogin_BT;
	
	@FindBy(xpath="//h1[text()='Your Home Page']")
	public WebElement HomePage_Title;
	
	@FindBy(xpath="//div[@id='idConnPOSIcon']")
	public WebElement HomePage_POS_Img;
	
	@FindBy(xpath="//a[text()='Home']")
	public WebElement HomePage_Link;
	
	@FindBy(xpath="//div[@id='signOut']")
	public WebElement SignOut_BT;
	
	@FindBy(xpath="//button[@id='htmlButton']/span[text()='Yes']")
	public WebElement SignOutConfirmationPopUp_YES_BT;
	
	@FindBy(xpath="//img[@src='../images/qsrInventory.png']")
	public WebElement QSRInventory_Lebel;
	
	@FindBy(xpath="//button[text()='Create Daily Inventory']")
	public WebElement CreateDailyInventory_BT;
	
	@FindBy(xpath="//button[text()='Enter Raw Waste']")
	public WebElement EnterRawWaste_BT;
	
	@FindBy(xpath="//button[text()='Enter Completed Waste']")
	public WebElement EnterCompletedWaste_BT;
	
	@FindBy(xpath=".//span[text()='Month-to-Date Restaurant Performance']")
	public WebElement HomePage_MonthToDatePerformance_Label;
	
	//Method Reporter
	public HomePage ssoLogin(String userName, String password) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='login_frame']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='login_frame']")));
		wait.until(ExpectedConditions.visibilityOf(SSOUserName_TB));
		GenericMethods.enterValueInElement(SSOUserName_TB,"SSOUserName_TB", userName);
		GenericMethods.enterValueInElement(SSOPassword_TB,"SSOPassword_TB", password);
		GenericMethods.clickOnElement(SSOLogin_BT,"SSOLogin_BT");
		if(Base.isElementDisplayed(By.xpath("//input[@value='No']"))){
			driver.findElement(By.xpath("//input[@value='No']")).click();
		}
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(HomePage_Title));
		Reporter.log("Successfully redirected to the Home Page");
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
}
