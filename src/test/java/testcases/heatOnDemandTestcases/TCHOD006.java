package testcases.heatOnDemandTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCHOD006 extends BaseClass {
	
	@Test
	public void VerifyUserCanCheckProgramOverview()
	{
		
		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on the Heat On Demand");
		commonpage.ClickOnLeftMenu("Heat On Demand");
		
		testStepsLog(" Click on a video sub category");
		heatondemandpage.clickOnHODvideoSubCategory(heatondemandpage. getFirstHODvideoSubCategoryName());
		
		testStepsLog("Verify program details are showing");
		visibilityOfElement(heatondemandpage.programOverview_Workouts);
		visibilityOfElement(heatondemandpage.programOverview_MinsPerHead);
		visibilityOfElement(heatondemandpage.programOverview_skillLevel);
		visibilityOfElement(heatondemandpage.programOverview_Weeks);
		visibilityOfElement(heatondemandpage.programOverview_Hours);
		visibilityOfElement(heatondemandpage.programOverview_Trainer);
		testVerifyLog("program details are showing");
		
		
		
		
        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
