package testcases.challengeVideoTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCCV001 extends BaseClass{
	
	@Test
	public void verifyUserCanNotAccessChallengVideos() {
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Click on the challenge videos");
		commonpage.ClickOnLeftMenu("Challenge Videos");
		
		testStepsLog("Verify Buy Now button is showing");
		visibilityOfElement(challengevideospage.buyNowButton);
		testVerifyLog("Buy Now button is showing");
		
		testStepsLog("Click on the Buy Now button");
		clickOn(challengevideospage.buyNowButton);
		
		switchTab(1);
		testInfoLog("switched to new tab");
		
		testStepsLog("Verify user redirected to the purchase challenge page");
		Assert.assertEquals(driver.getCurrentUrl(), "https://heatxtreme.com/pages/challenge");
		testVerifyLog("user redirected to the purchase challenge page");
		
	}

}
