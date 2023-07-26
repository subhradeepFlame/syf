package testcases.heatOnDemandTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCHOD003 extends BaseClass { 
	
	
	@Test
	public void VerifyUserScrollVideos()
	{
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Click on the Heat On Demand");
		dashboardpage.ClickOnLeftMenu("Heat On Demand");
		
		testStepsLog("Click on the right arrow icon of a video category");
		clickOn(heatondemandpage.HODvideorightSlideIcon);
		
		testStepsLog("Verify next video category is showing");
		heatondemandpage.checkHODvideoSubCategoryIsVisible("06");
		testVerifyLog("Next video category is showing");
		
	}
}
		
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	















