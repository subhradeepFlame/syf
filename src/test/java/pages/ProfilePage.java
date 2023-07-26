package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProfilePage extends CommonPage {

	public ProfilePage(WebDriver dr) {
		super(dr);
	}

	public String profilePhotoPath = System.getProperty("user.dir") + "/src/test/resources/test.jpg";
	@FindBy(xpath = "//div[@id='toolbar_faq']//span")
	public WebElement FAQs;
	@FindBy(xpath = "//h3[text() = 'Faq']")
	public WebElement FAQtext;
	@FindBy(xpath = "//div[@class='vs-collapse-item']")
	public WebElement FaqQuestion;
	@FindBy(xpath = "//span[contains(@class,'icon-header' )]//i")
	public WebElement questionDropdown;
	@FindBy(xpath = "//div[@class ='con-content--item' ]")
	public WebElement FaqAnswer;
	@FindBy(xpath = "//span[contains(@class,'icon-header vs-collapse')]")
	public WebElement FAQansIconHide;
	@FindBy(xpath = "//h3[text()='Faq']/../..//i")
	public WebElement FAQcloseIcon;
	@FindBy(xpath = "//p[@class = 'flex items-center']")
	public WebElement editProfile;
	@FindBy(xpath = "//span[contains(text(),' FIRST NAME')]")
	public WebElement firstNameText;
	@FindBy(xpath = "//input[@name = 'first-name']")
	public WebElement firstNameField;
	@FindBy(xpath = "//input[@name= 'phone']")
	public WebElement phoneNumberField;
	@FindBy(xpath = "//span[text()='Save Changes']/..")
	public WebElement saveChangesButton;
	@FindBy(xpath = "//div[@class='img-upload']//input")
	public WebElement uploadPhotoField;
	@FindBy(xpath = "//p[@class = 'flex items-center']")
	public WebElement viewProfile;
	@FindBy(xpath = "//button//span[contains(text(),'Remove')]/..")
	public WebElement removeProfileImage;
	@FindBy(xpath = "//span[text()='Accept']/..")
	public WebElement acceptButton;
	@FindBy(xpath = "//button//span[text()='Answer questionnaire']/..")
	public WebElement answerQuestionnaireButton;
	@FindBy(xpath = "//h6[text()='Invoice']/..//div[@class = 'profile-table']")
	public WebElement invoiceDetails;
	@FindBy(xpath = "//h6[text()='Subscription']/..//div[@class = 'profile-table']")
	public WebElement subscriptionDetails;
	@FindBy(xpath = "//span[text()='Change Password']/..")
	public WebElement changePassword;
	@FindBy(xpath = "//span[contains(text(),' OLD PASSWORD ')]/..//input")
	public WebElement oldPassword;
	@FindBy(xpath = "//span[contains(text(),' NEW PASSWORD ')]/..//input")
	public WebElement newPassword;
	@FindBy(xpath = "//span[contains(text(),' CONFIRM PASSWORD ')]/..//input")
	public WebElement confirmPassword;

	public void selectGender(String gender) {
		/* helps to select gender in edit profile */
		clickOn(driver.findElement(By.xpath("//span[text()='" + gender + "']/..//span[@class='vs-radio--borde']")));
	}

	public boolean changePassword(String oldPsd, String newPsd, String confirmPsd) {
		/* helps to change profile password */
		boolean status = false;
		if (oldPsd.isEmpty() || newPsd.isEmpty() || confirmPsd.isEmpty()) {
			testVerifyLog("Required fileds are missing");
		} else {

			if (confirmPsd == newPsd) {
				testStepsLog("Write old password");
				enterValue(oldPassword, oldPsd);

				testStepsLog("Write new password");
				enterValue(newPassword, newPsd);

				testStepsLog("Write confirm password");
				enterValue(confirmPassword, confirmPsd);

				testStepsLog("Click on Save Changes button");
				clickOn(saveChangesButton);

				testStepsLog("Verify success message");
				String notificationMessage = commonpage.getNotificationMessage();
				try {
					Assert.assertEquals("Password updated successfully", notificationMessage);
					testVerifyLog("Success message");
					status = true;
				} catch (Exception e) {
					testInfoLog("error message showing : " + notificationMessage);
				}
			} else {

				testVerifyLog("New password and confirm password do not match");
			}
		}
		return status;
	}

}
