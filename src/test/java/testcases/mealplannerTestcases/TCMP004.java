package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP004 extends BaseClass {

	@Test
	public void VerifyUSerCanMarkMealsAsEaten() {

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

		int beforeCalorieParcentConsumedUnit = mealplannerpage.getCaloriePercentConsumedUnit();
		double beforeCalorieParcentPercentage = mealplannerpage
				.getSectionPercentageValue(mealplannerpage.caloriePercentPercentage);
		double beforeproteinPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.proteinPercentage);
		double beforecarbsPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.carbsPercentage);
		double beforefatPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.fatPercentage);
		int beforeRemainingCalorieUnit = Integer.parseInt(mealplannerpage.remainingCalorieUnit.getText());

		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog("Click on the I ate this chekbox of breakfast section");
		mealplannerpage.ClickOnIateThisCheckbox("Breakfast");
		String iAteThisMarkedMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify success message shows");
		Assert.assertEquals(iAteThisMarkedMessage, "Meal has been marked successfully");
		testVerifyLog("Success message shows :" + iAteThisMarkedMessage);

		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog("Verify Calorie percent section consumed unit increased ");
		int afterCalorieParcentConsumedUnit = mealplannerpage.getCaloriePercentConsumedUnit();
		Assert.assertTrue(beforeCalorieParcentConsumedUnit < afterCalorieParcentConsumedUnit);
		testVerifyLog("Calorie percentage section consumed unit increased");

		testStepsLog("Verify Calorie percent section percentage increased ");
		double afterCalorieParcentPercentage = mealplannerpage
				.getSectionPercentageValue(mealplannerpage.caloriePercentPercentage);
		Assert.assertTrue(beforeCalorieParcentPercentage < afterCalorieParcentPercentage);
		testVerifyLog("Calorie percent section percentage increased");

		testStepsLog("Verify Calorie percent section protein percentage increased ");
		double afterproteinPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.proteinPercentage);
		Assert.assertTrue(beforeproteinPercentage < afterproteinPercentage);
		testVerifyLog("Calorie percent section protein percentage increased");

		testStepsLog("Verify Calorie percent section carbs percentage increased ");
		double aftercarbsPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.carbsPercentage);
		Assert.assertTrue(beforecarbsPercentage < aftercarbsPercentage);
		testVerifyLog("Calorie percent section carbs percentage increased");

		testStepsLog("Verify Calorie percent section fat percentage increased ");
		double afterfatPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.fatPercentage);
		Assert.assertTrue(beforefatPercentage < afterfatPercentage);
		testVerifyLog("Calorie percent section fat percentage increased");

		testStepsLog("Verify remaining calorie decreased ");
		int afterRemainingCalorieUnit = Integer.parseInt(mealplannerpage.remainingCalorieUnit.getText());
		Assert.assertTrue(beforeRemainingCalorieUnit > afterRemainingCalorieUnit);
		testVerifyLog("Remaining calorie decreased");

		testStepsLog("Click on clear this meal of breakfast section");
		mealplannerpage.clickOnMealSectionOption("Breakfast", "Clear");
		String ClearThisMealErrorMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify error message showing");
		Assert.assertEquals(ClearThisMealErrorMessage, "You have already consumed this meal");
		testVerifyLog("Error message showing : "+ ClearThisMealErrorMessage);

		testStepsLog("Click on Remove this meal of any meal under breakfast section");
		mealplannerpage.clickOnMealOption("Breakfast", 1, "Remove");

		testStepsLog("Click on clear button");
		clickOn(mealplannerpage.RemoveMealClearButton);
		String removeFromThisMealErrorMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify error message showing");
		Assert.assertEquals(removeFromThisMealErrorMessage, "You have already consumed this meal");
		testVerifyLog("Error message showing : "+removeFromThisMealErrorMessage);

		testStepsLog("Click on Dont want to see this item of any meal under breakfast section");
		mealplannerpage.clickOnMealOption("Breakfast", 1, "Don");
		String DontWantToSeeThisItemErrorMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify error message showing");
		Assert.assertEquals(DontWantToSeeThisItemErrorMessage, "You have already consumed this meal");
		testVerifyLog("Error message showing : "+DontWantToSeeThisItemErrorMessage );
		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog("Uncheck the the I ate this chekbox of breakfast section");
		mealplannerpage.ClickOnIateThisCheckbox("Breakfast");
		String iAteThisUnmarkedMessage = commonpage.getNotificationMessage();

		testStepsLog("Verify success message shows");
		Assert.assertEquals(iAteThisUnmarkedMessage, "Meal has been unmarked successfully");
		testVerifyLog("Success message shows :" + iAteThisUnmarkedMessage);
		driver.navigate().refresh();
		waitForPageLoaded();
		
		testStepsLog("Verify Calorie percentage section consumed units back to previous value");
		int currentCalorieParcentConsumedUnit = mealplannerpage.getCaloriePercentConsumedUnit();
		Assert.assertEquals(beforeCalorieParcentConsumedUnit, currentCalorieParcentConsumedUnit);
		testVerifyLog("Calorie percentage section consumed units back to previous value");
		
		testStepsLog("Verify Calorie percent section percentage back to previous value ");
		double curentCalorieParcentPercentage = mealplannerpage
				.getSectionPercentageValue(mealplannerpage.caloriePercentPercentage);
		Assert.assertEquals(beforeCalorieParcentPercentage, curentCalorieParcentPercentage);
		testVerifyLog("Calorie percent section percentage back to previous value");

		testStepsLog("Verify Calorie percent section protein percentage back to previous value ");
		double currentproteinPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.proteinPercentage);
		Assert.assertEquals(beforeproteinPercentage, currentproteinPercentage);
		testVerifyLog("Calorie percent section protein percentage back to previous value");

		testStepsLog("Verify Calorie percent section carbs percentage back to previous value ");
		double currentcarbsPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.carbsPercentage);
		Assert.assertEquals(beforecarbsPercentage, currentcarbsPercentage);
		testVerifyLog("Calorie percent section carbs percentage back to previous value");

		testStepsLog("Verify Calorie percent section fat percentage back to previous value ");
		double currentfatPercentage = mealplannerpage.getSectionPercentageValue(mealplannerpage.fatPercentage);
		Assert.assertEquals(beforefatPercentage, currentfatPercentage);
		testVerifyLog("Calorie percent section fat percentage back to previous value");

		testStepsLog("Verify remaining calorie back to previous value ");
		int currentRemainingCalorieUnit = Integer.parseInt(mealplannerpage.remainingCalorieUnit.getText());
		Assert.assertEquals(beforeRemainingCalorieUnit, currentRemainingCalorieUnit);
		testVerifyLog("Remaining calorie back to previous value");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();
	}

}
