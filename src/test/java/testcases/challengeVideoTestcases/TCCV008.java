package testcases.challengeVideoTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV008 extends BaseClass{
	
	@Test
	public void checkRelatedVideos() {
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on the challege videos");
		dashboardpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Click on a video category which have multiple videos");
		System.out.println("asdasd: "+challengevideospage.getMultipleVideoInsideSubCategoryName());
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getMultipleVideoInsideSubCategoryName());
		
		testStepsLog("Click on a video ");
		challengevideospage.clickOnVideo(challengevideospage.getFirstVideoName());
		
		testStepsLog("Verify related videos are showing");
		visibilityOfElement(challengevideospage.relatedVideos);
		testVerifyLog("Related videos are showing");
		
		testStepsLog("Click on the challege videos");
		dashboardpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Click on a video category which have only 1 video inside");
		System.out.println("asdasd: "+challengevideospage.getSingleVideoInsideSubCategoryName());
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getSingleVideoInsideSubCategoryName());
		
		testStepsLog("Click on the video ");
		challengevideospage.clickOnVideo(challengevideospage.getFirstVideoName());
		
		testStepsLog("Verify text showing This category contains only one video");
		visibilityOfElement(challengevideospage.noRelatedVideosAvaialableText);
		testVerifyLog("Related videos are showing");
		
		
		
	}

}
