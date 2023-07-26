package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP005 extends BaseClass {

	@Test
	public void verifyUserCanUpdateMeal() {

		int value = randomValue(10, 100);

		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify the setting your meal planner message shows");
		String setMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("Message showing: " + setMealMessage);

		testStepsLog("Click on a meal from breakfast section");
		mealplannerpage.clickOnMeal("Breakfast", 1);

		double beforeCarbsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Carbs");
		double beforeProteinsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Protein");
		double beforeFatValue = mealplannerpage.getMealDetailsNutritionInfoValues("Fat");
		double beforeCaloriesValue = mealplannerpage.getMealDetailsNutritionInfoValues("Calories");

		testStepsLog("Change the quantity of the meal");
		enterValue(mealplannerpage.MealQuantityField, String.valueOf(value));
		pause(5);  // pause added cause after remove the value there is a error message shows

		testStepsLog("Click on update button");
		clickOn(mealplannerpage.mealUpdateButton);
		String mealUpdateSuccessMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify success message");
		Assert.assertEquals(mealUpdateSuccessMessage, "Servings modified successfully");
		testVerifyLog("Success message showing: " + mealUpdateSuccessMessage);
		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog("Verify Carbs value is increased");
		double afterCarbsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Carbs");
		Assert.assertTrue(beforeCarbsValue < afterCarbsValue);
		testVerifyLog("Carbs value is increased");

		testStepsLog("Verify Protein value is increased");
		double afterProteinsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Protein");
		Assert.assertTrue(beforeProteinsValue < afterProteinsValue);
		testVerifyLog("Protein value is increased");

		testStepsLog("Verify Fat value is increased");
		double afterFatValue = mealplannerpage.getMealDetailsNutritionInfoValues("Fat");
		Assert.assertTrue(beforeFatValue < afterFatValue);
		testVerifyLog("Fat value is increased");

		testStepsLog("Verify calorie value is increased");
		double afterCaloriesValue = mealplannerpage.getMealDetailsNutritionInfoValues("Calories");
		Assert.assertTrue(beforeCaloriesValue < afterCaloriesValue);
		testVerifyLog("Calorie value is increased");

		testStepsLog("Click on the back icon");
		mealplannerpage.mealDetailsPageBackIcon.click();

		testStepsLog("Click on the edit icon of the meal");
		mealplannerpage.clickOnEditIconOfMeal("Breakfast", 1);

		testStepsLog("Change the quantity of the meal");
		enterValue(mealplannerpage.MealQuantityField, String.valueOf(value + 5));

		testStepsLog("Click on save canges button");
		clickOn(mealplannerpage.mealDetailsSaveChangesButton);
		String mealValueUpdateSuccessMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify success message");
		Assert.assertEquals(mealValueUpdateSuccessMessage, "Servings modified successfully");
		testVerifyLog("Success message showing: " + mealValueUpdateSuccessMessage);
		
		testStepsLog("Click on a meal from breakfast section");
		mealplannerpage.clickOnMeal("Breakfast", 1);
		
		testStepsLog("Verify Carbs value is increased");
		double currentCarbsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Carbs");
		Assert.assertTrue(afterCarbsValue < currentCarbsValue);
		testVerifyLog("Carbs value is increased");

		testStepsLog("Verify Protein value is increased");
		double currentProteinsValue = mealplannerpage.getMealDetailsNutritionInfoValues("Protein");
		Assert.assertTrue(afterProteinsValue < currentProteinsValue);
		testVerifyLog("Protein value is increased");

		testStepsLog("Verify Fat value is increased");
		double currentFatValue = mealplannerpage.getMealDetailsNutritionInfoValues("Fat");
		Assert.assertTrue(afterFatValue < currentFatValue);
		testVerifyLog("Fat value is increased");

		testStepsLog("Verify calorie value is increased");
		double currentCaloriesValue = mealplannerpage.getMealDetailsNutritionInfoValues("Calories");
		Assert.assertTrue(afterCaloriesValue < currentCaloriesValue);
		testVerifyLog("Calorie value is increased");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}

}
