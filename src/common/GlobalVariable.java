package common;

public class GlobalVariable 
{
	public static String StoreId ;
	public static String testEnvironment="http://qa.ebos.qsrsoft.com/";
	public static String loginMode = "SSO";
	public static String StoreId2 = "10776" ;
	public static String vendorName="Vendor B";
	public static String vendorNumber="1234";
	public static String vendorName1="Sharon's test123";
	public static String vendorNumber1="62754";
	/*************WRIN FOR Store 11089****************/
	public static String wrinID_Food="00001";
	public static String productCategoryFood = "food";
	public static String wrinID_Paper="00116-141";
	public static String productCategorypPaper = "paper";
	public static String wrinID_opsSupplier="00173";
	public static String productCategoryOpsSupplies = "ops supplies";
	public static String wrinID_Linens="00000-222";
	public static String wrinID_NonProductHappyMealPremiums="11824";
	public static String wrinID_NonProductother="00000-444";
	
	/*************State Varient****************/
	//List type value in Raw item activity page should be 'Daily' for below items
	public static String wrinID_01_recepie="00001";
	public static String wrinID_02_recepie="00005";
	//List type value in Raw item activity page should be 'Daily' for below item
	public static String dailyInventoryWrin_YieldValue="00026-041";
	public static String dailyInventoryWrinDescription_YieldValue="Mustard Pouch";
	
	/*********Manual Vendor****************/
	
	public static String wrinIdForNewVendor ="00005";
	public static String purchaseVendorName="Vendor B";

	/**********Purchases Test Data***************/
	public static String createPurchaseWrin="00009";
	public static String createPurchaseWrin1="00002";
	public static String createPurchaseWrinForVendor1="00004";
	public static String viewLedger_monthDate="November 2016";
	
	/******************Raw Item Waste Test Data */
	public static String rawItemWatsewrin1="00001";
	public static String rawItemWastewrin2="00016";
	public static String rawItemWastewrin2Description ="Large Eggs";
	public static String rawItemWastewrin3="00168";
	public static String rawItemWastewrin4="00028";
	/*On Physical inventory page WRIN  was counted 60 days ago with a value of “0”
	The same WRIN has not been posted on an electronic invoice in that time*/
	/******************Raw Item Promo Test Data */
	public static String rawItemPromowrin1="00001";
	public static String rawItemPromowrin2="00016";
	/******************Completed waste Test Data */
	public static String completedWasteWrin1 ="1";
	public static String completedWasteWrin1Description ="Hamburger";
	public static String receipeWrinForCompletedWasteWrin1= "00026";
	public static String receipeWrinForCompletedWasteWrin1_UOMPerCase= "150";
	public static String receipeWrinForCompletedWasteWrin1_CasePrice= "50.6200";
	public static String completedWasteWrin2 ="148";
	public static String completedWasteWrin3 ="1790";
	public static String completedWasteWrin3Description ="Extra Hotcake";
	public static String completedWasteWrin4 ="592";
	public static String completedWasteWrin5 ="31";

	public static String valueMealDescription="2 big mac";
	/******recipe that have the WASTE_INDICATOR = 'Y' in BOM_COMPONENTS'***/
	public static String completedWasteWrin_YWasteIndicator ="5";
	
	/*************************************************/
	/*******Raw Item Activity Data***********/
	public static String rawItem1="00001";
	public static String rawItem2="00016";
	public static String rawItem3="00055";
	public static String middleRangeYieldNumber_00055 = "36";
	public static String rawItem4="00028-075";
	public static String middleRangeYieldNumber_00028 = "120";
	public static String nonRecipeRawItem="00045";
	public static String recipeRawItem="00026";
	public static String rawItemActivitywrin1="00001";
	public static String recepieItemWithYieldValue="00063";//On Raw Item Information Page 'Yield Range' and 'Calculated Yield' should display for this item
	public static String rawItemInformationWrin="00419";
	public static String rawItemInformationWrinWithoutInnerPackDescription="00005";
	//Change the vendor name before execution of purchase
	public static String rawItemActivityWrin="00003";

	/*****************************************/
	/*************Transfer Test Data*****************/
	public static String addTransferItemWrin="00001";
	public static String addTransferItemWrin1="00002";
	public static String addTransferItemWrin1Description="Qtr Pnder Bn Frzn/Next Gen";
	public static String addTransferItemWrin2="00003";
	public static String addTransferItemWrin2CasePrice="15";
	public static String addTransferItemWrin3="00008";
	public static String addTransferItemWrin4="00004";
	public static String transferTypeIn = "In";
	public static String transferTypeOut = "Out";
	public static String transferTypeOffice = "Office";
	public static String nationalStore1="1719";
	public static String nationalStore2="1842";

	/*********************************************
		common Data
	*********************************************/
	public static String createDate = "03/10/2017";
	public static String startDate = "03/03/2017";
	public static String endDate = "03/10/2017";

	/*******Menu Item Activity Data***********/
	public static String menuItem="1";
	public static String menuItemDescription ="Hamburger";
	public static String menuItem2="31";
	public static String startTime = "01:30";
	public static String defaultStartTime ="00:00";
	public static String endTime = "10:00";
	/*****************************************/
	/******Physical Inventory Test Data*******/
	//Frequency should not be edited for these items in RIA Page:
	public static String newFoodItem="00014-162";
	public static String newNonFoodItem="08798-080";
	//Non receipe Item
	public static String nonRecipeItemWithActualUsageZero="00045-237";
	
	public static String wrinWithAllTypes="01245";

	//List type value in Raw item activity page should be 'Daily' for below items
	public static String createDailyInventoryWrin1="00009-000";
	public static String createDailyInventoryWrin1_description="Tartar Sauce Tubes (New)";
	public static String createDailyInventoryWrin1_BASE_UOM_CODE = "TUB";
	public static String createDailyInventoryWrin2="00005-086";
	public static String createDailyInventoryWrin2_BASE_UOM_CODE = "TUB";
	public static String createDailyInventoryWrin3="00015-032";//"00006-330";
	public static String createDailyInventoryWrin3_description="Canadian Bacon/Natl Juice (New)";//"4/1 Patty/4.25 Oz";
	/*****************************************************/
	/************Food OverBase Test Data***************/
	public static String wasteItem1="00028-075";
	//UOM/Case Value for WasteItem1
	public static String wasteItem1_UOMPerCase="5";
	/************************************************/

	/***********AUdit Log Test Data***********/
	//It should be a wrin Id for which manual purchase should not be enabled in Raw Item Activity Page
	public static String rawItemActvityAuditWrin1="03719-036";
	//pick the item for which inventory is submitted only once
	public static String actualUsageItem = "00055-080";


	
}
