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
	public static String wrinID_Linens="";
	public static String wrinID_NonProductHappyMealPremiums="11824";
	public static String wrinID_NonProductother="02581";
	/*************State Varient****************/
	//List type value in Raw item activity page should be 'Daily' for below items
	public static String wrinID_01_recepie="00001";
	public static String wrinID_02_recepie="00005";
	//List type value in Raw item activity page should be 'Daily' for below item
	public static String dailyInventoryWrin_YieldValue="00009-000";
	public static String dailyInventoryWrinDescription_YieldValue="Tartar Sauce Tubes";
	
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
	/*On Physical inventory page WRIN  was counted 60 days ago with a value of �0�
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
	public static String rawItemActivityWrin="00001";

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


	public static String transferDate="03/07/2017";

	/*********************************************
		common Data
	*********************************************/
	public static String createDate = "03/07/2017";
	public static String approveDate = "03/07/2016";

	public static String time = "03:30";
	public static String transferTime = "03:30";
	public static String startDate = "03/01/2017";
	public static String endDate = "03/07/2017";


	/*******Menu Item Activity Data***********/
	public static String menuItem="1";
	public static String menuItemDescription ="Hamburger";
	public static String menuItem2="31";
	public static String startTime = "01:30";
	public static String defaultStartTime ="00:00";
	public static String endTime = "10:00";
	/*****************************************/
	/******Physical Inventory Test Data*******/
	//List type value in Raw item activity page should be 'Daily' for below items
	public static String wrinWithAllTypes="01245";
	public static String createDailyInventoryWrin1_description="Tartar Sauce Tubes (New)";

	public static String createDailyInventoryWrin1_BASE_UOM_CODE = "TUB";
	public static String createDailyInventoryWrin2="00005-086";
	public static String createDailyInventoryWrin2_BASE_UOM_CODE = "TUB";
	public static String createDailyInventoryWrin3="00015-032";//"00006-330";
	public static String createDailyInventoryWrin3_description="Canadian Bacon/Natl Juice (New)";//"4/1 Patty/4.25 Oz";
	//Wrin Id with leading zeros; List type value in Raw item activity page should be 'Daily' for this Item
	public static String createDailyInventoryWrinLeadingZero="00005-086";
	public static String createDailyInventoryWrinLeadingZero_description="10 To 1 Beef Patty 1/8 In Grnd (New)";
	//Wrin Id with Trailing zeros; List type value in Raw item activity page should be 'Daily' for this Item
	public static String createDailyInventoryWrinTrailingZero="08551-000";
	public static String createDailyInventoryWrinTrailingZero_description="Hi C Orange Lavaburst Syr/Bib (New)";
	//Wrin Id without Inner Pack Description; List type value in Raw item activity page should be 'Daily' for this Item
	public static String createDailyInventoryWrinWithoutInnerPack="00005-086";
	public static String createDailyInventoryWrinWithoutInnerPack_description="10 To 1 Beef Patty 1/8 In Grnd (New)";
	//List type value in Raw item activity page should not be 'Daily' for below item; InnerPack should be available for this item
	public static String dailyInventoryWrin1="00001-573";
	public static String dailyInventoryWrin1_description="Regular Bun/Next Gen/Frozen";
	public static String dailyInventoryWrin1_case_description = "Case";
	public static String dailyInventoryWrin2="00008-044";
	/*****************************************************/
	//Wrin Id for each temperature Zone; List type value in Raw item activity page should be 'Daily' for These Item
	public static String frozenWRIN="00005-086";
	public static String RefrigeratedWRIN="00009-000";
	public static String RefrigeratedWRIN_description="Tartar Sauce Tubes";
	public static String DryWRIN="08551-000";
	/********************************************/
	
	public static String weeklyInventoryWrin1="00005-086";
	public static String weeklyInventoryWrin1_description="10 To 1 Beef Patty 1/8 In Grnd";
	//List type value in Raw item activity page should be 'Weekly' for below items
	public static String createWeeklyInventoryWrin1="00047-065";
	public static String createWeeklyInventoryWrin2="00035-076";
	public static String createWeeklyInventoryWrin3="00116";
	
	//List type value in Raw item activity page should be 'Monthly' for below items
	public static String createMonthlyInventoryWrin1="00117-255";
	public static String createMonthlyInventoryWrin2 = "03282-033";
	public static String createMonthlyInventoryWrin3 = "01207-073";
	public static String createMontlhyInventoryWrin3_description="Clear Entree Salad Bowl Rpet";
	
	
	//Wrin ID with UOM_CONVERSION_FACTOR CASE_PACK_QTY INNERPACK_QTY,BASE_UOM_CODE,ALTERNATE_CASE_DESC Data; Check these Items in Monthly Inventory
	public static String uomConversionItem1 = "00009";
	public static String uomConversionItem1_UOM_CONVERSION_FACTOR = "0.1953125";
	public static String uomConversionItem1_CASE_PACK_QTY = "4.6875";
	public static String uomConversionItem1_INNERPACK_QTY = "0.1953125";
	public static String uomConversionItem1_BASE_UOM_CODE = "TUB";
	public static String uomConversionItem1_ALTERNATE_CASE_DESC = "CASE";
	
	//This Item should have innerPack Field
	public static String uomConversionItem2 = "02913-009";
	public static String uomConversionItem2_UOM_CONVERSION_FACTOR = "1";
	public static String uomConversionItem2_CASE_PACK_QTY = "192";
	public static String uomConversionItem2_INNERPACK_QTY = "48";
	public static String uomConversionItem2_BASE_UOM_CODE = "EA";
	public static String uomConversionItem2_ALTERNATE_CASE_DESC = "CASE";
	public static String uomConversionItem2_ALTERNATE_INNERPACK_DESC = "SLEEVE";
	
	public static String uomConversionItem5 = "00023-117";
	public static String uomConversionItem5_UOM_CONVERSION_FACTOR = "1";
	public static String uomConversionItem5_CASE_PACK_QTY = "720";
	public static String uomConversionItem5_INNERPACK_QTY = "20";
	public static String uomConversionItem5_BASE_UOM_CODE = "EA";
	public static String uomConversionItem5_ALTERNATE_CASE_DESC = "CASE";
	public static String uomConversionItem5_ALTERNATE_INNERPACK_DESC = "SLEEVE";
	
	public static String uomConversionItem3 = "00406-033";
	public static String uomConversionItem3_UOM_CONVERSION_FACTOR = "0.9375";
	public static String uomConversionItem3_CASE_PACK_QTY = "11.25";
	public static String uomConversionItem3_INNERPACK_QTY = "0.9375";
	public static String uomConversionItem3_BASE_UOM_CODE = "CON";
	public static String uomConversionItem3_ALTERNATE_CASE_DESC = "CASE";
	
	//This item should have INNERPACK_QTY = 0
	public static String uomConversionItem4 = "02589-234";
	public static String uomConversionItem4_UOM_CONVERSION_FACTOR = "1";
	public static String uomConversionItem4_CASE_PACK_QTY = "35";
	public static String uomConversionItem4_INNERPACK_QTY = "0";
	public static String uomConversionItem4_BASE_UOM_CODE = "LB";
	public static String uomConversionItem4_ALTERNATE_CASE_DESC = "CASE";
	/*****************************************************************/
	/************Food OverBase Test Data***************/
	public static String wasteItem1="00028-075";
	//UOM/Case Value for WasteItem1
	public static String wasteItem1_UOMPerCase="5";
	/************************************************/

	/***********AUdit Log Test Data***********/
	//It should be a wrin Id for which manual purchase should not be enabled in Raw Item Activity Page
	public static String rawItemActvityAuditWrin1="03114-087";
	


	
}
