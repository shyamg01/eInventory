package rawItemActivityBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.GlobalVariable;
import common.LoginTestData;
import common.Reporter;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import eInventoryPageClasses.RawItemActivityPage;
import eInventoryPageClasses.AbstractTest;

public class US1813_RemoveDetailsColumnAddVarianceDifferenceAndUserColumns extends AbstractTest {
	

	
	//TC4056 : Verify that, First Name or Nickname is displayed for person who has submitted physical inventory. 
	@Test()
	public void rawItemActivity_US1813_TC4056() throws RowsExceededException,
			BiffException, WriteException, IOException, InterruptedException {
		/** Variable Section : **/
		AbstractTest.tcName="rawItemActivity_US1813_TC4056";
		String password = LoginTestData.password;
		String userId = LoginTestData.userId;
		String storeId = LoginTestData.StoreId;
		String looseQTY=Integer.toString(Base.generateNdigitRandomNumber(1));
		String createDate = Base.returnTodayDate();
		String samplewRINID = GlobalVariable.wrinWithAllTypes;
		/***********************************/
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage = homePage.selectUserWithSSOLogin(userId, password).selectLocation(storeId)
				.goToPhysicalInventoryPage();
		//Create a Physical Inventory
		physicalInventoryPage.submitDailyInventoryForAWrin(samplewRINID, "", "", looseQTY);
		Thread.sleep(5000);
		RawItemActivityPage rawItemActivityPage = homePage.goToRawItemActivityPage();
		rawItemActivityPage.searchAndSelectWRINID(samplewRINID);
		Thread.sleep(5000);
		String creater=driver.findElement(By.xpath("//span[@id='eid_name']")).getText().trim();
		String formattedDate = Base.getFormattedDate1(createDate);
		System.out.println("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+looseQTY+"')]/../../following-sibling::td[3]/span/strong");
		String expCreatedBy=driver.findElement(By.xpath("//table[@id='raw_item_detail_table']/tbody/tr[contains(@class,'date"+formattedDate+"')]/td[2]/span/strong[contains(text(),'INVENTORY')]/../../following-sibling::td[2]/span/strong[contains(text(),'"+looseQTY+"')]/../../following-sibling::td[3]/span/strong")).getText().trim();
		if(expCreatedBy.split("-")[0].trim().equalsIgnoreCase(creater)){
			Reporter.reportPassResult(
					browser,
					"User should be able to view the user name who has submitted physical inventory, on the Raw Item Activity page",
					"Pass");
		} else {
			Reporter.reportTestFailure(
					browser,
					"User should be able to view the user name who has submitted physical inventory, on the Raw Item Activity page",
					"Fail");
			AbstractTest.takeSnapShot();
		}
	}

}
