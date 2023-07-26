package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP003 extends BaseClass {

	@Test
	public void VerifyUserCanGenerateMeal() {

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

		testStepsLog(" Verify breakfast meals are showing");
        Assert.assertEquals(mealplannerpage.verifyMealsAreShowingInMealSection("Breakfast"), true);
        testVerifyLog("Breakfast meals are showing");
        
        testStepsLog(" Verify lunch meals are showing");
        Assert.assertEquals(mealplannerpage.verifyMealsAreShowingInMealSection("Lunch"), true);
        testVerifyLog("Lunch meals are showing");
        
        testStepsLog(" Verify dinner meals are showing");
        Assert.assertEquals(mealplannerpage.verifyMealsAreShowingInMealSection("Dinner"), true);
        testVerifyLog("Dinner meals are showing");
        
        testStepsLog(" Verify snack meals are showing");
        Assert.assertEquals(mealplannerpage.verifyMealsAreShowingInMealSection("Snack"), true);
        testVerifyLog("Snack meals are showing");
        
        testVerifyLog("Verify daily option is selected ");
        visibilityOfElement(mealplannerpage.dailyOption);
        testVerifyLog("Daily option is selected");
		
        testStepsLog("Verify currect date is showing");
        Assert.assertEquals(commonpage.getCurrentDateMonthYear(),mealplannerpage.mealPlannerSelectedDate.getText());
        testVerifyLog("Currect date is showing");
        
        testStepsLog("Verify calorie percentage is showing");
        visibilityOfElement(mealplannerpage.calorieDiv);
        testVerifyLog("Calorie percentage is showing");
        
        testStepsLog("Verify protein percentage is showing");
        visibilityOfElement(mealplannerpage.proteinDiv);
        testVerifyLog("Protein percentage is showing");
        
        testStepsLog("Verify carbs percentage is showing");
        visibilityOfElement(mealplannerpage.carbsDiv);
        testVerifyLog("Carbs percentage is showing");
        
        testStepsLog("Verify fat percentage is showing");
        visibilityOfElement(mealplannerpage.fatDiv);
        testVerifyLog("Fat percentage is showing");
        
        testStepsLog("Resubmit the questionnaire");
        questionnairepage.reSubmitQuestionnaire();
        
        
	}

}
