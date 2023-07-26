package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

	
public class TCSU005 extends BaseClass {
		

		@Test
		public void verifyDuplicatePhoneNumberValidation() {
			testStepsLog("Click on sign up button");
			clickOn(loginpage.signUpLink);
			testStepsLog("Verify user is in sign up page");
			visibilityOfElement(registrationpage.Create_an_account_text);
			testVerifyLog("User is in registration page");
			
			testStepsLog("Signup with duplicate Phone number");
			registrationpage.register("qatestfirst", "qatestlast", "38665656565","qatestNegetive@mailinator.com",con.getLoginPassword(),con.getLoginPassword(),true);
			
			
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
