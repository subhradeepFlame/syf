package testcases.forgotPasswordTestcases;

import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCFP004 extends BaseClass {

	@Test
	public void createPasswordViaForgotPassword() {
		
		testStepsLog("Click on the forgot password link");
		clickOn(loginpage.forgotPasswordLink);
		
		testStepsLog("Verify user redirects to the forgot password page");
		visibilityOfElement(forgotpasswordpage.forogtYourPasswordText);
		testVerifyLog("User resdirects to the forgot password page");

		testStepsLog("Enter valid email address");
		forgotpasswordpage.sendForgotPasswordEmail("autouserqa1@mailinator.com");
		
		testStepsLog("Verify the Reset Password mail received");
		commonpage.VerifyMailinatorMail("autouserqa1", "Reset Your Password");

		testStepsLog("Open the mail");
		commonpage.openMailinatorMail("Reset Your Password");
		
		testStepsLog("Click on Reset button");
		driver.switchTo().frame(forgotpasswordpage.forgotPasswordFrame);
		visibilityOfElement(forgotpasswordpage.resetButton);
		scrollToElement(forgotpasswordpage.resetButton);
		clickOn(forgotpasswordpage.resetButton);
		
		testStepsLog("Verify page redirected to the Create new password page");
		switchTab(1);
		visibilityOfElement(forgotpasswordpage.createNewPasswordText);
		testVerifyLog("Create new password page opened");
		
		testStepsLog("Verify when password and confirm password fields are blank, Create button is not clickable");
		forgotpasswordpage.createNewPassword("", "");
		
		testStepsLog("Verify when password and confirm password are not matched, Create button is not clickable");
		forgotpasswordpage.createNewPassword("122222", "123456");
		
		testStepsLog("Verify when password and confirm password are matched, Create button is clickable");
		forgotpasswordpage.createNewPassword(con.getLoginPassword(), con.getLoginPassword());
		
		testStepsLog("Login the user with changed password");
		loginpage.Login("User 1");
		
		
		
		
		
		
	}
}
