package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AdminPage extends CommonPage {

	public AdminPage(WebDriver dr) {
		super(dr);
	}

	@FindBy(xpath = "//button//span[text()='Add New']")
	public WebElement addNewButton;
	@FindBy(xpath = "//button//span[text()='Save Changes']")
	public WebElement saveChangesButton;
	@FindBy(xpath = "//div[@class='con-input-search vs-table--search']//input")
	public WebElement searchField;
	@FindBy(xpath = "//div[@class='con-vs-tooltip']//span[@class='feather-icon select-none relative']")
	public WebElement editIcon;
	@FindBy(xpath = "//label[contains(text(),'Start Date')]/..//div[contains(@class,'datepicker')]")
	public WebElement startDateField;
	@FindBy(xpath = "(//select[@aria-label='Month'])[1]")
	public WebElement startDateMonthField;
	@FindBy(xpath = "//input[@aria-label='Year']")
	public WebElement startDateYearField;
	@FindBy(xpath = "(//span[@aria-current='date'])[1]/following-sibling::span")
	public WebElement nextDateOfCurrentDate;
	@FindBy(xpath = "//input[@placeholder='Purchased Product']/..")
	public WebElement purchasedProductField;

	public void superAdminLogin() {
		loginpage.Login(con.getSuperAdminId(), con.getLoginPassword());
	}

	public void SearchValue(String value) {
		enterValue(searchField, value);
		pause(3);
		visibilityOfElement(driver.findElement(By.xpath("//span[text()='"+value+"']")));
	}

	public void updateChallengeStartDateToNextDate(String challengeName) {

		testStepsLog("Search challenge");
		SearchValue(challengeName);

		testStepsLog("Click on edit icon");
		clickOn(editIcon);
		waitForPageLoaded();

		testStepsLog("Click on Start date field");
		startDateField.click();

		testStepsLog("Select current Month");
		adminpage.SelectUsingVisibleValue(startDateMonthField, adminpage.getCurrentMonth());

		testStepsLog("Enter current Year");
		enterValue(startDateYearField, adminpage.getCurrentYear());

		testStepsLog("Click on next date of current date");
		nextDateOfCurrentDate.click();

		testStepsLog("Click on save changes button");
		scrollToElement(saveChangesButton);
		clickOn(saveChangesButton);

		testStepsLog("Verify success message showing");
		Assert.assertEquals(adminpage.getNotificationMessage(), "Updated Successfully");

	}

	public void addChallengeToUser(String userEmail, String activeChallengeProductName) {

		testStepsLog("Search User");
		SearchValue(userEmail);

		testStepsLog("Click on edit icon");
		clickOn(editIcon);
		waitForPageLoaded();

		testStepsLog("Click on purchased product Field");
		scrollToElement(purchasedProductField);
		purchasedProductField.click();

		testStepsLog("Click on a active challenge product");
		driver.findElement(By.xpath(
				"//input[@placeholder='Purchased Product']/../../..//ul/li[contains(text(),'"+activeChallengeProductName+"')]"))
				.click();

		testStepsLog("Click on save changes button");
		scrollToElement(saveChangesButton);
		clickOn(saveChangesButton);
		
		testStepsLog("Verify success message showing");
		Assert.assertEquals(adminpage.getNotificationMessage(), "Updated Successfully");
	}

}
