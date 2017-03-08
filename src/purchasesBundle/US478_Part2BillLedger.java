package purchasesBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PurchasesPage;
import eInventoryPageClasses.StoreLedgerDetailPage;
import eInventoryPageClasses.TransferLandingPage;
import eInventoryPageClasses.AbstractTest;

public class US478_Part2BillLedger extends AbstractTest
{
	//TC1274 : Verify the change in column header on store ledger page	
		@Test()
		public void purchaseBundle_US478_TC1242() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/**Variable Section :**/
			AbstractTest.tcName="purchaseBundle_US478_TC1242";
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			
			String wrinIDFood = GlobalVariable.wrinID_Food;
			String wrinIDLinens = GlobalVariable.wrinID_Linens;
			String wrinIDNonProductHappyMealPremiums = GlobalVariable.wrinID_NonProductHappyMealPremiums;
			String wrinIDNonProductother = GlobalVariable.wrinID_NonProductother;
			String wrinIDopsSupplier = GlobalVariable.wrinID_opsSupplier;
			String wrinIDPaper = GlobalVariable.wrinID_Paper;
			
			String transferTypeOut = GlobalVariable.transferTypeOut;
			String transferTypeIn = GlobalVariable.transferTypeIn;
			String transferStoreNumber = GlobalVariable.nationalStore1;
			String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
			String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
			String date = GlobalVariable.transferDate;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
			StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);

			//Navigate to Transfer Landing page and click on create new transfer button
			TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
					.goToTransferLandingPage();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			transferLandingPage.removeAllWrinIdFromTransferPage();
			//Get the time of transfer
//			String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
			//Select the transfer type as "in" and select the store from dropdown an add the transfer details
			//Create the transfer type IN transfer
			transferLandingPage.selectTransferType(transferTypeOut).selectLocationToTransfer(transferStoreNumber);
			//Search and select all the types of WRIN
			transferLandingPage.seacrhAndSelectRawItem(wrinIDFood);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDLinens);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDNonProductHappyMealPremiums);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDNonProductother);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDopsSupplier);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDPaper);
			//Insert the Values for inner pack,loose unit and cse quantity
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(0).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(1).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(2).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(3).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(4).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(5).sendKeys(caseQuantity);
			Thread.sleep(3000);
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(0).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(1).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(2).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(3).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(4).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(5).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			Thread.sleep(3000);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(0).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(1).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(2).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(3).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(4).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(5).sendKeys(looseUnitQuantity);
			Thread.sleep(3000);
			//Fetch the Sub total for each WRIN ID
			String subTotal_Out_wrinIDFood= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[1]/td[8]")).getText();
			String subTotal_Out_wrinIDLinens= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[2]/td[8]")).getText();
			String subTotal_Out_wrinIDNonProductHappyMealPremiums= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[3]/td[8]")).getText();
			String subTotal_Out_wrinIDNonProductother= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[4]/td[8]")).getText();
			String subTotal_Out_wrinIDopsSupplier= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[5]/td[8]")).getText();
			String subTotal_Out_wrinIDPaper= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[6]/td[8]")).getText();
			System.out.println("subTotal_Out_wrinIDFood"+subTotal_Out_wrinIDFood);
			System.out.println("subTotal_Out_wrinIDLinens"+subTotal_Out_wrinIDLinens);
			System.out.println("subTotal_Out_wrinIDNonProductHappyMealPremiums"+subTotal_Out_wrinIDNonProductHappyMealPremiums);
			System.out.println("subTotal_Out_wrinIDNonProductother"+subTotal_Out_wrinIDNonProductother);
			System.out.println("subTotal_Out_wrinIDopsSupplier"+subTotal_Out_wrinIDopsSupplier);
			System.out.println("subTotal_Out_wrinIDPaper"+subTotal_Out_wrinIDPaper);
			String totalAmountOfOutType= transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
			System.out.println("totalAmountOfOutType"+totalAmountOfOutType);
			//Submit the transfer
			transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
			//click on the yes button for confirmation
			wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
			transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.Submit_Transfer_Confirmation_MSG));
			Thread.sleep(5000);
			//Now Create the transfer In type transaction
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
			transferLandingPage.removeAllWrinIdFromTransferPage();
			//Get the time of transfer
