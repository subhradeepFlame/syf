package testcases.livestreamTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCLS001 extends BaseClass{
	
	@Test
	public void verifyLivestreamDetailsAreShowing() {
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Click on the Livestream");
		dashboardpage.ClickOnLeftMenu("Livestream");
		
		testStepsLog("Verify program details are showing");
		visibilityOfElement(livestreampage.programDetailsText);
		testVerifyLog("program details are showing");
		
	}

}
