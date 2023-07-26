package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;



	public class TCSU001 extends BaseClass {
	
	@Test
	
	public void verifyUserCantSignUpWithoutRequiredFields() {
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");
		
		testStepsLog("Fill up required fields with blank data");
		registrationpage.register("","","","","","",false);
		testVerifyLog("register button is not clickable");
		
	
	
	
	}
	}
	
	
	



