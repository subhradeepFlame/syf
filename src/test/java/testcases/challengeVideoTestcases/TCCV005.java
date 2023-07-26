package testcases.challengeVideoTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV005 extends BaseClass{
	
	@Test
	public void verifyUserCanScrollChallengeVideos() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Click on the right arrow icon of any category");
		clickOn(challengevideospage.rightSlideIcon);
		
		testStepsLog("Verify next video category is showing");
		challengevideospage.checkVideoSubCategoryIsVisible("06");
		
		
	}

}
