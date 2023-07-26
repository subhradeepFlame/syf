package testcases.dashboardTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCDB006 extends BaseClass{

	@Test
	public void verifyChallenegeUserDashboardScenarios() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Verify User can see Calorie Goal section");
		visibilityOfElement(dashboardpage.calorieGoalSection);
		testVerifyLog("User can see Calorie Goal section");
		
		testStepsLog("Verify user can see Challenge Videos section");
		visibilityOfElement(dashboardpage.challengeVideosSection);
		testVerifyLog("user can see Challenge Videos section");
		
		testStepsLog("Verify user can see Dsiliked Foods section");
		visibilityOfElement(dashboardpage.dislikedFoodSection);
		testVerifyLog("user can see Dsiliked Foods section");
		
		testStepsLog("Verify user can see Transformation videos section");
		visibilityOfElement(dashboardpage.tansformationVideosSection);
		testVerifyLog("user can see Transformation videos section");
		
	}
}
