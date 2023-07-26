package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP005 extends BaseClass {

	@Test
	public void VerifyUserCanAddRemoveProfilePhoto() {

		testStepsLog("Login user");
		loginpage.Login("User 1");

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");

		testStepsLog("Upload a profile photo");
		profilepage.uploadPhotoField.sendKeys(profilepage.profilePhotoPath);

		testStepsLog("Verify success message");
		String successAddMessage = commonpage.getNotificationMessage();
		testVerifyLog("Success message");

		testStepsLog("validate the notification message");
		Assert.assertEquals("Profile Updated Successfully", successAddMessage);

		testStepsLog(" Verfy profile photo is showing");
		visibilityOfElement(profilepage.removeProfileImage);
		testVerifyLog("Profile photo is showing");

		testStepsLog("Click on Remove Under Profle photo");
		clickOn(profilepage.removeProfileImage);

		testStepsLog("Click on Accept");
		clickOn(profilepage.acceptButton);
		String successRemoveMessage = commonpage.getNotificationMessage();

		testStepsLog("validate the notification message");
		Assert.assertEquals("Avatar has been Removed from this profile", successRemoveMessage);

	}

}
