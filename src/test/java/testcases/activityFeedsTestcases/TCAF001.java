package testcases.activityFeedsTestcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCAF001 extends BaseClass{
	
	@Test
	public void VerifyUserCanCreatePost() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String postText="test automation :"+ activityfeedspage.getRandomString(5);
		
		testStepsLog("Login user");
		loginpage.Login("User 3");
		
		testStepsLog("Click on Activity Feeds");
		dashboardpage.ClickOnLeftMenu("Activity Feeds");
		
		testStepsLog("Create a post with a photo");
		activityfeedspage.createPost(postText, activityfeedspage.PhotoFilePath);
		
		testStepsLog("Verify post is uploading text showing");
		visibilityOfElement(activityfeedspage.PhotoIsUploadingText);
		testVerifyLog("post is uploading text showing");
		String PostSuccessMessage = visibilityOfElement(questionnairepage.notification).getText();
		
		testStepsLog("Verify success message showing");
		Assert.assertEquals(PostSuccessMessage, "Post uploaded successfully");
		testVerifyLog("Success message showing");
		
		testStepsLog("Verify created post is showing");
		visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[text()='"+postText+"']")));
		testVerifyLog("Created post is showing");
		
		testStepsLog("Verify post photo is showing");
		visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[text()='"+postText+"']/../..//div[@class='post-media w-full']")));
		testVerifyLog("post photo is showing");
		
	}

}
