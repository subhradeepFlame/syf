package testcases.challengeVideoTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV002 extends BaseClass{
	
	@Test
	public void VerifyUpcomingChallengCountdownShowing() {
		
		testStepsLog("Login user");
		loginpage.Login("User 2");

		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Verify upcoming challenge countdown is showing");
		visibilityOfElement(challengevideospage.upcomingChallengeCountdownDiv);
		testVerifyLog("upcoming challenge countdown is showing");
	}

}
