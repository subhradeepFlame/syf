package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP009 extends BaseClass {

	
	@Test
	public void VerifyIfRequiredFiledsBlankThenSaveChangesBuutonRemansDisabled() {
		
		testStepsLog("Login user");
		loginpage.Login("User 1");
		
		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");
		
		testStepsLog("Click on Change Password");
		clickOn(profilepage.changePassword);
		
		testStepsLog("Keep all required fields empty");
		profilepage.changePassword("","","");
		
		testStepsLog("Verify Save Changes button remains disabled");
		Assert.assertFalse(profilepage.saveChangesButton.isEnabled());
		testVerifyLog("Save Changes button remains disabled");
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
