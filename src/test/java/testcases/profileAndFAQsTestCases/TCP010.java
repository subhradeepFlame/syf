package testcases.profileAndFAQsTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP010 extends BaseClass {
	
	
	
	
	@Test
	public void VerifyIfNewPasswordANdConfirmPasswordAreDifferentThenSaveButtonRemainsDisabled() {
		
		testStepsLog("Login user");
		loginpage.Login("User 1");

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");
		
		testStepsLog("Click on Change Password");
		clickOn(profilepage.changePassword);
		
		testStepsLog("Write different password for new password and confirm password");
		profilepage.changePassword(con.getLoginPassword(),"123123","111111");
		
		testStepsLog("Verify Save Changes button remains disabled");
		Assert.assertFalse(profilepage.saveChangesButton.isEnabled());
		testVerifyLog("Save Changes button remains disabled");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
