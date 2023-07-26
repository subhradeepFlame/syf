package testcases.registrationTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCSU002 extends BaseClass {

	@Test
	public void verifyUserCantRegisterWithDuplicateEmailId() {

		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");

		testStepsLog("Signup with existing email id");
		registrationpage.register("qatestfirst", "qatestlast", "8966414375", "testauto0_01@mailinator.com",
				con.getLoginPassword(), con.getLoginPassword(), true);
		testVerifyLog("'You have already registered,please press login'");

	}

}
