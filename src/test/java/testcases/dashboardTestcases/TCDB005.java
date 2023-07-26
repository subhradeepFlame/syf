package testcases.dashboardTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCDB005 extends BaseClass{

	@Test
	public void verifyNonChallenegeUserDashboardScenarios() {
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Verify User can't see Calorie Goal section");
		try {
			visibilityOfElement(dashboardpage.calorieGoalSection);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("User can't see Calorie Goal section");
		}
		
		testStepsLog("Verify user can't see Challenge Videos section");
		try {
			visibilityOfElement(dashboardpage.challengeVideosSection);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("user can't see Challenge Videos section");
		}
		
		testStepsLog("Verify user can't see Dsiliked Foods section");
		try {
			visibilityOfElement(dashboardpage.dislikedFoodSection);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("user can't see Dsiliked Foods section");
		}
		
		testStepsLog("Verify user can't see Transformation videos section");
		try {
			visibilityOfElement(dashboardpage.tansformationVideosSection);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("user can't see Transformation videos section");
		}
	}
}
