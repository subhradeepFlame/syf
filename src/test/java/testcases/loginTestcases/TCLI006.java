package testcases.loginTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCLI006 extends BaseClass{

	
	@Test
	public void checkForgotPasswordPageRedirection() {
		
		testStepsLog("Verify user is in the login page");
		visibilityOfElement(loginpage.lognToYourAccountText);
		testVerifyLog("User is in the Login Page");
		
		testStepsLog("Click on the forgot password link");
		clickOn(loginpage.forgotPasswordLink);
		
		testStepsLog("Verify user redirects to the forgot password page");
		visibilityOfElement(forgotpasswordpage.forogtYourPasswordText);
		String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/forgot-password", currentLink);
		testVerifyLog("User redirects to the forgot password page");
		
	}
}
