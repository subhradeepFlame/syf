package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengeVideosPage extends CommonPage{

	public ChallengeVideosPage(WebDriver dr) {
		super(dr);
	}
	
	@FindBy(xpath = "//button//span[text()='Buy Now']/..")
	public WebElement buyNowButton;
	@FindBy(xpath = "//h4[text()='Challenge starts in']/..//span")
	public WebElement upcomingChallengeCountdownDiv;
	@FindBy(xpath = "//div[@class='video_slider']")
	public WebElement challengeVideosDiv;
	@FindBy(xpath = "//div[@aria-label='Next slide' and @aria-disabled='false' ]")
	public WebElement rightSlideIcon;
	@FindBy(xpath = "//div[@aria-label='Next slide' and @aria-disabled='false' ]/../../..//h3")
	public WebElement firstVideoCategoryWithActiveSlide;
	@FindBy(xpath = "//div[contains(@class,'vs-card--content')]//div[@class='con-vs-tooltip']")
	public WebElement viewDetailsIcon;
	@FindBy(xpath = "//h4[contains(@class,'title')]")
	public WebElement videoDetails;
	@FindBy(xpath = "//span[text()='Mark as - Completed']/..")
	public WebElement markAsCompletedCheckbox;
	@FindBy(xpath = "//h5[text()='Related Videos']/..")
	public WebElement relatedVideos;
	@FindBy(xpath = "//h5[contains(text(),'This category contains only one video')]")
	public WebElement noRelatedVideosAvaialableText;


	


	public void checkVideoSubCategoryIsVisible(String subCategoryNumber) {
		/* after scroll video sub categories this method checks that given number video sub category is showing on the screen  */
		visibilityOfElement(driver.findElement(By.xpath("(//div[@class='video_slider']//h3[contains(text(),'"+firstVideoCategoryWithActiveSlide.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span)["+subCategoryNumber+"]")));
	}
	
	public String getFirstVideoSubCategoryName() {
		/* helps to get the first video sub category title  */
		visibilityOfElement(driver.findElement(By.xpath("//div[@class='video_slider']//h3[contains(text(),'"+firstVideoCategoryWithActiveSlide.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span")));
		return driver.findElement(By.xpath("//div[@class='video_slider']//h3[contains(text(),'"+firstVideoCategoryWithActiveSlide.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span")).getText();
	}
	
	public void clickOnVideoSubCategory(String subCategoryTitle) {
		/* helps to click on the given video sub category  */
		scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'"+subCategoryTitle+"')]/../../..//div[@class='play']")));
		clickOn(driver.findElement(By.xpath("//span[contains(text(),'"+subCategoryTitle+"')]/../../..//div[@class='play']")));
	}
	
	public void clickOnVideo(String videoTitle) {
		/* helps to click on the given video under a sub category  */
		scrollToElement(driver.findElement(By.xpath("//div[contains(text(),'"+videoTitle+"')]/../../../..//div[@class='vs-card--media']//div[contains(@class,'play')]")));
		clickOn(driver.findElement(By.xpath("//div[contains(text(),'"+videoTitle+"')]/../../../..//div[@class='vs-card--media']//div[contains(@class,'play')]")));
		waitForPageLoaded();
	}
	
	public String getFirstVideoName() {
		/* helps to get the first video title under a sub category */
		visibilityOfElement(driver.findElement(By.xpath("(//div[@class='vs-card--content']/div/div/div)[1]")));
		return driver.findElement(By.xpath("(//div[@class='vs-card--content']/div/div/div)[1]")).getText();
	}
	
	public String getMultipleVideoInsideSubCategoryName() {
		/* helps to get a sub category title which have multiple videos inside */
		String subCategory=null;
		List<WebElement> subCategoryNames = driver.findElements(By.xpath("//div[@class='video_slider']//h3/..//div[contains(@class,'swiper-slide')]//span"));
		
		for(int i=0;i<subCategoryNames.size();i++) {
			clickOnVideoSubCategory(subCategoryNames.get(i).getText());
			List<WebElement>videoNames = driver.findElements(By.xpath("//div/../../../..//div[@class='vs-card--media']//div[contains(@class,'play')]"));
			driver.navigate().back();
			System.out.println("asdas"+videoNames.size());
			if(videoNames.size()>1) {
				subCategory=subCategoryNames.get(i).getText();
				break;
			}
		}
		return subCategory;

	}
	
	public String getSingleVideoInsideSubCategoryName() {
		/* helps to get a sub category title which have single videos inside */
		String subCategory=null;
		List<WebElement> subCategoryNames = driver.findElements(By.xpath("//div[@class='video_slider']//h3/..//div[contains(@class,'swiper-slide')]//span"));
		
		for(int i=0;i<subCategoryNames.size();i++) {
			clickOnVideoSubCategory(subCategoryNames.get(i).getText());
			List<WebElement>videoNames = driver.findElements(By.xpath("//div/../../../..//div[@class='vs-card--media']//div[contains(@class,'play')]"));
			driver.navigate().back();
			System.out.println("asdas"+videoNames.size());
			if(videoNames.size() == 1) {
				subCategory=subCategoryNames.get(i).getText();
				break;
			}
		}
		return subCategory;

	}
	

	
}
