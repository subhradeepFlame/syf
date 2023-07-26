package testcases.activityFeedsTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF002 extends BaseClass {

	@Test
	public void VerifyUserCanEditPost() {
		String postText = "test automation :" + activityfeedspage.getRandomString(5);
		String modifiedPostText="Modified post :"+ activityfeedspage.getRandomString(4);

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
		
		testStepsLog("Click on edit of the post");
		activityfeedspage.clickOnPostOption(postText, "Edit");
		
		testStepsLog("Modify the text");
		enterValue(activityfeedspage.updatePostTextArea, modifiedPostText);
		
		testStepsLog("Upload photo");
		activityfeedspage.uploadPhotoVideo(activityfeedspage.PhotoFilePath);
		
		testStepsLog("Click on the update button");
		clickOn(activityfeedspage.postUpdateButton);
		
		testStepsLog("Verify updated text is showing");
		visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[text()='"+modifiedPostText+"']")));
		testVerifyLog("Updated text is showing");
		
		testStepsLog("Verify updated photo is showing");
		visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[text()='"+modifiedPostText+"']/../..//div[@class='post-media w-full']")));
		testVerifyLog("Updated photo is showing");
		
		

	}
}
