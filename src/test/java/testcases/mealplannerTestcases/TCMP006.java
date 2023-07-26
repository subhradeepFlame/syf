package testcases.mealplannerTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class TCMP006 extends BaseClass{
	
	@Test
	public void VerifyUserCanRegenerateMeal(){
		
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
		testVerifyLog("setting your meal planner message shows :"+setMealMessage );
       
		String beforeSnackFirstItemTitle = mealplannerpage.getMealTitle("Snack",1);
		testStepsLog("Click on the 3 dot icon of a meal from the snack section and click on regenerate this item");
		mealplannerpage.clickOnMealOption("Snack",1,"Regenerate");
		
		testStepsLog("Verify the success message");
		String notificationMessage = commonpage.getNotificationMessage();
		Assert.assertEquals("Item re-generated successfully", notificationMessage);
		testVerifyLog("Success message showing : "+ notificationMessage);
		
		driver.navigate().refresh();
		waitForPageLoaded();
		String afterSnackFirstItemTitle = mealplannerpage.getMealTitle("Snack",1);
		
		testStepsLog(" Verify the meal has changed ");
		Assert.assertNotEquals(beforeSnackFirstItemTitle, afterSnackFirstItemTitle);
		testVerifyLog("Meal has changed");
		
		testStepsLog("Resubmit the questionnaire");
		questionnairepage.reSubmitQuestionnaire();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
