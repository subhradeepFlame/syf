package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP011 extends BaseClass {

	@Test
	public void VerifyUserCanClearMealSections() {

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

		testStepsLog("Click on the 3 dot icon of brekfast section and click on clear this meal");
		mealplannerpage.clickOnMealSectionOption("Breakfast", "Clear");

		testStepsLog("Verify success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Meal successfully cleared", notificationMessage);
		testVerifyLog("success message showing: "+ notificationMessage);

		testStepsLog("Verify no meals are showing under breakfast section");
		Assert.assertEquals(mealplannerpage.verifyNoMealsAreShowing("Breakfast"),true);
		testVerifyLog("No meals are showing under breakfast section");
		
		testStepsLog("Click on regenerate meal icon");
		mealplannerpage.clickOnRegenerateMealButton("Breakfast");

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}

}
