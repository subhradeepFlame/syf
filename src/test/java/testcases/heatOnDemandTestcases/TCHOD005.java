package testcases.heatOnDemandTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCHOD005 extends BaseClass {

		@Test
		public void VerifyUserCanNotSearchHODVideosByInvalidData()
		{
			
			testStepsLog("Login user");
			loginpage.Login("User 4");

			testStepsLog("Click on the Heat On Demand");
			commonpage.ClickOnLeftMenu("Heat On Demand");
			
			testStepsLog("Filter values");
			heatondemandpage.filterHODvideos(1,1,1);
			
			testStepsLog("Verify no record found message is showing");
			visibilityOfElement(heatondemandpage.filterSearchNoRecordsFoundText);
			testVerifyLog("No record found message is showing");
			
			testStepsLog("Click on Clear Filter button");
			clickOn(heatondemandpage.clearFilterButton);
			
			testStepsLog("Verify filter changes removed and all videos are showing");
			visibilityOfElement(heatondemandpage.newAndFeaturedSubCategory);
			testVerifyLog("Filter changes removed and all videos are showing");
			
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
