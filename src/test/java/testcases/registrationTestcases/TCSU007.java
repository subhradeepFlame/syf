package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;


	
	public class TCSU007 extends BaseClass {
	

		@Test
		public void verifyCheckBoxValidation() {
			testStepsLog("Click on sign up button");
			clickOn(loginpage.signUpLink);
			testStepsLog("Verify user is in sign up page");
			visibilityOfElement(registrationpage.Create_an_account_text);
			testVerifyLog("User is in registration page");
			
			testStepsLog("Sign up with terms and condition box unchecked");
			registrationpage.register("testa","lasta","7669665656565","testauto0_03@mailinator.com",con.getLoginPassword(),con.getLoginPassword(),false);
			testVerifyLog("Signup failed due to terms and condition checkbox is unchecked");
			
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
