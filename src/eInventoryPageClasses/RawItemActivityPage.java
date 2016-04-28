package eInventoryPageClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import common.Base;


public class RawItemActivityPage extends AbstractPage 
{

	public RawItemActivityPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//h1[contains(.,'Raw Item Activity')]")
	public WebElement RawItemActivity_Title;

	@FindBy(xpath = "//input[@id='autosearchInput']")
	public WebElement Search_TB;

	@FindBy(xpath = "//h4[@id='raw_item_detail_label']")
	public WebElement RawItemActivity_Header;

	@FindBy(xpath = "//input[@id='history_start_date']")
	public WebElement RawItemActivityPage_StartDate_TB;

	@FindBy(xpath = "//input[@id='history_end_date']")
	public WebElement RawItemActivityPage_EndDate_TB;

	@FindBy(xpath = ".//*[@id='get_item_details_btn']")
	public WebElement getItemDetails_Button;

	@FindBy(xpath = "//table[@id='raw_item_detail_table']/tbody/tr")
	public List<WebElement> rawItemDetailList;
	
	@FindBy(xpath="//span[contains(text(),'Time: ')]")
	public WebElement InventoryPopUp_Time_Label;
	
	@FindBy(xpath="//span[contains(text(),'Date: ')]")
	public WebElement InventoryPopUp_Date_Label;
	
	@FindBy(xpath="//input[@id='done_button']")
	public WebElement DoneWithThisItem_BT;
	
	@FindBy(xpath="//button[@id='start_raw_detail_calendar_btn']")
	public WebElement StartDate_BT;
	
	@FindBy(xpath="//button[@id='end_raw_detail_date_btn']")
	public WebElement EndDate_BT;
	
	@FindBy(xpath="//input[@id='raw_activity_history_start_date']")
	public WebElement StartDate_TB;
	
	@FindBy(xpath="//input[@id='raw_activity_history_end_date']")
	public WebElement EndDate_TB;
	
	@FindBy(xpath="//div[@id='waste_hist_detail_data']/table/tbody[@id='waste_hist_detail_table_body']/tr/td")
	public WebElement WasteDetailPopUp_WasteDetailList;
	
	@FindBy(xpath="//input[@value='Close']")
	public WebElement ActivityDetailPopUp_Close_BT;
	
	@FindBy(xpath="//eb-button[@id='raw_item_information_btn']/button")
	public WebElement Information_BT;
	
	@FindBy(xpath = "//table[@id='raw_item_detail_table']/tbody/tr/td/span[contains(text(),'Sales (POS Sold, Completed Promo)')]")
	public List<WebElement> rawItemEventDetailList;
	
	@FindBy(xpath = "//div/span[contains(.,'Average Cost per Unit')]/../following-sibling::div[1]/span")
	public WebElement AveratCostPerUnit_Value;
	
	@FindBy(xpath = "//h2[text()='Raw Item Information']")
	public WebElement RawItemInformation_Title;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement RawItemInformation_popUp_ManualPurchase_CB;
	
	@FindBy(xpath = "//select[@ddm-data='raw_item.primary_vdr']")
	public WebElement RawItemInformation_popUp_PrimaryVendor_DD;
	
	@FindBy(xpath = "//input[@ddm-data='raw_item.latest_case_price']")
	public WebElement RawItemInformation_popUp_CasePrice_TB;
	
	@FindBy(xpath = "//button[@role='button' and @value='Submit']")
	public WebElement RawItemInformation_popUp_Submit_BT;

	@FindBy(xpath = "//div[@class='toast-message' and text()='Changes Saved']")
	public WebElement RawItemInformation_popUp_ChangesSaved_Confirmation_MSG;
	
	@FindBy(xpath = "//div[@id='raw_item_detail_table_wrapper']")
	public WebElement RawItemActivity_Table_Wrapper;
	
	
	
	
	// This method will take WRIN Id as argument and search the the WRIN Id in Raw Item Activity Page
	public RawItemActivityPage searchAndSelectWRINID(String samplewRINID)
			throws InterruptedException {
		Search_TB.sendKeys(samplewRINID);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		int size=driver.findElements(By.xpath("//strong[text()='" + samplewRINID + "']")).size();
		driver.findElement(By.xpath("(//strong[text()='" + samplewRINID + "'])["+size+"]")).click();
		return PageFactory.initElements(driver, RawItemActivityPage.class);

	}

