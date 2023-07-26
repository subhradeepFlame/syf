package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MealPlannerPage extends CommonPage {

	public MealPlannerPage(WebDriver dr) {
		super(dr);
	}

	@FindBy(xpath = "//h3[text()='Your meals has not been generated yet']")
	public WebElement mealNotGeneratedText;
	@FindBy(xpath = "//button//span[text()='Generate Meal']/..")
	public WebElement generateMealButton;
	@FindBy(xpath = " //div[contains(@class,'no-subscription')]")
	public WebElement noSubscriptionText;
	@FindBy(xpath = "//div//a[contains(@onclick,'showcart')]")
	public WebElement challengePurchaseCartIcon;
	@FindBy(xpath = "//div[@class='mealplanner-left-sec daily-view']//span[contains(text(),'daily')]")
	public WebElement dailyOption;
	@FindBy(xpath = "//div[contains(@class,'date-slide')]//h6")
	public WebElement mealPlannerSelectedDate;
	@FindBy(xpath = "//h5[contains(text(),'Calorie Percent')]/..//div[contains(@class,'vx-row goal')]")
	public WebElement calorieDiv;
	@FindBy(xpath = "//h4[contains(text(),'Protein')]/../..")
	public WebElement proteinDiv;
	@FindBy(xpath = "//h4[contains(text(),'Carbs')]/../..")
	public WebElement carbsDiv;
	@FindBy(xpath = "//h4[contains(text(),'Fat')]/../..")
	public WebElement fatDiv;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//span[text()='Consumed']/..//h2")
	public WebElement caloriePercentConsumedUnit;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//span[text()='Total']/..//h3")
	public WebElement caloriePercentPercentage;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//h4[text()='Protein']/../..//h6")
	public WebElement proteinPercentage;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//h4[text()='Carbs']/../..//h6")
	public WebElement carbsPercentage;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//h4[text()='Fat']/../..//h6")
	public WebElement fatPercentage;
	@FindBy(xpath = "//h5[text()='Calorie Percent']/..//span[text()='Remaining']/..//h2")
	public WebElement remainingCalorieUnit;
	@FindBy(xpath = "//button//span[text()='Clear']/..")
	public WebElement RemoveMealClearButton;
	@FindBy(xpath = "//div[@class='vs-con-input']//input")
	public WebElement MealQuantityField;
	@FindBy(xpath = "//button//span[contains(text(),'Update')]/..")
	public WebElement mealUpdateButton;
	@FindBy(xpath = "//span//strong[text()='Back']/..")
	public WebElement mealDetailsPageBackIcon;
	@FindBy(xpath = "//button//span[text()='Save Changes']/..")
	public WebElement mealDetailsSaveChangesButton;
	@FindBy(xpath = "//div[contains(@class,'mealplanner-left-sec daily')]//div[@aria-label='Search for option']//span[@role='presentation']")
	public WebElement dailyDropDown;
	@FindBy(xpath = "//span[text()='Clear']/..")
	public WebElement removeMealClearButton;
	@FindBy(xpath = "//div//strong[text()='Calories']/..")
	public WebElement nutritionInfo_calorieInfo;
	@FindBy(xpath = "//div//strong[text()='Protein']/..")
	public WebElement nutritionInfo_proteinInfo;
	@FindBy(xpath = "//div//strong[text()='Carbs']/..")
	public WebElement nutritionInfo_carbsInfo;
	@FindBy(xpath = "//div//strong[text()='Fat']/..")
	public WebElement nutritionInfo_fatInfo;
	@FindBy(xpath = "//div[contains(@class,'date-sec flex items-center ju')]//*[name()='svg' and contains(@class,'feather-chevron-right')]")
	public WebElement dateRightIcon;
	@FindBy(xpath = "//div[contains(@class,'date-sec flex items-center ju')]//*[name()='svg' and contains(@class,'feather-chevron-left')]")
	public WebElement dateLeftIcon;
	@FindBy(xpath = "//div[@class='flat-pickr-datepicker-div']")
	public WebElement calendarIcon;
	@FindBy(xpath = "//div[contains(@class,'flatpickr-calendar animate open')]//select[@aria-label='Month']")
	public WebElement calendarMonthField;
	@FindBy(xpath = "(//span[@aria-current='date'])[1]/following-sibling::span")
	public WebElement calendarNextDate;
	@FindBy(xpath = "//div[contains(@class,'meal-top mb-3 lg')]//span[contains(@class,'feather-icon select-none relative v')]")
	public WebElement dailyWeeklydropDown;
	@FindBy(xpath = "//div[contains(@class,'vx-col w-full lg:w-5')]//span[text()=' Search Food ']/../input")
	public WebElement searchField;
	@FindBy(xpath = "//button//span[contains(text(),'Add to Meal')]/..")
	public WebElement addToMealButton;
	@FindBy(xpath = "//span[@role='presentation']")
	public WebElement searchedFood_mealSectionSelectDropdown;
	@FindBy(xpath = "//button//span[contains(text(),'Save')]/..")
	public WebElement saveButton;

	public boolean verifyMealsAreShowingInMealSection(String mealSectionName) {
		/* Check meals are showing under specific meal sections */
		try {
			PresenceOfElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[contains(text(),'" + mealSectionName
					+ "')]/../../../..//div[@class='meals flex']"));
			return true;
		}

		catch (Exception e) {
			return false;
		}
	}

	public void ClickOnIateThisCheckbox(String mealSectionName) {
		/* click on the checkbox od I ate this under specific meal sections */
		driver.findElement(By.xpath("//div[contains(@class,'vx-row w-full')]//h6[contains(text(),'" + mealSectionName
				+ "')]/../..//span[text()='I ate this']/..//input")).click();
	}

	public int getCaloriePercentConsumedUnit() {
		/* return the int value of total calorie percent consumed unit */
		String CalorieParcentConsumedUnit[] = caloriePercentConsumedUnit.getText().split(" /");
		return Integer.parseInt(CalorieParcentConsumedUnit[0]);
	}

	public double getSectionPercentageValue(WebElement percentage) {
		/* return meal planner sections parcentag int value */
		String s[] = percentage.getText().split("%");
		return Double.parseDouble(s[0]);
	}

	public void clickOnMealOption(String mealSectionName, int mealNumber, String option) {
		/*
		 * helps to click on meal option of a particular mealsection like
		 * breakfast,dinner,lunch and snack.
		 */
		/*
		 * option should be -Regenerate, Remove and Don for Regenerate this item, Remove
		 * from this meal and Don't want to see this item
		 */

		scrollToElement(driver
				.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName + "']")));
		clickableElement(driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='"
				+ mealSectionName + "']/../../../..//div[@class='con-tab-ejemplo']//div)[" + mealNumber
				+ "]//button[@name='button']")));
		clickOn(driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../../../..//div[@class='con-tab-ejemplo']//div)[" + mealNumber + "]//button[@name='button']")));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")));
		clickOn(driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")));

	}

	public void clickOnMealSectionOption(String mealSectionName, String option) {
		/*
		 * helps to click on meal section option of a particular mealsection like
		 * breakfast,dinner,lunch and snack.
		 */
		/*
		 * option should be -Nutrition,Set,Clear, Stop for Nutrition info, Set recurring
		 * meal, Clear this meal and Stop recurring meal
		 */
		scrollToElement(driver
				.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName + "']")));
		clickableElement(driver.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../..//button[@name='button']")));
		clickOn(driver.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../..//button[@name='button']")));
		clickableElement(driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")));
		clickOn(driver.findElement(By.xpath("//span[contains(text(),'" + option + "')]")));
	}

	public void clickOnMeal(String mealSectionName, int mealNumber) {
		/* helps to click on meal */
		scrollToElement(driver
				.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName + "']")));
		clickableElement(
				driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
						+ "']/../../../..//div[@class='con-tab-ejemplo']//div[contains(@class,'meal_detail')]/h5)["
						+ mealNumber + "]")));
		clickOn(driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../../../..//div[@class='con-tab-ejemplo']//div[contains(@class,'meal_detail')]/h5)[" + mealNumber
				+ "]")));
	}

	public double getMealDetailsNutritionInfoValues(String nutritionType) {
		/*
		 * helps to get the value of selected nutrition info type like
		 * protien,fat,carbs,calories in meal details page
		 */

		String s[] = driver.findElement(By.xpath("//strong[text()='" + nutritionType + "']/following-sibling::Strong"))
				.getText().split(" ");
		return Double.parseDouble(s[0]);
	}

	public void clickOnEditIconOfMeal(String mealSectionName, int mealNumber) {
		/* Click on the edit icon of a meal under a mealsection */
		scrollToElement(driver
				.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName + "']")));
		clickableElement(driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='"
				+ mealSectionName
				+ "']/../../../..//div[@class='con-tab-ejemplo']//div[contains(@class,'meal_detail')]//span[contains(@class,'editIconhover')])["
				+ mealNumber + "]")));
		clickOn(driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../../../..//div[@class='con-tab-ejemplo']//div[contains(@class,'meal_detail')]//span[contains(@class,'editIconhover')])["
				+ mealNumber + "]")));
	}

	public String getMealTitle(String mealSectionName, int mealNumber) {
		/* helps to get the meal title */
		scrollToElement(driver
				.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName + "']")));
		return driver.findElement(By.xpath("(//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../../../..//div[@class='con-tab-ejemplo']//div)[" + mealNumber + "]//h5")).getText();
	}

	public boolean verifyNoMealsAreShowing(String mealSectionName) {
		/* verify no meals are showing under a meal section */
		try {
			visibilityOfElement(driver.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='"
					+ mealSectionName + "']/../../../..//h5[contains(text(),'Click')]")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnRegenerateMealButton(String mealSectionName) {
		/* helps click on regenerate meal button */
		driver.findElement(By.xpath("//div[contains(@class,'vx-row w')]//h6[text()='" + mealSectionName
				+ "']/../..//div[@class='con-vs-tooltip']")).click();
	}

	public void clickOnNextDateCalendar() {
		/* click on the next date of the calendar */

		adminpage.SelectUsingVisibleValue(calendarMonthField, adminpage.getCurrentMonth());
		calendarNextDate.click();
	}

	public void selectMealViewOption(String option) {
		/*
		 * helps select daily or weekly option from the drop down option should be daily
		 * and weekly
		 */

		dailyWeeklydropDown.click();
		driver.findElement(By.xpath("//li[contains(text(),'" + option + "')]")).click();
		waitForPageLoaded();

	}

	public int getWeekDaysCount() {
		/* helps to get the count of total number of days in weekly view */
		List<WebElement> weeklyList = driver.findElements(
				By.xpath("//div[contains(@class,'vx-row mealplanner_tab')]//div[contains(@class,'vx-card dark')]"));
		return weeklyList.size();

	}

	public boolean checkSearchedFoodShowingCorrectly(String searchedText) {
		/*
		 * helps to check the searched food name is matched with the given searched word
		 */
		boolean status = false;
		List<WebElement> searchedFoods = driver.findElements(By.xpath(
				"//div[contains(@class,'mealplanner-left-sec daily-view')]//div[@class='meals flex items-center']//h5"));
		for (int i = 0; i < searchedFoods.size(); i++) {
			String st = searchedFoods.get(i).getText();
			if (st.contains(searchedText)) {
				status = true;
			}
		}
		return status;
	}

	public String clickOnSearchedFood(int searchedFoodNumber) {
		/* helps to click on the searched food */
		String st=driver.findElement(By.xpath(
				"(//div[contains(@class,'mealplanner-left-sec daily-view')]//div[@class='meals flex items-center']//h5)["
						+ searchedFoodNumber + "]"))
				.getText();
		clickOn(driver.findElement(By.xpath(
				"(//div[contains(@class,'mealplanner-left-sec daily-view')]//div[@class='meals flex items-center']//h5)["
						+ searchedFoodNumber + "]")));
		return st;
	}

	public void selectFoodSectionInsearchedFood(String mealSectionName) {
		/* after search a food, it helps to select meal section name to add food */
		searchedFood_mealSectionSelectDropdown.click();
		driver.findElement(By.xpath("//li[contains(text(),'"+mealSectionName+"')]")).click();
	}

}
