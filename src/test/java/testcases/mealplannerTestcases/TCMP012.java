package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP012 extends BaseClass {

	@Test
	public void VerifyUserCanRegenerateMealSections() {

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
		testVerifyLog("setting your meal planner message shows: " + setMealMessage);

		String beforeBreakfastFirstItemTitle = mealplannerpage.getMealTitle("Breakfast", 1);
		driver.navigate().refresh();
		waitForPageLoaded();

		testStepsLog(" Click on Regenerate icon of breakfast section");
		mealplannerpage.clickOnRegenerateMealButton("Breakfast");

		testStepsLog("Verify success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Meal re-generated successfully", notificationMessage);
		testVerifyLog("success message showing: " + notificationMessage);
		String afterBreakfastFirstItemTitle = mealplannerpage.getMealTitle("Breakfast", 1);

		testStepsLog("Verify that meals under breakfast section are changed");
		Assert.assertNotEquals(beforeBreakfastFirstItemTitle, afterBreakfastFirstItemTitle);
		testVerifyLog("meals under breakfast section are changed");

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}

}
