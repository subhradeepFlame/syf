package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends CommonPage {

	public DashboardPage(WebDriver dr) {
		super(dr);
	}

	@FindBy(xpath = "//span[text()='Input Weight']/..")
	public WebElement inputWeightButton;
	@FindBy(xpath = "//h4[text()='Weight Input']/../..//div[@class='vs-con-input']//input")
	public WebElement inputWeightfield;
	@FindBy(xpath = "//h4[text()='Weight Input']/../..//div[@class='input-select-con']")
	public WebElement inputWeightTypeDropdown;
	@FindBy(xpath = "//h4[text()='Weight Input']/../..//span[text()='Save']/..")
	public WebElement weightInputSaveButton;
	@FindBy(xpath = "//h4[text()='Weight Statistics']/..//p[contains(text(),'Current weight recorded on')]")
	public WebElement currentWeightText;
	@FindBy(xpath = "//h4[text()='Weight Statistics']/..//p[contains(text(),'Current weight recorded on')]/span")
	public WebElement currentWeightFormat;
	@FindBy(xpath = "//h3[text()='Confirm ']/../../..//span[text()='Accept']/..")
	public WebElement confirmationAcceptButton;
	@FindBy(xpath = "//div[@class='hidden md:block']//span[text()='here']")
	public WebElement clickHereToGenerateMealLink;
	@FindBy(xpath = "//div[@class='hidden md:block']//h5[text()='Today’s Meal']/../..//div[@class='carousel-example']")
	public WebElement todaysMealSection;
	@FindBy(xpath = "//div[@class='hidden md:block']//h5[text()='Today’s Meal']/..//a")
	public WebElement todaysMealViewDetails;
	@FindBy(xpath = "//h4[text()='Challenge starts in']/..//span")
	public WebElement upcomingChallengeCountdownDiv;
	@FindBy(xpath = "//div[@class='vx-card__body']/h5[text()='Calorie Goal']/..")
	public WebElement calorieGoalSection;
	@FindBy(xpath = "//div[@class='vx-card__body']/h5[text()='Challenge Video']/..")
	public WebElement challengeVideosSection;
	@FindBy(xpath = "//div[@class='vx-card__title']/h4[text()='Disliked Foods']/../../..")
	public WebElement dislikedFoodSection;
	@FindBy(xpath = "//span//h6[text()='Transformation Videos']/../..")
	public WebElement tansformationVideosSection;
	@FindBy(xpath = "//span//label[text()='Before']/..//i/..")
	public WebElement beforeVideoDeleteIcon;
	@FindBy(xpath = "//span//label[text()='After']/..//i/..")
	public WebElement afterVideoDeleteIcon;
	@FindBy(xpath = "//span//label[text()='Before']/..//div[@class='after-video-section']//button")
	public WebElement beforeVideoUploadButton;
	@FindBy(xpath = "//span//label[text()='After']/..//div[@class='after-video-section']//button")
	public WebElement afterVideoUploadButton;
	@FindBy(xpath = "//em[contains(text(),'Hello,')]")
	public WebElement helloUserText;
	@FindBy(xpath = "//span[text()='Completed']/..//h2")
	public WebElement completedChallengeVideoCount;
	@FindBy(xpath = "//span[text()='Remove from List']")
	public WebElement removeFromDislikeList;

	public void inputWeight(String weight, String type) {
		/* helps to input weight */

		visibilityOfElement(inputWeightButton);
		testStepsLog("Click on the Input Weight Button");
		clickOn(inputWeightButton);

		testStepsLog("Enter weight value");
		enterValue(inputWeightfield, weight);

//		testStepsLog("Click on the Input Weight type dropdown");
//		clickOn(inputWeightTypeDropdown);		
//		testStepsLog("Select dropdown as : " + type);
//		clickOn(driver.findElement(By.xpath("//button//span[text()='"+type+"']/..")));

		testStepsLog("Click on save button");
		clickOn(weightInputSaveButton);
	}

	public void changeWeightDetailsViewFormat(String format) {
		/* helps to change the weight details view format in lbs or kg */

		PresenceOfElement(By
				.xpath("//span[text()='Input Weight']/../../../following-sibling::div//span[text()='" + format + "']"));
		clickOn(driver.findElement(By.xpath(
				"//span[text()='Input Weight']/../../../following-sibling::div//span[text()='" + format + "']")));
	}

	public void uploadTransformationVideo(String transformationVideoType) {
		/* helps to Upload transformaton video */

		String videoPath = System.getProperty("user.dir") + "/src/test/java/resources/testVideo.mp4";
		scrollToElement(tansformationVideosSection);
		try {
			PresenceOfElement(By.xpath("//span//label[text()='" + transformationVideoType + "']/..//i/.."));
			testInfoLog("video already is uploaded in transformation video section: " + transformationVideoType);
		} catch (Exception e) {
			testStepsLog("Scroll to Transformation Videos section : " + transformationVideoType);
			scrollToElement(driver.findElement(By.xpath("//span//label[text()='" + transformationVideoType
					+ "']/..//div[@class='after-video-section']//button")));
			WebElement uploadButton = driver.findElement(By.xpath("//span//label[text()='" + transformationVideoType
					+ "']/..//div[@class='after-video-section']//button"));
			uploadButton.sendKeys(videoPath);
		}
	}

	public void deleteTransformationVideo(String transformationVideoType) {
		/* helps to delete transformaton video */

		testStepsLog("Click on delete icon of transformation video section: " + transformationVideoType);
		clickableElement(
				driver.findElement(By.xpath("//span//label[text()='" + transformationVideoType + "']/..//i/..")));
		clickOn(driver.findElement(By.xpath("//span//label[text()='" + transformationVideoType + "']/..//i/..")));
		testStepsLog("Click on accept button");
		clickOn(confirmationAcceptButton);
	}

	public String currentWeight(int i) {
		/* helps to get user's current weight showing in the dashboard */
		return currentWeightText.getText().split("is ")[i];
	}

	public String getCompletedChallengeVideoCount() {
		/*
		 * returns the total count of completed challenge video that shows in dashboard
		 */
		String totalCount[] = completedChallengeVideoCount.getText().split("/");
		return totalCount[0].replaceAll(" ", "");
	}

	public boolean verifyUserIsInDashboard() {
		/* returns true if user is in dashboard page */
		try {
			visibilityOfElement(helloUserText);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeDislikefoods(String dislikedFood) {
		/* removes disliked food */
		clickOn(driver.findElement(By.xpath("//h4[text()='Disliked Foods']/../../..//h5[text() ='" + dislikedFood
				+ "']/../../..//button[@type='button']")));
		clickOn(removeFromDislikeList);
	}

}
