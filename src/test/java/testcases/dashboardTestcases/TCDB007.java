package testcases.dashboardTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCDB007 extends BaseClass{

	@Test
	public void checkTransformationVideoUpload() {
		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("upload before video");
		dashboardpage.uploadTransformationVideo("Before");
		
		String beforeVideoNotification = commonpage.getNotificationMessage();
		
		testStepsLog("Verify success messsage");
		Assert.assertEquals(beforeVideoNotification, "Video uploaded successfully");
		testVerifyLog("Success message showing : "+beforeVideoNotification);
		
		testStepsLog("Verify Before Video is uploaded");
		visibilityOfElement(dashboardpage.beforeVideoDeleteIcon);
		testVerifyLog("Before video is uploaded");
		
		testStepsLog("upload after video");
		dashboardpage.uploadTransformationVideo("After");
		
		String afterVideoNotification = commonpage.getNotificationMessage();
		
		testStepsLog("Verify success messsage");
		Assert.assertEquals(afterVideoNotification, "Video uploaded successfully");
		testVerifyLog("Success message showing : "+afterVideoNotification);
		
		testStepsLog("Verify After Video is uploaded");
		visibilityOfElement(dashboardpage.afterVideoDeleteIcon);
		testVerifyLog("Before video is uploaded");
		
		testStepsLog("Delete before video");
		dashboardpage.deleteTransformationVideo("Before");
		
		String deleteBeforeVideoMessage= commonpage.getNotificationMessage();
		
		testStepsLog("Verify the success message");
		Assert.assertEquals(deleteBeforeVideoMessage, "Video deleted successfully");
		testVerifyLog("Success message showing : "+deleteBeforeVideoMessage);
		
		testStepsLog("Verify before video is deleted");
		visibilityOfElement(dashboardpage.beforeVideoUploadButton);
		testVerifyLog("before video is deleted");
		
		testStepsLog("Delete after video");
		dashboardpage.deleteTransformationVideo("After");
		
		String deleteAfterVideoMessage= commonpage.getNotificationMessage();
		
		testStepsLog("Verify the success message");
		Assert.assertEquals(deleteAfterVideoMessage, "Video deleted successfully");
		testVerifyLog("Success message showing : "+deleteAfterVideoMessage);
		
		testStepsLog("Verify before video is deleted");
		visibilityOfElement(dashboardpage.afterVideoUploadButton);
		testVerifyLog("After video is deleted");
		

		
		
	}
}
