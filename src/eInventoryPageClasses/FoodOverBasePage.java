package eInventoryPageClasses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FoodOverBasePage extends AbstractPage {

	public FoodOverBasePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Food Over Base']")
	public WebElement FoodOverBase_Label;
	
	@FindBy(xpath = "//table[contains(@id,'raw_item_info_table+undefined+')]/tbody/tr[9]/td/var")
	public WebElement PostCommentForCurrentMonth_BT;
	
	@FindBy(xpath = "//textarea[@id='text_save']")
	public WebElement CommentBox_TB;
	
	@FindBy(xpath = "//input[@id='btn_save_comment']")
	public WebElement SaveComment_BT;
	
	/***********New UI********************/
	@FindBy(xpath = "//div[@id='food_over_base_nav']/ul/li[1]/a[contains(text(),'Current Month')]")
	public WebElement CurrentMonth_BT;
	
	@FindBy(xpath = "//div[@id='current_month_main_view']//div[@class='tabTitle']")
	public WebElement CurrentMonth_Title_Label;
	
	@FindBy(xpath = "//div[@id='food_over_base_nav']/ul/li[3]/a[contains(text(),'Month-End')]")
	public WebElement MonthEnd_BT;
	
	@FindBy(xpath = "//div[@id='food_over_base_nav']/ul/li[2]/a[contains(text(),'Projections')]")
	public WebElement Projections_BT;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/thead/tr/th[text()='%']/following-sibling::th[contains(text(),'Difference')]")
	public WebElement CurrentMonth_DifferencePercentage_Column_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/thead/tr/th[text()='Target']")
	public WebElement CurrentMonth_Target_Column_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/thead/tr/th[text()='Actual']")
	public WebElement CurrentMonth_Actual_Column_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/thead/tr/th[text()='$']/preceding-sibling::th[contains(text(),'Difference')]")
	public WebElement CurrentMonth_DifferenceDoller_Column_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[2]")
	public List<WebElement> CurrentMonth_TargetPercent_List;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[3]")
	public List<WebElement> CurrentMonth_ActualPercent_List;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[4]")
	public List<WebElement> CurrentMonth_DifferencePercent_List;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[6]")
	public List<WebElement> CurrentMonth_DifferenceDoller_List;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[2]")
	public List<WebElement> MonthEnd_TargetPercent_List;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[3]")
	public List<WebElement> MonthEnd_ActualPercent_List;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[4]")
	public List<WebElement> MonthEnd_DifferencePercent_List;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[6]")
	public List<WebElement> MonthEnd_DifferenceDoller_List;
	
	@FindBy(xpath = "(//div[@class='netSales'])[2]")
	public WebElement CurrentMonth_NetSales_Value;
	
	@FindBy(xpath = "//div[contains(text(),'Month-to-Date Product Net Sales:')]")
	public WebElement MonthToDateProductNetSales_Label;
	
	@FindBy(xpath = "//div[@class='toast-message' and contains(text(),'Food Over Base changes saved!')]")
	public WebElement CurrentMonth_CommentsSaved_Confirmation_MSG;
	
	@FindBy(xpath = "//eb-button[@id='edit_btn']/button")
	public WebElement CurrentMonth_Edit_BT;
	
	@FindBy(xpath = "//eb-button[@id='apply_btn']/button")
	public WebElement CurrentMonth_Apply_BT;
	
	@FindBy(xpath = "(//textarea[@id='current_month_comment'])[1]")
	public WebElement CurrentMonth_Comments_TB;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Completed Waste']")
	public WebElement CurrentMonth_CompletedWaste_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Raw Waste']")
	public WebElement CurrentMonth_RawWaste_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Condiments']")
	public WebElement CurrentMonth_Condiments_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']")
	public WebElement CurrentMonth_EmpMgrMeals_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Discounts/Coupons']")
	public WebElement CurrentMonth_DiscountCoupons_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Stat Variance']")
	public WebElement CurrentMonth_StatVariance_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Unexplained']")
	public WebElement CurrentMonth_Unexplained_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Totals']")
	public WebElement CurrentMonth_Totals_Label;
	
	@FindBy(xpath = "//table[@id='current_month_food_cost']/tbody/tr/td[text()='Base Food']")
	public WebElement CurrentMonth_BaseFood_Label;
	
	@FindBy(xpath = "//table[@id='current_month_food_cost']/tbody/tr/td[text()='Food Over Base']")
	public WebElement CurrentMonth_FoodOverBase_Label;
	
	@FindBy(xpath = "//table[@id='current_month_food_cost']/tbody/tr/td[text()='Total']")
	public WebElement CurrentMonth_Total_Label;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[5]")
	public WebElement CurrentMonth_EmpMgrMeals_DifferenceDoller_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[3]")
	public WebElement CurrentMonth_EmpMgrMeals_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[1]")
	public WebElement CurrentMonth_EmpMgrMeals_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[2]")
	public WebElement CurrentMonth_EmpMgrMeals_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[2]")
	public WebElement CurrentMonth_DiscountCoupons_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[5]")
	public WebElement CurrentMonth_DiscountCoupons_DifferenceDoller_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[3]")
	public WebElement CurrentMonth_DiscountCoupons_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[1]")
	public WebElement CurrentMonth_DiscountCoupons_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Raw Waste']/following-sibling::td[2]")
	public WebElement CurrentMonth_RawWaste_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[2]")
	public WebElement CurrentMonth_CompletedWaste_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[5]")
	public WebElement CurrentMonth_CompletedWaste_DifferenceDoller_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[3]")
	public WebElement CurrentMonth_CompletedWaste_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[1]")
	public WebElement CurrentMonth_CompletedWaste_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[2]")
	public WebElement CurrentMonth_StatVariance_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[5]")
	public WebElement CurrentMonth_StatVariance_DifferenceDoller_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[3]")
	public WebElement CurrentMonth_StatVariance_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='current_month_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[1]")
	public WebElement CurrentMonth_StatVariance_TargetPercent_Value;
	
	/********Projections Tab UI*******/
	@FindBy(xpath = "//div[@id='projections_main_view']//div[@class='tabTitle']")
	public WebElement Projections_Title_Label;
	
	@FindBy(xpath = "//table[@id='projections_left']/tbody/tr[1]/td[contains(text(),'Product Net Sales')]")
	public WebElement Projections_NetSales_Label;
	
	@FindBy(xpath = "//table[@id='projections_left']/tbody/tr/td[text()='Raw Waste']")
	public WebElement Projections_RawWaste_Label;
	
	@FindBy(xpath = "//eb-button[@id='edit_proj_btn']/button")
	public WebElement Projections_EditTargets_BT;
	
	@FindBy(xpath = "//eb-button[@id='apply_proj_btn']/button")
	public WebElement Projections_ApplyTargets_BT;
	
	@FindBy(xpath = "//td[text()='Product Net Sales']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_NetSalesTarget_TB;
	
	@FindBy(xpath = "//td[text()='Base Food']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_BaseFoodTarget_TB;
	
	@FindBy(xpath = "//td[text()='Completed Waste']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_CompletedWasteTarget_TB;
	
	@FindBy(xpath = "//td[text()='Raw Waste']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_RawWasteTarget_TB;
	
	@FindBy(xpath = "//td[text()='Condiments']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_CondimentsTarget_TB;
	
	@FindBy(xpath = "//td[text()='Emp/Mgr Meals']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_EmpMgrMealsTarget_TB;
	
	@FindBy(xpath = "//td[text()='Discount/Coupons']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_DiscountCouponsTarget_TB;
	
	@FindBy(xpath = "//td[text()='Stat Variance']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_StatVarianceTarget_TB;
	
	@FindBy(xpath = "//td[text()='Unexplained']/following-sibling::td/eb-validated-input//div/input")
	public WebElement Projections_UnexplainedTarget_TB;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Product Net Sales']/following-sibling::td[1]")
	public WebElement Projections_NetSalesProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Base Food']/following-sibling::td[1]")
	public WebElement Projections_BaseFoodProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[1]")
	public WebElement Projections_CompletedWasteProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Raw Waste']/following-sibling::td[1]")
	public WebElement Projections_RawWasteProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Condiments']/following-sibling::td[1]")
	public WebElement Projections_CondimentsProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[1]")
	public WebElement Projections_EmpMgrMealsProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Discount/Coupons']/following-sibling::td[1]")
	public WebElement Projections_DiscountCouponsProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[1]")
	public WebElement Projections_StatVarianceProjected_Value;
	
	@FindBy(xpath = "//table [@id='projections_left']/tbody/tr/td[text()='Unexplained']/following-sibling::td[1]")
	public WebElement Projections_UnexplainedProjected_Value;
	
	@FindBy(xpath = "//div[@class='toast-message' and contains(text(),'Projected fields saved')]")
	public WebElement Projections_ChangesSaved_Confirmation_MSG;
	
	@FindBy(xpath = "(//textarea [@id='current_month_comment'])[2]")
	public WebElement Projections_Comments_TB;
	
	@FindBy(xpath = "//table[@id='projections_right']/tbody/tr/td[text()='Unexplained']")
	public WebElement Projections_Historicals_Unexplained_Raw_Header;
	
	@FindBy(xpath = "//div[contains(@id,'popover') and @role='tooltip']/div[@class='popover-content']")
	public WebElement InvalidValues_Msg;
	
	//Historicals Section UI
	@FindBy(xpath = "//select[@id='select_projection']")
	public WebElement Historicals_SelectProjections_DD;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr[1]/td[contains(text(),'Product Net Sales')]")
	public WebElement Historicals_NetSales_Label;
	
	@FindBy(xpath = "//thead[@id='projections_right_tbl_head']/tr/th[text()='Historicals']")
	public WebElement Historicals_Column_Label;
	
	@FindBy(xpath = "//thead[@id='projections_right_tbl_head']/tr/th[2]")
	public WebElement Historicals_PastMonth1Column_Label;
	
	@FindBy(xpath = "//thead[@id='projections_right_tbl_head']/tr/th[3]")
	public WebElement Historicals_PastMonth2Column_Label;
	
	@FindBy(xpath = "//thead[@id='projections_right_tbl_head']/tr/th[4]")
	public WebElement Historicals_PastMonth3Column_Label;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Emp/Mgr Meals')]/following-sibling::td[1]/span")
	public WebElement Historicals_EmpMgrMeals_PastMonth1_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Emp/Mgr Meals')]/following-sibling::td[2]/span")
	public WebElement Historicals_EmpMgrMeals_PastMonth2_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Emp/Mgr Meals')]/following-sibling::td[3]/span")
	public WebElement Historicals_EmpMgrMeals_PastMonth3_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Discount/Coupons')]/following-sibling::td[1]/span")
	public WebElement Historicals_DiscountCoupon_PastMonth1_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Completed Waste')]/following-sibling::td[1]/span")
	public WebElement Historicals_CompletedWaste_PastMonth1_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Completed Waste')]/following-sibling::td[2]/span")
	public WebElement Historicals_CompletedWaste_PastMonth2_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Completed Waste')]/following-sibling::td[3]/span")
	public WebElement Historicals_CompletedWaste_PastMonth3_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Stat Variance')]/following-sibling::td[1]/span")
	public WebElement Historicals_StatVariance_PastMonth1_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Stat Variance')]/following-sibling::td[2]/span")
	public WebElement Historicals_StatVariance_PastMonth2_Value;
	
	@FindBy(xpath = "//table[@id='projections_right']//tr/td[contains(text(),'Stat Variance')]/following-sibling::td[3]/span")
	public WebElement Historicals_StatVariance_PastMonth3_Value;
	
	/**********Month End Section UI**********/
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]/thead/tr/th[text()='Total P&L Food Cost']")
	public WebElement MonthEnd_TotalPLFoodCost_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]/thead/tr/th[text()='Total P&L Paper Cost']")
	public WebElement MonthEnd_TotalPLPaperCost_Label;
	
	@FindBy(xpath = "//select[@id='select_month_end']")
	public WebElement MonthEnd_SelectMonth_DD;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']")
	public WebElement MonthEnd_CompletedWaste_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Raw Waste']")
	public WebElement MonthEnd_RawWaste_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Condiments']")
	public WebElement MonthEnd_Condiments_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']")
	public WebElement MonthEnd_EmpMgrMeals_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']")
	public WebElement MonthEnd_DiscountCoupons_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Stat Variance']")
	public WebElement MonthEnd_StatVariance_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Unexplained']")
	public WebElement MonthEnd_Unexplained_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Totals']")
	public WebElement MonthEnd_Totals_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/thead/tr/th[text()='%']/following-sibling::th[contains(text(),'Difference')]")
	public WebElement MonthEnd_DifferencePercentage_Column_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/thead/tr/th[text()='$']/preceding-sibling::th[contains(text(),'Difference')]")
	public WebElement MonthEnd_DifferenceDoller_Column_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/thead/tr/th[text()='Target']")
	public WebElement MonthEnd_Target_Column_Label;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/thead/tr/th[text()='Actual']")
	public WebElement MonthEnd_Actual_Column_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_food_cost'])[2]/tbody/tr/td[text()='Base Food']")
	public WebElement MonthEnd_BaseFood_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_food_cost'])[2]/tbody/tr/td[text()='Food Over Base']")
	public WebElement MonthEnd_FoodOverBase_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_food_cost'])[2]/tbody/tr/td[text()='Total']")
	public WebElement MonthEnd_Total_Label;
	
	@FindBy(xpath = "//div[text()='Product Net Sales:']/../following-sibling::div/div[@class='meTotals']")
	public WebElement MonthEnd_NetSales_Value;
	
	@FindBy(xpath = "//div[text()='Product Net Sales:']")
	public WebElement MonthEnd_ProductNetSales_Label;
	
	@FindBy(xpath = "//div[text()='Total Paper Cost:']")
	public WebElement MonthEnd_TotalPaperCost_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Beginning Inventory']")
	public WebElement MonthEnd_PlFoodCost_BeginingInventory_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Beginning Inventory']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_BeginingInventory_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Purchases']")
	public WebElement MonthEnd_PlFoodCost_FoodPurchases_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Purchases']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_FoodPurchases_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Transfers']")
	public WebElement MonthEnd_PlFoodCost_FoodTransfers_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Transfers']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_FoodTransfers_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Transfers']/following-sibling::td[1]")
	public WebElement MonthEnd_PlFoodCost_FoodTransfers_Sign;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Promotions']")
	public WebElement MonthEnd_PlFoodCost_FoodPromotions_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Food Promotions']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_FoodPromotions_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Ending Inventory']")
	public WebElement MonthEnd_PlFoodCost_EndingInventory_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Ending Inventory']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_EndingInventory_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Total:']")
	public WebElement MonthEnd_PlFoodCost_Total_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[2]//tr/td[text()='Total:']/following-sibling::td[2]")
	public WebElement MonthEnd_PlFoodCost_Total_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Beginning Inventory']")
	public WebElement MonthEnd_PLPaperCost_BeginingInventory_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Beginning Inventory']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_BeginingInventory_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Purchases']")
	public WebElement MonthEnd_PLPaperCost_PaperPurchases_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Purchases']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_PaperPurchases_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Transfers']")
	public WebElement MonthEnd_PLPaperCost_PaperTransfers_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Transfers']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_PaperTransfers_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Promotions']")
	public WebElement MonthEnd_PLPaperCost_PaperPromotions_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Paper Promotions']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_PaperPromotions_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Ending Inventory']")
	public WebElement MonthEnd_PLPaperCost_EndingInventory_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Ending Inventory']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_EndingInventory_Value;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Total:']")
	public WebElement MonthEnd_PLPaperCost_Total_Label;
	
	@FindBy(xpath = "(//table[@id='current_month_pl'])[3]//tr/td[text()='Total:']/following-sibling::td[2]")
	public WebElement MonthEnd_PLPaperCost_Total_Value;
	
	@FindBy(xpath = "//textarea [@id='me']")
	public WebElement MonthEnd_Comments_TB;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[3]")
	public WebElement MonthEnd_EmpMgrMeals_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[1]")
	public WebElement MonthEnd_EmpMgrMeals_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[2]")
	public WebElement MonthEnd_EmpMgrMeals_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Emp/Mgr Meals']/following-sibling::td[5]")
	public WebElement MonthEnd_EmpMgrMeals_DifferenceDollar_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[3]")
	public WebElement MonthEnd_DiscountCoupon_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[1]")
	public WebElement MonthEnd_DiscountCoupon_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[2]")
	public WebElement MonthEnd_DiscountCoupon_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Discounts/Coupons']/following-sibling::td[5]")
	public WebElement MonthEnd_DiscountCoupon_DifferenceDollar_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[3]")
	public WebElement MonthEnd_CompletedWaste_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[1]")
	public WebElement MonthEnd_CompletedWaste_TargetPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[2]")
	public WebElement MonthEnd_CompletedWaste_AcutalPercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Completed Waste']/following-sibling::td[5]")
	public WebElement MonthEnd_CompletedWaste_DifferenceDollar_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[3]")
	public WebElement MonthEnd_StatVariance_DifferencePercent_Value;
	
	@FindBy(xpath = "//table[@id='month_end_contributors']/tbody/tr/td[text()='Stat Variance']/following-sibling::td[5]")
	public WebElement MonthEnd_StatVariance_DifferenceDollar_Value;
	
	
	public void postCommentForCurrentMonth(String comment) throws InterruptedException{
		System.out.println("comment "+comment);
		wait.until(ExpectedConditions.visibilityOf(PostCommentForCurrentMonth_BT)).click();
		wait.until(ExpectedConditions.elementToBeClickable(CommentBox_TB)).clear();
		Thread.sleep(1000);
		CommentBox_TB.sendKeys(comment);
		SaveComment_BT.click();
		wait.until(ExpectedConditions.visibilityOf(Projections_ChangesSaved_Confirmation_MSG));
		Thread.sleep(2000);
	}
	
	/**********************New UI************************/
	
	public boolean verifyDifferencePercentageValueForCurrentMonth() throws InterruptedException{
		boolean result = true;
		for(int i = 0;i<CurrentMonth_TargetPercent_List.size();i++){
			String targetPercentage = CurrentMonth_TargetPercent_List.get(i).getText().replace("%", "");
			BigDecimal target;
			if(targetPercentage.contains("-")){
				target = new BigDecimal(targetPercentage.replace("-", "").trim()).negate();
			}else{
				target = new BigDecimal(targetPercentage);
			}
			System.out.println("target % : "+ target);
			String actualPercentage = CurrentMonth_ActualPercent_List.get(i).getText().replace("%", "").trim();
			BigDecimal actual;
			if(actualPercentage.contains("-")){
				actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
			}else{
				actual = new BigDecimal(actualPercentage);
			}
			System.out.println("actual % : "+ actual);
			String diff = CurrentMonth_DifferencePercent_List.get(i).getText().replace("%", "").trim();
			System.out.println("diff % : "+ diff);
			BigDecimal calculatedDiff = target.subtract(actual);
			System.out.println("calculatedDiff % : "+ calculatedDiff);
			System.out.println("Result is "+calculatedDiff.toString().equals(diff));
			result = result & calculatedDiff.toString().equals(diff);
		}
		return result;
	}
	
	public boolean verifyDifferencePercentageValueForMonthEnd() throws InterruptedException{
		boolean result = true;
		for(int i = 0;i<MonthEnd_TargetPercent_List.size();i++){
			String targetPercentage = MonthEnd_TargetPercent_List.get(i).getText().replace("%", "");
			BigDecimal target;
			if(targetPercentage.contains("-")){
				target = new BigDecimal(targetPercentage.replace("-", "").trim()).negate();
			}else{
				target = new BigDecimal(targetPercentage);
			}
			System.out.println("target % : "+ target);
			String actualPercentage = MonthEnd_ActualPercent_List.get(i).getText().replace("%", "").trim();
			BigDecimal actual;
			if(actualPercentage.contains("-")){
				actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
			}else{
				actual = new BigDecimal(actualPercentage);
			}
			System.out.println("actual % : "+ actual);
			String diff = MonthEnd_DifferencePercent_List.get(i).getText().replace("%", "").trim();
			System.out.println("diff % : "+ diff);
			BigDecimal calculatedDiff = target.subtract(actual);
			System.out.println("calculatedDiff % : "+ calculatedDiff);
			System.out.println("Result is "+calculatedDiff.toString().equals(diff));
			result = result & calculatedDiff.toString().equals(diff);
		}
		return result;
	}
	
	public boolean verifyDifferenceDollerValueForCurrentMonth() throws InterruptedException{
		boolean result = true;
		for(int i = 0;i<CurrentMonth_DifferencePercent_List.size();i++){
			//Get Actual Percentage Value
			String actualPercentage = CurrentMonth_DifferencePercent_List.get(i).getText().replace("%", "").trim();
			BigDecimal actual;
			if(actualPercentage.contains("-")){
				actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
			}else{
				actual = new BigDecimal(actualPercentage);
			}
			//Get Difference Dollar Value
			String diff = CurrentMonth_DifferenceDoller_List.get(i).getText().replace("$", "").trim();
			BigDecimal actualDoller;
			if(diff.contains("-")){
				actualDoller = new BigDecimal(diff.replace("-", "").trim()).negate();
			}else{
				actualDoller = new BigDecimal(diff);
			}
			BigDecimal netSales = new BigDecimal(CurrentMonth_NetSales_Value.getText().replace("$", ""));
			BigDecimal calculatedPercent = actualDoller.divide(netSales,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
			BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
			BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
			System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
			//Verify Difference Dollar Value matches with the calculated value
			result = result & (calculatedPercent1.equals(actual) || calculatedPercent2.equals(actual));
		}
		return result;
	}
	
	public boolean verifyDifferenceDollerValueForMonthEnd() throws InterruptedException{
		boolean result = true;
		for(int i = 0;i<MonthEnd_DifferencePercent_List.size();i++){
			//Get Actual Percentage Value
			String actualPercentage = MonthEnd_DifferencePercent_List.get(i).getText().replace("%", "").trim();
			BigDecimal actual;
			if(actualPercentage.contains("-")){
				actual = new BigDecimal(actualPercentage.replace("-", "").trim()).negate();
			}else{
				actual = new BigDecimal(actualPercentage);
			}
			//Get Difference Dollar Value
			String diff = MonthEnd_DifferenceDoller_List.get(i).getText().replace("$", "").trim();
			BigDecimal actualDoller;
			if(diff.contains("-")){
				actualDoller = new BigDecimal(diff.replace("-", "").trim()).negate();
			}else{
				actualDoller = new BigDecimal(diff);
			}
			BigDecimal netSales = new BigDecimal(MonthEnd_NetSales_Value.getText().replace("$", ""));
			BigDecimal calculatedPercent = actualDoller.divide(netSales,8,RoundingMode.FLOOR).multiply(new BigDecimal(100));
			BigDecimal calculatedPercent1 = calculatedPercent.setScale(2, BigDecimal.ROUND_DOWN);
			BigDecimal calculatedPercent2 = calculatedPercent.setScale(2, BigDecimal.ROUND_UP);
			System.out.println("expected percent   "+calculatedPercent1+" 2 "+calculatedPercent2);
			result = result & (calculatedPercent1.equals(actual) || calculatedPercent2.equals(actual));
		}
		return result;
	}
	
	public void editTargetPercentValues(String validValue) throws InterruptedException{
		Thread.sleep(2000);
		Projections_NetSalesTarget_TB.clear();
		Projections_NetSalesTarget_TB.sendKeys(validValue);
		Projections_BaseFoodTarget_TB.clear();
		Projections_BaseFoodTarget_TB.sendKeys(validValue);
		Projections_CompletedWasteTarget_TB.clear();
		Projections_CompletedWasteTarget_TB.sendKeys(validValue);
		Projections_RawWasteTarget_TB.clear();
		Projections_RawWasteTarget_TB.sendKeys(validValue);
		Projections_CondimentsTarget_TB.clear();
		Projections_CondimentsTarget_TB.sendKeys(validValue);
		Projections_EmpMgrMealsTarget_TB.clear();
		Projections_EmpMgrMealsTarget_TB.sendKeys(validValue);
		Projections_DiscountCouponsTarget_TB.clear();
		Projections_DiscountCouponsTarget_TB.sendKeys(validValue);
		Projections_StatVarianceTarget_TB.clear();
		Projections_StatVarianceTarget_TB.sendKeys(validValue);
		Projections_UnexplainedTarget_TB.clear();
		Projections_UnexplainedTarget_TB.sendKeys(validValue);
		Thread.sleep(2000);
		Projections_ApplyTargets_BT.click();
		wait.until(ExpectedConditions.visibilityOf(Projections_ChangesSaved_Confirmation_MSG));
	}
	
	public boolean verifyHistoricalProjectionsDataDisplayed(){
		boolean productNetSalesDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Product Net Sales");
		boolean baseFoodDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Base Food");
		boolean completedWasteDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Completed Waste");
		boolean rawWasteDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Raw Waste");
		boolean condimentsDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Condiments");
		boolean empMgrMealsDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Emp/Mgr Meals");
		boolean discountCouponsDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Discount/Coupons");
		boolean statVarianceDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Stat Variance");
		boolean unexplainedDisplayedForPast3Months = verifyDataDisplayedForLastThreeMonths("Unexplained");
		return productNetSalesDisplayedForPast3Months & baseFoodDisplayedForPast3Months
				& completedWasteDisplayedForPast3Months & rawWasteDisplayedForPast3Months
				& condimentsDisplayedForPast3Months & empMgrMealsDisplayedForPast3Months
				& discountCouponsDisplayedForPast3Months & statVarianceDisplayedForPast3Months
				& unexplainedDisplayedForPast3Months;
	}
	
	public boolean verifyDataDisplayedForLastThreeMonths(String fieldName){
		System.out.println("Month 1 "+driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[1]")).getText());
		System.out.println("Month 2 "+driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[2]")).getText());
		System.out.println("Month 3 "+driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[3]")).getText());
		return !driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[1]")).getText().isEmpty()
				& !driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[2]")).getText().isEmpty()
				& !driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[3]")).getText().isEmpty();
	}
	
	public boolean verifyCommentsDisplayedForLastThreeMonths(){
		return driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Factors impacting food cost']/following-sibling::td[1]/textarea")).isDisplayed()
				& driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Factors impacting food cost']/following-sibling::td[2]/textarea")).isDisplayed()
				& driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='Factors impacting food cost']/following-sibling::td[3]/textarea")).isDisplayed();
	}
	
	public String[] getDataForLastThreeMonths(String fieldName){
		String data1 = driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[1]")).getText();
		String data2 = driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[2]")).getText();
		String data3 = driver.findElement(By.xpath("//table[@id='projections_right']/tbody/tr/td[text()='"+fieldName+"']/following-sibling::td[3]")).getText();
		String[] precedingMonthData = new String[]{data1,data2,data3};
		return precedingMonthData;
	}
	
	
	
}
