package testcases.registrationTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCSU008 extends BaseClass{
	
	
	@Test
	public void checkLoginPagePageRedirection() {
		
		testStepsLog("Click on sign up button");
		clickOn(loginpage.signUpLink);
		testStepsLog("Verify user is in sign up page");
		visibilityOfElement(registrationpage.Create_an_account_text);
		testVerifyLog("User is in registration page");
		
		testStepsLog("Click on the login link");
		clickOn(registrationpage.logInLink);
		
		testStepsLog("Verify user redirects to the login page");
		visibilityOfElement(loginpage.lognToYourAccountText);
		String currentLink = driver.getCurrentUrl();
		Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/login", currentLink);
		testVerifyLog("User redirects to the login page");
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






