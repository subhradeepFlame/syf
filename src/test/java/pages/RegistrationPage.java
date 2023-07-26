package pages;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends CommonPage {

	public RegistrationPage(WebDriver dr) {
		super(dr);
	}

	@FindBy(xpath = "//input[@name='first_name']")
	public WebElement firstNameField;
	@FindBy(xpath = "//input[@name='last_name']")
	public WebElement lastNameField;
	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phoneField;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailIdField;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordField;
	@FindBy(xpath = "//input[@name='confirm_password']")
	public WebElement confirmPasswordField;
	@FindBy(xpath = "//input[@type='checkbox']/..")
	public WebElement termsAndConditionCheckBox;
	@FindBy(xpath = "//button[@type='button']")
	public WebElement registerButton;
	@FindBy(xpath = "//div[contains(text(),'Create an account')]")
	public WebElement Create_an_account_text;
	@FindBy(xpath = "//a[text()='Log In']")
	public WebElement logInLink;

	public boolean register(String firstName, String lastName, String phoneNumber, String email, String password,
			String confirmPassword, boolean check) {

		boolean status = false;

		testStepsLog("Enter first name : " + firstName);
		enterValue(firstNameField, firstName);
		testStepsLog("Enter last name : " + lastName);
		enterValue(lastNameField, lastName);
		testStepsLog("Enter phone : " + phoneNumber);
		enterValue(phoneField, phoneNumber);
		testStepsLog("Enter email id : " + email);
		enterValue(emailIdField, email);
		testStepsLog("Enter password  : " + password);
		enterValue(passwordField, password);
		testStepsLog("Enter confirm password : " + confirmPassword);
		enterValue(confirmPasswordField, confirmPassword);
		if (check) {
			testStepsLog("Click on the terms and condition check box");
			termsAndConditionCheckBox.click();
		} else {
			testInfoLog("terms and conditions check box is not clicked");
		}
		scrollToElement(registerButton);
		if (registerButton.isEnabled()) {
			testInfoLog("Register button is enabled");
			testStepsLog("Click on the register button");
			clickOn(registerButton);
			String notificationMessage = commonpage.getNotificationMessage();
			testStepsLog("validate the notification message");
			try {
				Assert.assertEquals(notificationMessage, "Successfully registered");
				testVerifyLog("Successfully registered");
				testStepsLog("Verify user redirect to the dashboard page");
				String currentLink = driver.getCurrentUrl();
				Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/account/dashboard", currentLink);
				testVerifyLog("User redirects to the dashboard page");
				status = true;
			} catch (AssertionError e) {
				try {
					Assert.assertEquals(notificationMessage, "You have already registered,please press login.");
					testInfoLog(" Sign up failed : You have already registered,please press login.");
				} catch (AssertionError e1) {
					try {
						Assert.assertEquals(notificationMessage, "phone number already exists.");
						testInfoLog("Sign up failed : phone number already exists.");

					} catch (AssertionError e2) {
						testInfoLog("Sign up failed due to : " + notificationMessage);
					}
				}
			}
		} else {
			testInfoLog("Register button is disabled");
			ArrayList<String> arlist = new ArrayList<String>();

			if (firstName.isEmpty())
				arlist.add("firstname");

			if (lastName.isEmpty())
				arlist.add("lastname");

			if (phoneNumber.isEmpty()) {
				arlist.add("phone");
			} else {
				if (phoneNumber.length() < 8)
					testInfoLog("invalid phone number");
			}
			if (email.isEmpty()) {
				arlist.add("email");
			} else {
				if (isValidEmail(email) == false)
					testInfoLog("Invalid email format");
			}
			if (password.isEmpty())
				arlist.add("password");

			if (confirmPassword.isEmpty()) {
				arlist.add("confirmpassword");
			} else {
				if (!confirmPassword.equals(password))
					testInfoLog("Password & Confirm password not matched");
			}
			if (arlist.size() != 0)
				testInfoLog(arlist + " is missing");
		}
		return status;
	}

	public String SignupWithExcel() throws EncryptedDocumentException, InvalidFormatException, IOException {
		/* helps to sign up with excel incrementor value */
		String value = getIncrementedValue();
		register("Autoqa", getUpdatedLastName(value), getUpdatedPhoneNumber(value), getUpdatedEmail(value),
				con.getLoginPassword(), con.getLoginPassword(), true);
		return getUpdatedEmail(value);
	}

	public String getUpdatedLastName(String incrementorValue) {
		/* returns updated last name for signup */
		return "User" + incrementorValue;
	}

	public String getUpdatedPhoneNumber(String incrementorValue) {
		/* returns updated phone number for signup */
		return "77777777777" + incrementorValue;
	}

	public String getUpdatedEmail(String incrementorValue) {
		/* returns updated email for signup */
		return "AutoqaUser" + incrementorValue + "@mailinator.com";
	}

}
