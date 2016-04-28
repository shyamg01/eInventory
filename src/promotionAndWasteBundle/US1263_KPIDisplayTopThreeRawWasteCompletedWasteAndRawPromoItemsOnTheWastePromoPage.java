package promotionAndWasteBundle;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.Base;
import common.LoginTestData;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PromotionsAndWastePage;
import sprint2.AbstractTest;

public class US1263_KPIDisplayTopThreeRawWasteCompletedWasteAndRawPromoItemsOnTheWastePromoPage extends AbstractTest
{
	// TC3212 : 	Verify the screen available on Promotion & Waste page to view Top three 3 raw waste, completed waste and raw promo items.
		@Test()
		public void pramotionWaste_US1263_TC3212() throws RowsExceededException,
				BiffException, WriteException, IOException, InterruptedException {
			/** Variable Section : **/
			String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
			String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
			String storeId = LoginTestData.supervisorWithRoleAssignmentStoreId;
			/***********************************/
			HomePage homePage = PageFactory.initElements(driver, HomePage.class);
			// Navigate to Transfer Landing page and click on create new transfer button
			PromotionsAndWastePage promotionsAndWastePage = homePage.selectUserWithSSOLogin(userId, password)
					.selectLocation(storeId).navigateToInventoryManagement().goToPromotionsAndWastePage();
			//Click on expend icon
			promotionsAndWastePage.AtAGlance_Expand_Icon.click();
			//Verify that all the required items are displaying
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_Header);
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_RawItemActivity_Label);
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_CurrentDayAsOf_Label);
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_TopRawItemWasted_Column_header);
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_TopRawItemsPromo_Column_header);
			Base.isElementDisplayed(promotionsAndWastePage.AtAGlance_TopCompletedWaste_Column_header);





			
			
		}
		
	
}
