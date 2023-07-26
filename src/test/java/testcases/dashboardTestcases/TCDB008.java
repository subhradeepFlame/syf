package testcases.dashboardTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import initiate.BaseClass;

public class TCDB008 extends BaseClass{
	@Test
	public void checkMealGenerateFromDashboard() {

		
		testStepsLog("Login user");
		loginpage.Login("User 4");
		
		testStepsLog("Resubmit Questionnaire");
		questionnairepage.reSubmitQuestionnaire();
		
		testStepsLog("Click on meal planner");
		commonpage.ClickOnLeftMenu("Meal Planner");
		
		testStepsLog("Verify meal is not generated");
		visibilityOfElement(mealplannerpage.mealNotGeneratedText);
		visibilityOfElement(mealplannerpage.generateMealButton);
		testVerifyLog("meal is not generated");
		
		testStepsLog("Click on dashboard");
		commonpage.ClickOnLeftMenu("Dashboard");
		
		testStepsLog("Verify Click here to generate meal text is showing in the dashboard");
		clickableElement(dashboardpage.clickHereToGenerateMealLink);
		testVerifyLog("Click here to generate meal text is showing in the dashboard");
		
		testStepsLog("click on here");
		clickOn(dashboardpage.clickHereToGenerateMealLink);
		
		String settingMealMessage = commonpage.getNotificationMessage();
		
		testStepsLog("Verify the setting meal message");
		Assert.assertEquals(settingMealMessage, "We are setting your meal planner. Please be patient.");
		testVerifyLog("the setting meal message");
		
		testStepsLog("Click on meal planner");
		commonpage.ClickOnLeftMenu("Meal Planner");
		
		testStepsLog("Verify meal generated");
		try {
			visibilityOfElement(mealplannerpage.mealNotGeneratedText);
			visibilityOfElement(mealplannerpage.generateMealButton);
			Assert.fail();
		}
		catch(Exception e) {
			testVerifyLog("meal generated");
		}
		
		testStepsLog("Click on dashboard");
		commonpage.ClickOnLeftMenu("Dashboard");
		
		testStepsLog("Verify todays meal section is showing in dashboard");
		visibilityOfElement(dashboardpage.todaysMealSection);
		testVerifyLog("todays meal section is showing in dashboard");
		
		
		
	}

}