//			String time=transferLandingPage.InsertNewTransfersPopup_Time_Value.getText().trim();
			//Select the transfer type as "in" and select the store from dropdown an add the transfer details
			//Create the transfer type IN transfer
			transferLandingPage.selectTransferType(transferTypeIn).selectLocationToTransfer(transferStoreNumber);
			//Search and select all the types of WRIN
			transferLandingPage.seacrhAndSelectRawItem(wrinIDFood);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDLinens);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDNonProductHappyMealPremiums);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDNonProductother);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDopsSupplier);
			transferLandingPage.seacrhAndSelectRawItem(wrinIDPaper);
			//Insert the Values for inner pack,loose unit and cse quantity
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(0).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(1).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(2).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(3).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(4).sendKeys(caseQuantity);
			transferLandingPage.AddTransferItemsPopup_CaseCount_TB.get(5).sendKeys(caseQuantity);
			Thread.sleep(3000);
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(0).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(1).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(2).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(3).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(4).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			try {
				// Enter the innerPackQty for the food item
				transferLandingPage.AddTransferItemsPopup_InnerPackCount_TB.get(5).sendKeys(innerPackQuantity);
			} catch (Exception e) {
				// innerPackQty is not applicable for the food item
			}
			Thread.sleep(3000);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(0).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(1).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(2).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(3).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(4).sendKeys(looseUnitQuantity);
			transferLandingPage.AddTransferItemsPopup_LooseCount_TB.get(5).sendKeys(looseUnitQuantity);
			Thread.sleep(3000);
			//Fetch the Sub total for each WRIN ID
			String subTotal_IN_wrinIDFood= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[1]/td[8]")).getText();
			String subTotal_IN_wrinIDLinens= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[2]/td[8]")).getText();
			String subTotal_IN_wrinIDNonProductHappyMealPremiums= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[3]/td[8]")).getText();
			String subTotal_IN_wrinIDNonProductother= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[4]/td[8]")).getText();
			String subTotal_IN_wrinIDopsSupplier= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[5]/td[8]")).getText();
			String subTotal_IN_wrinIDPaper= driver.findElement(By.xpath("//table[@id='transfer_add']/tbody/tr[6]/td[8]")).getText();
			System.out.println("subTotal_IN_wrinIDFood"+subTotal_IN_wrinIDFood);
			System.out.println("subTotal_IN_wrinIDLinens"+subTotal_IN_wrinIDLinens);
			System.out.println("subTotal_IN_wrinIDNonProductHappyMealPremiums"+subTotal_IN_wrinIDNonProductHappyMealPremiums);
			System.out.println("subTotal_IN_wrinIDNonProductother"+subTotal_IN_wrinIDNonProductother);
			System.out.println("subTotal_IN_wrinIDopsSupplier"+subTotal_IN_wrinIDopsSupplier);
			System.out.println("subTotal_IN_wrinIDPaper"+subTotal_IN_wrinIDPaper);
			String totalAmountOfInType= transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
			System.out.println("totalAmountOfOutType"+totalAmountOfInType);
			//Submit the transfer
			transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
			//click on the yes button for confirmation
			wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
			transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
			wait.until(ExpectedConditions.visibilityOf(transferLandingPage.Submit_Transfer_Confirmation_MSG));
			Thread.sleep(5000);
			//Go to View Ledger Page
			homePage.Menu_DD_BT.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT)).click();
			wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
			purchasesPage.ViewLedger_BT.click();
			wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
			Thread.sleep(5000);
	 		//Verify the Out Type Transfer
			String ActualtotalAmountOfOutType=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[4]")).getText();
			String ActualwrinIDFood_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[5]")).getText();
			String ActualwrinIDPaper_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[6]")).getText();
			String ActualwrinIDNonProductother_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[7]")).getText();
			String ActualwrinIDopsSupplier_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[8]")).getText();
			String ActualwrinIDLinens_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[9]")).getText();
			String ActualwrinIDNonProductHappyMealPremiums_Out_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$-"+totalAmountOfOutType+"']/../td[3]/span[text()='Out']/../../td[10]")).getText();
			System.out.println("ActualtotalAmountOfOutType"+ActualtotalAmountOfOutType);
			System.out.println("ActualwrinIDFood_Out_Amount"+ActualwrinIDFood_Out_Amount);
			System.out.println("ActualwrinIDPaper_Out_Amount"+ActualwrinIDPaper_Out_Amount);
			System.out.println("ActualwrinIDNonProductother_Out_Amount"+ActualwrinIDNonProductother_Out_Amount);
			System.out.println("ActualwrinIDopsSupplier_Out_Amount"+ActualwrinIDopsSupplier_Out_Amount);
			System.out.println("ActualwrinIDLinens_Out_Amount"+ActualwrinIDLinens_Out_Amount);
			System.out.println("ActualwrinIDNonProductHappyMealPremiums_Out_Amount"+ActualwrinIDNonProductHappyMealPremiums_Out_Amount);
			if((ActualtotalAmountOfOutType.replace("$", "").replace("-","").equalsIgnoreCase(totalAmountOfOutType)) &&
					(ActualwrinIDFood_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDFood)) &&
					(ActualwrinIDPaper_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDPaper) ) &&
					(ActualwrinIDNonProductother_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDNonProductother) ) &&
					(ActualwrinIDopsSupplier_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDopsSupplier)) &&
					(ActualwrinIDLinens_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDLinens)) &&
					(ActualwrinIDNonProductHappyMealPremiums_Out_Amount.replace("$", "").replace("-","").equalsIgnoreCase(subTotal_Out_wrinIDNonProductHappyMealPremiums)))
			{
				Reporter.reportPassResult(
						browser,
						"User should able to find subtotal for each product category(Food, Paper, Ops Supplies, Linens, Non-product Happy Meal Premiums, Non-product Other) present in initiated transfer out.",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should able to find subtotal for each product category(Food, Paper, Ops Supplies, Linens, Non-product Happy Meal Premiums, Non-product Other) present in initiated transfer out.",
						"Fail");
				AbstractTest.takeSnapShot();
				
			}
			//Verify the In Type Transfer
			String ActualtotalAmountOfInType=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[4]")).getText();
			String ActualwrinIDFood_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[5]")).getText();
			String ActualwrinIDPaper_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[6]")).getText();
			String ActualwrinIDNonProductother_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[7]")).getText();
			String ActualwrinIDopsSupplier_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[8]")).getText();
			String ActualwrinIDLinens_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[9]")).getText();
			String ActualwrinIDNonProductHappyMealPremiums_In_Amount=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[4][preceding-sibling::td/span[text()='"+date+"']][text()='$"+totalAmountOfInType+"']/../td[3]/span[text()='In']/../../td[10]")).getText();
			System.out.println("ActualtotalAmountOfInType"+ActualtotalAmountOfInType);
			System.out.println("ActualwrinIDFood_In_Amount"+ActualwrinIDFood_In_Amount);
			System.out.println("ActualwrinIDPaper_In_Amount"+ActualwrinIDPaper_In_Amount);
			System.out.println("ActualwrinIDNonProductother_In_Amount"+ActualwrinIDNonProductother_In_Amount);
			System.out.println("ActualwrinIDopsSupplier_In_Amount"+ActualwrinIDopsSupplier_In_Amount);
			System.out.println("ActualwrinIDLinens_In_Amount"+ActualwrinIDLinens_In_Amount);
			System.out.println("ActualwrinIDNonProductHappyMealPremiums_In_Amount"+ActualwrinIDNonProductHappyMealPremiums_In_Amount);
			if(ActualtotalAmountOfInType.equalsIgnoreCase("$"+totalAmountOfInType) &&
					ActualwrinIDFood_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDFood) &&
					ActualwrinIDPaper_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDPaper) &&
					ActualwrinIDNonProductother_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDNonProductother) &&
					ActualwrinIDopsSupplier_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDopsSupplier) &&
					ActualwrinIDLinens_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDLinens) &&
					ActualwrinIDNonProductHappyMealPremiums_In_Amount.equalsIgnoreCase("$"+subTotal_IN_wrinIDNonProductHappyMealPremiums))
			{
				Reporter.reportPassResult(
						browser,
						"User should able to find subtotal for each product category(Food, Paper, Ops Supplies, Linens, Non-product Happy Meal Premiums, Non-product: Other) present in initiated transfer IN",
						"Pass");
			}
			else
			{
				Reporter.reportTestFailure(
						browser,
						"User should able to find subtotal for each product category(Food, Paper, Ops Supplies, Linens, Non-product Happy Meal Premiums, Non-product: Other) present in initiated transfer IN",
						"Fail");
				AbstractTest.takeSnapShot();
			}
		}		
	
