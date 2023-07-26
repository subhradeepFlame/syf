package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP004 extends BaseClass {

	@Test
	public void VerifyUserCanNotUseDuplicatePhoneNumber() {

		testStepsLog("Login user");
		loginpage.Login("User 1");

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");

		testStepsLog("Click on Edit Profile");
		clickOn(profilepage.editProfile);

		testStepsLog("Remove phone number");
		clearElement(profilepage.phoneNumberField);

		testStepsLog("Enter a Phone Number which is already a  registered Phone Number");
		enterValue(profilepage.phoneNumberField, "121212121213");

		testStepsLog("Click on Save Changes Button");
		clickOn(profilepage.saveChangesButton);

		testStepsLog("Verify error message");
		String notificationMessage = commonpage.getNotificationMessage();
		testVerifyLog("Error message");

		testStepsLog("validate the notification message");
		Assert.assertEquals("Phone number already exists.", notificationMessage);

	}

}
