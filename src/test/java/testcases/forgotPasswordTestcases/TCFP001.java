package testcases.forgotPasswordTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCFP001 extends BaseClass {

	@Test
	public void checkLoginRedirection() {

		testStepsLog("Verify user is in the login page");
		visibilityOfElement(loginpage.lognToYourAccountText);
		testVerifyLog("User is in the Login Page");
		
		testStepsLog("Click on the forgot password link");
		clickOn(loginpage.forgotPasswordLink);
		
		testStepsLog("Verify user redirects to the forgot password page");
		visibilityOfElement(forgotpasswordpage.forogtYourPasswordText);
		String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/forgot-password", currentLink);
		testVerifyLog("User resdirects to the forgot password page");
		
		testStepsLog("Click on Log In");
		clickOn(forgotpasswordpage.loginLink);
		waitForPageLoaded();
		
		testStepsLog("Verify user redirects to the login page");
		visibilityOfElement(loginpage.lognToYourAccountText);
		testVerifyLog("User redirects to the Login Page");
	}
}