	// This method will navigate the user to Raw Item Activity Detail page
	public RawItemActivityPage clickOngetItemDetailButton() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		getItemDetails_Button.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//u[text()='System Date and Time']")));
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}

	// This method will take date and time as argument and return the deducted count
	public boolean verifyDeductedCountForSelectedDateTime(String date, String time,String deductedCount) 
	{
		String dateTime = date +" "+time;
		deductedCount = "-"+deductedCount+".0000";
		/*String deductedCount = "";
		for (int i = 1; i <= rawItemDetailList.size(); i++) {
			String dateTime = driver.findElement(By.xpath(".//*[@id='raw_item_detail_table']/tbody/tr[" + i+ "]/td[1]/span")).getText();
			boolean result = dateTime.split(" ")[0].equals(date);
			result = result && dateTime.split(" ")[1].equals(time);
			if (result) {
				deductedCount = driver.findElement(
						By.xpath(".//*[@id='raw_item_detail_table']/tbody/tr["
								+ i + "]/td[4]/span")).getText();
				return deductedCount;
			}
		}*/
		return driver.findElement(By.xpath("//table[@id='raw_item_detail_table']//tr/td/span[text()='"+dateTime+"']/../following-sibling::td/span[text()='Transfer Out']/../following-sibling::td[1]/span[text()='"+deductedCount+"']")).isDisplayed();
		
	}
	
	// This method will return count for a row item for physical inventory event from Raw Item Activity Page
	public String getCountForInventoryEvent(String date, String time) {
		String dateTime = date + " " + time;
		return driver.findElement(By.xpath("//table[@id='raw_item_detail_table']//tr/td[1]/span[text()='"+ dateTime+ "']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td[1]/span")).getText();
	}

	// This method will return style of the record for a row item for physical inventory event from Raw Item Activity Page
	public String getStyleForPostedInventoryEvent(String date, String time) {
		String dateTime = date + " " + time;
		return driver.findElement(By.xpath("//table[@id='raw_item_detail_table']//tr/td[1]/span[text()='"+ dateTime+ "']/../following-sibling::td/span[text()='Inventory']/../..")).getAttribute("style");
	}

	// This method will click on View details button for a row item for physical inventory event from Raw Item Activity Page
	public RawItemActivityPage clickOnPostedInventoryViewDetailsButton(String date, String time) {
		String dateTime = date + " " + time;
		driver.findElement(By.xpath("//table[@id='raw_item_detail_table']//tr/td[1]/span[text()='"+ dateTime+ "']/../following-sibling::td/span[text()='Inventory']/../following-sibling::td/button[@id='view_details_btn']")).click();
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}

	// This method will select start date from calendar
	public RawItemActivityPage selectStartDate(String date) throws InterruptedException {
		StartDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]/table/tbody/tr/td[@data-month='"+ month + "' and @data-date='" + day + "']/div")).click();
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}

	// This method will select end date from calendar
	public RawItemActivityPage selectEndDate(String date) throws InterruptedException {
		EndDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),2);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[2]/table/tbody/tr/td[@data-month='"+ month + "' and @data-date='" + day + "']/div")).click();
		return PageFactory.initElements(driver, RawItemActivityPage.class);
	}
	
	//click on waste details in raw item activity
	public void clickOnWasteDetails(){
		driver.findElement(By.xpath("(.//*[@id='raw_item_detail_table']/tbody/tr/td/span[text()='Waste'])[1]/../following-sibling::td/button[@id='view_details_btn']")).click();
	}
	
	public void clickOnDateGroup(String date) throws InterruptedException{
		String formattedDate =  Base.getFormattedDate1(date);
		WebElement dateGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'date" + formattedDate + "_group')]")));
		dateGroup.click();
		Thread.sleep(1000);
	}
	
	public int getNoumberOfPromoActivities(String date){
		return getNumberOfActivities(date,"Promo");
	}
	public int getNumberOfWasteActivities(String date){
		return getNumberOfActivities(date,"Waste");
	}
	
	public int getNumberOfCompletedWasteActivities(String date){
		return getNumberOfActivities(date,"Completed Waste");
	}
	
	public int getNoumberOfOfficeTransferActivities(String date){
		return getNumberOfActivities(date,"Office Transfer");
	}
	
	public int getNoumberOfTransferOutActivities(String date){
		return getNumberOfActivities(date,"Transfer Out");
	}
	
	public int getNumberOfActivities(String date, String activityType){
		String dateformat1 = Base.getFormattedDate1(date);
		String enteredDate = Base.returnTodayDate();
		String month = enteredDate.split("/")[0];
		String day = enteredDate.split("/")[1];
		String year = enteredDate.split("/")[2];
		String dateformat2 =  month+"/" + day+"/"+year;//  12-08-2015
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[contains(text(),'"+dateformat2+"')]/../following-sibling::td/span[text()='"+activityType+"']");
		return driver.findElements(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+dateformat1+" ')]/td/span[contains(text(),'"+dateformat2+"')]/../following-sibling::td/span[text()='"+activityType+"']")).size();
	}
	
	public boolean verifyWrinItemDisplayed(String wrinId){
		return Base.isElementDisplayed(By.xpath("//div[@id='raw_item_detail']/div/div/span[contains(.,'"+wrinId+"')]"));
	}
	
	public boolean verifyWrinItemDisplayedInRawItemInformationPopUp(String wrinId){
		return Base.isElementDisplayed(By.xpath("//table[@id='raw_item_info_table']/tbody/tr/td[contains(.,'"+wrinId+"')]"));
	}
	
	
}
