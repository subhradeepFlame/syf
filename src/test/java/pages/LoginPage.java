package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends CommonPage {

	public LoginPage(WebDriver dr) {
		super(dr);
	}
	protected String datafile = System.getProperty("user.dir")+ "/src/test/resources/SyfUserData.xlsx";
	String sheet = con.getEnv();

	@FindBy(xpath = "//span[text()='Log In']/..")
	public WebElement loginButton;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailField;
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passwordField;
	@FindBy(xpath = "//a[text()='Forgot Password?']")
	public WebElement forgotPasswordLink;
	@FindBy(xpath = "//div[text()='Login to your account!']")
	public WebElement lognToYourAccountText;
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	public WebElement signUpLink;

	public void Login(String email, String password) {
		visibilityOfElement(lognToYourAccountText);
		testVerifyLog("User is in the Login Page");
		testStepsLog("Enter email : " + email);
		emailField.click();
		enterValue(emailField, email);
		testStepsLog("Enter password : " + password);
		passwordField.click();
		enterValue(passwordField, password);

		if (loginButton.isEnabled()) {
			testVerifyLog("login button is clickable");
			testStepsLog("Click on the login button");
			clickOn(loginButton);
			String notificationText = visibilityOfElement(notification).getText();
			try {
				Assert.assertEquals(notificationText, "Successfully logged in");
				testVerifyLog("popup message showing-Successfully logged in");
				testStepsLog("Verify user redirects to the after login page");
				try {
					visibilityOfElement(dashboardpage.dashboardMenuText);
					String currentLink = driver.getCurrentUrl();
					Assert.assertEquals("https://" + con.getEnv() + ".heatxtreme.com/account/dashboard", currentLink);
					testVerifyLog("User redirects to the dashboard page");
				} catch (Exception e) {
					visibilityOfElement(questionnairepage.PersonalDetailsText);
					testVerifyLog("User redirects to the questionnaire page");
				}
				testVerifyLog("User logged in successfully");

			} catch (AssertionError e) {
				try {
					Assert.assertEquals(notificationText, "Invalid Credentials");
					testVerifyLog("popup message showing-Invalid Credentials");
					visibilityOfElement(lognToYourAccountText);
					testVerifyLog("Login not successfull");
				} catch (AssertionError e1) {
					testVerifyLog("Notification messahe showing: " + notificationText);
				}
			}
		} else {
			testVerifyLog("Login button is not clickable");
			if (email.isEmpty() || password.isEmpty()) {
				testVerifyLog("Missing credentials");
			} else if (isValidEmail(email) == false) {
				testVerifyLog("Invalid email id");
			}

		}

	}
	
	
	public String getUserEmail(String user) {
		/* helps to get user email from excel sheet */
		return excelhelper.dataLookup(datafile, sheet, 3, user);
	}

	public String getUserPassword(String user) {
		/* helps to get user password from excel sheet */
		return excelhelper.dataLookup(datafile, sheet, 4, user);
	}
	
	public void Login(String user) {
		/* helps to login user by excel sheet */
		Login(getUserEmail(user), getUserPassword(user));
	}
	
	public String getjoinheatuserdomain() {
		String datafile2 = System.getProperty("user.dir")+ "/src/test/resources/SYF testing accounts.xlsx";
		/* helps to get user email from excel sheet */
		return excelhelper.getCellValue(datafile2, "LIVE JHC", 1, 1);
	}

}
