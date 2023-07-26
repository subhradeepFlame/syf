package testcases.forgotPasswordTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCFP002 extends BaseClass {

	@Test
	public void sentForgotPasswordMailWithNotRegisteredMailId() {

		testStepsLog("Click on the forgot password link");
		clickOn(loginpage.forgotPasswordLink);
		
		testStepsLog("Verify user redirects to the forgot password page");
		visibilityOfElement(forgotpasswordpage.forogtYourPasswordText);
		testVerifyLog("User resdirects to the forgot password page");
		
		testStepsLog("Verify send button is not clikable when email field is empty");
		forgotpasswordpage.sendForgotPasswordEmail("");

		testStepsLog("Enter not registered email address");
		forgotpasswordpage.sendForgotPasswordEmail("autouser13343@mailinator.com");
		
	}
}
