package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCSU006 extends BaseClass {
	

	@Test
	public void verifySuccessfullRegistration() throws Exception {
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");
		
		testStepsLog("Signup a new user");
		registrationpage.SignupWithExcel();
		
		
  }
	
	

}
