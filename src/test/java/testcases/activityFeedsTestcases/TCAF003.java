package testcases.activityFeedsTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF003 extends BaseClass{

	@Test
	public void VerifyUserCanDeletePost() {
		String postText = "test automation :" + activityfeedspage.getRandomString(5);
		
		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");

		testStepsLog("Create a post without any photo");
		activityfeedspage.createPost(postText, "");
		
		testStepsLog("Verify post is uploading text showing");
		visibilityOfElement(activityfeedspage.PhotoIsUploadingText);
		testVerifyLog("post is uploading text showing");
		String PostSuccessMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify success message showing");
		Assert.assertEquals(PostSuccessMessage, "Post uploaded successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Click on Delete option of the post");
		activityfeedspage.clickOnPostOption(postText, "Delete");
		
		testStepsLog("Click on Accept");
		clickOn(activityfeedspage.confirmAcceptButton);
		String deleteMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify deleted success message showing");
		Assert.assertEquals(deleteMessage, "Post deleted successfully");
		testVerifyLog("Deleted success message showing");
		
		testStepsLog("Verify the post is no longer showing");
		try {
			visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[text()='"+postText+"']")));
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("The post is no longer showing");
		}
		
		
		
		
	}
}
