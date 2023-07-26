package testcases.activityFeedsTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF006 extends BaseClass{

	@Test
	public void verifyUserCanLikePost() {
		
		String postText = "test automation :" + activityfeedspage.getRandomString(5);

		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");

		testStepsLog("Create a post with a photo");
		activityfeedspage.createPost(postText, activityfeedspage.PhotoFilePath);
		String PostSuccessMessage = visibilityOfElement(questionnairepage.notification).getText();

		testStepsLog("Verify success message showing");
		Assert.assertEquals(PostSuccessMessage, "Post uploaded successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Get that post like count");
		int beforeLikeCount= activityfeedspage.getPostTotalLikeCount(postText);
		
		testStepsLog("Like the post");
		activityfeedspage.likePost(postText);
		
		testStepsLog("Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog("After like Get that post like count");
		int afterLikeCount= activityfeedspage.getPostTotalLikeCount(postText);
		
		testStepsLog("Verify like count increased");
		Assert.assertTrue(beforeLikeCount<afterLikeCount);
		testVerifyLog("like count increased");
		
		testStepsLog("Unlike the post");
		activityfeedspage.likePost(postText);
		
		testStepsLog("Refresh the page");
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog("After unlike Get that post like count");
		int afterUnlikeCount= activityfeedspage.getPostTotalLikeCount(postText);
		
		testStepsLog("Verify like count decreased");
		Assert.assertTrue(afterUnlikeCount<afterLikeCount);
		testVerifyLog("like count decreased");
		
	}
	
	
}
