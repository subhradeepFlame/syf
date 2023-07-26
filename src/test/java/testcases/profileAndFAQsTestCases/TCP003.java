package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP003 extends BaseClass {

	@Test
	public void VerifyUserCanEditProfileDetails() {

		testStepsLog("Login user");
		loginpage.Login("User 1");

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");

		testStepsLog("Click on Edit Profile");
		clickOn(profilepage.editProfile);

		testStepsLog("Remove FirstName");
		clearElement(profilepage.firstNameField);

		testStepsLog(" Verify save Changes button is not clickable");
		Assert.assertEquals(profilepage.saveChangesButton.isEnabled(), false);
		testVerifyLog("Save Changes button is not clickable");

		testStepsLog("Enter new FirstName");
		enterValue(profilepage.firstNameField, "autoabv");

		testStepsLog("Select gender as female");
		profilepage.selectGender("Female");

		testStepsLog("Click on save button");
		clickOn(profilepage.saveChangesButton);
		String notificationMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify the notification message");
		Assert.assertEquals("Profile Updated Successfully", notificationMessage);

		testStepsLog("Click on view profile");
		clickOn(profilepage.viewProfile);

		testStepsLog(" Click on Edit Profile ");
		clickOn(profilepage.editProfile);

		testStepsLog("Remove first name");
		clearElement(profilepage.firstNameField);

		testStepsLog("Enter previous firstname");
		enterValue(profilepage.firstNameField, "automation");

		testStepsLog("Select gender as male");
		profilepage.selectGender("Male");

		testStepsLog(" Click on Save Changes button");
		clickOn(profilepage.saveChangesButton);
		visibilityOfElement(profilepage.notification);

	}

}
