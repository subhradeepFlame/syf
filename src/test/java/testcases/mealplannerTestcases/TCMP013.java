
package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP013 extends BaseClass {

	@Test
	public void VerifyUserCanChangeMealPlannerDate() {

		testStepsLog("Login user");
		loginpage.Login("User 4");

		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

		testStepsLog("Click on the Meal Planner");
		commonpage.ClickOnLeftMenu("Meal Planner");

		testStepsLog("Click on Generate Meal button");
		clickOn(mealplannerpage.generateMealButton);

		testStepsLog("Verify the setting your meal planner message shows");
		String setMealMessage = mealplannerpage.getNotificationMessage();
		Assert.assertEquals("We are setting your meal planner. Please be patient.", setMealMessage);
		testVerifyLog("setting your meal planner message shows: " + setMealMessage);

		testStepsLog("Click on the right arrow icon of the date");
		clickOn(mealplannerpage.dateRightIcon);
		String nextDate = mealplannerpage.mealPlannerSelectedDate.getText();

		testStepsLog("Verify date is changed to the next date");
		Assert.assertEquals(nextDate, mealplannerpage.getNextDateMonthYear());
		testVerifyLog("Date is changed to the next date");

		testStepsLog("Click on the left arrow icon of the date");
		clickOn(mealplannerpage.dateLeftIcon);

		testStepsLog("Click on the caleandar icon");
		mealplannerpage.calendarIcon.click();

		testStepsLog("Select next date");
		mealplannerpage.clickOnNextDateCalendar();
		String currentDate = mealplannerpage.mealPlannerSelectedDate.getText();

		testStepsLog("Verify meal planner is showing as next date");
		Assert.assertEquals(currentDate, mealplannerpage.getNextDateMonthYear());
		testVerifyLog("Meal planner is showing as next date");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();

	}

}
