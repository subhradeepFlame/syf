package testcases.challengeVideoTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV006 extends BaseClass{
	
	@Test
	public void viewDetailsOfVideos() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Click on a challenge video sub category");
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getFirstVideoSubCategoryName());
		
		testStepsLog("Click on the view details icon of the video");
		clickOn(challengevideospage.viewDetailsIcon);
		
		testStepsLog("Verify video details are showing");
		visibilityOfElement(challengevideospage.videoDetails);
		testVerifyLog("video details are showing");
		
	}

}
