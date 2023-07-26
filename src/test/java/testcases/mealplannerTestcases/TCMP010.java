package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP010 extends BaseClass {

	@Test
	public void VerifyUserCanSetRecurringMeal() {

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

		testStepsLog("Click on the 3 dot icon of brekfast section and click on set recurring meal");
		mealplannerpage.clickOnMealSectionOption("Breakfast", "Set");

		testStepsLog("Verify the success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Recurring successful", notificationMessage);
		testVerifyLog("Success message showing: "+ notificationMessage);

		testStepsLog("Click on the 3 dot icon of brekfast section and click on stop recurring meal");
		mealplannerpage.clickOnMealSectionOption("Breakfast", "Stop");

		testStepsLog("Verify the success message");
		String stopRecurringNotification = commonpage.getNotificationMessage();
		Assert.assertEquals("Recurring successful", stopRecurringNotification);
		testVerifyLog("Success message showing: "+ stopRecurringNotification);

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}

}
