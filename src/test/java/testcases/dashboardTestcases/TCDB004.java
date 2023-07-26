package testcases.dashboardTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCDB004 extends BaseClass {

	@Test
	public void checkChallengeCountDownShowing() {

		testStepsLog("Login user");
		loginpage.Login("User 2");

		testStepsLog("Verify upcoming challenge countdown is showing");
		visibilityOfElement(dashboardpage.upcomingChallengeCountdownDiv);
		testVerifyLog("upcoming challenge countdown is showing");

	}
}
