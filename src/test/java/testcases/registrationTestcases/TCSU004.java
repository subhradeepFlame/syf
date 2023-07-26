package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCSU004 extends BaseClass {

	@Test
	public void verifyPasswordConfirmPasswordMismatchValidation() {

		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");

		testStepsLog("Signup when password and confirm password does't match");
		registrationpage.register("qatestfirst", "qatestlast", "38665656565", "qatestNegetive@mailinator.com", con.getLoginPassword(), "123000",
				true);
		testVerifyLog("Register button is disabled because Password and confirm password doesn't match");

	}

}
