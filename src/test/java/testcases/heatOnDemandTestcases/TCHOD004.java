package testcases.heatOnDemandTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCHOD004 extends BaseClass {

	@Test
	public void VerifyUserScrollVideos()
	{
		
		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on the Heat On Demand");
		commonpage.ClickOnLeftMenu("Heat On Demand");
		
		testStepsLog("Filter values");
		heatondemandpage.filterHODvideos(1,2,1);
		
		testStepsLog("Verify searched video is showing");
		visibilityOfElement(heatondemandpage.filteredSubCategoryPlayButton);
		testVerifyLog("Searched video is showing");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
