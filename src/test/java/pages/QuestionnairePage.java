package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionnairePage extends CommonPage{

	public QuestionnairePage(WebDriver dr) {
		super(dr);
	}

	
	@FindBy(xpath = "//button[contains(text(),'Next')]")
	public WebElement nextButton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement submitButton;
	@FindBy(xpath = "//h4[contains(text(),'Tell us about yourself')]")
	public WebElement tellUsAboutYourselfText;
	@FindBy(xpath = "//h4[contains(text(),'What do you like to eat?')]")
	public WebElement whatDoYouLikeToEatText;
	@FindBy(xpath = "//h4[contains(text(),'Nutrition Targets')]")
	public WebElement NutritionTargetsText;
	@FindBy(xpath = "//h4[contains(text(),'Personal Details')]")
	public WebElement PersonalDetailsText;
	@FindBy(xpath = "//label[contains(text(),'DOB')]/../..//div[contains(@class,'datepicker')]")
	public WebElement DOBField;
	@FindBy(xpath = "//span[@class='flatpickr-day ']/following-sibling::span")
	public WebElement DobDate;
	@FindBy(xpath = "//label[contains(text(),'Where did you hear about us')]/../..//span[@role='presentation']")
	public WebElement WhereDidYouHearAboutUsField;
	@FindBy(xpath = "//label[contains(text(),'Where did you hear about us')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement WhereDidYouHearAboutUsFieldAns;
	@FindBy(xpath = "//label[contains(text(),'Primary Goal')]/../..//span[@role='presentation']")
	public WebElement primaryGoalField;
	@FindBy(xpath = "//label[contains(text(),'Primary Goal')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement primaryGoalFieldAns;
	@FindBy(xpath = "//input[@name='Height in Feet']")
	public WebElement HeightFtField;
	@FindBy(xpath = "//input[@name='Height in Inches']")
	public WebElement HeightInchField;
	@FindBy(xpath = "//input[@name='Current Weight']")
	public WebElement currenrtWeightField;
	@FindBy(xpath = "//input[@name='Target Weight']")
	public WebElement targetWeightField;
	@FindBy(xpath = "//label[contains(text(),'Activity Level')]/../..//span[@role='presentation']")
	public WebElement activityLevelField;
	@FindBy(xpath = "//label[contains(text(),'Activity Level')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement activityLevelFieldAns;
	@FindBy(xpath = "//label[contains(text(),'Currently, how motivated')]/../..//span[@role='presentation']")
	public WebElement currentlyHowMotivateField;
	@FindBy(xpath = "//label[contains(text(),'Currently, how motivated')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement currentlyHowMotivateFieldAns;
	@FindBy(xpath = "//label[contains(text(),'What is your level')]/../..//span[@role='presentation']")
	public WebElement whatIsYourLevelField;
	@FindBy(xpath = "//label[contains(text(),'What is your level')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement  whatIsYourLevelFieldAns;
	@FindBy(xpath = "//label[contains(text(),'On average')]/../..//span[@role='presentation']")
	public WebElement howManyHoursOfSleepField;
	@FindBy(xpath = "//label[contains(text(),'On average')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement howManyHoursOfSleepFieldAns;
	@FindBy(xpath = "//label[contains(text(),'Grade your current')]/../..//span[@role='presentation']")
	public WebElement currentNutritionHabitsField;
	@FindBy(xpath = "//label[contains(text(),'Grade your current')]/../..//span[@role='presentation']/../../..//ul//li")
	public WebElement currentNutritionHabitsFieldAns;
	
	public void reSubmitQuestionnaire() {
	
		testStepsLog("Go to questionnaire");
		ClickOnProfileMenu("Questionnaire");
		visibilityOfElement(tellUsAboutYourselfText);
		
		testStepsLog("Click on next button");
		scrollToElement(nextButton);
		clickOn(nextButton);
		
		visibilityOfElement(whatDoYouLikeToEatText);
		testStepsLog("Click on next button");
		scrollToElement(nextButton);
		clickOn(nextButton);
		
		visibilityOfElement(NutritionTargetsText);
		testStepsLog("Click on Submit button");
		scrollToElement(submitButton);
		clickOn(submitButton);
	}
	
	public void SelectGender(String gender) {
		/* questionnaire first page gender select > String gender should be Male or Female*/
		
		scrollToElement(driver.findElement(By.xpath("//span[text()='"+gender+"']")));
		clickOn(driver.findElement(By.xpath("//span[text()='"+gender+"']")));
	}
	
	public void selectPreferredDiet(String foodDietType) {
		clickOn(driver.findElement(By.xpath("//div[text()='"+foodDietType+"']/../..")));
	}
	
	
	
	

}
