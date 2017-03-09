package eInventoryPageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

import common.Base;
import common.GenericMethods;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PhysicalInventoryPage  extends AbstractPage{

	public PhysicalInventoryPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//h1[text()='Inventory']")
	public WebElement PhysicalInventoryPage_Title;
	
	@FindBy(xpath ="//h2[text()='Daily Inventory']")
	public WebElement DailyInventory_PopUp_Title;
	
	@FindBy(xpath ="//button[@id='htmlButton' and @value='Daily Inventory']")
	public WebElement DailyInventory_BT;
	
	@FindBy(xpath ="//input[@id='validatedInput' and @colname='loose_count_input']")
	public List <WebElement> DailyInventory_PopUp_Loose_TB;
	
	@FindBy(xpath ="//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span")
	public List <WebElement> DailyInventory_PopUp_WRIN_Value;
	
	@FindBy(xpath ="//table[@id='dailyInventoryTable']/tbody/tr/td[6]/span")
	public List <WebElement> DailyInventory_PopUp_ItemTotal_Value;
	
	@FindBy(xpath ="//table[@id='dailyInventoryTable']/tbody/tr/td[7]/span")
	public List <WebElement> DailyInventory_PopUp_RangeIndicator_RB;
	
	@FindBy(xpath = "//input[@id='daily_inventory_autocomplete' and @placeholder='Enter WRIN or Description']")
	public WebElement EnterRawOrDescription_TB;
	
	@FindBy(xpath = "//a[text()='Items to Inventory']")
	public WebElement ItemsToInventory_BT;
	
	@FindBy(xpath = "//a[text()='Inventory History']")
	public WebElement InventoryHistory_BT;
	
	@FindBy(xpath = "//input[@id='autosearchHisInput']")
	public WebElement InventoryHistory_Search_TB;
	
	@FindBy(xpath = "//h3[text()='Inventory History']")
	public WebElement InventoryHistory_Title;
	
	@FindBy(xpath = "//h2[text()='Daily Inventory']")
	public WebElement DailyInventoryPopUp_Title;
	
	@FindBy(xpath = "//eb-button[@id='dailyInventoryModalSubmitBtn']/button[@value='Submit']")
	public WebElement DailyInventoryPopUp_Submit_BT;
	
	@FindBy(xpath ="//div[@class='toast-message' and text()='Daily Inventory has been successfully submitted']")
	public WebElement DailyInventorySubmitted_Confirmation_MSG;
	
	@FindBy(xpath = "//input[@colname='case_count_input']")
	public List<WebElement> DailyInventoryPopUp_CaseQty_TB_List;
	
	@FindBy(xpath = "//input[@colname='pack_count_input']")
	public List<WebElement> DailyInventoryPopUp_InnerPackQty_TB_List;
	
	@FindBy(xpath = "//input[@colname='loose_count_input']")
	public List<WebElement> DailyInventoryPopUp_LooseUnitsQty_TB_List;
	
	@FindBy(xpath ="//button/span[text()='Yes']")
	public WebElement ConfirmationPopUp_YES_BT;
	
	@FindBy(xpath ="//button/span[text()='No']")
	public WebElement ConfirmationPopUp_NO_BT;
	
	@FindBy(xpath = "//div[text()='Add Count']/input")
	public WebElement Preview_AddCount_RB;
	
	@FindBy(xpath = "//div[text()='Replace Count']/input")
	public WebElement Preview_ReplaceCount_RB;
	
	@FindBy(xpath = "//input[@id='validatedInput' and @placeholder='Case']")
	public WebElement Preview_Case_TB;
	
	@FindBy(xpath = "//input[@id='validatedInput' and @name='pack']")
	public WebElement Preview_Pack_TB;
	
	@FindBy(xpath = "//input[@id='validatedInput' and @name='loose']")
	public WebElement Preview_Loose_TB;
	
	@FindBy(xpath = "//input[@id='inventoryItemSaveButton']")
	public WebElement Preview_Save_BT;
	
	@FindBy(xpath = "//div[@id='inventoryItemCloseButton']")
	public WebElement Preview_Cross_BT;
	
	@FindBy(xpath = "//table[@id='dailyInventoryTable']/tbody/tr/td[1]/span")
	public List<WebElement> DailyInventoryPopUp_WrinId_List;
	
	@FindBy(xpath ="//select[@id='wrinSelectId']")
	public WebElement Wrin_DD;
	
	@FindBy(xpath ="//select[@id='tempSelectId']")
	public WebElement TemperatureZone_DD;
	
	@FindBy(xpath ="//select[@id='varianceSelectId']")
	public WebElement RangeIndicator_DD;
	
	@FindBy(xpath ="//eb-button[@id='submitButton']/button")
	public WebElement SubmitSelectedItems_BT;
	
	@FindBy(xpath = "//table[@id='inventoryTable']/tbody/tr/td[2]/span")
	public List<WebElement> WrinId_List;
	
	@FindBy(xpath = "//eb-validated-input[@class='case_input']/div//div/input")
	public WebElement WrinPreview_PopUP_CaseQty_TB;
	
	@FindBy(xpath = "//eb-validated-input[@class='pack_input']/div//div/input")
	public WebElement WrinPreview_PopUP_InnerPackQty_TB;
	
	@FindBy(xpath = "//eb-validated-input[@class='loose_input']/div//div/input")
	public WebElement WrinPreview_PopUP_LooseUnitsQty_TB;
	
	@FindBy(xpath = "//input[@id='inventoryItemSaveButton']")
	public WebElement WrinPreview_PopUP_Save_BT;
	
	@FindBy(xpath = "//table[@id='historyInventoryTable']/tbody/tr/td[3]/span")
	public List<WebElement> InventoryHistory_Date_List;
	
	public PhysicalInventoryPage enterQuantityForAllWrin(String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException{
		for(WebElement caseTB : DailyInventoryPopUp_CaseQty_TB_List){
			GenericMethods.clearValueOfElement(caseTB, "outerPack");
			GenericMethods.enterValueInElement(caseTB, "outerPack", caseQty);
		}
		for(WebElement innerPackTB : DailyInventoryPopUp_InnerPackQty_TB_List){
			GenericMethods.clearValueOfElement(innerPackTB, "innerPack");
			GenericMethods.enterValueInElement(innerPackTB, "innerPack", innerPackQty);
		}
		for(WebElement looseUnitsTB : DailyInventoryPopUp_LooseUnitsQty_TB_List){
			GenericMethods.clearValueOfElement(looseUnitsTB, "looseUnitsPack");
			GenericMethods.enterValueInElement(looseUnitsTB, "looseUnitsPack", looseQty);
		}
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}
	
	 public PhysicalInventoryPage enterQuantityForNewAddedWrin(String wrinId, String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException{
	        WebElement outerPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+wrinId+"')]/following-sibling::td/eb-validated-input[@class='case_count_input']/div//div/input"));
	        GenericMethods.clearValueOfElement(outerPack, "outerPack");
	        GenericMethods.enterValueInElement(outerPack, "outerPack", caseQty);
	        try
	        {
	            WebElement innerPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+wrinId+"')]/following-sibling::td/eb-validated-input[@class='inner_count_input']/div//div/input"));
	            GenericMethods.clearValueOfElement(innerPack, "innerPack");
	            GenericMethods.enterValueInElement(innerPack, "innerPack", caseQty);
	        } catch (Exception e) 
	        {
	            
	        }
	        WebElement looseUnitsPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[contains(.,'"+wrinId+"')]/following-sibling::td/eb-validated-input[@class='loose_count_input']/div//div/input"));
	        //GenericMethods.clearValueOfElement(looseUnitsPack, "looseUnitsPack");
	        looseUnitsPack.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	        looseUnitsPack.sendKeys(Keys.DELETE);
	        GenericMethods.enterValueInElement(looseUnitsPack, "looseUnitsPack", looseQty);
	        return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	    }
	
	public PhysicalInventoryPage enterQuantityForWrin(String wrinId, String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException{
		WebElement outerPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+wrinId+"')]/../following-sibling::td/eb-validated-input[@class='case_count_input']/div//div/input"));
		GenericMethods.clearValueOfElement(outerPack, "outerPack");
		GenericMethods.enterValueInElement(outerPack, "outerPack", caseQty);
		try{
			WebElement innerPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+wrinId+"')]/../following-sibling::td/eb-validated-input[@class='inner_count_input']/div//div/input"));
			GenericMethods.clearValueOfElement(innerPack, "innerPack");
			GenericMethods.enterValueInElement(innerPack, "innerPack", caseQty);
		} catch (Exception e) {
		}
		WebElement looseUnitsPack = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+wrinId+"')]/../following-sibling::td/eb-validated-input[@class='loose_count_input']/div//div/input"));
		//GenericMethods.clearValueOfElement(looseUnitsPack, "looseUnitsPack");
        looseUnitsPack.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        looseUnitsPack.sendKeys(Keys.DELETE);
		GenericMethods.enterValueInElement(looseUnitsPack, "looseUnitsPack", looseQty);
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}
	
	public PhysicalInventoryPage submitDailyInventoryForAWrin(String wrinId, String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException, InterruptedException
	{
		GenericMethods.clickOnElement(DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(DailyInventoryPopUp_Title));
		verifyAndAddWrinInTable(wrinId, caseQty,  innerPackQty,  looseQty);
		Thread.sleep(2000);
		GenericMethods.clickOnElement(DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(DailyInventorySubmitted_Confirmation_MSG));
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}
	
	public PhysicalInventoryPage submitDailyInventoryForAllItems(String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException
	{
		GenericMethods.clickOnElement(DailyInventory_BT, "DailyInventory_BT");
		wait.until(ExpectedConditions.visibilityOf(DailyInventoryPopUp_Title));
		enterQuantityForAllWrin(caseQty, innerPackQty, looseQty);
		GenericMethods.clickOnElement(DailyInventoryPopUp_Submit_BT, "DailyInventoryPopUp_Submit_BT");
		if(Base.isElementDisplayed(ConfirmationPopUp_YES_BT)){
			GenericMethods.clickOnElement(ConfirmationPopUp_YES_BT, "ConfirmationPopUp_YES_BT");
		}
		wait.until(ExpectedConditions.visibilityOf(DailyInventorySubmitted_Confirmation_MSG));
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}
	
	
	public boolean verifyInventorySubmittedForItem(String wrinId,String date, String itemTotal){
		return Base.isElementDisplayed(By.xpath("//table[@id='historyInventoryTable']//tr/td/span[text()='"+wrinId+"']/../following-sibling::td/span[contains(text(),'"+date+"')]/../following-sibling::td/span[text()='"+itemTotal+"']"));
	}
	
	public String getItemTotalForAWrin(String wrinId){
		try{
			return driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[text()='"+wrinId+"']/../following-sibling::td/span[@class='dailyTotal']")).getText();
		}catch(Exception ex){
			return driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[text()='"+wrinId+"']/following-sibling::td/span[@class='dailyTotal']")).getText();
		}
	}
	
	public PhysicalInventoryPage seacrhAndSelectRawItem(String samplewRINID)throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		GenericMethods.clickOnElement(EnterRawOrDescription_TB, "EnterRawOrDescription_TB");
		GenericMethods.clearValueOfElement(EnterRawOrDescription_TB, "EnterRawOrDescription_TB");
		GenericMethods.enterValueInElement(EnterRawOrDescription_TB, "CreateManualInvoice_EnterRawItemNumberOrDescription_TB", samplewRINID);
		action.sendKeys(Keys.SPACE).build().perform(); 
		Thread.sleep(1500); 
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		GenericMethods.clickOnElement(driver.findElement(By.xpath("(//strong[text()='"+samplewRINID+"'])[1]")), "WRIN ID");
		Thread.sleep(2000);
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}

	public PhysicalInventoryPage verifyAndAddWrinInTable(String wrinID,String caseQty, String innerPackQty, String looseQty)
			throws RowsExceededException, BiffException, WriteException,InterruptedException, IOException {
		if (Base.isElementDisplayed(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[contains(.,'"+ wrinID + "')]"))) {
			enterQuantityForWrin(wrinID, caseQty, innerPackQty, looseQty);
		} else {
			seacrhAndSelectRawItem(wrinID);
			Thread.sleep(2000);
			enterQuantityForNewAddedWrin(wrinID, caseQty, innerPackQty,looseQty);
		}
		return PageFactory.initElements(driver, PhysicalInventoryPage.class);
	}
	
	
	public void selectWrinForSubmissionInPILandingPage(String wrinId, String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException, InterruptedException{
		WebElement checkBox = driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td/span[text()='"+wrinId+"']/../preceding-sibling::td"));
		String checkBoxClass = checkBox.getAttribute("class");
		if(!checkBoxClass.contains("select-checkbox")){
			enterQuantityForWrinInPreviewModel(wrinId, caseQty, innerPackQty, looseQty);
			Thread.sleep(2000);
		}
		GenericMethods.clickOnElement(checkBox, "checkBox");
	}
	
	public void enterQuantityForWrinInPreviewModel(String wrinId, String caseQty, String innerPackQty, String looseQty) throws RowsExceededException, BiffException, WriteException, IOException{
		GenericMethods.clickOnElement(driver.findElement(By.xpath("//table[@id='inventoryTable']/tbody/tr/td/span[text()='"+wrinId+"']")), wrinId);
		GenericMethods.clearValueOfElement(WrinPreview_PopUP_CaseQty_TB, "WrinPreview_PopUP_CaseQty_TB");
		GenericMethods.enterValueInElement(WrinPreview_PopUP_CaseQty_TB, "WrinPreview_PopUP_CaseQty_TB", caseQty);
		if(Base.isElementDisplayed(WrinPreview_PopUP_InnerPackQty_TB)){
			GenericMethods.clearValueOfElement(WrinPreview_PopUP_InnerPackQty_TB, "WrinPreview_PopUP_InnerPackQty_TB");
			GenericMethods.enterValueInElement(WrinPreview_PopUP_InnerPackQty_TB, "WrinPreview_PopUP_InnerPackQty_TB", innerPackQty);
		}
		GenericMethods.clearValueOfElement(WrinPreview_PopUP_LooseUnitsQty_TB, "WrinPreview_PopUP_LooseUnitsQty_TB");
		GenericMethods.enterValueInElement(WrinPreview_PopUP_LooseUnitsQty_TB, "WrinPreview_PopUP_LooseUnitsQty_TB", looseQty);
		GenericMethods.clickOnElement(WrinPreview_PopUP_Save_BT, "WrinPreview_PopUP_Save_BT");
	}
	
	public boolean verifyWrinIdDisplayedInPILandingPage(String wrinID){
		return Base.isElementDisplayed(By.xpath("//table[@id='inventoryTable']/tbody/tr/td/span[text()='"+wrinID+"']"));
	}
	
	public boolean verifyWrinIdDisplayedInInventoryHistoryPage(String wrinID){
		return Base.isElementDisplayed(By.xpath("//table[@id='historyInventoryTable']//tr/td/span[text()='"+wrinID+"']"));
	}
	
	public String calculateRangeIndicator(String perpetualInventoryCount, String unitCount){
		BigDecimal diff = new BigDecimal(perpetualInventoryCount).subtract(new BigDecimal(unitCount));
		BigDecimal percent = diff.divide(new BigDecimal(perpetualInventoryCount),4,RoundingMode.FLOOR).multiply(new BigDecimal("100"));
		if(percent.compareTo(new BigDecimal("19")) >0){
			return "Red";
		}else if (percent.compareTo(new BigDecimal("5")) >0 && percent.compareTo(new BigDecimal("19")) <0){
			return "Yellow";
		}else if (percent.compareTo(new BigDecimal("0")) >0 && percent.compareTo(new BigDecimal("5")) <0){
			return "Green";
		}else{
			return "N/A";
		}
	}
	
	public String getRangeIndicatorForAWrin(String wrinId){
        WebElement range;
        try{
            range = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td/span[text()='"+wrinId+"']/../following-sibling::td/span[contains(@class,'badge')]"));
        }catch(Exception ex){
            range = driver.findElement(By.xpath("//table[@id='dailyInventoryTable']/tbody/tr/td[text()='"+wrinId+"']/following-sibling::td/span[contains(@class,'badge')]"));
        }		
		String rangeClass = range.getAttribute("class");
		if(rangeClass.contains("Red")){
			return "Red";
		}else if (rangeClass.contains("Green")){
			return "Green";
		}else if (rangeClass.contains("Yellow")){
			return "Yellow";
		}else{
			return "N/A";
		}
	}
	
	public String getLooseUnitsForGreenIndicator(String perpectualCount){
		BigDecimal temp1 = new BigDecimal(3).multiply(new BigDecimal(perpectualCount)).divide(new BigDecimal(100));
		BigDecimal temp2 = new BigDecimal(perpectualCount).subtract(temp1);
		BigDecimal looseUnit = temp2.setScale(0,BigDecimal.ROUND_DOWN);
		return looseUnit.toString();
		
	}
	
	public String getLooseUnitsForYellowIndicator(String perpectualCount){
		BigDecimal temp1 = new BigDecimal(6).multiply(new BigDecimal(perpectualCount)).divide(new BigDecimal(100));
		BigDecimal temp2 = new BigDecimal(perpectualCount).subtract(temp1);
		BigDecimal looseUnit = temp2.setScale(0,BigDecimal.ROUND_DOWN);
		return looseUnit.toString();
	}
	
	public String getLooseUnitsForRedIndicator(String perpectualCount){
		BigDecimal temp1 = new BigDecimal(20).multiply(new BigDecimal(perpectualCount)).divide(new BigDecimal(100));
		BigDecimal temp2 = new BigDecimal(perpectualCount).subtract(temp1);
		BigDecimal looseUnit = temp2.setScale(0,BigDecimal.ROUND_DOWN);
		return looseUnit.toString();
	}
	
	public boolean verifyInventoryDateInDescendingOrder() throws ParseException
	{
		List<String>dateValueList = Base.getTextListFromWebElements(InventoryHistory_Date_List);
		return Base.verifyDateInDescendingOrder(dateValueList);
	}

}
