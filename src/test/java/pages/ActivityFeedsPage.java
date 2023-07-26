package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityFeedsPage extends CommonPage {

	public ActivityFeedsPage(WebDriver dr) {
		super(dr);
	}

	public String PhotoFilePath = System.getProperty("user.dir") + "/src/test/resources/test.jpg";
	@FindBy(xpath = "//h4[text()='Create Post']/..//textarea")
	public WebElement createPostField;
	@FindBy(xpath = "//button//span[text()='Post']/..")
	public WebElement PostButton;
	@FindBy(xpath = "//span[contains(text(),'Photo / Video')]/../../..//input")
	public WebElement UploadPhotoVideoButton;
	@FindBy(xpath = "//h4[contains(text(),'Post upload in progress')]")
	public WebElement PhotoIsUploadingText;
	@FindBy(xpath = "//textarea[@placeholder='Write something about post...']")
	public WebElement updatePostTextArea;
	@FindBy(xpath = "//button//span[text()='Update']/../..")
	public WebElement postUpdateButton;
	@FindBy(xpath = "//button//span[text()='Submit']/..")
	public WebElement ReportPostSubmitButton;
	@FindBy(xpath = "//p[text()='Provide reason for your reporting']/..//textarea")
	public WebElement ReportPostReasonField;

	public void createPost(String PostText, String FilePath) {
		/* helps to create any post with or without photo/video in activity feeds */
		testStepsLog("Write post");
		enterValue(createPostField, PostText);
		if (!FilePath.isEmpty()) {
			uploadPhotoVideo(FilePath);
		}
		testStepsLog("Click on post button");
		clickOn(PostButton);

	}

	public void clickOnPostOption(String postText, String option) {
		/*
		 * String option should be Edit, Delete,Report this Post. helps to click on any
		 * post edit or delete o Report this Post option
		 */
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]")));
		clickOn(driver.findElement(
				By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]/../..//button")));
		clickOn(driver.findElement(By.xpath("//li//span[text()='" + option + "']")));
	}

	public void uploadPhotoVideo(String FilePath) {
		/* helps to upload photo/video in a post */
		testStepsLog("Upload photo/video");
		UploadPhotoVideoButton.sendKeys(FilePath);
	}

	public boolean checkFirstPostIsPinned() {
		/* check first post of activity feeds page is pinned or not */
		try {
			visibilityOfElement(driver.findElement(By.xpath(
					"(//div[@class='vx-card__body']//div[contains(@class,'activity_txt')])[1]/../..//div[contains(@class,'con-vs-tooltip')]")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void likePost(String postText) {
		/* Click on the like icon of a post */
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]")));
		clickOn(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText
				+ "')]/../../..//div[contains(@class,'total_like')]//span[contains(@class,'feather-icon')]")));
	}

	public int getPostTotalLikeCount(String postText) {
		/* helps to get total like count of a post */
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]")));
		String sss[] = driver
				.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText
						+ "')]/../../..//div[contains(@class,'total_like')]//span[contains(text(),'Like')]"))
				.getText().split(" ");
		return Integer.parseInt(sss[0]);
	}

	public void addComment(String postText, String comment) {
		/* helps to comment to a post */
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]")));
		enterValue(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText
				+ "')]/../../..//textarea[@placeholder='Add comment']")), comment);
		clickOn(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText
				+ "')]/../../..//button[@name='button']")));
		
	}

	public boolean VerifyAddedCommentIsShowing(String postText, String comment) {
		/* verify a added comment is showing in the perticlar post */
		scrollToElement(
				driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'" + postText + "')]")));
		try {
			visibilityOfElement(driver.findElement(By.xpath("//div[@class='vx-card__body']//p[contains(text(),'"
					+ postText + "')]/../../..//div[contains(@class,'comment-text')]//p[contains(text(),'" + comment
					+ "')]")));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
