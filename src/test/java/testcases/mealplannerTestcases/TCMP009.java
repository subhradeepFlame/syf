package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP009 extends BaseClass{
	
	@Test
	public void VerifyUserCanCheckMealSectionTotalNutritionInfo() {

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
		testVerifyLog("setting your meal planner message shows : "+ setMealMessage);
        
		testStepsLog("Click on the 3 dot icon of brekfast section and Click on nutrition Info");
        mealplannerpage.clickOnMealSectionOption("Breakfast","Nutrition");
        
        testStepsLog("Verify user redirect to the breakfast nutrition info page where carbs, protien, fat ,calorie information is showing");
	    visibilityOfElement(mealplannerpage.nutritionInfo_calorieInfo);
	    visibilityOfElement(mealplannerpage.nutritionInfo_proteinInfo);
	    visibilityOfElement(mealplannerpage.nutritionInfo_carbsInfo);
	    visibilityOfElement(mealplannerpage.nutritionInfo_fatInfo);
	    testVerifyLog("User redirect to the breakfast nutrition info page where carbs, protien, fat ,calorie information is showing");
	
	    testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}
	
	
	

}