package testcases.challengeVideoTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV007 extends BaseClass {

	@Test
	public void markVideoAsComepleted() {

		testStepsLog("Login user");
		loginpage.Login("User 3");

		testStepsLog("Get the completed challenge video count");
		scrollToElement(dashboardpage.completedChallengeVideoCount);
		String challenegVideoCount = dashboardpage.getCompletedChallengeVideoCount();

		testStepsLog("Click on the challege videos");
		dashboardpage.ClickOnLeftMenu("Challenge Videos");

		testStepsLog("Click on a challenge video sub category");
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getFirstVideoSubCategoryName());

		testStepsLog("Click on a video");
		challengevideospage.clickOnVideo(challengevideospage.getFirstVideoName());
		visibilityOfElement(challengevideospage.videoPlayButton);
		
		testStepsLog("Click on mark as completed checkbox");
		challengevideospage.markAsCompletedCheckbox.click();

		testStepsLog("Click on the dashboard");
		challengevideospage.ClickOnLeftMenu("Dashboard");

		testStepsLog("Get the completed challenge video count");
		scrollToElement(dashboardpage.completedChallengeVideoCount);
		String afterCheckCompletedVideoCount = dashboardpage.getCompletedChallengeVideoCount();

		testStepsLog("Verify In challenge videos section completed video count increased");
		if (Integer.parseInt(challenegVideoCount) < Integer
				.parseInt(afterCheckCompletedVideoCount)) {
			testVerifyLog("challenge videos section completed video count increased");
		} else {
			Assert.fail();
		}
		
		testStepsLog("Click on the challenge videos");
		dashboardpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Click on the same challege video sub category");
		challengevideospage.clickOnVideoSubCategory(challengevideospage.getFirstVideoSubCategoryName());

		testStepsLog("Click on the same video");
		challengevideospage.clickOnVideo(challengevideospage.getFirstVideoName());
		visibilityOfElement(challengevideospage.videoPlayButton);
		
		testStepsLog("Uncheck mark as completed checkbox");
		challengevideospage.markAsCompletedCheckbox.click();
		
		testStepsLog("Click on the dashboard");
		challengevideospage.ClickOnLeftMenu("Dashboard");
		
		testStepsLog("Get the completed challenge video count");
		scrollToElement(dashboardpage.completedChallengeVideoCount);
		String afterUnCheckCompletedVideoCount = dashboardpage.getCompletedChallengeVideoCount();
		
		testStepsLog("Verify In challenge videos section completed video count decreased");
		if (Integer.parseInt(afterUnCheckCompletedVideoCount) < Integer
				.parseInt(afterCheckCompletedVideoCount)) {
			testVerifyLog("Challenge videos section completed video count decreased");
		} else {
			Assert.fail();
		}

	}

}
