package testcases.profileAndFAQsTestCases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCP011 extends BaseClass {
	
	
	@Test
	public void VerifyIfRequiredFiledsAreBlankThenSaveChangesButtonRemansDisabled() {
		
		
		testStepsLog("Login user");
		loginpage.Login("User 1");	

		testStepsLog("Open profile");
		dashboardpage.ClickOnProfileMenu("Profile");
		
		testStepsLog("Click on Change Password");
		clickOn(profilepage.changePassword);
		
		testStepsLog("Verify user can successfully update password");
		profilepage.changePassword(con.getLoginPassword(),con.getLoginPassword(),con.getLoginPassword());
		testVerifyLog("User can successfully update password");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
