package testcases.forgotPasswordTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCFP003 extends BaseClass {

	@Test
	public void sentForgotPasswordMailWithInvalidEmailFormat() {

		testStepsLog("Click on the forgot password link");
		clickOn(loginpage.forgotPasswordLink);
		
		testStepsLog("Verify user redirects to the forgot password page");
		visibilityOfElement(forgotpasswordpage.forogtYourPasswordText);
		testVerifyLog("User resdirects to the forgot password page");

		testStepsLog("Enter Invalid email address");
		forgotpasswordpage.sendForgotPasswordEmail("automationchallenge");
	}
}
