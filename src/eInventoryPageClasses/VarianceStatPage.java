package eInventoryPageClasses;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.List;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import common.Base;
import common.GenericMethods;

public class VarianceStatPage  extends AbstractPage{

	public VarianceStatPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h1[text()='Variance Stat: Overview']")
	public WebElement StateVariance_Label;
	
	@FindBy(xpath = "//select[@id='landing_date_value']")
	public WebElement VarianceStatType_DD;
	

	
	@FindBy(xpath = "//input[@id='history_start_date_input']")
	public WebElement StatDate_TB;
	
	@FindBy(xpath = "//select[@id='landing_month_value']")
	public WebElement SelectMonth_DD;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='WRIN']")
	public WebElement VarianceStatTable_WrinHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Description']")
	public WebElement VarianceStatTable_DescHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Inv Time']")
	public WebElement VarianceStatTable_InvTimeHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Expected Usage']")
	public WebElement VarianceStatTable_ExpectedUsageHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Actual Usage']")
	public WebElement VarianceStatTable_ActualUsageHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Variance']")
	public WebElement VarianceStatTable_VarianceHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='Yield']")
	public WebElement VarianceStatTable_YieldsHeader_Label;
	
	@FindBy(xpath = "//table[@id='dailyinvstattable']/thead/tr/th[text()='$ Difference']")
	public WebElement VarianceStatTable_DifferenceHeader_Label;
	
	@FindBy(xpath = "//tbody[@id='daily_inv_table_body']/tr/td[@class='dataTables_empty']")
	public WebElement VarianceStatTable_EmptyTable_Label;
	
	@FindBy(xpath = "//tbody[@id='daily_inv_table_body']/tr")
	public List<WebElement> VarianceStatTable_Data_List;
	
	@FindBy(xpath = "//div[contains(text(),'Stat Gain:')]")
	public WebElement StatGain_Label;
	
	@FindBy(xpath = "//span[@id='dollar_gain']")
	public WebElement StatGain_Value;
	
	@FindBy(xpath = "//div[contains(text(),'Stat Loss:')]")
	public WebElement StatLoss_Label;
	
	@FindBy(xpath = "//span[@id='dollar_loss']")
	public WebElement StatLoss_Value;
	
	@FindBy(xpath = "//span[@id='dollar_variance']")
	public WebElement StatVariance_Value;
	
	@FindBy(xpath = "//input[@id='done_button']")
	public WebElement DoneWithThisItem_BT;
	
	@FindBy(xpath = "//tbody[@id='daily_inv_table_body']/tr[@role='row']")
	public List<WebElement> dailyStatRecords_List;
	
	@FindBy(xpath = "//tbody[@id='monthly_inv_table_body']/tr[@role='row']")
	public List<WebElement> MonthlyStatRecords_List;
	
	@FindBy(xpath = "//h1[text()='Variance Stat: Raw Item Activity']")
	public WebElement VarianceStatRawItemActivity_Label;
	
	@FindBy(xpath = "//tbody[@id='daily_inv_table_body']/tr[@role='row']/td[8]")
	public List<WebElement> DifferenceValue_List;
	
	@FindBy(xpath = "//table[@id='raw_item_detail_table']/tbody/tr[@role='row']")
	public List<WebElement> VarianceStatRawItemActivity_List;
	
	@FindBy(xpath = "//button[@value='Variance Stat: Overview']")
	public WebElement VarianceStatOverview_BT;
	
		
	public VarianceStatPage selectVarianceStatType(String varianceType) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(VarianceStatType_DD));
		Thread.sleep(2000);
		Select varianceStatTypeDD = new Select(VarianceStatType_DD);
		varianceStatTypeDD.selectByVisibleText(varianceType);
		return PageFactory.initElements(driver, VarianceStatPage.class);
	}
	
	public VarianceStatPage selectDateForDailyStat(String date) throws InterruptedException{
		StatDate_TB.click();
		Thread.sleep(1000);
		int day = Base.getDayFromDate(date);
		int month = Base.getMonthFromDate(date);
		selectMonthFromDatePicker(Base.getMonthName(month+1),1);
		driver.findElement(By.xpath("(//div[@class='xdsoft_calendar'])[1]//tbody/tr//td[@data-month='"+month+"']/div[text()='"+day+"']")).click();
		return PageFactory.initElements(driver, VarianceStatPage.class);
	}
	
	public void selectMonth(String monthStartDate){
		Select monthDropdown = new Select(SelectMonth_DD);
		monthDropdown.selectByValue(monthStartDate);
	}
	
	public boolean verifyVarianceStatLoaded() {
		System.out.println("VarianceStatTableHeaderDisplayed "+ VarianceStatTableHeaderDisplayed());
		System.out.println("VarianceStatTable_Data_List.size() "+ VarianceStatTable_Data_List.size());
		return VarianceStatTableHeaderDisplayed()
				& (Base.isElementDisplayed(VarianceStatTable_EmptyTable_Label) || VarianceStatTable_Data_List.size() > 0);
	}
	
	public boolean VarianceStatTableHeaderDisplayed() {
		return Base.isElementDisplayed(VarianceStatTable_WrinHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_DescHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_InvTimeHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_ExpectedUsageHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_ActualUsageHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_VarianceHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_YieldsHeader_Label)
				& Base.isElementDisplayed(VarianceStatTable_DifferenceHeader_Label);
	}
	
	public boolean verifyYieldValueDisplayedForWrin(String WrinId){
		return Base.isElementDisplayed(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[6]"));
	}
	
	public WebElement viewActivityButtn(String wrinId){
		return driver.findElement(By.xpath("//tbody[@id='daily_inv_table_body']/tr[@role='row']/td[contains(text(),'"+wrinId+"')]/following-sibling::td/eb-button/button"));
	}
	
	public String getDifferenceForAWrin(String wrinId){
		return driver.findElement(By.xpath("//tbody[@id='daily_inv_table_body']/tr[@role='row']/td[contains(text(),'"+wrinId+"')]/following-sibling::td[7]")).getText();
	}
	
	public String getActualUsageForAWrin(String wrinId){
		return driver.findElement(By.xpath("//tbody[@id='daily_inv_table_body']/tr[@role='row']/td[contains(text(),'"+wrinId+"')]/following-sibling::td[4]")).getText();
	}
	
	public void clickOnDateGroup(String date) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		String formattedDate =  Base.getFormattedDate1(date);
		WebElement dateGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(@class,'date" + formattedDate + "_group')]")));
		GenericMethods.clickOnElement(dateGroup,date);
		Thread.sleep(1000);
	}
	
	public boolean verifyInventoryOnHandCountMatchedForSelectedDate(String date, String count, String uom){
		String formattedDate = Base.getFormattedDate1(date);
		return Base.isElementDisplayed(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+count+"') and contains(text(),'"+uom+"')]"));
	}
	
	public boolean verifySelectedDateIsCollapsed(String date){
		String formattedDate =  Base.getFormattedDate1(date);
		boolean recordIsCollapsed =  driver.findElement(By.xpath("//tr[contains(@class,'date"+formattedDate+" ')]")).getAttribute("class").contains("hidden");
		return recordIsCollapsed;
	}
	
	public BigDecimal getStatGainFromDifference(){
		BigDecimal gain = new BigDecimal(0.00);
		for (WebElement difference : DifferenceValue_List){
			if (!difference.getText().contains("-")){
				gain = gain.add(new BigDecimal(difference.getText()));
				System.out.println("Gain "+gain);
			}
		}
		return gain;
	}
	
	public BigDecimal getStatLossFromDifference(){
		BigDecimal loss = new BigDecimal(0.00);
		for (WebElement difference : DifferenceValue_List){
			if (difference.getText().contains("-")){
				loss = loss.add(new BigDecimal(difference.getText().replace("-", "")));
				System.out.println("Loss "+loss);
			}
		}
		return loss;
	}
	
	public String calculateDifferenceForARawItem(String date){
		String formattedDate =  Base.getFormattedDate1(date);
		List<WebElement>DifferenceList = driver.findElements(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'"+formattedDate+"')]/td[6]/span/strong"));
		BigDecimal sum = new BigDecimal(0.00);
		for(WebElement diff : DifferenceList ){
			if (! diff.getText().equals("")){
				String temp = diff.getText().replace("$", "");
				BigDecimal temp2;
				if(temp.contains("-")){
					temp2 = new BigDecimal(temp.replace("-", ""));
					temp2 = temp2.negate();
				}else{
					temp2 = new BigDecimal(temp);
				}
				sum = sum.add(temp2);
				System.out.println("Sum "+sum);
			}
		}
		sum = sum.setScale(2);
		return String.valueOf(sum);
	}
	
	public String calculateActualUsageForARawItem(String date){
		String formattedDate =  Base.getFormattedDate1(date);
		String startingInventory = driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td/span/strong[contains(text(),'POS OPEN')]/../../following-sibling::td[2]/span/strong")).getText();
		String startingInventoryCount = startingInventory.split(" ")[0];
		String endingInventory = driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr/td/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong")).getText();
		String endingInventoryCount = endingInventory.split(" ")[0];
		BigDecimal actualUsage = new BigDecimal(startingInventoryCount).subtract(new BigDecimal(endingInventoryCount));
		actualUsage = actualUsage.setScale(4, RoundingMode.HALF_UP);
		/*List<WebElement>onHandList = driver.findElements(By.xpath(".//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'"+formattedDate+"')]/td[4]/span/strong"));
		BigDecimal sum = new BigDecimal(0.00);
		for(WebElement onHand : onHandList ){
			if (! onHand.getText().equals("")){
				String temp = onHand.getText().split(" ")[0];
				BigDecimal temp2;
				if(temp.contains("-")){
					temp2 = new BigDecimal(temp.replace("-", ""));
					temp2 = temp2.negate();
				}else{
					temp2 = new BigDecimal(temp);
				}
				sum = sum.add(temp2);
				System.out.println("Sum "+sum);
			}
		}
		sum = sum.setScale(2);
		return String.valueOf(sum);*/
		return String.valueOf(actualUsage);
	}
	
	public boolean verifyStatDetailsDisplayedForAnItem(String WrinId, String description, String date, String time){
		boolean descriptionDisplayed = Base.isElementDisplayed(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[contains(text(),'"+description+"')]"));
		String formattedDate = date.split("/")[2] + "-" + date.split("/")[0] + "-" + date.split("/")[1];
		boolean dateDisplayed = Base.isElementDisplayed(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[contains(text(),'"+formattedDate+"')]"));
		boolean timeDisplayed = Base.isElementDisplayed(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[contains(text(),'"+time+"')]"));
		boolean expectedUsageDisplayed = !driver.findElement(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[3]")).getText().isEmpty();
		boolean actualUsageDisplayed = !driver.findElement(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[4]")).getText().isEmpty();
		boolean varianceDisplayed = !driver.findElement(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[5]")).getText().isEmpty();
		boolean yieldDisplayed = !driver.findElement(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[6]")).getText().isEmpty();
		boolean differenceDisplayed = !driver.findElement(By.xpath("//tbody [@id='daily_inv_table_body']/tr/td[contains(text(),'"+WrinId+"')]/following-sibling::td[6]")).getText().isEmpty();
		return descriptionDisplayed & dateDisplayed & timeDisplayed & expectedUsageDisplayed 
				& actualUsageDisplayed & varianceDisplayed & yieldDisplayed & differenceDisplayed;
	}
	
	public VarianceStatPage clickOnViewActivityButtonForWRIN(String wrin) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		//click on the view Activity button
		Thread.sleep(1500);
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//tbody[@id='daily_inv_table_body']/tr/td[1][contains(.,'"+wrin+"')]/following-sibling::td[8]/eb-button/button")), "View Activity Button");
		wait.until(ExpectedConditions.visibilityOf(VarianceStatOverview_BT));
		return PageFactory.initElements(driver, VarianceStatPage.class);

		
	}
	
	public boolean verifyDifferenceDisplayedForSelectedDate(String date){
		String formattedDate = date.split("/")[2] + "-" + date.split("/")[0] + "-" + date.split("/")[1];
		return (driver.findElements(By.xpath("//tbody[@id='daily_inv_table_body']/tr[1]/td[contains(text(),'"+formattedDate+"')]/following-sibling::td[5]")).size() > 0);
	}
	
	public boolean verifyDifferenceDescendingOrder(){
		List<String>differenceValueList = Base.getTextListFromWebElements(DifferenceValue_List);
		return Base.verifyAmountIsInDescendingOrder(differenceValueList);
	}
	
	public boolean verifyDifferenceInAscendingOrder(){
		List<String>differenceValueList = Base.getTextListFromWebElements(DifferenceValue_List);
		return Base.verifyAmountIsInAscendingOrder(differenceValueList);
	}
	 

}
