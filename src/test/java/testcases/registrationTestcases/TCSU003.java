package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCSU003 extends BaseClass{

	
	@Test
	public void verifyUserCantSignUpWithInvalidEmail() {
		
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");
		
		testStepsLog("Signup with invalid email id");
		registrationpage.register("qatestfirst", "qatestlast", "8966414375","test.com",con.getLoginPassword(),con.getLoginPassword(),true);
		
		
		
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
