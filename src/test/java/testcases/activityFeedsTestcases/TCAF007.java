package testcases.activityFeedsTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF007 extends BaseClass {

	@Test
	public void verifyUserCanCommentPost() {

		String postText = "test automation :" + activityfeedspage.getRandomString(5);
		String comment = "test automation qa";

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

		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog("Add a comment to the post");
		activityfeedspage.addComment(postText, comment);
		visibilityOfElement(questionnairepage.notification);

		testStepsLog("Verify added comment is showing under the post");
		Assert.assertEquals(activityfeedspage.VerifyAddedCommentIsShowing(postText, comment), true);

	}
}
