package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeatOnDemandPage extends CommonPage{

	public HeatOnDemandPage(WebDriver dr) {
		super(dr);
	}
	
		@FindBy(xpath = "//input[@type='checkbox']/parent::div")
		public WebElement HODwarningCheckBox;
		@FindBy(xpath = "//button//span[contains(text(),'Accept')]/..")
		public WebElement warningModalAcceptButton;
		@FindBy(xpath = "//button[@type='button']//span[contains(text(),'Videos')]/..")
		public WebElement videosTab;
		@FindBy(xpath = "//span[contains(text(),'Subscribe Now')]")
		public WebElement SubscribeNowButton;	
		@FindBy(xpath = "//button//span[text()='SUBSCRIBE NOW']/../..")
		public WebElement plansSubscribeNowButton;
		@FindBy(xpath = "//input[@name='cardnumber']")
		public WebElement checkout_CardNumberField;
		@FindBy(xpath = "//input[@name='exp-date']")
		public WebElement checkout_ExpDateField;
		@FindBy(xpath = "//input[@name='cvc']")
		public WebElement checkout_cvcfieldField;
		@FindBy(xpath = "//input[@name='postal']")
		public WebElement checkout_zipField;
		@FindBy(xpath = "//button[contains(text(),'Pay')]")
		public WebElement checkout_payButton;
		@FindBy(xpath = "//div[@class='vs-card--media']//div[contains(@class,'lock')]")
		public WebElement Videoslockicon;
		@FindBy(xpath = "//h5[contains(text(),'You have no active subscription!')]")
		public WebElement noSubscriptionText ;
		@FindBy(xpath = "//h2[contains(text(),'Select your plan')]")
		public WebElement selectYourPlanText ;
		@FindBy(xpath = "//div[@class='vx-card__body']")
		public WebElement SubscriptionPlansDiv ;
		@FindBy(xpath = "//div[@aria-label='Next slide']/../../..//h3")
		public WebElement firstHODVideoCategory;
		@FindBy(xpath = "//div[@aria-label='Next slide' and @aria-disabled='false' ]/../../..//h3")
		public WebElement firstVideoCategoryWithActiveSlide;
		@FindBy(xpath = "//div[@aria-label='Next slide']/../../..//h3")
		public WebElement firstVideoCategory;
		@FindBy(xpath = "//p[contains(text(),'Credit Card')]/..//iframe")
		public WebElement creditCardIframe;
		@FindBy(xpath = "//h6[contains(text(),'Program Details')]")
		public WebElement programDetailsText;
		@FindBy(xpath = "//input[@placeholder='Select Level']/../..//span[@role='presentation']")
		public WebElement filterLevelDropDown;
        @FindBy(xpath = "//input[@placeholder='Select Program']/../..//span[@role='presentation']")
		public WebElement filterProgramDropDown;
        @FindBy(xpath = "//input[@placeholder='Select Trainer']/../..//span[@role='presentation']")
      	public WebElement filterTrainerDropdown;
        @FindBy(xpath = "//div[@class='program-play']")
      	public WebElement filteredSubCategoryPlayButton ; // only shows after filter search 
        @FindBy(xpath = "//div[@aria-label='Next slide' and @aria-disabled='false' ]")
    	public WebElement HODvideorightSlideIcon;
        @FindBy(xpath = "//p[@class='no-record-found']")
      	public WebElement filterSearchNoRecordsFoundText ;
        @FindBy(xpath = "//span[text()='Clear All']/..")
      	public WebElement clearFilterButton ;
        @FindBy(xpath = "//span[text()='WORKOUTS']/following-sibling::h5")
      	public WebElement programOverview_Workouts ;
        @FindBy(xpath = "//span[text()='MINS/DAY']/following-sibling::h5")
      	public WebElement programOverview_MinsPerHead;
        @FindBy(xpath = "//span[text()='SKILL LEVEL']/following-sibling::img")
      	public WebElement programOverview_skillLevel;
        @FindBy(xpath = "//span[text()='WEEKS']/following-sibling::h5")
      	public WebElement programOverview_Weeks ;
        @FindBy(xpath = "//span[text()='HOURS']/following-sibling::h5")
      	public WebElement programOverview_Hours ;
        @FindBy(xpath = "//span[text()='TRAINER']/following-sibling::h5")
      	public WebElement programOverview_Trainer;
        @FindBy(xpath = "//h3[contains(text(),'New & Featured')]")
      	public WebElement newAndFeaturedSubCategory;
        
        
        
        public void checkHODvideoSubCategoryIsVisible(String subCategoryNumber) {
    		/* after scroll video sub categories this method checks that given number video sub category is showing on the screen  */
    		visibilityOfElement(driver.findElement(By.xpath("(//div[@class='video_slider']//h3[contains(text(),'"+firstVideoCategoryWithActiveSlide.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span)["+subCategoryNumber+"]")));
    	}
		
		public String getFirstHODvideoSubCategoryName() {
			/* helps to get the first video sub category title  */
			visibilityOfElement(driver.findElement(By.xpath("//div[@class='video_slider']//h3[contains(text(),'"+firstHODVideoCategory.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span")));
			return driver.findElement(By.xpath("//div[@class='video_slider']//h3[contains(text(),'"+firstHODVideoCategory.getText()+"')]/..//div[contains(@class,'swiper-slide')]//span")).getText();
		}
		
		public void clickOnHODvideoSubCategory(String subCategoryTitle) {
			/* helps to click on the given video sub category  */
			scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'"+subCategoryTitle+"')]/../../..//div[@class='play']")));
			clickOn(driver.findElement(By.xpath("//span[contains(text(),'"+subCategoryTitle+"')]/../../..//div[@class='play']")));
		}
		
		public String getFirstHODVideoName() {
			/* helps to get first video title under a subcategory */
			return driver.findElement(By.xpath("//div[@class='vs-card--content']//span")).getText();
		}
		
		public void clickOnHODvideo(String videoTitle) {
			/* helps to click on the given video*/
			scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'"+videoTitle+"')]/../../..//div[@class='play']")));
			clickOn(driver.findElement(By.xpath("//span[contains(text(),'"+videoTitle+"')]/../../..//div[@class='play']")));
		}
		
		public void filterHODvideos(int levelDropdownValueNumber, int programDropdownValueNumber, int trainerDropdownValueNumber) {
			
			testStepsLog("Select level of filter");
			filterLevelDropDown.click();
			clickOn(driver.findElement(By.xpath("(//input[@placeholder='Select Level']/../../..//ul//li)["+levelDropdownValueNumber+"]")));
			waitForPageLoaded();
			
			testStepsLog("Select level of filter");
			filterProgramDropDown.click();
			clickOn(driver.findElement(By.xpath("(//input[@placeholder='Select Program']/../../..//ul//li)["+programDropdownValueNumber+"]")));
			waitForPageLoaded();
			
			testStepsLog("Select level of filter");
			filterTrainerDropdown.click();
			clickOn(driver.findElement(By.xpath("(//input[@placeholder='Select Trainer']/../../..//ul//li)["+trainerDropdownValueNumber+"]")));
			waitForPageLoaded();
		}


		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
