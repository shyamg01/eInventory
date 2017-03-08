package purchasesBundle;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import eInventoryPageClasses.AbstractTest;
import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.ReadTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.ManualInvoiceNewPage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.ViewPurchaseHistoryPage;

public class US461_ShowProductCategoryOnElectronicAndManualInvoicePage extends AbstractTest{
	
	//TC1267 : Show Product Category $ amounts on an Electronic Invoice and on Manual Purchase Detail page
	@Test(enabled =false)
	public void purchasesBundle_US461_TC1267() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US461_TC1267";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US758_TC1356", "Object1");
		String wrinId1 = ReadTestData.getTestData(purchasesPageSheet,"WrinId1");
		String wrinId2 = ReadTestData.getTestData(purchasesPageSheet,"WrinId2");
		String electronicInvoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.clickOnApproveButtonForElectronicPurchase(electronicInvoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveElectronicInvoice_PopUp_Lable));
		BigDecimal subtotalForWrin1= new BigDecimal(purchasesPage.getSubTotalForWrinItemForElectronicInvoice(wrinId1));
		BigDecimal subtotalForWrin2= new BigDecimal(purchasesPage.getSubTotalForWrinItemForElectronicInvoice(wrinId2));
		BigDecimal totalAmount = subtotalForWrin1.add(subtotalForWrin2);
		BigDecimal breakDownCost= new BigDecimal(purchasesPage.getBreakDownCostForEachCategory(productCategory).substring(0));
		if (totalAmount.equals(breakDownCost)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view subtotal on 'E'  for product category P1 as break down by cost type for WRIN id1:X1  and WRIN id2:X2",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view subtotal on 'E'  for product category P1 as break down by cost type for WRIN id1:X1  and WRIN id2:X2",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1269 : Verify the subtotal in existing Manual Purchase is calculated in dollar for each product category
	@Test()
	public void purchasesBundle_US461_TC1269() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US461_TC1269";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		String wrinId1 = GlobalVariable.wrinID_Food;
		String productCategory1 = GlobalVariable.productCategoryFood;
		String wrinId2 = GlobalVariable.wrinID_Paper;
		String productCategory2 = GlobalVariable.productCategorypPaper;
		String vendor = GlobalVariable.vendorName;
		String quantity = "1";
		String casePrice = "10";
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.CreateManualInvoice_BT));
		ManualInvoiceNewPage manualInvoiceNewPage = purchasesPage.goToManualInvoiceNewPage();
		manualInvoiceNewPage.selectAVendor(vendor).seacrhAndSelectRawItem(wrinId1).enterQuantityForMultipleWrin(wrinId1, quantity);
		manualInvoiceNewPage.enterCasePriceForMultipleWrin(wrinId1, casePrice);
		manualInvoiceNewPage.seacrhAndSelectRawItem(wrinId2).enterQuantityForMultipleWrin(wrinId2, quantity);
		manualInvoiceNewPage.enterCasePriceForMultipleWrin(wrinId2, casePrice);
		String subtotalForWrin1= purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId1);
		System.out.println("subtotalForWrin1 "+subtotalForWrin1);
		String subtotalForWrin2= purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId2);
		System.out.println("subtotalForWrin2 "+subtotalForWrin2);
		String breakDownCostForCategory1 = purchasesPage.getBreakDownCostForEachCategory(productCategory1).substring(1);
		System.out.println("breakDownCostForCategory1 "+breakDownCostForCategory1);
		String breakDownCostForCategory2 = purchasesPage.getBreakDownCostForEachCategory(productCategory2).substring(1);
		System.out.println("breakDownCostForCategory2 "+breakDownCostForCategory2);
		if (breakDownCostForCategory1.contains(subtotalForWrin1)
				& breakDownCostForCategory2.contains(subtotalForWrin2)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the subtotal value in front of Prod Category P1 and P2 for WRIN Id1 X1 and WRIN id2 X2",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the subtotal value in front of Prod Category P1 and P2 for WRIN Id1 X1 and WRIN id2 X2",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	
	//TC1270 : Verify that for WRINs belonging to condiment category,their sub-total value is categorized and calculated under "Total Food" category for manual and electronic invoice
	@Test(enabled =false)
	public void purchasesBundle_US461_TC1270() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US461_TC1270";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US461_TC1270", "Object1");
		String wrinId1 = ReadTestData.getTestData(purchasesPageSheet,"WrinId1");
		String wrinId2 = ReadTestData.getTestData(purchasesPageSheet,"WrinId2");
		String electronicInvoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		String quantity = ReadTestData.getTestData(purchasesPageSheet,"Quantity");
		String vendor = ReadTestData.getTestData(purchasesPageSheet,"Vendor");
		String invoiceNumber = Base.randomNumberFiveDigit();
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId1, quantity, "");
		purchasesPage.clickOnApproveButtonForManualPurchase(invoiceNumber);
		String subtotalForWrin1= purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId1);
		String breakDownCostForProductCategory = purchasesPage.getBreakDownCostForEachCategory(productCategory).substring(1);
		if (subtotalForWrin1.equals(breakDownCostForProductCategory)) {
			Reporter.reportPassResult(
					browser,
					"Verify that for WRINs belonging to condiment category,their sub-total value is categorized and calculated under Total Food category for manual invoice",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify that for WRINs belonging to condiment category,their sub-total value is categorized and calculated under Total Food category for manual invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		purchasesPage.ManualInvoiceApprove_Close_BT.click();
		Thread.sleep(3000);
		purchasesPage.clickOnApproveButtonForElectronicPurchase(electronicInvoiceId);
		String subtotalForWrin2= purchasesPage.getSubTotalForWrinItemForManualInvoice(wrinId2);
		System.out.println("subtotalForWrin2 "+subtotalForWrin2);
		breakDownCostForProductCategory = purchasesPage.getBreakDownCostForEachCategory(productCategory).substring(1);
		if (subtotalForWrin2.equals(breakDownCostForProductCategory)) {
			Reporter.reportPassResult(
					browser,
					"Verify that for WRINs belonging to condiment category,their sub-total value is categorised and calculated under Total Food category for electronic invoice",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"Verify that for WRINs belonging to condiment category,their sub-total value is categorised and calculated under Total Food category for electronic invoice",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC3507 : Verify the subtotal in existing Electronic Invoice is calculated in dollar for each product category
	@Test(enabled = false)
	public void purchasesBundle_US461_TC3507() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US461_TC3507";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US461_TC3507", "Object1");
		String electronicInvoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String productCategory = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		purchasesPage.clickOnApproveButtonForElectronicPurchase(electronicInvoiceId);
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.ApproveElectronicInvoice_PopUp_Lable));
		String subtotalForInvoice= purchasesPage.getSubTotalAmountForElectronicInvoice();
		String breakDownCost= purchasesPage.getBreakDownCostForEachCategory(productCategory).substring(1);
		if (subtotalForInvoice.equals(breakDownCost)) {
			Reporter.reportPassResult(
					browser,
					"subtotal in existing Electronic Invoice is calculated in dollar for each product category",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"subtotal in existing Electronic Invoice is calculated in dollar for each product category",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}
	
	//TC1271 : Verify that subtotal field is shown for existing posted electronic and manual invoices
	@Test(enabled = false)
	public void purchasesBundle_US461_TC1271() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException, ParseException {
		/** Variable Section : **/
		AbstractTest.tcName="purchasesBundle_US461_TC1271";
		String password = LoginTestData.level1_SSO_Password;
		String userId = LoginTestData.level1_SSO_UserId;
		String storeId = LoginTestData.level1StoreId;
		HSSFSheet purchasesPageSheet = ReadTestData.getTestDataSheet("purchasesBundle_US461_TC1271", "Object1");
		String wrinId1 = ReadTestData.getTestData(purchasesPageSheet,"WrinId1");
		String wrinId2 = ReadTestData.getTestData(purchasesPageSheet,"WrinId2");
		String electronicInvoiceId =ReadTestData.getTestData(purchasesPageSheet,"Electronic Invoice Id");
		String productCategory1 = ReadTestData.getTestData(purchasesPageSheet,"WrinId1Category");
		String productCategory2 = ReadTestData.getTestData(purchasesPageSheet,"WrinId2Category");
		String quantity = ReadTestData.getTestData(purchasesPageSheet,"Quantity");
		String vendor = ReadTestData.getTestData(purchasesPageSheet,"Vendor");
		String invoiceNumber = Base.randomNumberFiveDigit();
		String startDate = GlobalVariable.startDate;
		String endDate = GlobalVariable.endDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManualInvoiceNewPage manualInvoiceNewPage = PageFactory.initElements(driver, ManualInvoiceNewPage.class);
		ViewPurchaseHistoryPage viewPurchaseHistoryPage = PageFactory.initElements(driver, ViewPurchaseHistoryPage.class);
		PurchasesPage purchasesPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPurchaseLandingPage();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		manualInvoiceNewPage.createAManualPurchase(vendor, invoiceNumber, wrinId1, quantity, "");
		purchasesPage.approveAManualInvoice(invoiceNumber);
		purchasesPage.ViewHistory_BT.click();
		viewPurchaseHistoryPage.selectStartDateToViewHistory(startDate).selectEndDateToViewHistory(endDate).ViewHistory_Vendor_DD.click();
		viewPurchaseHistoryPage.ViewHistory_ShowResults_BT.click();
		Thread.sleep(5000);
		viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(invoiceNumber);
		String subtotalForWrin1= viewPurchaseHistoryPage.getSubTotalForWrinItemForInvoice(wrinId1);
		System.out.println("Manual invoice subtotalForWrin1 "+subtotalForWrin1);
		String subtotalForWrin2= viewPurchaseHistoryPage.getSubTotalForWrinItemForInvoice(wrinId2);
		System.out.println("Manual invoice subtotalForWrin2 "+subtotalForWrin2);
		String breakDownCostForCategory1 = viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory1).substring(1);
		System.out.println("Manual invoice breakDownCostForCategory1 "+breakDownCostForCategory1);
		String breakDownCostForCategory2 = viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory2).substring(1);
		System.out.println("Manual invoice breakDownCostForCategory2 "+breakDownCostForCategory2);
		if (subtotalForWrin1.equals(breakDownCostForCategory1)
				& subtotalForWrin2.equals(breakDownCostForCategory2)) {
			Reporter.reportPassResult(
					browser,
					"Manual Invoice :User should be able to view the calculated subtotal in $ for WRIN id1:X1 under category P1 and calculated subtotal in $ for WRIN id2:X2 under category P2",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Manual Invoice :User should be able to view the calculated subtotal in $ for WRIN id1:X1 under category P1 and calculated subtotal in $ for WRIN id2:X2 under category P2",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
		viewPurchaseHistoryPage.ViewInvoiceForm_Close_BT.click();
		Thread.sleep(5000);
		viewPurchaseHistoryPage.clickOnPostedPurchaseRecord(electronicInvoiceId);
		subtotalForWrin1= viewPurchaseHistoryPage.getSubTotalForWrinItemForInvoice(wrinId1);
		System.out.println("Electronic invoice subtotalForWrin1 "+subtotalForWrin1);
		subtotalForWrin2= viewPurchaseHistoryPage.getSubTotalForWrinItemForInvoice(wrinId2);
		System.out.println("Electronic invoice subtotalForWrin2 "+subtotalForWrin2);
		breakDownCostForCategory1 = viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory1).substring(1);
		System.out.println("Electronic invoice breakDownCostForCategory1 "+breakDownCostForCategory1);
		breakDownCostForCategory2 = viewPurchaseHistoryPage.getBreakDownCostForEachCategory(productCategory2).substring(1);
		System.out.println("Electronic invoice  breakDownCostForCategory2 "+breakDownCostForCategory2);
		if (subtotalForWrin1.equals(breakDownCostForCategory1)
				& subtotalForWrin2.equals(breakDownCostForCategory2)) {
			Reporter.reportPassResult(
					browser,
					"Electronic Invoice :User should be able to view the calculated subtotal in $ for WRIN id1:X1 under category P1 and calculated subtotal in $ for WRIN id2:X2 under category P2",
					"Pass");
			
		} else {
			Reporter.reportTestFailure(
					browser,
					"Electronic Invoice :User should be able to view the calculated subtotal in $ for WRIN id1:X1 under category P1 and calculated subtotal in $ for WRIN id2:X2 under category P2",
					"Fail");
			AbstractTest.takeSnapShot();
			
		}
	}

}
