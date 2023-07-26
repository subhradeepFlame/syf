package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP014 extends BaseClass{
	
	@Test
	public void VerifyUserCanChangeMealplannerDate(){
		
		testStepsLog("Login user");
		loginpage.Login("autouserqa4@mailinator.com", con.getLoginPassword());

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify the setting your meal planner message shows");
		String setMealMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("Success message: "+ setMealMessage);
		
		testStepsLog("Click on the daily dropdown and select Weekly");
		mealplannerpage.selectMealViewOption("weekly");
		
		testStepsLog("Verify the meal planner is showing as weekly view where all the 7 days are showing");
		Assert.assertEquals(7,mealplannerpage.getWeekDaysCount());
		testVerifyLog("The meal planner is showing as weekly view where all the 7 days are showing");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		
		
	}

}
