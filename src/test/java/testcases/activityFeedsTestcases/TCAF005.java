package testcases.activityFeedsTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF005 extends BaseClass {

	@Test
	public void verifyUserCanReportPost() {

		String postText = "test automation :" + activityfeedspage.getRandomString(5);

		testStepsLog("Login user");
		loginpage.Login("User 3");

		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");

		testStepsLog("Create a post with a photo");
		activityfeedspage.createPost(postText, activityfeedspage.PhotoFilePath);
		String PostSuccessMessage = visibilityOfElement(questionnairepage.notification).getText();

		testStepsLog("Verify success message showing");
		Assert.assertEquals(PostSuccessMessage, "Post uploaded successfully");
		testVerifyLog("Success message showing");

		testStepsLog("Logout the user");
		activityfeedspage.ClickOnProfileMenu("Logout");

		testStepsLog("Login with another user");
		loginpage.Login("User 4");
		
		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");

		testStepsLog("Click on Report this post of that post");
		activityfeedspage.clickOnPostOption(postText, "Report this Post");

		testStepsLog("Enter reason");
		enterValue(activityfeedspage.ReportPostReasonField, "Test reason");

		testStepsLog("Click on Submit");
		clickOn(activityfeedspage.ReportPostSubmitButton);
		String reportSuccessMessage = visibilityOfElement(questionnairepage.notification).getText();

		testStepsLog("Verify success message showing");
		Assert.assertEquals(reportSuccessMessage, "Reported Successfully.");
		testVerifyLog("Success message showing");
		
		testStepsLog("Report the same post again");
		activityfeedspage.clickOnPostOption(postText, "Report this Post");

		testStepsLog("Enter reason");
		enterValue(activityfeedspage.ReportPostReasonField, "Test reason");

		testStepsLog("Click on Submit");
		clickOn(activityfeedspage.ReportPostSubmitButton);
		String reportErrorMessage = visibilityOfElement(questionnairepage.notification).getText();

		testStepsLog("Verify error message showing");
		Assert.assertEquals(reportErrorMessage, "You have already reported this post.");
		testVerifyLog("Error message showing");

	}
}
