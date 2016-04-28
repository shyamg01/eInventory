package sprint17;

import java.io.IOException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import common.LoginTestData;
import eInventoryPageClasses.HomePage;
import eInventoryPageClasses.PhysicalInventoryPage;
import sprint2.AbstractTest;

public class US763_DisplayUserInformationOnThePhysicalInventoryPagesWhereApplicable extends AbstractTest
{
	
	//TC2704 Verify that the user can view the user(s) first name and last name initial and eID of the user that made a change in the viewable audit table(s) for any change captured on the physical inventory pages.
	
	@Test
	public void sprint17_US763_TC2704() throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
	{
		
		/** Variable Section : **/
		String userId = LoginTestData.supervisorWithRoleAssignment_SSO_UserId;
		String password = LoginTestData.supervisorWithRoleAssignment_SSO_Password;
		/***********************************/
		//Go to Physical Inventory page
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		PhysicalInventoryPage physicalInventoryPage =homePage.selectUserWithSSOLogin(userId, password)
				.navigateToInventoryManagement().goToPhysicalInventoryPage();
		Thread.sleep(4000);
		;
		//To ckeck if the records are present on the page
		if(physicalInventoryPage.NoRecordPresent_MSG.isDisplayed())
		{
			physicalInventoryPage.selectPreviousmonthDate();
			Thread.sleep(5000);
		}
		else
		{
			
		}
		
	}
	
}
