package testcases.challengeVideoTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV004 extends BaseClass{
	
	@Test
	public void VerifyUserCanAccessChallengeVideos() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Verify challenge videos are showing");
		visibilityOfElement(challengevideospage.challengeVideosDiv);
		testVerifyLog("challenge videos are showing");
		
		testStepsLog("Click on a challenge video sub category");
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getFirstVideoSubCategoryName());

		testStepsLog("Click on a video");
		challengevideospage.clickOnVideo(challengevideospage.getFirstVideoName());
		
		testStepsLog("Click on the play button");
		clickOn(challengevideospage.videoPlayButton);

		testStepsLog("Verify video is playing");
		Assert.assertEquals(challengevideospage.VerifyVideoIsPlaying(), true);
		testVerifyLog("Video is playing");
		
	}

}
