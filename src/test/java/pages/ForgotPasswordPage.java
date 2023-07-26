package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ForgotPasswordPage extends CommonPage {

	public ForgotPasswordPage(WebDriver dr) {
		super(dr);
	}

	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailAddressField;
	@FindBy(xpath = "//button[@type='button']")
	public WebElement sendButton;
	@FindBy(xpath = "//iframe[@id='html_msg_body']")
	public WebElement forgotPasswordFrame;
	@FindBy(xpath = "//a[contains(text(),'Reset')]")
	public WebElement resetButton;
	@FindBy(xpath = "//span[text()=' Enter New Password ']//..//input")
	public WebElement newPasswordField;
	@FindBy(xpath = "//span[text()=' Re-Type New Password ']//..//input")
	public WebElement confirmPasswordField;
	@FindBy(xpath = "//button[@type='button']")
	public WebElement createButton;
	@FindBy(xpath = "//a[text()='Log In']")
	public WebElement loginLink;
	@FindBy(xpath = "//div[text()='Forgot your password?']")
	public WebElement forogtYourPasswordText;
	@FindBy(xpath = "//div[text()='Create new password']")
	public WebElement createNewPasswordText;

	public void sendForgotPasswordEmail(String email) {
		/* helps to send forgot password mail to emailId */

		testStepsLog("Enter email address :" + email);
		emailAddressField.click();
		enterValue(emailAddressField, email);
		if (sendButton.isEnabled()) {
			testVerifyLog("Send button is clickable");
			testStepsLog("Click on send button");
			clickOn(sendButton);
			String notificationText = visibilityOfElement(notification).getText();
			try {
				Assert.assertEquals(notificationText,
						"An email with password reset information has been sent to your registered email address.");
				testVerifyLog("Success Message showing: " + notificationText);
			} catch (AssertionError e) {
				try {
					Assert.assertEquals(notificationText, "Sorry! This Email is not registered with us");
					testVerifyLog("Error Message showing: " + notificationText);
				} catch (AssertionError e1) {
					testInfoLog("Forgot Password failed due to: " + notificationText);
				}
			}
		} else {
			testVerifyLog("Send button is not clickable");
			if (email.isEmpty()) {
				testVerifyLog("Missing email address");
			} else if (isValidEmail(email) == false) {
				testVerifyLog("Invalid email id");
			}
		}

	}

	public void createNewPassword(String newPassword, String ConfirmPassword) {
		/* helps to create new password */
		testStepsLog("Enter New Password : " + newPassword);
		newPasswordField.click();
		enterValue(newPasswordField, newPassword);
		testStepsLog("Enter Confirm Password : " + ConfirmPassword);
		confirmPasswordField.click();
		enterValue(confirmPasswordField, ConfirmPassword);

		if (createButton.isEnabled()) {
			testVerifyLog("Create Button is enabled");
			testStepsLog("Click on Create button");
			clickOn(createButton);
			String messageText = visibilityOfElement(notification).getText();
			try {
				Assert.assertTrue(messageText.contains("Password has been changed."));
				testVerifyLog("Success Message showing : " + messageText);
				Assert.assertEquals(con.getUrl() + "login", driver.getCurrentUrl());
				testVerifyLog("Page redirected to login page");
			} catch (AssertionError e2) {
				testInfoLog("Create New Password failed due to: " + messageText);
			}
		} else {
			testVerifyLog("Create button is not enabled in Create New Password page");
			if (newPassword.isEmpty() || ConfirmPassword.isEmpty()) {
				testVerifyLog("Password fields are blank");
			} else if (!ConfirmPassword.equals(newPassword)) {
				testVerifyLog("New password and confirm password not matched");
			}
		}
	}

}