//TC1274 : Verify the change in column header on store ledger page	
	@Test()
	public void purchaseBundle_US478_TC1274() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/**Variable Section :**/
		AbstractTest.tcName="purchaseBundle_US478_TC1274";
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
		String samplewRINID = GlobalVariable.addTransferItemWrin;
		String transferType2 = GlobalVariable.transferTypeOut;
		String transferStoreNumber = GlobalVariable.nationalStore1;
		String caseQuantity = Integer.toString(Base.generateNdigitRandomNumber(1));
		String innerPackQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String looseUnitQuantity =Integer.toString(Base.generateNdigitRandomNumber(1));
		String date = GlobalVariable.approveDate;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PurchasesPage purchasesPage = PageFactory.initElements(driver, PurchasesPage.class);
		StoreLedgerDetailPage storeLedgerDetailPage = PageFactory.initElements(driver, StoreLedgerDetailPage.class);
		//Navigate to Transfer Landing page and click on create new transfer button
		TransferLandingPage transferLandingPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId).selectLocation(storeId)
				.goToTransferLandingPage();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.CreateNewTransfers_BT)).click();
		wait.until(ExpectedConditions.visibilityOf(transferLandingPage.AddTransferItemsPopup_RawItemsSearchBox_TB));
		transferLandingPage.selectTransferType(transferType2).selectLocationToTransfer(transferStoreNumber)
				.insertAndAddDetailsToTransfer(samplewRINID, caseQuantity,innerPackQuantity, looseUnitQuantity);
		Thread.sleep(2000);
		//Get the total transfer amount
		String amount = transferLandingPage.AddTransferPopup_TotalAmount_Value.getText().split("\\$")[1];
		System.out.println("Amount is"+amount);
		//Submit the transfer
		transferLandingPage.AddTransferItemsPopup_Submit_BT.click();
		//click on the yes button for confirmation
		wait.until(ExpectedConditions.elementToBeClickable(transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT));
		transferLandingPage.SubmitTransferConfirmationPopUp_Yes_BT.click();
		Thread.sleep(5000);
		//Go to Purchase landing page
		homePage.Menu_DD_BT.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(homePage.Purchases_BT));
		Thread.sleep(2000);
		homePage.Purchases_BT.click();
		wait.until(ExpectedConditions.visibilityOf(purchasesPage.Purchases_Label));
		Thread.sleep(5000);
		purchasesPage.ViewLedger_BT.click();
		wait.until(ExpectedConditions.visibilityOf(storeLedgerDetailPage.month_DD));
		Thread.sleep(4000);
		String storeID=driver.findElement(By.xpath("//table[@id='ledger_table']/tbody/tr/td[2][preceding-sibling::td/span[text()='"+date+"'] and following-sibling::td[text()='$-"+amount+"']]/span")).getText();
		if (storeID.equalsIgnoreCase(transferStoreNumber)) {
			Reporter.reportPassResult(
					browser,
					"User should be able to view the correct National Store Number",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the correct National Store Number",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}		
}
